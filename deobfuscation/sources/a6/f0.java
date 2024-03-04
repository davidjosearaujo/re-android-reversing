package a6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class f0<T> extends f6.r<T> {

    /* renamed from: j */
    public static final AtomicIntegerFieldUpdater f290j = AtomicIntegerFieldUpdater.newUpdater(f0.class, "_decision");
    private volatile int _decision;

    public f0(i5.d dVar, i5.f fVar) {
        super(dVar, fVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0023, code lost:
        if (r2 == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0025, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0026, code lost:
        a0.b.A(q2.a.A(r5.f4177i), a0.b.u(r6), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0034, code lost:
        return;
     */
    @Override // f6.r, a6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i0(java.lang.Object r6) {
        /*
            r5 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = a6.f0.f290j
        L2:
            int r1 = r0.get(r5)
            r2 = 0
            r3 = 1
            r4 = 2
            if (r1 == 0) goto L1a
            if (r1 != r3) goto Le
            goto L23
        Le:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Already resumed"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L1a:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = a6.f0.f290j
            boolean r1 = r1.compareAndSet(r5, r2, r4)
            if (r1 == 0) goto L2
            r2 = r3
        L23:
            if (r2 == 0) goto L26
            return
        L26:
            i5.d<T> r5 = r5.f4177i
            i5.d r5 = q2.a.A(r5)
            java.lang.Object r6 = a0.b.u(r6)
            r0 = 0
            a0.b.A(r5, r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.f0.i0(java.lang.Object):void");
    }

    @Override // f6.r, a6.z0
    public final void w(Object obj) {
        i0(obj);
    }
}
