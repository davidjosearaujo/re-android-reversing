package cn.jpush.android.helper;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class h {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";
    private static String g = "";
    private static String h = "";

    public static String a() {
        try {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (!lowerCase.contains("huawei") && !lowerCase.contains("honor")) {
                if (lowerCase.contains("xiaomi")) {
                    return f();
                }
                if (lowerCase.contains("meizu")) {
                    return b();
                }
                if (!lowerCase.contains("oppo") && !lowerCase.contains("realme")) {
                    return lowerCase.contains("vivo") ? d() : lowerCase.contains("oneplus") ? g() : lowerCase.contains("samsung") ? h() : lowerCase.contains("meitu") ? i() : "";
                }
                return e();
            }
            return c();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            Logger.i("RomVersionHelper", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable th) {
            Logger.e("RomVersionHelper", " get " + str + "wrong error:" + th.getMessage());
            return "";
        }
    }

    public static String b() {
        if (TextUtils.isEmpty(f)) {
            String a2 = a("ro.build.display.id");
            f = a2;
            return a2;
        }
        return f;
    }

    private static String c() {
        if (TextUtils.isEmpty(a)) {
            String a2 = a("ro.build.version.emui");
            a = a2;
            return a2;
        }
        return a;
    }

    private static String d() {
        if (TextUtils.isEmpty(c)) {
            String a2 = a("ro.vivo.os.build.display.id");
            c = a2;
            return a2;
        }
        return c;
    }

    private static String e() {
        if (TextUtils.isEmpty(b)) {
            String str = "OPPO_" + a("ro.build.version.opporom");
            b = str;
            return str;
        }
        return b;
    }

    private static String f() {
        if (TextUtils.isEmpty(e)) {
            String str = "MIUI_" + a("ro.miui.ui.version.name");
            e = str;
            return str;
        }
        return e;
    }

    private static String g() {
        if (TextUtils.isEmpty(d)) {
            String a2 = a("ro.rom.version");
            d = a2;
            if (TextUtils.isEmpty(a2)) {
                d = "OXYGEN_" + a("ro.oxygen.version");
            }
            if (!TextUtils.isEmpty(d) && !d.startsWith("Hydrogen") && !d.startsWith("OXYGEN_")) {
                d = "ONEPLUS_" + d;
            }
            Logger.d("RomVersionHelper", "getOnePlusVersion = " + d);
            return d;
        }
        return d;
    }

    private static String h() {
        String str;
        if (TextUtils.isEmpty(g)) {
            String a2 = a("ro.build.version.sem");
            if ("2601".equals(a2)) {
                str = "SAMSUNG_EXUI_9.0";
            } else if ("2801".equals(a2)) {
                str = "SAMSUNG_ONEUI_1.0";
            } else if ("2802".equals(a2)) {
                str = "SAMSUNG_ONEUI_1.x";
            } else if ("2803".equals(a2)) {
                str = "SAMSUNG_ONEUI_1.5";
            } else if (!"2901".equals(a2)) {
                if ("2902".equals(a2)) {
                    str = "SAMSUNG_ONEUI_2.1";
                }
                return g;
            } else {
                str = "SAMSUNG_ONEUI_2.0";
            }
            g = str;
            return g;
        }
        return g;
    }

    private static String i() {
        if (TextUtils.isEmpty(h)) {
            String str = "MEIOS_" + a("ro.build.version.meios");
            h = str;
            return str;
        }
        return h;
    }
}
