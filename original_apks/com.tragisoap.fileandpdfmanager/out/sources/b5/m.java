package b5;

import androidx.activity.h;
import i6.d;
import i6.u;
import i6.w;
import java.net.ProtocolException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class m implements u {

    /* renamed from: f  reason: collision with root package name */
    public boolean f2433f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2434g;

    /* renamed from: h  reason: collision with root package name */
    public final d f2435h;

    public m() {
        this(-1);
    }

    public m(int i7) {
        this.f2435h = new d();
        this.f2434g = i7;
    }

    @Override // i6.u
    public final w c() {
        return w.f4537d;
    }

    @Override // i6.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (!this.f2433f) {
            this.f2433f = true;
            if (this.f2435h.f4498g < ((long) this.f2434g)) {
                StringBuilder d7 = h.d("content-length promised ");
                d7.append(this.f2434g);
                d7.append(" bytes, but received ");
                d7.append(this.f2435h.f4498g);
                throw new ProtocolException(d7.toString());
            }
        }
    }

    @Override // i6.u, java.io.Flushable
    public final void flush() {
    }

    @Override // i6.u
    public final void h(d dVar, long j7) {
        if (!this.f2433f) {
            long j8 = dVar.f4498g;
            byte[] bArr = z4.h.f6955a;
            if ((j7 | 0) < 0 || 0 > j8 || j8 - 0 < j7) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i7 = this.f2434g;
            if (i7 == -1 || this.f2435h.f4498g <= ((long) i7) - j7) {
                this.f2435h.h(dVar, j7);
                return;
            }
            StringBuilder d7 = h.d("exceeded content-length limit of ");
            d7.append(this.f2434g);
            d7.append(" bytes");
            throw new ProtocolException(d7.toString());
        }
        throw new IllegalStateException("closed");
    }
}
