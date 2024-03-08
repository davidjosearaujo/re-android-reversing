package g5;

import f5.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class u extends t {
    public static final Map X(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return q.f4285f;
        }
        if (size != 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(t.V(arrayList.size()));
            Y(arrayList, linkedHashMap);
            return linkedHashMap;
        }
        c cVar = (c) arrayList.get(0);
        h.f(cVar, "pair");
        Map singletonMap = Collections.singletonMap(cVar.f4135f, cVar.f4136g);
        h.e(singletonMap, "singletonMap(...)");
        return singletonMap;
    }

    public static final void Y(ArrayList arrayList, LinkedHashMap linkedHashMap) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            linkedHashMap.put(cVar.f4135f, cVar.f4136g);
        }
    }
}
