package b;

import android.util.Log;
import androidx.activity.h;
import androidx.fragment.app.s0;
import com.davemorrissey.labs.subscaleview.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
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
import java.util.TimeZone;
import java.util.regex.Pattern;
import linc.com.amplituda.ErrorCode;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: j */
    public static final int[] f2298j;

    /* renamed from: k */
    public static final int[] f2299k;

    /* renamed from: l */
    public static final byte[] f2300l;
    public static final byte[] m;

    /* renamed from: n */
    public static final byte[] f2301n;

    /* renamed from: o */
    public static final String[] f2302o;

    /* renamed from: p */
    public static final int[] f2303p;

    /* renamed from: q */
    public static final byte[] f2304q;

    /* renamed from: r */
    public static final c f2305r;
    public static final c[][] s;

    /* renamed from: t */
    public static final c[] f2306t;

    /* renamed from: u */
    public static final HashMap<Integer, c>[] f2307u;

    /* renamed from: v */
    public static final HashMap<String, c>[] f2308v;

    /* renamed from: w */
    public static final HashSet<String> f2309w;

    /* renamed from: x */
    public static final HashMap<Integer, Integer> f2310x;

    /* renamed from: y */
    public static final Charset f2311y;

    /* renamed from: z */
    public static final byte[] f2312z;

    /* renamed from: a */
    public final String f2313a;

    /* renamed from: b */
    public int f2314b;

    /* renamed from: c */
    public final HashMap<String, b>[] f2315c = new HashMap[s.length];

    /* renamed from: d */
    public ByteOrder f2316d = ByteOrder.BIG_ENDIAN;
    public int e;

    /* renamed from: f */
    public int f2317f;

    /* renamed from: g */
    public int f2318g;

    /* renamed from: h */
    public int f2319h;

    /* renamed from: i */
    public int f2320i;

    /* renamed from: b.a$a */
    /* loaded from: classes.dex */
    public static class C0025a extends InputStream implements DataInput {

        /* renamed from: j */
        public static final ByteOrder f2321j = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: k */
        public static final ByteOrder f2322k = ByteOrder.BIG_ENDIAN;

        /* renamed from: f */
        public DataInputStream f2323f;

        /* renamed from: g */
        public ByteOrder f2324g;

        /* renamed from: h */
        public final int f2325h;

        /* renamed from: i */
        public int f2326i;

        public C0025a(InputStream inputStream) {
            this.f2324g = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f2323f = dataInputStream;
            int available = dataInputStream.available();
            this.f2325h = available;
            this.f2326i = 0;
            this.f2323f.mark(available);
        }

        public C0025a(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }

        @Override // java.io.InputStream
        public final int available() {
            return this.f2323f.available();
        }

        public final void b(long j7) {
            int i7 = this.f2326i;
            if (i7 > j7) {
                this.f2326i = 0;
                this.f2323f.reset();
                this.f2323f.mark(this.f2325h);
            } else {
                j7 -= i7;
            }
            int i8 = (int) j7;
            if (skipBytes(i8) != i8) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        @Override // java.io.InputStream
        public final int read() {
            this.f2326i++;
            return this.f2323f.read();
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i7, int i8) {
            int read = this.f2323f.read(bArr, i7, i8);
            this.f2326i += read;
            return read;
        }

        @Override // java.io.DataInput
        public final boolean readBoolean() {
            this.f2326i++;
            return this.f2323f.readBoolean();
        }

        @Override // java.io.DataInput
        public final byte readByte() {
            int i7 = this.f2326i + 1;
            this.f2326i = i7;
            if (i7 <= this.f2325h) {
                int read = this.f2323f.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final char readChar() {
            this.f2326i += 2;
            return this.f2323f.readChar();
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
            int length = this.f2326i + bArr.length;
            this.f2326i = length;
            if (length > this.f2325h) {
                throw new EOFException();
            }
            if (this.f2323f.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr, int i7, int i8) {
            int i9 = this.f2326i + i8;
            this.f2326i = i9;
            if (i9 > this.f2325h) {
                throw new EOFException();
            }
            if (this.f2323f.read(bArr, i7, i8) != i8) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public final int readInt() {
            int i7 = this.f2326i + 4;
            this.f2326i = i7;
            if (i7 <= this.f2325h) {
                int read = this.f2323f.read();
                int read2 = this.f2323f.read();
                int read3 = this.f2323f.read();
                int read4 = this.f2323f.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.f2324g;
                    if (byteOrder == f2321j) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f2322k) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    StringBuilder d7 = h.d("Invalid byte order: ");
                    d7.append(this.f2324g);
                    throw new IOException(d7.toString());
                }
                throw new EOFException();
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
            int i7 = this.f2326i + 8;
            this.f2326i = i7;
            if (i7 <= this.f2325h) {
                int read = this.f2323f.read();
                int read2 = this.f2323f.read();
                int read3 = this.f2323f.read();
                int read4 = this.f2323f.read();
                int read5 = this.f2323f.read();
                int read6 = this.f2323f.read();
                int read7 = this.f2323f.read();
                int read8 = this.f2323f.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.f2324g;
                    if (byteOrder == f2321j) {
                        return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f2322k) {
                        return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                    }
                    StringBuilder d7 = h.d("Invalid byte order: ");
                    d7.append(this.f2324g);
                    throw new IOException(d7.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final short readShort() {
            int i7;
            int i8 = this.f2326i + 2;
            this.f2326i = i8;
            if (i8 <= this.f2325h) {
                int read = this.f2323f.read();
                int read2 = this.f2323f.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f2324g;
                    if (byteOrder == f2321j) {
                        i7 = (read2 << 8) + read;
                    } else if (byteOrder != f2322k) {
                        StringBuilder d7 = h.d("Invalid byte order: ");
                        d7.append(this.f2324g);
                        throw new IOException(d7.toString());
                    } else {
                        i7 = (read << 8) + read2;
                    }
                    return (short) i7;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final String readUTF() {
            this.f2326i += 2;
            return this.f2323f.readUTF();
        }

        @Override // java.io.DataInput
        public final int readUnsignedByte() {
            this.f2326i++;
            return this.f2323f.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public final int readUnsignedShort() {
            int i7 = this.f2326i + 2;
            this.f2326i = i7;
            if (i7 <= this.f2325h) {
                int read = this.f2323f.read();
                int read2 = this.f2323f.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f2324g;
                    if (byteOrder == f2321j) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == f2322k) {
                        return (read << 8) + read2;
                    }
                    StringBuilder d7 = h.d("Invalid byte order: ");
                    d7.append(this.f2324g);
                    throw new IOException(d7.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final int skipBytes(int i7) {
            int min = Math.min(i7, this.f2325h - this.f2326i);
            int i8 = 0;
            while (i8 < min) {
                i8 += this.f2323f.skipBytes(min - i8);
            }
            this.f2326i += i8;
            return i8;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public final int f2327a;

        /* renamed from: b */
        public final int f2328b;

        /* renamed from: c */
        public final byte[] f2329c;

        public b(byte[] bArr, int i7, int i8) {
            this.f2327a = i7;
            this.f2328b = i8;
            this.f2329c = bArr;
        }

        public static b a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.f2311y);
            return new b(bytes, 2, bytes.length);
        }

        public static b b(long j7, ByteOrder byteOrder) {
            long[] jArr = {j7};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.f2303p[4] * 1]);
            wrap.order(byteOrder);
            for (int i7 = 0; i7 < 1; i7++) {
                wrap.putInt((int) jArr[i7]);
            }
            return new b(wrap.array(), 4, 1);
        }

        public static b c(d dVar, ByteOrder byteOrder) {
            d[] dVarArr = {dVar};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.f2303p[5] * 1]);
            wrap.order(byteOrder);
            for (int i7 = 0; i7 < 1; i7++) {
                d dVar2 = dVarArr[i7];
                wrap.putInt((int) dVar2.f2334a);
                wrap.putInt((int) dVar2.f2335b);
            }
            return new b(wrap.array(), 5, 1);
        }

        public static b d(int i7, ByteOrder byteOrder) {
            int[] iArr = {i7};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.f2303p[3] * 1]);
            wrap.order(byteOrder);
            for (int i8 = 0; i8 < 1; i8++) {
                wrap.putShort((short) iArr[i8]);
            }
            return new b(wrap.array(), 3, 1);
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
                } else if (h7 instanceof d[]) {
                    d[] dVarArr = (d[]) h7;
                    if (dVarArr.length == 1) {
                        d dVar = dVarArr[0];
                        return dVar.f2334a / dVar.f2335b;
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
            } else if (h7 instanceof d[]) {
                d[] dVarArr = (d[]) h7;
                while (i7 < dVarArr.length) {
                    sb.append(dVarArr[i7].f2334a);
                    sb.append('/');
                    sb.append(dVarArr[i7].f2335b);
                    i7++;
                    if (i7 != dVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else {
                return null;
            }
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x01a3: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:346:0x01a3 */
        /* JADX WARN: Removed duplicated region for block: B:372:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r13v17, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v19, types: [long[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v21, types: [b.a$d[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v23, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v25, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v27, types: [b.a$d[], java.io.Serializable] */
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
            throw new UnsupportedOperationException("Method not decompiled: b.a.b.h(java.nio.ByteOrder):java.io.Serializable");
        }

        public final String toString() {
            StringBuilder d7 = h.d("(");
            d7.append(a.f2302o[this.f2327a]);
            d7.append(", data length:");
            d7.append(this.f2329c.length);
            d7.append(")");
            return d7.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        public final int f2330a;

        /* renamed from: b */
        public final String f2331b;

        /* renamed from: c */
        public final int f2332c;

        /* renamed from: d */
        public final int f2333d;

        public c(String str, int i7) {
            this.f2331b = str;
            this.f2330a = i7;
            this.f2332c = 3;
            this.f2333d = 4;
        }

        public c(String str, int i7, int i8) {
            this.f2331b = str;
            this.f2330a = i7;
            this.f2332c = i8;
            this.f2333d = -1;
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a */
        public final long f2334a;

        /* renamed from: b */
        public final long f2335b;

        public d(long j7, long j8) {
            if (j8 == 0) {
                this.f2334a = 0L;
                this.f2335b = 1L;
                return;
            }
            this.f2334a = j7;
            this.f2335b = j8;
        }

        public final String toString() {
            return this.f2334a + "/" + this.f2335b;
        }
    }

    static {
        c[] cVarArr;
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        f2298j = new int[]{8, 8, 8};
        f2299k = new int[]{8};
        f2300l = new byte[]{-1, -40, -1};
        m = new byte[]{79, 76, 89, 77, 80, 0};
        f2301n = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        f2302o = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
        f2303p = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        f2304q = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        c[] cVarArr2 = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ImageWidth", 256), new c("ImageLength", 257), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", SubsamplingScaleImageView.ORIENTATION_270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278), new c("StripByteCounts", 279), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7)};
        c[] cVarArr3 = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962), new c("PixelYDimension", 40963), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720)};
        c[] cVarArr4 = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
        c[] cVarArr5 = {new c("InteroperabilityIndex", 1, 2)};
        c[] cVarArr6 = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ThumbnailImageWidth", 256), new c("ThumbnailImageLength", 257), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", SubsamplingScaleImageView.ORIENTATION_270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278), new c("StripByteCounts", 279), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720)};
        f2305r = new c("StripOffsets", 273, 3);
        s = new c[][]{cVarArr2, cVarArr3, cVarArr4, cVarArr5, cVarArr6, cVarArr2, new c[]{new c("ThumbnailImage", 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)}, new c[]{new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)}, new c[]{new c("AspectFrame", 4371, 3)}, new c[]{new c("ColorSpace", 55, 3)}};
        f2306t = new c[]{new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
        f2307u = new HashMap[10];
        f2308v = new HashMap[10];
        f2309w = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f2310x = new HashMap<>();
        Charset forName = Charset.forName("US-ASCII");
        f2311y = forName;
        f2312z = "Exif\u0000\u0000".getBytes(forName);
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").setTimeZone(TimeZone.getTimeZone("UTC"));
        int i7 = 0;
        while (true) {
            c[][] cVarArr7 = s;
            if (i7 >= cVarArr7.length) {
                HashMap<Integer, Integer> hashMap = f2310x;
                c[] cVarArr8 = f2306t;
                hashMap.put(Integer.valueOf(cVarArr8[0].f2330a), 5);
                hashMap.put(Integer.valueOf(cVarArr8[1].f2330a), 1);
                hashMap.put(Integer.valueOf(cVarArr8[2].f2330a), 2);
                hashMap.put(Integer.valueOf(cVarArr8[3].f2330a), 3);
                hashMap.put(Integer.valueOf(cVarArr8[4].f2330a), 7);
                hashMap.put(Integer.valueOf(cVarArr8[5].f2330a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
            f2307u[i7] = new HashMap<>();
            f2308v[i7] = new HashMap<>();
            for (c cVar : cVarArr7[i7]) {
                f2307u[i7].put(Integer.valueOf(cVar.f2330a), cVar);
                f2308v[i7].put(cVar.f2331b, cVar);
            }
            i7++;
        }
    }

    public a(String str) {
        FileInputStream fileInputStream;
        if (str == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }
        FileInputStream fileInputStream2 = null;
        this.f2313a = str;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            m(fileInputStream);
            try {
                fileInputStream.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (RuntimeException e7) {
                    throw e7;
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    public static long[] b(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i7 = 0; i7 < iArr.length; i7++) {
            jArr[i7] = iArr[i7];
        }
        return jArr;
    }

    public static ByteOrder o(C0025a c0025a) {
        short readShort = c0025a.readShort();
        if (readShort != 18761) {
            if (readShort == 19789) {
                return ByteOrder.BIG_ENDIAN;
            }
            StringBuilder d7 = h.d("Invalid byte order: ");
            d7.append(Integer.toHexString(readShort));
            throw new IOException(d7.toString());
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    public final void a() {
        String c7 = c("DateTimeOriginal");
        if (c7 != null && c("DateTime") == null) {
            this.f2315c[0].put("DateTime", b.a(c7));
        }
        if (c("ImageWidth") == null) {
            this.f2315c[0].put("ImageWidth", b.b(0L, this.f2316d));
        }
        if (c("ImageLength") == null) {
            this.f2315c[0].put("ImageLength", b.b(0L, this.f2316d));
        }
        if (c("Orientation") == null) {
            this.f2315c[0].put("Orientation", b.b(0L, this.f2316d));
        }
        if (c("LightSource") == null) {
            this.f2315c[1].put("LightSource", b.b(0L, this.f2316d));
        }
    }

    public final String c(String str) {
        String sb;
        b d7 = d(str);
        if (d7 != null) {
            if (!f2309w.contains(str)) {
                return d7.g(this.f2316d);
            }
            if (str.equals("GPSTimeStamp")) {
                int i7 = d7.f2327a;
                if (i7 == 5 || i7 == 10) {
                    d[] dVarArr = (d[]) d7.h(this.f2316d);
                    if (dVarArr != null && dVarArr.length == 3) {
                        d dVar = dVarArr[0];
                        d dVar2 = dVarArr[1];
                        d dVar3 = dVarArr[2];
                        return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) dVar.f2334a) / ((float) dVar.f2335b))), Integer.valueOf((int) (((float) dVar2.f2334a) / ((float) dVar2.f2335b))), Integer.valueOf((int) (((float) dVar3.f2334a) / ((float) dVar3.f2335b))));
                    }
                    StringBuilder d8 = h.d("Invalid GPS Timestamp array. array=");
                    d8.append(Arrays.toString(dVarArr));
                    sb = d8.toString();
                } else {
                    StringBuilder d9 = h.d("GPS Timestamp format is not rational. format=");
                    d9.append(d7.f2327a);
                    sb = d9.toString();
                }
                Log.w("ExifInterface", sb);
                return null;
            }
            try {
                return Double.toString(d7.e(this.f2316d));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final b d(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i7 = 0; i7 < s.length; i7++) {
            b bVar = this.f2315c[i7].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x011a, code lost:
        r10.f2324g = r9.f2316d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x011e, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0055 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(b.a.C0025a r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.e(b.a$a, int, int):void");
    }

    public final int f(BufferedInputStream bufferedInputStream) {
        boolean z6;
        boolean z7;
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        int i7 = 0;
        while (true) {
            byte[] bArr2 = f2300l;
            if (i7 >= bArr2.length) {
                z6 = true;
                break;
            } else if (bArr[i7] != bArr2[i7]) {
                z6 = false;
                break;
            } else {
                i7++;
            }
        }
        if (z6) {
            return 4;
        }
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        int i8 = 0;
        while (true) {
            if (i8 >= bytes.length) {
                z7 = true;
                break;
            } else if (bArr[i8] != bytes[i8]) {
                z7 = false;
                break;
            } else {
                i8++;
            }
        }
        if (z7) {
            return 9;
        }
        C0025a c0025a = new C0025a(bArr);
        ByteOrder o6 = o(c0025a);
        this.f2316d = o6;
        c0025a.f2324g = o6;
        short readShort = c0025a.readShort();
        c0025a.close();
        if (readShort == 20306 || readShort == 21330) {
            return 7;
        }
        C0025a c0025a2 = new C0025a(bArr);
        ByteOrder o7 = o(c0025a2);
        this.f2316d = o7;
        c0025a2.f2324g = o7;
        short readShort2 = c0025a2.readShort();
        c0025a2.close();
        return readShort2 == 85 ? 10 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(b.a.C0025a r6) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.g(b.a$a):void");
    }

    public final void h(C0025a c0025a) {
        c0025a.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        c0025a.read(bArr);
        c0025a.skipBytes(4);
        c0025a.read(bArr2);
        int i7 = ByteBuffer.wrap(bArr).getInt();
        int i8 = ByteBuffer.wrap(bArr2).getInt();
        e(c0025a, i7, 5);
        c0025a.b(i8);
        c0025a.f2324g = ByteOrder.BIG_ENDIAN;
        int readInt = c0025a.readInt();
        for (int i9 = 0; i9 < readInt; i9++) {
            int readUnsignedShort = c0025a.readUnsignedShort();
            int readUnsignedShort2 = c0025a.readUnsignedShort();
            if (readUnsignedShort == f2305r.f2330a) {
                short readShort = c0025a.readShort();
                short readShort2 = c0025a.readShort();
                b d7 = b.d(readShort, this.f2316d);
                b d8 = b.d(readShort2, this.f2316d);
                this.f2315c[0].put("ImageLength", d7);
                this.f2315c[0].put("ImageWidth", d8);
                return;
            }
            c0025a.skipBytes(readUnsignedShort2);
        }
    }

    public final void i(C0025a c0025a) {
        b bVar;
        n(c0025a, c0025a.available());
        p(c0025a, 0);
        s(c0025a, 0);
        s(c0025a, 5);
        s(c0025a, 4);
        r(0, 5);
        r(0, 4);
        r(5, 4);
        b bVar2 = this.f2315c[1].get("PixelXDimension");
        b bVar3 = this.f2315c[1].get("PixelYDimension");
        if (bVar2 != null && bVar3 != null) {
            this.f2315c[0].put("ImageWidth", bVar2);
            this.f2315c[0].put("ImageLength", bVar3);
        }
        if (this.f2315c[4].isEmpty() && l(this.f2315c[5])) {
            HashMap<String, b>[] hashMapArr = this.f2315c;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!l(this.f2315c[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        if (this.f2314b != 8 || (bVar = this.f2315c[1].get("MakerNote")) == null) {
            return;
        }
        C0025a c0025a2 = new C0025a(bVar.f2329c);
        c0025a2.f2324g = this.f2316d;
        c0025a2.b(6L);
        p(c0025a2, 9);
        b bVar4 = this.f2315c[9].get("ColorSpace");
        if (bVar4 != null) {
            this.f2315c[1].put("ColorSpace", bVar4);
        }
    }

    public final void j(C0025a c0025a) {
        i(c0025a);
        if (this.f2315c[0].get("JpgFromRaw") != null) {
            e(c0025a, this.f2320i, 5);
        }
        b bVar = this.f2315c[0].get("ISO");
        b bVar2 = this.f2315c[1].get("PhotographicSensitivity");
        if (bVar == null || bVar2 != null) {
            return;
        }
        this.f2315c[1].put("PhotographicSensitivity", bVar);
    }

    public final void k(C0025a c0025a, HashMap hashMap) {
        int i7;
        b bVar = (b) hashMap.get("JPEGInterchangeFormat");
        b bVar2 = (b) hashMap.get("JPEGInterchangeFormatLength");
        if (bVar == null || bVar2 == null) {
            return;
        }
        int f7 = bVar.f(this.f2316d);
        int min = Math.min(bVar2.f(this.f2316d), c0025a.available() - f7);
        int i8 = this.f2314b;
        if (i8 != 4 && i8 != 9 && i8 != 10) {
            if (i8 == 7) {
                i7 = this.f2317f;
            }
            if (f7 > 0 || min <= 0 || this.f2313a != null) {
                return;
            }
            c0025a.b(f7);
            c0025a.readFully(new byte[min]);
            return;
        }
        i7 = this.e;
        f7 += i7;
        if (f7 > 0) {
        }
    }

    public final boolean l(HashMap hashMap) {
        b bVar = (b) hashMap.get("ImageLength");
        b bVar2 = (b) hashMap.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.f(this.f2316d) <= 512 && bVar2.f(this.f2316d) <= 512;
    }

    public final void m(FileInputStream fileInputStream) {
        for (int i7 = 0; i7 < s.length; i7++) {
            try {
                this.f2315c[i7] = new HashMap<>();
            } catch (IOException unused) {
            } catch (Throwable th) {
                a();
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 5000);
        this.f2314b = f(bufferedInputStream);
        C0025a c0025a = new C0025a(bufferedInputStream);
        switch (this.f2314b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
            case 6:
            case 8:
            case ErrorCode.PACKET_ALLOC_CODE /* 11 */:
                i(c0025a);
                break;
            case 4:
                e(c0025a, 0, 0);
                break;
            case 7:
                g(c0025a);
                break;
            case 9:
                h(c0025a);
                break;
            case ErrorCode.FRAME_ALLOC_CODE /* 10 */:
                j(c0025a);
                break;
        }
        q(c0025a);
        a();
    }

    public final void n(C0025a c0025a, int i7) {
        ByteOrder o6 = o(c0025a);
        this.f2316d = o6;
        c0025a.f2324g = o6;
        int readUnsignedShort = c0025a.readUnsignedShort();
        int i8 = this.f2314b;
        if (i8 != 7 && i8 != 10 && readUnsignedShort != 42) {
            StringBuilder d7 = h.d("Invalid start code: ");
            d7.append(Integer.toHexString(readUnsignedShort));
            throw new IOException(d7.toString());
        }
        int readInt = c0025a.readInt();
        if (readInt < 8 || readInt >= i7) {
            throw new IOException(s0.g("Invalid first Ifd offset: ", readInt));
        }
        int i9 = readInt - 8;
        if (i9 > 0 && c0025a.skipBytes(i9) != i9) {
            throw new IOException(s0.g("Couldn't jump to first Ifd: ", i9));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:214:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void p(b.a.C0025a r25, int r26) {
        /*
            Method dump skipped, instructions count: 718
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.p(b.a$a, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0059, code lost:
        if (java.util.Arrays.equals(r1, b.a.f2299k) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0061, code lost:
        if (java.util.Arrays.equals(r1, r5) != false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q(b.a.C0025a r12) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.q(b.a$a):void");
    }

    public final void r(int i7, int i8) {
        if (this.f2315c[i7].isEmpty() || this.f2315c[i8].isEmpty()) {
            return;
        }
        b bVar = this.f2315c[i7].get("ImageLength");
        b bVar2 = this.f2315c[i7].get("ImageWidth");
        b bVar3 = this.f2315c[i8].get("ImageLength");
        b bVar4 = this.f2315c[i8].get("ImageWidth");
        if (bVar == null || bVar2 == null || bVar3 == null || bVar4 == null) {
            return;
        }
        int f7 = bVar.f(this.f2316d);
        int f8 = bVar2.f(this.f2316d);
        int f9 = bVar3.f(this.f2316d);
        int f10 = bVar4.f(this.f2316d);
        if (f7 >= f9 || f8 >= f10) {
            return;
        }
        HashMap<String, b>[] hashMapArr = this.f2315c;
        HashMap<String, b> hashMap = hashMapArr[i7];
        hashMapArr[i7] = hashMapArr[i8];
        hashMapArr[i8] = hashMap;
    }

    public final void s(C0025a c0025a, int i7) {
        b bVar;
        StringBuilder d7;
        String arrays;
        b d8;
        b d9;
        b bVar2 = this.f2315c[i7].get("DefaultCropSize");
        b bVar3 = this.f2315c[i7].get("SensorTopBorder");
        b bVar4 = this.f2315c[i7].get("SensorLeftBorder");
        b bVar5 = this.f2315c[i7].get("SensorBottomBorder");
        b bVar6 = this.f2315c[i7].get("SensorRightBorder");
        if (bVar2 == null) {
            if (bVar3 == null || bVar4 == null || bVar5 == null || bVar6 == null) {
                b bVar7 = this.f2315c[i7].get("ImageLength");
                b bVar8 = this.f2315c[i7].get("ImageWidth");
                if ((bVar7 == null || bVar8 == null) && (bVar = this.f2315c[i7].get("JPEGInterchangeFormat")) != null) {
                    e(c0025a, bVar.f(this.f2316d), i7);
                    return;
                }
                return;
            }
            int f7 = bVar3.f(this.f2316d);
            int f8 = bVar5.f(this.f2316d);
            int f9 = bVar6.f(this.f2316d);
            int f10 = bVar4.f(this.f2316d);
            if (f8 <= f7 || f9 <= f10) {
                return;
            }
            b d10 = b.d(f8 - f7, this.f2316d);
            b d11 = b.d(f9 - f10, this.f2316d);
            this.f2315c[i7].put("ImageLength", d10);
            this.f2315c[i7].put("ImageWidth", d11);
        } else if (bVar2.f2327a == 5) {
            d[] dVarArr = (d[]) bVar2.h(this.f2316d);
            if (dVarArr == null || dVarArr.length != 2) {
                d7 = h.d("Invalid crop size values. cropSize=");
                arrays = Arrays.toString(dVarArr);
                d7.append(arrays);
                Log.w("ExifInterface", d7.toString());
                return;
            }
            d8 = b.c(dVarArr[0], this.f2316d);
            d9 = b.c(dVarArr[1], this.f2316d);
            this.f2315c[i7].put("ImageWidth", d8);
            this.f2315c[i7].put("ImageLength", d9);
        } else {
            int[] iArr = (int[]) bVar2.h(this.f2316d);
            if (iArr == null || iArr.length != 2) {
                d7 = h.d("Invalid crop size values. cropSize=");
                arrays = Arrays.toString(iArr);
                d7.append(arrays);
                Log.w("ExifInterface", d7.toString());
                return;
            }
            d8 = b.d(iArr[0], this.f2316d);
            d9 = b.d(iArr[1], this.f2316d);
            this.f2315c[i7].put("ImageWidth", d8);
            this.f2315c[i7].put("ImageLength", d9);
        }
    }
}
