package b0;

/* loaded from: classes.dex */
public final class g implements Comparable<g> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f2344f = new a();

    /* renamed from: g  reason: collision with root package name */
    public static final float f2345g;

    /* loaded from: classes.dex */
    public static final class a {
    }

    static {
        a(1.0f);
        a(-1.0f);
        f2345g = Float.intBitsToFloat(1056964608);
    }

    public static short a(float f7) {
        int i7;
        int i8;
        f2344f.getClass();
        int floatToRawIntBits = Float.floatToRawIntBits(f7);
        int i9 = floatToRawIntBits >>> 31;
        int i10 = (floatToRawIntBits >>> 23) & 255;
        int i11 = floatToRawIntBits & 8388607;
        if (i10 == 255) {
            i7 = i11 != 0 ? 512 : 0;
            r3 = 31;
        } else {
            int i12 = (i10 - 127) + 15;
            if (i12 >= 31) {
                r3 = 49;
                i7 = 0;
            } else if (i12 > 0) {
                int i13 = i11 >> 13;
                if ((i11 & 4096) != 0) {
                    i7 = ((i12 << 10) | i13) + 1;
                    i8 = i9 << 15;
                    return (short) (i7 | i8);
                }
                i7 = i13;
                r3 = i12;
            } else if (i12 >= -10) {
                int i14 = (i11 | 8388608) >> (1 - i12);
                if ((i14 & 4096) != 0) {
                    i14 += 8192;
                }
                i7 = i14 >> 13;
            } else {
                i7 = 0;
            }
        }
        i8 = (i9 << 15) | (r3 << 10);
        return (short) (i7 | i8);
    }

    public static final float b(short s) {
        int i7;
        int i8;
        int i9 = s & 65535;
        int i10 = 32768 & i9;
        int i11 = (i9 >>> 10) & 31;
        int i12 = i9 & 1023;
        int i13 = 0;
        if (i11 != 0) {
            int i14 = i12 << 13;
            if (i11 == 31) {
                i7 = 255;
                if (i14 != 0) {
                    i14 |= 4194304;
                }
            } else {
                i7 = (i11 - 15) + 127;
            }
            int i15 = i14;
            i13 = i7;
            i8 = i15;
        } else if (i12 != 0) {
            float intBitsToFloat = Float.intBitsToFloat(i12 + 1056964608) - f2345g;
            return i10 == 0 ? intBitsToFloat : -intBitsToFloat;
        } else {
            i8 = 0;
        }
        return Float.intBitsToFloat(i8 | (i10 << 16) | (i13 << 23));
    }
}
