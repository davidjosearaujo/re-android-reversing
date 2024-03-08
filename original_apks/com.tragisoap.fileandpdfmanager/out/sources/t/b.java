package t;

import p.b;
import p.d0;
import p.e0;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b {
    public static final int a(int i7, int i8) {
        return i7 << (((i8 % 10) * 3) + 1);
    }

    public static final a b(p.b bVar, int i7, i iVar) {
        a aVar;
        h.f(bVar, "composer");
        bVar.d(i7);
        Object f7 = bVar.f();
        if (f7 == b.a.f5423a) {
            aVar = new a(i7, true);
            bVar.j(aVar);
        } else {
            h.d(f7, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaImpl");
            aVar = (a) f7;
        }
        aVar.c(iVar);
        bVar.l();
        return aVar;
    }

    public static final a c(int i7, boolean z6, i iVar) {
        a aVar = new a(i7, z6);
        aVar.c(iVar);
        return aVar;
    }

    public static final boolean d(d0 d0Var, d0 d0Var2) {
        if (d0Var != null) {
            if (!(d0Var instanceof e0) || !(d0Var2 instanceof e0)) {
                return false;
            }
            ((e0) d0Var).getClass();
        }
        return true;
    }
}
