package com.hunantv.mpdt.statistics.bigdata;

import android.content.Context;
import android.text.TextUtils;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.n0;
import j.l.b.e.a;
import j.l.b.e.e.v;
import java.util.UUID;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PVSourceEvent extends a {
    public static final String A = "38";
    public static final String A0 = "8144";
    public static final String A1 = "7211";
    public static final String A2 = "7";
    public static final String A3 = "100039";
    public static final String B = "39";
    public static final String B0 = "8145";
    public static final String B1 = "7203";
    public static final String B2 = "8";
    public static final String B3 = "100040";
    public static final String C = "40";
    public static final String C0 = "8148";
    public static final String C1 = "7204";
    public static final String C2 = "100";
    public static final String C3 = "phtips";
    public static final String D = "41";
    public static final String D0 = "8149";
    public static final String D1 = "7205";
    public static final String D2 = "200";
    public static final String D3 = "8147";
    public static final String E = "42";
    public static final String E0 = "8150";
    public static final String E1 = "7206";
    public static final String E2 = "210";
    public static final String E3 = "8151";
    public static final String F = "43";
    public static final String F0 = "8152";
    public static final String F1 = "7207";
    public static final String F2 = "211";
    public static final String F3 = "8153 ";
    public static final String G = "44";
    public static final String G0 = "8154";
    public static final String G1 = "7208";
    public static final String G2 = "212";
    public static final String G3 = "200001";
    public static final String H = "45";
    public static final String H0 = "45";
    public static final String H1 = "7209";
    public static final String H2 = "300";
    public static final String H3 = "200002";
    public static final String I = "50";
    public static final String I0 = "8155";
    public static final String I1 = "7210";
    public static final String I2 = "400";
    public static final String I3 = "200003";
    public static final String J = "51";
    public static final String J0 = "8156";
    public static final String J1 = "7212";
    public static final String J2 = "510";
    public static final String J3 = "200004";
    public static final String K = "52";
    public static final String K0 = "46";
    public static final String K1 = "7213";
    public static final String K2 = "522";
    public static final String K3 = "200005";
    public static final String L = "53";
    public static final String L0 = "47";
    public static final String L1 = "7214";
    public static final String L2 = "520";
    public static final String L3 = "200006";
    public static final String M = "54";
    public static final String M0 = "48";
    public static final String M1 = "7215";
    public static final String M2 = "521";
    public static final String M3 = "200007";
    public static final String N = "55";
    public static final String N0 = "49";
    public static final String N1 = "7234";
    public static final String N2 = "523";
    public static final String N3 = "200008";
    public static final String O = "56";
    public static final String O0 = "86";
    public static final String O1 = "7235";
    public static final String O2 = "610";
    public static final String O3 = "200009";
    public static final String P = "57";
    public static final String P0 = "87";
    public static final String P1 = "7232";
    public static final String P2 = "699";
    public static final String P3 = "200010";
    public static final String Q = "58";
    public static final String Q0 = "88";
    public static final String Q1 = "7233";
    public static final String Q2 = "7216";
    public static final String Q3 = "200011";
    public static final String R = "59";
    public static final String R0 = "89";
    public static final String R1 = "7236";
    public static final String R2 = "7217";
    public static final String R3 = "200012";
    public static final String S = "60";
    public static final String S0 = "91";
    public static final String S1 = "7237";
    public static final String S2 = "7218";
    public static final String S3 = "200013";
    public static final String T = "62";
    public static final String T0 = "8104";
    public static final String T1 = "7240";
    public static final String T2 = "7219";
    public static final String T3 = "200014";
    public static final String U = "63";
    public static final String U0 = "8125";
    public static final String U1 = "7241";
    public static final String U2 = "7220";
    public static final String U3 = "200015";
    public static final String V = "64";
    public static final String V0 = "92";
    public static final String V1 = "7242";
    public static final String V2 = "7221";
    public static final String V3 = "200016";
    public static final String W = "65";
    public static final String W0 = "8108";
    public static final String W1 = "7243";
    public static final String W2 = "7222";
    private static final int W3 = 10;
    public static final String X = "66";
    public static final String X0 = "94";
    public static final String X1 = "7244";
    public static final String X2 = "7223";
    private static volatile PVSourceEvent X3 = null;
    public static final String Y = "68";
    public static final String Y0 = "95";
    public static final String Y1 = "7245";
    public static final String Y2 = "7224";
    private static final /* synthetic */ c.b Y3 = null;
    public static final String Z = "69";
    public static final String Z0 = "96";
    public static final String Z1 = "7246";
    public static final String Z2 = "7225";
    public static final String a0 = "70";
    public static final String a1 = "97";
    public static final String a2 = "7247";
    public static final String a3 = "7226";
    public static final String b0 = "72";
    public static final String b1 = "98";
    public static final String b2 = "7248";
    public static final String b3 = "7227";
    public static final String c0 = "73";
    public static final String c1 = "99";
    public static final String c2 = "7249";
    public static final String c3 = "7228";
    public static final String d0 = "74";
    public static final String d1 = "61";
    public static final String d2 = "7250";
    public static final String d3 = "7229";
    public static final String e0 = "75";
    public static final String e1 = "90";
    public static final String e2 = "7251";
    public static final String e3 = "7258";
    public static final String f = "1";
    public static final String f0 = "76";
    public static final String f1 = "6300";
    public static final String f2 = "7254";
    public static final String f3 = "7259";
    public static final String g = "9101";
    public static final String g0 = "77";
    public static final String g1 = "1";
    public static final String g2 = "7258";
    public static final String g3 = "7230";
    public static final String h = "2";
    public static final String h0 = "78";
    public static final String h1 = "2";
    public static final String h2 = "11001";
    public static final String h3 = "8142";
    public static final String i = "3";
    public static final String i0 = "79";
    public static final String i1 = "7100";
    public static final String i2 = "11002";
    public static final String i3 = "8143";
    public static final String j = "4";
    public static final String j0 = "80";
    public static final String j1 = "7101";
    public static final String j2 = "7106";
    public static final String j3 = "7231";
    public static final String k = "5";
    public static final String k0 = "82";
    public static final String k1 = "7102";
    public static final String k2 = "7107";
    public static final String k3 = "8122";
    public static final String l = "18";
    public static final String l0 = "81";
    public static final String l1 = "7103";
    public static final String l2 = "1023";
    public static final String l3 = "8123";
    public static final String m = "19";
    public static final String m0 = "83";
    public static final String m1 = "7104";
    public static final String m2 = "1026";
    public static final String m3 = "7252";
    public static final String n = "20";
    public static final String n0 = "84";
    public static final String n1 = "7105";
    public static final String n2 = "1027";
    public static final String n3 = "7253";
    public static final String o = "8131";
    public static final String o0 = "85";
    public static final String o1 = "8100";
    public static final String o2 = "1101";
    public static final String o3 = "8136";
    public static final String p = "8132";
    public static final String p0 = "2001";
    public static final String p1 = "8101";
    public static final String p2 = "8110";
    public static final String p3 = "8137";
    public static final String q = "21";
    public static final String q0 = "2002";
    public static final String q1 = "8102";
    public static final String q2 = "8111";
    public static final String q3 = "8138";
    public static final String r = "8107";
    public static final String r0 = "6002";
    public static final String r1 = "8109";
    public static final String r2 = "8112";
    public static final String r3 = "8139";
    public static final String s = "22";
    public static final String s0 = "8117";
    public static final String s1 = "9100";
    public static final String s2 = "10001";
    public static final String s3 = "8140";
    public static final String t = "23";
    public static final String t0 = "8120";
    public static final String t1 = "9102";
    public static final String t2 = "10002";
    public static final String t3 = "7256";
    public static final String u = "24";
    public static final String u0 = "8121";
    public static final String u1 = "9103";
    public static final String u2 = "1";
    public static final String u3 = "7257";
    public static final String v = "25";
    public static final String v0 = "8127";
    public static final String v1 = "6000";
    public static final String v2 = "2";
    public static final String v3 = "7255";
    public static final String w = "26";
    public static final String w0 = "8128";
    public static final String w1 = "3000";
    public static final String w2 = "3";
    public static final String w3 = "100012";
    public static final String x = "27";
    public static final String x0 = "8129";
    public static final String x1 = "5100";
    public static final String x2 = "4";
    public static final String x3 = "100013";
    public static final String y = "28";
    public static final String y0 = "17";
    public static final String y1 = "7201";
    public static final String y2 = "5";
    public static final String y3 = "100036";
    public static final String z = "29";
    public static final String z0 = "8141";
    public static final String z1 = "7202";
    public static final String z2 = "6";
    public static final String z3 = "100038";
    private j.l.c.x.t0.a e;

    static {
        c();
    }

    private PVSourceEvent(Context context) {
        super(context);
        ((a) this).c = context;
        this.e = j.l.c.x.t0.a.a();
    }

    private static /* synthetic */ void c() {
        e eVar = new e("PVSourceEvent.java", PVSourceEvent.class);
        Y3 = eVar.H("method-execution", eVar.E("1", "sendPlayerPVData", "com.hunantv.mpdt.statistics.bigdata.PVSourceEvent", "java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:int:int:boolean:java.lang.String", "cpn:cpid:cid:plid:oldfpa:cma:ctl:pt:bdid:bsid:ftl:fpt:dateNo:isfull:isAuto:b:lob", "", "void"), 583);
    }

    public static PVSourceEvent e(Context context) {
        if (X3 == null) {
            synchronized (PVSourceEvent.class) {
                if (X3 == null) {
                    X3 = new PVSourceEvent(context.getApplicationContext());
                }
            }
        }
        return X3;
    }

    private String f() {
        String str;
        if (TextUtils.isEmpty(j.l.c.x.t0.a.a().y) && TextUtils.isEmpty(j.l.c.x.t0.a.a().z)) {
            str = "";
        } else {
            str = j.l.c.x.t0.a.a().y + "," + j.l.c.x.t0.a.a().z;
        }
        j.l.c.x.t0.a.a().y = j.l.c.x.t0.a.a().z;
        j.l.c.x.t0.a.a().z = "";
        return str;
    }

    public static String g() {
        String str = j.l.c.x.t0.a.a().g;
        if (n0.y(str)) {
            String uuid = UUID.randomUUID().toString();
            j.l.c.x.t0.a.a().g = uuid;
            return uuid;
        }
        return str;
    }

    private String h(String str, String str2) {
        if (TextUtils.equals(str, "19") || !TextUtils.equals(str2, "19") || TextUtils.isEmpty(this.e.F)) {
            return "";
        }
        return i() + "&" + this.e.F;
    }

    public static String i() {
        String str = j.l.c.x.t0.a.a().h;
        if (n0.y(str)) {
            String uuid = UUID.randomUUID().toString();
            j.l.c.x.t0.a.a().h = uuid;
            return uuid;
        }
        return str;
    }

    private String k(String str) {
        return str == null ? "" : str;
    }

    @Deprecated
    private void n(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
    }

    public static final /* synthetic */ void v(PVSourceEvent pVSourceEvent, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i4, int i5, boolean z4, String str14, c cVar) {
    }

    public String a() {
        return !j.l.a.b0.e.W0() ? "https://aphone.v1.mgtv.com/dispatcher.do" : "https://hd-mobile-v1.log.mgtv.com/dispatcher.do";
    }

    public void b() {
        ((a) this).a = j.l.b.g.c.f();
    }

    public void d() {
        j.l.c.x.t0.a aVar = this.e;
        aVar.i = "";
        aVar.j = "";
        j.l.c.x.t0.a.a().C = "";
        j.l.c.x.t0.a aVar2 = this.e;
        aVar2.y = "";
        aVar2.m = "";
        aVar2.h = "";
        aVar2.g = "";
        aVar2.B = "";
        aVar2.A = "";
    }

    public void j() {
        j.l.c.x.t0.a aVar = this.e;
        aVar.i = "";
        aVar.j = "";
        j.l.c.x.t0.a.a().C = "";
        j.l.c.x.t0.a aVar2 = this.e;
        aVar2.m = "";
        aVar2.B = "";
        aVar2.A = "";
        if (TextUtils.isEmpty(aVar2.h)) {
            this.e.h = UUID.randomUUID().toString();
        }
    }

    @Deprecated
    public void l(String str, String str2, String str3, String str4) {
    }

    public void m() {
        this.e.g();
        j.l.c.x.t0.a aVar = this.e;
        aVar.b = "";
        aVar.c = "";
    }

    @Deprecated
    public void o(String str, String str2, String str3, String str4, String str5) {
    }

    @Deprecated
    public void p(String str, String str2, String str3, String str4, String str5) {
        q(str, str2, str3, str4, str5, null);
    }

    @Deprecated
    public void q(String str, String str2, String str3, String str4, String str5, String str6) {
        r(str, str2, str3, str4, str5, str6, "");
    }

    @Deprecated
    public void r(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
    }

    @Deprecated
    public void s(String str, String str2, String str3) {
        j.l.c.x.t0.a aVar = this.e;
        n(str, str2, str3, "", "", aVar.c, aVar.b);
    }

    @WithTryCatchRuntime
    @Deprecated
    public void sendPlayerPVData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i4, int i5, boolean z4, String str14) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new v(new Object[]{this, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, r.a.c.b.e.k(i4), r.a.c.b.e.k(i5), r.a.c.b.e.a(z4), str14, e.y(Y3, this, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, r.a.c.b.e.k(i4), r.a.c.b.e.k(i5), r.a.c.b.e.a(z4), str14})}).e(69648));
    }

    @Deprecated
    public void t(String str, String str2, String str3, String str4, String str5, String str6) {
    }

    @Deprecated
    public void u(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        n(str, str2, str3, str4, str5, str6, str7);
    }

    @Deprecated
    public void w(String str, String str2, String str3, boolean z4) {
    }
}
