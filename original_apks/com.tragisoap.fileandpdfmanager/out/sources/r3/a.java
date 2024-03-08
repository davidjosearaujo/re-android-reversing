package r3;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import k4.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f5897a;

    public a(BottomSheetBehavior bottomSheetBehavior) {
        this.f5897a = bottomSheetBehavior;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        f fVar = this.f5897a.f2859n;
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
