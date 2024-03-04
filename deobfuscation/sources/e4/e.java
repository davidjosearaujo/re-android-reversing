package e4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ f f3774a;

    public e(f fVar) {
        this.f3774a = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f3774a.f3763b.setTranslationY(0.0f);
        this.f3774a.b(0.0f);
    }
}
