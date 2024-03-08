package i6;

import java.nio.charset.Charset;
import java.util.logging.Logger;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h implements u {

    /* renamed from: f  reason: collision with root package name */
    public final e f4504f;

    /* renamed from: g  reason: collision with root package name */
    public final Deflater f4505g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4506h;

    public h(d dVar, Deflater deflater) {
        Logger logger = p.f4522a;
        this.f4504f = new q(dVar);
        this.f4505g = deflater;
    }

    @IgnoreJRERequirement
    public final void b(boolean z6) {
        s p6;
        d a7 = this.f4504f.a();
        while (true) {
            p6 = a7.p(1);
            Deflater deflater = this.f4505g;
            byte[] bArr = p6.f4529a;
            int i7 = p6.f4531c;
            int i8 = 2048 - i7;
            int deflate = z6 ? deflater.deflate(bArr, i7, i8, 2) : deflater.deflate(bArr, i7, i8);
            if (deflate > 0) {
                p6.f4531c += deflate;
                a7.f4498g += (long) deflate;
                this.f4504f.F();
            } else if (this.f4505g.needsInput()) {
                break;
            }
        }
        if (p6.f4530b == p6.f4531c) {
            a7.f4497f = p6.a();
            t.a(p6);
        }
    }

    @Override // i6.u
    public final w c() {
        return this.f4504f.c();
    }

    @Override // i6.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (!this.f4506h) {
            Throwable th = null;
            try {
                this.f4505g.finish();
                b(false);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f4505g.end();
            } catch (Throwable th3) {
                th = th3;
                if (th == null) {
                }
            }
            try {
                this.f4504f.close();
            } catch (Throwable th4) {
                th = th4;
                if (th == null) {
                }
            }
            this.f4506h = true;
            if (th != null) {
                Charset charset = x.f4541a;
                throw th;
            }
        }
    }

    @Override // i6.u, java.io.Flushable
    public final void flush() {
        b(true);
        this.f4504f.flush();
    }

    @Override // i6.u
    public final void h(d dVar, long j7) {
        x.a(dVar.f4498g, 0, j7);
        while (j7 > 0) {
            s sVar = dVar.f4497f;
            int min = (int) Math.min(j7, (long) (sVar.f4531c - sVar.f4530b));
            this.f4505g.setInput(sVar.f4529a, sVar.f4530b, min);
            b(false);
            long j8 = (long) min;
            dVar.f4498g -= j8;
            int i7 = sVar.f4530b + min;
            sVar.f4530b = i7;
            if (i7 == sVar.f4531c) {
                dVar.f4497f = sVar.a();
                t.a(sVar);
            }
            j7 -= j8;
        }
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("DeflaterSink(");
        d7.append(this.f4504f);
        d7.append(")");
        return d7.toString();
    }
}
