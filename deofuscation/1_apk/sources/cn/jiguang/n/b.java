package cn.jiguang.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import cn.jiguang.f.g;
import cn.jiguang.internal.JConstants;
import java.util.HashMap;

@SuppressLint({"CommitPrefEdits"})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private static SharedPreferences a;
    private static HashMap<String, Long> b;

    private static String a(String str, String str2) {
        return str + str2;
    }

    private static void a() {
        HashMap<String, Long> hashMap = new HashMap<>();
        b = hashMap;
        hashMap.put(a("JDataConfigManager", "_bi"), 86400000L);
        b.put(a("JWakeReport", "_ri"), Long.valueOf((long) JConstants.HOUR));
    }

    public static void a(Context context) {
        String n = n(context);
        m(context).edit().putInt(n, m(context).getInt(n, 0) + 1).apply();
    }

    public static void a(Context context, String str, int i) {
        m(context).edit().putInt(a("JType", "ktsv_" + str), i).apply();
    }

    public static void a(Context context, String str, long j) {
        if (j < 0) {
            return;
        }
        if (!str.contains("JLocation") || j <= j(context, "JLocationv2")) {
            String a2 = a(str, "_bi");
            cn.jiguang.ak.a.c("JCommonConfig", "update " + str + " businessInterval:" + j);
            m(context).edit().putLong(a2, j).apply();
        }
    }

    public static void a(Context context, String str, String str2) {
        m(context).edit().putString(a("JType", str), str2).apply();
    }

    public static void a(Context context, String str, boolean z) {
        m(context).edit().putBoolean(a(str, "_ace"), z).apply();
    }

    public static void a(Context context, boolean z) {
        m(context).edit().putBoolean(a("user_wake", "_aue"), z).apply();
    }

    public static boolean a(int i) {
        boolean z = !d.e() && cn.jiguang.i.a.a().c(i) == 0;
        cn.jiguang.ak.a.c("JCommonConfig", "configId : " + i + ", isBackgroundBusiness : " + z);
        return z;
    }

    public static boolean a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long f = f(context, str);
        long b2 = cn.jiguang.i.a.a().b(str);
        boolean z = currentTimeMillis - f > b2;
        cn.jiguang.ak.a.c("JCommonConfig", "is " + str + " businessTime:" + z + ",curTime:" + currentTimeMillis + ",lastBusinessTime:" + f + ",businessInterval:" + b2);
        return z;
    }

    private static long b(String str, String str2) {
        try {
            return b.get(a(str, str2)).longValue();
        } catch (NullPointerException unused) {
            return 0L;
        }
    }

    public static void b(Context context, String str, long j) {
        if (j < 0) {
            return;
        }
        String a2 = a(str, "_ri");
        cn.jiguang.ak.a.c("JCommonConfig", "update " + str + " reportInterval:" + j);
        m(context).edit().putLong(a2, j).apply();
    }

    public static void b(Context context, String str, boolean z) {
        m(context).edit().putBoolean(a(str, "_aue"), z).apply();
    }

    public static void b(Context context, boolean z) {
        m(context).edit().putBoolean("JArponceEnable", z).apply();
    }

    public static boolean b(Context context) {
        return m(context).getBoolean(a("user_wake", "_aue"), true);
    }

    public static boolean b(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long f = f(context, str);
        long g = g(context, str);
        boolean z = currentTimeMillis - f > g;
        cn.jiguang.ak.a.c("JCommonConfig", "is " + str + " businessTime:" + z + ",curTime:" + currentTimeMillis + ",lastBusinessTime:" + f + ",businessInterval:" + g);
        return z;
    }

    public static String c(Context context) {
        return m(context).getString("JWakeLocalState", "");
    }

    public static boolean c(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long i = i(context, str);
        long c = cn.jiguang.i.a.a().c(str);
        boolean z = currentTimeMillis - i > c;
        cn.jiguang.ak.a.c("JCommonConfig", "is " + str + " reportTime:" + z + ",curTime:" + currentTimeMillis + ",lastReportTime:" + i + ",reportInterval:" + c);
        return z;
    }

    public static boolean d(Context context) {
        return m(context).getBoolean("JArponceEnable", false);
    }

    public static boolean d(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long i = i(context, str);
        long j = j(context, str);
        boolean z = currentTimeMillis - i > j;
        cn.jiguang.ak.a.c("JCommonConfig", "is " + str + " reportTime:" + z + ",curTime:" + currentTimeMillis + ",lastReportTime:" + i + ",reportInterval:" + j);
        return z;
    }

    public static String e(Context context) {
        return m(context).getString(a("JLocation", "info"), "");
    }

    public static void e(Context context, String str) {
        String a2 = a(str, "_blt");
        long currentTimeMillis = System.currentTimeMillis();
        cn.jiguang.ak.a.c("JCommonConfig", "update " + str + " lastBusinessTime");
        m(context).edit().putLong(a2, currentTimeMillis).apply();
    }

    public static long f(Context context, String str) {
        return m(context).getLong(a(str, "_blt"), 0L);
    }

    public static String f(Context context) {
        return m(context).getString("JNotificationState", "");
    }

    public static long g(Context context, String str) {
        return m(context).getLong(a(str, "_bi"), b(str, "_bi"));
    }

    public static String g(Context context) {
        return m(context).getString("JDevicesession", "");
    }

    public static String h(Context context) {
        return m(context).getString("JDeviceIds", "");
    }

    public static void h(Context context, String str) {
        cn.jiguang.ak.a.c("JCommonConfig", "update " + str + " lastReportTime");
        long currentTimeMillis = System.currentTimeMillis();
        m(context).edit().putLong(a(str, "_rlt"), currentTimeMillis).apply();
    }

    public static long i(Context context, String str) {
        return m(context).getLong(a(str, "_rlt"), 0L);
    }

    public static String i(Context context) {
        return m(context).getString("JDeviceIdsMap", "");
    }

    public static long j(Context context, String str) {
        return m(context).getLong(a(str, "_ri"), b(str, "_ri"));
    }

    public static String j(Context context) {
        return m(context).getString("device_ids_map", "");
    }

    public static String k(Context context) {
        return m(context).getString("lo_cf", "");
    }

    public static boolean k(Context context, String str) {
        return m(context).getBoolean(a(str, "_ace"), !str.equals("JArp"));
    }

    private static void l(Context context) {
        a = context.getSharedPreferences("cn.jiguang.common", 0);
        a();
    }

    public static boolean l(Context context, String str) {
        return m(context).getBoolean(a(str, "_aue"), true);
    }

    private static SharedPreferences m(Context context) {
        if (a == null) {
            l(context);
        }
        return a;
    }

    public static void m(Context context, String str) {
        if (g.a(str)) {
            return;
        }
        String n = n(context);
        if (n != null && !n.equals(str)) {
            m(context).edit().remove(n).apply();
        }
        m(context).edit().putString("current_time_key", str).apply();
    }

    public static int n(Context context, String str) {
        if (g.a(str)) {
            return Integer.MAX_VALUE;
        }
        return m(context).getInt(str, 0);
    }

    private static String n(Context context) {
        return m(context).getString("current_time_key", null);
    }

    public static void o(Context context, String str) {
        m(context).edit().putString("JWakeLocalState", str).apply();
    }

    public static String p(Context context, String str) {
        return m(context).getString(a("JType", str), "-1,-1");
    }

    public static int q(Context context, String str) {
        return m(context).getInt(a("JType", "ktsv_" + str), 0);
    }

    public static void r(Context context, String str) {
        m(context).edit().putBoolean(a("JArp", str), true).apply();
    }

    public static boolean s(Context context, String str) {
        return m(context).getBoolean(a("JArp", str), false);
    }

    public static void t(Context context, String str) {
        m(context).edit().putString(a("JLocation", "info"), str).apply();
    }

    public static void u(Context context, String str) {
        m(context).edit().putString("JNotificationState", str).apply();
    }

    public static void v(Context context, String str) {
        cn.jiguang.ak.a.c("JCommonConfig", "update deviceSession");
        m(context).edit().putString("JDevicesession", str).apply();
    }

    public static void w(Context context, String str) {
        m(context).edit().putString("JDeviceIds", str).apply();
    }

    public static void x(Context context, String str) {
        m(context).edit().putString("JDeviceIdsMap", str).apply();
    }

    public static void y(Context context, String str) {
        m(context).edit().putString("device_ids_map", str).apply();
    }

    public static void z(Context context, String str) {
        m(context).edit().putString("lo_cf", str).apply();
    }
}
