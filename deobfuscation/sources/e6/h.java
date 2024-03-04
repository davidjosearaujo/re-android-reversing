package e6;

import f6.v;
import i5.e;

/* loaded from: classes.dex */
public abstract class h<S, T> extends f {

    /* renamed from: i */
    public final d6.c f3886i;

    public h(int i7, i5.f fVar, c6.a aVar, d6.c cVar) {
        super(fVar, i7, aVar);
        this.f3886i = cVar;
    }

    public final Object a(d6.d dVar, i5.d dVar2) {
        if (this.f3881g == -3) {
            i5.f a7 = dVar2.a();
            i5.f fVar = this.f3880f;
            i5.f s = !((Boolean) fVar.q(Boolean.FALSE, a6.t.f336g)).booleanValue() ? a7.s(fVar) : a6.s.a(a7, fVar, false);
            if (r5.h.a(s, a7)) {
                Object g2 = g(dVar, dVar2);
                if (g2 == Kotlin_1.a.f4591f) {
                    return g2;
                }
            } else {
                e.a aVar = e.a.f4486f;
                if (r5.h.a(s.e(aVar), a7.e(aVar))) {
                    i5.f a8 = dVar2.a();
                    if (!(dVar instanceof r ? true : dVar instanceof n)) {
                        dVar = new u(dVar, a8);
                    }
                    Object E = a0.b.E(s, dVar, v.b(s), new g(this, null), dVar2);
                    Kotlin_1.a aVar2 = Kotlin_1.a.f4591f;
                    if (E != aVar2) {
                        E = f5.g.f4141a;
                    }
                    if (E == aVar2) {
                        return E;
                    }
                }
            }
            return f5.g.f4141a;
        }
        Object a9 = super.a(dVar, dVar2);
        if (a9 == Kotlin_1.a.f4591f) {
            return a9;
        }
        return f5.g.f4141a;
    }

    public final Object d(c6.o oVar, i5.d dVar) {
        Object g2 = g(new r(oVar), dVar);
        return g2 == Kotlin_1.a.f4591f ? g2 : f5.g.f4141a;
    }

    public abstract Object g(d6.d dVar, i5.d dVar2);

    public final String toString() {
        return this.f3886i + " -> " + super.toString();
    }
}
