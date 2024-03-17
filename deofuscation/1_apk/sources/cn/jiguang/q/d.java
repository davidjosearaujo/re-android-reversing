package cn.jiguang.q;

import android.text.TextUtils;
import cn.jiguang.n.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";

    public static String a() {
        try {
            String lowerCase = c.a.b.toLowerCase();
            if (lowerCase.contains("huawei")) {
                return b();
            }
            if (lowerCase.contains("xiaomi")) {
                return f();
            }
            if (lowerCase.contains("meizu")) {
                return e();
            }
            if (!lowerCase.contains("oppo") && !lowerCase.contains("realme")) {
                return lowerCase.contains("vivo") ? c() : lowerCase.contains("oneplus") ? g() : "";
            }
            return d();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            cn.jiguang.ak.a.c("JRomVersionHelper", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable th) {
            cn.jiguang.ak.a.f("JRomVersionHelper", " get " + str + "wrong error:" + th.getMessage());
            return "";
        }
    }

    private static String b() {
        if (TextUtils.isEmpty(a)) {
            String a2 = a("ro.build.version.emui");
            a = a2;
            return a2;
        }
        return a;
    }

    private static String c() {
        if (TextUtils.isEmpty(c)) {
            String a2 = a("ro.vivo.os.build.display.id");
            c = a2;
            return a2;
        }
        return c;
    }

    private static String d() {
        if (TextUtils.isEmpty(b)) {
            String a2 = a("ro.build.version.opporom");
            b = a2;
            return a2;
        }
        return b;
    }

    private static String e() {
        if (TextUtils.isEmpty(f)) {
            String a2 = a("ro.build.display.id");
            f = a2;
            return a2;
        }
        return f;
    }

    private static String f() {
        if (TextUtils.isEmpty(e)) {
            String a2 = a("ro.miui.ui.version.name");
            e = a2;
            return a2;
        }
        return e;
    }

    private static String g() {
        if (TextUtils.isEmpty(d)) {
            String a2 = a("ro.rom.version");
            d = a2;
            return a2;
        }
        return d;
    }
}
