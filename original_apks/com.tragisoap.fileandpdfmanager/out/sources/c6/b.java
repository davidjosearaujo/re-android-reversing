package c6;

import a0.e;
import a6.h;
import a6.p1;
import f5.d;
import f5.g;
import f6.n;
import f6.s;
import f6.t;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k5.c;
import q.d;
import q5.l;
import r5.v;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class b<E> implements e<E> {

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
    public final l<E, g> f2590g;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final class a implements g<E>, p1 {

        /* renamed from: f */
        public Object f2591f = d.f2608p;

        /* renamed from: g */
        public h<? super Boolean> f2592g;

        public a() {
            b.this = r1;
        }

        @Override // c6.g
        public final Object a(c cVar) {
            j<E> jVar;
            Boolean bool;
            j<E> jVar2;
            b<E> bVar = b.this;
            j<E> jVar3 = (j) b.m.get(bVar);
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
                long j7 = (long) d.f2596b;
                long j8 = andIncrement / j7;
                int i8 = (int) (andIncrement % j7);
                if (jVar3.f4179h != j8) {
                    j<E> k6 = bVar.k(j8, jVar3);
                    if (k6 == null) {
                        continue;
                    } else {
                        jVar = k6;
                    }
                } else {
                    jVar = jVar3;
                }
                Object B = bVar.B(jVar, i8, andIncrement, null);
                d dVar = d.m;
                if (B != dVar) {
                    d dVar2 = d.f2607o;
                    if (B == dVar2) {
                        if (andIncrement < bVar.p()) {
                            jVar.a();
                        }
                        jVar3 = jVar;
                    } else if (B == d.f2606n) {
                        b<E> bVar2 = b.this;
                        h<? super Boolean> q6 = e.q(q2.a.A(cVar));
                        try {
                            this.f2592g = q6;
                            Object B2 = bVar2.B(jVar, i8, andIncrement, this);
                            if (B2 == dVar) {
                                b(jVar, i8);
                            } else {
                                n nVar = null;
                                if (B2 == dVar2) {
                                    if (andIncrement < bVar2.p()) {
                                        jVar.a();
                                    }
                                    j<E> jVar4 = (j) b.m.get(bVar2);
                                    while (true) {
                                        if (bVar2.r(b.f2581h.get(bVar2), true)) {
                                            h<? super Boolean> hVar = this.f2592g;
                                            r5.h.c(hVar);
                                            this.f2592g = null;
                                            this.f2591f = d.f2605l;
                                            Throwable m3 = b.this.m();
                                            hVar.o(m3 == null ? Boolean.FALSE : f5.e.a(m3));
                                        } else {
                                            long andIncrement2 = b.f2582i.getAndIncrement(bVar2);
                                            long j9 = (long) d.f2596b;
                                            long j10 = andIncrement2 / j9;
                                            int i9 = (int) (andIncrement2 % j9);
                                            if (jVar4.f4179h != j10) {
                                                j<E> k7 = bVar2.k(j10, jVar4);
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
                                            } else if (B3 != d.f2606n) {
                                                jVar2.a();
                                                this.f2591f = B3;
                                                this.f2592g = null;
                                                bool = Boolean.TRUE;
                                                l<E, g> lVar = bVar2.f2590g;
                                                if (lVar != null) {
                                                    nVar = new n(lVar, B3, q6.f296j);
                                                }
                                            } else {
                                                throw new IllegalStateException("unexpected".toString());
                                            }
                                        }
                                    }
                                } else {
                                    jVar.a();
                                    this.f2591f = B2;
                                    this.f2592g = null;
                                    bool = Boolean.TRUE;
                                    l<E, g> lVar2 = bVar2.f2590g;
                                    if (lVar2 != null) {
                                        nVar = new n(lVar2, B2, q6.f296j);
                                    }
                                }
                                q6.B(bool, q6.f291h, nVar);
                            }
                            Object t5 = q6.t();
                            j5.a aVar = j5.a.f4591f;
                            return t5;
                        } catch (Throwable th) {
                            q6.A();
                            throw th;
                        }
                    } else {
                        jVar.a();
                        this.f2591f = B;
                        return Boolean.TRUE;
                    }
                } else {
                    throw new IllegalStateException("unreachable".toString());
                }
            }
        }

        @Override // a6.p1
        public final void b(s<?> sVar, int i7) {
            h<? super Boolean> hVar = this.f2592g;
            if (hVar != null) {
                hVar.b(sVar, i7);
            }
        }

        @Override // c6.g
        public final E next() {
            E e = (E) this.f2591f;
            d dVar = d.f2608p;
            if (e != dVar) {
                this.f2591f = dVar;
                if (e != d.f2605l) {
                    return e;
                }
                b<E> bVar = b.this;
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
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0030b implements p1 {
        @Override // a6.p1
        public final void b(s<?> sVar, int i7) {
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(int i7, l<? super E, g> lVar) {
        this.f2589f = i7;
        this.f2590g = lVar;
        if (i7 >= 0) {
            j<Object> jVar = d.f2595a;
            this.bufferEnd = i7 != 0 ? i7 != Integer.MAX_VALUE ? (long) i7 : Long.MAX_VALUE : 0;
            this.completedExpandBuffersAndPauseFlag = l();
            j<Object> jVar2 = new j<>(0, null, this, 3);
            this.sendSegment = jVar2;
            this.receiveSegment = jVar2;
            if (v()) {
                jVar2 = d.f2595a;
                r5.h.d(jVar2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment = jVar2;
            this._closeCause = d.s;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i7 + ", should be >=0").toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0049, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final c6.j a(c6.b r9, long r10, c6.j r12) {
        /*
            r9.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = c6.b.f2585l
            c6.j<java.lang.Object> r1 = c6.d.f2595a
            c6.c r1 = c6.c.f2594n
        L_0x0009:
            java.lang.Object r1 = a0.b.m(r12, r10)
            boolean r2 = q2.a.B(r1)
            if (r2 != 0) goto L_0x0056
            f6.s r2 = q2.a.y(r1)
        L_0x0017:
            java.lang.Object r3 = r0.get(r9)
            f6.s r3 = (f6.s) r3
            long r4 = r3.f4179h
            long r6 = r2.f4179h
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            r5 = 0
            r6 = 1
            if (r4 < 0) goto L_0x0028
            goto L_0x0048
        L_0x0028:
            boolean r4 = r2.i()
            if (r4 != 0) goto L_0x002f
            goto L_0x0049
        L_0x002f:
            boolean r4 = r0.compareAndSet(r9, r3, r2)
            if (r4 == 0) goto L_0x0037
            r5 = r6
            goto L_0x003d
        L_0x0037:
            java.lang.Object r4 = r0.get(r9)
            if (r4 == r3) goto L_0x002f
        L_0x003d:
            if (r5 == 0) goto L_0x004c
            boolean r2 = r3.e()
            if (r2 == 0) goto L_0x0048
            r3.d()
        L_0x0048:
            r5 = r6
        L_0x0049:
            if (r5 == 0) goto L_0x0009
            goto L_0x0056
        L_0x004c:
            boolean r3 = r2.e()
            if (r3 == 0) goto L_0x0017
            r2.d()
            goto L_0x0017
        L_0x0056:
            boolean r0 = q2.a.B(r1)
            r2 = 0
            if (r0 == 0) goto L_0x006f
            r9.g()
            long r10 = r12.f4179h
            int r0 = c6.d.f2596b
            long r0 = (long) r0
            long r10 = r10 * r0
            long r0 = r9.n()
            int r9 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r9 >= 0) goto L_0x00b6
            goto L_0x00b1
        L_0x006f:
            f6.s r12 = q2.a.y(r1)
            c6.j r12 = (c6.j) r12
            long r0 = r12.f4179h
            int r10 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r10 <= 0) goto L_0x00b5
            int r10 = c6.d.f2596b
            long r10 = (long) r10
            long r0 = r0 * r10
            java.util.concurrent.atomic.AtomicLongFieldUpdater r10 = c6.b.f2581h
        L_0x0081:
            long r5 = r10.get(r9)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r3 = r3 & r5
            int r11 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r11 < 0) goto L_0x0090
            goto L_0x00a3
        L_0x0090:
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
            if (r11 == 0) goto L_0x0081
        L_0x00a3:
            long r10 = r12.f4179h
            int r0 = c6.d.f2596b
            long r0 = (long) r0
            long r10 = r10 * r0
            long r0 = r9.n()
            int r9 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r9 >= 0) goto L_0x00b6
        L_0x00b1:
            r12.a()
            goto L_0x00b6
        L_0x00b5:
            r2 = r12
        L_0x00b6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.a(c6.b, long, c6.j):c6.j");
    }

    public static final int b(b bVar, j jVar, int i7, Object obj, long j7, Object obj2, boolean z6) {
        bVar.getClass();
        jVar.n(i7, obj);
        if (!z6) {
            Object k6 = jVar.k(i7);
            if (k6 == null) {
                if (bVar.c(j7)) {
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
                d dVar = d.f2604k;
                if (jVar.f2619k.getAndSet((i7 * 2) + 1, dVar) != dVar) {
                    jVar.l(i7, true);
                }
                return 5;
            }
        }
        return bVar.C(jVar, i7, obj, j7, obj2, z6);
    }

    public final boolean A(Object obj, j<E> jVar, int i7) {
        if (obj instanceof a6.g) {
            r5.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return d.a((a6.g) obj, g.f4141a, null);
        } else if (obj instanceof h6.b) {
            r5.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            g gVar = g.f4141a;
            int g2 = ((h6.a) obj).g(this);
            char c7 = 3;
            if (g2 == 0) {
                c7 = 1;
            } else if (g2 == 1) {
                c7 = 2;
            } else if (g2 != 2) {
                if (g2 == 3) {
                    c7 = 4;
                } else {
                    throw new IllegalStateException(("Unexpected internal result: " + g2).toString());
                }
            }
            if (c7 == 2) {
                jVar.n(i7, null);
            }
            return c7 == 1;
        } else if (obj instanceof C0030b) {
            ((C0030b) obj).getClass();
            d.a(null, Boolean.TRUE, null);
            throw null;
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0081, code lost:
        i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0090, code lost:
        if (r8 != false) goto L_0x00a6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a6, code lost:
        i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
        return r6.m(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
        return c6.d.f2607o;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(c6.j r6, int r7, long r8, c6.g r10) {
        /*
            r5 = this;
            java.lang.Object r0 = r6.k(r7)
            r1 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r0 != 0) goto L_0x0027
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = c6.b.f2581h
            long r3 = r3.get(r5)
            long r3 = r3 & r1
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x003b
            if (r10 != 0) goto L_0x001b
            q.d r5 = c6.d.f2606n
            return r5
        L_0x001b:
            boolean r0 = r6.j(r0, r7, r10)
            if (r0 == 0) goto L_0x003b
            r5.i()
            q.d r5 = c6.d.m
            return r5
        L_0x0027:
            q.d r3 = c6.d.f2598d
            if (r0 != r3) goto L_0x003b
            q.d r3 = c6.d.f2602i
            boolean r0 = r6.j(r0, r7, r3)
            if (r0 == 0) goto L_0x003b
            r5.i()
            java.lang.Object r5 = r6.m(r7)
            return r5
        L_0x003b:
            java.lang.Object r0 = r6.k(r7)
            if (r0 == 0) goto L_0x0093
            q.d r3 = c6.d.e
            if (r0 != r3) goto L_0x0046
            goto L_0x0093
        L_0x0046:
            q.d r3 = c6.d.f2598d
            if (r0 != r3) goto L_0x0053
            q.d r3 = c6.d.f2602i
            boolean r0 = r6.j(r0, r7, r3)
            if (r0 == 0) goto L_0x003b
            goto L_0x0081
        L_0x0053:
            q.d r3 = c6.d.f2603j
            if (r0 != r3) goto L_0x0058
            goto L_0x00a9
        L_0x0058:
            q.d r4 = c6.d.f2601h
            if (r0 != r4) goto L_0x005d
            goto L_0x00a9
        L_0x005d:
            q.d r4 = c6.d.f2605l
            if (r0 != r4) goto L_0x0062
            goto L_0x00a6
        L_0x0062:
            q.d r4 = c6.d.f2600g
            if (r0 == r4) goto L_0x003b
            q.d r4 = c6.d.f2599f
            boolean r4 = r6.j(r0, r7, r4)
            if (r4 == 0) goto L_0x003b
            boolean r8 = r0 instanceof c6.s
            if (r8 == 0) goto L_0x0076
            c6.s r0 = (c6.s) r0
            a6.p1 r0 = r0.f2621a
        L_0x0076:
            boolean r9 = r5.A(r0, r6, r7)
            if (r9 == 0) goto L_0x0089
            q.d r8 = c6.d.f2602i
            r6.o(r7, r8)
        L_0x0081:
            r5.i()
            java.lang.Object r5 = r6.m(r7)
            goto L_0x00bc
        L_0x0089:
            r6.o(r7, r3)
            r9 = 0
            r6.l(r7, r9)
            if (r8 == 0) goto L_0x00a9
            goto L_0x00a6
        L_0x0093:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = c6.b.f2581h
            long r3 = r3.get(r5)
            long r3 = r3 & r1
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x00ac
            q.d r3 = c6.d.f2601h
            boolean r0 = r6.j(r0, r7, r3)
            if (r0 == 0) goto L_0x003b
        L_0x00a6:
            r5.i()
        L_0x00a9:
            q.d r5 = c6.d.f2607o
            goto L_0x00bc
        L_0x00ac:
            if (r10 != 0) goto L_0x00b1
            q.d r5 = c6.d.f2606n
            goto L_0x00bc
        L_0x00b1:
            boolean r0 = r6.j(r0, r7, r10)
            if (r0 == 0) goto L_0x003b
            r5.i()
            q.d r5 = c6.d.m
        L_0x00bc:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.B(c6.j, int, long, c6.g):java.lang.Object");
    }

    public final int C(j<E> jVar, int i7, E e, long j7, Object obj, boolean z6) {
        while (true) {
            Object k6 = jVar.k(i7);
            if (k6 == null) {
                if (!c(j7) || z6) {
                    if (z6) {
                        if (jVar.j(null, i7, d.f2603j)) {
                            jVar.l(i7, false);
                            return 4;
                        }
                    } else if (obj == null) {
                        return 3;
                    } else {
                        if (jVar.j(null, i7, obj)) {
                            return 2;
                        }
                    }
                } else if (jVar.j(null, i7, d.f2598d)) {
                    return 1;
                }
            } else if (k6 != d.e) {
                d dVar = d.f2604k;
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
                    if (z(k6, e)) {
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

    public final boolean c(long j7) {
        return j7 < l() || j7 < n() + ((long) this.f2589f);
    }

    @Override // c6.q
    public final void d(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        e(cancellationException, true);
    }

    public final boolean e(Throwable th, boolean z6) {
        boolean z7;
        Object obj;
        boolean z8;
        long j7;
        int i7;
        long j8;
        long j9;
        long j10;
        if (z6) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f2581h;
            do {
                j10 = atomicLongFieldUpdater.get(this);
                if (((int) (j10 >> 60)) != 0) {
                    break;
                }
                j<Object> jVar = d.f2595a;
            } while (!atomicLongFieldUpdater.compareAndSet(this, j10, (((long) 1) << 60) + (j10 & 1152921504606846975L)));
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2587o;
        d dVar = d.s;
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
                j9 = atomicLongFieldUpdater2.get(this);
                j<Object> jVar2 = d.f2595a;
            } while (!atomicLongFieldUpdater2.compareAndSet(this, j9, (((long) 3) << 60) + (j9 & 1152921504606846975L)));
        } else {
            AtomicLongFieldUpdater atomicLongFieldUpdater3 = f2581h;
            do {
                j7 = atomicLongFieldUpdater3.get(this);
                int i8 = (int) (j7 >> 60);
                if (i8 == 0) {
                    j8 = j7 & 1152921504606846975L;
                    i7 = 2;
                    j<Object> jVar3 = d.f2595a;
                } else if (i8 != 1) {
                    break;
                } else {
                    j8 = j7 & 1152921504606846975L;
                    j<Object> jVar4 = d.f2595a;
                    i7 = 3;
                }
            } while (!atomicLongFieldUpdater3.compareAndSet(this, j7, (((long) i7) << 60) + j8));
        }
        g();
        if (z7) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f2588p;
            do {
                obj = atomicReferenceFieldUpdater2.get(this);
                d dVar2 = obj == null ? d.f2609q : d.f2610r;
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
                ((l) obj).k(m());
            }
        }
        return z7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0095, code lost:
        r1 = (c6.j) ((f6.b) f6.b.f4144g.get(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e5, code lost:
        r5 = a0.b.t(r5, r6);
        r1.l(r3, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c6.j<E> f(long r13) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.f(long):c6.j");
    }

    public final void g() {
        r(f2581h.get(this), false);
    }

    public final void h(long j7) {
        f5.b h7;
        j<E> jVar = (j) m.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f2582i;
            long j8 = atomicLongFieldUpdater.get(this);
            if (j7 >= Math.max(((long) this.f2589f) + j8, l())) {
                if (atomicLongFieldUpdater.compareAndSet(this, j8, j8 + 1)) {
                    long j9 = (long) d.f2596b;
                    long j10 = j8 / j9;
                    int i7 = (int) (j8 % j9);
                    if (jVar.f4179h != j10) {
                        j<E> k6 = k(j10, jVar);
                        if (k6 == null) {
                            continue;
                        } else {
                            jVar = k6;
                        }
                    }
                    Object B = B(jVar, i7, j8, null);
                    if (B != d.f2607o) {
                        jVar.a();
                        l<E, g> lVar = this.f2590g;
                        if (!(lVar == null || (h7 = a0.b.h(lVar, B, null)) == null)) {
                            throw h7;
                        }
                    } else if (j8 < p()) {
                        jVar.a();
                    }
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0198 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0012 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0012 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00cf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.i():void");
    }

    @Override // c6.q
    public final g<E> iterator() {
        return new a();
    }

    @Override // c6.r
    public final boolean j(Throwable th) {
        return e(th, false);
    }

    public final j<E> k(long j7, j<E> jVar) {
        Object m3;
        long j8;
        boolean z6;
        boolean z7;
        boolean z8;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
        j<Object> jVar2 = d.f2595a;
        c cVar = c.f2594n;
        do {
            m3 = a0.b.m(jVar, j7);
            if (q2.a.B(m3)) {
                break;
            }
            s y6 = q2.a.y(m3);
            while (true) {
                s sVar = (s) atomicReferenceFieldUpdater.get(this);
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
            if (jVar.f4179h * ((long) d.f2596b) >= p()) {
                return null;
            }
        } else {
            jVar = (j) q2.a.y(m3);
            if (!v() && j7 <= l() / ((long) d.f2596b)) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f2586n;
                while (true) {
                    s sVar2 = (s) atomicReferenceFieldUpdater2.get(this);
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
            long j9 = jVar.f4179h;
            if (j9 <= j7) {
                return jVar;
            }
            long j10 = j9 * ((long) d.f2596b);
            AtomicLongFieldUpdater atomicLongFieldUpdater = f2582i;
            do {
                j8 = atomicLongFieldUpdater.get(this);
                if (j8 >= j10) {
                    break;
                }
            } while (!f2582i.compareAndSet(this, j8, j10));
            if (jVar.f4179h * ((long) d.f2596b) >= p()) {
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

    public final void q(long j7) {
        boolean z6;
        if ((f2584k.addAndGet(this, j7) & 4611686018427387904L) != 0) {
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

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a4, code lost:
        r12.n(r4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b0, code lost:
        r12.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b7, code lost:
        r12 = (c6.j) ((f6.b) f6.b.f4144g.get(r12));
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0131, code lost:
        r11 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r(long r12, boolean r14) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.r(long, boolean):boolean");
    }

    public boolean s() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d8, code lost:
        return f5.g.f4141a;
     */
    @Override // c6.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object t(E r21) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.t(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x01b9, code lost:
        r2 = (c6.j) r2.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c0, code lost:
        if (r2 != null) goto L_0x01f7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01b9 A[EDGE_INSN: B:120:0x01b9->B:95:0x01b9 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.toString():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0128, code lost:
        r1 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0196  */
    @Override // c6.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object u(E r24, i5.d<? super f5.g> r25) {
        /*
            Method dump skipped, instructions count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.u(java.lang.Object, i5.d):java.lang.Object");
    }

    public final boolean v() {
        long l6 = l();
        return l6 == 0 || l6 == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
        r1 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(long r5, c6.j<E> r7) {
        /*
            r4 = this;
        L_0x0000:
            long r0 = r7.f4179h
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0011
            f6.b r0 = r7.b()
            c6.j r0 = (c6.j) r0
            if (r0 != 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r7 = r0
            goto L_0x0000
        L_0x0011:
            boolean r5 = r7.c()
            if (r5 == 0) goto L_0x0022
            f6.b r5 = r7.b()
            c6.j r5 = (c6.j) r5
            if (r5 != 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r7 = r5
            goto L_0x0011
        L_0x0022:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = c6.b.f2586n
        L_0x0024:
            java.lang.Object r6 = r5.get(r4)
            f6.s r6 = (f6.s) r6
            long r0 = r6.f4179h
            long r2 = r7.f4179h
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 < 0) goto L_0x0035
            goto L_0x0055
        L_0x0035:
            boolean r0 = r7.i()
            if (r0 != 0) goto L_0x003c
            goto L_0x0056
        L_0x003c:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L_0x0044
            r1 = r2
            goto L_0x004a
        L_0x0044:
            java.lang.Object r0 = r5.get(r4)
            if (r0 == r6) goto L_0x003c
        L_0x004a:
            if (r1 == 0) goto L_0x0059
            boolean r5 = r6.e()
            if (r5 == 0) goto L_0x0055
            r6.d()
        L_0x0055:
            r1 = r2
        L_0x0056:
            if (r1 == 0) goto L_0x0011
            return
        L_0x0059:
            boolean r6 = r7.e()
            if (r6 == 0) goto L_0x0024
            r7.d()
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.b.w(long, c6.j):void");
    }

    public final Object x(E e, i5.d<? super g> dVar) {
        d.a aVar;
        f5.b h7;
        h hVar = new h(1, q2.a.A(dVar));
        hVar.u();
        l<E, g> lVar = this.f2590g;
        if (lVar == null || (h7 = a0.b.h(lVar, e, null)) == null) {
            aVar = f5.e.a(o());
        } else {
            q2.a.c(h7, o());
            aVar = f5.e.a(h7);
        }
        hVar.o(aVar);
        Object t5 = hVar.t();
        return t5 == j5.a.f4591f ? t5 : g.f4141a;
    }

    public final void y(p1 p1Var, boolean z6) {
        Throwable th;
        if (p1Var instanceof C0030b) {
            ((C0030b) p1Var).getClass();
            throw null;
        } else if (p1Var instanceof a6.g) {
            i5.d dVar = (i5.d) p1Var;
            if (z6) {
                th = m();
                if (th == null) {
                    th = new k();
                }
            } else {
                th = o();
            }
            dVar.o(f5.e.a(th));
        } else if (p1Var instanceof p) {
            ((p) p1Var).getClass();
            m();
            throw null;
        } else if (p1Var instanceof a) {
            a aVar = (a) p1Var;
            h<? super Boolean> hVar = aVar.f2592g;
            r5.h.c(hVar);
            aVar.f2592g = null;
            aVar.f2591f = d.f2605l;
            Throwable m3 = b.this.m();
            hVar.o(m3 == null ? Boolean.FALSE : f5.e.a(m3));
        } else if (p1Var instanceof h6.b) {
            ((h6.b) p1Var).a(this, d.f2605l);
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + p1Var).toString());
        }
    }

    public final boolean z(Object obj, E e) {
        if (obj instanceof h6.b) {
            return ((h6.b) obj).a(this, e);
        }
        n nVar = null;
        if (obj instanceof p) {
            r5.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            p pVar = (p) obj;
            i iVar = new i(e);
            if (this.f2590g != null) {
                throw null;
            }
            d.a(null, iVar, null);
            throw null;
        } else if (obj instanceof a) {
            r5.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            a aVar = (a) obj;
            h<? super Boolean> hVar = aVar.f2592g;
            r5.h.c(hVar);
            aVar.f2592g = null;
            aVar.f2591f = e;
            Boolean bool = Boolean.TRUE;
            l<E, g> lVar = b.this.f2590g;
            if (lVar != null) {
                nVar = new n(lVar, e, hVar.f296j);
            }
            return d.a(hVar, bool, nVar);
        } else if (obj instanceof a6.g) {
            r5.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            a6.g gVar = (a6.g) obj;
            l<E, g> lVar2 = this.f2590g;
            if (lVar2 != null) {
                nVar = new n(lVar2, e, gVar.a());
            }
            return d.a(gVar, e, nVar);
        } else {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
    }
}
