package i6;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k implements v {

    /* renamed from: g  reason: collision with root package name */
    public final r f4509g;

    /* renamed from: h  reason: collision with root package name */
    public final Inflater f4510h;

    /* renamed from: i  reason: collision with root package name */
    public final l f4511i;

    /* renamed from: f  reason: collision with root package name */
    public int f4508f = 0;

    /* renamed from: j  reason: collision with root package name */
    public final CRC32 f4512j = new CRC32();

    public k(f fVar) {
        if (fVar != null) {
            Inflater inflater = new Inflater(true);
            this.f4510h = inflater;
            r a7 = p.a(fVar);
            this.f4509g = a7;
            this.f4511i = new l(a7, inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    public static void b(int i7, int i8, String str) {
        if (i8 != i7) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i8), Integer.valueOf(i7)));
        }
    }

    @Override // i6.v
    public final long B(d dVar, long j7) {
        long j8;
        int i7 = (j7 > 0 ? 1 : (j7 == 0 ? 0 : -1));
        if (i7 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j7);
        } else if (i7 == 0) {
            return 0;
        } else {
            if (this.f4508f == 0) {
                this.f4509g.P(10);
                byte e = this.f4509g.f4526f.e(3);
                boolean z6 = ((e >> 1) & 1) == 1;
                if (z6) {
                    d(this.f4509g.f4526f, 0, 10);
                }
                b(8075, this.f4509g.readShort(), "ID1ID2");
                this.f4509g.skip(8);
                if (((e >> 2) & 1) == 1) {
                    this.f4509g.P(2);
                    if (z6) {
                        d(this.f4509g.f4526f, 0, 2);
                    }
                    short readShort = this.f4509g.f4526f.readShort();
                    Charset charset = x.f4541a;
                    int i8 = readShort & 65535;
                    long j9 = (long) ((short) (((i8 & 255) << 8) | ((i8 & 65280) >>> 8)));
                    this.f4509g.P(j9);
                    if (z6) {
                        j8 = j9;
                        d(this.f4509g.f4526f, 0, j9);
                    } else {
                        j8 = j9;
                    }
                    this.f4509g.skip(j8);
                }
                if (((e >> 3) & 1) == 1) {
                    long b2 = this.f4509g.b((byte) 0);
                    if (b2 != -1) {
                        if (z6) {
                            d(this.f4509g.f4526f, 0, b2 + 1);
                        }
                        this.f4509g.skip(b2 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (((e >> 4) & 1) == 1) {
                    long b7 = this.f4509g.b((byte) 0);
                    if (b7 != -1) {
                        if (z6) {
                            d(this.f4509g.f4526f, 0, b7 + 1);
                        }
                        this.f4509g.skip(b7 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z6) {
                    r rVar = this.f4509g;
                    rVar.P(2);
                    short readShort2 = rVar.f4526f.readShort();
                    Charset charset2 = x.f4541a;
                    int i9 = readShort2 & 65535;
                    b((short) (((i9 & 255) << 8) | ((i9 & 65280) >>> 8)), (short) ((int) this.f4512j.getValue()), "FHCRC");
                    this.f4512j.reset();
                }
                this.f4508f = 1;
            }
            if (this.f4508f == 1) {
                long j10 = dVar.f4498g;
                long B = this.f4511i.B(dVar, j7);
                if (B != -1) {
                    d(dVar, j10, B);
                    return B;
                }
                this.f4508f = 2;
            }
            if (this.f4508f == 2) {
                r rVar2 = this.f4509g;
                rVar2.P(4);
                int readInt = rVar2.f4526f.readInt();
                Charset charset3 = x.f4541a;
                b(((readInt & 255) << 24) | ((readInt & -16777216) >>> 24) | ((readInt & 16711680) >>> 8) | ((readInt & 65280) << 8), (int) this.f4512j.getValue(), "CRC");
                r rVar3 = this.f4509g;
                rVar3.P(4);
                int readInt2 = rVar3.f4526f.readInt();
                b(((readInt2 & 255) << 24) | ((readInt2 & -16777216) >>> 24) | ((readInt2 & 16711680) >>> 8) | ((readInt2 & 65280) << 8), this.f4510h.getTotalOut(), "ISIZE");
                this.f4508f = 3;
                if (!this.f4509g.x()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
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

    public final void d(d dVar, long j7, long j8) {
        s sVar = dVar.f4497f;
        while (true) {
            int i7 = sVar.f4531c;
            int i8 = sVar.f4530b;
            if (j7 >= ((long) (i7 - i8))) {
                j7 -= (long) (i7 - i8);
                sVar = sVar.f4533f;
            }
        }
        while (j8 > 0) {
            int i9 = (int) (((long) sVar.f4530b) + j7);
            int min = (int) Math.min((long) (sVar.f4531c - i9), j8);
            this.f4512j.update(sVar.f4529a, i9, min);
            j8 -= (long) min;
            sVar = sVar.f4533f;
            j7 = 0;
        }
    }
}
