package g5;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class c<E> extends a<E> implements List<E> {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {
        public static void a(int i7, int i8, int i9) {
            if (i7 < 0 || i8 > i9) {
                throw new IndexOutOfBoundsException("fromIndex: " + i7 + ", toIndex: " + i8 + ", size: " + i9);
            } else if (i7 > i8) {
                throw new IllegalArgumentException("fromIndex: " + i7 + " > toIndex: " + i8);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements Iterator<E>, s5.a {

        /* renamed from: f */
        public int f4270f;

        public b() {
            c.this = r1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f4270f < c.this.a();
        }

        @Override // java.util.Iterator
        public final E next() {
            if (hasNext()) {
                c<E> cVar = c.this;
                int i7 = this.f4270f;
                this.f4270f = i7 + 1;
                return cVar.get(i7);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: g5.c$c */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class C0061c extends c<E>.b implements ListIterator<E> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0061c(int i7) {
            super();
            c.this = r3;
            int a7 = r3.a();
            if (i7 < 0 || i7 > a7) {
                throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + a7);
            }
            this.f4270f = i7;
        }

        @Override // java.util.ListIterator
        public final void add(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f4270f > 0;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f4270f;
        }

        @Override // java.util.ListIterator
        public final E previous() {
            if (hasPrevious()) {
                c<E> cVar = c.this;
                int i7 = this.f4270f - 1;
                this.f4270f = i7;
                return cVar.get(i7);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f4270f - 1;
        }

        @Override // java.util.ListIterator
        public final void set(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class d<E> extends c<E> implements RandomAccess {

        /* renamed from: f */
        public final c<E> f4273f;

        /* renamed from: g */
        public final int f4274g;

        /* renamed from: h */
        public int f4275h;

        /* JADX WARN: Multi-variable type inference failed */
        public d(c<? extends E> cVar, int i7, int i8) {
            h.f(cVar, "list");
            this.f4273f = cVar;
            this.f4274g = i7;
            a.a(i7, i8, cVar.a());
            this.f4275h = i8 - i7;
        }

        @Override // g5.a
        public final int a() {
            return this.f4275h;
        }

        @Override // g5.c, java.util.List
        public final E get(int i7) {
            int i8 = this.f4275h;
            if (i7 >= 0 && i7 < i8) {
                return this.f4273f.get(this.f4274g + i7);
            }
            throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i8);
        }
    }

    @Override // java.util.List
    public final void add(int i7, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i7, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection collection = (Collection) obj;
        h.f(collection, "other");
        if (size() != collection.size()) {
            return false;
        }
        Iterator<E> it = collection.iterator();
        for (E e : this) {
            if (!h.a(e, it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public abstract E get(int i7);

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public final int hashCode() {
        Iterator<E> it = iterator();
        int i7 = 1;
        while (it.hasNext()) {
            E next = it.next();
            i7 = (i7 * 31) + (next != null ? next.hashCode() : 0);
        }
        return i7;
    }

    @Override // java.util.List
    public int indexOf(E e) {
        int i7 = 0;
        for (E e7 : this) {
            if (h.a(e7, e)) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<E> iterator() {
        return new b();
    }

    @Override // java.util.List
    public int lastIndexOf(E e) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (h.a(listIterator.previous(), e)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator<E> listIterator() {
        return new C0061c(0);
    }

    @Override // java.util.List
    public final ListIterator<E> listIterator(int i7) {
        return new C0061c(i7);
    }

    @Override // java.util.List
    public final E remove(int i7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final E set(int i7, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List<E> subList(int i7, int i8) {
        return new d(this, i7, i8);
    }
}
