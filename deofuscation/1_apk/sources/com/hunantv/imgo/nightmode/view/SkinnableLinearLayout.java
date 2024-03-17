package com.hunantv.imgo.nightmode.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import j.l.a.a0.b;
import j.l.a.b0.q;
import j.l.a.b0.v;
import j.l.a.t.a;
import j.l.a.t.c;
import j.l.a.t.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinnableLinearLayout extends LinearLayout implements h, c {
    private int dynamicBackgroundId;
    private boolean hasDynamicBackground;
    private boolean isAgainSetBackground;
    private a mAttrsHelper;
    private boolean mAutoCrop;
    private int mCropHeight;
    private int mCropWidth;
    private boolean valueProtect;
    private int widgetIdInSkin;

    public SkinnableLinearLayout(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.mAttrsHelper = new a();
        int[] iArr = b.r.SkinnableView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        this.mAttrsHelper.d(obtainStyledAttributes, iArr);
        obtainStyledAttributes.recycle();
    }

    private boolean setStyleFromSkin() {
        Drawable h;
        int e = j.l.a.t.k.b.a().e(getContext(), this.widgetIdInSkin);
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
        if (this.mAutoCrop) {
            h = j.l.a.t.k.b.a().c(getContext(), this.widgetIdInSkin, this.mCropWidth, this.mCropHeight);
        } else {
            h = j.l.a.t.k.b.a().h(getContext(), this.widgetIdInSkin);
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

    public void addAttributeResource(int i, int i2) {
        this.mAttrsHelper.c(i, i2);
    }

    public void againSetBackground(int i) {
        this.isAgainSetBackground = true;
        setBackgroundResource(i);
        this.isAgainSetBackground = false;
    }

    public void applyDayNight() {
        boolean z;
        Context context = getContext();
        try {
            if (!this.hasDynamicBackground) {
                if (!j.l.a.t.k.b.b || this.widgetIdInSkin == -1) {
                    z = false;
                } else {
                    this.valueProtect = true;
                    z = setStyleFromSkin();
                    this.valueProtect = false;
                }
                if (z) {
                    return;
                }
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
            } else if (this.dynamicBackgroundId != -1) {
                Drawable drawable2 = ContextCompat.getDrawable(getContext(), this.dynamicBackgroundId);
                if (Build.VERSION.SDK_INT < 16) {
                    setBackgroundDrawable(drawable2);
                } else {
                    setBackground(drawable2);
                }
            }
        } catch (Exception unused) {
            v.g("SkinnableLinearLayout", "applyDayNight() Exception");
        }
    }

    public void applyGrayMode() {
        this.isAgainSetBackground = true;
        setBackground(getBackground());
        this.isAgainSetBackground = false;
    }

    public void clearDynamicStyle() {
        if (this.hasDynamicBackground) {
            this.hasDynamicBackground = false;
            applyDayNight();
        }
    }

    public void setAutoCrop(boolean z, int i, int i2) {
        if (i != 0 && i2 != 0) {
            this.mAutoCrop = z;
        } else {
            this.mAutoCrop = false;
        }
        this.mCropHeight = i2;
        this.mCropWidth = i;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (this.valueProtect || this.isAgainSetBackground) {
            return;
        }
        this.hasDynamicBackground = true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        q.c(this, drawable);
        super.setBackgroundDrawable(drawable);
        if (this.valueProtect || this.isAgainSetBackground) {
            return;
        }
        this.hasDynamicBackground = true;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.isAgainSetBackground) {
            return;
        }
        this.dynamicBackgroundId = i;
        this.hasDynamicBackground = true;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(new j.l.a.t.k.a(onClickListener));
    }

    public void setSkinWidgetId(int i) {
        this.widgetIdInSkin = i;
        if (!j.l.a.t.k.b.b || this.hasDynamicBackground) {
            return;
        }
        this.valueProtect = true;
        setStyleFromSkin();
        this.valueProtect = false;
    }

    public SkinnableLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinnableLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hasDynamicBackground = false;
        this.widgetIdInSkin = -1;
        this.valueProtect = false;
        this.dynamicBackgroundId = -1;
        this.mAutoCrop = false;
        this.mCropWidth = 0;
        this.mCropHeight = 0;
        this.isAgainSetBackground = false;
        init(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public SkinnableLinearLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.hasDynamicBackground = false;
        this.widgetIdInSkin = -1;
        this.valueProtect = false;
        this.dynamicBackgroundId = -1;
        this.mAutoCrop = false;
        this.mCropWidth = 0;
        this.mCropHeight = 0;
        this.isAgainSetBackground = false;
        init(context, attributeSet, i);
    }
}
