package cn.jiguang.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.facebook.appevents.UserDataStore;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.sms.common.ReadSmsConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    private static SharedPreferences a;
    private static List<Integer> b;
    private static Map<Integer, JSONArray> c;
    private static a d;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        public String a = "";
        public Map<Integer, b> b = new HashMap();

        public void a() {
            this.a = "";
            this.b.clear();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class b {
        private int a;
        private boolean b;
        private int c;

        public void a(int i) {
            this.a = i;
        }

        public void a(boolean z) {
            this.b = z;
        }

        public boolean a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public void b(int i) {
            this.c = i;
        }

        public String toString() {
            return "ControlDataBody{ac=" + this.a + ", sw=" + this.b + ", ri=" + this.c + '}';
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        b = arrayList;
        c = null;
        d = null;
        arrayList.add(2021);
        b.add(Integer.valueOf((int) ReadSmsConstant.FAIL));
        b.add(2023);
        b.add(2025);
        b.add(Integer.valueOf((int) CommonConstant.RETCODE.INDEPENDENT_AUTH_NOT_ALLOW));
        b.add(2027);
        b.add(2028);
        b.add(2029);
        b.add(Integer.valueOf((int) CommonConstant.RETCODE.LOGOUT_REQUEST_SUCCESS));
    }

    private static long a(Context context, int i, long j) {
        SharedPreferences h = h(context);
        return h.getLong("KEY_JSON_DATA_TIME_" + i, j);
    }

    public static synchronized b a(Context context, int i) {
        b bVar;
        synchronized (c.class) {
            bVar = g(context).b.get(Integer.valueOf(i));
        }
        return bVar;
    }

    private static String a(Context context, int i, String str) {
        SharedPreferences h = h(context);
        return h.getString(i + "", str);
    }

    private static JSONArray a(JSONObject jSONObject, int i, JSONArray jSONArray) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (2021 != i || (optJSONObject = jSONArray.optJSONObject(jSONArray.length() - 1)) == null || (optJSONObject2 = optJSONObject.optJSONObject("extra")) == null || 1 != optJSONObject2.optInt("type")) {
            return jSONArray;
        }
        if (jSONObject.optLong("itime", 0L) - optJSONObject.optLong("itime", 0L) < 500) {
            if (Build.VERSION.SDK_INT >= 19) {
                jSONArray.remove(jSONArray.length() - 1);
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            for (int i2 = 0; i2 < jSONArray.length() - 1; i2++) {
                jSONArray2.put(jSONArray.opt(i2));
            }
            return jSONArray2;
        }
        return jSONArray;
    }

    public static synchronized void a(Context context) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        synchronized (c.class) {
            cn.jiguang.ar.c.c("JAnalyticsUtil", "sendAll");
            boolean b2 = b(context);
            cn.jiguang.ar.c.c("JAnalyticsUtil", "sendAll haveControlData:" + b2);
            if (b2) {
                for (int i = 0; i < b.size(); i++) {
                    Integer num = b.get(i);
                    cn.jiguang.ar.c.c("JAnalyticsUtil", "sendAll haveControlData code:" + num);
                    b a2 = a(context, num.intValue());
                    cn.jiguang.ar.c.c("JAnalyticsUtil", "sendAll haveControlData controlData:" + a2);
                    if (a2 != null && a2.a()) {
                        if (System.currentTimeMillis() - a(context, num.intValue(), 0L) >= a2.b() * 1000) {
                            JSONArray jSONArray = f(context).get(num);
                            cn.jiguang.ar.c.c("JAnalyticsUtil", "sendAll haveControlData jsonArray:" + jSONArray);
                            if (jSONArray != null) {
                                if (num.intValue() == 2021 && (optJSONObject = jSONArray.optJSONObject(jSONArray.length() - 1)) != null && (optJSONObject2 = optJSONObject.optJSONObject("extra")) != null && 1 == optJSONObject2.optInt("type")) {
                                    long optLong = optJSONObject.optLong("itime", 0L);
                                    if (System.currentTimeMillis() - optLong < AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS) {
                                        cn.jiguang.ar.c.c("JAnalyticsUtil", "sendAll haveControlData 2021 itime:" + optLong);
                                    }
                                }
                                cn.jiguang.ar.c.c("JAnalyticsUtil", "sendAll haveControlData report:" + jSONArray);
                                cn.jiguang.d.a.a(context, jSONArray);
                                f(context).remove(num);
                                a(context, num.intValue(), (JSONArray) null);
                                b(context, num.intValue());
                            }
                        }
                    }
                }
            }
        }
    }

    private static void a(Context context, int i, JSONArray jSONArray) {
        SharedPreferences.Editor edit = h(context).edit();
        if (jSONArray == null) {
            edit.remove(i + "");
        } else {
            edit.putString(i + "", jSONArray.toString());
        }
        edit.apply();
    }

    private static void a(Context context, Map<Integer, JSONArray> map) {
        for (int i = 0; i < b.size(); i++) {
            Integer num = b.get(i);
            String a2 = a(context, num.intValue(), (String) null);
            if (a2 != null) {
                try {
                    map.put(num, new JSONArray(a2));
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(Context context, JSONObject jSONObject) {
        synchronized (c.class) {
            a(context, jSONObject, true);
        }
    }

    public static synchronized void a(final Context context, JSONObject jSONObject, boolean z) {
        synchronized (c.class) {
            int optInt = jSONObject.optInt(JThirdPlatFormInterface.KEY_CODE);
            if (b(context)) {
                b a2 = a(context, optInt);
                if (a2 != null && a2.a()) {
                    JSONArray jSONArray = f(context).get(Integer.valueOf(optInt));
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                    }
                    JSONArray a3 = a(jSONObject, optInt, jSONArray);
                    f(context).put(Integer.valueOf(optInt), a3);
                    a3.put(jSONObject);
                    a(context, optInt, a3);
                }
                if (!z) {
                    return;
                }
                cn.jiguang.be.d.a("FUTURE_TASK", new cn.jiguang.be.b() { // from class: cn.jiguang.b.c.1
                    @Override // cn.jiguang.be.b
                    public void a() {
                        try {
                            c.a(context);
                        } catch (Throwable unused) {
                        }
                    }
                });
            } else if (2022 == optInt) {
                JSONArray jSONArray2 = f(context).get(Integer.valueOf(optInt));
                if (jSONArray2 == null) {
                    jSONArray2 = new JSONArray();
                }
                jSONArray2.put(jSONObject);
                a(context, optInt, jSONArray2);
            }
        }
    }

    public static void a(Context context, boolean z) {
        h(context).edit().putBoolean("KEY_INSTALL_FIRST_START_APP", z).apply();
    }

    private static synchronized void a(a aVar, JSONObject jSONObject) {
        synchronized (c.class) {
            aVar.a();
            if (jSONObject != null) {
                aVar.a = jSONObject.optString("sign", "");
                JSONArray optJSONArray = jSONObject.optJSONArray(UserDataStore.CITY);
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        int optInt = optJSONObject.optInt("ac", -1);
                        boolean optBoolean = optJSONObject.optBoolean("sw", false);
                        int optInt2 = optJSONObject.optInt("ri", -1);
                        b bVar = new b();
                        bVar.a(optInt);
                        bVar.a(optBoolean);
                        bVar.b(optInt2);
                        cn.jiguang.ar.c.c("JAnalyticsUtil", "setControlData :" + bVar);
                        aVar.b.put(Integer.valueOf(optInt), bVar);
                    }
                }
            }
        }
    }

    private static void b(Context context, int i) {
        SharedPreferences.Editor edit = h(context).edit();
        edit.putLong("KEY_JSON_DATA_TIME_" + i, System.currentTimeMillis());
        edit.apply();
    }

    public static synchronized void b(Context context, JSONObject jSONObject) {
        synchronized (c.class) {
            a(g(context), jSONObject);
            SharedPreferences h = h(context);
            (jSONObject != null ? h.edit().putString("KEY_JSON_DATA_CONTROL", jSONObject.toString()) : h.edit().remove("KEY_JSON_DATA_CONTROL")).apply();
        }
    }

    public static synchronized boolean b(Context context) {
        boolean z;
        synchronized (c.class) {
            z = !"".equals(h(context).getString("KEY_JSON_DATA_CONTROL", ""));
        }
        return z;
    }

    public static boolean b(Context context, boolean z) {
        return h(context).getBoolean("KEY_INSTALL_FIRST_START_APP", z);
    }

    public static synchronized String c(Context context) {
        String str;
        synchronized (c.class) {
            str = g(context).a;
        }
        return str;
    }

    public static long d(Context context) {
        return h(context).getLong("KEY_JSON_DATA_CONTROL_TIME", 0L);
    }

    public static void e(Context context) {
        h(context).edit().putLong("KEY_JSON_DATA_CONTROL_TIME", System.currentTimeMillis()).apply();
    }

    private static Map<Integer, JSONArray> f(Context context) {
        if (c == null) {
            HashMap hashMap = new HashMap();
            c = hashMap;
            a(context, hashMap);
        }
        return c;
    }

    private static a g(Context context) {
        if (d == null) {
            d = new a();
            String string = h(context).getString("KEY_JSON_DATA_CONTROL", "");
            try {
                cn.jiguang.ar.c.c("JAnalyticsUtil", "data control l:" + string);
                a(d, new JSONObject(string));
            } catch (Throwable unused) {
            }
        }
        return d;
    }

    private static SharedPreferences h(Context context) {
        if (a == null) {
            a = context.getSharedPreferences("cn.jiguang.analytics_push", 0);
        }
        return a;
    }
}
