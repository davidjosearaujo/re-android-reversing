package i6;

import androidx.fragment.app.s0;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public final class d implements f, e, Cloneable {

    /* renamed from: h */
    public static final byte[] f4496h = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: f */
    public s f4497f;

    /* renamed from: g */
    public long f4498g;

    @Override // i6.v
    public final long B(d dVar, long j5) {
        if (dVar != null) {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            }
            long j7 = this.f4498g;
            if (j7 == 0) {
                return -1L;
            }
            if (j5 > j7) {
                j5 = j7;
            }
            dVar.h(this, j5);
            return j5;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public final d C(long j5) {
        if (j5 == 0) {
            z(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j5)) / 4) + 1;
        s p6 = p(numberOfTrailingZeros);
        byte[] bArr = p6.f4529a;
        int i7 = p6.f4531c;
        int i8 = i7 + numberOfTrailingZeros;
        while (true) {
            i8--;
            if (i8 < i7) {
                p6.f4531c += numberOfTrailingZeros;
                this.f4498g += numberOfTrailingZeros;
                return this;
            }
            bArr[i8] = f4496h[(int) (15 & j5)];
            j5 >>>= 4;
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
        }
        if (i7 < 0) {
            throw new IllegalAccessError(s0.g("beginIndex < 0: ", i7));
        }
        if (i8 < i7) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i8 + " < " + i7);
        } else if (i8 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i8 + " > " + str.length());
        } else {
            while (i7 < i8) {
                char charAt2 = str.charAt(i7);
                if (charAt2 < 128) {
                    s p6 = p(1);
                    byte[] bArr = p6.f4529a;
                    int i10 = p6.f4531c - i7;
                    int min = Math.min(i8, 2048 - i10);
                    int i11 = i7 + 1;
                    bArr[i7 + i10] = (byte) charAt2;
                    while (true) {
                        i7 = i11;
                        if (i7 >= min || (charAt = str.charAt(i7)) >= 128) {
                            break;
                        }
                        i11 = i7 + 1;
                        bArr[i7 + i10] = (byte) charAt;
                    }
                    int i12 = p6.f4531c;
                    int i13 = (i10 + i7) - i12;
                    p6.f4531c = i12 + i13;
                    this.f4498g += i13;
                } else {
                    if (charAt2 < 2048) {
                        i9 = (charAt2 >> 6) | 192;
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        z((charAt2 >> '\f') | 224);
                        i9 = ((charAt2 >> 6) & 63) | 128;
                    } else {
                        int i14 = i7 + 1;
                        char charAt3 = i14 < i8 ? str.charAt(i14) : (char) 0;
                        if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            z(63);
                            i7 = i14;
                        } else {
                            int i15 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                            z((i15 >> 18) | 240);
                            z(((i15 >> 12) & 63) | 128);
                            z(((i15 >> 6) & 63) | 128);
                            z((i15 & 63) | 128);
                            i7 += 2;
                        }
                    }
                    z(i9);
                    z((charAt2 & '?') | 128);
                    i7++;
                }
            }
        }
    }

    public final void J(int i7) {
        int i8;
        int i9;
        if (i7 >= 128) {
            if (i7 < 2048) {
                i9 = (i7 >> 6) | 192;
            } else {
                if (i7 < 65536) {
                    if (i7 >= 55296 && i7 <= 57343) {
                        StringBuilder d7 = androidx.activity.h.d("Unexpected code point: ");
                        d7.append(Integer.toHexString(i7));
                        throw new IllegalArgumentException(d7.toString());
                    }
                    i8 = (i7 >> 12) | 224;
                } else if (i7 > 1114111) {
                    StringBuilder d8 = androidx.activity.h.d("Unexpected code point: ");
                    d8.append(Integer.toHexString(i7));
                    throw new IllegalArgumentException(d8.toString());
                } else {
                    z((i7 >> 18) | 240);
                    i8 = ((i7 >> 12) & 63) | 128;
                }
                z(i8);
                i9 = ((i7 >> 6) & 63) | 128;
            }
            z(i9);
            i7 = (i7 & 63) | 128;
        }
        z(i7);
    }

    @Override // i6.f
    public final void P(long j5) {
        if (this.f4498g < j5) {
            throw new EOFException();
        }
    }

    @Override // i6.e
    public final e Q(String str) {
        G(0, str.length(), str);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:180:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x009a A[EDGE_INSN: B:189:0x009a->B:185:0x009a ?: BREAK  , SYNTHETIC] */
    @Override // i6.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long T() {
        /*
            r14 = this;
            long r0 = r14.f4498g
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto La1
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            i6.s r6 = r14.f4497f
            byte[] r7 = r6.f4529a
            int r8 = r6.f4530b
            int r9 = r6.f4531c
        L13:
            if (r8 >= r9) goto L86
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L39
        L22:
            r11 = 97
            if (r10 < r11) goto L2d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2d
            int r11 = r10 + (-97)
            goto L37
        L2d:
            r11 = 65
            if (r10 < r11) goto L6b
            r11 = 70
            if (r10 > r11) goto L6b
            int r11 = r10 + (-65)
        L37:
            int r11 = r11 + 10
        L39:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L49
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L49:
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
        L6b:
            if (r0 == 0) goto L6f
            r1 = 1
            goto L86
        L6f:
            java.lang.NumberFormatException r14 = new java.lang.NumberFormatException
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r0 = androidx.activity.h.d(r0)
            java.lang.String r1 = java.lang.Integer.toHexString(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        L86:
            if (r8 != r9) goto L92
            i6.s r7 = r6.a()
            r14.f4497f = r7
            i6.t.a(r6)
            goto L94
        L92:
            r6.f4530b = r8
        L94:
            if (r1 != 0) goto L9a
            i6.s r6 = r14.f4497f
            if (r6 != 0) goto Lb
        L9a:
            long r1 = r14.f4498g
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.f4498g = r1
            return r4
        La1:
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
    public final d m2clone() {
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
            if (sVar2 == this.f4497f) {
                dVar.f4498g = this.f4498g;
                return dVar;
            }
            dVar.f4497f.f4534g.b(new s(sVar2));
        }
    }

    @Override // i6.v
    public final w c() {
        return w.f4537d;
    }

    @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public final void d(d dVar, long j5, long j7) {
        if (dVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        x.a(this.f4498g, j5, j7);
        if (j7 == 0) {
            return;
        }
        dVar.f4498g += j7;
        s sVar = this.f4497f;
        while (true) {
            long j8 = sVar.f4531c - sVar.f4530b;
            if (j5 < j8) {
                break;
            }
            j5 -= j8;
            sVar = sVar.f4533f;
        }
        while (j7 > 0) {
            s sVar2 = new s(sVar);
            int i7 = (int) (sVar2.f4530b + j5);
            sVar2.f4530b = i7;
            sVar2.f4531c = Math.min(i7 + ((int) j7), sVar2.f4531c);
            s sVar3 = dVar.f4497f;
            if (sVar3 == null) {
                sVar2.f4534g = sVar2;
                sVar2.f4533f = sVar2;
                dVar.f4497f = sVar2;
            } else {
                sVar3.f4534g.b(sVar2);
            }
            j7 -= sVar2.f4531c - sVar2.f4530b;
            sVar = sVar.f4533f;
            j5 = 0;
        }
    }

    public final byte e(long j5) {
        x.a(this.f4498g, j5, 1L);
        s sVar = this.f4497f;
        while (true) {
            int i7 = sVar.f4531c;
            int i8 = sVar.f4530b;
            long j7 = i7 - i8;
            if (j5 < j7) {
                return sVar.f4529a[i8 + ((int) j5)];
            }
            j5 -= j7;
            sVar = sVar.f4533f;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            long j5 = this.f4498g;
            if (j5 != dVar.f4498g) {
                return false;
            }
            long j7 = 0;
            if (j5 == 0) {
                return true;
            }
            s sVar = this.f4497f;
            s sVar2 = dVar.f4497f;
            int i7 = sVar.f4530b;
            int i8 = sVar2.f4530b;
            while (j7 < this.f4498g) {
                long min = Math.min(sVar.f4531c - i7, sVar2.f4531c - i8);
                int i9 = 0;
                while (i9 < min) {
                    int i10 = i7 + 1;
                    int i11 = i8 + 1;
                    if (sVar.f4529a[i7] != sVar2.f4529a[i8]) {
                        return false;
                    }
                    i9++;
                    i7 = i10;
                    i8 = i11;
                }
                if (i7 == sVar.f4531c) {
                    sVar = sVar.f4533f;
                    i7 = sVar.f4530b;
                }
                if (i8 == sVar2.f4531c) {
                    sVar2 = sVar2.f4533f;
                    i8 = sVar2.f4530b;
                }
                j7 += min;
            }
            return true;
        }
        return false;
    }

    public final long f(byte b2, long j5) {
        long j7;
        if (j5 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        s sVar = this.f4497f;
        if (sVar == null) {
            return -1L;
        }
        long j8 = j5;
        long j9 = 0;
        while (true) {
            int i7 = sVar.f4531c;
            int i8 = sVar.f4530b;
            long j10 = i7 - i8;
            if (j8 >= j10) {
                j7 = j8 - j10;
            } else {
                byte[] bArr = sVar.f4529a;
                for (int i9 = (int) (i8 + j8); i9 < i7; i9++) {
                    if (bArr[i9] == b2) {
                        return (j9 + i9) - sVar.f4530b;
                    }
                }
                j7 = 0;
            }
            j9 += j10;
            sVar = sVar.f4533f;
            if (sVar == this.f4497f) {
                return -1L;
            }
            j8 = j7;
        }
    }

    @Override // i6.u, java.io.Flushable
    public final void flush() {
    }

    @Override // i6.e
    public final /* bridge */ /* synthetic */ e g(long j5) {
        C(j5);
        return this;
    }

    @Override // i6.u
    public final void h(d dVar, long j5) {
        if (dVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (dVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        x.a(dVar.f4498g, 0L, j5);
        while (j5 > 0) {
            s sVar = dVar.f4497f;
            int i7 = sVar.f4531c - sVar.f4530b;
            if (j5 < i7) {
                s sVar2 = this.f4497f;
                s sVar3 = sVar2 != null ? sVar2.f4534g : null;
                if (sVar3 != null && sVar3.e) {
                    if ((sVar3.f4531c + j5) - (sVar3.f4532d ? 0 : sVar3.f4530b) <= 2048) {
                        sVar.c(sVar3, (int) j5);
                        dVar.f4498g -= j5;
                        this.f4498g += j5;
                        return;
                    }
                }
                int i8 = (int) j5;
                if (i8 <= 0 || i8 > i7) {
                    throw new IllegalArgumentException();
                }
                s sVar4 = new s(sVar);
                sVar4.f4531c = sVar4.f4530b + i8;
                sVar.f4530b += i8;
                sVar.f4534g.b(sVar4);
                dVar.f4497f = sVar4;
            }
            s sVar5 = dVar.f4497f;
            long j7 = sVar5.f4531c - sVar5.f4530b;
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
                }
                if (sVar7.e) {
                    int i9 = sVar5.f4531c - sVar5.f4530b;
                    if (i9 <= (2048 - sVar7.f4531c) + (sVar7.f4532d ? 0 : sVar7.f4530b)) {
                        sVar5.c(sVar7, i9);
                        sVar5.a();
                        t.a(sVar5);
                    }
                }
            }
            dVar.f4498g -= j7;
            this.f4498g += j7;
            j5 -= j7;
        }
    }

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

    public final byte[] i(long j5) {
        int min;
        x.a(this.f4498g, 0L, j5);
        if (j5 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j5);
        }
        int i7 = (int) j5;
        byte[] bArr = new byte[i7];
        int i8 = 0;
        while (i8 < i7) {
            int i9 = i7 - i8;
            x.a(i7, i8, i9);
            s sVar = this.f4497f;
            if (sVar == null) {
                min = -1;
            } else {
                min = Math.min(i9, sVar.f4531c - sVar.f4530b);
                System.arraycopy(sVar.f4529a, sVar.f4530b, bArr, i8, min);
                int i10 = sVar.f4530b + min;
                sVar.f4530b = i10;
                this.f4498g -= min;
                if (i10 == sVar.f4531c) {
                    this.f4497f = sVar.a();
                    t.a(sVar);
                }
            }
            if (min == -1) {
                throw new EOFException();
            }
            i8 += min;
        }
        return bArr;
    }

    @Override // i6.f
    public final g j(long j5) {
        return new g(i(j5));
    }

    public final String k(long j5, Charset charset) {
        x.a(this.f4498g, 0L, j5);
        if (charset != null) {
            if (j5 > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j5);
            } else if (j5 == 0) {
                return "";
            } else {
                s sVar = this.f4497f;
                int i7 = sVar.f4530b;
                if (i7 + j5 > sVar.f4531c) {
                    return new String(i(j5), charset);
                }
                String str = new String(sVar.f4529a, i7, (int) j5, charset);
                int i8 = (int) (sVar.f4530b + j5);
                sVar.f4530b = i8;
                this.f4498g -= j5;
                if (i8 == sVar.f4531c) {
                    this.f4497f = sVar.a();
                    t.a(sVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // i6.e
    public final long l(v vVar) {
        if (vVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j5 = 0;
        while (true) {
            long B = vVar.B(this, 2048L);
            if (B == -1) {
                return j5;
            }
            j5 += B;
        }
    }

    public final String m() {
        try {
            return k(this.f4498g, x.f4541a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final String n(long j5) {
        if (j5 > 0) {
            long j7 = j5 - 1;
            if (e(j7) == 13) {
                String k6 = k(j7, x.f4541a);
                skip(2L);
                return k6;
            }
        }
        String k7 = k(j5, x.f4541a);
        skip(1L);
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
        if (sVar2.f4531c + i7 > 2048 || !sVar2.e) {
            s b7 = t.b();
            sVar2.b(b7);
            return b7;
        }
        return sVar2;
    }

    public final void q(g gVar) {
        if (gVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byte[] bArr = gVar.f4501f;
        s(bArr, bArr.length);
    }

    @Override // i6.f
    public final byte readByte() {
        long j5 = this.f4498g;
        if (j5 != 0) {
            s sVar = this.f4497f;
            int i7 = sVar.f4530b;
            int i8 = sVar.f4531c;
            int i9 = i7 + 1;
            byte b2 = sVar.f4529a[i7];
            this.f4498g = j5 - 1;
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
        long j5 = this.f4498g;
        if (j5 < 4) {
            StringBuilder d7 = androidx.activity.h.d("size < 4: ");
            d7.append(this.f4498g);
            throw new IllegalStateException(d7.toString());
        }
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
        this.f4498g = j5 - 4;
        if (i14 == i8) {
            this.f4497f = sVar.a();
            t.a(sVar);
        } else {
            sVar.f4530b = i14;
        }
        return i15;
    }

    @Override // i6.f
    public final short readShort() {
        long j5 = this.f4498g;
        if (j5 < 2) {
            StringBuilder d7 = androidx.activity.h.d("size < 2: ");
            d7.append(this.f4498g);
            throw new IllegalStateException(d7.toString());
        }
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
        this.f4498g = j5 - 2;
        if (i10 == i8) {
            this.f4497f = sVar.a();
            t.a(sVar);
        } else {
            sVar.f4530b = i10;
        }
        return (short) i11;
    }

    public final void s(byte[] bArr, int i7) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        int i8 = 0;
        long j5 = i7;
        x.a(bArr.length, 0, j5);
        int i9 = i7 + 0;
        while (i8 < i9) {
            s p6 = p(1);
            int min = Math.min(i9 - i8, 2048 - p6.f4531c);
            System.arraycopy(bArr, i8, p6.f4529a, p6.f4531c, min);
            i8 += min;
            p6.f4531c += min;
        }
        this.f4498g += j5;
    }

    @Override // i6.f
    public final void skip(long j5) {
        s sVar;
        while (j5 > 0) {
            if (this.f4497f == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j5, sVar.f4531c - sVar.f4530b);
            long j7 = min;
            this.f4498g -= j7;
            j5 -= j7;
            s sVar2 = this.f4497f;
            int i7 = sVar2.f4530b + min;
            sVar2.f4530b = i7;
            if (i7 == sVar2.f4531c) {
                this.f4497f = sVar2.a();
                t.a(sVar2);
            }
        }
    }

    @Override // i6.f
    public final String t() {
        long f7 = f((byte) 10, 0L);
        if (f7 != -1) {
            return n(f7);
        }
        d dVar = new d();
        d(dVar, 0L, Math.min(32L, this.f4498g));
        StringBuilder d7 = androidx.activity.h.d("\\n not found: size=");
        d7.append(this.f4498g);
        d7.append(" content=");
        d7.append(new g(dVar.u()).c());
        d7.append("...");
        throw new EOFException(d7.toString());
    }

    public final String toString() {
        long j5 = this.f4498g;
        if (j5 == 0) {
            return "Buffer[size=0]";
        }
        if (j5 <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.f4498g), new g(clone().u()).c());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            s sVar = this.f4497f;
            byte[] bArr = sVar.f4529a;
            int i7 = sVar.f4530b;
            messageDigest.update(bArr, i7, sVar.f4531c - i7);
            s sVar2 = this.f4497f;
            while (true) {
                sVar2 = sVar2.f4533f;
                if (sVar2 == this.f4497f) {
                    return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.f4498g), g.d(messageDigest.digest()).c());
                }
                byte[] bArr2 = sVar2.f4529a;
                int i8 = sVar2.f4530b;
                messageDigest.update(bArr2, i8, sVar2.f4531c - i8);
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
