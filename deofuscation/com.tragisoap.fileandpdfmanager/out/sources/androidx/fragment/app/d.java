package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.l;
import androidx.fragment.app.q0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1607a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f1608b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f1609c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ q0.b f1610d;
    public final /* synthetic */ l.a e;

    public d(ViewGroup viewGroup, View view, boolean z6, q0.b bVar, l.a aVar) {
        this.f1607a = viewGroup;
        this.f1608b = view;
        this.f1609c = z6;
        this.f1610d = bVar;
        this.e = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f1607a.endViewTransition(this.f1608b);
        if (this.f1609c) {
            s0.a(this.f1610d.f1748a, this.f1608b);
        }
        this.e.a();
    }
}
