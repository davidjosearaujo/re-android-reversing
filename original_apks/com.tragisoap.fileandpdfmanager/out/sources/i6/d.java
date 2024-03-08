package i6;

import androidx.activity.h;
import androidx.fragment.app.s0;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d implements f, e, Cloneable {

    /* renamed from: h */
    public static final byte[] f4496h = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: f */
    public s f4497f;

    /* renamed from: g */
    public long f4498g;

    @Override // i6.v
    public final long B(d dVar, long j7) {
        if (dVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j7 >= 0) {
            long j8 = this.f4498g;
            if (j8 == 0) {
                return -1;
            }
            if (j7 > j8) {
                j7 = j8;
            }
            dVar.h(this, j7);
            return j7;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j7);
        }
    }

    public final d C(long j7) {
        if (j7 == 0) {
            z(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j7)) / 4) + 1;
        s p6 = p(numberOfTrailingZeros);
        byte[] bArr = p6.f4529a;
        int i7 = p6.f4531c;
        int i8 = i7 + numberOfTrailingZeros;
        while (true) {
            i8--;
            if (i8 >= i7) {
                bArr[i8] = f4496h[(int) (15 & j7)];
                j7 >>>= 4;
            } else {
                p6.f4531c += numberOfTrailingZeros;
                this.f4498g += (long) numberOfTrailingZeros;
                return this;
            }
        }
    }

    public final void D(int i7) {
        s p6 = p(4);
        byte[] bArr = p6.f4529a;
        int i8 = p6.f4531c;
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((i7 >>> 24) & 255);
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((i7 >>> 16) & 255);
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((i7 >>> 8) & 255);
        bArr[i11] = (byte) (i7 & 255);
        p6.f4531c = i11 + 1;
        this.f4498g += 4;
    }

    public final void E(int i7) {
        s p6 = p(2);
        byte[] bArr = p6.f4529a;
        int i8 = p6.f4531c;
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((i7 >>> 8) & 255);
        bArr[i9] = (byte) (i7 & 255);
        p6.f4531c = i9 + 1;
        this.f4498g += 2;
    }

    @Override // i6.e
    public final e F() {
        return this;
    }

    public final void G(int i7, int i8, String str) {
        char charAt;
        int i9;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i7 < 0) {
            throw new IllegalAccessError(s0.g("beginIndex < 0: ", i7));
        } else if (i8 < i7) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i8 + " < " + i7);
        } else if (i8 <= str.length()) {
            while (i7 < i8) {
                char charAt2 = str.charAt(i7);
                if (charAt2 < 128) {
                    s p6 = p(1);
                    byte[] bArr = p6.f4529a;
                    int i10 = p6.f4531c - i7;
                    int min = Math.min(i8, 2048 - i10);
                    i7++;
                    bArr[i7 + i10] = (byte) charAt2;
                    while (i7 < min && (charAt = str.charAt(i7)) < 128) {
                        i7++;
                        bArr[i7 + i10] = (byte) charAt;
                    }
                    int i11 = p6.f4531c;
                    int i12 = (i10 + i7) - i11;
                    p6.f4531c = i11 + i12;
                    this.f4498g += (long) i12;
                } else {
                    if (charAt2 < 2048) {
                        i9 = (charAt2 >> 6) | 192;
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        z((charAt2 >> '\f') | 224);
                        i9 = ((charAt2 >> 6) & 63) | 128;
                    } else {
                        int i13 = i7 + 1;
                        char charAt3 = i13 < i8 ? str.charAt(i13) : 0;
                        if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            z(63);
                            i7 = i13;
                        } else {
                            int i14 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                            z((i14 >> 18) | 240);
                            z(((i14 >> 12) & 63) | 128);
                            z(((i14 >> 6) & 63) | 128);
                            z((i14 & 63) | 128);
                            i7 += 2;
                        }
                    }
                    z(i9);
                    z((charAt2 & '?') | 128);
                    i7++;
                }
            }
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i8 + " > " + str.length());
        }
    }

    public final void J(int i7) {
        int i8;
        int i9;
        if (i7 >= 128) {
            if (i7 < 2048) {
                i8 = (i7 >> 6) | 192;
            } else {
                if (i7 < 65536) {
                    if (i7 < 55296 || i7 > 57343) {
                        i9 = (i7 >> 12) | 224;
                    } else {
                        StringBuilder d7 = h.d("Unexpected code point: ");
                        d7.append(Integer.toHexString(i7));
                        throw new IllegalArgumentException(d7.toString());
                    }
                } else if (i7 <= 1114111) {
                    z((i7 >> 18) | 240);
                    i9 = ((i7 >> 12) & 63) | 128;
                } else {
                    StringBuilder d8 = h.d("Unexpected code point: ");
                    d8.append(Integer.toHexString(i7));
                    throw new IllegalArgumentException(d8.toString());
                }
                z(i9);
                i8 = ((i7 >> 6) & 63) | 128;
            }
            z(i8);
            i7 = (i7 & 63) | 128;
        }
        z(i7);
    }

    @Override // i6.f
    public final void P(long j7) {
        if (this.f4498g < j7) {
            throw new EOFException();
        }
    }

    @Override // i6.e
    public final e Q(String str) {
        G(0, str.length(), str);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a A[EDGE_INSN: B:42:0x009a->B:38:0x009a ?: BREAK  , SYNTHETIC] */
    @Override // i6.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long T() {
        /*
            r14 = this;
            long r0 = r14.f4498g
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00a1
            r0 = 0
            r1 = r0
            r4 = r2
        L_0x000b:
            i6.s r6 = r14.f4497f
            byte[] r7 = r6.f4529a
            int r8 = r6.f4530b
            int r9 = r6.f4531c
        L_0x0013:
            if (r8 >= r9) goto L_0x0086
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x0039
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002d
            int r11 = r10 + -97
            goto L_0x0037
        L_0x002d:
            r11 = 65
            if (r10 < r11) goto L_0x006b
            r11 = 70
            if (r10 > r11) goto L_0x006b
            int r11 = r10 + -65
        L_0x0037:
            int r11 = r11 + 10
        L_0x0039:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0049
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x0049:
            i6.d r14 = new i6.d
            r14.<init>()
            r14.C(r4)
            r14.z(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Number too large: "
            java.lang.StringBuilder r1 = androidx.activity.h.d(r1)
            java.lang.String r14 = r14.m()
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            r0.<init>(r14)
            throw r0
        L_0x006b:
            if (r0 == 0) goto L_0x006f
            r1 = 1
            goto L_0x0086
        L_0x006f:
            java.lang.NumberFormatException r14 = new java.lang.NumberFormatException
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r0 = androidx.activity.h.d(r0)
            java.lang.String r1 = java.lang.Integer.toHexString(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        L_0x0086:
            if (r8 != r9) goto L_0x0092
            i6.s r7 = r6.a()
            r14.f4497f = r7
            i6.t.a(r6)
            goto L_0x0094
        L_0x0092:
            r6.f4530b = r8
        L_0x0094:
            if (r1 != 0) goto L_0x009a
            i6.s r6 = r14.f4497f
            if (r6 != 0) goto L_0x000b
        L_0x009a:
            long r1 = r14.f4498g
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.f4498g = r1
            return r4
        L_0x00a1:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "size == 0"
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.d.T():long");
    }

    @Override // i6.f, i6.e
    public final d a() {
        return this;
    }

    /* renamed from: b */
    public final d clone() {
        d dVar = new d();
        if (this.f4498g == 0) {
            return dVar;
        }
        s sVar = new s(this.f4497f);
        dVar.f4497f = sVar;
        sVar.f4534g = sVar;
        sVar.f4533f = sVar;
        s sVar2 = this.f4497f;
        while (true) {
            sVar2 = sVar2.f4533f;
            if (sVar2 != this.f4497f) {
                dVar.f4497f.f4534g.b(new s(sVar2));
            } else {
                dVar.f4498g = this.f4498g;
                return dVar;
            }
        }
    }

    @Override // i6.v
    public final w c() {
        return w.f4537d;
    }

    @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public final void d(d dVar, long j7, long j8) {
        if (dVar != null) {
            x.a(this.f4498g, j7, j8);
            if (j8 != 0) {
                dVar.f4498g += j8;
                s sVar = this.f4497f;
                while (true) {
                    long j9 = (long) (sVar.f4531c - sVar.f4530b);
                    if (j7 >= j9) {
                        j7 -= j9;
                        sVar = sVar.f4533f;
                    }
                }
                while (j8 > 0) {
                    s sVar2 = new s(sVar);
                    int i7 = (int) (((long) sVar2.f4530b) + j7);
                    sVar2.f4530b = i7;
                    sVar2.f4531c = Math.min(i7 + ((int) j8), sVar2.f4531c);
                    s sVar3 = dVar.f4497f;
                    if (sVar3 == null) {
                        sVar2.f4534g = sVar2;
                        sVar2.f4533f = sVar2;
                        dVar.f4497f = sVar2;
                    } else {
                        sVar3.f4534g.b(sVar2);
                    }
                    j8 -= (long) (sVar2.f4531c - sVar2.f4530b);
                    sVar = sVar.f4533f;
                    j7 = 0;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final byte e(long j7) {
        x.a(this.f4498g, j7, 1);
        s sVar = this.f4497f;
        while (true) {
            int i7 = sVar.f4531c;
            int i8 = sVar.f4530b;
            long j8 = (long) (i7 - i8);
            if (j7 < j8) {
                return sVar.f4529a[i8 + ((int) j7)];
            }
            j7 -= j8;
            sVar = sVar.f4533f;
        }
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        long j7 = this.f4498g;
        if (j7 != dVar.f4498g) {
            return false;
        }
        long j8 = 0;
        if (j7 == 0) {
            return true;
        }
        s sVar = this.f4497f;
        s sVar2 = dVar.f4497f;
        int i7 = sVar.f4530b;
        int i8 = sVar2.f4530b;
        while (j8 < this.f4498g) {
            long min = (long) Math.min(sVar.f4531c - i7, sVar2.f4531c - i8);
            for (int i9 = 0; ((long) i9) < min; i9++) {
                i7++;
                i8++;
                if (sVar.f4529a[i7] != sVar2.f4529a[i8]) {
                    return false;
                }
            }
            if (i7 == sVar.f4531c) {
                sVar = sVar.f4533f;
                i7 = sVar.f4530b;
            }
            if (i8 == sVar2.f4531c) {
                sVar2 = sVar2.f4533f;
                i8 = sVar2.f4530b;
            }
            j8 += min;
        }
        return true;
    }

    public final long f(byte b2, long j7) {
        if (j7 >= 0) {
            s sVar = this.f4497f;
            if (sVar == null) {
                return -1;
            }
            long j8 = j7;
            long j9 = 0;
            while (true) {
                int i7 = sVar.f4531c;
                int i8 = sVar.f4530b;
                long j10 = (long) (i7 - i8);
                if (j8 >= j10) {
                    j8 -= j10;
                } else {
                    byte[] bArr = sVar.f4529a;
                    for (int i9 = (int) (((long) i8) + j8); i9 < i7; i9++) {
                        if (bArr[i9] == b2) {
                            return (j9 + ((long) i9)) - ((long) sVar.f4530b);
                        }
                    }
                    j8 = 0;
                }
                j9 += j10;
                sVar = sVar.f4533f;
                if (sVar == this.f4497f) {
                    return -1;
                }
            }
        } else {
            throw new IllegalArgumentException("fromIndex < 0");
        }
    }

    @Override // i6.u, java.io.Flushable
    public final void flush() {
    }

    @Override // i6.e
    public final /* bridge */ /* synthetic */ e g(long j7) {
        C(j7);
        return this;
    }

    @Override // i6.u
    public final void h(d dVar, long j7) {
        if (dVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (dVar != this) {
            x.a(dVar.f4498g, 0, j7);
            while (j7 > 0) {
                s sVar = dVar.f4497f;
                int i7 = sVar.f4531c - sVar.f4530b;
                int i8 = 0;
                if (j7 < ((long) i7)) {
                    s sVar2 = this.f4497f;
                    s sVar3 = sVar2 != null ? sVar2.f4534g : null;
                    if (sVar3 != null && sVar3.e) {
                        if ((((long) sVar3.f4531c) + j7) - ((long) (sVar3.f4532d ? 0 : sVar3.f4530b)) <= 2048) {
                            sVar.c(sVar3, (int) j7);
                            dVar.f4498g -= j7;
                            this.f4498g += j7;
                            return;
                        }
                    }
                    int i9 = (int) j7;
                    if (i9 <= 0 || i9 > i7) {
                        throw new IllegalArgumentException();
                    }
                    s sVar4 = new s(sVar);
                    sVar4.f4531c = sVar4.f4530b + i9;
                    sVar.f4530b += i9;
                    sVar.f4534g.b(sVar4);
                    dVar.f4497f = sVar4;
                }
                s sVar5 = dVar.f4497f;
                long j8 = (long) (sVar5.f4531c - sVar5.f4530b);
                dVar.f4497f = sVar5.a();
                s sVar6 = this.f4497f;
                if (sVar6 == null) {
                    this.f4497f = sVar5;
                    sVar5.f4534g = sVar5;
                    sVar5.f4533f = sVar5;
                } else {
                    sVar6.f4534g.b(sVar5);
                    s sVar7 = sVar5.f4534g;
                    if (sVar7 == sVar5) {
                        throw new IllegalStateException();
                    } else if (sVar7.e) {
                        int i10 = sVar5.f4531c - sVar5.f4530b;
                        int i11 = 2048 - sVar7.f4531c;
                        if (!sVar7.f4532d) {
                            i8 = sVar7.f4530b;
                        }
                        if (i10 <= i11 + i8) {
                            sVar5.c(sVar7, i10);
                            sVar5.a();
                            t.a(sVar5);
                        }
                    }
                }
                dVar.f4498g -= j8;
                this.f4498g += j8;
                j7 -= j8;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    @Override // java.lang.Object
    public final int hashCode() {
        s sVar = this.f4497f;
        if (sVar == null) {
            return 0;
        }
        int i7 = 1;
        do {
            int i8 = sVar.f4531c;
            for (int i9 = sVar.f4530b; i9 < i8; i9++) {
                i7 = (i7 * 31) + sVar.f4529a[i9];
            }
            sVar = sVar.f4533f;
        } while (sVar != this.f4497f);
        return i7;
    }

    public final byte[] i(long j7) {
        int i7;
        x.a(this.f4498g, 0, j7);
        if (j7 <= 2147483647L) {
            int i8 = (int) j7;
            byte[] bArr = new byte[i8];
            int i9 = 0;
            while (i9 < i8) {
                int i10 = i8 - i9;
                x.a((long) i8, (long) i9, (long) i10);
                s sVar = this.f4497f;
                if (sVar == null) {
                    i7 = -1;
                } else {
                    i7 = Math.min(i10, sVar.f4531c - sVar.f4530b);
                    System.arraycopy(sVar.f4529a, sVar.f4530b, bArr, i9, i7);
                    int i11 = sVar.f4530b + i7;
                    sVar.f4530b = i11;
                    this.f4498g -= (long) i7;
                    if (i11 == sVar.f4531c) {
                        this.f4497f = sVar.a();
                        t.a(sVar);
                    }
                }
                if (i7 != -1) {
                    i9 += i7;
                } else {
                    throw new EOFException();
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j7);
    }

    @Override // i6.f
    public final g j(long j7) {
        return new g(i(j7));
    }

    public final String k(long j7, Charset charset) {
        x.a(this.f4498g, 0, j7);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j7 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j7);
        } else if (j7 == 0) {
            return "";
        } else {
            s sVar = this.f4497f;
            int i7 = sVar.f4530b;
            if (((long) i7) + j7 > ((long) sVar.f4531c)) {
                return new String(i(j7), charset);
            }
            String str = new String(sVar.f4529a, i7, (int) j7, charset);
            int i8 = (int) (((long) sVar.f4530b) + j7);
            sVar.f4530b = i8;
            this.f4498g -= j7;
            if (i8 == sVar.f4531c) {
                this.f4497f = sVar.a();
                t.a(sVar);
            }
            return str;
        }
    }

    @Override // i6.e
    public final long l(v vVar) {
        if (vVar != null) {
            long j7 = 0;
            while (true) {
                long B = vVar.B(this, 2048);
                if (B == -1) {
                    return j7;
                }
                j7 += B;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public final String m() {
        try {
            return k(this.f4498g, x.f4541a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final String n(long j7) {
        if (j7 > 0) {
            long j8 = j7 - 1;
            if (e(j8) == 13) {
                String k6 = k(j8, x.f4541a);
                skip(2);
                return k6;
            }
        }
        String k7 = k(j7, x.f4541a);
        skip(1);
        return k7;
    }

    public final s p(int i7) {
        if (i7 < 1 || i7 > 2048) {
            throw new IllegalArgumentException();
        }
        s sVar = this.f4497f;
        if (sVar == null) {
            s b2 = t.b();
            this.f4497f = b2;
            b2.f4534g = b2;
            b2.f4533f = b2;
            return b2;
        }
        s sVar2 = sVar.f4534g;
        if (sVar2.f4531c + i7 <= 2048 && sVar2.e) {
            return sVar2;
        }
        s b7 = t.b();
        sVar2.b(b7);
        return b7;
    }

    public final void q(g gVar) {
        if (gVar != null) {
            byte[] bArr = gVar.f4501f;
            s(bArr, bArr.length);
            return;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // i6.f
    public final byte readByte() {
        long j7 = this.f4498g;
        if (j7 != 0) {
            s sVar = this.f4497f;
            int i7 = sVar.f4530b;
            int i8 = sVar.f4531c;
            int i9 = i7 + 1;
            byte b2 = sVar.f4529a[i7];
            this.f4498g = j7 - 1;
            if (i9 == i8) {
                this.f4497f = sVar.a();
                t.a(sVar);
            } else {
                sVar.f4530b = i9;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // i6.f
    public final int readInt() {
        long j7 = this.f4498g;
        if (j7 >= 4) {
            s sVar = this.f4497f;
            int i7 = sVar.f4530b;
            int i8 = sVar.f4531c;
            if (i8 - i7 < 4) {
                return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
            }
            byte[] bArr = sVar.f4529a;
            int i9 = i7 + 1;
            int i10 = i9 + 1;
            int i11 = ((bArr[i7] & 255) << 24) | ((bArr[i9] & 255) << 16);
            int i12 = i10 + 1;
            int i13 = i11 | ((bArr[i10] & 255) << 8);
            int i14 = i12 + 1;
            int i15 = i13 | (bArr[i12] & 255);
            this.f4498g = j7 - 4;
            if (i14 == i8) {
                this.f4497f = sVar.a();
                t.a(sVar);
            } else {
                sVar.f4530b = i14;
            }
            return i15;
        }
        StringBuilder d7 = h.d("size < 4: ");
        d7.append(this.f4498g);
        throw new IllegalStateException(d7.toString());
    }

    @Override // i6.f
    public final short readShort() {
        long j7 = this.f4498g;
        if (j7 >= 2) {
            s sVar = this.f4497f;
            int i7 = sVar.f4530b;
            int i8 = sVar.f4531c;
            if (i8 - i7 < 2) {
                return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
            }
            byte[] bArr = sVar.f4529a;
            int i9 = i7 + 1;
            int i10 = i9 + 1;
            int i11 = ((bArr[i7] & 255) << 8) | (bArr[i9] & 255);
            this.f4498g = j7 - 2;
            if (i10 == i8) {
                this.f4497f = sVar.a();
                t.a(sVar);
            } else {
                sVar.f4530b = i10;
            }
            return (short) i11;
        }
        StringBuilder d7 = h.d("size < 2: ");
        d7.append(this.f4498g);
        throw new IllegalStateException(d7.toString());
    }

    public final void s(byte[] bArr, int i7) {
        if (bArr != null) {
            int i8 = 0;
            long j7 = (long) i7;
            x.a((long) bArr.length, (long) 0, j7);
            int i9 = i7 + 0;
            while (i8 < i9) {
                s p6 = p(1);
                int min = Math.min(i9 - i8, 2048 - p6.f4531c);
                System.arraycopy(bArr, i8, p6.f4529a, p6.f4531c, min);
                i8 += min;
                p6.f4531c += min;
            }
            this.f4498g += j7;
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // i6.f
    public final void skip(long j7) {
        while (j7 > 0) {
            s sVar = this.f4497f;
            if (sVar != null) {
                int min = (int) Math.min(j7, (long) (sVar.f4531c - sVar.f4530b));
                long j8 = (long) min;
                this.f4498g -= j8;
                j7 -= j8;
                s sVar2 = this.f4497f;
                int i7 = sVar2.f4530b + min;
                sVar2.f4530b = i7;
                if (i7 == sVar2.f4531c) {
                    this.f4497f = sVar2.a();
                    t.a(sVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // i6.f
    public final String t() {
        long f7 = f((byte) 10, 0);
        if (f7 != -1) {
            return n(f7);
        }
        d dVar = new d();
        d(dVar, 0, Math.min(32L, this.f4498g));
        StringBuilder d7 = h.d("\\n not found: size=");
        d7.append(this.f4498g);
        d7.append(" content=");
        d7.append(new g(dVar.u()).c());
        d7.append("...");
        throw new EOFException(d7.toString());
    }

    @Override // java.lang.Object
    public final String toString() {
        long j7 = this.f4498g;
        if (j7 == 0) {
            return "Buffer[size=0]";
        }
        if (j7 <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.f4498g), new g(clone().u()).c());
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            s sVar = this.f4497f;
            byte[] bArr = sVar.f4529a;
            int i7 = sVar.f4530b;
            instance.update(bArr, i7, sVar.f4531c - i7);
            s sVar2 = this.f4497f;
            while (true) {
                sVar2 = sVar2.f4533f;
                if (sVar2 == this.f4497f) {
                    return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.f4498g), g.d(instance.digest()).c());
                }
                byte[] bArr2 = sVar2.f4529a;
                int i8 = sVar2.f4530b;
                instance.update(bArr2, i8, sVar2.f4531c - i8);
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    @Override // i6.f
    public final byte[] u() {
        try {
            return i(this.f4498g);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // i6.e
    public final e write(byte[] bArr) {
        s(bArr, bArr.length);
        return this;
    }

    @Override // i6.e
    public final /* bridge */ /* synthetic */ e writeByte(int i7) {
        z(i7);
        return this;
    }

    @Override // i6.e
    public final /* bridge */ /* synthetic */ e writeInt(int i7) {
        D(i7);
        return this;
    }

    @Override // i6.e
    public final /* bridge */ /* synthetic */ e writeShort(int i7) {
        E(i7);
        return this;
    }

    @Override // i6.f
    public final boolean x() {
        return this.f4498g == 0;
    }

    public final void z(int i7) {
        s p6 = p(1);
        byte[] bArr = p6.f4529a;
        int i8 = p6.f4531c;
        p6.f4531c = i8 + 1;
        bArr[i8] = (byte) i7;
        this.f4498g++;
    }
}
