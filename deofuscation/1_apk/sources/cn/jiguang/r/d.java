package cn.jiguang.r;

import android.text.TextUtils;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    private static long a = 1;

    public static long a() {
        long j = a + 1;
        a = j;
        if (j >= 2147483647L) {
            a = 1L;
        }
        return a;
    }

    public static byte[] a(long j, String str) {
        cn.jiguang.s.a aVar = new cn.jiguang.s.a(20480);
        aVar.a(0);
        aVar.a(j);
        if (str != null && !TextUtils.isEmpty(str)) {
            aVar.a(cn.jiguang.n.d.e(str));
        }
        return aVar.a();
    }
}
