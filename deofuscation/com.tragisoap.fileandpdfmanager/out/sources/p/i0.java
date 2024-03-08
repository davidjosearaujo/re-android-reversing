package p;

import i5.f;
import q5.p;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i0 implements t {

    /* renamed from: f  reason: collision with root package name */
    public static final i0 f5435f = new i0();

    @Override // i5.f.b, i5.f
    public final <E extends f.b> E e(f.c<E> cVar) {
        h.f(cVar, "key");
        return (E) f.b.a.a(this, cVar);
    }

    @Override // i5.f
    public final f k(f.c<?> cVar) {
        h.f(cVar, "key");
        return f.b.a.b(this, cVar);
    }

    @Override // i5.f
    public final <R> R q(R r6, p<? super R, ? super f.b, ? extends R> pVar) {
        return (R) pVar.i(r6, this);
    }

    @Override // i5.f
    public final f s(f fVar) {
        h.f(fVar, "context");
        return f.a.a(this, fVar);
    }
}
