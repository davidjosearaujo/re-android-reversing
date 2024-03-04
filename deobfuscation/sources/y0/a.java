package y0;

import androidx.fragment.app.s0;
import y0.c;

/* loaded from: classes.dex */
public final class a extends i {

    /* renamed from: u0 */
    public int f6475u0 = 0;

    /* renamed from: v0 */
    public boolean f6476v0 = true;

    /* renamed from: w0 */
    public int f6477w0 = 0;

    /* renamed from: x0 */
    public boolean f6478x0 = false;

    @Override // y0.d
    public final boolean B() {
        return this.f6478x0;
    }

    @Override // y0.d
    public final boolean C() {
        return this.f6478x0;
    }

    public final boolean S() {
        int i7;
        c j5;
        c j7;
        c j8;
        int i8;
        int i9;
        c.a aVar = c.a.BOTTOM;
        c.a aVar2 = c.a.TOP;
        c.a aVar3 = c.a.RIGHT;
        c.a aVar4 = c.a.LEFT;
        int i10 = 0;
        boolean z6 = true;
        while (true) {
            i7 = this.f6584t0;
            if (i10 >= i7) {
                break;
            }
            d dVar = this.f6583s0[i10];
            if ((this.f6476v0 || dVar.d()) && ((((i8 = this.f6475u0) == 0 || i8 == 1) && !dVar.B()) || (((i9 = this.f6475u0) == 2 || i9 == 3) && !dVar.C()))) {
                z6 = false;
            }
            i10++;
        }
        if (!z6 || i7 <= 0) {
            return false;
        }
        int i11 = 0;
        boolean z7 = false;
        for (int i12 = 0; i12 < this.f6584t0; i12++) {
            d dVar2 = this.f6583s0[i12];
            if (this.f6476v0 || dVar2.d()) {
                if (!z7) {
                    int i13 = this.f6475u0;
                    if (i13 == 0) {
                        j8 = dVar2.j(aVar4);
                    } else if (i13 == 1) {
                        j8 = dVar2.j(aVar3);
                    } else if (i13 == 2) {
                        j8 = dVar2.j(aVar2);
                    } else {
                        if (i13 == 3) {
                            j8 = dVar2.j(aVar);
                        }
                        z7 = true;
                    }
                    i11 = j8.d();
                    z7 = true;
                }
                int i14 = this.f6475u0;
                if (i14 == 0) {
                    j7 = dVar2.j(aVar4);
                } else {
                    if (i14 == 1) {
                        j5 = dVar2.j(aVar3);
                    } else if (i14 == 2) {
                        j7 = dVar2.j(aVar2);
                    } else if (i14 == 3) {
                        j5 = dVar2.j(aVar);
                    }
                    i11 = Math.max(i11, j5.d());
                }
                i11 = Math.min(i11, j7.d());
            }
        }
        int i15 = i11 + this.f6477w0;
        int i16 = this.f6475u0;
        if (i16 == 0 || i16 == 1) {
            J(i15, i15);
        } else {
            K(i15, i15);
        }
        this.f6478x0 = true;
        return true;
    }

    public final int T() {
        int i7 = this.f6475u0;
        if (i7 == 0 || i7 == 1) {
            return 0;
        }
        return (i7 == 2 || i7 == 3) ? 1 : -1;
    }

    @Override // y0.d
    public final void c(w0.d dVar, boolean z6) {
        c[] cVarArr;
        boolean z7;
        w0.f fVar;
        c cVar;
        int i7;
        int i8;
        w0.f fVar2;
        int i9;
        c[] cVarArr2 = this.S;
        cVarArr2[0] = this.K;
        cVarArr2[2] = this.L;
        cVarArr2[1] = this.M;
        cVarArr2[3] = this.N;
        int i10 = 0;
        while (true) {
            cVarArr = this.S;
            if (i10 >= cVarArr.length) {
                break;
            }
            c cVar2 = cVarArr[i10];
            cVar2.f6501i = dVar.l(cVar2);
            i10++;
        }
        int i11 = this.f6475u0;
        if (i11 < 0 || i11 >= 4) {
            return;
        }
        c cVar3 = cVarArr[i11];
        if (!this.f6478x0) {
            S();
        }
        if (this.f6478x0) {
            this.f6478x0 = false;
            int i12 = this.f6475u0;
            if (i12 == 0 || i12 == 1) {
                dVar.d(this.K.f6501i, this.f6513b0);
                fVar2 = this.M.f6501i;
                i9 = this.f6513b0;
            } else if (i12 != 2 && i12 != 3) {
                return;
            } else {
                dVar.d(this.L.f6501i, this.f6515c0);
                fVar2 = this.N.f6501i;
                i9 = this.f6515c0;
            }
            dVar.d(fVar2, i9);
            return;
        }
        for (int i13 = 0; i13 < this.f6584t0; i13++) {
            d dVar2 = this.f6583s0[i13];
            if ((this.f6476v0 || dVar2.d()) && ((((i8 = this.f6475u0) == 0 || i8 == 1) && dVar2.V[0] == 3 && dVar2.K.f6498f != null && dVar2.M.f6498f != null) || ((i8 == 2 || i8 == 3) && dVar2.V[1] == 3 && dVar2.L.f6498f != null && dVar2.N.f6498f != null))) {
                z7 = true;
                break;
            }
        }
        z7 = false;
        boolean z8 = this.K.g() || this.M.g();
        boolean z9 = this.L.g() || this.N.g();
        int i14 = !z7 && (((i7 = this.f6475u0) == 0 && z8) || ((i7 == 2 && z9) || ((i7 == 1 && z8) || (i7 == 3 && z9)))) ? 5 : 4;
        for (int i15 = 0; i15 < this.f6584t0; i15++) {
            d dVar3 = this.f6583s0[i15];
            if (this.f6476v0 || dVar3.d()) {
                w0.f l6 = dVar.l(dVar3.S[this.f6475u0]);
                c[] cVarArr3 = dVar3.S;
                int i16 = this.f6475u0;
                c cVar4 = cVarArr3[i16];
                cVar4.f6501i = l6;
                c cVar5 = cVar4.f6498f;
                int i17 = (cVar5 == null || cVar5.f6497d != this) ? 0 : cVar4.f6499g + 0;
                if (i16 == 0 || i16 == 2) {
                    w0.b m = dVar.m();
                    w0.f n6 = dVar.n();
                    n6.f6365i = 0;
                    m.d(cVar3.f6501i, l6, n6, this.f6477w0 - i17);
                    dVar.c(m);
                } else {
                    w0.b m3 = dVar.m();
                    w0.f n7 = dVar.n();
                    n7.f6365i = 0;
                    m3.c(cVar3.f6501i, l6, n7, this.f6477w0 + i17);
                    dVar.c(m3);
                }
                dVar.e(cVar3.f6501i, l6, this.f6477w0 + i17, i14);
            }
        }
        int i18 = this.f6475u0;
        if (i18 == 0) {
            dVar.e(this.M.f6501i, this.K.f6501i, 0, 8);
            dVar.e(this.K.f6501i, this.W.M.f6501i, 0, 4);
            fVar = this.K.f6501i;
            cVar = this.W.K;
        } else if (i18 == 1) {
            dVar.e(this.K.f6501i, this.M.f6501i, 0, 8);
            dVar.e(this.K.f6501i, this.W.K.f6501i, 0, 4);
            fVar = this.K.f6501i;
            cVar = this.W.M;
        } else if (i18 == 2) {
            dVar.e(this.N.f6501i, this.L.f6501i, 0, 8);
            dVar.e(this.L.f6501i, this.W.N.f6501i, 0, 4);
            fVar = this.L.f6501i;
            cVar = this.W.L;
        } else if (i18 != 3) {
            return;
        } else {
            dVar.e(this.L.f6501i, this.N.f6501i, 0, 8);
            dVar.e(this.L.f6501i, this.W.L.f6501i, 0, 4);
            fVar = this.L.f6501i;
            cVar = this.W.N;
        }
        dVar.e(fVar, cVar.f6501i, 0, 0);
    }

    @Override // y0.d
    public final boolean d() {
        return true;
    }

    @Override // y0.d
    public final String toString() {
        String c7 = androidx.activity.h.c(androidx.activity.h.d("[Barrier] "), this.f6530k0, " {");
        for (int i7 = 0; i7 < this.f6584t0; i7++) {
            d dVar = this.f6583s0[i7];
            if (i7 > 0) {
                c7 = s0.h(c7, ", ");
            }
            StringBuilder d7 = androidx.activity.h.d(c7);
            d7.append(dVar.f6530k0);
            c7 = d7.toString();
        }
        return s0.h(c7, "}");
    }
}
