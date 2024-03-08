package n2;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b implements Closeable {

    /* renamed from: f  reason: collision with root package name */
    public final InputStream f5154f;

    /* renamed from: g  reason: collision with root package name */
    public final Charset f5155g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f5156h;

    /* renamed from: i  reason: collision with root package name */
    public int f5157i;

    /* renamed from: j  reason: collision with root package name */
    public int f5158j;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends ByteArrayOutputStream {
        public a(int i7) {
            super(i7);
        }

        @Override // java.io.ByteArrayOutputStream, java.lang.Object
        public final String toString() {
            int i7 = ((ByteArrayOutputStream) this).count;
            if (i7 > 0 && ((ByteArrayOutputStream) this).buf[i7 - 1] == 13) {
                i7--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i7, b.this.f5155g.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public b(FileInputStream fileInputStream, Charset charset) {
        if (charset == null) {
            throw null;
        } else if (charset.equals(c.f5160a)) {
            this.f5154f = fileInputStream;
            this.f5155g = charset;
            this.f5156h = new byte[8192];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public final String b() {
        int i7;
        synchronized (this.f5154f) {
            byte[] bArr = this.f5156h;
            if (bArr != null) {
                if (this.f5157i >= this.f5158j) {
                    int read = this.f5154f.read(bArr, 0, bArr.length);
                    if (read != -1) {
                        this.f5157i = 0;
                        this.f5158j = read;
                    } else {
                        throw new EOFException();
                    }
                }
                for (int i8 = this.f5157i; i8 != this.f5158j; i8++) {
                    byte[] bArr2 = this.f5156h;
                    if (bArr2[i8] == 10) {
                        int i9 = this.f5157i;
                        if (i8 != i9) {
                            i7 = i8 - 1;
                            if (bArr2[i7] == 13) {
                                String str = new String(bArr2, i9, i7 - i9, this.f5155g.name());
                                this.f5157i = i8 + 1;
                                return str;
                            }
                        }
                        i7 = i8;
                        String str2 = new String(bArr2, i9, i7 - i9, this.f5155g.name());
                        this.f5157i = i8 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f5158j - this.f5157i) + 80);
                while (true) {
                    byte[] bArr3 = this.f5156h;
                    int i10 = this.f5157i;
                    aVar.write(bArr3, i10, this.f5158j - i10);
                    this.f5158j = -1;
                    InputStream inputStream = this.f5154f;
                    byte[] bArr4 = this.f5156h;
                    int read2 = inputStream.read(bArr4, 0, bArr4.length);
                    if (read2 != -1) {
                        this.f5157i = 0;
                        this.f5158j = read2;
                        for (int i11 = 0; i11 != this.f5158j; i11++) {
                            byte[] bArr5 = this.f5156h;
                            if (bArr5[i11] == 10) {
                                int i12 = this.f5157i;
                                if (i11 != i12) {
                                    aVar.write(bArr5, i12, i11 - i12);
                                }
                                this.f5157i = i11 + 1;
                                return aVar.toString();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            } else {
                throw new IOException("LineReader is closed");
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f5154f) {
            if (this.f5156h != null) {
                this.f5156h = null;
                this.f5154f.close();
            }
        }
    }
}