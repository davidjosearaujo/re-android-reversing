package l0;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import x.a;

/* loaded from: classes.dex */
public final class g implements List<a.b>, s5.a {

    /* renamed from: f */
    public Object[] f4843f = new Object[16];

    /* renamed from: g */
    public long[] f4844g = new long[16];

    /* renamed from: h */
    public int f4845h = -1;

    /* renamed from: i */
    public int f4846i;

    /* loaded from: classes.dex */
    public final class a implements ListIterator<a.b>, s5.a {

        /* renamed from: f */
        public int f4847f;

        /* renamed from: g */
        public final int f4848g;

        /* renamed from: h */
        public final int f4849h;

        public a(g gVar, int i7, int i8) {
            this((i8 & 1) != 0 ? 0 : i7, 0, (i8 & 4) != 0 ? gVar.f4846i : 0);
        }

        public a(int i7, int i8, int i9) {
            g.this = r1;
            this.f4847f = i7;
            this.f4848g = i8;
            this.f4849h = i9;
        }

        @Override // java.util.ListIterator
        public final /* bridge */ /* synthetic */ void add(a.b bVar) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.f4847f < this.f4849h;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f4847f > this.f4848g;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            Object[] objArr = g.this.f4843f;
            int i7 = this.f4847f;
            this.f4847f = i7 + 1;
            Object obj = objArr[i7];
            r5.h.d(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (a.b) obj;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f4847f - this.f4848g;
        }

        @Override // java.util.ListIterator
        public final a.b previous() {
            Object[] objArr = g.this.f4843f;
            int i7 = this.f4847f - 1;
            this.f4847f = i7;
            Object obj = objArr[i7];
            r5.h.d(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (a.b) obj;
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return (this.f4847f - this.f4848g) - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public final /* bridge */ /* synthetic */ void set(a.b bVar) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: classes.dex */
    public final class b implements List<a.b>, s5.a {

        /* renamed from: f */
        public final int f4851f;

        /* renamed from: g */
        public final int f4852g;

        public b(int i7, int i8) {
            g.this = r1;
            this.f4851f = i7;
            this.f4852g = i8;
        }

        @Override // java.util.List
        public final /* bridge */ /* synthetic */ void add(int i7, a.b bVar) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final boolean addAll(int i7, Collection<? extends a.b> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection<? extends a.b> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj instanceof a.b) {
                a.b bVar = (a.b) obj;
                r5.h.f(bVar, "element");
                return indexOf(bVar) != -1;
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection<? extends Object> collection) {
            r5.h.f(collection, "elements");
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains((a.b) it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public final a.b get(int i7) {
            Object obj = g.this.f4843f[i7 + this.f4851f];
            r5.h.d(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (a.b) obj;
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            if (obj instanceof a.b) {
                a.b bVar = (a.b) obj;
                r5.h.f(bVar, "element");
                int i7 = this.f4851f;
                int i8 = this.f4852g;
                if (i7 <= i8) {
                    while (!r5.h.a(g.this.f4843f[i7], bVar)) {
                        if (i7 == i8) {
                            return -1;
                        }
                        i7++;
                    }
                    return i7 - this.f4851f;
                }
                return -1;
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            return this.f4852g - this.f4851f == 0;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator<a.b> iterator() {
            g gVar = g.this;
            int i7 = this.f4851f;
            return new a(i7, i7, this.f4852g);
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            if (obj instanceof a.b) {
                a.b bVar = (a.b) obj;
                r5.h.f(bVar, "element");
                int i7 = this.f4852g;
                int i8 = this.f4851f;
                if (i8 <= i7) {
                    while (!r5.h.a(g.this.f4843f[i7], bVar)) {
                        if (i7 == i8) {
                            return -1;
                        }
                        i7--;
                    }
                    return i7 - this.f4851f;
                }
                return -1;
            }
            return -1;
        }

        @Override // java.util.List
        public final ListIterator<a.b> listIterator() {
            g gVar = g.this;
            int i7 = this.f4851f;
            return new a(i7, i7, this.f4852g);
        }

        @Override // java.util.List
        public final ListIterator<a.b> listIterator(int i7) {
            g gVar = g.this;
            int i8 = this.f4851f;
            return new a(i7 + i8, i8, this.f4852g);
        }

        @Override // java.util.List
        public final /* bridge */ /* synthetic */ a.b remove(int i7) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final void replaceAll(UnaryOperator<a.b> unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final /* bridge */ /* synthetic */ a.b set(int i7, a.b bVar) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            return this.f4852g - this.f4851f;
        }

        @Override // java.util.List
        public final void sort(Comparator<? super a.b> comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final List<a.b> subList(int i7, int i8) {
            g gVar = g.this;
            int i9 = this.f4851f;
            return new b(i7 + i9, i9 + i8);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            return q2.a.S(this);
        }

        @Override // java.util.List, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            r5.h.f(tArr, "array");
            return (T[]) q2.a.T(this, tArr);
        }
    }

    public final long a() {
        long b2 = a0.b.b(Float.POSITIVE_INFINITY, false);
        int i7 = this.f4845h + 1;
        int x3 = q2.a.x(this);
        if (i7 <= x3) {
            while (true) {
                long j5 = this.f4844g[i7];
                if (a0.b.i(j5, b2) < 0) {
                    b2 = j5;
                }
                if (Float.intBitsToFloat((int) (b2 >> 32)) < 0.0f && a0.b.n(b2)) {
                    return b2;
                }
                if (i7 == x3) {
                    break;
                }
                i7++;
            }
        }
        return b2;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int i7, a.b bVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i7, Collection<? extends a.b> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends a.b> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void b(a.b bVar, float f7, boolean z6, q5.a<f5.g> aVar) {
        r5.h.f(bVar, "node");
        int i7 = this.f4845h;
        int i8 = i7 + 1;
        this.f4845h = i8;
        Object[] objArr = this.f4843f;
        if (i8 >= objArr.length) {
            int length = objArr.length + 16;
            Object[] copyOf = Arrays.copyOf(objArr, length);
            r5.h.e(copyOf, "copyOf(this, newSize)");
            this.f4843f = copyOf;
            long[] copyOf2 = Arrays.copyOf(this.f4844g, length);
            r5.h.e(copyOf2, "copyOf(this, newSize)");
            this.f4844g = copyOf2;
        }
        Object[] objArr2 = this.f4843f;
        int i9 = this.f4845h;
        objArr2[i9] = bVar;
        this.f4844g[i9] = a0.b.b(f7, z6);
        c();
        aVar.d();
        this.f4845h = i7;
    }

    public final void c() {
        int i7 = this.f4845h + 1;
        int x3 = q2.a.x(this);
        if (i7 <= x3) {
            while (true) {
                this.f4843f[i7] = null;
                if (i7 == x3) {
                    break;
                }
                i7++;
            }
        }
        this.f4846i = this.f4845h + 1;
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.f4845h = -1;
        c();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof a.b) {
            a.b bVar = (a.b) obj;
            r5.h.f(bVar, "element");
            return indexOf(bVar) != -1;
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> collection) {
        r5.h.f(collection, "elements");
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains((a.b) it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public final a.b get(int i7) {
        Object obj = this.f4843f[i7];
        r5.h.d(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
        return (a.b) obj;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof a.b) {
            a.b bVar = (a.b) obj;
            r5.h.f(bVar, "element");
            int x3 = q2.a.x(this);
            if (x3 >= 0) {
                int i7 = 0;
                while (!r5.h.a(this.f4843f[i7], bVar)) {
                    if (i7 == x3) {
                        return -1;
                    }
                    i7++;
                }
                return i7;
            }
            return -1;
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f4846i == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<a.b> iterator() {
        return new a(this, 0, 7);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof a.b) {
            a.b bVar = (a.b) obj;
            r5.h.f(bVar, "element");
            for (int x3 = q2.a.x(this); -1 < x3; x3--) {
                if (r5.h.a(this.f4843f[x3], bVar)) {
                    return x3;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator<a.b> listIterator() {
        return new a(this, 0, 7);
    }

    @Override // java.util.List
    public final ListIterator<a.b> listIterator(int i7) {
        return new a(this, i7, 6);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ a.b remove(int i7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<a.b> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ a.b set(int i7, a.b bVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f4846i;
    }

    @Override // java.util.List
    public final void sort(Comparator<? super a.b> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List<a.b> subList(int i7, int i8) {
        return new b(i7, i8);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return q2.a.S(this);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        r5.h.f(tArr, "array");
        return (T[]) q2.a.T(this, tArr);
    }
}
