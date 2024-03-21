package b.a.a.a.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class o {
    private static short[] $ = {5997, 6111, 5977, 5918, 5997, 6111, 5982, 6006, 6141, 5982, 5983, 5980, 5983, 5983, 5972, 5981, 6047, 6077, 6106, 5915, 5945, 5911, 5997, 6096, 5997, 3417, 3563, 3437, 3521, 3417, 3563, 3434, 3577, 3529, 3434, 3435, 3432, 3435, 3435, 3424, 3433, 3516, 3564, 3537, 3333, 3348, 3514, 3367, 3484, 3417};

    /* renamed from: a  reason: collision with root package name */
    static final l[] f129a = {new p(l.y($(0, 25, 5981))), new q(l.y($(25, 50, 3433)))};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }
}
