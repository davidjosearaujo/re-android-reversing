package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView.a0 f2190a;

    /* renamed from: b */
    public final /* synthetic */ View f2191b;

    /* renamed from: c */
    public final /* synthetic */ ViewPropertyAnimator f2192c;

    /* renamed from: d */
    public final /* synthetic */ c f2193d;

    public e(View view, ViewPropertyAnimator viewPropertyAnimator, c cVar, RecyclerView.a0 a0Var) {
        this.f2193d = cVar;
        this.f2190a = a0Var;
        this.f2191b = view;
        this.f2192c = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f2191b.setAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f2192c.setListener(null);
        this.f2193d.g(this.f2190a);
        this.f2193d.f2167o.remove(this.f2190a);
        this.f2193d.p();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f2193d.getClass();
    }
}
