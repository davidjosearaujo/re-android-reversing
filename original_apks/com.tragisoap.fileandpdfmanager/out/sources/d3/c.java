package d3;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f3562a = new ArrayList();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<Z> f3563a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<R> f3564b;

        /* renamed from: c  reason: collision with root package name */
        public final b<Z, R> f3565c;

        public a(Class<Z> cls, Class<R> cls2, b<Z, R> bVar) {
            this.f3563a = cls;
            this.f3564b = cls2;
            this.f3565c = bVar;
        }
    }

    public final synchronized ArrayList a(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator it = this.f3562a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if ((aVar.f3563a.isAssignableFrom(cls) && cls2.isAssignableFrom(aVar.f3564b)) && !arrayList.contains(aVar.f3564b)) {
                arrayList.add(aVar.f3564b);
            }
        }
        return arrayList;
    }
}
