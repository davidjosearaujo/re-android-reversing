package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class c {
    public static Map<String, String> a(Context context) {
        com.alipay.security.mobile.module.b.b b = com.alipay.security.mobile.module.b.b.b();
        HashMap hashMap = new HashMap();
        f a = com.alipay.apmobilesecuritysdk.e.e.a(context);
        String a2 = com.alipay.security.mobile.module.b.b.a(context);
        String b2 = com.alipay.security.mobile.module.b.b.b(context);
        String k = com.alipay.security.mobile.module.b.b.k(context);
        String m = com.alipay.security.mobile.module.b.b.m(context);
        if (a != null) {
            if (com.alipay.security.mobile.module.a.a.a(a2)) {
                a2 = a.a();
            }
            if (com.alipay.security.mobile.module.a.a.a(b2)) {
                b2 = a.b();
            }
            if (com.alipay.security.mobile.module.a.a.a(k)) {
                k = a.c();
            }
            if (com.alipay.security.mobile.module.a.a.a(m)) {
                m = a.e();
            }
        }
        f fVar = new f(a2, b2, k, "", m);
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", fVar.a());
                jSONObject.put("imsi", fVar.b());
                jSONObject.put("mac", fVar.c());
                jSONObject.put("bluetoothmac", fVar.d());
                jSONObject.put("gsi", fVar.e());
                String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key", jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key", jSONObject2);
            } catch (Exception e) {
                com.alipay.apmobilesecuritysdk.c.a.a(e);
            }
        }
        hashMap.put("AD1", a2);
        hashMap.put("AD2", b2);
        hashMap.put("AD3", com.alipay.security.mobile.module.b.b.f(context));
        hashMap.put("AD5", com.alipay.security.mobile.module.b.b.h(context));
        hashMap.put("AD6", com.alipay.security.mobile.module.b.b.i(context));
        hashMap.put("AD7", com.alipay.security.mobile.module.b.b.j(context));
        hashMap.put("AD8", k);
        hashMap.put("AD9", com.alipay.security.mobile.module.b.b.l(context));
        hashMap.put("AD10", m);
        hashMap.put("AD11", com.alipay.security.mobile.module.b.b.e());
        hashMap.put("AD12", b.a());
        hashMap.put("AD13", com.alipay.security.mobile.module.b.b.f());
        hashMap.put("AD14", com.alipay.security.mobile.module.b.b.h());
        hashMap.put("AD15", com.alipay.security.mobile.module.b.b.i());
        hashMap.put("AD16", com.alipay.security.mobile.module.b.b.j());
        hashMap.put("AD17", "");
        hashMap.put("AD19", com.alipay.security.mobile.module.b.b.n(context));
        hashMap.put("AD20", com.alipay.security.mobile.module.b.b.k());
        hashMap.put("AD22", "");
        hashMap.put("AD23", com.alipay.security.mobile.module.b.b.p(context));
        hashMap.put("AD24", com.alipay.security.mobile.module.a.a.g(com.alipay.security.mobile.module.b.b.g(context)));
        hashMap.put("AD26", com.alipay.security.mobile.module.b.b.e(context));
        hashMap.put("AD27", com.alipay.security.mobile.module.b.b.p());
        hashMap.put("AD28", com.alipay.security.mobile.module.b.b.r());
        hashMap.put("AD29", com.alipay.security.mobile.module.b.b.t());
        hashMap.put("AD30", com.alipay.security.mobile.module.b.b.q());
        hashMap.put("AD31", com.alipay.security.mobile.module.b.b.s());
        hashMap.put("AD32", com.alipay.security.mobile.module.b.b.n());
        hashMap.put("AD33", com.alipay.security.mobile.module.b.b.o());
        hashMap.put("AD34", com.alipay.security.mobile.module.b.b.r(context));
        hashMap.put("AD35", com.alipay.security.mobile.module.b.b.s(context));
        hashMap.put("AD36", com.alipay.security.mobile.module.b.b.q(context));
        hashMap.put("AD37", com.alipay.security.mobile.module.b.b.m());
        hashMap.put("AD38", com.alipay.security.mobile.module.b.b.l());
        hashMap.put("AD39", com.alipay.security.mobile.module.b.b.c(context));
        hashMap.put("AD40", com.alipay.security.mobile.module.b.b.d(context));
        hashMap.put("AD41", com.alipay.security.mobile.module.b.b.c());
        hashMap.put("AD42", com.alipay.security.mobile.module.b.b.d());
        hashMap.put("AL3", com.alipay.security.mobile.module.b.b.o(context));
        return hashMap;
    }
}
