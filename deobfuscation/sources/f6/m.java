package f6;

import a6.b1;
import androidx.fragment.app.s0;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a */
    public static final b1 f4172a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [y5.a] */
    static {
        String str;
        Object next;
        b1 b2;
        int i7 = u.f4181a;
        try {
            str = System.getProperty("kotlinx.coroutines.fast.service.loader");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str != null) {
            Boolean.parseBoolean(str);
        }
        Iterator k6 = s0.k();
        r5.h.f(k6, "<this>");
        y5.g gVar = new y5.g(k6);
        if (!(gVar instanceof y5.a)) {
            gVar = new y5.a(gVar);
        }
        List<? extends l> O = y5.l.O(gVar);
        Iterator it = O.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int c7 = ((l) next).c();
                do {
                    Object next2 = it.next();
                    int c8 = ((l) next2).c();
                    if (c7 < c8) {
                        next = next2;
                        c7 = c8;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        l lVar = (l) next;
        if (lVar == null || (b2 = lVar.b(O)) == null) {
            throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
        }
        f4172a = b2;
    }
}
