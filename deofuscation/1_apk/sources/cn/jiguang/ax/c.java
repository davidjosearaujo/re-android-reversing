package cn.jiguang.ax;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.android.BuildConfig;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    public static boolean a(Context context) {
        String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.C());
        String e = cn.jiguang.d.a.e(context);
        cn.jiguang.ar.c.c("InitHelper", "appkey=" + e + " last=" + str);
        if (cn.jiguang.f.g.a(str) || "null".equals(str) || !str.equalsIgnoreCase(e)) {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.C().a((cn.jiguang.g.a<String>) e));
            cn.jiguang.ar.c.d("InitHelper", "We found the appKey is changed or register appkey is empty. Will re-register.");
            cn.jiguang.at.b.a(context);
            return true;
        }
        return false;
    }

    public static void b(Context context) {
        String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.w());
        if (TextUtils.isEmpty(str) || str.startsWith("1.")) {
            cn.jiguang.at.b.d(context);
        }
        if (TextUtils.isEmpty(str) || !BuildConfig.VERSION_NAME.equals(str)) {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.w().a((cn.jiguang.g.a<String>) BuildConfig.VERSION_NAME));
        }
    }
}
