package i6;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l implements v {

    /* renamed from: f  reason: collision with root package name */
    public final f f4513f;

    /* renamed from: g  reason: collision with root package name */
    public final Inflater f4514g;

    /* renamed from: h  reason: collision with root package name */
    public int f4515h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4516i;

    public l(r rVar, Inflater inflater) {
        this.f4513f = rVar;
        this.f4514g = inflater;
    }

    @Override // i6.v
    public final long B(d dVar, long j7) {
        s p6;
        int i7 = (j7 > 0 ? 1 : (j7 == 0 ? 0 : -1));
        if (i7 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j7);
        } else if (this.f4516i) {
            throw new IllegalStateException("closed");
        } else if (i7 == 0) {
            return 0;
        } else {
            while (true) {
                boolean b2 = b();
                try {
                    p6 = dVar.p(1);
                    Inflater inflater = this.f4514g;
                    byte[] bArr = p6.f4529a;
                    int i8 = p6.f4531c;
                    int inflate = inflater.inflate(bArr, i8, 2048 - i8);
                    if (inflate <= 0) {
                        if (this.f4514g.finished() || this.f4514g.needsDictionary()) {
                            break;
                        } else if (b2) {
                            throw new EOFException("source exhausted prematurely");
                        }
                    } else {
                        p6.f4531c += inflate;
                        long j8 = (long) inflate;
                        dVar.f4498g += j8;
                        return j8;
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            int i9 = this.f4515h;
            if (i9 != 0) {
                int remaining = i9 - this.f4514g.getRemaining();
                this.f4515h -= remaining;
                this.f4513f.skip((long) remaining);
            }
            if (p6.f4530b != p6.f4531c) {
                return -1;
            }
            dVar.f4497f = p6.a();
            t.a(p6);
            return -1;
        }
    }

    public final boolean b() {
        if (!this.f4514g.needsInput()) {
            return false;
        }
        int i7 = this.f4515h;
        if (i7 != 0) {
            int remaining = i7 - this.f4514g.getRemaining();
            this.f4515h -= remaining;
            this.f4513f.skip((long) remaining);
        }
        if (this.f4514g.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f4513f.x()) {
            return true;
        } else {
            s sVar = this.f4513f.a().f4497f;
            int i8 = sVar.f4531c;
            int i9 = sVar.f4530b;
            int i10 = i8 - i9;
            this.f4515h = i10;
            this.f4514g.setInput(sVar.f4529a, i9, i10);
            return false;
        }
    }

    @Override // i6.v
    public final w c() {
        return this.f4513f.c();
    }

    @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (!this.f4516i) {
            this.f4514g.end();
            this.f4516i = true;
            this.f4513f.close();
        }
    }
}
