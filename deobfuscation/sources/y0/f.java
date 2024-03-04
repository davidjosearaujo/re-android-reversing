package y0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f extends j {
    public d[] c1;
    public int F0 = -1;
    public int G0 = -1;
    public int H0 = -1;
    public int I0 = -1;
    public int J0 = -1;
    public int K0 = -1;
    public float L0 = 0.5f;
    public float M0 = 0.5f;
    public float N0 = 0.5f;
    public float O0 = 0.5f;
    public float P0 = 0.5f;
    public float Q0 = 0.5f;
    public int R0 = 0;
    public int S0 = 0;
    public int T0 = 2;
    public int U0 = 2;
    public int V0 = 0;
    public int W0 = -1;
    public int X0 = 0;
    public ArrayList<a> Y0 = new ArrayList<>();
    public d[] Z0 = null;

    /* renamed from: a1 */
    public d[] f6558a1 = null;

    /* renamed from: b1 */
    public int[] f6559b1 = null;

    /* renamed from: d1 */
    public int f6560d1 = 0;

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a */
        public int f6561a;

        /* renamed from: d */
        public c f6564d;
        public c e;

        /* renamed from: f */
        public c f6565f;

        /* renamed from: g */
        public c f6566g;

        /* renamed from: h */
        public int f6567h;

        /* renamed from: i */
        public int f6568i;

        /* renamed from: j */
        public int f6569j;

        /* renamed from: k */
        public int f6570k;

        /* renamed from: q */
        public int f6575q;

        /* renamed from: b */
        public d f6562b = null;

        /* renamed from: c */
        public int f6563c = 0;

        /* renamed from: l */
        public int f6571l = 0;
        public int m = 0;

        /* renamed from: n */
        public int f6572n = 0;

        /* renamed from: o */
        public int f6573o = 0;

        /* renamed from: p */
        public int f6574p = 0;

        public a(int i7, c cVar, c cVar2, c cVar3, c cVar4, int i8) {
            f.this = r2;
            this.f6567h = 0;
            this.f6568i = 0;
            this.f6569j = 0;
            this.f6570k = 0;
            this.f6575q = 0;
            this.f6561a = i7;
            this.f6564d = cVar;
            this.e = cVar2;
            this.f6565f = cVar3;
            this.f6566g = cVar4;
            this.f6567h = r2.f6589y0;
            this.f6568i = r2.f6585u0;
            this.f6569j = r2.f6590z0;
            this.f6570k = r2.f6586v0;
            this.f6575q = i8;
        }

        public final void a(d dVar) {
            if (this.f6561a == 0) {
                int V = f.this.V(this.f6575q, dVar);
                if (dVar.V[0] == 3) {
                    this.f6574p++;
                    V = 0;
                }
                f fVar = f.this;
                this.f6571l = V + (dVar.f6528j0 != 8 ? fVar.R0 : 0) + this.f6571l;
                int U = fVar.U(this.f6575q, dVar);
                if (this.f6562b == null || this.f6563c < U) {
                    this.f6562b = dVar;
                    this.f6563c = U;
                    this.m = U;
                }
            } else {
                int V2 = f.this.V(this.f6575q, dVar);
                int U2 = f.this.U(this.f6575q, dVar);
                if (dVar.V[1] == 3) {
                    this.f6574p++;
                    U2 = 0;
                }
                this.m = U2 + (dVar.f6528j0 != 8 ? f.this.S0 : 0) + this.m;
                if (this.f6562b == null || this.f6563c < V2) {
                    this.f6562b = dVar;
                    this.f6563c = V2;
                    this.f6571l = V2;
                }
            }
            this.f6573o++;
        }

        /* JADX WARN: Removed duplicated region for block: B:870:0x01f2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b(int r17, boolean r18, boolean r19) {
            /*
                Method dump skipped, instructions count: 732
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: y0.f.a.b(int, boolean, boolean):void");
        }

        public final int c() {
            return this.f6561a == 1 ? this.m - f.this.S0 : this.m;
        }

        public final int d() {
            return this.f6561a == 0 ? this.f6571l - f.this.R0 : this.f6571l;
        }

        public final void e(int i7) {
            int r6;
            int i8;
            int i9;
            int i10 = this.f6574p;
            if (i10 == 0) {
                return;
            }
            int i11 = this.f6573o;
            int i12 = i7 / i10;
            for (int i13 = 0; i13 < i11; i13++) {
                int i14 = this.f6572n + i13;
                f fVar = f.this;
                if (i14 >= fVar.f6560d1) {
                    break;
                }
                d dVar = fVar.c1[i14];
                int i15 = 1;
                if (this.f6561a == 0) {
                    if (dVar != null) {
                        int[] iArr = dVar.V;
                        if (iArr[0] == 3 && dVar.s == 0) {
                            i9 = iArr[1];
                            i8 = dVar.l();
                            r6 = i12;
                            fVar.T(dVar, i15, r6, i9, i8);
                        }
                    }
                } else {
                    if (dVar != null) {
                        int[] iArr2 = dVar.V;
                        if (iArr2[1] == 3 && dVar.f6544t == 0) {
                            int i16 = iArr2[0];
                            r6 = dVar.r();
                            i8 = i12;
                            i9 = 1;
                            i15 = i16;
                            fVar.T(dVar, i15, r6, i9, i8);
                        }
                    }
                }
            }
            this.f6571l = 0;
            this.m = 0;
            this.f6562b = null;
            this.f6563c = 0;
            int i17 = this.f6573o;
            for (int i18 = 0; i18 < i17; i18++) {
                int i19 = this.f6572n + i18;
                f fVar2 = f.this;
                if (i19 >= fVar2.f6560d1) {
                    return;
                }
                d dVar2 = fVar2.c1[i19];
                if (this.f6561a == 0) {
                    int r7 = dVar2.r();
                    f fVar3 = f.this;
                    int i20 = fVar3.R0;
                    if (dVar2.f6528j0 == 8) {
                        i20 = 0;
                    }
                    this.f6571l = r7 + i20 + this.f6571l;
                    int U = fVar3.U(this.f6575q, dVar2);
                    if (this.f6562b == null || this.f6563c < U) {
                        this.f6562b = dVar2;
                        this.f6563c = U;
                        this.m = U;
                    }
                } else {
                    int V = fVar2.V(this.f6575q, dVar2);
                    int U2 = f.this.U(this.f6575q, dVar2);
                    int i21 = f.this.S0;
                    if (dVar2.f6528j0 == 8) {
                        i21 = 0;
                    }
                    this.m = U2 + i21 + this.m;
                    if (this.f6562b == null || this.f6563c < V) {
                        this.f6562b = dVar2;
                        this.f6563c = V;
                        this.f6571l = V;
                    }
                }
            }
        }

        public final void f(int i7, c cVar, c cVar2, c cVar3, c cVar4, int i8, int i9, int i10, int i11, int i12) {
            this.f6561a = i7;
            this.f6564d = cVar;
            this.e = cVar2;
            this.f6565f = cVar3;
            this.f6566g = cVar4;
            this.f6567h = i8;
            this.f6568i = i9;
            this.f6569j = i10;
            this.f6570k = i11;
            this.f6575q = i12;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:1499:0x00ae, code lost:
        if (r8.G0 == (-1)) goto L462;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1505:0x00b9, code lost:
        if (r8.G0 == (-1)) goto L462;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1506:0x00bb, code lost:
        r8.G0 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1668:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:1846:0x07d6  */
    /* JADX WARN: Removed duplicated region for block: B:1847:0x07d8  */
    /* JADX WARN: Removed duplicated region for block: B:1853:0x07e6  */
    /* JADX WARN: Removed duplicated region for block: B:1854:0x07e8  */
    /* JADX WARN: Removed duplicated region for block: B:1861:0x0802  */
    /* JADX WARN: Removed duplicated region for block: B:1862:0x0804  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:1735:0x04e2 -> B:1736:0x04ef). Please submit an issue!!! */
    @Override // y0.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void S(int r35, int r36, int r37, int r38) {
        /*
            Method dump skipped, instructions count: 2056
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.f.S(int, int, int, int):void");
    }

    public final int U(int i7, d dVar) {
        if (dVar == null) {
            return 0;
        }
        if (dVar.V[1] == 3) {
            int i8 = dVar.f6544t;
            if (i8 == 0) {
                return 0;
            }
            if (i8 == 2) {
                int i9 = (int) (dVar.A * i7);
                if (i9 != dVar.l()) {
                    dVar.f6521g = true;
                    T(dVar, dVar.V[0], dVar.r(), 1, i9);
                }
                return i9;
            } else if (i8 == 1) {
                return dVar.l();
            } else {
                if (i8 == 3) {
                    return (int) ((dVar.r() * dVar.Z) + 0.5f);
                }
            }
        }
        return dVar.l();
    }

    public final int V(int i7, d dVar) {
        if (dVar == null) {
            return 0;
        }
        if (dVar.V[0] == 3) {
            int i8 = dVar.s;
            if (i8 == 0) {
                return 0;
            }
            if (i8 == 2) {
                int i9 = (int) (dVar.f6548x * i7);
                if (i9 != dVar.r()) {
                    dVar.f6521g = true;
                    T(dVar, 1, i9, dVar.V[1], dVar.l());
                }
                return i9;
            } else if (i8 == 1) {
                return dVar.r();
            } else {
                if (i8 == 3) {
                    return (int) ((dVar.l() * dVar.Z) + 0.5f);
                }
            }
        }
        return dVar.r();
    }

    @Override // y0.d
    public final void c(w0.d dVar, boolean z6) {
        d dVar2;
        float f7;
        int i7;
        super.c(dVar, z6);
        d dVar3 = this.W;
        boolean z7 = dVar3 != null && ((e) dVar3).f6555x0;
        int i8 = this.V0;
        if (i8 != 0) {
            if (i8 == 1) {
                int size = this.Y0.size();
                int i9 = 0;
                while (i9 < size) {
                    this.Y0.get(i9).b(i9, z7, i9 == size + (-1));
                    i9++;
                }
            } else if (i8 != 2) {
                if (i8 == 3) {
                    int size2 = this.Y0.size();
                    int i10 = 0;
                    while (i10 < size2) {
                        this.Y0.get(i10).b(i10, z7, i10 == size2 + (-1));
                        i10++;
                    }
                }
            } else if (this.f6559b1 != null && this.f6558a1 != null && this.Z0 != null) {
                for (int i11 = 0; i11 < this.f6560d1; i11++) {
                    this.c1[i11].E();
                }
                int[] iArr = this.f6559b1;
                int i12 = iArr[0];
                int i13 = iArr[1];
                d dVar4 = null;
                float f8 = this.L0;
                int i14 = 0;
                while (i14 < i12) {
                    if (z7) {
                        i7 = (i12 - i14) - 1;
                        f7 = 1.0f - this.L0;
                    } else {
                        f7 = f8;
                        i7 = i14;
                    }
                    d dVar5 = this.f6558a1[i7];
                    if (dVar5 != null && dVar5.f6528j0 != 8) {
                        if (i14 == 0) {
                            dVar5.g(dVar5.K, this.K, this.f6589y0);
                            dVar5.f6532l0 = this.F0;
                            dVar5.f6522g0 = f7;
                        }
                        if (i14 == i12 - 1) {
                            dVar5.g(dVar5.M, this.M, this.f6590z0);
                        }
                        if (i14 > 0 && dVar4 != null) {
                            dVar5.g(dVar5.K, dVar4.M, this.R0);
                            dVar4.g(dVar4.M, dVar5.K, 0);
                        }
                        dVar4 = dVar5;
                    }
                    i14++;
                    f8 = f7;
                }
                for (int i15 = 0; i15 < i13; i15++) {
                    d dVar6 = this.Z0[i15];
                    if (dVar6 != null && dVar6.f6528j0 != 8) {
                        if (i15 == 0) {
                            dVar6.g(dVar6.L, this.L, this.f6585u0);
                            dVar6.f6533m0 = this.G0;
                            dVar6.f6524h0 = this.M0;
                        }
                        if (i15 == i13 - 1) {
                            dVar6.g(dVar6.N, this.N, this.f6586v0);
                        }
                        if (i15 > 0 && dVar4 != null) {
                            dVar6.g(dVar6.L, dVar4.N, this.S0);
                            dVar4.g(dVar4.N, dVar6.L, 0);
                        }
                        dVar4 = dVar6;
                    }
                }
                for (int i16 = 0; i16 < i12; i16++) {
                    for (int i17 = 0; i17 < i13; i17++) {
                        int i18 = (i17 * i12) + i16;
                        if (this.X0 == 1) {
                            i18 = (i16 * i13) + i17;
                        }
                        d[] dVarArr = this.c1;
                        if (i18 < dVarArr.length && (dVar2 = dVarArr[i18]) != null && dVar2.f6528j0 != 8) {
                            d dVar7 = this.f6558a1[i16];
                            d dVar8 = this.Z0[i17];
                            if (dVar2 != dVar7) {
                                dVar2.g(dVar2.K, dVar7.K, 0);
                                dVar2.g(dVar2.M, dVar7.M, 0);
                            }
                            if (dVar2 != dVar8) {
                                dVar2.g(dVar2.L, dVar8.L, 0);
                                dVar2.g(dVar2.N, dVar8.N, 0);
                            }
                        }
                    }
                }
            }
        } else if (this.Y0.size() > 0) {
            this.Y0.get(0).b(0, z7, true);
        }
        this.A0 = false;
    }
}
