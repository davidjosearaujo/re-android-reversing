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
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: g  reason: collision with root package name */
    public int f2797g;

    /* renamed from: h  reason: collision with root package name */
    public int f2798h;

    /* renamed from: i  reason: collision with root package name */
    public TimeInterpolator f2799i;

    /* renamed from: j  reason: collision with root package name */
    public TimeInterpolator f2800j;

    /* renamed from: n  reason: collision with root package name */
    public ViewPropertyAnimator f2803n;

    /* renamed from: f  reason: collision with root package name */
    public final LinkedHashSet<b> f2796f = new LinkedHashSet<>();

    /* renamed from: k  reason: collision with root package name */
    public int f2801k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f2802l = 2;
    public int m = 0;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f2803n = null;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface b {
        void a();
    }

    public HideBottomViewOnScrollBehavior() {
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
        boolean z6 = false;
        if (i7 > 0) {
            if (this.f2802l == 1) {
                z6 = true;
            }
            if (!z6) {
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
                w(view, this.f2801k + this.m, (long) this.f2798h, this.f2800j);
            }
        } else if (i7 < 0) {
            if (this.f2802l == 2) {
                z6 = true;
            }
            if (!z6) {
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
                w(view, 0, (long) this.f2797g, this.f2799i);
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean t(CoordinatorLayout coordinatorLayout, V v6, View view, View view2, int i7, int i8) {
        return i7 == 2;
    }

    public final void w(V v6, int i7, long j7, TimeInterpolator timeInterpolator) {
        this.f2803n = v6.animate().translationY((float) i7).setInterpolator(timeInterpolator).setDuration(j7).setListener(new a());
    }
}
