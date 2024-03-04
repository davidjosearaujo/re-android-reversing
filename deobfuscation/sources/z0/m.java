package z0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a */
    public p f6885a;

    /* renamed from: b */
    public ArrayList<p> f6886b = new ArrayList<>();

    public m(p pVar) {
        this.f6885a = null;
        this.f6885a = pVar;
    }

    public static long a(f fVar, long j5) {
        p pVar = fVar.f6875d;
        if (pVar instanceof k) {
            return j5;
        }
        int size = fVar.f6881k.size();
        long j7 = j5;
        for (int i7 = 0; i7 < size; i7++) {
            d dVar = (d) fVar.f6881k.get(i7);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f6875d != pVar) {
                    j7 = Math.min(j7, a(fVar2, fVar2.f6876f + j5));
                }
            }
        }
        if (fVar == pVar.f6901i) {
            long j8 = j5 - pVar.j();
            return Math.min(Math.min(j7, a(pVar.f6900h, j8)), j8 - pVar.f6900h.f6876f);
        }
        return j7;
    }

    public static long b(f fVar, long j5) {
        p pVar = fVar.f6875d;
        if (pVar instanceof k) {
            return j5;
        }
        int size = fVar.f6881k.size();
        long j7 = j5;
        for (int i7 = 0; i7 < size; i7++) {
            d dVar = (d) fVar.f6881k.get(i7);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f6875d != pVar) {
                    j7 = Math.max(j7, b(fVar2, fVar2.f6876f + j5));
                }
            }
        }
        if (fVar == pVar.f6900h) {
            long j8 = j5 + pVar.j();
            return Math.max(Math.max(j7, b(pVar.f6901i, j8)), j8 - pVar.f6901i.f6876f);
        }
        return j7;
    }
}
