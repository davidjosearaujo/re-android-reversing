package l;

import androidx.activity.h;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: f */
    public c<K, V> f4829f;

    /* renamed from: g */
    public c<K, V> f4830g;

    /* renamed from: h */
    public final WeakHashMap<f<K, V>, Boolean> f4831h = new WeakHashMap<>();

    /* renamed from: i */
    public int f4832i = 0;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // l.b.e
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.f4836i;
        }

        @Override // l.b.e
        public final c<K, V> c(c<K, V> cVar) {
            return cVar.f4835h;
        }
    }

    /* renamed from: l.b$b */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0075b<K, V> extends e<K, V> {
        public C0075b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // l.b.e
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.f4835h;
        }

        @Override // l.b.e
        public final c<K, V> c(c<K, V> cVar) {
            return cVar.f4836i;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: f */
        public final K f4833f;

        /* renamed from: g */
        public final V f4834g;

        /* renamed from: h */
        public c<K, V> f4835h;

        /* renamed from: i */
        public c<K, V> f4836i;

        public c(K k6, V v6) {
            this.f4833f = k6;
            this.f4834g = v6;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f4833f.equals(cVar.f4833f) && this.f4834g.equals(cVar.f4834g);
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f4833f;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f4834g;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public final int hashCode() {
            return this.f4834g.hashCode() ^ this.f4833f.hashCode();
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v6) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        @Override // java.lang.Object
        public final String toString() {
            return this.f4833f + "=" + this.f4834g;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: f */
        public c<K, V> f4837f;

        /* renamed from: g */
        public boolean f4838g = true;

        public d() {
            b.this = r1;
        }

        @Override // l.b.f
        public final void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f4837f;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f4836i;
                this.f4837f = cVar3;
                this.f4838g = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f4838g) {
                return b.this.f4829f != null;
            }
            c<K, V> cVar = this.f4837f;
            return (cVar == null || cVar.f4835h == null) ? false : true;
        }

        @Override // java.util.Iterator
        public final Object next() {
            c<K, V> cVar;
            if (this.f4838g) {
                this.f4838g = false;
                cVar = b.this.f4829f;
            } else {
                c<K, V> cVar2 = this.f4837f;
                cVar = cVar2 != null ? cVar2.f4835h : null;
            }
            this.f4837f = cVar;
            return cVar;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: f */
        public c<K, V> f4840f;

        /* renamed from: g */
        public c<K, V> f4841g;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f4840f = cVar2;
            this.f4841g = cVar;
        }

        @Override // l.b.f
        public final void a(c<K, V> cVar) {
            c<K, V> cVar2 = null;
            if (this.f4840f == cVar && cVar == this.f4841g) {
                this.f4841g = null;
                this.f4840f = null;
            }
            c<K, V> cVar3 = this.f4840f;
            if (cVar3 == cVar) {
                this.f4840f = b(cVar3);
            }
            c<K, V> cVar4 = this.f4841g;
            if (cVar4 == cVar) {
                c<K, V> cVar5 = this.f4840f;
                if (!(cVar4 == cVar5 || cVar5 == null)) {
                    cVar2 = c(cVar4);
                }
                this.f4841g = cVar2;
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f4841g != null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            c<K, V> cVar = this.f4841g;
            c<K, V> cVar2 = this.f4840f;
            this.f4841g = (cVar == cVar2 || cVar2 == null) ? null : c(cVar);
            return cVar;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class f<K, V> {
        public abstract void a(c<K, V> cVar);
    }

    public c<K, V> a(K k6) {
        c<K, V> cVar = this.f4829f;
        while (cVar != null && !cVar.f4833f.equals(k6)) {
            cVar = cVar.f4835h;
        }
        return cVar;
    }

    public V b(K k6) {
        c<K, V> a7 = a(k6);
        if (a7 == null) {
            return null;
        }
        this.f4832i--;
        if (!this.f4831h.isEmpty()) {
            for (f<K, V> fVar : this.f4831h.keySet()) {
                fVar.a(a7);
            }
        }
        c<K, V> cVar = a7.f4836i;
        c<K, V> cVar2 = a7.f4835h;
        if (cVar != null) {
            cVar.f4835h = cVar2;
        } else {
            this.f4829f = cVar2;
        }
        c<K, V> cVar3 = a7.f4835h;
        if (cVar3 != null) {
            cVar3.f4836i = cVar;
        } else {
            this.f4830g = cVar;
        }
        a7.f4835h = null;
        a7.f4836i = null;
        return a7.f4834g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r1.hasNext() != false) goto L_0x0053;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (((l.b.e) r6).hasNext() != false) goto L_0x0053;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
        return true;
     */
    @Override // java.lang.Object
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
            boolean r1 = r6 instanceof l.b
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            l.b r6 = (l.b) r6
            int r1 = r5.f4832i
            int r3 = r6.f4832i
            if (r1 == r3) goto L_0x0013
            return r2
        L_0x0013:
            java.util.Iterator r5 = r5.iterator()
            java.util.Iterator r6 = r6.iterator()
        L_0x001b:
            r1 = r5
            l.b$e r1 = (l.b.e) r1
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0044
            r3 = r6
            l.b$e r3 = (l.b.e) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0044
            java.lang.Object r1 = r1.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r3 = r3.next()
            if (r1 != 0) goto L_0x003b
            if (r3 != 0) goto L_0x0043
        L_0x003b:
            if (r1 == 0) goto L_0x001b
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x001b
        L_0x0043:
            return r2
        L_0x0044:
            boolean r5 = r1.hasNext()
            if (r5 != 0) goto L_0x0053
            l.b$e r6 = (l.b.e) r6
            boolean r5 = r6.hasNext()
            if (r5 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r0 = r2
        L_0x0054:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l.b.equals(java.lang.Object):boolean");
    }

    @Override // java.lang.Object
    public final int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i7 = 0;
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return i7;
            }
            i7 += ((Map.Entry) eVar.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f4829f, this.f4830g);
        this.f4831h.put(aVar, Boolean.FALSE);
        return aVar;
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder d7 = h.d("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (true) {
            e eVar = (e) it;
            if (eVar.hasNext()) {
                d7.append(((Map.Entry) eVar.next()).toString());
                if (eVar.hasNext()) {
                    d7.append(", ");
                }
            } else {
                d7.append("]");
                return d7.toString();
            }
        }
    }
}
