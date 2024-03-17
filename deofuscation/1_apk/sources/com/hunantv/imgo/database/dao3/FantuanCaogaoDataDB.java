package com.hunantv.imgo.database.dao3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FantuanCaogaoDataDB {
    private Long a;
    private String b;
    private Long c;
    private String d;
    private String e;
    private int f;
    private String g;
    private String h;
    private String i;
    private int j;
    private FantuanDescription k;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class FantuanDescription implements Serializable {
        private static final long serialVersionUID = 9183664371202236330L;
        public String mContent;
        public List<InnerKeyword> mKeywordList;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class InnerKeyword implements Serializable {
            private static final long serialVersionUID = -4434123541284633101L;
            public String mKeyword;
            public int mStartOffset;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a implements r.c.b.k.a<FantuanDescription, byte[]> {
        /* renamed from: c */
        public byte[] b(FantuanDescription fantuanDescription) {
            if (fantuanDescription == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                new ObjectOutputStream(byteArrayOutputStream).writeObject(fantuanDescription);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        /* renamed from: d */
        public FantuanDescription a(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    FantuanDescription fantuanDescription = (FantuanDescription) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return fantuanDescription;
                } catch (ClassNotFoundException e3) {
                    e3.printStackTrace();
                    return null;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }

    public FantuanCaogaoDataDB(Long l, String str, Long l2, String str2, String str3, int i, String str4, String str5, String str6, int i2, FantuanDescription fantuanDescription) {
        this.a = l;
        this.b = str;
        this.c = l2;
        this.d = str2;
        this.e = str3;
        this.f = i;
        this.g = str4;
        this.h = str5;
        this.i = str6;
        this.j = i2;
        this.k = fantuanDescription;
    }

    public String a() {
        return this.e;
    }

    public FantuanDescription b() {
        return this.k;
    }

    public String c() {
        return this.i;
    }

    public String d() {
        return this.h;
    }

    public String e() {
        return this.g;
    }

    public Long f() {
        return this.c;
    }

    public String g() {
        return this.d;
    }

    public int h() {
        return this.f;
    }

    public int i() {
        return this.j;
    }

    public String j() {
        return this.b;
    }

    public Long k() {
        return this.a;
    }

    public void l(String str) {
        this.e = str;
    }

    public void m(FantuanDescription fantuanDescription) {
        this.k = fantuanDescription;
    }

    public void n(String str) {
        this.i = str;
    }

    public void o(String str) {
        this.h = str;
    }

    public void p(String str) {
        this.g = str;
    }

    public void q(Long l) {
        this.c = l;
    }

    public void r(String str) {
        this.d = str;
    }

    public void s(int i) {
        this.f = i;
    }

    public void t(int i) {
        this.j = i;
    }

    public void u(String str) {
        this.b = str;
    }

    public void v(Long l) {
        this.a = l;
    }

    public FantuanCaogaoDataDB() {
    }
}
