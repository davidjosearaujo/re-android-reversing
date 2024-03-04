package v;

import java.util.ArrayList;
import java.util.Iterator;
import q5.p;

/* loaded from: classes.dex */
public final class e implements Iterable, s5.a {

    /* renamed from: j */
    public static final e f6133j = new e(0, 0, 0, null);

    /* renamed from: f */
    public final long f6134f;

    /* renamed from: g */
    public final long f6135g;

    /* renamed from: h */
    public final int f6136h;

    /* renamed from: i */
    public final int[] f6137i;

    @k5.e(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", l = {295, 300, 307}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class a extends k5.h implements p {

        /* renamed from: h */
        public int[] f6138h;

        /* renamed from: i */
        public int f6139i;

        /* renamed from: j */
        public int f6140j;

        /* renamed from: k */
        public int f6141k;

        /* renamed from: l */
        public /* synthetic */ Object f6142l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i5.d dVar) {
            super(dVar);
            e.this = r1;
        }

        public final Object i(Object obj, Object obj2) {
            return ((a) p((y5.f) obj, (i5.d) obj2)).s(f5.g.f4141a);
        }

        public final i5.d p(Object obj, i5.d dVar) {
            a aVar = new a(dVar);
            aVar.f6142l = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:63:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x00b4  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x006e -> B:66:0x0071). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x008b -> B:77:0x00a5). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x00a2 -> B:77:0x00a5). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x00da -> B:89:0x00db). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x00dd -> B:91:0x00de). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object s(java.lang.Object r20) {
            /*
                Method dump skipped, instructions count: 227
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: v.e.a.s(java.lang.Object):java.lang.Object");
        }
    }

    public e(long j5, long j7, int i7, int[] iArr) {
        this.f6134f = j5;
        this.f6135g = j7;
        this.f6136h = i7;
        this.f6137i = iArr;
    }

    public final e a(int i7) {
        int[] iArr;
        int f7;
        int i8 = this.f6136h;
        int i9 = i7 - i8;
        if (i9 >= 0 && i9 < 64) {
            long j5 = 1 << i9;
            long j7 = this.f6135g;
            if ((j7 & j5) != 0) {
                return new e(this.f6134f, j7 & (~j5), i8, this.f6137i);
            }
        } else if (i9 >= 64 && i9 < 128) {
            long j8 = 1 << (i9 - 64);
            long j9 = this.f6134f;
            if ((j9 & j8) != 0) {
                return new e((~j8) & j9, this.f6135g, i8, this.f6137i);
            }
        } else if (i9 < 0 && (iArr = this.f6137i) != null && (f7 = a0.e.f(iArr, i7)) >= 0) {
            int length = iArr.length - 1;
            if (length == 0) {
                return new e(this.f6134f, this.f6135g, this.f6136h, null);
            }
            int[] iArr2 = new int[length];
            if (f7 > 0) {
                g5.i.V(0, 0, f7, iArr, iArr2);
            }
            if (f7 < length) {
                g5.i.V(f7, f7 + 1, length + 1, iArr, iArr2);
            }
            return new e(this.f6134f, this.f6135g, this.f6136h, iArr2);
        }
        return this;
    }

    public final boolean b(int i7) {
        int[] iArr;
        int i8 = i7 - this.f6136h;
        if (i8 >= 0 && i8 < 64) {
            return (this.f6135g & (1 << i8)) != 0;
        } else if (i8 >= 64 && i8 < 128) {
            return (this.f6134f & (1 << (i8 - 64))) != 0;
        } else if (i8 <= 0 && (iArr = this.f6137i) != null) {
            return a0.e.f(iArr, i7) >= 0;
        } else {
            return false;
        }
    }

    public final e c(int i7) {
        int i8;
        int[] iArr;
        int i9 = this.f6136h;
        int i10 = i7 - i9;
        long j5 = 0;
        if (i10 >= 0 && i10 < 64) {
            long j7 = 1 << i10;
            long j8 = this.f6135g;
            if ((j8 & j7) == 0) {
                return new e(this.f6134f, j8 | j7, i9, this.f6137i);
            }
        } else if (i10 >= 64 && i10 < 128) {
            long j9 = 1 << (i10 - 64);
            long j10 = this.f6134f;
            if ((j10 & j9) == 0) {
                return new e(j9 | j10, this.f6135g, i9, this.f6137i);
            }
        } else if (i10 < 128) {
            int[] iArr2 = this.f6137i;
            if (iArr2 == null) {
                return new e(this.f6134f, this.f6135g, i9, new int[]{i7});
            }
            int f7 = a0.e.f(iArr2, i7);
            if (f7 < 0) {
                int i11 = -(f7 + 1);
                int length = iArr2.length + 1;
                int[] iArr3 = new int[length];
                g5.i.V(0, 0, i11, iArr2, iArr3);
                g5.i.V(i11 + 1, i11, length - 1, iArr2, iArr3);
                iArr3[i11] = i7;
                return new e(this.f6134f, this.f6135g, this.f6136h, iArr3);
            }
        } else if (!b(i7)) {
            long j11 = this.f6134f;
            long j12 = this.f6135g;
            int i12 = this.f6136h;
            ArrayList<Number> arrayList = null;
            int i13 = ((i7 + 1) / 64) * 64;
            long j13 = j11;
            while (true) {
                if (i12 >= i13) {
                    i8 = i12;
                    j5 = j12;
                    break;
                }
                if (j12 != 0) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        int[] iArr4 = this.f6137i;
                        if (iArr4 != null) {
                            for (int i14 : iArr4) {
                                arrayList.add(Integer.valueOf(i14));
                            }
                        }
                    }
                    for (int i15 = 0; i15 < 64; i15++) {
                        if (((1 << i15) & j12) != 0) {
                            arrayList.add(Integer.valueOf(i15 + i12));
                        }
                    }
                }
                if (j13 == 0) {
                    i8 = i13;
                    break;
                }
                i12 += 64;
                j12 = j13;
                j13 = 0;
            }
            if (arrayList != null) {
                iArr = new int[arrayList.size()];
                int i16 = 0;
                for (Number number : arrayList) {
                    iArr[i16] = number.intValue();
                    i16++;
                }
            } else {
                iArr = this.f6137i;
            }
            return new e(j13, j5, i8, iArr).c(i7);
        }
        return this;
    }

    public final Iterator iterator() {
        a aVar = new a(null);
        y5.e eVar = new y5.e();
        eVar.f6843i = q2.a.p(eVar, eVar, aVar);
        return eVar;
    }

    public final String toString() {
        CharSequence valueOf;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [");
        ArrayList arrayList = new ArrayList(g5.j.V(this));
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).intValue()));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int size = arrayList.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            Object obj = arrayList.get(i8);
            i7++;
            if (i7 > 1) {
                sb2.append((CharSequence) ", ");
            }
            if (obj != null ? obj instanceof CharSequence : true) {
                valueOf = (CharSequence) obj;
            } else if (obj instanceof Character) {
                sb2.append(((Character) obj).charValue());
            } else {
                valueOf = String.valueOf(obj);
            }
            sb2.append(valueOf);
        }
        sb2.append((CharSequence) "");
        String sb3 = sb2.toString();
        r5.h.e(sb3, "fastJoinTo(StringBuilder…form)\n        .toString()");
        sb.append(sb3);
        sb.append(']');
        return sb.toString();
    }
}
