package i6;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class q implements e {

    /* renamed from: f */
    public final d f4523f = new d();

    /* renamed from: g */
    public final u f4524g;

    /* renamed from: h */
    public boolean f4525h;

    public q(u uVar) {
        this.f4524g = uVar;
    }

    @Override // i6.e
    public final e F() {
        int i7;
        if (this.f4525h) {
            throw new IllegalStateException("closed");
        }
        d dVar = this.f4523f;
        long j5 = dVar.f4498g;
        if (j5 == 0) {
            j5 = 0;
        } else {
            s sVar = dVar.f4497f.f4534g;
            if (sVar.f4531c < 2048 && sVar.e) {
                j5 -= i7 - sVar.f4530b;
            }
        }
        if (j5 > 0) {
            this.f4524g.h(dVar, j5);
        }
        return this;
    }

    @Override // i6.e
    public final e Q(String str) {
        if (this.f4525h) {
            throw new IllegalStateException("closed");
        }
        d dVar = this.f4523f;
        dVar.getClass();
        dVar.G(0, str.length(), str);
        F();
        return this;
    }

    @Override // i6.e
    public final d a() {
        return this.f4523f;
    }

    @Override // i6.u
    public final w c() {
        return this.f4524g.c();
    }

    @Override // i6.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f4525h) {
            return;
        }
        Throwable th = null;
        try {
            d dVar = this.f4523f;
            long j5 = dVar.f4498g;
            if (j5 > 0) {
                this.f4524g.h(dVar, j5);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f4524g.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f4525h = true;
        if (th == null) {
            return;
        }
        Charset charset = x.f4541a;
        throw th;
    }

    @Override // i6.u, java.io.Flushable
    public final void flush() {
        if (this.f4525h) {
            throw new IllegalStateException("closed");
        }
        d dVar = this.f4523f;
        long j5 = dVar.f4498g;
        if (j5 > 0) {
            this.f4524g.h(dVar, j5);
        }
        this.f4524g.flush();
    }

    @Override // i6.e
    public final e g(long j5) {
        if (this.f4525h) {
            throw new IllegalStateException("closed");
        }
        this.f4523f.C(j5);
        F();
        return this;
    }

    @Override // i6.u
    public final void h(d dVar, long j5) {
        if (this.f4525h) {
            throw new IllegalStateException("closed");
        }
        this.f4523f.h(dVar, j5);
        F();
    }

    @Override // i6.e
    public final long l(v vVar) {
        if (vVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j5 = 0;
        while (true) {
            long B = ((d) vVar).B(this.f4523f, 2048L);
            if (B == -1) {
                return j5;
            }
            j5 += B;
            F();
        }
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("buffer(");
        d7.append(this.f4524g);
        d7.append(")");
        return d7.toString();
    }

    @Override // i6.e
    public final e write(byte[] bArr) {
        if (this.f4525h) {
            throw new IllegalStateException("closed");
        }
        d dVar = this.f4523f;
        dVar.getClass();
        dVar.s(bArr, bArr.length);
        F();
        return this;
    }

    @Override // i6.e
    public final e writeByte(int i7) {
        if (this.f4525h) {
            throw new IllegalStateException("closed");
        }
        this.f4523f.z(i7);
        F();
        return this;
    }

    @Override // i6.e
    public final e writeInt(int i7) {
        if (this.f4525h) {
            throw new IllegalStateException("closed");
        }
        this.f4523f.D(i7);
        F();
        return this;
    }

    @Override // i6.e
    public final e writeShort(int i7) {
        if (this.f4525h) {
            throw new IllegalStateException("closed");
        }
        this.f4523f.E(i7);
        F();
        return this;
    }
}
