package g5;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class h<E> extends e<E> {

    /* renamed from: i */
    public static final Object[] f4279i = new Object[0];

    /* renamed from: f */
    public int f4280f;

    /* renamed from: g */
    public Object[] f4281g = f4279i;

    /* renamed from: h */
    public int f4282h;

    @Override // g5.e
    public final int a() {
        return this.f4282h;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i7, E e) {
        int i8;
        int i9 = this.f4282h;
        if (i7 < 0 || i7 > i9) {
            throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i9);
        } else if (i7 == i9) {
            addLast(e);
        } else if (i7 == 0) {
            d(i9 + 1);
            int i10 = this.f4280f;
            if (i10 == 0) {
                Object[] objArr = this.f4281g;
                r5.h.f(objArr, "<this>");
                i10 = objArr.length;
            }
            int i11 = i10 - 1;
            this.f4280f = i11;
            this.f4281g[i11] = e;
            this.f4282h++;
        } else {
            d(i9 + 1);
            int f7 = f(this.f4280f + i7);
            int i12 = this.f4282h;
            if (i7 < ((i12 + 1) >> 1)) {
                if (f7 == 0) {
                    Object[] objArr2 = this.f4281g;
                    r5.h.f(objArr2, "<this>");
                    i8 = objArr2.length - 1;
                } else {
                    i8 = f7 - 1;
                }
                int i13 = this.f4280f;
                if (i13 == 0) {
                    Object[] objArr3 = this.f4281g;
                    r5.h.f(objArr3, "<this>");
                    i13 = objArr3.length;
                }
                int i14 = i13 - 1;
                int i15 = this.f4280f;
                Object[] objArr4 = this.f4281g;
                if (i8 >= i15) {
                    objArr4[i14] = objArr4[i15];
                    i.W(objArr4, objArr4, i15, i15 + 1, i8 + 1);
                } else {
                    i.W(objArr4, objArr4, i15 - 1, i15, objArr4.length);
                    Object[] objArr5 = this.f4281g;
                    objArr5[objArr5.length - 1] = objArr5[0];
                    i.W(objArr5, objArr5, 0, 1, i8 + 1);
                }
                this.f4281g[i8] = e;
                this.f4280f = i14;
            } else {
                int f8 = f(i12 + this.f4280f);
                Object[] objArr6 = this.f4281g;
                if (f7 < f8) {
                    i.W(objArr6, objArr6, f7 + 1, f7, f8);
                } else {
                    i.W(objArr6, objArr6, 1, 0, f8);
                    Object[] objArr7 = this.f4281g;
                    objArr7[0] = objArr7[objArr7.length - 1];
                    i.W(objArr7, objArr7, f7 + 1, f7, objArr7.length - 1);
                }
                this.f4281g[f7] = e;
            }
            this.f4282h++;
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i7, Collection<? extends E> collection) {
        r5.h.f(collection, "elements");
        int i8 = this.f4282h;
        if (i7 >= 0 && i7 <= i8) {
            if (collection.isEmpty()) {
                return false;
            }
            int i9 = this.f4282h;
            if (i7 == i9) {
                return addAll(collection);
            }
            d(collection.size() + i9);
            int f7 = f(this.f4282h + this.f4280f);
            int f8 = f(this.f4280f + i7);
            int size = collection.size();
            if (i7 < ((this.f4282h + 1) >> 1)) {
                int i10 = this.f4280f;
                int i11 = i10 - size;
                if (f8 < i10) {
                    Object[] objArr = this.f4281g;
                    i.W(objArr, objArr, i11, i10, objArr.length);
                    Object[] objArr2 = this.f4281g;
                    int length = objArr2.length - size;
                    if (size >= f8) {
                        i.W(objArr2, objArr2, length, 0, f8);
                    } else {
                        i.W(objArr2, objArr2, length, 0, size);
                        Object[] objArr3 = this.f4281g;
                        i.W(objArr3, objArr3, 0, size, f8);
                    }
                } else if (i11 >= 0) {
                    Object[] objArr4 = this.f4281g;
                    i.W(objArr4, objArr4, i11, i10, f8);
                } else {
                    Object[] objArr5 = this.f4281g;
                    i11 += objArr5.length;
                    int i12 = f8 - i10;
                    int length2 = objArr5.length - i11;
                    if (length2 >= i12) {
                        i.W(objArr5, objArr5, i11, i10, f8);
                    } else {
                        i.W(objArr5, objArr5, i11, i10, i10 + length2);
                        Object[] objArr6 = this.f4281g;
                        i.W(objArr6, objArr6, 0, this.f4280f + length2, f8);
                    }
                }
                this.f4280f = i11;
                f8 -= size;
                if (f8 < 0) {
                    f8 += this.f4281g.length;
                }
            } else {
                int i13 = f8 + size;
                if (f8 < f7) {
                    int i14 = size + f7;
                    Object[] objArr7 = this.f4281g;
                    if (i14 > objArr7.length) {
                        if (i13 >= objArr7.length) {
                            i13 -= objArr7.length;
                        } else {
                            int length3 = f7 - (i14 - objArr7.length);
                            i.W(objArr7, objArr7, 0, length3, f7);
                            Object[] objArr8 = this.f4281g;
                            i.W(objArr8, objArr8, i13, f8, length3);
                        }
                    }
                    i.W(objArr7, objArr7, i13, f8, f7);
                } else {
                    Object[] objArr9 = this.f4281g;
                    i.W(objArr9, objArr9, size, 0, f7);
                    Object[] objArr10 = this.f4281g;
                    if (i13 >= objArr10.length) {
                        i.W(objArr10, objArr10, i13 - objArr10.length, f8, objArr10.length);
                    } else {
                        i.W(objArr10, objArr10, 0, objArr10.length - size, objArr10.length);
                        Object[] objArr11 = this.f4281g;
                        i.W(objArr11, objArr11, i13, f8, objArr11.length - size);
                    }
                }
            }
            c(f8, collection);
            return true;
        }
        throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i8);
    }

    public final void addLast(E e) {
        d(a() + 1);
        this.f4281g[f(a() + this.f4280f)] = e;
        this.f4282h = a() + 1;
    }

    @Override // g5.e
    public final E b(int i7) {
        int i8 = this.f4282h;
        if (i7 < 0 || i7 >= i8) {
            throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i8);
        } else if (i7 == q2.a.x(this)) {
            if (isEmpty()) {
                throw new NoSuchElementException("ArrayDeque is empty.");
            }
            int f7 = f(q2.a.x(this) + this.f4280f);
            Object[] objArr = this.f4281g;
            E e = (E) objArr[f7];
            objArr[f7] = null;
            this.f4282h--;
            return e;
        } else if (i7 == 0) {
            return removeFirst();
        } else {
            int f8 = f(this.f4280f + i7);
            Object[] objArr2 = this.f4281g;
            E e7 = (E) objArr2[f8];
            if (i7 < (this.f4282h >> 1)) {
                int i9 = this.f4280f;
                if (f8 >= i9) {
                    i.W(objArr2, objArr2, i9 + 1, i9, f8);
                } else {
                    i.W(objArr2, objArr2, 1, 0, f8);
                    Object[] objArr3 = this.f4281g;
                    objArr3[0] = objArr3[objArr3.length - 1];
                    int i10 = this.f4280f;
                    i.W(objArr3, objArr3, i10 + 1, i10, objArr3.length - 1);
                }
                Object[] objArr4 = this.f4281g;
                int i11 = this.f4280f;
                objArr4[i11] = null;
                this.f4280f = e(i11);
            } else {
                int f9 = f(q2.a.x(this) + this.f4280f);
                Object[] objArr5 = this.f4281g;
                int i12 = f8 + 1;
                if (f8 <= f9) {
                    i.W(objArr5, objArr5, f8, i12, f9 + 1);
                } else {
                    i.W(objArr5, objArr5, f8, i12, objArr5.length);
                    Object[] objArr6 = this.f4281g;
                    objArr6[objArr6.length - 1] = objArr6[0];
                    i.W(objArr6, objArr6, 0, 1, f9 + 1);
                }
                this.f4281g[f9] = null;
            }
            this.f4282h--;
            return e7;
        }
    }

    public final void c(int i7, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f4281g.length;
        while (i7 < length && it.hasNext()) {
            this.f4281g[i7] = it.next();
            i7++;
        }
        int i8 = this.f4280f;
        for (int i9 = 0; i9 < i8 && it.hasNext(); i9++) {
            this.f4281g[i9] = it.next();
        }
        this.f4282h = collection.size() + a();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int f7 = f(this.f4282h + this.f4280f);
        int i7 = this.f4280f;
        if (i7 < f7) {
            i.Z(this.f4281g, i7, f7);
        } else if (!isEmpty()) {
            Object[] objArr = this.f4281g;
            i.Z(objArr, this.f4280f, objArr.length);
            i.Z(this.f4281g, 0, f7);
        }
        this.f4280f = 0;
        this.f4282h = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i7) {
        if (i7 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f4281g;
        if (i7 <= objArr.length) {
            return;
        }
        if (objArr == f4279i) {
            if (i7 < 10) {
                i7 = 10;
            }
            this.f4281g = new Object[i7];
            return;
        }
        int length = objArr.length;
        int i8 = length + (length >> 1);
        if (i8 - i7 < 0) {
            i8 = i7;
        }
        if (i8 - 2147483639 > 0) {
            i8 = i7 > 2147483639 ? SubsamplingScaleImageView.TILE_SIZE_AUTO : 2147483639;
        }
        Object[] objArr2 = new Object[i8];
        i.W(objArr, objArr2, 0, this.f4280f, objArr.length);
        Object[] objArr3 = this.f4281g;
        int length2 = objArr3.length;
        int i9 = this.f4280f;
        i.W(objArr3, objArr2, length2 - i9, 0, i9);
        this.f4280f = 0;
        this.f4281g = objArr2;
    }

    public final int e(int i7) {
        Object[] objArr = this.f4281g;
        r5.h.f(objArr, "<this>");
        if (i7 == objArr.length - 1) {
            return 0;
        }
        return i7 + 1;
    }

    public final int f(int i7) {
        Object[] objArr = this.f4281g;
        return i7 >= objArr.length ? i7 - objArr.length : i7;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i7) {
        int a7 = a();
        if (i7 < 0 || i7 >= a7) {
            throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + a7);
        }
        return (E) this.f4281g[f(this.f4280f + i7)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int f7 = f(a() + this.f4280f);
        int i7 = this.f4280f;
        if (i7 < f7) {
            while (i7 < f7) {
                if (!r5.h.a(obj, this.f4281g[i7])) {
                    i7++;
                }
            }
            return -1;
        } else if (i7 < f7) {
            return -1;
        } else {
            int length = this.f4281g.length;
            while (true) {
                if (i7 >= length) {
                    for (int i8 = 0; i8 < f7; i8++) {
                        if (r5.h.a(obj, this.f4281g[i8])) {
                            i7 = i8 + this.f4281g.length;
                        }
                    }
                    return -1;
                } else if (r5.h.a(obj, this.f4281g[i7])) {
                    break;
                } else {
                    i7++;
                }
            }
        }
        return i7 - this.f4280f;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return a() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int f7 = f(this.f4282h + this.f4280f);
        int i7 = this.f4280f;
        if (i7 < f7) {
            length = f7 - 1;
            if (i7 <= length) {
                while (!r5.h.a(obj, this.f4281g[length])) {
                    if (length != i7) {
                        length--;
                    }
                }
                return length - this.f4280f;
            }
            return -1;
        }
        if (i7 > f7) {
            int i8 = f7 - 1;
            while (true) {
                if (-1 >= i8) {
                    Object[] objArr = this.f4281g;
                    r5.h.f(objArr, "<this>");
                    length = objArr.length - 1;
                    int i9 = this.f4280f;
                    if (i9 <= length) {
                        while (!r5.h.a(obj, this.f4281g[length])) {
                            if (length != i9) {
                                length--;
                            }
                        }
                    }
                } else if (r5.h.a(obj, this.f4281g[i8])) {
                    length = i8 + this.f4281g.length;
                    break;
                } else {
                    i8--;
                }
            }
            return length - this.f4280f;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        b(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection<? extends Object> collection) {
        int i7;
        r5.h.f(collection, "elements");
        boolean z6 = false;
        z6 = false;
        z6 = false;
        if (!isEmpty()) {
            if ((this.f4281g.length == 0 ? (byte) 1 : (byte) 0) == 0) {
                int f7 = f(this.f4282h + this.f4280f);
                int i8 = this.f4280f;
                if (i8 < f7) {
                    i7 = i8;
                    while (i8 < f7) {
                        Object obj = this.f4281g[i8];
                        if (!collection.contains(obj)) {
                            this.f4281g[i7] = obj;
                            i7++;
                        } else {
                            z6 = true;
                        }
                        i8++;
                    }
                    i.Z(this.f4281g, i7, f7);
                } else {
                    int length = this.f4281g.length;
                    boolean z7 = false;
                    int i9 = i8;
                    while (i8 < length) {
                        Object[] objArr = this.f4281g;
                        Object obj2 = objArr[i8];
                        objArr[i8] = null;
                        if (!collection.contains(obj2)) {
                            this.f4281g[i9] = obj2;
                            i9++;
                        } else {
                            z7 = true;
                        }
                        i8++;
                    }
                    int f8 = f(i9);
                    for (int i10 = 0; i10 < f7; i10++) {
                        Object[] objArr2 = this.f4281g;
                        Object obj3 = objArr2[i10];
                        objArr2[i10] = null;
                        if (!collection.contains(obj3)) {
                            this.f4281g[f8] = obj3;
                            f8 = e(f8);
                        } else {
                            z7 = true;
                        }
                    }
                    i7 = f8;
                    z6 = z7;
                }
                if (z6) {
                    int i11 = i7 - this.f4280f;
                    if (i11 < 0) {
                        i11 += this.f4281g.length;
                    }
                    this.f4282h = i11;
                }
            }
        }
        return z6;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f4281g;
        int i7 = this.f4280f;
        E e = (E) objArr[i7];
        objArr[i7] = null;
        this.f4280f = e(i7);
        this.f4282h = a() - 1;
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection<? extends Object> collection) {
        int i7;
        r5.h.f(collection, "elements");
        boolean z6 = false;
        z6 = false;
        z6 = false;
        if (!isEmpty()) {
            if ((this.f4281g.length == 0 ? (byte) 1 : (byte) 0) == 0) {
                int f7 = f(this.f4282h + this.f4280f);
                int i8 = this.f4280f;
                if (i8 < f7) {
                    i7 = i8;
                    while (i8 < f7) {
                        Object obj = this.f4281g[i8];
                        if (collection.contains(obj)) {
                            this.f4281g[i7] = obj;
                            i7++;
                        } else {
                            z6 = true;
                        }
                        i8++;
                    }
                    i.Z(this.f4281g, i7, f7);
                } else {
                    int length = this.f4281g.length;
                    boolean z7 = false;
                    int i9 = i8;
                    while (i8 < length) {
                        Object[] objArr = this.f4281g;
                        Object obj2 = objArr[i8];
                        objArr[i8] = null;
                        if (collection.contains(obj2)) {
                            this.f4281g[i9] = obj2;
                            i9++;
                        } else {
                            z7 = true;
                        }
                        i8++;
                    }
                    int f8 = f(i9);
                    for (int i10 = 0; i10 < f7; i10++) {
                        Object[] objArr2 = this.f4281g;
                        Object obj3 = objArr2[i10];
                        objArr2[i10] = null;
                        if (collection.contains(obj3)) {
                            this.f4281g[f8] = obj3;
                            f8 = e(f8);
                        } else {
                            z7 = true;
                        }
                    }
                    i7 = f8;
                    z6 = z7;
                }
                if (z6) {
                    int i11 = i7 - this.f4280f;
                    if (i11 < 0) {
                        i11 += this.f4281g.length;
                    }
                    this.f4282h = i11;
                }
            }
        }
        return z6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i7, E e) {
        int a7 = a();
        if (i7 >= 0 && i7 < a7) {
            int f7 = f(this.f4280f + i7);
            Object[] objArr = this.f4281g;
            E e7 = (E) objArr[f7];
            objArr[f7] = e;
            return e7;
        }
        throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + a7);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final <T> T[] toArray(T[] tArr) {
        r5.h.f(tArr, "array");
        int length = tArr.length;
        int i7 = this.f4282h;
        if (length < i7) {
            Object newInstance = Array.newInstance(tArr.getClass().getComponentType(), i7);
            r5.h.d(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            tArr = (T[]) ((Object[]) newInstance);
        }
        int f7 = f(this.f4282h + this.f4280f);
        int i8 = this.f4280f;
        if (i8 < f7) {
            i.Y(this.f4281g, tArr, i8, f7, 2);
        } else if (!isEmpty()) {
            Object[] objArr = this.f4281g;
            i.W(objArr, tArr, 0, this.f4280f, objArr.length);
            Object[] objArr2 = this.f4281g;
            i.W(objArr2, tArr, objArr2.length - this.f4280f, 0, f7);
        }
        int i9 = this.f4282h;
        if (i9 < tArr.length) {
            tArr[i9] = null;
        }
        return tArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends E> collection) {
        r5.h.f(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        d(collection.size() + a());
        c(f(a() + this.f4280f), collection);
        return true;
    }
}
