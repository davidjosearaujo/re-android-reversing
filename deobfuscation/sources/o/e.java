package o;

import l0.z;

/* loaded from: classes.dex */
public final class e<E> implements Cloneable {

    /* renamed from: j */
    public static final Object f5191j = new Object();

    /* renamed from: f */
    public boolean f5192f = false;

    /* renamed from: g */
    public long[] f5193g;

    /* renamed from: h */
    public Object[] f5194h;

    /* renamed from: i */
    public int f5195i;

    public e() {
        int i7 = 80;
        int i8 = 4;
        while (true) {
            if (i8 >= 32) {
                break;
            }
            int i9 = (1 << i8) - 12;
            if (80 <= i9) {
                i7 = i9;
                break;
            }
            i8++;
        }
        int i10 = i7 / 8;
        this.f5193g = new long[i10];
        this.f5194h = new Object[i10];
    }

    public final void a() {
        int i7 = this.f5195i;
        Object[] objArr = this.f5194h;
        for (int i8 = 0; i8 < i7; i8++) {
            objArr[i8] = null;
        }
        this.f5195i = 0;
        this.f5192f = false;
    }

    /* renamed from: b */
    public final e<E> m3clone() {
        try {
            e<E> eVar = (e) super.clone();
            eVar.f5193g = (long[]) this.f5193g.clone();
            eVar.f5194h = (Object[]) this.f5194h.clone();
            return eVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final void c() {
        int i7 = this.f5195i;
        long[] jArr = this.f5193g;
        Object[] objArr = this.f5194h;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            Object obj = objArr[i9];
            if (obj != f5191j) {
                if (i9 != i8) {
                    jArr[i8] = jArr[i9];
                    objArr[i8] = obj;
                    objArr[i9] = null;
                }
                i8++;
            }
        }
        this.f5192f = false;
        this.f5195i = i8;
    }

    public final Object d(Long l6, long j5) {
        Object obj;
        int j7 = z.j(this.f5193g, this.f5195i, j5);
        return (j7 < 0 || (obj = this.f5194h[j7]) == f5191j) ? l6 : obj;
    }

    public final void e(Object obj, long j5) {
        int j7 = z.j(this.f5193g, this.f5195i, j5);
        if (j7 >= 0) {
            this.f5194h[j7] = obj;
            return;
        }
        int i7 = ~j7;
        int i8 = this.f5195i;
        if (i7 < i8) {
            Object[] objArr = this.f5194h;
            if (objArr[i7] == f5191j) {
                this.f5193g[i7] = j5;
                objArr[i7] = obj;
                return;
            }
        }
        if (this.f5192f && i8 >= this.f5193g.length) {
            c();
            i7 = ~z.j(this.f5193g, this.f5195i, j5);
        }
        int i9 = this.f5195i;
        if (i9 >= this.f5193g.length) {
            int i10 = (i9 + 1) * 8;
            int i11 = 4;
            while (true) {
                if (i11 >= 32) {
                    break;
                }
                int i12 = (1 << i11) - 12;
                if (i10 <= i12) {
                    i10 = i12;
                    break;
                }
                i11++;
            }
            int i13 = i10 / 8;
            long[] jArr = new long[i13];
            Object[] objArr2 = new Object[i13];
            long[] jArr2 = this.f5193g;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f5194h;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f5193g = jArr;
            this.f5194h = objArr2;
        }
        int i14 = this.f5195i - i7;
        if (i14 != 0) {
            long[] jArr3 = this.f5193g;
            int i15 = i7 + 1;
            System.arraycopy(jArr3, i7, jArr3, i15, i14);
            Object[] objArr4 = this.f5194h;
            System.arraycopy(objArr4, i7, objArr4, i15, this.f5195i - i7);
        }
        this.f5193g[i7] = j5;
        this.f5194h[i7] = obj;
        this.f5195i++;
    }

    public final E f(int i7) {
        if (this.f5192f) {
            c();
        }
        return (E) this.f5194h[i7];
    }

    public final String toString() {
        if (this.f5192f) {
            c();
        }
        int i7 = this.f5195i;
        if (i7 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i7 * 28);
        sb.append('{');
        for (int i8 = 0; i8 < this.f5195i; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            if (this.f5192f) {
                c();
            }
            sb.append(this.f5193g[i8]);
            sb.append('=');
            E f7 = f(i8);
            if (f7 != this) {
                sb.append(f7);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
