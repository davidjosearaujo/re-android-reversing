package com.hunantv.imgo.nightmode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import j.l.a.b0.q;
import j.l.a.t.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinnablePlayerHorizontalScrollView extends HorizontalScrollView implements h {
    public SkinnablePlayerHorizontalScrollView(Context context) {
        super(context);
    }

    public void addAttributeResource(int i, int i2) {
    }

    public void applyDayNight() {
    }

    public void applyGrayMode() {
        invalidate();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void draw(Canvas canvas) {
        if (q.f(this)) {
            q.d(this, canvas);
            super.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas);
    }

    public SkinnablePlayerHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SkinnablePlayerHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
