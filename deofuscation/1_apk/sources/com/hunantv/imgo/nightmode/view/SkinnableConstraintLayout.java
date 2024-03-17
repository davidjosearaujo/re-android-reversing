package com.hunantv.imgo.nightmode.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import j.l.a.a0.b;
import j.l.a.b0.q;
import j.l.a.b0.v;
import j.l.a.t.a;
import j.l.a.t.c;
import j.l.a.t.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinnableConstraintLayout extends ConstraintLayout implements h, c {
    private a a;
    private boolean b;
    private int c;
    private boolean d;
    private int e;
    private boolean f;
    private int g;
    private int h;
    private boolean i;

    public SkinnableConstraintLayout(Context context) {
        this(context, null);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        this.a = new a();
        int[] iArr = b.r.SkinnableView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        this.a.d(obtainStyledAttributes, iArr);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean d() {
        Drawable h;
        int e = j.l.a.t.k.b.a().e(getContext(), this.c);
        if (e != 0 && getBackground() != null) {
            Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
            DrawableCompat.setTint(wrap, e);
            if (Build.VERSION.SDK_INT < 16) {
                setBackgroundDrawable(wrap);
            } else {
                setBackground(wrap);
            }
            return true;
        }
        if (this.f) {
            h = j.l.a.t.k.b.a().c(getContext(), this.c, this.g, this.h);
        } else {
            h = j.l.a.t.k.b.a().h(getContext(), this.c);
        }
        if (h == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 16) {
            setBackgroundDrawable(h);
        } else {
            setBackground(h);
        }
        return true;
    }

    public void a() {
        this.b = false;
        applyDayNight();
    }

    public void addAttributeResource(int i, int i2) {
        this.a.c(i, i2);
    }

    public void againSetBackground(int i) {
        this.i = true;
        setBackgroundResource(i);
        this.i = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void applyDayNight() {
        boolean z;
        Context context = getContext();
        try {
            if (!this.b) {
                if (!j.l.a.t.k.b.b || this.c == -1) {
                    z = false;
                } else {
                    this.d = true;
                    z = d();
                    this.d = false;
                }
                if (z) {
                    return;
                }
                int a = this.a.a(b.r.SkinnableView[b.r.SkinnableView_android_background]);
                if (a != -1) {
                    Drawable drawable = ContextCompat.getDrawable(context, a);
                    this.d = true;
                    if (Build.VERSION.SDK_INT < 16) {
                        setBackgroundDrawable(drawable);
                    } else {
                        setBackground(drawable);
                    }
                    this.d = false;
                }
            } else if (this.e != -1) {
                Drawable drawable2 = ContextCompat.getDrawable(getContext(), this.e);
                if (Build.VERSION.SDK_INT < 16) {
                    setBackgroundDrawable(drawable2);
                } else {
                    setBackground(drawable2);
                }
            }
        } catch (Exception unused) {
            v.g("SkinnableRelativeLayout", "applyDayNight() Exception");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void applyGrayMode() {
        this.i = true;
        setBackground(getBackground());
        this.i = false;
    }

    public void c(boolean z, int i, int i2) {
        if (i != 0 && i2 != 0) {
            this.f = z;
        } else {
            this.f = false;
        }
        this.h = i2;
        this.g = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void draw(Canvas canvas) {
        super/*android.view.ViewGroup*/.draw(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundColor(int i) {
        super/*android.view.ViewGroup*/.setBackgroundColor(i);
        if (this.d || this.i) {
            return;
        }
        this.b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundDrawable(Drawable drawable) {
        q.c(this, drawable);
        super/*android.view.ViewGroup*/.setBackgroundDrawable(drawable);
        if (this.d || this.i) {
            return;
        }
        this.b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundResource(int i) {
        super/*android.view.ViewGroup*/.setBackgroundResource(i);
        if (this.i) {
            return;
        }
        this.e = i;
        this.b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super/*android.view.ViewGroup*/.setOnClickListener(new j.l.a.t.k.a(onClickListener));
    }

    public void setSkinWidgetId(int i) {
        this.c = i;
        if (!j.l.a.t.k.b.b || this.b) {
            return;
        }
        this.d = true;
        d();
        this.d = false;
    }

    public SkinnableConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinnableConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        this.c = -1;
        this.d = false;
        this.e = -1;
        this.f = false;
        this.g = 0;
        this.h = 0;
        this.i = false;
        b(context, attributeSet, i);
    }
}
