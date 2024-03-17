package cn.jiguang.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.analytics.page.ActivityLifecycle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.ar.c;
import cn.jiguang.f.g;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import com.facebook.appevents.UserDataStore;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    public static Object a() {
        return ActionManager.getActionMap();
    }

    public static JSONObject a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                c.c("JBridgeHelper", "file_name is null , give up read ");
                return null;
            }
            String d = cn.jiguang.f.c.d(cn.jiguang.f.c.a(context, str));
            if (g.a(d)) {
                c.c("JBridgeHelper", "read String is empty");
                return null;
            }
            return new JSONObject(d.trim());
        } catch (Throwable th) {
            c.c("JBridgeHelper", "can't build " + str + " into JsonObject, give up read :" + th);
            return null;
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("itime", b.b(context));
            jSONObject.put("type", str);
            jSONObject.put("account_id", cn.jiguang.g.b.a(context, cn.jiguang.g.a.m()));
        } catch (JSONException e) {
            c.g("JBridgeHelper", "fillBase exception:" + e);
        }
        return jSONObject;
    }

    public static synchronized void a(Context context) {
        String str;
        String str2;
        synchronized (a.class) {
            try {
                if (JConstants.isInstrumentationHookFailed && Build.VERSION.SDK_INT >= 14 && (context instanceof Application)) {
                    String a = cn.jiguang.f.a.a(context);
                    String packageName = context.getPackageName();
                    if (a == null || packageName == null || !context.getPackageName().equals(a)) {
                        str = "JBridgeHelper";
                        str2 = "need not registerActivityLifecycleCallbacks in other process :" + a;
                    } else {
                        JConstants.isInstrumentationHookFailed = false;
                        ActivityLifecycle activityLifecycle = new ActivityLifecycle();
                        ((Application) context).registerActivityLifecycleCallbacks(activityLifecycle);
                        Activity o = cn.jiguang.f.a.o(context);
                        if (o != null && ActivityLifecycle.activityTaskCount == 0) {
                            activityLifecycle.onActivityCreated(o, null);
                            activityLifecycle.onActivityStarted(o);
                            activityLifecycle.onActivityResumed(o);
                        }
                        str = "JBridgeHelper";
                        str2 = "registerActivityLifecycleCallbacks in main process,packageName:" + packageName + ",currentProcessName:" + a;
                    }
                    c.c(str, str2);
                }
            } finally {
            }
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent != null) {
            try {
                if ("asm".equals(intent.getAction())) {
                    JCoreManager.onEvent(context, JConstants.SDK_TYPE, 3, "asm", intent.getExtras(), new Object[0]);
                    return;
                }
            } catch (Throwable th) {
                c.g("JBridgeHelper", "shareActionRun error:" + th.getMessage());
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("shareActionRun intent error:");
        sb.append(intent == null ? "null" : intent.getAction());
        c.c("JBridgeHelper", sb.toString());
    }

    public static void a(Context context, Object obj) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 14, null, null, obj);
    }

    public static void a(String str, String str2) {
        ActionManager.addAction(str, str2);
    }

    public static String b(Context context) {
        return (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.d());
    }

    public static String c(Context context) {
        return (String) cn.jiguang.g.b.b(context, cn.jiguang.g.a.l());
    }

    public static String d(Context context) {
        return (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.m());
    }

    public static String e(Context context) {
        return cn.jiguang.aq.a.a(context);
    }

    public static long f(Context context) {
        return ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c())).longValue();
    }

    public static String g(Context context) {
        return cn.jiguang.aq.a.c(context);
    }

    public static String h(Context context) {
        return (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.a());
    }

    public static String i(Context context) {
        return (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.e());
    }

    public static Object j(Context context) {
        HashMap hashMap = new HashMap();
        long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.j())).longValue();
        int intValue = ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.k())).intValue();
        hashMap.put("uuid", (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.i()));
        hashMap.put(UserDataStore.CITY, Long.valueOf(longValue));
        hashMap.put("state", Integer.valueOf(intValue));
        return hashMap;
    }

    public static int k(Context context) {
        return ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.f())).intValue();
    }

    public static boolean l(Context context) {
        c.c("JBridgeHelper", "canShowLbsPermissionDialog");
        Boolean bool = (Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.z());
        if (bool != null && !bool.booleanValue()) {
            c.d("JBridgeHelper", "lbs disable");
            return false;
        }
        long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.y())).longValue();
        long longValue2 = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.x())).longValue();
        c.c("JBridgeHelper", "lbs permission dialog shield, firstInit=" + longValue2 + ", delay=" + longValue);
        if (longValue2 > 0) {
            return longValue <= 0 || System.currentTimeMillis() > longValue2 + longValue;
        }
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.x().a((cn.jiguang.g.a<Long>) Long.valueOf(System.currentTimeMillis())));
        return longValue <= 0;
    }

    public static int m(Context context) {
        return ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.k())).intValue();
    }
}
