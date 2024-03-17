package com.huawei.hms.support.hwid.tools;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.hwid.aa;
import com.huawei.hms.hwid.as;
import com.huawei.hms.hwid.r;
import com.huawei.hms.hwid.t;
import com.huawei.hms.hwid.x;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.common.HuaweiIdAuthException;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthServiceImpl;
import com.huawei.hms.utils.HMSPackageManager;
import j.k.b.a.h;
import j.k.b.a.i;
import j.k.b.a.l;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class HuaweiIdAuthTool {
    public static final String TAG = "[HUAWEIIDSDK]HuaweiIdAuthTool";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        private int a;

        private a() {
        }

        public void a(int i) {
            this.a = i;
        }

        public int a() {
            return this.a;
        }
    }

    private HuaweiIdAuthTool() {
    }

    private static void a(final l<Void> lVar) throws HuaweiIdAuthException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final a aVar = new a();
        lVar.k(new i<Void>() { // from class: com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.2
            /* renamed from: a */
            public void onSuccess(Void r3) {
                as.b(HuaweiIdAuthTool.TAG, "deleteAuthInfo Success.", true);
                countDownLatch.countDown();
                aVar.a(0);
            }
        }).h(new h() { // from class: com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.1
            public void onFailure(Exception exc) {
                int statusCode = ((ApiException) lVar.q()).getStatusCode();
                as.b(HuaweiIdAuthTool.TAG, "deleteAuthInfo fail: " + statusCode, true);
                countDownLatch.countDown();
                aVar.a(statusCode);
            }
        });
        try {
        } catch (InterruptedException unused) {
            aVar.a(8);
        }
        if (!countDownLatch.await(10L, TimeUnit.SECONDS)) {
            throw new HuaweiIdAuthException("connection timeout[907135004 ].");
        }
        if (aVar.a() != 0) {
            if (aVar.a() != 8) {
                if (aVar.a() == 2010) {
                    as.c(TAG, "invalid arguments[907135000].", true);
                }
            } else {
                throw new HuaweiIdAuthException("unknown interruption[8].");
            }
        }
        as.b(TAG, "deleteAuthInfo return[success]", true);
    }

    private static Account b(Context context, String str) throws HuaweiIdAuthException {
        if (context != null) {
            String hMSPackageName = HMSPackageManager.getInstance(context).getHMSPackageName();
            as.b(TAG, "get package name of hms is " + hMSPackageName, true);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new Account(str, hMSPackageName);
        }
        as.b(TAG, "context is null", true);
        throw new HuaweiIdAuthException("context is null");
    }

    public static void deleteAuthInfo(Context context, String str) throws HuaweiIdAuthException {
        a(context, str);
    }

    @Deprecated
    public static String requestAccessToken(Context context, String str, List<Scope> list, Bundle bundle) throws HuaweiIdAuthException {
        return requestAccessToken(context, b(context, str), list, bundle);
    }

    public static String requestUnionId(Context context, String str) throws HuaweiIdAuthException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Scope(CommonConstant.SCOPE.SCOPE_ACCOUNT_OPENID));
        return a(context, b(context, str), arrayList, new Bundle(), "requestUnionId").c();
    }

    public static void deleteAuthInfo(Activity activity, String str) throws HuaweiIdAuthException {
        a(activity, str);
    }

    @Deprecated
    public static String requestAccessToken(Activity activity, String str, List<Scope> list, Bundle bundle) throws HuaweiIdAuthException {
        return requestAccessToken(activity, b(activity, str), list, bundle);
    }

    @Deprecated
    public static String requestAccessToken(Context context, String str, List<Scope> list) throws HuaweiIdAuthException {
        return requestAccessToken(context, b(context, str), list, new Bundle());
    }

    @Deprecated
    public static String requestAccessToken(Activity activity, String str, List<Scope> list) throws HuaweiIdAuthException {
        return requestAccessToken(activity, b(activity, str), list, new Bundle());
    }

    public static String requestAccessToken(Context context, Account account, List<Scope> list) throws HuaweiIdAuthException {
        return requestAccessToken(context, account, list, new Bundle());
    }

    public static String requestUnionId(Activity activity, String str) throws HuaweiIdAuthException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Scope(CommonConstant.SCOPE.SCOPE_ACCOUNT_OPENID));
        return a(activity, b(activity, str), arrayList, new Bundle(), "requestUnionId").c();
    }

    public static String requestAccessToken(Activity activity, Account account, List<Scope> list) throws HuaweiIdAuthException {
        return requestAccessToken(activity, account, list, new Bundle());
    }

    public static String requestAccessToken(Context context, Account account, List<Scope> list, Bundle bundle) throws HuaweiIdAuthException {
        return a(context, account, list, bundle, "requestAccessToken").b();
    }

    public static String requestAccessToken(Activity activity, Account account, List<Scope> list, Bundle bundle) throws HuaweiIdAuthException {
        return a(activity, account, list, bundle, "requestAccessToken").b();
    }

    private static void a(Context context, String str) throws HuaweiIdAuthException {
        boolean z;
        r.a();
        x.a();
        if (context != null) {
            if (context instanceof Activity) {
                z = true;
            } else {
                a(context);
                z = false;
            }
            if (TextUtils.isEmpty(str)) {
                as.b(TAG, "accessToken is null or empty.", true);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("accessToken", str);
                HuaweiIdAuthServiceImpl huaweiIdAuthServiceImpl = new HuaweiIdAuthServiceImpl(context, (HuaweiIdAuthParams) null, 60400300);
                if (z) {
                    huaweiIdAuthServiceImpl = new HuaweiIdAuthServiceImpl((Activity) context, (HuaweiIdAuthParams) null, 60400300);
                }
                a((l<Void>) huaweiIdAuthServiceImpl.doWrite(new aa(CommonNaming.signout, jSONObject.toString(), HiAnalyticsClient.reportEntry(context, CommonNaming.signout, 60400300))));
                return;
            } catch (JSONException unused) {
                throw new HuaweiIdAuthException("json error.");
            }
        }
        throw new HuaweiIdAuthException("Context or Activity is null.");
    }

    private static t a(Context context, Account account, List<Scope> list, Bundle bundle, String str) throws HuaweiIdAuthException {
        boolean z;
        HuaweiIdAuthServiceImpl huaweiIdAuthServiceImpl;
        r.a();
        if (context != null) {
            if (context instanceof Activity) {
                z = true;
            } else {
                a(context);
                z = false;
            }
            a(context, account, list, bundle);
            HuaweiIdAuthParams createParams = new HuaweiIdAuthParamsHelper().setAccessToken().setScopeList(list).createParams();
            String str2 = account == null ? "" : account.name;
            if (z) {
                huaweiIdAuthServiceImpl = new HuaweiIdAuthServiceImpl((Activity) context, createParams, str2, 60400300);
            } else {
                huaweiIdAuthServiceImpl = new HuaweiIdAuthServiceImpl(context, createParams, str2, 60400300);
            }
            return a(huaweiIdAuthServiceImpl, str);
        }
        throw new HuaweiIdAuthException("Context or Activity is null.");
    }

    private static void a(Context context) throws HuaweiIdAuthException {
        int isHuaweiMobileServicesAvailable = new AvailableAdapter(40000300).isHuaweiMobileServicesAvailable(context);
        as.b(TAG, "checkDependentHMSVersion result is: " + isHuaweiMobileServicesAvailable, true);
        if (1 == isHuaweiMobileServicesAvailable) {
            throw new HuaweiIdAuthException("hms apk is not exist[2013]");
        }
        if (2 == isHuaweiMobileServicesAvailable) {
            throw new HuaweiIdAuthException("hms apk version is low[2013]");
        }
    }

    private static void a(Context context, Account account, List<Scope> list, Bundle bundle) throws HuaweiIdAuthException {
        String hMSPackageName = HMSPackageManager.getInstance(context).getHMSPackageName();
        as.b(TAG, "get package name of hms is " + hMSPackageName, true);
        String str = (account == null || hMSPackageName.equals(account.type)) ? null : "Account type is not supported.";
        if (!TextUtils.isEmpty(str)) {
            throw new HuaweiIdAuthException(str);
        }
    }

    private static t a(HuaweiIdAuthService huaweiIdAuthService, String str) throws HuaweiIdAuthException {
        as.b(TAG, "start countDownLatch innerSignIn:" + str, true);
        final t tVar = new t();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        l<AuthHuaweiId> silentSignIn = huaweiIdAuthService.silentSignIn();
        silentSignIn.k(new i<AuthHuaweiId>() { // from class: com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.3
            /* renamed from: a */
            public void onSuccess(AuthHuaweiId authHuaweiId) {
                as.b(HuaweiIdAuthTool.TAG, "silentSignIn success", true);
                t.this.a(0);
                t.this.a(authHuaweiId.getAccessToken());
                t.this.b(authHuaweiId.getUnionId());
                countDownLatch.countDown();
            }
        });
        silentSignIn.h(new h() { // from class: com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.4
            public void onFailure(Exception exc) {
                as.b(HuaweiIdAuthTool.TAG, "silentSignIn fail", true);
                if (exc instanceof ApiException) {
                    t.this.a(((ApiException) exc).getStatusCode());
                }
                countDownLatch.countDown();
            }
        });
        boolean z = false;
        try {
            z = countDownLatch.await(10L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            as.d(TAG, "innerSignIn InterruptedException.", true);
            tVar.a(8);
        }
        if (!z) {
            throw new HuaweiIdAuthException("connection timeout[907135004 ].");
        }
        as.b(TAG, str + " end countDownLatch awaitValue:" + z, true);
        int a2 = tVar.a();
        if (a2 == 0) {
            return tVar;
        }
        as.d(TAG, str + " fail, error code is:" + a2, true);
        throw new HuaweiIdAuthException(str + " error[" + a2 + "]");
    }
}
