package com.alipay.sdk.packet;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.net.a;
import com.alipay.sdk.util.k;
import com.alipay.sdk.util.l;
import com.hunantv.imgo.net.RequestParams;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class e {
    public static final String c = "msp-gzip";
    public static final String d = "Msp-Param";
    public static final String e = "Operation-Type";
    public static final String f = "content-type";
    public static final String g = "Version";
    public static final String h = "AppId";
    public static final String i = "des-mode";
    public static final String j = "namespace";
    public static final String k = "api_name";
    public static final String l = "api_version";
    public static final String m = "data";
    public static final String n = "params";
    public static final String o = "public_key";
    public static final String p = "device";
    public static final String q = "action";
    public static final String r = "type";
    public static final String s = "method";
    public boolean a = true;
    public boolean b = true;

    public Map<String, String> a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(c, String.valueOf(z));
        hashMap.put(e, "alipay.msp.cashier.dispatch.bytes");
        hashMap.put(f, RequestParams.APPLICATION_OCTET_STREAM);
        hashMap.put(g, "2.0");
        hashMap.put(h, "TAOBAO");
        hashMap.put(d, a.a(str));
        hashMap.put(i, "CBC");
        return hashMap;
    }

    public abstract JSONObject a() throws JSONException;

    public String b() throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("device", Build.MODEL);
        hashMap.put("namespace", "com.alipay.mobilecashier");
        hashMap.put("api_name", "com.alipay.mcpay");
        hashMap.put(l, c());
        return a(hashMap, new HashMap<>());
    }

    public String c() {
        return "4.9.0";
    }

    public static JSONObject a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put(s, str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    public String a(com.alipay.sdk.sys.a aVar, String str, JSONObject jSONObject) {
        com.alipay.sdk.sys.b d2 = com.alipay.sdk.sys.b.d();
        com.alipay.sdk.tid.a a = com.alipay.sdk.tid.a.a(d2.b());
        JSONObject a2 = com.alipay.sdk.util.b.a(new JSONObject(), jSONObject);
        try {
            a2.put(com.alipay.sdk.cons.b.d, str);
            a2.put("tid", a.d());
            a2.put(com.alipay.sdk.cons.b.b, d2.a().a(aVar, a));
            a2.put(com.alipay.sdk.cons.b.e, l.b(aVar, d2.b(), com.alipay.sdk.app.a.d));
            a2.put(com.alipay.sdk.cons.b.f, l.i(d2.b()));
            a2.put(com.alipay.sdk.cons.b.h, com.alipay.sdk.cons.a.f);
            a2.put(com.alipay.sdk.cons.b.g, d2.c());
            a2.put(com.alipay.sdk.cons.b.j, a.c());
            a2.put(com.alipay.sdk.cons.b.k, com.alipay.sdk.data.b.b(d2.b()));
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, "BodyErr", th);
            com.alipay.sdk.util.c.a(th);
        }
        return a2.toString();
    }

    public static boolean a(a.b bVar) {
        return Boolean.valueOf(a(bVar, c)).booleanValue();
    }

    public static String a(a.b bVar, String str) {
        Map<String, List<String>> map;
        List<String> list;
        if (bVar == null || str == null || (map = bVar.a) == null || (list = map.get(str)) == null) {
            return null;
        }
        return TextUtils.join(",", list);
    }

    public String a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
        if (hashMap2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : hashMap2.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject2.put("params", jSONObject3);
        }
        jSONObject.put("data", jSONObject2);
        return jSONObject.toString();
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            if (jSONObject.has("params")) {
                String optString = jSONObject.getJSONObject("params").optString(o, null);
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                com.alipay.sdk.data.b.a(optString);
                return true;
            }
            return false;
        } catch (JSONException e2) {
            com.alipay.sdk.util.c.a(e2);
            return false;
        }
    }

    public b a(com.alipay.sdk.sys.a aVar, Context context) throws Throwable {
        return a(aVar, context, "");
    }

    public b a(com.alipay.sdk.sys.a aVar, Context context, String str) throws Throwable {
        return a(aVar, context, str, k.b(context));
    }

    public b a(com.alipay.sdk.sys.a aVar, Context context, String str, String str2) throws Throwable {
        return a(aVar, context, str, str2, true);
    }

    public b a(com.alipay.sdk.sys.a aVar, Context context, String str, String str2, boolean z) throws Throwable {
        com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "Packet: " + str2);
        c cVar = new c(this.b);
        b bVar = new b(b(), a(aVar, str, a()));
        Map<String, String> a = a(false, str);
        d a2 = cVar.a(bVar, this.a, a.get("iSr"));
        a.b a3 = com.alipay.sdk.net.a.a(context, new a.C0029a(str2, a(a2.b(), str), a2.a()));
        if (a3 != null) {
            b a4 = cVar.a(new d(a(a3), a3.c), a.get("iSr"));
            return (a4 != null && a(a4.b()) && z) ? a(aVar, context, str, str2, false) : a4;
        }
        throw new RuntimeException("Response is null.");
    }
}
