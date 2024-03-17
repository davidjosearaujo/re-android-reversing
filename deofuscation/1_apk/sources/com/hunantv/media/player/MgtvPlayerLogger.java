package com.hunantv.media.player;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvPlayerLogger {
    public static final int REPORT_LOG_LEVEL_DEBUG = 0;
    public static final int REPORT_LOG_LEVEL_ERROR = 3;
    public static final int REPORT_LOG_LEVEL_INFO = 1;
    public static final int REPORT_LOG_LEVEL_WARN = 2;
    private static OnLogCallback mOnLogCallback;
    private static boolean sDebugMode;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnLogCallback {
        void onLogCb(int i, String str, String str2, String str3);
    }

    public static OnLogCallback getLogCallback() {
        return mOnLogCallback;
    }

    public static boolean isDebugMode() {
        return sDebugMode;
    }

    public static void openDebugMode(boolean z) {
        sDebugMode = z;
    }

    public static void setLogCallback(OnLogCallback onLogCallback) {
        mOnLogCallback = onLogCallback;
    }
}
