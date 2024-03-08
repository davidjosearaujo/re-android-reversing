package d6;

import a0.e;
import e6.b;
import e6.c;
import i5.d;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e0 extends c<d0<?>> {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f3686a = AtomicReferenceFieldUpdater.newUpdater(e0.class, Object.class, "_state");
    private volatile Object _state;

    @Override // e6.c
    public final boolean a(b bVar) {
        d0 d0Var = (d0) bVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3686a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, a0.b.s);
        return true;
    }

    @Override // e6.c
    public final d[] b(b bVar) {
        d0 d0Var = (d0) bVar;
        f3686a.set(this, null);
        return e.X;
    }
}
