package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LimitedInputStream extends FilterInputStream {
    private int mBytesToRead;
    private int mBytesToReadWhenMarked;

    public LimitedInputStream(InputStream inputStream, int i) {
        super(inputStream);
        Objects.requireNonNull(inputStream);
        if (i >= 0) {
            this.mBytesToRead = i;
            this.mBytesToReadWhenMarked = -1;
            return;
        }
        throw new IllegalArgumentException("limit must be >= 0");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return Math.min(((FilterInputStream) this).in.available(), this.mBytesToRead);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        if (((FilterInputStream) this).in.markSupported()) {
            ((FilterInputStream) this).in.mark(i);
            this.mBytesToReadWhenMarked = this.mBytesToRead;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.mBytesToRead == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.mBytesToRead--;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (((FilterInputStream) this).in.markSupported()) {
            if (this.mBytesToReadWhenMarked != -1) {
                ((FilterInputStream) this).in.reset();
                this.mBytesToRead = this.mBytesToReadWhenMarked;
                return;
            }
            throw new IOException("mark not set");
        }
        throw new IOException("mark is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = ((FilterInputStream) this).in.skip(Math.min(j, this.mBytesToRead));
        this.mBytesToRead = (int) (this.mBytesToRead - skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.mBytesToRead;
        if (i3 == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read(bArr, i, Math.min(i2, i3));
        if (read > 0) {
            this.mBytesToRead -= read;
        }
        return read;
    }
}