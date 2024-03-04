package g5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class g<T> implements Collection<T>, s5.a {

    /* renamed from: f */
    public final T[] f4277f;

    /* renamed from: g */
    public final boolean f4278g;

    public g(T[] tArr, boolean z6) {
        this.f4277f = tArr;
        this.f4278g = z6;
    }

    @Override // java.util.Collection
    public final boolean add(T t5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        int i7;
        T[] tArr = this.f4277f;
        r5.h.f(tArr, "<this>");
        if (obj == null) {
            int length = tArr.length;
            i7 = 0;
            while (i7 < length) {
                if (tArr[i7] == null) {
                    break;
                }
                i7++;
            }
            i7 = -1;
        } else {
            int length2 = tArr.length;
            for (int i8 = 0; i8 < length2; i8++) {
                if (r5.h.a(obj, tArr[i8])) {
                    i7 = i8;
                    break;
                }
            }
            i7 = -1;
        }
        return i7 >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> collection) {
        r5.h.f(collection, "elements");
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

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f4277f.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        T[] tArr = this.f4277f;
        r5.h.f(tArr, "array");
        return new r5.a(tArr);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f4277f.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        T[] tArr = this.f4277f;
        boolean z6 = this.f4278g;
        r5.h.f(tArr, "<this>");
        if (z6 && r5.h.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        r5.h.e(copyOf, "copyOf(...)");
        return copyOf;
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        r5.h.f(tArr, "array");
        return (T[]) q2.a.T(this, tArr);
    }
}
