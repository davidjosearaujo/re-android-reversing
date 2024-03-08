package o4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f5340a;

    public e(f fVar) {
        this.f5340a = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f5340a.f5365b.h(false);
    }
}
