package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import e4.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import l0.z;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public class ClockHandView extends View {

    /* renamed from: f */
    public final ValueAnimator f3352f;

    /* renamed from: g */
    public boolean f3353g;

    /* renamed from: h */
    public final ArrayList f3354h;

    /* renamed from: i */
    public final int f3355i;

    /* renamed from: j */
    public final float f3356j;

    /* renamed from: k */
    public final Paint f3357k;

    /* renamed from: l */
    public final RectF f3358l;
    public final int m;

    /* renamed from: n */
    public float f3359n;

    /* renamed from: o */
    public boolean f3360o;

    /* renamed from: p */
    public double f3361p;

    /* renamed from: q */
    public int f3362q;

    /* renamed from: r */
    public int f3363r;

    /* loaded from: classes.dex */
    public interface a {
        void b(float f7);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130903818);
        this.f3352f = new ValueAnimator();
        this.f3354h = new ArrayList();
        Paint paint = new Paint();
        this.f3357k = paint;
        this.f3358l = new RectF();
        this.f3363r = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.f4920f, 2130903818, 2131887192);
        j.c(context, 2130903868, 200);
        j.d(context, 2130903884, n3.a.f5162b);
        this.f3362q = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f3355i = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        Resources resources = getResources();
        this.m = resources.getDimensionPixelSize(2131100197);
        this.f3356j = resources.getDimensionPixelSize(2131100195);
        int color = obtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        a(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.d.s(this, 2);
        obtainStyledAttributes.recycle();
    }

    public final void a(float f7) {
        ValueAnimator valueAnimator = this.f3352f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        b(f7, false);
    }

    public final void b(float f7, boolean z6) {
        float f8 = f7 % 360.0f;
        this.f3359n = f8;
        this.f3361p = Math.toRadians(f8 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int i7 = this.f3363r;
        int i8 = this.f3362q;
        if (i7 == 2) {
            i8 = Math.round(i8 * 0.66f);
        }
        float f9 = width;
        float f10 = i8;
        float cos = (((float) Math.cos(this.f3361p)) * f10) + f9;
        float sin = (f10 * ((float) Math.sin(this.f3361p))) + height;
        RectF rectF = this.f3358l;
        float f11 = this.f3355i;
        rectF.set(cos - f11, sin - f11, cos + f11, sin + f11);
        Iterator it = this.f3354h.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(f8);
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int i7 = this.f3363r;
        int i8 = this.f3362q;
        if (i7 == 2) {
            i8 = Math.round(i8 * 0.66f);
        }
        float f7 = width;
        float f8 = i8;
        float f9 = height;
        this.f3357k.setStrokeWidth(0.0f);
        canvas.drawCircle((((float) Math.cos(this.f3361p)) * f8) + f7, (f8 * ((float) Math.sin(this.f3361p))) + f9, this.f3355i, this.f3357k);
        double sin = Math.sin(this.f3361p);
        double cos = Math.cos(this.f3361p);
        this.f3357k.setStrokeWidth(this.m);
        canvas.drawLine(f7, f9, width + ((int) (cos * r3)), height + ((int) (r3 * sin)), this.f3357k);
        canvas.drawCircle(f7, f9, this.f3356j, this.f3357k);
    }

    @Override // android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        super.onLayout(z6, i7, i8, i9, i10);
        if (this.f3352f.isRunning()) {
            return;
        }
        a(this.f3359n);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z6;
        boolean z7;
        int actionMasked = motionEvent.getActionMasked();
        float x3 = motionEvent.getX();
        float y6 = motionEvent.getY();
        boolean z8 = false;
        if (actionMasked == 0) {
            this.f3360o = false;
            z6 = true;
            z7 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z7 = this.f3360o;
            if (this.f3353g) {
                this.f3363r = ((float) Math.hypot((double) (x3 - ((float) (getWidth() / 2))), (double) (y6 - ((float) (getHeight() / 2))))) <= ((float) Math.round(((float) this.f3362q) * 0.66f)) + TypedValue.applyDimension(1, (float) 12, getContext().getResources().getDisplayMetrics()) ? 2 : 1;
            }
            z6 = false;
        } else {
            z7 = false;
            z6 = false;
        }
        boolean z9 = this.f3360o;
        int degrees = ((int) Math.toDegrees(Math.atan2(y6 - (getHeight() / 2), x3 - (getWidth() / 2)))) + 90;
        if (degrees < 0) {
            degrees += 360;
        }
        float f7 = degrees;
        boolean z10 = this.f3359n != f7;
        if (!z6 || !z10) {
            if (z10 || z7) {
                a(f7);
            }
            this.f3360o = z9 | z8;
            return true;
        }
        z8 = true;
        this.f3360o = z9 | z8;
        return true;
    }
}
