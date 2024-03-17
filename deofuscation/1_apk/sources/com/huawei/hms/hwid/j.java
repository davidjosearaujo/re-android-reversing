package com.huawei.hms.hwid;

import android.app.PendingIntent;
import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.account.AccountNaming;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* compiled from: AccountLogoutTaskApiCall.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class j extends TaskApiCall<c, Void> {
    public j(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a */
    public void doExecute(c cVar, ResponseErrorCode responseErrorCode, String str, j.k.b.a.m<Void> mVar) {
        as.b("AccountLogoutTaskApiCall", "AccountLogoutTaskApiCall doExecute", true);
        a(responseErrorCode);
        if (responseErrorCode.getErrorCode() != 0) {
            if (CommonCode.Resolution.HAS_RESOLUTION.equals(responseErrorCode.getResolution())) {
                as.b("AccountLogoutTaskApiCall", "hms apk version is low or is not exist.", true);
                mVar.c(new ResolvableApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), (PendingIntent) responseErrorCode.getParcelable())));
            } else {
                as.b("AccountLogoutTaskApiCall", "AccountLogoutTaskApiCall callback.", true);
                if (responseErrorCode.getErrorCode() != 2031) {
                    mVar.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                }
            }
            mVar.d((Object) null);
            a(cVar, responseErrorCode);
        } else if (TextUtils.isEmpty(str)) {
            mVar.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            a(cVar, responseErrorCode);
        } else {
            mVar.d((Object) null);
            a(cVar, responseErrorCode);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 16;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 60000000;
    }

    private void a(c cVar, ResponseErrorCode responseErrorCode) {
        if (cVar == null || responseErrorCode == null) {
            return;
        }
        HiAnalyticsClient.reportExit(cVar.getContext(), AccountNaming.logout, getTransactionId(), ar.a(responseErrorCode.getErrorCode()), responseErrorCode.getErrorCode());
    }

    private void a(ResponseErrorCode responseErrorCode) {
        StringBuilder sb = new StringBuilder();
        sb.append("headerErrorCode:" + responseErrorCode.getErrorCode());
        as.b("AccountLogoutTaskApiCall", sb.toString(), true);
    }
}
