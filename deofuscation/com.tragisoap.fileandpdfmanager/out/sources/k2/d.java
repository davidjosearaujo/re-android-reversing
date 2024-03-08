package k2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import java.util.HashMap;
import java.util.WeakHashMap;
import k2.o;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d extends v {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final View f4621a;

        /* renamed from: b */
        public boolean f4622b = false;

        public a(View view) {
            this.f4621a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            View view = this.f4621a;
            o.a aVar = o.f4669a;
            view.setTransitionAlpha(1.0f);
            if (this.f4622b) {
                this.f4621a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            View view = this.f4621a;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            if (y.d.h(view) && this.f4621a.getLayerType() == 0) {
                this.f4622b = true;
                this.f4621a.setLayerType(2, null);
            }
        }
    }

    public d() {
    }

    public d(int i7) {
        if ((i7 & -4) == 0) {
            this.C = i7;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public final ObjectAnimator J(View view, float f7, float f8) {
        if (f7 == f8) {
            return null;
        }
        o.a aVar = o.f4669a;
        view.setTransitionAlpha(f7);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, o.f4669a, f8);
        ofFloat.addListener(new a(view));
        a(new c(view));
        return ofFloat;
    }

    @Override // k2.h
    public final void g(n nVar) {
        H(nVar);
        HashMap hashMap = nVar.f4666a;
        View view = nVar.f4667b;
        o.a aVar = o.f4669a;
        hashMap.put("android:fade:transitionAlpha", Float.valueOf(view.getTransitionAlpha()));
    }
}
