package i6;

import androidx.activity.h;
import java.nio.charset.Charset;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class q implements e {

    /* renamed from: f  reason: collision with root package name */
    public final d f4523f = new d();

    /* renamed from: g  reason: collision with root package name */
    public final u f4524g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4525h;

    public q(u uVar) {
        this.f4524g = uVar;
    }

    @Override // i6.e
    public final e F() {
        if (!this.f4525h) {
            d dVar = this.f4523f;
            long j7 = dVar.f4498g;
            if (j7 == 0) {
                j7 = 0;
            } else {
                s sVar = dVar.f4497f.f4534g;
                int i7 = sVar.f4531c;
                if (i7 < 2048 && sVar.e) {
                    j7 -= (long) (i7 - sVar.f4530b);
                }
            }
            if (j7 > 0) {
                this.f4524g.h(dVar, j7);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // i6.e
    public final e Q(String str) {
        if (!this.f4525h) {
            d dVar = this.f4523f;
            dVar.getClass();
            dVar.G(0, str.length(), str);
            F();
            return this;
        }
        throw new IllegalStateException("closed");
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
        if (!this.f4525h) {
            Throwable th = null;
            try {
                d dVar = this.f4523f;
                long j7 = dVar.f4498g;
                if (j7 > 0) {
                    this.f4524g.h(dVar, j7);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f4524g.close();
            } catch (Throwable th3) {
                th = th3;
                if (th == null) {
                }
            }
            this.f4525h = true;
            if (th != null) {
                Charset charset = x.f4541a;
                throw th;
            }
        }
    }

    @Override // i6.u, java.io.Flushable
    public final void flush() {
        if (!this.f4525h) {
            d dVar = this.f4523f;
            long j7 = dVar.f4498g;
            if (j7 > 0) {
                this.f4524g.h(dVar, j7);
            }
            this.f4524g.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // i6.e
    public final e g(long j7) {
        if (!this.f4525h) {
            this.f4523f.C(j7);
            F();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // i6.u
    public final void h(d dVar, long j7) {
        if (!this.f4525h) {
            this.f4523f.h(dVar, j7);
            F();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // i6.e
    public final long l(v vVar) {
        if (vVar != null) {
            long j7 = 0;
            while (true) {
                long B = ((d) vVar).B(this.f4523f, 2048);
                if (B == -1) {
                    return j7;
                }
                j7 += B;
                F();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder d7 = h.d("buffer(");
        d7.append(this.f4524g);
        d7.append(")");
        return d7.toString();
    }

    @Override // i6.e
    public final e write(byte[] bArr) {
        if (!this.f4525h) {
            d dVar = this.f4523f;
            dVar.getClass();
            dVar.s(bArr, bArr.length);
            F();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // i6.e
    public final e writeByte(int i7) {
        if (!this.f4525h) {
            this.f4523f.z(i7);
            F();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // i6.e
    public final e writeInt(int i7) {
        if (!this.f4525h) {
            this.f4523f.D(i7);
            F();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // i6.e
    public final e writeShort(int i7) {
        if (!this.f4525h) {
            this.f4523f.E(i7);
            F();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
