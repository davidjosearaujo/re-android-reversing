package cn.jiguang.ar;

import android.util.Log;
import cn.jiguang.internal.JConstants;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    public static void a(String str, String str2, boolean z, int i, String str3, Throwable th) {
        String str4;
        try {
            if (JConstants.DEBUG_MODE || i >= 5) {
                if ((JConstants.INTERNAL_USE || !z || i >= 6) && a(i)) {
                    if (i == 2) {
                        Log.v("JIGUANG-" + str, "[" + str2 + "] " + str3);
                        str4 = "TRACE";
                    } else if (i == 3) {
                        Log.d("JIGUANG-" + str, "[" + str2 + "] " + str3);
                        str4 = "DEBUG";
                    } else if (i == 4) {
                        Log.i("JIGUANG-" + str, "[" + str2 + "] " + str3);
                        str4 = "INFO";
                    } else if (i == 5) {
                        Log.w("JIGUANG-" + str, "[" + str2 + "] " + str3);
                        str4 = "WARN";
                    } else if (i != 6) {
                        return;
                    } else {
                        Log.e("JIGUANG-" + str, "[" + str2 + "] " + str3);
                        str4 = "ERROR";
                    }
                    b.a(str4, str2, str3, null);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean a(int i) {
        return i >= 2;
    }
}
