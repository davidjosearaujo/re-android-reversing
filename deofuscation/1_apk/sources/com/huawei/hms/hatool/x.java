package com.huawei.hms.hatool;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class x {
    public static x b = new x();
    public a a = new a();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a {
        public String a;
        public String b;
        public long c = 0;

        public a() {
            x.this = r3;
        }

        public void a(long j) {
            x.this.a.c = j;
        }

        public void a(String str) {
            x.this.a.b = str;
        }

        public void b(String str) {
            x.this.a.a = str;
        }
    }

    public static x d() {
        return b;
    }

    public String a() {
        return this.a.b;
    }

    public void a(String str, String str2) {
        long b2 = b();
        String b3 = r0.b(str, str2);
        if (b3 == null || b3.isEmpty()) {
            y.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (b2 == 0) {
            b2 = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - b2 <= 43200000) {
            return;
        }
        String e = j.k.c.a.a.h.g.b.e(16);
        String a2 = e.a(b3, e);
        this.a.a(b2);
        this.a.b(e);
        this.a.a(a2);
    }

    public long b() {
        return this.a.c;
    }

    public String c() {
        return this.a.a;
    }
}
