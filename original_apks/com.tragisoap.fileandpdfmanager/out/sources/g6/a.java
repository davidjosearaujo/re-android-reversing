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
import q.d;
import r5.h;
import r5.s;
import u5.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements Executor, Closeable {
    public static final AtomicLongFieldUpdater m = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* renamed from: n */
    public static final AtomicLongFieldUpdater f4292n = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* renamed from: o */
    public static final AtomicIntegerFieldUpdater f4293o = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* renamed from: p */
    public static final d f4294p = new d(4, "NOT_IN_STACK");
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
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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
            this.f4308k = c.f6119f.a();
            f(i7);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00d0  */
        /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final g6.g a(boolean r11) {
            /*
                Method dump skipped, instructions count: 226
                To view this dump add '--comments-level debug' option
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
            boolean z6 = true;
            if (i8 != 1) {
                z6 = false;
            }
            if (z6) {
                a.f4292n.addAndGet(a.this, 4398046511104L);
            }
            if (i8 != i7) {
                this.f4305h = i7;
            }
            return z6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x00ce A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r7v1, types: [T] */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v7, types: [g6.g] */
        /* JADX WARN: Type inference failed for: r7v9, types: [g6.g] */
        /* JADX WARN: Type inference failed for: r8v1, types: [T, g6.g, java.lang.Object] */
        /* JADX WARN: Unknown variable types count: 2 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final g6.g i(int r22) {
            /*
                Method dump skipped, instructions count: 264
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: g6.a.C0062a.i(int):g6.g");
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
            r20.f4307j = 0;
            r2 = r4.f4316g.b();
            r20.f4306i = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
            if (r20.f4305h != 3) goto L_0x003b;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
            r20.f4305h = 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
            if (r2 != 0) goto L_0x003e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
            if (h(2) == false) goto L_0x005d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
            r0 = g6.a.this;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
            if (r0.i() == false) goto L_0x004d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
            if (r0.f(g6.a.f4292n.get(r0)) == false) goto L_0x005a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
            r0.i();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
            g6.a.this.getClass();
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
            r4.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0073, code lost:
            if (r2 == 0) goto L_0x0002;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
            g6.a.f4292n.addAndGet(g6.a.this, -2097152);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
            if (r20.f4305h != 5) goto L_0x0081;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0081, code lost:
            r20.f4305h = 4;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 438
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: g6.a.C0062a.run():void");
        }
    }

    public a(int i7, int i8, long j7, String str) {
        this.f4295f = i7;
        this.f4296g = i8;
        this.f4297h = j7;
        this.f4298i = str;
        boolean z6 = true;
        if (i7 >= 1) {
            if (i8 >= i7) {
                if (i8 <= 2097150) {
                    if (j7 <= 0 ? false : z6) {
                        this.f4299j = new d();
                        this.f4300k = new d();
                        this.f4301l = new q<>((i7 + 1) * 2);
                        this.controlState = ((long) i7) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j7 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i8 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + i8 + " should be greater than or equals to core pool size " + i7).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i7 + " should be at least 1").toString());
    }

    public final int b() {
        synchronized (this.f4301l) {
            boolean z6 = false;
            if (f4293o.get(this) != 0) {
                return -1;
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater = f4292n;
            long j7 = atomicLongFieldUpdater.get(this);
            int i7 = (int) (j7 & 2097151);
            int i8 = i7 - ((int) ((j7 & 4398044413952L) >> 21));
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
                C0062a aVar = new C0062a(i9);
                this.f4301l.c(i9, aVar);
                if (i9 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    z6 = true;
                }
                if (z6) {
                    int i10 = i8 + 1;
                    aVar.start();
                    return i10;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008a, code lost:
        if (r1 == null) goto L_0x008c;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0077 A[LOOP:0: B:19:0x0037->B:33:0x0077, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x007a A[EDGE_INSN: B:59:0x007a->B:34:0x007a ?: BREAK  , SYNTHETIC] */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = g6.a.f4293o
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r9, r1, r2)
            if (r0 != 0) goto L_0x000c
            goto L_0x00b2
        L_0x000c:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r3 = r0 instanceof g6.a.C0062a
            r4 = 0
            if (r3 == 0) goto L_0x0018
            g6.a$a r0 = (g6.a.C0062a) r0
            goto L_0x0019
        L_0x0018:
            r0 = r4
        L_0x0019:
            if (r0 == 0) goto L_0x0024
            g6.a r3 = g6.a.this
            boolean r3 = r5.h.a(r3, r9)
            if (r3 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r0 = r4
        L_0x0025:
            f6.q<g6.a$a> r3 = r9.f4301l
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r5 = g6.a.f4292n     // Catch: all -> 0x00c6
            long r5 = r5.get(r9)     // Catch: all -> 0x00c6
            r7 = 2097151(0x1fffff, double:1.0361303E-317)
            long r5 = r5 & r7
            int r5 = (int) r5
            monitor-exit(r3)
            if (r2 > r5) goto L_0x007a
            r3 = r2
        L_0x0037:
            f6.q<g6.a$a> r6 = r9.f4301l
            java.lang.Object r6 = r6.b(r3)
            r5.h.c(r6)
            g6.a$a r6 = (g6.a.C0062a) r6
            if (r6 == r0) goto L_0x0075
        L_0x0044:
            boolean r7 = r6.isAlive()
            if (r7 == 0) goto L_0x0053
            java.util.concurrent.locks.LockSupport.unpark(r6)
            r7 = 10000(0x2710, double:4.9407E-320)
            r6.join(r7)
            goto L_0x0044
        L_0x0053:
            g6.m r6 = r6.f4303f
            g6.d r7 = r9.f4300k
            r6.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = g6.m.f4327b
            java.lang.Object r8 = r8.getAndSet(r6, r4)
            g6.g r8 = (g6.g) r8
            if (r8 == 0) goto L_0x0067
            r7.a(r8)
        L_0x0067:
            g6.g r8 = r6.b()
            if (r8 != 0) goto L_0x006f
            r8 = r1
            goto L_0x0073
        L_0x006f:
            r7.a(r8)
            r8 = r2
        L_0x0073:
            if (r8 != 0) goto L_0x0067
        L_0x0075:
            if (r3 == r5) goto L_0x007a
            int r3 = r3 + 1
            goto L_0x0037
        L_0x007a:
            g6.d r1 = r9.f4300k
            r1.b()
            g6.d r1 = r9.f4299j
            r1.b()
        L_0x0084:
            if (r0 == 0) goto L_0x008c
            g6.g r1 = r0.a(r2)
            if (r1 != 0) goto L_0x00b3
        L_0x008c:
            g6.d r1 = r9.f4299j
            java.lang.Object r1 = r1.d()
            g6.g r1 = (g6.g) r1
            if (r1 != 0) goto L_0x00b3
            g6.d r1 = r9.f4300k
            java.lang.Object r1 = r1.d()
            g6.g r1 = (g6.g) r1
            if (r1 != 0) goto L_0x00b3
            if (r0 == 0) goto L_0x00a6
            r1 = 5
            r0.h(r1)
        L_0x00a6:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = g6.a.m
            r1 = 0
            r0.set(r9, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = g6.a.f4292n
            r0.set(r9, r1)
        L_0x00b2:
            return
        L_0x00b3:
            r1.run()     // Catch: all -> 0x00b7
            goto L_0x0084
        L_0x00b7:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch: all -> 0x00c4
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()     // Catch: all -> 0x00c4
            r4.uncaughtException(r3, r1)     // Catch: all -> 0x00c4
            goto L_0x0084
        L_0x00c4:
            r9 = move-exception
            throw r9
        L_0x00c6:
            r9 = move-exception
            monitor-exit(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: g6.a.close():void");
    }

    public final void d(Runnable runnable, h hVar, boolean z6) {
        g gVar;
        k.f4323f.getClass();
        long nanoTime = System.nanoTime();
        if (runnable instanceof g) {
            gVar = (g) runnable;
            gVar.f4315f = nanoTime;
            gVar.f4316g = hVar;
        } else {
            gVar = new j(runnable, nanoTime, hVar);
        }
        boolean z7 = false;
        boolean z8 = gVar.f4316g.b() == 1;
        long addAndGet = z8 ? f4292n.addAndGet(this, 2097152) : 0;
        Thread currentThread = Thread.currentThread();
        C0062a aVar = currentThread instanceof C0062a ? (C0062a) currentThread : null;
        if (aVar == null || !h.a(a.this, this)) {
            aVar = null;
        }
        if (!(aVar == null || aVar.f4305h == 5 || (gVar.f4316g.b() == 0 && aVar.f4305h == 2))) {
            aVar.f4309l = true;
            m mVar = aVar.f4303f;
            if (z6) {
                gVar = mVar.a(gVar);
            } else {
                mVar.getClass();
                g gVar2 = (g) m.f4327b.getAndSet(mVar, gVar);
                gVar = gVar2 == null ? null : mVar.a(gVar2);
            }
        }
        if (gVar != null) {
            if (!(gVar.f4316g.b() == 1 ? this.f4300k : this.f4299j).a(gVar)) {
                throw new RejectedExecutionException(androidx.activity.h.c(new StringBuilder(), this.f4298i, " was terminated"));
            }
        }
        if (z6 && aVar != null) {
            z7 = true;
        }
        if (z8) {
            if (!z7 && !i() && !f(addAndGet)) {
                i();
            }
        } else if (!z7 && !i() && !f(f4292n.get(this))) {
            i();
        }
    }

    public final void e(C0062a aVar, int i7, int i8) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = m;
        while (true) {
            long j7 = atomicLongFieldUpdater.get(this);
            int i9 = (int) (2097151 & j7);
            long j8 = (2097152 + j7) & -2097152;
            if (i9 == i7) {
                if (i8 == 0) {
                    C0062a aVar2 = aVar;
                    while (true) {
                        Object c7 = aVar2.c();
                        if (c7 != f4294p) {
                            if (c7 != null) {
                                aVar2 = (C0062a) c7;
                                int b2 = aVar2.b();
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
            if (i9 >= 0 && m.compareAndSet(this, j7, j8 | ((long) i9))) {
                return;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        d(runnable, k.f4324g, false);
    }

    public final boolean f(long j7) {
        int i7 = ((int) (2097151 & j7)) - ((int) ((j7 & 4398044413952L) >> 21));
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
        d dVar;
        int i7;
        do {
            AtomicLongFieldUpdater atomicLongFieldUpdater = m;
            while (true) {
                long j7 = atomicLongFieldUpdater.get(this);
                b2 = this.f4301l.b((int) (2097151 & j7));
                if (b2 != null) {
                    long j8 = (2097152 + j7) & -2097152;
                    C0062a aVar = b2;
                    while (true) {
                        Object c7 = aVar.c();
                        dVar = f4294p;
                        if (c7 != dVar) {
                            if (c7 != null) {
                                aVar = (C0062a) c7;
                                i7 = aVar.b();
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
                    if (i7 >= 0 && m.compareAndSet(this, j7, ((long) i7) | j8)) {
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

    @Override // java.lang.Object
    public final String toString() {
        char c7;
        StringBuilder sb;
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
        long j7 = f4292n.get(this);
        return this.f4298i + '@' + a0.c(this) + "[Pool Size {core = " + this.f4295f + ", max = " + this.f4296g + "}, Worker States {CPU = " + i7 + ", blocking = " + i8 + ", parked = " + i9 + ", dormant = " + i10 + ", terminated = " + i11 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f4299j.c() + ", global blocking queue size = " + this.f4300k.c() + ", Control State {created workers= " + ((int) (2097151 & j7)) + ", blocking tasks = " + ((int) ((4398044413952L & j7) >> 21)) + ", CPUs acquired = " + (this.f4295f - ((int) ((j7 & 9223367638808264704L) >> 42))) + "}]";
    }
}
