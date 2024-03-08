package a5;

import a5.b;
import a5.d;
import a5.n;
import androidx.activity.h;
import com.davemorrissey.labs.subscaleview.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import i6.e;
import i6.f;
import i6.g;
import i6.v;
import i6.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o implements v {

    /* renamed from: a */
    public static final Logger f233a = Logger.getLogger(b.class.getName());

    /* renamed from: b */
    public static final g f234b = g.b("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements v {

        /* renamed from: f */
        public final f f235f;

        /* renamed from: g */
        public int f236g;

        /* renamed from: h */
        public byte f237h;

        /* renamed from: i */
        public int f238i;

        /* renamed from: j */
        public int f239j;

        /* renamed from: k */
        public short f240k;

        public a(f fVar) {
            this.f235f = fVar;
        }

        @Override // i6.v
        public final long B(i6.d dVar, long j7) {
            int i7;
            int readInt;
            do {
                int i8 = this.f239j;
                if (i8 == 0) {
                    this.f235f.skip((long) this.f240k);
                    this.f240k = 0;
                    if ((this.f237h & 4) != 0) {
                        return -1;
                    }
                    i7 = this.f238i;
                    f fVar = this.f235f;
                    Logger logger = o.f233a;
                    int readByte = (fVar.readByte() & 255) | ((fVar.readByte() & 255) << 16) | ((fVar.readByte() & 255) << 8);
                    this.f239j = readByte;
                    this.f236g = readByte;
                    byte readByte2 = (byte) (this.f235f.readByte() & 255);
                    this.f237h = (byte) (this.f235f.readByte() & 255);
                    Logger logger2 = o.f233a;
                    if (logger2.isLoggable(Level.FINE)) {
                        logger2.fine(b.a(true, this.f238i, this.f236g, readByte2, this.f237h));
                    }
                    readInt = this.f235f.readInt() & SubsamplingScaleImageView.TILE_SIZE_AUTO;
                    this.f238i = readInt;
                    if (readByte2 != 9) {
                        o.d("%s != TYPE_CONTINUATION", Byte.valueOf(readByte2));
                        throw null;
                    }
                } else {
                    long B = this.f235f.B(dVar, Math.min(j7, (long) i8));
                    if (B == -1) {
                        return -1;
                    }
                    this.f239j = (int) (((long) this.f239j) - B);
                    return B;
                }
            } while (readInt == i7);
            o.d("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        }

        @Override // i6.v
        public final w c() {
            return this.f235f.c();
        }

        @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b {

        /* renamed from: a */
        public static final String[] f241a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* renamed from: b */
        public static final String[] f242b = new String[64];

        /* renamed from: c */
        public static final String[] f243c = new String[256];

        static {
            int i7 = 0;
            int i8 = 0;
            while (true) {
                String[] strArr = f243c;
                if (i8 >= strArr.length) {
                    break;
                }
                strArr[i8] = String.format("%8s", Integer.toBinaryString(i8)).replace(' ', '0');
                i8++;
            }
            String[] strArr2 = f242b;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            for (int i9 = 0; i9 < 1; i9++) {
                int i10 = iArr[i9];
                String[] strArr3 = f242b;
                strArr3[i10 | 8] = h.c(new StringBuilder(), strArr3[i10], "|PADDED");
            }
            String[] strArr4 = f242b;
            strArr4[4] = "END_HEADERS";
            strArr4[32] = "PRIORITY";
            strArr4[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr2[i11];
                for (int i13 = 0; i13 < 1; i13++) {
                    int i14 = iArr[i13];
                    String[] strArr5 = f242b;
                    int i15 = i14 | i12;
                    strArr5[i15] = strArr5[i14] + '|' + strArr5[i12];
                    StringBuilder sb = new StringBuilder();
                    sb.append(strArr5[i14]);
                    sb.append('|');
                    strArr5[i15 | 8] = h.c(sb, strArr5[i12], "|PADDED");
                }
            }
            while (true) {
                String[] strArr6 = f242b;
                if (i7 < strArr6.length) {
                    if (strArr6[i7] == null) {
                        strArr6[i7] = f243c[i7];
                    }
                    i7++;
                } else {
                    return;
                }
            }
        }

        public static String a(boolean z6, int i7, int i8, byte b2, byte b7) {
            String str;
            String str2;
            String str3;
            String format = b2 < 10 ? f241a[b2] : String.format("0x%02x", Byte.valueOf(b2));
            if (b7 == 0) {
                str = "";
            } else {
                if (!(b2 == 2 || b2 == 3)) {
                    if (b2 == 4 || b2 == 6) {
                        str = b7 == 1 ? "ACK" : f243c[b7];
                    } else if (!(b2 == 7 || b2 == 8)) {
                        String str4 = b7 < 64 ? f242b[b7] : f243c[b7];
                        if (b2 == 5 && (b7 & 4) != 0) {
                            str2 = "HEADERS";
                            str3 = "PUSH_PROMISE";
                        } else if (b2 != 0 || (b7 & 32) == 0) {
                            str = str4;
                        } else {
                            str2 = "PRIORITY";
                            str3 = "COMPRESSED";
                        }
                        str = str4.replace(str2, str3);
                    }
                }
                str = f243c[b7];
            }
            Object[] objArr = new Object[5];
            objArr[0] = z6 ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i7);
            objArr[2] = Integer.valueOf(i8);
            objArr[3] = format;
            objArr[4] = str;
            return String.format("%s 0x%08x %5d %-13s %s", objArr);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c implements b {

        /* renamed from: f */
        public final f f244f;

        /* renamed from: g */
        public final a f245g;

        /* renamed from: h */
        public final boolean f246h;

        /* renamed from: i */
        public final n.a f247i;

        public c(f fVar, boolean z6) {
            this.f244f = fVar;
            this.f246h = z6;
            a aVar = new a(fVar);
            this.f245g = aVar;
            this.f247i = new n.a(aVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // a5.b
        public final boolean S(b.a aVar) {
            a aVar2;
            a aVar3;
            short s = 0;
            boolean z6 = false;
            short s6 = 0;
            try {
                this.f244f.P(9);
                f fVar = this.f244f;
                int readByte = (fVar.readByte() & 255) | ((fVar.readByte() & 255) << 16) | ((fVar.readByte() & 255) << 8);
                if (readByte < 0 || readByte > 16384) {
                    o.d("FRAME_SIZE_ERROR: %s", Integer.valueOf(readByte));
                    throw null;
                }
                byte readByte2 = (byte) (this.f244f.readByte() & 255);
                byte readByte3 = (byte) (this.f244f.readByte() & 255);
                int readInt = this.f244f.readInt() & SubsamplingScaleImageView.TILE_SIZE_AUTO;
                Logger logger = o.f233a;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(b.a(true, readInt, readByte, readByte2, readByte3));
                }
                switch (readByte2) {
                    case 0:
                        boolean z7 = (readByte3 & 1) != 0;
                        if (((readByte3 & 32) != 0 ? 1 : null) == null) {
                            if ((readByte3 & 8) != 0) {
                                s = (short) (this.f244f.readByte() & 255);
                            }
                            ((d.e) aVar).b(readInt, o.c(readByte, readByte3, s), this.f244f, z7);
                            this.f244f.skip((long) s);
                            break;
                        } else {
                            o.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
                            throw null;
                        }
                    case 1:
                        if (readInt != 0) {
                            boolean z8 = (readByte3 & 1) != 0;
                            if ((readByte3 & 8) != 0) {
                                s6 = (short) (this.f244f.readByte() & 255);
                            }
                            if ((readByte3 & 32) != 0) {
                                this.f244f.readInt();
                                this.f244f.readByte();
                                aVar.getClass();
                                readByte -= 5;
                            }
                            ((d.e) aVar).d(false, z8, readInt, b(o.c(readByte, readByte3, s6), s6, readByte3, readInt), 4);
                            break;
                        } else {
                            o.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
                            throw null;
                        }
                    case 2:
                        if (readByte != 5) {
                            o.d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(readByte));
                            throw null;
                        } else if (readInt != 0) {
                            this.f244f.readInt();
                            this.f244f.readByte();
                            aVar.getClass();
                            break;
                        } else {
                            o.d("TYPE_PRIORITY streamId == 0", new Object[0]);
                            throw null;
                        }
                    case 3:
                        if (readByte != 4) {
                            o.d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(readByte));
                            throw null;
                        } else if (readInt != 0) {
                            int readInt2 = this.f244f.readInt();
                            a[] values = a.values();
                            int length = values.length;
                            int i7 = 0;
                            while (true) {
                                if (i7 < length) {
                                    aVar2 = values[i7];
                                    if (aVar2.f141f != readInt2) {
                                        i7++;
                                    }
                                } else {
                                    aVar2 = null;
                                }
                            }
                            if (aVar2 != null) {
                                ((d.e) aVar).f(readInt, aVar2);
                                break;
                            } else {
                                o.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt2));
                                throw null;
                            }
                        } else {
                            o.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
                            throw null;
                        }
                    case 4:
                        if (readInt != 0) {
                            o.d("TYPE_SETTINGS streamId != 0", new Object[0]);
                            throw null;
                        } else if ((readByte3 & 1) != 0) {
                            if (readByte == 0) {
                                aVar.getClass();
                                break;
                            } else {
                                o.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                                throw null;
                            }
                        } else if (readByte % 6 == 0) {
                            t tVar = new t();
                            for (int i8 = 0; i8 < readByte; i8 += 6) {
                                short readShort = this.f244f.readShort();
                                int readInt3 = this.f244f.readInt();
                                switch (readShort) {
                                    case 1:
                                    case 6:
                                        break;
                                    case 2:
                                        if (!(readInt3 == 0 || readInt3 == 1)) {
                                            o.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                            throw null;
                                        }
                                        break;
                                    case 3:
                                        readShort = 4;
                                        break;
                                    case 4:
                                        readShort = 7;
                                        if (readInt3 >= 0) {
                                            break;
                                        } else {
                                            o.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                            throw null;
                                        }
                                    case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                                        if (readInt3 >= 16384 && readInt3 <= 16777215) {
                                            break;
                                        } else {
                                            o.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt3));
                                            throw null;
                                        }
                                        break;
                                    default:
                                        o.d("PROTOCOL_ERROR invalid settings id: %s", Short.valueOf(readShort));
                                        throw null;
                                }
                                tVar.c(readShort, 0, readInt3);
                            }
                            ((d.e) aVar).g(false, tVar);
                            int i9 = tVar.f267a;
                            if (((i9 & 2) != 0 ? tVar.f270d[1] : -1) >= 0) {
                                n.a aVar4 = this.f247i;
                                int i10 = (i9 & 2) != 0 ? tVar.f270d[1] : -1;
                                aVar4.f227c = i10;
                                aVar4.f228d = i10;
                                int i11 = aVar4.f231h;
                                if (i10 < i11) {
                                    if (i10 == 0) {
                                        aVar4.f225a.clear();
                                        Arrays.fill(aVar4.e, (Object) null);
                                        aVar4.f229f = aVar4.e.length - 1;
                                        aVar4.f230g = 0;
                                        aVar4.f231h = 0;
                                        break;
                                    } else {
                                        aVar4.a(i11 - i10);
                                        break;
                                    }
                                }
                            }
                        } else {
                            o.d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(readByte));
                            throw null;
                        }
                        break;
                    case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                        if (readInt != 0) {
                            short readByte4 = (readByte3 & 8) != 0 ? (short) (this.f244f.readByte() & 255) : 0;
                            int readInt4 = this.f244f.readInt() & SubsamplingScaleImageView.TILE_SIZE_AUTO;
                            ArrayList b2 = b(o.c(readByte - 4, readByte3, readByte4), readByte4, readByte3, readInt);
                            d dVar = d.this;
                            synchronized (dVar) {
                                if (dVar.f161x.contains(Integer.valueOf(readInt4))) {
                                    dVar.k(readInt4, a.PROTOCOL_ERROR);
                                } else {
                                    dVar.f161x.add(Integer.valueOf(readInt4));
                                    dVar.f152n.execute(new f(dVar, new Object[]{dVar.f149j, Integer.valueOf(readInt4)}, readInt4, b2));
                                }
                            }
                            break;
                        } else {
                            o.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
                            throw null;
                        }
                    case 6:
                        if (readByte != 8) {
                            o.d("TYPE_PING length != 8: %s", Integer.valueOf(readByte));
                            throw null;
                        } else if (readInt == 0) {
                            int readInt5 = this.f244f.readInt();
                            int readInt6 = this.f244f.readInt();
                            if ((readByte3 & 1) != 0) {
                                z6 = true;
                            }
                            ((d.e) aVar).e(readInt5, readInt6, z6);
                            break;
                        } else {
                            o.d("TYPE_PING streamId != 0", new Object[0]);
                            throw null;
                        }
                    case 7:
                        if (readByte < 8) {
                            o.d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(readByte));
                            throw null;
                        } else if (readInt == 0) {
                            int readInt7 = this.f244f.readInt();
                            int readInt8 = this.f244f.readInt();
                            int i12 = readByte - 8;
                            a[] values2 = a.values();
                            int length2 = values2.length;
                            int i13 = 0;
                            while (true) {
                                if (i13 < length2) {
                                    aVar3 = values2[i13];
                                    if (aVar3.f141f != readInt8) {
                                        i13++;
                                    }
                                } else {
                                    aVar3 = null;
                                }
                            }
                            if (aVar3 != null) {
                                g gVar = g.f4500j;
                                if (i12 > 0) {
                                    gVar = this.f244f.j((long) i12);
                                }
                                ((d.e) aVar).c(readInt7, gVar);
                                break;
                            } else {
                                o.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt8));
                                throw null;
                            }
                        } else {
                            o.d("TYPE_GOAWAY streamId != 0", new Object[0]);
                            throw null;
                        }
                    case 8:
                        if (readByte == 4) {
                            long readInt9 = ((long) this.f244f.readInt()) & 2147483647L;
                            if (readInt9 != 0) {
                                ((d.e) aVar).h(readInt, readInt9);
                                break;
                            } else {
                                o.d("windowSizeIncrement was 0", Long.valueOf(readInt9));
                                throw null;
                            }
                        } else {
                            o.d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(readByte));
                            throw null;
                        }
                    default:
                        this.f244f.skip((long) readByte);
                        break;
                }
                return true;
            } catch (IOException unused) {
                return false;
            }
        }

        public final ArrayList b(int i7, short s, byte b2, int i8) {
            ArrayList arrayList;
            m mVar;
            m mVar2;
            m mVar3;
            a aVar = this.f245g;
            aVar.f239j = i7;
            aVar.f236g = i7;
            aVar.f240k = s;
            aVar.f237h = b2;
            aVar.f238i = i8;
            n.a aVar2 = this.f247i;
            while (!aVar2.f226b.x()) {
                int readByte = aVar2.f226b.readByte() & 255;
                if (readByte != 128) {
                    boolean z6 = false;
                    if ((readByte & 128) == 128) {
                        int d7 = aVar2.d(readByte, 127) - 1;
                        if (d7 >= 0 && d7 <= n.f223a.length - 1) {
                            z6 = true;
                        }
                        if (z6) {
                            mVar = n.f223a[d7];
                            arrayList = aVar2.f225a;
                        } else {
                            int length = aVar2.f229f + 1 + (d7 - n.f223a.length);
                            if (length >= 0) {
                                m[] mVarArr = aVar2.e;
                                if (length <= mVarArr.length - 1) {
                                    arrayList = aVar2.f225a;
                                    mVar = mVarArr[length];
                                }
                            }
                            StringBuilder d8 = h.d("Header index too large ");
                            d8.append(d7 + 1);
                            throw new IOException(d8.toString());
                        }
                        arrayList.add(mVar);
                    } else if (readByte == 64) {
                        g c7 = aVar2.c();
                        n.a(c7);
                        aVar2.b(new m(c7, aVar2.c()));
                    } else if ((readByte & 64) == 64) {
                        int d9 = aVar2.d(readByte, 63) - 1;
                        if (d9 >= 0 && d9 <= n.f223a.length - 1) {
                            z6 = true;
                        }
                        if (z6) {
                            mVar2 = n.f223a[d9];
                        } else {
                            mVar2 = aVar2.e[aVar2.f229f + 1 + (d9 - n.f223a.length)];
                        }
                        aVar2.b(new m(mVar2.f220a, aVar2.c()));
                    } else if ((readByte & 32) == 32) {
                        int d10 = aVar2.d(readByte, 31);
                        aVar2.f228d = d10;
                        if (d10 < 0 || d10 > aVar2.f227c) {
                            StringBuilder d11 = h.d("Invalid dynamic table size update ");
                            d11.append(aVar2.f228d);
                            throw new IOException(d11.toString());
                        }
                        int i9 = aVar2.f231h;
                        if (d10 < i9) {
                            if (d10 == 0) {
                                aVar2.f225a.clear();
                                Arrays.fill(aVar2.e, (Object) null);
                                aVar2.f229f = aVar2.e.length - 1;
                                aVar2.f230g = 0;
                                aVar2.f231h = 0;
                            } else {
                                aVar2.a(i9 - d10);
                            }
                        }
                    } else if (readByte == 16 || readByte == 0) {
                        g c8 = aVar2.c();
                        n.a(c8);
                        aVar2.f225a.add(new m(c8, aVar2.c()));
                    } else {
                        int d12 = aVar2.d(readByte, 15) - 1;
                        if (d12 >= 0 && d12 <= n.f223a.length - 1) {
                            z6 = true;
                        }
                        if (z6) {
                            mVar3 = n.f223a[d12];
                        } else {
                            mVar3 = aVar2.e[aVar2.f229f + 1 + (d12 - n.f223a.length)];
                        }
                        aVar2.f225a.add(new m(mVar3.f220a, aVar2.c()));
                    }
                } else {
                    throw new IOException("index == 0");
                }
            }
            n.a aVar3 = this.f247i;
            aVar3.getClass();
            ArrayList arrayList2 = new ArrayList(aVar3.f225a);
            aVar3.f225a.clear();
            return arrayList2;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.f244f.close();
        }

        @Override // a5.b
        public final void o() {
            if (!this.f246h) {
                f fVar = this.f244f;
                g gVar = o.f234b;
                g j7 = fVar.j((long) gVar.f4501f.length);
                Logger logger = o.f233a;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(String.format("<< CONNECTION %s", j7.c()));
                }
                if (!gVar.equals(j7)) {
                    o.d("Expected a connection header but was %s", j7.f());
                    throw null;
                }
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class d implements c {

        /* renamed from: f */
        public final e f248f;

        /* renamed from: g */
        public final boolean f249g;

        /* renamed from: h */
        public final i6.d f250h;

        /* renamed from: i */
        public final n.b f251i;

        /* renamed from: j */
        public int f252j = 16384;

        /* renamed from: k */
        public boolean f253k;

        public d(e eVar, boolean z6) {
            this.f248f = eVar;
            this.f249g = z6;
            i6.d dVar = new i6.d();
            this.f250h = dVar;
            this.f251i = new n.b(dVar);
        }

        @Override // a5.c
        public final synchronized void A(boolean z6, boolean z7, int i7, ArrayList arrayList) {
            if (z7) {
                throw new UnsupportedOperationException();
            } else if (!this.f253k) {
                d(i7, arrayList, z6);
            } else {
                throw new IOException("closed");
            }
        }

        @Override // a5.c
        public final synchronized void H(boolean z6, int i7, i6.d dVar, int i8) {
            if (!this.f253k) {
                b(i7, i8, (byte) 0, z6 ? (byte) 1 : 0);
                if (i8 > 0) {
                    this.f248f.h(dVar, (long) i8);
                }
            } else {
                throw new IOException("closed");
            }
        }

        @Override // a5.c
        public final synchronized void I(int i7, a aVar, byte[] bArr) {
            if (this.f253k) {
                throw new IOException("closed");
            } else if (aVar.f141f != -1) {
                b(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f248f.writeInt(i7);
                this.f248f.writeInt(aVar.f141f);
                if (bArr.length > 0) {
                    this.f248f.write(bArr);
                }
                this.f248f.flush();
            } else {
                throw new IllegalArgumentException(String.format("errorCode.httpCode == -1", new Object[0]));
            }
        }

        @Override // a5.c
        public final synchronized void L(int i7, long j7) {
            if (this.f253k) {
                throw new IOException("closed");
            } else if (j7 == 0 || j7 > 2147483647L) {
                throw new IllegalArgumentException(String.format("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j7)));
            } else {
                b(i7, 4, (byte) 8, (byte) 0);
                this.f248f.writeInt((int) j7);
                this.f248f.flush();
            }
        }

        @Override // a5.c
        public final synchronized void M(int i7, int i8, boolean z6) {
            if (!this.f253k) {
                b(0, 8, (byte) 6, z6 ? (byte) 1 : 0);
                this.f248f.writeInt(i7);
                this.f248f.writeInt(i8);
                this.f248f.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // a5.c
        public final int O() {
            return this.f252j;
        }

        public final void b(int i7, int i8, byte b2, byte b7) {
            Logger logger = o.f233a;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(b.a(false, i7, i8, b2, b7));
            }
            int i9 = this.f252j;
            if (i8 > i9) {
                throw new IllegalArgumentException(String.format("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i9), Integer.valueOf(i8)));
            } else if ((Integer.MIN_VALUE & i7) == 0) {
                e eVar = this.f248f;
                eVar.writeByte((i8 >>> 16) & 255);
                eVar.writeByte((i8 >>> 8) & 255);
                eVar.writeByte(i8 & 255);
                this.f248f.writeByte(b2 & 255);
                this.f248f.writeByte(b7 & 255);
                this.f248f.writeInt(i7 & SubsamplingScaleImageView.TILE_SIZE_AUTO);
            } else {
                throw new IllegalArgumentException(String.format("reserved bit set: %s", Integer.valueOf(i7)));
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final synchronized void close() {
            this.f253k = true;
            this.f248f.close();
        }

        public final void d(int i7, ArrayList arrayList, boolean z6) {
            if (!this.f253k) {
                this.f251i.b(arrayList);
                long j7 = this.f250h.f4498g;
                int min = (int) Math.min((long) this.f252j, j7);
                long j8 = (long) min;
                int i8 = (j7 > j8 ? 1 : (j7 == j8 ? 0 : -1));
                byte b2 = i8 == 0 ? (byte) 4 : 0;
                if (z6) {
                    b2 = (byte) (b2 | 1);
                }
                b(i7, min, (byte) 1, b2);
                this.f248f.h(this.f250h, j8);
                if (i8 > 0) {
                    e(i7, j7 - j8);
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        public final void e(int i7, long j7) {
            while (j7 > 0) {
                int min = (int) Math.min((long) this.f252j, j7);
                long j8 = (long) min;
                j7 -= j8;
                b(i7, min, (byte) 9, j7 == 0 ? (byte) 4 : 0);
                this.f248f.h(this.f250h, j8);
            }
        }

        @Override // a5.c
        public final synchronized void flush() {
            if (!this.f253k) {
                this.f248f.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // a5.c
        public final synchronized void r(t tVar) {
            if (!this.f253k) {
                int i7 = this.f252j;
                if ((tVar.f267a & 32) != 0) {
                    i7 = tVar.f270d[5];
                }
                this.f252j = i7;
                b(0, 0, (byte) 4, (byte) 1);
                this.f248f.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // a5.c
        public final synchronized void v(int i7, a aVar) {
            if (this.f253k) {
                throw new IOException("closed");
            } else if (aVar.f141f != -1) {
                b(i7, 4, (byte) 3, (byte) 0);
                this.f248f.writeInt(aVar.f141f);
                this.f248f.flush();
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override // a5.c
        public final synchronized void w(t tVar) {
            if (!this.f253k) {
                b(0, Integer.bitCount(tVar.f267a) * 6, (byte) 4, (byte) 0);
                int i7 = 0;
                while (i7 < 10) {
                    boolean z6 = true;
                    if (((1 << i7) & tVar.f267a) == 0) {
                        z6 = false;
                    }
                    if (z6) {
                        this.f248f.writeShort(i7 == 4 ? 3 : i7 == 7 ? 4 : i7);
                        this.f248f.writeInt(tVar.f270d[i7]);
                    }
                    i7++;
                }
                this.f248f.flush();
            } else {
                throw new IOException("closed");
            }
        }

        @Override // a5.c
        public final synchronized void y() {
            if (this.f253k) {
                throw new IOException("closed");
            } else if (this.f249g) {
                Logger logger = o.f233a;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(String.format(">> CONNECTION %s", o.f234b.c()));
                }
                this.f248f.write((byte[]) o.f234b.f4501f.clone());
                this.f248f.flush();
            }
        }
    }

    public static int c(int i7, byte b2, short s) {
        if ((b2 & 8) != 0) {
            i7--;
        }
        if (s <= i7) {
            return (short) (i7 - s);
        }
        d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i7));
        throw null;
    }

    public static void d(String str, Object... objArr) {
        throw new IOException(String.format(str, objArr));
    }

    @Override // a5.v
    public final c a(e eVar, boolean z6) {
        return new d(eVar, z6);
    }

    @Override // a5.v
    public final b b(f fVar, boolean z6) {
        return new c(fVar, z6);
    }
}
