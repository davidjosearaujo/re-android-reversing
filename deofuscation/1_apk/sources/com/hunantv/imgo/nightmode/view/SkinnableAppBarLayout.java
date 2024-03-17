package com.hunantv.imgo.nightmode.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.google.android.material.appbar.AppBarLayout;
import j.l.a.a0.b;
import j.l.a.b0.q;
import j.l.a.b0.v;
import j.l.a.t.a;
import j.l.a.t.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinnableAppBarLayout extends AppBarLayout implements h {
    private a a;

    public SkinnableAppBarLayout(Context context) {
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
        } catch (Exception unused) {
            v.g("SkinnableAppBarLayout", "applyDayNight() Exception");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void applyGrayMode() {
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundColor(int i) {
        super/*android.widget.LinearLayout*/.setBackgroundColor(i);
        this.a.b(b.r.SkinnableView[b.r.SkinnableView_android_background]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundDrawable(Drawable drawable) {
        q.c(this, drawable);
        super/*android.widget.LinearLayout*/.setBackgroundDrawable(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundResource(int i) {
        super/*android.widget.LinearLayout*/.setBackgroundResource(i);
        if (i > 0) {
            this.a.c(b.r.SkinnableView[b.r.SkinnableView_android_background], i);
        } else {
            this.a.b(b.r.SkinnableView[b.r.SkinnableView_android_background]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super/*android.widget.LinearLayout*/.setOnClickListener(new j.l.a.t.k.a(onClickListener));
    }

    public SkinnableAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new a();
        int[] iArr = b.r.SkinnableView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        this.a.d(obtainStyledAttributes, iArr);
        obtainStyledAttributes.recycle();
    }
}
