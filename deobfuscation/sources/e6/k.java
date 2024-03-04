package e6;

import i5.f;

/* loaded from: classes.dex */
public final class k implements i5.f {

    /* renamed from: f */
    public final Throwable f3903f;

    /* renamed from: g */
    public final /* synthetic */ i5.f f3904g;

    public k(i5.f fVar, Throwable th) {
        this.f3903f = th;
        this.f3904g = fVar;
    }

    @Override // i5.f
    public final <E extends f.b> E e(f.c<E> cVar) {
        return (E) this.f3904g.e(cVar);
    }

    @Override // i5.f
    public final i5.f k(f.c<?> cVar) {
        return this.f3904g.k(cVar);
    }

    @Override // i5.f
    public final <R> R q(R r6, q5.p<? super R, ? super f.b, ? extends R> pVar) {
        return (R) this.f3904g.q(r6, pVar);
    }

    @Override // i5.f
    public final i5.f s(i5.f fVar) {
        return this.f3904g.s(fVar);
    }
}
