package com.huawei.hms.account.internal.ui.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.hwid.a;
import com.huawei.hms.hwid.ao;
import com.huawei.hms.hwid.ap;
import com.huawei.hms.hwid.ar;
import com.huawei.hms.hwid.as;
import com.huawei.hms.hwid.b;
import com.huawei.hms.hwid.f;
import com.huawei.hms.hwid.g;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.result.AccountAuthResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.account.AccountSignInRequest;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService;
import com.huawei.hms.ui.SafeIntent;
import com.huawei.hms.utils.HMSPackageManager;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AccountSignInHubActivity extends Activity {
    private b e;
    private int f;
    private String a = null;
    private boolean b = false;
    private AccountSignInRequest c = null;
    private AccountAuthResult d = null;
    private String g = CommonNaming.signinIntent;

    private void b() {
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "checkMinVersion start.", true);
        a.a(this, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.account.internal.ui.activity.AccountSignInHubActivity.1
            @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
            public void onComplete(int i) {
                if (i == 0) {
                    as.b("[ACCOUNTSDK]AccountSignInHubActivity", "version check ok", true);
                    AccountSignInHubActivity.this.c();
                    return;
                }
                as.b("[ACCOUNTSDK]AccountSignInHubActivity", "version check failed", true);
                AccountSignInHubActivity.this.a(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "startSignInActivity", true);
        try {
            startActivityForResult(d(), this.f == 1 ? 16588 : 16587);
        } catch (ActivityNotFoundException e) {
            this.b = true;
            as.d("[ACCOUNTSDK]AccountSignInHubActivity", "Launch sign in Intent failed. hms is probably being updated：" + e.getClass().getSimpleName(), true);
            a(17);
        }
    }

    private Intent d() {
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "getJosSignInIntent", true);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("HUAWEIID_CP_CLIENTINFO");
        String stringExtra2 = intent.getStringExtra("HUAWEIID_SIGNIN_REQUEST");
        String action = intent.getAction();
        try {
            b a = b.a(stringExtra);
            ForegroundIntentBuilder kitSdkVersion = new ForegroundIntentBuilder(this).setAction(action).setRequestBody(stringExtra2).setKitSdkVersion(60400300);
            if (a.c() != null) {
                kitSdkVersion.setSubAppId(a.c());
            }
            if (this.f == 1) {
                as.b("[ACCOUNTSDK]AccountSignInHubActivity", "setApiLevel is 11", true);
                kitSdkVersion.setApiLevel(11);
            }
            if (e().booleanValue()) {
                as.b("[ACCOUNTSDK]AccountSignInHubActivity", "setApiLevel is 13", true);
                kitSdkVersion.setApiLevel(13);
            }
            Intent build = kitSdkVersion.build();
            as.b("[ACCOUNTSDK]AccountSignInHubActivity", "get package name of hms is " + HMSPackageManager.getInstance(this).getHMSPackageName(), true);
            as.b("[ACCOUNTSDK]AccountSignInHubActivity", "current package name is " + getPackageName(), true);
            build.setPackage(getPackageName());
            return build;
        } catch (Exception e) {
            as.d("[ACCOUNTSDK]AccountSignInHubActivity", "getSignInIntent failed because:" + e.getClass().getSimpleName(), true);
            return new Intent();
        }
    }

    private Boolean e() {
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "checkCarrierIdPermission begin", true);
        AccountAuthParams accountAuthParams = this.c.getAccountAuthParams();
        if (accountAuthParams == null) {
            return Boolean.FALSE;
        }
        List<PermissionInfo> permissionInfos = accountAuthParams.getPermissionInfos();
        if (ap.b(permissionInfos).booleanValue()) {
            for (PermissionInfo permissionInfo : permissionInfos) {
                String permission = permissionInfo.getPermission();
                if (permission != null && permission.equals(CommonConstant.LocalPermission.CARRIER_ID)) {
                    as.b("[ACCOUNTSDK]AccountSignInHubActivity", "permissioninfos contain carrierId", true);
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        int i3;
        b bVar;
        super.onActivityResult(i, i2, intent);
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "onActivityResult: requestCode：" + i + " , resultCode：" + i2, true);
        SafeIntent safeIntent = intent != null ? new SafeIntent(intent) : null;
        if (this.b) {
            return;
        }
        if (i == 16587 || i == 16588) {
            if (safeIntent != null && (stringExtra = intent.getStringExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID)) != null) {
                try {
                    this.d = new AccountAuthResult().fromJson(stringExtra);
                    if (i == 16587) {
                        g.a().a(this.d.getAccount(), this.c.getAccountAuthParams());
                    }
                    i3 = this.d.getStatus().getStatusCode();
                } catch (JSONException unused) {
                    this.d = null;
                    as.d("[ACCOUNTSDK]AccountSignInHubActivity", "onActivityResult: JsonException", true);
                    i3 = 8;
                }
                String str = this.a;
                if (str != null && (bVar = this.e) != null) {
                    HiAnalyticsClient.reportExit(this, this.g, str, bVar.a(), ar.a(i3), i3, (int) this.e.b());
                }
                setResult(i2, safeIntent);
                finish();
                return;
            }
            a(i2 > 0 ? i2 : 8);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "onCreate", true);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (a(intent)) {
            a(0, "invalid intent");
        }
        a(intent.getBooleanExtra("intent.extra.isfullscreen", false));
        String action = intent.getAction();
        if (!TextUtils.equals("com.huawei.hms.jos.signIn", action) && !TextUtils.equals("com.huawei.hms.account.signIn", action) && !TextUtils.equals("com.huawei.hms.account.picker.signIn", action)) {
            String str = "unknow Action:";
            if (action != null) {
                str = "unknow Action:" + action;
            }
            a(0, str);
        }
        String stringExtra = intent.getStringExtra("HUAWEIID_CP_CLIENTINFO");
        try {
            this.c = AccountSignInRequest.fromJson(intent.getStringExtra("HUAWEIID_SIGNIN_REQUEST"));
        } catch (JSONException unused) {
            this.c = null;
            as.d("[ACCOUNTSDK]AccountSignInHubActivity", "onCreate: JsonException", true);
        }
        if (TextUtils.isEmpty(stringExtra)) {
            a(0, "Activity started with invalid cp client info");
            return;
        }
        try {
            this.e = b.a(stringExtra);
        } catch (JSONException unused2) {
            this.e = null;
            as.d("[ACCOUNTSDK]AccountSignInHubActivity", "onCreate: JsonException", true);
        }
        if (this.c != null && this.e != null) {
            if (!a()) {
                a(CommonConstant.RETCODE.SIGN_IN_PARAMS_ERROR);
                return;
            }
            int intExtra = intent.getIntExtra("INDEPENDENT_SIGN_IN_FLAG", 0);
            this.f = intExtra;
            if (intExtra != 1 || b(intent).booleanValue()) {
                ao.a(this);
                if (bundle != null) {
                    restoreInstanceState(bundle);
                    return;
                }
                this.a = HiAnalyticsClient.reportEntry(this, this.g, 60400300);
                b();
                return;
            }
            return;
        }
        a(0, "Activity started with invalid sign in request info");
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "onSaveInstanceState start", true);
        String str = this.a;
        if (str == null || bundle == null) {
            return;
        }
        bundle.putString("HiAnalyticsTransId", str);
    }

    public void restoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.a = bundle.getString("HiAnalyticsTransId");
        }
    }

    private boolean a() {
        AccountAuthParams accountAuthParams = this.c.getAccountAuthParams();
        if (accountAuthParams == null) {
            return false;
        }
        try {
            int optInt = new JSONObject(accountAuthParams.getSignInParams()).optInt(CommonConstant.RequestParams.KEY_ID_TOKEN_SIGN_ALG, 2);
            return optInt == 1 || optInt == 2;
        } catch (JSONException e) {
            as.d("[ACCOUNTSDK]AccountSignInHubActivity", "JSONException:" + e.getClass().getSimpleName(), true);
            return false;
        }
    }

    private Boolean b(Intent intent) {
        String stringExtra = intent.getStringExtra("ACCESS_TOKEN");
        AccountAuthParams accountAuthParams = this.c.getAccountAuthParams();
        if (accountAuthParams == null) {
            a("accountAuthParams is null");
            return Boolean.FALSE;
        }
        List<Scope> requestScopeList = accountAuthParams.getRequestScopeList();
        if (!TextUtils.isEmpty(stringExtra) && !ap.a(requestScopeList).booleanValue() && requestScopeList.size() == 1) {
            this.g = CommonNaming.independentsigninIntent;
            return Boolean.TRUE;
        }
        a("independent sign in params error");
        return Boolean.FALSE;
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:732)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:811)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    private boolean a(android.content.Intent r3) {
        /*
            r2 = this;
            r0 = 1
            if (r3 != 0) goto L4
            goto La
        L4:
            java.lang.String r1 = "ANYTHING"
            r3.getStringExtra(r1)     // Catch: java.lang.Exception -> La
            r0 = 0
        La:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.account.internal.ui.activity.AccountSignInHubActivity.a(android.content.Intent):boolean");
    }

    private void a(int i, String str) {
        as.d("[ACCOUNTSDK]AccountSignInHubActivity", "errMessage is: " + str, true);
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        b bVar;
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "onSignInAccountFailed: retCode：" + i, true);
        String str = this.a;
        if (str != null && (bVar = this.e) != null) {
            HiAnalyticsClient.reportExit(this, this.g, str, bVar.a(), ar.a(i), i, (int) this.e.b());
        }
        Status status = new Status(i);
        AccountAuthResult accountAuthResult = new AccountAuthResult();
        accountAuthResult.setStatus(status);
        Intent intent = new Intent();
        try {
            intent.putExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID, accountAuthResult.toJson());
        } catch (JSONException unused) {
            as.d("[ACCOUNTSDK]AccountSignInHubActivity", "convert result to json failed", true);
        }
        setResult(0, intent);
        finish();
    }

    private void a(String str) {
        as.d("[ACCOUNTSDK]AccountSignInHubActivity", "onIndependentSignInFailed errMessage:" + str, true);
        Status status = new Status(CommonConstant.RETCODE.SIGN_IN_PARAMS_ERROR, str);
        AccountAuthResult accountAuthResult = new AccountAuthResult();
        accountAuthResult.setStatus(status);
        Intent intent = new Intent();
        try {
            intent.putExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID, accountAuthResult.toJson());
        } catch (JSONException unused) {
            as.d("[ACCOUNTSDK]AccountSignInHubActivity", "convert result to json failed", true);
        }
        setResult(0, intent);
        finish();
    }

    private void a(boolean z) {
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "isActivityFullScreen is :" + z, true);
        if (z) {
            f.a(getWindow());
            getWindow().setFlags(1024, 1024);
            return;
        }
        f.a(this);
    }
}
