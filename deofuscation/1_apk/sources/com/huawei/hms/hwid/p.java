package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.account.result.AssistTokenResult;
import com.huawei.hms.support.account.result.GetAssistTokenResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.account.AccountNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;

/* compiled from: GetAssistTokenTaskApiCall.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class p extends TaskApiCall<c, AssistTokenResult> {
    public p(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a */
    public void doExecute(c cVar, ResponseErrorCode responseErrorCode, String str, j.k.b.a.m<AssistTokenResult> mVar) {
        int errorCode = responseErrorCode.getErrorCode();
        if (!TextUtils.isEmpty(str) && !"{}".equals(str)) {
            try {
                AssistTokenResult assistTokenResult = new AssistTokenResult();
                GetAssistTokenResult fromJson = new GetAssistTokenResult().fromJson(str);
                if (fromJson.isSuccess()) {
                    as.b("[AccountSDK]GetAssistTokenTaskApiCall", "getAssistToken success", true);
                    a(cVar, errorCode);
                    assistTokenResult.setAssistToken(fromJson.getAssistToken());
                    mVar.d(assistTokenResult);
                } else {
                    as.b("[AccountSDK]GetAssistTokenTaskApiCall", "getAssistToken failed", true);
                    a(cVar, errorCode);
                    mVar.c(new ApiException(fromJson.getStatus()));
                }
                return;
            } catch (JSONException unused) {
                as.d("[AccountSDK]GetAssistTokenTaskApiCall", "getAssistToken complete, but parser json exception", true);
                a(cVar, errorCode);
                mVar.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                return;
            }
        }
        as.b("[AccountSDK]GetAssistTokenTaskApiCall", "getAssistToken complete, response or body is null, failed", true);
        a(cVar, errorCode);
        mVar.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 14;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 60000000;
    }

    private void a(c cVar, int i) {
        if (cVar != null) {
            HiAnalyticsClient.reportExit(cVar.getContext(), AccountNaming.getAssistToken, getTransactionId(), ar.a(i), i);
        }
    }
}
