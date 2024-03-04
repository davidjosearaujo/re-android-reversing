package f6;

import a6.e1;
import f6.s;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public abstract class s<S extends s<S>> extends b<S> implements e1 {

    /* renamed from: i */
    public static final AtomicIntegerFieldUpdater f4178i = AtomicIntegerFieldUpdater.newUpdater(s.class, "cleanedAndPointers");
    private volatile int cleanedAndPointers;

    /* renamed from: h */
    public final long f4179h;

    public s(long j5, S s, int i7) {
        super(s);
        this.f4179h = j5;
        this.cleanedAndPointers = i7 << 16;
    }

    @Override // f6.b
    public final boolean c() {
        if (f4178i.get(this) == f()) {
            if (!(b() == 0)) {
                return true;
            }
        }
        return false;
    }

    public final boolean e() {
        if (f4178i.addAndGet(this, -65536) == f()) {
            if (!(b() == 0)) {
                return true;
            }
        }
        return false;
    }

    public abstract int f();

    public abstract void g(int i7, i5.f fVar);

    public final void h() {
        if (f4178i.incrementAndGet(this) == c6.d.f2596b) {
            d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x001f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean i() {
        /*
            r5 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f6.s.f4178i
        L2:
            int r1 = r0.get(r5)
            int r2 = r5.f()
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L1c
            f6.b r2 = r5.b()
            if (r2 != 0) goto L16
            r2 = r3
            goto L17
        L16:
            r2 = r4
        L17:
            if (r2 == 0) goto L1a
            goto L1c
        L1a:
            r2 = r4
            goto L1d
        L1c:
            r2 = r3
        L1d:
            if (r2 != 0) goto L21
            r3 = r4
            goto L2a
        L21:
            r2 = 65536(0x10000, float:9.18355E-41)
            int r2 = r2 + r1
            boolean r1 = r0.compareAndSet(r5, r1, r2)
            if (r1 == 0) goto L2
        L2a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.s.i():boolean");
    }
}
