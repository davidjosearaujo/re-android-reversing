package com.hunantv.imgo.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.hunantv.imgo.nightmode.view.SkinnableView;
import j.l.a.a0.b;
import j.l.a.b0.q;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class CustomSlideSwitch extends SkinnableView {
    private static final String q = "CustomSlideSwitch";
    private int a;
    private int b;
    public Bitmap c;
    public Bitmap d;
    public Bitmap e;
    public Bitmap f;
    private boolean g;
    private boolean h;
    private float i;
    private float j;
    private Rect k;
    private Rect l;
    private a m;
    private int n;
    public Matrix o;
    public Paint p;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface a {
        void onSwitchChanged(CustomSlideSwitch customSlideSwitch, boolean z);
    }

    public CustomSlideSwitch(Context context) {
        this(context, null);
    }

    private void c() {
        Resources resources = getResources();
        this.c = BitmapFactory.decodeResource(resources, b.g.icon_custom_switch_off);
        this.d = BitmapFactory.decodeResource(resources, b.g.icon_custom_switch_on);
        int i = b.g.icon_custom_switch_thumb;
        this.e = BitmapFactory.decodeResource(resources, i);
        this.f = BitmapFactory.decodeResource(resources, i);
        this.a = this.d.getWidth();
        this.b = this.d.getHeight();
    }

    private void d() {
        this.k = new Rect(0, 0, this.e.getWidth(), this.e.getHeight());
        this.l = new Rect(this.c.getWidth() - this.f.getWidth(), 0, this.c.getWidth(), this.f.getHeight());
    }

    private float getXWhenSlip() {
        Bitmap bitmap = this.g ? this.e : this.f;
        if (this.j >= this.d.getWidth()) {
            return this.d.getWidth() - (bitmap.getWidth() / 2);
        }
        return this.j - (bitmap.getWidth() / 2);
    }

    @Override // com.hunantv.imgo.nightmode.view.SkinnableView, android.view.View
    public void draw(Canvas canvas) {
        if (q.f(this)) {
            q.d(this, canvas);
            super.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas);
    }

    public boolean e() {
        return this.g;
    }

    public void f(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4) {
        this.c = bitmap;
        this.d = bitmap2;
        this.e = bitmap3;
        this.f = bitmap4;
        this.a = Math.max(bitmap2.getWidth(), bitmap3.getWidth());
        this.b = Math.max(bitmap2.getHeight(), bitmap3.getHeight());
        setLayoutParams(getLayoutParams());
        d();
        invalidate();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        int i;
        float f;
        super.onDraw(canvas);
        if (this.g) {
            canvas.drawBitmap(this.d, this.o, this.p);
        } else {
            canvas.drawBitmap(this.c, this.o, this.p);
        }
        if (this.h) {
            f = getXWhenSlip();
        } else {
            if (this.g) {
                i = this.l.left - this.n;
            } else {
                i = this.k.left + this.n;
            }
            f = i;
        }
        Bitmap bitmap = this.g ? this.e : this.f;
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.d.getWidth() - bitmap.getWidth()) {
            f = this.d.getWidth() - bitmap.getWidth();
        }
        canvas.drawBitmap(bitmap, f, (this.d.getHeight() - bitmap.getHeight()) / 2, this.p);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    this.h = false;
                    boolean z = !this.g;
                    this.g = z;
                    a aVar = this.m;
                    if (aVar != null) {
                        aVar.onSwitchChanged(this, z);
                    }
                } else if (action != 2) {
                    if ((action == 3 || action == 4) && this.h) {
                        this.h = false;
                        boolean z2 = !this.g;
                        this.g = z2;
                        a aVar2 = this.m;
                        if (aVar2 != null) {
                            aVar2.onSwitchChanged(this, z2);
                        }
                    }
                } else {
                    this.j = motionEvent.getX();
                }
            } else if (motionEvent.getX() > this.d.getWidth() || motionEvent.getY() > this.d.getHeight()) {
                return false;
            } else {
                this.h = true;
                float x = motionEvent.getX();
                this.i = x;
                this.j = x;
            }
            invalidate();
            return true;
        }
        return false;
    }

    public void setChecked(boolean z) {
        if (this.g == z) {
            return;
        }
        if (z) {
            this.j = this.d.getWidth();
        } else {
            this.j = 0.0f;
        }
        this.g = z;
        a aVar = this.m;
        if (aVar != null) {
            aVar.onSwitchChanged(this, z);
        }
        invalidate();
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = this.a;
        layoutParams.height = this.b;
        super.setLayoutParams(layoutParams);
    }

    public void setOnSwitchChangedListener(a aVar) {
        this.m = aVar;
    }

    public CustomSlideSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomSlideSwitch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 0;
        this.g = true;
        this.h = false;
        this.n = 0;
        this.o = new Matrix();
        this.p = new Paint();
        this.n = getPaddingLeft();
        c();
        d();
    }
}
