package cn.jiguang.t;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import cn.jiguang.n.c;
import cn.jiguang.n.d;
import cn.jiguang.v.b;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static String a(Context context, String str) {
        try {
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("IdHelper", "getIdsByLocal failed:" + th.getMessage());
        }
        if (b()) {
            cn.jiguang.ak.a.d("IdHelper", "not get id in main thread");
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        String g = d.g("KACzk43fXSu6fNDY3NHiRg==");
        if (!TextUtils.isEmpty(g) && str.toLowerCase().equals(g)) {
            String f = f(context);
            if (TextUtils.isEmpty(f)) {
                return "";
            }
            jSONObject.put("joad", f);
            return jSONObject.toString();
        }
        String g2 = d.g("abElWL6JFOA3DmtpsVXe5g==");
        if (TextUtils.isEmpty(g2) || !str.toLowerCase().equals(g2)) {
            String g3 = d.g("ZCUqO8ru60AnJTvdxNftwg==");
            if (TextUtils.isEmpty(g3) || !str.toLowerCase().equals(g3)) {
                String g4 = d.g("Sqo/G40afBQEk/ThxiHCDA==");
                if (!TextUtils.isEmpty(g4) && str.toLowerCase().equals(g4)) {
                    String k = k(context);
                    if (TextUtils.isEmpty(k)) {
                        return "";
                    }
                    jSONObject.put("joad", k);
                    return jSONObject.toString();
                }
                String g5 = d.g("Fl44OKc45ZSCqG4pxdgAdA==");
                if (!TextUtils.isEmpty(g5) && str.toLowerCase().equals(g5)) {
                    String i = i(context);
                    if (TextUtils.isEmpty(i)) {
                        return "";
                    }
                    jSONObject.put("joad", i);
                    return jSONObject.toString();
                }
                String g6 = d.g("v4ibuvMAw0xxYGyCW947bw==");
                String g7 = d.g("lJTl9z+ZycJlu+D6qavE9g==");
                if ((TextUtils.isEmpty(g6) || !str.toLowerCase().equals(g6)) && (TextUtils.isEmpty(g7) || !str.toLowerCase().equals(g7))) {
                    String g8 = d.g("7UUoz3VX0wN8BuYNQ77o2g==");
                    if (TextUtils.isEmpty(g8) || !str.toLowerCase().equals(g8)) {
                        String g9 = d.g("NftKgs8fjwuVYJ3VslncvA==");
                        String g10 = d.g("Wq1559o9+HHChTmry59Bkg==");
                        if ((!TextUtils.isEmpty(g9) && str.toLowerCase().equals(g9)) || (!TextUtils.isEmpty(g10) && str.toLowerCase().equals(g10))) {
                            String g11 = g(context);
                            if (TextUtils.isEmpty(g11)) {
                                return "";
                            }
                            jSONObject.put("joad", g11);
                            return jSONObject.toString();
                        }
                        String g12 = d.g("fmTCWm9ViPlyzM8H0bOrgw==");
                        if (!TextUtils.isEmpty(g12) && str.toLowerCase().equals(g12)) {
                            String m = m(context);
                            if (TextUtils.isEmpty(m)) {
                                return "";
                            }
                            jSONObject.put("joad", m);
                            return jSONObject.toString();
                        }
                        String g13 = d.g("bbyVCf9F4jMXWPUAeT3frw==");
                        if (!TextUtils.isEmpty(g13) && str.toLowerCase().equals(g13)) {
                            String o = o(context);
                            if (TextUtils.isEmpty(o)) {
                                return "";
                            }
                            jSONObject.put("joad", o);
                            return jSONObject.toString();
                        }
                        String g14 = d.g("0kbg5dLQpyr1z+M/7Qkp7A==");
                        if ((!TextUtils.isEmpty(g14) && str.toLowerCase().equals(g14)) || cn.jiguang.af.a.a()) {
                            String p = p(context);
                            if (TextUtils.isEmpty(p)) {
                                return "";
                            }
                            jSONObject.put("joad", p);
                            return jSONObject.toString();
                        }
                        String g15 = d.g("7kOXkVyi2CnACIIN3msOQg==");
                        if ((TextUtils.isEmpty(g15) || !str.toLowerCase().equals(g15)) && !cn.jiguang.af.a.b()) {
                            cn.jiguang.ak.a.d("IdHelper", "not supported this device: " + str);
                            return "";
                        }
                        String q = q(context);
                        if (TextUtils.isEmpty(q)) {
                            return "";
                        }
                        jSONObject.put("joad", q);
                        return jSONObject.toString();
                    }
                    return h(context);
                }
                return j(context);
            }
            return l(context);
        }
        return n(context);
    }

    public static JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String d = d(context);
            cn.jiguang.ak.a.a("IdHelper", "[getAllIds] miit id is: " + d);
            if (TextUtils.isEmpty(d)) {
                String str = c.a.b;
                if (!TextUtils.isEmpty(str)) {
                    cn.jiguang.ak.a.a("IdHelper", "start getAllIds by local");
                    String a = a(context, str);
                    if (!TextUtils.isEmpty(a)) {
                        jSONObject = new JSONObject(a);
                    }
                }
            } else {
                jSONObject = new JSONObject(d);
            }
            String b = b(context);
            if (!TextUtils.isEmpty(b)) {
                jSONObject.put("jgad", b);
            }
            cn.jiguang.ak.a.a("IdHelper", "gaid: " + b);
            if (jSONObject.toString().equals("{}")) {
                return null;
            }
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("IdHelper", "[getAllIds] failed：" + th.getMessage());
            return null;
        }
    }

    private static boolean a() {
        try {
            Class<?> cls = Class.forName(d.g("PcAdtsBZRJNo5a0tkYAln7JmiO95myc4NXXWf+j90/KXOpD1MlJOBugPF6SmMTLe"));
            cn.jiguang.ak.a.a("IdHelper", "MdidSdkHelper name:" + cls.getName());
            return true;
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("IdHelper", "not found mitt class" + th);
            return false;
        }
    }

    public static String b(Context context) {
        try {
            return e(context);
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("IdHelper", "getGoogleAdid failed:" + th.getMessage());
            return "";
        }
    }

    private static boolean b() {
        try {
            return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("IdHelper", "[isMainThread] failed:" + th.getMessage());
            return true;
        }
    }

    private static String c(Context context) {
        try {
            Class.forName(d.g("PcAdtsBZRJNo5a0tkYAln5KxAHXeXV/NVUuFAGa7lw0lgssd4d8qhC10P370VkfX"));
            FutureTask futureTask = new FutureTask(new cn.jiguang.y.a(context));
            d.b(futureTask);
            return (String) futureTask.get(2L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("IdHelper", "getMittIds by version 10 failed:" + th);
            try {
                Class.forName(d.g("KbEOJC6hqkBcbuUrDsdaXOUofElYAGZhekK9mozUIHGMGWMoSFaqAoiWtoXrQsHy"));
                FutureTask futureTask2 = new FutureTask(new cn.jiguang.z.a(context));
                d.b(futureTask2);
                return (String) futureTask2.get(2L, TimeUnit.SECONDS);
            } catch (Throwable th2) {
                cn.jiguang.ak.a.d("IdHelper", "getMittIds by version 13 failed:" + th2);
                return "";
            }
        }
    }

    private static String d(Context context) {
        if (b()) {
            cn.jiguang.ak.a.d("IdHelper", "not get id in main thread");
            return "";
        }
        if (a()) {
            String c = c(context);
            if (!TextUtils.isEmpty(c)) {
                return c;
            }
            cn.jiguang.ak.a.d("IdHelper", "not get ids by mitts");
        }
        return "";
    }

    private static String e(Context context) {
        String str;
        String g;
        if (b()) {
            str = "not get id in main thread";
        } else {
            try {
                String g2 = d.g("83JmFPusB5CQP/HtGWAx9pgfJZgEDCaE2wJbKIZa8GM=");
                if (TextUtils.isEmpty(g2)) {
                    return "";
                }
                context.getPackageManager().getPackageInfo(g2, 0);
                try {
                    g = d.g("+Fc+/S0DV5xukan0E/9N4RvXQpEI8h8+6y3k9NAvwjLhqIYeN+juscczCl6Sq6PxwLAq9CdDlLtmxsbD83akRg==");
                } catch (Throwable th) {
                    cn.jiguang.ak.a.d("IdHelper", "google getAdvertisingIdInfo Exception: " + th.toString());
                }
                if (TextUtils.isEmpty(g)) {
                    return "";
                }
                Intent intent = new Intent(g);
                String g3 = d.g("+Fc+/S0DV5xukan0E/9N4VArQdi8pEVBp8UquAC8VbE=");
                if (TextUtils.isEmpty(g3)) {
                    return "";
                }
                intent.setPackage(g3);
                b bVar = new b();
                if (!context.bindService(intent, bVar, 1)) {
                    cn.jiguang.ak.a.d("IdHelper", "google service bind failed");
                    return "";
                } else if (bVar.a) {
                    cn.jiguang.ak.a.d("IdHelper", "google service repeat bind");
                    context.unbindService(bVar);
                    return "";
                } else {
                    String a = new cn.jiguang.v.a(bVar.b.take()).a();
                    cn.jiguang.ak.a.a("IdHelper", "google ad id:" + a);
                    context.unbindService(bVar);
                    return a;
                }
            } catch (Throwable unused) {
                str = "not supported google";
            }
        }
        cn.jiguang.ak.a.d("IdHelper", str);
        return "";
    }

    private static String f(Context context) {
        String g;
        if (context == null) {
            return "";
        }
        try {
            String g2 = d.g("CV+BUnOM9r9hBWkUu5oSnA==");
            if (TextUtils.isEmpty(g2)) {
                return "";
            }
            context.getPackageManager().getPackageInfo(g2, 0);
            try {
                g = d.g("axDZqud6H+CDQBXA/yBXOiEPy9gW6px8eLENPXdBlBHSZeanEgWxhi72s58AM6wZ");
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("IdHelper", "hw getAdvertisingIdInfo Exception: " + th.toString());
            }
            if (TextUtils.isEmpty(g)) {
                return "";
            }
            Intent intent = new Intent(g);
            intent.setPackage(g2);
            cn.jiguang.w.b bVar = new cn.jiguang.w.b();
            boolean bindService = context.bindService(intent, bVar, 1);
            if (!bindService) {
                cn.jiguang.ak.a.d("IdHelper", "hw service bind failed");
                return "";
            }
            String a = new cn.jiguang.w.a(bVar.a.take()).a();
            cn.jiguang.ak.a.a("IdHelper", "hw ids-o:" + a);
            if (bindService) {
                context.unbindService(bVar);
            }
            return a;
        } catch (Throwable unused) {
            cn.jiguang.ak.a.d("IdHelper", "not supported hw");
            return "";
        }
    }

    private static String g(Context context) {
        String g;
        try {
            String g2 = d.g("Mpy0fkBSw1N+kug2cBPj2YJ2JkldBoT0Hj8EbMwXMGU=");
            if (TextUtils.isEmpty(g2)) {
                return "";
            }
            context.getPackageManager().getPackageInfo(g2, 0);
            try {
                g = d.g("Mpy0fkBSw1N+kug2cBPj2dTFEwqSue3aUHyxqBhF0BWQuC1TiTYwRmpXbBFYowSK");
            } catch (Exception e) {
                cn.jiguang.ak.a.d("IdHelper", "zui getAdvertisingIdInfo Exception: " + e.toString());
            }
            if (TextUtils.isEmpty(g)) {
                return "";
            }
            Intent intent = new Intent(g);
            intent.setPackage(g2);
            cn.jiguang.ag.b bVar = new cn.jiguang.ag.b();
            boolean bindService = context.bindService(intent, bVar, 1);
            if (!bindService) {
                cn.jiguang.ak.a.d("IdHelper", "zui service bind failed");
                return "";
            }
            String a = new cn.jiguang.ag.a(bVar.a.take()).a();
            cn.jiguang.ak.a.a("IdHelper", "zui ids-oa:" + a);
            if (bindService) {
                context.unbindService(bVar);
            }
            return a;
        } catch (Throwable unused) {
            cn.jiguang.ak.a.d("IdHelper", "package com.zui.deviceidservice not found ");
            return "";
        }
    }

    private static String h(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            cn.jiguang.aa.b bVar = new cn.jiguang.aa.b(context);
            String b = bVar.b();
            String c = bVar.c();
            String a = bVar.a();
            if (!TextUtils.isEmpty(b)) {
                jSONObject.put("joad", b);
            }
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put("jvad", c);
            }
            if (!TextUtils.isEmpty(a)) {
                jSONObject.put("jaad", a);
            }
        } catch (JSONException e) {
            cn.jiguang.ak.a.d("IdHelper", "getNubiaIds err: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    private static String i(Context context) {
        String g;
        try {
            String g2 = d.g("NZZdxIY39aBpJdeuRJ0VLp5xPlLZJqfiSSPak26ACVtSyGK74B1pfv+DoniV/u8H");
            if (TextUtils.isEmpty(g2)) {
                return "";
            }
            if (context.getPackageManager().getPackageInfo(g2, 0) == null) {
                cn.jiguang.ak.a.d("IdHelper", "sumsung not support");
                return "";
            }
            try {
                g = d.g("NZZdxIY39aBpJdeuRJ0VLp5xPlLZJqfiSSPak26ACVsaSg3goTgfCOA0dOFWjVLPc7dVv4XHGL0Dk7MQTYMVQw==");
            } catch (Exception e) {
                cn.jiguang.ak.a.d("IdHelper", "sumsung getAdvertisingIdInfo Exception: " + e.toString());
            }
            if (TextUtils.isEmpty(g)) {
                return "";
            }
            Intent intent = new Intent();
            intent.setClassName(g2, g);
            cn.jiguang.ac.b bVar = new cn.jiguang.ac.b();
            boolean bindService = context.bindService(intent, bVar, 1);
            if (!bindService) {
                cn.jiguang.ak.a.d("IdHelper", "sumsung service bind failed");
                return "";
            }
            String a = new cn.jiguang.ac.a(bVar.a.take()).a(context);
            cn.jiguang.ak.a.a("IdHelper", "sumsuang ids-oa:" + a);
            if (bindService) {
                context.unbindService(bVar);
            }
            return a;
        } catch (PackageManager.NameNotFoundException unused) {
            cn.jiguang.ak.a.d("IdHelper", "package com.samsung.android.deviceidservice not found");
            return "";
        }
    }

    private static String j(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            cn.jiguang.x.c cVar = new cn.jiguang.x.c(context);
            String b = cVar.b();
            String c = cVar.c();
            String a = cVar.a();
            if (!TextUtils.isEmpty(b)) {
                jSONObject.put("joad", b);
            }
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put("jvad", c);
            }
            if (!TextUtils.isEmpty(a)) {
                jSONObject.put("jaad", a);
            }
        } catch (JSONException e) {
            cn.jiguang.ak.a.d("IdHelper", "getVivoIds err: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    private static String k(Context context) {
        String g;
        try {
            String g2 = d.g("qFFOesfckPwVmbfqzGl5oG9IMWwJa4PjDfKEUokUsrU=");
            if (TextUtils.isEmpty(g2)) {
                return "";
            }
            boolean z = false;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(g2, 0);
            if (packageInfo == null) {
                cn.jiguang.ak.a.d("IdHelper", "oppo get package info is null");
                return "";
            }
            if (Build.VERSION.SDK_INT < 28 ? packageInfo.versionCode >= 1 : packageInfo.getLongVersionCode() >= 1) {
                z = true;
            }
            if (!z) {
                cn.jiguang.ak.a.a("IdHelper", "oppo not support above version 28");
                return "";
            }
            try {
                g = d.g("qFFOesfckPwVmbfqzGl5oOMkBF5tSSPHMYAiT/owwSwoCrUg5HXoJRYDJrCupV3K");
            } catch (Exception e) {
                cn.jiguang.ak.a.d("IdHelper", "oppo getAdvertisingIdInfo Exception: " + e.toString());
            }
            if (TextUtils.isEmpty(g)) {
                return "";
            }
            Intent intent = new Intent(g);
            intent.setPackage(g2);
            String g3 = d.g("/3gurUKcGzqF8/YMsL45D9RvCsSd5y5lQDTuvU2S5vtG2aMIkkluUNr+NKF2loi0");
            if (TextUtils.isEmpty(g3)) {
                return "";
            }
            intent.setAction(g3);
            cn.jiguang.ab.b bVar = new cn.jiguang.ab.b();
            boolean bindService = context.bindService(intent, bVar, 1);
            if (!bindService) {
                cn.jiguang.ak.a.d("IdHelper", "oppo service bind failed");
                return "";
            }
            String a = new cn.jiguang.ab.a(bVar.a.take()).a(context);
            cn.jiguang.ak.a.a("IdHelper", "oppo ids-oa: " + a);
            if (bindService) {
                context.unbindService(bVar);
            }
            return a;
        } catch (PackageManager.NameNotFoundException unused) {
            cn.jiguang.ak.a.d("IdHelper", "package com.heytap.openid not found");
            return "";
        }
    }

    private static String l(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            cn.jiguang.ad.c cVar = new cn.jiguang.ad.c(context);
            cVar.a("");
            String b = cVar.b();
            String c = cVar.c();
            String a = cVar.a();
            if (!TextUtils.isEmpty(b)) {
                jSONObject.put("joad", b);
            }
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put("jvad", c);
            }
            if (!TextUtils.isEmpty(a)) {
                jSONObject.put("jaad", a);
            }
        } catch (JSONException e) {
            cn.jiguang.ak.a.d("IdHelper", "getVivoIds err: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    private static String m(Context context) {
        String g;
        if (context == null) {
            return "";
        }
        try {
            g = d.g("AVy8x+cBVze9OKJHZKioHyNDBGqtEllVM4dvG69zMJc=");
        } catch (Exception e) {
            cn.jiguang.ak.a.d("IdHelper", "asus getAdvertisingIdInfo Exception: " + e.toString());
        }
        if (TextUtils.isEmpty(g)) {
            return "";
        }
        Intent intent = new Intent(g);
        String g2 = d.g("8lAhWp7NB89J3VIJU4lIGQtLf0YkfPcfFvWDnnGUuiQ=");
        if (TextUtils.isEmpty(g2)) {
            return "";
        }
        String g3 = d.g("8lAhWp7NB89J3VIJU4lIGQnPwmB8zgbENyN+gUA8dpRI7pO4GGAXufB+HCPmLRg7bL9N6o9V3Rxxk98J3lyy6g==");
        if (TextUtils.isEmpty(g3)) {
            return "";
        }
        ComponentName componentName = new ComponentName(g2, g3);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        cn.jiguang.ak.a.c("IdHelper", "start to bind did service.");
        cn.jiguang.u.b bVar = new cn.jiguang.u.b();
        boolean bindService = context.bindService(intent2, bVar, 1);
        if (bindService) {
            String a = new cn.jiguang.u.a(bVar.a.take()).a();
            cn.jiguang.ak.a.a("IdHelper", "asus ids-oa; " + a);
            if (bindService) {
                cn.jiguang.ak.a.c("IdHelper", "start to unbind did service");
                context.unbindService(bVar);
            }
            return a;
        }
        return "";
    }

    private static String n(Context context) {
        return cn.jiguang.ae.a.a(context);
    }

    private static String o(Context context) {
        return new cn.jiguang.af.b(context).a();
    }

    private static String p(Context context) {
        return new cn.jiguang.af.b(context).a();
    }

    private static String q(Context context) {
        return new cn.jiguang.af.b(context).a();
    }
}
