package r;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class d<K, V> extends g5.f<Map.Entry<? extends K, ? extends V>> {

    /* renamed from: f */
    public final b<K, V> f5679f;

    public d(b<K, V> bVar) {
        r5.h.f(bVar, "map");
        this.f5679f = bVar;
    }

    @Override // g5.a
    public final int a() {
        b<K, V> bVar = this.f5679f;
        bVar.getClass();
        return bVar.f5675g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g5.a, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            r5.h.f(entry, "element");
            Object obj2 = this.f5679f.get(entry.getKey());
            return obj2 != null ? r5.h.a(obj2, entry.getValue()) : entry.getValue() == null && this.f5679f.containsKey(entry.getKey());
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new e(this.f5679f.f5674f);
    }
}
