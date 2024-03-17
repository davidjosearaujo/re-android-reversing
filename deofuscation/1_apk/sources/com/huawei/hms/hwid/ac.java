package com.huawei.hms.hwid;

import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;

/* compiled from: HuaweiIdSignInTaskApiCall.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ac extends TaskApiCall<u, AuthHuaweiId> {
    public ac(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b7  */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doExecute(com.huawei.hms.hwid.u r17, com.huawei.hms.common.internal.ResponseErrorCode r18, java.lang.String r19, j.k.b.a.m<com.huawei.hms.support.hwid.result.AuthHuaweiId> r20) {
        /*
            r16 = this;
            r0 = r20
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ResponseErrorCode.status:"
            r1.append(r2)
            int r2 = r18.getErrorCode()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "[HUAWEIIDSDK]SignInTaskApiCall"
            r3 = 1
            com.huawei.hms.hwid.as.b(r2, r1, r3)
            int r1 = r18.getErrorCode()
            boolean r4 = android.text.TextUtils.isEmpty(r19)
            r5 = 0
            if (r4 != 0) goto L92
            com.huawei.hms.support.hwid.result.HuaweiIdAuthResult r4 = new com.huawei.hms.support.hwid.result.HuaweiIdAuthResult     // Catch: org.json.JSONException -> L75
            r4.<init>()     // Catch: org.json.JSONException -> L75
            r6 = r19
            com.huawei.hms.support.hwid.result.HuaweiIdAuthResult r4 = r4.fromJson(r6)     // Catch: org.json.JSONException -> L75
            com.huawei.hms.support.api.client.Status r6 = r4.getStatus()     // Catch: org.json.JSONException -> L75
            int r1 = r6.getStatusCode()     // Catch: org.json.JSONException -> L75
            boolean r6 = r4.isSuccess()     // Catch: org.json.JSONException -> L75
            if (r6 == 0) goto L62
            java.lang.String r6 = "signIn success"
            com.huawei.hms.hwid.as.b(r2, r6, r3)     // Catch: org.json.JSONException -> L75
            com.huawei.hms.hwid.w r6 = new com.huawei.hms.hwid.w     // Catch: org.json.JSONException -> L75
            android.content.Context r7 = r17.getContext()     // Catch: org.json.JSONException -> L75
            r6.<init>(r7)     // Catch: org.json.JSONException -> L75
            r6.a()     // Catch: org.json.JSONException -> L75
            com.huawei.hms.support.hwid.result.AuthHuaweiId r6 = r4.getHuaweiId()     // Catch: org.json.JSONException -> L75
            com.huawei.hms.support.hwid.result.AuthHuaweiId r4 = r4.getHuaweiId()     // Catch: org.json.JSONException -> L76
            r0.d(r4)     // Catch: org.json.JSONException -> L76
            goto L90
        L62:
            java.lang.String r6 = "signIn failed"
            com.huawei.hms.hwid.as.b(r2, r6, r3)     // Catch: org.json.JSONException -> L75
            com.huawei.hms.common.ApiException r6 = new com.huawei.hms.common.ApiException     // Catch: org.json.JSONException -> L75
            com.huawei.hms.support.api.client.Status r4 = r4.getStatus()     // Catch: org.json.JSONException -> L75
            r6.<init>(r4)     // Catch: org.json.JSONException -> L75
            r0.c(r6)     // Catch: org.json.JSONException -> L75
            r6 = r5
            goto L90
        L75:
            r6 = r5
        L76:
            java.lang.String r4 = "signIn complete, but parser json exception"
            com.huawei.hms.hwid.as.c(r2, r4, r3)
            com.huawei.hms.common.ApiException r4 = new com.huawei.hms.common.ApiException
            com.huawei.hms.support.api.client.Status r7 = new com.huawei.hms.support.api.client.Status
            int r8 = r18.getErrorCode()
            java.lang.String r9 = r18.getErrorReason()
            r7.<init>(r8, r9)
            r4.<init>(r7)
            r0.c(r4)
        L90:
            r14 = r1
            goto Lae
        L92:
            java.lang.String r4 = "signIn complete, response is null, failed"
            com.huawei.hms.hwid.as.b(r2, r4, r3)
            com.huawei.hms.common.ApiException r4 = new com.huawei.hms.common.ApiException
            com.huawei.hms.support.api.client.Status r6 = new com.huawei.hms.support.api.client.Status
            int r7 = r18.getErrorCode()
            java.lang.String r8 = r18.getErrorReason()
            r6.<init>(r7, r8)
            r4.<init>(r6)
            r0.c(r4)
            r14 = r1
            r6 = r5
        Lae:
            com.huawei.hms.hwid.y r0 = com.huawei.hms.hwid.y.a()
            r0.a(r6, r5)
            if (r17 == 0) goto Ld3
            android.content.Context r9 = r17.getContext()
            java.lang.String r11 = r16.getTransactionId()
            android.content.Context r0 = r17.getContext()
            java.lang.String r12 = com.huawei.hms.utils.Util.getAppId(r0)
            int r13 = com.huawei.hms.hwid.ar.a(r14)
            r15 = 60400302(0x399a2ae, float:9.029881E-37)
            java.lang.String r10 = "hwid.silentSignIn"
            com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportExit(r9, r10, r11, r12, r13, r14, r15)
        Ld3:
            java.lang.String r0 = "report: api=hwid.silentSignInversion=60400302"
            com.huawei.hms.hwid.as.b(r2, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hwid.ac.doExecute(com.huawei.hms.hwid.u, com.huawei.hms.common.internal.ResponseErrorCode, java.lang.String, j.k.b.a.m):void");
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }
}
