package com.alipay.sdk.util;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class h {
    public static String a;

    public static synchronized boolean a(Context context, String str) {
        boolean z;
        synchronized (h.class) {
            try {
                z = PreferenceManager.getDefaultSharedPreferences(context).contains(str);
            } catch (Throwable th) {
                c.a(th);
                z = false;
            }
        }
        return z;
    }

    public static synchronized void b(Context context, String str) {
        synchronized (h.class) {
            try {
                PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).apply();
            } catch (Throwable th) {
                c.a(th);
            }
        }
    }

    public static synchronized String a(com.alipay.sdk.sys.a aVar, Context context, String str, String str2) {
        String str3;
        synchronized (h.class) {
            try {
                String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
                str3 = TextUtils.isEmpty(string) ? null : com.alipay.sdk.encrypt.e.a(a(context), string, str);
                if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(str3)) {
                    com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.b.m, com.alipay.sdk.app.statistic.b.J, String.format("%s,%s", str, string));
                }
            } catch (Exception e) {
                c.a(e);
            }
        }
        return str3;
    }

    public static synchronized void b(com.alipay.sdk.sys.a aVar, Context context, String str, String str2) {
        synchronized (h.class) {
            try {
                String b = com.alipay.sdk.encrypt.e.b(a(context), str2, str);
                if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(b)) {
                    com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.b.m, com.alipay.sdk.app.statistic.b.K, String.format("%s,%s", str, str2));
                }
                PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, b).apply();
            } catch (Throwable th) {
                c.a(th);
            }
        }
    }

    public static String a(Context context) {
        String str;
        if (TextUtils.isEmpty(a)) {
            try {
                str = context.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                c.a(th);
                str = "";
            }
            a = (str + "0000000000000000000000000000").substring(0, 24);
        }
        return a;
    }
}
