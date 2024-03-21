package b.a.a.a.e;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class e1 {
    private static short[] $ = {5507, 5505, 5532, 5525, 5530, 5535, 5526, 1875, 1883, 1879, 1887, 1882, 5151, 5157, 5163, 5154, 5125, 5154, 5218, 5133, 5148, 5125, 12085, 12047, 12033, 12040, 12079, 12040, 12104, 12079, 12072, 12082, 12067, 12084, 12072, 12071, 12074, 12089, 12071, 12086, 12079};

    /* renamed from: a */
    private static a.g<r1> f145a = new a.g<>();

    /* renamed from: b */
    private static a.g<r1> f146b = new a.g<>();
    public static final a.b<r1, j1> c = new f1();
    private static a.b<r1, h1> d = new g1();
    public static final a<j1> e = new a<>($(12, 22, 5196), c, f145a);

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    static {
        new Scope($(0, 7, 5619));
        new Scope($(7, 12, 1846));
        new a($(22, 41, 12134), d, f146b);
    }
}
