package a.a.a.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class i<E> implements Cloneable {
    private static short[] $ = {22702, 22696, 18170, 18166, 20713, 20661, 20649, 20648, 20658, 20705, 20620, 20640, 20657, 20712};
    private static final Object e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private boolean f106a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f107b;
    private Object[] c;
    private int d;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public i() {
        this(10);
    }

    public i(int i) {
        this.f106a = false;
        if (i == 0) {
            this.f107b = c.f89a;
            this.c = c.f90b;
        } else {
            int d = c.d(i);
            this.f107b = new int[d];
            this.c = new Object[d];
        }
        this.d = 0;
    }

    private void d() {
        int i = this.d;
        int[] iArr = this.f107b;
        Object[] objArr = this.c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != e) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f106a = false;
        this.d = i2;
    }

    public void a() {
        int i = this.d;
        Object[] objArr = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.d = 0;
        this.f106a = false;
    }

    /* renamed from: b */
    public i<E> clone() {
        i<E> iVar = null;
        try {
            i<E> iVar2 = (i) super.clone();
            try {
                iVar2.f107b = (int[]) this.f107b.clone();
                iVar2.c = (Object[]) this.c.clone();
                return iVar2;
            } catch (CloneNotSupportedException unused) {
                iVar = iVar2;
                return iVar;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public void c(int i) {
        Object[] objArr;
        Object obj;
        int a2 = c.a(this.f107b, this.d, i);
        if (a2 >= 0 && (objArr = this.c)[a2] != (obj = e)) {
            objArr[a2] = obj;
            this.f106a = true;
        }
    }

    public E e(int i) {
        return f(i, null);
    }

    public E f(int i, E e2) {
        int a2 = c.a(this.f107b, this.d, i);
        if (a2 >= 0) {
            Object[] objArr = this.c;
            if (objArr[a2] != e) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    public int g(int i) {
        if (this.f106a) {
            d();
        }
        return this.f107b[i];
    }

    public void h(int i, E e2) {
        int a2 = c.a(this.f107b, this.d, i);
        if (a2 >= 0) {
            this.c[a2] = e2;
            return;
        }
        int i2 = ~a2;
        if (i2 < this.d) {
            Object[] objArr = this.c;
            if (objArr[i2] == e) {
                this.f107b[i2] = i;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f106a && this.d >= this.f107b.length) {
            d();
            i2 = ~c.a(this.f107b, this.d, i);
        }
        int i3 = this.d;
        if (i3 >= this.f107b.length) {
            int d = c.d(i3 + 1);
            int[] iArr = new int[d];
            Object[] objArr2 = new Object[d];
            int[] iArr2 = this.f107b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f107b = iArr;
            this.c = objArr2;
        }
        int i4 = this.d;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f107b;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.c;
            System.arraycopy(objArr4, i2, objArr4, i5, this.d - i2);
        }
        this.f107b[i2] = i;
        this.c[i2] = e2;
        this.d++;
    }

    public void i(int i) {
        c(i);
    }

    public int j() {
        if (this.f106a) {
            d();
        }
        return this.d;
    }

    public E k(int i) {
        if (this.f106a) {
            d();
        }
        return (E) this.c[i];
    }

    @Override // java.lang.Object
    public String toString() {
        if (j() <= 0) {
            return $(0, 2, 22741);
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        for (int i = 0; i < this.d; i++) {
            if (i > 0) {
                sb.append($(2, 4, 18134));
            }
            sb.append(g(i));
            sb.append('=');
            E k = k(i);
            if (k != this) {
                sb.append(k);
            } else {
                sb.append($(4, 14, 20673));
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
