package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.PayResultActivity;
import com.alipay.sdk.data.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.H5PayResultModel;
import com.alipay.sdk.util.f;
import com.alipay.sdk.util.g;
import com.alipay.sdk.util.j;
import com.alipay.sdk.util.l;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.hunantv.imgo.entity.JumpAction;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PayTask {
    public static final Object h = f.class;
    public static long i = 0;
    public static final long j = 3000;
    public static long k = -1;
    public Activity a;
    public com.alipay.sdk.widget.a b;
    public final String c = "wappaygw.alipay.com/service/rest.htm";
    public final String d = "mclient.alipay.com/service/rest.htm";
    public final String e = "mclient.alipay.com/home/exterfaceAssign.htm";
    public final String f = "mclient.alipay.com/cashier/mobilepay.htm";
    public Map<String, c> g = new HashMap();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ H5PayCallback c;

        public a(String str, boolean z, H5PayCallback h5PayCallback) {
            this.a = str;
            this.b = z;
            this.c = h5PayCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            H5PayResultModel h5Pay = PayTask.this.h5Pay(new com.alipay.sdk.sys.a(PayTask.this.a, this.a, "payInterceptorWithUrl"), this.a, this.b);
            com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "inc finished: " + h5Pay.getResultCode());
            this.c.onPayResult(h5Pay);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b implements f.e {
        public b() {
        }

        @Override // com.alipay.sdk.util.f.e
        public void a() {
            PayTask.this.dismissLoading();
        }

        @Override // com.alipay.sdk.util.f.e
        public void b() {
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class c {
        public String a;
        public String b;
        public String c;
        public String d;

        public c() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
        }

        public String a() {
            return this.c;
        }

        public String b() {
            return this.a;
        }

        public String c() {
            return this.b;
        }

        public String d() {
            return this.d;
        }

        public void a(String str) {
            this.c = str;
        }

        public void b(String str) {
            this.a = str;
        }

        public void c(String str) {
            this.b = str;
        }

        public void d(String str) {
            this.d = str;
        }

        public /* synthetic */ c(PayTask payTask, a aVar) {
            this();
        }
    }

    public PayTask(Activity activity) {
        this.a = activity;
        com.alipay.sdk.sys.b.d().a(this.a);
        this.b = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.j);
    }

    public static boolean b() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - k >= j) {
            k = elapsedRealtime;
            return false;
        }
        return true;
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        synchronized (PayTask.class) {
            try {
                com.alipay.sdk.sys.b.d().a(context);
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                if (elapsedRealtime - i < com.alipay.sdk.data.a.v().c()) {
                    return false;
                }
                i = elapsedRealtime;
                com.alipay.sdk.data.a.v().a(com.alipay.sdk.sys.a.e(), context.getApplicationContext(), false);
                return true;
            } catch (Exception e) {
                com.alipay.sdk.util.c.a(e);
                return false;
            }
        }
    }

    public void dismissLoading() {
        com.alipay.sdk.widget.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
            this.b = null;
        }
    }

    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String trim = str.trim();
                if (trim.startsWith("https://wappaygw.alipay.com/service/rest.htm") || trim.startsWith("http://wappaygw.alipay.com/service/rest.htm")) {
                    String trim2 = trim.replaceFirst("(http|https)://wappaygw.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(trim2)) {
                        String a2 = l.a("<request_token>", "</request_token>", l.a(trim2).get("req_data"));
                        com.alipay.sdk.sys.a aVar = new com.alipay.sdk.sys.a(this.a, "", "");
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + a2 + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + aVar.a("sc", "h5tonative") + "\"";
                    }
                }
                if (trim.startsWith("https://mclient.alipay.com/service/rest.htm") || trim.startsWith("http://mclient.alipay.com/service/rest.htm")) {
                    String trim3 = trim.replaceFirst("(http|https)://mclient.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(trim3)) {
                        String a3 = l.a("<request_token>", "</request_token>", l.a(trim3).get("req_data"));
                        com.alipay.sdk.sys.a aVar2 = new com.alipay.sdk.sys.a(this.a, "", "");
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + a3 + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + aVar2.a("sc", "h5tonative") + "\"";
                    }
                }
                if ((trim.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm") || trim.startsWith("http://mclient.alipay.com/home/exterfaceAssign.htm")) && ((trim.contains("alipay.wap.create.direct.pay.by.user") || trim.contains("create_forex_trade_wap")) && !TextUtils.isEmpty(trim.replaceFirst("(http|https)://mclient.alipay.com/home/exterfaceAssign.htm\\?", "").trim()))) {
                    com.alipay.sdk.sys.a aVar3 = new com.alipay.sdk.sys.a(this.a, "", "");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str);
                    jSONObject.put("bizcontext", aVar3.a("sc", "h5tonative"));
                    return "new_external_info==" + jSONObject.toString();
                }
                if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                    String a4 = l.a(JumpAction.STR_ACTION_SPLIT, "", str);
                    if (!TextUtils.isEmpty(a4)) {
                        Map<String, String> a5 = l.a(a4);
                        StringBuilder sb = new StringBuilder();
                        if (a(false, true, com.alipay.sdk.app.statistic.b.I0, sb, a5, com.alipay.sdk.app.statistic.b.I0, "alipay_trade_no")) {
                            a(true, false, "pay_phase_id", sb, a5, "payPhaseId", "pay_phase_id", "out_relation_id");
                            sb.append("&biz_sub_type=\"TRADE\"");
                            sb.append("&biz_type=\"trade\"");
                            String str2 = a5.get(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
                            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(a5.get("cid"))) {
                                str2 = "ali1688";
                            } else if (TextUtils.isEmpty(str2) && (!TextUtils.isEmpty(a5.get("sid")) || !TextUtils.isEmpty(a5.get("s_id")))) {
                                str2 = "tb";
                            }
                            sb.append("&app_name=\"" + str2 + "\"");
                            if (a(true, true, "extern_token", sb, a5, "extern_token", "cid", "sid", "s_id")) {
                                a(true, false, "appenv", sb, a5, "appenv");
                                sb.append("&pay_channel_id=\"alipay_sdk\"");
                                c cVar = new c(this, null);
                                cVar.b(a5.get("return_url"));
                                cVar.c(a5.get("show_url"));
                                cVar.a(a5.get("pay_order_id"));
                                com.alipay.sdk.sys.a aVar4 = new com.alipay.sdk.sys.a(this.a, "", "");
                                String str3 = sb.toString() + "&bizcontext=\"" + aVar4.a("sc", "h5tonative") + "\"";
                                this.g.put(str3, cVar);
                                return str3;
                            }
                            return "";
                        }
                    }
                }
                if (!trim.startsWith("https://mclient.alipay.com/cashier/mobilepay.htm") && !trim.startsWith("http://mclient.alipay.com/cashier/mobilepay.htm") && (!EnvUtils.isSandBox() || !trim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                    if (com.alipay.sdk.data.a.v().g() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(trim).find()) {
                        Uri parse = Uri.parse(trim);
                        String queryParameter = parse.getQueryParameter("return_url");
                        String queryParameter2 = parse.getQueryParameter("show_url");
                        String queryParameter3 = parse.getQueryParameter("pay_order_id");
                        String a6 = a(parse.getQueryParameter("trade_nos"), parse.getQueryParameter("alipay_trade_no"));
                        String a7 = a(parse.getQueryParameter("payPhaseId"), parse.getQueryParameter("pay_phase_id"), parse.getQueryParameter("out_relation_id"));
                        String[] strArr = new String[4];
                        strArr[0] = parse.getQueryParameter(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
                        strArr[1] = !TextUtils.isEmpty(parse.getQueryParameter("cid")) ? "ali1688" : "";
                        strArr[2] = !TextUtils.isEmpty(parse.getQueryParameter("sid")) ? "tb" : "";
                        strArr[3] = !TextUtils.isEmpty(parse.getQueryParameter("s_id")) ? "tb" : "";
                        String a8 = a(strArr);
                        String a9 = a(parse.getQueryParameter("extern_token"), parse.getQueryParameter("cid"), parse.getQueryParameter("sid"), parse.getQueryParameter("s_id"));
                        String a10 = a(parse.getQueryParameter("appenv"));
                        if (!TextUtils.isEmpty(a6) && !TextUtils.isEmpty(a8) && !TextUtils.isEmpty(a9)) {
                            String format = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", a6, a7, a8, a9, a10, new com.alipay.sdk.sys.a(this.a, "", "").a("sc", "h5tonative"));
                            c cVar2 = new c(this, null);
                            cVar2.b(queryParameter);
                            cVar2.c(queryParameter2);
                            cVar2.a(queryParameter3);
                            cVar2.d(a6);
                            this.g.put(format, cVar2);
                            return format;
                        }
                    }
                }
                String a11 = new com.alipay.sdk.sys.a(this.a, "", "").a("sc", "h5tonative");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", trim);
                jSONObject2.put("bizcontext", a11);
                return String.format("new_external_info==%s", jSONObject2.toString());
            }
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
        return "";
    }

    public synchronized String fetchTradeToken() {
        return g.a(new com.alipay.sdk.sys.a(this.a, "", "fetchTradeToken"), this.a.getApplicationContext());
    }

    public String getVersion() {
        return "15.8.02";
    }

    public synchronized H5PayResultModel h5Pay(com.alipay.sdk.sys.a aVar, String str, boolean z) {
        H5PayResultModel h5PayResultModel;
        h5PayResultModel = new H5PayResultModel();
        String[] split = a(aVar, str, z).split(g.b);
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            int indexOf = str2.indexOf("={");
            if (indexOf >= 0) {
                String substring = str2.substring(0, indexOf);
                hashMap.put(substring, a(str2, substring));
            }
        }
        if (hashMap.containsKey(j.a)) {
            h5PayResultModel.setResultCode(hashMap.get(j.a));
        }
        h5PayResultModel.setReturnUrl(a(str, hashMap));
        if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
            com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.s0, "");
        }
        return h5PayResultModel;
    }

    public synchronized String pay(String str, boolean z) {
        return a(new com.alipay.sdk.sys.a(this.a, str, "pay"), str, z);
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z, H5PayCallback h5PayCallback) {
        String fetchOrderInfoFromH5PayUrl;
        fetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl)) {
            com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "intercepted: " + fetchOrderInfoFromH5PayUrl);
            new Thread(new a(fetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl);
    }

    public synchronized Map<String, String> payV2(String str, boolean z) {
        com.alipay.sdk.sys.a aVar;
        aVar = new com.alipay.sdk.sys.a(this.a, str, "payV2");
        return j.a(aVar, a(aVar, str, z));
    }

    public void showLoading() {
        com.alipay.sdk.widget.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    private synchronized String a(com.alipay.sdk.sys.a aVar, String str, boolean z) {
        if (b()) {
            com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.b.l, "RepPay", "");
            return com.alipay.sdk.app.b.b();
        }
        if (z) {
            showLoading();
        }
        if (str.contains("payment_inst=")) {
            String substring = str.substring(str.indexOf("payment_inst=") + 13);
            int indexOf = substring.indexOf(38);
            if (indexOf > 0) {
                substring = substring.substring(0, indexOf);
            }
            com.alipay.sdk.app.a.a(substring.replaceAll("\"", "").toLowerCase(Locale.getDefault()).replaceAll("alipay", ""));
        } else {
            com.alipay.sdk.app.a.a("");
        }
        if (str.contains(com.alipay.sdk.cons.a.t)) {
            com.alipay.sdk.cons.a.u = true;
        }
        if (com.alipay.sdk.cons.a.u) {
            if (str.startsWith(com.alipay.sdk.cons.a.v)) {
                str = str.substring(str.indexOf(com.alipay.sdk.cons.a.v) + 53);
            } else if (str.startsWith(com.alipay.sdk.cons.a.w)) {
                str = str.substring(str.indexOf(com.alipay.sdk.cons.a.w) + 52);
            }
        }
        com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay prepared: " + str);
        String a2 = a(str, aVar);
        com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay raw result: " + a2);
        g.a(aVar, this.a.getApplicationContext(), a2);
        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.Z, "" + SystemClock.elapsedRealtime());
        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.a0, j.a(a2, j.a) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + j.a(a2, j.b));
        if (!com.alipay.sdk.data.a.v().q()) {
            com.alipay.sdk.data.a.v().a(aVar, this.a.getApplicationContext(), false);
        }
        dismissLoading();
        com.alipay.sdk.app.statistic.a.b(this.a.getApplicationContext(), aVar, str, aVar.d);
        com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay returning: " + a2);
        return a2;
    }

    public static final String a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    private boolean a(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i2];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i2++;
        }
        if (TextUtils.isEmpty(str2)) {
            return !z2;
        } else if (z) {
            sb.append("&");
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        } else {
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        }
    }

    private String a(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean equals = "9000".equals(map.get(j.a));
        String str2 = map.get("result");
        c remove = this.g.remove(str);
        String[] strArr = new String[2];
        strArr[0] = remove != null ? remove.a() : "";
        strArr[1] = remove != null ? remove.d() : "";
        a(strArr);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            String a2 = a(l.a("&callBackUrl=\"", "\"", str2), l.a("&call_back_url=\"", "\"", str2), l.a(com.alipay.sdk.cons.a.r, "\"", str2), URLDecoder.decode(l.a(com.alipay.sdk.cons.a.s, "&", str2), "utf-8"), URLDecoder.decode(l.a("&callBackUrl=", "&", str2), "utf-8"), l.a("call_back_url=\"", "\"", str2));
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
        }
        if (remove != null) {
            String b2 = equals ? remove.b() : remove.c();
            if (!TextUtils.isEmpty(b2)) {
                return b2;
            }
        }
        return remove != null ? com.alipay.sdk.data.a.v().p() : "";
    }

    private String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(g.d));
    }

    private f.e a() {
        return new b();
    }

    private String a(String str, com.alipay.sdk.sys.a aVar) {
        String a2 = aVar.a(str);
        if (a2.contains("paymethod=\"expressGateway\"")) {
            return a(aVar, a2);
        }
        List<a.b> k2 = com.alipay.sdk.data.a.v().k();
        if (!com.alipay.sdk.data.a.v().g || k2 == null) {
            k2 = com.alipay.sdk.app.a.d;
        }
        if (l.b(aVar, this.a, k2)) {
            f fVar = new f(this.a, aVar, a());
            com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay inner started: " + a2);
            String a3 = fVar.a(a2);
            com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay inner raw result: " + a3);
            fVar.a();
            if (!TextUtils.equals(a3, f.j) && !TextUtils.equals(a3, f.k)) {
                if (TextUtils.isEmpty(a3)) {
                    return com.alipay.sdk.app.b.a();
                }
                if (a3.contains(PayResultActivity.b)) {
                    com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.o0);
                    return a(aVar, a2, k2, a3, this.a);
                }
                return a3;
            }
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.m0);
            return a(aVar, a2);
        }
        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.n0);
        return a(aVar, a2);
    }

    public static String a(com.alipay.sdk.sys.a aVar, String str, List<a.b> list, String str2, Activity activity) {
        l.c a2 = l.a(aVar, activity, list);
        if (a2 == null || a2.a(aVar) || a2.a() || !TextUtils.equals(a2.a.packageName, PayResultActivity.d)) {
            return str2;
        }
        com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "PayTask not_login");
        String valueOf = String.valueOf(str.hashCode());
        Object obj = new Object();
        HashMap<String, Object> hashMap = PayResultActivity.c;
        hashMap.put(valueOf, obj);
        Intent intent = new Intent(activity, PayResultActivity.class);
        intent.putExtra(PayResultActivity.f, str);
        intent.putExtra(PayResultActivity.g, activity.getPackageName());
        intent.putExtra(PayResultActivity.e, valueOf);
        a.C0030a.a(aVar, intent);
        j.l.c.e0.a.a.a.h(intent);
        activity.startActivity(intent);
        synchronized (hashMap.get(valueOf)) {
            try {
                com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "PayTask wait");
                hashMap.get(valueOf).wait();
            } catch (InterruptedException unused) {
                com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "PayTask interrupted");
                return com.alipay.sdk.app.b.a();
            }
        }
        String str3 = PayResultActivity.b.b;
        com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "PayTask ret: " + str3);
        return str3;
    }

    private String a(com.alipay.sdk.sys.a aVar, String str) {
        showLoading();
        com.alipay.sdk.app.c cVar = null;
        try {
            try {
                JSONObject c2 = new com.alipay.sdk.packet.impl.f().a(aVar, this.a.getApplicationContext(), str).c();
                String optString = c2.optString("end_code", null);
                List<com.alipay.sdk.protocol.b> a2 = com.alipay.sdk.protocol.b.a(c2.optJSONObject(com.alipay.sdk.cons.c.c).optJSONObject(com.alipay.sdk.cons.c.d));
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    if (a2.get(i2).a() == com.alipay.sdk.protocol.a.Update) {
                        com.alipay.sdk.protocol.b.a(a2.get(i2));
                    }
                }
                a(aVar, c2);
                dismissLoading();
                com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.d);
                for (int i3 = 0; i3 < a2.size(); i3++) {
                    com.alipay.sdk.protocol.b bVar = a2.get(i3);
                    if (bVar.a() == com.alipay.sdk.protocol.a.WapPay) {
                        String a3 = a(aVar, bVar);
                        dismissLoading();
                        com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.d);
                        return a3;
                    } else if (bVar.a() == com.alipay.sdk.protocol.a.OpenWeb) {
                        String a4 = a(aVar, bVar, optString);
                        dismissLoading();
                        com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.d);
                        return a4;
                    }
                }
                dismissLoading();
                com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.d);
            } catch (IOException e) {
                com.alipay.sdk.app.c b2 = com.alipay.sdk.app.c.b(com.alipay.sdk.app.c.NETWORK_ERROR.b());
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.k, e);
                dismissLoading();
                com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.d);
                cVar = b2;
            }
            if (cVar == null) {
                cVar = com.alipay.sdk.app.c.b(com.alipay.sdk.app.c.FAILED.b());
            }
            return com.alipay.sdk.app.b.a(cVar.b(), cVar.a(), "");
        }
    }

    private void a(com.alipay.sdk.sys.a aVar, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("tid");
            String optString2 = jSONObject.optString(com.alipay.sdk.tid.a.j);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            com.alipay.sdk.tid.a.a(com.alipay.sdk.sys.b.d().b()).a(optString, optString2);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.T, th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0092, code lost:
        r0 = r6.c();
        r11 = com.alipay.sdk.app.b.a(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], com.alipay.sdk.util.l.e(r10, r0[2]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(com.alipay.sdk.sys.a r10, com.alipay.sdk.protocol.b r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.a(com.alipay.sdk.sys.a, com.alipay.sdk.protocol.b, java.lang.String):java.lang.String");
    }

    private String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.protocol.b bVar) {
        String[] c2 = bVar.c();
        Intent intent = new Intent(this.a, H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", c2[0]);
        if (c2.length == 2) {
            bundle.putString("cookie", c2[1]);
        }
        intent.putExtras(bundle);
        a.C0030a.a(aVar, intent);
        Activity activity = this.a;
        j.l.c.e0.a.a.a.h(intent);
        activity.startActivity(intent);
        Object obj = h;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                com.alipay.sdk.util.c.a(e);
                return com.alipay.sdk.app.b.a();
            }
        }
        String d = com.alipay.sdk.app.b.d();
        return TextUtils.isEmpty(d) ? com.alipay.sdk.app.b.a() : d;
    }
}
