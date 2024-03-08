package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import w3.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f3400a;

    public c(d dVar) {
        this.f3400a = dVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        d.C0130d revealInfo = this.f3400a.getRevealInfo();
        revealInfo.f6406c = Float.MAX_VALUE;
        this.f3400a.setRevealInfo(revealInfo);
    }
}
