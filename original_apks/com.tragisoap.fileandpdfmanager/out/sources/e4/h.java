package e4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f3777a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3778b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ i f3779c;

    public h(i iVar, boolean z6, int i7) {
        this.f3779c = iVar;
        this.f3777a = z6;
        this.f3778b = i7;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f3779c.f3763b.setTranslationX(0.0f);
        this.f3779c.a(0.0f, this.f3778b, this.f3777a);
    }
}
