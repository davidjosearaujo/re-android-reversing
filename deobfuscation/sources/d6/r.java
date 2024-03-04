package d6;

import a6.h1;
import a6.u0;

/* loaded from: classes.dex */
public final class r<T> implements c0<T>, c, e6.l<T> {

    /* renamed from: f */
    public final u0 f3730f;

    /* renamed from: g */
    public final /* synthetic */ c0<T> f3731g;

    public r(d0 d0Var, h1 h1Var) {
        this.f3730f = h1Var;
        this.f3731g = d0Var;
    }

    @Override // d6.t, d6.c
    public final Object a(d<? super T> dVar, i5.d<?> dVar2) {
        return this.f3731g.a(dVar, dVar2);
    }

    @Override // e6.l
    public final c<T> c(i5.f fVar, int i7, c6.a aVar) {
        return (((i7 >= 0 && i7 < 2) || i7 == -2) && aVar == c6.a.DROP_OLDEST) ? this : ((i7 == 0 || i7 == -3) && aVar == c6.a.SUSPEND) ? this : new e6.i(i7, fVar, aVar, this);
    }

    @Override // d6.c0
    public final T getValue() {
        return this.f3731g.getValue();
    }
}
