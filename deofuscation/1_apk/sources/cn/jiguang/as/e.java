package cn.jiguang.as;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.f.h;
import cn.jiguang.internal.JConstants;
import cn.jiguang.n.c;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e {
    private static a a;
    private static volatile FutureTask<?> b;
    private static final Object c = new Object();
    private static final LinkedHashSet<String> d;
    private static final String e;
    private static final LinkedHashSet<String> f;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends cn.jiguang.be.b {
        private final Context a;

        private a(Context context) {
            this.a = context;
            this.h = "SisTask";
        }

        @Override // cn.jiguang.be.b
        public void a() {
            try {
                String c = e.c(this.a);
                LinkedHashSet d = e.d(this.a);
                d.addAll(e.a());
                cn.jiguang.ar.c.c("ReportSis", "sis urls=" + d.toString() + " post json=" + c);
                if (!cn.jiguang.f.a.d(this.a)) {
                    cn.jiguang.ar.c.g("ReportSis", "give up sis, because network is not connected");
                    return;
                }
                Iterator it = d.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!TextUtils.isEmpty(str)) {
                        if (Build.VERSION.SDK_INT >= 28 && !str.startsWith(c.a.d)) {
                            cn.jiguang.ar.c.g("ReportSis", "won't use http at device since 28");
                        } else if (e.b(this.a, str, c)) {
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    static {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        d = linkedHashSet;
        String b2 = cn.jiguang.r.a.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 68, 83, 112, 123, 56, 123, 64, 85, 106, 96, 56, 114, 94});
        e = b2;
        linkedHashSet.add(b2);
        f = new LinkedHashSet<>();
    }

    public static LinkedHashSet<String> a() {
        if (JConstants.isTestEnv()) {
            LinkedHashSet<String> linkedHashSet = f;
            if (!linkedHashSet.isEmpty()) {
                return linkedHashSet;
            }
        }
        return d;
    }

    public static void a(Context context, boolean z) {
        String str;
        StringBuilder sb;
        if (a == null) {
            a = new a(context);
        }
        if (b == null || b.isCancelled() || b.isDone()) {
            synchronized (c) {
                if (b == null || b.isCancelled() || b.isDone()) {
                    b = new FutureTask<>(a, null);
                    cn.jiguang.be.d.a("FUTURE_TASK", b);
                }
            }
        }
        if (z) {
            try {
                b.get(10L, TimeUnit.SECONDS);
            } catch (InterruptedException e2) {
                e = e2;
                str = "ReportSis";
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.ar.c.g(str, sb.toString());
            } catch (ExecutionException e3) {
                e = e3;
                str = "ReportSis";
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.ar.c.g(str, sb.toString());
            } catch (TimeoutException e4) {
                e = e4;
                str = "ReportSis";
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.ar.c.g(str, sb.toString());
            } catch (Throwable th) {
                e = th;
                str = "ReportSis";
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.ar.c.g(str, sb.toString());
            }
        }
    }

    public static boolean b(Context context, String str, String str2) {
        g a2 = b.a(str, str2, context, true, 3, 2);
        cn.jiguang.ar.c.c("ReportSis", "report sis code[" + a2.a() + "] from url=" + str + "\n body=" + a2.b());
        if (a2.a() == 0) {
            String b2 = a2.b();
            if (TextUtils.isEmpty(b2)) {
                return false;
            }
            try {
                cn.jiguang.as.a.a().a(context, new JSONObject(b2).getJSONObject("ret"));
                return true;
            } catch (Throwable th) {
                cn.jiguang.ar.c.g("ReportSis", "getUrls e:" + th);
                return false;
            }
        }
        return false;
    }

    public static String c(Context context) {
        long j;
        Object a2;
        double d2;
        double d3;
        JSONObject jSONObject = new JSONObject();
        try {
            String e2 = cn.jiguang.d.a.e(context);
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c())).longValue();
            int a3 = h.a(context);
            String b2 = h.b(context);
            jSONObject.put("type", a3);
            jSONObject.put(com.alipay.sdk.sys.a.o, e2);
            jSONObject.put("sdkver", cn.jiguang.a.a.b);
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, 0);
            j = 0;
            if (longValue != 0) {
                jSONObject.put(CommonConstant.KEY_UID, longValue);
            }
            if (b2 != null) {
                jSONObject.put("opera", b2);
            }
            a2 = cn.jiguang.ax.e.a(context, "get_loc_info", null);
            d2 = 200.0d;
        } catch (Throwable unused) {
        }
        if (a2 instanceof Bundle) {
            try {
                Bundle bundle = (Bundle) a2;
                double d4 = bundle.getDouble("lat");
                try {
                    d2 = bundle.getDouble("lot");
                    j = bundle.getLong(CrashHianalyticsData.TIME);
                } catch (Throwable unused2) {
                }
                double d5 = d2;
                d2 = d4;
                d3 = d5;
            } catch (Throwable unused3) {
            }
            if (d2 > -90.0d && d2 < 90.0d && d3 > -180.0d && d3 < 180.0d) {
                jSONObject.put("lat", d2);
                jSONObject.put("lng", d3);
                jSONObject.put(CrashHianalyticsData.TIME, j);
            }
            return jSONObject.toString();
        }
        d3 = 200.0d;
        if (d2 > -90.0d) {
            jSONObject.put("lat", d2);
            jSONObject.put("lng", d3);
            jSONObject.put(CrashHianalyticsData.TIME, j);
        }
        return jSONObject.toString();
    }

    public static LinkedHashSet<String> d(Context context) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.t());
        if (TextUtils.isEmpty(str)) {
            return linkedHashSet;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedHashSet.add(jSONArray.optString(i));
            }
        } catch (JSONException unused) {
        }
        return linkedHashSet;
    }
}
