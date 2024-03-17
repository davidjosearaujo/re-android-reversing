package com.hunantv.imgo.nightmode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import j.l.a.a0.b;
import j.l.a.b0.q;
import j.l.a.t.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinnableEditText extends AppCompatEditText implements h {
    public SkinnableEditText(Context context) {
        this(context, null);
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
            super/*android.widget.EditText*/.draw(canvas);
            canvas.restore();
            return;
        }
        super/*android.widget.EditText*/.draw(canvas);
    }

    public SkinnableEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.c.editTextStyle);
    }

    public SkinnableEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
