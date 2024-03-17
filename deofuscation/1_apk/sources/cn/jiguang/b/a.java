package cn.jiguang.b;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.f.h;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.sms.common.ReadSmsConstant;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static long a;
    private static long b;

    private static JSONObject a(int i, String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(JThirdPlatFormInterface.KEY_CODE, i);
            if (str != null) {
                jSONObject2.put("msg", str);
            }
            if (jSONObject != null) {
                jSONObject2.put("extra", jSONObject);
            }
        } catch (Throwable unused) {
        }
        return jSONObject2;
    }

    private static JSONObject a(Context context, JSONObject jSONObject, boolean z) {
        if (z) {
            try {
                c(context);
            } catch (Throwable th) {
                cn.jiguang.ar.c.d("JAnylysis", "getContainer", th);
            }
        }
        boolean z2 = false;
        boolean z3 = 1 == h.a(context);
        String b2 = h.b(context);
        int d = h.d(context);
        long currentTimeMillis = (System.currentTimeMillis() - a) / 1000;
        boolean z4 = cn.jiguang.at.b.a;
        if (b != 0 && System.currentTimeMillis() - b <= 500) {
            z2 = true;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        jSONObject.put("type", "analysis_info");
        jSONObject.put("is_wifi", z3);
        jSONObject.put("oporater", b2);
        jSONObject.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, d);
        jSONObject.put("keep_time", currentTimeMillis);
        jSONObject.put("background", z4);
        jSONObject.put("is_first", z2);
        jSONObject.put("itime", currentTimeMillis2);
        jSONObject.put("os", "a");
        return jSONObject;
    }

    public static void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if ("".equals(cn.jiguang.ax.b.a().b(JPushConstants.SDK_TYPE, ""))) {
            cn.jiguang.ar.c.c("JAnylysis", "periodTask not jpush sdk");
        } else {
            b.a(applicationContext);
        }
    }

    public static void a(Context context, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i);
        } catch (Throwable unused) {
        }
        a(context, 2021, "Start the APP", jSONObject);
    }

    public static void a(Context context, int i, String str) {
        c.a(context, a(context, a(i, str, (JSONObject) null), false), false);
    }

    private static void a(Context context, int i, String str, JSONObject jSONObject) {
        a(context, a(i, str, jSONObject));
    }

    public static void a(Context context, Bundle bundle, Object obj) {
        JSONObject a2;
        try {
            if ("".equals(cn.jiguang.ax.b.a().b(JPushConstants.SDK_TYPE, ""))) {
                cn.jiguang.ar.c.c("JAnylysis", "save not jpush sdk");
                return;
            }
            Context applicationContext = context.getApplicationContext();
            int i = bundle.getInt(JThirdPlatFormInterface.KEY_CODE);
            String string = bundle.getString("msg");
            if (obj == null) {
                a2 = a(i, string, (JSONObject) null);
            } else if (!(obj instanceof JSONObject)) {
                return;
            } else {
                a2 = a(i, string, (JSONObject) obj);
            }
            a(applicationContext, a2);
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        JSONObject b2 = b(context, jSONObject);
        cn.jiguang.ar.c.c("JAnylysis", "may save json:" + jSONObject);
        c.a(context, b2);
    }

    private static JSONObject b(Context context, JSONObject jSONObject) {
        return a(context, jSONObject, true);
    }

    private static void b(Context context, int i, String str) {
        a(context, i, str, null);
    }

    public static boolean b(Context context) {
        return c.b(context, true);
    }

    public static synchronized void c(Context context) {
        synchronized (a.class) {
            if (0 != a) {
                return;
            }
            if (context.getPackageName().equals(cn.jiguang.f.a.a(context))) {
                a = System.currentTimeMillis();
                b.a(context);
                if (b(context)) {
                    b = System.currentTimeMillis();
                    c.a(context, false);
                    b(context, ReadSmsConstant.FAIL, "The APP activation");
                }
                a(context, 1);
            }
        }
    }

    public static void d(Context context) {
        b(context, CommonConstant.RETCODE.LOGOUT_REQUEST_SUCCESS, "Register success");
    }

    public static void e(Context context) {
        b(context, 2023, "Exit the APP");
    }
}
