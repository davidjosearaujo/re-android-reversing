package f3;

import java.util.ArrayList;
import p2.k;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f4129a = new ArrayList();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<T> f4130a;

        /* renamed from: b  reason: collision with root package name */
        public final k<T> f4131b;

        public a(Class<T> cls, k<T> kVar) {
            this.f4130a = cls;
            this.f4131b = kVar;
        }
    }

    public final synchronized <Z> k<Z> a(Class<Z> cls) {
        int size = this.f4129a.size();
        for (int i7 = 0; i7 < size; i7++) {
            a aVar = (a) this.f4129a.get(i7);
            if (aVar.f4130a.isAssignableFrom(cls)) {
                return (k<Z>) aVar.f4131b;
            }
        }
        return null;
    }
}
