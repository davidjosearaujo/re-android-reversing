package z0;

import java.util.ArrayList;
import y0.c;
import y0.d;
import y0.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l extends p {

    /* renamed from: k */
    public static int[] f6884k = new int[2];

    public l(d dVar) {
        super(dVar);
        this.f6900h.e = 4;
        this.f6901i.e = 5;
        this.f6898f = 0;
    }

    public static void m(int[] iArr, int i7, int i8, int i9, int i10, float f7, int i11) {
        int i12 = i8 - i7;
        int i13 = i10 - i9;
        if (i11 == -1) {
            int i14 = (int) ((((float) i13) * f7) + 0.5f);
            int i15 = (int) ((((float) i12) / f7) + 0.5f);
            if (i14 <= i12) {
                iArr[0] = i14;
                iArr[1] = i13;
            } else if (i15 <= i13) {
                iArr[0] = i12;
                iArr[1] = i15;
            }
        } else if (i11 == 0) {
            iArr[0] = (int) ((((float) i13) * f7) + 0.5f);
            iArr[1] = i13;
        } else if (i11 == 1) {
            iArr[0] = i12;
            iArr[1] = (int) ((((float) i12) * f7) + 0.5f);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0250, code lost:
        if (r15 != 1) goto L_0x029f;
     */
    @Override // z0.p, z0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(z0.d r21) {
        /*
            Method dump skipped, instructions count: 961
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.l.a(z0.d):void");
    }

    @Override // z0.p
    public final void d() {
        c cVar;
        f fVar;
        d dVar;
        Object obj;
        ArrayList arrayList;
        f fVar2;
        int i7;
        f fVar3;
        f fVar4;
        d dVar2;
        d dVar3;
        int i8;
        d dVar4;
        int i9;
        d dVar5 = this.f6895b;
        if (dVar5.f6510a) {
            this.e.d(dVar5.r());
        }
        g gVar = this.e;
        if (!gVar.f6880j) {
            d dVar6 = this.f6895b;
            int i10 = dVar6.V[0];
            this.f6897d = i10;
            if (i10 != 3) {
                if (i10 == 4 && (dVar4 = dVar6.W) != null && ((i9 = dVar4.V[0]) == 1 || i9 == 4)) {
                    int r6 = (dVar4.r() - this.f6895b.K.e()) - this.f6895b.M.e();
                    p.b(this.f6900h, dVar4.f6516d.f6900h, this.f6895b.K.e());
                    p.b(this.f6901i, dVar4.f6516d.f6901i, -this.f6895b.M.e());
                    this.e.d(r6);
                    return;
                } else if (i10 == 1) {
                    gVar.d(dVar6.r());
                }
            }
        } else if (this.f6897d == 4 && (dVar3 = (dVar2 = this.f6895b).W) != null && ((i8 = dVar3.V[0]) == 1 || i8 == 4)) {
            p.b(this.f6900h, dVar3.f6516d.f6900h, dVar2.K.e());
            p.b(this.f6901i, dVar3.f6516d.f6901i, -this.f6895b.M.e());
            return;
        }
        g gVar2 = this.e;
        if (gVar2.f6880j) {
            d dVar7 = this.f6895b;
            if (dVar7.f6510a) {
                c[] cVarArr = dVar7.S;
                c cVar2 = cVarArr[0];
                c cVar3 = cVar2.f6498f;
                if (cVar3 == null || cVarArr[1].f6498f == null) {
                    if (cVar3 != null) {
                        f h7 = p.h(cVar2);
                        if (h7 != null) {
                            p.b(this.f6900h, h7, this.f6895b.S[0].e());
                        } else {
                            return;
                        }
                    } else {
                        c cVar4 = cVarArr[1];
                        if (cVar4.f6498f != null) {
                            f h8 = p.h(cVar4);
                            if (h8 != null) {
                                p.b(this.f6901i, h8, -this.f6895b.S[1].e());
                                fVar4 = this.f6900h;
                                fVar3 = this.f6901i;
                                i7 = -this.e.f6877g;
                                p.b(fVar4, fVar3, i7);
                                return;
                            }
                            return;
                        } else if (!(dVar7 instanceof h) && dVar7.W != null && dVar7.j(c.a.CENTER).f6498f == null) {
                            d dVar8 = this.f6895b;
                            p.b(this.f6900h, dVar8.W.f6516d.f6900h, dVar8.s());
                        } else {
                            return;
                        }
                    }
                    fVar4 = this.f6901i;
                    fVar3 = this.f6900h;
                    i7 = this.e.f6877g;
                    p.b(fVar4, fVar3, i7);
                    return;
                } else if (dVar7.y()) {
                    this.f6900h.f6876f = this.f6895b.S[0].e();
                    fVar = this.f6901i;
                    cVar = this.f6895b.S[1];
                    fVar.f6876f = -cVar.e();
                } else {
                    f h9 = p.h(this.f6895b.S[0]);
                    if (h9 != null) {
                        p.b(this.f6900h, h9, this.f6895b.S[0].e());
                    }
                    f h10 = p.h(this.f6895b.S[1]);
                    if (h10 != null) {
                        p.b(this.f6901i, h10, -this.f6895b.S[1].e());
                    }
                    this.f6900h.f6873b = true;
                    this.f6901i.f6873b = true;
                    return;
                }
            }
        }
        if (this.f6897d == 3) {
            d dVar9 = this.f6895b;
            int i11 = dVar9.s;
            if (i11 == 2) {
                d dVar10 = dVar9.W;
                if (dVar10 != null) {
                    g gVar3 = dVar10.e.e;
                    gVar2.f6882l.add(gVar3);
                    gVar3.f6881k.add(this.e);
                    g gVar4 = this.e;
                    gVar4.f6873b = true;
                    gVar4.f6881k.add(this.f6900h);
                    arrayList = this.e.f6881k;
                    obj = this.f6901i;
                    arrayList.add(obj);
                }
            } else if (i11 == 3) {
                if (dVar9.f6544t == 3) {
                    this.f6900h.f6872a = this;
                    this.f6901i.f6872a = this;
                    n nVar = dVar9.e;
                    nVar.f6900h.f6872a = this;
                    nVar.f6901i.f6872a = this;
                    gVar2.f6872a = this;
                    if (dVar9.z()) {
                        this.e.f6882l.add(this.f6895b.e.e);
                        this.f6895b.e.e.f6881k.add(this.e);
                        n nVar2 = this.f6895b.e;
                        nVar2.e.f6872a = this;
                        this.e.f6882l.add(nVar2.f6900h);
                        this.e.f6882l.add(this.f6895b.e.f6901i);
                        this.f6895b.e.f6900h.f6881k.add(this.e);
                        arrayList = this.f6895b.e.f6901i.f6881k;
                        obj = this.e;
                        arrayList.add(obj);
                    } else if (this.f6895b.y()) {
                        this.f6895b.e.e.f6882l.add(this.e);
                        arrayList = this.e.f6881k;
                        obj = this.f6895b.e.e;
                        arrayList.add(obj);
                    } else {
                        fVar2 = this.f6895b.e.e;
                    }
                } else {
                    g gVar5 = dVar9.e.e;
                    gVar2.f6882l.add(gVar5);
                    gVar5.f6881k.add(this.e);
                    this.f6895b.e.f6900h.f6881k.add(this.e);
                    this.f6895b.e.f6901i.f6881k.add(this.e);
                    g gVar6 = this.e;
                    gVar6.f6873b = true;
                    gVar6.f6881k.add(this.f6900h);
                    this.e.f6881k.add(this.f6901i);
                    this.f6900h.f6882l.add(this.e);
                    fVar2 = this.f6901i;
                }
                arrayList = fVar2.f6882l;
                obj = this.e;
                arrayList.add(obj);
            }
            fVar.f6876f = -cVar.e();
        }
        d dVar11 = this.f6895b;
        c[] cVarArr2 = dVar11.S;
        c cVar5 = cVarArr2[0];
        c cVar6 = cVar5.f6498f;
        if (cVar6 == null || cVarArr2[1].f6498f == null) {
            if (cVar6 != null) {
                f h11 = p.h(cVar5);
                if (h11 != null) {
                    p.b(this.f6900h, h11, this.f6895b.S[0].e());
                } else {
                    return;
                }
            } else {
                c cVar7 = cVarArr2[1];
                if (cVar7.f6498f != null) {
                    f h12 = p.h(cVar7);
                    if (h12 != null) {
                        p.b(this.f6901i, h12, -this.f6895b.S[1].e());
                        c(this.f6900h, this.f6901i, -1, this.e);
                        return;
                    }
                    return;
                } else if (!(dVar11 instanceof h) && (dVar = dVar11.W) != null) {
                    p.b(this.f6900h, dVar.f6516d.f6900h, dVar11.s());
                } else {
                    return;
                }
            }
            c(this.f6901i, this.f6900h, 1, this.e);
        } else if (dVar11.y()) {
            this.f6900h.f6876f = this.f6895b.S[0].e();
            fVar = this.f6901i;
            cVar = this.f6895b.S[1];
            fVar.f6876f = -cVar.e();
        } else {
            f h13 = p.h(this.f6895b.S[0]);
            f h14 = p.h(this.f6895b.S[1]);
            if (h13 != null) {
                h13.b(this);
            }
            if (h14 != null) {
                h14.b(this);
            }
            this.f6902j = 4;
        }
    }

    @Override // z0.p
    public final void e() {
        f fVar = this.f6900h;
        if (fVar.f6880j) {
            this.f6895b.f6513b0 = fVar.f6877g;
        }
    }

    @Override // z0.p
    public final void f() {
        this.f6896c = null;
        this.f6900h.c();
        this.f6901i.c();
        this.e.c();
        this.f6899g = false;
    }

    @Override // z0.p
    public final boolean k() {
        return this.f6897d != 3 || this.f6895b.s == 0;
    }

    public final void n() {
        this.f6899g = false;
        this.f6900h.c();
        this.f6900h.f6880j = false;
        this.f6901i.c();
        this.f6901i.f6880j = false;
        this.e.f6880j = false;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("HorizontalRun ");
        d7.append(this.f6895b.f6530k0);
        return d7.toString();
    }
}
