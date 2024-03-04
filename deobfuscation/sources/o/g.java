package o;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class g<K, V> {

    /* renamed from: a */
    public g<K, V>.b f5200a;

    /* renamed from: b */
    public g<K, V>.c f5201b;

    /* renamed from: c */
    public g<K, V>.e f5202c;

    /* loaded from: classes.dex */
    public final class a<T> implements Iterator<T> {

        /* renamed from: f */
        public final int f5203f;

        /* renamed from: g */
        public int f5204g;

        /* renamed from: h */
        public int f5205h;

        /* renamed from: i */
        public boolean f5206i = false;

        public a(int i7) {
            g.this = r2;
            this.f5203f = i7;
            this.f5204g = r2.d();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f5205h < this.f5204g;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (hasNext()) {
                T t5 = (T) g.this.b(this.f5205h, this.f5203f);
                this.f5205h++;
                this.f5206i = true;
                return t5;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.f5206i) {
                throw new IllegalStateException();
            }
            int i7 = this.f5205h - 1;
            this.f5205h = i7;
            this.f5204g--;
            this.f5206i = false;
            g.this.h(i7);
        }
    }

    /* loaded from: classes.dex */
    public final class b implements Set<Map.Entry<K, V>> {
        public b() {
            g.this = r1;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d7 = g.this.d();
            for (Map.Entry<K, V> entry : collection) {
                g.this.g(entry.getKey(), entry.getValue());
            }
            return d7 != g.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            g.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int e = g.this.e(entry.getKey());
                if (e < 0) {
                    return false;
                }
                Object b2 = g.this.b(e, 1);
                Object value = entry.getValue();
                return b2 == value || (b2 != null && b2.equals(value));
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object obj) {
            return g.j(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            int i7 = 0;
            for (int d7 = g.this.d() - 1; d7 >= 0; d7--) {
                Object b2 = g.this.b(d7, 0);
                Object b7 = g.this.b(d7, 1);
                i7 += (b2 == null ? 0 : b2.hashCode()) ^ (b7 == null ? 0 : b7.hashCode());
            }
            return i7;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            return g.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return g.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    public final class c implements Set<K> {
        public c() {
            g.this = r1;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(K k6) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            g.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            return g.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            Map<K, V> c7 = g.this.c();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!c7.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object obj) {
            return g.j(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            int i7 = 0;
            for (int d7 = g.this.d() - 1; d7 >= 0; d7--) {
                Object b2 = g.this.b(d7, 0);
                i7 += b2 == null ? 0 : b2.hashCode();
            }
            return i7;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            return g.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            int e = g.this.e(obj);
            if (e >= 0) {
                g.this.h(e);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            Map<K, V> c7 = g.this.c();
            int size = c7.size();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                c7.remove(it.next());
            }
            return size != c7.size();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            return g.k(g.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return g.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            g gVar = g.this;
            int d7 = gVar.d();
            Object[] objArr = new Object[d7];
            for (int i7 = 0; i7 < d7; i7++) {
                objArr[i7] = gVar.b(i7, 0);
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) g.this.l(0, tArr);
        }
    }

    /* loaded from: classes.dex */
    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: f */
        public int f5210f;

        /* renamed from: h */
        public boolean f5212h = false;

        /* renamed from: g */
        public int f5211g = -1;

        public d() {
            g.this = r2;
            this.f5210f = r2.d() - 1;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (this.f5212h) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object b2 = g.this.b(this.f5211g, 0);
                    if (key == b2 || (key != null && key.equals(b2))) {
                        Object value = entry.getValue();
                        Object b7 = g.this.b(this.f5211g, 1);
                        return value == b7 || (value != null && value.equals(b7));
                    }
                    return false;
                }
                return false;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            if (this.f5212h) {
                return (K) g.this.b(this.f5211g, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            if (this.f5212h) {
                return (V) g.this.b(this.f5211g, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f5211g < this.f5210f;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            if (this.f5212h) {
                Object b2 = g.this.b(this.f5211g, 0);
                Object b7 = g.this.b(this.f5211g, 1);
                return (b2 == null ? 0 : b2.hashCode()) ^ (b7 != null ? b7.hashCode() : 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (hasNext()) {
                this.f5211g++;
                this.f5212h = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.f5212h) {
                throw new IllegalStateException();
            }
            g.this.h(this.f5211g);
            this.f5211g--;
            this.f5210f--;
            this.f5212h = false;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v6) {
            if (this.f5212h) {
                return (V) g.this.i(this.f5211g, v6);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* loaded from: classes.dex */
    public final class e implements Collection<V> {
        public e() {
            g.this = r1;
        }

        @Override // java.util.Collection
        public final boolean add(V v6) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final void clear() {
            g.this.a();
        }

        @Override // java.util.Collection
        public final boolean contains(Object obj) {
            return g.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return g.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            int f7 = g.this.f(obj);
            if (f7 >= 0) {
                g.this.h(f7);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            int d7 = g.this.d();
            int i7 = 0;
            boolean z6 = false;
            while (i7 < d7) {
                if (collection.contains(g.this.b(i7, 1))) {
                    g.this.h(i7);
                    i7--;
                    d7--;
                    z6 = true;
                }
                i7++;
            }
            return z6;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            int d7 = g.this.d();
            int i7 = 0;
            boolean z6 = false;
            while (i7 < d7) {
                if (!collection.contains(g.this.b(i7, 1))) {
                    g.this.h(i7);
                    i7--;
                    d7--;
                    z6 = true;
                }
                i7++;
            }
            return z6;
        }

        @Override // java.util.Collection
        public final int size() {
            return g.this.d();
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            g gVar = g.this;
            int d7 = gVar.d();
            Object[] objArr = new Object[d7];
            for (int i7 = 0; i7 < d7; i7++) {
                objArr[i7] = gVar.b(i7, 1);
            }
            return objArr;
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) g.this.l(1, tArr);
        }
    }

    public static <T> boolean j(Set<T> set, Object obj) {
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

    public static <K, V> boolean k(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract void a();

    public abstract Object b(int i7, int i8);

    public abstract Map<K, V> c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(K k6, V v6);

    public abstract void h(int i7);

    public abstract V i(int i7, V v6);

    public final Object[] l(int i7, Object[] objArr) {
        int d7 = d();
        if (objArr.length < d7) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), d7);
        }
        for (int i8 = 0; i8 < d7; i8++) {
            objArr[i8] = b(i8, i7);
        }
        if (objArr.length > d7) {
            objArr[d7] = null;
        }
        return objArr;
    }
}
