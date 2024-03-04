package c4;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.graphics.Rect;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.d;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b extends d {
    public StateListAnimator I;

    public b(FloatingActionButton floatingActionButton, FloatingActionButton.b bVar) {
        super(floatingActionButton, bVar);
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final float e() {
        return this.f3185q.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void f(Rect rect) {
        if (FloatingActionButton.this.f3154o) {
            super.f(rect);
            return;
        }
        int sizeDimension = !this.f3172b || this.f3185q.getSizeDimension() >= 0 ? 0 : (0 - this.f3185q.getSizeDimension()) / 2;
        rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void g() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void h() {
        n();
        throw null;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void i(int[] iArr) {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void j(float f7, float f8, float f9) {
        if (this.f3185q.getStateListAnimator() == this.I) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(d.C, o(f7, f9));
            stateListAnimator.addState(d.D, o(f7, f8));
            stateListAnimator.addState(d.E, o(f7, f8));
            stateListAnimator.addState(d.F, o(f7, f8));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.f3185q, "elevation", f7).setDuration(0L));
            arrayList.add(ObjectAnimator.ofFloat(this.f3185q, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(d.f3168x);
            stateListAnimator.addState(d.G, animatorSet);
            stateListAnimator.addState(d.H, o(0.0f, 0.0f));
            this.I = stateListAnimator;
            this.f3185q.setStateListAnimator(stateListAnimator);
        }
        if (p()) {
            n();
            throw null;
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void l() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void m() {
    }

    public final AnimatorSet o(float f7, float f8) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f3185q, "elevation", f7).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f3185q, View.TRANSLATION_Z, f8).setDuration(100L));
        animatorSet.setInterpolator(d.f3168x);
        return animatorSet;
    }

    public final boolean p() {
        if (!FloatingActionButton.this.f3154o) {
            if (!this.f3172b || this.f3185q.getSizeDimension() >= 0) {
                return false;
            }
        }
        return true;
    }
}
