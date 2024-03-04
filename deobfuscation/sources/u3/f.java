package u3;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: classes.dex */
public final class f extends g {

    /* renamed from: b */
    public final /* synthetic */ CarouselLayoutManager f6112b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(CarouselLayoutManager carouselLayoutManager) {
        super(0);
        this.f6112b = carouselLayoutManager;
    }

    @Override // u3.g
    public final void a(RectF rectF, RectF rectF2, RectF rectF3) {
        float f7 = rectF2.left;
        float f8 = rectF3.left;
        if (f7 < f8 && rectF2.right > f8) {
            float f9 = f8 - f7;
            rectF.left += f9;
            rectF2.left += f9;
        }
        float f10 = rectF2.right;
        float f11 = rectF3.right;
        if (f10 <= f11 || rectF2.left >= f11) {
            return;
        }
        float f12 = f10 - f11;
        rectF.right = Math.max(rectF.right - f12, rectF.left);
        rectF2.right = Math.max(rectF2.right - f12, rectF2.left);
    }

    @Override // u3.g
    public final float b(RecyclerView.m mVar) {
        return ((ViewGroup.MarginLayoutParams) mVar).rightMargin + ((ViewGroup.MarginLayoutParams) mVar).leftMargin;
    }

    @Override // u3.g
    public final RectF c(float f7, float f8, float f9, float f10) {
        return new RectF(f10, 0.0f, f8 - f10, f7);
    }

    @Override // u3.g
    public final int d() {
        CarouselLayoutManager carouselLayoutManager = this.f6112b;
        return carouselLayoutManager.f2045o - carouselLayoutManager.C();
    }

    @Override // u3.g
    public final int e() {
        if (this.f6112b.Q0()) {
            return 0;
        }
        return this.f6112b.f2044n;
    }

    @Override // u3.g
    public final int f() {
        return 0;
    }

    @Override // u3.g
    public final int g() {
        return this.f6112b.f2044n;
    }

    @Override // u3.g
    public final int h() {
        if (this.f6112b.Q0()) {
            return this.f6112b.f2044n;
        }
        return 0;
    }

    @Override // u3.g
    public final int i() {
        return this.f6112b.F();
    }

    @Override // u3.g
    public final void j(View view, int i7, int i8) {
        CarouselLayoutManager carouselLayoutManager = this.f6112b;
        int i9 = i();
        int d7 = d();
        carouselLayoutManager.getClass();
        RecyclerView.l.M(view, i7, i9, i8, d7);
    }

    @Override // u3.g
    public final void k(RectF rectF, RectF rectF2, RectF rectF3) {
        if (rectF2.right <= rectF3.left) {
            float floor = ((float) Math.floor(rectF.right)) - 1.0f;
            rectF.right = floor;
            rectF.left = Math.min(rectF.left, floor);
        }
        if (rectF2.left >= rectF3.right) {
            float ceil = ((float) Math.ceil(rectF.left)) + 1.0f;
            rectF.left = ceil;
            rectF.right = Math.max(ceil, rectF.right);
        }
    }

    @Override // u3.g
    public final void l(float f7, float f8, Rect rect, View view) {
        view.offsetLeftAndRight((int) (f8 - (rect.left + f7)));
    }
}
