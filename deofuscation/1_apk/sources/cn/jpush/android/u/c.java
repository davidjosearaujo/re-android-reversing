package cn.jpush.android.u;

import android.annotation.SuppressLint;
import cn.jpush.android.helper.Logger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c extends e {
    private int w;
    private double x;
    private float y;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        private int a;
        private double b;
        private float c;
        private cn.jpush.android.d.d d;

        public a a(float f) {
            this.b = Math.min(Math.max(f, 0.0f), 1.0f);
            return this;
        }

        @SuppressLint({"RtlHardcoded"})
        public a a(int i) {
            int i2;
            i = (i > 1 || i < 0) ? 0 : 0;
            if (i != 0) {
                i2 = i == 1 ? 51 : 53;
                return this;
            }
            this.a = i2;
            return this;
        }

        public a a(cn.jpush.android.d.d dVar) {
            this.d = dVar;
            return this;
        }

        public c a() {
            Logger.d("InAppFloatMessage", "build InAppFloatMessage object, floatMarginYPer: " + this.b);
            return new c(this.a, this.b, this.c, this.d);
        }

        public a b(float f) {
            this.c = f * 1000.0f;
            return this;
        }
    }

    private c(int i, double d, float f, cn.jpush.android.d.d dVar) {
        super(dVar);
        this.w = i;
        this.x = d;
        this.y = f;
    }

    public static a d() {
        return new a();
    }

    public int a() {
        return this.w;
    }

    public double b() {
        return this.x;
    }

    public float c() {
        return this.y;
    }
}
