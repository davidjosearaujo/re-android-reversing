package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e4.j;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: f */
    public final LinkedHashSet<b> f2796f;

    /* renamed from: g */
    public int f2797g;

    /* renamed from: h */
    public int f2798h;

    /* renamed from: i */
    public TimeInterpolator f2799i;

    /* renamed from: j */
    public TimeInterpolator f2800j;

    /* renamed from: k */
    public int f2801k;

    /* renamed from: l */
    public int f2802l;
    public int m;

    /* renamed from: n */
    public ViewPropertyAnimator f2803n;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
            HideBottomViewOnScrollBehavior.this = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f2803n = null;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    public HideBottomViewOnScrollBehavior() {
        this.f2796f = new LinkedHashSet<>();
        this.f2801k = 0;
        this.f2802l = 2;
        this.m = 0;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2796f = new LinkedHashSet<>();
        this.f2801k = 0;
        this.f2802l = 2;
        this.m = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v6, int i7) {
        this.f2801k = v6.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v6.getLayoutParams()).bottomMargin;
        this.f2797g = j.c(v6.getContext(), 2130903868, 225);
        this.f2798h = j.c(v6.getContext(), 2130903874, 175);
        this.f2799i = j.d(v6.getContext(), 2130903884, n3.a.f5164d);
        this.f2800j = j.d(v6.getContext(), 2130903884, n3.a.f5163c);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void p(CoordinatorLayout coordinatorLayout, View view, int i7, int i8, int i9, int[] iArr) {
        if (i7 > 0) {
            if (this.f2802l == 1) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator = this.f2803n;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.f2802l = 1;
            Iterator<b> it = this.f2796f.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            w(view, this.f2801k + this.m, this.f2798h, this.f2800j);
        } else if (i7 < 0) {
            if (this.f2802l == 2) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator2 = this.f2803n;
            if (viewPropertyAnimator2 != null) {
                viewPropertyAnimator2.cancel();
                view.clearAnimation();
            }
            this.f2802l = 2;
            Iterator<b> it2 = this.f2796f.iterator();
            while (it2.hasNext()) {
                it2.next().a();
            }
            w(view, 0, this.f2797g, this.f2799i);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean t(CoordinatorLayout coordinatorLayout, V v6, View view, View view2, int i7, int i8) {
        return i7 == 2;
    }

    public final void w(V v6, int i7, long j5, TimeInterpolator timeInterpolator) {
        this.f2803n = v6.animate().translationY(i7).setInterpolator(timeInterpolator).setDuration(j5).setListener(new a());
    }
}
