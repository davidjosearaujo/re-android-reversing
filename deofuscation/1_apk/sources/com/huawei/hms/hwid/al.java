package com.huawei.hms.hwid;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* compiled from: StartConsentTaskApiCall.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class al extends TaskApiCall<ai, Void> {
    public al(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a */
    public void doExecute(ai aiVar, ResponseErrorCode responseErrorCode, String str, j.k.b.a.m<Void> mVar) {
        ag b = ag.b(str);
        Integer a = b.a();
        String b2 = b.b();
        if (a == null) {
            a = Integer.valueOf(responseErrorCode.getErrorCode());
            b2 = responseErrorCode.getErrorReason();
        }
        if (a(responseErrorCode, b.a())) {
            mVar.d((Object) null);
        } else {
            mVar.c(new ApiException(new Status(a.intValue(), b2)));
        }
        if (aiVar != null) {
            HiAnalyticsClient.reportExit(aiVar.getContext(), getUri(), getTransactionId(), ar.a(a.intValue()), a.intValue());
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        as.b("StartConsentTaskApiCall", "startConsent getApiLevel8", true);
        return 8;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 50005300;
    }

    private boolean a(ResponseErrorCode responseErrorCode, Integer num) {
        return num == null ? responseErrorCode.getStatusCode() == 0 : num.intValue() == 0;
    }
}
