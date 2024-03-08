package a5;

import a5.b;
import a5.d;
import androidx.fragment.app.s0;
import com.davemorrissey.labs.subscaleview.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import i6.e;
import i6.f;
import i6.g;
import i6.h;
import i6.q;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.zip.Deflater;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class u implements v {

    /* renamed from: a */
    public static final byte[] f271a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements b {

        /* renamed from: f */
        public final f f272f;

        /* renamed from: g */
        public final boolean f273g;

        /* renamed from: h */
        public final q f274h;

        public a(f fVar, boolean z6) {
            this.f272f = fVar;
            this.f274h = new q(fVar);
            this.f273g = z6;
        }

        public static void b(String str, Object... objArr) {
            throw new IOException(String.format(str, objArr));
        }

        @Override // a5.b
        public final boolean S(b.a aVar) {
            a aVar2;
            a aVar3;
            boolean z6 = false;
            try {
                int readInt = this.f272f.readInt();
                int readInt2 = this.f272f.readInt();
                int i7 = (readInt2 & -16777216) >>> 24;
                int i8 = readInt2 & 16777215;
                if ((Integer.MIN_VALUE & readInt) != 0) {
                    int i9 = (2147418112 & readInt) >>> 16;
                    int i10 = readInt & 65535;
                    if (i9 == 3) {
                        switch (i10) {
                            case 1:
                                int readInt3 = this.f272f.readInt();
                                this.f272f.readInt();
                                int i11 = readInt3 & SubsamplingScaleImageView.TILE_SIZE_AUTO;
                                this.f272f.readShort();
                                ((d.e) aVar).d((i7 & 2) != 0, (i7 & 1) != 0, i11, this.f274h.a(i8 - 10), 1);
                                return true;
                            case 2:
                                ((d.e) aVar).d(false, (i7 & 1) != 0, this.f272f.readInt() & SubsamplingScaleImageView.TILE_SIZE_AUTO, this.f274h.a(i8 - 4), 2);
                                return true;
                            case 3:
                                if (i8 == 8) {
                                    int readInt4 = this.f272f.readInt() & SubsamplingScaleImageView.TILE_SIZE_AUTO;
                                    int readInt5 = this.f272f.readInt();
                                    a[] values = a.values();
                                    int length = values.length;
                                    int i12 = 0;
                                    while (true) {
                                        if (i12 < length) {
                                            aVar2 = values[i12];
                                            if (aVar2.f142g != readInt5) {
                                                i12++;
                                            }
                                        } else {
                                            aVar2 = null;
                                        }
                                    }
                                    if (aVar2 != null) {
                                        ((d.e) aVar).f(readInt4, aVar2);
                                        return true;
                                    }
                                    b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt5));
                                    throw null;
                                }
                                b("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i8));
                                throw null;
                            case 4:
                                int readInt6 = this.f272f.readInt();
                                if (i8 == (readInt6 * 8) + 4) {
                                    t tVar = new t();
                                    for (int i13 = 0; i13 < readInt6; i13++) {
                                        int readInt7 = this.f272f.readInt();
                                        tVar.c(readInt7 & 16777215, (readInt7 & -16777216) >>> 24, this.f272f.readInt());
                                    }
                                    if ((i7 & 1) != 0) {
                                        z6 = true;
                                    }
                                    ((d.e) aVar).g(z6, tVar);
                                    return true;
                                }
                                b("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i8), Integer.valueOf(readInt6));
                                throw null;
                            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                            default:
                                this.f272f.skip((long) i8);
                                return true;
                            case 6:
                                if (i8 == 4) {
                                    int readInt8 = this.f272f.readInt();
                                    ((d.e) aVar).e(readInt8, 0, this.f273g == ((readInt8 & 1) == 1));
                                    return true;
                                }
                                b("TYPE_PING length: %d != 4", Integer.valueOf(i8));
                                throw null;
                            case 7:
                                if (i8 == 8) {
                                    int readInt9 = this.f272f.readInt() & SubsamplingScaleImageView.TILE_SIZE_AUTO;
                                    int readInt10 = this.f272f.readInt();
                                    a[] values2 = a.values();
                                    int length2 = values2.length;
                                    int i14 = 0;
                                    while (true) {
                                        if (i14 < length2) {
                                            aVar3 = values2[i14];
                                            if (aVar3.f143h != readInt10) {
                                                i14++;
                                            }
                                        } else {
                                            aVar3 = null;
                                        }
                                    }
                                    if (aVar3 != null) {
                                        ((d.e) aVar).c(readInt9, g.f4500j);
                                        return true;
                                    }
                                    b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt10));
                                    throw null;
                                }
                                b("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i8));
                                throw null;
                            case 8:
                                ((d.e) aVar).d(false, false, this.f272f.readInt() & SubsamplingScaleImageView.TILE_SIZE_AUTO, this.f274h.a(i8 - 4), 3);
                                return true;
                            case 9:
                                if (i8 == 8) {
                                    int readInt11 = this.f272f.readInt();
                                    int readInt12 = this.f272f.readInt();
                                    int i15 = readInt11 & SubsamplingScaleImageView.TILE_SIZE_AUTO;
                                    long j7 = (long) (readInt12 & SubsamplingScaleImageView.TILE_SIZE_AUTO);
                                    if (j7 != 0) {
                                        ((d.e) aVar).h(i15, j7);
                                        return true;
                                    }
                                    b("windowSizeIncrement was 0", Long.valueOf(j7));
                                    throw null;
                                }
                                b("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i8));
                                throw null;
                        }
                    } else {
                        throw new ProtocolException(s0.g("version != 3: ", i9));
                    }
                } else {
                    int i16 = readInt & SubsamplingScaleImageView.TILE_SIZE_AUTO;
                    if ((i7 & 1) != 0) {
                        z6 = true;
                    }
                    ((d.e) aVar).b(i16, i8, this.f272f, z6);
                    return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.f274h.f263c.close();
        }

        @Override // a5.b
        public final void o() {
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b implements c {

        /* renamed from: f */
        public final e f275f;

        /* renamed from: g */
        public final i6.d f276g;

        /* renamed from: h */
        public final q f277h;

        /* renamed from: i */
        public final boolean f278i;

        /* renamed from: j */
        public boolean f279j;

        public b(e eVar, boolean z6) {
            this.f275f = eVar;
            this.f278i = z6;
            Deflater deflater = new Deflater();
            deflater.setDictionary(u.f271a);
            i6.d dVar = new i6.d();
            this.f276g = dVar;
            this.f277h = new q(new h(dVar, deflater));
        }

        @Override // a5.c
        public final synchronized void A(boolean z6, boolean z7, int i7, ArrayList arrayList) {
            if (!this.f279j) {
                d(arrayList);
                int i8 = (int) (this.f276g.f4498g + 10);
                int i9 = (z6 ? 1 : 0) | (z7 ? 2 : 0);
                this.f275f.writeInt(-2147287039);
                this.f275f.writeInt(((i9 & 255) << 24) | (i8 & 16777215));
                this.f275f.writeInt(Integer.MAX_VALUE & i7);
                this.f275f.writeInt(0);
                this.f275f.writeShort(0);
                this.f275f.l(this.f276g);
                this.f275f.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // a5.c
        public final synchronized void H(boolean z6, int i7, i6.d dVar, int i8) {
            b(i7, z6 ? 1 : 0, dVar, i8);
        }

        @Override // a5.c
        public final synchronized void I(int i7, a aVar, byte[] bArr) {
            if (this.f279j) {
                throw new IOException("closed");
            } else if (aVar.f143h != -1) {
                this.f275f.writeInt(-2147287033);
                this.f275f.writeInt(8);
                this.f275f.writeInt(i7);
                this.f275f.writeInt(aVar.f143h);
                this.f275f.flush();
            } else {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            }
        }

        @Override // a5.c
        public final synchronized void L(int i7, long j7) {
            if (this.f279j) {
                throw new IOException("closed");
            } else if (j7 == 0 || j7 > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j7);
            } else {
                this.f275f.writeInt(-2147287031);
                this.f275f.writeInt(8);
                this.f275f.writeInt(i7);
                this.f275f.writeInt((int) j7);
                this.f275f.flush();
            }
        }

        @Override // a5.c
        public final synchronized void M(int i7, int i8, boolean z6) {
            if (!this.f279j) {
                boolean z7 = false;
                if (this.f278i != ((i7 & 1) == 1)) {
                    z7 = true;
                }
                if (z6 == z7) {
                    this.f275f.writeInt(-2147287034);
                    this.f275f.writeInt(4);
                    this.f275f.writeInt(i7);
                    this.f275f.flush();
                } else {
                    throw new IllegalArgumentException("payload != reply");
                }
            } else {
                throw new IOException("closed");
            }
        }

        @Override // a5.c
        public final int O() {
            return 16383;
        }

        public final void b(int i7, int i8, i6.d dVar, int i9) {
            if (!this.f279j) {
                long j7 = (long) i9;
                if (j7 <= 16777215) {
                    this.f275f.writeInt(i7 & SubsamplingScaleImageView.TILE_SIZE_AUTO);
                    this.f275f.writeInt(((i8 & 255) << 24) | (16777215 & i9));
                    if (i9 > 0) {
                        this.f275f.h(dVar, j7);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(s0.g("FRAME_TOO_LARGE max size is 16Mib: ", i9));
            }
            throw new IOException("closed");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final synchronized void close() {
            this.f279j = true;
            z4.h.a(this.f275f, this.f277h);
        }

        public final void d(ArrayList arrayList) {
            this.f277h.writeInt(arrayList.size());
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                g gVar = ((m) arrayList.get(i7)).f220a;
                this.f277h.writeInt(gVar.f4501f.length);
                q qVar = this.f277h;
                if (!qVar.f4525h) {
                    qVar.f4523f.q(gVar);
                    qVar.F();
                    g gVar2 = ((m) arrayList.get(i7)).f221b;
                    this.f277h.writeInt(gVar2.f4501f.length);
                    q qVar2 = this.f277h;
                    if (!qVar2.f4525h) {
                        qVar2.f4523f.q(gVar2);
                        qVar2.F();
                    } else {
                        throw new IllegalStateException("closed");
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
            this.f277h.flush();
        }

        @Override // a5.c
        public final synchronized void flush() {
            if (!this.f279j) {
                this.f275f.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // a5.c
        public final void r(t tVar) {
        }

        @Override // a5.c
        public final synchronized void v(int i7, a aVar) {
            if (this.f279j) {
                throw new IOException("closed");
            } else if (aVar.f142g != -1) {
                this.f275f.writeInt(-2147287037);
                this.f275f.writeInt(8);
                this.f275f.writeInt(i7 & SubsamplingScaleImageView.TILE_SIZE_AUTO);
                this.f275f.writeInt(aVar.f142g);
                this.f275f.flush();
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override // a5.c
        public final synchronized void w(t tVar) {
            if (!this.f279j) {
                int bitCount = Integer.bitCount(tVar.f267a);
                this.f275f.writeInt(-2147287036);
                this.f275f.writeInt((((bitCount * 8) + 4) & 16777215) | 0);
                this.f275f.writeInt(bitCount);
                for (int i7 = 0; i7 <= 10; i7++) {
                    boolean z6 = true;
                    if (((1 << i7) & tVar.f267a) == 0) {
                        z6 = false;
                    }
                    if (z6) {
                        this.f275f.writeInt(((tVar.a(i7) & 255) << 24) | (i7 & 16777215));
                        this.f275f.writeInt(tVar.f270d[i7]);
                    }
                }
                this.f275f.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // a5.c
        public final synchronized void y() {
        }
    }

    static {
        try {
            f271a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(z4.h.f6957c.name());
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }

    @Override // a5.v
    public final c a(e eVar, boolean z6) {
        return new b(eVar, z6);
    }

    @Override // a5.v
    public final b b(f fVar, boolean z6) {
        return new a(fVar, z6);
    }
}
