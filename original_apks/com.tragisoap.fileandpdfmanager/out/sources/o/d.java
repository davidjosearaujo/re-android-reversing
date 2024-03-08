package o;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import l0.z;
import o.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d<E> implements Collection<E>, Set<E> {

    /* renamed from: j */
    public static final int[] f5182j = new int[0];

    /* renamed from: k */
    public static final Object[] f5183k = new Object[0];

    /* renamed from: l */
    public static Object[] f5184l;
    public static int m;

    /* renamed from: n */
    public static Object[] f5185n;

    /* renamed from: o */
    public static int f5186o;

    /* renamed from: f */
    public int[] f5187f = f5182j;

    /* renamed from: g */
    public Object[] f5188g = f5183k;

    /* renamed from: h */
    public int f5189h = 0;

    /* renamed from: i */
    public c f5190i;

    public static void b(int[] iArr, Object[] objArr, int i7) {
        if (iArr.length == 8) {
            synchronized (d.class) {
                if (f5186o < 10) {
                    objArr[0] = f5185n;
                    objArr[1] = iArr;
                    for (int i8 = i7 - 1; i8 >= 2; i8--) {
                        objArr[i8] = null;
                    }
                    f5185n = objArr;
                    f5186o++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (d.class) {
                if (m < 10) {
                    objArr[0] = f5184l;
                    objArr[1] = iArr;
                    for (int i9 = i7 - 1; i9 >= 2; i9--) {
                        objArr[i9] = null;
                    }
                    f5184l = objArr;
                    m++;
                }
            }
        }
    }

    public final void a(int i7) {
        if (i7 == 8) {
            synchronized (d.class) {
                Object[] objArr = f5185n;
                if (objArr != null) {
                    this.f5188g = objArr;
                    f5185n = (Object[]) objArr[0];
                    this.f5187f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f5186o--;
                    return;
                }
            }
        } else if (i7 == 4) {
            synchronized (d.class) {
                Object[] objArr2 = f5184l;
                if (objArr2 != null) {
                    this.f5188g = objArr2;
                    f5184l = (Object[]) objArr2[0];
                    this.f5187f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    m--;
                    return;
                }
            }
        }
        this.f5187f = new int[i7];
        this.f5188g = new Object[i7];
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(E e) {
        int i7;
        int i8;
        if (e == null) {
            i8 = d();
            i7 = 0;
        } else {
            int hashCode = e.hashCode();
            i8 = c(hashCode, e);
            i7 = hashCode;
        }
        if (i8 >= 0) {
            return false;
        }
        int i9 = ~i8;
        int i10 = this.f5189h;
        int[] iArr = this.f5187f;
        if (i10 >= iArr.length) {
            int i11 = 4;
            if (i10 >= 8) {
                i11 = (i10 >> 1) + i10;
            } else if (i10 >= 4) {
                i11 = 8;
            }
            Object[] objArr = this.f5188g;
            a(i11);
            int[] iArr2 = this.f5187f;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f5188g, 0, objArr.length);
            }
            b(iArr, objArr, this.f5189h);
        }
        int i12 = this.f5189h;
        if (i9 < i12) {
            int[] iArr3 = this.f5187f;
            int i13 = i9 + 1;
            System.arraycopy(iArr3, i9, iArr3, i13, i12 - i9);
            Object[] objArr2 = this.f5188g;
            System.arraycopy(objArr2, i9, objArr2, i13, this.f5189h - i9);
        }
        this.f5187f[i9] = i7;
        this.f5188g[i9] = e;
        this.f5189h++;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends E> collection) {
        int size = collection.size() + this.f5189h;
        int[] iArr = this.f5187f;
        boolean z6 = false;
        if (iArr.length < size) {
            Object[] objArr = this.f5188g;
            a(size);
            int i7 = this.f5189h;
            if (i7 > 0) {
                System.arraycopy(iArr, 0, this.f5187f, 0, i7);
                System.arraycopy(objArr, 0, this.f5188g, 0, this.f5189h);
            }
            b(iArr, objArr, this.f5189h);
        }
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            z6 |= add(it.next());
        }
        return z6;
    }

    public final int c(int i7, Object obj) {
        int i8 = this.f5189h;
        if (i8 == 0) {
            return -1;
        }
        int i9 = z.i(i8, i7, this.f5187f);
        if (i9 < 0 || obj.equals(this.f5188g[i9])) {
            return i9;
        }
        int i10 = i9 + 1;
        while (i10 < i8 && this.f5187f[i10] == i7) {
            if (obj.equals(this.f5188g[i10])) {
                return i10;
            }
            i10++;
        }
        for (int i11 = i9 - 1; i11 >= 0 && this.f5187f[i11] == i7; i11--) {
            if (obj.equals(this.f5188g[i11])) {
                return i11;
            }
        }
        return ~i10;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int i7 = this.f5189h;
        if (i7 != 0) {
            b(this.f5187f, this.f5188g, i7);
            this.f5187f = f5182j;
            this.f5188g = f5183k;
            this.f5189h = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int d() {
        int i7 = this.f5189h;
        if (i7 == 0) {
            return -1;
        }
        int i8 = z.i(i7, 0, this.f5187f);
        if (i8 < 0 || this.f5188g[i8] == null) {
            return i8;
        }
        int i9 = i8 + 1;
        while (i9 < i7 && this.f5187f[i9] == 0) {
            if (this.f5188g[i9] == null) {
                return i9;
            }
            i9++;
        }
        for (int i10 = i8 - 1; i10 >= 0 && this.f5187f[i10] == 0; i10--) {
            if (this.f5188g[i10] == null) {
                return i10;
            }
        }
        return ~i9;
    }

    public final void e(int i7) {
        Object[] objArr = this.f5188g;
        Object obj = objArr[i7];
        int i8 = this.f5189h;
        if (i8 <= 1) {
            b(this.f5187f, objArr, i8);
            this.f5187f = f5182j;
            this.f5188g = f5183k;
            this.f5189h = 0;
            return;
        }
        int[] iArr = this.f5187f;
        int i9 = 8;
        if (iArr.length <= 8 || i8 >= iArr.length / 3) {
            int i10 = i8 - 1;
            this.f5189h = i10;
            if (i7 < i10) {
                int i11 = i7 + 1;
                System.arraycopy(iArr, i11, iArr, i7, i10 - i7);
                Object[] objArr2 = this.f5188g;
                System.arraycopy(objArr2, i11, objArr2, i7, this.f5189h - i7);
            }
            this.f5188g[this.f5189h] = null;
            return;
        }
        if (i8 > 8) {
            i9 = i8 + (i8 >> 1);
        }
        a(i9);
        this.f5189h--;
        if (i7 > 0) {
            System.arraycopy(iArr, 0, this.f5187f, 0, i7);
            System.arraycopy(objArr, 0, this.f5188g, 0, i7);
        }
        int i12 = this.f5189h;
        if (i7 < i12) {
            int i13 = i7 + 1;
            System.arraycopy(iArr, i13, this.f5187f, i7, i12 - i7);
            System.arraycopy(objArr, i13, this.f5188g, i7, this.f5189h - i7);
        }
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f5189h != set.size()) {
                return false;
            }
            for (int i7 = 0; i7 < this.f5189h; i7++) {
                try {
                    if (!set.contains(this.f5188g[i7])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f5187f;
        int i7 = this.f5189h;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            i8 += iArr[i9];
        }
        return i8;
    }

    public final int indexOf(Object obj) {
        return obj == null ? d() : c(obj.hashCode(), obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f5189h <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        if (this.f5190i == null) {
            this.f5190i = new c(this);
        }
        c cVar = this.f5190i;
        if (cVar.f5201b == null) {
            cVar.f5201b = new g.c();
        }
        return (Iterator<E>) cVar.f5201b.iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        e(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z6 = false;
        while (it.hasNext()) {
            z6 |= remove(it.next());
        }
        return z6;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<?> collection) {
        boolean z6 = false;
        for (int i7 = this.f5189h - 1; i7 >= 0; i7--) {
            if (!collection.contains(this.f5188g[i7])) {
                e(i7);
                z6 = true;
            }
        }
        return z6;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f5189h;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int i7 = this.f5189h;
        Object[] objArr = new Object[i7];
        System.arraycopy(this.f5188g, 0, objArr, 0, i7);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f5189h) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f5189h));
        }
        System.arraycopy(this.f5188g, 0, tArr, 0, this.f5189h);
        int length = tArr.length;
        int i7 = this.f5189h;
        if (length > i7) {
            tArr[i7] = null;
        }
        return tArr;
    }

    @Override // java.lang.Object
    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f5189h * 14);
        sb.append('{');
        for (int i7 = 0; i7 < this.f5189h; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            Object obj = this.f5188g[i7];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
