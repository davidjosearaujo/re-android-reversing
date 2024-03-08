package k5;

import i5.d;
import i5.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class g extends a {
    public g(d<Object> dVar) {
        super(dVar);
        if (dVar != null) {
            if (!(dVar.a() == i5.g.f4488f)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // i5.d
    public final f a() {
        return i5.g.f4488f;
    }
}
