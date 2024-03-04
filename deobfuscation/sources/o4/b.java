package o4;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ int f5335a;

    /* renamed from: b */
    public final /* synthetic */ m f5336b;

    public /* synthetic */ b(m mVar, int i7) {
        this.f5335a = i7;
        this.f5336b = mVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f5335a) {
            case 0:
                f fVar = (f) this.f5336b;
                fVar.getClass();
                fVar.f5367d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
            default:
                l lVar = (l) this.f5336b;
                lVar.getClass();
                lVar.f5367d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
        }
    }
}
