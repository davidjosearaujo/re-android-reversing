package k3;

import java.io.FilterInputStream;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j extends FilterInputStream {

    /* renamed from: f  reason: collision with root package name */
    public int f4708f = Integer.MIN_VALUE;

    public j(d dVar) {
        super(dVar);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        int i7 = this.f4708f;
        int available = super.available();
        return i7 == Integer.MIN_VALUE ? available : Math.min(i7, available);
    }

    public final long b(long j7) {
        int i7 = this.f4708f;
        if (i7 == 0) {
            return -1;
        }
        return (i7 == Integer.MIN_VALUE || j7 <= ((long) i7)) ? j7 : (long) i7;
    }

    public final void d(long j7) {
        int i7 = this.f4708f;
        if (i7 != Integer.MIN_VALUE && j7 != -1) {
            this.f4708f = (int) (((long) i7) - j7);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i7) {
        super.mark(i7);
        this.f4708f = i7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        if (b(1) == -1) {
            return -1;
        }
        int read = super.read();
        d(1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i7, int i8) {
        int b2 = (int) b((long) i8);
        if (b2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i7, b2);
        d((long) read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        super.reset();
        this.f4708f = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j7) {
        long b2 = b(j7);
        if (b2 == -1) {
            return 0;
        }
        long skip = super.skip(b2);
        d(skip);
        return skip;
    }
}
