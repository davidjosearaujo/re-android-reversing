package q0;

import java.util.Map;
import l0.z;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public int[] f5617a;

    /* renamed from: b  reason: collision with root package name */
    public Object[] f5618b;

    /* renamed from: c  reason: collision with root package name */
    public int f5619c;

    public b() {
        this(0);
    }

    public b(int i7) {
        this.f5617a = z.F;
        this.f5618b = z.G;
        this.f5619c = 0;
    }

    public final int a(int i7, Object obj) {
        h.f(obj, "key");
        int i8 = this.f5619c;
        if (i8 == 0) {
            return -1;
        }
        int k6 = z.k(i8, i7, this.f5617a);
        if (k6 < 0 || h.a(obj, this.f5618b[k6 << 1])) {
            return k6;
        }
        int i9 = k6 + 1;
        while (i9 < i8 && this.f5617a[i9] == i7) {
            if (h.a(obj, this.f5618b[i9 << 1])) {
                return i9;
            }
            i9++;
        }
        for (int i10 = k6 - 1; i10 >= 0 && this.f5617a[i10] == i7; i10--) {
            if (h.a(obj, this.f5618b[i10 << 1])) {
                return i10;
            }
        }
        return ~i9;
    }

    public final int b() {
        int i7 = this.f5619c;
        if (i7 == 0) {
            return -1;
        }
        int k6 = z.k(i7, 0, this.f5617a);
        if (k6 < 0 || this.f5618b[k6 << 1] == null) {
            return k6;
        }
        int i8 = k6 + 1;
        while (i8 < i7 && this.f5617a[i8] == 0) {
            if (this.f5618b[i8 << 1] == null) {
                return i8;
            }
            i8++;
        }
        for (int i9 = k6 - 1; i9 >= 0 && this.f5617a[i9] == 0; i9--) {
            if (this.f5618b[i9 << 1] == null) {
                return i9;
            }
        }
        return ~i8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof b) {
                b bVar = (b) obj;
                int i7 = this.f5619c;
                if (i7 != bVar.f5619c) {
                    return false;
                }
                for (int i8 = 0; i8 < i7; i8++) {
                    Object[] objArr = this.f5618b;
                    int i9 = i8 << 1;
                    Object obj2 = objArr[i9];
                    Object obj3 = objArr[i9 + 1];
                    int b2 = obj2 == null ? bVar.b() : bVar.a(obj2.hashCode(), obj2);
                    Object obj4 = b2 >= 0 ? bVar.f5618b[(b2 << 1) + 1] : null;
                    if (obj3 == null) {
                        if (obj4 == null) {
                            if (!((obj2 == null ? bVar.b() : bVar.a(obj2.hashCode(), obj2)) >= 0)) {
                            }
                        }
                        return false;
                    } else if (!h.a(obj3, obj4)) {
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof Map) || this.f5619c != ((Map) obj).size()) {
                return false;
            } else {
                int i10 = this.f5619c;
                for (int i11 = 0; i11 < i10; i11++) {
                    Object[] objArr2 = this.f5618b;
                    int i12 = i11 << 1;
                    Object obj5 = objArr2[i12];
                    Object obj6 = objArr2[i12 + 1];
                    Object obj7 = ((Map) obj).get(obj5);
                    if (obj6 == null) {
                        if (obj7 != null || !((Map) obj).containsKey(obj5)) {
                            return false;
                        }
                    } else if (!h.a(obj6, obj7)) {
                        return false;
                    }
                }
                return true;
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final int hashCode() {
        int[] iArr = this.f5617a;
        Object[] objArr = this.f5618b;
        int i7 = this.f5619c;
        int i8 = 1;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i7) {
            Object obj = objArr[i8];
            i10 += (obj != null ? obj.hashCode() : 0) ^ iArr[i9];
            i9++;
            i8 += 2;
        }
        return i10;
    }

    public final String toString() {
        int i7 = this.f5619c;
        if (i7 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i7 * 28);
        sb.append('{');
        int i8 = this.f5619c;
        for (int i9 = 0; i9 < i8; i9++) {
            if (i9 > 0) {
                sb.append(", ");
            }
            int i10 = i9 << 1;
            Object obj = this.f5618b[i10];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object obj2 = this.f5618b[i10 + 1];
            if (obj2 != this) {
                sb.append(obj2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        h.e(sb2, "buffer.toString()");
        return sb2;
    }
}
