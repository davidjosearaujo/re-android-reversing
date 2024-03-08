package o0;

import l0.d;
import l0.i0;
import l0.o;
import q5.l;
import r5.h;
import x.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k {
    public static final j a(o oVar, boolean z6) {
        h.f(oVar, "layoutNode");
        a.b bVar = oVar.s.f4886d;
        i0 i0Var = null;
        if ((bVar.f6421b & 8) != 0) {
            loop0: while (true) {
                if (bVar == null) {
                    break;
                }
                bVar.getClass();
                if (false && true) {
                    for (a.b bVar2 = bVar; bVar2 != null; bVar2 = null) {
                        if (bVar2 instanceof i0) {
                            i0Var = bVar2;
                            break loop0;
                        }
                        bVar2.getClass();
                        if ((false & true) && (bVar2 instanceof d)) {
                            d dVar = (d) bVar2;
                        }
                    }
                }
                if ((bVar.f6421b & 8) == 0) {
                    break;
                }
                bVar = null;
                bVar.getClass();
            }
        }
        h.c(i0Var);
        a.b a7 = i0Var.a();
        f b2 = oVar.b();
        h.c(b2);
        return new j(a7, z6, oVar, b2);
    }

    public static final o b(o oVar, l<? super o, Boolean> lVar) {
        h.f(oVar, "<this>");
        do {
            oVar = oVar.c();
            if (oVar == null) {
                return null;
            }
        } while (!lVar.k(oVar).booleanValue());
        return oVar;
    }

    public static final i0 c(o oVar) {
        h.f(oVar, "<this>");
        a.b bVar = oVar.s.f4886d;
        if ((bVar.f6421b & 8) != 0) {
            while (bVar != null) {
                bVar.getClass();
                if (false && true) {
                    for (a.b bVar2 = bVar; bVar2 != null; bVar2 = null) {
                        if (bVar2 instanceof i0) {
                            i0 i0Var = (i0) bVar2;
                        } else {
                            bVar2.getClass();
                            if ((false & true) && (bVar2 instanceof d)) {
                                d dVar = (d) bVar2;
                            }
                        }
                    }
                }
                if ((bVar.f6421b & 8) == 0) {
                    break;
                }
                bVar = null;
                bVar.getClass();
            }
        }
        return null;
    }
}
