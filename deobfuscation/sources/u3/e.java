package u3;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: classes.dex */
public final class e extends g {

    /* renamed from: b */
    public final /* synthetic */ CarouselLayoutManager f6111b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(CarouselLayoutManager carouselLayoutManager) {
        super(1);
        this.f6111b = carouselLayoutManager;
    }

    @Override // u3.g
    public final void a(RectF rectF, RectF rectF2, RectF rectF3) {
        float f7 = rectF2.top;
        float f8 = rectF3.top;
        if (f7 < f8 && rectF2.bottom > f8) {
            float f9 = f8 - f7;
            rectF.top += f9;
            rectF3.top += f9;
        }
        float f10 = rectF2.bottom;
        float f11 = rectF3.bottom;
        if (f10 <= f11 || rectF2.top >= f11) {
            return;
        }
        float f12 = f10 - f11;
        rectF.bottom = Math.max(rectF.bottom - f12, rectF.top);
        rectF2.bottom = Math.max(rectF2.bottom - f12, rectF2.top);
    }

    @Override // u3.g
    public final float b(RecyclerView.m mVar) {
        return ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
    }

    @Override // u3.g
    public final RectF c(float f7, float f8, float f9, float f10) {
        return new RectF(0.0f, f9, f8, f7 - f9);
    }

    @Override // u3.g
    public final int d() {
        return this.f6111b.f2045o;
    }

    @Override // u3.g
    public final int e() {
        return this.f6111b.f2045o;
    }

    @Override // u3.g
    public final int f() {
        return this.f6111b.D();
    }

    @Override // u3.g
    public final int g() {
        CarouselLayoutManager carouselLayoutManager = this.f6111b;
        return carouselLayoutManager.f2044n - carouselLayoutManager.E();
    }

    @Override // u3.g
    public final int h() {
        return 0;
    }

    @Override // u3.g
    public final int i() {
        return 0;
    }

    @Override // u3.g
    public final void j(View view, int i7, int i8) {
        CarouselLayoutManager carouselLayoutManager = this.f6111b;
        int f7 = f();
        int g2 = g();
        carouselLayoutManager.getClass();
        RecyclerView.l.M(view, f7, i7, g2, i8);
    }

    @Override // u3.g
    public final void k(RectF rectF, RectF rectF2, RectF rectF3) {
        if (rectF2.bottom <= rectF3.top) {
            float floor = ((float) Math.floor(rectF.bottom)) - 1.0f;
            rectF.bottom = floor;
            rectF.top = Math.min(rectF.top, floor);
        }
        if (rectF2.top >= rectF3.bottom) {
            float ceil = ((float) Math.ceil(rectF.top)) + 1.0f;
            rectF.top = ceil;
            rectF.bottom = Math.max(ceil, rectF.bottom);
        }
    }

    @Override // u3.g
    public final void l(float f7, float f8, Rect rect, View view) {
        view.offsetTopAndBottom((int) (f8 - (rect.top + f7)));
    }
}
