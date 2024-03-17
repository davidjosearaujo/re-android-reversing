package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.hwid.SignOutResult;
import org.json.JSONException;

/* compiled from: AccountSignOutTaskApiCall.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class n extends TaskApiCall<c, Void> {
    public n(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a */
    public void doExecute(c cVar, ResponseErrorCode responseErrorCode, String str, j.k.b.a.m<Void> mVar) {
        a(responseErrorCode, str);
        if (!TextUtils.isEmpty(str)) {
            try {
                SignOutResult fromJson = new SignOutResult().fromJson(str);
                if (fromJson.isSuccess()) {
                    mVar.d((Object) null);
                } else {
                    Status status = fromJson.getStatus();
                    ao.a(responseErrorCode, status);
                    mVar.c(new ApiException(status));
                }
                return;
            } catch (JSONException unused) {
                Status status2 = new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason());
                ao.a(responseErrorCode, status2);
                mVar.c(new ApiException(status2));
                return;
            }
        }
        mVar.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    private void a(ResponseErrorCode responseErrorCode, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("headerErrorCode:" + responseErrorCode.getErrorCode());
        as.b("[AccountSDK]AccountSignOutTaskApiCall", sb.toString(), true);
    }
}
