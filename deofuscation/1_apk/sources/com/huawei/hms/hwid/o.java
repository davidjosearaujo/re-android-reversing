package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.hwid.StartAssistLoginResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;

/* compiled from: AccountStartAssistLoginTaskApiCall.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class o extends TaskApiCall<c, Void> {
    public o(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a */
    public void doExecute(c cVar, ResponseErrorCode responseErrorCode, String str, j.k.b.a.m<Void> mVar) {
        int i;
        as.b("AccountCancelAuthorizationTaskApiCall", "AccountStartAssistLoginTaskApiCall doExecute", true);
        if (!TextUtils.isEmpty(str)) {
            if ("{}".equals(str)) {
                as.b("AccountCancelAuthorizationTaskApiCall", "signIn complete, body is null", true);
                mVar.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                return;
            }
            try {
                StartAssistLoginResult fromJson = new StartAssistLoginResult().fromJson(str);
                if (fromJson.isSuccess()) {
                    mVar.d((Object) null);
                } else {
                    mVar.c(new ApiException(fromJson.getStatus()));
                }
            } catch (JSONException unused) {
                as.c("AccountCancelAuthorizationTaskApiCall", "tartAssistLogin complete, but parser json exception", true);
                mVar.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
            i = 0;
        } else {
            int errorCode = responseErrorCode.getErrorCode();
            mVar.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            i = errorCode;
        }
        if (cVar != null) {
            HiAnalyticsClient.reportExit(cVar.getContext(), getUri(), getTransactionId(), ar.a(i), i);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 14;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 60000000;
    }
}
