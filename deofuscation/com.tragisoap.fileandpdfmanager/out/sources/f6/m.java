package f6;

import a6.b1;
import androidx.fragment.app.s0;
import java.util.Iterator;
import java.util.List;
import r5.h;
import y5.a;
import y5.g;
import y5.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class m {

    /* renamed from: a */
    public static final b1 f4172a;

    static {
        String str;
        Object obj;
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
        h.f(k6, "<this>");
        g gVar = new g(k6);
        List<? extends l> O = l.O(gVar instanceof a ? gVar : new a(gVar));
        Iterator it = O.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            obj = it.next();
            if (it.hasNext()) {
                int c7 = ((l) obj).c();
                do {
                    Object next = it.next();
                    int c8 = ((l) next).c();
                    if (c7 < c8) {
                        obj = next;
                        c7 = c8;
                    }
                } while (it.hasNext());
            }
        }
        l lVar = (l) obj;
        if (lVar == null || (b2 = lVar.b(O)) == null) {
            throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
        }
        f4172a = b2;
    }
}
