package o4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f5351a;

    public k(l lVar) {
        this.f5351a = lVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f5351a.q();
        this.f5351a.f5363r.start();
    }
}