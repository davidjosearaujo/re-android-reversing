package androidx.compose.ui.platform;

import i5.f;

/* loaded from: classes.dex */
public final class v implements x.b {

    /* renamed from: f */
    public final p.y f1240f;

    public v() {
        int i7 = p.a.f5420a;
        this.f1240f = new p.y(1.0f);
    }

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
