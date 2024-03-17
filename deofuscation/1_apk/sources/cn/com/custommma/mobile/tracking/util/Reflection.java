package cn.com.custommma.mobile.tracking.util;

import android.content.Context;
import com.alipay.security.mobile.module.http.model.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class Reflection {
    public static boolean checkPermission(Context context, String str) {
        return getContextCompat() && getContextCompatValue(context, str) == 0;
    }

    public static boolean checkPermissionX(Context context, String str) {
        return getContextCompatX() && getContextCompatValueX(context, str) == 0;
    }

    private static Object getAdvertisingInfoObject(Context context) throws Exception {
        return invokeStaticMethod("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class}, context);
    }

    private static boolean getContextCompat() {
        try {
            return Class.forName("android.support.v4.content.ContextCompat") != null;
        } catch (Exception unused) {
            return false;
        }
    }

    private static int getContextCompatValue(Context context, String str) {
        try {
            Class<?> cls = Class.forName("android.support.v4.content.ContextCompat");
            return ((Integer) cls.getDeclaredMethod("checkSelfPermission", Context.class, String.class).invoke(cls, context, str)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    private static int getContextCompatValueX(Context context, String str) {
        try {
            Class<?> cls = Class.forName("android.support.v4.content.ContextCompat");
            return ((Integer) cls.getDeclaredMethod("checkSelfPermission", Context.class, String.class).invoke(cls, context, str)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    private static boolean getContextCompatX() {
        try {
            return Class.forName("androidx.core.content.ContextCompat") != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getPlayAdId(Context context) {
        String str = null;
        try {
            Object advertisingInfoObject = getAdvertisingInfoObject(context);
            if (advertisingInfoObject != null) {
                str = (String) invokeInstanceMethod(advertisingInfoObject, "getId", null, new Object[0]);
            }
        } catch (Throwable unused) {
        }
        return str == null ? "" : str;
    }

    private static Object invokeInstanceMethod(Object obj, String str, Class[] clsArr, Object... objArr) throws Exception {
        return invokeMethod(obj.getClass(), str, obj, clsArr, objArr);
    }

    private static Object invokeMethod(Class cls, String str, Object obj, Class[] clsArr, Object... objArr) throws Exception {
        return cls.getMethod(str, clsArr).invoke(obj, objArr);
    }

    private static Object invokeStaticMethod(String str, String str2, Class[] clsArr, Object... objArr) throws Exception {
        return invokeMethod(Class.forName(str), str2, null, clsArr, objArr);
    }

    private static boolean isConnectionResultSuccess(Integer num) {
        if (num == null) {
            return false;
        }
        try {
            return Class.forName("com.google.android.gms.common.ConnectionResult").getField(c.p).getInt(null) == num.intValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean isGooglePlayServicesAvailable(Context context) {
        try {
            return isConnectionResultSuccess((Integer) invokeStaticMethod("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[]{Context.class}, context));
        } catch (Throwable unused) {
            return false;
        }
    }
}
