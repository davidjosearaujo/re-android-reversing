package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ CoordinatorLayout f2787a;

    /* renamed from: b */
    public final /* synthetic */ AppBarLayout f2788b;

    /* renamed from: c */
    public final /* synthetic */ AppBarLayout.BaseBehavior f2789c;

    public a(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.f2789c = baseBehavior;
        this.f2787a = coordinatorLayout;
        this.f2788b = appBarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2789c.E(this.f2787a, this.f2788b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
