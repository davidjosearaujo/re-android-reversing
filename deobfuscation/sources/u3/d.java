package u3;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: classes.dex */
public final class d extends m {

    /* renamed from: q */
    public final /* synthetic */ CarouselLayoutManager f6110q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(CarouselLayoutManager carouselLayoutManager, Context context) {
        super(context);
        this.f6110q = carouselLayoutManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v
    public final PointF a(int i7) {
        return this.f6110q.a(i7);
    }

    @Override // androidx.recyclerview.widget.m
    public final int f(View view, int i7) {
        CarouselLayoutManager carouselLayoutManager = this.f6110q;
        if (carouselLayoutManager.f2937u == null || !carouselLayoutManager.P0()) {
            return 0;
        }
        CarouselLayoutManager carouselLayoutManager2 = this.f6110q;
        carouselLayoutManager2.getClass();
        int G = RecyclerView.l.G(view);
        return (int) (carouselLayoutManager2.f2933p - carouselLayoutManager2.M0(G, carouselLayoutManager2.K0(G)));
    }

    @Override // androidx.recyclerview.widget.m
    public final int g(View view, int i7) {
        CarouselLayoutManager carouselLayoutManager = this.f6110q;
        if (carouselLayoutManager.f2937u == null || carouselLayoutManager.P0()) {
            return 0;
        }
        CarouselLayoutManager carouselLayoutManager2 = this.f6110q;
        carouselLayoutManager2.getClass();
        int G = RecyclerView.l.G(view);
        return (int) (carouselLayoutManager2.f2933p - carouselLayoutManager2.M0(G, carouselLayoutManager2.K0(G)));
    }
}
