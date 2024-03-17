package com.alipay.sdk.data;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.h;
import com.alipay.sdk.util.l;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class a {
    public static final boolean A = true;
    public static final boolean B = false;
    public static final boolean C = true;
    public static final boolean D = true;
    public static final String E = "";
    public static final boolean F = false;
    public static final boolean G = false;
    public static final boolean H = false;
    public static final boolean I = false;
    public static final boolean J = true;
    public static final String K = "";
    public static final boolean L = false;
    public static final String M = "";
    public static final int N = 1000;
    public static final int O = 20000;
    public static final String P = "alipay_cashier_dynamic_config";
    public static final String Q = "timeout";
    public static final String R = "h5_port_degrade";
    public static final String S = "st_sdk_config";
    public static final String T = "tbreturl";
    public static final String U = "launchAppSwitch";
    public static final String V = "configQueryInterval";
    public static final String W = "deg_log_mcgw";
    public static final String X = "deg_start_srv_first";
    public static final String Y = "prev_jump_dual";
    public static final String Z = "use_sc_only";
    public static final String a0 = "bind_use_imp";
    public static final String b0 = "retry_bnd_once";
    public static final String c0 = "skip_trans";
    public static final String d0 = "start_trans";
    public static final String e0 = "up_before_pay";
    public static final String f0 = "lck_k";
    public static final String g0 = "use_sc_lck_a";
    public static final String h0 = "utdid_factor";
    public static final String i0 = "scheme_pay_2";
    public static final String j0 = "intercept_batch";
    public static final String k0 = "bind_with_startActivity";
    public static a l0 = null;
    public static final char[] m0 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', '/'};
    public static final String v = "DynCon";
    public static final int w = 10000;
    public static final String x = "https://h5.m.taobao.com/mlapp/olist.html";
    public static final int y = 10;
    public static final boolean z = true;
    public int a = 10000;
    public boolean b = false;
    public String c = x;
    public int d = 10;
    public boolean e = true;
    public boolean f = true;
    public boolean g = false;
    public boolean h = false;
    public boolean i = true;
    public boolean j = true;
    public String k = "";
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public boolean p = true;
    public String q = "";
    public String r = "";
    public boolean s = false;
    public List<b> t = null;
    public int u = -1;

    /* renamed from: com.alipay.sdk.data.a$a */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class RunnableC0027a implements Runnable {
        public final /* synthetic */ com.alipay.sdk.sys.a a;
        public final /* synthetic */ Context b;

        public RunnableC0027a(com.alipay.sdk.sys.a aVar, Context context) {
            a.this = r1;
            this.a = aVar;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.alipay.sdk.packet.b a = new com.alipay.sdk.packet.impl.b().a(this.a, this.b);
                if (a != null) {
                    a.this.d(a.a());
                    a.this.a(com.alipay.sdk.sys.a.e());
                }
            } catch (Throwable th) {
                c.a(th);
            }
        }
    }

    private int u() {
        String c = com.alipay.sdk.sys.b.d().c();
        if (TextUtils.isEmpty(c)) {
            return -1;
        }
        String replaceAll = c.replaceAll(ContainerUtils.KEY_VALUE_DELIMITER, "");
        if (replaceAll.length() >= 5) {
            replaceAll = replaceAll.substring(0, 5);
        }
        int a = (int) (a(replaceAll) % 10000);
        return a < 0 ? a * (-1) : a;
    }

    public static a v() {
        if (l0 == null) {
            a aVar = new a();
            l0 = aVar;
            aVar.r();
        }
        return l0;
    }

    private JSONObject w() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Q, j());
        jSONObject.put(R, s());
        jSONObject.put(T, p());
        jSONObject.put(V, c());
        jSONObject.put(U, b.a(k()));
        jSONObject.put(i0, h());
        jSONObject.put(j0, g());
        jSONObject.put(W, d());
        jSONObject.put(X, e());
        jSONObject.put(Y, l());
        jSONObject.put(Z, f());
        jSONObject.put(a0, a());
        jSONObject.put(b0, m());
        jSONObject.put(c0, o());
        jSONObject.put(d0, t());
        jSONObject.put(e0, q());
        jSONObject.put(g0, n());
        jSONObject.put(f0, i());
        jSONObject.put(k0, b());
        return jSONObject;
    }

    public String b() {
        return this.r;
    }

    public int c() {
        return this.d;
    }

    public boolean d() {
        return this.h;
    }

    public boolean e() {
        return this.i;
    }

    public String f() {
        return this.k;
    }

    public boolean g() {
        return this.f;
    }

    public boolean h() {
        return this.e;
    }

    public String i() {
        return this.q;
    }

    public int j() {
        int i = this.a;
        if (i >= 1000 && i <= 20000) {
            c.b(v, "time = " + this.a);
            return this.a;
        }
        c.b(v, "time(def) = 10000");
        return 10000;
    }

    public List<b> k() {
        return this.t;
    }

    public boolean l() {
        return this.j;
    }

    public boolean m() {
        return this.m;
    }

    public boolean n() {
        return this.s;
    }

    public boolean o() {
        return this.n;
    }

    public String p() {
        return this.c;
    }

    public boolean q() {
        return this.p;
    }

    public void r() {
        Context b2 = com.alipay.sdk.sys.b.d().b();
        String a = h.a(com.alipay.sdk.sys.a.e(), b2, P, null);
        try {
            this.u = Integer.parseInt(h.a(com.alipay.sdk.sys.a.e(), b2, h0, "-1"));
        } catch (Exception unused) {
        }
        c(a);
    }

    public boolean s() {
        return this.b;
    }

    public boolean t() {
        return this.o;
    }

    public static int b(String str) {
        for (int i = 0; i < 64; i++) {
            if (str.equals(String.valueOf(m0[i]))) {
                return i;
            }
        }
        return 0;
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(new JSONObject(str));
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(S);
            if (optJSONObject != null) {
                a(optJSONObject);
            } else {
                c.e(v, "empty config");
            }
        } catch (Throwable th) {
            c.a(th);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class b {
        public final String a;
        public final int b;
        public final String c;

        public b(String str, int i, String str2) {
            this.a = str;
            this.b = i;
            this.c = str2;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new b(jSONObject.optString("pn"), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
        }

        public String toString() {
            return String.valueOf(a(this));
        }

        public static List<b> a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                b a = a(jSONArray.optJSONObject(i));
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        }

        public static JSONObject a(b bVar) {
            if (bVar == null) {
                return null;
            }
            try {
                return new JSONObject().put("pn", bVar.a).put("v", bVar.b).put("pk", bVar.c);
            } catch (JSONException e) {
                c.a(e);
                return null;
            }
        }

        public static JSONArray a(List<b> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (b bVar : list) {
                jSONArray.put(a(bVar));
            }
            return jSONArray;
        }
    }

    public boolean a() {
        return this.l;
    }

    public void a(boolean z2) {
        this.g = z2;
    }

    public void a(com.alipay.sdk.sys.a aVar) {
        try {
            JSONObject w2 = w();
            h.b(aVar, com.alipay.sdk.sys.b.d().b(), P, w2.toString());
        } catch (Exception e) {
            c.a(e);
        }
    }

    private void a(JSONObject jSONObject) {
        this.a = jSONObject.optInt(Q, 10000);
        this.b = jSONObject.optBoolean(R, false);
        this.c = jSONObject.optString(T, x).trim();
        this.d = jSONObject.optInt(V, 10);
        this.t = b.a(jSONObject.optJSONArray(U));
        this.e = jSONObject.optBoolean(i0, true);
        this.f = jSONObject.optBoolean(j0, true);
        this.h = jSONObject.optBoolean(W, false);
        this.i = jSONObject.optBoolean(X, true);
        this.j = jSONObject.optBoolean(Y, true);
        this.k = jSONObject.optString(Z, "");
        this.l = jSONObject.optBoolean(a0, false);
        this.m = jSONObject.optBoolean(b0, false);
        this.n = jSONObject.optBoolean(c0, false);
        this.o = jSONObject.optBoolean(d0, false);
        this.p = jSONObject.optBoolean(e0, true);
        this.q = jSONObject.optString(f0, "");
        this.s = jSONObject.optBoolean(g0, false);
        this.r = jSONObject.optString(k0, "");
    }

    public void a(com.alipay.sdk.sys.a aVar, Context context, boolean z2) {
        RunnableC0027a runnableC0027a = new RunnableC0027a(aVar, context);
        if (z2) {
            if (l.a(600L, runnableC0027a, "AlipayDCPBlok")) {
                return;
            }
            com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.r0, "");
            return;
        }
        Thread thread = new Thread(runnableC0027a);
        thread.setName("AlipayDCP");
        thread.start();
    }

    public boolean a(Context context, int i) {
        if (this.u == -1) {
            this.u = u();
            h.b(com.alipay.sdk.sys.a.e(), context, h0, String.valueOf(this.u));
        }
        return this.u < i;
    }

    public static long a(String str) {
        return a(str, 6);
    }

    public static long a(String str, int i) {
        int i2;
        int pow = (int) Math.pow(2.0d, i);
        int length = str.length();
        long j = 0;
        int i3 = length;
        for (int i4 = 0; i4 < length; i4++) {
            j += Integer.parseInt(String.valueOf(b(str.substring(i4, i2)))) * ((long) Math.pow(pow, i3 - 1));
            i3--;
        }
        return j;
    }
}
