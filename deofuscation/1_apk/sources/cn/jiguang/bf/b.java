package cn.jiguang.bf;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.f.g;
import cn.jiguang.internal.JConstants;
import java.io.File;
import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    public static int a = 1;

    public static String a(Context context) {
        String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.a());
        if (g.h(str)) {
            a = 3;
            return str;
        }
        String b = b(context, str);
        if (g.h(b)) {
            a = 1;
            d(context, b);
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.a().a((cn.jiguang.g.a<String>) b));
            return b;
        }
        String b2 = b(context);
        if (g.h(b2)) {
            a = 2;
            c(context, b2);
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.a().a((cn.jiguang.g.a<String>) b2));
            return b2;
        }
        String e = Build.VERSION.SDK_INT < 23 ? cn.jiguang.f.a.e(context, b2) : "";
        String i = cn.jiguang.f.a.i(context);
        String g = cn.jiguang.f.a.g(context, "");
        String uuid = UUID.randomUUID().toString();
        String d = g.d(e + i + g + uuid);
        if (!TextUtils.isEmpty(d)) {
            uuid = d;
        }
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.a().a((cn.jiguang.g.a<String>) uuid));
        a = 0;
        c(context, uuid);
        d(context, uuid);
        return uuid;
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c(context, str);
        d(context, str);
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.a().a((cn.jiguang.g.a<String>) str));
    }

    private static String b(Context context) {
        if (!JConstants.isAndroidQ(context, true, "do not get deviceId from SD") && cn.jiguang.f.a.c(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            String b = cn.jiguang.f.a.b();
            if (TextUtils.isEmpty(b)) {
                cn.jiguang.ar.c.i("DeviceIdUtils", "can't get sdcard data path");
            } else {
                String d = cn.jiguang.f.c.d(new File(b + ".push_deviceid"));
                if (d != null) {
                    int indexOf = d.indexOf("\n");
                    return indexOf < 0 ? d.trim() : d.substring(0, indexOf).trim();
                }
            }
        }
        return null;
    }

    private static String b(Context context, String str) {
        return str;
    }

    private static String c(Context context, String str) {
        return null;
    }

    private static String d(Context context, String str) {
        if (JConstants.isAndroidQ(context, true, "not write deviceId to SD")) {
            return str;
        }
        if (cn.jiguang.f.a.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            try {
                String b = cn.jiguang.f.a.b();
                if (TextUtils.isEmpty(b)) {
                    cn.jiguang.ar.c.i("DeviceIdUtils", "can't get sdcard data path");
                    return null;
                }
                cn.jiguang.f.c.b(new File(b + ".push_deviceid"), str);
                return str;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }
}
