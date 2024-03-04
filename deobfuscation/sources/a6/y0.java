package a6;

/* loaded from: classes.dex */
public abstract class y0 extends q implements i0, q0 {

    /* renamed from: i */
    public z0 f345i;

    /* JADX WARN: Code restructure failed: missing block: B:209:0x0024, code lost:
        continue;
     */
    @Override // a6.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r7 = this;
            a6.z0 r0 = r7.r()
        L4:
            java.lang.Object r1 = r0.Q()
            boolean r2 = r1 instanceof a6.y0
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L27
            if (r1 == r7) goto L12
            goto L75
        L12:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = a6.z0.f346f
            a6.k0 r5 = a0.e.m
        L16:
            boolean r6 = r2.compareAndSet(r0, r1, r5)
            if (r6 == 0) goto L1e
            r3 = r4
            goto L24
        L1e:
            java.lang.Object r6 = r2.get(r0)
            if (r6 == r1) goto L16
        L24:
            if (r3 == 0) goto L4
            goto L75
        L27:
            boolean r0 = r1 instanceof a6.q0
            if (r0 == 0) goto L75
            a6.q0 r1 = (a6.q0) r1
            a6.c1 r0 = r1.g()
            if (r0 == 0) goto L75
        L33:
            java.lang.Object r0 = r7.m()
            boolean r1 = r0 instanceof f6.p
            if (r1 == 0) goto L40
            f6.p r0 = (f6.p) r0
            f6.i r7 = r0.f4176a
            goto L75
        L40:
            if (r0 != r7) goto L45
            f6.i r0 = (f6.i) r0
            goto L75
        L45:
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            r5.h.d(r0, r1)
            r1 = r0
            f6.i r1 = (f6.i) r1
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = f6.i.f4161h
            java.lang.Object r5 = r2.get(r1)
            f6.p r5 = (f6.p) r5
            if (r5 != 0) goto L5f
            f6.p r5 = new f6.p
            r5.<init>(r1)
            r2.lazySet(r1, r5)
        L5f:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = f6.i.f4159f
        L61:
            boolean r6 = r2.compareAndSet(r7, r0, r5)
            if (r6 == 0) goto L69
            r0 = r4
            goto L70
        L69:
            java.lang.Object r6 = r2.get(r7)
            if (r6 == r0) goto L61
            r0 = r3
        L70:
            if (r0 == 0) goto L33
            r1.h()
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.y0.a():void");
    }

    @Override // a6.q0
    public final boolean b() {
        return true;
    }

    @Override // a6.q0
    public final c1 g() {
        return null;
    }

    public final z0 r() {
        z0 z0Var = this.f345i;
        if (z0Var != null) {
            return z0Var;
        }
        r5.h.k("job");
        throw null;
    }

    @Override // f6.i
    public final String toString() {
        return getClass().getSimpleName() + '@' + a0.c(this) + "[job@" + a0.c(r()) + ']';
    }
}
