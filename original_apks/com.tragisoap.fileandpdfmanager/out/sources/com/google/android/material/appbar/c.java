package com.google.android.material.appbar;

import android.view.View;
import q1.j;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f2794a;

    /* renamed from: b  reason: collision with root package name */
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
