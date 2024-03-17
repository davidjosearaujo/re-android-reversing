package com.hunantv.imgo.nightmode.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import j.l.a.a0.b;
import j.l.a.b0.q;
import j.l.a.b0.v;
import j.l.a.t.a;
import j.l.a.t.h;
import j.l.a.t.k.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinnableImageView extends AppCompatImageView implements h {
    private int dynamicBackgroundId;
    private int dynamicSourceId;
    private boolean enableGray;
    private boolean forceTintColor;
    private boolean hasDynamicBackground;
    private boolean hasDynamicSource;
    private a mAttrsHelper;
    private boolean valueProtect;
    public int widgetIdInSkin;

    public SkinnableImageView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean setBackgroundFromSkin() {
        int e = b.a().e(getContext(), this.widgetIdInSkin);
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
                    z = false;
                } else {
                    this.valueProtect = true;
                    z = setBackgroundFromSkin();
                    this.valueProtect = false;
                }
                if (!z) {
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
            } else {
                if (this.dynamicBackgroundId != -1) {
                    Drawable drawable2 = ContextCompat.getDrawable(getContext(), this.dynamicBackgroundId);
                    if (Build.VERSION.SDK_INT < 16) {
                        setBackgroundDrawable(drawable2);
                    } else {
                        setBackground(drawable2);
                    }
                }
                z = false;
            }
            if (!this.hasDynamicSource) {
                if (!j.l.a.t.k.b.b || this.widgetIdInSkin == -1) {
                    z2 = false;
                } else {
                    this.valueProtect = true;
                    z2 = setSrcFromSkin();
                    this.valueProtect = false;
                }
                if (z2) {
                    return;
                }
                int a2 = this.mAttrsHelper.a(b.r.SkinnableImageView[b.r.SkinnableImageView_android_src]);
                if (a2 > 0) {
                    this.valueProtect = true;
                    setImageDrawable(ContextCompat.getDrawable(getContext(), a2));
                    this.valueProtect = false;
                }
            } else if (this.forceTintColor) {
                if (j.l.a.t.k.b.b && this.widgetIdInSkin != -1) {
                    this.valueProtect = true;
                    z = setSrcFromSkin();
                    this.valueProtect = false;
                }
                if (z || this.dynamicSourceId == -1) {
                    return;
                }
                setImageDrawable(ContextCompat.getDrawable(getContext(), this.dynamicSourceId));
            } else if (this.dynamicSourceId != -1) {
                setImageDrawable(ContextCompat.getDrawable(getContext(), this.dynamicSourceId));
            }
        } catch (Exception unused) {
            v.g("SkinnableImageView", "applyDayNight() Exception");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void applyGrayMode() {
        invalidate();
    }

    public void clearDynamicColor() {
        if (this.hasDynamicSource || this.hasDynamicBackground) {
            this.hasDynamicSource = false;
            this.hasDynamicBackground = false;
            applyDayNight();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dispatchDraw(Canvas canvas) {
        if (this.enableGray && q.f(this)) {
            q.d(this, canvas);
            super/*android.widget.ImageView*/.dispatchDraw(canvas);
            canvas.restore();
            return;
        }
        super/*android.widget.ImageView*/.dispatchDraw(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void draw(Canvas canvas) {
        if (this.enableGray && q.f(this)) {
            q.d(this, canvas);
            super/*android.widget.ImageView*/.draw(canvas);
            canvas.restore();
            return;
        }
        super/*android.widget.ImageView*/.draw(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        try {
            super/*android.widget.ImageView*/.onDraw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundColor(int i) {
        super/*android.widget.ImageView*/.setBackgroundColor(i);
        if (this.valueProtect) {
            return;
        }
        this.hasDynamicBackground = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.enableGray) {
            q.c(this, drawable);
        }
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

    public void setForceTintColor(boolean z) {
        this.forceTintColor = z;
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.valueProtect) {
            return;
        }
        this.dynamicSourceId = -1;
        this.hasDynamicSource = true;
    }

    public void setImageResource(@DrawableRes int i) {
        super.setImageResource(i);
        this.dynamicSourceId = i;
        this.hasDynamicSource = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super/*android.widget.ImageView*/.setOnClickListener(new j.l.a.t.k.a(onClickListener));
    }

    public void setSkinWidgetId(int i) {
        this.widgetIdInSkin = i;
        if (j.l.a.t.k.b.b) {
            this.valueProtect = true;
            if (!this.hasDynamicSource || this.forceTintColor) {
                setSrcFromSkin();
            }
            if (!this.hasDynamicBackground) {
                setBackgroundFromSkin();
            }
            this.valueProtect = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean setSrcFromSkin() {
        int f = j.l.a.t.k.b.a().f(getContext(), this.widgetIdInSkin);
        if (f != 0 && getDrawable() != null) {
            Drawable wrap = DrawableCompat.wrap(getDrawable().mutate());
            DrawableCompat.setTintList(wrap, ColorStateList.valueOf(f));
            setImageDrawable(wrap);
            return true;
        }
        Drawable b = j.l.a.t.k.b.a().b(getContext(), this.widgetIdInSkin);
        if (b == null) {
            return false;
        }
        setImageDrawable(b);
        return true;
    }

    public SkinnableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinnableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.widgetIdInSkin = -1;
        this.valueProtect = false;
        this.hasDynamicSource = false;
        this.dynamicSourceId = -1;
        this.hasDynamicBackground = false;
        this.dynamicBackgroundId = -1;
        this.forceTintColor = false;
        this.mAttrsHelper = new a();
        int[] iArr = b.r.SkinnableView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        this.mAttrsHelper.d(obtainStyledAttributes, iArr);
        this.enableGray = obtainStyledAttributes.getBoolean(b.r.SkinnableView_enableGray, true);
        obtainStyledAttributes.recycle();
        int[] iArr2 = b.r.SkinnableImageView;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        this.mAttrsHelper.d(obtainStyledAttributes2, iArr2);
        obtainStyledAttributes2.recycle();
    }
}
