package a.a.a.a;

import android.annotation.TargetApi;
import android.os.Bundle;
@TargetApi(16)
/* loaded from: /home/remnux/decompressedMalicious.dex */
class m0 {
    private static short[] $ = {6468, 6483, 6469, 6467, 6490, 6466, 6525, 6483, 6479, 2785, 2796, 2799, 2792, 2785, 8930, 8937, 8942, 8936, 8930, 8932, 8946, 9442, 9455, 9455, 9452, 9460, 9413, 9457, 9446, 9446, 9413, 9452, 9457, 9454, 9418, 9453, 9459, 9462, 9463, 4379, 4358, 4362, 4364, 4383, 4365};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    static Bundle a(l0 l0Var) {
        Bundle bundle = new Bundle();
        bundle.putString($(0, 9, 6454), l0Var.e());
        bundle.putCharSequence($(9, 14, 2701), l0Var.d());
        bundle.putCharSequenceArray($(14, 21, 8833), l0Var.b());
        bundle.putBoolean($(21, 39, 9347), l0Var.a());
        bundle.putBundle($(39, 45, 4478), l0Var.c());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle[] b(l0[] l0VarArr) {
        if (l0VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[l0VarArr.length];
        for (int i = 0; i < l0VarArr.length; i++) {
            bundleArr[i] = a(l0VarArr[i]);
        }
        return bundleArr;
    }
}
