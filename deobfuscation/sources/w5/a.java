package w5;

import java.util.Iterator;

/* loaded from: classes.dex */
public class a implements Iterable<Integer>, s5.a {

    /* renamed from: f */
    public final int f6411f;

    /* renamed from: g */
    public final int f6412g;

    /* renamed from: h */
    public final int f6413h;

    public a(int i7, int i8, int i9) {
        if (i9 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i9 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f6411f = i7;
        if (i9 > 0) {
            if (i7 < i8) {
                int i10 = i8 % i9;
                int i11 = i7 % i9;
                int i12 = ((i10 < 0 ? i10 + i9 : i10) - (i11 < 0 ? i11 + i9 : i11)) % i9;
                i8 -= i12 < 0 ? i12 + i9 : i12;
            }
        } else if (i9 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else {
            if (i7 > i8) {
                int i13 = -i9;
                int i14 = i7 % i13;
                int i15 = i8 % i13;
                int i16 = ((i14 < 0 ? i14 + i13 : i14) - (i15 < 0 ? i15 + i13 : i15)) % i13;
                i8 += i16 < 0 ? i16 + i13 : i16;
            }
        }
        this.f6412g = i8;
        this.f6413h = i9;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f6411f != aVar.f6411f || this.f6412g != aVar.f6412g || this.f6413h != aVar.f6413h) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return this.f6413h + (((this.f6411f * 31) + this.f6412g) * 31);
    }

    public boolean isEmpty() {
        if (this.f6413h > 0) {
            if (this.f6411f > this.f6412g) {
                return true;
            }
        } else if (this.f6411f < this.f6412g) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator<Integer> iterator() {
        return new b(this.f6411f, this.f6412g, this.f6413h);
    }

    public String toString() {
        StringBuilder sb;
        int i7;
        if (this.f6413h > 0) {
            sb = new StringBuilder();
            sb.append(this.f6411f);
            sb.append("..");
            sb.append(this.f6412g);
            sb.append(" step ");
            i7 = this.f6413h;
        } else {
            sb = new StringBuilder();
            sb.append(this.f6411f);
            sb.append(" downTo ");
            sb.append(this.f6412g);
            sb.append(" step ");
            i7 = -this.f6413h;
        }
        sb.append(i7);
        return sb.toString();
    }
}
