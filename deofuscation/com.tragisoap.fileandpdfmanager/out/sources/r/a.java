package r;

import java.util.Map;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class a<K, V> implements Map.Entry<K, V>, s5.a {

    /* renamed from: f  reason: collision with root package name */
    public final K f5672f;

    /* renamed from: g  reason: collision with root package name */
    public final V f5673g;

    public a(K k6, V v6) {
        this.f5672f = k6;
        this.f5673g = v6;
    }

    @Override // java.util.Map.Entry, java.lang.Object
    public final boolean equals(Object obj) {
        Map.Entry entry = obj instanceof Map.Entry ? (Map.Entry) obj : null;
        return entry != null && h.a(entry.getKey(), this.f5672f) && h.a(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f5672f;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.f5673g;
    }

    @Override // java.util.Map.Entry, java.lang.Object
    public final int hashCode() {
        K k6 = this.f5672f;
        int i7 = 0;
        int hashCode = k6 != null ? k6.hashCode() : 0;
        V value = getValue();
        if (value != null) {
            i7 = value.hashCode();
        }
        return hashCode ^ i7;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5672f);
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
