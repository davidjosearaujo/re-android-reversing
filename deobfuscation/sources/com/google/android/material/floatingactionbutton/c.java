package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.d;

/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ boolean f3165a;

    /* renamed from: b */
    public final /* synthetic */ d.g f3166b;

    /* renamed from: c */
    public final /* synthetic */ d f3167c;

    public c(d dVar, boolean z6, a aVar) {
        this.f3167c = dVar;
        this.f3165a = z6;
        this.f3166b = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        d dVar = this.f3167c;
        dVar.m = 0;
        dVar.f3176g = null;
        d.g gVar = this.f3166b;
        if (gVar != null) {
            ((a) gVar).f3159a.b();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f3167c.f3185q.b(0, this.f3165a);
        d dVar = this.f3167c;
        dVar.m = 2;
        dVar.f3176g = animator;
    }
}
