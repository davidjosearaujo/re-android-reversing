package a2;

import a2.IOWrapper;
import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.OsConstants;
import android.util.Log;
import androidx.activity.h;
import androidx.fragment.app.s0;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public final class a {
    public static final byte[] A;
    public static final String[] B;
    public static final int[] C;
    public static final byte[] D;
    public static final d E;
    public static final d[][] F;
    public static final d[] G;
    public static final HashMap<Integer, d>[] H;
    public static final HashMap<String, d>[] I;
    public static final HashSet<String> J;
    public static final HashMap<Integer, Integer> K;
    public static final Charset L;
    public static final byte[] M;
    public static final byte[] N;

    /* renamed from: l */
    public static final boolean f78l = Log.isLoggable("ExifInterface", 3);
    public static final int[] m;

    /* renamed from: n */
    public static final int[] f79n;

    /* renamed from: o */
    public static final byte[] f80o;

    /* renamed from: p */
    public static final byte[] f81p;

    /* renamed from: q */
    public static final byte[] f82q;

    /* renamed from: r */
    public static final byte[] f83r;
    public static final byte[] s;

    /* renamed from: t */
    public static final byte[] f84t;

    /* renamed from: u */
    public static final byte[] f85u;

    /* renamed from: v */
    public static final byte[] f86v;

    /* renamed from: w */
    public static final byte[] f87w;

    /* renamed from: x */
    public static final byte[] f88x;

    /* renamed from: y */
    public static final byte[] f89y;

    /* renamed from: z */
    public static final byte[] f90z;

    /* renamed from: a */
    public FileDescriptor f91a;

    /* renamed from: b */
    public AssetManager.AssetInputStream f92b;

    /* renamed from: c */
    public int f93c;

    /* renamed from: d */
    public final HashMap<String, c>[] f94d;
    public HashSet e;

    /* renamed from: f */
    public ByteOrder f95f;

    /* renamed from: g */
    public boolean f96g;

    /* renamed from: h */
    public int f97h;

    /* renamed from: i */
    public int f98i;

    /* renamed from: j */
    public int f99j;

    /* renamed from: k */
    public int f100k;

    /* renamed from: a2.a$a */
    /* loaded from: classes.dex */
    public class MediaDataSourceExtended extends MediaDataSource {

        /* renamed from: f */
        public long f101f;

        /* renamed from: g */
        public final /* synthetic */ f f102g;

        public MediaDataSourceExtended(f fVar) {
            this.f102g = fVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // android.media.MediaDataSource
        public final long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public final int readAt(long j5, byte[] bArr, int i7, int i8) {
            if (i8 == 0) {
                return 0;
            }
            if (j5 < 0) {
                return -1;
            }
            try {
                long j7 = this.f101f;
                if (j7 != j5) {
                    if (j7 >= 0 && j5 >= j7 + this.f102g.available()) {
                        return -1;
                    }
                    this.f102g.d(j5);
                    this.f101f = j5;
                }
                if (i8 > this.f102g.available()) {
                    i8 = this.f102g.available();
                }
                int read = this.f102g.read(bArr, i7, i8);
                if (read >= 0) {
                    this.f101f += read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f101f = -1L;
            return -1;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends InputStream implements DataInput {

        /* renamed from: j */
        public static final ByteOrder f103j = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: k */
        public static final ByteOrder f104k = ByteOrder.BIG_ENDIAN;

        /* renamed from: f */
        public final DataInputStream f105f;

        /* renamed from: g */
        public ByteOrder f106g;

        /* renamed from: h */
        public int f107h;

        /* renamed from: i */
        public byte[] f108i;

        public b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public b(InputStream inputStream, ByteOrder byteOrder) {
            this.f106g = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f105f = dataInputStream;
            dataInputStream.mark(0);
            this.f107h = 0;
            this.f106g = byteOrder;
        }

        public b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public final int available() {
            return this.f105f.available();
        }

        public final void b(int i7) {
            int i8 = 0;
            while (i8 < i7) {
                int i9 = i7 - i8;
                int skip = (int) this.f105f.skip(i9);
                if (skip <= 0) {
                    if (this.f108i == null) {
                        this.f108i = new byte[8192];
                    }
                    skip = this.f105f.read(this.f108i, 0, Math.min(8192, i9));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i7 + " bytes.");
                    }
                }
                i8 += skip;
            }
            this.f107h += i8;
        }

        @Override // java.io.InputStream
        public final void mark(int i7) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public final int read() {
            this.f107h++;
            return this.f105f.read();
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i7, int i8) {
            int read = this.f105f.read(bArr, i7, i8);
            this.f107h += read;
            return read;
        }

        @Override // java.io.DataInput
        public final boolean readBoolean() {
            this.f107h++;
            return this.f105f.readBoolean();
        }

        @Override // java.io.DataInput
        public final byte readByte() {
            this.f107h++;
            int read = this.f105f.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final char readChar() {
            this.f107h += 2;
            return this.f105f.readChar();
        }

        @Override // java.io.DataInput
        public final double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public final float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr) {
            this.f107h += bArr.length;
            this.f105f.readFully(bArr);
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr, int i7, int i8) {
            this.f107h += i8;
            this.f105f.readFully(bArr, i7, i8);
        }

        @Override // java.io.DataInput
        public final int readInt() {
            this.f107h += 4;
            int read = this.f105f.read();
            int read2 = this.f105f.read();
            int read3 = this.f105f.read();
            int read4 = this.f105f.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.f106g;
                if (byteOrder == f103j) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f104k) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                StringBuilder d7 = h.d("Invalid byte order: ");
                d7.append(this.f106g);
                throw new IOException(d7.toString());
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public final long readLong() {
            this.f107h += 8;
            int read = this.f105f.read();
            int read2 = this.f105f.read();
            int read3 = this.f105f.read();
            int read4 = this.f105f.read();
            int read5 = this.f105f.read();
            int read6 = this.f105f.read();
            int read7 = this.f105f.read();
            int read8 = this.f105f.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.f106g;
                if (byteOrder == f103j) {
                    return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f104k) {
                    return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                }
                StringBuilder d7 = h.d("Invalid byte order: ");
                d7.append(this.f106g);
                throw new IOException(d7.toString());
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final short readShort() {
            int i7;
            this.f107h += 2;
            int read = this.f105f.read();
            int read2 = this.f105f.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f106g;
                if (byteOrder == f103j) {
                    i7 = (read2 << 8) + read;
                } else if (byteOrder != f104k) {
                    StringBuilder d7 = h.d("Invalid byte order: ");
                    d7.append(this.f106g);
                    throw new IOException(d7.toString());
                } else {
                    i7 = (read << 8) + read2;
                }
                return (short) i7;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final String readUTF() {
            this.f107h += 2;
            return this.f105f.readUTF();
        }

        @Override // java.io.DataInput
        public final int readUnsignedByte() {
            this.f107h++;
            return this.f105f.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public final int readUnsignedShort() {
            this.f107h += 2;
            int read = this.f105f.read();
            int read2 = this.f105f.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f106g;
                if (byteOrder == f103j) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == f104k) {
                    return (read << 8) + read2;
                }
                StringBuilder d7 = h.d("Invalid byte order: ");
                d7.append(this.f106g);
                throw new IOException(d7.toString());
            }
            throw new EOFException();
        }

        @Override // java.io.InputStream
        public final void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public final int skipBytes(int i7) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        public final int f109a;

        /* renamed from: b */
        public final int f110b;

        /* renamed from: c */
        public final long f111c;

        /* renamed from: d */
        public final byte[] f112d;

        public c(long j5, byte[] bArr, int i7, int i8) {
            this.f109a = i7;
            this.f110b = i8;
            this.f111c = j5;
            this.f112d = bArr;
        }

        public c(byte[] bArr, int i7, int i8) {
            this(-1L, bArr, i7, i8);
        }

        public static c a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.L);
            return new c(bytes, 2, bytes.length);
        }

        public static c b(long j5, ByteOrder byteOrder) {
            long[] jArr = {j5};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.C[4] * 1]);
            wrap.order(byteOrder);
            for (int i7 = 0; i7 < 1; i7++) {
                wrap.putInt((int) jArr[i7]);
            }
            return new c(wrap.array(), 4, 1);
        }

        public static c c(e eVar, ByteOrder byteOrder) {
            e[] eVarArr = {eVar};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.C[5] * 1]);
            wrap.order(byteOrder);
            for (int i7 = 0; i7 < 1; i7++) {
                e eVar2 = eVarArr[i7];
                wrap.putInt((int) eVar2.f117a);
                wrap.putInt((int) eVar2.f118b);
            }
            return new c(wrap.array(), 5, 1);
        }

        public static c d(int i7, ByteOrder byteOrder) {
            int[] iArr = {i7};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.C[3] * 1]);
            wrap.order(byteOrder);
            for (int i8 = 0; i8 < 1; i8++) {
                wrap.putShort((short) iArr[i8]);
            }
            return new c(wrap.array(), 3, 1);
        }

        public final double e(ByteOrder byteOrder) {
            Serializable h7 = h(byteOrder);
            if (h7 != null) {
                if (h7 instanceof String) {
                    return Double.parseDouble((String) h7);
                }
                if (h7 instanceof long[]) {
                    long[] jArr = (long[]) h7;
                    if (jArr.length == 1) {
                        return jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (h7 instanceof int[]) {
                    int[] iArr = (int[]) h7;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (h7 instanceof double[]) {
                    double[] dArr = (double[]) h7;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (h7 instanceof e[]) {
                    e[] eVarArr = (e[]) h7;
                    if (eVarArr.length == 1) {
                        e eVar = eVarArr[0];
                        return eVar.f117a / eVar.f118b;
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public final int f(ByteOrder byteOrder) {
            Serializable h7 = h(byteOrder);
            if (h7 != null) {
                if (h7 instanceof String) {
                    return Integer.parseInt((String) h7);
                }
                if (h7 instanceof long[]) {
                    long[] jArr = (long[]) h7;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (h7 instanceof int[]) {
                    int[] iArr = (int[]) h7;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public final String g(ByteOrder byteOrder) {
            Serializable h7 = h(byteOrder);
            if (h7 == null) {
                return null;
            }
            if (h7 instanceof String) {
                return (String) h7;
            }
            StringBuilder sb = new StringBuilder();
            int i7 = 0;
            if (h7 instanceof long[]) {
                long[] jArr = (long[]) h7;
                while (i7 < jArr.length) {
                    sb.append(jArr[i7]);
                    i7++;
                    if (i7 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (h7 instanceof int[]) {
                int[] iArr = (int[]) h7;
                while (i7 < iArr.length) {
                    sb.append(iArr[i7]);
                    i7++;
                    if (i7 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (h7 instanceof double[]) {
                double[] dArr = (double[]) h7;
                while (i7 < dArr.length) {
                    sb.append(dArr[i7]);
                    i7++;
                    if (i7 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (h7 instanceof e[]) {
                e[] eVarArr = (e[]) h7;
                while (i7 < eVarArr.length) {
                    sb.append(eVarArr[i7].f117a);
                    sb.append('/');
                    sb.append(eVarArr[i7].f118b);
                    i7++;
                    if (i7 != eVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else {
                return null;
            }
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x01a3: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:151:0x01a3 */
        /* JADX WARN: Removed duplicated region for block: B:177:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r13v17, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v19, types: [long[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v21, types: [a2.a$e[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v23, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v25, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v27, types: [a2.a$e[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v29, types: [double[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v31, types: [double[], java.io.Serializable] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.io.Serializable h(java.nio.ByteOrder r13) {
            /*
                Method dump skipped, instructions count: 460
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.a.c.h(java.nio.ByteOrder):java.io.Serializable");
        }

        public final String toString() {
            StringBuilder d7 = h.d("(");
            d7.append(a.B[this.f109a]);
            d7.append(", data length:");
            d7.append(this.f112d.length);
            d7.append(")");
            return d7.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a */
        public final int f113a;

        /* renamed from: b */
        public final String f114b;

        /* renamed from: c */
        public final int f115c;

        /* renamed from: d */
        public final int f116d;

        public d(int i7, int i8, int i9, String str) {
            this.f114b = str;
            this.f113a = i7;
            this.f115c = i8;
            this.f116d = i9;
        }

        public d(int i7, int i8, String str) {
            this.f114b = str;
            this.f113a = i7;
            this.f115c = i8;
            this.f116d = -1;
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a */
        public final long f117a;

        /* renamed from: b */
        public final long f118b;

        public e(long j5, long j7) {
            if (j7 == 0) {
                this.f117a = 0L;
                this.f118b = 1L;
                return;
            }
            this.f117a = j5;
            this.f118b = j7;
        }

        public final String toString() {
            return this.f117a + "/" + this.f118b;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends b {
        public f(InputStream inputStream) {
            super(inputStream);
            if (!inputStream.markSupported()) {
                throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
            }
            this.f105f.mark(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        }

        public f(byte[] bArr) {
            super(bArr);
            this.f105f.mark(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        }

        public final void d(long j5) {
            int i7 = this.f107h;
            if (i7 > j5) {
                this.f107h = 0;
                this.f105f.reset();
            } else {
                j5 -= i7;
            }
            b((int) j5);
        }
    }

    static {
        d[] dVarArr;
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        m = new int[]{8, 8, 8};
        f79n = new int[]{8};
        f80o = new byte[]{-1, -40, -1};
        f81p = new byte[]{102, 116, 121, 112};
        f82q = new byte[]{109, 105, 102, 49};
        f83r = new byte[]{104, 101, 105, 99};
        s = new byte[]{79, 76, 89, 77, 80, 0};
        f84t = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        f85u = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        f86v = new byte[]{101, 88, 73, 102};
        f87w = new byte[]{73, 72, 68, 82};
        f88x = new byte[]{73, 69, 78, 68};
        f89y = new byte[]{82, 73, 70, 70};
        f90z = new byte[]{87, 69, 66, 80};
        A = new byte[]{69, 88, 73, 70};
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        B = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        C = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        D = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        d[] dVarArr2 = {new d(254, 4, "NewSubfileType"), new d(255, 4, "SubfileType"), new d(256, 3, 4, "ImageWidth"), new d(257, 3, 4, "ImageLength"), new d(258, 3, "BitsPerSample"), new d(259, 3, "Compression"), new d(262, 3, "PhotometricInterpretation"), new d(SubsamplingScaleImageView.ORIENTATION_270, 2, "ImageDescription"), new d(271, 2, "Make"), new d(272, 2, "Model"), new d(273, 3, 4, "StripOffsets"), new d(274, 3, "Orientation"), new d(277, 3, "SamplesPerPixel"), new d(278, 3, 4, "RowsPerStrip"), new d(279, 3, 4, "StripByteCounts"), new d(282, 5, "XResolution"), new d(283, 5, "YResolution"), new d(284, 3, "PlanarConfiguration"), new d(296, 3, "ResolutionUnit"), new d(301, 3, "TransferFunction"), new d(305, 2, "Software"), new d(306, 2, "DateTime"), new d(315, 2, "Artist"), new d(318, 5, "WhitePoint"), new d(319, 5, "PrimaryChromaticities"), new d(330, 4, "SubIFDPointer"), new d(513, 4, "JPEGInterchangeFormat"), new d(514, 4, "JPEGInterchangeFormatLength"), new d(529, 5, "YCbCrCoefficients"), new d(530, 3, "YCbCrSubSampling"), new d(531, 3, "YCbCrPositioning"), new d(532, 5, "ReferenceBlackWhite"), new d(33432, 2, "Copyright"), new d(34665, 4, "ExifIFDPointer"), new d(34853, 4, "GPSInfoIFDPointer"), new d(4, 4, "SensorTopBorder"), new d(5, 4, "SensorLeftBorder"), new d(6, 4, "SensorBottomBorder"), new d(7, 4, "SensorRightBorder"), new d(23, 3, "ISO"), new d(46, 7, "JpgFromRaw"), new d(700, 1, "Xmp")};
        d[] dVarArr3 = {new d(33434, 5, "ExposureTime"), new d(33437, 5, "FNumber"), new d(34850, 3, "ExposureProgram"), new d(34852, 2, "SpectralSensitivity"), new d(34855, 3, "PhotographicSensitivity"), new d(34856, 7, "OECF"), new d(34864, 3, "SensitivityType"), new d(34865, 4, "StandardOutputSensitivity"), new d(34866, 4, "RecommendedExposureIndex"), new d(34867, 4, "ISOSpeed"), new d(34868, 4, "ISOSpeedLatitudeyyy"), new d(34869, 4, "ISOSpeedLatitudezzz"), new d(36864, 2, "ExifVersion"), new d(36867, 2, "DateTimeOriginal"), new d(36868, 2, "DateTimeDigitized"), new d(36880, 2, "OffsetTime"), new d(36881, 2, "OffsetTimeOriginal"), new d(36882, 2, "OffsetTimeDigitized"), new d(37121, 7, "ComponentsConfiguration"), new d(37122, 5, "CompressedBitsPerPixel"), new d(37377, 10, "ShutterSpeedValue"), new d(37378, 5, "ApertureValue"), new d(37379, 10, "BrightnessValue"), new d(37380, 10, "ExposureBiasValue"), new d(37381, 5, "MaxApertureValue"), new d(37382, 5, "SubjectDistance"), new d(37383, 3, "MeteringMode"), new d(37384, 3, "LightSource"), new d(37385, 3, "Flash"), new d(37386, 5, "FocalLength"), new d(37396, 3, "SubjectArea"), new d(37500, 7, "MakerNote"), new d(37510, 7, "UserComment"), new d(37520, 2, "SubSecTime"), new d(37521, 2, "SubSecTimeOriginal"), new d(37522, 2, "SubSecTimeDigitized"), new d(40960, 7, "FlashpixVersion"), new d(40961, 3, "ColorSpace"), new d(40962, 3, 4, "PixelXDimension"), new d(40963, 3, 4, "PixelYDimension"), new d(40964, 2, "RelatedSoundFile"), new d(40965, 4, "InteroperabilityIFDPointer"), new d(41483, 5, "FlashEnergy"), new d(41484, 7, "SpatialFrequencyResponse"), new d(41486, 5, "FocalPlaneXResolution"), new d(41487, 5, "FocalPlaneYResolution"), new d(41488, 3, "FocalPlaneResolutionUnit"), new d(41492, 3, "SubjectLocation"), new d(41493, 5, "ExposureIndex"), new d(41495, 3, "SensingMethod"), new d(41728, 7, "FileSource"), new d(41729, 7, "SceneType"), new d(41730, 7, "CFAPattern"), new d(41985, 3, "CustomRendered"), new d(41986, 3, "ExposureMode"), new d(41987, 3, "WhiteBalance"), new d(41988, 5, "DigitalZoomRatio"), new d(41989, 3, "FocalLengthIn35mmFilm"), new d(41990, 3, "SceneCaptureType"), new d(41991, 3, "GainControl"), new d(41992, 3, "Contrast"), new d(41993, 3, "Saturation"), new d(41994, 3, "Sharpness"), new d(41995, 7, "DeviceSettingDescription"), new d(41996, 3, "SubjectDistanceRange"), new d(42016, 2, "ImageUniqueID"), new d(42032, 2, "CameraOwnerName"), new d(42033, 2, "BodySerialNumber"), new d(42034, 5, "LensSpecification"), new d(42035, 2, "LensMake"), new d(42036, 2, "LensModel"), new d(42240, 5, "Gamma"), new d(50706, 1, "DNGVersion"), new d(50720, 3, 4, "DefaultCropSize")};
        d[] dVarArr4 = {new d(0, 1, "GPSVersionID"), new d(1, 2, "GPSLatitudeRef"), new d(2, 5, 10, "GPSLatitude"), new d(3, 2, "GPSLongitudeRef"), new d(4, 5, 10, "GPSLongitude"), new d(5, 1, "GPSAltitudeRef"), new d(6, 5, "GPSAltitude"), new d(7, 5, "GPSTimeStamp"), new d(8, 2, "GPSSatellites"), new d(9, 2, "GPSStatus"), new d(10, 2, "GPSMeasureMode"), new d(11, 5, "GPSDOP"), new d(12, 2, "GPSSpeedRef"), new d(13, 5, "GPSSpeed"), new d(14, 2, "GPSTrackRef"), new d(15, 5, "GPSTrack"), new d(16, 2, "GPSImgDirectionRef"), new d(17, 5, "GPSImgDirection"), new d(18, 2, "GPSMapDatum"), new d(19, 2, "GPSDestLatitudeRef"), new d(20, 5, "GPSDestLatitude"), new d(21, 2, "GPSDestLongitudeRef"), new d(22, 5, "GPSDestLongitude"), new d(23, 2, "GPSDestBearingRef"), new d(24, 5, "GPSDestBearing"), new d(25, 2, "GPSDestDistanceRef"), new d(26, 5, "GPSDestDistance"), new d(27, 7, "GPSProcessingMethod"), new d(28, 7, "GPSAreaInformation"), new d(29, 2, "GPSDateStamp"), new d(30, 3, "GPSDifferential"), new d(31, 5, "GPSHPositioningError")};
        d[] dVarArr5 = {new d(1, 2, "InteroperabilityIndex")};
        d[] dVarArr6 = {new d(254, 4, "NewSubfileType"), new d(255, 4, "SubfileType"), new d(256, 3, 4, "ThumbnailImageWidth"), new d(257, 3, 4, "ThumbnailImageLength"), new d(258, 3, "BitsPerSample"), new d(259, 3, "Compression"), new d(262, 3, "PhotometricInterpretation"), new d(SubsamplingScaleImageView.ORIENTATION_270, 2, "ImageDescription"), new d(271, 2, "Make"), new d(272, 2, "Model"), new d(273, 3, 4, "StripOffsets"), new d(274, 3, "ThumbnailOrientation"), new d(277, 3, "SamplesPerPixel"), new d(278, 3, 4, "RowsPerStrip"), new d(279, 3, 4, "StripByteCounts"), new d(282, 5, "XResolution"), new d(283, 5, "YResolution"), new d(284, 3, "PlanarConfiguration"), new d(296, 3, "ResolutionUnit"), new d(301, 3, "TransferFunction"), new d(305, 2, "Software"), new d(306, 2, "DateTime"), new d(315, 2, "Artist"), new d(318, 5, "WhitePoint"), new d(319, 5, "PrimaryChromaticities"), new d(330, 4, "SubIFDPointer"), new d(513, 4, "JPEGInterchangeFormat"), new d(514, 4, "JPEGInterchangeFormatLength"), new d(529, 5, "YCbCrCoefficients"), new d(530, 3, "YCbCrSubSampling"), new d(531, 3, "YCbCrPositioning"), new d(532, 5, "ReferenceBlackWhite"), new d(700, 1, "Xmp"), new d(33432, 2, "Copyright"), new d(34665, 4, "ExifIFDPointer"), new d(34853, 4, "GPSInfoIFDPointer"), new d(50706, 1, "DNGVersion"), new d(50720, 3, 4, "DefaultCropSize")};
        E = new d(273, 3, "StripOffsets");
        F = new d[][]{dVarArr2, dVarArr3, dVarArr4, dVarArr5, dVarArr6, dVarArr2, new d[]{new d(256, 7, "ThumbnailImage"), new d(8224, 4, "CameraSettingsIFDPointer"), new d(8256, 4, "ImageProcessingIFDPointer")}, new d[]{new d(257, 4, "PreviewImageStart"), new d(258, 4, "PreviewImageLength")}, new d[]{new d(4371, 3, "AspectFrame")}, new d[]{new d(55, 3, "ColorSpace")}};
        G = new d[]{new d(330, 4, "SubIFDPointer"), new d(34665, 4, "ExifIFDPointer"), new d(34853, 4, "GPSInfoIFDPointer"), new d(40965, 4, "InteroperabilityIFDPointer"), new d(8224, 1, "CameraSettingsIFDPointer"), new d(8256, 1, "ImageProcessingIFDPointer")};
        H = new HashMap[10];
        I = new HashMap[10];
        J = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        K = new HashMap<>();
        Charset forName = Charset.forName("US-ASCII");
        L = forName;
        M = "Exif\u0000\u0000".getBytes(forName);
        N = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        int i7 = 0;
        while (true) {
            d[][] dVarArr7 = F;
            if (i7 >= dVarArr7.length) {
                HashMap<Integer, Integer> hashMap = K;
                d[] dVarArr8 = G;
                hashMap.put(Integer.valueOf(dVarArr8[0].f113a), 5);
                hashMap.put(Integer.valueOf(dVarArr8[1].f113a), 1);
                hashMap.put(Integer.valueOf(dVarArr8[2].f113a), 2);
                hashMap.put(Integer.valueOf(dVarArr8[3].f113a), 3);
                hashMap.put(Integer.valueOf(dVarArr8[4].f113a), 7);
                hashMap.put(Integer.valueOf(dVarArr8[5].f113a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            H[i7] = new HashMap<>();
            I[i7] = new HashMap<>();
            for (d dVar : dVarArr7[i7]) {
                H[i7].put(Integer.valueOf(dVar.f113a), dVar);
                I[i7].put(dVar.f114b, dVar);
            }
            i7++;
        }
    }

    public a(InputStream inputStream) {
        boolean z6;
        d[][] dVarArr = F;
        this.f94d = new HashMap[dVarArr.length];
        this.e = new HashSet(dVarArr.length);
        this.f95f = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new NullPointerException("inputStream cannot be null");
        }
        FileDescriptor fileDescriptor = null;
        boolean z7 = true;
        if (inputStream instanceof AssetManager.AssetInputStream) {
            this.f92b = (AssetManager.AssetInputStream) inputStream;
        } else {
            if (inputStream instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) inputStream;
                try {
                    IOWrapper.FileDescriptorWrapper.seek(fileInputStream.getFD(), 0L, OsConstants.SEEK_CUR);
                    z6 = true;
                } catch (Exception unused) {
                    if (f78l) {
                        Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                    }
                    z6 = false;
                }
                if (z6) {
                    this.f92b = null;
                    fileDescriptor = fileInputStream.getFD();
                }
            }
            this.f92b = null;
        }
        this.f91a = fileDescriptor;
        for (int i7 = 0; i7 < F.length; i7++) {
            try {
                try {
                    this.f94d[i7] = new HashMap<>();
                } catch (IOException | UnsupportedOperationException e7) {
                    boolean z8 = f78l;
                    if (z8) {
                        Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e7);
                    }
                    a();
                    if (!z8) {
                        return;
                    }
                }
            } finally {
                a();
                if (f78l) {
                    p();
                }
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        int f7 = f(bufferedInputStream);
        this.f93c = f7;
        if ((f7 == 4 || f7 == 9 || f7 == 13 || f7 == 14) ? false : z7) {
            f fVar = new f(bufferedInputStream);
            int i8 = this.f93c;
            if (i8 == 12) {
                d(fVar);
            } else if (i8 == 7) {
                g(fVar);
            } else if (i8 == 10) {
                k(fVar);
            } else {
                j(fVar);
            }
            fVar.d(this.f97h);
            u(fVar);
        } else {
            b bVar = new b(bufferedInputStream);
            int i9 = this.f93c;
            if (i9 == 4) {
                e(bVar, 0, 0);
            } else if (i9 == 13) {
                h(bVar);
            } else if (i9 == 9) {
                i(bVar);
            } else if (i9 == 14) {
                l(bVar);
            }
        }
    }

    public static ByteOrder q(b bVar) {
        short readShort = bVar.readShort();
        if (readShort == 18761) {
            if (f78l) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            if (f78l) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        } else {
            StringBuilder d7 = h.d("Invalid byte order: ");
            d7.append(Integer.toHexString(readShort));
            throw new IOException(d7.toString());
        }
    }

    public final void a() {
        String b2 = b("DateTimeOriginal");
        if (b2 != null && b("DateTime") == null) {
            this.f94d[0].put("DateTime", c.a(b2));
        }
        if (b("ImageWidth") == null) {
            this.f94d[0].put("ImageWidth", c.b(0L, this.f95f));
        }
        if (b("ImageLength") == null) {
            this.f94d[0].put("ImageLength", c.b(0L, this.f95f));
        }
        if (b("Orientation") == null) {
            this.f94d[0].put("Orientation", c.b(0L, this.f95f));
        }
        if (b("LightSource") == null) {
            this.f94d[1].put("LightSource", c.b(0L, this.f95f));
        }
    }

    public final String b(String str) {
        String sb;
        c c7 = c(str);
        if (c7 != null) {
            if (!J.contains(str)) {
                return c7.g(this.f95f);
            }
            if (str.equals("GPSTimeStamp")) {
                int i7 = c7.f109a;
                if (i7 == 5 || i7 == 10) {
                    e[] eVarArr = (e[]) c7.h(this.f95f);
                    if (eVarArr != null && eVarArr.length == 3) {
                        e eVar = eVarArr[0];
                        e eVar2 = eVarArr[1];
                        e eVar3 = eVarArr[2];
                        return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) eVar.f117a) / ((float) eVar.f118b))), Integer.valueOf((int) (((float) eVar2.f117a) / ((float) eVar2.f118b))), Integer.valueOf((int) (((float) eVar3.f117a) / ((float) eVar3.f118b))));
                    }
                    StringBuilder d7 = h.d("Invalid GPS Timestamp array. array=");
                    d7.append(Arrays.toString(eVarArr));
                    sb = d7.toString();
                } else {
                    StringBuilder d8 = h.d("GPS Timestamp format is not rational. format=");
                    d8.append(c7.f109a);
                    sb = d8.toString();
                }
                Log.w("ExifInterface", sb);
                return null;
            }
            try {
                return Double.toString(c7.e(this.f95f));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final c c(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            if (f78l) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i7 = 0; i7 < F.length; i7++) {
            c cVar = this.f94d[i7].get(str);
            if (cVar != null) {
                return cVar;
            }
        }
        return null;
    }

    public final void d(f fVar) {
        String str;
        String str2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                IOWrapper.DataSourceSetter.setDataSource(mediaMetadataRetriever, new MediaDataSourceExtended(fVar));
                String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                String str3 = null;
                if ("yes".equals(extractMetadata3)) {
                    str3 = mediaMetadataRetriever.extractMetadata(29);
                    str = mediaMetadataRetriever.extractMetadata(30);
                    str2 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(extractMetadata4)) {
                    str3 = mediaMetadataRetriever.extractMetadata(18);
                    str = mediaMetadataRetriever.extractMetadata(19);
                    str2 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    str = null;
                    str2 = null;
                }
                if (str3 != null) {
                    this.f94d[0].put("ImageWidth", c.d(Integer.parseInt(str3), this.f95f));
                }
                if (str != null) {
                    this.f94d[0].put("ImageLength", c.d(Integer.parseInt(str), this.f95f));
                }
                if (str2 != null) {
                    int i7 = 1;
                    int parseInt = Integer.parseInt(str2);
                    if (parseInt == 90) {
                        i7 = 6;
                    } else if (parseInt == 180) {
                        i7 = 3;
                    } else if (parseInt == 270) {
                        i7 = 8;
                    }
                    this.f94d[0].put("Orientation", c.d(i7, this.f95f));
                }
                if (extractMetadata != null && extractMetadata2 != null) {
                    int parseInt2 = Integer.parseInt(extractMetadata);
                    int parseInt3 = Integer.parseInt(extractMetadata2);
                    if (parseInt3 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    fVar.d(parseInt2);
                    byte[] bArr = new byte[6];
                    if (fVar.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i8 = parseInt2 + 6;
                    int i9 = parseInt3 - 6;
                    if (!Arrays.equals(bArr, M)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i9];
                    if (fVar.read(bArr2) != i9) {
                        throw new IOException("Can't read exif");
                    }
                    this.f97h = i8;
                    r(bArr2, 0);
                }
                if (f78l) {
                    Log.d("ExifInterface", "Heif meta: " + str3 + "x" + str + ", rotation " + str2);
                }
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x01a7, code lost:
        r20.f106g = r19.f95f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01ab, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ae A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(a2.a.b r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.e(a2.a$b, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x00cf, code lost:
        if (r8 != null) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0143 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x010f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int f(java.io.BufferedInputStream r18) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.f(java.io.BufferedInputStream):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(a2.a.f r6) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.g(a2.a$f):void");
    }

    public final void h(b bVar) {
        if (f78l) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.f106g = ByteOrder.BIG_ENDIAN;
        byte[] bArr = f85u;
        bVar.b(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = bVar.readInt();
                int i7 = length + 4;
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i8 = i7 + 4;
                if (i8 == 16 && !Arrays.equals(bArr2, f87w)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, f88x)) {
                    return;
                }
                if (Arrays.equals(bArr2, f86v)) {
                    byte[] bArr3 = new byte[readInt];
                    if (bVar.read(bArr3) != readInt) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + IOWrapper.ByteArrayToString(bArr2));
                    }
                    int readInt2 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == readInt2) {
                        this.f97h = i8;
                        r(bArr3, 0);
                        x();
                        u(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                }
                int i9 = readInt + 4;
                bVar.b(i9);
                length = i8 + i9;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void i(b bVar) {
        boolean z6 = f78l;
        if (z6) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.b(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i7 = ByteBuffer.wrap(bArr).getInt();
        int i8 = ByteBuffer.wrap(bArr2).getInt();
        int i9 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i8];
        bVar.b(i7 - bVar.f107h);
        bVar.read(bArr4);
        e(new b(bArr4), i7, 5);
        bVar.b(i9 - bVar.f107h);
        bVar.f106g = ByteOrder.BIG_ENDIAN;
        int readInt = bVar.readInt();
        if (z6) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i10 = 0; i10 < readInt; i10++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == E.f113a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                c d7 = c.d(readShort, this.f95f);
                c d8 = c.d(readShort2, this.f95f);
                this.f94d[0].put("ImageLength", d7);
                this.f94d[0].put("ImageWidth", d8);
                if (f78l) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) readShort) + ", width: " + ((int) readShort2));
                    return;
                }
                return;
            }
            bVar.b(readUnsignedShort2);
        }
    }

    public final void j(f fVar) {
        c cVar;
        o(fVar);
        s(fVar, 0);
        w(fVar, 0);
        w(fVar, 5);
        w(fVar, 4);
        x();
        if (this.f93c != 8 || (cVar = this.f94d[1].get("MakerNote")) == null) {
            return;
        }
        f fVar2 = new f(cVar.f112d);
        fVar2.f106g = this.f95f;
        fVar2.b(6);
        s(fVar2, 9);
        c cVar2 = this.f94d[9].get("ColorSpace");
        if (cVar2 != null) {
            this.f94d[1].put("ColorSpace", cVar2);
        }
    }

    public final void k(f fVar) {
        if (f78l) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + fVar);
        }
        j(fVar);
        c cVar = this.f94d[0].get("JpgFromRaw");
        if (cVar != null) {
            e(new b(cVar.f112d), (int) cVar.f111c, 5);
        }
        c cVar2 = this.f94d[0].get("ISO");
        c cVar3 = this.f94d[1].get("PhotographicSensitivity");
        if (cVar2 == null || cVar3 != null) {
            return;
        }
        this.f94d[1].put("PhotographicSensitivity", cVar2);
    }

    public final void l(b bVar) {
        if (f78l) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.f106g = ByteOrder.LITTLE_ENDIAN;
        bVar.b(f89y.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = f90z;
        bVar.b(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int readInt2 = bVar.readInt();
                int i7 = length + 4 + 4;
                if (Arrays.equals(A, bArr2)) {
                    byte[] bArr3 = new byte[readInt2];
                    if (bVar.read(bArr3) == readInt2) {
                        this.f97h = i7;
                        r(bArr3, 0);
                        u(new b(bArr3));
                        return;
                    }
                    throw new IOException("Failed to read given length for given PNG chunk type: " + IOWrapper.ByteArrayToString(bArr2));
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                length = i7 + readInt2;
                if (length == readInt) {
                    return;
                }
                if (length > readInt) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.b(readInt2);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void m(b bVar, HashMap hashMap) {
        c cVar = (c) hashMap.get("JPEGInterchangeFormat");
        c cVar2 = (c) hashMap.get("JPEGInterchangeFormatLength");
        if (cVar == null || cVar2 == null) {
            return;
        }
        int f7 = cVar.f(this.f95f);
        int f8 = cVar2.f(this.f95f);
        if (this.f93c == 7) {
            f7 += this.f98i;
        }
        if (f7 > 0 && f8 > 0 && this.f92b == null && this.f91a == null) {
            bVar.skip(f7);
            bVar.read(new byte[f8]);
        }
        if (f78l) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + f7 + ", length: " + f8);
        }
    }

    public final boolean n(HashMap hashMap) {
        c cVar = (c) hashMap.get("ImageLength");
        c cVar2 = (c) hashMap.get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            return false;
        }
        return cVar.f(this.f95f) <= 512 && cVar2.f(this.f95f) <= 512;
    }

    public final void o(b bVar) {
        ByteOrder q6 = q(bVar);
        this.f95f = q6;
        bVar.f106g = q6;
        int readUnsignedShort = bVar.readUnsignedShort();
        int i7 = this.f93c;
        if (i7 != 7 && i7 != 10 && readUnsignedShort != 42) {
            StringBuilder d7 = h.d("Invalid start code: ");
            d7.append(Integer.toHexString(readUnsignedShort));
            throw new IOException(d7.toString());
        }
        int readInt = bVar.readInt();
        if (readInt < 8) {
            throw new IOException(s0.g("Invalid first Ifd offset: ", readInt));
        }
        int i8 = readInt - 8;
        if (i8 > 0) {
            bVar.b(i8);
        }
    }

    public final void p() {
        for (int i7 = 0; i7 < this.f94d.length; i7++) {
            Log.d("ExifInterface", "The size of tag group[" + i7 + "]: " + this.f94d[i7].size());
            for (Map.Entry<String, c> entry : this.f94d[i7].entrySet()) {
                c value = entry.getValue();
                StringBuilder d7 = h.d("tagName: ");
                d7.append(entry.getKey());
                d7.append(", tagType: ");
                d7.append(value.toString());
                d7.append(", tagValue: '");
                d7.append(value.g(this.f95f));
                d7.append("'");
                Log.d("ExifInterface", d7.toString());
            }
        }
    }

    public final void r(byte[] bArr, int i7) {
        f fVar = new f(bArr);
        o(fVar);
        s(fVar, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s(a2.a.f r22, int r23) {
        /*
            Method dump skipped, instructions count: 937
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.s(a2.a$f, int):void");
    }

    public final void t(int i7, String str, String str2) {
        if (this.f94d[i7].isEmpty() || this.f94d[i7].get(str) == null) {
            return;
        }
        HashMap<String, c> hashMap = this.f94d[i7];
        hashMap.put(str2, hashMap.get(str));
        this.f94d[i7].remove(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u(a2.a.b r18) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.u(a2.a$b):void");
    }

    public final void v(int i7, int i8) {
        String str;
        if (this.f94d[i7].isEmpty() || this.f94d[i8].isEmpty()) {
            if (f78l) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        c cVar = this.f94d[i7].get("ImageLength");
        c cVar2 = this.f94d[i7].get("ImageWidth");
        c cVar3 = this.f94d[i8].get("ImageLength");
        c cVar4 = this.f94d[i8].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            if (!f78l) {
                return;
            }
            str = "First image does not contain valid size information";
        } else if (cVar3 != null && cVar4 != null) {
            int f7 = cVar.f(this.f95f);
            int f8 = cVar2.f(this.f95f);
            int f9 = cVar3.f(this.f95f);
            int f10 = cVar4.f(this.f95f);
            if (f7 >= f9 || f8 >= f10) {
                return;
            }
            HashMap<String, c>[] hashMapArr = this.f94d;
            HashMap<String, c> hashMap = hashMapArr[i7];
            hashMapArr[i7] = hashMapArr[i8];
            hashMapArr[i8] = hashMap;
            return;
        } else if (!f78l) {
            return;
        } else {
            str = "Second image does not contain valid size information";
        }
        Log.d("ExifInterface", str);
    }

    public final void w(f fVar, int i7) {
        StringBuilder d7;
        String arrays;
        c d8;
        c d9;
        c cVar = this.f94d[i7].get("DefaultCropSize");
        c cVar2 = this.f94d[i7].get("SensorTopBorder");
        c cVar3 = this.f94d[i7].get("SensorLeftBorder");
        c cVar4 = this.f94d[i7].get("SensorBottomBorder");
        c cVar5 = this.f94d[i7].get("SensorRightBorder");
        if (cVar != null) {
            if (cVar.f109a == 5) {
                e[] eVarArr = (e[]) cVar.h(this.f95f);
                if (eVarArr == null || eVarArr.length != 2) {
                    d7 = h.d("Invalid crop size values. cropSize=");
                    arrays = Arrays.toString(eVarArr);
                    d7.append(arrays);
                    Log.w("ExifInterface", d7.toString());
                    return;
                }
                d8 = c.c(eVarArr[0], this.f95f);
                d9 = c.c(eVarArr[1], this.f95f);
                this.f94d[i7].put("ImageWidth", d8);
                this.f94d[i7].put("ImageLength", d9);
            }
            int[] iArr = (int[]) cVar.h(this.f95f);
            if (iArr == null || iArr.length != 2) {
                d7 = h.d("Invalid crop size values. cropSize=");
                arrays = Arrays.toString(iArr);
                d7.append(arrays);
                Log.w("ExifInterface", d7.toString());
                return;
            }
            d8 = c.d(iArr[0], this.f95f);
            d9 = c.d(iArr[1], this.f95f);
            this.f94d[i7].put("ImageWidth", d8);
            this.f94d[i7].put("ImageLength", d9);
        } else if (cVar2 != null && cVar3 != null && cVar4 != null && cVar5 != null) {
            int f7 = cVar2.f(this.f95f);
            int f8 = cVar4.f(this.f95f);
            int f9 = cVar5.f(this.f95f);
            int f10 = cVar3.f(this.f95f);
            if (f8 <= f7 || f9 <= f10) {
                return;
            }
            c d10 = c.d(f8 - f7, this.f95f);
            c d11 = c.d(f9 - f10, this.f95f);
            this.f94d[i7].put("ImageLength", d10);
            this.f94d[i7].put("ImageWidth", d11);
        } else {
            c cVar6 = this.f94d[i7].get("ImageLength");
            c cVar7 = this.f94d[i7].get("ImageWidth");
            if (cVar6 == null || cVar7 == null) {
                c cVar8 = this.f94d[i7].get("JPEGInterchangeFormat");
                c cVar9 = this.f94d[i7].get("JPEGInterchangeFormatLength");
                if (cVar8 == null || cVar9 == null) {
                    return;
                }
                int f11 = cVar8.f(this.f95f);
                int f12 = cVar8.f(this.f95f);
                fVar.d(f11);
                byte[] bArr = new byte[f12];
                fVar.read(bArr);
                e(new b(bArr), f11, i7);
            }
        }
    }

    public final void x() {
        v(0, 5);
        v(0, 4);
        v(5, 4);
        c cVar = this.f94d[1].get("PixelXDimension");
        c cVar2 = this.f94d[1].get("PixelYDimension");
        if (cVar != null && cVar2 != null) {
            this.f94d[0].put("ImageWidth", cVar);
            this.f94d[0].put("ImageLength", cVar2);
        }
        if (this.f94d[4].isEmpty() && n(this.f94d[5])) {
            HashMap<String, c>[] hashMapArr = this.f94d;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!n(this.f94d[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        t(0, "ThumbnailOrientation", "Orientation");
        t(0, "ThumbnailImageLength", "ImageLength");
        t(0, "ThumbnailImageWidth", "ImageWidth");
        t(5, "ThumbnailOrientation", "Orientation");
        t(5, "ThumbnailImageLength", "ImageLength");
        t(5, "ThumbnailImageWidth", "ImageWidth");
        t(4, "Orientation", "ThumbnailOrientation");
        t(4, "ImageLength", "ThumbnailImageLength");
        t(4, "ImageWidth", "ThumbnailImageWidth");
    }
}
