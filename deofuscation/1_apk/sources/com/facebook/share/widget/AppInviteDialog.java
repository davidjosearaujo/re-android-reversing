package com.facebook.share.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.internal.AppInviteDialogFeature;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.AppInviteContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AppInviteDialog extends FacebookDialogBase<AppInviteContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.AppInvite.toRequestCode();
    private static final String TAG = "AppInviteDialog";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class NativeHandler extends FacebookDialogBase<AppInviteContent, Result>.ModeHandler {
        private NativeHandler() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(AppInviteContent appInviteContent, boolean z) {
            return false;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(final AppInviteContent appInviteContent) {
            AppCall createBaseAppCall = AppInviteDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new DialogPresenter.ParameterProvider() { // from class: com.facebook.share.widget.AppInviteDialog.NativeHandler.1
                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getLegacyParameters() {
                    Log.e(AppInviteDialog.TAG, "Attempting to present the AppInviteDialog with an outdated Facebook app on the device");
                    return new Bundle();
                }

                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                public Bundle getParameters() {
                    return AppInviteDialog.createParameters(appInviteContent);
                }
            }, AppInviteDialog.access$300());
            return createBaseAppCall;
        }
    }

    @Deprecated
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class Result {
        private final Bundle bundle;

        public Result(Bundle bundle) {
            this.bundle = bundle;
        }

        public Bundle getData() {
            return this.bundle;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class WebFallbackHandler extends FacebookDialogBase<AppInviteContent, Result>.ModeHandler {
        private WebFallbackHandler() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(AppInviteContent appInviteContent, boolean z) {
            return false;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(AppInviteContent appInviteContent) {
            AppCall createBaseAppCall = AppInviteDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebFallbackDialog(createBaseAppCall, AppInviteDialog.createParameters(appInviteContent), AppInviteDialog.access$300());
            return createBaseAppCall;
        }
    }

    @Deprecated
    public AppInviteDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public static /* synthetic */ DialogFeature access$300() {
        return getFeature();
    }

    @Deprecated
    public static boolean canShow() {
        return false;
    }

    private static boolean canShowNativeDialog() {
        return false;
    }

    private static boolean canShowWebFallback() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle createParameters(AppInviteContent appInviteContent) {
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.APPLINK_URL, appInviteContent.getApplinkUrl());
        bundle.putString(ShareConstants.PREVIEW_IMAGE_URL, appInviteContent.getPreviewImageUrl());
        bundle.putString(ShareConstants.DESTINATION, appInviteContent.getDestination().toString());
        String promotionCode = appInviteContent.getPromotionCode();
        if (promotionCode == null) {
            promotionCode = "";
        }
        String promotionText = appInviteContent.getPromotionText();
        if (!TextUtils.isEmpty(promotionText)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ShareConstants.PROMO_CODE, promotionCode);
                jSONObject.put(ShareConstants.PROMO_TEXT, promotionText);
                bundle.putString(ShareConstants.DEEPLINK_CONTEXT, jSONObject.toString());
                bundle.putString(ShareConstants.PROMO_CODE, promotionCode);
                bundle.putString(ShareConstants.PROMO_TEXT, promotionText);
            } catch (JSONException unused) {
                Log.e(TAG, "Json Exception in creating deeplink context");
            }
        }
        return bundle;
    }

    private static DialogFeature getFeature() {
        return AppInviteDialogFeature.APP_INVITES_DIALOG;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public List<FacebookDialogBase<AppInviteContent, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NativeHandler());
        arrayList.add(new WebFallbackHandler());
        return arrayList;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, final FacebookCallback<Result> facebookCallback) {
        final ResultProcessor resultProcessor = facebookCallback == null ? null : new ResultProcessor(facebookCallback) { // from class: com.facebook.share.widget.AppInviteDialog.1
            @Override // com.facebook.share.internal.ResultProcessor
            public void onSuccess(AppCall appCall, Bundle bundle) {
                if ("cancel".equalsIgnoreCase(ShareInternalUtility.getNativeDialogCompletionGesture(bundle))) {
                    facebookCallback.onCancel();
                } else {
                    facebookCallback.onSuccess(new Result(bundle));
                }
            }
        };
        callbackManagerImpl.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.share.widget.AppInviteDialog.2
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public boolean onActivityResult(int i, Intent intent) {
                return ShareInternalUtility.handleActivityResult(AppInviteDialog.this.getRequestCode(), i, intent, resultProcessor);
            }
        });
    }

    @Override // com.facebook.internal.FacebookDialogBase, com.facebook.FacebookDialog
    @Deprecated
    public void show(AppInviteContent appInviteContent) {
    }

    @Deprecated
    public AppInviteDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    @Deprecated
    public static void show(Activity activity, AppInviteContent appInviteContent) {
        new AppInviteDialog(activity).show(appInviteContent);
    }

    @Deprecated
    public AppInviteDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    @Deprecated
    public static void show(Fragment fragment, AppInviteContent appInviteContent) {
        show(new FragmentWrapper(fragment), appInviteContent);
    }

    private AppInviteDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }

    @Deprecated
    public static void show(android.app.Fragment fragment, AppInviteContent appInviteContent) {
        show(new FragmentWrapper(fragment), appInviteContent);
    }

    private static void show(FragmentWrapper fragmentWrapper, AppInviteContent appInviteContent) {
        new AppInviteDialog(fragmentWrapper).show(appInviteContent);
    }
}