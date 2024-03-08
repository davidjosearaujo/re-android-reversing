package q;

import g5.n;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import q5.l;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b<T> implements Set<T>, s5.a {

    /* renamed from: f */
    public int f5593f;

    /* renamed from: g */
    public Object[] f5594g = new Object[16];

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements Iterator<T>, s5.a {

        /* renamed from: f */
        public int f5595f;

        /* renamed from: g */
        public final /* synthetic */ b<T> f5596g;

        public a(b<T> bVar) {
            this.f5596g = bVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f5595f < this.f5596g.f5593f;
        }

        @Override // java.util.Iterator
        public final T next() {
            Object[] objArr = this.f5596g.f5594g;
            int i7 = this.f5595f;
            this.f5595f = i7 + 1;
            T t5 = (T) objArr[i7];
            h.d(t5, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            return t5;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: q.b$b */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0097b extends i implements l<T, CharSequence> {

        /* renamed from: g */
        public static final C0097b f5597g = new C0097b();

        public C0097b() {
            super(1);
        }

        @Override // q5.l
        public final CharSequence k(Object obj) {
            h.f(obj, "it");
            return obj.toString();
        }
    }

    public final int a(Object obj) {
        Object obj2;
        int i7 = this.f5593f - 1;
        int identityHashCode = System.identityHashCode(obj);
        Object[] objArr = this.f5594g;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) >>> 1;
            Object obj3 = objArr[i9];
            int identityHashCode2 = System.identityHashCode(obj3);
            if (identityHashCode2 < identityHashCode) {
                i8 = i9 + 1;
            } else if (identityHashCode2 > identityHashCode) {
                i7 = i9 - 1;
            } else if (obj3 == obj) {
                return i9;
            } else {
                Object[] objArr2 = this.f5594g;
                int i10 = this.f5593f;
                for (int i11 = i9 - 1; -1 < i11; i11--) {
                    Object obj4 = objArr2[i11];
                    if (obj4 == obj) {
                        return i11;
                    }
                    if (System.identityHashCode(obj4) != identityHashCode) {
                        break;
                    }
                }
                do {
                    i9++;
                    if (i9 >= i10) {
                        return -(i10 + 1);
                    }
                    obj2 = objArr2[i9];
                    if (obj2 == obj) {
                        return i9;
                    }
                } while (System.identityHashCode(obj2) == identityHashCode);
                return -(i9 + 1);
            }
        }
        return -(i8 + 1);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(T t5) {
        int i7;
        h.f(t5, "value");
        int i8 = this.f5593f;
        Object[] objArr = this.f5594g;
        if (i8 > 0) {
            i7 = a(t5);
            if (i7 >= 0) {
                return false;
            }
        } else {
            i7 = -1;
        }
        int i9 = -(i7 + 1);
        if (i8 == objArr.length) {
            Object[] objArr2 = new Object[objArr.length * 2];
            g5.i.W(objArr, objArr2, i9 + 1, i9, i8);
            g5.i.Y(objArr, objArr2, 0, i9, 6);
            this.f5594g = objArr2;
        } else {
            g5.i.W(objArr, objArr, i9 + 1, i9, i8);
        }
        this.f5594g[i9] = t5;
        this.f5593f++;
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        g5.i.a0(this.f5594g);
        this.f5593f = 0;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return obj != null && a(obj) >= 0;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> collection) {
        h.f(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f5593f == 0;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return new a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(T t5) {
        if (t5 == null) {
            return false;
        }
        int a7 = a(t5);
        Object[] objArr = this.f5594g;
        int i7 = this.f5593f;
        if (a7 < 0) {
            return false;
        }
        int i8 = i7 - 1;
        if (a7 < i8) {
            g5.i.W(objArr, objArr, a7, a7 + 1, i7);
        }
        objArr[i8] = null;
        this.f5593f--;
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f5593f;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return q2.a.S(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        h.f(tArr, "array");
        return (T[]) q2.a.T(this, tArr);
    }

    @Override // java.lang.Object
    public final String toString() {
        return n.Z(this, null, "[", "]", C0097b.f5597g, 25);
    }
}
