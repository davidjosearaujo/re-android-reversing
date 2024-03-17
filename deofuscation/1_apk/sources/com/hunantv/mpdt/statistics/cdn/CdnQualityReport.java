package com.hunantv.mpdt.statistics.cdn;

import android.text.TextUtils;
import com.facebook.common.time.Clock;
import com.hunantv.imgo.net.RequestParams;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.b0;
import java.net.URL;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CdnQualityReport extends j.l.b.g.a {
    public static int B;
    private static final /* synthetic */ c.b C = null;
    private String A;
    public boolean j;
    private boolean k;
    private long l;
    private long m;
    private int n;
    private int o;
    private String p;
    private int q;
    private int r;
    private String s;
    private String t;
    private String u;
    private int v;
    private String w;
    private String x;
    private j.l.b.g.c y;
    private boolean z;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 5;
        public static final int g = 6;
        public static final int h = 7;
        public static final int i = 8;
        public static final int j = 9;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class b {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class c {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        public static final int h = 9;
        public static final int i = 11;
    }

    static {
        j();
    }

    public CdnQualityReport(String str, boolean z, int i, int i2, String str2, String str3, String str4) {
        super((long) Clock.MAX_TIME, 300000L);
        this.w = "";
        this.y = j.l.b.g.c.f();
        this.z = false;
        this.A = "https://v1-play.log.mgtv.com/info.php";
        this.p = str;
        this.v = z ? 2 : 1;
        this.r = i;
        this.o = i2;
        this.t = str2;
        this.u = str3;
        this.s = str4;
    }

    private void A(boolean z) {
        v(1, n(this.p), this.r, this.p, 0, this.t, this.o, "", this.w, z, this.m, this.l);
    }

    private void B(boolean z, long j, long j2) {
        if (this.r == 6) {
            v(0, n(this.p), this.r, this.p, 1, "", this.o, "", this.w, z, j, j2);
        } else {
            v(this.q, n(this.p), this.r, this.p, 1, "", this.o, "", this.w, z, j, j2);
        }
        this.q = 0;
    }

    private void C(String str, String str2, boolean z) {
        int i = this.r;
        if (i != 6 && i != 3) {
            v(this.q, n(str), this.r, str, 4, this.t, this.o, str2, this.w, z, this.m, this.l);
        } else {
            v(1, n(str), this.r, str, 4, this.u, this.o, str2, this.w, z, this.m, this.l);
        }
    }

    private static /* synthetic */ void j() {
        e eVar = new e("CdnQualityReport.java", CdnQualityReport.class);
        C = eVar.H("method-execution", eVar.E("1", "onTick", "com.hunantv.mpdt.statistics.cdn.CdnQualityReport", "long", "millisUntilFinished", "", "void"), 99);
    }

    private String n(String str) {
        try {
            return new URL(str).getHost();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String o(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(str2);
        if (split.length == 2) {
            return split[1];
        }
        return split[0];
    }

    public static final /* synthetic */ void s(CdnQualityReport cdnQualityReport, long j, r.a.b.c cVar) {
        if (j.l.a.b0.e.O0(j.l.a.a.a()) || cdnQualityReport.j) {
            if (cdnQualityReport.n > 0) {
                cdnQualityReport.B(cdnQualityReport.k, cdnQualityReport.m, cdnQualityReport.l);
            }
            cdnQualityReport.n++;
        }
    }

    private void v(int i, String str, int i2, String str2, int i3, String str3, int i4, String str4, String str5, boolean z, long j, long j2) {
        RequestParams requestParams = new RequestParams();
        String str6 = i2 == 1 ? "" : str3;
        if ((i2 == 7 || i2 == 1) && i3 == 1) {
            requestParams.put("rpt", String.valueOf(System.currentTimeMillis()));
            requestParams.put("smt", String.valueOf(j));
            requestParams.put("dlt", String.valueOf(j2));
        }
        String str7 = j.l.c.x.t0.a.a().i;
        boolean z2 = false;
        if ((!(TextUtils.equals(str7, "100001") || TextUtils.equals(str7, "100002") || TextUtils.equals(str7, "100003") || TextUtils.equals(str7, "100004")) || i2 != 8) && z) {
            z2 = true;
        }
        String F0 = j.l.a.b0.e.F0(z2);
        requestParams.put("p", "3");
        requestParams.put("v", F0);
        requestParams.put("u", j.l.a.b0.e.A());
        requestParams.put("f", i);
        requestParams.put("h", str);
        requestParams.put("t", i2);
        requestParams.put("cv", "20170105");
        requestParams.put("r", i3);
        requestParams.put("t", i2);
        requestParams.put(com.huawei.hms.opendevice.c.a, 1);
        requestParams.put("o", str6);
        requestParams.put("b", i4);
        requestParams.put(com.huawei.hms.push.e.a, str4);
        requestParams.put("ex", str5);
        requestParams.put(com.alipay.sdk.sys.a.q, j.l.a.b0.e.Z());
        requestParams.put("mf", j.l.a.b0.e.P());
        requestParams.put("mod", j.l.a.b0.e.Q());
        requestParams.put("m", j.l.a.b0.e.x());
        requestParams.put("pt", this.s);
        requestParams.put("l", o(str2, str));
        requestParams.put("ml", this.v);
        requestParams.put(com.alipay.sdk.app.statistic.b.k, b0.b());
        requestParams.put("uvip", j.l.c.x.p0.b.c().e() ? 1 : 0);
        requestParams.put("src", j.l.a.b0.e.g0());
        requestParams.put("tk", this.x);
        requestParams.put("paid", j.l.c.x.t0.a.a().E);
        requestParams.put("ntime", System.currentTimeMillis());
        requestParams.put("oaid", j.l.a.b0.e.U());
        requestParams.put("patver", j.l.a.b0.e.G0());
        this.y.b(this.A, requestParams);
    }

    private void w(int i, String str, int i2, String str2, int i3, String str3, int i4, String str4, String str5, boolean z, long j, long j2, long j3, long j4) {
        RequestParams requestParams = new RequestParams();
        String str6 = i2 == 1 ? "" : str3;
        if ((i2 == 7 || i2 == 1) && i3 == 1) {
            requestParams.put("rpt", String.valueOf(System.currentTimeMillis()));
            requestParams.put("smt", String.valueOf(j));
            requestParams.put("dlt", String.valueOf(j2));
        }
        String str7 = j.l.c.x.t0.a.a().i;
        boolean z2 = false;
        if ((!(TextUtils.equals(str7, "100001") || TextUtils.equals(str7, "100002") || TextUtils.equals(str7, "100003") || TextUtils.equals(str7, "100004")) || i2 != 8) && z) {
            z2 = true;
        }
        String F0 = j.l.a.b0.e.F0(z2);
        requestParams.put("p", "3");
        requestParams.put("v", F0);
        requestParams.put("u", j.l.a.b0.e.A());
        requestParams.put("f", i);
        requestParams.put("h", str);
        requestParams.put("t", i2);
        requestParams.put("cv", "20170105");
        requestParams.put("r", i3);
        requestParams.put("t", i2);
        requestParams.put(com.huawei.hms.opendevice.c.a, 1);
        requestParams.put("o", str6);
        requestParams.put("b", i4);
        requestParams.put(com.huawei.hms.push.e.a, str4);
        requestParams.put("ex", str5);
        requestParams.put(com.alipay.sdk.sys.a.q, j.l.a.b0.e.Z());
        requestParams.put("mf", j.l.a.b0.e.P());
        requestParams.put("mod", j.l.a.b0.e.Q());
        requestParams.put("m", j.l.a.b0.e.x());
        requestParams.put("pt", this.s);
        requestParams.put("l", o(str2, str));
        requestParams.put("ml", this.v);
        requestParams.put(com.alipay.sdk.app.statistic.b.k, b0.b());
        requestParams.put("uvip", j.l.c.x.p0.b.c().e() ? 1 : 0);
        requestParams.put("src", j.l.a.b0.e.g0());
        requestParams.put("tk", this.x);
        if (i3 == 3) {
            requestParams.put("buftime", j3);
            requestParams.put("bufsize", j4);
        }
        requestParams.put("paid", j.l.c.x.t0.a.a().E);
        requestParams.put("ntime", System.currentTimeMillis());
        requestParams.put("oaid", j.l.a.b0.e.U());
        requestParams.put("patver", j.l.a.b0.e.G0());
        this.y.b(this.A, requestParams);
    }

    private void x(String str, boolean z) {
        int i = this.r;
        if (i != 6 && i != 3) {
            v(this.q, n(this.p), this.r, this.p, 2, this.t, this.o, str, this.w, z, this.m, this.l);
        } else {
            v(1, n(this.p), this.r, this.p, 2, this.u, this.o, str, this.w, z, this.m, this.l);
        }
    }

    private void y(String str, boolean z) {
        String str2;
        String valueOf;
        int i = this.r;
        if (i == 6) {
            valueOf = this.u;
        } else {
            String str3 = this.t;
            int i2 = B;
            if (i2 > 0 && i == 8) {
                valueOf = String.valueOf(i2);
            } else {
                str2 = str3;
                v(this.q, n(this.p), this.r, this.p, 3, str2, this.o, "", str, z, this.m, this.l);
                this.q = 0;
                this.n = 0;
            }
        }
        str2 = valueOf;
        v(this.q, n(this.p), this.r, this.p, 3, str2, this.o, "", str, z, this.m, this.l);
        this.q = 0;
        this.n = 0;
    }

    private void z(String str, boolean z, long j, long j2) {
        String str2;
        String valueOf;
        int i = this.r;
        if (i == 6) {
            valueOf = this.u;
        } else {
            String str3 = this.t;
            int i2 = B;
            if (i2 > 0 && i == 8) {
                valueOf = String.valueOf(i2);
            } else {
                str2 = str3;
                w(this.q, n(this.p), this.r, this.p, 3, str2, this.o, "", str, z, this.m, this.l, j, j2);
                this.q = 0;
                this.n = 0;
            }
        }
        str2 = valueOf;
        w(this.q, n(this.p), this.r, this.p, 3, str2, this.o, "", str, z, this.m, this.l, j, j2);
        this.q = 0;
        this.n = 0;
    }

    public void D(String str) {
        this.w = str;
    }

    public void E(String str) {
        this.A = str;
    }

    public void F(String str) {
        this.x = str;
    }

    public void G(String str, boolean z) {
        this.k = z;
        y(str, z);
        this.z = false;
        e();
    }

    public void H(String str, boolean z, long j, long j2) {
        this.k = z;
        z(str, z, j, j2);
        this.z = false;
        e();
    }

    public void I(String str, String str2, boolean z) {
        this.k = z;
        C(str, str2, z);
    }

    public void f() {
    }

    public void k() {
        this.q++;
        this.k = false;
        A(false);
    }

    public void l(boolean z) {
        int i = this.q + 1;
        this.q = i;
        this.k = z;
        if (i == 1) {
            A(z);
        }
    }

    public void m(String str, boolean z) {
        this.k = z;
        x(str, z);
    }

    @WithTryCatchRuntime
    public void onTick(long j) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.f.a(new Object[]{this, r.a.c.b.e.m(j), e.w(C, this, this, r.a.c.b.e.m(j))}).e(69648));
    }

    public boolean p() {
        return this.z;
    }

    public boolean q() {
        return this.k;
    }

    public void r(long j, long j2) {
        if (j.l.a.b0.e.X0() || this.j) {
            B(this.k, j, j2);
        }
    }

    public void t(boolean z) {
        i();
        this.z = true;
        this.k = z;
        B(z, this.m, this.l);
    }

    public void u(boolean z, long j, long j2) {
        this.z = true;
        this.k = z;
        this.m = j;
        this.l = j2;
        B(z, j, j2);
    }
}
