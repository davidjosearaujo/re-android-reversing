package com.google.android.material.datepicker;

import android.view.View;

/* loaded from: classes.dex */
public final class l extends p1.a {

    /* renamed from: d */
    public final /* synthetic */ i f3092d;

    public l(i iVar) {
        this.f3092d = iVar;
    }

    @Override // p1.a
    public final void d(View view, q1.f fVar) {
        this.f5466a.onInitializeAccessibilityNodeInfo(view, fVar.f5624a);
        fVar.f5624a.setHintText(this.f3092d.q(this.f3092d.f3085j0.getVisibility() == 0 ? 2131820704 : 2131820702));
    }
}
