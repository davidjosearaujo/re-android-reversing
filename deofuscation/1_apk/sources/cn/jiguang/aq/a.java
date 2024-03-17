package cn.jiguang.aq;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.f.g;
import cn.jiguang.internal.JConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static String a = "";
    private static String b;
    private static Boolean c;
    private static Pair<String, Integer> d;
    private static final ArrayList<String> e;
    private static final ArrayList<String> f;
    private static final ArrayList<String> g;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        e = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        f = arrayList2;
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList2.add("android.permission.WAKE_LOCK");
        arrayList2.add("android.permission.VIBRATE");
        arrayList2.add("android.permission.CHANGE_WIFI_STATE");
        arrayList2.add("android.permission.WRITE_EXTERNAL_STORAGE");
        ArrayList<String> arrayList3 = new ArrayList<>();
        g = arrayList3;
        arrayList3.add("android.permission.ACCESS_FINE_LOCATION");
        arrayList3.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList3.add("android.permission.ACCESS_LOCATION_EXTRA_COMMANDS");
        arrayList3.add("android.permission.ACCESS_WIFI_STATE");
    }

    public static String a(Context context) {
        try {
            if (c == null && !TextUtils.isEmpty(JConstants.APP_KEY)) {
                return JConstants.APP_KEY;
            }
        } catch (Throwable unused) {
            c = Boolean.FALSE;
        }
        b(context);
        return a;
    }

    public static String a(Bundle bundle, String str) {
        Object obj;
        if (bundle == null || (obj = bundle.get(str)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static void a(Context context, String str) {
        b = str;
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.l().a((cn.jiguang.g.a<String>) str));
        c(context);
    }

    public static String b(Context context) {
        Bundle bundle;
        if (TextUtils.isEmpty(a)) {
            if (TextUtils.isEmpty(a)) {
                try {
                    if (context != null) {
                        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                            String a2 = a(bundle, "JPUSH_APPKEY");
                            a = a2;
                            if (!TextUtils.isEmpty(a2)) {
                                a = a.toLowerCase(Locale.getDefault());
                            }
                        }
                    } else {
                        cn.jiguang.ar.c.c("CheckManifestHelper", "[getAppKey] context is null");
                    }
                } catch (Throwable unused) {
                }
            }
            return a;
        }
        return a;
    }

    public static String c(Context context) {
        StringBuilder sb;
        Bundle bundle;
        if (b == null && context != null) {
            try {
                String c2 = cn.jiguang.d.a.c(context);
                b = c2;
                if (c2 != null) {
                    sb = new StringBuilder();
                    sb.append("get option channel - ");
                    sb.append(b);
                } else {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                        String a2 = a(bundle, "JPUSH_CHANNEL");
                        b = a2;
                        if (!TextUtils.isEmpty(a2)) {
                            b = g.b(b);
                        }
                    }
                    sb = new StringBuilder();
                    sb.append("manifest:channel - ");
                    sb.append(b);
                }
                cn.jiguang.ar.c.d("CheckManifestHelper", sb.toString());
            } catch (Throwable unused) {
            }
        }
        return b;
    }

    public static Pair<String, Integer> d(Context context) {
        if (d == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                String str = packageInfo.versionName;
                if (str != null && str.length() > 30) {
                    str = str.substring(0, 30);
                }
                d = new Pair<>(str, Integer.valueOf(packageInfo.versionCode));
            } catch (Throwable unused) {
                cn.jiguang.ar.c.d("CheckManifestHelper", "NO versionCode or versionName defined in manifest.");
            }
        }
        return d;
    }

    public static boolean e(Context context) {
        String str;
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            cn.jiguang.ar.c.j("CheckManifestHelper", "errorcode:10001,metadata: JCore appKey - not defined in manifest");
            str = " 未在manifest中配置AppKey";
        } else if (a2.length() == 24) {
            return true;
        } else {
            cn.jiguang.ar.c.j("CheckManifestHelper", "errorcode:1008,Invalid appKey : " + a2 + ", Please get your Appkey from JIGUANG web console!");
            str = " AppKey:" + a2 + " 是无效的AppKey,请确认与JIGUANG web端的AppKey一致";
        }
        cn.jiguang.f.a.a(context, str, -1);
        return false;
    }

    public static boolean f(Context context) {
        StringBuilder sb;
        c(context);
        if (c.a().c() || c.a().b()) {
            String str = context.getPackageName() + cn.jiguang.a.a.a;
            if (!cn.jiguang.f.a.i(context, str)) {
                sb = new StringBuilder();
                sb.append("The permission should be defined - ");
                sb.append(str);
                cn.jiguang.ar.c.j("CheckManifestHelper", sb.toString());
                return false;
            }
            e.add(str);
        }
        Iterator<String> it = e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!cn.jiguang.f.a.c(context, next)) {
                sb = new StringBuilder();
                sb.append("The permissoin is required - ");
                sb.append(next);
                cn.jiguang.ar.c.j("CheckManifestHelper", sb.toString());
                return false;
            }
        }
        Iterator<String> it2 = f.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (!cn.jiguang.f.a.i(context, next2)) {
                cn.jiguang.ar.c.g("CheckManifestHelper", "We recommend you add the permission - " + next2);
            }
        }
        Iterator<String> it3 = g.iterator();
        while (it3.hasNext()) {
            String next3 = it3.next();
            if (!cn.jiguang.f.a.i(context, next3)) {
                cn.jiguang.ar.c.g("CheckManifestHelper", "We recommend you add the permission - " + next3 + ", otherwise you can not locate the devices.");
            }
        }
        return true;
    }
}
