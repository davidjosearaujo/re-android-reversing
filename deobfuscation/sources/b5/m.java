package b5;

import i6.u;
import i6.w;
import java.net.ProtocolException;

/* loaded from: classes.dex */
public final class m implements u {

    /* renamed from: f */
    public boolean f2433f;

    /* renamed from: g */
    public final int f2434g;

    /* renamed from: h */
    public final i6.d f2435h;

    public m() {
        this(-1);
    }

    public m(int i7) {
        this.f2435h = new i6.d();
        this.f2434g = i7;
    }

    @Override // i6.u
    public final w c() {
        return w.f4537d;
    }

    @Override // i6.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f2433f) {
            return;
        }
        this.f2433f = true;
        if (this.f2435h.f4498g >= this.f2434g) {
            return;
        }
        StringBuilder d7 = androidx.activity.h.d("content-length promised ");
        d7.append(this.f2434g);
        d7.append(" bytes, but received ");
        d7.append(this.f2435h.f4498g);
        throw new ProtocolException(d7.toString());
    }

    @Override // i6.u, java.io.Flushable
    public final void flush() {
    }

    @Override // i6.u
    public final void h(i6.d dVar, long j5) {
        if (this.f2433f) {
            throw new IllegalStateException("closed");
        }
        long j7 = dVar.f4498g;
        byte[] bArr = z4.h.f6955a;
        if ((j5 | 0) < 0 || 0 > j7 || j7 - 0 < j5) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i7 = this.f2434g;
        if (i7 == -1 || this.f2435h.f4498g <= i7 - j5) {
            this.f2435h.h(dVar, j5);
            return;
        }
        StringBuilder d7 = androidx.activity.h.d("exceeded content-length limit of ");
        d7.append(this.f2434g);
        d7.append(" bytes");
        throw new ProtocolException(d7.toString());
    }
}
