package a6;

import i5.f;
import q5.p;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o1 implements f.b, f.c<o1> {

    /* renamed from: f */
    public static final o1 f325f = new o1();

    @Override // i5.f.b, i5.f
    public final <E extends f.b> E e(f.c<E> cVar) {
        return (E) f.b.a.a(this, cVar);
    }

    @Override // i5.f.b
    public final f.c<?> getKey() {
        return this;
    }

    @Override // i5.f
    public final f k(f.c<?> cVar) {
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
