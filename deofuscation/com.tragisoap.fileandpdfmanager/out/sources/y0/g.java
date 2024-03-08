package y0;

import w0.b;
import w0.d;
import w0.f;
import y0.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g extends d {

    /* renamed from: s0 */
    public float f6577s0 = -1.0f;

    /* renamed from: t0 */
    public int f6578t0 = -1;

    /* renamed from: u0 */
    public int f6579u0 = -1;

    /* renamed from: v0 */
    public c f6580v0 = this.L;

    /* renamed from: w0 */
    public int f6581w0 = 0;

    /* renamed from: x0 */
    public boolean f6582x0;

    public g() {
        this.T.clear();
        this.T.add(this.f6580v0);
        int length = this.S.length;
        for (int i7 = 0; i7 < length; i7++) {
            this.S[i7] = this.f6580v0;
        }
    }

    @Override // y0.d
    public final boolean B() {
        return this.f6582x0;
    }

    @Override // y0.d
    public final boolean C() {
        return this.f6582x0;
    }

    @Override // y0.d
    public final void Q(d dVar, boolean z6) {
        if (this.W != null) {
            c cVar = this.f6580v0;
            dVar.getClass();
            int o6 = d.o(cVar);
            if (this.f6581w0 == 1) {
                this.f6513b0 = o6;
                this.f6515c0 = 0;
                L(this.W.l());
                O(0);
                return;
            }
            this.f6513b0 = 0;
            this.f6515c0 = o6;
            O(this.W.r());
            L(0);
        }
    }

    public final void R(int i7) {
        if (this.f6581w0 != i7) {
            this.f6581w0 = i7;
            this.T.clear();
            this.f6580v0 = this.f6581w0 == 1 ? this.K : this.L;
            this.T.add(this.f6580v0);
            int length = this.S.length;
            for (int i8 = 0; i8 < length; i8++) {
                this.S[i8] = this.f6580v0;
            }
        }
    }

    @Override // y0.d
    public final void c(d dVar, boolean z6) {
        f fVar;
        e eVar = (e) this.W;
        if (eVar != null) {
            Object j7 = eVar.j(c.a.LEFT);
            Object j8 = eVar.j(c.a.RIGHT);
            d dVar2 = this.W;
            boolean z7 = true;
            z7 = dVar2 != null && dVar2.V[0] == 2;
            if (this.f6581w0 == 0) {
                j7 = eVar.j(c.a.TOP);
                j8 = eVar.j(c.a.BOTTOM);
                d dVar3 = this.W;
                if (dVar3 == null || dVar3.V[1] != 2) {
                    z7 = false;
                }
            }
            if (this.f6582x0) {
                c cVar = this.f6580v0;
                if (cVar.f6496c) {
                    f l6 = dVar.l(cVar);
                    dVar.d(l6, this.f6580v0.d());
                    if (this.f6578t0 != -1) {
                        if (z7) {
                            fVar = dVar.l(j8);
                            dVar.f(fVar, l6, 0, 5);
                        }
                        this.f6582x0 = false;
                        return;
                    }
                    if (this.f6579u0 != -1 && z7) {
                        fVar = dVar.l(j8);
                        dVar.f(l6, dVar.l(j7), 0, 5);
                        dVar.f(fVar, l6, 0, 5);
                    }
                    this.f6582x0 = false;
                    return;
                }
            }
            if (this.f6578t0 != -1) {
                f l7 = dVar.l(this.f6580v0);
                dVar.e(l7, dVar.l(j7), this.f6578t0, 8);
                if (z7) {
                    dVar.f(dVar.l(j8), l7, 0, 5);
                }
            } else if (this.f6579u0 != -1) {
                f l8 = dVar.l(this.f6580v0);
                f l9 = dVar.l(j8);
                dVar.e(l8, l9, -this.f6579u0, 8);
                if (z7) {
                    dVar.f(l8, dVar.l(j7), 0, 5);
                    dVar.f(l9, l8, 0, 5);
                }
            } else if (this.f6577s0 != -1.0f) {
                f l10 = dVar.l(this.f6580v0);
                f l11 = dVar.l(j8);
                float f7 = this.f6577s0;
                b m = dVar.m();
                m.f6336d.b(l10, -1.0f);
                m.f6336d.b(l11, f7);
                dVar.c(m);
            }
        }
    }

    @Override // y0.d
    public final boolean d() {
        return true;
    }

    @Override // y0.d
    public final c j(c.a aVar) {
        int ordinal = aVar.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        return null;
                    }
                }
            }
            if (this.f6581w0 == 0) {
                return this.f6580v0;
            }
            return null;
        }
        if (this.f6581w0 == 1) {
            return this.f6580v0;
        }
        return null;
    }
}
