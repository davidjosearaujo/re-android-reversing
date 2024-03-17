package cn.jiguang.ap;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.service.WakedResultReceiver;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e {
    public static boolean a;
    private static WakedResultReceiver b;

    public static JSONArray a(Context context) {
        JSONObject a2;
        synchronized ("waked_cache_v2.json") {
            a2 = cn.jiguang.r.c.a(context, "waked_cache_v2.json");
        }
        if (a2 == null) {
            a2 = new JSONObject();
        }
        JSONArray optJSONArray = a2.optJSONArray("content");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            cn.jiguang.ak.a.a("JWakedHelper", "no save data");
            return null;
        }
        return a(context, optJSONArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0101 A[Catch: all -> 0x0251, TryCatch #0 {all -> 0x0251, blocks: (B:83:0x0008, B:86:0x0010, B:87:0x0016, B:90:0x0025, B:92:0x0035, B:95:0x003c, B:114:0x00e1, B:116:0x0101, B:118:0x0112, B:120:0x011a, B:96:0x0053, B:100:0x0063, B:102:0x0071, B:104:0x0081, B:106:0x0091, B:107:0x00a0, B:109:0x00a9, B:110:0x00ad, B:112:0x00c2, B:108:0x00a4, B:111:0x00b1, B:113:0x00c6, B:121:0x011e, B:122:0x0137, B:124:0x013d, B:125:0x017e, B:127:0x0184, B:129:0x01ce, B:131:0x01da, B:133:0x01e0, B:135:0x01ec, B:136:0x021b, B:137:0x022f, B:139:0x0235, B:140:0x0249), top: B:147:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONArray a(android.content.Context r19, org.json.JSONArray r20) {
        /*
            Method dump skipped, instructions count: 620
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ap.e.a(android.content.Context, org.json.JSONArray):org.json.JSONArray");
    }

    private static JSONObject a(String str, int i, boolean z) {
        if (str == null) {
            str = "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("wake_type", i);
            jSONObject.put("package", str);
            jSONObject.put("app_alive", z);
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWakedHelper", "packageWakedJson error:" + th.getMessage());
            return null;
        }
    }

    private static void a(Context context, int i) {
        if (context == null) {
            cn.jiguang.ak.a.d("JWakedHelper", "context is null,can not notify waked");
            return;
        }
        WakedResultReceiver e = e(context);
        b = e;
        if (e == null) {
            cn.jiguang.ak.a.d("JWakedHelper", "waked receiver is null");
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("1", context);
        hashMap.put("2", Integer.valueOf(i));
        b.onWakeMap(hashMap);
    }

    public static void a(final Context context, final Bundle bundle, final int i) {
        try {
            cn.jiguang.ak.a.a("JWakedHelper", "executeWakedAction.");
            a(context, i);
            cn.jiguang.n.d.a(new cn.jiguang.n.e() { // from class: cn.jiguang.ap.e.1
                @Override // cn.jiguang.n.e
                public void a() {
                    e.c(context, bundle, i);
                }
            });
            cn.jiguang.h.a.a(context, 2);
        } catch (Throwable th) {
            cn.jiguang.ak.a.a("JWakedHelper", "executeWakedAction failed:" + th.getLocalizedMessage());
        }
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("di", str);
            synchronized ("di.json") {
                JSONObject a2 = cn.jiguang.r.c.a(context, "di.json");
                if (a2 == null) {
                    a2 = new JSONObject();
                }
                JSONArray optJSONArray = a2.optJSONArray("content");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject);
                a2.put("content", optJSONArray);
                cn.jiguang.r.c.a(context, "di.json", a2);
                cn.jiguang.ak.a.a("JWakedHelper", "save di is: " + str + ", success!");
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWakedHelper", "saveDId failed:" + th.getMessage());
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            cn.jiguang.ak.a.a("JWakedHelper", "save waked data : " + jSONObject.toString());
            jSONObject.put("itime", cn.jiguang.n.d.h(context));
            jSONObject.put("type", "aat3");
            synchronized ("waked_cache_v2.json") {
                JSONObject a2 = cn.jiguang.r.c.a(context, "waked_cache_v2.json");
                if (a2 == null) {
                    a2 = new JSONObject();
                }
                JSONArray optJSONArray = a2.optJSONArray("content");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject);
                a2.put("content", optJSONArray);
                cn.jiguang.r.c.a(context, "waked_cache_v2.json", a2);
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWakedHelper", "saveWakedData failed:" + th.getMessage());
        }
    }

    public static JSONArray b(Context context) {
        JSONObject a2;
        synchronized ("di.json") {
            a2 = cn.jiguang.r.c.a(context, "di.json");
        }
        if (a2 == null) {
            a2 = new JSONObject();
        }
        JSONArray optJSONArray = a2.optJSONArray("content");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            cn.jiguang.ak.a.a("JWakedHelper", "no save data");
            return null;
        }
        return optJSONArray;
    }

    public static void c(Context context) {
        synchronized ("di.json") {
            cn.jiguang.r.c.a(context, "di.json", (String) null);
        }
    }

    public static void c(Context context, Bundle bundle, int i) {
        String str;
        if (bundle == null) {
            str = "bundle is null,give up save";
        } else if (b.b(context).u) {
            String str2 = null;
            try {
                str2 = bundle.getString("from_package");
            } catch (Throwable unused) {
            }
            if (str2 == null) {
                str2 = "";
            }
            JSONObject a2 = a(str2, i, a);
            a = true;
            if (a2 == null) {
                return;
            }
            try {
                String string = bundle.getString("jg_extras");
                if (!TextUtils.isEmpty(string)) {
                    a2.put("jg_extras", string);
                }
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JWakedHelper", "save waked extras error:" + th.getMessage());
            }
            a(context, a2);
            return;
        } else {
            str = "server set do not report waked data,give up save";
        }
        cn.jiguang.ak.a.d("JWakedHelper", str);
    }

    public static void d(Context context) {
        synchronized ("waked_cache_v2.json") {
            cn.jiguang.r.c.a(context, "waked_cache_v2.json", (String) null);
        }
    }

    private static WakedResultReceiver e(Context context) {
        WakedResultReceiver wakedResultReceiver = b;
        if (wakedResultReceiver != null) {
            return wakedResultReceiver;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.WakedReceiver");
            intent.setPackage(context.getPackageName());
            intent.addCategory(context.getPackageName());
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() == 0) {
                return null;
            }
            return (WakedResultReceiver) Class.forName(queryBroadcastReceivers.get(0).activityInfo.name).newInstance();
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWakedHelper", "find waked receiver throwable:" + th.getMessage());
            return null;
        }
    }
}
