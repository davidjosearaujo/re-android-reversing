package com.hunantv.imgo.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ThreadManager$a extends Handler {
    public ThreadManager$a(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Object obj;
        if (message.what == 1 && (obj = message.obj) != null && (obj instanceof Runnable)) {
            ((Runnable) obj).run();
        }
    }
}
