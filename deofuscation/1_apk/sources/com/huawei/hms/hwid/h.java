package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.hwid.RevokeAccessResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* compiled from: AccountCancelAuthorizationTaskApiCall.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class h extends TaskApiCall<c, Void> {
    public h(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a */
    public void doExecute(c cVar, ResponseErrorCode responseErrorCode, String str, j.k.b.a.m<Void> mVar) {
        int i;
        as.b("AccountCancelAuthorizationTaskApiCall", "AccountCancelAuthorizationTaskApiCall doExecute", true);
        f.a();
        if (!TextUtils.isEmpty(str)) {
            if ("{}".equals(str)) {
                as.b("AccountCancelAuthorizationTaskApiCall", "signIn complete, body is null", true);
                mVar.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                return;
            }
            RevokeAccessResult beanFromJsonStr = new RevokeAccessResult().getBeanFromJsonStr(str);
            if (beanFromJsonStr.getErrorCode() != null) {
                i = beanFromJsonStr.getErrorCode().intValue();
                mVar.c(new ApiException(new Status(beanFromJsonStr.getErrorCode().intValue(), beanFromJsonStr.getErrorMsg())));
            } else {
                if (responseErrorCode.getErrorCode() == 1212) {
                    as.b("AccountCancelAuthorizationTaskApiCall", "AccountCancelAuthorizationTaskApiCall 1212", true);
                    Status status = new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason());
                    ao.a(responseErrorCode, status);
                    mVar.c(new ApiException(status));
                } else {
                    mVar.d((Object) null);
                }
                i = 0;
            }
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
        return 1;
    }
}
