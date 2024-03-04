package y4;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class t implements Closeable {
    public final byte[] b() {
        long d7 = d();
        if (d7 > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + d7);
        }
        i6.f f7 = f();
        try {
            byte[] u6 = f7.u();
            z4.h.b(f7);
            if (d7 == -1 || d7 == u6.length) {
                return u6;
            }
            throw new IOException("Content-Length and stream length disagree");
        } catch (Throwable th) {
            z4.h.b(f7);
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        f().close();
    }

    public abstract long d();

    public abstract o e();

    public abstract i6.f f();
}
