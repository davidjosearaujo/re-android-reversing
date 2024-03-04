package f6;

/* loaded from: classes.dex */
public class r<T> extends a6.a<T> implements k5.d {

    /* renamed from: i */
    public final i5.d<T> f4177i;

    public r(i5.d dVar, i5.f fVar) {
        super(fVar, true);
        this.f4177i = dVar;
    }

    @Override // a6.z0
    public final boolean W() {
        return true;
    }

    @Override // k5.d
    public final k5.d g() {
        i5.d<T> dVar = this.f4177i;
        if (dVar instanceof k5.d) {
            return (k5.d) dVar;
        }
        return null;
    }

    @Override // a6.a
    public void i0(Object obj) {
        this.f4177i.o(a0.b.u(obj));
    }

    @Override // a6.z0
    public void w(Object obj) {
        a0.b.A(q2.a.A(this.f4177i), a0.b.u(obj), null);
    }
}
