package a6;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class j extends w0 {

    /* renamed from: j */
    public final h<?> f300j;

    public j(h<?> hVar) {
        this.f300j = hVar;
    }

    @Override // q5.l
    public final /* bridge */ /* synthetic */ f5.g k(Throwable th) {
        q(th);
        return f5.g.f4141a;
    }

    @Override // a6.q
    public final void q(Throwable th) {
        boolean z6;
        h<?> hVar = this.f300j;
        z0 r6 = r();
        hVar.getClass();
        CancellationException G = r6.G();
        boolean z7 = false;
        if (hVar.y()) {
            i5.d dVar = hVar.f295i;
            r5.h.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            f6.f fVar = (f6.f) dVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6.f.m;
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(fVar);
                q.d dVar2 = a0.b.B;
                boolean z8 = true;
                if (r5.h.a(obj, dVar2)) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f6.f.m;
                    while (true) {
                        if (!atomicReferenceFieldUpdater2.compareAndSet(fVar, dVar2, G)) {
                            if (atomicReferenceFieldUpdater2.get(fVar) != dVar2) {
                                z6 = false;
                                break;
                            }
                        } else {
                            z6 = true;
                            break;
                        }
                    }
                    if (z6) {
                        break;
                    }
                } else if (obj instanceof Throwable) {
                    break;
                } else {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f6.f.m;
                    while (true) {
                        if (!atomicReferenceFieldUpdater3.compareAndSet(fVar, obj, null)) {
                            if (atomicReferenceFieldUpdater3.get(fVar) != obj) {
                                z8 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z8) {
                        break;
                    }
                }
            }
            z7 = true;
        }
        if (z7) {
            return;
        }
        hVar.p(G);
        if (hVar.y()) {
            return;
        }
        hVar.q();
    }
}
