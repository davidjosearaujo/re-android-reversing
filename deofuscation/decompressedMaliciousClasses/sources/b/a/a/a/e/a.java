package b.a.a.a.e;

import android.os.Build;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class a {
    private static short[] $ = {4758, 4784, 4771, 4780, 4785, 4771, 4769, 4790, 4779, 4781, 4780, 4758, 4781, 4781, 4750, 4771, 4784, 4773, 4775, 4743, 4794, 4769, 4775, 4786, 4790, 4779, 4781, 4780, 4856, 4834};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public a(int i) {
    }

    public static Status a(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 15 && (remoteException instanceof TransactionTooLargeException)) {
            sb.append($(0, 30, 4802));
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void b(p pVar, boolean z);

    public abstract void c(v<?> vVar);

    public abstract void e(Status status);
}
