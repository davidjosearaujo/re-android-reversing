package com.hunantv.imgo.nightmode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import j.l.a.b0.q;
import j.l.a.t.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinableSimpleDraweeView extends SimpleDraweeView implements h {
    public SkinableSimpleDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
    }

    public void addAttributeResource(int i, int i2) {
    }

    public void applyDayNight() {
    }

    public void applyGrayMode() {
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            if (q.f(this)) {
                q.d(this, canvas);
                super.draw(canvas);
                canvas.restore();
            } else {
                super.draw(canvas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        q.c(this, drawable);
        super.setBackgroundDrawable(drawable);
    }

    public SkinableSimpleDraweeView(Context context) {
        super(context);
    }

    public SkinableSimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SkinableSimpleDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SkinableSimpleDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
