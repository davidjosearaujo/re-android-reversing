package com.mikhaellopez.circularprogressbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.s0;
import f5.g;
import q5.l;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class CircularProgressBar extends View {
    public l<? super Float, g> A;
    public l<? super Boolean, g> B;
    public float C;
    public b D;

    /* renamed from: f */
    public ValueAnimator f3422f;

    /* renamed from: g */
    public Handler f3423g;

    /* renamed from: i */
    public Paint f3425i;

    /* renamed from: j */
    public Paint f3426j;

    /* renamed from: k */
    public float f3427k;

    /* renamed from: p */
    public Integer f3431p;

    /* renamed from: q */
    public Integer f3432q;

    /* renamed from: r */
    public a f3433r;

    /* renamed from: t */
    public Integer f3434t;

    /* renamed from: u */
    public Integer f3435u;

    /* renamed from: v */
    public a f3436v;

    /* renamed from: w */
    public boolean f3437w;

    /* renamed from: y */
    public b f3439y;

    /* renamed from: z */
    public boolean f3440z;

    /* renamed from: h */
    public RectF f3424h = new RectF();

    /* renamed from: l */
    public float f3428l = 100.0f;
    public float m = getResources().getDimension(2131099743);

    /* renamed from: n */
    public float f3429n = getResources().getDimension(2131099742);

    /* renamed from: o */
    public int f3430o = -16777216;
    public int s = -7829368;

    /* renamed from: x */
    public float f3438x = 270.0f;
    public float E = 270.0f;
    public final c F = new c();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public enum a {
        f3441g("LEFT_TO_RIGHT"),
        f3442h("RIGHT_TO_LEFT"),
        f3443i("TOP_TO_BOTTOM"),
        f3444j("BOTTOM_TO_END");
        

        /* renamed from: f */
        public final int f3446f;

        a(String str) {
            this.f3446f = r2;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public enum b {
        f3447g("TO_RIGHT"),
        f3448h("TO_LEFT");
        

        /* renamed from: f */
        public final int f3450f;

        b(String str) {
            this.f3450f = r2;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c implements Runnable {
        public c() {
            CircularProgressBar.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CircularProgressBar circularProgressBar;
            float f7;
            if (CircularProgressBar.this.getIndeterminateMode()) {
                CircularProgressBar circularProgressBar2 = CircularProgressBar.this;
                Handler handler = circularProgressBar2.f3423g;
                if (handler != null) {
                    handler.postDelayed(circularProgressBar2.F, 1500);
                }
                CircularProgressBar circularProgressBar3 = CircularProgressBar.this;
                circularProgressBar3.setProgressDirectionIndeterminateMode(CircularProgressBar.e(circularProgressBar3.D) ? b.f3448h : b.f3447g);
                if (CircularProgressBar.e(CircularProgressBar.this.D)) {
                    circularProgressBar = CircularProgressBar.this;
                    f7 = 0.0f;
                } else {
                    circularProgressBar = CircularProgressBar.this;
                    f7 = circularProgressBar.getProgressMax();
                }
                CircularProgressBar.h(circularProgressBar, f7, 1500L, 12);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.g(context, "context");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        this.f3425i = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        this.f3426j = paint2;
        a aVar = a.f3441g;
        this.f3433r = aVar;
        this.f3436v = aVar;
        b bVar = b.f3447g;
        this.f3439y = bVar;
        this.D = bVar;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, q2.a.f5643c, 0, 0);
        h.b(obtainStyledAttributes, "context.theme.obtainStyl…ircularProgressBar, 0, 0)");
        setProgress(obtainStyledAttributes.getFloat(6, this.f3427k));
        setProgressMax(obtainStyledAttributes.getFloat(8, this.f3428l));
        float dimension = obtainStyledAttributes.getDimension(13, this.m);
        Resources system = Resources.getSystem();
        h.b(system, "Resources.getSystem()");
        setProgressBarWidth(dimension / system.getDisplayMetrics().density);
        float dimension2 = obtainStyledAttributes.getDimension(4, this.f3429n);
        Resources system2 = Resources.getSystem();
        h.b(system2, "Resources.getSystem()");
        setBackgroundProgressBarWidth(dimension2 / system2.getDisplayMetrics().density);
        setProgressBarColor(obtainStyledAttributes.getInt(9, this.f3430o));
        int color = obtainStyledAttributes.getColor(12, 0);
        if (color != 0) {
            setProgressBarColorStart(Integer.valueOf(color));
        }
        int color2 = obtainStyledAttributes.getColor(11, 0);
        if (color2 != 0) {
            setProgressBarColorEnd(Integer.valueOf(color2));
        }
        setProgressBarColorDirection(i(obtainStyledAttributes.getInteger(10, this.f3433r.f3446f)));
        setBackgroundProgressBarColor(obtainStyledAttributes.getInt(0, this.s));
        int color3 = obtainStyledAttributes.getColor(3, 0);
        if (color3 != 0) {
            setBackgroundProgressBarColorStart(Integer.valueOf(color3));
        }
        int color4 = obtainStyledAttributes.getColor(2, 0);
        if (color4 != 0) {
            setBackgroundProgressBarColorEnd(Integer.valueOf(color4));
        }
        setBackgroundProgressBarColorDirection(i(obtainStyledAttributes.getInteger(1, this.f3436v.f3446f)));
        int integer = obtainStyledAttributes.getInteger(7, this.f3439y.f3450f);
        if (integer != 1) {
            if (integer == 2) {
                bVar = b.f3448h;
            } else {
                throw new IllegalArgumentException(s0.g("This value is not supported for ProgressDirection: ", integer));
            }
        }
        setProgressDirection(bVar);
        setRoundBorder(obtainStyledAttributes.getBoolean(14, this.f3437w));
        setStartAngle(obtainStyledAttributes.getFloat(15, 0.0f));
        setIndeterminateMode(obtainStyledAttributes.getBoolean(5, this.f3440z));
        obtainStyledAttributes.recycle();
    }

    public static boolean e(b bVar) {
        return bVar == b.f3447g;
    }

    public static void h(CircularProgressBar circularProgressBar, float f7, Long l6, int i7) {
        if ((i7 & 2) != 0) {
            l6 = null;
        }
        ValueAnimator valueAnimator = circularProgressBar.f3422f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float[] fArr = new float[2];
        fArr[0] = circularProgressBar.f3440z ? circularProgressBar.C : circularProgressBar.f3427k;
        fArr[1] = f7;
        circularProgressBar.f3422f = ValueAnimator.ofFloat(fArr);
        if (l6 != null) {
            long longValue = l6.longValue();
            ValueAnimator valueAnimator2 = circularProgressBar.f3422f;
            if (valueAnimator2 != null) {
                valueAnimator2.setDuration(longValue);
            }
        }
        ValueAnimator valueAnimator3 = circularProgressBar.f3422f;
        if (valueAnimator3 != null) {
            valueAnimator3.addUpdateListener(new u4.a(circularProgressBar));
        }
        ValueAnimator valueAnimator4 = circularProgressBar.f3422f;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
    }

    public static a i(int i7) {
        if (i7 == 1) {
            return a.f3441g;
        }
        if (i7 == 2) {
            return a.f3442h;
        }
        if (i7 == 3) {
            return a.f3443i;
        }
        if (i7 == 4) {
            return a.f3444j;
        }
        throw new IllegalArgumentException(s0.g("This value is not supported for GradientDirection: ", i7));
    }

    public final void setProgressDirectionIndeterminateMode(b bVar) {
        this.D = bVar;
        invalidate();
    }

    public final void setProgressIndeterminateMode(float f7) {
        this.C = f7;
        invalidate();
    }

    public final void setStartAngleIndeterminateMode(float f7) {
        this.E = f7;
        invalidate();
    }

    public final LinearGradient d(int i7, int i8, a aVar) {
        float f7;
        float f8;
        float f9;
        float f10;
        int ordinal = aVar.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                f10 = (float) getWidth();
                f9 = 0.0f;
            } else if (ordinal == 2) {
                f7 = (float) getHeight();
                f10 = 0.0f;
                f9 = 0.0f;
                f8 = 0.0f;
            } else if (ordinal != 3) {
                f10 = 0.0f;
                f9 = 0.0f;
            } else {
                f9 = (float) getHeight();
                f10 = 0.0f;
                f8 = 0.0f;
                f7 = f8;
            }
            f8 = f9;
            f7 = f8;
        } else {
            f8 = (float) getWidth();
            f10 = 0.0f;
            f9 = 0.0f;
            f7 = 0.0f;
        }
        return new LinearGradient(f10, f9, f8, f7, i7, i8, Shader.TileMode.CLAMP);
    }

    public final void f() {
        Paint paint = this.f3425i;
        Integer num = this.f3434t;
        int intValue = num != null ? num.intValue() : this.s;
        Integer num2 = this.f3435u;
        paint.setShader(d(intValue, num2 != null ? num2.intValue() : this.s, this.f3436v));
    }

    public final void g() {
        Paint paint = this.f3426j;
        Integer num = this.f3431p;
        int intValue = num != null ? num.intValue() : this.f3430o;
        Integer num2 = this.f3432q;
        paint.setShader(d(intValue, num2 != null ? num2.intValue() : this.f3430o, this.f3433r));
    }

    public final int getBackgroundProgressBarColor() {
        return this.s;
    }

    public final a getBackgroundProgressBarColorDirection() {
        return this.f3436v;
    }

    public final Integer getBackgroundProgressBarColorEnd() {
        return this.f3435u;
    }

    public final Integer getBackgroundProgressBarColorStart() {
        return this.f3434t;
    }

    public final float getBackgroundProgressBarWidth() {
        return this.f3429n;
    }

    public final boolean getIndeterminateMode() {
        return this.f3440z;
    }

    public final l<Boolean, g> getOnIndeterminateModeChangeListener() {
        return this.B;
    }

    public final l<Float, g> getOnProgressChangeListener() {
        return this.A;
    }

    public final float getProgress() {
        return this.f3427k;
    }

    public final int getProgressBarColor() {
        return this.f3430o;
    }

    public final a getProgressBarColorDirection() {
        return this.f3433r;
    }

    public final Integer getProgressBarColorEnd() {
        return this.f3432q;
    }

    public final Integer getProgressBarColorStart() {
        return this.f3431p;
    }

    public final float getProgressBarWidth() {
        return this.m;
    }

    public final b getProgressDirection() {
        return this.f3439y;
    }

    public final float getProgressMax() {
        return this.f3428l;
    }

    public final boolean getRoundBorder() {
        return this.f3437w;
    }

    public final float getStartAngle() {
        return this.f3438x;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f3422f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        Handler handler = this.f3423g;
        if (handler != null) {
            handler.removeCallbacks(this.F);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        h.g(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawOval(this.f3424h, this.f3425i);
        boolean z6 = this.f3440z;
        float f7 = ((z6 ? this.C : this.f3427k) * 100.0f) / this.f3428l;
        boolean z7 = true;
        boolean z8 = z6 && e(this.D);
        if (this.f3440z || !e(this.f3439y)) {
            z7 = false;
        }
        canvas.drawArc(this.f3424h, this.f3440z ? this.E : this.f3438x, (((float) ((z8 || z7) ? 360 : -360)) * f7) / ((float) 100), false, this.f3426j);
    }

    @Override // android.view.View
    public final void onMeasure(int i7, int i8) {
        int min = Math.min(View.getDefaultSize(getSuggestedMinimumWidth(), i7), View.getDefaultSize(getSuggestedMinimumHeight(), i8));
        setMeasuredDimension(min, min);
        float f7 = this.m;
        float f8 = this.f3429n;
        if (f7 <= f8) {
            f7 = f8;
        }
        float f9 = f7 / ((float) 2);
        float f10 = ((float) 0) + f9;
        float f11 = ((float) min) - f9;
        this.f3424h.set(f10, f10, f11, f11);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        g();
        f();
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i7) {
        setBackgroundProgressBarColor(i7);
    }

    public final void setBackgroundProgressBarColor(int i7) {
        this.s = i7;
        f();
        invalidate();
    }

    public final void setBackgroundProgressBarColorDirection(a aVar) {
        h.g(aVar, "value");
        this.f3436v = aVar;
        f();
        invalidate();
    }

    public final void setBackgroundProgressBarColorEnd(Integer num) {
        this.f3435u = num;
        f();
        invalidate();
    }

    public final void setBackgroundProgressBarColorStart(Integer num) {
        this.f3434t = num;
        f();
        invalidate();
    }

    public final void setBackgroundProgressBarWidth(float f7) {
        Resources system = Resources.getSystem();
        h.b(system, "Resources.getSystem()");
        float f8 = f7 * system.getDisplayMetrics().density;
        this.f3429n = f8;
        this.f3425i.setStrokeWidth(f8);
        requestLayout();
        invalidate();
    }

    public final void setIndeterminateMode(boolean z6) {
        this.f3440z = z6;
        l<? super Boolean, g> lVar = this.B;
        if (lVar != null) {
            lVar.k(Boolean.valueOf(z6));
        }
        setProgressIndeterminateMode(0.0f);
        setProgressDirectionIndeterminateMode(b.f3447g);
        setStartAngleIndeterminateMode(270.0f);
        Handler handler = this.f3423g;
        if (handler != null) {
            handler.removeCallbacks(this.F);
        }
        ValueAnimator valueAnimator = this.f3422f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        Handler handler2 = new Handler();
        this.f3423g = handler2;
        if (this.f3440z) {
            handler2.post(this.F);
        }
    }

    public final void setOnIndeterminateModeChangeListener(l<? super Boolean, g> lVar) {
        this.B = lVar;
    }

    public final void setOnProgressChangeListener(l<? super Float, g> lVar) {
        this.A = lVar;
    }

    public final void setProgress(float f7) {
        float f8 = this.f3427k;
        float f9 = this.f3428l;
        if (f8 > f9) {
            f7 = f9;
        }
        this.f3427k = f7;
        l<? super Float, g> lVar = this.A;
        if (lVar != null) {
            lVar.k(Float.valueOf(f7));
        }
        invalidate();
    }

    public final void setProgressBarColor(int i7) {
        this.f3430o = i7;
        g();
        invalidate();
    }

    public final void setProgressBarColorDirection(a aVar) {
        h.g(aVar, "value");
        this.f3433r = aVar;
        g();
        invalidate();
    }

    public final void setProgressBarColorEnd(Integer num) {
        this.f3432q = num;
        g();
        invalidate();
    }

    public final void setProgressBarColorStart(Integer num) {
        this.f3431p = num;
        g();
        invalidate();
    }

    public final void setProgressBarWidth(float f7) {
        Resources system = Resources.getSystem();
        h.b(system, "Resources.getSystem()");
        float f8 = f7 * system.getDisplayMetrics().density;
        this.m = f8;
        this.f3426j.setStrokeWidth(f8);
        requestLayout();
        invalidate();
    }

    public final void setProgressDirection(b bVar) {
        h.g(bVar, "value");
        this.f3439y = bVar;
        invalidate();
    }

    public final void setProgressMax(float f7) {
        if (this.f3428l < ((float) 0)) {
            f7 = 100.0f;
        }
        this.f3428l = f7;
        invalidate();
    }

    public final void setProgressWithAnimation(float f7) {
        h(this, f7, null, 14);
    }

    public final void setRoundBorder(boolean z6) {
        this.f3437w = z6;
        this.f3426j.setStrokeCap(z6 ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        invalidate();
    }

    public final void setStartAngle(float f7) {
        int i7;
        float f8 = f7 + 270.0f;
        while (true) {
            float f9 = (float) 360;
            i7 = (f8 > f9 ? 1 : (f8 == f9 ? 0 : -1));
            if (i7 <= 0) {
                break;
            }
            f8 -= f9;
        }
        if (f8 < ((float) 0)) {
            f8 = 0.0f;
        } else if (i7 > 0) {
            f8 = 360.0f;
        }
        this.f3438x = f8;
        invalidate();
    }
}
