package p;

import i5.f;

/* loaded from: classes.dex */
public final class i0 implements t {

    /* renamed from: f */
    public static final i0 f5435f = new i0();

    @Override // i5.f.b, i5.f
    public final <E extends f.b> E e(f.c<E> cVar) {
        r5.h.f(cVar, "key");
        return (E) f.b.a.a(this, cVar);
    }

    @Override // i5.f
    public final i5.f k(f.c<?> cVar) {
        r5.h.f(cVar, "key");
        return f.b.a.b(this, cVar);
    }

    @Override // i5.f
    public final <R> R q(R r6, q5.p<? super R, ? super f.b, ? extends R> pVar) {
        return pVar.i(r6, this);
    }

    @Override // i5.f
    public final i5.f s(i5.f fVar) {
        r5.h.f(fVar, "context");
        return f.a.a(this, fVar);
    }
}
