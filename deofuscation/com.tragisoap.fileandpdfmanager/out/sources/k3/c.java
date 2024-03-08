package k3;

import androidx.activity.h;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c extends FilterInputStream {

    /* renamed from: f  reason: collision with root package name */
    public final long f4692f;

    /* renamed from: g  reason: collision with root package name */
    public int f4693g;

    public c(InputStream inputStream, long j7) {
        super(inputStream);
        this.f4692f = j7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        return (int) Math.max(this.f4692f - ((long) this.f4693g), (long) ((FilterInputStream) this).in.available());
    }

    public final void b(int i7) {
        if (i7 >= 0) {
            this.f4693g += i7;
        } else if (this.f4692f - ((long) this.f4693g) > 0) {
            StringBuilder d7 = h.d("Failed to read all expected data, expected: ");
            d7.append(this.f4692f);
            d7.append(", but read: ");
            d7.append(this.f4693g);
            throw new IOException(d7.toString());
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        int read;
        read = super.read();
        b(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i7, int i8) {
        int read;
        read = super.read(bArr, i7, i8);
        b(read);
        return read;
    }
}
