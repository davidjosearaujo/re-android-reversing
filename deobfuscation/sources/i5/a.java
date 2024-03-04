package i5;

import i5.f;
import q5.p;
import r5.h;

/* loaded from: classes.dex */
public abstract class a implements f.b {

    /* renamed from: f */
    public final f.c<?> f4479f;

    public a(f.c<?> cVar) {
        this.f4479f = cVar;
    }

    @Override // i5.f.b, i5.f
    public <E extends f.b> E e(f.c<E> cVar) {
        return (E) f.b.a.a(this, cVar);
    }

    @Override // i5.f.b
    public final f.c<?> getKey() {
        return this.f4479f;
    }

    @Override // i5.f
    public f k(f.c<?> cVar) {
        return f.b.a.b(this, cVar);
    }

    @Override // i5.f
    public final <R> R q(R r6, p<? super R, ? super f.b, ? extends R> pVar) {
        return pVar.i(r6, this);
    }

    @Override // i5.f
    public final f s(f fVar) {
        h.f(fVar, "context");
        return f.a.a(this, fVar);
    }
}
