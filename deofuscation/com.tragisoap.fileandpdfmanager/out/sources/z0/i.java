package z0;

import java.util.ArrayList;
import y0.c;
import y0.d;
import y0.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i {
    public static o a(d dVar, int i7, ArrayList<o> arrayList, o oVar) {
        c cVar;
        int i8;
        int i9 = i7 == 0 ? dVar.f6541q0 : dVar.f6543r0;
        int i10 = 0;
        if (i9 != -1 && (oVar == null || i9 != oVar.f6891b)) {
            int i11 = 0;
            while (true) {
                if (i11 >= arrayList.size()) {
                    break;
                }
                o oVar2 = arrayList.get(i11);
                if (oVar2.f6891b == i9) {
                    if (oVar != null) {
                        oVar.d(i7, oVar2);
                        arrayList.remove(oVar);
                    }
                    oVar = oVar2;
                } else {
                    i11++;
                }
            }
        } else if (i9 != -1) {
            return oVar;
        }
        if (oVar == null) {
            if (dVar instanceof y0.i) {
                y0.i iVar = (y0.i) dVar;
                int i12 = 0;
                while (true) {
                    if (i12 >= iVar.f6584t0) {
                        i8 = -1;
                        break;
                    }
                    d dVar2 = iVar.f6583s0[i12];
                    if ((i7 == 0 && (i8 = dVar2.f6541q0) != -1) || (i7 == 1 && (i8 = dVar2.f6543r0) != -1)) {
                        break;
                    }
                    i12++;
                }
                if (i8 != -1) {
                    int i13 = 0;
                    while (true) {
                        if (i13 >= arrayList.size()) {
                            break;
                        }
                        o oVar3 = arrayList.get(i13);
                        if (oVar3.f6891b == i8) {
                            oVar = oVar3;
                            break;
                        }
                        i13++;
                    }
                }
            }
            if (oVar == null) {
                oVar = new o(i7);
            }
            arrayList.add(oVar);
        }
        if (oVar.a(dVar)) {
            if (dVar instanceof g) {
                g gVar = (g) dVar;
                c cVar2 = gVar.f6580v0;
                if (gVar.f6581w0 == 0) {
                    i10 = 1;
                }
                cVar2.c(i10, oVar, arrayList);
            }
            if (i7 == 0) {
                dVar.f6541q0 = oVar.f6891b;
                dVar.K.c(i7, oVar, arrayList);
                cVar = dVar.M;
            } else {
                dVar.f6543r0 = oVar.f6891b;
                dVar.L.c(i7, oVar, arrayList);
                dVar.O.c(i7, oVar, arrayList);
                cVar = dVar.N;
            }
            cVar.c(i7, oVar, arrayList);
            dVar.R.c(i7, oVar, arrayList);
        }
        return oVar;
    }

    public static boolean b(int i7, int i8, int i9, int i10) {
        return (i9 == 1 || i9 == 2 || (i9 == 4 && i7 != 2)) || (i10 == 1 || i10 == 2 || (i10 == 4 && i8 != 2));
    }
}
