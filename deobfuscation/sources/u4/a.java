package u4;

import android.animation.ValueAnimator;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import r5.h;

/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ CircularProgressBar f6117a;

    public a(CircularProgressBar circularProgressBar) {
        this.f6117a = circularProgressBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        h.b(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (!(animatedValue instanceof Float)) {
            animatedValue = null;
        }
        Float f7 = (Float) animatedValue;
        if (f7 != null) {
            float floatValue = f7.floatValue();
            if (this.f6117a.getIndeterminateMode()) {
                this.f6117a.setProgressIndeterminateMode(floatValue);
            } else {
                this.f6117a.setProgress(floatValue);
            }
            if (this.f6117a.getIndeterminateMode()) {
                float f8 = (floatValue * 360) / 100;
                CircularProgressBar circularProgressBar = this.f6117a;
                if (!CircularProgressBar.e(circularProgressBar.D)) {
                    f8 = -f8;
                }
                circularProgressBar.setStartAngleIndeterminateMode(f8 + 270.0f);
            }
        }
    }
}
