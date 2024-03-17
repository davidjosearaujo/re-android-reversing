package com.hunantv.media.source;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImgoCacheLogger {
    public static final int REPORT_LOG_LEVEL_DEBUG = 0;
    public static final int REPORT_LOG_LEVEL_ERROR = 3;
    public static final int REPORT_LOG_LEVEL_INFO = 1;
    public static final int REPORT_LOG_LEVEL_WARN = 2;
    private static Callback sLoggerCallback;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface Callback {
        void onLog(int i, String str, String str2);
    }

    public static void cbLog(int i, String str, String str2) {
        Callback callback = sLoggerCallback;
        if (callback != null) {
            callback.onLog(i, str, str2);
        }
    }

    public static void d(String str, String str2) {
        cbLog(0, str, str2);
    }

    public static void e(String str, String str2) {
        cbLog(3, str, str2);
    }

    public static synchronized Callback getCallback() {
        Callback callback;
        synchronized (ImgoCacheLogger.class) {
            callback = sLoggerCallback;
        }
        return callback;
    }

    public static void i(String str, String str2) {
        cbLog(1, str, str2);
    }

    public static synchronized void setCallback(Callback callback) {
        synchronized (ImgoCacheLogger.class) {
            sLoggerCallback = callback;
        }
    }

    public static void w(String str, String str2) {
        cbLog(2, str, str2);
    }
}
