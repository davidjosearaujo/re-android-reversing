package g5;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class d<K, V> implements Map<K, V>, s5.a {

    /* loaded from: classes.dex */
    public static final class a extends r5.i implements q5.l<Map.Entry<? extends K, ? extends V>, CharSequence> {

        /* renamed from: g */
        public final /* synthetic */ d<K, V> f4276g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(d<K, ? extends V> dVar) {
            super(1);
            this.f4276g = dVar;
        }

        @Override // q5.l
        public final CharSequence k(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            r5.h.f(entry, "it");
            d<K, V> dVar = this.f4276g;
            dVar.getClass();
            StringBuilder sb = new StringBuilder();
            Object key = entry.getKey();
            sb.append(key == dVar ? "(this Map)" : String.valueOf(key));
            sb.append('=');
            Object value = entry.getValue();
            sb.append(value != dVar ? String.valueOf(value) : "(this Map)");
            return sb.toString();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> entrySet = entrySet();
        if (entrySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            if (r5.h.a(((Map.Entry) it.next()).getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return new r.d((r.b) this);
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x005a A[SYNTHETIC] */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L4
            return r0
        L4:
            boolean r1 = r6 instanceof java.util.Map
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            r1 = r5
            r.b r1 = (r.b) r1
            int r1 = r1.f5675g
            java.util.Map r6 = (java.util.Map) r6
            int r3 = r6.size()
            if (r1 == r3) goto L18
            return r2
        L18:
            java.util.Set r6 = r6.entrySet()
            boolean r1 = r6 instanceof java.util.Collection
            if (r1 == 0) goto L27
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L27
            goto L5b
        L27:
            java.util.Iterator r6 = r6.iterator()
        L2b:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L5b
            java.lang.Object r1 = r6.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            if (r1 != 0) goto L3b
        L39:
            r1 = r2
            goto L58
        L3b:
            java.lang.Object r3 = r1.getKey()
            java.lang.Object r1 = r1.getValue()
            java.lang.Object r4 = r5.get(r3)
            boolean r1 = r5.h.a(r1, r4)
            if (r1 != 0) goto L4e
            goto L39
        L4e:
            if (r4 != 0) goto L57
            boolean r1 = r5.containsKey(r3)
            if (r1 != 0) goto L57
            goto L39
        L57:
            r1 = r0
        L58:
            if (r1 != 0) goto L2b
            r0 = r2
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.d.equals(java.lang.Object):boolean");
    }

    @Override // java.util.Map
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return ((r.b) this).f5675g == 0;
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return new r.f((r.b) this);
    }

    @Override // java.util.Map
    public final V put(K k6, V v6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return ((r.b) this).f5675g;
    }

    public final String toString() {
        return n.Z(entrySet(), ", ", "{", "}", new a(this), 24);
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return new r.h((r.b) this);
    }
}
