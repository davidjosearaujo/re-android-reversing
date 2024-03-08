package v2;

import java.util.ArrayDeque;
import k3.i;
import v2.m;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l extends i<m.a<Object>, Object> {
    public l() {
        super(500);
    }

    @Override // k3.i
    public final void c(m.a<Object> aVar, Object obj) {
        m.a<Object> aVar2 = aVar;
        aVar2.getClass();
        ArrayDeque arrayDeque = m.a.f6219d;
        synchronized (arrayDeque) {
            arrayDeque.offer(aVar2);
        }
    }
}
