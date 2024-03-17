package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hms.framework.common.EmuiUtil;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* compiled from: EmuiUtil.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class aq {
    private static int a = -1;
    private static int b;

    static {
        b();
    }

    public static boolean a() {
        return b >= 21;
    }

    private static void b() {
        int d = d();
        b = d;
        if (d >= 17) {
            a = 90;
        }
        if (d >= 11) {
            a = 50;
        } else if (d >= 10) {
            a = 41;
        } else if (d >= 9) {
            a = 40;
        } else if (d >= 8) {
            a = 31;
        } else if (d >= 7) {
            a = 30;
        }
        if (a == -1) {
            c();
        }
    }

    private static void c() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    a = 30;
                } else if (str.contains("EmotionUI_3.1")) {
                    a = 31;
                } else if (str.contains("EmotionUI_4.0")) {
                    a = 40;
                } else if (str.contains("EmotionUI_4.1")) {
                    a = 41;
                } else if (str.contains("EmotionUI_5.0")) {
                    a = 50;
                }
            }
        } catch (RuntimeException unused) {
            as.d("EmuiUtil", "RuntimeException getEmuiType.", true);
        } catch (Exception unused2) {
            as.d("EmuiUtil", "getEmuiType Exception.", true);
        }
    }

    private static int d() {
        Object a2 = a.a(EmuiUtil.BUILDEX_VERSION, EmuiUtil.EMUI_SDK_INT);
        if (a2 != null) {
            try {
                b = ((Integer) a2).intValue();
            } catch (ClassCastException unused) {
                as.d("EmuiUtil", "getEMUIVersionCode is not a number", true);
            }
        }
        return b;
    }

    /* compiled from: EmuiUtil.java */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        public static Class<?> a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (EmuiUtil.BUILDEX_VERSION.equals(str) || EmuiUtil.IMMERSION_STYLE.equals(str)) {
                try {
                    return Class.forName(str);
                } catch (ClassNotFoundException unused) {
                    return null;
                }
            }
            return null;
        }

        public static Object a(String str, String str2) {
            Class<?> a = a(str);
            if (a == null || TextUtils.isEmpty(str2) || !EmuiUtil.BUILDEX_VERSION.equals(str) || !EmuiUtil.EMUI_SDK_INT.equals(str2)) {
                return null;
            }
            try {
                Field declaredField = a.getDeclaredField(str2);
                AccessibleObject.setAccessible(new Field[]{declaredField}, true);
                return declaredField.get(a);
            } catch (IllegalAccessException unused) {
                as.c("ReflectionUtils", "Exception in getFieldObj :: IllegalAccessException", true);
                return null;
            } catch (IllegalArgumentException unused2) {
                as.c("ReflectionUtils", "Exception in getFieldObj :: IllegalArgumentException", true);
                return null;
            } catch (NoSuchFieldException unused3) {
                as.c("ReflectionUtils", "Exception in getFieldObj :: NoSuchFieldException", true);
                return null;
            } catch (SecurityException unused4) {
                as.b("ReflectionUtils", "not security int method getStaticFieldObj", true);
                return null;
            }
        }
    }
}
