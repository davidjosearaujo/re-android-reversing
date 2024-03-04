package t0;

import t0.a;

/* loaded from: classes.dex */
public final class b {
    public static final long a(int i7, int i8, int i9, int i10) {
        long j5;
        if (!(i8 >= i7)) {
            throw new IllegalArgumentException(("maxWidth(" + i8 + ") must be >= than minWidth(" + i7 + ')').toString());
        }
        if (!(i10 >= i9)) {
            throw new IllegalArgumentException(("maxHeight(" + i10 + ") must be >= than minHeight(" + i9 + ')').toString());
        }
        if (!(i7 >= 0 && i9 >= 0)) {
            throw new IllegalArgumentException(("minWidth(" + i7 + ") and minHeight(" + i9 + ") must be >= 0").toString());
        }
        int i11 = i10 == Integer.MAX_VALUE ? i9 : i10;
        int a7 = a.C0104a.a(i11);
        int i12 = i8 == Integer.MAX_VALUE ? i7 : i8;
        int a8 = a.C0104a.a(i12);
        if (a7 + a8 > 31) {
            throw new IllegalArgumentException("Can't represent a width of " + i12 + " and height of " + i11 + " in Constraints");
        }
        if (a8 == 13) {
            j5 = 3;
        } else if (a8 == 18) {
            j5 = 1;
        } else if (a8 == 15) {
            j5 = 2;
        } else if (a8 != 16) {
            throw new IllegalStateException("Should only have the provided constants.");
        } else {
            j5 = 0;
        }
        int i13 = i8 == Integer.MAX_VALUE ? 0 : i8 + 1;
        int i14 = i10 != Integer.MAX_VALUE ? i10 + 1 : 0;
        int i15 = a.f5998b[(int) j5];
        return (i13 << 33) | (i7 << 2) | j5 | (i9 << i15) | (i14 << (i15 + 31));
    }
}
