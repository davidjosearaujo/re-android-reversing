package com.hunantv.imgo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hunantv.imgo.nightmode.view.SkinnableView;
import j.l.a.a;
import j.l.a.a0.b;
import j.l.a.b0.j0;
import j.l.a.b0.n0;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class RoundRectCheckButton extends SkinnableView {
    private static final boolean D = true;
    private static final boolean E = false;
    public static final int K1 = 10;
    private static final int k0 = 0;
    private static final boolean x1 = false;
    private static final float y1 = 0.8f;
    @Nullable
    private String A;
    public int B;
    private RectF C;
    private Paint a;
    private Paint b;
    private Paint c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private int m;
    @ColorInt
    private int n;
    @ColorInt
    private int o;
    @Nullable
    private Drawable p;
    @Nullable
    private Drawable q;
    private int r;
    @Nullable
    private DrawIcon s;
    @Nullable
    private DrawIcon t;
    @ColorInt
    private int u;
    @ColorInt
    private int v;
    private int w;
    @ColorInt
    private int x;
    @ColorInt
    private int y;
    @Nullable
    private String z;
    private static final int F = j0.b(a.a(), 2.0f);
    private static final int K0 = j0.b(a.a(), 6.0f);
    private static final int k1 = j0.b(a.a(), 1.0f);
    private static final int C1 = j0.b(a.a(), 1.0f);

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum DrawIcon {
        UNKNOWN(0),
        ADD(1);
        
        private final int mID;

        DrawIcon(int i) {
            this.mID = i;
        }

        @NonNull
        public static DrawIcon fromID(int i) {
            DrawIcon[] values;
            for (DrawIcon drawIcon : values()) {
                if (drawIcon.mID == i) {
                    return drawIcon;
                }
            }
            return UNKNOWN;
        }
    }

    public RoundRectCheckButton(Context context) {
        this(context, null);
    }

    @Nullable
    private DrawIcon c(boolean z) {
        return z ? this.t : this.s;
    }

    @ColorInt
    private int d(boolean z) {
        return z ? this.v : this.u;
    }

    @Nullable
    private Drawable e(boolean z) {
        return z ? this.q : this.p;
    }

    private int f(boolean z) {
        Drawable e = e(z);
        if (e != null) {
            return e.getIntrinsicHeight();
        }
        DrawIcon c = c(z);
        if (c == null || DrawIcon.UNKNOWN == c) {
            return 0;
        }
        return (int) (n0.B(this.c) * y1);
    }

    private int g(boolean z, @Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (e(z) != null) {
            return this.i;
        }
        DrawIcon c = c(z);
        if (c == null || DrawIcon.UNKNOWN == c) {
            return 0;
        }
        return this.i;
    }

    private int h(boolean z) {
        Drawable e = e(z);
        if (e != null) {
            return e.getIntrinsicWidth();
        }
        DrawIcon c = c(z);
        if (c == null || DrawIcon.UNKNOWN == c) {
            return 0;
        }
        return (int) (n0.B(this.c) * y1);
    }

    @ColorInt
    private int i(boolean z) {
        return z ? this.o : this.n;
    }

    @Nullable
    private String j(boolean z) {
        return z ? this.A : this.z;
    }

    @ColorInt
    private int k(boolean z) {
        return z ? this.y : this.x;
    }

    private void n(Canvas canvas) {
        int f;
        DrawIcon c = c(this.g);
        if (c == null || DrawIcon.UNKNOWN == c) {
            return;
        }
        this.b.setColor(d(this.g));
        if (DrawIcon.ADD == c) {
            int measuredHeight = getMeasuredHeight();
            int h = h(this.g);
            float f2 = measuredHeight / 2.0f;
            float f3 = (measuredHeight - f) / 2.0f;
            float f4 = f(this.g);
            float f5 = f3 + (f4 / 2.0f);
            float f6 = h;
            canvas.drawLine(f2, f5, f2 + f6, f5, this.b);
            float f7 = f2 + (f6 / 2.0f);
            canvas.drawLine(f7, f3, f7, f3 + f4, this.b);
        }
    }

    private void o(boolean z, @Nullable DrawIcon drawIcon) {
        if (z) {
            if (this.t == drawIcon) {
                return;
            }
            this.t = drawIcon;
        } else if (this.s == drawIcon) {
            return;
        } else {
            this.s = drawIcon;
        }
        invalidate();
    }

    private void p(boolean z, @ColorInt int i) {
        if (z) {
            if (this.o == i && this.v == i && this.y == i) {
                return;
            }
            this.o = i;
            this.v = i;
            this.y = i;
        } else if (this.n == i && this.u == i && this.x == i) {
            return;
        } else {
            this.n = i;
            this.u = i;
            this.x = i;
        }
        invalidate();
    }

    public boolean l() {
        return this.f;
    }

    public boolean m() {
        return this.g;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            return;
        }
        this.a.setColor(i(this.g));
        if (this.C == null) {
            this.C = new RectF();
        }
        RectF rectF = this.C;
        int i = this.m;
        rectF.left = i;
        rectF.top = i;
        rectF.right = getWidth() - this.m;
        this.C.bottom = getHeight() - this.m;
        RectF rectF2 = this.C;
        int i2 = this.B;
        canvas.drawRoundRect(rectF2, i2, i2, this.a);
        Drawable e = e(this.g);
        if (e != null) {
            int h = h(this.g);
            int f = f(this.g);
            int i3 = measuredHeight / 2;
            int i4 = (measuredHeight - f) / 2;
            e.setBounds(i3, i4, h + i3, f + i4);
            e.draw(canvas);
        } else {
            n(canvas);
        }
        this.c.setColor(k(this.g));
        String j = j(this.g);
        if (TextUtils.isEmpty(j)) {
            return;
        }
        int h2 = h(this.g) + g(this.g, j);
        float f2 = measuredHeight / 2.0f;
        float f3 = (measuredWidth - measuredHeight) - h2;
        Paint.FontMetrics fontMetrics = this.c.getFontMetrics();
        canvas.drawText(j, h2 + f2 + ((f3 - n0.C(this.c, j)) / 2.0f), (f2 - fontMetrics.descent) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f), this.c);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int B = (int) n0.B(this.c);
        int max = Math.max(Math.max((this.k * 2) + Math.max(B, f(false)), (this.k * 2) + Math.max(B, f(true))), this.e);
        int max2 = Math.max(Math.max((int) ((this.j * 2) + max + h(false) + g(false, this.z) + n0.C(this.c, this.z)), (int) ((this.j * 2) + max + h(true) + g(true, this.A) + n0.C(this.c, this.A))), this.d);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (1073741824 == mode) {
            max2 = size;
        }
        if (1073741824 == mode2) {
            max = size2;
        }
        setMeasuredDimension(max2, max);
    }

    public void r(boolean z, @Nullable String str) {
        if (z) {
            if (TextUtils.equals(this.A, str)) {
                return;
            }
            this.A = str;
        } else if (TextUtils.equals(this.z, str)) {
            return;
        } else {
            this.z = str;
        }
        invalidate();
    }

    public void setCheckable(boolean z) {
        if (this.f == z) {
            return;
        }
        this.f = z;
        invalidate();
    }

    public void setChecked(boolean z) {
        if (!this.f || this.g == z) {
            return;
        }
        this.g = z;
        invalidate();
    }

    public void setColorCheck(@ColorInt int i) {
        p(true, i);
    }

    public void setColorUnCheck(@ColorInt int i) {
        p(false, i);
    }

    public void setDrawIconCheck(@Nullable DrawIcon drawIcon) {
        o(true, drawIcon);
    }

    public void setDrawIconColorUnCheck(int i) {
        this.u = i;
    }

    public void setDrawIconUnCheck(@Nullable DrawIcon drawIcon) {
        o(false, drawIcon);
    }

    public void setRectFill(boolean z) {
        this.l = z;
        this.a.setStyle(z ? Paint.Style.FILL : Paint.Style.STROKE);
    }

    public void setTextCheck(@Nullable String str) {
        r(true, str);
    }

    public void setTextColorUnCheck(int i) {
        this.x = i;
    }

    public void setTextSize(int i) {
        if (this.w == i) {
            return;
        }
        this.w = i;
        this.c.setTextSize(i);
        invalidate();
    }

    public void setTextUnCheck(@Nullable String str) {
        r(false, str);
    }

    public RoundRectCheckButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundRectCheckButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.r.RoundRectCheckButton);
        this.d = obtainStyledAttributes.getDimensionPixelSize(b.r.RoundRectCheckButton_minimumWidth, -1);
        this.e = obtainStyledAttributes.getDimensionPixelSize(b.r.RoundRectCheckButton_minimumHeight, -1);
        this.f = obtainStyledAttributes.getBoolean(b.r.RoundRectCheckButton_checkable, true);
        this.g = obtainStyledAttributes.getBoolean(b.r.RoundRectCheckButton_checked, false);
        this.h = obtainStyledAttributes.getBoolean(b.r.RoundRectCheckButton_useBoldFont, false);
        int i2 = b.r.RoundRectCheckButton_angle;
        this.B = obtainStyledAttributes.getInteger(i2, 10);
        this.i = obtainStyledAttributes.getDimensionPixelSize(b.r.RoundRectCheckButton_iconPadding, F);
        this.j = obtainStyledAttributes.getDimensionPixelSize(b.r.RoundRectCheckButton_horizontalPadding, 0);
        this.k = obtainStyledAttributes.getDimensionPixelSize(b.r.RoundRectCheckButton_verticalPadding, K0);
        int color = obtainStyledAttributes.getColor(b.r.RoundRectCheckButton_colorUnCheck, 0);
        int color2 = obtainStyledAttributes.getColor(b.r.RoundRectCheckButton_colorCheck, 0);
        this.m = obtainStyledAttributes.getDimensionPixelSize(b.r.RoundRectCheckButton_rectStrokeWidth, k1);
        this.l = obtainStyledAttributes.getBoolean(b.r.RoundRectCheckButton_rectFill, false);
        int i3 = b.r.RoundRectCheckButton_rectColor;
        if (obtainStyledAttributes.hasValue(i3)) {
            int color3 = obtainStyledAttributes.getColor(i3, 0);
            this.o = color3;
            this.n = color3;
        } else {
            this.n = obtainStyledAttributes.getColor(b.r.RoundRectCheckButton_rectColorUnCheck, color);
            this.o = obtainStyledAttributes.getColor(b.r.RoundRectCheckButton_rectColorCheck, color2);
        }
        int i4 = b.r.RoundRectCheckButton_icon;
        if (obtainStyledAttributes.hasValue(i4)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(i4);
            this.q = drawable;
            this.p = drawable;
        } else {
            this.p = obtainStyledAttributes.getDrawable(b.r.RoundRectCheckButton_iconUnCheck);
            this.q = obtainStyledAttributes.getDrawable(b.r.RoundRectCheckButton_iconCheck);
        }
        this.B = obtainStyledAttributes.getInteger(i2, 10);
        this.r = obtainStyledAttributes.getDimensionPixelSize(b.r.RoundRectCheckButton_drawIconStrokeWidth, C1);
        int i5 = b.r.RoundRectCheckButton_drawIconUnCheck;
        DrawIcon drawIcon = DrawIcon.UNKNOWN;
        this.s = DrawIcon.fromID(obtainStyledAttributes.getInt(i5, drawIcon.ordinal()));
        this.u = obtainStyledAttributes.getColor(b.r.RoundRectCheckButton_drawIconColorUnCheck, color);
        this.t = DrawIcon.fromID(obtainStyledAttributes.getInt(b.r.RoundRectCheckButton_drawIconCheck, drawIcon.ordinal()));
        this.v = obtainStyledAttributes.getColor(b.r.RoundRectCheckButton_drawIconColorCheck, color2);
        this.w = obtainStyledAttributes.getDimensionPixelSize(b.r.RoundRectCheckButton_textSize, 0);
        int i6 = b.r.RoundRectCheckButton_textColor;
        if (obtainStyledAttributes.hasValue(i6)) {
            int color4 = obtainStyledAttributes.getColor(i6, 0);
            this.y = color4;
            this.x = color4;
        } else {
            this.x = obtainStyledAttributes.getColor(b.r.RoundRectCheckButton_textColorUnCheck, color);
            this.y = obtainStyledAttributes.getColor(b.r.RoundRectCheckButton_textColorCheck, color2);
        }
        int i7 = b.r.RoundRectCheckButton_text;
        if (obtainStyledAttributes.hasValue(i7)) {
            String string = obtainStyledAttributes.getString(i7);
            this.A = string;
            this.z = string;
        } else {
            this.z = obtainStyledAttributes.getString(b.r.RoundRectCheckButton_textUnCheck);
            this.A = obtainStyledAttributes.getString(b.r.RoundRectCheckButton_textCheck);
        }
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStyle(this.l ? Paint.Style.FILL : Paint.Style.STROKE);
        this.a.setStrokeWidth(this.m);
        Paint paint2 = new Paint(1);
        this.b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.b.setStrokeWidth(this.r);
        Paint paint3 = new Paint(1);
        this.c = paint3;
        paint3.setTextSize(this.w);
        this.c.setFakeBoldText(this.h);
    }
}
