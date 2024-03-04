package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import java.util.WeakHashMap;
import p1.y;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    public final View f891a;

    /* renamed from: d */
    public y0 f894d;
    public y0 e;

    /* renamed from: f */
    public y0 f895f;

    /* renamed from: c */
    public int f893c = -1;

    /* renamed from: b */
    public final j f892b = j.a();

    public e(View view) {
        this.f891a = view;
    }

    public final void a() {
        Drawable background = this.f891a.getBackground();
        if (background != null) {
            boolean z6 = true;
            if (this.f894d != null) {
                if (this.f895f == null) {
                    this.f895f = new y0();
                }
                y0 y0Var = this.f895f;
                y0Var.f1072a = null;
                y0Var.f1075d = false;
                y0Var.f1073b = null;
                y0Var.f1074c = false;
                View view = this.f891a;
                WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
                ColorStateList g2 = y.i.g(view);
                if (g2 != null) {
                    y0Var.f1075d = true;
                    y0Var.f1072a = g2;
                }
                PorterDuff.Mode h7 = y.i.h(this.f891a);
                if (h7 != null) {
                    y0Var.f1074c = true;
                    y0Var.f1073b = h7;
                }
                if (y0Var.f1075d || y0Var.f1074c) {
                    j.e(background, y0Var, this.f891a.getDrawableState());
                } else {
                    z6 = false;
                }
                if (z6) {
                    return;
                }
            }
            y0 y0Var2 = this.e;
            if (y0Var2 != null) {
                j.e(background, y0Var2, this.f891a.getDrawableState());
                return;
            }
            y0 y0Var3 = this.f894d;
            if (y0Var3 != null) {
                j.e(background, y0Var3, this.f891a.getDrawableState());
            }
        }
    }

    public final ColorStateList b() {
        y0 y0Var = this.e;
        if (y0Var != null) {
            return y0Var.f1072a;
        }
        return null;
    }

    public final PorterDuff.Mode c() {
        y0 y0Var = this.e;
        if (y0Var != null) {
            return y0Var.f1073b;
        }
        return null;
    }

    public final void d(AttributeSet attributeSet, int i7) {
        ColorStateList h7;
        Context context = this.f891a.getContext();
        int[] iArr = a0.e.V;
        a1 m = a1.m(context, attributeSet, iArr, i7);
        View view = this.f891a;
        Context context2 = view.getContext();
        TypedArray typedArray = m.f831b;
        WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
        y.m.d(view, context2, iArr, attributeSet, typedArray, i7, 0);
        try {
            if (m.l(0)) {
                this.f893c = m.i(0, -1);
                j jVar = this.f892b;
                Context context3 = this.f891a.getContext();
                int i8 = this.f893c;
                synchronized (jVar) {
                    h7 = jVar.f941a.h(context3, i8);
                }
                if (h7 != null) {
                    g(h7);
                }
            }
            if (m.l(1)) {
                y.i.q(this.f891a, m.b(1));
            }
            if (m.l(2)) {
                y.i.r(this.f891a, h0.b(m.h(2, -1), null));
            }
        } finally {
            m.n();
        }
    }

    public final void e() {
        this.f893c = -1;
        g(null);
        a();
    }

    public final void f(int i7) {
        ColorStateList colorStateList;
        this.f893c = i7;
        j jVar = this.f892b;
        if (jVar != null) {
            Context context = this.f891a.getContext();
            synchronized (jVar) {
                colorStateList = jVar.f941a.h(context, i7);
            }
        } else {
            colorStateList = null;
        }
        g(colorStateList);
        a();
    }

    public final void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f894d == null) {
                this.f894d = new y0();
            }
            y0 y0Var = this.f894d;
            y0Var.f1072a = colorStateList;
            y0Var.f1075d = true;
        } else {
            this.f894d = null;
        }
        a();
    }

    public final void h(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new y0();
        }
        y0 y0Var = this.e;
        y0Var.f1072a = colorStateList;
        y0Var.f1075d = true;
        a();
    }

    public final void i(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new y0();
        }
        y0 y0Var = this.e;
        y0Var.f1073b = mode;
        y0Var.f1074c = true;
        a();
    }
}
