package com.alipay.sdk.packet.impl;

import android.content.Context;
import com.facebook.yoga.android.BuildConfig;
import com.hunantv.imgo.net.RequestParams;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d extends com.alipay.sdk.packet.e {
    public static final String t = "log_v";

    @Override // com.alipay.sdk.packet.e
    public String a(com.alipay.sdk.sys.a aVar, String str, JSONObject jSONObject) {
        return str;
    }

    @Override // com.alipay.sdk.packet.e
    public Map<String, String> a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(com.alipay.sdk.packet.e.c, String.valueOf(z));
        hashMap.put(com.alipay.sdk.packet.e.f, RequestParams.APPLICATION_OCTET_STREAM);
        hashMap.put(com.alipay.sdk.packet.e.i, "CBC");
        return hashMap;
    }

    @Override // com.alipay.sdk.packet.e
    public JSONObject a() throws JSONException {
        return null;
    }

    @Override // com.alipay.sdk.packet.e
    public String b() throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("api_name", "/sdk/log");
        hashMap.put(com.alipay.sdk.packet.e.l, "1.0.0");
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put(t, BuildConfig.VERSION_NAME);
        return a(hashMap, hashMap2);
    }

    @Override // com.alipay.sdk.packet.e
    public com.alipay.sdk.packet.b a(com.alipay.sdk.sys.a aVar, Context context, String str) throws Throwable {
        return a(aVar, context, str, com.alipay.sdk.cons.a.c, true);
    }
}
