package r5;

import java.util.AbstractMap;
import java.util.Map;
import s5.a;
import s5.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class v {
    public static Map a(AbstractMap abstractMap) {
        if (!(abstractMap instanceof a) || (abstractMap instanceof c)) {
            return abstractMap;
        }
        c(abstractMap, "kotlin.collections.MutableMap");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x00b9, code lost:
        if ((r4 instanceof r5.e ? ((r5.e) r4).e() : r4 instanceof q5.a ? 0 : r4 instanceof q5.l ? 1 : r4 instanceof q5.p ? 2 : r4 instanceof q5.q ? 3 : r4 instanceof q5.r ? 4 : r4 instanceof q5.s ? 5 : r4 instanceof q5.t ? 6 : r4 instanceof q5.u ? 7 : r4 instanceof q5.v ? 8 : r4 instanceof q5.w ? 9 : r4 instanceof q5.b ? 10 : r4 instanceof q5.c ? 11 : r4 instanceof q5.d ? 12 : r4 instanceof q5.e ? 13 : r4 instanceof q5.f ? 14 : r4 instanceof q5.g ? 15 : r4 instanceof q5.h ? 16 : r4 instanceof q5.i ? 17 : r4 instanceof q5.j ? 18 : r4 instanceof q5.k ? 19 : r4 instanceof q5.m ? 20 : r4 instanceof q5.n ? 21 : r4 instanceof q5.o ? 22 : -1) == r3) goto L_0x00bd;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(int r3, java.lang.Object r4) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r5.v.b(int, java.lang.Object):void");
    }

    public static void c(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        ClassCastException classCastException = new ClassCastException(name + " cannot be cast to " + str);
        h.j(v.class.getName(), classCastException);
        throw classCastException;
    }
}
