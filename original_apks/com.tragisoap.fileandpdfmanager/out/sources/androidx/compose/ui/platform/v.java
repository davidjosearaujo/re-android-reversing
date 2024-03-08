package androidx.compose.ui.platform;

import i5.f;
import p.a;
import p.y;
import q5.p;
import r5.h;
import x.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class v implements b {

    /* renamed from: f  reason: collision with root package name */
    public final y f1240f = new y(1.0f);

    public v() {
        int i7 = a.f5420a;
    }

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
