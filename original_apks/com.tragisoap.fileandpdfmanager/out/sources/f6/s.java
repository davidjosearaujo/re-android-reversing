package f6;

import a6.e1;
import c6.d;
import f6.s;
import i5.f;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class s<S extends s<S>> extends b<S> implements e1 {

    /* renamed from: i */
    public static final AtomicIntegerFieldUpdater f4178i = AtomicIntegerFieldUpdater.newUpdater(s.class, "cleanedAndPointers");
    private volatile int cleanedAndPointers;

    /* renamed from: h */
    public final long f4179h;

    public s(long j7, S s, int i7) {
        super(s);
        this.f4179h = j7;
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

    public abstract void g(int i7, f fVar);

    public final void h() {
        if (f4178i.incrementAndGet(this) == d.f2596b) {
            d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x001f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i() {
        /*
            r5 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f6.s.f4178i
        L_0x0002:
            int r1 = r0.get(r5)
            int r2 = r5.f()
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L_0x001c
            f6.b r2 = r5.b()
            if (r2 != 0) goto L_0x0016
            r2 = r3
            goto L_0x0017
        L_0x0016:
            r2 = r4
        L_0x0017:
            if (r2 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r2 = r4
            goto L_0x001d
        L_0x001c:
            r2 = r3
        L_0x001d:
            if (r2 != 0) goto L_0x0021
            r3 = r4
            goto L_0x002a
        L_0x0021:
            r2 = 65536(0x10000, float:9.18355E-41)
            int r2 = r2 + r1
            boolean r1 = r0.compareAndSet(r5, r1, r2)
            if (r1 == 0) goto L_0x0002
        L_0x002a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.s.i():boolean");
    }
}
