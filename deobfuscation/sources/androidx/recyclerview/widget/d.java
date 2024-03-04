package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView.a0 f2186a;

    /* renamed from: b */
    public final /* synthetic */ ViewPropertyAnimator f2187b;

    /* renamed from: c */
    public final /* synthetic */ View f2188c;

    /* renamed from: d */
    public final /* synthetic */ c f2189d;

    public d(View view, ViewPropertyAnimator viewPropertyAnimator, c cVar, RecyclerView.a0 a0Var) {
        this.f2189d = cVar;
        this.f2186a = a0Var;
        this.f2187b = viewPropertyAnimator;
        this.f2188c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f2187b.setListener(null);
        this.f2188c.setAlpha(1.0f);
        this.f2189d.g(this.f2186a);
        this.f2189d.f2169q.remove(this.f2186a);
        this.f2189d.p();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f2189d.getClass();
    }
}
