package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.ConditionVariable;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.g;
import com.alipay.sdk.util.l;
import com.hunantv.imgo.log.MLog;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    public static final String d = "virtualImeiAndImsi";
    public static final String e = "virtual_imei";
    public static final String f = "virtual_imsi";
    public static volatile b g;
    public String a;
    public String b = "sdk-and-lite";
    public String c;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a implements APSecuritySdk.InitResultListener {
        public final /* synthetic */ String[] a;
        public final /* synthetic */ ConditionVariable b;

        public a(String[] strArr, ConditionVariable conditionVariable) {
            this.a = strArr;
            this.b = conditionVariable;
        }

        @Override // com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener
        public void onResult(APSecuritySdk.TokenResult tokenResult) {
            if (tokenResult != null) {
                this.a[0] = tokenResult.apdidToken;
            }
            this.b.open();
        }
    }

    /* renamed from: com.alipay.sdk.data.b$b  reason: collision with other inner class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class CallableC0028b implements Callable<String> {
        public final /* synthetic */ com.alipay.sdk.sys.a a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ HashMap c;

        public CallableC0028b(com.alipay.sdk.sys.a aVar, Context context, HashMap hashMap) {
            this.a = aVar;
            this.b = context;
            this.c = hashMap;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            return b.c(this.a, this.b, this.c);
        }
    }

    public b() {
        String a2 = com.alipay.sdk.app.a.a();
        if (com.alipay.sdk.app.a.b()) {
            return;
        }
        this.b += '_' + a2;
    }

    public static synchronized b b() {
        b bVar;
        synchronized (b.class) {
            if (g == null) {
                g = new b();
            }
            bVar = g;
        }
        return bVar;
    }

    public static String c() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        return hexString + (random.nextInt(9000) + 1000);
    }

    public static String d() {
        return "-1;-1";
    }

    public static String d(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getSSID() : "-1";
    }

    public static String e() {
        return "1";
    }

    public static String f() {
        String b;
        Context b2 = com.alipay.sdk.sys.b.d().b();
        SharedPreferences sharedPreferences = b2.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(e, null);
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(com.alipay.sdk.tid.a.a(b2).d())) {
                b = c();
            } else {
                b = com.alipay.sdk.util.a.b(b2).b();
            }
            String str = b;
            sharedPreferences.edit().putString(e, str).apply();
            return str;
        }
        return string;
    }

    public static String g() {
        String c;
        Context b = com.alipay.sdk.sys.b.d().b();
        SharedPreferences sharedPreferences = b.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(f, null);
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(com.alipay.sdk.tid.a.a(b).d())) {
                String c2 = com.alipay.sdk.sys.b.d().c();
                if (!TextUtils.isEmpty(c2) && c2.length() >= 18) {
                    c = c2.substring(3, 18);
                } else {
                    c = c();
                }
            } else {
                c = com.alipay.sdk.util.a.b(b).c();
            }
            String str = c;
            sharedPreferences.edit().putString(f, str).apply();
            return str;
        }
        return string;
    }

    public String a() {
        return this.c;
    }

    public static synchronized void a(String str) {
        synchronized (b.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.sys.b.d().b()).edit().putString(com.alipay.sdk.cons.b.i, str).apply();
            com.alipay.sdk.cons.a.e = str;
        }
    }

    public static String b(com.alipay.sdk.sys.a aVar, Context context, HashMap<String, String> hashMap) {
        try {
            return (String) Executors.newFixedThreadPool(2).submit(new CallableC0028b(aVar, context, hashMap)).get(PayTask.j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.o, com.alipay.sdk.app.statistic.b.u, th);
            return "";
        }
    }

    public static String c(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getBSSID() : MLog.a.b;
    }

    public static String a(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    public static String b(Context context) {
        if (context != null) {
            try {
                StringBuilder sb = new StringBuilder();
                String packageName = context.getPackageName();
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                sb.append("(");
                sb.append(packageName);
                sb.append(g.b);
                sb.append(packageInfo.versionCode);
                sb.append(")");
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return "";
    }

    public static String c(com.alipay.sdk.sys.a aVar, Context context, HashMap<String, String> hashMap) {
        String[] strArr = {""};
        try {
            APSecuritySdk aPSecuritySdk = APSecuritySdk.getInstance(context);
            ConditionVariable conditionVariable = new ConditionVariable();
            aPSecuritySdk.initToken(0, hashMap, new a(strArr, conditionVariable));
            conditionVariable.block(PayTask.j);
        } catch (Throwable th) {
            c.a(th);
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.o, com.alipay.sdk.app.statistic.b.s, th);
        }
        if (TextUtils.isEmpty(strArr[0])) {
            com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.b.o, com.alipay.sdk.app.statistic.b.t, "missing token");
        }
        c.b(com.alipay.sdk.cons.a.x, "ap:" + strArr[0]);
        return strArr[0];
    }

    public String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.tid.a aVar2) {
        Context b = com.alipay.sdk.sys.b.d().b();
        com.alipay.sdk.util.a b2 = com.alipay.sdk.util.a.b(b);
        if (TextUtils.isEmpty(this.a)) {
            String e2 = l.e();
            String d2 = l.d();
            String c = l.c(b);
            String e3 = l.e(b);
            String f2 = l.f(b);
            String a2 = a(b);
            this.a = "Msp/15.8.02 (" + e2 + g.b + d2 + g.b + c + g.b + e3 + g.b + f2 + g.b + a2;
        }
        String b3 = com.alipay.sdk.util.a.d(b).b();
        String b4 = l.b(b);
        String e4 = e();
        String c2 = b2.c();
        String b5 = b2.b();
        String g2 = g();
        String f3 = f();
        if (aVar2 != null) {
            this.c = aVar2.c();
        }
        String replace = Build.MANUFACTURER.replace(g.b, " ");
        String replace2 = Build.MODEL.replace(g.b, " ");
        boolean e5 = com.alipay.sdk.sys.b.e();
        String d3 = b2.d();
        String d4 = d(b);
        String c3 = c(b);
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(g.b);
        sb.append(b3);
        sb.append(g.b);
        sb.append(b4);
        sb.append(g.b);
        sb.append(e4);
        sb.append(g.b);
        sb.append(c2);
        sb.append(g.b);
        sb.append(b5);
        sb.append(g.b);
        sb.append(this.c);
        sb.append(g.b);
        sb.append(replace);
        sb.append(g.b);
        sb.append(replace2);
        sb.append(g.b);
        sb.append(e5);
        sb.append(g.b);
        sb.append(d3);
        sb.append(g.b);
        sb.append(d());
        sb.append(g.b);
        sb.append(this.b);
        sb.append(g.b);
        sb.append(g2);
        sb.append(g.b);
        sb.append(f3);
        sb.append(g.b);
        sb.append(d4);
        sb.append(g.b);
        sb.append(c3);
        if (aVar2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("tid", com.alipay.sdk.tid.a.a(b).d());
            hashMap.put(com.alipay.sdk.cons.b.g, com.alipay.sdk.sys.b.d().c());
            String b6 = b(aVar, b, hashMap);
            if (!TextUtils.isEmpty(b6)) {
                sb.append(";;;");
                sb.append(b6);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
