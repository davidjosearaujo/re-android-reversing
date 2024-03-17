package com.huawei.hms.hwid;

import android.os.Looper;

/* compiled from: HuaweiIdValidator.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class r {
    public static void a() {
        a("Must not be called on the main application thread");
    }

    public static void a(String str) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new IllegalStateException(str);
        }
    }
}
