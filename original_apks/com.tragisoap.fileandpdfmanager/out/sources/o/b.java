package o;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import o.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class b<K, V> extends h<K, V> implements Map<K, V> {
    public a m;

    public b() {
    }

    public b(b bVar) {
        if (bVar != null) {
            i(bVar);
        }
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.m == null) {
            this.m = new a(this);
        }
        a aVar = this.m;
        if (aVar.f5200a == null) {
            aVar.f5200a = new g.b();
        }
        return aVar.f5200a;
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        if (this.m == null) {
            this.m = new a(this);
        }
        a aVar = this.m;
        if (aVar.f5201b == null) {
            aVar.f5201b = new g.c();
        }
        return aVar.f5201b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        b(map.size() + this.f5221h);
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        if (this.m == null) {
            this.m = new a(this);
        }
        a aVar = this.m;
        if (aVar.f5202c == null) {
            aVar.f5202c = new g.e();
        }
        return aVar.f5202c;
    }
}
