package y5;

import g5.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class l extends j {
    public static final <T> List<T> O(d<? extends T> dVar) {
        Iterator<? extends T> it = dVar.iterator();
        if (!it.hasNext()) {
            return p.f4284f;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return a.G(next);
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(next);
            if (!it.hasNext()) {
                return arrayList;
            }
            next = it.next();
        }
    }
}
