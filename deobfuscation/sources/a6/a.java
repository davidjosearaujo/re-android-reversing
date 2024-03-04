package a6;

import a6.u0;

/* loaded from: classes.dex */
public abstract class a<T> extends z0 implements i5.d<T>, x {

    /* renamed from: h */
    public final i5.f f280h;

    public a(i5.f fVar, boolean z6) {
        super(z6);
        U((u0) fVar.e(u0.b.f341f));
        this.f280h = fVar.s(this);
    }

    @Override // a6.z0
    public final String B() {
        return getClass().getSimpleName() + " was cancelled";
    }

    @Override // a6.z0
    public final void T(i2.c cVar) {
        w.a(this.f280h, cVar);
    }

    @Override // a6.z0
    public String Y() {
        return super.Y();
    }

    @Override // i5.d
    public final i5.f a() {
        return this.f280h;
    }

    @Override // a6.z0, a6.u0
    public boolean b() {
        return super.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a6.z0
    public final void b0(Object obj) {
        if (!(obj instanceof o)) {
            k0(obj);
            return;
        }
        o oVar = (o) obj;
        Throwable th = oVar.f324a;
        oVar.getClass();
        j0(th, o.f323b.get(oVar) != 0);
    }

    public void i0(Object obj) {
        w(obj);
    }

    public void j0(Throwable th, boolean z6) {
    }

    public void k0(T t5) {
    }

    @Override // a6.x
    public final i5.f l() {
        return this.f280h;
    }

    public final void l0(int i7, a aVar, q5.p pVar) {
        Object a7;
        if (i7 == 0) {
            throw null;
        }
        int i8 = i7 - 1;
        if (i8 == 0) {
            try {
                a0.b.A(q2.a.A(q2.a.p(aVar, this, pVar)), f5.g.f4141a, null);
            } catch (Throwable th) {
                o(f5.e.a(th));
                throw th;
            }
        } else if (i8 != 1) {
            if (i8 == 2) {
                r5.h.f(pVar, "<this>");
                q2.a.A(q2.a.p(aVar, this, pVar)).o(f5.g.f4141a);
            } else if (i8 != 3) {
                throw new f5.b();
            } else {
                try {
                    i5.f fVar = this.f280h;
                    Object c7 = f6.v.c(fVar, null);
                    r5.v.b(2, pVar);
                    a7 = pVar.i(aVar, this);
                    f6.v.a(fVar, c7);
                    if (a7 == Kotlin_1.a.f4591f) {
                        return;
                    }
                } catch (Throwable th2) {
                    a7 = f5.e.a(th2);
                }
                o(a7);
            }
        }
    }

    @Override // i5.d
    public final void o(Object obj) {
        Throwable a7 = f5.d.a(obj);
        if (a7 != null) {
            obj = new o(a7, false);
        }
        Object X = X(obj);
        if (X == a0.e.f41h) {
            return;
        }
        i0(X);
    }
}
