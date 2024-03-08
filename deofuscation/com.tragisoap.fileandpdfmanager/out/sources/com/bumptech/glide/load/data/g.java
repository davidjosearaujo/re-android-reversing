package com.bumptech.glide.load.data;

import androidx.fragment.app.s0;
import java.io.FilterInputStream;
import java.io.InputStream;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g extends FilterInputStream {

    /* renamed from: h  reason: collision with root package name */
    public static final byte[] f2673h = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: i  reason: collision with root package name */
    public static final int f2674i = 31;

    /* renamed from: f  reason: collision with root package name */
    public final byte f2675f;

    /* renamed from: g  reason: collision with root package name */
    public int f2676g;

    public g(InputStream inputStream, int i7) {
        super(inputStream);
        if (i7 < -1 || i7 > 8) {
            throw new IllegalArgumentException(s0.g("Cannot add invalid orientation: ", i7));
        }
        this.f2675f = (byte) i7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i7) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int i7;
        int i8 = this.f2676g;
        int read = (i8 < 2 || i8 > (i7 = f2674i)) ? super.read() : i8 == i7 ? this.f2675f : f2673h[i8 - 2] & 255;
        if (read != -1) {
            this.f2676g++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i7, int i8) {
        int i9;
        int i10 = this.f2676g;
        int i11 = f2674i;
        if (i10 > i11) {
            i9 = super.read(bArr, i7, i8);
        } else if (i10 == i11) {
            bArr[i7] = this.f2675f;
            i9 = 1;
        } else if (i10 < 2) {
            i9 = super.read(bArr, i7, 2 - i10);
        } else {
            int min = Math.min(i11 - i10, i8);
            System.arraycopy(f2673h, this.f2676g - 2, bArr, i7, min);
            i9 = min;
        }
        if (i9 > 0) {
            this.f2676g += i9;
        }
        return i9;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j7) {
        long skip = super.skip(j7);
        if (skip > 0) {
            this.f2676g = (int) (((long) this.f2676g) + skip);
        }
        return skip;
    }
}
