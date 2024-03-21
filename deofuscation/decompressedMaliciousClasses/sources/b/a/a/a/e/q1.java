package b.a.a.a.e;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class q1 extends w1 implements p1 {
    private static short[] $ = {7201, 7213, 7215, 7276, 7205, 7213, 7213, 7205, 7214, 7207, 7276, 7203, 7212, 7206, 7216, 7213, 7211, 7206, 7276, 7205, 7215, 7217, 7276, 7217, 7211, 7205, 7212, 7211, 7212, 7276, 7211, 7212, 7222, 7207, 7216, 7212, 7203, 7214, 7276, 7179, 7185, 7211, 7205, 7212, 7179, 7212, 7185, 7207, 7216, 7220, 7211, 7201, 7207};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q1(IBinder iBinder) {
        super(iBinder, $(0, 53, 7234));
    }

    @Override // b.a.a.a.e.p1
    public final void p(s1 s1Var, n1 n1Var) {
        Parcel a2 = a();
        y1.c(a2, s1Var);
        y1.b(a2, n1Var);
        c(12, a2);
    }
}
