package z0;

import java.util.Iterator;
import y0.a;
import y0.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k extends p {
    public k(d dVar) {
        super(dVar);
    }

    @Override // z0.p, z0.d
    public final void a(d dVar) {
        a aVar = (a) this.f6895b;
        int i7 = aVar.f6475u0;
        Iterator it = this.f6900h.f6882l.iterator();
        int i8 = 0;
        int i9 = -1;
        while (it.hasNext()) {
            int i10 = ((f) it.next()).f6877g;
            if (i9 == -1 || i10 < i9) {
                i9 = i10;
            }
            if (i8 < i10) {
                i8 = i10;
            }
        }
        if (i7 == 0 || i7 == 2) {
            this.f6900h.d(i9 + aVar.f6477w0);
        } else {
            this.f6900h.d(i8 + aVar.f6477w0);
        }
    }

    @Override // z0.p
    public final void d() {
        p pVar;
        d dVar = this.f6895b;
        if (dVar instanceof a) {
            f fVar = this.f6900h;
            fVar.f6873b = true;
            a aVar = (a) dVar;
            int i7 = aVar.f6475u0;
            boolean z6 = aVar.f6476v0;
            int i8 = 0;
            if (i7 == 0) {
                fVar.e = 4;
                while (i8 < aVar.f6584t0) {
                    d dVar2 = aVar.f6583s0[i8];
                    if (z6 || dVar2.f6528j0 != 8) {
                        f fVar2 = dVar2.f6516d.f6900h;
                        fVar2.f6881k.add(this.f6900h);
                        this.f6900h.f6882l.add(fVar2);
                    }
                    i8++;
                }
            } else if (i7 != 1) {
                if (i7 == 2) {
                    fVar.e = 6;
                    while (i8 < aVar.f6584t0) {
                        d dVar3 = aVar.f6583s0[i8];
                        if (z6 || dVar3.f6528j0 != 8) {
                            f fVar3 = dVar3.e.f6900h;
                            fVar3.f6881k.add(this.f6900h);
                            this.f6900h.f6882l.add(fVar3);
                        }
                        i8++;
                    }
                } else if (i7 == 3) {
                    fVar.e = 7;
                    while (i8 < aVar.f6584t0) {
                        d dVar4 = aVar.f6583s0[i8];
                        if (z6 || dVar4.f6528j0 != 8) {
                            f fVar4 = dVar4.e.f6901i;
                            fVar4.f6881k.add(this.f6900h);
                            this.f6900h.f6882l.add(fVar4);
                        }
                        i8++;
                    }
                } else {
                    return;
                }
                m(this.f6895b.e.f6900h);
                pVar = this.f6895b.e;
                m(pVar.f6901i);
            } else {
                fVar.e = 5;
                while (i8 < aVar.f6584t0) {
                    d dVar5 = aVar.f6583s0[i8];
                    if (z6 || dVar5.f6528j0 != 8) {
                        f fVar5 = dVar5.f6516d.f6901i;
                        fVar5.f6881k.add(this.f6900h);
                        this.f6900h.f6882l.add(fVar5);
                    }
                    i8++;
                }
            }
            m(this.f6895b.f6516d.f6900h);
            pVar = this.f6895b.f6516d;
            m(pVar.f6901i);
        }
    }

    @Override // z0.p
    public final void e() {
        d dVar = this.f6895b;
        if (dVar instanceof a) {
            int i7 = ((a) dVar).f6475u0;
            if (i7 == 0 || i7 == 1) {
                dVar.f6513b0 = this.f6900h.f6877g;
            } else {
                dVar.f6515c0 = this.f6900h.f6877g;
            }
        }
    }

    @Override // z0.p
    public final void f() {
        this.f6896c = null;
        this.f6900h.c();
    }

    @Override // z0.p
    public final boolean k() {
        return false;
    }

    public final void m(f fVar) {
        this.f6900h.f6881k.add(fVar);
        fVar.f6882l.add(this.f6900h);
    }
}
