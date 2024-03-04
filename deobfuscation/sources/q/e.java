package q;

import g5.i;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import r5.h;

/* loaded from: classes.dex */
public final class e<T> implements RandomAccess {

    /* renamed from: f */
    public T[] f5603f;

    /* renamed from: g */
    public a f5604g;

    /* renamed from: h */
    public int f5605h = 0;

    /* loaded from: classes.dex */
    public static final class a<T> implements List<T>, s5.b {

        /* renamed from: f */
        public final e<T> f5606f;

        public a(e<T> eVar) {
            h.f(eVar, "vector");
            this.f5606f = eVar;
        }

        @Override // java.util.List
        public final void add(int i7, T t5) {
            this.f5606f.a(i7, t5);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean add(T t5) {
            this.f5606f.b(t5);
            return true;
        }

        @Override // java.util.List
        public final boolean addAll(int i7, Collection<? extends T> collection) {
            h.f(collection, "elements");
            return this.f5606f.d(i7, collection);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection<? extends T> collection) {
            h.f(collection, "elements");
            e<T> eVar = this.f5606f;
            eVar.getClass();
            return eVar.d(eVar.f5605h, collection);
        }

        @Override // java.util.List, java.util.Collection
        public final void clear() {
            this.f5606f.e();
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object obj) {
            return this.f5606f.f(obj);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection<? extends Object> collection) {
            h.f(collection, "elements");
            e<T> eVar = this.f5606f;
            eVar.getClass();
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                if (!eVar.f(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public final T get(int i7) {
            a0.b.c(i7, this);
            return this.f5606f.f5603f[i7];
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            e<T> eVar = this.f5606f;
            int i7 = eVar.f5605h;
            if (i7 > 0) {
                int i8 = 0;
                T[] tArr = eVar.f5603f;
                while (!h.a(obj, tArr[i8])) {
                    i8++;
                    if (i8 >= i7) {
                        return -1;
                    }
                }
                return i8;
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            return this.f5606f.f5605h == 0;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator<T> iterator() {
            return new c(0, this);
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            e<T> eVar = this.f5606f;
            int i7 = eVar.f5605h;
            if (i7 > 0) {
                int i8 = i7 - 1;
                T[] tArr = eVar.f5603f;
                while (!h.a(obj, tArr[i8])) {
                    i8--;
                    if (i8 < 0) {
                        return -1;
                    }
                }
                return i8;
            }
            return -1;
        }

        @Override // java.util.List
        public final ListIterator<T> listIterator() {
            return new c(0, this);
        }

        @Override // java.util.List
        public final ListIterator<T> listIterator(int i7) {
            return new c(i7, this);
        }

        @Override // java.util.List
        public final T remove(int i7) {
            a0.b.c(i7, this);
            return this.f5606f.j(i7);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object obj) {
            return this.f5606f.i(obj);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection<? extends Object> collection) {
            h.f(collection, "elements");
            e<T> eVar = this.f5606f;
            eVar.getClass();
            if (collection.isEmpty()) {
                return false;
            }
            int i7 = eVar.f5605h;
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                eVar.i(it.next());
            }
            return i7 != eVar.f5605h;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection<? extends Object> collection) {
            h.f(collection, "elements");
            e<T> eVar = this.f5606f;
            eVar.getClass();
            int i7 = eVar.f5605h;
            for (int i8 = i7 - 1; -1 < i8; i8--) {
                if (!collection.contains(eVar.f5603f[i8])) {
                    eVar.j(i8);
                }
            }
            return i7 != eVar.f5605h;
        }

        @Override // java.util.List
        public final T set(int i7, T t5) {
            a0.b.c(i7, this);
            T[] tArr = this.f5606f.f5603f;
            T t6 = tArr[i7];
            tArr[i7] = t5;
            return t6;
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            return this.f5606f.f5605h;
        }

        @Override // java.util.List
        public final List<T> subList(int i7, int i8) {
            a0.b.d(i7, i8, this);
            return new b(i7, i8, this);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            return q2.a.S(this);
        }

        @Override // java.util.List, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            h.f(tArr, "array");
            return (T[]) q2.a.T(this, tArr);
        }
    }

    /* loaded from: classes.dex */
    public static final class b<T> implements List<T>, s5.b {

        /* renamed from: f */
        public final List<T> f5607f;

        /* renamed from: g */
        public final int f5608g;

        /* renamed from: h */
        public int f5609h;

        public b(int i7, int i8, List list) {
            h.f(list, "list");
            this.f5607f = list;
            this.f5608g = i7;
            this.f5609h = i8;
        }

        @Override // java.util.List
        public final void add(int i7, T t5) {
            this.f5607f.add(i7 + this.f5608g, t5);
            this.f5609h++;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean add(T t5) {
            List<T> list = this.f5607f;
            int i7 = this.f5609h;
            this.f5609h = i7 + 1;
            list.add(i7, t5);
            return true;
        }

        @Override // java.util.List
        public final boolean addAll(int i7, Collection<? extends T> collection) {
            h.f(collection, "elements");
            this.f5607f.addAll(i7 + this.f5608g, collection);
            this.f5609h = collection.size() + this.f5609h;
            return collection.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection<? extends T> collection) {
            h.f(collection, "elements");
            this.f5607f.addAll(this.f5609h, collection);
            this.f5609h = collection.size() + this.f5609h;
            return collection.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public final void clear() {
            int i7 = this.f5609h - 1;
            int i8 = this.f5608g;
            if (i8 <= i7) {
                while (true) {
                    this.f5607f.remove(i7);
                    if (i7 == i8) {
                        break;
                    }
                    i7--;
                }
            }
            this.f5609h = this.f5608g;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object obj) {
            int i7 = this.f5609h;
            for (int i8 = this.f5608g; i8 < i7; i8++) {
                if (h.a(this.f5607f.get(i8), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection<? extends Object> collection) {
            h.f(collection, "elements");
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public final T get(int i7) {
            a0.b.c(i7, this);
            return this.f5607f.get(i7 + this.f5608g);
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            int i7 = this.f5609h;
            for (int i8 = this.f5608g; i8 < i7; i8++) {
                if (h.a(this.f5607f.get(i8), obj)) {
                    return i8 - this.f5608g;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            return this.f5609h == this.f5608g;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator<T> iterator() {
            return new c(0, this);
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            int i7 = this.f5609h - 1;
            int i8 = this.f5608g;
            if (i8 <= i7) {
                while (!h.a(this.f5607f.get(i7), obj)) {
                    if (i7 == i8) {
                        return -1;
                    }
                    i7--;
                }
                return i7 - this.f5608g;
            }
            return -1;
        }

        @Override // java.util.List
        public final ListIterator<T> listIterator() {
            return new c(0, this);
        }

        @Override // java.util.List
        public final ListIterator<T> listIterator(int i7) {
            return new c(i7, this);
        }

        @Override // java.util.List
        public final T remove(int i7) {
            a0.b.c(i7, this);
            this.f5609h--;
            return this.f5607f.remove(i7 + this.f5608g);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object obj) {
            int i7 = this.f5609h;
            for (int i8 = this.f5608g; i8 < i7; i8++) {
                if (h.a(this.f5607f.get(i8), obj)) {
                    this.f5607f.remove(i8);
                    this.f5609h--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection<? extends Object> collection) {
            h.f(collection, "elements");
            int i7 = this.f5609h;
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i7 != this.f5609h;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection<? extends Object> collection) {
            h.f(collection, "elements");
            int i7 = this.f5609h;
            int i8 = i7 - 1;
            int i9 = this.f5608g;
            if (i9 <= i8) {
                while (true) {
                    if (!collection.contains(this.f5607f.get(i8))) {
                        this.f5607f.remove(i8);
                        this.f5609h--;
                    }
                    if (i8 == i9) {
                        break;
                    }
                    i8--;
                }
            }
            return i7 != this.f5609h;
        }

        @Override // java.util.List
        public final T set(int i7, T t5) {
            a0.b.c(i7, this);
            return this.f5607f.set(i7 + this.f5608g, t5);
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            return this.f5609h - this.f5608g;
        }

        @Override // java.util.List
        public final List<T> subList(int i7, int i8) {
            a0.b.d(i7, i8, this);
            return new b(i7, i8, this);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            return q2.a.S(this);
        }

        @Override // java.util.List, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            h.f(tArr, "array");
            return (T[]) q2.a.T(this, tArr);
        }
    }

    /* loaded from: classes.dex */
    public static final class c<T> implements ListIterator<T>, s5.a {

        /* renamed from: f */
        public final List<T> f5610f;

        /* renamed from: g */
        public int f5611g;

        public c(int i7, List list) {
            h.f(list, "list");
            this.f5610f = list;
            this.f5611g = i7;
        }

        @Override // java.util.ListIterator
        public final void add(T t5) {
            this.f5610f.add(this.f5611g, t5);
            this.f5611g++;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.f5611g < this.f5610f.size();
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f5611g > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final T next() {
            List<T> list = this.f5610f;
            int i7 = this.f5611g;
            this.f5611g = i7 + 1;
            return list.get(i7);
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f5611g;
        }

        @Override // java.util.ListIterator
        public final T previous() {
            int i7 = this.f5611g - 1;
            this.f5611g = i7;
            return this.f5610f.get(i7);
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f5611g - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            int i7 = this.f5611g - 1;
            this.f5611g = i7;
            this.f5610f.remove(i7);
        }

        @Override // java.util.ListIterator
        public final void set(T t5) {
            this.f5610f.set(this.f5611g, t5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Object[] objArr) {
        this.f5603f = objArr;
    }

    public final void a(int i7, T t5) {
        g(this.f5605h + 1);
        T[] tArr = this.f5603f;
        int i8 = this.f5605h;
        if (i7 != i8) {
            i.W(tArr, tArr, i7 + 1, i7, i8);
        }
        tArr[i7] = t5;
        this.f5605h++;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(Object obj) {
        g(this.f5605h + 1);
        int i7 = this.f5605h;
        this.f5603f[i7] = obj;
        this.f5605h = i7 + 1;
    }

    public final void c(int i7, e eVar) {
        h.f(eVar, "elements");
        int i8 = eVar.f5605h;
        if (i8 == 0) {
            return;
        }
        g(this.f5605h + i8);
        T[] tArr = this.f5603f;
        int i9 = this.f5605h;
        if (i7 != i9) {
            i.W(tArr, tArr, eVar.f5605h + i7, i7, i9);
        }
        i.W(eVar.f5603f, tArr, i7, 0, eVar.f5605h);
        this.f5605h += eVar.f5605h;
    }

    public final boolean d(int i7, Collection<? extends T> collection) {
        h.f(collection, "elements");
        int i8 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        g(collection.size() + this.f5605h);
        T[] tArr = this.f5603f;
        if (i7 != this.f5605h) {
            i.W(tArr, tArr, collection.size() + i7, i7, this.f5605h);
        }
        for (T t5 : collection) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            tArr[i8 + i7] = t5;
            i8 = i9;
        }
        this.f5605h = collection.size() + this.f5605h;
        return true;
    }

    public final void e() {
        T[] tArr = this.f5603f;
        int i7 = this.f5605h;
        while (true) {
            i7--;
            if (-1 >= i7) {
                this.f5605h = 0;
                return;
            }
            tArr[i7] = null;
        }
    }

    public final boolean f(T t5) {
        int i7 = this.f5605h - 1;
        if (i7 >= 0) {
            for (int i8 = 0; !h.a(this.f5603f[i8], t5); i8++) {
                if (i8 != i7) {
                }
            }
            return true;
        }
        return false;
    }

    public final void g(int i7) {
        T[] tArr = this.f5603f;
        if (tArr.length < i7) {
            T[] tArr2 = (T[]) Arrays.copyOf(tArr, Math.max(i7, tArr.length * 2));
            h.e(tArr2, "copyOf(this, newSize)");
            this.f5603f = tArr2;
        }
    }

    public final boolean h() {
        return this.f5605h != 0;
    }

    public final boolean i(T t5) {
        int i7;
        int i8 = this.f5605h;
        if (i8 <= 0) {
            i7 = -1;
            break;
        }
        T[] tArr = this.f5603f;
        i7 = 0;
        while (!h.a(t5, tArr[i7])) {
            i7++;
            if (i7 >= i8) {
                i7 = -1;
                break;
            }
        }
        if (i7 >= 0) {
            j(i7);
            return true;
        }
        return false;
    }

    public final T j(int i7) {
        T[] tArr = this.f5603f;
        T t5 = tArr[i7];
        int i8 = this.f5605h;
        if (i7 != i8 - 1) {
            i.W(tArr, tArr, i7, i7 + 1, i8);
        }
        int i9 = this.f5605h - 1;
        this.f5605h = i9;
        tArr[i9] = null;
        return t5;
    }
}
