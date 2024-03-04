package p0;

import g5.p;
import java.util.ArrayList;
import java.util.List;
import p0.a;
import r5.h;

/* loaded from: classes.dex */
public final class b {
    static {
        p pVar = true & true ? p.f4284f : null;
        p pVar2 = (true && true) ? p.f4284f : null;
        h.f(pVar, "spanStyles");
        h.f(pVar2, "paragraphStyles");
    }

    public static final ArrayList a(int i7, int i8, List list) {
        if (!(i7 <= i8)) {
            throw new IllegalArgumentException(("start (" + i7 + ") should be less than or equal to end (" + i8 + ')').toString());
        } else if (list == null) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i9 = 0; i9 < size; i9++) {
                Object obj = list.get(i9);
                a.C0091a c0091a = (a.C0091a) obj;
                if (b(i7, i8, c0091a.f5461b, c0091a.f5462c)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i10 = 0; i10 < size2; i10++) {
                a.C0091a c0091a2 = (a.C0091a) arrayList.get(i10);
                arrayList2.add(new a.C0091a(c0091a2.f5460a, Math.max(i7, c0091a2.f5461b) - i7, Math.min(i8, c0091a2.f5462c) - i7, c0091a2.f5463d));
            }
            if (arrayList2.isEmpty()) {
                return null;
            }
            return arrayList2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x001c, code lost:
        if ((r6 == r7) == (r4 == r5)) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0033, code lost:
        if ((r4 == r5) == (r6 == r7)) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean b(int r4, int r5, int r6, int r7) {
        /*
            int r0 = java.lang.Math.max(r4, r6)
            int r1 = java.lang.Math.min(r5, r7)
            r2 = 0
            r3 = 1
            if (r0 < r1) goto L3a
            if (r4 > r6) goto L20
            if (r7 > r5) goto L20
            if (r5 != r7) goto L1e
            if (r6 != r7) goto L16
            r0 = r3
            goto L17
        L16:
            r0 = r2
        L17:
            if (r4 != r5) goto L1b
            r1 = r3
            goto L1c
        L1b:
            r1 = r2
        L1c:
            if (r0 != r1) goto L20
        L1e:
            r0 = r3
            goto L21
        L20:
            r0 = r2
        L21:
            if (r0 != 0) goto L3a
            if (r6 > r4) goto L37
            if (r5 > r7) goto L37
            if (r7 != r5) goto L35
            if (r4 != r5) goto L2d
            r4 = r3
            goto L2e
        L2d:
            r4 = r2
        L2e:
            if (r6 != r7) goto L32
            r5 = r3
            goto L33
        L32:
            r5 = r2
        L33:
            if (r4 != r5) goto L37
        L35:
            r4 = r3
            goto L38
        L37:
            r4 = r2
        L38:
            if (r4 == 0) goto L3b
        L3a:
            r2 = r3
        L3b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.b.b(int, int, int, int):boolean");
    }
}
