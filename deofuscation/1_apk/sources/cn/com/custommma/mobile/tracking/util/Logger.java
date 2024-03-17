package cn.com.custommma.mobile.tracking.util;

import com.mgadplus.mgutil.SourceKitLogger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class Logger {
    public static boolean DEBUG_LOG = false;
    public static String TAG = "MMAChinaSDK";

    public static void d(String str, String str2) {
        if (DEBUG_LOG) {
            SourceKitLogger.a(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (DEBUG_LOG) {
            SourceKitLogger.b(str, str2);
        }
    }

    public static void i(String str) {
        if (DEBUG_LOG) {
            SourceKitLogger.d(TAG, str);
        }
    }

    public static void w(String str) {
        if (DEBUG_LOG) {
            SourceKitLogger.g(TAG, str);
        }
    }

    public static void d(String str) {
        if (DEBUG_LOG) {
            SourceKitLogger.a(TAG, str);
        }
    }

    public static void e(String str) {
        if (DEBUG_LOG) {
            SourceKitLogger.b(TAG, str);
        }
    }
}
