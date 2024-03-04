package i6;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: classes.dex */
public interface u extends Closeable, Flushable {
    w c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    void h(d dVar, long j5);
}
