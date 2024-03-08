package c0;

import a0.e;
import java.util.Arrays;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class r extends c {

    /* renamed from: p */
    public static final e f2494p = new e(1);

    /* renamed from: d */
    public final t f2495d;
    public final float e;

    /* renamed from: f */
    public final float f2496f;

    /* renamed from: g */
    public final s f2497g;

    /* renamed from: h */
    public final float[] f2498h;

    /* renamed from: i */
    public final float[] f2499i;

    /* renamed from: j */
    public final float[] f2500j;

    /* renamed from: k */
    public final i f2501k;

    /* renamed from: l */
    public final l f2502l;
    public final i m;

    /* renamed from: n */
    public final m f2503n;

    /* renamed from: o */
    public final boolean f2504o;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {
        public static float a(float[] fArr) {
            float f7 = fArr[0];
            float f8 = fArr[1];
            float f9 = fArr[2];
            float f10 = fArr[3];
            float f11 = fArr[4];
            float f12 = fArr[5];
            float f13 = (((((f9 * f12) + ((f8 * f11) + (f7 * f10))) - (f10 * f11)) - (f8 * f9)) - (f7 * f12)) * 0.5f;
            return f13 < 0.0f ? -f13 : f13;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public r(java.lang.String r18, float[] r19, c0.t r20, double r21, float r23, float r24, int r25) {
        /*
            r17 = this;
            r1 = r21
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x000c
            r5 = r3
            goto L_0x000d
        L_0x000c:
            r5 = r4
        L_0x000d:
            if (r5 == 0) goto L_0x0012
            c0.e r5 = c0.r.f2494p
            goto L_0x0017
        L_0x0012:
            c0.p r5 = new c0.p
            r5.<init>(r1)
        L_0x0017:
            r11 = r5
            if (r0 != 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r3 = r4
        L_0x001c:
            if (r3 == 0) goto L_0x0021
            c0.e r0 = c0.r.f2494p
            goto L_0x0026
        L_0x0021:
            c0.q r0 = new c0.q
            r0.<init>(r1)
        L_0x0026:
            r12 = r0
            c0.s r15 = new c0.s
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r5 = 0
            r7 = 0
            r9 = 0
            r0 = r15
            r1 = r21
            r0.<init>(r1, r3, r5, r7, r9)
            r10 = 0
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r13 = r23
            r14 = r24
            r16 = r25
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.r.<init>(java.lang.String, float[], c0.t, double, float, float, int):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public r(java.lang.String r12, float[] r13, c0.t r14, c0.s r15, int r16) {
        /*
            r11 = this;
            r9 = r15
            double r0 = r9.f2509f
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            r4 = 0
            if (r0 != 0) goto L_0x000d
            r5 = r1
            goto L_0x000e
        L_0x000d:
            r5 = r4
        L_0x000e:
            if (r5 == 0) goto L_0x0021
            double r5 = r9.f2510g
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x0018
            r5 = r1
            goto L_0x0019
        L_0x0018:
            r5 = r4
        L_0x0019:
            if (r5 == 0) goto L_0x0021
            c0.n r5 = new c0.n
            r5.<init>(r15, r4)
            goto L_0x0026
        L_0x0021:
            c0.o r5 = new c0.o
            r5.<init>(r15, r4)
        L_0x0026:
            if (r0 != 0) goto L_0x002a
            r0 = r1
            goto L_0x002b
        L_0x002a:
            r0 = r4
        L_0x002b:
            if (r0 == 0) goto L_0x003c
            double r6 = r9.f2510g
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0034
            r4 = r1
        L_0x0034:
            if (r4 == 0) goto L_0x003c
            c0.n r0 = new c0.n
            r0.<init>(r15, r1)
            goto L_0x0041
        L_0x003c:
            c0.o r0 = new c0.o
            r0.<init>(r15, r1)
        L_0x0041:
            r6 = r0
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r9 = r15
            r10 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.r.<init>(java.lang.String, float[], c0.t, c0.s, int):void");
    }

    @Override // c0.c
    public final float[] a(float[] fArr) {
        d.g(this.f2500j, fArr);
        fArr[0] = (float) this.f2502l.b((double) fArr[0]);
        fArr[1] = (float) this.f2502l.b((double) fArr[1]);
        fArr[2] = (float) this.f2502l.b((double) fArr[2]);
        return fArr;
    }

    @Override // c0.c
    public final float b(int i7) {
        return this.f2496f;
    }

    @Override // c0.c
    public final float c(int i7) {
        return this.e;
    }

    @Override // c0.c
    public final boolean d() {
        return this.f2504o;
    }

    @Override // c0.c
    public final long e(float f7, float f8, float f9) {
        float b2 = (float) this.f2503n.b((double) f7);
        float b7 = (float) this.f2503n.b((double) f8);
        float b8 = (float) this.f2503n.b((double) f9);
        return (((long) Float.floatToIntBits(d.h(this.f2499i, b2, b7, b8))) << 32) | (4294967295L & ((long) Float.floatToIntBits(d.i(this.f2499i, b2, b7, b8))));
    }

    @Override // c0.c
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        r rVar = (r) obj;
        if (Float.compare(rVar.e, this.e) != 0 || Float.compare(rVar.f2496f, this.f2496f) != 0 || !h.a(this.f2495d, rVar.f2495d) || !Arrays.equals(this.f2498h, rVar.f2498h)) {
            return false;
        }
        s sVar = this.f2497g;
        if (sVar != null) {
            return h.a(sVar, rVar.f2497g);
        }
        if (rVar.f2497g == null) {
            return true;
        }
        if (!h.a(this.f2501k, rVar.f2501k)) {
            return false;
        }
        return h.a(this.m, rVar.m);
    }

    @Override // c0.c
    public final float[] f(float[] fArr) {
        fArr[0] = (float) this.f2503n.b((double) fArr[0]);
        fArr[1] = (float) this.f2503n.b((double) fArr[1]);
        fArr[2] = (float) this.f2503n.b((double) fArr[2]);
        d.g(this.f2499i, fArr);
        return fArr;
    }

    @Override // c0.c
    public final float g(float f7, float f8, float f9) {
        return d.j(this.f2499i, (float) this.f2503n.b((double) f7), (float) this.f2503n.b((double) f8), (float) this.f2503n.b((double) f9));
    }

    @Override // c0.c
    public final long h(float f7, float f8, float f9, float f10, c cVar) {
        h.f(cVar, "colorSpace");
        return e.a((float) this.f2502l.b((double) d.h(this.f2500j, f7, f8, f9)), (float) this.f2502l.b((double) d.i(this.f2500j, f7, f8, f9)), (float) this.f2502l.b((double) d.j(this.f2500j, f7, f8, f9)), f10, cVar);
    }

    @Override // c0.c
    public final int hashCode() {
        int hashCode = (Arrays.hashCode(this.f2498h) + ((this.f2495d.hashCode() + (super.hashCode() * 31)) * 31)) * 31;
        float f7 = this.e;
        boolean z6 = true;
        int i7 = 0;
        int floatToIntBits = (hashCode + (!((f7 > 0.0f ? 1 : (f7 == 0.0f ? 0 : -1)) == 0) ? Float.floatToIntBits(f7) : 0)) * 31;
        float f8 = this.f2496f;
        if (f8 != 0.0f) {
            z6 = false;
        }
        int floatToIntBits2 = (floatToIntBits + (!z6 ? Float.floatToIntBits(f8) : 0)) * 31;
        s sVar = this.f2497g;
        if (sVar != null) {
            i7 = sVar.hashCode();
        }
        int i8 = floatToIntBits2 + i7;
        if (this.f2497g != null) {
            return i8;
        }
        return this.m.hashCode() + ((this.f2501k.hashCode() + (i8 * 31)) * 31);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    public r(String str, float[] fArr, t tVar, float[] fArr2, i iVar, i iVar2, float f7, float f8, s sVar, int i7) {
        super(str, b.f2462a, i7);
        boolean z6;
        boolean z7;
        h.f(str, "name");
        h.f(fArr, "primaries");
        h.f(iVar, "oetf");
        h.f(iVar2, "eotf");
        this.f2495d = tVar;
        this.e = f7;
        this.f2496f = f8;
        this.f2497g = sVar;
        this.f2501k = iVar;
        this.f2502l = new l(this);
        this.m = iVar2;
        this.f2503n = new m(this);
        if (fArr.length != 6 && fArr.length != 9) {
            throw new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
        } else if (f7 < f8) {
            float[] fArr3 = new float[6];
            boolean z8 = true;
            if (fArr.length == 9) {
                float f9 = fArr[0];
                float f10 = fArr[1];
                float f11 = f9 + f10 + fArr[2];
                fArr3[0] = f9 / f11;
                fArr3[1] = f10 / f11;
                float f12 = fArr[3];
                float f13 = fArr[4];
                float f14 = f12 + f13 + fArr[5];
                fArr3[2] = f12 / f14;
                fArr3[3] = f13 / f14;
                float f15 = fArr[6];
                float f16 = fArr[7];
                float f17 = f15 + f16 + fArr[8];
                fArr3[4] = f15 / f17;
                fArr3[5] = f16 / f17;
            } else {
                System.arraycopy(fArr, 0, fArr3, 0, 6);
            }
            this.f2498h = fArr3;
            if (fArr2 == null) {
                float f18 = fArr3[0];
                float f19 = fArr3[1];
                float f20 = fArr3[2];
                float f21 = fArr3[3];
                float f22 = fArr3[4];
                float f23 = fArr3[5];
                float f24 = tVar.f2511a;
                float f25 = tVar.f2512b;
                float f26 = (float) 1;
                float f27 = (f26 - f18) / f19;
                float f28 = f18 / f19;
                float f29 = (f20 / f21) - f28;
                float f30 = (f24 / f25) - f28;
                float f31 = ((f26 - f20) / f21) - f27;
                float f32 = (f22 / f23) - f28;
                float f33 = (((((f26 - f24) / f25) - f27) * f29) - (f30 * f31)) / (((((f26 - f22) / f23) - f27) * f29) - (f31 * f32));
                float f34 = (f30 - (f32 * f33)) / f29;
                float f35 = (1.0f - f34) - f33;
                float f36 = f35 / f19;
                float f37 = f34 / f21;
                float f38 = f33 / f23;
                this.f2499i = new float[]{f36 * f18, f35, ((1.0f - f18) - f19) * f36, f37 * f20, f34, ((1.0f - f20) - f21) * f37, f38 * f22, f33, ((1.0f - f22) - f23) * f38};
            } else if (fArr2.length == 9) {
                this.f2499i = fArr2;
            } else {
                StringBuilder d7 = androidx.activity.h.d("Transform must have 9 entries! Has ");
                d7.append(fArr2.length);
                throw new IllegalArgumentException(d7.toString());
            }
            this.f2500j = d.d(this.f2499i);
            float a7 = a.a(fArr3);
            float[] fArr4 = f.f2470a;
            if (a7 / a.a(f.f2471b) > 0.9f) {
                float[] fArr5 = f.f2470a;
                z6 = false;
                float f39 = fArr3[0];
                float f40 = fArr5[0];
                float f41 = f39 - f40;
                float f42 = fArr3[1];
                float f43 = fArr5[1];
                float f44 = f42 - f43;
                float f45 = fArr3[2];
                float f46 = fArr5[2];
                float f47 = f45 - f46;
                float f48 = fArr3[3];
                float f49 = fArr5[3];
                float f50 = f48 - f49;
                float f51 = fArr3[4];
                float f52 = fArr5[4];
                float f53 = f51 - f52;
                float f54 = fArr3[5];
                float f55 = fArr5[5];
                float f56 = f54 - f55;
                if (((f43 - f55) * f41) - ((f40 - f52) * f44) >= 0.0f && ((f40 - f46) * f44) - ((f43 - f49) * f41) >= 0.0f && ((f49 - f43) * f47) - ((f46 - f40) * f50) >= 0.0f && ((f46 - f52) * f50) - ((f49 - f55) * f47) >= 0.0f && ((f55 - f49) * f53) - ((f52 - f46) * f56) >= 0.0f) {
                    int i8 = ((((f52 - f40) * f56) - ((f55 - f43) * f53)) > 0.0f ? 1 : ((((f52 - f40) * f56) - ((f55 - f43) * f53)) == 0.0f ? 0 : -1));
                }
            } else {
                z6 = false;
            }
            if (i7 != 0) {
                float[] fArr6 = f.f2470a;
                if (fArr3 != fArr6) {
                    int i9 = z6;
                    while (i9 < 6) {
                        if (Float.compare(fArr3[i9 == true ? 1 : 0], fArr6[i9]) != 0 && Math.abs(fArr3[i9] - fArr6[i9]) > 0.001f) {
                            z7 = z6;
                            break;
                        }
                        i9 = (i9 == true ? 1 : 0) + 1;
                    }
                }
                z7 = true;
                if (z7 && d.c(tVar, e.f53t)) {
                    if (f7 == 0.0f ? true : z6) {
                        if (f8 == 1.0f ? true : z6) {
                            float[] fArr7 = f.f2470a;
                            r rVar = f.f2472c;
                            for (double d8 = 0.0d; d8 <= 1.0d; d8 += 0.00392156862745098d) {
                                if (Math.abs(iVar.b(d8) - rVar.f2501k.b(d8)) <= 0.001d ? true : z6) {
                                    if (Math.abs(iVar2.b(d8) - rVar.m.b(d8)) <= 0.001d ? true : z6) {
                                    }
                                }
                            }
                        }
                    }
                }
                z8 = z6;
                break;
            }
            this.f2504o = z8;
        } else {
            throw new IllegalArgumentException("Invalid range: min=" + f7 + ", max=" + f8 + "; min must be strictly < max");
        }
    }
}
