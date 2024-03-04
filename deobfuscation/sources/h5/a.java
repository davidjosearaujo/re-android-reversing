package h5;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import g5.c;
import g5.e;
import g5.i;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import r5.h;

/* loaded from: classes.dex */
public final class a<E> extends e<E> implements RandomAccess, Serializable {

    /* renamed from: l */
    public static final a f4391l;

    /* renamed from: f */
    public E[] f4392f;

    /* renamed from: g */
    public int f4393g;

    /* renamed from: h */
    public int f4394h;

    /* renamed from: i */
    public boolean f4395i;

    /* renamed from: j */
    public final a<E> f4396j;

    /* renamed from: k */
    public final a<E> f4397k;

    /* renamed from: h5.a$a */
    /* loaded from: classes.dex */
    public static final class C0065a<E> implements ListIterator<E>, s5.a {

        /* renamed from: f */
        public final a<E> f4398f;

        /* renamed from: g */
        public int f4399g;

        /* renamed from: h */
        public int f4400h;

        /* renamed from: i */
        public int f4401i;

        public C0065a(a<E> aVar, int i7) {
            h.f(aVar, "list");
            this.f4398f = aVar;
            this.f4399g = i7;
            this.f4400h = -1;
            this.f4401i = ((AbstractList) aVar).modCount;
        }

        public final void a() {
            if (((AbstractList) this.f4398f).modCount != this.f4401i) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public final void add(E e) {
            a();
            a<E> aVar = this.f4398f;
            int i7 = this.f4399g;
            this.f4399g = i7 + 1;
            aVar.add(i7, e);
            this.f4400h = -1;
            this.f4401i = ((AbstractList) this.f4398f).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.f4399g < this.f4398f.f4394h;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f4399g > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final E next() {
            a();
            int i7 = this.f4399g;
            a<E> aVar = this.f4398f;
            if (i7 < aVar.f4394h) {
                this.f4399g = i7 + 1;
                this.f4400h = i7;
                return aVar.f4392f[aVar.f4393g + i7];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f4399g;
        }

        @Override // java.util.ListIterator
        public final E previous() {
            a();
            int i7 = this.f4399g;
            if (i7 > 0) {
                int i8 = i7 - 1;
                this.f4399g = i8;
                this.f4400h = i8;
                a<E> aVar = this.f4398f;
                return aVar.f4392f[aVar.f4393g + i8];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f4399g - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            a();
            int i7 = this.f4400h;
            if (!(i7 != -1)) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.f4398f.b(i7);
            this.f4399g = this.f4400h;
            this.f4400h = -1;
            this.f4401i = ((AbstractList) this.f4398f).modCount;
        }

        @Override // java.util.ListIterator
        public final void set(E e) {
            a();
            int i7 = this.f4400h;
            if (!(i7 != -1)) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.f4398f.set(i7, e);
        }
    }

    static {
        a aVar = new a(0);
        aVar.f4395i = true;
        f4391l = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(int i7) {
        this(new Object[i7], 0, 0, false, null, null);
        if (i7 >= 0) {
            return;
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public a(E[] eArr, int i7, int i8, boolean z6, a<E> aVar, a<E> aVar2) {
        this.f4392f = eArr;
        this.f4393g = i7;
        this.f4394h = i8;
        this.f4395i = z6;
        this.f4396j = aVar;
        this.f4397k = aVar2;
        if (aVar != null) {
            ((AbstractList) this).modCount = ((AbstractList) aVar).modCount;
        }
    }

    @Override // g5.e
    public final int a() {
        f();
        return this.f4394h;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i7, E e) {
        g();
        f();
        int i8 = this.f4394h;
        if (i7 >= 0 && i7 <= i8) {
            e(this.f4393g + i7, e);
            return;
        }
        throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i8);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        g();
        f();
        e(this.f4393g + this.f4394h, e);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i7, Collection<? extends E> collection) {
        h.f(collection, "elements");
        g();
        f();
        int i8 = this.f4394h;
        if (i7 >= 0 && i7 <= i8) {
            int size = collection.size();
            d(this.f4393g + i7, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends E> collection) {
        h.f(collection, "elements");
        g();
        f();
        int size = collection.size();
        d(this.f4393g + this.f4394h, collection, size);
        return size > 0;
    }

    @Override // g5.e
    public final E b(int i7) {
        g();
        f();
        int i8 = this.f4394h;
        if (i7 < 0 || i7 >= i8) {
            throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i8);
        }
        return i(this.f4393g + i7);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        g();
        f();
        j(this.f4393g, this.f4394h);
    }

    public final void d(int i7, Collection<? extends E> collection, int i8) {
        ((AbstractList) this).modCount++;
        a<E> aVar = this.f4396j;
        if (aVar != null) {
            aVar.d(i7, collection, i8);
            this.f4392f = this.f4396j.f4392f;
            this.f4394h += i8;
            return;
        }
        h(i7, i8);
        Iterator<? extends E> it = collection.iterator();
        for (int i9 = 0; i9 < i8; i9++) {
            this.f4392f[i7 + i9] = it.next();
        }
    }

    public final void e(int i7, E e) {
        ((AbstractList) this).modCount++;
        a<E> aVar = this.f4396j;
        if (aVar == null) {
            h(i7, 1);
            this.f4392f[i7] = e;
            return;
        }
        aVar.e(i7, e);
        this.f4392f = this.f4396j.f4392f;
        this.f4394h++;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r7.f()
            r0 = 0
            r1 = 1
            if (r8 == r7) goto L33
            boolean r2 = r8 instanceof java.util.List
            if (r2 == 0) goto L34
            java.util.List r8 = (java.util.List) r8
            E[] r2 = r7.f4392f
            int r3 = r7.f4393g
            int r7 = r7.f4394h
            int r4 = r8.size()
            if (r7 == r4) goto L1a
            goto L2b
        L1a:
            r4 = r0
        L1b:
            if (r4 >= r7) goto L30
            int r5 = r3 + r4
            r5 = r2[r5]
            java.lang.Object r6 = r8.get(r4)
            boolean r5 = r5.h.a(r5, r6)
            if (r5 != 0) goto L2d
        L2b:
            r7 = r0
            goto L31
        L2d:
            int r4 = r4 + 1
            goto L1b
        L30:
            r7 = r1
        L31:
            if (r7 == 0) goto L34
        L33:
            r0 = r1
        L34:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.a.equals(java.lang.Object):boolean");
    }

    public final void f() {
        a<E> aVar = this.f4397k;
        if (aVar != null && ((AbstractList) aVar).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public final void g() {
        a<E> aVar;
        if (this.f4395i || ((aVar = this.f4397k) != null && aVar.f4395i)) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i7) {
        f();
        int i8 = this.f4394h;
        if (i7 < 0 || i7 >= i8) {
            throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i8);
        }
        return this.f4392f[this.f4393g + i7];
    }

    public final void h(int i7, int i8) {
        int i9 = this.f4394h + i8;
        if (i9 < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.f4392f;
        if (i9 > eArr.length) {
            int length = eArr.length;
            int i10 = length + (length >> 1);
            if (i10 - i9 < 0) {
                i10 = i9;
            }
            if (i10 - 2147483639 > 0) {
                i10 = i9 > 2147483639 ? SubsamplingScaleImageView.TILE_SIZE_AUTO : 2147483639;
            }
            E[] eArr2 = (E[]) Arrays.copyOf(eArr, i10);
            h.e(eArr2, "copyOf(...)");
            this.f4392f = eArr2;
        }
        E[] eArr3 = this.f4392f;
        i.W(eArr3, eArr3, i7 + i8, i7, this.f4393g + this.f4394h);
        this.f4394h += i8;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        f();
        E[] eArr = this.f4392f;
        int i7 = this.f4393g;
        int i8 = this.f4394h;
        int i9 = 1;
        for (int i10 = 0; i10 < i8; i10++) {
            E e = eArr[i7 + i10];
            i9 = (i9 * 31) + (e != null ? e.hashCode() : 0);
        }
        return i9;
    }

    public final E i(int i7) {
        ((AbstractList) this).modCount++;
        a<E> aVar = this.f4396j;
        if (aVar != null) {
            this.f4394h--;
            return aVar.i(i7);
        }
        E[] eArr = this.f4392f;
        E e = eArr[i7];
        i.W(eArr, eArr, i7, i7 + 1, this.f4393g + this.f4394h);
        E[] eArr2 = this.f4392f;
        h.f(eArr2, "<this>");
        eArr2[(this.f4393g + this.f4394h) - 1] = null;
        this.f4394h--;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        f();
        for (int i7 = 0; i7 < this.f4394h; i7++) {
            if (h.a(this.f4392f[this.f4393g + i7], obj)) {
                return i7;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        f();
        return this.f4394h == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<E> iterator() {
        return listIterator(0);
    }

    public final void j(int i7, int i8) {
        if (i8 > 0) {
            ((AbstractList) this).modCount++;
        }
        a<E> aVar = this.f4396j;
        if (aVar != null) {
            aVar.j(i7, i8);
        } else {
            E[] eArr = this.f4392f;
            i.W(eArr, eArr, i7, i7 + i8, this.f4394h);
            E[] eArr2 = this.f4392f;
            int i9 = this.f4394h;
            h.f(eArr2, "<this>");
            for (int i10 = i9 - i8; i10 < i9; i10++) {
                eArr2[i10] = null;
            }
        }
        this.f4394h -= i8;
    }

    public final int k(int i7, int i8, Collection<? extends E> collection, boolean z6) {
        int i9;
        a<E> aVar = this.f4396j;
        if (aVar != null) {
            i9 = aVar.k(i7, i8, collection, z6);
        } else {
            int i10 = 0;
            int i11 = 0;
            while (i10 < i8) {
                int i12 = i7 + i10;
                if (collection.contains(this.f4392f[i12]) == z6) {
                    E[] eArr = this.f4392f;
                    i10++;
                    eArr[i11 + i7] = eArr[i12];
                    i11++;
                } else {
                    i10++;
                }
            }
            int i13 = i8 - i11;
            E[] eArr2 = this.f4392f;
            i.W(eArr2, eArr2, i7 + i11, i8 + i7, this.f4394h);
            E[] eArr3 = this.f4392f;
            int i14 = this.f4394h;
            h.f(eArr3, "<this>");
            for (int i15 = i14 - i13; i15 < i14; i15++) {
                eArr3[i15] = null;
            }
            i9 = i13;
        }
        if (i9 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f4394h -= i9;
        return i9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        f();
        for (int i7 = this.f4394h - 1; i7 >= 0; i7--) {
            if (h.a(this.f4392f[this.f4393g + i7], obj)) {
                return i7;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<E> listIterator(int i7) {
        f();
        int i8 = this.f4394h;
        if (i7 < 0 || i7 > i8) {
            throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i8);
        }
        return new C0065a(this, i7);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        g();
        f();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            b(indexOf);
        }
        return indexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection<? extends Object> collection) {
        h.f(collection, "elements");
        g();
        f();
        return k(this.f4393g, this.f4394h, collection, false) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection<? extends Object> collection) {
        h.f(collection, "elements");
        g();
        f();
        return k(this.f4393g, this.f4394h, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i7, E e) {
        g();
        f();
        int i8 = this.f4394h;
        if (i7 >= 0 && i7 < i8) {
            E[] eArr = this.f4392f;
            int i9 = this.f4393g;
            E e7 = eArr[i9 + i7];
            eArr[i9 + i7] = e;
            return e7;
        }
        throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i8);
    }

    @Override // java.util.AbstractList, java.util.List
    public final List<E> subList(int i7, int i8) {
        c.a.a(i7, i8, this.f4394h);
        E[] eArr = this.f4392f;
        int i9 = this.f4393g + i7;
        int i10 = i8 - i7;
        boolean z6 = this.f4395i;
        a<E> aVar = this.f4397k;
        return new a(eArr, i9, i10, z6, this, aVar == null ? this : aVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        f();
        E[] eArr = this.f4392f;
        int i7 = this.f4393g;
        int i8 = this.f4394h + i7;
        h.f(eArr, "<this>");
        int length = eArr.length;
        if (i8 <= length) {
            Object[] copyOfRange = Arrays.copyOfRange(eArr, i7, i8);
            h.e(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i8 + ") is greater than size (" + length + ").");
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        f();
        E[] eArr = this.f4392f;
        int i7 = this.f4393g;
        int i8 = this.f4394h;
        StringBuilder sb = new StringBuilder((i8 * 3) + 2);
        sb.append("[");
        for (int i9 = 0; i9 < i8; i9++) {
            if (i9 > 0) {
                sb.append(", ");
            }
            E e = eArr[i7 + i9];
            if (e == this) {
                sb.append("(this Collection)");
            } else {
                sb.append(e);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        h.e(sb2, "toString(...)");
        return sb2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final <T> T[] toArray(T[] tArr) {
        h.f(tArr, "destination");
        f();
        int length = tArr.length;
        int i7 = this.f4394h;
        if (length < i7) {
            E[] eArr = this.f4392f;
            int i8 = this.f4393g;
            T[] tArr2 = (T[]) Arrays.copyOfRange(eArr, i8, i7 + i8, tArr.getClass());
            h.e(tArr2, "copyOfRange(...)");
            return tArr2;
        }
        E[] eArr2 = this.f4392f;
        int i9 = this.f4393g;
        i.W(eArr2, tArr, 0, i9, i7 + i9);
        int i10 = this.f4394h;
        if (i10 < tArr.length) {
            tArr[i10] = null;
        }
        return tArr;
    }
}
