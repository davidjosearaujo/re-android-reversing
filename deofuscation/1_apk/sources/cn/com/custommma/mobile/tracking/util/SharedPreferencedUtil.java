package cn.com.custommma.mobile.tracking.util;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SharedPreferencedUtil {
    public static final String SP_CONFIG_KEY_FILE = "trackingConfig";
    public static final String SP_KEY_ID = "ID_KEY";
    public static final String SP_NAME = "ID_SP";
    public static final String SP_NAME_CONFIG = "cn.com.mma.mobile.tracking.sdkconfig";
    public static final String SP_NAME_FAILED = "cn.com.mma.mobile.tracking.falied";
    public static final String SP_NAME_NORMAL = "cn.com.mma.mobile.tracking.normal";
    public static final String SP_NAME_OTHER = "cn.com.mma.mobile.tracking.other";
    public static final String SP_OTHER_KEY_LASTUPLOADTIME_SUFFIX = "_uploadtime";
    public static final String SP_OTHER_KEY_UPDATE_TIME = "updateTime";

    public static void clearAllDataInSP(Context context, String str) {
        context.getSharedPreferences(str, 0).edit().clear().commit();
    }

    public static synchronized long getLong(Context context, String str, String str2) {
        long j;
        synchronized (SharedPreferencedUtil.class) {
            j = context.getSharedPreferences(str, 0).getLong(str2, 0L);
        }
        return j;
    }

    public static synchronized SharedPreferences getSharedPreferences(Context context, String str) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferencedUtil.class) {
            sharedPreferences = context.getSharedPreferences(str, 0);
        }
        return sharedPreferences;
    }

    public static synchronized String getString(Context context, String str, String str2) {
        String string;
        synchronized (SharedPreferencedUtil.class) {
            string = context.getSharedPreferences(str, 0).getString(str2, "");
        }
        return string;
    }

    public static synchronized void putLong(Context context, String str, String str2, long j) {
        synchronized (SharedPreferencedUtil.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putLong(str2, j);
            edit.commit();
        }
    }

    public static synchronized void putString(Context context, String str, String str2, String str3) {
        synchronized (SharedPreferencedUtil.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }

    public static synchronized boolean removeFromSharedPreferences(Context context, String str, String str2) {
        boolean commit;
        synchronized (SharedPreferencedUtil.class) {
            commit = context.getSharedPreferences(str, 0).edit().remove(str2).commit();
        }
        return commit;
    }

    public static String getString(Context context) {
        return context.getSharedPreferences(SP_NAME, 0).getString(SP_KEY_ID, "");
    }

    public static void putString(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SP_NAME, 0).edit();
        edit.putString(SP_KEY_ID, str);
        edit.commit();
    }
}
