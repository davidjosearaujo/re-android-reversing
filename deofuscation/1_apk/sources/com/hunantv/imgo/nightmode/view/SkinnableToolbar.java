package com.hunantv.imgo.nightmode.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import j.l.a.a0.b;
import j.l.a.b0.q;
import j.l.a.b0.v;
import j.l.a.t.a;
import j.l.a.t.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinnableToolbar extends Toolbar implements h {
    private a a;

    public SkinnableToolbar(Context context) {
        this(context, null);
    }

    public void addAttributeResource(int i, int i2) {
        this.a.c(i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void applyDayNight() {
        Context context = getContext();
        try {
            int a = this.a.a(b.r.SkinnableView[b.r.SkinnableView_android_background]);
            if (a > 0) {
                Drawable drawable = ContextCompat.getDrawable(context, a);
                if (Build.VERSION.SDK_INT < 16) {
                    setBackgroundDrawable(drawable);
                } else {
                    setBackground(drawable);
                }
            }
            int[] iArr = b.r.Toolbar;
            int a2 = this.a.a(iArr[b.r.Toolbar_titleTextAppearance]);
            if (a2 > 0) {
                setTitleTextAppearance(context, a2);
            }
            int a3 = this.a.a(iArr[b.r.Toolbar_subtitleTextAppearance]);
            if (a2 > 0) {
                setSubtitleTextAppearance(context, a3);
            }
        } catch (Exception unused) {
            v.g("SkinnableToolbar", "applyDayNight() Exception");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void applyGrayMode() {
        setBackground(getBackground());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundColor(int i) {
        super/*android.view.ViewGroup*/.setBackgroundColor(i);
        this.a.b(b.r.SkinnableView[b.r.SkinnableView_android_background]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundDrawable(Drawable drawable) {
        q.c(this, drawable);
        super/*android.view.ViewGroup*/.setBackgroundDrawable(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundResource(int i) {
        super/*android.view.ViewGroup*/.setBackgroundResource(i);
        if (i > 0) {
            this.a.c(b.r.SkinnableView[b.r.SkinnableView_android_background], i);
        } else {
            this.a.b(b.r.SkinnableView[b.r.SkinnableView_android_background]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super/*android.view.ViewGroup*/.setOnClickListener(new j.l.a.t.k.a(onClickListener));
    }

    public SkinnableToolbar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, b.c.toolbarStyle);
    }

    public SkinnableToolbar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new a();
        int[] iArr = b.r.SkinnableView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        this.a.d(obtainStyledAttributes, iArr);
        obtainStyledAttributes.recycle();
        int[] iArr2 = b.r.Toolbar;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        this.a.d(obtainStyledAttributes2, iArr2);
        obtainStyledAttributes2.recycle();
    }
}
