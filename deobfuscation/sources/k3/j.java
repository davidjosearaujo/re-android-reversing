package k3;

import java.io.FilterInputStream;

/* loaded from: classes.dex */
public final class j extends FilterInputStream {

    /* renamed from: f */
    public int f4708f;

    public j(d dVar) {
        super(dVar);
        this.f4708f = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        int i7 = this.f4708f;
        int available = super.available();
        return i7 == Integer.MIN_VALUE ? available : Math.min(i7, available);
    }

    public final long b(long j5) {
        int i7 = this.f4708f;
        if (i7 == 0) {
            return -1L;
        }
        return (i7 == Integer.MIN_VALUE || j5 <= ((long) i7)) ? j5 : i7;
    }

    public final void d(long j5) {
        int i7 = this.f4708f;
        if (i7 == Integer.MIN_VALUE || j5 == -1) {
            return;
        }
        this.f4708f = (int) (i7 - j5);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i7) {
        super.mark(i7);
        this.f4708f = i7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        if (b(1L) == -1) {
            return -1;
        }
        int read = super.read();
        d(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i7, int i8) {
        int b2 = (int) b(i8);
        if (b2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i7, b2);
        d(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        super.reset();
        this.f4708f = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j5) {
        long b2 = b(j5);
        if (b2 == -1) {
            return 0L;
        }
        long skip = super.skip(b2);
        d(skip);
        return skip;
    }
}
