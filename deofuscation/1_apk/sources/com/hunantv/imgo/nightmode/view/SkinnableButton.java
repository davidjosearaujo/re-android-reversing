package com.hunantv.imgo.nightmode.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import j.l.a.a0.b;
import j.l.a.b0.q;
import j.l.a.b0.v;
import j.l.a.t.a;
import j.l.a.t.h;
import j.l.a.t.k.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinnableButton extends AppCompatButton implements h {
    private a a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;

    public SkinnableButton(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean c() {
        Drawable h = b.a().h(getContext(), this.b);
        if (h == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 16) {
            setBackgroundDrawable(h);
            return true;
        }
        setBackground(h);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean d() {
        ColorStateList g = b.a().g(getContext(), this.b);
        if (g == null) {
            return false;
        }
        setTextColor(g);
        return true;
    }

    public void a(int i, int i2) {
        this.a.c(i, i2);
    }

    public void addAttributeResource(int i, int i2) {
        this.a.c(i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void applyDayNight() {
        boolean z;
        boolean z2;
        Context context = getContext();
        try {
            if (!this.e) {
                if (!b.b || this.b == -1) {
                    z2 = false;
                } else {
                    this.c = true;
                    z2 = c();
                    this.c = false;
                }
                if (!z2) {
                    int a = this.a.a(b.r.SkinnableView[b.r.SkinnableView_android_background]);
                    if (a > 0) {
                        Drawable drawable = ContextCompat.getDrawable(context, a);
                        this.c = true;
                        if (Build.VERSION.SDK_INT < 16) {
                            setBackgroundDrawable(drawable);
                        } else {
                            setBackground(drawable);
                        }
                        this.c = false;
                    }
                }
            } else if (this.f != -1) {
                Drawable drawable2 = ContextCompat.getDrawable(getContext(), this.f);
                if (Build.VERSION.SDK_INT < 16) {
                    setBackgroundDrawable(drawable2);
                } else {
                    setBackground(drawable2);
                }
            }
            if (this.d) {
                return;
            }
            if (!j.l.a.t.k.b.b || this.b == -1) {
                z = false;
            } else {
                this.c = true;
                z = d();
                this.c = false;
            }
            if (z) {
                return;
            }
            int a2 = this.a.a(b.r.SkinnableTextView[b.r.SkinnableTextView_android_textColor]);
            if (a2 > 0) {
                ColorStateList colorStateList = ContextCompat.getColorStateList(context, a2);
                this.c = true;
                setTextColor(colorStateList);
                this.c = false;
            }
        } catch (Exception unused) {
            v.g("SkinnableButton", "applyDayNight() Exception");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void applyGrayMode() {
        invalidate();
    }

    public void b() {
        if (this.e || this.d) {
            this.d = false;
            this.e = false;
            applyDayNight();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void draw(Canvas canvas) {
        if (q.f(this)) {
            q.d(this, canvas);
            super/*android.widget.Button*/.draw(canvas);
            canvas.restore();
            return;
        }
        super/*android.widget.Button*/.draw(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundColor(int i) {
        super/*android.widget.Button*/.setBackgroundColor(i);
        if (this.c) {
            return;
        }
        this.e = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundDrawable(Drawable drawable) {
        q.c(this, drawable);
        super.setBackgroundDrawable(drawable);
        if (this.c) {
            return;
        }
        this.e = true;
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        this.f = i;
        this.e = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super/*android.widget.Button*/.setOnClickListener(new j.l.a.t.k.a(onClickListener));
    }

    public void setSkinWidgetId(int i) {
        this.b = i;
        if (j.l.a.t.k.b.b) {
            this.c = true;
            if (!this.d) {
                d();
            }
            if (!this.e) {
                c();
            }
            this.c = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextColor(int i) {
        super/*android.widget.Button*/.setTextColor(i);
        if (this.c) {
            return;
        }
        this.d = true;
    }

    public SkinnableButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.c.buttonStyle);
    }

    public SkinnableButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -1;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = -1;
        this.a = new a();
        int[] iArr = b.r.SkinnableView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        this.a.d(obtainStyledAttributes, iArr);
        obtainStyledAttributes.recycle();
        int[] iArr2 = b.r.SkinnableButton;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        this.a.d(obtainStyledAttributes2, iArr2);
        obtainStyledAttributes2.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextColor(ColorStateList colorStateList) {
        super/*android.widget.Button*/.setTextColor(colorStateList);
        if (this.c) {
            return;
        }
        this.d = true;
    }
}
