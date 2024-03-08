package u;

import androidx.compose.ui.platform.s;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import q5.a;
import q5.l;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final l<Object, Boolean> f6066a = s.f1237g;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedHashMap f6067b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedHashMap f6068c;

    public b(LinkedHashMap linkedHashMap) {
        this.f6067b = linkedHashMap != null ? new LinkedHashMap(linkedHashMap) : new LinkedHashMap();
        this.f6068c = new LinkedHashMap();
    }

    @Override // u.a
    public final Map<String, List<Object>> a() {
        LinkedHashMap linkedHashMap = this.f6067b;
        h.f(linkedHashMap, "<this>");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        for (Map.Entry entry : this.f6068c.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.size() == 1) {
                Object d7 = ((a) list.get(0)).d();
                if (d7 == null) {
                    continue;
                } else if (this.f6066a.k(d7).booleanValue()) {
                    linkedHashMap2.put(str, q2.a.e(d7));
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i7 = 0; i7 < size; i7++) {
                    Object d8 = ((a) list.get(i7)).d();
                    if (d8 == null || this.f6066a.k(d8).booleanValue()) {
                        arrayList.add(d8);
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                }
                linkedHashMap2.put(str, arrayList);
            }
        }
        return linkedHashMap2;
    }
}
