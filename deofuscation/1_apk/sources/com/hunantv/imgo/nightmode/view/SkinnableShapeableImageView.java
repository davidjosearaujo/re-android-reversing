package com.hunantv.imgo.nightmode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.google.android.material.imageview.ShapeableImageView;
import j.l.a.b0.q;
import j.l.a.t.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinnableShapeableImageView extends ShapeableImageView implements h {
    public SkinnableShapeableImageView(Context context) {
        super(context);
    }

    public void addAttributeResource(int i, int i2) {
    }

    public void applyDayNight() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void applyGrayMode() {
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dispatchDraw(Canvas canvas) {
        if (q.f(this)) {
            q.d(this, canvas);
            super/*android.widget.ImageView*/.dispatchDraw(canvas);
            canvas.restore();
            return;
        }
        super/*android.widget.ImageView*/.dispatchDraw(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void draw(Canvas canvas) {
        if (q.f(this)) {
            q.d(this, canvas);
            super/*android.widget.ImageView*/.draw(canvas);
            canvas.restore();
            return;
        }
        super/*android.widget.ImageView*/.draw(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackground(Drawable drawable) {
        q.c(this, drawable);
        super/*androidx.appcompat.widget.AppCompatImageView*/.setBackgroundDrawable(drawable);
    }

    public SkinnableShapeableImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SkinnableShapeableImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
