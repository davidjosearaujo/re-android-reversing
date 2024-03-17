package cn.jpush.android.z;

import android.text.TextUtils;
import cn.jpush.android.helper.Logger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    public static byte[] a(int i, byte b, long j, String str) {
        e eVar = new e(128);
        eVar.b(i);
        eVar.a((int) b);
        eVar.a(j);
        if (!TextUtils.isEmpty(str)) {
            eVar.a(b(str));
        }
        return eVar.a();
    }

    public static byte[] a(int i, int i2, int i3, int i4, int i5, int i6, String str, String str2) {
        e eVar = new e(128);
        eVar.a(i);
        eVar.a(i2);
        eVar.a(i3);
        eVar.a(i4);
        eVar.a(i5);
        eVar.a(i6);
        eVar.a(str);
        eVar.a(str2);
        return eVar.a();
    }

    public static byte[] a(int i, String str, String str2) {
        e eVar = new e(128);
        eVar.a(i);
        eVar.a(str);
        eVar.a(str2);
        return eVar.a();
    }

    public static byte[] a(String str) {
        e eVar = new e(128);
        eVar.a(7);
        eVar.a(1);
        eVar.a(str != null ? b(str) : new byte[0]);
        return eVar.a();
    }

    public static byte[] a(String str, byte b) {
        e eVar = new e(8192);
        eVar.a(TextUtils.isEmpty(str) ? new byte[0] : b(str));
        eVar.a((int) b);
        return eVar.a();
    }

    public static byte[] a(String str, int i, String str2) {
        e eVar = new e(8192);
        if (i == 10) {
            eVar.a(b(str));
        }
        eVar.a(b(str2));
        return eVar.a();
    }

    public static byte[] b(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (Throwable th) {
            Logger.ee("PushPackage", "stringToUtf8Bytes error:" + th.getMessage());
            return str.getBytes();
        }
    }

    public static byte[] c(String str) {
        e eVar = new e(8192);
        eVar.a(b(str));
        return eVar.a();
    }
}
