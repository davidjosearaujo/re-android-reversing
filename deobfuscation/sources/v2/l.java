package v2;

import java.util.ArrayDeque;
import v2.m;

/* loaded from: classes.dex */
public final class l extends k3.i<m.a<Object>, Object> {
    public l() {
        super(500L);
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
