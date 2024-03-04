package d6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class e0 extends e6.c<d0<?>> {

    /* renamed from: a */
    public static final AtomicReferenceFieldUpdater f3686a = AtomicReferenceFieldUpdater.newUpdater(e0.class, Object.class, "_state");
    private volatile Object _state;

    @Override // e6.c
    public final boolean a(e6.b bVar) {
        d0 d0Var = (d0) bVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3686a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, a0.b.s);
        return true;
    }

    @Override // e6.c
    public final i5.d[] b(e6.b bVar) {
        d0 d0Var = (d0) bVar;
        f3686a.set(this, null);
        return a0.e.X;
    }
}
