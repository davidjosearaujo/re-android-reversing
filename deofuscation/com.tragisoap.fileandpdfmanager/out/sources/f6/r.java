package f6;

import a0.b;
import a6.a;
import i5.f;
import k5.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class r<T> extends a<T> implements d {

    /* renamed from: i */
    public final i5.d<T> f4177i;

    public r(i5.d dVar, f fVar) {
        super(fVar, true);
        this.f4177i = dVar;
    }

    @Override // a6.z0
    public final boolean W() {
        return true;
    }

    @Override // k5.d
    public final d g() {
        i5.d<T> dVar = this.f4177i;
        if (dVar instanceof d) {
            return (d) dVar;
        }
        return null;
    }

    @Override // a6.a
    public void i0(Object obj) {
        this.f4177i.o(b.u(obj));
    }

    @Override // a6.z0
    public void w(Object obj) {
        b.A(q2.a.A(this.f4177i), b.u(obj), null);
    }
}
