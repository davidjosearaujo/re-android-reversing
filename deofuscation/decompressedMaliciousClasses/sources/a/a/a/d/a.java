package a.a.a.d;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class a<K, V> extends h<K, V> implements Map<K, V> {
    f<K, V> h;

    /* renamed from: a.a.a.d.a$a */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class C0001a extends f<K, V> {
        C0001a() {
            a.this = r1;
        }

        @Override // a.a.a.d.f
        protected void a() {
            a.this.clear();
        }

        @Override // a.a.a.d.f
        protected Object b(int i, int i2) {
            return a.this.f105b[(i << 1) + i2];
        }

        @Override // a.a.a.d.f
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // a.a.a.d.f
        protected int d() {
            return a.this.c;
        }

        @Override // a.a.a.d.f
        protected int e(Object obj) {
            return a.this.e(obj);
        }

        @Override // a.a.a.d.f
        protected int f(Object obj) {
            return a.this.g(obj);
        }

        @Override // a.a.a.d.f
        protected void g(K k, V v) {
            a.this.put(k, v);
        }

        @Override // a.a.a.d.f
        protected void h(int i) {
            a.this.j(i);
        }

        @Override // a.a.a.d.f
        protected V i(int i, V v) {
            return a.this.k(i, v);
        }
    }

    private f<K, V> m() {
        if (this.h == null) {
            this.h = new C0001a();
        }
        return this.h;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m().m();
    }

    public boolean n(Collection<?> collection) {
        return f.p(this, collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        b(this.c + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m().n();
    }
}
