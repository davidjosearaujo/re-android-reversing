package o;

import l0.z;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i<E> implements Cloneable {

    /* renamed from: i  reason: collision with root package name */
    public static final Object f5222i = new Object();

    /* renamed from: f  reason: collision with root package name */
    public int[] f5223f;

    /* renamed from: g  reason: collision with root package name */
    public Object[] f5224g;

    /* renamed from: h  reason: collision with root package name */
    public int f5225h;

    public i() {
        int i7 = 40;
        int i8 = 4;
        while (true) {
            if (i8 >= 32) {
                break;
            }
            int i9 = (1 << i8) - 12;
            if (40 <= i9) {
                i7 = i9;
                break;
            }
            i8++;
        }
        int i10 = i7 / 4;
        this.f5223f = new int[i10];
        this.f5224g = new Object[i10];
    }

    public final void a(int i7, E e) {
        int i8 = this.f5225h;
        if (i8 == 0 || i7 > this.f5223f[i8 - 1]) {
            if (i8 >= this.f5223f.length) {
                int i9 = (i8 + 1) * 4;
                int i10 = 4;
                while (true) {
                    if (i10 >= 32) {
                        break;
                    }
                    int i11 = (1 << i10) - 12;
                    if (i9 <= i11) {
                        i9 = i11;
                        break;
                    }
                    i10++;
                }
                int i12 = i9 / 4;
                int[] iArr = new int[i12];
                Object[] objArr = new Object[i12];
                int[] iArr2 = this.f5223f;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f5224g;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f5223f = iArr;
                this.f5224g = objArr;
            }
            this.f5223f[i8] = i7;
            this.f5224g[i8] = e;
            this.f5225h = i8 + 1;
            return;
        }
        d(i7, e);
    }

    /* renamed from: b */
    public final i<E> clone() {
        try {
            i<E> iVar = (i) super.clone();
            iVar.f5223f = (int[]) this.f5223f.clone();
            iVar.f5224g = (Object[]) this.f5224g.clone();
            return iVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final Object c(int i7, Integer num) {
        Object obj;
        int i8 = z.i(this.f5225h, i7, this.f5223f);
        return (i8 < 0 || (obj = this.f5224g[i8]) == f5222i) ? num : obj;
    }

    public final void d(int i7, E e) {
        int i8 = z.i(this.f5225h, i7, this.f5223f);
        if (i8 >= 0) {
            this.f5224g[i8] = e;
            return;
        }
        int i9 = ~i8;
        int i10 = this.f5225h;
        if (i9 < i10) {
            Object[] objArr = this.f5224g;
            if (objArr[i9] == f5222i) {
                this.f5223f[i9] = i7;
                objArr[i9] = e;
                return;
            }
        }
        if (i10 >= this.f5223f.length) {
            int i11 = (i10 + 1) * 4;
            int i12 = 4;
            while (true) {
                if (i12 >= 32) {
                    break;
                }
                int i13 = (1 << i12) - 12;
                if (i11 <= i13) {
                    i11 = i13;
                    break;
                }
                i12++;
            }
            int i14 = i11 / 4;
            int[] iArr = new int[i14];
            Object[] objArr2 = new Object[i14];
            int[] iArr2 = this.f5223f;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f5224g;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f5223f = iArr;
            this.f5224g = objArr2;
        }
        int i15 = this.f5225h - i9;
        if (i15 != 0) {
            int[] iArr3 = this.f5223f;
            int i16 = i9 + 1;
            System.arraycopy(iArr3, i9, iArr3, i16, i15);
            Object[] objArr4 = this.f5224g;
            System.arraycopy(objArr4, i9, objArr4, i16, this.f5225h - i9);
        }
        this.f5223f[i9] = i7;
        this.f5224g[i9] = e;
        this.f5225h++;
    }

    @Override // java.lang.Object
    public final String toString() {
        int i7 = this.f5225h;
        if (i7 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i7 * 28);
        sb.append('{');
        for (int i8 = 0; i8 < this.f5225h; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            sb.append(this.f5223f[i8]);
            sb.append('=');
            Object obj = this.f5224g[i8];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
