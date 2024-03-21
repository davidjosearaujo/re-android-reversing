package b.a.a.a.c;

import android.content.Context;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class k {
    private static short[] $ = {6241, 6217, 6217, 6209, 6218, 6211, 6245, 6211, 6228, 6226, 6223, 6208, 6223, 6213, 6215, 6226, 6211, 6229, 6875, 6899, 6899, 6907, 6896, 6905, 6879, 6905, 6894, 6888, 6901, 6906, 6901, 6911, 6909, 6888, 6905, 6895, 6844, 6900, 6909, 6895, 6844, 6910, 6905, 6905, 6898, 6844, 6901, 6898, 6901, 6888, 6901, 6909, 6896, 6901, 6886, 6905, 6904, 6844, 6909, 6896, 6894, 6905, 6909, 6904, 6885};

    /* renamed from: a  reason: collision with root package name */
    private static Context f125a;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(Context context) {
        synchronized (k.class) {
            if (f125a != null) {
                Log.w($(0, 18, 6182), $(18, 65, 6812));
            } else if (context != null) {
                f125a = context.getApplicationContext();
            }
        }
    }
}
