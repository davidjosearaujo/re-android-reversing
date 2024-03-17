package cn.jiguang.aw;

import com.alibaba.android.arouter.utils.Consts;
import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class g implements Serializable, Comparable {
    public static final g a;
    public static final g b;
    private static final byte[] f = {0};
    private static final byte[] g = {1, 42};
    private static final DecimalFormat h;
    private static final byte[] i;
    private static final g j;
    private byte[] c;
    private long d;
    private int e;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        h = decimalFormat;
        i = new byte[256];
        decimalFormat.setMinimumIntegerDigits(3);
        int i2 = 0;
        while (true) {
            byte[] bArr = i;
            if (i2 >= bArr.length) {
                g gVar = new g();
                a = gVar;
                gVar.b(f, 0, 1);
                g gVar2 = new g();
                b = gVar2;
                gVar2.c = new byte[0];
                g gVar3 = new g();
                j = gVar3;
                gVar3.b(g, 0, 1);
                return;
            }
            if (i2 < 65 || i2 > 90) {
                bArr[i2] = (byte) i2;
            } else {
                bArr[i2] = (byte) ((i2 - 65) + 97);
            }
            i2++;
        }
    }

    private g() {
    }

    public g(b bVar) {
        byte[] bArr = new byte[64];
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            int f2 = bVar.f();
            int i2 = f2 & 192;
            if (i2 != 0) {
                if (i2 != 192) {
                    throw new IOException("bad label type");
                }
                int f3 = bVar.f() + ((f2 & (-193)) << 8);
                if (f3 >= bVar.a() - 2) {
                    throw new IOException("bad compression");
                }
                if (!z2) {
                    bVar.d();
                    z2 = true;
                }
                bVar.b(f3);
            } else if (d() >= 128) {
                throw new IOException("too many labels");
            } else {
                if (f2 == 0) {
                    a(f, 0, 1);
                    z = true;
                } else {
                    bArr[0] = (byte) f2;
                    bVar.a(bArr, 1, f2);
                    a(bArr, 0, 1);
                }
            }
        }
        if (z2) {
            bVar.e();
        }
    }

    public g(g gVar, int i2) {
        int b2 = gVar.b();
        if (i2 > b2) {
            throw new IllegalArgumentException("attempted to remove too many labels");
        }
        this.c = gVar.c;
        int i3 = b2 - i2;
        b(i3);
        for (int i4 = 0; i4 < 7 && i4 < i3; i4++) {
            a(i4, gVar.a(i4 + i2));
        }
    }

    public g(String str, g gVar) {
        int i2;
        boolean z;
        int i3;
        if (str.equals("")) {
            throw a(str, "empty name");
        }
        if (str.equals("@")) {
            if (gVar == null) {
                b(b, this);
            } else {
                b(gVar, this);
            }
        } else if (str.equals(Consts.DOT)) {
            b(a, this);
        } else {
            byte[] bArr = new byte[64];
            int i4 = 0;
            boolean z2 = false;
            int i5 = -1;
            int i6 = 1;
            int i7 = 0;
            for (int i8 = 0; i8 < str.length(); i8++) {
                byte charAt = (byte) str.charAt(i8);
                if (z2) {
                    if (charAt >= 48 && charAt <= 57 && i4 < 3) {
                        i4++;
                        i7 = (i7 * 10) + (charAt - 48);
                        if (i7 > 255) {
                            throw a(str, "bad escape");
                        }
                        if (i4 < 3) {
                            continue;
                        } else {
                            charAt = (byte) i7;
                        }
                    } else if (i4 > 0 && i4 < 3) {
                        throw a(str, "bad escape");
                    }
                    if (i6 > 63) {
                        throw a(str, "label too long");
                    }
                    i3 = i6 + 1;
                    bArr[i6] = charAt;
                    i5 = i6;
                    z2 = false;
                    i6 = i3;
                } else {
                    if (charAt == 92) {
                        i4 = 0;
                        z2 = true;
                        i7 = 0;
                    } else if (charAt != 46) {
                        i5 = i5 == -1 ? i8 : i5;
                        if (i6 > 63) {
                            throw a(str, "label too long");
                        }
                        i3 = i6 + 1;
                        bArr[i6] = charAt;
                        i6 = i3;
                    } else if (i5 == -1) {
                        throw a(str, "invalid empty label");
                    } else {
                        bArr[0] = (byte) (i6 - 1);
                        a(str, bArr, 0, 1);
                        i5 = -1;
                        i6 = 1;
                    }
                }
            }
            if (i4 > 0 && i4 < 3) {
                throw a(str, "bad escape");
            }
            if (z2) {
                throw a(str, "bad escape");
            }
            if (i5 == -1) {
                z = true;
                i2 = 0;
                a(str, f, 0, 1);
            } else {
                i2 = 0;
                bArr[0] = (byte) (i6 - 1);
                a(str, bArr, 0, 1);
                z = false;
            }
            if (gVar == null || z) {
                return;
            }
            a(str, gVar.c, gVar.a(i2), gVar.d());
        }
    }

    private final int a(int i2) {
        if (i2 == 0 && d() == 0) {
            return 0;
        }
        if (i2 < 0 || i2 >= d()) {
            throw new IllegalArgumentException("label out of range");
        }
        if (i2 < 7) {
            return ((int) (this.d >>> ((7 - i2) * 8))) & JfifUtil.MARKER_FIRST_BYTE;
        }
        int a2 = a(6);
        for (int i3 = 6; i3 < i2; i3++) {
            a2 += this.c[a2] + 1;
        }
        return a2;
    }

    public static g a(g gVar, g gVar2) {
        if (gVar.a()) {
            return gVar;
        }
        g gVar3 = new g();
        b(gVar, gVar3);
        gVar3.a(gVar2.c, gVar2.a(0), gVar2.d());
        return gVar3;
    }

    public static g a(String str) {
        return a(str, (g) null);
    }

    public static g a(String str, g gVar) {
        return (!str.equals("@") || gVar == null) ? str.equals(Consts.DOT) ? a : new g(str, gVar) : gVar;
    }

    private static IOException a(String str, String str2) {
        return new IOException("'" + str + "': " + str2);
    }

    private String a(byte[] bArr, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + 1;
        int i4 = bArr[i2];
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            int i6 = bArr[i5] & 255;
            if (i6 <= 32 || i6 >= 127) {
                stringBuffer.append('\\');
                stringBuffer.append(h.format(i6));
            } else {
                if (i6 == 34 || i6 == 40 || i6 == 41 || i6 == 46 || i6 == 59 || i6 == 92 || i6 == 64 || i6 == 36) {
                    stringBuffer.append('\\');
                }
                stringBuffer.append((char) i6);
            }
        }
        return stringBuffer.toString();
    }

    private final void a(int i2, int i3) {
        if (i2 >= 7) {
            return;
        }
        int i4 = (7 - i2) * 8;
        long j2 = this.d & ((255 << i4) ^ (-1));
        this.d = j2;
        this.d = (i3 << i4) | j2;
    }

    private final void a(String str, byte[] bArr, int i2, int i3) {
        try {
            a(bArr, i2, i3);
        } catch (Exception unused) {
            throw a(str, "Name too long");
        }
    }

    private final void a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.c;
        int length = bArr2 == null ? 0 : bArr2.length - a(0);
        int i4 = i2;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = bArr[i4];
            if (i7 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i8 = i7 + 1;
            i4 += i8;
            i5 += i8;
        }
        int i9 = length + i5;
        if (i9 > 255) {
            throw new IOException();
        }
        int d = d();
        int i10 = d + i3;
        if (i10 > 128) {
            throw new IllegalStateException("too many labels");
        }
        byte[] bArr3 = new byte[i9];
        if (length != 0) {
            System.arraycopy(this.c, a(0), bArr3, 0, length);
        }
        System.arraycopy(bArr, i2, bArr3, length, i5);
        this.c = bArr3;
        for (int i11 = 0; i11 < i3; i11++) {
            a(d + i11, length);
            length += bArr3[length] + 1;
        }
        b(i10);
    }

    private final void b(int i2) {
        long j2 = this.d & (-256);
        this.d = j2;
        this.d = j2 | i2;
    }

    private static final void b(g gVar, g gVar2) {
        if (gVar.a(0) == 0) {
            gVar2.c = gVar.c;
            gVar2.d = gVar.d;
            return;
        }
        int a2 = gVar.a(0);
        int length = gVar.c.length - a2;
        int b2 = gVar.b();
        byte[] bArr = new byte[length];
        gVar2.c = bArr;
        System.arraycopy(gVar.c, a2, bArr, 0, length);
        for (int i2 = 0; i2 < b2 && i2 < 7; i2++) {
            gVar2.a(i2, gVar.a(i2) - a2);
        }
        gVar2.b(b2);
    }

    private final void b(byte[] bArr, int i2, int i3) {
        try {
            a(bArr, i2, i3);
        } catch (Exception unused) {
        }
    }

    private final boolean b(byte[] bArr, int i2) {
        int b2 = b();
        int a2 = a(0);
        int i3 = 0;
        while (i3 < b2) {
            byte[] bArr2 = this.c;
            if (bArr2[a2] != bArr[i2]) {
                return false;
            }
            int i4 = a2 + 1;
            byte b3 = bArr2[a2];
            i2++;
            if (b3 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i5 = 0;
            while (i5 < b3) {
                byte[] bArr3 = i;
                int i6 = i4 + 1;
                int i7 = i2 + 1;
                if (bArr3[this.c[i4] & 255] != bArr3[bArr[i2] & 255]) {
                    return false;
                }
                i5++;
                i2 = i7;
                i4 = i6;
            }
            i3++;
            a2 = i4;
        }
        return true;
    }

    private final int d() {
        return (int) (this.d & 255);
    }

    public String a(boolean z) {
        int b2 = b();
        if (b2 == 0) {
            return "@";
        }
        int i2 = 0;
        if (b2 == 1 && this.c[a(0)] == 0) {
            return Consts.DOT;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int a2 = a(0);
        while (true) {
            if (i2 >= b2) {
                break;
            }
            byte b3 = this.c[a2];
            if (b3 > 63) {
                throw new IllegalStateException("invalid label");
            }
            if (b3 != 0) {
                if (i2 > 0) {
                    stringBuffer.append('.');
                }
                stringBuffer.append(a(this.c, a2));
                a2 += b3 + 1;
                i2++;
            } else if (!z) {
                stringBuffer.append('.');
            }
        }
        return stringBuffer.toString();
    }

    public void a(c cVar) {
        cVar.a(c());
    }

    public void a(c cVar, a aVar) {
        int b2 = b();
        int i2 = 0;
        while (i2 < b2 - 1) {
            g gVar = i2 == 0 ? this : new g(this, i2);
            int a2 = aVar != null ? aVar.a(gVar) : -1;
            if (a2 >= 0) {
                cVar.c(49152 | a2);
                return;
            }
            if (aVar != null) {
                aVar.a(cVar.a(), gVar);
            }
            int a3 = a(i2);
            byte[] bArr = this.c;
            cVar.a(bArr, a3, bArr[a3] + 1);
            i2++;
        }
        cVar.b(0);
    }

    public void a(c cVar, a aVar, boolean z) {
        if (z) {
            a(cVar);
        } else {
            a(cVar, aVar);
        }
    }

    public boolean a() {
        int b2 = b();
        return b2 != 0 && this.c[a(b2 - 1)] == 0;
    }

    public int b() {
        return d();
    }

    public byte[] c() {
        int b2 = b();
        if (b2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[this.c.length - a(0)];
        int a2 = a(0);
        int i2 = 0;
        for (int i3 = 0; i3 < b2; i3++) {
            byte[] bArr2 = this.c;
            byte b3 = bArr2[a2];
            if (b3 > 63) {
                throw new IllegalStateException("invalid label");
            }
            bArr[i2] = bArr2[a2];
            i2++;
            a2++;
            int i4 = 0;
            while (i4 < b3) {
                bArr[i2] = i[this.c[a2] & 255];
                i4++;
                i2++;
                a2++;
            }
        }
        return bArr;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        g gVar = (g) obj;
        if (this == gVar) {
            return 0;
        }
        int b2 = b();
        int b3 = gVar.b();
        int i2 = b2 > b3 ? b3 : b2;
        for (int i3 = 1; i3 <= i2; i3++) {
            int a2 = a(b2 - i3);
            int a3 = gVar.a(b3 - i3);
            byte b4 = this.c[a2];
            byte b5 = gVar.c[a3];
            for (int i4 = 0; i4 < b4 && i4 < b5; i4++) {
                byte[] bArr = i;
                int i5 = bArr[this.c[(i4 + a2) + 1] & 255] - bArr[gVar.c[(i4 + a3) + 1] & 255];
                if (i5 != 0) {
                    return i5;
                }
            }
            if (b4 != b5) {
                return b4 - b5;
            }
        }
        return b2 - b3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (gVar.e == 0) {
            gVar.hashCode();
        }
        if (this.e == 0) {
            hashCode();
        }
        if (gVar.e == this.e && gVar.b() == b()) {
            return b(gVar.c, gVar.a(0));
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.e;
        if (i2 != 0) {
            return i2;
        }
        int i3 = 0;
        int a2 = a(0);
        while (true) {
            byte[] bArr = this.c;
            if (a2 >= bArr.length) {
                this.e = i3;
                return i3;
            }
            i3 += (i3 << 3) + i[bArr[a2] & 255];
            a2++;
        }
    }

    public String toString() {
        return a(false);
    }
}
