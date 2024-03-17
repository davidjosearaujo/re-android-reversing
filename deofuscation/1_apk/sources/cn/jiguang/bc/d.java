package cn.jiguang.bc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.f.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    private static List<String> a;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add("358673013795895");
        a.add("004999010640000");
        a.add("00000000000000");
        a.add("000000000000000");
    }

    private static String a() {
        String b = cn.jiguang.f.a.b();
        if (b == null) {
            return null;
        }
        return b + ".push_udid";
    }

    public static String a(Context context) {
        String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.D());
        if (!TextUtils.isEmpty(str)) {
            str = new String(Base64.decode(str, 2));
        }
        if (a(str)) {
            return str;
        }
        String b = b(context);
        if (!TextUtils.isEmpty(b)) {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.D().a((cn.jiguang.g.a<String>) Base64.encodeToString(b.getBytes(), 2)));
        }
        return b;
    }

    private static boolean a(String str) {
        if (g.h(str) && str.length() >= 10) {
            for (String str2 : a) {
                if (str.startsWith(str2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static String b(Context context) {
        try {
            String str = a.a(context).p;
            if (a(str)) {
                return str;
            }
            String str2 = a.a(context).i;
            if (!a(str2) || "9774d56d682e549c".equals(str2.toLowerCase(Locale.getDefault()))) {
                String c = c(context);
                return a(c) ? c : "";
            }
            return str2;
        } catch (Exception e) {
            cn.jiguang.ar.c.c("UDIDUtils", "", e);
            String d = d(context);
            return a(d) ? d : "";
        }
    }

    private static String c(Context context) {
        String j = cn.jiguang.d.a.l(context) ? cn.jiguang.f.a.j(context) : "";
        if (a(j)) {
            return j;
        }
        String d = d(context);
        return d == null ? " " : d;
    }

    private static String d(Context context) {
        cn.jiguang.ar.c.c("UDIDUtils", "Action:getSavedUuid");
        String str = (String) cn.jiguang.g.b.b(context, cn.jiguang.g.a.S());
        if (g.a(str)) {
            if (cn.jiguang.f.a.a()) {
                String str2 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.E());
                return TextUtils.isEmpty(str2) ? (Build.VERSION.SDK_INT >= 23 && !(cn.jiguang.f.a.c(context, "android.permission.WRITE_EXTERNAL_STORAGE") && cn.jiguang.f.a.c(context, "android.permission.READ_EXTERNAL_STORAGE"))) ? f(context) : e(context) : str2;
            }
            return f(context);
        }
        return str;
    }

    private static String e(Context context) {
        String a2 = a();
        File file = !g.a(a2) ? new File(a2) : null;
        String d = cn.jiguang.f.c.d(file);
        if (!TextUtils.isEmpty(d)) {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.E().a((cn.jiguang.g.a<String>) d));
            cn.jiguang.ar.c.e("UDIDUtils", "Got sdcard file saved udid - " + d);
            return d;
        }
        String j = g.j(UUID.nameUUIDFromBytes((System.currentTimeMillis() + "").getBytes()).toString());
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.E().a((cn.jiguang.g.a<String>) j));
        cn.jiguang.f.c.b(file, j);
        return j;
    }

    private static String f(Context context) {
        cn.jiguang.g.a<String> S = cn.jiguang.g.a.S();
        String str = (String) cn.jiguang.g.b.b(context, S);
        if (str == null) {
            String uuid = UUID.randomUUID().toString();
            cn.jiguang.g.b.a(context, S.a((cn.jiguang.g.a<String>) uuid));
            return uuid;
        }
        return str;
    }
}
