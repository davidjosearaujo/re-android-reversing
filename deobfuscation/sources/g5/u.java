package g5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class u extends t {
    public static final Map X(ArrayList arrayList) {
        int size = arrayList.size();
        if (size != 0) {
            if (size != 1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(t.V(arrayList.size()));
                Y(arrayList, linkedHashMap);
                return linkedHashMap;
            }
            f5.c cVar = (f5.c) arrayList.get(0);
            r5.h.f(cVar, "pair");
            Map singletonMap = Collections.singletonMap(cVar.f4135f, cVar.f4136g);
            r5.h.e(singletonMap, "singletonMap(...)");
            return singletonMap;
        }
        return q.f4285f;
    }

    public static final void Y(ArrayList arrayList, LinkedHashMap linkedHashMap) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f5.c cVar = (f5.c) it.next();
            linkedHashMap.put(cVar.f4135f, cVar.f4136g);
        }
    }
}
