package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.c;
import f.h;

/* loaded from: classes.dex */
public final class c1 implements g0 {

    /* renamed from: a */
    public Toolbar f865a;

    /* renamed from: b */
    public int f866b;

    /* renamed from: c */
    public t0 f867c;

    /* renamed from: d */
    public View f868d;
    public Drawable e;

    /* renamed from: f */
    public Drawable f869f;

    /* renamed from: g */
    public Drawable f870g;

    /* renamed from: h */
    public boolean f871h;

    /* renamed from: i */
    public CharSequence f872i;

    /* renamed from: j */
    public CharSequence f873j;

    /* renamed from: k */
    public CharSequence f874k;

    /* renamed from: l */
    public Window.Callback f875l;
    public boolean m;

    /* renamed from: n */
    public c f876n;

    /* renamed from: o */
    public int f877o;

    /* renamed from: p */
    public Drawable f878p;

    /* loaded from: classes.dex */
    public class a extends l0.z {
        public boolean L = false;
        public final /* synthetic */ int M;

        public a(int i7) {
            c1.this = r1;
            this.M = i7;
        }

        @Override // p1.l0
        public final void a() {
            if (this.L) {
                return;
            }
            c1.this.f865a.setVisibility(this.M);
        }

        @Override // l0.z, p1.l0
        public final void b(View view) {
            this.L = true;
        }

        @Override // l0.z, p1.l0
        public final void c() {
            c1.this.f865a.setVisibility(0);
        }
    }

    public c1(Toolbar toolbar, boolean z6) {
        Drawable drawable;
        this.f877o = 0;
        this.f865a = toolbar;
        this.f872i = toolbar.getTitle();
        this.f873j = toolbar.getSubtitle();
        this.f871h = this.f872i != null;
        this.f870g = toolbar.getNavigationIcon();
        a1 m = a1.m(toolbar.getContext(), null, a0.e.f56w, 2130903047);
        int i7 = 15;
        this.f878p = m.e(15);
        if (z6) {
            CharSequence k6 = m.k(27);
            if (!TextUtils.isEmpty(k6)) {
                this.f871h = true;
                this.f872i = k6;
                if ((this.f866b & 8) != 0) {
                    this.f865a.setTitle(k6);
                    if (this.f871h) {
                        p1.y.j(this.f865a.getRootView(), k6);
                    }
                }
            }
            CharSequence k7 = m.k(25);
            if (!TextUtils.isEmpty(k7)) {
                this.f873j = k7;
                if ((this.f866b & 8) != 0) {
                    this.f865a.setSubtitle(k7);
                }
            }
            Drawable e = m.e(20);
            if (e != null) {
                this.f869f = e;
                w();
            }
            Drawable e7 = m.e(17);
            if (e7 != null) {
                setIcon(e7);
            }
            if (this.f870g == null && (drawable = this.f878p) != null) {
                this.f870g = drawable;
                if ((this.f866b & 4) != 0) {
                    this.f865a.setNavigationIcon(drawable);
                } else {
                    this.f865a.setNavigationIcon((Drawable) null);
                }
            }
            m(m.h(10, 0));
            int i8 = m.i(9, 0);
            if (i8 != 0) {
                View inflate = LayoutInflater.from(this.f865a.getContext()).inflate(i8, (ViewGroup) this.f865a, false);
                View view = this.f868d;
                if (view != null && (this.f866b & 16) != 0) {
                    this.f865a.removeView(view);
                }
                this.f868d = inflate;
                if (inflate != null && (this.f866b & 16) != 0) {
                    this.f865a.addView(inflate);
                }
                m(this.f866b | 16);
            }
            int layoutDimension = m.f831b.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.f865a.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.f865a.setLayoutParams(layoutParams);
            }
            int c7 = m.c(7, -1);
            int c8 = m.c(3, -1);
            if (c7 >= 0 || c8 >= 0) {
                Toolbar toolbar2 = this.f865a;
                int max = Math.max(c7, 0);
                int max2 = Math.max(c8, 0);
                if (toolbar2.f789y == null) {
                    toolbar2.f789y = new s0();
                }
                toolbar2.f789y.a(max, max2);
            }
            int i9 = m.i(28, 0);
            if (i9 != 0) {
                Toolbar toolbar3 = this.f865a;
                Context context = toolbar3.getContext();
                toolbar3.f782q = i9;
                c0 c0Var = toolbar3.f773g;
                if (c0Var != null) {
                    c0Var.setTextAppearance(context, i9);
                }
            }
            int i10 = m.i(26, 0);
            if (i10 != 0) {
                Toolbar toolbar4 = this.f865a;
                Context context2 = toolbar4.getContext();
                toolbar4.f783r = i10;
                c0 c0Var2 = toolbar4.f774h;
                if (c0Var2 != null) {
                    c0Var2.setTextAppearance(context2, i10);
                }
            }
            int i11 = m.i(22, 0);
            if (i11 != 0) {
                this.f865a.setPopupTheme(i11);
            }
        } else {
            if (this.f865a.getNavigationIcon() != null) {
                this.f878p = this.f865a.getNavigationIcon();
            } else {
                i7 = 11;
            }
            this.f866b = i7;
        }
        m.n();
        if (2131820545 != this.f877o) {
            this.f877o = 2131820545;
            if (TextUtils.isEmpty(this.f865a.getNavigationContentDescription())) {
                int i12 = this.f877o;
                this.f874k = i12 != 0 ? a().getString(i12) : null;
                v();
            }
        }
        this.f874k = this.f865a.getNavigationContentDescription();
        this.f865a.setNavigationOnClickListener(new b1(this));
    }

    @Override // androidx.appcompat.widget.g0
    public final Context a() {
        return this.f865a.getContext();
    }

    @Override // androidx.appcompat.widget.g0
    public final boolean b() {
        ActionMenuView actionMenuView = this.f865a.f772f;
        if (actionMenuView != null) {
            c cVar = actionMenuView.f707y;
            if (cVar != null && cVar.g()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.widget.g0
    public final void c() {
        this.m = true;
    }

    @Override // androidx.appcompat.widget.g0
    public final void collapseActionView() {
        Toolbar.f fVar = this.f865a.R;
        androidx.appcompat.view.menu.h hVar = fVar == null ? null : fVar.f796g;
        if (hVar != null) {
            hVar.collapseActionView();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.widget.g0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d() {
        /*
            r3 = this;
            androidx.appcompat.widget.Toolbar r3 = r3.f865a
            androidx.appcompat.widget.ActionMenuView r3 = r3.f772f
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L22
            androidx.appcompat.widget.c r3 = r3.f707y
            if (r3 == 0) goto L1e
            androidx.appcompat.widget.c$c r2 = r3.f850z
            if (r2 != 0) goto L19
            boolean r3 = r3.g()
            if (r3 == 0) goto L17
            goto L19
        L17:
            r3 = r1
            goto L1a
        L19:
            r3 = r0
        L1a:
            if (r3 == 0) goto L1e
            r3 = r0
            goto L1f
        L1e:
            r3 = r1
        L1f:
            if (r3 == 0) goto L22
            goto L23
        L22:
            r0 = r1
        L23:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.c1.d():boolean");
    }

    @Override // androidx.appcompat.widget.g0
    public final boolean e() {
        ActionMenuView actionMenuView = this.f865a.f772f;
        if (actionMenuView != null) {
            c cVar = actionMenuView.f707y;
            if (cVar != null && cVar.d()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.widget.g0
    public final void f(androidx.appcompat.view.menu.f fVar, h.c cVar) {
        if (this.f876n == null) {
            this.f876n = new c(this.f865a.getContext());
        }
        c cVar2 = this.f876n;
        cVar2.f533j = cVar;
        Toolbar toolbar = this.f865a;
        if (fVar == null && toolbar.f772f == null) {
            return;
        }
        toolbar.e();
        androidx.appcompat.view.menu.f fVar2 = toolbar.f772f.f703u;
        if (fVar2 == fVar) {
            return;
        }
        if (fVar2 != null) {
            fVar2.r(toolbar.Q);
            fVar2.r(toolbar.R);
        }
        if (toolbar.R == null) {
            toolbar.R = new Toolbar.f();
        }
        cVar2.f846v = true;
        if (fVar != null) {
            fVar.b(cVar2, toolbar.f780o);
            fVar.b(toolbar.R, toolbar.f780o);
        } else {
            cVar2.e(toolbar.f780o, null);
            toolbar.R.e(toolbar.f780o, null);
            cVar2.f();
            toolbar.R.f();
        }
        toolbar.f772f.setPopupTheme(toolbar.f781p);
        toolbar.f772f.setPresenter(cVar2);
        toolbar.Q = cVar2;
        toolbar.s();
    }

    @Override // androidx.appcompat.widget.g0
    public final boolean g() {
        ActionMenuView actionMenuView = this.f865a.f772f;
        if (actionMenuView != null) {
            c cVar = actionMenuView.f707y;
            if (cVar != null && cVar.l()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.widget.g0
    public final CharSequence getTitle() {
        return this.f865a.getTitle();
    }

    @Override // androidx.appcompat.widget.g0
    public final boolean h() {
        ActionMenuView actionMenuView;
        Toolbar toolbar = this.f865a;
        return toolbar.getVisibility() == 0 && (actionMenuView = toolbar.f772f) != null && actionMenuView.f706x;
    }

    @Override // androidx.appcompat.widget.g0
    public final void i() {
        c cVar;
        ActionMenuView actionMenuView = this.f865a.f772f;
        if (actionMenuView == null || (cVar = actionMenuView.f707y) == null) {
            return;
        }
        cVar.d();
        c.a aVar = cVar.f849y;
        if (aVar == null || !aVar.b()) {
            return;
        }
        aVar.f635j.dismiss();
    }

    @Override // androidx.appcompat.widget.g0
    public final void j(int i7) {
        this.f865a.setVisibility(i7);
    }

    @Override // androidx.appcompat.widget.g0
    public final void k() {
    }

    @Override // androidx.appcompat.widget.g0
    public final boolean l() {
        Toolbar.f fVar = this.f865a.R;
        return (fVar == null || fVar.f796g == null) ? false : true;
    }

    @Override // androidx.appcompat.widget.g0
    public final void m(int i7) {
        View view;
        Toolbar toolbar;
        int i8 = this.f866b ^ i7;
        this.f866b = i7;
        if (i8 != 0) {
            CharSequence charSequence = null;
            if ((i8 & 4) != 0) {
                if ((i7 & 4) != 0) {
                    v();
                }
                if ((this.f866b & 4) != 0) {
                    Toolbar toolbar2 = this.f865a;
                    Drawable drawable = this.f870g;
                    if (drawable == null) {
                        drawable = this.f878p;
                    }
                    toolbar2.setNavigationIcon(drawable);
                } else {
                    this.f865a.setNavigationIcon((Drawable) null);
                }
            }
            if ((i8 & 3) != 0) {
                w();
            }
            if ((i8 & 8) != 0) {
                if ((i7 & 8) != 0) {
                    this.f865a.setTitle(this.f872i);
                    toolbar = this.f865a;
                    charSequence = this.f873j;
                } else {
                    this.f865a.setTitle((CharSequence) null);
                    toolbar = this.f865a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i8 & 16) == 0 || (view = this.f868d) == null) {
                return;
            }
            int i9 = i7 & 16;
            Toolbar toolbar3 = this.f865a;
            if (i9 != 0) {
                toolbar3.addView(view);
            } else {
                toolbar3.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.g0
    public final void n() {
        t0 t0Var = this.f867c;
        if (t0Var != null) {
            ViewParent parent = t0Var.getParent();
            Toolbar toolbar = this.f865a;
            if (parent == toolbar) {
                toolbar.removeView(this.f867c);
            }
        }
        this.f867c = null;
    }

    @Override // androidx.appcompat.widget.g0
    public final int o() {
        return this.f866b;
    }

    @Override // androidx.appcompat.widget.g0
    public final void p(int i7) {
        this.f869f = i7 != 0 ? g.a.a(a(), i7) : null;
        w();
    }

    @Override // androidx.appcompat.widget.g0
    public final void q() {
    }

    @Override // androidx.appcompat.widget.g0
    public final p1.k0 r(int i7, long j5) {
        p1.k0 a7 = p1.y.a(this.f865a);
        a7.a(i7 == 0 ? 1.0f : 0.0f);
        a7.c(j5);
        a7.d(new a(i7));
        return a7;
    }

    @Override // androidx.appcompat.widget.g0
    public final void s() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.g0
    public final void setIcon(int i7) {
        setIcon(i7 != 0 ? g.a.a(a(), i7) : null);
    }

    @Override // androidx.appcompat.widget.g0
    public final void setIcon(Drawable drawable) {
        this.e = drawable;
        w();
    }

    @Override // androidx.appcompat.widget.g0
    public final void setWindowCallback(Window.Callback callback) {
        this.f875l = callback;
    }

    @Override // androidx.appcompat.widget.g0
    public final void setWindowTitle(CharSequence charSequence) {
        if (this.f871h) {
            return;
        }
        this.f872i = charSequence;
        if ((this.f866b & 8) != 0) {
            this.f865a.setTitle(charSequence);
            if (this.f871h) {
                p1.y.j(this.f865a.getRootView(), charSequence);
            }
        }
    }

    @Override // androidx.appcompat.widget.g0
    public final void t() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.g0
    public final void u(boolean z6) {
        this.f865a.setCollapsible(z6);
    }

    public final void v() {
        if ((this.f866b & 4) != 0) {
            if (TextUtils.isEmpty(this.f874k)) {
                this.f865a.setNavigationContentDescription(this.f877o);
            } else {
                this.f865a.setNavigationContentDescription(this.f874k);
            }
        }
    }

    public final void w() {
        Drawable drawable;
        int i7 = this.f866b;
        if ((i7 & 2) == 0) {
            drawable = null;
        } else if ((i7 & 1) == 0 || (drawable = this.f869f) == null) {
            drawable = this.e;
        }
        this.f865a.setLogo(drawable);
    }
}
