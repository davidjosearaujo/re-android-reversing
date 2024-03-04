package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.d;

/* loaded from: classes.dex */
public final class b extends AnimatorListenerAdapter {

    /* renamed from: a */
    public boolean f3161a;

    /* renamed from: b */
    public final /* synthetic */ boolean f3162b;

    /* renamed from: c */
    public final /* synthetic */ d.g f3163c;

    /* renamed from: d */
    public final /* synthetic */ d f3164d;

    public b(d dVar, boolean z6, a aVar) {
        this.f3164d = dVar;
        this.f3162b = z6;
        this.f3163c = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f3161a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        d dVar = this.f3164d;
        dVar.m = 0;
        dVar.f3176g = null;
        if (this.f3161a) {
            return;
        }
        FloatingActionButton floatingActionButton = dVar.f3185q;
        boolean z6 = this.f3162b;
        floatingActionButton.b(z6 ? 8 : 4, z6);
        d.g gVar = this.f3163c;
        if (gVar != null) {
            a aVar = (a) gVar;
            aVar.f3159a.a(aVar.f3160b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f3164d.f3185q.b(0, this.f3162b);
        d dVar = this.f3164d;
        dVar.m = 1;
        dVar.f3176g = animator;
        this.f3161a = false;
    }
}
