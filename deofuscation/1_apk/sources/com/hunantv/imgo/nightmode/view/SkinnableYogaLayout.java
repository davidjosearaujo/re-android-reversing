package com.hunantv.imgo.nightmode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.yoga.android.YogaLayout;
import j.l.a.b0.q;
import j.l.a.t.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinnableYogaLayout extends YogaLayout implements h {
    public SkinnableYogaLayout(Context context) {
        this(context, null);
    }

    public void addAttributeResource(int i, int i2) {
    }

    public void applyDayNight() {
    }

    public void applyGrayMode() {
        setBackground(getBackground());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (q.f(this)) {
            q.d(this, canvas);
            super.onDraw(canvas);
            canvas.restore();
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        q.c(this, drawable);
        super.setBackgroundDrawable(drawable);
    }

    public SkinnableYogaLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinnableYogaLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
