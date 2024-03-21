package a.a.a.e;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    static final l f112a;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class a extends k {
        a() {
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class b implements l {
        b() {
        }

        @Override // a.a.a.e.f.l
        public boolean a(View view) {
            return g.a(view);
        }

        @Override // a.a.a.e.f.l
        public String b(View view) {
            return null;
        }

        @Override // a.a.a.e.f.l
        public int c(View view) {
            return 0;
        }

        @Override // a.a.a.e.f.l
        public void d(View view, boolean z) {
        }

        @Override // a.a.a.e.f.l
        public boolean e(View view) {
            return true;
        }

        @Override // a.a.a.e.f.l
        public void f(View view, int i, Paint paint) {
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class c extends b {
        c() {
        }

        @Override // a.a.a.e.f.b, a.a.a.e.f.l
        public int c(View view) {
            return h.a(view);
        }

        @Override // a.a.a.e.f.b, a.a.a.e.f.l
        public void d(View view, boolean z) {
            h.c(view, z);
        }

        @Override // a.a.a.e.f.b, a.a.a.e.f.l
        public void f(View view, int i, Paint paint) {
            h.b(view, i, paint);
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class d extends e {
        d() {
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class e extends c {
        e() {
        }
    }

    /* renamed from: a.a.a.e.f$f  reason: collision with other inner class name */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class C0003f extends d {
        C0003f() {
        }

        @Override // a.a.a.e.f.b, a.a.a.e.f.l
        public boolean e(View view) {
            return i.a(view);
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class g extends C0003f {
        g() {
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class h extends g {
        h() {
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class i extends h {
        i() {
        }

        @Override // a.a.a.e.f.b, a.a.a.e.f.l
        public boolean a(View view) {
            return j.a(view);
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class j extends i {
        j() {
        }

        @Override // a.a.a.e.f.b, a.a.a.e.f.l
        public String b(View view) {
            return k.a(view);
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class k extends j {
        k() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public interface l {
        boolean a(View view);

        String b(View view);

        int c(View view);

        void d(View view, boolean z);

        boolean e(View view);

        void f(View view, int i, Paint paint);
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f112a = a.a.a.c.a.a() ? new a() : i2 >= 23 ? new k() : i2 >= 21 ? new j() : i2 >= 19 ? new i() : i2 >= 18 ? new h() : i2 >= 17 ? new g() : i2 >= 16 ? new C0003f() : i2 >= 15 ? new d() : i2 >= 14 ? new e() : i2 >= 11 ? new c() : new b();
    }

    public static int a(View view) {
        return f112a.c(view);
    }

    public static String b(View view) {
        return f112a.b(view);
    }

    public static boolean c(View view) {
        return f112a.e(view);
    }

    public static boolean d(View view) {
        return f112a.a(view);
    }

    public static void e(View view, int i2, Paint paint) {
        f112a.f(view, i2, paint);
    }

    public static void f(View view, boolean z) {
        f112a.d(view, z);
    }
}
