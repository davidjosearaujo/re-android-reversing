package r3;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import k4.f;

/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ BottomSheetBehavior f5897a;

    public a(BottomSheetBehavior bottomSheetBehavior) {
        this.f5897a = bottomSheetBehavior;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        k4.f fVar = this.f5897a.f2859n;
        if (fVar != null) {
            f.b bVar = fVar.f4720f;
            if (bVar.f4748j != floatValue) {
                bVar.f4748j = floatValue;
                fVar.f4724j = true;
                fVar.invalidateSelf();
            }
        }
    }
}
