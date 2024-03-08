package z5;

import g5.s;
import java.util.Collection;
import java.util.Iterator;
import q2.a;
import r5.h;
import w5.b;
import w5.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class f extends e {
    public static final boolean V(String str) {
        boolean z6;
        h.f(str, "<this>");
        if (str.length() != 0) {
            c cVar = new c(0, str.length() - 1);
            if (!(cVar instanceof Collection) || !((Collection) cVar).isEmpty()) {
                Iterator<Integer> it = cVar.iterator();
                while (((b) it).f6416h) {
                    if (!a.E(str.charAt(((s) it).nextInt()))) {
                        z6 = false;
                        break;
                    }
                }
            }
            z6 = true;
            if (!z6) {
                return false;
            }
        }
        return true;
    }

    public static final boolean W(int i7, int i8, int i9, String str, String str2, boolean z6) {
        h.f(str, "<this>");
        h.f(str2, "other");
        return !z6 ? str.regionMatches(i7, str2, i8, i9) : str.regionMatches(z6, i7, str2, i8, i9);
    }
}
