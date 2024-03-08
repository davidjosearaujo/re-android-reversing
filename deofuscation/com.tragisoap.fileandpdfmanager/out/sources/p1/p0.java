package p1;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import androidx.fragment.app.s0;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.WeakHashMap;
import p1.d;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class p0 {

    /* renamed from: b */
    public static final p0 f5509b = i.f5525l;

    /* renamed from: a */
    public final j f5510a;

    @SuppressLint({"SoonBlockedPrivateApi"})
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {

        /* renamed from: a */
        public static Field f5511a;

        /* renamed from: b */
        public static Field f5512b;

        /* renamed from: c */
        public static Field f5513c;

        /* renamed from: d */
        public static boolean f5514d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f5511a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f5512b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f5513c = declaredField3;
                declaredField3.setAccessible(true);
                f5514d = true;
            } catch (ReflectiveOperationException e) {
                StringBuilder d7 = androidx.activity.h.d("Failed to get visible insets from AttachInfo ");
                d7.append(e.getMessage());
                Log.w("WindowInsetsCompat", d7.toString(), e);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b extends d {

        /* renamed from: b */
        public final WindowInsets.Builder f5515b;

        public b() {
            this.f5515b = new WindowInsets.Builder();
        }

        public b(p0 p0Var) {
            super(p0Var);
            WindowInsets g2 = p0Var.g();
            this.f5515b = g2 != null ? new WindowInsets.Builder(g2) : new WindowInsets.Builder();
        }

        @Override // p1.p0.d
        public p0 b() {
            a();
            p0 h7 = p0.h(null, this.f5515b.build());
            h7.f5510a.o(null);
            return h7;
        }

        @Override // p1.p0.d
        public void c(i1.b bVar) {
            this.f5515b.setMandatorySystemGestureInsets(bVar.d());
        }

        @Override // p1.p0.d
        public void d(i1.b bVar) {
            this.f5515b.setStableInsets(bVar.d());
        }

        @Override // p1.p0.d
        public void e(i1.b bVar) {
            this.f5515b.setSystemGestureInsets(bVar.d());
        }

        @Override // p1.p0.d
        public void f(i1.b bVar) {
            this.f5515b.setSystemWindowInsets(bVar.d());
        }

        @Override // p1.p0.d
        public void g(i1.b bVar) {
            this.f5515b.setTappableElementInsets(bVar.d());
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c extends b {
        public c() {
        }

        public c(p0 p0Var) {
            super(p0Var);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d {

        /* renamed from: a */
        public final p0 f5516a;

        public d() {
            this(new p0());
        }

        public d(p0 p0Var) {
            this.f5516a = p0Var;
        }

        public final void a() {
        }

        public p0 b() {
            throw null;
        }

        public void c(i1.b bVar) {
            throw null;
        }

        public void d(i1.b bVar) {
            throw null;
        }

        public void e(i1.b bVar) {
            throw null;
        }

        public void f(i1.b bVar) {
            throw null;
        }

        public void g(i1.b bVar) {
            throw null;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class e extends j {

        /* renamed from: c */
        public final WindowInsets f5517c;

        /* renamed from: d */
        public i1.b[] f5518d;
        public i1.b e = null;

        /* renamed from: f */
        public p0 f5519f;

        /* renamed from: g */
        public i1.b f5520g;

        public e(p0 p0Var, WindowInsets windowInsets) {
            super(p0Var);
            this.f5517c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private i1.b q(int i7, boolean z6) {
            i1.b bVar = i1.b.e;
            for (int i8 = 1; i8 <= 256; i8 <<= 1) {
                if ((i7 & i8) != 0) {
                    bVar = i1.b.a(bVar, r(i8, z6));
                }
            }
            return bVar;
        }

        private i1.b s() {
            p0 p0Var = this.f5519f;
            return p0Var != null ? p0Var.f5510a.h() : i1.b.e;
        }

        private i1.b t(View view) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // p1.p0.j
        public void d(View view) {
            i1.b t5 = t(view);
            if (t5 == null) {
                t5 = i1.b.e;
            }
            u(t5);
        }

        @Override // p1.p0.j
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f5520g, ((e) obj).f5520g);
        }

        @Override // p1.p0.j
        public i1.b f(int i7) {
            return q(i7, false);
        }

        @Override // p1.p0.j
        public final i1.b j() {
            if (this.e == null) {
                this.e = i1.b.b(this.f5517c.getSystemWindowInsetLeft(), this.f5517c.getSystemWindowInsetTop(), this.f5517c.getSystemWindowInsetRight(), this.f5517c.getSystemWindowInsetBottom());
            }
            return this.e;
        }

        @Override // p1.p0.j
        public p0 l(int i7, int i8, int i9, int i10) {
            c cVar = new c(p0.h(null, this.f5517c));
            cVar.f(p0.f(j(), i7, i8, i9, i10));
            cVar.d(p0.f(h(), i7, i8, i9, i10));
            return cVar.b();
        }

        @Override // p1.p0.j
        public boolean n() {
            return this.f5517c.isRound();
        }

        @Override // p1.p0.j
        public void o(i1.b[] bVarArr) {
            this.f5518d = bVarArr;
        }

        @Override // p1.p0.j
        public void p(p0 p0Var) {
            this.f5519f = p0Var;
        }

        public i1.b r(int i7, boolean z6) {
            int i8;
            if (i7 == 1) {
                return z6 ? i1.b.b(0, Math.max(s().f4463b, j().f4463b), 0, 0) : i1.b.b(0, j().f4463b, 0, 0);
            }
            i1.b bVar = null;
            if (i7 != 2) {
                if (i7 == 8) {
                    i1.b[] bVarArr = this.f5518d;
                    if (bVarArr != null) {
                        bVar = bVarArr[k.a(8)];
                    }
                    if (bVar != null) {
                        return bVar;
                    }
                    i1.b j7 = j();
                    i1.b s = s();
                    int i9 = j7.f4465d;
                    if (i9 > s.f4465d) {
                        return i1.b.b(0, 0, 0, i9);
                    }
                    i1.b bVar2 = this.f5520g;
                    return (bVar2 == null || bVar2.equals(i1.b.e) || (i8 = this.f5520g.f4465d) <= s.f4465d) ? i1.b.e : i1.b.b(0, 0, 0, i8);
                } else if (i7 == 16) {
                    return i();
                } else {
                    if (i7 == 32) {
                        return g();
                    }
                    if (i7 == 64) {
                        return k();
                    }
                    if (i7 != 128) {
                        return i1.b.e;
                    }
                    p0 p0Var = this.f5519f;
                    d e = p0Var != null ? p0Var.f5510a.e() : e();
                    return e != null ? i1.b.b(d.a.d(e.f5481a), d.a.f(e.f5481a), d.a.e(e.f5481a), d.a.c(e.f5481a)) : i1.b.e;
                }
            } else if (z6) {
                i1.b s6 = s();
                i1.b h7 = h();
                return i1.b.b(Math.max(s6.f4462a, h7.f4462a), 0, Math.max(s6.f4464c, h7.f4464c), Math.max(s6.f4465d, h7.f4465d));
            } else {
                i1.b j8 = j();
                p0 p0Var2 = this.f5519f;
                if (p0Var2 != null) {
                    bVar = p0Var2.f5510a.h();
                }
                int i10 = j8.f4465d;
                if (bVar != null) {
                    i10 = Math.min(i10, bVar.f4465d);
                }
                return i1.b.b(j8.f4462a, 0, j8.f4464c, i10);
            }
        }

        public void u(i1.b bVar) {
            this.f5520g = bVar;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class f extends e {

        /* renamed from: h */
        public i1.b f5521h = null;

        public f(p0 p0Var, WindowInsets windowInsets) {
            super(p0Var, windowInsets);
        }

        @Override // p1.p0.j
        public p0 b() {
            return p0.h(null, this.f5517c.consumeStableInsets());
        }

        @Override // p1.p0.j
        public p0 c() {
            return p0.h(null, this.f5517c.consumeSystemWindowInsets());
        }

        @Override // p1.p0.j
        public final i1.b h() {
            if (this.f5521h == null) {
                this.f5521h = i1.b.b(this.f5517c.getStableInsetLeft(), this.f5517c.getStableInsetTop(), this.f5517c.getStableInsetRight(), this.f5517c.getStableInsetBottom());
            }
            return this.f5521h;
        }

        @Override // p1.p0.j
        public boolean m() {
            return this.f5517c.isConsumed();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class g extends f {
        public g(p0 p0Var, WindowInsets windowInsets) {
            super(p0Var, windowInsets);
        }

        @Override // p1.p0.j
        public p0 a() {
            return p0.h(null, this.f5517c.consumeDisplayCutout());
        }

        @Override // p1.p0.j
        public d e() {
            DisplayCutout displayCutout = this.f5517c.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new d(displayCutout);
        }

        @Override // p1.p0.e, p1.p0.j
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return Objects.equals(this.f5517c, gVar.f5517c) && Objects.equals(this.f5520g, gVar.f5520g);
        }

        @Override // p1.p0.j
        public int hashCode() {
            return this.f5517c.hashCode();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class h extends g {

        /* renamed from: i */
        public i1.b f5522i = null;

        /* renamed from: j */
        public i1.b f5523j = null;

        /* renamed from: k */
        public i1.b f5524k = null;

        public h(p0 p0Var, WindowInsets windowInsets) {
            super(p0Var, windowInsets);
        }

        @Override // p1.p0.j
        public i1.b g() {
            if (this.f5523j == null) {
                this.f5523j = i1.b.c(this.f5517c.getMandatorySystemGestureInsets());
            }
            return this.f5523j;
        }

        @Override // p1.p0.j
        public i1.b i() {
            if (this.f5522i == null) {
                this.f5522i = i1.b.c(this.f5517c.getSystemGestureInsets());
            }
            return this.f5522i;
        }

        @Override // p1.p0.j
        public i1.b k() {
            if (this.f5524k == null) {
                this.f5524k = i1.b.c(this.f5517c.getTappableElementInsets());
            }
            return this.f5524k;
        }

        @Override // p1.p0.e, p1.p0.j
        public p0 l(int i7, int i8, int i9, int i10) {
            return p0.h(null, this.f5517c.inset(i7, i8, i9, i10));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class i extends h {

        /* renamed from: l */
        public static final p0 f5525l = p0.h(null, WindowInsets.CONSUMED);

        public i(p0 p0Var, WindowInsets windowInsets) {
            super(p0Var, windowInsets);
        }

        @Override // p1.p0.e, p1.p0.j
        public final void d(View view) {
        }

        @Override // p1.p0.e, p1.p0.j
        public i1.b f(int i7) {
            return i1.b.c(this.f5517c.getInsets(l.a(i7)));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class j {

        /* renamed from: b */
        public static final p0 f5526b = new c().b().f5510a.a().f5510a.b().f5510a.c();

        /* renamed from: a */
        public final p0 f5527a;

        public j(p0 p0Var) {
            this.f5527a = p0Var;
        }

        public p0 a() {
            return this.f5527a;
        }

        public p0 b() {
            return this.f5527a;
        }

        public p0 c() {
            return this.f5527a;
        }

        public void d(View view) {
        }

        public d e() {
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return n() == jVar.n() && m() == jVar.m() && o1.b.a(j(), jVar.j()) && o1.b.a(h(), jVar.h()) && o1.b.a(e(), jVar.e());
        }

        public i1.b f(int i7) {
            return i1.b.e;
        }

        public i1.b g() {
            return j();
        }

        public i1.b h() {
            return i1.b.e;
        }

        public int hashCode() {
            return o1.b.b(Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), e());
        }

        public i1.b i() {
            return j();
        }

        public i1.b j() {
            return i1.b.e;
        }

        public i1.b k() {
            return j();
        }

        public p0 l(int i7, int i8, int i9, int i10) {
            return f5526b;
        }

        public boolean m() {
            return false;
        }

        public boolean n() {
            return false;
        }

        public void o(i1.b[] bVarArr) {
        }

        public void p(p0 p0Var) {
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class k {
        public static int a(int i7) {
            if (i7 == 1) {
                return 0;
            }
            if (i7 == 2) {
                return 1;
            }
            if (i7 == 4) {
                return 2;
            }
            if (i7 == 8) {
                return 3;
            }
            if (i7 == 16) {
                return 4;
            }
            if (i7 == 32) {
                return 5;
            }
            if (i7 == 64) {
                return 6;
            }
            if (i7 == 128) {
                return 7;
            }
            if (i7 == 256) {
                return 8;
            }
            throw new IllegalArgumentException(s0.g("type needs to be >= FIRST and <= LAST, type=", i7));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class l {
        public static int a(int i7) {
            int i8;
            int i9 = 0;
            for (int i10 = 1; i10 <= 256; i10 <<= 1) {
                if ((i7 & i10) != 0) {
                    if (i10 == 1) {
                        i8 = WindowInsets.Type.statusBars();
                    } else if (i10 == 2) {
                        i8 = WindowInsets.Type.navigationBars();
                    } else if (i10 == 4) {
                        i8 = WindowInsets.Type.captionBar();
                    } else if (i10 == 8) {
                        i8 = WindowInsets.Type.ime();
                    } else if (i10 == 16) {
                        i8 = WindowInsets.Type.systemGestures();
                    } else if (i10 == 32) {
                        i8 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i10 == 64) {
                        i8 = WindowInsets.Type.tappableElement();
                    } else if (i10 == 128) {
                        i8 = WindowInsets.Type.displayCutout();
                    }
                    i9 |= i8;
                }
            }
            return i9;
        }
    }

    public p0() {
        this.f5510a = new j(this);
    }

    public p0(WindowInsets windowInsets) {
        this.f5510a = new i(this, windowInsets);
    }

    public static i1.b f(i1.b bVar, int i7, int i8, int i9, int i10) {
        int max = Math.max(0, bVar.f4462a - i7);
        int max2 = Math.max(0, bVar.f4463b - i8);
        int max3 = Math.max(0, bVar.f4464c - i9);
        int max4 = Math.max(0, bVar.f4465d - i10);
        return (max == i7 && max2 == i8 && max3 == i9 && max4 == i10) ? bVar : i1.b.b(max, max2, max3, max4);
    }

    public static p0 h(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        p0 p0Var = new p0(windowInsets);
        if (view != null) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            if (y.g.b(view)) {
                p0Var.f5510a.p(y.j.a(view));
                p0Var.f5510a.d(view.getRootView());
            }
        }
        return p0Var;
    }

    public final i1.b a(int i7) {
        return this.f5510a.f(i7);
    }

    @Deprecated
    public final int b() {
        return this.f5510a.j().f4465d;
    }

    @Deprecated
    public final int c() {
        return this.f5510a.j().f4462a;
    }

    @Deprecated
    public final int d() {
        return this.f5510a.j().f4464c;
    }

    @Deprecated
    public final int e() {
        return this.f5510a.j().f4463b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return false;
        }
        return o1.b.a(this.f5510a, ((p0) obj).f5510a);
    }

    public final WindowInsets g() {
        j jVar = this.f5510a;
        if (jVar instanceof e) {
            return ((e) jVar).f5517c;
        }
        return null;
    }

    public final int hashCode() {
        j jVar = this.f5510a;
        if (jVar == null) {
            return 0;
        }
        return jVar.hashCode();
    }
}
