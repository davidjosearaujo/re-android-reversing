package o0;

import l0.i0;
import x.a;

/* loaded from: classes.dex */
public final class k {
    public static final j a(l0.o oVar, boolean z6) {
        r5.h.f(oVar, "layoutNode");
        a.b bVar = oVar.s.f4886d;
        i0 i0Var = null;
        if ((bVar.f6421b & 8) != 0) {
            loop0: while (true) {
                if (bVar == null) {
                    break;
                }
                bVar.getClass();
                if (false & true) {
                    for (a.b bVar2 = bVar; bVar2 != null; bVar2 = null) {
                        if (bVar2 instanceof i0) {
                            i0Var = bVar2;
                            break loop0;
                        }
                        bVar2.getClass();
                        if ((false & true) && (bVar2 instanceof l0.d)) {
                            l0.d dVar = (l0.d) bVar2;
                        }
                    }
                }
                if ((bVar.f6421b & 8) == 0) {
                    break;
                }
                bVar.getClass();
                bVar = null;
            }
        }
        r5.h.c(i0Var);
        a.b a7 = i0Var.a();
        f b2 = oVar.b();
        r5.h.c(b2);
        return new j(a7, z6, oVar, b2);
    }

    public static final l0.o b(l0.o oVar, q5.l<? super l0.o, Boolean> lVar) {
        r5.h.f(oVar, "<this>");
        do {
            oVar = oVar.c();
            if (oVar == null) {
                return null;
            }
        } while (!lVar.k(oVar).booleanValue());
        return oVar;
    }

    public static final i0 c(l0.o oVar) {
        r5.h.f(oVar, "<this>");
        a.b bVar = oVar.s.f4886d;
        if ((bVar.f6421b & 8) != 0) {
            while (bVar != null) {
                bVar.getClass();
                if (false & true) {
                    for (a.b bVar2 = bVar; bVar2 != null; bVar2 = null) {
                        if (bVar2 instanceof i0) {
                            i0 i0Var = (i0) bVar2;
                        } else {
                            bVar2.getClass();
                            if ((false & true) && (bVar2 instanceof l0.d)) {
                                l0.d dVar = (l0.d) bVar2;
                            }
                        }
                    }
                }
                if ((bVar.f6421b & 8) == 0) {
                    break;
                }
                bVar.getClass();
                bVar = null;
            }
        }
        return null;
    }
}
