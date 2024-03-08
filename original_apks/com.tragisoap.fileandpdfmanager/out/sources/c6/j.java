package c6;

import f6.s;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import q.d;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j<E> extends s<j<E>> {

    /* renamed from: j  reason: collision with root package name */
    public final b<E> f2618j;

    /* renamed from: k  reason: collision with root package name */
    public final AtomicReferenceArray f2619k = new AtomicReferenceArray(d.f2596b * 2);

    public j(long j7, j<E> jVar, b<E> bVar, int i7) {
        super(j7, jVar, i7);
        this.f2618j = bVar;
    }

    @Override // f6.s
    public final int f() {
        return d.f2596b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
        n(r6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
        if (r1 == false) goto L_?;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
        r5 = r5.f2618j;
        r5.h.c(r5);
        r5 = r5.f2590g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0068, code lost:
        if (r5 == null) goto L_?;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006a, code lost:
        a0.b.g(r5, r0, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    @Override // f6.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r6, i5.f r7) {
        /*
            r5 = this;
            int r0 = c6.d.f2596b
            if (r6 < r0) goto L_0x0006
            r1 = 1
            goto L_0x0007
        L_0x0006:
            r1 = 0
        L_0x0007:
            if (r1 == 0) goto L_0x000a
            int r6 = r6 - r0
        L_0x000a:
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r5.f2619k
            int r2 = r6 * 2
            java.lang.Object r0 = r0.get(r2)
        L_0x0012:
            java.lang.Object r2 = r5.k(r6)
            boolean r3 = r2 instanceof a6.p1
            r4 = 0
            if (r3 != 0) goto L_0x006e
            boolean r3 = r2 instanceof c6.s
            if (r3 == 0) goto L_0x0020
            goto L_0x006e
        L_0x0020:
            q.d r3 = c6.d.f2603j
            if (r2 == r3) goto L_0x005c
            q.d r3 = c6.d.f2604k
            if (r2 != r3) goto L_0x0029
            goto L_0x005c
        L_0x0029:
            q.d r3 = c6.d.f2600g
            if (r2 == r3) goto L_0x0012
            q.d r3 = c6.d.f2599f
            if (r2 != r3) goto L_0x0032
            goto L_0x0012
        L_0x0032:
            q.d r5 = c6.d.f2602i
            if (r2 == r5) goto L_0x005b
            q.d r5 = c6.d.f2598d
            if (r2 != r5) goto L_0x003b
            goto L_0x005b
        L_0x003b:
            q.d r5 = c6.d.f2605l
            if (r2 != r5) goto L_0x0040
            return
        L_0x0040:
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
        L_0x005b:
            return
        L_0x005c:
            r5.n(r6, r4)
            if (r1 == 0) goto L_0x006d
            c6.b<E> r5 = r5.f2618j
            r5.h.c(r5)
            q5.l<E, f5.g> r5 = r5.f2590g
            if (r5 == 0) goto L_0x006d
            a0.b.g(r5, r0, r7)
        L_0x006d:
            return
        L_0x006e:
            if (r1 == 0) goto L_0x0073
            q.d r3 = c6.d.f2603j
            goto L_0x0075
        L_0x0073:
            q.d r3 = c6.d.f2604k
        L_0x0075:
            boolean r2 = r5.j(r2, r6, r3)
            if (r2 == 0) goto L_0x0012
            r5.n(r6, r4)
            r2 = r1 ^ 1
            r5.l(r6, r2)
            if (r1 == 0) goto L_0x0091
            c6.b<E> r5 = r5.f2618j
            r5.h.c(r5)
            q5.l<E, f5.g> r5 = r5.f2590g
            if (r5 == 0) goto L_0x0091
            a0.b.g(r5, r0, r7)
        L_0x0091:
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
        long j7;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j8;
        if (z6) {
            b<E> bVar = this.f2618j;
            h.c(bVar);
            long j9 = (this.f4179h * ((long) d.f2596b)) + ((long) i7);
            if (!bVar.v()) {
                do {
                } while (bVar.l() <= j9);
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
                            j7 = atomicLongFieldUpdater2.get(bVar);
                        } while (!atomicLongFieldUpdater2.compareAndSet(bVar, j7, 4611686018427387904L + (j7 & 4611686018427387903L)));
                        while (true) {
                            long l7 = bVar.l();
                            atomicLongFieldUpdater = b.f2584k;
                            long j10 = atomicLongFieldUpdater.get(bVar);
                            long j11 = j10 & 4611686018427387903L;
                            boolean z7 = (j10 & 4611686018427387904L) != 0;
                            if (!(l7 == j11 && l7 == bVar.l())) {
                                if (!z7) {
                                    atomicLongFieldUpdater.compareAndSet(bVar, j10, j11 + 4611686018427387904L);
                                }
                            }
                        }
                        do {
                            j8 = atomicLongFieldUpdater.get(bVar);
                        } while (!atomicLongFieldUpdater.compareAndSet(bVar, j8, 0 + (j8 & 4611686018427387903L)));
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

    public final void o(int i7, d dVar) {
        this.f2619k.set((i7 * 2) + 1, dVar);
    }
}
