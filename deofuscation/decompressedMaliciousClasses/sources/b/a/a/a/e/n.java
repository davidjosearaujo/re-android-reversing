package b.a.a.a.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class n<R extends j> extends Handler {
    private static short[] $ = {28391, 28364, 28365, 28292, 28375, 28291, 28360, 28365, 28364, 28372, 28291, 28363, 28364, 28372, 28291, 28375, 28364, 28291, 28363, 28354, 28365, 28359, 28367, 28358, 28291, 28366, 28358, 28368, 28368, 28354, 28356, 28358, 28313, 28291, 27087, 27116, 27134, 27112, 27101, 27112, 27107, 27113, 27108, 27107, 27114, 27103, 27112, 27134, 27128, 27105, 27129};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public n(Looper looper) {
        super(looper);
    }

    public final void a(k<? super R> kVar, R r) {
        sendMessage(obtainMessage(1, new Pair(kVar, r)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            Pair pair = (Pair) message.obj;
            k kVar = (k) pair.first;
            j jVar = (j) pair.second;
            try {
                kVar.a(jVar);
            } catch (RuntimeException e) {
                l.i(jVar);
                throw e;
            }
        } else if (i != 2) {
            StringBuilder sb = new StringBuilder(45);
            sb.append($(0, 34, 28323));
            sb.append(i);
            Log.wtf($(34, 51, 27021), sb.toString(), new Exception());
        } else {
            ((l) message.obj).k(Status.h);
        }
    }
}
