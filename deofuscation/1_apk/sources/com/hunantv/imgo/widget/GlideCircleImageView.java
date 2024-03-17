package com.hunantv.imgo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import j.l.a.a0.b;
import j.l.a.t.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class GlideCircleImageView extends MgFrescoImageView {
    private static final int h = b.e.color_avatar_border;
    private static final int i = b.f.dp_1;
    private a c;
    private final Paint d;
    private boolean e;
    private int f;
    private int g;

    public GlideCircleImageView(Context context) {
        this(context, null);
    }

    private float h() {
        if (this.g <= 0) {
            return 0.0f;
        }
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            return 0.0f;
        }
        int min = Math.min(width, height);
        float f = (min - this.g) / 2.0f;
        if (Float.compare(f, 0.0f) <= 0) {
            return 0.0f;
        }
        return f / (min / 2.0f);
    }

    @Override // com.hunantv.imgo.widget.MgFrescoImageView, com.hunantv.imgo.nightmode.view.SkinableSimpleDraweeView
    public void applyDayNight() {
        super.applyDayNight();
        int a = this.c.a(b.r.SkinnableImageView[b.r.SkinnableImageView_android_src]);
        if (a > 0) {
            setImageResource(a);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.e) {
            super.onDraw(canvas);
            return;
        }
        float h2 = h();
        if (Float.compare(h2, 0.0f) <= 0) {
            super.onDraw(canvas);
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int min = Math.min(width, height);
        float f = width / 2.0f;
        float f2 = height / 2.0f;
        canvas.save();
        canvas.scale(h2, h2, f, f2);
        super.onDraw(canvas);
        canvas.restore();
        if (this.f != 0) {
            this.d.setStyle(Paint.Style.STROKE);
            this.d.setColor(this.f);
            this.d.setStrokeWidth(this.g);
            canvas.drawCircle(f, f2, (min - this.g) / 2.0f, this.d);
        }
    }

    public void setBorderColor(int i2) {
        if (this.f != i2) {
            this.f = i2;
            postInvalidate();
        }
    }

    public void setBorderEnable(boolean z) {
        if (this.e != z) {
            this.e = z;
            postInvalidate();
        }
    }

    public void setBorderWidth(int i2) {
        if (i2 >= 0 && this.g != i2) {
            this.g = i2;
            postInvalidate();
        }
    }

    public GlideCircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GlideCircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.d = new Paint(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.r.GlideCircleImageView);
        this.f = obtainStyledAttributes.getColor(b.r.GlideCircleImageView_borderColor, ContextCompat.getColor(context, h));
        this.g = obtainStyledAttributes.getDimensionPixelSize(b.r.GlideCircleImageView_borderWidth, getResources().getDimensionPixelSize(i));
        this.e = obtainStyledAttributes.getBoolean(b.r.GlideCircleImageView_borderEnable, true);
        obtainStyledAttributes.recycle();
        this.c = new a();
        int[] iArr = b.r.SkinnableImageView;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        this.c.d(obtainStyledAttributes2, iArr);
        obtainStyledAttributes2.recycle();
    }
}
