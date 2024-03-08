package f3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p2.j;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f4124a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f4125b = new HashMap();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<T> f4126a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<R> f4127b;

        /* renamed from: c  reason: collision with root package name */
        public final j<T, R> f4128c;

        public a(Class<T> cls, Class<R> cls2, j<T, R> jVar) {
            this.f4126a = cls;
            this.f4127b = cls2;
            this.f4128c = jVar;
        }
    }

    public final synchronized List<a<?, ?>> a(String str) {
        List<a<?, ?>> list;
        if (!this.f4124a.contains(str)) {
            this.f4124a.add(str);
        }
        list = (List) this.f4125b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f4125b.put(str, list);
        }
        return list;
    }

    public final synchronized ArrayList b(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f4124a.iterator();
        while (it.hasNext()) {
            List<a> list = (List) this.f4125b.get((String) it.next());
            if (list != null) {
                for (a aVar : list) {
                    if ((aVar.f4126a.isAssignableFrom(cls) && cls2.isAssignableFrom(aVar.f4127b)) && !arrayList.contains(aVar.f4127b)) {
                        arrayList.add(aVar.f4127b);
                    }
                }
            }
        }
        return arrayList;
    }
}
