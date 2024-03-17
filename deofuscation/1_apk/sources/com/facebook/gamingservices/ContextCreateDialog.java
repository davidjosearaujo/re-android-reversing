package com.facebook.gamingservices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.facebook.gamingservices.model.ContextCreateContent;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ContextCreateDialog extends FacebookDialogBase<ContextCreateContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GameRequest.toRequestCode();
    @Nullable
    private FacebookCallback mCallback;

    public ContextCreateDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    private void showForCloud(ContextCreateContent contextCreateContent, Object obj) {
        Activity activityContext = getActivityContext();
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken != null && !currentAccessToken.isExpired()) {
            DaemonRequest.Callback callback = new DaemonRequest.Callback() { // from class: com.facebook.gamingservices.ContextCreateDialog.1
                @Override // com.facebook.gamingservices.cloudgaming.DaemonRequest.Callback
                public void onCompleted(GraphResponse graphResponse) {
                    if (ContextCreateDialog.this.mCallback != null) {
                        if (graphResponse.getError() != null) {
                            ContextCreateDialog.this.mCallback.onError(new FacebookException(graphResponse.getError().getErrorMessage()));
                        } else {
                            ContextCreateDialog.this.mCallback.onSuccess(new Result(graphResponse));
                        }
                    }
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                if (contextCreateContent.getSuggestedPlayerIDs() != null) {
                    List asList = Arrays.asList(contextCreateContent.getSuggestedPlayerIDs().split("\\s*,\\s*"));
                    if (!asList.isEmpty()) {
                        if (asList.size() == 1) {
                            jSONObject.put("id", asList.get(0));
                        } else {
                            JSONArray jSONArray = new JSONArray();
                            for (int i = 0; i < asList.size(); i++) {
                                jSONArray.put(asList.get(i));
                            }
                            jSONObject.put("id", jSONArray);
                        }
                    }
                }
                DaemonRequest.executeAsync(activityContext, jSONObject, callback, SDKMessageEnum.CONTEXT_CREATE);
                return;
            } catch (JSONException unused) {
                FacebookCallback facebookCallback = this.mCallback;
                if (facebookCallback != null) {
                    facebookCallback.onError(new FacebookException("Couldn't prepare Context Create Dialog"));
                    return;
                }
                return;
            }
        }
        throw new FacebookException("Attempted to open ContextCreateContent with an invalid access token");
    }

    @Override // com.facebook.internal.FacebookDialogBase, com.facebook.FacebookDialog
    public boolean canShow(ContextCreateContent contextCreateContent) {
        return true;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public AppCall createBaseAppCall() {
        return null;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public List<FacebookDialogBase<ContextCreateContent, Result>.ModeHandler> getOrderedModeHandlers() {
        return null;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, final FacebookCallback<Result> facebookCallback) {
        this.mCallback = facebookCallback;
        final ResultProcessor resultProcessor = facebookCallback == null ? null : new ResultProcessor(facebookCallback) { // from class: com.facebook.gamingservices.ContextCreateDialog.2
            @Override // com.facebook.share.internal.ResultProcessor
            public void onSuccess(AppCall appCall, Bundle bundle) {
                if (bundle != null) {
                    facebookCallback.onSuccess(new Result(bundle));
                } else {
                    onCancel(appCall);
                }
            }
        };
        callbackManagerImpl.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.gamingservices.ContextCreateDialog.3
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public boolean onActivityResult(int i, Intent intent) {
                return ShareInternalUtility.handleActivityResult(ContextCreateDialog.this.getRequestCode(), i, intent, resultProcessor);
            }
        });
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class Result {
        @Nullable
        public String contextID;

        @Nullable
        public String getContextID() {
            return this.contextID;
        }

        private Result(Bundle bundle) {
            this.contextID = bundle.getString("id");
        }

        private Result(GraphResponse graphResponse) {
            try {
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    this.contextID = null;
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                this.contextID = optJSONObject != null ? optJSONObject.getString("id") : null;
            } catch (JSONException unused) {
                this.contextID = null;
            }
        }
    }

    public ContextCreateDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public void showImpl(ContextCreateContent contextCreateContent, Object obj) {
        if (CloudGameLoginHandler.isRunningInCloud()) {
            showForCloud(contextCreateContent, obj);
        }
    }

    public ContextCreateDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    private ContextCreateDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }
}
