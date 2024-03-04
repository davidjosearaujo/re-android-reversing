package k2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
public final class i extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ o.b f4654a;

    /* renamed from: b */
    public final /* synthetic */ h f4655b;

    public i(h hVar, o.b bVar) {
        this.f4655b = hVar;
        this.f4654a = bVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f4654a.remove(animator);
        this.f4655b.f4643r.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f4655b.f4643r.add(animator);
    }
}
