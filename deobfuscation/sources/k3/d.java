package k3;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class d extends InputStream {

    /* renamed from: h */
    public static final ArrayDeque f4694h;

    /* renamed from: f */
    public InputStream f4695f;

    /* renamed from: g */
    public IOException f4696g;

    static {
        char[] cArr = l.f4712a;
        f4694h = new ArrayDeque(0);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f4695f.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f4695f.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i7) {
        this.f4695f.mark(i7);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f4695f.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() {
        try {
            return this.f4695f.read();
        } catch (IOException e) {
            this.f4696g = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        try {
            return this.f4695f.read(bArr);
        } catch (IOException e) {
            this.f4696g = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i7, int i8) {
        try {
            return this.f4695f.read(bArr, i7, i8);
        } catch (IOException e) {
            this.f4696g = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.f4695f.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j5) {
        try {
            return this.f4695f.skip(j5);
        } catch (IOException e) {
            this.f4696g = e;
            throw e;
        }
    }
}
