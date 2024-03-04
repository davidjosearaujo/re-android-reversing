package o;

import java.util.ConcurrentModificationException;
import java.util.Map;
import l0.z;

/* loaded from: classes.dex */
public class h<K, V> {

    /* renamed from: i */
    public static Object[] f5215i;

    /* renamed from: j */
    public static int f5216j;

    /* renamed from: k */
    public static Object[] f5217k;

    /* renamed from: l */
    public static int f5218l;

    /* renamed from: f */
    public int[] f5219f;

    /* renamed from: g */
    public Object[] f5220g;

    /* renamed from: h */
    public int f5221h;

    public h() {
        this.f5219f = z.D;
        this.f5220g = z.E;
        this.f5221h = 0;
    }

    public h(int i7) {
        if (i7 == 0) {
            this.f5219f = z.D;
            this.f5220g = z.E;
        } else {
            a(i7);
        }
        this.f5221h = 0;
    }

    private void a(int i7) {
        if (i7 == 8) {
            synchronized (h.class) {
                Object[] objArr = f5217k;
                if (objArr != null) {
                    this.f5220g = objArr;
                    f5217k = (Object[]) objArr[0];
                    this.f5219f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f5218l--;
                    return;
                }
            }
        } else if (i7 == 4) {
            synchronized (h.class) {
                Object[] objArr2 = f5215i;
                if (objArr2 != null) {
                    this.f5220g = objArr2;
                    f5215i = (Object[]) objArr2[0];
                    this.f5219f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f5216j--;
                    return;
                }
            }
        }
        this.f5219f = new int[i7];
        this.f5220g = new Object[i7 << 1];
    }

    public static void c(int[] iArr, Object[] objArr, int i7) {
        if (iArr.length == 8) {
            synchronized (h.class) {
                if (f5218l < 10) {
                    objArr[0] = f5217k;
                    objArr[1] = iArr;
                    for (int i8 = (i7 << 1) - 1; i8 >= 2; i8--) {
                        objArr[i8] = null;
                    }
                    f5217k = objArr;
                    f5218l++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (h.class) {
                if (f5216j < 10) {
                    objArr[0] = f5215i;
                    objArr[1] = iArr;
                    for (int i9 = (i7 << 1) - 1; i9 >= 2; i9--) {
                        objArr[i9] = null;
                    }
                    f5215i = objArr;
                    f5216j++;
                }
            }
        }
    }

    public final void b(int i7) {
        int i8 = this.f5221h;
        int[] iArr = this.f5219f;
        if (iArr.length < i7) {
            Object[] objArr = this.f5220g;
            a(i7);
            if (this.f5221h > 0) {
                System.arraycopy(iArr, 0, this.f5219f, 0, i8);
                System.arraycopy(objArr, 0, this.f5220g, 0, i8 << 1);
            }
            c(iArr, objArr, i8);
        }
        if (this.f5221h != i8) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i7 = this.f5221h;
        if (i7 > 0) {
            int[] iArr = this.f5219f;
            Object[] objArr = this.f5220g;
            this.f5219f = z.D;
            this.f5220g = z.E;
            this.f5221h = 0;
            c(iArr, objArr, i7);
        }
        if (this.f5221h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public final boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public final int d(int i7, Object obj) {
        int i8 = this.f5221h;
        if (i8 == 0) {
            return -1;
        }
        try {
            int i9 = z.i(i8, i7, this.f5219f);
            if (i9 >= 0 && !obj.equals(this.f5220g[i9 << 1])) {
                int i10 = i9 + 1;
                while (i10 < i8 && this.f5219f[i10] == i7) {
                    if (obj.equals(this.f5220g[i10 << 1])) {
                        return i10;
                    }
                    i10++;
                }
                for (int i11 = i9 - 1; i11 >= 0 && this.f5219f[i11] == i7; i11--) {
                    if (obj.equals(this.f5220g[i11 << 1])) {
                        return i11;
                    }
                }
                return ~i10;
            }
            return i9;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int e(Object obj) {
        return obj == null ? f() : d(obj.hashCode(), obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f5221h != hVar.f5221h) {
                return false;
            }
            for (int i7 = 0; i7 < this.f5221h; i7++) {
                try {
                    K h7 = h(i7);
                    V l6 = l(i7);
                    Object orDefault = hVar.getOrDefault(h7, null);
                    if (l6 == null) {
                        if (orDefault != null || !hVar.containsKey(h7)) {
                            return false;
                        }
                    } else if (!l6.equals(orDefault)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.f5221h != map.size()) {
                return false;
            }
            for (int i8 = 0; i8 < this.f5221h; i8++) {
                try {
                    K h8 = h(i8);
                    V l7 = l(i8);
                    Object obj2 = map.get(h8);
                    if (l7 == null) {
                        if (obj2 != null || !map.containsKey(h8)) {
                            return false;
                        }
                    } else if (!l7.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        int i7 = this.f5221h;
        if (i7 == 0) {
            return -1;
        }
        try {
            int i8 = z.i(i7, 0, this.f5219f);
            if (i8 >= 0 && this.f5220g[i8 << 1] != null) {
                int i9 = i8 + 1;
                while (i9 < i7 && this.f5219f[i9] == 0) {
                    if (this.f5220g[i9 << 1] == null) {
                        return i9;
                    }
                    i9++;
                }
                for (int i10 = i8 - 1; i10 >= 0 && this.f5219f[i10] == 0; i10--) {
                    if (this.f5220g[i10 << 1] == null) {
                        return i10;
                    }
                }
                return ~i9;
            }
            return i8;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int g(Object obj) {
        int i7 = this.f5221h * 2;
        Object[] objArr = this.f5220g;
        if (obj == null) {
            for (int i8 = 1; i8 < i7; i8 += 2) {
                if (objArr[i8] == null) {
                    return i8 >> 1;
                }
            }
            return -1;
        }
        for (int i9 = 1; i9 < i7; i9 += 2) {
            if (obj.equals(objArr[i9])) {
                return i9 >> 1;
            }
        }
        return -1;
    }

    public final V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public final V getOrDefault(Object obj, V v6) {
        int e = e(obj);
        return e >= 0 ? (V) this.f5220g[(e << 1) + 1] : v6;
    }

    public final K h(int i7) {
        return (K) this.f5220g[i7 << 1];
    }

    public int hashCode() {
        int[] iArr = this.f5219f;
        Object[] objArr = this.f5220g;
        int i7 = this.f5221h;
        int i8 = 1;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i7) {
            Object obj = objArr[i8];
            i10 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i9];
            i9++;
            i8 += 2;
        }
        return i10;
    }

    public void i(b bVar) {
        int i7 = bVar.f5221h;
        b(this.f5221h + i7);
        if (this.f5221h != 0) {
            for (int i8 = 0; i8 < i7; i8++) {
                put(bVar.h(i8), bVar.l(i8));
            }
        } else if (i7 > 0) {
            System.arraycopy(bVar.f5219f, 0, this.f5219f, 0, i7);
            System.arraycopy(bVar.f5220g, 0, this.f5220g, 0, i7 << 1);
            this.f5221h = i7;
        }
    }

    public final boolean isEmpty() {
        return this.f5221h <= 0;
    }

    public V j(int i7) {
        Object[] objArr = this.f5220g;
        int i8 = i7 << 1;
        V v6 = (V) objArr[i8 + 1];
        int i9 = this.f5221h;
        int i10 = 0;
        if (i9 <= 1) {
            c(this.f5219f, objArr, i9);
            this.f5219f = z.D;
            this.f5220g = z.E;
        } else {
            int i11 = i9 - 1;
            int[] iArr = this.f5219f;
            if (iArr.length <= 8 || i9 >= iArr.length / 3) {
                if (i7 < i11) {
                    int i12 = i7 + 1;
                    int i13 = i11 - i7;
                    System.arraycopy(iArr, i12, iArr, i7, i13);
                    Object[] objArr2 = this.f5220g;
                    System.arraycopy(objArr2, i12 << 1, objArr2, i8, i13 << 1);
                }
                Object[] objArr3 = this.f5220g;
                int i14 = i11 << 1;
                objArr3[i14] = null;
                objArr3[i14 + 1] = null;
            } else {
                a(i9 > 8 ? i9 + (i9 >> 1) : 8);
                if (i9 != this.f5221h) {
                    throw new ConcurrentModificationException();
                }
                if (i7 > 0) {
                    System.arraycopy(iArr, 0, this.f5219f, 0, i7);
                    System.arraycopy(objArr, 0, this.f5220g, 0, i8);
                }
                if (i7 < i11) {
                    int i15 = i7 + 1;
                    int i16 = i11 - i7;
                    System.arraycopy(iArr, i15, this.f5219f, i7, i16);
                    System.arraycopy(objArr, i15 << 1, this.f5220g, i8, i16 << 1);
                }
            }
            i10 = i11;
        }
        if (i9 == this.f5221h) {
            this.f5221h = i10;
            return v6;
        }
        throw new ConcurrentModificationException();
    }

    public V k(int i7, V v6) {
        int i8 = (i7 << 1) + 1;
        Object[] objArr = this.f5220g;
        V v7 = (V) objArr[i8];
        objArr[i8] = v6;
        return v7;
    }

    public final V l(int i7) {
        return (V) this.f5220g[(i7 << 1) + 1];
    }

    public V put(K k6, V v6) {
        int i7;
        int d7;
        int i8 = this.f5221h;
        if (k6 == null) {
            d7 = f();
            i7 = 0;
        } else {
            int hashCode = k6.hashCode();
            i7 = hashCode;
            d7 = d(hashCode, k6);
        }
        if (d7 >= 0) {
            int i9 = (d7 << 1) + 1;
            Object[] objArr = this.f5220g;
            V v7 = (V) objArr[i9];
            objArr[i9] = v6;
            return v7;
        }
        int i10 = ~d7;
        int[] iArr = this.f5219f;
        if (i8 >= iArr.length) {
            int i11 = 4;
            if (i8 >= 8) {
                i11 = (i8 >> 1) + i8;
            } else if (i8 >= 4) {
                i11 = 8;
            }
            Object[] objArr2 = this.f5220g;
            a(i11);
            if (i8 != this.f5221h) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f5219f;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f5220g, 0, objArr2.length);
            }
            c(iArr, objArr2, i8);
        }
        if (i10 < i8) {
            int[] iArr3 = this.f5219f;
            int i12 = i10 + 1;
            System.arraycopy(iArr3, i10, iArr3, i12, i8 - i10);
            Object[] objArr3 = this.f5220g;
            System.arraycopy(objArr3, i10 << 1, objArr3, i12 << 1, (this.f5221h - i10) << 1);
        }
        int i13 = this.f5221h;
        if (i8 == i13) {
            int[] iArr4 = this.f5219f;
            if (i10 < iArr4.length) {
                iArr4[i10] = i7;
                Object[] objArr4 = this.f5220g;
                int i14 = i10 << 1;
                objArr4[i14] = k6;
                objArr4[i14 + 1] = v6;
                this.f5221h = i13 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final V putIfAbsent(K k6, V v6) {
        V orDefault = getOrDefault(k6, null);
        return orDefault == null ? put(k6, v6) : orDefault;
    }

    public final V remove(Object obj) {
        int e = e(obj);
        if (e >= 0) {
            return j(e);
        }
        return null;
    }

    public final boolean remove(Object obj, Object obj2) {
        int e = e(obj);
        if (e >= 0) {
            V l6 = l(e);
            if (obj2 == l6 || (obj2 != null && obj2.equals(l6))) {
                j(e);
                return true;
            }
            return false;
        }
        return false;
    }

    public final V replace(K k6, V v6) {
        int e = e(k6);
        if (e >= 0) {
            return k(e, v6);
        }
        return null;
    }

    public final boolean replace(K k6, V v6, V v7) {
        int e = e(k6);
        if (e >= 0) {
            V l6 = l(e);
            if (l6 == v6 || (v6 != null && v6.equals(l6))) {
                k(e, v7);
                return true;
            }
            return false;
        }
        return false;
    }

    public final int size() {
        return this.f5221h;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f5221h * 28);
        sb.append('{');
        for (int i7 = 0; i7 < this.f5221h; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            K h7 = h(i7);
            if (h7 != this) {
                sb.append(h7);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V l6 = l(i7);
            if (l6 != this) {
                sb.append(l6);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
