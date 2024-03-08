package r0;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import r5.h;
import s5.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l extends e implements List<f>, a {
    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int i7, f fVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i7, Collection<? extends f> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends f> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        h.f((f) obj, "element");
        throw null;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> collection) {
        h.f(collection, "elements");
        throw null;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        ((l) obj).getClass();
        return h.a(null, null);
    }

    @Override // java.util.List
    public final f get(int i7) {
        throw null;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Object
    public final int hashCode() {
        throw null;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof f)) {
            return -1;
        }
        h.f((f) obj, "element");
        throw null;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        throw null;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<f> iterator() {
        throw null;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof f)) {
            return -1;
        }
        h.f((f) obj, "element");
        throw null;
    }

    @Override // java.util.List
    public final ListIterator<f> listIterator() {
        throw null;
    }

    @Override // java.util.List
    public final ListIterator<f> listIterator(int i7) {
        throw null;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ f remove(int i7) {
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
    public final void replaceAll(UnaryOperator<f> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ f set(int i7, f fVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        throw null;
    }

    @Override // java.util.List
    public final void sort(Comparator<? super f> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List<f> subList(int i7, int i8) {
        throw null;
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

    @Override // java.lang.Object
    public final String toString() {
        return "FontListFontFamily(fonts=null)";
    }
}
