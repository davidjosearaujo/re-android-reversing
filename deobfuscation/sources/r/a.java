package r;

import java.util.Map;

/* loaded from: classes.dex */
public class a<K, V> implements Map.Entry<K, V>, s5.a {

    /* renamed from: f */
    public final K f5672f;

    /* renamed from: g */
    public final V f5673g;

    public a(K k6, V v6) {
        this.f5672f = k6;
        this.f5673g = v6;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        Map.Entry entry = obj instanceof Map.Entry ? (Map.Entry) obj : null;
        return entry != null && r5.h.a(entry.getKey(), this.f5672f) && r5.h.a(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f5672f;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.f5673g;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        K k6 = this.f5672f;
        int hashCode = k6 != null ? k6.hashCode() : 0;
        V value = getValue();
        return hashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public V setValue(V v6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5672f);
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
