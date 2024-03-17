package cn.jpush.android.a;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class a {
    private static SharedPreferences a;

    public static void a(Context context) {
        if (a == null) {
            a = context.getSharedPreferences("asus_push_sdk_preferences", 0);
        }
    }

    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    public static void a(String str, boolean z) {
        SharedPreferences sharedPreferences = a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, false);
            edit.apply();
        }
    }

    public static Boolean b(String str, boolean z) {
        SharedPreferences sharedPreferences = a;
        return sharedPreferences != null ? Boolean.valueOf(sharedPreferences.getBoolean(str, true)) : Boolean.TRUE;
    }

    public static String b(String str, String str2) {
        SharedPreferences sharedPreferences = a;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }
}
