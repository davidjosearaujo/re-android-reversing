package b.a.a.a.d;

import android.os.IBinder;
import b.a.a.a.e.w1;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class b extends w1 implements a {
    private static short[] $ = {662, 666, 664, 731, 658, 666, 666, 658, 665, 656, 731, 660, 667, 657, 647, 666, 668, 657, 731, 658, 664, 646, 731, 657, 652, 667, 660, 664, 668, 662, 731, 700, 698, 663, 671, 656, 662, 641, 674, 647, 660, 645, 645, 656, 647};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(IBinder iBinder) {
        super(iBinder, $(0, 45, 757));
    }
}
