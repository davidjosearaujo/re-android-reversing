package b.a.a.a.e;

import android.os.StrictMode;
import java.util.concurrent.Callable;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class t0 {
    public static <T> T a(Callable<T> callable) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
            return callable.call();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
