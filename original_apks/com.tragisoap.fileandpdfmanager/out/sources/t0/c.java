package t0;

import a0.d;
import a0.e;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public interface c {
    default float a(float f7) {
        return getDensity() * f7;
    }

    default long b(long j7) {
        int i7 = (j7 > e.f6005b ? 1 : (j7 == e.f6005b ? 0 : -1));
        boolean z6 = true;
        if (!(i7 != 0)) {
            return d.f30a;
        }
        if (i7 != 0) {
            float a7 = a(Float.intBitsToFloat((int) (j7 >> 32)));
            if (i7 == 0) {
                z6 = false;
            }
            if (z6) {
                return e.d(a7, a(Float.intBitsToFloat((int) (j7 & 4294967295L))));
            }
            throw new IllegalStateException("DpSize is unspecified".toString());
        }
        throw new IllegalStateException("DpSize is unspecified".toString());
    }

    float getDensity();
}
