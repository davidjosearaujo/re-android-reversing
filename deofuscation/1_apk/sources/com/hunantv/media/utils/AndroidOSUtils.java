package com.hunantv.media.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import java.lang.reflect.Method;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AndroidOSUtils {
    @TargetApi(31)
    public static String getCPUChipMf() {
        return Build.SOC_MANUFACTURER;
    }

    @TargetApi(31)
    public static String getCPUChipMod() {
        return Build.SOC_MODEL;
    }

    public static String getCPUChipMod4Display() {
        String prop = getProp("ro.config.cpu_info_display", "n");
        return !prop.equalsIgnoreCase("n") ? prop : "ncpu";
    }

    public static String getColorOSVersion() {
        StringBuilder sb;
        String str = Build.MANUFACTURER;
        String str2 = "0";
        if (!str.equals("OPPO") && !str.equals("realme") && !str.equals("OnePlus")) {
            return "0";
        }
        try {
            Class<?> cls = Class.forName("com.oplus.os.OplusBuild$VERSION");
            String str3 = (String) cls.getField("RELEASE").get(cls.newInstance());
            if (str3 != null) {
                try {
                    if (str3.startsWith("V")) {
                        sb = new StringBuilder();
                        sb.append("ColorOS_");
                        sb.append(str3.substring(1));
                    } else {
                        sb = new StringBuilder();
                        sb.append("ColorOS_");
                        sb.append(str3);
                    }
                    return sb.toString();
                } catch (Exception e) {
                    e = e;
                    str2 = str3;
                    e.printStackTrace();
                    return str2;
                }
            }
            return "ColorOS_0";
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static String getEMUIVersion() {
        if (Build.MANUFACTURER.equals("HUAWEI")) {
            String prop = getProp("ro.build.version.emui", "n");
            return !prop.equalsIgnoreCase("n") ? prop : "EmotionUI_0";
        }
        return "0";
    }

    public static String getFlymeVersion() {
        StringBuilder sb;
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            String prop = getProp("ro.build.display.id", "n");
            if (prop.equalsIgnoreCase("n")) {
                return "Flyme_0";
            }
            if (prop.length() > 6) {
                sb = new StringBuilder();
                sb.append("Flyme_");
                prop = prop.substring(6);
            } else {
                sb = new StringBuilder();
                sb.append("Flyme_");
            }
            sb.append(prop);
            return sb.toString();
        }
        return "0";
    }

    public static String getFuntouchOSVersion() {
        if (Build.MANUFACTURER.equals("vivo")) {
            try {
                Class<?> cls = Class.forName("android.os.FtBuild");
                Method method = cls.getMethod("getProductVersion", new Class[0]);
                return "FunOS_" + ((String) method.invoke(cls, new Object[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "0";
    }

    public static String getMIUIVersion() {
        if (Build.MANUFACTURER.equals("Xiaomi")) {
            String romVersion = getRomVersion();
            if (romVersion != null) {
                int lastIndexOf = romVersion.lastIndexOf(Consts.DOT);
                if (romVersion.length() <= 1 || lastIndexOf == -1) {
                    return "MIUI_" + romVersion;
                }
                return "MIUI_" + romVersion.substring(1, lastIndexOf);
            }
            return romVersion;
        }
        return "n";
    }

    public static String getMagicOSVersion() {
        if (Build.MANUFACTURER.equals("HONOR")) {
            if (Build.VERSION.SDK_INT >= 31) {
                String prop = getProp("ro.build.version.magic", "n");
                return prop.equalsIgnoreCase("n") ? "MagicUI_0" : prop;
            }
            return "MagicUI_" + getRomVersion();
        }
        return "0";
    }

    public static String getOneUIVersion() {
        if (Build.MANUFACTURER.equals("samsung")) {
            String prop = getProp("ro.build.version.oneui", "n");
            if (prop.equalsIgnoreCase("n")) {
                return "OneUI_0";
            }
            int i = 0;
            try {
                i = Integer.parseInt(prop);
            } catch (NumberFormatException unused) {
            }
            return "OneUI_" + (i / 10000) + Consts.DOT + ((i % 10000) / 100);
        }
        return "0";
    }

    private static String getProp(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public static String getRomVersion() {
        return Build.VERSION.INCREMENTAL;
    }
}
