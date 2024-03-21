package a.a.a.d;

import java.util.Map;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class h<K, V> {
    private static short[] $ = {29257, 29263, 19916, 19904, 19929, 19845, 19865, 19864, 19842, 19921, 19900, 19856, 19841, 19928};
    static Object[] d;
    static int e;
    static Object[] f;
    static int g;

    /* renamed from: a */
    int[] f104a = c.f89a;

    /* renamed from: b */
    Object[] f105b = c.f90b;
    int c = 0;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    private void a(int i) {
        if (i == 8) {
            synchronized (a.class) {
                if (f != null) {
                    Object[] objArr = f;
                    this.f105b = objArr;
                    f = (Object[]) objArr[0];
                    this.f104a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    g--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (a.class) {
                if (d != null) {
                    Object[] objArr2 = d;
                    this.f105b = objArr2;
                    d = (Object[]) objArr2[0];
                    this.f104a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    e--;
                    return;
                }
            }
        }
        this.f104a = new int[i];
        this.f105b = new Object[i << 1];
    }

    private static void c(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (g < 10) {
                    objArr[0] = f;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f = objArr;
                    g++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (e < 10) {
                    objArr[0] = d;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    d = objArr;
                    e++;
                }
            }
        }
    }

    public void b(int i) {
        int[] iArr = this.f104a;
        if (iArr.length < i) {
            Object[] objArr = this.f105b;
            a(i);
            int i2 = this.c;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f104a, 0, i2);
                System.arraycopy(objArr, 0, this.f105b, 0, this.c << 1);
            }
            c(iArr, objArr, this.c);
        }
    }

    public void clear() {
        int i = this.c;
        if (i != 0) {
            c(this.f104a, this.f105b, i);
            this.f104a = c.f89a;
            this.f105b = c.f90b;
            this.c = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    int d(Object obj, int i) {
        int i2 = this.c;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.f104a, i2, i);
        if (a2 < 0 || obj.equals(this.f105b[a2 << 1])) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f104a[i3] == i) {
            if (obj.equals(this.f105b[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a2 - 1; i4 >= 0 && this.f104a[i4] == i; i4--) {
            if (obj.equals(this.f105b[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public int e(Object obj) {
        return obj == null ? f() : d(obj, obj.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (size() != hVar.size()) {
                return false;
            }
            for (int i = 0; i < this.c; i++) {
                try {
                    K h = h(i);
                    V l = l(i);
                    Object obj2 = hVar.get(h);
                    if (l == null) {
                        if (obj2 != null || !hVar.containsKey(h)) {
                            return false;
                        }
                    } else if (!l.equals(obj2)) {
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
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.c; i2++) {
                try {
                    K h2 = h(i2);
                    V l2 = l(i2);
                    Object obj3 = map.get(h2);
                    if (l2 == null) {
                        if (obj3 != null || !map.containsKey(h2)) {
                            return false;
                        }
                    } else if (!l2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    int f() {
        int i = this.c;
        if (i == 0) {
            return -1;
        }
        int a2 = c.a(this.f104a, i, 0);
        if (a2 < 0 || this.f105b[a2 << 1] == null) {
            return a2;
        }
        int i2 = a2 + 1;
        while (i2 < i && this.f104a[i2] == 0) {
            if (this.f105b[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = a2 - 1; i3 >= 0 && this.f104a[i3] == 0; i3--) {
            if (this.f105b[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public int g(Object obj) {
        int i = this.c * 2;
        Object[] objArr = this.f105b;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public V get(Object obj) {
        int e2 = e(obj);
        if (e2 >= 0) {
            return (V) this.f105b[(e2 << 1) + 1];
        }
        return null;
    }

    public K h(int i) {
        return (K) this.f105b[i << 1];
    }

    public int hashCode() {
        int[] iArr = this.f104a;
        Object[] objArr = this.f105b;
        int i = this.c;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i(h<? extends K, ? extends V> hVar) {
        int i = hVar.c;
        b(this.c + i);
        if (this.c != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(hVar.h(i2), hVar.l(i2));
            }
        } else if (i > 0) {
            System.arraycopy(hVar.f104a, 0, this.f104a, 0, i);
            System.arraycopy(hVar.f105b, 0, this.f105b, 0, i << 1);
            this.c = i;
        }
    }

    public boolean isEmpty() {
        return this.c <= 0;
    }

    public V j(int i) {
        Object[] objArr = this.f105b;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.c;
        if (i3 <= 1) {
            c(this.f104a, objArr, i3);
            this.f104a = c.f89a;
            this.f105b = c.f90b;
            this.c = 0;
        } else {
            int[] iArr = this.f104a;
            int i4 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i5 = this.c - 1;
                this.c = i5;
                if (i < i5) {
                    int[] iArr2 = this.f104a;
                    int i6 = i + 1;
                    System.arraycopy(iArr2, i6, iArr2, i, i5 - i);
                    Object[] objArr2 = this.f105b;
                    System.arraycopy(objArr2, i6 << 1, objArr2, i2, (this.c - i) << 1);
                }
                Object[] objArr3 = this.f105b;
                int i7 = this.c;
                objArr3[i7 << 1] = null;
                objArr3[(i7 << 1) + 1] = null;
            } else {
                if (i3 > 8) {
                    i4 = i3 + (i3 >> 1);
                }
                int[] iArr3 = this.f104a;
                Object[] objArr4 = this.f105b;
                a(i4);
                this.c--;
                if (i > 0) {
                    System.arraycopy(iArr3, 0, this.f104a, 0, i);
                    System.arraycopy(objArr4, 0, this.f105b, 0, i2);
                }
                int i8 = this.c;
                if (i < i8) {
                    int i9 = i + 1;
                    System.arraycopy(iArr3, i9, this.f104a, i, i8 - i);
                    System.arraycopy(objArr4, i9 << 1, this.f105b, i2, (this.c - i) << 1);
                }
            }
        }
        return v;
    }

    public V k(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.f105b;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public V l(int i) {
        return (V) this.f105b[(i << 1) + 1];
    }

    public V put(K k, V v) {
        int i;
        int i2;
        if (k == null) {
            i2 = f();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i2 = d(k, hashCode);
            i = hashCode;
        }
        if (i2 >= 0) {
            int i3 = (i2 << 1) + 1;
            Object[] objArr = this.f105b;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~i2;
        int i5 = this.c;
        if (i5 >= this.f104a.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f104a;
            Object[] objArr2 = this.f105b;
            a(i6);
            int[] iArr2 = this.f104a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f105b, 0, objArr2.length);
            }
            c(iArr, objArr2, this.c);
        }
        int i7 = this.c;
        if (i4 < i7) {
            int[] iArr3 = this.f104a;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr3 = this.f105b;
            System.arraycopy(objArr3, i4 << 1, objArr3, i8 << 1, (this.c - i4) << 1);
        }
        this.f104a[i4] = i;
        Object[] objArr4 = this.f105b;
        int i9 = i4 << 1;
        objArr4[i9] = k;
        objArr4[i9 + 1] = v;
        this.c++;
        return null;
    }

    public V remove(Object obj) {
        int e2 = e(obj);
        if (e2 >= 0) {
            return j(e2);
        }
        return null;
    }

    public int size() {
        return this.c;
    }

    public String toString() {
        if (isEmpty()) {
            return $(0, 2, 29234);
        }
        StringBuilder sb = new StringBuilder(this.c * 28);
        sb.append('{');
        for (int i = 0; i < this.c; i++) {
            if (i > 0) {
                sb.append($(2, 4, 19936));
            }
            K h = h(i);
            String $2 = $(4, 14, 19953);
            if (h != this) {
                sb.append(h);
            } else {
                sb.append($2);
            }
            sb.append('=');
            V l = l(i);
            if (l != this) {
                sb.append(l);
            } else {
                sb.append($2);
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
