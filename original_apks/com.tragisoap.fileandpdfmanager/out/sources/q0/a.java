package q0;

import a6.a0;
import f5.g;
import g5.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import r5.h;
import r5.v;
import s5.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a<K, V> {

    /* renamed from: a */
    public final a0 f5612a = new a0();

    /* renamed from: b */
    public final HashMap<K, V> f5613b = new HashMap<>(0, 0.75f);

    /* renamed from: c */
    public final LinkedHashSet<K> f5614c = new LinkedHashSet<>();

    /* renamed from: d */
    public int f5615d;
    public int e;

    /* renamed from: f */
    public int f5616f;

    public final V a(K k6) {
        synchronized (this.f5612a) {
            V v6 = this.f5613b.get(k6);
            if (v6 != null) {
                this.f5614c.remove(k6);
                this.f5614c.add(k6);
                this.e++;
                return v6;
            }
            this.f5616f++;
            return null;
        }
    }

    public final V b(K k6, V v6) {
        V put;
        V v7;
        Object obj;
        if (k6 == null || v6 == null) {
            throw null;
        }
        synchronized (this.f5612a) {
            this.f5615d = d() + 1;
            put = this.f5613b.put(k6, v6);
            if (put != null) {
                this.f5615d = d() - 1;
            }
            if (this.f5614c.contains(k6)) {
                this.f5614c.remove(k6);
            }
            this.f5614c.add(k6);
        }
        while (true) {
            synchronized (this.f5612a) {
                if (d() < 0 || ((this.f5613b.isEmpty() && d() != 0) || this.f5613b.isEmpty() != this.f5614c.isEmpty())) {
                    break;
                }
                if (d() <= 16 || this.f5613b.isEmpty()) {
                    obj = null;
                    v7 = null;
                } else {
                    LinkedHashSet<K> linkedHashSet = this.f5614c;
                    h.f(linkedHashSet, "<this>");
                    if (linkedHashSet instanceof List) {
                        obj = n.W((List) linkedHashSet);
                    } else {
                        Iterator<T> it = linkedHashSet.iterator();
                        if (it.hasNext()) {
                            obj = it.next();
                        } else {
                            throw new NoSuchElementException("Collection is empty.");
                        }
                    }
                    v7 = this.f5613b.get(obj);
                    if (v7 != null) {
                        HashMap<K, V> hashMap = this.f5613b;
                        v.a(hashMap);
                        hashMap.remove(obj);
                        LinkedHashSet<K> linkedHashSet2 = this.f5614c;
                        if ((linkedHashSet2 instanceof s5.a) && !(linkedHashSet2 instanceof b)) {
                            v.c(linkedHashSet2, "kotlin.collections.MutableCollection");
                            throw null;
                        }
                        linkedHashSet2.remove(obj);
                        int d7 = d();
                        h.c(obj);
                        this.f5615d = d7 - 1;
                    } else {
                        throw new IllegalStateException("inconsistent state");
                    }
                }
                g gVar = g.f4141a;
            }
            if (obj == null && v7 == null) {
                return put;
            }
            h.c(obj);
            h.c(v7);
        }
        throw new IllegalStateException("map/keySet size inconsistency");
    }

    public final V c(K k6) {
        V remove;
        k6.getClass();
        synchronized (this.f5612a) {
            remove = this.f5613b.remove(k6);
            this.f5614c.remove(k6);
            if (remove != null) {
                this.f5615d = d() - 1;
            }
            g gVar = g.f4141a;
        }
        return remove;
    }

    public final int d() {
        int i7;
        synchronized (this.f5612a) {
            i7 = this.f5615d;
        }
        return i7;
    }

    public final String toString() {
        String str;
        synchronized (this.f5612a) {
            int i7 = this.e;
            int i8 = this.f5616f + i7;
            str = "LruCache[maxSize=16,hits=" + this.e + ",misses=" + this.f5616f + ",hitRate=" + (i8 != 0 ? (i7 * 100) / i8 : 0) + "%]";
        }
        return str;
    }
}
