package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import java.util.WeakHashMap;
import p1.y;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a */
    public final ImageView f1008a;

    /* renamed from: b */
    public y0 f1009b;

    /* renamed from: c */
    public int f1010c = 0;

    public o(ImageView imageView) {
        this.f1008a = imageView;
    }

    public final void a() {
        y0 y0Var;
        Drawable drawable = this.f1008a.getDrawable();
        if (drawable != null) {
            h0.a(drawable);
        }
        if (drawable == null || (y0Var = this.f1009b) == null) {
            return;
        }
        j.e(drawable, y0Var, this.f1008a.getDrawableState());
    }

    public final void b(AttributeSet attributeSet, int i7) {
        int i8;
        Context context = this.f1008a.getContext();
        int[] iArr = a0.e.B;
        a1 m = a1.m(context, attributeSet, iArr, i7);
        ImageView imageView = this.f1008a;
        Context context2 = imageView.getContext();
        TypedArray typedArray = m.f831b;
        WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
        y.m.d(imageView, context2, iArr, attributeSet, typedArray, i7, 0);
        try {
            Drawable drawable = this.f1008a.getDrawable();
            if (drawable == null && (i8 = m.i(1, -1)) != -1 && (drawable = g.a.a(this.f1008a.getContext(), i8)) != null) {
                this.f1008a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                h0.a(drawable);
            }
            if (m.l(2)) {
                t1.e.c(this.f1008a, m.b(2));
            }
            if (m.l(3)) {
                t1.e.d(this.f1008a, h0.b(m.h(3, -1), null));
            }
        } finally {
            m.n();
        }
    }

    public final void c(int i7) {
        if (i7 != 0) {
            Drawable a7 = g.a.a(this.f1008a.getContext(), i7);
            if (a7 != null) {
                h0.a(a7);
            }
            this.f1008a.setImageDrawable(a7);
        } else {
            this.f1008a.setImageDrawable(null);
        }
        a();
    }
}