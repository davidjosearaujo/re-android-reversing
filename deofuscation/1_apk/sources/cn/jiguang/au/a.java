package cn.jiguang.au;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.ar.c;
import cn.jiguang.g.b;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    public static String a;
    public static int b;
    public static String c;
    public static int d;
    private static final LinkedHashMap<String, Integer> e;
    private static final LinkedHashMap<String, Integer> f;
    private static final LinkedHashMap<String, Integer> g;
    private static final LinkedHashMap<String, Integer> h;
    private static String i;
    private static String j;
    private static String k;
    private static String l;

    static {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        e = linkedHashMap;
        linkedHashMap.put("s.jpush.cn", 19000);
        linkedHashMap.put("sis.jpush.io", 19000);
        linkedHashMap.put("easytomessage.com", 19000);
        LinkedHashMap<String, Integer> linkedHashMap2 = new LinkedHashMap<>();
        f = linkedHashMap2;
        try {
            String str = new String(Base64.decode("MTIzLjE5Ni4xMTguMjM=", 2));
            String str2 = new String(Base64.decode("MTAzLjIyOS4yMTUuNjA=", 2));
            String str3 = new String(Base64.decode("MTE3LjEyMS40OS4xMDA=", 2));
            linkedHashMap2.put(str, 19000);
            linkedHashMap2.put(str2, 19000);
            linkedHashMap2.put(str3, 19000);
        } catch (Throwable unused) {
        }
        g = new LinkedHashMap<>();
        h = new LinkedHashMap<>();
        i = "";
        j = "";
        k = "";
        l = "";
    }

    public static String a(Context context) {
        if (!JCoreManager.isTestEnv() || TextUtils.isEmpty(i)) {
            String str = (String) b.b(context, cn.jiguang.g.a.P());
            return !TextUtils.isEmpty(str) ? str : "im64.jpush.cn";
        }
        return i;
    }

    public static LinkedHashMap<String, Integer> a() {
        if (JCoreManager.isTestEnv()) {
            LinkedHashMap<String, Integer> linkedHashMap = g;
            if (!linkedHashMap.isEmpty()) {
                return linkedHashMap;
            }
        }
        return e;
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            c.g("HostConfig", "conn info was empty");
            return;
        }
        c.c("HostConfig", "get conn info=" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("srv");
            c.c("HostConfig", "save srvHost:" + optString);
            if (!TextUtils.isEmpty(optString)) {
                b.a(context, cn.jiguang.g.a.Q().a((cn.jiguang.g.a<String>) optString));
            }
            String optString2 = jSONObject.optString("conn");
            c.c("HostConfig", "save connHost:" + optString2);
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            b.a(context, cn.jiguang.g.a.P().a((cn.jiguang.g.a<String>) optString2));
        } catch (Throwable unused) {
        }
    }

    public static String b(Context context) {
        if (!JCoreManager.isTestEnv() || TextUtils.isEmpty(j)) {
            String str = (String) b.b(context, cn.jiguang.g.a.Q());
            return !TextUtils.isEmpty(str) ? str : "_im64._tcp.jpush.cn";
        }
        return j;
    }

    public static LinkedHashMap<String, Integer> b() {
        if (JCoreManager.isTestEnv()) {
            LinkedHashMap<String, Integer> linkedHashMap = h;
            if (!linkedHashMap.isEmpty()) {
                return linkedHashMap;
            }
        }
        return f;
    }

    public static String c() {
        return (!JCoreManager.isTestEnv() || TextUtils.isEmpty(k)) ? "_psis._udp.jpush.cn" : k;
    }

    public static String d() {
        return (!JCoreManager.isTestEnv() || TextUtils.isEmpty(l)) ? "" : l;
    }
}
