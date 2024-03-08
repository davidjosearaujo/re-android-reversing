package i6;

import androidx.activity.h;
import java.io.EOFException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class r implements f {

    /* renamed from: f  reason: collision with root package name */
    public final d f4526f;

    /* renamed from: g  reason: collision with root package name */
    public final v f4527g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4528h;

    public r(v vVar) {
        d dVar = new d();
        if (vVar != null) {
            this.f4526f = dVar;
            this.f4527g = vVar;
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // i6.v
    public final long B(d dVar, long j7) {
        if (dVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j7 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j7);
        } else if (!this.f4528h) {
            d dVar2 = this.f4526f;
            if (dVar2.f4498g == 0 && this.f4527g.B(dVar2, 2048) == -1) {
                return -1;
            }
            return this.f4526f.B(dVar, Math.min(j7, this.f4526f.f4498g));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    @Override // i6.f
    public final void P(long j7) {
        if (!d(j7)) {
            throw new EOFException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        if (r1 == 0) goto L_0x0035;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // i6.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long T() {
        /*
            r6 = this;
            r0 = 1
            r6.P(r0)
            r0 = 0
            r1 = r0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.d(r3)
            if (r3 == 0) goto L_0x004a
            i6.d r3 = r6.f4526f
            long r4 = (long) r1
            byte r3 = r3.e(r4)
            r4 = 48
            if (r3 < r4) goto L_0x001f
            r4 = 57
            if (r3 <= r4) goto L_0x0030
        L_0x001f:
            r4 = 97
            if (r3 < r4) goto L_0x0027
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L_0x0030
        L_0x0027:
            r4 = 65
            if (r3 < r4) goto L_0x0032
            r4 = 70
            if (r3 <= r4) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r1 = r2
            goto L_0x0007
        L_0x0032:
            if (r1 == 0) goto L_0x0035
            goto L_0x004a
        L_0x0035:
            java.lang.NumberFormatException r6 = new java.lang.NumberFormatException
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Byte r2 = java.lang.Byte.valueOf(r3)
            r1[r0] = r2
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r1)
            r6.<init>(r0)
            throw r6
        L_0x004a:
            i6.d r6 = r6.f4526f
            long r0 = r6.T()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.r.T():long");
    }

    @Override // i6.f, i6.e
    public final d a() {
        return this.f4526f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        r0 = r9.f4526f;
        r3 = r0.f4498g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
        if (r9.f4527g.B(r0, 2048) != -1) goto L_0x001d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
        r0 = r9.f4526f.f(r10, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
        if (r0 != -1) goto L_0x0036;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long b(byte r10) {
        /*
            r9 = this;
            boolean r0 = r9.f4528h
            if (r0 != 0) goto L_0x0038
        L_0x0004:
            i6.d r0 = r9.f4526f
            long r1 = r0.f4498g
            r3 = 0
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            r5 = 2048(0x800, double:1.0118E-320)
            r7 = -1
            if (r1 < 0) goto L_0x001d
            i6.v r1 = r9.f4527g
            long r0 = r1.B(r0, r5)
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0004
            goto L_0x0037
        L_0x001d:
            i6.d r0 = r9.f4526f
            long r0 = r0.f(r10, r3)
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x0036
            i6.d r0 = r9.f4526f
            long r3 = r0.f4498g
            i6.v r1 = r9.f4527g
            long r0 = r1.B(r0, r5)
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x001d
            goto L_0x0037
        L_0x0036:
            r7 = r0
        L_0x0037:
            return r7
        L_0x0038:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.r.b(byte):long");
    }

    @Override // i6.v
    public final w c() {
        return this.f4527g.c();
    }

    @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (!this.f4528h) {
            this.f4528h = true;
            this.f4527g.close();
            d dVar = this.f4526f;
            dVar.getClass();
            try {
                dVar.skip(dVar.f4498g);
            } catch (EOFException e) {
                throw new AssertionError(e);
            }
        }
    }

    public final boolean d(long j7) {
        d dVar;
        if (j7 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j7);
        } else if (!this.f4528h) {
            do {
                dVar = this.f4526f;
                if (dVar.f4498g >= j7) {
                    return true;
                }
            } while (this.f4527g.B(dVar, 2048) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    @Override // i6.f
    public final g j(long j7) {
        P(j7);
        return this.f4526f.j(j7);
    }

    @Override // i6.f
    public final byte readByte() {
        P(1);
        return this.f4526f.readByte();
    }

    @Override // i6.f
    public final int readInt() {
        P(4);
        return this.f4526f.readInt();
    }

    @Override // i6.f
    public final short readShort() {
        P(2);
        return this.f4526f.readShort();
    }

    @Override // i6.f
    public final void skip(long j7) {
        if (!this.f4528h) {
            while (j7 > 0) {
                d dVar = this.f4526f;
                if (dVar.f4498g == 0 && this.f4527g.B(dVar, 2048) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j7, this.f4526f.f4498g);
                this.f4526f.skip(min);
                j7 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // i6.f
    public final String t() {
        long b2 = b((byte) 10);
        if (b2 != -1) {
            return this.f4526f.n(b2);
        }
        d dVar = new d();
        d dVar2 = this.f4526f;
        dVar2.d(dVar, 0, Math.min(32L, dVar2.f4498g));
        StringBuilder d7 = h.d("\\n not found: size=");
        d7.append(this.f4526f.f4498g);
        d7.append(" content=");
        d7.append(new g(dVar.u()).c());
        d7.append("...");
        throw new EOFException(d7.toString());
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder d7 = h.d("buffer(");
        d7.append(this.f4527g);
        d7.append(")");
        return d7.toString();
    }

    @Override // i6.f
    public final byte[] u() {
        this.f4526f.l(this.f4527g);
        return this.f4526f.u();
    }

    @Override // i6.f
    public final boolean x() {
        if (!this.f4528h) {
            return this.f4526f.x() && this.f4527g.B(this.f4526f, 2048) == -1;
        }
        throw new IllegalStateException("closed");
    }
}
