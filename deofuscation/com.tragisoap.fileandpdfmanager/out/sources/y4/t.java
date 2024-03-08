package y4;

import i6.f;
import java.io.Closeable;
import java.io.IOException;
import z4.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class t implements Closeable {
    /* JADX WARN: Finally extract failed */
    public final byte[] b() {
        long d7 = d();
        if (d7 <= 2147483647L) {
            f f7 = f();
            try {
                byte[] u6 = f7.u();
                h.b(f7);
                if (d7 == -1 || d7 == ((long) u6.length)) {
                    return u6;
                }
                throw new IOException("Content-Length and stream length disagree");
            } catch (Throwable th) {
                h.b(f7);
                throw th;
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + d7);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        f().close();
    }

    public abstract long d();

    public abstract o e();

    public abstract f f();
}
