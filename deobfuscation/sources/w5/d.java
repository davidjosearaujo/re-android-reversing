package w5;

import r5.h;

/* loaded from: classes.dex */
public class d extends q2.a {
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
        h.f(2, "step");
        return new a(cVar.f6411f, cVar.f6412g, cVar.f6413h <= 0 ? -2 : 2);
    }

    public static final c Z(int i7, int i8) {
        if (i8 <= Integer.MIN_VALUE) {
            c cVar = c.f6418i;
            return c.f6418i;
        }
        return new c(i7, i8 - 1);
    }
}
