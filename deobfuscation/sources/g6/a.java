package g6;

import a6.a0;
import f6.q;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import p.p;
import r5.s;

/* loaded from: classes.dex */
public final class a implements Executor, Closeable {
    public static final AtomicLongFieldUpdater m = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* renamed from: n */
    public static final AtomicLongFieldUpdater f4292n = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* renamed from: o */
    public static final AtomicIntegerFieldUpdater f4293o = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* renamed from: p */
    public static final q.d f4294p = new q.d(4, "NOT_IN_STACK");
    private volatile int _isTerminated;
    private volatile long controlState;

    /* renamed from: f */
    public final int f4295f;

    /* renamed from: g */
    public final int f4296g;

    /* renamed from: h */
    public final long f4297h;

    /* renamed from: i */
    public final String f4298i;

    /* renamed from: j */
    public final d f4299j;

    /* renamed from: k */
    public final d f4300k;

    /* renamed from: l */
    public final q<C0062a> f4301l;
    private volatile long parkedWorkersStack;

    /* renamed from: g6.a$a */
    /* loaded from: classes.dex */
    public final class C0062a extends Thread {

        /* renamed from: n */
        public static final AtomicIntegerFieldUpdater f4302n = AtomicIntegerFieldUpdater.newUpdater(C0062a.class, "workerCtl");

        /* renamed from: f */
        public final m f4303f;

        /* renamed from: g */
        public final s<g> f4304g;

        /* renamed from: h */
        public int f4305h;

        /* renamed from: i */
        public long f4306i;
        private volatile int indexInArray;

        /* renamed from: j */
        public long f4307j;

        /* renamed from: k */
        public int f4308k;

        /* renamed from: l */
        public boolean f4309l;
        private volatile Object nextParkedWorker;
        private volatile int workerCtl;

        public C0062a() {
            throw null;
        }

        public C0062a(int i7) {
            a.this = r1;
            setDaemon(true);
            this.f4303f = new m();
            this.f4304g = new s<>();
            this.f4305h = 4;
            this.nextParkedWorker = a.f4294p;
            this.f4308k = u5.c.f6119f.a();
            f(i7);
        }

        /* JADX WARN: Removed duplicated region for block: B:288:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:312:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:338:0x00d0  */
        /* JADX WARN: Removed duplicated region for block: B:358:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final g6.g a(boolean r11) {
            /*
                Method dump skipped, instructions count: 226
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: g6.a.C0062a.a(boolean):g6.g");
        }

        public final int b() {
            return this.indexInArray;
        }

        public final Object c() {
            return this.nextParkedWorker;
        }

        public final int d(int i7) {
            int i8 = this.f4308k;
            int i9 = i8 ^ (i8 << 13);
            int i10 = i9 ^ (i9 >> 17);
            int i11 = i10 ^ (i10 << 5);
            this.f4308k = i11;
            int i12 = i7 - 1;
            return (i12 & i7) == 0 ? i12 & i11 : (Integer.MAX_VALUE & i11) % i7;
        }

        public final g e() {
            d dVar;
            if (d(2) == 0) {
                g d7 = a.this.f4299j.d();
                if (d7 != null) {
                    return d7;
                }
                dVar = a.this.f4300k;
            } else {
                g d8 = a.this.f4300k.d();
                if (d8 != null) {
                    return d8;
                }
                dVar = a.this.f4299j;
            }
            return dVar.d();
        }

        public final void f(int i7) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f4298i);
            sb.append("-worker-");
            sb.append(i7 == 0 ? "TERMINATED" : String.valueOf(i7));
            setName(sb.toString());
            this.indexInArray = i7;
        }

        public final void g(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean h(int i7) {
            int i8 = this.f4305h;
            boolean z6 = i8 == 1;
            if (z6) {
                a.f4292n.addAndGet(a.this, 4398046511104L);
            }
            if (i8 != i7) {
                this.f4305h = i7;
            }
            return z6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:328:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:342:0x00ce A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v5, types: [g6.g] */
        /* JADX WARN: Type inference failed for: r7v9, types: [g6.g] */
        /* JADX WARN: Type inference failed for: r8v3, types: [T, g6.g, java.lang.Object] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final g6.g i(int r22) {
            /*
                Method dump skipped, instructions count: 264
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: g6.a.C0062a.i(int):g6.g");
        }

        /* JADX WARN: Code restructure failed: missing block: B:434:0x002a, code lost:
            r20.f4307j = 0;
            r2 = r4.f4316g.b();
            r20.f4306i = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:435:0x0037, code lost:
            if (r20.f4305h != 3) goto L97;
         */
        /* JADX WARN: Code restructure failed: missing block: B:436:0x0039, code lost:
            r20.f4305h = 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:437:0x003b, code lost:
            if (r2 != 0) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:440:0x0042, code lost:
            if (h(2) == false) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:441:0x0044, code lost:
            r0 = g6.a.this;
         */
        /* JADX WARN: Code restructure failed: missing block: B:442:0x004a, code lost:
            if (r0.i() == false) goto L102;
         */
        /* JADX WARN: Code restructure failed: missing block: B:445:0x0057, code lost:
            if (r0.f(g6.a.f4292n.get(r0)) == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:447:0x005a, code lost:
            r0.i();
         */
        /* JADX WARN: Code restructure failed: missing block: B:448:0x005d, code lost:
            g6.a.this.getClass();
         */
        /* JADX WARN: Code restructure failed: missing block: B:449:0x0062, code lost:
            r4.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:451:0x0066, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:454:0x0073, code lost:
            if (r2 == 0) goto L116;
         */
        /* JADX WARN: Code restructure failed: missing block: B:456:0x0076, code lost:
            g6.a.f4292n.addAndGet(g6.a.this, -2097152);
         */
        /* JADX WARN: Code restructure failed: missing block: B:457:0x007f, code lost:
            if (r20.f4305h != 5) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:458:0x0081, code lost:
            r20.f4305h = 4;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 438
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: g6.a.C0062a.run():void");
        }
    }

    public a(int i7, int i8, long j5, String str) {
        this.f4295f = i7;
        this.f4296g = i8;
        this.f4297h = j5;
        this.f4298i = str;
        if (!(i7 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i7 + " should be at least 1").toString());
        }
        if (!(i8 >= i7)) {
            throw new IllegalArgumentException(("Max pool size " + i8 + " should be greater than or equals to core pool size " + i7).toString());
        }
        if (!(i8 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i8 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j5 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j5 + " must be positive").toString());
        }
        this.f4299j = new d();
        this.f4300k = new d();
        this.f4301l = new q<>((i7 + 1) * 2);
        this.controlState = i7 << 42;
        this._isTerminated = 0;
    }

    public final int b() {
        synchronized (this.f4301l) {
            if (f4293o.get(this) != 0) {
                return -1;
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater = f4292n;
            long j5 = atomicLongFieldUpdater.get(this);
            int i7 = (int) (j5 & 2097151);
            int i8 = i7 - ((int) ((j5 & 4398044413952L) >> 21));
            if (i8 < 0) {
                i8 = 0;
            }
            if (i8 >= this.f4295f) {
                return 0;
            }
            if (i7 >= this.f4296g) {
                return 0;
            }
            int i9 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
            if (i9 > 0 && this.f4301l.b(i9) == null) {
                C0062a c0062a = new C0062a(i9);
                this.f4301l.c(i9, c0062a);
                if (i9 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    int i10 = i8 + 1;
                    c0062a.start();
                    return i10;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:264:0x008a, code lost:
        if (r1 == null) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0077 A[LOOP:0: B:246:0x0037->B:260:0x0077, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x007a A[EDGE_INSN: B:289:0x007a->B:261:0x007a ?: BREAK  , SYNTHETIC] */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = g6.a.f4293o
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r9, r1, r2)
            if (r0 != 0) goto Lc
            goto Lb2
        Lc:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r3 = r0 instanceof g6.a.C0062a
            r4 = 0
            if (r3 == 0) goto L18
            g6.a$a r0 = (g6.a.C0062a) r0
            goto L19
        L18:
            r0 = r4
        L19:
            if (r0 == 0) goto L24
            g6.a r3 = g6.a.this
            boolean r3 = r5.h.a(r3, r9)
            if (r3 == 0) goto L24
            goto L25
        L24:
            r0 = r4
        L25:
            f6.q<g6.a$a> r3 = r9.f4301l
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r5 = g6.a.f4292n     // Catch: java.lang.Throwable -> Lc6
            long r5 = r5.get(r9)     // Catch: java.lang.Throwable -> Lc6
            r7 = 2097151(0x1fffff, double:1.0361303E-317)
            long r5 = r5 & r7
            int r5 = (int) r5
            monitor-exit(r3)
            if (r2 > r5) goto L7a
            r3 = r2
        L37:
            f6.q<g6.a$a> r6 = r9.f4301l
            java.lang.Object r6 = r6.b(r3)
            r5.h.c(r6)
            g6.a$a r6 = (g6.a.C0062a) r6
            if (r6 == r0) goto L75
        L44:
            boolean r7 = r6.isAlive()
            if (r7 == 0) goto L53
            java.util.concurrent.locks.LockSupport.unpark(r6)
            r7 = 10000(0x2710, double:4.9407E-320)
            r6.join(r7)
            goto L44
        L53:
            g6.m r6 = r6.f4303f
            g6.d r7 = r9.f4300k
            r6.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = g6.m.f4327b
            java.lang.Object r8 = r8.getAndSet(r6, r4)
            g6.g r8 = (g6.g) r8
            if (r8 == 0) goto L67
            r7.a(r8)
        L67:
            g6.g r8 = r6.b()
            if (r8 != 0) goto L6f
            r8 = r1
            goto L73
        L6f:
            r7.a(r8)
            r8 = r2
        L73:
            if (r8 != 0) goto L67
        L75:
            if (r3 == r5) goto L7a
            int r3 = r3 + 1
            goto L37
        L7a:
            g6.d r1 = r9.f4300k
            r1.b()
            g6.d r1 = r9.f4299j
            r1.b()
        L84:
            if (r0 == 0) goto L8c
            g6.g r1 = r0.a(r2)
            if (r1 != 0) goto Lb3
        L8c:
            g6.d r1 = r9.f4299j
            java.lang.Object r1 = r1.d()
            g6.g r1 = (g6.g) r1
            if (r1 != 0) goto Lb3
            g6.d r1 = r9.f4300k
            java.lang.Object r1 = r1.d()
            g6.g r1 = (g6.g) r1
            if (r1 != 0) goto Lb3
            if (r0 == 0) goto La6
            r1 = 5
            r0.h(r1)
        La6:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = g6.a.m
            r1 = 0
            r0.set(r9, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = g6.a.f4292n
            r0.set(r9, r1)
        Lb2:
            return
        Lb3:
            r1.run()     // Catch: java.lang.Throwable -> Lb7
            goto L84
        Lb7:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> Lc4
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()     // Catch: java.lang.Throwable -> Lc4
            r4.uncaughtException(r3, r1)     // Catch: java.lang.Throwable -> Lc4
            goto L84
        Lc4:
            r9 = move-exception
            throw r9
        Lc6:
            r9 = move-exception
            monitor-exit(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: g6.a.close():void");
    }

    public final void d(Runnable runnable, h hVar, boolean z6) {
        g jVar;
        k.f4323f.getClass();
        long nanoTime = System.nanoTime();
        if (runnable instanceof g) {
            jVar = (g) runnable;
            jVar.f4315f = nanoTime;
            jVar.f4316g = hVar;
        } else {
            jVar = new j(runnable, nanoTime, hVar);
        }
        boolean z7 = false;
        boolean z8 = jVar.f4316g.b() == 1;
        long addAndGet = z8 ? f4292n.addAndGet(this, 2097152L) : 0L;
        Thread currentThread = Thread.currentThread();
        C0062a c0062a = currentThread instanceof C0062a ? (C0062a) currentThread : null;
        if (c0062a == null || !r5.h.a(a.this, this)) {
            c0062a = null;
        }
        if (c0062a != null && c0062a.f4305h != 5 && (jVar.f4316g.b() != 0 || c0062a.f4305h != 2)) {
            c0062a.f4309l = true;
            m mVar = c0062a.f4303f;
            if (z6) {
                jVar = mVar.a(jVar);
            } else {
                mVar.getClass();
                g gVar = (g) m.f4327b.getAndSet(mVar, jVar);
                jVar = gVar == null ? null : mVar.a(gVar);
            }
        }
        if (jVar != null) {
            if (!(jVar.f4316g.b() == 1 ? this.f4300k : this.f4299j).a(jVar)) {
                throw new RejectedExecutionException(androidx.activity.h.c(new StringBuilder(), this.f4298i, " was terminated"));
            }
        }
        if (z6 && c0062a != null) {
            z7 = true;
        }
        if (z8) {
            if (z7 || i() || f(addAndGet)) {
                return;
            }
            i();
        } else if (z7 || i() || f(f4292n.get(this))) {
        } else {
            i();
        }
    }

    public final void e(C0062a c0062a, int i7, int i8) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = m;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            int i9 = (int) (2097151 & j5);
            long j7 = (2097152 + j5) & (-2097152);
            if (i9 == i7) {
                if (i8 == 0) {
                    C0062a c0062a2 = c0062a;
                    while (true) {
                        Object c7 = c0062a2.c();
                        if (c7 != f4294p) {
                            if (c7 != null) {
                                c0062a2 = (C0062a) c7;
                                int b2 = c0062a2.b();
                                if (b2 != 0) {
                                    i9 = b2;
                                    break;
                                }
                            } else {
                                i9 = 0;
                                break;
                            }
                        } else {
                            i9 = -1;
                            break;
                        }
                    }
                } else {
                    i9 = i8;
                }
            }
            if (i9 >= 0 && m.compareAndSet(this, j5, j7 | i9)) {
                return;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        d(runnable, k.f4324g, false);
    }

    public final boolean f(long j5) {
        int i7 = ((int) (2097151 & j5)) - ((int) ((j5 & 4398044413952L) >> 21));
        if (i7 < 0) {
            i7 = 0;
        }
        if (i7 < this.f4295f) {
            int b2 = b();
            if (b2 == 1 && this.f4295f > 1) {
                b();
            }
            if (b2 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean i() {
        C0062a b2;
        q.d dVar;
        int i7;
        do {
            AtomicLongFieldUpdater atomicLongFieldUpdater = m;
            while (true) {
                long j5 = atomicLongFieldUpdater.get(this);
                b2 = this.f4301l.b((int) (2097151 & j5));
                if (b2 != null) {
                    long j7 = (2097152 + j5) & (-2097152);
                    C0062a c0062a = b2;
                    while (true) {
                        Object c7 = c0062a.c();
                        dVar = f4294p;
                        if (c7 != dVar) {
                            if (c7 != null) {
                                c0062a = (C0062a) c7;
                                i7 = c0062a.b();
                                if (i7 != 0) {
                                    break;
                                }
                            } else {
                                i7 = 0;
                                break;
                            }
                        } else {
                            i7 = -1;
                            break;
                        }
                    }
                    if (i7 >= 0 && m.compareAndSet(this, j5, i7 | j7)) {
                        b2.g(dVar);
                        break;
                    }
                } else {
                    b2 = null;
                    break;
                }
            }
            if (b2 == null) {
                return false;
            }
        } while (!C0062a.f4302n.compareAndSet(b2, -1, 0));
        LockSupport.unpark(b2);
        return true;
    }

    public final String toString() {
        StringBuilder sb;
        char c7;
        ArrayList arrayList = new ArrayList();
        int a7 = this.f4301l.a();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 1; i12 < a7; i12++) {
            C0062a b2 = this.f4301l.b(i12);
            if (b2 != null) {
                m mVar = b2.f4303f;
                mVar.getClass();
                Object obj = m.f4327b.get(mVar);
                int i13 = m.f4328c.get(mVar) - m.f4329d.get(mVar);
                if (obj != null) {
                    i13++;
                }
                int a8 = p.a(b2.f4305h);
                if (a8 == 0) {
                    i7++;
                    sb = new StringBuilder();
                    sb.append(i13);
                    c7 = 'c';
                } else if (a8 == 1) {
                    i8++;
                    sb = new StringBuilder();
                    sb.append(i13);
                    c7 = 'b';
                } else if (a8 == 2) {
                    i9++;
                } else if (a8 == 3) {
                    i10++;
                    if (i13 > 0) {
                        sb = new StringBuilder();
                        sb.append(i13);
                        c7 = 'd';
                    }
                } else if (a8 == 4) {
                    i11++;
                }
                sb.append(c7);
                arrayList.add(sb.toString());
            }
        }
        long j5 = f4292n.get(this);
        return this.f4298i + '@' + a0.c(this) + "[Pool Size {core = " + this.f4295f + ", max = " + this.f4296g + "}, Worker States {CPU = " + i7 + ", blocking = " + i8 + ", parked = " + i9 + ", dormant = " + i10 + ", terminated = " + i11 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f4299j.c() + ", global blocking queue size = " + this.f4300k.c() + ", Control State {created workers= " + ((int) (2097151 & j5)) + ", blocking tasks = " + ((int) ((4398044413952L & j5) >> 21)) + ", CPUs acquired = " + (this.f4295f - ((int) ((j5 & 9223367638808264704L) >> 42))) + "}]";
    }
}
