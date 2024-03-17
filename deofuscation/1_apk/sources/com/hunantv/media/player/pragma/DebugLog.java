package com.hunantv.media.player.pragma;

import android.util.Log;
import com.hunantv.media.player.libnative.ImgoReportLog;
import java.util.Locale;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DebugLog {
    public static final String MODULE_ID = "12";
    private static final int REPORT_LOG_LEVEL_DEBUG = 0;
    private static final int REPORT_LOG_LEVEL_ERROR = 3;
    private static final int REPORT_LOG_LEVEL_INFO = 1;
    private static final int REPORT_LOG_LEVEL_WARN = 2;

    public static void d(String str, String str2) {
        reportLog(0, str, str2);
    }

    public static void d(String str, String str2, Throwable th) {
        if (PlayerConfig.use_report_level > 0) {
            Log.d(str, str2, th);
        }
    }

    public static void dfmt(String str, String str2, Object... objArr) {
        reportLog(0, str, String.format(Locale.US, str2, objArr));
    }

    public static void e(String str, String str2) {
        reportLog(3, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (PlayerConfig.use_report_level > 0) {
            Log.e(str, str2, th);
        }
    }

    public static void efmt(String str, String str2, Object... objArr) {
        reportLog(3, str, String.format(Locale.US, str2, objArr));
    }

    public static void i(String str, String str2) {
        reportLog(1, str, str2);
    }

    public static void i(String str, String str2, Throwable th) {
        if (PlayerConfig.use_report_level > 0) {
            Log.i(str, str2, th);
        }
    }

    public static void ifmt(String str, String str2, Object... objArr) {
        reportLog(1, str, String.format(Locale.US, str2, objArr));
    }

    public static void printCause(Throwable th) {
        if (PlayerConfig.use_report_level > 0) {
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            printStackTrace(th);
        }
    }

    public static void printStackTrace(Throwable th) {
        if (PlayerConfig.use_report_level > 0) {
            th.printStackTrace();
        }
    }

    private static void reportLog(int i, String str, String str2) {
        ImgoReportLog.ImgoLogReport(i, "12", str, str2);
    }

    public static void v(String str, String str2) {
        reportLog(0, str, str2);
    }

    public static void v(String str, String str2, Throwable th) {
        if (PlayerConfig.use_report_level > 0) {
            Log.v(str, str2, th);
        }
    }

    public static void vfmt(String str, String str2, Object... objArr) {
        reportLog(0, str, String.format(Locale.US, str2, objArr));
    }

    public static void w(String str, String str2) {
        reportLog(2, str, str2);
    }

    public static void w(String str, String str2, Throwable th) {
        if (PlayerConfig.use_report_level > 0) {
            Log.w(str, str2, th);
        }
    }

    public static void wfmt(String str, String str2, Object... objArr) {
        reportLog(2, str, String.format(Locale.US, str2, objArr));
    }
}
