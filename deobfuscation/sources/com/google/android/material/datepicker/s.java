package com.google.android.material.datepicker;

import android.view.View;
import p1.p0;

/* loaded from: classes.dex */
public final class s implements p1.p {

    /* renamed from: a */
    public final /* synthetic */ int f3118a;

    /* renamed from: b */
    public final /* synthetic */ View f3119b;

    /* renamed from: c */
    public final /* synthetic */ int f3120c;

    public s(int i7, View view, int i8) {
        this.f3118a = i7;
        this.f3119b = view;
        this.f3120c = i8;
    }

    @Override // p1.p
    public final p0 a(View view, p0 p0Var) {
        int i7 = p0Var.a(7).f4463b;
        if (this.f3118a >= 0) {
            this.f3119b.getLayoutParams().height = this.f3118a + i7;
            View view2 = this.f3119b;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        View view3 = this.f3119b;
        view3.setPadding(view3.getPaddingLeft(), this.f3120c + i7, this.f3119b.getPaddingRight(), this.f3119b.getPaddingBottom());
        return p0Var;
    }
}
