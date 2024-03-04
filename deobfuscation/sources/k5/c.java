package k5;

import i5.e;
import i5.f;

/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: g */
    public final i5.f f4819g;

    /* renamed from: h */
    public transient i5.d<Object> f4820h;

    public c(i5.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.a() : null);
    }

    public c(i5.d<Object> dVar, i5.f fVar) {
        super(dVar);
        this.f4819g = fVar;
    }

    @Override // i5.d
    public i5.f a() {
        i5.f fVar = this.f4819g;
        r5.h.c(fVar);
        return fVar;
    }

    @Override // k5.a
    public void t() {
        i5.d<?> dVar = this.f4820h;
        if (dVar != null && dVar != this) {
            i5.f a7 = a();
            int i7 = i5.e.f4485c;
            f.b e = a7.e(e.a.f4486f);
            r5.h.c(e);
            ((i5.e) e).f(dVar);
        }
        this.f4820h = b.f4818f;
    }
}
