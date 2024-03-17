package cn.jiguang.b;

import android.content.Context;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.hunantv.mpdt.data.EventClickData;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    public static String a;
    private static boolean b;
    private static final String c = cn.jiguang.r.a.b(new byte[]{88, 8, 73, 72, 109, 123, 93, 64, 118, 122, 76, 87, 93, 0, 97, 74});
    private static final String d = cn.jiguang.r.a.b(new byte[]{67, 100, 100, 125, 66, 78, 118, 116, 100, 79, 80, 94, 41, 100, 66, 111});

    public static void a(final Context context) {
        cn.jiguang.be.d.a("FUTURE_TASK", new cn.jiguang.be.b() { // from class: cn.jiguang.b.b.1
            @Override // cn.jiguang.be.b
            public void a() {
                if (b.b) {
                    return;
                }
                synchronized (b.class) {
                    if (b.b) {
                        return;
                    }
                    boolean unused = b.b = true;
                    b.c(context);
                    boolean unused2 = b.b = false;
                }
            }
        });
    }

    private static String b() {
        cn.jiguang.ar.c.c("HttpControl", "BuildConfig.INTERNAL_USE:false");
        cn.jiguang.ar.c.c("HttpControl", "URL_BASE_TEST:" + a);
        return "https://ce3e75d5.jpush.cn";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(Context context) {
        synchronized (b.class) {
            long currentTimeMillis = System.currentTimeMillis() - c.d(context);
            if (currentTimeMillis < 86400000) {
                cn.jiguang.ar.c.c("HttpControl", "controlData time:" + currentTimeMillis);
                return;
            }
            String b2 = cn.jiguang.ax.b.a().b(JPushConstants.SDK_TYPE, "");
            if ("".equals(b2)) {
                cn.jiguang.ar.c.c("JAnalyticsManager", "controlData not jpush sdk");
                return;
            }
            String b3 = b();
            HttpRequest httpRequest = new HttpRequest(b3 + "/wi/sm2cg");
            httpRequest.setRequestProperty("Content-Type", "application/jason");
            JSONObject jSONObject = new JSONObject();
            cn.jiguang.bc.a a2 = cn.jiguang.bc.a.a(context);
            jSONObject.put("ak", cn.jiguang.d.a.e(context));
            jSONObject.put("p", "a");
            jSONObject.put("mo", a2.c);
            jSONObject.put(EventClickData.a.e, a2.l);
            jSONObject.put("ro", cn.jiguang.q.d.a());
            jSONObject.put("apv", a2.a);
            jSONObject.put("jcv", cn.jiguang.a.a.b);
            jSONObject.put("jpv", b2);
            jSONObject.put(com.alipay.sdk.sys.a.t, a2.q);
            jSONObject.put("aiv", 0);
            jSONObject.put("sign", c.b(context) ? c.c(context) : "");
            String jSONObject2 = jSONObject.toString();
            cn.jiguang.ar.c.c("HttpControl", "controlData ulr:" + httpRequest.getUrl());
            cn.jiguang.ar.c.c("HttpControl", "controlData body:" + jSONObject2);
            byte[] bytes = jSONObject2.getBytes();
            String str = c;
            String str2 = d;
            String a3 = cn.jiguang.bf.d.a(bytes, str, str2);
            httpRequest.setBody(a3);
            cn.jiguang.ar.c.c("HttpControl", "controlData aesEncryptBody:" + a3);
            HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
            cn.jiguang.ar.c.c("HttpControl", "controlData httpResponse:" + httpPost.toString());
            if (200 == httpPost.getResponseCode()) {
                String str3 = new String(cn.jiguang.bf.d.a(httpPost.getResponseBody(), str, str2));
                cn.jiguang.ar.c.c("HttpControl", "controlData response body:" + str3);
                JSONObject jSONObject3 = new JSONObject(str3);
                int optInt = jSONObject3.optInt(JThirdPlatFormInterface.KEY_CODE);
                if (2000 == optInt) {
                    c.e(context);
                    c.b(context, jSONObject3.optJSONObject(SDKConstants.PARAM_A2U_BODY));
                } else if (4009 == optInt) {
                    c.e(context);
                } else {
                    cn.jiguang.ar.c.h("HttpControl", "controlData response body w:" + str3);
                }
            }
        }
    }
}
