package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import j1.a;
import java.util.WeakHashMap;
import p1.y;

/* loaded from: classes.dex */
public final class x extends s {

    /* renamed from: d */
    public final SeekBar f1064d;
    public Drawable e;

    /* renamed from: f */
    public ColorStateList f1065f;

    /* renamed from: g */
    public PorterDuff.Mode f1066g;

    /* renamed from: h */
    public boolean f1067h;

    /* renamed from: i */
    public boolean f1068i;

    public x(SeekBar seekBar) {
        super(seekBar);
        this.f1065f = null;
        this.f1066g = null;
        this.f1067h = false;
        this.f1068i = false;
        this.f1064d = seekBar;
    }

    @Override // androidx.appcompat.widget.s
    public final void a(AttributeSet attributeSet, int i7) {
        super.a(attributeSet, 2130904033);
        Context context = this.f1064d.getContext();
        int[] iArr = a0.e.C;
        a1 m = a1.m(context, attributeSet, iArr, 2130904033);
        SeekBar seekBar = this.f1064d;
        Context context2 = seekBar.getContext();
        TypedArray typedArray = m.f831b;
        WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
        y.m.d(seekBar, context2, iArr, attributeSet, typedArray, 2130904033, 0);
        Drawable f7 = m.f(0);
        if (f7 != null) {
            this.f1064d.setThumb(f7);
        }
        Drawable e = m.e(1);
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.e = e;
        if (e != null) {
            e.setCallback(this.f1064d);
            a.c.b(e, y.e.d(this.f1064d));
            if (e.isStateful()) {
                e.setState(this.f1064d.getDrawableState());
            }
            c();
        }
        this.f1064d.invalidate();
        if (m.l(3)) {
            this.f1066g = h0.b(m.h(3, -1), this.f1066g);
            this.f1068i = true;
        }
        if (m.l(2)) {
            this.f1065f = m.b(2);
            this.f1067h = true;
        }
        m.n();
        c();
    }

    public final void c() {
        Drawable drawable = this.e;
        if (drawable != null) {
            if (this.f1067h || this.f1068i) {
                Drawable mutate = drawable.mutate();
                this.e = mutate;
                if (this.f1067h) {
                    a.b.h(mutate, this.f1065f);
                }
                if (this.f1068i) {
                    a.b.i(this.e, this.f1066g);
                }
                if (this.e.isStateful()) {
                    this.e.setState(this.f1064d.getDrawableState());
                }
            }
        }
    }

    public final void d(Canvas canvas) {
        if (this.e != null) {
            int max = this.f1064d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.e.getIntrinsicWidth();
                int intrinsicHeight = this.e.getIntrinsicHeight();
                int i7 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i8 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.e.setBounds(-i7, -i8, i7, i8);
                float width = ((this.f1064d.getWidth() - this.f1064d.getPaddingLeft()) - this.f1064d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f1064d.getPaddingLeft(), this.f1064d.getHeight() / 2);
                for (int i9 = 0; i9 <= max; i9++) {
                    this.e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
