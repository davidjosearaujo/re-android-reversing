package y2;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class t extends FilterInputStream {

    /* renamed from: f */
    public volatile byte[] f6652f;

    /* renamed from: g */
    public int f6653g;

    /* renamed from: h */
    public int f6654h;

    /* renamed from: i */
    public int f6655i;

    /* renamed from: j */
    public int f6656j;

    /* renamed from: k */
    public final s2.b f6657k;

    /* loaded from: classes.dex */
    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    public t(InputStream inputStream, s2.b bVar) {
        super(inputStream);
        this.f6655i = -1;
        this.f6657k = bVar;
        this.f6652f = (byte[]) bVar.c(65536, byte[].class);
    }

    public static void e() {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f6652f == null || inputStream == null) {
            e();
            throw null;
        }
        return (this.f6653g - this.f6656j) + inputStream.available();
    }

    public final int b(InputStream inputStream, byte[] bArr) {
        int i7 = this.f6655i;
        if (i7 != -1) {
            int i8 = this.f6656j - i7;
            int i9 = this.f6654h;
            if (i8 < i9) {
                if (i7 == 0 && i9 > bArr.length && this.f6653g == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i9) {
                        i9 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f6657k.c(i9, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f6652f = bArr2;
                    this.f6657k.put(bArr);
                    bArr = bArr2;
                } else if (i7 > 0) {
                    System.arraycopy(bArr, i7, bArr, 0, bArr.length - i7);
                }
                int i10 = this.f6656j - this.f6655i;
                this.f6656j = i10;
                this.f6655i = 0;
                this.f6653g = 0;
                int read = inputStream.read(bArr, i10, bArr.length - i10);
                int i11 = this.f6656j;
                if (read > 0) {
                    i11 += read;
                }
                this.f6653g = i11;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f6655i = -1;
            this.f6656j = 0;
            this.f6653g = read2;
        }
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f6652f != null) {
            this.f6657k.put(this.f6652f);
            this.f6652f = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public final synchronized void d() {
        if (this.f6652f != null) {
            this.f6657k.put(this.f6652f);
            this.f6652f = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i7) {
        this.f6654h = Math.max(this.f6654h, i7);
        this.f6655i = this.f6656j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        byte[] bArr = this.f6652f;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            e();
            throw null;
        } else if (this.f6656j < this.f6653g || b(inputStream, bArr) != -1) {
            if (bArr != this.f6652f && (bArr = this.f6652f) == null) {
                e();
                throw null;
            }
            int i7 = this.f6653g;
            int i8 = this.f6656j;
            if (i7 - i8 > 0) {
                this.f6656j = i8 + 1;
                return bArr[i8] & 255;
            }
            return -1;
        } else {
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i7, int i8) {
        int i9;
        int i10;
        byte[] bArr2 = this.f6652f;
        if (bArr2 == null) {
            e();
            throw null;
        } else if (i8 == 0) {
            return 0;
        } else {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream == null) {
                e();
                throw null;
            }
            int i11 = this.f6656j;
            int i12 = this.f6653g;
            if (i11 < i12) {
                int i13 = i12 - i11;
                if (i13 >= i8) {
                    i13 = i8;
                }
                System.arraycopy(bArr2, i11, bArr, i7, i13);
                this.f6656j += i13;
                if (i13 == i8 || inputStream.available() == 0) {
                    return i13;
                }
                i7 += i13;
                i9 = i8 - i13;
            } else {
                i9 = i8;
            }
            while (true) {
                if (this.f6655i == -1 && i9 >= bArr2.length) {
                    i10 = inputStream.read(bArr, i7, i9);
                    if (i10 == -1) {
                        return i9 != i8 ? i8 - i9 : -1;
                    }
                } else if (b(inputStream, bArr2) == -1) {
                    return i9 != i8 ? i8 - i9 : -1;
                } else {
                    if (bArr2 != this.f6652f && (bArr2 = this.f6652f) == null) {
                        e();
                        throw null;
                    }
                    int i14 = this.f6653g;
                    int i15 = this.f6656j;
                    i10 = i14 - i15;
                    if (i10 >= i9) {
                        i10 = i9;
                    }
                    System.arraycopy(bArr2, i15, bArr, i7, i10);
                    this.f6656j += i10;
                }
                i9 -= i10;
                if (i9 == 0) {
                    return i8;
                }
                if (inputStream.available() == 0) {
                    return i8 - i9;
                }
                i7 += i10;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (this.f6652f == null) {
            throw new IOException("Stream is closed");
        }
        int i7 = this.f6655i;
        if (-1 == i7) {
            throw new a("Mark has been invalidated, pos: " + this.f6656j + " markLimit: " + this.f6654h);
        }
        this.f6656j = i7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j5) {
        if (j5 < 1) {
            return 0L;
        }
        byte[] bArr = this.f6652f;
        if (bArr == null) {
            e();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            e();
            throw null;
        }
        int i7 = this.f6653g;
        int i8 = this.f6656j;
        if (i7 - i8 >= j5) {
            this.f6656j = (int) (i8 + j5);
            return j5;
        }
        long j7 = i7 - i8;
        this.f6656j = i7;
        if (this.f6655i == -1 || j5 > this.f6654h) {
            long skip = inputStream.skip(j5 - j7);
            if (skip > 0) {
                this.f6655i = -1;
            }
            return j7 + skip;
        } else if (b(inputStream, bArr) == -1) {
            return j7;
        } else {
            int i9 = this.f6653g;
            int i10 = this.f6656j;
            if (i9 - i10 >= j5 - j7) {
                this.f6656j = (int) ((i10 + j5) - j7);
                return j5;
            }
            long j8 = (j7 + i9) - i10;
            this.f6656j = i9;
            return j8;
        }
    }
}
