package c6;

import a6.v0;
import a6.z0;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public class f<E> extends a6.a<f5.g> implements e<E> {

    /* renamed from: i */
    public final e<E> f2614i;

    public f(i5.f fVar, b bVar) {
        super(fVar, true);
        this.f2614i = bVar;
    }

    @Override // a6.z0, a6.u0
    public final void d(CancellationException cancellationException) {
        Object Q = Q();
        if ((Q instanceof a6.o) || ((Q instanceof z0.b) && ((z0.b) Q).d())) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new v0(B(), null, this);
        }
        y(cancellationException);
    }

    @Override // c6.q
    public final g<E> iterator() {
        return this.f2614i.iterator();
    }

    @Override // c6.r
    public final boolean j(Throwable th) {
        return this.f2614i.j(th);
    }

    @Override // c6.r
    public final Object t(E e) {
        return this.f2614i.t(e);
    }

    @Override // c6.r
    public final Object u(E e, i5.d<? super f5.g> dVar) {
        return this.f2614i.u(e, dVar);
    }

    @Override // a6.z0
    public final void y(CancellationException cancellationException) {
        this.f2614i.d(cancellationException);
        x(cancellationException);
    }
}
