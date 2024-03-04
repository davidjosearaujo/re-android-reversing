package z0;

/* loaded from: classes.dex */
public final class n extends p {

    /* renamed from: k */
    public f f6887k;

    /* renamed from: l */
    public a f6888l;

    public n(y0.d dVar) {
        super(dVar);
        f fVar = new f(this);
        this.f6887k = fVar;
        this.f6888l = null;
        this.f6900h.e = 6;
        this.f6901i.e = 7;
        fVar.e = 8;
        this.f6898f = 1;
    }

    @Override // z0.p, z0.d
    public final void a(d dVar) {
        g gVar;
        float f7;
        int i7;
        g gVar2;
        if (p.p.a(this.f6902j) == 3) {
            y0.d dVar2 = this.f6895b;
            l(dVar2.L, dVar2.N, 1);
            return;
        }
        g gVar3 = this.e;
        if (gVar3.f6874c && !gVar3.f6880j && this.f6897d == 3) {
            y0.d dVar3 = this.f6895b;
            int i8 = dVar3.f6544t;
            if (i8 == 2) {
                y0.d dVar4 = dVar3.W;
                if (dVar4 != null) {
                    if (dVar4.e.e.f6880j) {
                        f7 = gVar.f6877g * dVar3.A;
                        i7 = (int) (f7 + 0.5f);
                    }
                }
            } else if (i8 == 3) {
                if (dVar3.f6516d.e.f6880j) {
                    int i9 = dVar3.f6511a0;
                    if (i9 != -1) {
                        if (i9 == 0) {
                            f7 = gVar2.f6877g * dVar3.Z;
                            i7 = (int) (f7 + 0.5f);
                        } else if (i9 != 1) {
                            i7 = 0;
                        }
                    }
                    f7 = gVar2.f6877g / dVar3.Z;
                    i7 = (int) (f7 + 0.5f);
                }
            }
            gVar3.d(i7);
        }
        f fVar = this.f6900h;
        if (fVar.f6874c) {
            f fVar2 = this.f6901i;
            if (fVar2.f6874c) {
                if (fVar.f6880j && fVar2.f6880j && this.e.f6880j) {
                    return;
                }
                if (!this.e.f6880j && this.f6897d == 3) {
                    y0.d dVar5 = this.f6895b;
                    if (dVar5.s == 0 && !dVar5.z()) {
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
                    int i16 = fVar6.f6876f + i15;
                    int i17 = fVar5.f6877g;
                    int i18 = this.f6901i.f6876f + i17;
                    float f8 = this.f6895b.f6524h0;
                    if (fVar4 == fVar5) {
                        f8 = 0.5f;
                    } else {
                        i15 = i16;
                        i17 = i18;
                    }
                    fVar6.d((int) ((((i17 - i15) - this.e.f6877g) * f8) + i15 + 0.5f));
                    this.f6901i.d(this.f6900h.f6877g + this.e.f6877g);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:625:0x02b5, code lost:
        if (r10.f6895b.F != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:639:0x02f8, code lost:
        if (r0.f6897d == 3) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:646:0x0326, code lost:
        if (r10.f6895b.F != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:647:0x0328, code lost:
        r0 = r10.f6887k;
        r1 = r10.f6900h;
        r3 = r10.f6888l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:666:0x0390, code lost:
        if (r0.f6897d == 3) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:667:0x0392, code lost:
        r0.e.f6881k.add(r10.e);
        r10.e.f6882l.add(r10.f6895b.f6516d.e);
        r10.e.f6872a = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:670:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:683:? A[RETURN, SYNTHETIC] */
    @Override // z0.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 955
            To view this dump change 'Code comments level' option to 'DEBUG'
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
        StringBuilder d7 = androidx.activity.h.d("VerticalRun ");
        d7.append(this.f6895b.f6530k0);
        return d7.toString();
    }
}
