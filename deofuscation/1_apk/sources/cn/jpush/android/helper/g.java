package cn.jpush.android.helper;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class g {
    private static long a = 1;

    public static long a() {
        long j = a + 1;
        a = j;
        if (j >= 2147483647L) {
            a = 1L;
        }
        return a;
    }
}
