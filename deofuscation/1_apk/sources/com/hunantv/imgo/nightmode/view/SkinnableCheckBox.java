package com.hunantv.imgo.nightmode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import j.l.a.b0.q;
import j.l.a.t.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinnableCheckBox extends AppCompatCheckBox implements h {
    public SkinnableCheckBox(Context context) {
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
    public void draw(Canvas canvas) {
        if (q.f(this)) {
            q.d(this, canvas);
            super/*android.widget.CheckBox*/.draw(canvas);
            canvas.restore();
            return;
        }
        super/*android.widget.CheckBox*/.draw(canvas);
    }

    public SkinnableCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SkinnableCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
