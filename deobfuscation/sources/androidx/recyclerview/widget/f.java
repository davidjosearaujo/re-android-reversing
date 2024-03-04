package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView.a0 f2194a;

    /* renamed from: b */
    public final /* synthetic */ int f2195b;

    /* renamed from: c */
    public final /* synthetic */ View f2196c;

    /* renamed from: d */
    public final /* synthetic */ int f2197d;
    public final /* synthetic */ ViewPropertyAnimator e;

    /* renamed from: f */
    public final /* synthetic */ c f2198f;

    public f(c cVar, RecyclerView.a0 a0Var, int i7, View view, int i8, ViewPropertyAnimator viewPropertyAnimator) {
        this.f2198f = cVar;
        this.f2194a = a0Var;
        this.f2195b = i7;
        this.f2196c = view;
        this.f2197d = i8;
        this.e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        if (this.f2195b != 0) {
            this.f2196c.setTranslationX(0.0f);
        }
        if (this.f2197d != 0) {
            this.f2196c.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.e.setListener(null);
        this.f2198f.g(this.f2194a);
        this.f2198f.f2168p.remove(this.f2194a);
        this.f2198f.p();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f2198f.getClass();
    }
}
