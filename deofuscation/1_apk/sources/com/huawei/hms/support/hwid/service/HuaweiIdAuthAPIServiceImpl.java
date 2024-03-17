package com.huawei.hms.support.hwid.service;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.common.api.internal.OptionalPendingResultImpl;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.hwid.as;
import com.huawei.hms.hwid.x;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.api.entity.hwid.QueryShippingAddressReq;
import com.huawei.hms.support.api.entity.hwid.QueryShippingAddressResp;
import com.huawei.hms.support.api.entity.hwid.RevokeAccessResp;
import com.huawei.hms.support.api.entity.hwid.ShippingAddressInfo;
import com.huawei.hms.support.api.entity.hwid.ShippingAddressParcelable;
import com.huawei.hms.support.api.entity.hwid.SignInReq;
import com.huawei.hms.support.api.entity.hwid.SignInResp;
import com.huawei.hms.support.api.entity.hwid.SignOutReq;
import com.huawei.hms.support.api.entity.hwid.SignOutResp;
import com.huawei.hms.support.api.hwid.AddressResult;
import com.huawei.hms.support.api.hwid.SignInResult;
import com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.Util;
import j.k.b.a.g;
import j.k.b.a.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class HuaweiIdAuthAPIServiceImpl implements HuaweiIdAuthAPIService {
    private HuaweiApiClient a = null;
    private WeakReference<Activity> b = null;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class SignOutNoConnectPendingResult extends PendingResultImpl<Status, SignOutResp> {
        private ResultCallback a;

        public SignOutNoConnectPendingResult(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        public ResultCallback getCallback() {
            return this.a;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl, com.huawei.hms.support.api.client.PendingResult
        public void setResultCallback(ResultCallback<Status> resultCallback) {
            this.a = resultCallback;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public Status onComplete(SignOutResp signOutResp) {
            Status status = new Status(0);
            as.b("HuaweiIdAuthAPIServiceImpl", "signOut onComplete", true);
            return status;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class SignOutOnCompleteListener implements g<Void> {
        private final SignOutNoConnectPendingResult a;

        public SignOutOnCompleteListener(SignOutNoConnectPendingResult signOutNoConnectPendingResult) {
            this.a = signOutNoConnectPendingResult;
        }

        public void onComplete(l<Void> lVar) {
            as.b("HuaweiIdAuthAPIServiceImpl", "SignOutOnCompleteListener onComplete", true);
            if (this.a == null) {
                as.d("HuaweiIdAuthAPIServiceImpl", "signOutResultPendingResult is null", true);
                return;
            }
            Status status = Status.FAILURE;
            if (lVar.v()) {
                status = Status.SUCCESS;
            } else {
                Exception q = lVar.q();
                if (q != null && (q instanceof ApiException)) {
                    status = new Status(((ApiException) q).getStatusCode());
                } else {
                    as.d("HuaweiIdAuthAPIServiceImpl", "wrong exception while failed", true);
                }
            }
            ResultCallback callback = this.a.getCallback();
            if (callback != null) {
                callback.onResult(status);
            } else {
                as.d("HuaweiIdAuthAPIServiceImpl", "set Result callback after signOut completed", true);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
        private a() {
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a */
        public void onResult(ResolveResult<JosGetNoticeResp> resolveResult) {
            JosGetNoticeResp value;
            Intent noticeIntent;
            if (resolveResult == null || !resolveResult.getStatus().isSuccess() || (noticeIntent = (value = resolveResult.getValue()).getNoticeIntent()) == null || value.getStatusCode() != 0) {
                return;
            }
            as.a("HuaweiIdAuthAPIServiceImpl", "get notice has intent.", true);
            Activity validActivity = Util.getValidActivity((Activity) HuaweiIdAuthAPIServiceImpl.this.b.get(), HuaweiIdAuthAPIServiceImpl.this.a.getTopActivity());
            if (validActivity == null) {
                as.d("HuaweiIdAuthAPIServiceImpl", "showNotice no valid activity!", true);
                return;
            }
            try {
                j.l.c.e0.a.a.a.h(noticeIntent);
                validActivity.startActivity(noticeIntent);
            } catch (Exception e) {
                as.d("HuaweiIdAuthAPIServiceImpl", "startActivity exception" + e.getClass().getSimpleName(), true);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class b extends PendingResultImpl<AddressResult, QueryShippingAddressResp> {
        public b(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a */
        public AddressResult onComplete(QueryShippingAddressResp queryShippingAddressResp) {
            Bundle extras;
            if (queryShippingAddressResp == null) {
                as.d("HuaweiIdAuthAPIServiceImpl", "queryShippingAddressResp is invalid.", true);
                return new AddressResult(new Status(2005));
            }
            as.b("HuaweiIdAuthAPIServiceImpl", "QueryShippingAddress.ResultCode:" + queryShippingAddressResp.getRetCode(), true);
            int retCode = queryShippingAddressResp.getRetCode();
            AddressResult addressResult = new AddressResult();
            addressResult.setStatus(queryShippingAddressResp.getCommonStatus());
            ArrayList<ShippingAddressInfo> arrayList = null;
            if (retCode == 0) {
                Intent data = queryShippingAddressResp.getData();
                if (data != null && (extras = data.getExtras()) != null) {
                    extras.setClassLoader(getClass().getClassLoader());
                    ShippingAddressParcelable shippingAddressParcelable = (ShippingAddressParcelable) extras.getParcelable(CommonConstant.RETKEY.SHIPPING_ADDRESS);
                    if (shippingAddressParcelable != null) {
                        arrayList = shippingAddressParcelable.getShippingAddressInfoList();
                    } else {
                        as.d("HuaweiIdAuthAPIServiceImpl", "shippingAddressParcelable is null", true);
                    }
                } else {
                    as.d("HuaweiIdAuthAPIServiceImpl", "data or bundle is null", true);
                }
            } else {
                as.d("HuaweiIdAuthAPIServiceImpl", "retCode is not ok", true);
            }
            addressResult.setShippingAddressInfoList(arrayList);
            return addressResult;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class c extends PendingResultImpl<Status, RevokeAccessResp> {
        public c(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a */
        public Status onComplete(RevokeAccessResp revokeAccessResp) {
            as.b("HuaweiIdAuthAPIServiceImpl", "RevokeAccessPendingResult onComplete", true);
            return new Status(revokeAccessResp.getRetCode());
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class d extends PendingResultImpl<Status, SignOutResp> {
        public d(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a */
        public Status onComplete(SignOutResp signOutResp) {
            Status status = new Status(0);
            as.b("HuaweiIdAuthAPIServiceImpl", "signOut onComplete", true);
            return status;
        }
    }

    private int c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            as.d("HuaweiIdAuthAPIServiceImpl", "parse homeZone error.", true);
            return 0;
        }
    }

    public static int conversionGender(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "-1";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int conversionHomeZone(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static HashSet<Scope> conversionScopes(String str) {
        HashSet<Scope> hashSet = new HashSet<>();
        if (str != null) {
            for (String str2 : str.split(" ")) {
                hashSet.add(new Scope(str2));
            }
        }
        return hashSet;
    }

    public static int conversionStatus(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private PendingResult<Status> d(HuaweiApiClient huaweiApiClient) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter signOutNoConnected", true);
        l<Void> signOut = HuaweiIdAuthManager.getService(huaweiApiClient.getContext(), getSignInOption(huaweiApiClient)).signOut();
        SignOutNoConnectPendingResult signOutNoConnectPendingResult = new SignOutNoConnectPendingResult(huaweiApiClient, CommonNaming.signout, new SignOutReq());
        signOut.e(new SignOutOnCompleteListener(signOutNoConnectPendingResult));
        return signOutNoConnectPendingResult;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<Status> cancelAuthorization(HuaweiApiClient huaweiApiClient) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter cancelAuthorization", true);
        this.a = huaweiApiClient;
        return new c(huaweiApiClient, CommonNaming.revokeAccess, c(huaweiApiClient));
    }

    public HuaweiIdAuthResult getHuaweiIdSignInResultFromIntent(Intent intent) {
        Status status;
        Bundle extras;
        HuaweiIdAuthResult huaweiIdAuthResult = new HuaweiIdAuthResult();
        if (intent != null && (extras = intent.getExtras()) != null) {
            int i = extras.getInt(CommonConstant.RETKEY.RETCODE, 0);
            status = new Status(i);
            if (i == 0) {
                huaweiIdAuthResult.setAuthHuaweiId(a(extras));
                as.b("HuaweiIdAuthAPIServiceImpl", "getSignInResult success", true);
            } else {
                as.b("HuaweiIdAuthAPIServiceImpl", "getSignInResult fail", true);
            }
        } else {
            status = new Status(CommonConstant.RETCODE.SIGN_IN_PARAMS_ERROR);
            as.d("HuaweiIdAuthAPIServiceImpl", "getSignInResult error", true);
        }
        huaweiIdAuthResult.setStatus(status);
        return huaweiIdAuthResult;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public SignInResult getHwIdSignInResultFromIntent(Intent intent) {
        Bundle extras;
        PendingIntent a2;
        if (intent != null && (extras = intent.getExtras()) != null) {
            int i = extras.getInt(CommonConstant.RETKEY.RETCODE, 0);
            if (i == 0) {
                String string = extras.getString(CommonConstant.RETKEY.GENDER);
                String string2 = extras.getString(CommonConstant.RETKEY.USERID, "");
                String string3 = extras.getString(CommonConstant.RETKEY.STATUS);
                String string4 = extras.getString(CommonConstant.RETKEY.SCOPE);
                String string5 = extras.getString(CommonConstant.RETKEY.ID_TOKEN);
                String string6 = extras.getString(CommonConstant.RETKEY.EMAIL);
                String string7 = extras.getString(CommonConstant.RETKEY.FAMILY_NAME);
                String string8 = extras.getString(CommonConstant.RETKEY.GIVEN_NAME);
                String string9 = extras.getString(CommonConstant.RETKEY.AGE_RANGE);
                String string10 = extras.getString(CommonConstant.RETKEY.HOME_ZONE);
                AuthHuaweiId build = AuthHuaweiId.build(extras.getString(CommonConstant.RETKEY.OPENID, ""), string2, extras.getString(CommonConstant.RETKEY.DISPLAYNAME, ""), extras.getString(CommonConstant.RETKEY.PHOTOURL), extras.getString(CommonConstant.RETKEY.ACCESS_TOKEN, ""), extras.getString(CommonConstant.RETKEY.SERVICECOUNTRYCODE, ""), conversionStatus(string3), conversionGender(string), conversionScopes(string4), extras.getString(CommonConstant.RETKEY.SERVICEAUTHCODE, ""), extras.getString(CommonConstant.RETKEY.UNIONID, ""), extras.getString(CommonConstant.RETKEY.COUNTRYCODE, ""));
                build.setIdToken(string5);
                build.setEmail(string6);
                build.setFamilyName(string7);
                build.setGivenName(string8);
                build.setAgeRange(string9);
                build.setHomeZone(conversionHomeZone(string10));
                Status status = new Status(i);
                SignInResult signInResult = new SignInResult(status);
                signInResult.setStatus(status);
                signInResult.setAuthHuaweiId(build);
                as.b("HuaweiIdAuthAPIServiceImpl", "getSignInResult success", true);
                return signInResult;
            }
            if (i == 2002 || i == 2004) {
                Random random = new Random();
                if (Build.VERSION.SDK_INT >= 23) {
                    as.b("HuaweiIdAuthAPIServiceImpl", "SDK version >= 23", true);
                    a2 = j.l.c.e0.a.a.d.a(this.a.getContext(), random.nextInt(), intent, 67108864);
                } else {
                    as.b("HuaweiIdAuthAPIServiceImpl", "SDK version < 23", true);
                    a2 = j.l.c.e0.a.a.d.a(this.a.getContext(), random.nextInt(), intent, 0);
                }
            } else {
                a2 = null;
            }
            Status status2 = new Status(i, (String) null, a2);
            SignInResult signInResult2 = new SignInResult(status2);
            signInResult2.setStatus(status2);
            signInResult2.setData(intent);
            as.b("HuaweiIdAuthAPIServiceImpl", "getSignInResult fail", true);
            return signInResult2;
        }
        SignInResult signInResult3 = new SignInResult(new Status(CommonConstant.RETCODE.SIGN_IN_PARAMS_ERROR));
        as.d("HuaweiIdAuthAPIServiceImpl", "getSignInResult error", true);
        return signInResult3;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public Intent getSignInIntent(HuaweiApiClient huaweiApiClient) {
        Context context = huaweiApiClient.getContext();
        HuaweiIdAuthParams signInOption = getSignInOption(huaweiApiClient);
        if (signInOption == null) {
            return null;
        }
        return x.a(context, signInOption, huaweiApiClient.getSubAppInfo() != null ? huaweiApiClient.getSubAppInfo().getSubAppID() : null);
    }

    public HuaweiIdAuthParams getSignInOption(HuaweiApiClient huaweiApiClient) {
        Api.ApiOptions apiOptions;
        Map<Api<?>, Api.ApiOptions> apiMap = huaweiApiClient.getApiMap();
        if (apiMap == null || (apiOptions = apiMap.get(HuaweiIdAuthAPIManager.HUAWEI_OAUTH_API)) == null || !(apiOptions instanceof HuaweiIdAuthParams)) {
            return null;
        }
        return (HuaweiIdAuthParams) apiOptions;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public HuaweiIdAuthResult parseHuaweiIdFromIntent(Intent intent) {
        return x.a(intent);
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<AddressResult> queryShippingAddress(HuaweiApiClient huaweiApiClient, AuthHuaweiId authHuaweiId) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter queryShippingAddress", true);
        return new b(huaweiApiClient, CommonNaming.queryShippingAddress, new QueryShippingAddressReq(authHuaweiId));
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<SignInResult> signIn(Activity activity, HuaweiApiClient huaweiApiClient) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter signIn", true);
        Checker.checkNonNull(activity, "Activity must not be null.");
        Checker.checkNonNull(huaweiApiClient, "HuaweiApiClient must not be null.");
        List<Scope> a2 = a(huaweiApiClient);
        List<PermissionInfo> b2 = b(huaweiApiClient);
        HashSet hashSet = new HashSet();
        for (Scope scope : a2) {
            hashSet.add(scope.getScopeUri());
        }
        HashSet hashSet2 = new HashSet();
        for (PermissionInfo permissionInfo : b2) {
            hashSet2.add(permissionInfo.getPermission());
        }
        SignInReq signInReq = new SignInReq(hashSet, hashSet2);
        this.a = huaweiApiClient;
        this.b = new WeakReference<>(activity);
        return new PendingResultImpl<SignInResult, SignInResp>(huaweiApiClient, CommonNaming.signin, signInReq) { // from class: com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl.1
            @Override // com.huawei.hms.support.api.PendingResultImpl
            /* renamed from: a */
            public SignInResult onComplete(SignInResp signInResp) {
                as.b("HuaweiIdAuthAPIServiceImpl", "signIn onComplete:" + signInResp.getRetCode(), true);
                HuaweiIdAuthAPIServiceImpl.this.a(signInResp.getRetCode());
                Intent data = signInResp.getData();
                data.putExtra(CommonConstant.RETKEY.RETCODE, signInResp.getRetCode());
                return HuaweiIdAuthAPIServiceImpl.this.getHwIdSignInResultFromIntent(data);
            }
        };
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<SignInResult> signInBackend(HuaweiApiClient huaweiApiClient) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter signInBackend", true);
        Checker.checkNonNull(huaweiApiClient, "HuaweiApiClient must not be null.");
        this.a = huaweiApiClient;
        List<Scope> a2 = a(huaweiApiClient);
        List<PermissionInfo> b2 = b(huaweiApiClient);
        HashSet hashSet = new HashSet();
        for (Scope scope : a2) {
            hashSet.add(scope.getScopeUri());
        }
        HashSet hashSet2 = new HashSet();
        for (PermissionInfo permissionInfo : b2) {
            hashSet2.add(permissionInfo.getPermission());
        }
        return new PendingResultImpl<SignInResult, SignInResp>(huaweiApiClient, CommonNaming.singinbackend, new SignInReq(hashSet, hashSet2)) { // from class: com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl.2
            @Override // com.huawei.hms.support.api.PendingResultImpl
            /* renamed from: a */
            public SignInResult onComplete(SignInResp signInResp) {
                as.b("HuaweiIdAuthAPIServiceImpl", "signInBackend onComplete:" + signInResp.getRetCode(), true);
                Intent data = signInResp.getData();
                data.putExtra(CommonConstant.RETKEY.RETCODE, signInResp.getRetCode());
                return HuaweiIdAuthAPIServiceImpl.this.getHwIdSignInResultFromIntent(data);
            }
        };
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<Status> signOut(HuaweiApiClient huaweiApiClient) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter signOut", true);
        if (!huaweiApiClient.isConnected()) {
            return d(huaweiApiClient);
        }
        return new d(huaweiApiClient, CommonNaming.signout, new SignOutReq());
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public OptionalPendingResult<HuaweiIdAuthResult> silentSignIn(HuaweiApiClient huaweiApiClient) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter silentSignIn", true);
        Checker.checkNonNull(huaweiApiClient, "HuaweiApiClient must not be null.");
        this.a = huaweiApiClient;
        return new OptionalPendingResultImpl(new PendingResultImpl<HuaweiIdAuthResult, SignInResp>(huaweiApiClient, CommonNaming.singinbackend, c(huaweiApiClient)) { // from class: com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl.3
            @Override // com.huawei.hms.support.api.PendingResultImpl
            /* renamed from: a */
            public HuaweiIdAuthResult onComplete(SignInResp signInResp) {
                as.b("HuaweiIdAuthAPIServiceImpl", "signInBackend onComplete:" + signInResp.getRetCode(), true);
                Intent data = signInResp.getData();
                data.putExtra(CommonConstant.RETKEY.RETCODE, signInResp.getRetCode());
                return HuaweiIdAuthAPIServiceImpl.this.getHuaweiIdSignInResultFromIntent(data);
            }
        });
    }

    public static List<PermissionInfo> b(HuaweiApiClient huaweiApiClient) {
        return ((HuaweiApiClientImpl) huaweiApiClient).getPermissionInfos();
    }

    public static List<Scope> a(HuaweiApiClient huaweiApiClient) {
        return ((HuaweiApiClientImpl) huaweiApiClient).getScopes();
    }

    private int b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private AuthHuaweiId a(Bundle bundle) {
        int i;
        if (bundle == null) {
            as.b("HuaweiIdAuthAPIServiceImpl", "bd is null", true);
            return new AuthHuaweiId();
        }
        String string = bundle.getString(CommonConstant.RETKEY.ACCESS_TOKEN, "");
        String string2 = bundle.getString(CommonConstant.RETKEY.SERVICEAUTHCODE, "");
        String string3 = bundle.getString(CommonConstant.RETKEY.DISPLAYNAME, "");
        String string4 = bundle.getString(CommonConstant.RETKEY.USERID, "");
        String string5 = bundle.getString(CommonConstant.RETKEY.OPENID, "");
        String string6 = bundle.getString(CommonConstant.RETKEY.PHOTOURL);
        String string7 = bundle.getString(CommonConstant.RETKEY.SERVICECOUNTRYCODE, "");
        String string8 = bundle.getString(CommonConstant.RETKEY.COUNTRYCODE, "");
        String string9 = bundle.getString(CommonConstant.RETKEY.UNIONID, "");
        int a2 = a(bundle.getString(CommonConstant.RETKEY.GENDER));
        int b2 = b(bundle.getString(CommonConstant.RETKEY.STATUS));
        int c2 = c(bundle.getString(CommonConstant.RETKEY.HOME_ZONE));
        String string10 = bundle.getString(CommonConstant.RETKEY.SCOPE);
        HashSet hashSet = new HashSet();
        if (string10 != null) {
            String[] split = string10.split(" ");
            int length = split.length;
            i = c2;
            int i2 = 0;
            while (i2 < length) {
                hashSet.add(new Scope(split[i2]));
                i2++;
                length = length;
                split = split;
            }
        } else {
            i = c2;
        }
        AuthHuaweiId build = AuthHuaweiId.build(string5, string4, string3, string6, string, string7, b2, a2, hashSet, string2, string9, string8);
        build.setIdToken(bundle.getString(CommonConstant.RETKEY.ID_TOKEN));
        build.setEmail(bundle.getString(CommonConstant.RETKEY.EMAIL));
        build.setFamilyName(bundle.getString(CommonConstant.RETKEY.FAMILY_NAME));
        build.setGivenName(bundle.getString(CommonConstant.RETKEY.GIVEN_NAME));
        build.setAgeRange(bundle.getString(CommonConstant.RETKEY.AGE_RANGE));
        build.setHomeZone(i);
        return build;
    }

    private SignInReq c(HuaweiApiClient huaweiApiClient) {
        List<Scope> a2 = a(huaweiApiClient);
        List<PermissionInfo> b2 = b(huaweiApiClient);
        HashSet hashSet = new HashSet();
        for (Scope scope : a2) {
            hashSet.add(scope.getScopeUri());
        }
        HashSet hashSet2 = new HashSet();
        for (PermissionInfo permissionInfo : b2) {
            hashSet2.add(permissionInfo.getPermission());
        }
        return new SignInReq(hashSet, hashSet2);
    }

    private int a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "-1";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 0 && HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.a.getContext()) == 0) {
            new Timer().schedule(new TimerTask() { // from class: com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    ConnectService.getNotice(HuaweiIdAuthAPIServiceImpl.this.a, 1, "6.4.0.302").setResultCallback(new a());
                }
            }, 200L);
        }
    }
}
