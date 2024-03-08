package t0;

import t0.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b {
    public static final long a(int i7, int i8, int i9, int i10) {
        long j7;
        int i11 = 0;
        if (i8 >= i7) {
            if (i10 >= i9) {
                if (i7 >= 0 && i9 >= 0) {
                    int i12 = i10 == Integer.MAX_VALUE ? i9 : i10;
                    int a7 = a.C0104a.a(i12);
                    int i13 = i8 == Integer.MAX_VALUE ? i7 : i8;
                    int a8 = a.C0104a.a(i13);
                    if (a7 + a8 <= 31) {
                        if (a8 == 13) {
                            j7 = 3;
                        } else if (a8 == 18) {
                            j7 = 1;
                        } else if (a8 == 15) {
                            j7 = 2;
                        } else if (a8 == 16) {
                            j7 = 0;
                        } else {
                            throw new IllegalStateException("Should only have the provided constants.");
                        }
                        int i14 = i8 == Integer.MAX_VALUE ? 0 : i8 + 1;
                        if (i10 != Integer.MAX_VALUE) {
                            i11 = i10 + 1;
                        }
                        int i15 = a.f5998b[(int) j7];
                        return (((long) i14) << 33) | (((long) i7) << 2) | j7 | (((long) i9) << i15) | (((long) i11) << (i15 + 31));
                    }
                    throw new IllegalArgumentException("Can't represent a width of " + i13 + " and height of " + i12 + " in Constraints");
                }
                throw new IllegalArgumentException(("minWidth(" + i7 + ") and minHeight(" + i9 + ") must be >= 0").toString());
            }
            throw new IllegalArgumentException(("maxHeight(" + i10 + ") must be >= than minHeight(" + i9 + ')').toString());
        }
        throw new IllegalArgumentException(("maxWidth(" + i8 + ") must be >= than minWidth(" + i7 + ')').toString());
    }
}
