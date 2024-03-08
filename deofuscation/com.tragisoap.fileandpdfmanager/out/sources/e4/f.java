package e4;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.fragment.app.s0;
import c2.b;
import n3.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f extends a<View> {

    /* renamed from: g  reason: collision with root package name */
    public final float f3775g;

    /* renamed from: h  reason: collision with root package name */
    public final float f3776h;

    public f(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f3775g = resources.getDimension(2131099822);
        this.f3776h = resources.getDimension(2131099823);
    }

    public final AnimatorSet a() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f3763b, View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f3763b, View.SCALE_Y, 1.0f));
        V v6 = this.f3763b;
        if (v6 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v6;
            for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i7), View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new b());
        return animatorSet;
    }

    public final void b(float f7) {
        float interpolation = this.f3762a.getInterpolation(f7);
        float width = (float) this.f3763b.getWidth();
        float height = (float) this.f3763b.getHeight();
        if (width > 0.0f && height > 0.0f) {
            float f8 = this.f3775g / width;
            LinearInterpolator linearInterpolator = a.f5161a;
            float f9 = 1.0f - s0.f(f8, 0.0f, interpolation, 0.0f);
            float f10 = 1.0f - s0.f(this.f3776h / height, 0.0f, interpolation, 0.0f);
            this.f3763b.setScaleX(f9);
            this.f3763b.setPivotY(height);
            this.f3763b.setScaleY(f10);
            V v6 = this.f3763b;
            if (v6 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v6;
                for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
                    View childAt = viewGroup.getChildAt(i7);
                    childAt.setPivotY((float) (-childAt.getTop()));
                    childAt.setScaleY(f10 != 0.0f ? f9 / f10 : 1.0f);
                }
            }
        }
    }
}
