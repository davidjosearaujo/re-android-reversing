package cn.jpush.android.x;

import android.graphics.Bitmap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    private int a = 0;
    private int b;
    private Object c;
    private Bitmap d;
    private int e;

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(Bitmap bitmap) {
        this.d = bitmap;
    }

    public void a(Object obj) {
        this.c = obj;
    }

    public Object b() {
        return this.c;
    }

    public void b(int i) {
        this.e = i;
    }

    public Bitmap c() {
        return this.d;
    }

    public void c(int i) {
        this.a = i;
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.a;
    }
}
