package i6;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class g implements Serializable, Comparable<g> {

    /* renamed from: i */
    public static final char[] f4499i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: j */
    public static final g f4500j = d(new byte[0]);

    /* renamed from: f */
    public final byte[] f4501f;

    /* renamed from: g */
    public transient int f4502g;

    /* renamed from: h */
    public transient String f4503h;

    public g(byte[] bArr) {
        this.f4501f = bArr;
    }

    public static g b(String str) {
        if (str != null) {
            g gVar = new g(str.getBytes(x.f4541a));
            gVar.f4503h = str;
            return gVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static g d(byte... bArr) {
        if (bArr != null) {
            return new g((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public final String a() {
        byte[] bArr = this.f4501f;
        byte[] bArr2 = a0.e.f40g0;
        byte[] bArr3 = new byte[((bArr.length + 2) * 4) / 3];
        int length = bArr.length - (bArr.length % 3);
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8 += 3) {
            int i9 = i7 + 1;
            bArr3[i7] = bArr2[(bArr[i8] & 255) >> 2];
            int i10 = i9 + 1;
            int i11 = i8 + 1;
            bArr3[i9] = bArr2[((bArr[i8] & 3) << 4) | ((bArr[i11] & 255) >> 4)];
            int i12 = i10 + 1;
            int i13 = i8 + 2;
            bArr3[i10] = bArr2[((bArr[i11] & 15) << 2) | ((bArr[i13] & 255) >> 6)];
            i7 = i12 + 1;
            bArr3[i12] = bArr2[bArr[i13] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i14 = i7 + 1;
            bArr3[i7] = bArr2[(bArr[length] & 255) >> 2];
            int i15 = i14 + 1;
            bArr3[i14] = bArr2[(bArr[length] & 3) << 4];
            int i16 = i15 + 1;
            bArr3[i15] = 61;
            i7 = i16 + 1;
            bArr3[i16] = 61;
        } else if (length2 == 2) {
            int i17 = i7 + 1;
            bArr3[i7] = bArr2[(bArr[length] & 255) >> 2];
            int i18 = i17 + 1;
            int i19 = length + 1;
            bArr3[i17] = bArr2[((bArr[i19] & 255) >> 4) | ((bArr[length] & 3) << 4)];
            int i20 = i18 + 1;
            bArr3[i18] = bArr2[(bArr[i19] & 15) << 2];
            i7 = i20 + 1;
            bArr3[i20] = 61;
        }
        try {
            return new String(bArr3, 0, i7, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public final String c() {
        byte[] bArr = this.f4501f;
        char[] cArr = new char[bArr.length * 2];
        int i7 = 0;
        for (byte b2 : bArr) {
            int i8 = i7 + 1;
            char[] cArr2 = f4499i;
            cArr[i7] = cArr2[(b2 >> 4) & 15];
            i7 = i8 + 1;
            cArr[i8] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0023, code lost:
        if (r7 < r8) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x002c, code lost:
        if (r0 < r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x002f, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
        return 1;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int compareTo(i6.g r10) {
        /*
            r9 = this;
            i6.g r10 = (i6.g) r10
            byte[] r0 = r9.f4501f
            int r0 = r0.length
            byte[] r1 = r10.f4501f
            int r1 = r1.length
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        Le:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L29
            byte[] r7 = r9.f4501f
            r7 = r7[r4]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte[] r8 = r10.f4501f
            r8 = r8[r4]
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L23
            int r4 = r4 + 1
            goto Le
        L23:
            if (r7 >= r8) goto L27
        L25:
            r3 = r5
            goto L2f
        L27:
            r3 = r6
            goto L2f
        L29:
            if (r0 != r1) goto L2c
            goto L2f
        L2c:
            if (r0 >= r1) goto L27
            goto L25
        L2f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.g.compareTo(java.lang.Object):int");
    }

    public final g e() {
        int i7 = 0;
        while (true) {
            byte[] bArr = this.f4501f;
            if (i7 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i7];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i7] = (byte) (b2 + 32);
                for (int i8 = i7 + 1; i8 < bArr2.length; i8++) {
                    byte b7 = bArr2[i8];
                    if (b7 >= 65 && b7 <= 90) {
                        bArr2[i8] = (byte) (b7 + 32);
                    }
                }
                return new g(bArr2);
            }
            i7++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof i6.g
            r2 = 0
            if (r1 == 0) goto L37
            i6.g r7 = (i6.g) r7
            byte[] r7 = r7.f4501f
            int r1 = r7.length
            byte[] r6 = r6.f4501f
            int r3 = r6.length
            if (r1 != r3) goto L37
            int r1 = r6.length
            int r3 = r7.length
            int r3 = r3 - r1
            if (r3 < 0) goto L33
            int r3 = r6.length
            int r3 = r3 - r1
            if (r3 < 0) goto L33
            java.nio.charset.Charset r3 = i6.x.f4541a
            r3 = r2
        L1f:
            if (r3 >= r1) goto L2e
            int r4 = r3 + 0
            r5 = r7[r4]
            r4 = r6[r4]
            if (r5 == r4) goto L2b
            r6 = r2
            goto L2f
        L2b:
            int r3 = r3 + 1
            goto L1f
        L2e:
            r6 = r0
        L2f:
            if (r6 == 0) goto L33
            r6 = r0
            goto L34
        L33:
            r6 = r2
        L34:
            if (r6 == 0) goto L37
            goto L38
        L37:
            r0 = r2
        L38:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.g.equals(java.lang.Object):boolean");
    }

    public final String f() {
        String str = this.f4503h;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f4501f, x.f4541a);
        this.f4503h = str2;
        return str2;
    }

    public final int hashCode() {
        int i7 = this.f4502g;
        if (i7 != 0) {
            return i7;
        }
        int hashCode = Arrays.hashCode(this.f4501f);
        this.f4502g = hashCode;
        return hashCode;
    }

    public final String toString() {
        byte[] bArr = this.f4501f;
        if (bArr.length == 0) {
            return "ByteString[size=0]";
        }
        if (bArr.length <= 16) {
            return String.format("ByteString[size=%s data=%s]", Integer.valueOf(bArr.length), c());
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr.length);
        try {
            objArr[1] = d(MessageDigest.getInstance("MD5").digest(this.f4501f)).c();
            return String.format("ByteString[size=%s md5=%s]", objArr);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }
}
