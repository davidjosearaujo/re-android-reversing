package a.a.a.d;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class f<K, V> {

    /* renamed from: a  reason: collision with root package name */
    f<K, V>.b f93a;

    /* renamed from: b  reason: collision with root package name */
    f<K, V>.c f94b;
    f<K, V>.e c;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    final class a<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f95a;

        /* renamed from: b  reason: collision with root package name */
        int f96b;
        int c;
        boolean d = false;

        a(int i) {
            this.f95a = i;
            this.f96b = f.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c < this.f96b;
        }

        @Override // java.util.Iterator
        public T next() {
            T t = (T) f.this.b(this.c, this.f95a);
            this.c++;
            this.d = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.d) {
                int i = this.c - 1;
                this.c = i;
                this.f96b--;
                this.d = false;
                f.this.h(i);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        public boolean a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            a((Map.Entry) obj);
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d = f.this.d();
            Iterator<? extends Map.Entry<K, V>> it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                f.this.g(entry.getKey(), entry.getValue());
            }
            return d != f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e = f.this.e(entry.getKey());
            if (e < 0) {
                return false;
            }
            return c.b(f.this.b(e, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Object
        public boolean equals(Object obj) {
            return f.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Object
        public int hashCode() {
            int i = 0;
            for (int d = f.this.d() - 1; d >= 0; d--) {
                Object b2 = f.this.b(d, 0);
                Object b3 = f.this.b(d, 1);
                i += (b2 == null ? 0 : b2.hashCode()) ^ (b3 == null ? 0 : b3.hashCode());
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return f.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return f.j(f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Object
        public boolean equals(Object obj) {
            return f.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Object
        public int hashCode() {
            int i = 0;
            for (int d = f.this.d() - 1; d >= 0; d--) {
                Object b2 = f.this.b(d, 0);
                i += b2 == null ? 0 : b2.hashCode();
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int e = f.this.e(obj);
            if (e < 0) {
                return false;
            }
            f.this.h(e);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return f.o(f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return f.p(f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return f.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) f.this.r(tArr, 0);
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        private static short[] $ = {31214, 31186, 31187, 31177, 31130, 31193, 31189, 31188, 31182, 31195, 31187, 31188, 31199, 31176, 31130, 31198, 31189, 31199, 31177, 31130, 31188, 31189, 31182, 31130, 31177, 31183, 31178, 31178, 31189, 31176, 31182, 31130, 31176, 31199, 31182, 31195, 31187, 31188, 31187, 31188, 31197, 31130, 31223, 31195, 31178, 31124, 31231, 31188, 31182, 31176, 31171, 31130, 31189, 31192, 31184, 31199, 31193, 31182, 31177, 22251, 22231, 22230, 22220, 22175, 22236, 22224, 22225, 22219, 22238, 22230, 22225, 22234, 22221, 22175, 22235, 22224, 22234, 22220, 22175, 22225, 22224, 22219, 22175, 22220, 22218, 22223, 22223, 22224, 22221, 22219, 22175, 22221, 22234, 22219, 22238, 22230, 22225, 22230, 22225, 22232, 22175, 22258, 22238, 22223, 22161, 22266, 22225, 22219, 22221, 22214, 22175, 22224, 22237, 22229, 22234, 22236, 22219, 22220, 5980, 5984, 5985, 6011, 5928, 5995, 5991, 5990, 6012, 5993, 5985, 5990, 5997, 6010, 5928, 5996, 5991, 5997, 6011, 5928, 5990, 5991, 6012, 5928, 6011, 6013, 6008, 6008, 5991, 6010, 6012, 5928, 6010, 5997, 6012, 5993, 5985, 5990, 5985, 5990, 5999, 5928, 5957, 5993, 6008, 5926, 5965, 5990, 6012, 6010, 6001, 5928, 5991, 5994, 5986, 5997, 5995, 6012, 6011, -20955, -20967, -20968, -20990, -20911, -20974, -20962, -20961, -20987, -20976, -20968, -20961, -20972, -20989, -20911, -20971, -20962, -20972, -20990, -20911, -20961, -20962, -20987, -20911, -20990, -20988, -20991, -20991, -20962, -20989, -20987, -20911, -20989, -20972, -20987, -20976, -20968, -20961, -20968, -20961, -20970, -20911, -20932, -20976, -20991, -20897, -20940, -20961, -20987, -20989, -20984, -20911, -20962, -20973, -20965, -20972, -20974, -20987, -20990, 23182, 23218, 23219, 23209, 23290, 23225, 23221, 23220, 23214, 23227, 23219, 23220, 23231, 23208, 23290, 23230, 23221, 23231, 23209, 23290, 23220, 23221, 23214, 23290, 23209, 23215, 23210, 23210, 23221, 23208, 23214, 23290, 23208, 23231, 23214, 23227, 23219, 23220, 23219, 23220, 23229, 23290, 23191, 23227, 23210, 23284, 23199, 23220, 23214, 23208, 23203, 23290, 23221, 23224, 23216, 23231, 23225, 23214, 23209, 18078};

        /* renamed from: a  reason: collision with root package name */
        int f99a;
        boolean c = false;

        /* renamed from: b  reason: collision with root package name */
        int f100b = -1;

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }

        d() {
            this.f99a = f.this.d() - 1;
        }

        public Map.Entry<K, V> a() {
            this.f100b++;
            this.c = true;
            return this;
        }

        @Override // java.lang.Object, java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!this.c) {
                throw new IllegalStateException($(0, 59, 31162));
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                return c.b(entry.getKey(), f.this.b(this.f100b, 0)) && c.b(entry.getValue(), f.this.b(this.f100b, 1));
            }
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.c) {
                return (K) f.this.b(this.f100b, 0);
            }
            throw new IllegalStateException($(59, 118, 22207));
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.c) {
                return (V) f.this.b(this.f100b, 1);
            }
            throw new IllegalStateException($(118, 177, 5896));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f100b < this.f99a;
        }

        @Override // java.lang.Object, java.util.Map.Entry
        public final int hashCode() {
            if (this.c) {
                int i = 0;
                Object b2 = f.this.b(this.f100b, 0);
                Object b3 = f.this.b(this.f100b, 1);
                int hashCode = b2 == null ? 0 : b2.hashCode();
                if (b3 != null) {
                    i = b3.hashCode();
                }
                return hashCode ^ i;
            }
            throw new IllegalStateException($(177, 236, -20879));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            a();
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.c) {
                f.this.h(this.f100b);
                this.f100b--;
                this.f99a--;
                this.c = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.c) {
                return (V) f.this.i(this.f100b, v);
            }
            throw new IllegalStateException($(236, 295, 23258));
        }

        @Override // java.lang.Object
        public final String toString() {
            return getKey() + $(295, 296, 18083) + getValue();
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            f.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return f.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int f = f.this.f(obj);
            if (f < 0) {
                return false;
            }
            f.this.h(f);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int d = f.this.d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (collection.contains(f.this.b(i, 1))) {
                    f.this.h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int d = f.this.d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (!collection.contains(f.this.b(i, 1))) {
                    f.this.h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return f.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return f.this.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) f.this.r(tArr, 1);
        }
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i, int i2);

    protected abstract Map<K, V> c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(K k, V v);

    protected abstract void h(int i);

    protected abstract V i(int i, V v);

    public Set<Map.Entry<K, V>> l() {
        if (this.f93a == null) {
            this.f93a = new b();
        }
        return this.f93a;
    }

    public Set<K> m() {
        if (this.f94b == null) {
            this.f94b = new c();
        }
        return this.f94b;
    }

    public Collection<V> n() {
        if (this.c == null) {
            this.c = new e();
        }
        return this.c;
    }

    public Object[] q(int i) {
        int d2 = d();
        Object[] objArr = new Object[d2];
        for (int i2 = 0; i2 < d2; i2++) {
            objArr[i2] = b(i2, i);
        }
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] r(T[] tArr, int i) {
        int d2 = d();
        if (tArr.length < d2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), d2));
        }
        for (int i2 = 0; i2 < d2; i2++) {
            tArr[i2] = b(i2, i);
        }
        if (tArr.length > d2) {
            tArr[d2] = null;
        }
        return tArr;
    }
}
