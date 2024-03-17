package cn.jiguang.aq;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.f.i;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.hunantv.media.player.subtitle.MediaFormat;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private static String g;
    private static HashMap<String, Integer> h;
    private static List<String> i;
    private static int k;
    private static long l;
    private static final String a = cn.jiguang.r.a.b(new byte[]{59, 87, 87, 6, 101, 43, 62, 39, 85, 116, 16, 46, 74, 39, 32, 7, 19, 43, 57, 36, 40, 1, 21, 90, 78, 87, 82, 115, 24, 91, 77, 47});
    private static final String b = cn.jiguang.r.a.b(new byte[]{96, 98, 101, 64, 83, 35, 39, 57, 114, 95, 78, Byte.MAX_VALUE, 97, 113, 60, 90, 85, 119, 97, 121, Byte.MAX_VALUE, 30, 74, 105, 125, 101, 121, 30, 67, 119, 39, 96, 32, 31, 83, 105, 97, 122});
    private static String c = "";
    private static long d = 0;
    private static long e = 43200;
    private static AtomicBoolean f = null;
    private static String j = null;
    private static String m = ".pkg_idx_v390";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends cn.jiguang.be.b {
        public Context a;

        public a(Context context) {
            this.a = context;
            this.h = "AppListProbeConfig";
        }

        private static int a(Context context) {
            try {
                String a = cn.jiguang.aq.a.a(context);
                long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c())).longValue();
                if (!TextUtils.isEmpty(a) && longValue != 0) {
                    if (f.a()) {
                        cn.jiguang.ar.c.c("JAppListProbeHelper", "sdk is banned, not config request");
                        return -2;
                    }
                    cn.jiguang.ar.c.c("JAppListProbeHelper", "google play not request");
                    return -2;
                }
                cn.jiguang.ar.c.g("JAppListProbeHelper", "not request config, appkey is " + a + ", uid is " + longValue);
                return -2;
            } catch (Throwable th) {
                cn.jiguang.ar.c.g("JAppListProbeHelper", "request app list probe failed, " + th.getMessage());
                return -2;
            }
        }

        @Override // cn.jiguang.be.b
        public void a() {
            a(this.a);
        }
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            cn.jiguang.be.d.a("FUTURE_TASK", new a(context));
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            cn.jiguang.ar.c.g("JAppListProbeHelper", "unexpected error, context: " + context + ", contentJson: " + jSONObject);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("use_config");
        context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putBoolean("can_req_config", optBoolean).apply();
        f = new AtomicBoolean(optBoolean);
        cn.jiguang.ar.c.e("JAppListProbeHelper", "handle probe switch cmd, use_config: " + optBoolean);
    }

    public static String b(Context context) {
        if (context == null) {
            cn.jiguang.ar.c.g("JAppListProbeHelper", "unexpected error, context is null");
            return "";
        }
        try {
            HashMap<String, Integer> e2 = e(context);
            if (e2 != null && e2.size() > 0) {
                String str = "";
                for (String str2 : e2.keySet()) {
                    Integer num = e2.get(str2);
                    if (!TextUtils.isEmpty(str2) && num.intValue() > 0) {
                        str = str + num + "&" + str2 + "&&";
                    }
                }
                String substring = !TextUtils.isEmpty(str) ? str.substring(0, str.length() - 2) : str;
                cn.jiguang.ar.c.c("JAppListProbeHelper", "package index list: " + substring + ", old content: " + str);
                return substring;
            }
            cn.jiguang.ar.c.c("JAppListProbeHelper", "no cache package index");
            return "";
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("JAppListProbeHelper", "get package index list failed, " + th.getMessage());
            return "";
        }
    }

    public static String c(Context context) {
        if (context == null) {
            cn.jiguang.ar.c.g("JAppListProbeHelper", "unexpected error, context is null");
            return "";
        }
        try {
            HashMap<String, Integer> e2 = e(context);
            if (e2 != null && e2.size() > 0) {
                if (i == null || l - System.currentTimeMillis() >= 21600000) {
                    i = new ArrayList();
                    l = System.currentTimeMillis();
                    Object a2 = cn.jiguang.ax.e.a(context, "get_installed_pkg_list", i);
                    if (a2 instanceof List) {
                        k = 0;
                        i = (List) a2;
                    } else if (a2 instanceof Integer) {
                        k = ((Integer) a2).intValue();
                        cn.jiguang.ar.c.c("JAppListProbeHelper", "get install pkg list failed, err_code: " + a2);
                        return String.valueOf(a2);
                    }
                }
                List<String> list = i;
                if (list != null && list.size() > 0 && k == 0) {
                    String str = "";
                    for (String str2 : e2.keySet()) {
                        Integer num = e2.get(str2);
                        if (!TextUtils.isEmpty(str2) && num.intValue() > 0 && i.contains(str2)) {
                            str = str + num + HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
                        }
                    }
                    String substring = !TextUtils.isEmpty(str) ? str.substring(0, str.length() - 1) : str;
                    cn.jiguang.ar.c.c("JAppListProbeHelper", "package index list: " + substring + ", old content: " + str);
                    return substring;
                }
                cn.jiguang.ar.c.c("JAppListProbeHelper", "get installed app index for none cahce app list, errCode: " + k);
                int i2 = k;
                return i2 != 0 ? String.valueOf(i2) : "";
            }
            cn.jiguang.ar.c.c("JAppListProbeHelper", "no package index list from cache");
            return "";
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("JAppListProbeHelper", "get package index list failed, " + th.getMessage());
            return "";
        }
    }

    public static Object d(Context context) {
        String str;
        Object a2;
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(g)) {
            try {
                return new JSONObject(g);
            } catch (Throwable unused) {
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            cn.jiguang.bc.a a3 = cn.jiguang.bc.a.a(context);
            jSONObject.put("android_id", a3.i);
            jSONObject.put("manufacturer", a3.l);
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, a3.c);
            Object a4 = cn.jiguang.ax.e.a(context, "deviceinfo", null);
            if (a4 instanceof JSONObject) {
                JSONArray jSONArray = ((JSONObject) a4).getJSONArray("sim_slots");
                String str2 = "";
                String str3 = str2;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = jSONObject2.optString("imei", "");
                            if (!TextUtils.isEmpty(str2)) {
                                jSONObject.put("imei1", str2);
                            }
                        } else {
                            str3 = jSONObject2.optString("imei", "");
                            if (!TextUtils.isEmpty(str3)) {
                                jSONObject.put("imei2", str3);
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                    jSONObject.put("imei1", a3.p);
                }
                jSONObject.put("os_version", ((JSONObject) a4).optString("os_version", ""));
                jSONObject.put(MediaFormat.KEY_LANGUAGE, ((JSONObject) a4).optString(MediaFormat.KEY_LANGUAGE, ""));
                try {
                    str = jSONObject.getJSONObject("ids").optString("joad", "");
                    try {
                        if (TextUtils.isEmpty(str)) {
                            str = j;
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    str = "";
                }
                if (TextUtils.isEmpty(str) && (a2 = cn.jiguang.ax.e.a(context, "get_all_ids", null)) != null && (a2 instanceof JSONObject)) {
                    str = ((JSONObject) a2).optString("joad", "");
                }
                jSONObject.put("joad", str);
            }
        } catch (Throwable unused4) {
        }
        g = jSONObject.toString();
        cn.jiguang.ar.c.c("JAppListProbeHelper", "force dev info " + jSONObject.toString());
        return jSONObject;
    }

    private static HashMap<String, Integer> e(Context context) {
        HashMap<String, Integer> hashMap = h;
        if (hashMap != null) {
            return hashMap;
        }
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        if (context == null) {
            cn.jiguang.ar.c.g("JAppListProbeHelper", "[readPkgIndexConfig] context is null");
            h = hashMap2;
            return hashMap2;
        }
        FileInputStream fileInputStream = null;
        try {
            File a2 = cn.jiguang.f.c.a(context, m);
            if (a2 != null && a2.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(a2);
                try {
                    JSONObject jSONObject = new JSONObject(cn.jiguang.bf.d.b(new String(i.a((InputStream) fileInputStream2))));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        int optInt = jSONObject.optInt(next, 0);
                        if (!TextUtils.isEmpty(next) && optInt > 0) {
                            hashMap2.put(next, Integer.valueOf(optInt));
                        }
                    }
                    cn.jiguang.ar.c.c("JAppListProbeHelper", "[readPkgIndexConfig] config json: " + jSONObject.toString());
                    fileInputStream = fileInputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        cn.jiguang.ar.c.g("JAppListProbeHelper", "load objects error:" + th.getMessage());
                        h = hashMap2;
                        return hashMap2;
                    } finally {
                        i.a((Closeable) fileInputStream);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        h = hashMap2;
        return hashMap2;
    }
}
