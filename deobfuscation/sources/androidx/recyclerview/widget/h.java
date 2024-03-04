package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.c;

/* loaded from: classes.dex */
public final class h extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ c.d f2203a;

    /* renamed from: b */
    public final /* synthetic */ ViewPropertyAnimator f2204b;

    /* renamed from: c */
    public final /* synthetic */ View f2205c;

    /* renamed from: d */
    public final /* synthetic */ c f2206d;

    public h(c cVar, c.d dVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f2206d = cVar;
        this.f2203a = dVar;
        this.f2204b = viewPropertyAnimator;
        this.f2205c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f2204b.setListener(null);
        this.f2205c.setAlpha(1.0f);
        this.f2205c.setTranslationX(0.0f);
        this.f2205c.setTranslationY(0.0f);
        this.f2206d.g(this.f2203a.f2178b);
        this.f2206d.f2170r.remove(this.f2203a.f2178b);
        this.f2206d.p();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        c cVar = this.f2206d;
        RecyclerView.a0 a0Var = this.f2203a.f2178b;
        cVar.getClass();
    }
}
