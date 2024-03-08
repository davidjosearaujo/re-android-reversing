package p0;

import g5.p;
import java.util.ArrayList;
import java.util.List;
import p0.a;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b {
    static {
        p pVar = null;
        p pVar2 = true & true ? p.f4284f : null;
        if (true && true) {
            pVar = p.f4284f;
        }
        h.f(pVar2, "spanStyles");
        h.f(pVar, "paragraphStyles");
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
                a.C0091a aVar = (a.C0091a) obj;
                if (b(i7, i8, aVar.f5461b, aVar.f5462c)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i10 = 0; i10 < size2; i10++) {
                a.C0091a aVar2 = (a.C0091a) arrayList.get(i10);
                arrayList2.add(new a.C0091a(aVar2.f5460a, Math.max(i7, aVar2.f5461b) - i7, Math.min(i8, aVar2.f5462c) - i7, aVar2.f5463d));
            }
            if (arrayList2.isEmpty()) {
                return null;
            }
            return arrayList2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
        if ((r6 == r7) == (r4 == r5)) goto L_0x001e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0033, code lost:
        if ((r4 == r5) == (r6 == r7)) goto L_0x0035;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean b(int r4, int r5, int r6, int r7) {
        /*
            int r0 = java.lang.Math.max(r4, r6)
            int r1 = java.lang.Math.min(r5, r7)
            r2 = 0
            r3 = 1
            if (r0 < r1) goto L_0x003a
            if (r4 > r6) goto L_0x0020
            if (r7 > r5) goto L_0x0020
            if (r5 != r7) goto L_0x001e
            if (r6 != r7) goto L_0x0016
            r0 = r3
            goto L_0x0017
        L_0x0016:
            r0 = r2
        L_0x0017:
            if (r4 != r5) goto L_0x001b
            r1 = r3
            goto L_0x001c
        L_0x001b:
            r1 = r2
        L_0x001c:
            if (r0 != r1) goto L_0x0020
        L_0x001e:
            r0 = r3
            goto L_0x0021
        L_0x0020:
            r0 = r2
        L_0x0021:
            if (r0 != 0) goto L_0x003a
            if (r6 > r4) goto L_0x0037
            if (r5 > r7) goto L_0x0037
            if (r7 != r5) goto L_0x0035
            if (r4 != r5) goto L_0x002d
            r4 = r3
            goto L_0x002e
        L_0x002d:
            r4 = r2
        L_0x002e:
            if (r6 != r7) goto L_0x0032
            r5 = r3
            goto L_0x0033
        L_0x0032:
            r5 = r2
        L_0x0033:
            if (r4 != r5) goto L_0x0037
        L_0x0035:
            r4 = r3
            goto L_0x0038
        L_0x0037:
            r4 = r2
        L_0x0038:
            if (r4 == 0) goto L_0x003b
        L_0x003a:
            r2 = r3
        L_0x003b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.b.b(int, int, int, int):boolean");
    }
}
