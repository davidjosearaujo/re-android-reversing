package i6;

import java.io.Closeable;
import java.io.Flushable;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public interface u extends Closeable, Flushable {
    w c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Override // java.io.Flushable
    void flush();

    void h(d dVar, long j7);
}
