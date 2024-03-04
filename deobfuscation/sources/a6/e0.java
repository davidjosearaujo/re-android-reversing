package a6;

import i5.e;
import i5.f;

/* loaded from: classes.dex */
public final class e0 {
    public static final Object a(long j5, i5.d dVar) {
        if (j5 <= 0) {
            return f5.g.f4141a;
        }
        h hVar = new h(1, q2.a.A(dVar));
        hVar.u();
        if (j5 < Long.MAX_VALUE) {
            b(hVar.f296j).J(j5, hVar);
        }
        Object t5 = hVar.t();
        return t5 == Kotlin_1.a.f4591f ? t5 : f5.g.f4141a;
    }

    public static final d0 b(i5.f fVar) {
        int i7 = i5.e.f4485c;
        f.b e = fVar.e(e.a.f4486f);
        d0 d0Var = e instanceof d0 ? (d0) e : null;
        return d0Var == null ? c0.f287a : d0Var;
    }
}
