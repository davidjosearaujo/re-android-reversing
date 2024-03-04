package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.widget.TextView;
import java.util.WeakHashMap;
import k4.f;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public final Rect f3049a;

    /* renamed from: b */
    public final ColorStateList f3050b;

    /* renamed from: c */
    public final ColorStateList f3051c;

    /* renamed from: d */
    public final ColorStateList f3052d;
    public final int e;

    /* renamed from: f */
    public final k4.i f3053f;

    public b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i7, k4.i iVar, Rect rect) {
        a0.e.h(rect.left);
        a0.e.h(rect.top);
        a0.e.h(rect.right);
        a0.e.h(rect.bottom);
        this.f3049a = rect;
        this.f3050b = colorStateList2;
        this.f3051c = colorStateList;
        this.f3052d = colorStateList3;
        this.e = i7;
        this.f3053f = iVar;
    }

    public static b a(Context context, int i7) {
        a0.e.g("Cannot create a CalendarItemStyle with a styleResId of 0", i7 != 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i7, l0.z.f4927n);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(0, 0), obtainStyledAttributes.getDimensionPixelOffset(2, 0), obtainStyledAttributes.getDimensionPixelOffset(1, 0), obtainStyledAttributes.getDimensionPixelOffset(3, 0));
        ColorStateList a7 = g4.c.a(context, obtainStyledAttributes, 4);
        ColorStateList a8 = g4.c.a(context, obtainStyledAttributes, 9);
        ColorStateList a9 = g4.c.a(context, obtainStyledAttributes, 7);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        k4.i iVar = new k4.i(k4.i.a(context, obtainStyledAttributes.getResourceId(5, 0), obtainStyledAttributes.getResourceId(6, 0), new k4.a(0)));
        obtainStyledAttributes.recycle();
        return new b(a7, a8, a9, dimensionPixelSize, iVar, rect);
    }

    public final void b(TextView textView) {
        k4.f fVar = new k4.f();
        k4.f fVar2 = new k4.f();
        fVar.setShapeAppearanceModel(this.f3053f);
        fVar2.setShapeAppearanceModel(this.f3053f);
        fVar.k(this.f3051c);
        ColorStateList colorStateList = this.f3052d;
        fVar.f4720f.f4749k = this.e;
        fVar.invalidateSelf();
        f.b bVar = fVar.f4720f;
        if (bVar.f4743d != colorStateList) {
            bVar.f4743d = colorStateList;
            fVar.onStateChange(fVar.getState());
        }
        textView.setTextColor(this.f3050b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f3050b.withAlpha(30), fVar, fVar2);
        Rect rect = this.f3049a;
        InsetDrawable insetDrawable = new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
        WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
        y.d.q(textView, insetDrawable);
    }
}
