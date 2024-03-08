package z0;

import androidx.activity.h;
import p.p;
import y0.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class n extends p {

    /* renamed from: k */
    public f f6887k;

    /* renamed from: l */
    public a f6888l = null;

    public n(d dVar) {
        super(dVar);
        f fVar = new f(this);
        this.f6887k = fVar;
        this.f6900h.e = 6;
        this.f6901i.e = 7;
        fVar.e = 8;
        this.f6898f = 1;
    }

    @Override // z0.p, z0.d
    public final void a(d dVar) {
        int i7;
        float f7;
        if (p.a(this.f6902j) != 3) {
            g gVar = this.e;
            if (gVar.f6874c && !gVar.f6880j && this.f6897d == 3) {
                d dVar2 = this.f6895b;
                int i8 = dVar2.f6544t;
                if (i8 == 2) {
                    d dVar3 = dVar2.W;
                    if (dVar3 != null) {
                        g gVar2 = dVar3.e.e;
                        if (gVar2.f6880j) {
                            f7 = ((float) gVar2.f6877g) * dVar2.A;
                            i7 = (int) (f7 + 0.5f);
                        }
                    }
                } else if (i8 == 3) {
                    g gVar3 = dVar2.f6516d.e;
                    if (gVar3.f6880j) {
                        int i9 = dVar2.f6511a0;
                        if (i9 != -1) {
                            if (i9 == 0) {
                                f7 = ((float) gVar3.f6877g) * dVar2.Z;
                                i7 = (int) (f7 + 0.5f);
                            } else if (i9 != 1) {
                                i7 = 0;
                            }
                        }
                        f7 = ((float) gVar3.f6877g) / dVar2.Z;
                        i7 = (int) (f7 + 0.5f);
                    }
                }
                gVar.d(i7);
            }
            f fVar = this.f6900h;
            if (fVar.f6874c) {
                f fVar2 = this.f6901i;
                if (fVar2.f6874c) {
                    if (!fVar.f6880j || !fVar2.f6880j || !this.e.f6880j) {
                        if (!this.e.f6880j && this.f6897d == 3) {
                            d dVar4 = this.f6895b;
                            if (dVar4.s == 0 && !dVar4.z()) {
                                int i10 = ((f) this.f6900h.f6882l.get(0)).f6877g;
                                f fVar3 = this.f6900h;
                                int i11 = i10 + fVar3.f6876f;
                                int i12 = ((f) this.f6901i.f6882l.get(0)).f6877g + this.f6901i.f6876f;
                                fVar3.d(i11);
                                this.f6901i.d(i12);
                                this.e.d(i12 - i11);
                                return;
                            }
                        }
                        if (!this.e.f6880j && this.f6897d == 3 && this.f6894a == 1 && this.f6900h.f6882l.size() > 0 && this.f6901i.f6882l.size() > 0) {
                            int i13 = (((f) this.f6901i.f6882l.get(0)).f6877g + this.f6901i.f6876f) - (((f) this.f6900h.f6882l.get(0)).f6877g + this.f6900h.f6876f);
                            g gVar4 = this.e;
                            int i14 = gVar4.m;
                            if (i13 < i14) {
                                gVar4.d(i13);
                            } else {
                                gVar4.d(i14);
                            }
                        }
                        if (this.e.f6880j && this.f6900h.f6882l.size() > 0 && this.f6901i.f6882l.size() > 0) {
                            f fVar4 = (f) this.f6900h.f6882l.get(0);
                            f fVar5 = (f) this.f6901i.f6882l.get(0);
                            int i15 = fVar4.f6877g;
                            f fVar6 = this.f6900h;
                            i15 = fVar6.f6876f + i15;
                            int i16 = fVar5.f6877g;
                            i16 = this.f6901i.f6876f + i16;
                            float f8 = this.f6895b.f6524h0;
                            if (fVar4 == fVar5) {
                                f8 = 0.5f;
                            }
                            fVar6.d((int) ((((float) ((i16 - i15) - this.e.f6877g)) * f8) + ((float) i15) + 0.5f));
                            this.f6901i.d(this.f6900h.f6877g + this.e.f6877g);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        d dVar5 = this.f6895b;
        l(dVar5.L, dVar5.N, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x02b5, code lost:
        if (r10.f6895b.F != false) goto L_0x0328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02f8, code lost:
        if (r0.f6897d == 3) goto L_0x0392;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0326, code lost:
        if (r10.f6895b.F != false) goto L_0x0328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0328, code lost:
        r0 = r10.f6887k;
        r1 = r10.f6900h;
        r3 = r10.f6888l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0390, code lost:
        if (r0.f6897d == 3) goto L_0x0392;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0392, code lost:
        r0.e.f6881k.add(r10.e);
        r10.e.f6882l.add(r10.f6895b.f6516d.e);
        r10.e.f6872a = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    @Override // z0.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 955
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.n.d():void");
    }

    @Override // z0.p
    public final void e() {
        f fVar = this.f6900h;
        if (fVar.f6880j) {
            this.f6895b.f6515c0 = fVar.f6877g;
        }
    }

    @Override // z0.p
    public final void f() {
        this.f6896c = null;
        this.f6900h.c();
        this.f6901i.c();
        this.f6887k.c();
        this.e.c();
        this.f6899g = false;
    }

    @Override // z0.p
    public final boolean k() {
        return this.f6897d != 3 || this.f6895b.f6544t == 0;
    }

    public final void m() {
        this.f6899g = false;
        this.f6900h.c();
        this.f6900h.f6880j = false;
        this.f6901i.c();
        this.f6901i.f6880j = false;
        this.f6887k.c();
        this.f6887k.f6880j = false;
        this.e.f6880j = false;
    }

    public final String toString() {
        StringBuilder d7 = h.d("VerticalRun ");
        d7.append(this.f6895b.f6530k0);
        return d7.toString();
    }
}
