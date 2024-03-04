package w3;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;
import w3.d;

/* loaded from: classes.dex */
public final class b {
    public static AnimatorSet a(d dVar, float f7, float f8, float f9) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(dVar, d.b.f6402a, d.a.f6400b, new d.C0130d(f7, f8, f9));
        d.C0130d revealInfo = dVar.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) dVar, (int) f7, (int) f8, revealInfo.f6406c, f9);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }
}
