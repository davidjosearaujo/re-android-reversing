package com.alipay.sdk.packet.impl;

import android.content.Context;
import com.alipay.sdk.net.a;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e extends com.alipay.sdk.packet.e {
    @Override // com.alipay.sdk.packet.e
    public String a(com.alipay.sdk.sys.a aVar, String str, JSONObject jSONObject) {
        return str;
    }

    @Override // com.alipay.sdk.packet.e
    public Map<String, String> a(boolean z, String str) {
        return new HashMap();
    }

    @Override // com.alipay.sdk.packet.e
    public JSONObject a() {
        return null;
    }

    @Override // com.alipay.sdk.packet.e
    public com.alipay.sdk.packet.b a(com.alipay.sdk.sys.a aVar, Context context, String str) throws Throwable {
        com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "mdap post");
        byte[] a = com.alipay.sdk.encrypt.b.a(str.getBytes(Charset.forName("UTF-8")));
        HashMap hashMap = new HashMap();
        hashMap.put("utdId", com.alipay.sdk.sys.b.d().c());
        hashMap.put("logHeader", "RAW");
        hashMap.put("bizCode", com.alipay.sdk.util.c.b);
        hashMap.put("productId", "alipaysdk_android");
        hashMap.put("Content-Encoding", "Gzip");
        hashMap.put("productVersion", "15.8.02");
        a.b a2 = com.alipay.sdk.net.a.a(context, new a.C0029a(com.alipay.sdk.cons.a.d, hashMap, a));
        com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "mdap got " + a2);
        if (a2 != null) {
            boolean a3 = com.alipay.sdk.packet.e.a(a2);
            try {
                byte[] bArr = a2.c;
                if (a3) {
                    bArr = com.alipay.sdk.encrypt.b.b(bArr);
                }
                return new com.alipay.sdk.packet.b("", new String(bArr, Charset.forName("UTF-8")));
            } catch (Exception e) {
                com.alipay.sdk.util.c.a(e);
                return null;
            }
        }
        throw new RuntimeException("Response is null");
    }
}
