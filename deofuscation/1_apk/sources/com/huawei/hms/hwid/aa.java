package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;

/* compiled from: HuaweiIdDeleteAuthInfoTaskApiCall.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class aa extends TaskApiCall<u, Void> {
    public aa(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a */
    public void doExecute(u uVar, ResponseErrorCode responseErrorCode, String str, j.k.b.a.m<Void> mVar) {
        a(responseErrorCode, str);
        if (!TextUtils.isEmpty(str)) {
            if (responseErrorCode.getErrorCode() == 0) {
                mVar.d((Object) null);
                return;
            } else {
                mVar.c(new ApiException(new Status(responseErrorCode.getErrorCode())));
                return;
            }
        }
        mVar.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40000300;
    }

    private void a(ResponseErrorCode responseErrorCode, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("headerErrorCode:" + responseErrorCode.getErrorCode());
        as.b("[HUAWEIIDSDK]HuaweiIdDeleteAuthInfoTaskApiCall", sb.toString(), true);
    }
}
