package com.hunantv.imgo.nightmode.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import j.l.a.a0.b;
import j.l.a.b0.q;
import j.l.a.b0.v;
import j.l.a.t.a;
import j.l.a.t.h;
import j.l.a.t.k.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinnableTextView extends AppCompatTextView implements h {
    private int dynamicBackgroundId;
    private boolean hasDynamicBackground;
    private boolean hasDynamicTextColor;
    private a mAttrsHelper;
    private boolean valueProtect;
    private int widgetIdInSkin;

    public SkinnableTextView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean setBackgroundForSkin() {
        Drawable wrap;
        int e = b.a().e(getContext(), this.widgetIdInSkin);
        if (e != 0) {
            Drawable background = getBackground();
            if (background != null) {
                if (background instanceof GradientDrawable) {
                    wrap = background.mutate();
                    ((GradientDrawable) wrap).setColor(e);
                } else if (background instanceof ColorDrawable) {
                    wrap = background.mutate();
                    ((ColorDrawable) wrap).setColor(e);
                } else {
                    wrap = DrawableCompat.wrap(background.mutate());
                    DrawableCompat.setTint(wrap, e);
                }
                if (Build.VERSION.SDK_INT < 16) {
                    setBackgroundDrawable(wrap);
                } else {
                    setBackground(wrap);
                }
            } else {
                ColorDrawable colorDrawable = new ColorDrawable(e);
                if (Build.VERSION.SDK_INT < 16) {
                    setBackgroundDrawable(colorDrawable);
                } else {
                    setBackground(colorDrawable);
                }
            }
            return true;
        }
        Drawable h = b.a().h(getContext(), this.widgetIdInSkin);
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

    public void addAttributeResource(int i, int i2) {
        this.mAttrsHelper.c(i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void applyDayNight() {
        boolean z;
        boolean z2;
        Context context = getContext();
        try {
            if (!this.hasDynamicBackground) {
                if (!b.b || this.widgetIdInSkin == -1) {
                    z2 = false;
                } else {
                    this.valueProtect = true;
                    z2 = setBackgroundForSkin();
                    this.valueProtect = false;
                }
                if (!z2) {
                    int a = this.mAttrsHelper.a(b.r.SkinnableView[b.r.SkinnableView_android_background]);
                    if (a > 0) {
                        Drawable drawable = ContextCompat.getDrawable(context, a);
                        this.valueProtect = true;
                        if (Build.VERSION.SDK_INT < 16) {
                            setBackgroundDrawable(drawable);
                        } else {
                            setBackground(drawable);
                        }
                        this.valueProtect = false;
                    }
                }
            } else if (this.dynamicBackgroundId != -1) {
                Drawable drawable2 = ContextCompat.getDrawable(getContext(), this.dynamicBackgroundId);
                if (Build.VERSION.SDK_INT < 16) {
                    setBackgroundDrawable(drawable2);
                } else {
                    setBackground(drawable2);
                }
            }
            if (this.hasDynamicTextColor) {
                return;
            }
            if (!j.l.a.t.k.b.b || this.widgetIdInSkin == -1) {
                z = false;
            } else {
                this.valueProtect = true;
                z = setTextColorFromSkin();
                this.valueProtect = false;
            }
            if (z) {
                return;
            }
            int a2 = this.mAttrsHelper.a(b.r.SkinnableTextView[b.r.SkinnableTextView_android_textColor]);
            if (a2 > 0) {
                ColorStateList colorStateList = ContextCompat.getColorStateList(context, a2);
                this.valueProtect = true;
                setTextColor(colorStateList);
                this.valueProtect = false;
            }
        } catch (Exception unused) {
            v.g("SkinnableTextView", "applyDayNight() Exception");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void applyGrayMode() {
        try {
            if (getBackground() != null) {
                setBackgroundDrawable(getBackground());
            }
            invalidate();
        } catch (Exception e) {
            v.g("SkinnableTextView", "applyGrayMode() Exception = " + e.toString());
        }
    }

    public void clearDynamicColor() {
        if (this.hasDynamicTextColor || this.hasDynamicBackground) {
            this.hasDynamicTextColor = false;
            this.hasDynamicBackground = false;
            applyDayNight();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void draw(Canvas canvas) {
        if (q.f(this)) {
            q.d(this, canvas);
            super/*android.widget.TextView*/.draw(canvas);
            canvas.restore();
            return;
        }
        super/*android.widget.TextView*/.draw(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundColor(int i) {
        super/*android.widget.TextView*/.setBackgroundColor(i);
        if (this.valueProtect) {
            return;
        }
        this.hasDynamicBackground = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundDrawable(Drawable drawable) {
        q.c(this, drawable);
        super.setBackgroundDrawable(drawable);
        if (this.valueProtect) {
            return;
        }
        this.hasDynamicBackground = true;
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        this.dynamicBackgroundId = i;
        this.hasDynamicBackground = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super/*android.widget.TextView*/.setOnClickListener(new j.l.a.t.k.a(onClickListener));
    }

    public void setSkinWidgetId(int i) {
        this.widgetIdInSkin = i;
        if (j.l.a.t.k.b.b) {
            this.valueProtect = true;
            if (!this.hasDynamicTextColor) {
                setTextColorFromSkin();
            }
            if (!this.hasDynamicBackground) {
                setBackgroundForSkin();
            }
            this.valueProtect = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextColor(int i) {
        super/*android.widget.TextView*/.setTextColor(i);
        if (this.valueProtect) {
            return;
        }
        this.hasDynamicTextColor = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean setTextColorFromSkin() {
        ColorStateList g = j.l.a.t.k.b.a().g(getContext(), this.widgetIdInSkin);
        if (g == null) {
            return false;
        }
        setTextColor(g);
        return true;
    }

    public void setTypeface(@Nullable Typeface typeface, int i) {
        try {
            super.setTypeface(typeface, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SkinnableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public SkinnableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.widgetIdInSkin = -1;
        this.valueProtect = false;
        this.hasDynamicTextColor = false;
        this.hasDynamicBackground = false;
        this.dynamicBackgroundId = -1;
        this.mAttrsHelper = new a();
        int[] iArr = b.r.SkinnableView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        this.mAttrsHelper.d(obtainStyledAttributes, iArr);
        obtainStyledAttributes.recycle();
        int[] iArr2 = b.r.SkinnableTextView;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        this.mAttrsHelper.d(obtainStyledAttributes2, iArr2);
        obtainStyledAttributes2.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTypeface(@Nullable Typeface typeface) {
        try {
            super/*android.widget.TextView*/.setTypeface(typeface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextColor(ColorStateList colorStateList) {
        super/*android.widget.TextView*/.setTextColor(colorStateList);
        if (this.valueProtect) {
            return;
        }
        this.hasDynamicTextColor = true;
    }
}
