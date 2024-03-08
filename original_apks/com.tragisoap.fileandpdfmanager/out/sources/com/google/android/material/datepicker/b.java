package com.google.android.material.datepicker;

import a0.e;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.widget.TextView;
import g4.c;
import java.util.WeakHashMap;
import k4.a;
import k4.f;
import k4.i;
import l0.z;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f3049a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f3050b;

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f3051c;

    /* renamed from: d  reason: collision with root package name */
    public final ColorStateList f3052d;
    public final int e;

    /* renamed from: f  reason: collision with root package name */
    public final i f3053f;

    public b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i7, i iVar, Rect rect) {
        e.h(rect.left);
        e.h(rect.top);
        e.h(rect.right);
        e.h(rect.bottom);
        this.f3049a = rect;
        this.f3050b = colorStateList2;
        this.f3051c = colorStateList;
        this.f3052d = colorStateList3;
        this.e = i7;
        this.f3053f = iVar;
    }

    public static b a(Context context, int i7) {
        e.g("Cannot create a CalendarItemStyle with a styleResId of 0", i7 != 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i7, z.f4927n);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(0, 0), obtainStyledAttributes.getDimensionPixelOffset(2, 0), obtainStyledAttributes.getDimensionPixelOffset(1, 0), obtainStyledAttributes.getDimensionPixelOffset(3, 0));
        ColorStateList a7 = c.a(context, obtainStyledAttributes, 4);
        ColorStateList a8 = c.a(context, obtainStyledAttributes, 9);
        ColorStateList a9 = c.a(context, obtainStyledAttributes, 7);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        i iVar = new i(i.a(context, obtainStyledAttributes.getResourceId(5, 0), obtainStyledAttributes.getResourceId(6, 0), new a((float) 0)));
        obtainStyledAttributes.recycle();
        return new b(a7, a8, a9, dimensionPixelSize, iVar, rect);
    }

    public final void b(TextView textView) {
        f fVar = new f();
        f fVar2 = new f();
        fVar.setShapeAppearanceModel(this.f3053f);
        fVar2.setShapeAppearanceModel(this.f3053f);
        fVar.k(this.f3051c);
        ColorStateList colorStateList = this.f3052d;
        fVar.f4720f.f4749k = (float) this.e;
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
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.d.q(textView, insetDrawable);
    }
}
