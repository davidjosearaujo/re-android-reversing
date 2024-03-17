package cn.jiguang.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.ar.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private static volatile Long a;
    private static volatile Long b;

    public static long a(Context context, long j) {
        return (j + c(context)) / 1000;
    }

    public static boolean a(Context context) {
        String str;
        if (((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c())).longValue() <= 0) {
            str = "isValidRegistered uid <= 0";
        } else if (!TextUtils.isEmpty((String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.d()))) {
            return true;
        } else {
            str = "isValidRegistered regId is empty";
        }
        c.a("SpHelper", str);
        return false;
    }

    public static long b(Context context) {
        return a(context, System.currentTimeMillis());
    }

    public static void b(Context context, long j) {
        if (j > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            a = Long.valueOf(j);
            b = Long.valueOf(currentTimeMillis);
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.h().a((cn.jiguang.g.a<Long>) Long.valueOf(j)), cn.jiguang.g.a.g().a((cn.jiguang.g.a<Long>) Long.valueOf(currentTimeMillis)));
        }
    }

    public static long c(Context context) {
        if (a == null || b == null) {
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.g())).longValue();
            long longValue2 = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.h())).longValue();
            if (longValue == 0 || longValue2 == 0) {
                return 0L;
            }
            a = Long.valueOf(longValue2);
            b = Long.valueOf(longValue);
            return longValue2 - longValue;
        }
        return a.longValue() - b.longValue();
    }
}
