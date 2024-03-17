package com.huawei.hms.hwid;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcelable;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.UIUtil;

/* compiled from: NoticeTaskApiCall.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ae extends TaskApiCall<u, Intent> {
    public ae(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a */
    public void doExecute(u uVar, ResponseErrorCode responseErrorCode, String str, j.k.b.a.m<Intent> mVar) {
        if (responseErrorCode.getStatusCode() == 0 && responseErrorCode.getErrorCode() == 0) {
            as.b("NoticeTaskApiCall", "Jos Notice onResult success.", true);
            a(responseErrorCode.getParcelable(), uVar, responseErrorCode, mVar);
        } else {
            as.c("NoticeTaskApiCall", "Jos Notice onResult failed, ErrCode" + responseErrorCode.getErrorCode(), true);
        }
        if (uVar != null) {
            HiAnalyticsClient.reportExit(uVar.getContext(), getUri(), getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode());
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    private void a(Parcelable parcelable, u uVar, ResponseErrorCode responseErrorCode, j.k.b.a.m<Intent> mVar) {
        Activity currentActivity = ActivityMgr.INST.getCurrentActivity();
        if (currentActivity != null && !currentActivity.isFinishing() && !currentActivity.isDestroyed()) {
            if (parcelable instanceof Intent) {
                try {
                    Intent intent = (Intent) parcelable;
                    j.l.c.e0.a.a.a.h(intent);
                    currentActivity.startActivity(intent);
                    return;
                } catch (Exception unused) {
                    as.d("NoticeTaskApiCall", "Jos Notice startActivity meet exception", true);
                    return;
                }
            } else if (parcelable instanceof PendingIntent) {
                PendingIntent pendingIntent = (PendingIntent) parcelable;
                try {
                    if (UIUtil.isBackground(uVar.getContext())) {
                        as.b("NoticeTaskApiCall", "ui isBackground.", true);
                        mVar.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), pendingIntent)));
                    } else {
                        currentActivity.startIntentSender(pendingIntent.getIntentSender(), null, 0, 0, 0);
                    }
                    return;
                } catch (IntentSender.SendIntentException unused2) {
                    as.d("NoticeTaskApiCall", "Jos Notice startIntentSender meet exception", true);
                    return;
                }
            } else {
                return;
            }
        }
        as.b("NoticeTaskApiCall", "launchNoticeActivity failed, activity is invalid", true);
    }
}
