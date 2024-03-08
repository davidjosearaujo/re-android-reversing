package e6;

import a6.y;
import c6.a;
import c6.o;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import d6.c;
import d6.d;
import f5.g;
import g5.n;
import java.util.ArrayList;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class f<T> implements l<T> {

    /* renamed from: f */
    public final i5.f f3880f;

    /* renamed from: g */
    public final int f3881g;

    /* renamed from: h */
    public final a f3882h;

    public f(i5.f fVar, int i7, a aVar) {
        this.f3880f = fVar;
        this.f3881g = i7;
        this.f3882h = aVar;
    }

    @Override // d6.c
    public Object a(d<? super T> dVar, i5.d<? super g> dVar2) {
        Object b2 = y.b(new d(null, dVar, this), dVar2);
        return b2 == j5.a.f4591f ? b2 : g.f4141a;
    }

    @Override // e6.l
    public final c<T> c(i5.f fVar, int i7, a aVar) {
        i5.f s = fVar.s(this.f3880f);
        if (aVar == a.SUSPEND) {
            i7 = this.f3881g;
            if (i7 != -3) {
                if (i7 != -3) {
                    if (i7 != -2) {
                        if (i7 != -2 && (i7 = i7 + i7) < 0) {
                            i7 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                        }
                    }
                }
            }
            aVar = this.f3882h;
        }
        return (h.a(s, this.f3880f) && i7 == this.f3881g && aVar == this.f3882h) ? this : e(s, i7, aVar);
    }

    public abstract Object d(o<? super T> oVar, i5.d<? super g> dVar);

    public abstract f<T> e(i5.f fVar, int i7, a aVar);

    public c<T> f() {
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
        if (this.f3882h != a.SUSPEND) {
            StringBuilder d9 = androidx.activity.h.d("onBufferOverflow=");
            d9.append(this.f3882h);
            arrayList.add(d9.toString());
        }
        return getClass().getSimpleName() + '[' + n.Z(arrayList, ", ", null, null, null, 62) + ']';
    }
}
