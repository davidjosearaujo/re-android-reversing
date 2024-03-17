package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

/* compiled from: AAIDCallable.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class j implements Callable<AAIDResult> {
    public Context a;

    public j(Context context) {
        this.a = context;
    }

    @Override // java.util.concurrent.Callable
    public AAIDResult call() throws Exception {
        Context context = this.a;
        if (context != null) {
            String c = o.c(context);
            AAIDResult aAIDResult = new AAIDResult();
            aAIDResult.setId(c);
            return aAIDResult;
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }
}