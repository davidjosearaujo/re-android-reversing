package v;

import f5.g;
import g5.i;
import g5.j;
import i5.d;
import java.util.ArrayList;
import java.util.Iterator;
import k5.h;
import q5.p;
import y5.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e implements Iterable<Integer>, s5.a {

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
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends h implements p<f<? super Integer>, d<? super g>, Object> {

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
        public a(d<? super a> dVar) {
            super(dVar);
            e.this = r1;
        }

        @Override // q5.p
        public final Object i(f<? super Integer> fVar, d<? super g> dVar) {
            return ((a) p(fVar, dVar)).s(g.f4141a);
        }

        @Override // k5.a
        public final d<g> p(Object obj, d<?> dVar) {
            a aVar = new a(dVar);
            aVar.f6142l = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00b4  */
        @Override // k5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object s(java.lang.Object r20) {
            /*
                Method dump skipped, instructions count: 227
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: v.e.a.s(java.lang.Object):java.lang.Object");
        }
    }

    public e(long j7, long j8, int i7, int[] iArr) {
        this.f6134f = j7;
        this.f6135g = j8;
        this.f6136h = i7;
        this.f6137i = iArr;
    }

    public final e a(int i7) {
        int[] iArr;
        int f7;
        int i8 = this.f6136h;
        int i9 = i7 - i8;
        if (i9 >= 0 && i9 < 64) {
            long j7 = 1 << i9;
            long j8 = this.f6135g;
            if ((j8 & j7) != 0) {
                return new e(this.f6134f, j8 & (~j7), i8, this.f6137i);
            }
        } else if (i9 >= 64 && i9 < 128) {
            long j9 = 1 << (i9 - 64);
            long j10 = this.f6134f;
            if ((j10 & j9) != 0) {
                return new e((~j9) & j10, this.f6135g, i8, this.f6137i);
            }
        } else if (i9 < 0 && (iArr = this.f6137i) != null && (f7 = a0.e.f(iArr, i7)) >= 0) {
            int length = iArr.length - 1;
            if (length == 0) {
                return new e(this.f6134f, this.f6135g, this.f6136h, null);
            }
            int[] iArr2 = new int[length];
            if (f7 > 0) {
                i.V(0, 0, f7, iArr, iArr2);
            }
            if (f7 < length) {
                i.V(f7, f7 + 1, length + 1, iArr, iArr2);
            }
            return new e(this.f6134f, this.f6135g, this.f6136h, iArr2);
        }
        return this;
    }

    public final boolean b(int i7) {
        int[] iArr;
        int i8 = i7 - this.f6136h;
        boolean z6 = true;
        if (i8 >= 0 && i8 < 64) {
            return (this.f6135g & (1 << i8)) != 0;
        }
        if (i8 >= 64 && i8 < 128) {
            return (this.f6134f & (1 << (i8 - 64))) != 0;
        }
        if (i8 > 0 || (iArr = this.f6137i) == null) {
            return false;
        }
        if (a0.e.f(iArr, i7) < 0) {
            z6 = false;
        }
        return z6;
    }

    public final e c(int i7) {
        int i8;
        int[] iArr;
        int i9 = this.f6136h;
        int i10 = i7 - i9;
        long j7 = 0;
        if (i10 >= 0 && i10 < 64) {
            long j8 = 1 << i10;
            long j9 = this.f6135g;
            if ((j9 & j8) == 0) {
                return new e(this.f6134f, j9 | j8, i9, this.f6137i);
            }
        } else if (i10 >= 64 && i10 < 128) {
            long j10 = 1 << (i10 - 64);
            long j11 = this.f6134f;
            if ((j11 & j10) == 0) {
                return new e(j10 | j11, this.f6135g, i9, this.f6137i);
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
                i.V(0, 0, i11, iArr2, iArr3);
                i.V(i11 + 1, i11, length - 1, iArr2, iArr3);
                iArr3[i11] = i7;
                return new e(this.f6134f, this.f6135g, this.f6136h, iArr3);
            }
        } else if (!b(i7)) {
            long j12 = this.f6134f;
            long j13 = this.f6135g;
            int i12 = this.f6136h;
            ArrayList<Number> arrayList = null;
            int i13 = ((i7 + 1) / 64) * 64;
            while (true) {
                if (i12 >= i13) {
                    i8 = i12;
                    j7 = j13;
                    break;
                }
                if (j13 != 0) {
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
                        if (((1 << i15) & j13) != 0) {
                            arrayList.add(Integer.valueOf(i15 + i12));
                        }
                    }
                }
                if (j12 == 0) {
                    i8 = i13;
                    break;
                }
                i12 += 64;
                j13 = j12;
                j12 = 0;
            }
            if (arrayList != null) {
                iArr = new int[arrayList.size()];
                int i16 = 0;
                for (Number number : arrayList) {
                    i16++;
                    iArr[i16] = number.intValue();
                }
            } else {
                iArr = this.f6137i;
            }
            return new e(j12, j7, i8, iArr).c(i7);
        }
        return this;
    }

    @Override // java.lang.Iterable
    public final Iterator<Integer> iterator() {
        a aVar = new a(null);
        y5.e eVar = new y5.e();
        eVar.f6843i = q2.a.p(eVar, eVar, aVar);
        return eVar;
    }

    @Override // java.lang.Object
    public final String toString() {
        CharSequence charSequence;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [");
        ArrayList arrayList = new ArrayList(j.V(this));
        Iterator<Integer> it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().intValue()));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int size = arrayList.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            Object obj = arrayList.get(i8);
            boolean z6 = true;
            i7++;
            if (i7 > 1) {
                sb2.append((CharSequence) ", ");
            }
            if (obj != null) {
                z6 = obj instanceof CharSequence;
            }
            if (z6) {
                charSequence = (CharSequence) obj;
            } else if (obj instanceof Character) {
                sb2.append(((Character) obj).charValue());
            } else {
                charSequence = String.valueOf(obj);
            }
            sb2.append(charSequence);
        }
        sb2.append((CharSequence) "");
        String sb3 = sb2.toString();
        r5.h.e(sb3, "fastJoinTo(StringBuilder…form)\n        .toString()");
        sb.append(sb3);
        sb.append(']');
        return sb.toString();
    }
}
