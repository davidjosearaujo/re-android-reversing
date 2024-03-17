package cn.jpush.android.u;

import cn.jpush.android.helper.Logger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b extends e {
    private int A;
    private int B;
    private int C;
    private int D;
    private float w;
    private float x;
    private float y;
    private int z;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        public int a = 0;
        private float b;
        private float c;
        private float d;
        private int e;
        private int f;
        private int g;
        private int h;
        private cn.jpush.android.d.d i;

        public a a(float f) {
            this.b = f * 1000.0f;
            return this;
        }

        public a a(int i) {
            this.e = i;
            return this;
        }

        public a a(cn.jpush.android.d.d dVar) {
            this.i = dVar;
            return this;
        }

        public b a() {
            Logger.d("InAppBannerMessage", "build InAppBannerMessage object");
            return new b(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.a, this.i);
        }

        public a b(float f) {
            this.c = f * 1000.0f;
            return this;
        }

        public a b(int i) {
            this.f = i;
            return this;
        }

        public a c(float f) {
            this.d = f * 1000.0f;
            return this;
        }

        public a c(int i) {
            this.g = i;
            return this;
        }

        public a d(int i) {
            this.h = i;
            return this;
        }

        public a e(int i) {
            this.a = i;
            return this;
        }
    }

    private b(float f, float f2, float f3, int i, int i2, int i3, int i4, int i5, cn.jpush.android.d.d dVar) {
        super(dVar);
        this.w = f;
        this.x = f2;
        this.y = f3;
        this.z = i;
        this.A = i2;
        this.B = i3;
        this.C = i4;
        this.D = i5;
    }

    public static a j() {
        return new a();
    }

    public boolean a() {
        return this.C == 1;
    }

    public boolean b() {
        return this.D == 1;
    }

    public int c() {
        return this.z;
    }

    public int d() {
        return this.A;
    }

    public int e() {
        return this.B;
    }

    public boolean f() {
        return this.w > 0.0f;
    }

    public float g() {
        return this.w;
    }

    public float h() {
        return this.x;
    }

    public float i() {
        return this.y;
    }
}
