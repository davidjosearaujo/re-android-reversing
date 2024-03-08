package u3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.c;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.carousel.a;
import com.google.android.material.carousel.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i extends c {

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f6114g = {1};

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f6115h = {1, 0};

    /* renamed from: f  reason: collision with root package name */
    public int f6116f = 0;

    @Override // androidx.activity.result.c
    public final b j(b bVar, View view) {
        int[] iArr;
        int[] iArr2;
        b.a aVar;
        b.a aVar2;
        float f7;
        CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) bVar;
        float f8 = (float) carouselLayoutManager.f2045o;
        if (carouselLayoutManager.P0()) {
            f8 = (float) carouselLayoutManager.f2044n;
        }
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        float f9 = (float) (((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin);
        float measuredHeight = (float) view.getMeasuredHeight();
        if (carouselLayoutManager.P0()) {
            f9 = (float) (((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin);
            measuredHeight = (float) view.getMeasuredWidth();
        }
        float dimension = view.getContext().getResources().getDimension(2131099892) + f9;
        float dimension2 = view.getContext().getResources().getDimension(2131099891) + f9;
        float min = Math.min(measuredHeight + f9, f8);
        float f10 = (measuredHeight / 3.0f) + f9;
        float dimension3 = view.getContext().getResources().getDimension(2131099892) + f9;
        float dimension4 = view.getContext().getResources().getDimension(2131099891) + f9;
        float f11 = f10 < dimension3 ? dimension3 : f10 > dimension4 ? dimension4 : f10;
        float f12 = (min + f11) / 2.0f;
        int[] iArr3 = f6114g;
        if (f8 < dimension * 2.0f) {
            iArr3 = new int[]{0};
        }
        int[] iArr4 = f6115h;
        if (carouselLayoutManager.C == 1) {
            int length = iArr3.length;
            int[] iArr5 = new int[length];
            for (int i7 = 0; i7 < length; i7++) {
                iArr5[i7] = iArr3[i7] * 2;
            }
            int[] iArr6 = new int[2];
            for (int i8 = 0; i8 < 2; i8++) {
                iArr6[i8] = iArr4[i8] * 2;
            }
            iArr = iArr6;
            iArr2 = iArr5;
        } else {
            iArr2 = iArr3;
            iArr = iArr4;
        }
        int i9 = Integer.MIN_VALUE;
        int i10 = Integer.MIN_VALUE;
        for (int i11 : iArr) {
            if (i11 > i10) {
                i10 = i11;
            }
        }
        float f13 = f8 - (((float) i10) * f12);
        for (int i12 : iArr2) {
            if (i12 > i9) {
                i9 = i12;
            }
        }
        int ceil = (int) Math.ceil((double) (f8 / min));
        int max = (ceil - ((int) Math.max(1.0d, Math.floor((double) ((f13 - (((float) i9) * dimension2)) / min))))) + 1;
        int[] iArr7 = new int[max];
        for (int i13 = 0; i13 < max; i13++) {
            iArr7[i13] = ceil - i13;
        }
        a a7 = a.a(f8, f11, dimension, dimension2, iArr2, f12, iArr, min, iArr7);
        this.f6116f = a7.f6104c + a7.f6105d + a7.f6107g;
        int A = ((RecyclerView.l) bVar).A();
        int i14 = a7.f6104c;
        int i15 = a7.f6105d;
        int i16 = ((i14 + i15) + a7.f6107g) - A;
        boolean z6 = i16 > 0 && (i14 > 0 || i15 > 1);
        while (i16 > 0) {
            int i17 = a7.f6104c;
            if (i17 > 0) {
                a7.f6104c = i17 - 1;
            } else {
                int i18 = a7.f6105d;
                if (i18 > 1) {
                    a7.f6105d = i18 - 1;
                }
            }
            i16--;
        }
        if (z6) {
            a7 = a.a(f8, f11, dimension, dimension2, new int[]{a7.f6104c}, f12, new int[]{a7.f6105d}, min, new int[]{a7.f6107g});
        }
        Context context = view.getContext();
        if (carouselLayoutManager.C == 1) {
            float min2 = Math.min(context.getResources().getDimension(2131099889) + f9, a7.f6106f);
            float f14 = min2 / 2.0f;
            float f15 = 0.0f - f14;
            float b2 = a.b(0.0f, a7.f6103b, a7.f6104c);
            float c7 = a.c(0.0f, a.a(b2, a7.f6103b, (int) Math.floor((double) (((float) a7.f6104c) / 2.0f))), a7.f6103b, a7.f6104c);
            float b7 = a.b(c7, a7.e, a7.f6105d);
            float c8 = a.c(c7, a.a(b7, a7.e, (int) Math.floor((double) (((float) a7.f6105d) / 2.0f))), a7.e, a7.f6105d);
            float b8 = a.b(c8, a7.f6106f, a7.f6107g);
            float c9 = a.c(c8, a.a(b8, a7.f6106f, a7.f6107g), a7.f6106f, a7.f6107g);
            float b9 = a.b(c9, a7.e, a7.f6105d);
            float b10 = a.b(a.c(c9, a.a(b9, a7.e, (int) Math.ceil((double) (((float) a7.f6105d) / 2.0f))), a7.e, a7.f6105d), a7.f6103b, a7.f6104c);
            float f16 = f14 + f8;
            float e = c.e(min2, a7.f6106f, f9);
            float e7 = c.e(a7.f6103b, a7.f6106f, f9);
            float e8 = c.e(a7.e, a7.f6106f, f9);
            b.a aVar3 = new b.a(a7.f6106f, f8);
            aVar3.a(f15, e, min2, false, true);
            int i19 = a7.f6104c;
            if (i19 > 0) {
                aVar2 = aVar3;
                f7 = b9;
                aVar3.c(b2, e7, a7.f6103b, (int) Math.floor((double) (((float) i19) / 2.0f)), false);
            } else {
                aVar2 = aVar3;
                f7 = b9;
            }
            int i20 = a7.f6105d;
            if (i20 > 0) {
                aVar2.c(b7, e8, a7.e, (int) Math.floor((double) (((float) i20) / 2.0f)), false);
            }
            aVar2.c(b8, 0.0f, a7.f6106f, a7.f6107g, true);
            int i21 = a7.f6105d;
            if (i21 > 0) {
                aVar2.c(f7, e8, a7.e, (int) Math.ceil((double) (((float) i21) / 2.0f)), false);
            }
            int i22 = a7.f6104c;
            if (i22 > 0) {
                aVar2.c(b10, e7, a7.f6103b, (int) Math.ceil((double) (((float) i22) / 2.0f)), false);
            }
            aVar2.a(f16, e, min2, false, true);
            return aVar2.d();
        }
        float min3 = Math.min(context.getResources().getDimension(2131099889) + f9, a7.f6106f);
        float f17 = min3 / 2.0f;
        float b11 = a.b(0.0f, a7.f6106f, a7.f6107g);
        float c10 = a.c(0.0f, a.a(b11, a7.f6106f, a7.f6107g), a7.f6106f, a7.f6107g);
        float b12 = a.b(c10, a7.e, a7.f6105d);
        float b13 = a.b(a.c(c10, b12, a7.e, a7.f6105d), a7.f6103b, a7.f6104c);
        float f18 = f17 + f8;
        float e9 = c.e(min3, a7.f6106f, f9);
        float e10 = c.e(a7.f6103b, a7.f6106f, f9);
        float e11 = c.e(a7.e, a7.f6106f, f9);
        b.a aVar4 = new b.a(a7.f6106f, f8);
        aVar4.a(0.0f - f17, e9, min3, false, true);
        aVar4.c(b11, 0.0f, a7.f6106f, a7.f6107g, true);
        if (a7.f6105d > 0) {
            aVar = aVar4;
            aVar4.a(b12, e11, a7.e, false, false);
        } else {
            aVar = aVar4;
        }
        int i23 = a7.f6104c;
        if (i23 > 0) {
            aVar.c(b13, e10, a7.f6103b, i23, false);
        }
        aVar.a(f18, e9, min3, false, true);
        return aVar.d();
    }

    @Override // androidx.activity.result.c
    public final boolean o(b bVar, int i7) {
        return (i7 < this.f6116f && ((RecyclerView.l) bVar).A() >= this.f6116f) || (i7 >= this.f6116f && ((RecyclerView.l) bVar).A() < this.f6116f);
    }
}
