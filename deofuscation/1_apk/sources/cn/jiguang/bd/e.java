package cn.jiguang.bd;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Random;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e {
    private static SharedPreferences a;

    private static long a(long j) {
        return (j + (j % 2 == 0 ? 1L : 2L)) % 32767;
    }

    private static long a(Context context, long j) {
        long j2 = c(context).getLong("next_rid", j);
        if (j2 != j) {
            long a2 = a(j2);
            c(context).edit().putLong("next_rid", a2).apply();
            return a2;
        }
        return j2;
    }

    public static void a(Context context) {
        a = context.getSharedPreferences("cn.jpush.preferences.support.rid", 0);
    }

    public static synchronized long b(Context context) {
        long a2;
        synchronized (e.class) {
            a2 = a(context, -1L);
            if (a2 == -1) {
                a2 = a(Math.abs(new Random().nextInt(32767)));
                c(context).edit().putLong("next_rid", a2).apply();
            }
        }
        return a2;
    }

    private static SharedPreferences c(Context context) {
        if (a == null) {
            a(context);
        }
        return a;
    }
}
