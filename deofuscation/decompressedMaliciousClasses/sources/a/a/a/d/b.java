package a.a.a.d;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class b<E> implements Collection<E>, Set<E> {
    private static short[] $ = {28772, 28770, 30676, 30680, 16829, 16865, 16893, 16892, 16870, 16821, 16838, 16880, 16865, 16828};
    private static final int[] f = new int[0];
    private static final Object[] g = new Object[0];
    static Object[] h;
    static int i;
    static Object[] j;
    static int k;

    /* renamed from: a  reason: collision with root package name */
    final boolean f87a;

    /* renamed from: b  reason: collision with root package name */
    int[] f88b;
    Object[] c;
    int d;
    f<E, E> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class a extends f<E, E> {
        private static short[] $ = {3324, 3325, 3302, 3250, 3315, 3250, 3327, 3315, 3298, 2053, 2052, 2079, 2123, 2058, 2123, 2054, 2058, 2075};

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }

        a() {
        }

        @Override // a.a.a.d.f
        protected void a() {
            b.this.clear();
        }

        @Override // a.a.a.d.f
        protected Object b(int i, int i2) {
            return b.this.c[i];
        }

        @Override // a.a.a.d.f
        protected Map<E, E> c() {
            throw new UnsupportedOperationException($(0, 9, 3218));
        }

        @Override // a.a.a.d.f
        protected int d() {
            return b.this.d;
        }

        @Override // a.a.a.d.f
        protected int e(Object obj) {
            return b.this.e(obj);
        }

        @Override // a.a.a.d.f
        protected int f(Object obj) {
            return b.this.e(obj);
        }

        @Override // a.a.a.d.f
        protected void g(E e, E e2) {
            b.this.add(e);
        }

        @Override // a.a.a.d.f
        protected void h(int i) {
            b.this.h(i);
        }

        @Override // a.a.a.d.f
        protected E i(int i, E e) {
            throw new UnsupportedOperationException($(9, 18, 2155));
        }
    }

    private static String $(int i2, int i3, int i4) {
        char[] cArr = new char[i3 - i2];
        for (int i5 = 0; i5 < i3 - i2; i5++) {
            cArr[i5] = (char) ($[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }

    public b() {
        this(0, false);
    }

    public b(int i2, boolean z) {
        this.f87a = z;
        if (i2 == 0) {
            this.f88b = f;
            this.c = g;
        } else {
            a(i2);
        }
        this.d = 0;
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                if (j != null) {
                    Object[] objArr = j;
                    this.c = objArr;
                    j = (Object[]) objArr[0];
                    this.f88b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    k--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                if (h != null) {
                    Object[] objArr2 = h;
                    this.c = objArr2;
                    h = (Object[]) objArr2[0];
                    this.f88b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    i--;
                    return;
                }
            }
        }
        this.f88b = new int[i2];
        this.c = new Object[i2];
    }

    private static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (k < 10) {
                    objArr[0] = j;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    j = objArr;
                    k++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (i < 10) {
                    objArr[0] = h;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    h = objArr;
                    i++;
                }
            }
        }
    }

    private f<E, E> d() {
        if (this.e == null) {
            this.e = new a();
        }
        return this.e;
    }

    private int f(Object obj, int i2) {
        int i3 = this.d;
        if (i3 == 0) {
            return -1;
        }
        int a2 = c.a(this.f88b, i3, i2);
        if (a2 < 0 || obj.equals(this.c[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f88b[i4] == i2) {
            if (obj.equals(this.c[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = a2 - 1; i5 >= 0 && this.f88b[i5] == i2; i5--) {
            if (obj.equals(this.c[i5])) {
                return i5;
            }
        }
        return ~i4;
    }

    private int g() {
        int i2 = this.d;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.f88b, i2, 0);
        if (a2 < 0 || this.c[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f88b[i3] == 0) {
            if (this.c[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a2 - 1; i4 >= 0 && this.f88b[i4] == 0; i4--) {
            if (this.c[i4] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i2;
        int i3;
        if (e == null) {
            i3 = g();
            i2 = 0;
        } else {
            int identityHashCode = this.f87a ? System.identityHashCode(e) : e.hashCode();
            i3 = f(e, identityHashCode);
            i2 = identityHashCode;
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = ~i3;
        int i5 = this.d;
        if (i5 >= this.f88b.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f88b;
            Object[] objArr = this.c;
            a(i6);
            int[] iArr2 = this.f88b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.c, 0, objArr.length);
            }
            c(iArr, objArr, this.d);
        }
        int i7 = this.d;
        if (i4 < i7) {
            int[] iArr3 = this.f88b;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.c;
            System.arraycopy(objArr2, i4, objArr2, i8, this.d - i4);
        }
        this.f88b[i4] = i2;
        this.c[i4] = e;
        this.d++;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        b(this.d + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    public void b(int i2) {
        int[] iArr = this.f88b;
        if (iArr.length < i2) {
            Object[] objArr = this.c;
            a(i2);
            int i3 = this.d;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f88b, 0, i3);
                System.arraycopy(objArr, 0, this.c, 0, this.d);
            }
            c(iArr, objArr, this.d);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.d;
        if (i2 != 0) {
            c(this.f88b, this.c, i2);
            this.f88b = f;
            this.c = g;
            this.d = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return e(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int e(Object obj) {
        if (obj == null) {
            return g();
        }
        return f(obj, this.f87a ? System.identityHashCode(obj) : obj.hashCode());
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.d; i2++) {
                try {
                    if (!set.contains(i(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public E h(int i2) {
        Object[] objArr = this.c;
        E e = (E) objArr[i2];
        int i3 = this.d;
        if (i3 <= 1) {
            c(this.f88b, objArr, i3);
            this.f88b = f;
            this.c = g;
            this.d = 0;
        } else {
            int[] iArr = this.f88b;
            int i4 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i5 = this.d - 1;
                this.d = i5;
                if (i2 < i5) {
                    int[] iArr2 = this.f88b;
                    int i6 = i2 + 1;
                    System.arraycopy(iArr2, i6, iArr2, i2, i5 - i2);
                    Object[] objArr2 = this.c;
                    System.arraycopy(objArr2, i6, objArr2, i2, this.d - i2);
                }
                this.c[this.d] = null;
            } else {
                if (i3 > 8) {
                    i4 = i3 + (i3 >> 1);
                }
                int[] iArr3 = this.f88b;
                Object[] objArr3 = this.c;
                a(i4);
                this.d--;
                if (i2 > 0) {
                    System.arraycopy(iArr3, 0, this.f88b, 0, i2);
                    System.arraycopy(objArr3, 0, this.c, 0, i2);
                }
                int i7 = this.d;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, this.f88b, i2, i7 - i2);
                    System.arraycopy(objArr3, i8, this.c, i2, this.d - i2);
                }
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int[] iArr = this.f88b;
        int i2 = this.d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public E i(int i2) {
        return (E) this.c[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.d <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int e = e(obj);
        if (e < 0) {
            return false;
        }
        h(e);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.d - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.c[i2])) {
                h(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.d;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.d;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.c, 0, objArr, 0, i2);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        T[] tArr2 = tArr;
        if (tArr2.length < this.d) {
            tArr2 = (T[]) ((Object[]) Array.newInstance(tArr2.getClass().getComponentType(), this.d));
        }
        System.arraycopy(this.c, 0, tArr2, 0, this.d);
        int length = tArr2.length;
        int i2 = this.d;
        if (length > i2) {
            tArr2[i2] = null;
        }
        return tArr2;
    }

    @Override // java.lang.Object
    public String toString() {
        if (isEmpty()) {
            return $(0, 2, 28703);
        }
        StringBuilder sb = new StringBuilder(this.d * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.d; i2++) {
            if (i2 > 0) {
                sb.append($(2, 4, 30712));
            }
            E i3 = i(i2);
            if (i3 != this) {
                sb.append(i3);
            } else {
                sb.append($(4, 14, 16789));
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
