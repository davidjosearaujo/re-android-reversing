package cn.jiguang.ak;

import cn.jiguang.api.JCoreManager;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static void a(int i, boolean z, String str, String str2, Throwable th) {
        JCoreManager.onEvent(null, "JCommon", 18, str, null, Integer.valueOf(i), Boolean.valueOf(z), str2, th);
    }

    public static void a(String str, String str2) {
        a(3, true, str, str2, null);
    }

    public static void b(String str, String str2) {
        a(3, false, str, str2, null);
    }

    public static void c(String str, String str2) {
        a(4, true, str, str2, null);
    }

    public static void d(String str, String str2) {
        a(5, true, str, str2, null);
    }

    public static void e(String str, String str2) {
        a(5, false, str, str2, null);
    }

    public static void f(String str, String str2) {
        a(6, true, str, str2, null);
    }
}
