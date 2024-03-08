package i5;

import i5.f;
import java.io.Serializable;
import q5.p;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g implements f, Serializable {

    /* renamed from: f */
    public static final g f4488f = new g();

    @Override // i5.f
    public final <E extends f.b> E e(f.c<E> cVar) {
        h.f(cVar, "key");
        return null;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return 0;
    }

    @Override // i5.f
    public final f k(f.c<?> cVar) {
        h.f(cVar, "key");
        return this;
    }

    @Override // i5.f
    public final <R> R q(R r6, p<? super R, ? super f.b, ? extends R> pVar) {
        return r6;
    }

    @Override // i5.f
    public final f s(f fVar) {
        h.f(fVar, "context");
        return fVar;
    }

    @Override // java.lang.Object
    public final String toString() {
        return "EmptyCoroutineContext";
    }
}
