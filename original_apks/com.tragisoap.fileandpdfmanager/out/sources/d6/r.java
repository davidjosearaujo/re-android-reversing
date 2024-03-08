package d6;

import a6.h1;
import a6.u0;
import c6.a;
import e6.i;
import e6.l;
import i5.d;
import i5.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class r<T> implements c0<T>, c, l<T> {

    /* renamed from: f  reason: collision with root package name */
    public final u0 f3730f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ c0<T> f3731g;

    public r(d0 d0Var, h1 h1Var) {
        this.f3730f = h1Var;
        this.f3731g = d0Var;
    }

    @Override // d6.t, d6.c
    public final Object a(d<? super T> dVar, d<?> dVar2) {
        return this.f3731g.a(dVar, dVar2);
    }

    @Override // e6.l
    public final c<T> c(f fVar, int i7, a aVar) {
        return (((i7 >= 0 && i7 < 2) || i7 == -2) && aVar == a.DROP_OLDEST) ? this : ((i7 == 0 || i7 == -3) && aVar == a.SUSPEND) ? this : new i(i7, fVar, aVar, this);
    }

    @Override // d6.c0
    public final T getValue() {
        return this.f3731g.getValue();
    }
}
