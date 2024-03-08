package e6;

import a0.b;
import a6.s;
import a6.t;
import c6.a;
import c6.o;
import d6.c;
import d6.d;
import f5.g;
import f6.v;
import i5.e;
import i5.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class h<S, T> extends f<T> {

    /* renamed from: i */
    public final c<S> f3886i;

    public h(int i7, f fVar, a aVar, c cVar) {
        super(fVar, i7, aVar);
        this.f3886i = cVar;
    }

    @Override // e6.f, d6.c
    public final Object a(d<? super T> dVar, i5.d<? super g> dVar2) {
        if (this.f3881g == -3) {
            f a7 = dVar2.a();
            f fVar = this.f3880f;
            f s = !((Boolean) fVar.q(Boolean.FALSE, t.f336g)).booleanValue() ? a7.s(fVar) : s.a(a7, fVar, false);
            if (r5.h.a(s, a7)) {
                Object g2 = g(dVar, dVar2);
                if (g2 == j5.a.f4591f) {
                    return g2;
                }
            } else {
                e.a aVar = e.a.f4486f;
                if (r5.h.a(s.e(aVar), a7.e(aVar))) {
                    f a8 = dVar2.a();
                    if (!(dVar instanceof r ? true : dVar instanceof n)) {
                        dVar = new u<>(dVar, a8);
                    }
                    Object E = b.E(s, dVar, v.b(s), new g(this, null), dVar2);
                    j5.a aVar2 = j5.a.f4591f;
                    if (E != aVar2) {
                        E = g.f4141a;
                    }
                    if (E == aVar2) {
                        return E;
                    }
                }
            }
            return g.f4141a;
        }
        Object a9 = super.a(dVar, dVar2);
        if (a9 == j5.a.f4591f) {
            return a9;
        }
        return g.f4141a;
    }

    @Override // e6.f
    public final Object d(o<? super T> oVar, i5.d<? super g> dVar) {
        Object g2 = g(new r(oVar), dVar);
        return g2 == j5.a.f4591f ? g2 : g.f4141a;
    }

    public abstract Object g(d<? super T> dVar, i5.d<? super g> dVar2);

    @Override // e6.f
    public final String toString() {
        return this.f3886i + " -> " + super.toString();
    }
}
