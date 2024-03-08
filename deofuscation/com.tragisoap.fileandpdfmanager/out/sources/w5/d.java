package w5;

import q2.a;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class d extends a {
    public static final double V(double d7, double d8, double d9) {
        if (d8 <= d9) {
            return d7 < d8 ? d8 : d7 > d9 ? d9 : d7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d9 + " is less than minimum " + d8 + '.');
    }

    public static final float W(float f7, float f8, float f9) {
        if (f8 <= f9) {
            return f7 < f8 ? f8 : f7 > f9 ? f9 : f7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f9 + " is less than minimum " + f8 + '.');
    }

    public static final int X(int i7, int i8, int i9) {
        if (i8 <= i9) {
            return i7 < i8 ? i8 : i7 > i9 ? i9 : i7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i9 + " is less than minimum " + i8 + '.');
    }

    public static final a Y(c cVar) {
        h.f(cVar, "<this>");
        int i7 = 2;
        h.f(2, "step");
        int i8 = cVar.f6411f;
        int i9 = cVar.f6412g;
        if (cVar.f6413h <= 0) {
            i7 = -2;
        }
        return new a(i8, i9, i7);
    }

    public static final c Z(int i7, int i8) {
        if (i8 > Integer.MIN_VALUE) {
            return new c(i7, i8 - 1);
        }
        c cVar = c.f6418i;
        return c.f6418i;
    }
}
