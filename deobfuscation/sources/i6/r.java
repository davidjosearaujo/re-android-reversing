package i6;

import java.io.EOFException;

/* loaded from: classes.dex */
public final class r implements f {

    /* renamed from: f */
    public final d f4526f;

    /* renamed from: g */
    public final v f4527g;

    /* renamed from: h */
    public boolean f4528h;

    public r(v vVar) {
        d dVar = new d();
        if (vVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f4526f = dVar;
        this.f4527g = vVar;
    }

    @Override // i6.v
    public final long B(d dVar, long j5) {
        if (dVar != null) {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            } else if (this.f4528h) {
                throw new IllegalStateException("closed");
            } else {
                d dVar2 = this.f4526f;
                if (dVar2.f4498g == 0 && this.f4527g.B(dVar2, 2048L) == -1) {
                    return -1L;
                }
                return this.f4526f.B(dVar, Math.min(j5, this.f4526f.f4498g));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // i6.f
    public final void P(long j5) {
        if (!d(j5)) {
            throw new EOFException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // i6.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long T() {
        /*
            r6 = this;
            r0 = 1
            r6.P(r0)
            r0 = 0
            r1 = r0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.d(r3)
            if (r3 == 0) goto L4a
            i6.d r3 = r6.f4526f
            long r4 = (long) r1
            byte r3 = r3.e(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r6 = new java.lang.NumberFormatException
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Byte r2 = java.lang.Byte.valueOf(r3)
            r1[r0] = r2
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r1)
            r6.<init>(r0)
            throw r6
        L4a:
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

    public final long b(byte b2) {
        d dVar;
        d dVar2;
        if (this.f4528h) {
            throw new IllegalStateException("closed");
        }
        do {
            dVar = this.f4526f;
            long j5 = 0;
            if (0 < dVar.f4498g) {
                do {
                    long f7 = this.f4526f.f(b2, j5);
                    if (f7 != -1) {
                        return f7;
                    }
                    dVar2 = this.f4526f;
                    j5 = dVar2.f4498g;
                } while (this.f4527g.B(dVar2, 2048L) != -1);
                return -1L;
            }
        } while (this.f4527g.B(dVar, 2048L) != -1);
        return -1L;
    }

    @Override // i6.v
    public final w c() {
        return this.f4527g.c();
    }

    @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f4528h) {
            return;
        }
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

    public final boolean d(long j5) {
        d dVar;
        if (j5 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j5);
        } else if (this.f4528h) {
            throw new IllegalStateException("closed");
        } else {
            do {
                dVar = this.f4526f;
                if (dVar.f4498g >= j5) {
                    return true;
                }
            } while (this.f4527g.B(dVar, 2048L) != -1);
            return false;
        }
    }

    @Override // i6.f
    public final g j(long j5) {
        P(j5);
        return this.f4526f.j(j5);
    }

    @Override // i6.f
    public final byte readByte() {
        P(1L);
        return this.f4526f.readByte();
    }

    @Override // i6.f
    public final int readInt() {
        P(4L);
        return this.f4526f.readInt();
    }

    @Override // i6.f
    public final short readShort() {
        P(2L);
        return this.f4526f.readShort();
    }

    @Override // i6.f
    public final void skip(long j5) {
        if (this.f4528h) {
            throw new IllegalStateException("closed");
        }
        while (j5 > 0) {
            d dVar = this.f4526f;
            if (dVar.f4498g == 0 && this.f4527g.B(dVar, 2048L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j5, this.f4526f.f4498g);
            this.f4526f.skip(min);
            j5 -= min;
        }
    }

    @Override // i6.f
    public final String t() {
        long b2 = b((byte) 10);
        if (b2 != -1) {
            return this.f4526f.n(b2);
        }
        d dVar = new d();
        d dVar2 = this.f4526f;
        dVar2.d(dVar, 0L, Math.min(32L, dVar2.f4498g));
        StringBuilder d7 = androidx.activity.h.d("\\n not found: size=");
        d7.append(this.f4526f.f4498g);
        d7.append(" content=");
        d7.append(new g(dVar.u()).c());
        d7.append("...");
        throw new EOFException(d7.toString());
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("buffer(");
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
        if (this.f4528h) {
            throw new IllegalStateException("closed");
        }
        return this.f4526f.x() && this.f4527g.B(this.f4526f, 2048L) == -1;
    }
}
