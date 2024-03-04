package f6;

import f6.b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class b<N extends b<N>> {

    /* renamed from: f */
    public static final AtomicReferenceFieldUpdater f4143f = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_next");

    /* renamed from: g */
    public static final AtomicReferenceFieldUpdater f4144g = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public b(N n6) {
        this._prev = n6;
    }

    public final void a() {
        f4144g.lazySet(this, null);
    }

    public final N b() {
        Object obj = f4143f.get(this);
        if (obj == a0.b.f25z) {
            return null;
        }
        return (N) obj;
    }

    public abstract boolean c();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [f6.b] */
    public final void d() {
        boolean z6;
        ?? b2;
        if (b() == null) {
            return;
        }
        while (true) {
            b bVar = (b) f4144g.get(this);
            while (bVar != null && bVar.c()) {
                bVar = (b) f4144g.get(bVar);
            }
            N b7 = b();
            r5.h.c(b7);
            while (b7.c() && (b2 = b7.b()) != 0) {
                b7 = b2;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4144g;
            do {
                Object obj = atomicReferenceFieldUpdater.get(b7);
                b bVar2 = ((b) obj) == null ? null : bVar;
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(b7, obj, bVar2)) {
                        if (atomicReferenceFieldUpdater.get(b7) != obj) {
                            z6 = false;
                            continue;
                            break;
                        }
                    } else {
                        z6 = true;
                        continue;
                        break;
                    }
                }
            } while (!z6);
            if (bVar != null) {
                f4143f.set(bVar, b7);
            }
            if (b7.c()) {
                if (!(b7.b() == null)) {
                    continue;
                }
            }
            if (bVar == null || !bVar.c()) {
                return;
            }
        }
    }
}
