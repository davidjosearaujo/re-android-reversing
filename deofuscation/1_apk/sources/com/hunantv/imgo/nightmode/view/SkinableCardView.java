package com.hunantv.imgo.nightmode.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import j.l.a.a0.b;
import j.l.a.b0.q;
import j.l.a.b0.v;
import j.l.a.t.a;
import j.l.a.t.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinableCardView extends CardView implements h {
    private a a;

    public SkinableCardView(Context context) {
        this(context, null);
    }

    public void addAttributeResource(int i, int i2) {
        this.a.c(i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void applyDayNight() {
        Context context = getContext();
        try {
            int a = this.a.a(b.r.CardView[b.r.CardView_cardBackgroundColor]);
            if (a > 0) {
                setCardBackgroundColor(ContextCompat.getColorStateList(context, a));
            }
        } catch (Exception unused) {
            v.g("SkinableCardView", "applyDayNight() Exception");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void applyGrayMode() {
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundDrawable(Drawable drawable) {
        q.c(this, drawable);
        super/*android.widget.FrameLayout*/.setBackgroundDrawable(drawable);
    }

    public void setCardBackgroundColor(int i) {
        super.setCardBackgroundColor(i);
        this.a.b(b.r.CardView[b.r.CardView_cardBackgroundColor]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super/*android.widget.FrameLayout*/.setOnClickListener(new j.l.a.t.k.a(onClickListener));
    }

    public SkinableCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinableCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new a();
        int[] iArr = b.r.CardView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        this.a.d(obtainStyledAttributes, iArr);
        obtainStyledAttributes.recycle();
    }
}
