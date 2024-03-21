package b.a.a.a.f;

import android.content.Context;
import b.a.a.a.e.a1;
import b.a.a.a.e.d1;
import com.google.android.gms.common.api.a;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class c {

    /* renamed from: b */
    private static a.b<d1, Object> f197b;
    @Deprecated
    public static final a<Object> c;
    private static short[] $ = {1253, 1239, 1232, 1235, 1218, 1231, 1272, 1235, 1218, 1176, 1271, 1254, 1279};

    /* renamed from: a */
    private static a.g<d1> f196a = new a.g<>();
    @Deprecated
    public static final d d = new a1();

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    static {
        n nVar = new n();
        f197b = nVar;
        c = new a<>($(0, 13, 1206), nVar, f196a);
    }

    public static e a(Context context) {
        return new e(context);
    }
}
