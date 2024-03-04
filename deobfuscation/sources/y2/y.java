package y2;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class y extends MediaDataSource {

    /* renamed from: f */
    public final /* synthetic */ ByteBuffer f6673f;

    public y(ByteBuffer byteBuffer) {
        this.f6673f = byteBuffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.f6673f.limit();
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j5, byte[] bArr, int i7, int i8) {
        if (j5 >= this.f6673f.limit()) {
            return -1;
        }
        this.f6673f.position((int) j5);
        int min = Math.min(i8, this.f6673f.remaining());
        this.f6673f.get(bArr, i7, min);
        return min;
    }
}
