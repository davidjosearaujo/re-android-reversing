package com.hunantv.imgo.widget.seekbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.facebook.imageutils.JfifUtil;
import com.hunantv.imgo.nightmode.view.SkinnableView;
import j.l.a.a0.b;
import j.l.a.c0.l.c;
import j.l.a.c0.l.d;
import j.l.a.c0.l.e;
import j.l.a.c0.l.f;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class TickSeekBar extends SkinnableView {
    private static final int X2 = 30;
    private String[] A;
    private RectF A2;
    private float[] B;
    private RectF B2;
    private float[] C;
    private float[] C1;
    private int C2;
    private float D;
    private int D2;
    private int E;
    private int E2;
    private Typeface F;
    private int F2;
    private int[] G2;
    private boolean H2;
    private float I2;
    private float J2;
    private int K0;
    private int K1;
    private Bitmap K2;
    private int L2;
    private int M2;
    private Drawable N2;
    private Bitmap O2;
    private int P2;
    private int Q2;
    private float R2;
    private int S2;
    private boolean T2;
    private e U2;
    private int V2;
    private boolean W2;
    private Context a;
    private Paint b;
    private TextPaint c;
    private d d;
    private Rect e;
    private float f;
    private float g;
    private float h;
    private int i;
    private int j;
    private int k;
    private int k0;
    private int k1;
    private int l;
    private float m;
    private float n;
    private boolean o;
    private float p;
    private int p2;
    private float q;
    private int q2;
    private float r;
    private float r2;
    private boolean s;
    private Bitmap s2;
    private boolean t;
    private Bitmap t2;
    private boolean u;
    private Drawable u2;
    private boolean v;
    private int v2;
    private float[] w;
    private boolean w2;
    private boolean x;
    private int x1;
    private boolean x2;
    private int y;
    private CharSequence[] y1;
    private int y2;
    private int z;
    private boolean z2;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ float a;
        public final /* synthetic */ int b;

        public a(float f, int i) {
            this.a = f;
            this.b = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TickSeekBar tickSeekBar = TickSeekBar.this;
            tickSeekBar.g = tickSeekBar.r;
            if (this.a - TickSeekBar.this.w[this.b] > 0.0f) {
                TickSeekBar.this.r = this.a - ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else {
                TickSeekBar.this.r = this.a + ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
            TickSeekBar tickSeekBar2 = TickSeekBar.this;
            tickSeekBar2.d0(tickSeekBar2.r);
            TickSeekBar.this.setSeekListener(false);
            TickSeekBar.this.invalidate();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TickSeekBar.this.requestLayout();
        }
    }

    public TickSeekBar(Context context) {
        this(context, null);
    }

    private String A(float f) {
        if (this.s) {
            return c.b(f, this.V2);
        }
        return String.valueOf(Math.round(f));
    }

    private String B(int i) {
        CharSequence[] charSequenceArr = this.y1;
        if (charSequenceArr == null) {
            return A(this.w[i]);
        }
        return i < charSequenceArr.length ? String.valueOf(charSequenceArr[i]) : "";
    }

    private boolean C() {
        return (this.K1 != 0 && this.y == 2) || this.Q2 == 2;
    }

    private boolean D() {
        return (this.K1 != 0 && this.y == 1) || this.Q2 == 1;
    }

    private void E(Context context, AttributeSet attributeSet) {
        j.l.a.c0.l.a aVar = new j.l.a.c0.l.a(context);
        if (attributeSet == null) {
            i(aVar);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.r.TickSeekBar);
        this.p = obtainStyledAttributes.getFloat(b.r.TickSeekBar_tsb_max, aVar.b);
        this.q = obtainStyledAttributes.getFloat(b.r.TickSeekBar_tsb_min, aVar.c);
        this.r = obtainStyledAttributes.getFloat(b.r.TickSeekBar_tsb_progress, aVar.d);
        this.s = obtainStyledAttributes.getBoolean(b.r.TickSeekBar_tsb_progress_value_float, aVar.e);
        this.t = obtainStyledAttributes.getBoolean(b.r.TickSeekBar_tsb_user_seekable, aVar.h);
        this.T2 = obtainStyledAttributes.getBoolean(b.r.TickSeekBar_tsb_clear_default_padding, aVar.J);
        this.u = obtainStyledAttributes.getBoolean(b.r.TickSeekBar_tsb_only_thumb_draggable, aVar.i);
        this.v = obtainStyledAttributes.getBoolean(b.r.TickSeekBar_tsb_seek_smoothly, aVar.f);
        this.x = obtainStyledAttributes.getBoolean(b.r.TickSeekBar_tsb_r2l, aVar.g);
        this.C2 = obtainStyledAttributes.getDimensionPixelSize(b.r.TickSeekBar_tsb_track_background_size, aVar.j);
        this.D2 = obtainStyledAttributes.getDimensionPixelSize(b.r.TickSeekBar_tsb_track_progress_size, aVar.l);
        this.E2 = obtainStyledAttributes.getColor(b.r.TickSeekBar_tsb_track_background_color, aVar.k);
        this.F2 = obtainStyledAttributes.getColor(b.r.TickSeekBar_tsb_track_progress_color, aVar.m);
        this.z2 = obtainStyledAttributes.getBoolean(b.r.TickSeekBar_tsb_track_rounded_corners, aVar.n);
        this.M2 = obtainStyledAttributes.getDimensionPixelSize(b.r.TickSeekBar_tsb_thumb_size, aVar.q);
        this.N2 = obtainStyledAttributes.getDrawable(b.r.TickSeekBar_tsb_thumb_drawable);
        P(obtainStyledAttributes.getColorStateList(b.r.TickSeekBar_tsb_thumb_color), aVar.r);
        this.W2 = obtainStyledAttributes.getBoolean(b.r.TickSeekBar_tsb_thumb_adjust_auto, aVar.s);
        this.Q2 = obtainStyledAttributes.getInt(b.r.TickSeekBar_tsb_show_thumb_text, aVar.p);
        this.S2 = obtainStyledAttributes.getColor(b.r.TickSeekBar_tsb_thumb_text_color, aVar.o);
        this.K1 = obtainStyledAttributes.getInt(b.r.TickSeekBar_tsb_ticks_count, aVar.B);
        this.v2 = obtainStyledAttributes.getInt(b.r.TickSeekBar_tsb_show_tick_marks_type, aVar.C);
        this.y2 = obtainStyledAttributes.getDimensionPixelSize(b.r.TickSeekBar_tsb_tick_marks_size, aVar.E);
        R(obtainStyledAttributes.getColorStateList(b.r.TickSeekBar_tsb_tick_marks_color), aVar.D);
        this.u2 = obtainStyledAttributes.getDrawable(b.r.TickSeekBar_tsb_tick_marks_drawable);
        this.x2 = obtainStyledAttributes.getBoolean(b.r.TickSeekBar_tsb_tick_marks_swept_hide, aVar.H);
        this.w2 = obtainStyledAttributes.getBoolean(b.r.TickSeekBar_tsb_tick_marks_ends_hide, aVar.G);
        this.y = obtainStyledAttributes.getInt(b.r.TickSeekBar_tsb_show_tick_texts, 0);
        this.E = obtainStyledAttributes.getDimensionPixelSize(b.r.TickSeekBar_tsb_tick_texts_size, aVar.x);
        S(obtainStyledAttributes.getColorStateList(b.r.TickSeekBar_tsb_tick_texts_color), aVar.w);
        this.y1 = obtainStyledAttributes.getTextArray(b.r.TickSeekBar_tsb_tick_texts_array);
        N(obtainStyledAttributes.getInt(b.r.TickSeekBar_tsb_tick_texts_typeface, -1), aVar.z);
        obtainStyledAttributes.recycle();
    }

    private void F() {
        if (this.T2) {
            return;
        }
        int a2 = f.a(this.a, 16.0f);
        if (getPaddingLeft() == 0) {
            setPadding(a2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        if (getPaddingRight() == 0) {
            setPadding(getPaddingLeft(), getPaddingTop(), a2, getPaddingBottom());
        }
    }

    private void G() {
        int i = this.K1;
        if (i >= 0 && i <= 50) {
            H();
            int i2 = this.C2;
            int i3 = this.D2;
            if (i2 > i3) {
                this.C2 = i3;
            }
            if (this.N2 == null) {
                float f = this.M2 / 2.0f;
                this.I2 = f;
                this.J2 = f * 1.2f;
            } else {
                float min = Math.min(f.a(this.a, 30.0f), this.M2) / 2.0f;
                this.I2 = min;
                this.J2 = min;
            }
            if (this.u2 == null) {
                this.r2 = this.y2 / 2.0f;
            } else {
                this.r2 = Math.min(f.a(this.a, 30.0f), this.y2) / 2.0f;
            }
            this.f = Math.max(this.J2, this.r2) * 2.0f;
            J();
            Y();
            this.g = this.r;
            n();
            this.A2 = new RectF();
            this.B2 = new RectF();
            F();
            return;
        }
        throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between 0-50, Now is " + this.K1);
    }

    private void H() {
        float f = this.p;
        float f2 = this.q;
        if (f >= f2) {
            if (this.r < f2) {
                this.r = f2;
            }
            if (this.r > f) {
                this.r = f;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
    }

    private void I() {
        int i;
        this.k = getMeasuredWidth();
        if (Build.VERSION.SDK_INT < 17) {
            this.i = getPaddingLeft();
            this.j = getPaddingRight();
        } else {
            this.i = getPaddingStart();
            this.j = getPaddingEnd();
        }
        this.l = getPaddingTop();
        float f = (this.k - this.i) - this.j;
        this.m = f;
        this.n = f / (this.K1 + (-1) > 0 ? i - 1 : 1);
    }

    private void J() {
        if (this.b == null) {
            this.b = new Paint();
        }
        if (this.z2) {
            this.b.setStrokeCap(Paint.Cap.ROUND);
        }
        this.b.setAntiAlias(true);
        int i = this.C2;
        if (i > this.D2) {
            this.D2 = i;
        }
    }

    private void K() {
        if (this.c == null) {
            TextPaint textPaint = new TextPaint();
            this.c = textPaint;
            textPaint.setAntiAlias(true);
            this.c.setTextAlign(Paint.Align.CENTER);
            this.c.setTextSize(this.E);
        }
        if (this.e == null) {
            this.e = new Rect();
        }
    }

    private void M() {
        if (this.C1 == null) {
            return;
        }
        if (this.y != 0) {
            this.A = new String[this.K1];
        }
        for (int i = 0; i < this.C1.length; i++) {
            if (this.y != 0) {
                this.A[i] = B(i);
                TextPaint textPaint = this.c;
                String[] strArr = this.A;
                textPaint.getTextBounds(strArr[i], 0, strArr[i].length(), this.e);
                this.B[i] = this.e.width();
                this.C[i] = this.i + (this.n * i);
            }
            this.C1[i] = this.i + (this.n * i);
        }
    }

    private void N(int i, Typeface typeface) {
        if (i == 0) {
            this.F = Typeface.DEFAULT;
        } else if (i == 1) {
            this.F = Typeface.MONOSPACE;
        } else if (i == 2) {
            this.F = Typeface.SANS_SERIF;
        } else if (i == 3) {
            this.F = Typeface.SERIF;
        } else if (typeface == null) {
            this.F = Typeface.DEFAULT;
        } else {
            this.F = typeface;
        }
    }

    private void O() {
        Drawable drawable = this.N2;
        if (drawable == null) {
            return;
        }
        if (drawable instanceof StateListDrawable) {
            try {
                StateListDrawable stateListDrawable = (StateListDrawable) drawable;
                Class<?> cls = stateListDrawable.getClass();
                int intValue = ((Integer) cls.getMethod("getStateCount", new Class[0]).invoke(stateListDrawable, new Object[0])).intValue();
                if (intValue == 2) {
                    Class<?> cls2 = Integer.TYPE;
                    Method method = cls.getMethod("getStateSet", cls2);
                    Method method2 = cls.getMethod("getStateDrawable", cls2);
                    for (int i = 0; i < intValue; i++) {
                        int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i));
                        if (iArr.length > 0) {
                            if (iArr[0] == 16842919) {
                                this.O2 = y((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                            } else {
                                throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                            }
                        } else {
                            this.K2 = y((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
            } catch (Exception unused) {
                Bitmap y = y(this.N2, true);
                this.K2 = y;
                this.O2 = y;
                return;
            }
        }
        Bitmap y2 = y(drawable, true);
        this.K2 = y2;
        this.O2 = y2;
    }

    private void P(ColorStateList colorStateList, int i) {
        Field[] declaredFields;
        if (colorStateList == null) {
            this.L2 = i;
            this.P2 = i;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                int i2 = iArr2[0];
                this.L2 = i2;
                this.P2 = i2;
            } else if (iArr.length == 2) {
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    int[] iArr3 = iArr[i3];
                    if (iArr3.length == 0) {
                        this.P2 = iArr2[i3];
                    } else if (iArr3[0] == 16842919) {
                        this.L2 = iArr2[i3];
                    } else {
                        throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                    }
                }
            } else {
                throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    private void Q() {
        Drawable drawable = this.u2;
        if (drawable instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            try {
                Class<?> cls = stateListDrawable.getClass();
                int intValue = ((Integer) cls.getMethod("getStateCount", new Class[0]).invoke(stateListDrawable, new Object[0])).intValue();
                if (intValue == 2) {
                    Class<?> cls2 = Integer.TYPE;
                    Method method = cls.getMethod("getStateSet", cls2);
                    Method method2 = cls.getMethod("getStateDrawable", cls2);
                    for (int i = 0; i < intValue; i++) {
                        int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i));
                        if (iArr.length > 0) {
                            if (iArr[0] == 16842913) {
                                this.t2 = y((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                            } else {
                                throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                            }
                        } else {
                            this.s2 = y((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            } catch (Exception unused) {
                Bitmap y = y(this.u2, false);
                this.s2 = y;
                this.t2 = y;
                return;
            }
        }
        Bitmap y2 = y(drawable, false);
        this.s2 = y2;
        this.t2 = y2;
    }

    private void R(ColorStateList colorStateList, int i) {
        Field[] declaredFields;
        if (colorStateList == null) {
            this.q2 = i;
            this.p2 = i;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                int i2 = iArr2[0];
                this.q2 = i2;
                this.p2 = i2;
            } else if (iArr.length == 2) {
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    int[] iArr3 = iArr[i3];
                    if (iArr3.length == 0) {
                        this.p2 = iArr2[i3];
                    } else if (iArr3[0] == 16842913) {
                        this.q2 = iArr2[i3];
                    } else {
                        throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                    }
                }
            } else {
                throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Something wrong happened when parsing thumb selector color." + e.getMessage());
        }
    }

    private void S(ColorStateList colorStateList, int i) {
        Field[] declaredFields;
        if (colorStateList == null) {
            this.k0 = i;
            this.K0 = i;
            this.k1 = i;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                int i2 = iArr2[0];
                this.k0 = i2;
                this.K0 = i2;
                this.k1 = i2;
            } else if (iArr.length == 3) {
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    int[] iArr3 = iArr[i3];
                    if (iArr3.length == 0) {
                        this.k0 = iArr2[i3];
                    } else {
                        int i4 = iArr3[0];
                        if (i4 == 16842913) {
                            this.K0 = iArr2[i3];
                        } else if (i4 == 16843623) {
                            this.k1 = iArr2[i3];
                        } else {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    private void T() {
        if (Z()) {
            this.c.getTextBounds("j", 0, 1, this.e);
            this.x1 = this.e.height();
            if (V()) {
                if (this.y == 1) {
                    this.R2 = this.l + Math.round(this.x1 - this.c.descent()) + f.a(this.a, 3.0f);
                    this.D = this.z + this.l + this.f + Math.round(this.x1 - this.c.descent()) + f.a(this.a, 3.0f);
                    return;
                }
                this.D = this.l + Math.round(this.x1 - this.c.descent()) + f.a(this.a, 3.0f);
                this.R2 = this.z + this.l + this.f + Math.round(this.x1 - this.c.descent()) + f.a(this.a, 3.0f);
                return;
            }
            if (D()) {
                this.D = this.l + this.f + Math.round(this.x1 - this.c.descent()) + f.a(this.a, 3.0f);
            } else if (C()) {
                this.D = this.l + Math.round(this.x1 - this.c.descent()) + f.a(this.a, 3.0f);
            }
            this.R2 = this.D;
        }
    }

    private void U() {
        if (this.x) {
            this.B2.left = this.i;
            if (C()) {
                this.B2.top = this.l + this.J2 + this.x1 + f.a(this.a, 3.0f);
            } else {
                this.B2.top = this.l + this.J2;
            }
            RectF rectF = this.B2;
            float f = this.m;
            float f2 = this.r;
            float f3 = this.q;
            float f4 = this.i + (f * (1.0f - ((f2 - f3) / (this.p - f3))));
            rectF.right = f4;
            float f5 = rectF.top;
            rectF.bottom = f5;
            RectF rectF2 = this.A2;
            rectF2.left = f4;
            rectF2.top = f5;
            rectF2.right = this.k - this.j;
            rectF2.bottom = f5;
            return;
        }
        this.A2.left = this.i;
        if (C()) {
            this.A2.top = this.l + this.J2 + this.x1 + f.a(this.a, 3.0f);
        } else {
            this.A2.top = this.l + this.J2;
        }
        RectF rectF3 = this.A2;
        float f6 = this.r;
        float f7 = this.q;
        float f8 = (((f6 - f7) * this.m) / (this.p - f7)) + this.i;
        rectF3.right = f8;
        float f9 = rectF3.top;
        rectF3.bottom = f9;
        RectF rectF4 = this.B2;
        rectF4.left = f8;
        rectF4.top = f9;
        rectF4.right = this.k - this.j;
        rectF4.bottom = f9;
    }

    private boolean V() {
        int i = this.K1;
        if (i != 0 && this.y == 2 && this.Q2 == 1) {
            return true;
        }
        return i != 0 && this.y == 1 && this.Q2 == 2;
    }

    private boolean W(float f, float f2) {
        if (this.h == -1.0f) {
            this.h = f.a(this.a, 5.0f);
        }
        float f3 = this.h;
        boolean z = f >= ((float) this.i) - (f3 * 2.0f) && f <= ((float) (this.k - this.j)) + (2.0f * f3);
        float f4 = this.A2.top;
        float f5 = this.J2;
        return z && ((f2 > ((f4 - f5) - f3) ? 1 : (f2 == ((f4 - f5) - f3) ? 0 : -1)) >= 0 && (f2 > ((f4 + f5) + f3) ? 1 : (f2 == ((f4 + f5) + f3) ? 0 : -1)) <= 0);
    }

    private boolean X(float f) {
        float touchX = getTouchX();
        int i = this.M2;
        return touchX - (((float) i) / 2.0f) <= f && f <= touchX + (((float) i) / 2.0f);
    }

    private void Y() {
        if (Z()) {
            K();
            this.c.setTypeface(this.F);
            this.c.getTextBounds("j", 0, 1, this.e);
            this.z = this.e.height() + f.a(this.a, 3.0f);
        }
    }

    private boolean Z() {
        return ((this.y == 0 || this.K1 == 0) && this.Q2 == 0) ? false : true;
    }

    private boolean a0() {
        return this.s ? this.g != this.r : Math.round(this.g) != Math.round(this.r);
    }

    private void b0(MotionEvent motionEvent) {
        d0(k(l(h(motionEvent))));
        setSeekListener(true);
        invalidate();
    }

    private void c0() {
        U();
        T();
        if (this.C1 == null) {
            return;
        }
        M();
        if (this.K1 > 2) {
            float f = this.w[getClosestIndex()];
            this.r = f;
            this.g = f;
        }
        d0(this.r);
    }

    private int getClosestIndex() {
        float abs = Math.abs(this.p - this.q);
        int i = 0;
        int i2 = 0;
        while (true) {
            float[] fArr = this.w;
            if (i >= fArr.length) {
                return i2;
            }
            float abs2 = Math.abs(fArr[i] - this.r);
            if (abs2 <= abs) {
                i2 = i;
                abs = abs2;
            }
            i++;
        }
    }

    private int getLeftSideTickColor() {
        if (this.x) {
            return this.p2;
        }
        return this.q2;
    }

    private int getLeftSideTickTextsColor() {
        if (this.x) {
            return this.k0;
        }
        return this.K0;
    }

    private int getLeftSideTrackSize() {
        if (this.x) {
            return this.C2;
        }
        return this.D2;
    }

    private int getRightSideTickColor() {
        if (this.x) {
            return this.q2;
        }
        return this.p2;
    }

    private int getRightSideTickTextsColor() {
        if (this.x) {
            return this.k0;
        }
        return this.k0;
    }

    private int getRightSideTrackSize() {
        if (this.x) {
            return this.D2;
        }
        return this.C2;
    }

    private float getThumbCenterX() {
        if (this.x) {
            return this.B2.right;
        }
        return this.A2.right;
    }

    private int getThumbPosOnTick() {
        if (this.K1 != 0) {
            return Math.round((getThumbCenterX() - this.i) / this.n);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.K1 != 0) {
            return (getThumbCenterX() - this.i) / this.n;
        }
        return 0.0f;
    }

    private float h(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        int i = this.i;
        if (x >= i) {
            float x2 = motionEvent.getX();
            int i2 = this.k;
            int i3 = this.j;
            if (x2 <= i2 - i3) {
                return motionEvent.getX();
            }
            i = i2 - i3;
        }
        return i;
    }

    private void i(j.l.a.c0.l.a aVar) {
        this.p = aVar.b;
        this.q = aVar.c;
        this.r = aVar.d;
        this.s = aVar.e;
        this.v = aVar.f;
        this.x = aVar.g;
        this.t = aVar.h;
        this.T2 = aVar.J;
        this.u = aVar.i;
        this.C2 = aVar.j;
        this.E2 = aVar.k;
        this.D2 = aVar.l;
        this.F2 = aVar.m;
        this.z2 = aVar.n;
        this.M2 = aVar.q;
        this.N2 = aVar.u;
        this.S2 = aVar.o;
        P(aVar.t, aVar.r);
        this.Q2 = aVar.p;
        this.K1 = aVar.B;
        this.v2 = aVar.C;
        this.y2 = aVar.E;
        this.u2 = aVar.F;
        this.w2 = aVar.G;
        this.x2 = aVar.H;
        R(aVar.I, aVar.D);
        this.y = aVar.v;
        this.E = aVar.x;
        this.y1 = aVar.y;
        this.F = aVar.z;
        S(aVar.A, aVar.w);
    }

    private boolean j() {
        if (this.K1 >= 3 && this.v && this.W2) {
            int closestIndex = getClosestIndex();
            float f = this.r;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, Math.abs(f - this.w[closestIndex]));
            ofFloat.start();
            ofFloat.addUpdateListener(new a(f, closestIndex));
            return true;
        }
        return false;
    }

    private float k(float f) {
        this.g = this.r;
        float f2 = this.q;
        float f3 = f2 + (((this.p - f2) * (f - this.i)) / this.m);
        this.r = f3;
        return f3;
    }

    private float l(float f) {
        if (this.K1 > 2 && !this.v) {
            f = this.i + (this.n * Math.round((f - this.i) / this.n));
        }
        return this.x ? (this.m - f) + (this.i * 2) : f;
    }

    private e m(boolean z) {
        String[] strArr;
        if (this.U2 == null) {
            this.U2 = new e(this);
        }
        this.U2.b = getProgress();
        this.U2.c = getProgressFloat();
        this.U2.d = z;
        if (this.K1 > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (this.y != 0 && (strArr = this.A) != null) {
                this.U2.f = strArr[thumbPosOnTick];
            }
            if (this.x) {
                this.U2.e = (this.K1 - thumbPosOnTick) - 1;
            } else {
                this.U2.e = thumbPosOnTick;
            }
        }
        return this.U2;
    }

    public static j.l.a.c0.l.a m0(@NonNull Context context) {
        return new j.l.a.c0.l.a(context);
    }

    private void n() {
        int i = this.K1;
        if (i < 0 || i > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.K1);
        } else if (i == 0) {
        } else {
            this.C1 = new float[i];
            if (this.y != 0) {
                this.C = new float[i];
                this.B = new float[i];
            }
            this.w = new float[i];
            int i2 = 0;
            while (true) {
                float[] fArr = this.w;
                if (i2 >= fArr.length) {
                    return;
                }
                float f = this.q;
                float f2 = i2 * (this.p - f);
                int i3 = this.K1;
                fArr[i2] = f + (f2 / (i3 + (-1) > 0 ? i3 - 1 : 1));
                i2++;
            }
        }
    }

    private void s(Canvas canvas) {
        float thumbCenterX = getThumbCenterX();
        if (this.N2 != null) {
            if (this.K2 == null || this.O2 == null) {
                O();
            }
            if (this.K2 != null && this.O2 != null) {
                this.b.setAlpha(JfifUtil.MARKER_FIRST_BYTE);
                if (this.o) {
                    Bitmap bitmap = this.O2;
                    canvas.drawBitmap(bitmap, thumbCenterX - (bitmap.getWidth() / 2.0f), this.A2.top - (this.O2.getHeight() / 2.0f), this.b);
                    return;
                }
                Bitmap bitmap2 = this.K2;
                canvas.drawBitmap(bitmap2, thumbCenterX - (bitmap2.getWidth() / 2.0f), this.A2.top - (this.K2.getHeight() / 2.0f), this.b);
                return;
            }
            throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
        }
        if (this.o) {
            this.b.setColor(this.P2);
        } else {
            this.b.setColor(this.L2);
        }
        canvas.drawCircle(thumbCenterX, this.A2.top, this.o ? this.J2 : this.I2, this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeekListener(boolean z) {
        if (this.d != null && a0()) {
            this.d.c(m(z));
        }
    }

    private void t(Canvas canvas) {
        int i = this.Q2;
        if (i == 0 || this.y == i) {
            return;
        }
        this.c.setColor(this.S2);
        canvas.drawText(A(this.r), getThumbCenterX(), this.R2, this.c);
    }

    private void v(Canvas canvas) {
        int rightSideTrackSize;
        Bitmap bitmap;
        if (this.K1 != 0) {
            if (this.v2 == 0 && this.u2 == null) {
                return;
            }
            float thumbCenterX = getThumbCenterX();
            for (int i = 0; i < this.C1.length; i++) {
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if ((!this.x2 || thumbCenterX < this.C1[i]) && ((!this.w2 || (i != 0 && i != this.C1.length - 1)) && (i != getThumbPosOnTick() || this.K1 <= 2 || this.v))) {
                    float f = i;
                    if (f <= thumbPosOnTickFloat) {
                        this.b.setColor(getLeftSideTickColor());
                    } else {
                        this.b.setColor(getRightSideTickColor());
                    }
                    if (this.u2 != null) {
                        if (this.t2 == null || this.s2 == null) {
                            Q();
                        }
                        Bitmap bitmap2 = this.t2;
                        if (bitmap2 == null || (bitmap = this.s2) == null) {
                            throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
                        }
                        if (f <= thumbPosOnTickFloat) {
                            canvas.drawBitmap(bitmap2, this.C1[i] - (bitmap.getWidth() / 2.0f), this.A2.top - (this.s2.getHeight() / 2.0f), this.b);
                        } else {
                            canvas.drawBitmap(bitmap, this.C1[i] - (bitmap.getWidth() / 2.0f), this.A2.top - (this.s2.getHeight() / 2.0f), this.b);
                        }
                    } else {
                        int i2 = this.v2;
                        if (i2 == 1) {
                            canvas.drawCircle(this.C1[i], this.A2.top, this.r2, this.b);
                        } else if (i2 == 3) {
                            int a2 = f.a(this.a, 1.0f);
                            if (thumbCenterX >= this.C1[i]) {
                                rightSideTrackSize = getLeftSideTrackSize();
                            } else {
                                rightSideTrackSize = getRightSideTrackSize();
                            }
                            float[] fArr = this.C1;
                            float f2 = a2;
                            float f3 = fArr[i] - f2;
                            float f4 = this.A2.top;
                            float f5 = rightSideTrackSize / 2.0f;
                            canvas.drawRect(f3, f4 - f5, fArr[i] + f2, f4 + f5, this.b);
                        } else if (i2 == 2) {
                            float[] fArr2 = this.C1;
                            float f6 = fArr2[i];
                            int i3 = this.y2;
                            float f7 = f6 - (i3 / 2.0f);
                            float f8 = this.A2.top;
                            canvas.drawRect(f7, f8 - (i3 / 2.0f), fArr2[i] + (i3 / 2.0f), f8 + (i3 / 2.0f), this.b);
                        }
                    }
                }
            }
        }
    }

    private void w(Canvas canvas) {
        if (this.A == null) {
            return;
        }
        float thumbPosOnTickFloat = getThumbPosOnTickFloat();
        for (int i = 0; i < this.A.length; i++) {
            if (i == getThumbPosOnTick()) {
                this.c.setColor(this.k1);
            } else if (i < thumbPosOnTickFloat) {
                this.c.setColor(getLeftSideTickTextsColor());
            } else {
                this.c.setColor(getRightSideTickTextsColor());
            }
            int length = this.x ? (this.A.length - 1) - i : i;
            if (i == 0) {
                canvas.drawText(this.A[length], this.C[i] + (this.B[length] / 2.0f), this.D, this.c);
            } else {
                String[] strArr = this.A;
                if (i == strArr.length - 1) {
                    canvas.drawText(strArr[length], this.C[i] - (this.B[length] / 2.0f), this.D, this.c);
                } else {
                    canvas.drawText(strArr[length], this.C[i], this.D, this.c);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.H2) {
            int i = this.K1;
            int i2 = i + (-1) > 0 ? i - 1 : 1;
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.x) {
                    this.b.setColor(this.G2[(i2 - i3) - 1]);
                } else {
                    this.b.setColor(this.G2[i3]);
                }
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                float f = i3;
                if (f < thumbPosOnTickFloat) {
                    int i4 = i3 + 1;
                    if (thumbPosOnTickFloat < i4) {
                        float thumbCenterX = getThumbCenterX();
                        this.b.setStrokeWidth(getLeftSideTrackSize());
                        float f2 = this.C1[i3];
                        RectF rectF = this.A2;
                        canvas.drawLine(f2, rectF.top, thumbCenterX, rectF.bottom, this.b);
                        this.b.setStrokeWidth(getRightSideTrackSize());
                        RectF rectF2 = this.A2;
                        canvas.drawLine(thumbCenterX, rectF2.top, this.C1[i4], rectF2.bottom, this.b);
                    }
                }
                if (f < thumbPosOnTickFloat) {
                    this.b.setStrokeWidth(getLeftSideTrackSize());
                } else {
                    this.b.setStrokeWidth(getRightSideTrackSize());
                }
                float[] fArr = this.C1;
                float f3 = fArr[i3];
                RectF rectF3 = this.A2;
                canvas.drawLine(f3, rectF3.top, fArr[i3 + 1], rectF3.bottom, this.b);
            }
            return;
        }
        this.b.setColor(this.F2);
        this.b.setStrokeWidth(this.D2);
        RectF rectF4 = this.A2;
        canvas.drawLine(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom, this.b);
        this.b.setColor(this.E2);
        this.b.setStrokeWidth(this.C2);
        RectF rectF5 = this.B2;
        canvas.drawLine(rectF5.left, rectF5.top, rectF5.right, rectF5.bottom, this.b);
    }

    private Bitmap y(Drawable drawable, boolean z) {
        int intrinsicHeight;
        int i;
        if (drawable == null) {
            return null;
        }
        int a2 = f.a(this.a, 30.0f);
        if (drawable.getIntrinsicWidth() > a2) {
            if (z) {
                i = this.M2;
            } else {
                i = this.y2;
            }
            intrinsicHeight = z(drawable, i);
            if (i > a2) {
                intrinsicHeight = z(drawable, a2);
            } else {
                a2 = i;
            }
        } else {
            a2 = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(a2, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private int z(Drawable drawable, int i) {
        return Math.round(((i * 1.0f) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
    }

    public void d0(float f) {
        if (this.x) {
            RectF rectF = this.B2;
            float f2 = this.m;
            float f3 = this.q;
            float f4 = this.i + (f2 * (1.0f - ((f - f3) / (this.p - f3))));
            rectF.right = f4;
            this.A2.left = f4;
            return;
        }
        RectF rectF2 = this.A2;
        float f5 = this.q;
        float f6 = (((f - f5) * this.m) / (this.p - f5)) + this.i;
        rectF2.right = f6;
        this.B2.left = f6;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        if (parent == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            parent.requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e0(@ColorInt int i) {
        this.L2 = i;
        this.P2 = i;
        invalidate();
    }

    public void g0(@NonNull ColorStateList colorStateList) {
        P(colorStateList, this.L2);
        invalidate();
    }

    public float getMax() {
        return this.p;
    }

    public float getMin() {
        return this.q;
    }

    public d getOnSeekChangeListener() {
        return this.d;
    }

    public int getProgress() {
        return Math.round(this.r);
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf(this.r).setScale(this.V2, 4).floatValue();
    }

    public int getTickCount() {
        return this.K1;
    }

    public synchronized float getTouchX() {
        d0(this.r);
        if (this.x) {
            return this.B2.right;
        }
        return this.A2.right;
    }

    public void h0(@ColorInt int i) {
        this.q2 = i;
        this.p2 = i;
        invalidate();
    }

    public void i0(@NonNull ColorStateList colorStateList) {
        R(colorStateList, this.q2);
        invalidate();
    }

    public void j0(@ColorInt int i) {
        this.k0 = i;
        this.k0 = i;
        this.k1 = i;
        invalidate();
    }

    public void k0(@NonNull ColorStateList colorStateList) {
        S(colorStateList, this.K0);
        invalidate();
    }

    public void o(@NonNull j.l.a.c0.l.b bVar) {
        int i = this.K1;
        int i2 = i + (-1) > 0 ? i - 1 : 1;
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = this.E2;
        }
        this.H2 = bVar.a(iArr);
        this.G2 = iArr;
        invalidate();
    }

    @Override // android.view.View
    public synchronized void onDraw(Canvas canvas) {
        x(canvas);
        v(canvas);
        w(canvas);
        s(canvas);
        t(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int round = Math.round(this.f + getPaddingTop() + getPaddingBottom());
        if (V()) {
            setMeasuredDimension(View.resolveSize(f.a(this.a, 170.0f), i), round + (this.z * 2));
        } else {
            setMeasuredDimension(View.resolveSize(f.a(this.a, 170.0f), i), round + this.z);
        }
        I();
        c0();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            float f = bundle.getFloat("tsb_progress");
            this.r = f;
            setProgress(f);
            super.onRestoreInstanceState(bundle.getParcelable("tsb_instance_state"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("tsb_instance_state", super.onSaveInstanceState());
        bundle.putFloat("tsb_progress", this.r);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new b());
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.t
            r1 = 0
            if (r0 == 0) goto L61
            boolean r0 = r4.isEnabled()
            if (r0 != 0) goto Lc
            goto L61
        Lc:
            int r0 = r5.getAction()
            r2 = 1
            if (r0 == 0) goto L33
            if (r0 == r2) goto L20
            r2 = 2
            if (r0 == r2) goto L1c
            r2 = 3
            if (r0 == r2) goto L20
            goto L5c
        L1c:
            r4.b0(r5)
            goto L5c
        L20:
            j.l.a.c0.l.d r0 = r4.d
            if (r0 == 0) goto L27
            r0.a(r4)
        L27:
            r4.o = r1
            boolean r0 = r4.j()
            if (r0 != 0) goto L5c
            r4.invalidate()
            goto L5c
        L33:
            r4.performClick()
            float r0 = r5.getX()
            float r3 = r5.getY()
            boolean r3 = r4.W(r0, r3)
            if (r3 == 0) goto L5c
            boolean r3 = r4.u
            if (r3 == 0) goto L4f
            boolean r0 = r4.X(r0)
            if (r0 != 0) goto L4f
            return r1
        L4f:
            j.l.a.c0.l.d r0 = r4.d
            if (r0 == 0) goto L56
            r0.b(r4)
        L56:
            r4.o = r2
            r4.b0(r5)
            return r2
        L5c:
            boolean r5 = super.onTouchEvent(r5)
            return r5
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.imgo.widget.seekbar.TickSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p(@NonNull String[] strArr) {
        this.y1 = strArr;
        if (this.A != null) {
            int i = 0;
            while (i < this.A.length) {
                String valueOf = i < strArr.length ? String.valueOf(strArr[i]) : "";
                int i2 = this.x ? (this.K1 - 1) - i : i;
                this.A[i2] = valueOf;
                TextPaint textPaint = this.c;
                if (textPaint != null && this.e != null) {
                    textPaint.getTextBounds(valueOf, 0, valueOf.length(), this.e);
                    this.B[i2] = this.e.width();
                }
                i++;
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void r(@NonNull Typeface typeface) {
        this.F = typeface;
        Y();
        requestLayout();
        invalidate();
    }

    public void setDecimalScale(int i) {
        this.V2 = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (z == isEnabled()) {
            return;
        }
        super.setEnabled(z);
        if (isEnabled()) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.3f);
        }
    }

    public synchronized void setMax(float f) {
        this.p = Math.max(this.q, f);
        H();
        c0();
        invalidate();
    }

    public synchronized void setMin(float f) {
        this.q = Math.min(this.p, f);
        H();
        c0();
        invalidate();
    }

    public void setOnSeekChangeListener(@NonNull d dVar) {
        this.d = dVar;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b A[Catch: all -> 0x0033, TryCatch #0 {, blocks: (B:3:0x0001, B:9:0x0014, B:11:0x001b, B:12:0x0025, B:6:0x000d), top: B:20:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void setProgress(float r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            float r0 = r2.r     // Catch: java.lang.Throwable -> L33
            r2.g = r0     // Catch: java.lang.Throwable -> L33
            float r0 = r2.q     // Catch: java.lang.Throwable -> L33
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto Ld
        Lb:
            r3 = r0
            goto L14
        Ld:
            float r0 = r2.p     // Catch: java.lang.Throwable -> L33
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto L14
            goto Lb
        L14:
            r2.r = r3     // Catch: java.lang.Throwable -> L33
            int r3 = r2.K1     // Catch: java.lang.Throwable -> L33
            r0 = 2
            if (r3 <= r0) goto L25
            float[] r3 = r2.w     // Catch: java.lang.Throwable -> L33
            int r0 = r2.getClosestIndex()     // Catch: java.lang.Throwable -> L33
            r3 = r3[r0]     // Catch: java.lang.Throwable -> L33
            r2.r = r3     // Catch: java.lang.Throwable -> L33
        L25:
            r3 = 0
            r2.setSeekListener(r3)     // Catch: java.lang.Throwable -> L33
            float r3 = r2.r     // Catch: java.lang.Throwable -> L33
            r2.d0(r3)     // Catch: java.lang.Throwable -> L33
            r2.postInvalidate()     // Catch: java.lang.Throwable -> L33
            monitor-exit(r2)
            return
        L33:
            r3 = move-exception
            monitor-exit(r2)
            goto L37
        L36:
            throw r3
        L37:
            goto L36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.imgo.widget.seekbar.TickSeekBar.setProgress(float):void");
    }

    public void setR2L(boolean z) {
        this.x = z;
        requestLayout();
        invalidate();
    }

    public void setThumbAdjustAuto(boolean z) {
        this.W2 = z;
    }

    public void setThumbDrawable(@NonNull Drawable drawable) {
        this.N2 = drawable;
        float min = Math.min(f.a(this.a, 30.0f), this.M2) / 2.0f;
        this.I2 = min;
        this.J2 = min;
        this.f = Math.max(min, this.r2) * 2.0f;
        O();
        requestLayout();
        invalidate();
    }

    public synchronized void setTickCount(int i) {
        int i2 = this.K1;
        if (i2 >= 0 && i2 <= 50) {
            this.K1 = i;
            n();
            M();
            I();
            c0();
            invalidate();
        } else {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.K1);
        }
    }

    public void setTickMarksDrawable(@NonNull Drawable drawable) {
        this.u2 = drawable;
        float min = Math.min(f.a(this.a, 30.0f), this.y2) / 2.0f;
        this.r2 = min;
        this.f = Math.max(this.J2, min) * 2.0f;
        Q();
        invalidate();
    }

    @Override // android.view.View
    public String toString() {
        return "TickSeekBar{lastProgress=" + this.g + ", mMax=" + this.p + ", mMin=" + this.q + ", mProgress=" + this.r + ", mTicksCount=" + this.K1 + '}';
    }

    public TickSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = -1.0f;
        this.V2 = 1;
        this.a = context;
        E(context, attributeSet);
        G();
    }

    public TickSeekBar(j.l.a.c0.l.a aVar) {
        super(aVar.a);
        this.h = -1.0f;
        this.V2 = 1;
        Context context = aVar.a;
        this.a = context;
        int a2 = f.a(context, 16.0f);
        setPadding(a2, getPaddingTop(), a2, getPaddingBottom());
        i(aVar);
        G();
    }
}
