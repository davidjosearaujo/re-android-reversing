package com.google.android.material.carousel;

import android.view.animation.LinearInterpolator;
import androidx.fragment.app.s0;
import com.google.android.material.carousel.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    public final b f2968a;

    /* renamed from: b */
    public final List<b> f2969b;

    /* renamed from: c */
    public final List<b> f2970c;

    /* renamed from: d */
    public final float[] f2971d;
    public final float[] e;

    /* renamed from: f */
    public final float f2972f;

    /* renamed from: g */
    public final float f2973g;

    public c(b bVar, ArrayList arrayList, ArrayList arrayList2) {
        this.f2968a = bVar;
        this.f2969b = Collections.unmodifiableList(arrayList);
        this.f2970c = Collections.unmodifiableList(arrayList2);
        float f7 = ((b) arrayList.get(arrayList.size() - 1)).b().f2963a - bVar.b().f2963a;
        this.f2972f = f7;
        float f8 = bVar.d().f2963a - ((b) arrayList2.get(arrayList2.size() - 1)).d().f2963a;
        this.f2973g = f8;
        this.f2971d = b(f7, arrayList, true);
        this.e = b(f8, arrayList2, false);
    }

    public static float[] b(float f7, ArrayList arrayList, boolean z6) {
        int size = arrayList.size();
        float[] fArr = new float[size];
        int i7 = 1;
        while (i7 < size) {
            int i8 = i7 - 1;
            b bVar = (b) arrayList.get(i8);
            b bVar2 = (b) arrayList.get(i7);
            fArr[i7] = i7 == size + (-1) ? 1.0f : fArr[i8] + ((z6 ? bVar2.b().f2963a - bVar.b().f2963a : bVar.d().f2963a - bVar2.d().f2963a) / f7);
            i7++;
        }
        return fArr;
    }

    public static b c(b bVar, int i7, int i8, float f7, int i9, int i10, float f8) {
        ArrayList arrayList = new ArrayList(bVar.f2952b);
        arrayList.add(i8, (b.C0032b) arrayList.remove(i7));
        b.a aVar = new b.a(bVar.f2951a, f8);
        int i11 = 0;
        while (i11 < arrayList.size()) {
            b.C0032b c0032b = (b.C0032b) arrayList.get(i11);
            float f9 = c0032b.f2966d;
            aVar.b((f9 / 2.0f) + f7, c0032b.f2965c, f9, i11 >= i9 && i11 <= i10, c0032b.e, c0032b.f2967f);
            f7 += c0032b.f2966d;
            i11++;
        }
        return aVar.d();
    }

    public final b a(float f7, float f8, float f9) {
        float a7;
        List<b> list;
        float[] fArr;
        float[] fArr2;
        float f10 = this.f2972f + f8;
        float f11 = f9 - this.f2973g;
        if (f7 < f10) {
            a7 = n3.a.a(1.0f, 0.0f, f8, f10, f7);
            list = this.f2969b;
            fArr = this.f2971d;
        } else if (f7 <= f11) {
            return this.f2968a;
        } else {
            a7 = n3.a.a(0.0f, 1.0f, f11, f9, f7);
            list = this.f2970c;
            fArr = this.e;
        }
        int size = list.size();
        float f12 = fArr[0];
        int i7 = 1;
        while (true) {
            if (i7 >= size) {
                fArr2 = new float[]{0.0f, 0.0f, 0.0f};
                break;
            }
            float f13 = fArr[i7];
            if (a7 <= f13) {
                fArr2 = new float[]{n3.a.a(0.0f, 1.0f, f12, f13, a7), (float) (i7 - 1), i7};
                break;
            }
            i7++;
            f12 = f13;
        }
        b bVar = list.get((int) fArr2[1]);
        b bVar2 = list.get((int) fArr2[2]);
        float f14 = fArr2[0];
        if (bVar.f2951a == bVar2.f2951a) {
            List<b.C0032b> list2 = bVar.f2952b;
            List<b.C0032b> list3 = bVar2.f2952b;
            if (list2.size() == list3.size()) {
                ArrayList arrayList = new ArrayList();
                for (int i8 = 0; i8 < bVar.f2952b.size(); i8++) {
                    b.C0032b c0032b = list2.get(i8);
                    b.C0032b c0032b2 = list3.get(i8);
                    float f15 = c0032b.f2963a;
                    float f16 = c0032b2.f2963a;
                    LinearInterpolator linearInterpolator = n3.a.f5161a;
                    float f17 = s0.f(f16, f15, f14, f15);
                    float f18 = c0032b.f2964b;
                    float f19 = s0.f(c0032b2.f2964b, f18, f14, f18);
                    float f20 = c0032b.f2965c;
                    float f21 = s0.f(c0032b2.f2965c, f20, f14, f20);
                    float f22 = c0032b.f2966d;
                    arrayList.add(new b.C0032b(f17, f19, f21, s0.f(c0032b2.f2966d, f22, f14, f22), false, 0.0f));
                }
                return new b(bVar.f2951a, arrayList, n3.a.b(bVar.f2953c, bVar2.f2953c, f14), n3.a.b(bVar.f2954d, bVar2.f2954d, f14));
            }
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
    }
}
