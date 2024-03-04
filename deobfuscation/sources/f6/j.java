package f6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class j<E> {

    /* renamed from: a */
    public static final AtomicReferenceFieldUpdater f4164a = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_cur");
    private volatile Object _cur = new k(8, false);

    public final boolean a(E e) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4164a;
        while (true) {
            k kVar = (k) atomicReferenceFieldUpdater.get(this);
            int a7 = kVar.a(e);
            if (a7 == 0) {
                return true;
            }
            if (a7 == 1) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f4164a;
                k<E> c7 = kVar.c();
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, kVar, c7) && atomicReferenceFieldUpdater2.get(this) == kVar) {
                }
            } else if (a7 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4164a;
        while (true) {
            k kVar = (k) atomicReferenceFieldUpdater.get(this);
            if (kVar.b()) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f4164a;
            k<E> c7 = kVar.c();
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, kVar, c7) && atomicReferenceFieldUpdater2.get(this) == kVar) {
            }
        }
    }

    public final int c() {
        k kVar = (k) f4164a.get(this);
        kVar.getClass();
        long j5 = k.f4165f.get(kVar);
        return 1073741823 & (((int) ((j5 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j5) >> 0)));
    }

    public final E d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4164a;
        while (true) {
            k kVar = (k) atomicReferenceFieldUpdater.get(this);
            E e = (E) kVar.d();
            if (e != k.f4166g) {
                return e;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f4164a;
            k<E> c7 = kVar.c();
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, kVar, c7) && atomicReferenceFieldUpdater2.get(this) == kVar) {
            }
        }
    }
}
