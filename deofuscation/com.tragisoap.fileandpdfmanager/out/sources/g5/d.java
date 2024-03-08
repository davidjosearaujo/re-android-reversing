package g5;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import q5.l;
import r.b;
import r.f;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class d<K, V> implements Map<K, V>, s5.a {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends i implements l<Map.Entry<? extends K, ? extends V>, CharSequence> {

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
            h.f(entry, "it");
            d<K, V> dVar = this.f4276g;
            dVar.getClass();
            StringBuilder sb = new StringBuilder();
            Object key = entry.getKey();
            String str = "(this Map)";
            sb.append(key == dVar ? str : String.valueOf(key));
            sb.append('=');
            Object value = entry.getValue();
            if (value != dVar) {
                str = String.valueOf(value);
            }
            sb.append(str);
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
            if (h.a(((Map.Entry) it.next()).getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return new r.d((b) this);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005a A[SYNTHETIC] */
    @Override // java.util.Map, java.lang.Object
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r6 instanceof java.util.Map
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            r1 = r5
            r.b r1 = (r.b) r1
            int r1 = r1.f5675g
            java.util.Map r6 = (java.util.Map) r6
            int r3 = r6.size()
            if (r1 == r3) goto L_0x0018
            return r2
        L_0x0018:
            java.util.Set r6 = r6.entrySet()
            boolean r1 = r6 instanceof java.util.Collection
            if (r1 == 0) goto L_0x0027
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L_0x0027
            goto L_0x005b
        L_0x0027:
            java.util.Iterator r6 = r6.iterator()
        L_0x002b:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x005b
            java.lang.Object r1 = r6.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            if (r1 != 0) goto L_0x003b
        L_0x0039:
            r1 = r2
            goto L_0x0058
        L_0x003b:
            java.lang.Object r3 = r1.getKey()
            java.lang.Object r1 = r1.getValue()
            java.lang.Object r4 = r5.get(r3)
            boolean r1 = r5.h.a(r1, r4)
            if (r1 != 0) goto L_0x004e
            goto L_0x0039
        L_0x004e:
            if (r4 != 0) goto L_0x0057
            boolean r1 = r5.containsKey(r3)
            if (r1 != 0) goto L_0x0057
            goto L_0x0039
        L_0x0057:
            r1 = r0
        L_0x0058:
            if (r1 != 0) goto L_0x002b
            r0 = r2
        L_0x005b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.d.equals(java.lang.Object):boolean");
    }

    @Override // java.util.Map, java.lang.Object
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return ((b) this).f5675g == 0;
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return new f((b) this);
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
        return ((b) this).f5675g;
    }

    @Override // java.lang.Object
    public final String toString() {
        return n.Z(entrySet(), ", ", "{", "}", new a(this), 24);
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return new r.h((b) this);
    }
}
