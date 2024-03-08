package r;

import g5.d;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class b<K, V> extends d<K, V> {

    /* renamed from: f */
    public final i<K, V> f5674f;

    /* renamed from: g */
    public final int f5675g;

    static {
        new b(i.f5682d, 0);
    }

    public b(i<K, V> iVar, int i7) {
        h.f(iVar, "node");
        this.f5674f = iVar;
        this.f5675g = i7;
    }

    @Override // java.util.Map
    public boolean containsKey(K k6) {
        return this.f5674f.b(k6 != null ? k6.hashCode() : 0, 0, k6);
    }

    @Override // java.util.Map
    public V get(K k6) {
        return (V) this.f5674f.d(k6 != null ? k6.hashCode() : 0, 0, k6);
    }
}
