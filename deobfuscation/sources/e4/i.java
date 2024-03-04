package e4;

import android.content.res.Resources;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.fragment.app.s0;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public final class i extends a<View> {

    /* renamed from: g */
    public final float f3780g;

    /* renamed from: h */
    public final float f3781h;

    /* renamed from: i */
    public final float f3782i;

    public i(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f3780g = resources.getDimension(2131099827);
        this.f3781h = resources.getDimension(2131099826);
        this.f3782i = resources.getDimension(2131099828);
    }

    public final void a(float f7, int i7, boolean z6) {
        float interpolation = this.f3762a.getInterpolation(f7);
        V v6 = this.f3763b;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        boolean z7 = (Gravity.getAbsoluteGravity(i7, y.e.d(v6)) & 3) == 3;
        boolean z8 = z6 == z7;
        int width = this.f3763b.getWidth();
        int height = this.f3763b.getHeight();
        float f8 = width;
        if (f8 > 0.0f) {
            float f9 = height;
            if (f9 <= 0.0f) {
                return;
            }
            float f10 = this.f3780g / f8;
            float f11 = this.f3781h / f8;
            float f12 = this.f3782i / f9;
            V v7 = this.f3763b;
            if (z7) {
                f8 = 0.0f;
            }
            v7.setPivotX(f8);
            if (!z8) {
                f11 = -f10;
            }
            LinearInterpolator linearInterpolator = n3.a.f5161a;
            float f13 = s0.f(f11, 0.0f, interpolation, 0.0f);
            float f14 = f13 + 1.0f;
            this.f3763b.setScaleX(f14);
            float f15 = 1.0f - (((f12 - 0.0f) * interpolation) + 0.0f);
            this.f3763b.setScaleY(f15);
            V v8 = this.f3763b;
            if (v8 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v8;
                for (int i8 = 0; i8 < viewGroup.getChildCount(); i8++) {
                    View childAt = viewGroup.getChildAt(i8);
                    childAt.setPivotX(z7 ? childAt.getWidth() + (width - childAt.getRight()) : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f16 = z8 ? 1.0f - f13 : 1.0f;
                    float f17 = f15 != 0.0f ? (f14 / f15) * f16 : 1.0f;
                    childAt.setScaleX(f16);
                    childAt.setScaleY(f17);
                }
            }
        }
    }
}
