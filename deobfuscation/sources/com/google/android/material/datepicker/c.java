package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    public final b f3054a;

    /* renamed from: b */
    public final b f3055b;

    /* renamed from: c */
    public final b f3056c;

    /* renamed from: d */
    public final b f3057d;
    public final b e;

    /* renamed from: f */
    public final b f3058f;

    /* renamed from: g */
    public final b f3059g;

    /* renamed from: h */
    public final Paint f3060h;

    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(g4.b.c(2130903810, context, i.class.getCanonicalName()).data, l0.z.m);
        this.f3054a = b.a(context, obtainStyledAttributes.getResourceId(4, 0));
        this.f3059g = b.a(context, obtainStyledAttributes.getResourceId(2, 0));
        this.f3055b = b.a(context, obtainStyledAttributes.getResourceId(3, 0));
        this.f3056c = b.a(context, obtainStyledAttributes.getResourceId(5, 0));
        ColorStateList a7 = g4.c.a(context, obtainStyledAttributes, 7);
        this.f3057d = b.a(context, obtainStyledAttributes.getResourceId(9, 0));
        this.e = b.a(context, obtainStyledAttributes.getResourceId(8, 0));
        this.f3058f = b.a(context, obtainStyledAttributes.getResourceId(10, 0));
        Paint paint = new Paint();
        this.f3060h = paint;
        paint.setColor(a7.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
