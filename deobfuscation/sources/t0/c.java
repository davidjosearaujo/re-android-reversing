package t0;

/* loaded from: classes.dex */
public interface c {
    default float a(float f7) {
        return getDensity() * f7;
    }

    default long b(long j7) {
        int i7 = (j7 > e.f6005b ? 1 : (j7 == e.f6005b ? 0 : -1));
        if (i7 != 0) {
            if (i7 != 0) {
                float a7 = a(Float.intBitsToFloat((int) (j7 >> 32)));
                if (i7 != 0) {
                    return a0.e.d(a7, a(Float.intBitsToFloat((int) (j7 & 4294967295L))));
                }
                throw new IllegalStateException("DpSize is unspecified".toString());
            }
            throw new IllegalStateException("DpSize is unspecified".toString());
        }
        return a0.d.f30a;
    }

    float getDensity();
}
