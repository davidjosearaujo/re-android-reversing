package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.c;

/* loaded from: classes.dex */
public final class g extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ c.d f2199a;

    /* renamed from: b */
    public final /* synthetic */ ViewPropertyAnimator f2200b;

    /* renamed from: c */
    public final /* synthetic */ View f2201c;

    /* renamed from: d */
    public final /* synthetic */ c f2202d;

    public g(c cVar, c.d dVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f2202d = cVar;
        this.f2199a = dVar;
        this.f2200b = viewPropertyAnimator;
        this.f2201c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f2200b.setListener(null);
        this.f2201c.setAlpha(1.0f);
        this.f2201c.setTranslationX(0.0f);
        this.f2201c.setTranslationY(0.0f);
        this.f2202d.g(this.f2199a.f2177a);
        this.f2202d.f2170r.remove(this.f2199a.f2177a);
        this.f2202d.p();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        c cVar = this.f2202d;
        RecyclerView.a0 a0Var = this.f2199a.f2177a;
        cVar.getClass();
    }
}
