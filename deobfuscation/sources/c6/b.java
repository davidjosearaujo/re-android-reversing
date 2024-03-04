package c6;

import a6.p1;
import f5.d;
import f6.t;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import r5.v;

/* loaded from: classes.dex */
public class b<E> implements e {

    /* renamed from: h */
    public static final AtomicLongFieldUpdater f2581h = AtomicLongFieldUpdater.newUpdater(b.class, "sendersAndCloseStatus");

    /* renamed from: i */
    public static final AtomicLongFieldUpdater f2582i = AtomicLongFieldUpdater.newUpdater(b.class, "receivers");

    /* renamed from: j */
    public static final AtomicLongFieldUpdater f2583j = AtomicLongFieldUpdater.newUpdater(b.class, "bufferEnd");

    /* renamed from: k */
    public static final AtomicLongFieldUpdater f2584k = AtomicLongFieldUpdater.newUpdater(b.class, "completedExpandBuffersAndPauseFlag");

    /* renamed from: l */
    public static final AtomicReferenceFieldUpdater f2585l = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "sendSegment");
    public static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "receiveSegment");

    /* renamed from: n */
    public static final AtomicReferenceFieldUpdater f2586n = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "bufferEndSegment");

    /* renamed from: o */
    public static final AtomicReferenceFieldUpdater f2587o = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_closeCause");

    /* renamed from: p */
    public static final AtomicReferenceFieldUpdater f2588p = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "closeHandler");
    private volatile Object _closeCause;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;

    /* renamed from: f */
    public final int f2589f;

    /* renamed from: g */
    public final q5.l f2590g;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    /* loaded from: classes.dex */
    public final class a implements g, p1 {

        /* renamed from: f */
        public Object f2591f = d.f2608p;

        /* renamed from: g */
        public a6.h f2592g;

        public a() {
            b.this = r1;
        }

        public final Object a(k5.c cVar) {
            j jVar;
            Boolean bool;
            j jVar2;
            b bVar = b.this;
            j jVar3 = (j) b.m.get(bVar);
            while (true) {
                bVar.getClass();
                if (bVar.r(b.f2581h.get(bVar), true)) {
                    this.f2591f = d.f2605l;
                    Throwable m = b.this.m();
                    if (m == null) {
                        return Boolean.FALSE;
                    }
                    int i7 = t.f4180a;
                    throw m;
                }
                long andIncrement = b.f2582i.getAndIncrement(bVar);
                long j5 = d.f2596b;
                long j7 = andIncrement / j5;
                int i8 = (int) (andIncrement % j5);
                if (jVar3.f4179h != j7) {
                    j k6 = bVar.k(j7, jVar3);
                    if (k6 == null) {
                        continue;
                    } else {
                        jVar = k6;
                    }
                } else {
                    jVar = jVar3;
                }
                Object B = bVar.B(jVar, i8, andIncrement, null);
                q.d dVar = d.m;
                if (B == dVar) {
                    throw new IllegalStateException("unreachable".toString());
                }
                q.d dVar2 = d.f2607o;
                if (B != dVar2) {
                    if (B != d.f2606n) {
                        jVar.a();
                        this.f2591f = B;
                        return Boolean.TRUE;
                    }
                    b bVar2 = b.this;
                    a6.h q6 = a0.e.q(q2.a.A(cVar));
                    try {
                        this.f2592g = q6;
                        Object B2 = bVar2.B(jVar, i8, andIncrement, this);
                        if (B2 == dVar) {
                            b(jVar, i8);
                        } else {
                            f6.n nVar = null;
                            if (B2 == dVar2) {
                                if (andIncrement < bVar2.p()) {
                                    jVar.a();
                                }
                                j jVar4 = (j) b.m.get(bVar2);
                                while (true) {
                                    if (bVar2.r(b.f2581h.get(bVar2), true)) {
                                        a6.h hVar = this.f2592g;
                                        r5.h.c(hVar);
                                        this.f2592g = null;
                                        this.f2591f = d.f2605l;
                                        Throwable m3 = b.this.m();
                                        hVar.o(m3 == null ? Boolean.FALSE : f5.e.a(m3));
                                    } else {
                                        long andIncrement2 = b.f2582i.getAndIncrement(bVar2);
                                        long j8 = d.f2596b;
                                        long j9 = andIncrement2 / j8;
                                        int i9 = (int) (andIncrement2 % j8);
                                        if (jVar4.f4179h != j9) {
                                            j k7 = bVar2.k(j9, jVar4);
                                            if (k7 != null) {
                                                jVar2 = k7;
                                            }
                                        } else {
                                            jVar2 = jVar4;
                                        }
                                        Object B3 = bVar2.B(jVar2, i9, andIncrement2, this);
                                        if (B3 == d.m) {
                                            b(jVar2, i9);
                                            break;
                                        } else if (B3 == d.f2607o) {
                                            if (andIncrement2 < bVar2.p()) {
                                                jVar2.a();
                                            }
                                            jVar4 = jVar2;
                                        } else if (B3 == d.f2606n) {
                                            throw new IllegalStateException("unexpected".toString());
                                        } else {
                                            jVar2.a();
                                            this.f2591f = B3;
                                            this.f2592g = null;
                                            bool = Boolean.TRUE;
                                            q5.l lVar = bVar2.f2590g;
                                            if (lVar != null) {
                                                nVar = new f6.n(lVar, B3, q6.f296j);
                                            }
                                        }
                                    }
                                }
                            } else {
                                jVar.a();
                                this.f2591f = B2;
                                this.f2592g = null;
                                bool = Boolean.TRUE;
                                q5.l lVar2 = bVar2.f2590g;
                                if (lVar2 != null) {
                                    nVar = new f6.n(lVar2, B2, q6.f296j);
                                }
                            }
                            q6.B(bool, q6.f291h, nVar);
                        }
                        Object t5 = q6.t();
                        Kotlin_1.a aVar = Kotlin_1.a.f4591f;
                        return t5;
                    } catch (Throwable th) {
                        q6.A();
                        throw th;
                    }
                }
                if (andIncrement < bVar.p()) {
                    jVar.a();
                }
                jVar3 = jVar;
            }
        }

        public final void b(f6.s sVar, int i7) {
            a6.h hVar = this.f2592g;
            if (hVar != null) {
                hVar.b(sVar, i7);
            }
        }

        public final Object next() {
            Object obj = this.f2591f;
            q.d dVar = d.f2608p;
            if (obj != dVar) {
                this.f2591f = dVar;
                if (obj != d.f2605l) {
                    return obj;
                }
                b bVar = b.this;
                AtomicLongFieldUpdater atomicLongFieldUpdater = b.f2581h;
                Throwable m = bVar.m();
                if (m == null) {
                    m = new k();
                }
                int i7 = t.f4180a;
                throw m;
            }
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        }
    }

    /* renamed from: c6.b$b */
    /* loaded from: classes.dex */
    public static final class C0030b implements p1 {
        public final void b(f6.s sVar, int i7) {
            throw null;
        }
    }

    public b(int i7, q5.l lVar) {
        this.f2589f = i7;
        this.f2590g = lVar;
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i7 + ", should be >=0").toString());
        }
        j<Object> jVar = d.f2595a;
        this.bufferEnd = i7 != 0 ? i7 != Integer.MAX_VALUE ? i7 : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag = l();
        j<Object> jVar2 = new j<>(0L, null, this, 3);
        this.sendSegment = jVar2;
        this.receiveSegment = jVar2;
        if (v()) {
            jVar2 = d.f2595a;
            r5.h.d(jVar2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = jVar2;
        this._closeCause = d.s;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0049, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final c6.j a(c6.b r9, long r10, c6.j r12) {
        /*
            r9.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = c6.b.f2585l
            c6.j<java.lang.Object> r1 = c6.d.f2595a
            c6.c r1 = c6.c.f2594n
        L9:
            java.lang.Object r1 = a0.b.m(r12, r10)
            boolean r2 = q2.a.B(r1)
            if (r2 != 0) goto L56
            f6.s r2 = q2.a.y(r1)
        L17:
            java.lang.Object r3 = r0.get(r9)
            f6.s r3 = (f6.s) r3
            long r4 = r3.f4179h
            long r6 = r2.f4179h
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            r5 = 0
            r6 = 1
            if (r4 < 0) goto L28
            goto L48
        L28:
            boolean r4 = r2.i()
            if (r4 != 0) goto L2f
            goto L49
        L2f:
            boolean r4 = r0.compareAndSet(r9, r3, r2)
            if (r4 == 0) goto L37
            r5 = r6
            goto L3d
        L37:
            java.lang.Object r4 = r0.get(r9)
            if (r4 == r3) goto L2f
        L3d:
            if (r5 == 0) goto L4c
            boolean r2 = r3.e()
            if (r2 == 0) goto L48
            r3.d()
        L48:
            r5 = r6
        L49:
            if (r5 == 0) goto L9
            goto L56
        L4c:
            boolean r3 = r2.e()
            if (r3 == 0) goto L17
            r2.d()
            goto L17
        L56:
            boolean r0 = q2.a.B(r1)
            r2 = 0
            if (r0 == 0) goto L6f
            r9.g()
            long r10 = r12.f4179h
            int r0 = c6.d.f2596b
            long r0 = (long) r0
            long r10 = r10 * r0
            long r0 = r9.n()
            int r9 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r9 >= 0) goto Lb6
            goto Lb1
        L6f:
            f6.s r12 = q2.a.y(r1)
            c6.j r12 = (c6.j) r12
            long r0 = r12.f4179h
            int r10 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r10 <= 0) goto Lb5
            int r10 = c6.d.f2596b
            long r10 = (long) r10
            long r0 = r0 * r10
            java.util.concurrent.atomic.AtomicLongFieldUpdater r10 = c6.b.f2581h
        L81:
            long r5 = r10.get(r9)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r3 = r3 & r5
            int r11 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r11 < 0) goto L90
            goto La3
        L90:
            r11 = 60
            long r7 = r5 >> r11
            int r7 = (int) r7
            c6.j<java.lang.Object> r8 = c6.d.f2595a
            long r7 = (long) r7
            long r7 = r7 << r11
            long r7 = r7 + r3
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = c6.b.f2581h
            r4 = r9
            boolean r11 = r3.compareAndSet(r4, r5, r7)
            if (r11 == 0) goto L81
        La3:
            long r10 = r12.f4179h
            int r0 = c6.d.f2596b
            long r0 = (long) r0
            long r10 = r10 * r0
            long r0 = r9.n()
            int r9 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r9 >= 0) goto Lb6
        Lb1:
            r12.a()
            goto Lb6
        Lb5:
            r2 = r12
        Lb6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.a(c6.b, long, c6.j):c6.j");
    }

    public static final int b(b bVar, j jVar, int i7, Object obj, long j5, Object obj2, boolean z6) {
        bVar.getClass();
        jVar.n(i7, obj);
        if (!z6) {
            Object k6 = jVar.k(i7);
            if (k6 == null) {
                if (bVar.c(j5)) {
                    if (jVar.j(null, i7, d.f2598d)) {
                        return 1;
                    }
                } else if (obj2 == null) {
                    return 3;
                } else {
                    if (jVar.j(null, i7, obj2)) {
                        return 2;
                    }
                }
            } else if (k6 instanceof p1) {
                jVar.n(i7, null);
                if (bVar.z(k6, obj)) {
                    jVar.o(i7, d.f2602i);
                    return 0;
                }
                q.d dVar = d.f2604k;
                if (jVar.f2619k.getAndSet((i7 * 2) + 1, dVar) != dVar) {
                    jVar.l(i7, true);
                }
                return 5;
            }
        }
        return bVar.C(jVar, i7, obj, j5, obj2, z6);
    }

    public final boolean A(Object obj, j jVar, int i7) {
        if (obj instanceof a6.g) {
            r5.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return d.a((a6.g) obj, f5.g.f4141a, null);
        } else if (!(obj instanceof h6.b)) {
            if (obj instanceof C0030b) {
                ((C0030b) obj).getClass();
                d.a(null, Boolean.TRUE, null);
                throw null;
            }
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        } else {
            r5.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            f5.g gVar = f5.g.f4141a;
            int g2 = ((h6.a) obj).g(this);
            char c7 = 3;
            if (g2 == 0) {
                c7 = 1;
            } else if (g2 == 1) {
                c7 = 2;
            } else if (g2 != 2) {
                if (g2 != 3) {
                    throw new IllegalStateException(("Unexpected internal result: " + g2).toString());
                }
                c7 = 4;
            }
            if (c7 == 2) {
                jVar.n(i7, null);
            }
            return c7 == 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x0081, code lost:
        i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0090, code lost:
        if (r8 != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x00a6, code lost:
        i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:?, code lost:
        return r6.m(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:?, code lost:
        return c6.d.f2607o;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object B(c6.j r6, int r7, long r8, c6.g r10) {
        /*
            r5 = this;
            java.lang.Object r0 = r6.k(r7)
            r1 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r0 != 0) goto L27
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = c6.b.f2581h
            long r3 = r3.get(r5)
            long r3 = r3 & r1
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 < 0) goto L3b
            if (r10 != 0) goto L1b
            q.d r5 = c6.d.f2606n
            return r5
        L1b:
            boolean r0 = r6.j(r0, r7, r10)
            if (r0 == 0) goto L3b
            r5.i()
            q.d r5 = c6.d.m
            return r5
        L27:
            q.d r3 = c6.d.f2598d
            if (r0 != r3) goto L3b
            q.d r3 = c6.d.f2602i
            boolean r0 = r6.j(r0, r7, r3)
            if (r0 == 0) goto L3b
            r5.i()
            java.lang.Object r5 = r6.m(r7)
            return r5
        L3b:
            java.lang.Object r0 = r6.k(r7)
            if (r0 == 0) goto L93
            q.d r3 = c6.d.e
            if (r0 != r3) goto L46
            goto L93
        L46:
            q.d r3 = c6.d.f2598d
            if (r0 != r3) goto L53
            q.d r3 = c6.d.f2602i
            boolean r0 = r6.j(r0, r7, r3)
            if (r0 == 0) goto L3b
            goto L81
        L53:
            q.d r3 = c6.d.f2603j
            if (r0 != r3) goto L58
            goto La9
        L58:
            q.d r4 = c6.d.f2601h
            if (r0 != r4) goto L5d
            goto La9
        L5d:
            q.d r4 = c6.d.f2605l
            if (r0 != r4) goto L62
            goto La6
        L62:
            q.d r4 = c6.d.f2600g
            if (r0 == r4) goto L3b
            q.d r4 = c6.d.f2599f
            boolean r4 = r6.j(r0, r7, r4)
            if (r4 == 0) goto L3b
            boolean r8 = r0 instanceof c6.s
            if (r8 == 0) goto L76
            c6.s r0 = (c6.s) r0
            a6.p1 r0 = r0.f2621a
        L76:
            boolean r9 = r5.A(r0, r6, r7)
            if (r9 == 0) goto L89
            q.d r8 = c6.d.f2602i
            r6.o(r7, r8)
        L81:
            r5.i()
            java.lang.Object r5 = r6.m(r7)
            goto Lbc
        L89:
            r6.o(r7, r3)
            r9 = 0
            r6.l(r7, r9)
            if (r8 == 0) goto La9
            goto La6
        L93:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = c6.b.f2581h
            long r3 = r3.get(r5)
            long r3 = r3 & r1
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto Lac
            q.d r3 = c6.d.f2601h
            boolean r0 = r6.j(r0, r7, r3)
            if (r0 == 0) goto L3b
        La6:
            r5.i()
        La9:
            q.d r5 = c6.d.f2607o
            goto Lbc
        Lac:
            if (r10 != 0) goto Lb1
            q.d r5 = c6.d.f2606n
            goto Lbc
        Lb1:
            boolean r0 = r6.j(r0, r7, r10)
            if (r0 == 0) goto L3b
            r5.i()
            q.d r5 = c6.d.m
        Lbc:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.B(c6.j, int, long, c6.g):java.lang.Object");
    }

    public final int C(j jVar, int i7, Object obj, long j5, Object obj2, boolean z6) {
        while (true) {
            Object k6 = jVar.k(i7);
            if (k6 == null) {
                if (!c(j5) || z6) {
                    if (z6) {
                        if (jVar.j(null, i7, d.f2603j)) {
                            jVar.l(i7, false);
                            return 4;
                        }
                    } else if (obj2 == null) {
                        return 3;
                    } else {
                        if (jVar.j(null, i7, obj2)) {
                            return 2;
                        }
                    }
                } else if (jVar.j(null, i7, d.f2598d)) {
                    return 1;
                }
            } else if (k6 != d.e) {
                q.d dVar = d.f2604k;
                if (k6 == dVar) {
                    jVar.n(i7, null);
                    return 5;
                } else if (k6 == d.f2601h) {
                    jVar.n(i7, null);
                    return 5;
                } else if (k6 == d.f2605l) {
                    jVar.n(i7, null);
                    g();
                    return 4;
                } else {
                    jVar.n(i7, null);
                    if (k6 instanceof s) {
                        k6 = ((s) k6).f2621a;
                    }
                    if (z(k6, obj)) {
                        jVar.o(i7, d.f2602i);
                        return 0;
                    }
                    if (jVar.f2619k.getAndSet((i7 * 2) + 1, dVar) != dVar) {
                        jVar.l(i7, true);
                    }
                    return 5;
                }
            } else if (jVar.j(k6, i7, d.f2598d)) {
                return 1;
            }
        }
    }

    public final boolean c(long j5) {
        return j5 < l() || j5 < n() + ((long) this.f2589f);
    }

    public final void d(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        e(cancellationException, true);
    }

    public final boolean e(Throwable th, boolean z6) {
        boolean z7;
        long j5;
        long j7;
        int i7;
        Object obj;
        boolean z8;
        long j8;
        long j9;
        if (z6) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f2581h;
            do {
                j9 = atomicLongFieldUpdater.get(this);
                if (((int) (j9 >> 60)) != 0) {
                    break;
                }
                j<Object> jVar = d.f2595a;
            } while (!atomicLongFieldUpdater.compareAndSet(this, j9, (1 << 60) + (j9 & 1152921504606846975L)));
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2587o;
        q.d dVar = d.s;
        while (true) {
            if (!atomicReferenceFieldUpdater.compareAndSet(this, dVar, th)) {
                if (atomicReferenceFieldUpdater.get(this) != dVar) {
                    z7 = false;
                    break;
                }
            } else {
                z7 = true;
                break;
            }
        }
        if (z6) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f2581h;
            do {
                j8 = atomicLongFieldUpdater2.get(this);
                j<Object> jVar2 = d.f2595a;
            } while (!atomicLongFieldUpdater2.compareAndSet(this, j8, (3 << 60) + (j8 & 1152921504606846975L)));
        } else {
            AtomicLongFieldUpdater atomicLongFieldUpdater3 = f2581h;
            do {
                j5 = atomicLongFieldUpdater3.get(this);
                int i8 = (int) (j5 >> 60);
                if (i8 == 0) {
                    j7 = j5 & 1152921504606846975L;
                    i7 = 2;
                    j<Object> jVar3 = d.f2595a;
                } else if (i8 != 1) {
                    break;
                } else {
                    j7 = j5 & 1152921504606846975L;
                    j<Object> jVar4 = d.f2595a;
                    i7 = 3;
                }
            } while (!atomicLongFieldUpdater3.compareAndSet(this, j5, (i7 << 60) + j7));
        }
        g();
        if (z7) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f2588p;
            do {
                obj = atomicReferenceFieldUpdater2.get(this);
                q.d dVar2 = obj == null ? d.f2609q : d.f2610r;
                while (true) {
                    if (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, dVar2)) {
                        if (atomicReferenceFieldUpdater2.get(this) != obj) {
                            z8 = false;
                            continue;
                            break;
                        }
                    } else {
                        z8 = true;
                        continue;
                        break;
                    }
                }
            } while (!z8);
            if (obj != null) {
                v.b(1, obj);
                ((q5.l) obj).k(m());
            }
        }
        return z7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x0095, code lost:
        r1 = (c6.j) ((f6.b) f6.b.f4144g.get(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x00e5, code lost:
        r5 = a0.b.t(r5, r6);
        r1.l(r3, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final c6.j f(long r13) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.f(long):c6.j");
    }

    public final void g() {
        r(f2581h.get(this), false);
    }

    public final void h(long j5) {
        f5.b h7;
        j jVar = (j) m.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f2582i;
            long j7 = atomicLongFieldUpdater.get(this);
            if (j5 < Math.max(this.f2589f + j7, l())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j7, j7 + 1)) {
                long j8 = d.f2596b;
                long j9 = j7 / j8;
                int i7 = (int) (j7 % j8);
                if (jVar.f4179h != j9) {
                    j k6 = k(j9, jVar);
                    if (k6 == null) {
                        continue;
                    } else {
                        jVar = k6;
                    }
                }
                Object B = B(jVar, i7, j7, null);
                if (B != d.f2607o) {
                    jVar.a();
                    q5.l lVar = this.f2590g;
                    if (lVar != null && (h7 = a0.b.h(lVar, B, null)) != null) {
                        throw h7;
                    }
                } else if (j7 < p()) {
                    jVar.a();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:231:0x014e, code lost:
        r12 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:258:0x00cf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0198 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0012 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0012 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.i():void");
    }

    public final g iterator() {
        return new a();
    }

    public final boolean j(Throwable th) {
        return e(th, false);
    }

    public final j k(long j5, j jVar) {
        Object m3;
        long j7;
        boolean z6;
        boolean z7;
        boolean z8;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
        j<Object> jVar2 = d.f2595a;
        c cVar = c.f2594n;
        do {
            m3 = a0.b.m(jVar, j5);
            if (q2.a.B(m3)) {
                break;
            }
            f6.s y6 = q2.a.y(m3);
            while (true) {
                f6.s sVar = (f6.s) atomicReferenceFieldUpdater.get(this);
                if (sVar.f4179h >= y6.f4179h) {
                    break;
                } else if (!y6.i()) {
                    z7 = false;
                    continue;
                    break;
                } else {
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(this, sVar, y6)) {
                            if (atomicReferenceFieldUpdater.get(this) != sVar) {
                                z8 = false;
                                break;
                            }
                        } else {
                            z8 = true;
                            break;
                        }
                    }
                    if (z8) {
                        if (sVar.e()) {
                            sVar.d();
                        }
                    } else if (y6.e()) {
                        y6.d();
                    }
                }
            }
            z7 = true;
            continue;
        } while (!z7);
        if (q2.a.B(m3)) {
            g();
            if (jVar.f4179h * d.f2596b >= p()) {
                return null;
            }
        } else {
            jVar = (j) q2.a.y(m3);
            if (!v() && j5 <= l() / d.f2596b) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f2586n;
                while (true) {
                    f6.s sVar2 = (f6.s) atomicReferenceFieldUpdater2.get(this);
                    if (sVar2.f4179h >= jVar.f4179h || !jVar.i()) {
                        break;
                    }
                    while (true) {
                        if (!atomicReferenceFieldUpdater2.compareAndSet(this, sVar2, jVar)) {
                            if (atomicReferenceFieldUpdater2.get(this) != sVar2) {
                                z6 = false;
                                break;
                            }
                        } else {
                            z6 = true;
                            break;
                        }
                    }
                    if (z6) {
                        if (sVar2.e()) {
                            sVar2.d();
                        }
                    } else if (jVar.e()) {
                        jVar.d();
                    }
                }
            }
            long j8 = jVar.f4179h;
            if (j8 <= j5) {
                return jVar;
            }
            long j9 = j8 * d.f2596b;
            AtomicLongFieldUpdater atomicLongFieldUpdater = f2582i;
            do {
                j7 = atomicLongFieldUpdater.get(this);
                if (j7 >= j9) {
                    break;
                }
            } while (!f2582i.compareAndSet(this, j7, j9));
            if (jVar.f4179h * d.f2596b >= p()) {
                return null;
            }
        }
        jVar.a();
        return null;
    }

    public final long l() {
        return f2583j.get(this);
    }

    public final Throwable m() {
        return (Throwable) f2587o.get(this);
    }

    public final long n() {
        return f2582i.get(this);
    }

    public final Throwable o() {
        Throwable m3 = m();
        return m3 == null ? new l() : m3;
    }

    public final long p() {
        return f2581h.get(this) & 1152921504606846975L;
    }

    public final void q(long j5) {
        boolean z6;
        if ((f2584k.addAndGet(this, j5) & 4611686018427387904L) != 0) {
            do {
                if ((f2584k.get(this) & 4611686018427387904L) != 0) {
                    z6 = true;
                    continue;
                } else {
                    z6 = false;
                    continue;
                }
            } while (z6);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:212:0x00a4, code lost:
        r12.n(r4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x00b0, code lost:
        r12.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x00b7, code lost:
        r12 = (c6.j) ((f6.b) f6.b.f4144g.get(r12));
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0131, code lost:
        r11 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean r(long r12, boolean r14) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.r(long, boolean):boolean");
    }

    public boolean s() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x00d8, code lost:
        return f5.g.f4141a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object t(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.t(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:222:0x01b9, code lost:
        r2 = (c6.j) r2.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x01c0, code lost:
        if (r2 != null) goto L118;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x01b9 A[EDGE_INSN: B:247:0x01b9->B:222:0x01b9 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 512
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.toString():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:237:0x01b8, code lost:
        return f5.g.f4141a;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:266:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object u(java.lang.Object r24, i5.d r25) {
        /*
            Method dump skipped, instructions count: 441
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.u(java.lang.Object, i5.d):java.lang.Object");
    }

    public final boolean v() {
        long l6 = l();
        return l6 == 0 || l6 == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0055, code lost:
        r1 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void w(long r5, c6.j r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f4179h
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            f6.b r0 = r7.b()
            c6.j r0 = (c6.j) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.c()
            if (r5 == 0) goto L22
            f6.b r5 = r7.b()
            c6.j r5 = (c6.j) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = c6.b.f2586n
        L24:
            java.lang.Object r6 = r5.get(r4)
            f6.s r6 = (f6.s) r6
            long r0 = r6.f4179h
            long r2 = r7.f4179h
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 < 0) goto L35
            goto L55
        L35:
            boolean r0 = r7.i()
            if (r0 != 0) goto L3c
            goto L56
        L3c:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L44
            r1 = r2
            goto L4a
        L44:
            java.lang.Object r0 = r5.get(r4)
            if (r0 == r6) goto L3c
        L4a:
            if (r1 == 0) goto L59
            boolean r5 = r6.e()
            if (r5 == 0) goto L55
            r6.d()
        L55:
            r1 = r2
        L56:
            if (r1 == 0) goto L11
            return
        L59:
            boolean r6 = r7.e()
            if (r6 == 0) goto L24
            r7.d()
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.w(long, c6.j):void");
    }

    public final Object x(Object obj, i5.d dVar) {
        d.a a7;
        f5.b h7;
        a6.h hVar = new a6.h(1, q2.a.A(dVar));
        hVar.u();
        q5.l lVar = this.f2590g;
        if (lVar == null || (h7 = a0.b.h(lVar, obj, null)) == null) {
            a7 = f5.e.a(o());
        } else {
            q2.a.c(h7, o());
            a7 = f5.e.a(h7);
        }
        hVar.o(a7);
        Object t5 = hVar.t();
        return t5 == Kotlin_1.a.f4591f ? t5 : f5.g.f4141a;
    }

    public final void y(p1 p1Var, boolean z6) {
        Throwable o6;
        if (p1Var instanceof C0030b) {
            ((C0030b) p1Var).getClass();
            throw null;
        } else if (p1Var instanceof a6.g) {
            i5.d dVar = (i5.d) p1Var;
            if (z6) {
                o6 = m();
                if (o6 == null) {
                    o6 = new k();
                }
            } else {
                o6 = o();
            }
            dVar.o(f5.e.a(o6));
        } else if (p1Var instanceof p) {
            ((p) p1Var).getClass();
            m();
            throw null;
        } else if (!(p1Var instanceof a)) {
            if (p1Var instanceof h6.b) {
                ((h6.b) p1Var).a(this, d.f2605l);
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + p1Var).toString());
        } else {
            a aVar = (a) p1Var;
            a6.h hVar = aVar.f2592g;
            r5.h.c(hVar);
            aVar.f2592g = null;
            aVar.f2591f = d.f2605l;
            Throwable m3 = b.this.m();
            hVar.o(m3 == null ? Boolean.FALSE : f5.e.a(m3));
        }
    }

    public final boolean z(Object obj, Object obj2) {
        if (obj instanceof h6.b) {
            return ((h6.b) obj).a(this, obj2);
        }
        if (obj instanceof p) {
            r5.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            p pVar = (p) obj;
            i iVar = new i(obj2);
            if (this.f2590g != null) {
                throw null;
            }
            d.a(null, iVar, null);
            throw null;
        } else if (obj instanceof a) {
            r5.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            a aVar = (a) obj;
            a6.h hVar = aVar.f2592g;
            r5.h.c(hVar);
            aVar.f2592g = null;
            aVar.f2591f = obj2;
            Boolean bool = Boolean.TRUE;
            q5.l lVar = b.this.f2590g;
            return d.a(hVar, bool, lVar != null ? new f6.n(lVar, obj2, hVar.f296j) : null);
        } else if (obj instanceof a6.g) {
            r5.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            a6.g gVar = (a6.g) obj;
            q5.l lVar2 = this.f2590g;
            return d.a(gVar, obj2, lVar2 != null ? new f6.n(lVar2, obj2, gVar.a()) : null);
        } else {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
    }
}
