package com.alipay.security.mobile.module.http.model;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c extends a {
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;
    public static final String o = "APPKEY_ERROR";
    public static final String p = "SUCCESS";
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k = "";

    public String a() {
        String str = this.f;
        return str == null ? "0" : str;
    }

    public boolean b() {
        return "1".equals(this.e);
    }

    public int c() {
        return this.a ? com.alipay.security.mobile.module.a.a.a(this.c) ? 2 : 1 : o.equals(this.b) ? 3 : 2;
    }
}
