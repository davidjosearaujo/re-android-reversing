package cn.com.custommma.mobile.tracking.util.klog;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class KLogUtil {
    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str) || str.equals("\n") || str.equals("\t") || TextUtils.isEmpty(str.trim());
    }

    public static void printLine(String str, boolean z) {
        if (z) {
            Log.d(str, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
            Log.d(str, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        }
    }
}
