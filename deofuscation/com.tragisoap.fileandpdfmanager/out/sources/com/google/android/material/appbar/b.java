package com.google.android.material.appbar;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import q1.j;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f2790a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f2791b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f2792c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f2793d;
    public final /* synthetic */ AppBarLayout.BaseBehavior e;

    public b(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i7) {
        this.e = baseBehavior;
        this.f2790a = coordinatorLayout;
        this.f2791b = appBarLayout;
        this.f2792c = view;
        this.f2793d = i7;
    }

    @Override // q1.j
    public final boolean a(View view) {
        this.e.H(this.f2790a, this.f2791b, this.f2792c, this.f2793d, new int[]{0, 0});
        return true;
    }
}
