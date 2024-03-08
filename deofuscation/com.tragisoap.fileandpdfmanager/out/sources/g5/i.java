package g5;

import java.util.Arrays;
import q2.a;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class i extends a {
    public static final void V(int i7, int i8, int i9, int[] iArr, int[] iArr2) {
        h.f(iArr, "<this>");
        h.f(iArr2, "destination");
        System.arraycopy(iArr, i8, iArr2, i7, i9 - i8);
    }

    public static final void W(Object[] objArr, Object[] objArr2, int i7, int i8, int i9) {
        h.f(objArr, "<this>");
        h.f(objArr2, "destination");
        System.arraycopy(objArr, i8, objArr2, i7, i9 - i8);
    }

    public static /* synthetic */ void X(int[] iArr, int[] iArr2, int i7, int i8) {
        if ((i8 & 8) != 0) {
            i7 = iArr.length;
        }
        V(0, 0, i7, iArr, iArr2);
    }

    public static /* synthetic */ void Y(Object[] objArr, Object[] objArr2, int i7, int i8, int i9) {
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = objArr.length;
        }
        W(objArr, objArr2, 0, i7, i8);
    }

    public static final void Z(Object[] objArr, int i7, int i8) {
        h.f(objArr, "<this>");
        Arrays.fill(objArr, i7, i8, (Object) null);
    }

    public static void a0(Object[] objArr) {
        int length = objArr.length;
        h.f(objArr, "<this>");
        Arrays.fill(objArr, 0, length, (Object) null);
    }
}
