package b0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g implements Comparable<g> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f2344f = new a();

    /* renamed from: g  reason: collision with root package name */
    public static final float f2345g = Float.intBitsToFloat(1056964608);

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {
    }

    static {
        a(1.0f);
        a(-1.0f);
    }

    public static short a(float f7) {
        int i7;
        f2344f.getClass();
        int floatToRawIntBits = Float.floatToRawIntBits(f7);
        int i8 = floatToRawIntBits >>> 31;
        int i9 = (floatToRawIntBits >>> 23) & 255;
        int i10 = floatToRawIntBits & 8388607;
        int i11 = 0;
        if (i9 == 255) {
            if (i10 != 0) {
                i11 = 512;
            }
            i11 = 31;
        } else {
            int i12 = (i9 - 127) + 15;
            if (i12 >= 31) {
                i11 = 49;
                i11 = 0;
            } else if (i12 > 0) {
                int i13 = i10 >> 13;
                if ((i10 & 4096) != 0) {
                    i11 = ((i12 << 10) | i13) + 1;
                    i7 = i8 << 15;
                    return (short) (i11 | i7);
                }
                i11 = i13;
                i11 = i12;
            } else if (i12 >= -10) {
                int i14 = (i10 | 8388608) >> (1 - i12);
                if ((i14 & 4096) != 0) {
                    i14 += 8192;
                }
                i11 = i14 >> 13;
            } else {
                i11 = 0;
            }
        }
        i7 = (i8 << 15) | (i11 << 10);
        return (short) (i11 | i7);
    }

    public static final float b(short s) {
        int i7;
        int i8 = s & 65535;
        int i9 = 32768 & i8;
        int i10 = (i8 >>> 10) & 31;
        int i11 = i8 & 1023;
        int i12 = 0;
        if (i10 != 0) {
            i7 = i11 << 13;
            if (i10 == 31) {
                i12 = 255;
                if (i7 != 0) {
                    i7 |= 4194304;
                }
            } else {
                i12 = (i10 - 15) + 127;
            }
        } else if (i11 != 0) {
            float intBitsToFloat = Float.intBitsToFloat(i11 + 1056964608) - f2345g;
            return i9 == 0 ? intBitsToFloat : -intBitsToFloat;
        } else {
            i7 = 0;
        }
        return Float.intBitsToFloat(i7 | (i9 << 16) | (i12 << 23));
    }
}
