package i6;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class k implements v {

    /* renamed from: g */
    public final r f4509g;

    /* renamed from: h */
    public final Inflater f4510h;

    /* renamed from: i */
    public final l f4511i;

    /* renamed from: f */
    public int f4508f = 0;

    /* renamed from: j */
    public final CRC32 f4512j = new CRC32();

    public k(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.f4510h = inflater;
        r a7 = p.a(fVar);
        this.f4509g = a7;
        this.f4511i = new l(a7, inflater);
    }

    public static void b(int i7, int i8, String str) {
        if (i8 != i7) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i8), Integer.valueOf(i7)));
        }
    }

    @Override // i6.v
    public final long B(d dVar, long j5) {
        long j7;
        int i7 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1));
        if (i7 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j5);
        } else if (i7 == 0) {
            return 0L;
        } else {
            if (this.f4508f == 0) {
                this.f4509g.P(10L);
                byte e = this.f4509g.f4526f.e(3L);
                boolean z6 = ((e >> 1) & 1) == 1;
                if (z6) {
                    d(this.f4509g.f4526f, 0L, 10L);
                }
                b(8075, this.f4509g.readShort(), "ID1ID2");
                this.f4509g.skip(8L);
                if (((e >> 2) & 1) == 1) {
                    this.f4509g.P(2L);
                    if (z6) {
                        d(this.f4509g.f4526f, 0L, 2L);
                    }
                    short readShort = this.f4509g.f4526f.readShort();
                    Charset charset = x.f4541a;
                    int i8 = readShort & 65535;
                    long j8 = (short) (((i8 & 255) << 8) | ((i8 & 65280) >>> 8));
                    this.f4509g.P(j8);
                    if (z6) {
                        j7 = j8;
                        d(this.f4509g.f4526f, 0L, j8);
                    } else {
                        j7 = j8;
                    }
                    this.f4509g.skip(j7);
                }
                if (((e >> 3) & 1) == 1) {
                    long b2 = this.f4509g.b((byte) 0);
                    if (b2 == -1) {
                        throw new EOFException();
                    }
                    if (z6) {
                        d(this.f4509g.f4526f, 0L, b2 + 1);
                    }
                    this.f4509g.skip(b2 + 1);
                }
                if (((e >> 4) & 1) == 1) {
                    long b7 = this.f4509g.b((byte) 0);
                    if (b7 == -1) {
                        throw new EOFException();
                    }
                    if (z6) {
                        d(this.f4509g.f4526f, 0L, b7 + 1);
                    }
                    this.f4509g.skip(b7 + 1);
                }
                if (z6) {
                    r rVar = this.f4509g;
                    rVar.P(2L);
                    short readShort2 = rVar.f4526f.readShort();
                    Charset charset2 = x.f4541a;
                    int i9 = readShort2 & 65535;
                    b((short) (((i9 & 255) << 8) | ((i9 & 65280) >>> 8)), (short) this.f4512j.getValue(), "FHCRC");
                    this.f4512j.reset();
                }
                this.f4508f = 1;
            }
            if (this.f4508f == 1) {
                long j9 = dVar.f4498g;
                long B = this.f4511i.B(dVar, j5);
                if (B != -1) {
                    d(dVar, j9, B);
                    return B;
                }
                this.f4508f = 2;
            }
            if (this.f4508f == 2) {
                r rVar2 = this.f4509g;
                rVar2.P(4L);
                int readInt = rVar2.f4526f.readInt();
                Charset charset3 = x.f4541a;
                b(((readInt & 255) << 24) | ((readInt & (-16777216)) >>> 24) | ((readInt & 16711680) >>> 8) | ((readInt & 65280) << 8), (int) this.f4512j.getValue(), "CRC");
                r rVar3 = this.f4509g;
                rVar3.P(4L);
                int readInt2 = rVar3.f4526f.readInt();
                b(((readInt2 & 255) << 24) | ((readInt2 & (-16777216)) >>> 24) | ((readInt2 & 16711680) >>> 8) | ((readInt2 & 65280) << 8), this.f4510h.getTotalOut(), "ISIZE");
                this.f4508f = 3;
                if (!this.f4509g.x()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // i6.v
    public final w c() {
        return this.f4509g.c();
    }

    @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f4511i.close();
    }

    public final void d(d dVar, long j5, long j7) {
        int i7;
        s sVar = dVar.f4497f;
        while (true) {
            int i8 = sVar.f4531c;
            int i9 = sVar.f4530b;
            if (j5 < i8 - i9) {
                break;
            }
            j5 -= i8 - i9;
            sVar = sVar.f4533f;
        }
        while (j7 > 0) {
            int min = (int) Math.min(sVar.f4531c - i7, j7);
            this.f4512j.update(sVar.f4529a, (int) (sVar.f4530b + j5), min);
            j7 -= min;
            sVar = sVar.f4533f;
            j5 = 0;
        }
    }
}
