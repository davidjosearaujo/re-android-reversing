package e6;

import a6.y;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class f<T> implements l {

    /* renamed from: f */
    public final i5.f f3880f;

    /* renamed from: g */
    public final int f3881g;

    /* renamed from: h */
    public final c6.a f3882h;

    public f(i5.f fVar, int i7, c6.a aVar) {
        this.f3880f = fVar;
        this.f3881g = i7;
        this.f3882h = aVar;
    }

    public Object a(d6.d dVar, i5.d dVar2) {
        Object b2 = y.b(new d(null, dVar, this), dVar2);
        return b2 == Kotlin_1.a.f4591f ? b2 : f5.g.f4141a;
    }

    public final d6.c c(i5.f fVar, int i7, c6.a aVar) {
        i5.f s = fVar.s(this.f3880f);
        if (aVar == c6.a.SUSPEND) {
            int i8 = this.f3881g;
            if (i8 != -3) {
                if (i7 != -3) {
                    if (i8 != -2) {
                        if (i7 != -2 && (i8 = i8 + i7) < 0) {
                            i7 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                        }
                    }
                }
                i7 = i8;
            }
            aVar = this.f3882h;
        }
        return (r5.h.a(s, this.f3880f) && i7 == this.f3881g && aVar == this.f3882h) ? this : e(s, i7, aVar);
    }

    public abstract Object d(c6.o oVar, i5.d dVar);

    public abstract f e(i5.f fVar, int i7, c6.a aVar);

    public d6.c f() {
        return null;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        if (this.f3880f != i5.g.f4488f) {
            StringBuilder d7 = androidx.activity.h.d("context=");
            d7.append(this.f3880f);
            arrayList.add(d7.toString());
        }
        if (this.f3881g != -3) {
            StringBuilder d8 = androidx.activity.h.d("capacity=");
            d8.append(this.f3881g);
            arrayList.add(d8.toString());
        }
        if (this.f3882h != c6.a.SUSPEND) {
            StringBuilder d9 = androidx.activity.h.d("onBufferOverflow=");
            d9.append(this.f3882h);
            arrayList.add(d9.toString());
        }
        return getClass().getSimpleName() + '[' + g5.n.Z(arrayList, ", ", null, null, null, 62) + ']';
    }
}
