package com.huawei.hms.hwid;

import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.account.result.AuthAccount;

/* compiled from: AccountSignInTaskApiCall.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class m extends TaskApiCall<c, AuthAccount> {
    public m(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doExecute(com.huawei.hms.hwid.c r7, com.huawei.hms.common.internal.ResponseErrorCode r8, java.lang.String r9, j.k.b.a.m<com.huawei.hms.support.account.result.AuthAccount> r10) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ResponseErrorCode.status:"
            r0.append(r1)
            int r1 = r8.getErrorCode()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "[AccountSDK]AccountSignInTaskApiCall"
            r2 = 1
            com.huawei.hms.hwid.as.b(r1, r0, r2)
            int r0 = r8.getErrorCode()
            boolean r3 = android.text.TextUtils.isEmpty(r9)
            r4 = 0
            if (r3 != 0) goto Lb5
            java.lang.String r3 = "{}"
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L4d
            java.lang.String r7 = "signIn complete, body is null"
            com.huawei.hms.hwid.as.b(r1, r7, r2)
            com.huawei.hms.common.ApiException r7 = new com.huawei.hms.common.ApiException
            com.huawei.hms.support.api.client.Status r9 = new com.huawei.hms.support.api.client.Status
            int r0 = r8.getErrorCode()
            java.lang.String r8 = r8.getErrorReason()
            r9.<init>(r0, r8)
            r7.<init>(r9)
            r10.c(r7)
            return
        L4d:
            com.huawei.hms.support.account.result.AccountAuthResult r3 = new com.huawei.hms.support.account.result.AccountAuthResult     // Catch: org.json.JSONException -> L96
            r3.<init>()     // Catch: org.json.JSONException -> L96
            com.huawei.hms.support.account.result.AccountAuthResult r9 = r3.fromJson(r9)     // Catch: org.json.JSONException -> L96
            com.huawei.hms.support.api.client.Status r3 = r9.getStatus()     // Catch: org.json.JSONException -> L96
            int r0 = r3.getStatusCode()     // Catch: org.json.JSONException -> L96
            boolean r3 = r9.isSuccess()     // Catch: org.json.JSONException -> L96
            if (r3 == 0) goto L81
            java.lang.String r3 = "signIn success"
            com.huawei.hms.hwid.as.b(r1, r3, r2)     // Catch: org.json.JSONException -> L96
            com.huawei.hms.hwid.e r3 = new com.huawei.hms.hwid.e     // Catch: org.json.JSONException -> L96
            android.content.Context r5 = r7.getContext()     // Catch: org.json.JSONException -> L96
            r3.<init>(r5)     // Catch: org.json.JSONException -> L96
            r3.a()     // Catch: org.json.JSONException -> L96
            com.huawei.hms.support.account.result.AuthAccount r3 = r9.getAccount()     // Catch: org.json.JSONException -> L96
            com.huawei.hms.support.account.result.AuthAccount r9 = r9.getAccount()     // Catch: org.json.JSONException -> L97
            r10.d(r9)     // Catch: org.json.JSONException -> L97
            goto Ld0
        L81:
            java.lang.String r3 = "signIn failed"
            com.huawei.hms.hwid.as.b(r1, r3, r2)     // Catch: org.json.JSONException -> L96
            com.huawei.hms.support.api.client.Status r9 = r9.getStatus()     // Catch: org.json.JSONException -> L96
            com.huawei.hms.hwid.ao.a(r8, r9)     // Catch: org.json.JSONException -> L96
            com.huawei.hms.common.ApiException r3 = new com.huawei.hms.common.ApiException     // Catch: org.json.JSONException -> L96
            r3.<init>(r9)     // Catch: org.json.JSONException -> L96
            r10.c(r3)     // Catch: org.json.JSONException -> L96
            goto Lcf
        L96:
            r3 = r4
        L97:
            java.lang.String r9 = "signIn complete, but parser json exception"
            com.huawei.hms.hwid.as.c(r1, r9, r2)
            com.huawei.hms.support.api.client.Status r9 = new com.huawei.hms.support.api.client.Status
            int r1 = r8.getErrorCode()
            java.lang.String r2 = r8.getErrorReason()
            r9.<init>(r1, r2)
            com.huawei.hms.hwid.ao.a(r8, r9)
            com.huawei.hms.common.ApiException r8 = new com.huawei.hms.common.ApiException
            r8.<init>(r9)
            r10.c(r8)
            goto Ld0
        Lb5:
            java.lang.String r9 = "signIn complete, response is null, failed"
            com.huawei.hms.hwid.as.b(r1, r9, r2)
            com.huawei.hms.common.ApiException r9 = new com.huawei.hms.common.ApiException
            com.huawei.hms.support.api.client.Status r1 = new com.huawei.hms.support.api.client.Status
            int r2 = r8.getErrorCode()
            java.lang.String r8 = r8.getErrorReason()
            r1.<init>(r2, r8)
            r9.<init>(r1)
            r10.c(r9)
        Lcf:
            r3 = r4
        Ld0:
            com.huawei.hms.hwid.g r8 = com.huawei.hms.hwid.g.a()
            r8.a(r3, r4)
            if (r7 == 0) goto Lec
            android.content.Context r7 = r7.getContext()
            java.lang.String r8 = r6.getUri()
            java.lang.String r9 = r6.getTransactionId()
            int r10 = com.huawei.hms.hwid.ar.a(r0)
            com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportExit(r7, r8, r9, r10, r0)
        Lec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hwid.m.doExecute(com.huawei.hms.hwid.c, com.huawei.hms.common.internal.ResponseErrorCode, java.lang.String, j.k.b.a.m):void");
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }
}
