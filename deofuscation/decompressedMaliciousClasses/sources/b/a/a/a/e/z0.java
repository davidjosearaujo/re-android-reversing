package b.a.a.a.e;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class z0 extends w1 implements y0 {
    private static short[] $ = {1061, 1065, 1067, 1128, 1057, 1065, 1065, 1057, 1066, 1059, 1128, 1063, 1064, 1058, 1076, 1065, 1071, 1058, 1128, 1057, 1067, 1077, 1128, 1077, 1063, 1056, 1059, 1074, 1087, 1064, 1059, 1074, 1128, 1071, 1064, 1074, 1059, 1076, 1064, 1063, 1066, 1128, 1039, 1045, 1063, 1056, 1059, 1074, 1087, 1032, 1059, 1074, 1045, 1059, 1076, 1072, 1071, 1061, 1059};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0(IBinder iBinder) {
        super(iBinder, $(0, 59, 1094));
    }

    @Override // b.a.a.a.e.y0
    public final void q(w0 w0Var) {
        Parcel a2 = a();
        y1.b(a2, w0Var);
        c(14, a2);
    }
}
