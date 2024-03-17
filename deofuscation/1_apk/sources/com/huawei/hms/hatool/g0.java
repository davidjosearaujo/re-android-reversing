package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;

@SuppressLint({"ApplySharedPref"})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class g0 {
    public static long a(Context context, String str, String str2, long j) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            y.f("hmsSdk", "context is null or spName empty or spkey is empty");
            return j;
        }
        SharedPreferences b = b(context, str);
        return b != null ? b.getLong(str2, j) : j;
    }

    public static String a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            y.f("hmsSdk", "context is null or spName empty or spkey is empty");
            return str3;
        }
        SharedPreferences b = b(context, str);
        return b != null ? b.getString(str2, str3) : str3;
    }

    public static Map<String, ?> a(Context context, String str) {
        return b(context, str).getAll();
    }

    public static void a(Context context, String str, String... strArr) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "clearData(): parameter error.context,spname";
        } else if (strArr != null) {
            SharedPreferences b = b(context, str);
            if (b != null) {
                SharedPreferences.Editor edit = b.edit();
                if (strArr.length == 0) {
                    edit.clear();
                    edit.commit();
                    return;
                }
                for (String str3 : strArr) {
                    if (b.contains(str3)) {
                        edit.remove(str3);
                        edit.commit();
                    }
                }
                return;
            }
            return;
        } else {
            str2 = "clearData(): No data need to be deleted,keys is null";
        }
        y.f("hmsSdk", str2);
    }

    public static SharedPreferences b(Context context, String str) {
        return context.getSharedPreferences(c(context, str), 0);
    }

    public static void b(Context context, String str, String str2, long j) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            y.f("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences b = b(context, str);
        if (b != null) {
            SharedPreferences.Editor edit = b.edit();
            edit.putLong(str2, j);
            edit.commit();
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            y.e("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences b = b(context, str);
        if (b != null) {
            SharedPreferences.Editor edit = b.edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }

    public static String c(Context context, String str) {
        String packageName = context.getPackageName();
        String n = c.n("_hms_config_tag", "oper");
        if (TextUtils.isEmpty(n)) {
            return "hms_" + str + "_" + packageName;
        }
        return "hms_" + str + "_" + packageName + "_" + n;
    }
}
