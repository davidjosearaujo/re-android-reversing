package g6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: b */
    public static final AtomicReferenceFieldUpdater f4327b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");

    /* renamed from: c */
    public static final AtomicIntegerFieldUpdater f4328c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");

    /* renamed from: d */
    public static final AtomicIntegerFieldUpdater f4329d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");
    public static final AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");

    /* renamed from: a */
    public final AtomicReferenceArray<g> f4330a = new AtomicReferenceArray<>(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    public final g a(g gVar) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f4328c;
        if (atomicIntegerFieldUpdater.get(this) - f4329d.get(this) == 127) {
            return gVar;
        }
        if (gVar.f4316g.b() == 1) {
            e.incrementAndGet(this);
        }
        int i7 = atomicIntegerFieldUpdater.get(this) & 127;
        while (this.f4330a.get(i7) != null) {
            Thread.yield();
        }
        this.f4330a.lazySet(i7, gVar);
        f4328c.incrementAndGet(this);
        return null;
    }

    public final g b() {
        g andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f4329d;
            int i7 = atomicIntegerFieldUpdater.get(this);
            if (i7 - f4328c.get(this) == 0) {
                return null;
            }
            int i8 = i7 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i7, i7 + 1) && (andSet = this.f4330a.getAndSet(i8, null)) != null) {
                if (andSet.f4316g.b() == 1) {
                    e.decrementAndGet(this);
                }
                return andSet;
            }
        }
    }

    public final g c(int i7, boolean z6) {
        int i8 = i7 & 127;
        g gVar = this.f4330a.get(i8);
        if (gVar != null) {
            boolean z7 = false;
            if ((gVar.f4316g.b() == 1) == z6) {
                AtomicReferenceArray<g> atomicReferenceArray = this.f4330a;
                while (true) {
                    if (!atomicReferenceArray.compareAndSet(i8, gVar, null)) {
                        if (atomicReferenceArray.get(i8) != gVar) {
                            break;
                        }
                    } else {
                        z7 = true;
                        break;
                    }
                }
                if (z7) {
                    if (z6) {
                        e.decrementAndGet(this);
                    }
                    return gVar;
                }
            }
        }
        return null;
    }
}
