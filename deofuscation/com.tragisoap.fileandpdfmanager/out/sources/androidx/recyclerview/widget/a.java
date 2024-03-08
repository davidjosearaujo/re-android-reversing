package androidx.recyclerview.widget;

import androidx.recyclerview.widget.n;
import java.util.ArrayList;
import o1.e;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements n.a {

    /* renamed from: d */
    public final AbstractC0021a f2144d;

    /* renamed from: a */
    public e f2141a = new e(30);

    /* renamed from: b */
    public final ArrayList<b> f2142b = new ArrayList<>();

    /* renamed from: c */
    public final ArrayList<b> f2143c = new ArrayList<>();
    public final n e = new n(this);

    /* renamed from: androidx.recyclerview.widget.a$a */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface AbstractC0021a {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b {

        /* renamed from: a */
        public int f2145a;

        /* renamed from: b */
        public int f2146b;

        /* renamed from: c */
        public Object f2147c;

        /* renamed from: d */
        public int f2148d;

        public b(Object obj, int i7, int i8, int i9) {
            this.f2145a = i7;
            this.f2146b = i8;
            this.f2148d = i9;
            this.f2147c = obj;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i7 = this.f2145a;
            if (i7 != bVar.f2145a) {
                return false;
            }
            if (i7 == 8 && Math.abs(this.f2148d - this.f2146b) == 1 && this.f2148d == bVar.f2146b && this.f2146b == bVar.f2148d) {
                return true;
            }
            if (this.f2148d != bVar.f2148d || this.f2146b != bVar.f2146b) {
                return false;
            }
            Object obj2 = this.f2147c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f2147c)) {
                    return false;
                }
            } else if (bVar.f2147c != null) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (((this.f2145a * 31) + this.f2146b) * 31) + this.f2148d;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i7 = this.f2145a;
            sb.append(i7 != 1 ? i7 != 2 ? i7 != 4 ? i7 != 8 ? "??" : "mv" : "up" : "rm" : "add");
            sb.append(",s:");
            sb.append(this.f2146b);
            sb.append("c:");
            sb.append(this.f2148d);
            sb.append(",p:");
            sb.append(this.f2147c);
            sb.append("]");
            return sb.toString();
        }
    }

    public a(u uVar) {
        this.f2144d = uVar;
    }

    public final boolean a(int i7) {
        int size = this.f2143c.size();
        for (int i8 = 0; i8 < size; i8++) {
            b bVar = this.f2143c.get(i8);
            int i9 = bVar.f2145a;
            if (i9 == 8) {
                if (f(bVar.f2148d, i8 + 1) == i7) {
                    return true;
                }
            } else if (i9 == 1) {
                int i10 = bVar.f2146b;
                int i11 = bVar.f2148d + i10;
                while (i10 < i11) {
                    if (f(i10, i8 + 1) == i7) {
                        return true;
                    }
                    i10++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public final void b() {
        int size = this.f2143c.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((u) this.f2144d).a(this.f2143c.get(i7));
        }
        l(this.f2143c);
    }

    public final void c() {
        b();
        int size = this.f2142b.size();
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = this.f2142b.get(i7);
            int i8 = bVar.f2145a;
            if (i8 == 1) {
                ((u) this.f2144d).a(bVar);
                ((u) this.f2144d).d(bVar.f2146b, bVar.f2148d);
            } else if (i8 == 2) {
                ((u) this.f2144d).a(bVar);
                AbstractC0021a aVar = this.f2144d;
                int i9 = bVar.f2146b;
                int i10 = bVar.f2148d;
                u uVar = (u) aVar;
                uVar.f2276a.R(i9, i10, true);
                RecyclerView recyclerView = uVar.f2276a;
                recyclerView.f1979n0 = true;
                recyclerView.f1974k0.f2087c += i10;
            } else if (i8 == 4) {
                ((u) this.f2144d).a(bVar);
                ((u) this.f2144d).c(bVar.f2146b, bVar.f2148d, bVar.f2147c);
            } else if (i8 == 8) {
                ((u) this.f2144d).a(bVar);
                ((u) this.f2144d).e(bVar.f2146b, bVar.f2148d);
            }
        }
        l(this.f2142b);
    }

    public final void d(b bVar) {
        int i7;
        int i8 = bVar.f2145a;
        if (i8 == 1 || i8 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int m = m(bVar.f2146b, i8);
        int i9 = bVar.f2146b;
        int i10 = bVar.f2145a;
        if (i10 == 2) {
            i7 = 0;
        } else if (i10 == 4) {
            i7 = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i11 = 1;
        for (int i12 = 1; i12 < bVar.f2148d; i12++) {
            int m3 = m((i7 * i12) + bVar.f2146b, bVar.f2145a);
            int i13 = bVar.f2145a;
            if (i13 == 2 ? m3 == m : i13 == 4 && m3 == m + 1) {
                i11++;
            } else {
                b h7 = h(bVar.f2147c, i13, m, i11);
                e(h7, i9);
                h7.f2147c = null;
                this.f2141a.a(h7);
                if (bVar.f2145a == 4) {
                    i9 += i11;
                }
                i11 = 1;
                m = m3;
            }
        }
        Object obj = bVar.f2147c;
        bVar.f2147c = null;
        this.f2141a.a(bVar);
        if (i11 > 0) {
            b h8 = h(obj, bVar.f2145a, m, i11);
            e(h8, i9);
            h8.f2147c = null;
            this.f2141a.a(h8);
        }
    }

    public final void e(b bVar, int i7) {
        ((u) this.f2144d).a(bVar);
        int i8 = bVar.f2145a;
        if (i8 == 2) {
            AbstractC0021a aVar = this.f2144d;
            int i9 = bVar.f2148d;
            u uVar = (u) aVar;
            uVar.f2276a.R(i7, i9, true);
            RecyclerView recyclerView = uVar.f2276a;
            recyclerView.f1979n0 = true;
            recyclerView.f1974k0.f2087c += i9;
        } else if (i8 == 4) {
            ((u) this.f2144d).c(i7, bVar.f2148d, bVar.f2147c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public final int f(int i7, int i8) {
        int size = this.f2143c.size();
        while (i8 < size) {
            b bVar = this.f2143c.get(i8);
            int i9 = bVar.f2145a;
            if (i9 == 8) {
                int i10 = bVar.f2146b;
                if (i10 == i7) {
                    i7 = bVar.f2148d;
                } else {
                    if (i10 < i7) {
                        i7--;
                    }
                    if (bVar.f2148d <= i7) {
                        i7++;
                    }
                }
            } else {
                int i11 = bVar.f2146b;
                if (i11 > i7) {
                    continue;
                } else if (i9 == 2) {
                    int i12 = bVar.f2148d;
                    if (i7 < i11 + i12) {
                        return -1;
                    }
                    i7 -= i12;
                } else if (i9 == 1) {
                    i7 += bVar.f2148d;
                }
            }
            i8++;
        }
        return i7;
    }

    public final boolean g() {
        return this.f2142b.size() > 0;
    }

    public final b h(Object obj, int i7, int i8, int i9) {
        b bVar = (b) this.f2141a.b();
        if (bVar == null) {
            return new b(obj, i7, i8, i9);
        }
        bVar.f2145a = i7;
        bVar.f2146b = i8;
        bVar.f2148d = i9;
        bVar.f2147c = obj;
        return bVar;
    }

    public final void i(b bVar) {
        this.f2143c.add(bVar);
        int i7 = bVar.f2145a;
        if (i7 == 1) {
            ((u) this.f2144d).d(bVar.f2146b, bVar.f2148d);
        } else if (i7 == 2) {
            AbstractC0021a aVar = this.f2144d;
            u uVar = (u) aVar;
            uVar.f2276a.R(bVar.f2146b, bVar.f2148d, false);
            uVar.f2276a.f1979n0 = true;
        } else if (i7 == 4) {
            ((u) this.f2144d).c(bVar.f2146b, bVar.f2148d, bVar.f2147c);
        } else if (i7 == 8) {
            ((u) this.f2144d).e(bVar.f2146b, bVar.f2148d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01a5, code lost:
        if (r4 == null) goto L_0x0009;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01a7, code lost:
        r2.add(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0164, code lost:
        if (r5 > r12.f2146b) goto L_0x0190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x018e, code lost:
        if (r5 >= r12.f2146b) goto L_0x0190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0190, code lost:
        r11.f2148d = r5 - r12.f2148d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0195, code lost:
        r2.set(r3, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x019c, code lost:
        if (r11.f2146b == r11.f2148d) goto L_0x01a2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x019e, code lost:
        r2.set(r7, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01a2, code lost:
        r2.remove(r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x013b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0125 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instructions count: 696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.a.j():void");
    }

    public final void k(b bVar) {
        bVar.f2147c = null;
        this.f2141a.a(bVar);
    }

    public final void l(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            k((b) arrayList.get(i7));
        }
        arrayList.clear();
    }

    public final int m(int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        for (int size = this.f2143c.size() - 1; size >= 0; size--) {
            b bVar = this.f2143c.get(size);
            int i15 = bVar.f2145a;
            if (i15 == 8) {
                int i16 = bVar.f2146b;
                int i17 = bVar.f2148d;
                if (i16 < i17) {
                    i11 = i16;
                    i10 = i17;
                } else {
                    i10 = i16;
                    i11 = i17;
                }
                if (i7 < i11 || i7 > i10) {
                    if (i7 < i16) {
                        if (i8 == 1) {
                            bVar.f2146b = i16 + 1;
                            i12 = i17 + 1;
                        } else if (i8 == 2) {
                            bVar.f2146b = i16 - 1;
                            i12 = i17 - 1;
                        }
                        bVar.f2148d = i12;
                    }
                } else if (i11 == i16) {
                    if (i8 == 1) {
                        i14 = i17 + 1;
                    } else {
                        if (i8 == 2) {
                            i14 = i17 - 1;
                        }
                        i7++;
                    }
                    bVar.f2148d = i14;
                    i7++;
                } else {
                    if (i8 == 1) {
                        i13 = i16 + 1;
                    } else {
                        if (i8 == 2) {
                            i13 = i16 - 1;
                        }
                        i7--;
                    }
                    bVar.f2146b = i13;
                    i7--;
                }
            } else {
                int i18 = bVar.f2146b;
                if (i18 > i7) {
                    if (i8 == 1) {
                        i9 = i18 + 1;
                    } else if (i8 == 2) {
                        i9 = i18 - 1;
                    }
                    bVar.f2146b = i9;
                } else if (i15 == 1) {
                    i7 -= bVar.f2148d;
                } else if (i15 == 2) {
                    i7 += bVar.f2148d;
                }
            }
        }
        for (int size2 = this.f2143c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f2143c.get(size2);
            if (bVar2.f2145a == 8) {
                int i19 = bVar2.f2148d;
                if (i19 != bVar2.f2146b && i19 >= 0) {
                }
                this.f2143c.remove(size2);
                k(bVar2);
            } else {
                if (bVar2.f2148d > 0) {
                }
                this.f2143c.remove(size2);
                k(bVar2);
            }
        }
        return i7;
    }
}
