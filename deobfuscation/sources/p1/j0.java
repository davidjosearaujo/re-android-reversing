package p1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* loaded from: classes.dex */
public final class j0 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ l0 f5493a;

    /* renamed from: b */
    public final /* synthetic */ View f5494b;

    public j0(l0 l0Var, View view) {
        this.f5493a = l0Var;
        this.f5494b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f5493a.b(this.f5494b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f5493a.a();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f5493a.c();
    }
}
