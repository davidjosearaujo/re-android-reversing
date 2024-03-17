package com.hunantv.media.player.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ThreadUtil {
    public static void postOnUiThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public static void quit(Looper looper) {
        if (looper != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                looper.quitSafely();
            } else {
                looper.quit();
            }
        }
    }

    public static void runOnTargetLooper(Looper looper, Runnable runnable) {
        if (looper == null || runnable == null) {
            return;
        }
        new Handler(looper).post(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            postOnUiThread(runnable);
        }
    }
}
