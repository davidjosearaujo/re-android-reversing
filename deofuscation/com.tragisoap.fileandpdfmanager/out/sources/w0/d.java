package w0;

import java.util.Arrays;
import p.o;
import w0.b;
import y0.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d {

    /* renamed from: p */
    public static boolean f6341p = false;

    /* renamed from: q */
    public static int f6342q = 1000;

    /* renamed from: c */
    public e f6345c;

    /* renamed from: f */
    public b[] f6347f;

    /* renamed from: l */
    public final c f6353l;

    /* renamed from: o */
    public b f6355o;

    /* renamed from: a */
    public boolean f6343a = false;

    /* renamed from: b */
    public int f6344b = 0;

    /* renamed from: d */
    public int f6346d = 32;
    public int e = 32;

    /* renamed from: g */
    public boolean f6348g = false;

    /* renamed from: h */
    public boolean[] f6349h = new boolean[32];

    /* renamed from: i */
    public int f6350i = 1;

    /* renamed from: j */
    public int f6351j = 0;

    /* renamed from: k */
    public int f6352k = 32;
    public f[] m = new f[f6342q];

    /* renamed from: n */
    public int f6354n = 0;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a {
        f a(boolean[] zArr);
    }

    public d() {
        this.f6347f = null;
        this.f6347f = new b[32];
        t();
        c cVar = new c(0);
        this.f6353l = cVar;
        this.f6345c = new e(cVar);
        this.f6355o = new b(cVar);
    }

    public static int o(c cVar) {
        f fVar = cVar.f6501i;
        if (fVar != null) {
            return (int) (fVar.f6366j + 0.5f);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Unknown variable types count: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final w0.f a(int r6) {
        /*
            r5 = this;
            w0.c r0 = r5.f6353l
            java.lang.Object r0 = r0.f6339c
            p.o r0 = (p.o) r0
            int r1 = r0.f5446b
            r2 = 0
            if (r1 <= 0) goto L_0x0018
            int r1 = r1 + -1
            java.lang.Object r3 = r0.f5445a
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            r4 = r3[r1]
            r3[r1] = r2
            r0.f5446b = r1
            r2 = r4
        L_0x0018:
            w0.f r2 = (w0.f) r2
            if (r2 != 0) goto L_0x0022
            w0.f r2 = new w0.f
            r2.<init>(r6)
            goto L_0x0025
        L_0x0022:
            r2.c()
        L_0x0025:
            r2.f6369n = r6
            int r6 = r5.f6354n
            int r0 = w0.d.f6342q
            if (r6 < r0) goto L_0x003b
            int r0 = r0 * 2
            w0.d.f6342q = r0
            w0.f[] r6 = r5.m
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r0)
            w0.f[] r6 = (w0.f[]) r6
            r5.m = r6
        L_0x003b:
            w0.f[] r6 = r5.m
            int r0 = r5.f6354n
            int r1 = r0 + 1
            r5.f6354n = r1
            r6[r0] = r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.d.a(int):w0.f");
    }

    public final void b(f fVar, f fVar2, int i7, float f7, f fVar3, f fVar4, int i8, int i9) {
        float f8;
        int i10;
        b m = m();
        if (fVar2 == fVar3) {
            m.f6336d.b(fVar, 1.0f);
            m.f6336d.b(fVar4, 1.0f);
            m.f6336d.b(fVar2, -2.0f);
        } else {
            if (f7 == 0.5f) {
                m.f6336d.b(fVar, 1.0f);
                m.f6336d.b(fVar2, -1.0f);
                m.f6336d.b(fVar3, -1.0f);
                m.f6336d.b(fVar4, 1.0f);
                if (i7 > 0 || i8 > 0) {
                    i10 = (-i7) + i8;
                    f8 = (float) i10;
                }
            } else if (f7 <= 0.0f) {
                m.f6336d.b(fVar, -1.0f);
                m.f6336d.b(fVar2, 1.0f);
                f8 = (float) i7;
            } else if (f7 >= 1.0f) {
                m.f6336d.b(fVar4, -1.0f);
                m.f6336d.b(fVar3, 1.0f);
                i10 = -i8;
                f8 = (float) i10;
            } else {
                float f9 = 1.0f - f7;
                m.f6336d.b(fVar, f9 * 1.0f);
                m.f6336d.b(fVar2, f9 * -1.0f);
                m.f6336d.b(fVar3, -1.0f * f7);
                m.f6336d.b(fVar4, 1.0f * f7);
                if (i7 > 0 || i8 > 0) {
                    m.f6334b = (((float) i8) * f7) + (((float) (-i7)) * f9);
                }
            }
            m.f6334b = f8;
        }
        if (i9 != 8) {
            m.b(this, i9);
        }
        c(m);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00bf, code lost:
        if (r4.f6372q <= 1) goto L_0x00d8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c8, code lost:
        if (r4.f6372q <= 1) goto L_0x00d8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00cb, code lost:
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e6, code lost:
        if (r4.f6372q <= 1) goto L_0x00ff;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ef, code lost:
        if (r4.f6372q <= 1) goto L_0x00ff;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f2, code lost:
        r14 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(w0.b r17) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.d.c(w0.b):void");
    }

    public final void d(f fVar, int i7) {
        b bVar;
        b.a aVar;
        float f7;
        int i8 = fVar.f6364h;
        if (i8 == -1) {
            fVar.d(this, (float) i7);
            for (int i9 = 0; i9 < this.f6344b + 1; i9++) {
                f fVar2 = ((f[]) this.f6353l.f6340d)[i9];
            }
            return;
        }
        if (i8 != -1) {
            b bVar2 = this.f6347f[i8];
            if (!bVar2.e) {
                if (bVar2.f6336d.c() == 0) {
                    bVar2.e = true;
                } else {
                    bVar = m();
                    if (i7 < 0) {
                        bVar.f6334b = (float) (i7 * -1);
                        aVar = bVar.f6336d;
                        f7 = 1.0f;
                    } else {
                        bVar.f6334b = (float) i7;
                        aVar = bVar.f6336d;
                        f7 = -1.0f;
                    }
                    aVar.b(fVar, f7);
                }
            }
            bVar2.f6334b = (float) i7;
            return;
        }
        bVar = m();
        bVar.f6333a = fVar;
        float f8 = (float) i7;
        fVar.f6366j = f8;
        bVar.f6334b = f8;
        bVar.e = true;
        c(bVar);
    }

    public final void e(f fVar, f fVar2, int i7, int i8) {
        if (i8 == 8 && fVar2.f6367k && fVar.f6364h == -1) {
            fVar.d(this, fVar2.f6366j + ((float) i7));
            return;
        }
        b m = m();
        boolean z6 = false;
        if (i7 != 0) {
            if (i7 < 0) {
                i7 *= -1;
                z6 = true;
            }
            m.f6334b = (float) i7;
        }
        if (!z6) {
            m.f6336d.b(fVar, -1.0f);
            m.f6336d.b(fVar2, 1.0f);
        } else {
            m.f6336d.b(fVar, 1.0f);
            m.f6336d.b(fVar2, -1.0f);
        }
        if (i8 != 8) {
            m.b(this, i8);
        }
        c(m);
    }

    public final void f(f fVar, f fVar2, int i7, int i8) {
        b m = m();
        f n6 = n();
        n6.f6365i = 0;
        m.c(fVar, fVar2, n6, i7);
        if (i8 != 8) {
            m.f6336d.b(k(i8), (float) ((int) (m.f6336d.e(n6) * -1.0f)));
        }
        c(m);
    }

    public final void g(f fVar, f fVar2, int i7, int i8) {
        b m = m();
        f n6 = n();
        n6.f6365i = 0;
        m.d(fVar, fVar2, n6, i7);
        if (i8 != 8) {
            m.f6336d.b(k(i8), (float) ((int) (m.f6336d.e(n6) * -1.0f)));
        }
        c(m);
    }

    public final void h(f fVar, f fVar2, f fVar3, f fVar4, float f7) {
        b m = m();
        m.f6336d.b(fVar, -1.0f);
        m.f6336d.b(fVar2, 1.0f);
        m.f6336d.b(fVar3, f7);
        m.f6336d.b(fVar4, -f7);
        c(m);
    }

    public final void i(b bVar) {
        int i7;
        if (bVar.e) {
            bVar.f6333a.d(this, bVar.f6334b);
        } else {
            b[] bVarArr = this.f6347f;
            int i8 = this.f6351j;
            bVarArr[i8] = bVar;
            f fVar = bVar.f6333a;
            fVar.f6364h = i8;
            this.f6351j = i8 + 1;
            fVar.e(this, bVar);
        }
        if (this.f6343a) {
            int i9 = 0;
            while (i9 < this.f6351j) {
                if (this.f6347f[i9] == null) {
                    System.out.println("WTF");
                }
                b bVar2 = this.f6347f[i9];
                if (bVar2 != null && bVar2.e) {
                    bVar2.f6333a.d(this, bVar2.f6334b);
                    ((o) this.f6353l.f6338b).a(bVar2);
                    this.f6347f[i9] = null;
                    int i10 = i9 + 1;
                    int i11 = i10;
                    while (true) {
                        i7 = this.f6351j;
                        if (i10 >= i7) {
                            break;
                        }
                        b[] bVarArr2 = this.f6347f;
                        int i12 = i10 - 1;
                        b bVar3 = bVarArr2[i10];
                        bVarArr2[i12] = bVar3;
                        f fVar2 = bVar3.f6333a;
                        if (fVar2.f6364h == i10) {
                            fVar2.f6364h = i12;
                        }
                        i10++;
                        i11 = i10;
                    }
                    if (i11 < i7) {
                        this.f6347f[i11] = null;
                    }
                    this.f6351j = i7 - 1;
                    i9--;
                }
                i9++;
            }
            this.f6343a = false;
        }
    }

    public final void j() {
        for (int i7 = 0; i7 < this.f6351j; i7++) {
            b bVar = this.f6347f[i7];
            bVar.f6333a.f6366j = bVar.f6334b;
        }
    }

    public final f k(int i7) {
        if (this.f6350i + 1 >= this.e) {
            p();
        }
        f a7 = a(4);
        int i8 = this.f6344b + 1;
        this.f6344b = i8;
        this.f6350i++;
        a7.f6363g = i8;
        a7.f6365i = i7;
        ((f[]) this.f6353l.f6340d)[i8] = a7;
        e eVar = this.f6345c;
        eVar.f6359i.f6360a = a7;
        Arrays.fill(a7.m, 0.0f);
        a7.m[a7.f6365i] = 1.0f;
        eVar.j(a7);
        return a7;
    }

    public final f l(Object obj) {
        f fVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f6350i + 1 >= this.e) {
            p();
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            fVar = cVar.f6501i;
            if (fVar == null) {
                cVar.k();
                fVar = cVar.f6501i;
            }
            int i7 = fVar.f6363g;
            if (i7 == -1 || i7 > this.f6344b || ((f[]) this.f6353l.f6340d)[i7] == null) {
                if (i7 != -1) {
                    fVar.c();
                }
                int i8 = this.f6344b + 1;
                this.f6344b = i8;
                this.f6350i++;
                fVar.f6363g = i8;
                fVar.f6369n = 1;
                ((f[]) this.f6353l.f6340d)[i8] = fVar;
            }
        }
        return fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Unknown variable types count: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final w0.b m() {
        /*
            r5 = this;
            w0.c r5 = r5.f6353l
            java.lang.Object r0 = r5.f6338b
            p.o r0 = (p.o) r0
            int r1 = r0.f5446b
            r2 = 0
            if (r1 <= 0) goto L_0x0018
            int r1 = r1 + -1
            java.lang.Object r3 = r0.f5445a
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            r4 = r3[r1]
            r3[r1] = r2
            r0.f5446b = r1
            goto L_0x0019
        L_0x0018:
            r4 = r2
        L_0x0019:
            w0.b r4 = (w0.b) r4
            if (r4 != 0) goto L_0x0023
            w0.b r4 = new w0.b
            r4.<init>(r5)
            goto L_0x0030
        L_0x0023:
            r4.f6333a = r2
            w0.b$a r5 = r4.f6336d
            r5.clear()
            r5 = 0
            r4.f6334b = r5
            r5 = 0
            r4.e = r5
        L_0x0030:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.d.m():w0.b");
    }

    public final f n() {
        if (this.f6350i + 1 >= this.e) {
            p();
        }
        f a7 = a(3);
        int i7 = this.f6344b + 1;
        this.f6344b = i7;
        this.f6350i++;
        a7.f6363g = i7;
        ((f[]) this.f6353l.f6340d)[i7] = a7;
        return a7;
    }

    public final void p() {
        int i7 = this.f6346d * 2;
        this.f6346d = i7;
        this.f6347f = (b[]) Arrays.copyOf(this.f6347f, i7);
        c cVar = this.f6353l;
        cVar.f6340d = (f[]) Arrays.copyOf((f[]) cVar.f6340d, this.f6346d);
        int i8 = this.f6346d;
        this.f6349h = new boolean[i8];
        this.e = i8;
        this.f6352k = i8;
    }

    public final void q() {
        if (this.f6345c.e()) {
            j();
            return;
        }
        if (this.f6348g) {
            boolean z6 = false;
            int i7 = 0;
            while (true) {
                if (i7 >= this.f6351j) {
                    z6 = true;
                    break;
                } else if (!this.f6347f[i7].e) {
                    break;
                } else {
                    i7++;
                }
            }
            if (z6) {
                j();
                return;
            }
        }
        r(this.f6345c);
    }

    public final void r(e eVar) {
        float f7;
        int i7;
        boolean z6;
        int i8 = 0;
        while (true) {
            f7 = 0.0f;
            i7 = 1;
            if (i8 >= this.f6351j) {
                z6 = false;
                break;
            }
            b bVar = this.f6347f[i8];
            if (bVar.f6333a.f6369n != 1 && bVar.f6334b < 0.0f) {
                z6 = true;
                break;
            }
            i8++;
        }
        if (z6) {
            boolean z7 = false;
            int i9 = 0;
            while (!z7) {
                i9 += i7;
                float f8 = Float.MAX_VALUE;
                int i10 = -1;
                int i11 = -1;
                int i12 = 0;
                int i13 = 0;
                while (i12 < this.f6351j) {
                    b bVar2 = this.f6347f[i12];
                    if (bVar2.f6333a.f6369n != i7 && !bVar2.e && bVar2.f6334b < f7) {
                        int c7 = bVar2.f6336d.c();
                        int i14 = 0;
                        while (i14 < c7) {
                            f g2 = bVar2.f6336d.g(i14);
                            float e = bVar2.f6336d.e(g2);
                            if (e > f7) {
                                for (int i15 = 0; i15 < 9; i15++) {
                                    float f9 = g2.f6368l[i15] / e;
                                    if ((f9 < f8 && i15 == i13) || i15 > i13) {
                                        i11 = g2.f6363g;
                                        i13 = i15;
                                        f8 = f9;
                                        i10 = i12;
                                    }
                                }
                            }
                            i14++;
                            f7 = 0.0f;
                        }
                    }
                    i12++;
                    f7 = 0.0f;
                    i7 = 1;
                }
                if (i10 != -1) {
                    b bVar3 = this.f6347f[i10];
                    bVar3.f6333a.f6364h = -1;
                    bVar3.g(((f[]) this.f6353l.f6340d)[i11]);
                    f fVar = bVar3.f6333a;
                    fVar.f6364h = i10;
                    fVar.e(this, bVar3);
                } else {
                    z7 = true;
                }
                if (i9 > this.f6350i / 2) {
                    z7 = true;
                }
                f7 = 0.0f;
                i7 = 1;
            }
        }
        s(eVar);
        j();
    }

    public final void s(b bVar) {
        for (int i7 = 0; i7 < this.f6350i; i7++) {
            this.f6349h[i7] = false;
        }
        boolean z6 = false;
        int i8 = 0;
        while (!z6) {
            i8++;
            if (i8 < this.f6350i * 2) {
                f fVar = bVar.f6333a;
                if (fVar != null) {
                    this.f6349h[fVar.f6363g] = true;
                }
                f a7 = bVar.a(this.f6349h);
                if (a7 != null) {
                    boolean[] zArr = this.f6349h;
                    int i9 = a7.f6363g;
                    if (!zArr[i9]) {
                        zArr[i9] = true;
                    } else {
                        return;
                    }
                }
                if (a7 != null) {
                    float f7 = Float.MAX_VALUE;
                    int i10 = -1;
                    for (int i11 = 0; i11 < this.f6351j; i11++) {
                        b bVar2 = this.f6347f[i11];
                        if (bVar2.f6333a.f6369n != 1 && !bVar2.e && bVar2.f6336d.f(a7)) {
                            float e = bVar2.f6336d.e(a7);
                            if (e < 0.0f) {
                                float f8 = (-bVar2.f6334b) / e;
                                if (f8 < f7) {
                                    i10 = i11;
                                    f7 = f8;
                                }
                            }
                        }
                    }
                    if (i10 > -1) {
                        b bVar3 = this.f6347f[i10];
                        bVar3.f6333a.f6364h = -1;
                        bVar3.g(a7);
                        f fVar2 = bVar3.f6333a;
                        fVar2.f6364h = i10;
                        fVar2.e(this, bVar3);
                    }
                } else {
                    z6 = true;
                }
            } else {
                return;
            }
        }
    }

    public final void t() {
        for (int i7 = 0; i7 < this.f6351j; i7++) {
            b bVar = this.f6347f[i7];
            if (bVar != null) {
                ((o) this.f6353l.f6338b).a(bVar);
            }
            this.f6347f[i7] = null;
        }
    }

    public final void u() {
        c cVar;
        int i7 = 0;
        while (true) {
            cVar = this.f6353l;
            f[] fVarArr = (f[]) cVar.f6340d;
            if (i7 >= fVarArr.length) {
                break;
            }
            f fVar = fVarArr[i7];
            if (fVar != null) {
                fVar.c();
            }
            i7++;
        }
        o oVar = (o) cVar.f6339c;
        f[] fVarArr2 = this.m;
        int i8 = this.f6354n;
        oVar.getClass();
        if (i8 > fVarArr2.length) {
            i8 = fVarArr2.length;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            f fVar2 = fVarArr2[i9];
            int i10 = oVar.f5446b;
            Object[] objArr = (Object[]) oVar.f5445a;
            if (i10 < objArr.length) {
                objArr[i10] = fVar2;
                oVar.f5446b = i10 + 1;
            }
        }
        this.f6354n = 0;
        Arrays.fill((f[]) this.f6353l.f6340d, (Object) null);
        this.f6344b = 0;
        e eVar = this.f6345c;
        eVar.f6358h = 0;
        eVar.f6334b = 0.0f;
        this.f6350i = 1;
        for (int i11 = 0; i11 < this.f6351j; i11++) {
            b bVar = this.f6347f[i11];
        }
        t();
        this.f6351j = 0;
        this.f6355o = new b(this.f6353l);
    }
}
