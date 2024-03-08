package androidx.appcompat.widget;

import a0.e;
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
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class x extends s {

    /* renamed from: d  reason: collision with root package name */
    public final SeekBar f1064d;
    public Drawable e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f1065f = null;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f1066g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1067h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1068i = false;

    public x(SeekBar seekBar) {
        super(seekBar);
        this.f1064d = seekBar;
    }

    @Override // androidx.appcompat.widget.s
    public final void a(AttributeSet attributeSet, int i7) {
        super.a(attributeSet, 2130904033);
        Context context = this.f1064d.getContext();
        int[] iArr = e.C;
        a1 m = a1.m(context, attributeSet, iArr, 2130904033);
        SeekBar seekBar = this.f1064d;
        Context context2 = seekBar.getContext();
        TypedArray typedArray = m.f831b;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
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
        if (drawable == null) {
            return;
        }
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

    public final void d(Canvas canvas) {
        if (this.e != null) {
            int max = this.f1064d.getMax();
            int i7 = 1;
            if (max > 1) {
                int intrinsicWidth = this.e.getIntrinsicWidth();
                int intrinsicHeight = this.e.getIntrinsicHeight();
                int i8 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i7 = intrinsicHeight / 2;
                }
                this.e.setBounds(-i8, -i7, i8, i7);
                float width = ((float) ((this.f1064d.getWidth() - this.f1064d.getPaddingLeft()) - this.f1064d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f1064d.getPaddingLeft(), (float) (this.f1064d.getHeight() / 2));
                for (int i9 = 0; i9 <= max; i9++) {
                    this.e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
