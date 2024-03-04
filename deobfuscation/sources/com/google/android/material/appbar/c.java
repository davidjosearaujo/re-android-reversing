package com.google.android.material.appbar;

import android.view.View;
import q1.j;

/* loaded from: classes.dex */
public final class c implements j {

    /* renamed from: a */
    public final /* synthetic */ AppBarLayout f2794a;

    /* renamed from: b */
    public final /* synthetic */ boolean f2795b;

    public c(AppBarLayout appBarLayout, boolean z6) {
        this.f2794a = appBarLayout;
        this.f2795b = z6;
    }

    @Override // q1.j
    public final boolean a(View view) {
        this.f2794a.setExpanded(this.f2795b);
        return true;
    }
}
