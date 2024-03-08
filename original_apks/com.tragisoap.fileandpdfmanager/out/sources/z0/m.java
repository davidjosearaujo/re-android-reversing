package z0;

import java.util.ArrayList;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class m {

    /* renamed from: a */
    public p f6885a;

    /* renamed from: b */
    public ArrayList<p> f6886b = new ArrayList<>();

    public m(p pVar) {
        this.f6885a = null;
        this.f6885a = pVar;
    }

    public static long a(f fVar, long j7) {
        p pVar = fVar.f6875d;
        if (pVar instanceof k) {
            return j7;
        }
        int size = fVar.f6881k.size();
        long j8 = j7;
        for (int i7 = 0; i7 < size; i7++) {
            d dVar = (d) fVar.f6881k.get(i7);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f6875d != pVar) {
                    j8 = Math.min(j8, a(fVar2, ((long) fVar2.f6876f) + j7));
                }
            }
        }
        if (fVar != pVar.f6901i) {
            return j8;
        }
        long j9 = j7 - pVar.j();
        return Math.min(Math.min(j8, a(pVar.f6900h, j9)), j9 - ((long) pVar.f6900h.f6876f));
    }

    public static long b(f fVar, long j7) {
        p pVar = fVar.f6875d;
        if (pVar instanceof k) {
            return j7;
        }
        int size = fVar.f6881k.size();
        long j8 = j7;
        for (int i7 = 0; i7 < size; i7++) {
            d dVar = (d) fVar.f6881k.get(i7);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f6875d != pVar) {
                    j8 = Math.max(j8, b(fVar2, ((long) fVar2.f6876f) + j7));
                }
            }
        }
        if (fVar != pVar.f6900h) {
            return j8;
        }
        long j9 = j7 + pVar.j();
        return Math.max(Math.max(j8, b(pVar.f6901i, j9)), j9 - ((long) pVar.f6901i.f6876f));
    }
}
