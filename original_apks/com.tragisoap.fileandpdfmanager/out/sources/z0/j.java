package z0;

import y0.d;
import y0.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j extends p {
    public j(d dVar) {
        super(dVar);
        dVar.f6516d.f();
        dVar.e.f();
        this.f6898f = ((g) dVar).f6581w0;
    }

    @Override // z0.p, z0.d
    public final void a(d dVar) {
        f fVar = this.f6900h;
        if (fVar.f6874c && !fVar.f6880j) {
            this.f6900h.d((int) ((((float) ((f) fVar.f6882l.get(0)).f6877g) * ((g) this.f6895b).f6577s0) + 0.5f));
        }
    }

    @Override // z0.p
    public final void d() {
        p pVar;
        d dVar = this.f6895b;
        g gVar = (g) dVar;
        int i7 = gVar.f6578t0;
        int i8 = gVar.f6579u0;
        if (gVar.f6581w0 == 1) {
            f fVar = this.f6900h;
            if (i7 != -1) {
                fVar.f6882l.add(dVar.W.f6516d.f6900h);
                this.f6895b.W.f6516d.f6900h.f6881k.add(this.f6900h);
                this.f6900h.f6876f = i7;
            } else if (i8 != -1) {
                fVar.f6882l.add(dVar.W.f6516d.f6901i);
                this.f6895b.W.f6516d.f6901i.f6881k.add(this.f6900h);
                this.f6900h.f6876f = -i8;
            } else {
                fVar.f6873b = true;
                fVar.f6882l.add(dVar.W.f6516d.f6901i);
                this.f6895b.W.f6516d.f6901i.f6881k.add(this.f6900h);
            }
            m(this.f6895b.f6516d.f6900h);
            pVar = this.f6895b.f6516d;
        } else {
            f fVar2 = this.f6900h;
            if (i7 != -1) {
                fVar2.f6882l.add(dVar.W.e.f6900h);
                this.f6895b.W.e.f6900h.f6881k.add(this.f6900h);
                this.f6900h.f6876f = i7;
            } else if (i8 != -1) {
                fVar2.f6882l.add(dVar.W.e.f6901i);
                this.f6895b.W.e.f6901i.f6881k.add(this.f6900h);
                this.f6900h.f6876f = -i8;
            } else {
                fVar2.f6873b = true;
                fVar2.f6882l.add(dVar.W.e.f6901i);
                this.f6895b.W.e.f6901i.f6881k.add(this.f6900h);
            }
            m(this.f6895b.e.f6900h);
            pVar = this.f6895b.e;
        }
        m(pVar.f6901i);
    }

    @Override // z0.p
    public final void e() {
        d dVar = this.f6895b;
        int i7 = ((g) dVar).f6581w0;
        int i8 = this.f6900h.f6877g;
        if (i7 == 1) {
            dVar.f6513b0 = i8;
        } else {
            dVar.f6515c0 = i8;
        }
    }

    @Override // z0.p
    public final void f() {
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
