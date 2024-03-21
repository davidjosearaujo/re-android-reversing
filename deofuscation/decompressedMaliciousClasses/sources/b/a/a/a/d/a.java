package b.a.a.a.d;

import android.os.IBinder;
import android.os.IInterface;
import b.a.a.a.e.x1;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public interface a extends IInterface {

    /* renamed from: b.a.a.a.d.a$a */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static abstract class AbstractBinderC0004a extends x1 implements a {
        private static short[] $ = {1245, 1233, 1235, 1168, 1241, 1233, 1233, 1241, 1234, 1243, 1168, 1247, 1232, 1242, 1228, 1233, 1239, 1242, 1168, 1241, 1235, 1229, 1168, 1242, 1223, 1232, 1247, 1235, 1239, 1245, 1168, 1271, 1265, 1244, 1236, 1243, 1245, 1226, 1257, 1228, 1247, 1230, 1230, 1243, 1228, 2244, 2248, 2250, 2185, 2240, 2248, 2248, 2240, 2251, 2242, 2185, 2246, 2249, 2243, 2261, 2248, 2254, 2243, 2185, 2240, 2250, 2260, 2185, 2243, 2270, 2249, 2246, 2250, 2254, 2244, 2185, 2286, 2280, 2245, 2253, 2242, 2244, 2259, 2288, 2261, 2246, 2263, 2263, 2242, 2261};

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }

        public AbstractBinderC0004a() {
            attachInterface(this, $(0, 45, 1214));
        }

        public static a x(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface($(45, 90, 2215));
            return queryLocalInterface instanceof a ? (a) queryLocalInterface : new b(iBinder);
        }
    }
}
