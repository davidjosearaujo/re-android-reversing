package o4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ f f5339a;

    public d(f fVar) {
        this.f5339a = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f5339a.f5365b.h(true);
    }
}
