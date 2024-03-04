package c6;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class j<E> extends f6.s<j<E>> {

    /* renamed from: j */
    public final b<E> f2618j;

    /* renamed from: k */
    public final AtomicReferenceArray f2619k;

    public j(long j5, j<E> jVar, b<E> bVar, int i7) {
        super(j5, jVar, i7);
        this.f2618j = bVar;
        this.f2619k = new AtomicReferenceArray(d.f2596b * 2);
    }

    @Override // f6.s
    public final int f() {
        return d.f2596b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:242:0x005c, code lost:
        n(r6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x005f, code lost:
        if (r1 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0061, code lost:
        r5 = r5.f2618j;
        r5.h.c(r5);
        r5 = r5.f2590g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0068, code lost:
        if (r5 == null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x006a, code lost:
        a0.b.g(r5, r0, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x006d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:?, code lost:
        return;
     */
    @Override // f6.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(int r6, i5.f r7) {
        /*
            r5 = this;
            int r0 = c6.d.f2596b
            if (r6 < r0) goto L6
            r1 = 1
            goto L7
        L6:
            r1 = 0
        L7:
            if (r1 == 0) goto La
            int r6 = r6 - r0
        La:
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r5.f2619k
            int r2 = r6 * 2
            java.lang.Object r0 = r0.get(r2)
        L12:
            java.lang.Object r2 = r5.k(r6)
            boolean r3 = r2 instanceof a6.p1
            r4 = 0
            if (r3 != 0) goto L6e
            boolean r3 = r2 instanceof c6.s
            if (r3 == 0) goto L20
            goto L6e
        L20:
            q.d r3 = c6.d.f2603j
            if (r2 == r3) goto L5c
            q.d r3 = c6.d.f2604k
            if (r2 != r3) goto L29
            goto L5c
        L29:
            q.d r3 = c6.d.f2600g
            if (r2 == r3) goto L12
            q.d r3 = c6.d.f2599f
            if (r2 != r3) goto L32
            goto L12
        L32:
            q.d r5 = c6.d.f2602i
            if (r2 == r5) goto L5b
            q.d r5 = c6.d.f2598d
            if (r2 != r5) goto L3b
            goto L5b
        L3b:
            q.d r5 = c6.d.f2605l
            if (r2 != r5) goto L40
            return
        L40:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "unexpected state: "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L5b:
            return
        L5c:
            r5.n(r6, r4)
            if (r1 == 0) goto L6d
            c6.b<E> r5 = r5.f2618j
            r5.h.c(r5)
            q5.l r5 = r5.f2590g
            if (r5 == 0) goto L6d
            a0.b.g(r5, r0, r7)
        L6d:
            return
        L6e:
            if (r1 == 0) goto L73
            q.d r3 = c6.d.f2603j
            goto L75
        L73:
            q.d r3 = c6.d.f2604k
        L75:
            boolean r2 = r5.j(r2, r6, r3)
            if (r2 == 0) goto L12
            r5.n(r6, r4)
            r2 = r1 ^ 1
            r5.l(r6, r2)
            if (r1 == 0) goto L91
            c6.b<E> r5 = r5.f2618j
            r5.h.c(r5)
            q5.l r5 = r5.f2590g
            if (r5 == 0) goto L91
            a0.b.g(r5, r0, r7)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.j.g(int, i5.f):void");
    }

    public final boolean j(Object obj, int i7, Object obj2) {
        AtomicReferenceArray atomicReferenceArray = this.f2619k;
        int i8 = (i7 * 2) + 1;
        while (!atomicReferenceArray.compareAndSet(i8, obj, obj2)) {
            if (atomicReferenceArray.get(i8) != obj) {
                return false;
            }
        }
        return true;
    }

    public final Object k(int i7) {
        return this.f2619k.get((i7 * 2) + 1);
    }

    public final void l(int i7, boolean z6) {
        long j5;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j7;
        if (z6) {
            b<E> bVar = this.f2618j;
            r5.h.c(bVar);
            long j8 = (this.f4179h * d.f2596b) + i7;
            if (!bVar.v()) {
                do {
                } while (bVar.l() <= j8);
                int i8 = d.f2597c;
                int i9 = 0;
                while (true) {
                    if (i9 < i8) {
                        long l6 = bVar.l();
                        if (l6 == (b.f2584k.get(bVar) & 4611686018427387903L) && l6 == bVar.l()) {
                            break;
                        }
                        i9++;
                    } else {
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = b.f2584k;
                        do {
                            j5 = atomicLongFieldUpdater2.get(bVar);
                        } while (!atomicLongFieldUpdater2.compareAndSet(bVar, j5, 4611686018427387904L + (j5 & 4611686018427387903L)));
                        while (true) {
                            long l7 = bVar.l();
                            atomicLongFieldUpdater = b.f2584k;
                            long j9 = atomicLongFieldUpdater.get(bVar);
                            long j10 = j9 & 4611686018427387903L;
                            boolean z7 = (j9 & 4611686018427387904L) != 0;
                            if (l7 == j10 && l7 == bVar.l()) {
                                break;
                            } else if (!z7) {
                                atomicLongFieldUpdater.compareAndSet(bVar, j9, j10 + 4611686018427387904L);
                            }
                        }
                        do {
                            j7 = atomicLongFieldUpdater.get(bVar);
                        } while (!atomicLongFieldUpdater.compareAndSet(bVar, j7, 0 + (j7 & 4611686018427387903L)));
                    }
                }
            }
        }
        h();
    }

    public final E m(int i7) {
        E e = (E) this.f2619k.get(i7 * 2);
        n(i7, null);
        return e;
    }

    public final void n(int i7, Object obj) {
        this.f2619k.lazySet(i7 * 2, obj);
    }

    public final void o(int i7, q.d dVar) {
        this.f2619k.set((i7 * 2) + 1, dVar);
    }
}
