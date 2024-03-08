package a6;

import a0.b;
import a6.u0;
import f5.e;
import f5.g;
import f6.v;
import i2.c;
import i5.d;
import i5.f;
import q5.p;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class a<T> extends z0 implements d<T>, x {

    /* renamed from: h */
    public final f f280h;

    public a(f fVar, boolean z6) {
        super(z6);
        U((u0) fVar.e(u0.b.f341f));
        this.f280h = fVar.s(this);
    }

    @Override // a6.z0
    public final String B() {
        return getClass().getSimpleName() + " was cancelled";
    }

    @Override // a6.z0
    public final void T(c cVar) {
        w.a(this.f280h, cVar);
    }

    @Override // a6.z0
    public String Y() {
        return super.Y();
    }

    @Override // i5.d
    public final f a() {
        return this.f280h;
    }

    @Override // a6.z0, a6.u0
    public boolean b() {
        return super.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a6.z0
    public final void b0(Object obj) {
        if (obj instanceof o) {
            o oVar = (o) obj;
            Throwable th = oVar.f324a;
            oVar.getClass();
            j0(th, o.f323b.get(oVar) != 0);
            return;
        }
        k0(obj);
    }

    public void i0(Object obj) {
        w(obj);
    }

    public void j0(Throwable th, boolean z6) {
    }

    public void k0(T t5) {
    }

    @Override // a6.x
    public final f l() {
        return this.f280h;
    }

    public final void l0(int i7, a aVar, p pVar) {
        Object obj;
        if (i7 != 0) {
            int i8 = i7 - 1;
            if (i8 == 0) {
                try {
                    b.A(q2.a.A(q2.a.p(aVar, this, pVar)), g.f4141a, null);
                } catch (Throwable th) {
                    o(e.a(th));
                    throw th;
                }
            } else if (i8 == 1) {
            } else {
                if (i8 == 2) {
                    h.f(pVar, "<this>");
                    q2.a.A(q2.a.p(aVar, this, pVar)).o(g.f4141a);
                } else if (i8 == 3) {
                    try {
                        f fVar = this.f280h;
                        Object c7 = v.c(fVar, null);
                        r5.v.b(2, pVar);
                        obj = pVar.i(aVar, this);
                        v.a(fVar, c7);
                        if (obj == j5.a.f4591f) {
                            return;
                        }
                    } catch (Throwable th2) {
                        obj = e.a(th2);
                    }
                    o(obj);
                } else {
                    throw new f5.b();
                }
            }
        } else {
            throw null;
        }
    }

    @Override // i5.d
    public final void o(Object obj) {
        Throwable a7 = f5.d.a(obj);
        if (a7 != null) {
            obj = new o(a7, false);
        }
        Object X = X(obj);
        if (X != a0.e.f41h) {
            i0(X);
        }
    }
}
