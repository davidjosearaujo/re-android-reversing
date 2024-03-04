package u3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.carousel.b;

/* loaded from: classes.dex */
public final class i extends androidx.activity.result.c {

    /* renamed from: g */
    public static final int[] f6114g = {1};

    /* renamed from: h */
    public static final int[] f6115h = {1, 0};

    /* renamed from: f */
    public int f6116f = 0;

    @Override // androidx.activity.result.c
    public final com.google.android.material.carousel.b j(b bVar, View view) {
        int[] iArr;
        int[] iArr2;
        b.a aVar;
        int i7;
        b.a aVar2;
        float f7;
        int i8;
        int i9;
        int i10;
        CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) bVar;
        float f8 = carouselLayoutManager.f2045o;
        if (carouselLayoutManager.P0()) {
            f8 = carouselLayoutManager.f2044n;
        }
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        float f9 = ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carouselLayoutManager.P0()) {
            f9 = ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f10 = f9;
        float dimension = view.getContext().getResources().getDimension(2131099892) + f10;
        float dimension2 = view.getContext().getResources().getDimension(2131099891) + f10;
        float min = Math.min(measuredHeight + f10, f8);
        float f11 = (measuredHeight / 3.0f) + f10;
        float dimension3 = view.getContext().getResources().getDimension(2131099892) + f10;
        float dimension4 = view.getContext().getResources().getDimension(2131099891) + f10;
        float f12 = f11 < dimension3 ? dimension3 : f11 > dimension4 ? dimension4 : f11;
        float f13 = (min + f12) / 2.0f;
        int[] iArr3 = f6114g;
        if (f8 < dimension * 2.0f) {
            iArr3 = new int[]{0};
        }
        int[] iArr4 = f6115h;
        if (carouselLayoutManager.C == 1) {
            int length = iArr3.length;
            int[] iArr5 = new int[length];
            for (int i11 = 0; i11 < length; i11++) {
                iArr5[i11] = iArr3[i11] * 2;
            }
            int[] iArr6 = new int[2];
            for (int i12 = 0; i12 < 2; i12++) {
                iArr6[i12] = iArr4[i12] * 2;
            }
            iArr2 = iArr6;
            iArr = iArr5;
        } else {
            iArr = iArr3;
            iArr2 = iArr4;
        }
        int i13 = Integer.MIN_VALUE;
        int i14 = Integer.MIN_VALUE;
        for (int i15 : iArr2) {
            if (i15 > i14) {
                i14 = i15;
            }
        }
        float f14 = f8 - (i14 * f13);
        for (int i16 : iArr) {
            if (i16 > i13) {
                i13 = i16;
            }
        }
        int ceil = (int) Math.ceil(f8 / min);
        int max = (ceil - ((int) Math.max(1.0d, Math.floor((f14 - (i13 * dimension2)) / min)))) + 1;
        int[] iArr7 = new int[max];
        for (int i17 = 0; i17 < max; i17++) {
            iArr7[i17] = ceil - i17;
        }
        a a7 = a.a(f8, f12, dimension, dimension2, iArr, f13, iArr2, min, iArr7);
        this.f6116f = a7.f6104c + a7.f6105d + a7.f6107g;
        int A = ((RecyclerView.l) bVar).A();
        int i18 = a7.f6104c;
        int i19 = a7.f6105d;
        int i20 = ((i18 + i19) + a7.f6107g) - A;
        boolean z6 = i20 > 0 && (i18 > 0 || i19 > 1);
        while (i20 > 0) {
            int i21 = a7.f6104c;
            if (i21 > 0) {
                a7.f6104c = i21 - 1;
            } else {
                int i22 = a7.f6105d;
                if (i22 > 1) {
                    a7.f6105d = i22 - 1;
                }
            }
            i20--;
        }
        if (z6) {
            a7 = a.a(f8, f12, dimension, dimension2, new int[]{a7.f6104c}, f13, new int[]{a7.f6105d}, min, new int[]{a7.f6107g});
        }
        Context context = view.getContext();
        if (carouselLayoutManager.C != 1) {
            float min2 = Math.min(context.getResources().getDimension(2131099889) + f10, a7.f6106f);
            float f15 = min2 / 2.0f;
            float b2 = com.google.android.material.carousel.a.b(0.0f, a7.f6106f, a7.f6107g);
            float c7 = com.google.android.material.carousel.a.c(0.0f, com.google.android.material.carousel.a.a(b2, a7.f6106f, a7.f6107g), a7.f6106f, a7.f6107g);
            float b7 = com.google.android.material.carousel.a.b(c7, a7.e, a7.f6105d);
            float b8 = com.google.android.material.carousel.a.b(com.google.android.material.carousel.a.c(c7, b7, a7.e, a7.f6105d), a7.f6103b, a7.f6104c);
            float f16 = f15 + f8;
            float e = androidx.activity.result.c.e(min2, a7.f6106f, f10);
            float e7 = androidx.activity.result.c.e(a7.f6103b, a7.f6106f, f10);
            float e8 = androidx.activity.result.c.e(a7.e, a7.f6106f, f10);
            b.a aVar3 = new b.a(a7.f6106f, f8);
            aVar3.a(0.0f - f15, e, min2, false, true);
            aVar3.c(b2, 0.0f, a7.f6106f, a7.f6107g, true);
            if (a7.f6105d > 0) {
                aVar = aVar3;
                aVar3.a(b7, e8, a7.e, false, false);
            } else {
                aVar = aVar3;
            }
            int i23 = a7.f6104c;
            if (i23 > 0) {
                aVar.c(b8, e7, a7.f6103b, i23, false);
            }
            aVar.a(f16, e, min2, false, true);
            return aVar.d();
        }
        float min3 = Math.min(context.getResources().getDimension(2131099889) + f10, a7.f6106f);
        float f17 = min3 / 2.0f;
        float f18 = 0.0f - f17;
        float b9 = com.google.android.material.carousel.a.b(0.0f, a7.f6103b, a7.f6104c);
        float c8 = com.google.android.material.carousel.a.c(0.0f, com.google.android.material.carousel.a.a(b9, a7.f6103b, (int) Math.floor(a7.f6104c / 2.0f)), a7.f6103b, a7.f6104c);
        float b10 = com.google.android.material.carousel.a.b(c8, a7.e, a7.f6105d);
        float c9 = com.google.android.material.carousel.a.c(c8, com.google.android.material.carousel.a.a(b10, a7.e, (int) Math.floor(a7.f6105d / 2.0f)), a7.e, a7.f6105d);
        float b11 = com.google.android.material.carousel.a.b(c9, a7.f6106f, a7.f6107g);
        float c10 = com.google.android.material.carousel.a.c(c9, com.google.android.material.carousel.a.a(b11, a7.f6106f, a7.f6107g), a7.f6106f, a7.f6107g);
        float b12 = com.google.android.material.carousel.a.b(c10, a7.e, a7.f6105d);
        float b13 = com.google.android.material.carousel.a.b(com.google.android.material.carousel.a.c(c10, com.google.android.material.carousel.a.a(b12, a7.e, (int) Math.ceil(a7.f6105d / 2.0f)), a7.e, a7.f6105d), a7.f6103b, a7.f6104c);
        float f19 = f17 + f8;
        float e9 = androidx.activity.result.c.e(min3, a7.f6106f, f10);
        float e10 = androidx.activity.result.c.e(a7.f6103b, a7.f6106f, f10);
        float e11 = androidx.activity.result.c.e(a7.e, a7.f6106f, f10);
        b.a aVar4 = new b.a(a7.f6106f, f8);
        aVar4.a(f18, e9, min3, false, true);
        if (a7.f6104c > 0) {
            aVar2 = aVar4;
            f7 = b12;
            aVar4.c(b9, e10, a7.f6103b, (int) Math.floor(i7 / 2.0f), false);
        } else {
            aVar2 = aVar4;
            f7 = b12;
        }
        if (a7.f6105d > 0) {
            aVar2.c(b10, e11, a7.e, (int) Math.floor(i8 / 2.0f), false);
        }
        aVar2.c(b11, 0.0f, a7.f6106f, a7.f6107g, true);
        if (a7.f6105d > 0) {
            aVar2.c(f7, e11, a7.e, (int) Math.ceil(i9 / 2.0f), false);
        }
        if (a7.f6104c > 0) {
            aVar2.c(b13, e10, a7.f6103b, (int) Math.ceil(i10 / 2.0f), false);
        }
        aVar2.a(f19, e9, min3, false, true);
        return aVar2.d();
    }

    @Override // androidx.activity.result.c
    public final boolean o(b bVar, int i7) {
        return (i7 < this.f6116f && ((RecyclerView.l) bVar).A() >= this.f6116f) || (i7 >= this.f6116f && ((RecyclerView.l) bVar).A() < this.f6116f);
    }
}
