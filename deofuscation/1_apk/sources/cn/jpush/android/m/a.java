package cn.jpush.android.m;

import cn.jiguang.internal.JConstants;
import cn.jpush.android.local.JPushConstants;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    public static int a = 415;
    public static String b = "4.1.5";
    public static final int c = JConstants.SDK_VERSION_INT;
    public static boolean d = false;

    public static boolean a() {
        try {
            return JPushConstants.THIRD_ENABLE;
        } catch (Throwable unused) {
            return true;
        }
    }
}
