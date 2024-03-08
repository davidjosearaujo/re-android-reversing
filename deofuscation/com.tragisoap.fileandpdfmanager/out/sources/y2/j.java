package y2;

import android.util.Log;
import androidx.activity.h;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j implements ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f6611a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f6612b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f6613a;

        public a(ByteBuffer byteBuffer) {
            this.f6613a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // y2.j.c
        public final int a(byte[] bArr, int i7) {
            int min = Math.min(i7, this.f6613a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f6613a.get(bArr, 0, min);
            return min;
        }

        @Override // y2.j.c
        public final short b() {
            if (this.f6613a.remaining() >= 1) {
                return (short) (this.f6613a.get() & 255);
            }
            throw new c.a();
        }

        @Override // y2.j.c
        public final int c() {
            return b() | (b() << 8);
        }

        @Override // y2.j.c
        public final long skip(long j7) {
            int min = (int) Math.min((long) this.f6613a.remaining(), j7);
            ByteBuffer byteBuffer = this.f6613a;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f6614a;

        public b(byte[] bArr, int i7) {
            this.f6614a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i7);
        }

        public final short a(int i7) {
            if (this.f6614a.remaining() - i7 >= 2) {
                return this.f6614a.getShort(i7);
            }
            return -1;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface c {

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static final class a extends IOException {
            public a() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a(byte[] bArr, int i7);

        short b();

        int c();

        long skip(long j7);
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        public final InputStream f6615a;

        public d(InputStream inputStream) {
            this.f6615a = inputStream;
        }

        @Override // y2.j.c
        public final int a(byte[] bArr, int i7) {
            int i8 = 0;
            int i9 = 0;
            while (i8 < i7 && (i9 = this.f6615a.read(bArr, i8, i7 - i8)) != -1) {
                i8 += i9;
            }
            if (i8 != 0 || i9 != -1) {
                return i8;
            }
            throw new c.a();
        }

        @Override // y2.j.c
        public final short b() {
            int read = this.f6615a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new c.a();
        }

        @Override // y2.j.c
        public final int c() {
            return b() | (b() << 8);
        }

        @Override // y2.j.c
        public final long skip(long j7) {
            if (j7 < 0) {
                return 0;
            }
            long j8 = j7;
            while (j8 > 0) {
                long skip = this.f6615a.skip(j8);
                if (skip <= 0) {
                    if (this.f6615a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j8 -= skip;
            }
            return j7 - j8;
        }
    }

    public static int e(c cVar, s2.b bVar) {
        try {
            int c7 = cVar.c();
            if (!((c7 & 65496) == 65496 || c7 == 19789 || c7 == 18761)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + c7);
                }
                return -1;
            }
            int g2 = g(cVar);
            if (g2 == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) bVar.c(g2, byte[].class);
            int h7 = h(cVar, bArr, g2);
            bVar.put(bArr);
            return h7;
        } catch (c.a unused) {
            return -1;
        }
    }

    public static ImageHeaderParser.ImageType f(c cVar) {
        try {
            int c7 = cVar.c();
            if (c7 == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int b2 = (c7 << 8) | cVar.b();
            if (b2 == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int b7 = (b2 << 8) | cVar.b();
            if (b7 == -1991225785) {
                cVar.skip(21);
                try {
                    return cVar.b() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (c.a unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            } else if (b7 != 1380533830) {
                boolean z6 = false;
                if (((cVar.c() << 16) | cVar.c()) == 1718909296) {
                    int c8 = (cVar.c() << 16) | cVar.c();
                    if (c8 != 1635150182 && c8 != 1635150195) {
                        cVar.skip(4);
                        int i7 = b7 - 16;
                        if (i7 % 4 == 0) {
                            int i8 = 0;
                            while (i8 < 5 && i7 > 0) {
                                int c9 = (cVar.c() << 16) | cVar.c();
                                if (c9 != 1635150182 && c9 != 1635150195) {
                                    i8++;
                                    i7 -= 4;
                                }
                            }
                        }
                    }
                    z6 = true;
                    break;
                }
                return z6 ? ImageHeaderParser.ImageType.AVIF : ImageHeaderParser.ImageType.UNKNOWN;
            } else {
                cVar.skip(4);
                if (((cVar.c() << 16) | cVar.c()) != 1464156752) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int c10 = (cVar.c() << 16) | cVar.c();
                if ((c10 & -256) != 1448097792) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int i9 = c10 & 255;
                if (i9 == 88) {
                    cVar.skip(4);
                    short b8 = cVar.b();
                    return (b8 & 2) != 0 ? ImageHeaderParser.ImageType.ANIMATED_WEBP : (b8 & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                } else if (i9 != 76) {
                    return ImageHeaderParser.ImageType.WEBP;
                } else {
                    cVar.skip(4);
                    return (cVar.b() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                }
            }
        } catch (c.a unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    public static int g(c cVar) {
        short b2;
        int c7;
        long j7;
        long skip;
        do {
            short b7 = cVar.b();
            if (b7 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) b7));
                }
                return -1;
            }
            b2 = cVar.b();
            if (b2 == 218) {
                return -1;
            }
            if (b2 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            c7 = cVar.c() - 2;
            if (b2 == 225) {
                return c7;
            }
            j7 = (long) c7;
            skip = cVar.skip(j7);
        } while (skip == j7);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) b2) + ", wanted to skip: " + c7 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    public static int h(c cVar, byte[] bArr, int i7) {
        ByteOrder byteOrder;
        String str;
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        int a7 = cVar.a(bArr, i7);
        if (a7 != i7) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i7 + ", actually read: " + a7);
            }
            return -1;
        }
        boolean z6 = bArr != null && i7 > f6611a.length;
        if (z6) {
            int i8 = 0;
            while (true) {
                byte[] bArr2 = f6611a;
                if (i8 >= bArr2.length) {
                    break;
                } else if (bArr[i8] != bArr2[i8]) {
                    z6 = false;
                    break;
                } else {
                    i8++;
                }
            }
        }
        if (z6) {
            b bVar = new b(bArr, i7);
            short a8 = bVar.a(6);
            if (a8 != 18761) {
                if (a8 != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) a8));
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            }
            bVar.f6614a.order(byteOrder);
            int i9 = (bVar.f6614a.remaining() - 10 >= 4 ? bVar.f6614a.getInt(10) : -1) + 6;
            short a9 = bVar.a(i9);
            for (int i10 = 0; i10 < a9; i10++) {
                int i11 = (i10 * 12) + i9 + 2;
                short a10 = bVar.a(i11);
                if (a10 == 274) {
                    short a11 = bVar.a(i11 + 2);
                    if (a11 >= 1 && a11 <= 12) {
                        int i12 = i11 + 4;
                        int i13 = bVar.f6614a.remaining() - i12 >= 4 ? bVar.f6614a.getInt(i12) : -1;
                        if (i13 >= 0) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Got tagIndex=" + i10 + " tagType=" + ((int) a10) + " formatCode=" + ((int) a11) + " componentCount=" + i13);
                            }
                            int i14 = i13 + f6612b[a11];
                            if (i14 <= 4) {
                                int i15 = i11 + 8;
                                if (i15 < 0 || i15 > bVar.f6614a.remaining()) {
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("Illegal tagValueOffset=");
                                        sb3.append(i15);
                                        sb3.append(" tagType=");
                                        sb = sb3;
                                        sb.append((int) a10);
                                    }
                                } else if (i14 >= 0 && i14 + i15 <= bVar.f6614a.remaining()) {
                                    return bVar.a(i15);
                                } else {
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        sb = h.d("Illegal number of bytes for TI tag data tagType=");
                                        sb.append((int) a10);
                                    }
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                sb2 = new StringBuilder();
                                str2 = "Got byte count > 4, not orientation, continuing, formatCode=";
                                sb2.append(str2);
                                sb2.append((int) a11);
                                sb = sb2;
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            str = "Negative tiff component count";
                            Log.d("DfltImageHeaderParser", str);
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        sb2 = new StringBuilder();
                        str2 = "Got invalid format code = ";
                        sb2.append(str2);
                        sb2.append((int) a11);
                        sb = sb2;
                    }
                    str = sb.toString();
                    Log.d("DfltImageHeaderParser", str);
                }
            }
            return -1;
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        q2.a.i(byteBuffer);
        return f(new a(byteBuffer));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final int b(InputStream inputStream, s2.b bVar) {
        q2.a.i(inputStream);
        d dVar = new d(inputStream);
        q2.a.i(bVar);
        return e(dVar, bVar);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final int c(ByteBuffer byteBuffer, s2.b bVar) {
        q2.a.i(byteBuffer);
        a aVar = new a(byteBuffer);
        q2.a.i(bVar);
        return e(aVar, bVar);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType d(InputStream inputStream) {
        q2.a.i(inputStream);
        return f(new d(inputStream));
    }
}
