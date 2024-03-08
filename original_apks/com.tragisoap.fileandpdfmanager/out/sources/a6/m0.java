package a6;

import androidx.activity.h;
import f5.g;
import f6.k;
import f6.w;
import f6.x;
import i5.f;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import q.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class m0 extends n0 implements d0 {

    /* renamed from: l */
    public static final AtomicReferenceFieldUpdater f310l = AtomicReferenceFieldUpdater.newUpdater(m0.class, Object.class, "_queue");
    public static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(m0.class, Object.class, "_delayed");

    /* renamed from: n */
    public static final AtomicIntegerFieldUpdater f311n = AtomicIntegerFieldUpdater.newUpdater(m0.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final class a extends b {

        /* renamed from: h */
        public final g<g> f312h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j7, h hVar) {
            super(j7);
            m0.this = r1;
            this.f312h = hVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f312h.r(m0.this, g.f4141a);
        }

        @Override // a6.m0.b, java.lang.Object
        public final String toString() {
            return super.toString() + this.f312h;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class b implements Runnable, Comparable<b>, i0, x {
        private volatile Object _heap;

        /* renamed from: f */
        public long f314f;

        /* renamed from: g */
        public int f315g = -1;

        public b(long j7) {
            this.f314f = j7;
        }

        @Override // a6.i0
        public final void a() {
            synchronized (this) {
                Object obj = this._heap;
                d dVar = a0.b.f3a;
                if (obj != dVar) {
                    w wVar = null;
                    c cVar = obj instanceof c ? (c) obj : null;
                    if (cVar != null) {
                        synchronized (cVar) {
                            Object obj2 = this._heap;
                            if (obj2 instanceof w) {
                                wVar = (w) obj2;
                            }
                            if (wVar != null) {
                                cVar.c(this.f315g);
                            }
                        }
                    }
                    this._heap = dVar;
                    g gVar = g.f4141a;
                }
            }
        }

        @Override // f6.x
        public final void b(c cVar) {
            if (this._heap != a0.b.f3a) {
                this._heap = cVar;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // java.lang.Comparable
        public final int compareTo(b bVar) {
            int i7 = ((this.f314f - bVar.f314f) > 0 ? 1 : ((this.f314f - bVar.f314f) == 0 ? 0 : -1));
            if (i7 > 0) {
                return 1;
            }
            return i7 < 0 ? -1 : 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
            if ((r8 - r10.f316c) > 0) goto L_0x0036;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [T extends f6.x & java.lang.Comparable<? super T>[]] */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int d(long r8, a6.m0.c r10, a6.m0 r11) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.lang.Object r0 = r7._heap     // Catch: all -> 0x004c
                q.d r1 = a0.b.f3a     // Catch: all -> 0x004c
                r2 = 0
                if (r0 != r1) goto L_0x000a
                r2 = 2
                goto L_0x0047
            L_0x000a:
                monitor-enter(r10)     // Catch: all -> 0x004c
                T extends f6.x & java.lang.Comparable<? super T>[] r0 = r10.f4187a     // Catch: all -> 0x0049
                if (r0 == 0) goto L_0x0012
                r0 = r0[r2]     // Catch: all -> 0x0049
                goto L_0x0013
            L_0x0012:
                r0 = 0
            L_0x0013:
                a6.m0$b r0 = (a6.m0.b) r0     // Catch: all -> 0x0049
                boolean r11 = a6.m0.e0(r11)     // Catch: all -> 0x0049
                if (r11 == 0) goto L_0x001f
                r8 = 1
                monitor-exit(r10)     // Catch: all -> 0x004c
                monitor-exit(r7)
                return r8
            L_0x001f:
                r3 = 0
                if (r0 != 0) goto L_0x0024
                goto L_0x0036
            L_0x0024:
                long r0 = r0.f314f     // Catch: all -> 0x0049
                long r5 = r0 - r8
                int r11 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r11 < 0) goto L_0x002d
                goto L_0x002e
            L_0x002d:
                r8 = r0
            L_0x002e:
                long r0 = r10.f316c     // Catch: all -> 0x0049
                long r0 = r8 - r0
                int r11 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r11 <= 0) goto L_0x0038
            L_0x0036:
                r10.f316c = r8     // Catch: all -> 0x0049
            L_0x0038:
                long r8 = r7.f314f     // Catch: all -> 0x0049
                long r0 = r10.f316c     // Catch: all -> 0x0049
                long r8 = r8 - r0
                int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r8 >= 0) goto L_0x0043
                r7.f314f = r0     // Catch: all -> 0x0049
            L_0x0043:
                r10.a(r7)     // Catch: all -> 0x0049
                monitor-exit(r10)     // Catch: all -> 0x004c
            L_0x0047:
                monitor-exit(r7)
                return r2
            L_0x0049:
                r8 = move-exception
                monitor-exit(r10)     // Catch: all -> 0x004c
                throw r8     // Catch: all -> 0x004c
            L_0x004c:
                r8 = move-exception
                monitor-exit(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: a6.m0.b.d(long, a6.m0$c, a6.m0):int");
        }

        @Override // f6.x
        public final void setIndex(int i7) {
            this.f315g = i7;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder d7 = h.d("Delayed[nanos=");
            d7.append(this.f314f);
            d7.append(']');
            return d7.toString();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c extends w<b> {

        /* renamed from: c */
        public long f316c;

        public c(long j7) {
            this.f316c = j7;
        }
    }

    public static final boolean e0(m0 m0Var) {
        m0Var.getClass();
        return f311n.get(m0Var) != 0;
    }

    @Override // a6.d0
    public final void J(long j7, h hVar) {
        long j8 = 0;
        if (j7 > 0) {
            j8 = j7 >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j7;
        }
        if (j8 < 4611686018427387903L) {
            long nanoTime = System.nanoTime();
            a aVar = new a(j8 + nanoTime, hVar);
            i0(nanoTime, aVar);
            hVar.w(new j0(0, aVar));
        }
    }

    @Override // a6.u
    public final void U(f fVar, Runnable runnable) {
        f0(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x008c, code lost:
        r8 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [T extends f6.x & java.lang.Comparable<? super T>[]] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, a6.m0, a6.l0] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r8v18, types: [T extends f6.x & java.lang.Comparable<? super T>[]] */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Unknown variable types count: 2 */
    @Override // a6.l0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a0() {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.m0.a0():long");
    }

    public void f0(Runnable runnable) {
        if (g0(runnable)) {
            Thread c02 = c0();
            if (Thread.currentThread() != c02) {
                LockSupport.unpark(c02);
                return;
            }
            return;
        }
        b0.f283o.f0(runnable);
    }

    public final boolean g0(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f310l;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z6 = false;
            if (f311n.get(this) != 0) {
                return false;
            }
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f310l;
                while (true) {
                    if (!atomicReferenceFieldUpdater2.compareAndSet(this, null, runnable)) {
                        if (atomicReferenceFieldUpdater2.get(this) != null) {
                            break;
                        }
                    } else {
                        z6 = true;
                        break;
                    }
                }
                if (z6) {
                    return true;
                }
            } else if (obj instanceof k) {
                k kVar = (k) obj;
                int a7 = kVar.a(runnable);
                if (a7 == 0) {
                    return true;
                }
                if (a7 == 1) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f310l;
                    k c7 = kVar.c();
                    while (!atomicReferenceFieldUpdater3.compareAndSet(this, obj, c7) && atomicReferenceFieldUpdater3.get(this) == obj) {
                    }
                } else if (a7 == 2) {
                    return false;
                }
            } else if (obj == a0.b.f4b) {
                return false;
            } else {
                k kVar2 = new k(8, true);
                kVar2.a((Runnable) obj);
                kVar2.a(runnable);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4 = f310l;
                while (true) {
                    if (!atomicReferenceFieldUpdater4.compareAndSet(this, obj, kVar2)) {
                        if (atomicReferenceFieldUpdater4.get(this) != obj) {
                            break;
                        }
                    } else {
                        z6 = true;
                        break;
                    }
                }
                if (z6) {
                    return true;
                }
            }
        }
    }

    public final boolean h0() {
        g5.h<g0<?>> hVar = this.f309j;
        if (!(hVar != null ? hVar.isEmpty() : true)) {
            return false;
        }
        c cVar = (c) m.get(this);
        if (cVar != null) {
            if (!(cVar.b() == 0)) {
                return false;
            }
        }
        Object obj = f310l.get(this);
        if (obj == null) {
            return true;
        }
        if (obj instanceof k) {
            long j7 = k.f4165f.get((k) obj);
            if (((int) ((1073741823 & j7) >> 0)) == ((int) ((j7 & 1152921503533105152L) >> 30))) {
                return true;
            }
        } else if (obj == a0.b.f4b) {
            return true;
        }
        return false;
    }

    public final void i0(long j7, b bVar) {
        int i7;
        Thread c02;
        boolean z6 = true;
        x xVar = null;
        if (f311n.get(this) != 0) {
            i7 = 1;
        } else {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
            c cVar = (c) atomicReferenceFieldUpdater.get(this);
            if (cVar == null) {
                c cVar2 = new c(j7);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, cVar2) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj = m.get(this);
                r5.h.c(obj);
                cVar = (c) obj;
            }
            i7 = bVar.d(j7, cVar, this);
        }
        if (i7 == 0) {
            c cVar3 = (c) m.get(this);
            if (cVar3 != null) {
                synchronized (cVar3) {
                    x[] xVarArr = cVar3.f4187a;
                    if (xVarArr != null) {
                        xVar = xVarArr[0];
                    }
                }
                xVar = (b) xVar;
            }
            if (xVar != bVar) {
                z6 = false;
            }
            if (z6 && Thread.currentThread() != (c02 = c0())) {
                LockSupport.unpark(c02);
            }
        } else if (i7 == 1) {
            d0(j7, bVar);
        } else if (i7 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    @Override // a6.l0
    public void shutdown() {
        b c7;
        boolean z6;
        boolean z7;
        ThreadLocal<l0> threadLocal = k1.f304a;
        k1.f304a.set(null);
        f311n.set(this, 1);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f310l;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f310l;
                d dVar = a0.b.f4b;
                while (true) {
                    if (!atomicReferenceFieldUpdater2.compareAndSet(this, null, dVar)) {
                        if (atomicReferenceFieldUpdater2.get(this) != null) {
                            z6 = false;
                            break;
                        }
                    } else {
                        z6 = true;
                        break;
                    }
                }
                if (z6) {
                    break;
                }
            } else if (obj instanceof k) {
                ((k) obj).b();
                break;
            } else if (obj == a0.b.f4b) {
                break;
            } else {
                k kVar = new k(8, true);
                kVar.a((Runnable) obj);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f310l;
                while (true) {
                    if (!atomicReferenceFieldUpdater3.compareAndSet(this, obj, kVar)) {
                        if (atomicReferenceFieldUpdater3.get(this) != obj) {
                            z7 = false;
                            break;
                        }
                    } else {
                        z7 = true;
                        break;
                    }
                }
                if (z7) {
                    break;
                }
            }
        }
        do {
        } while (a0() <= 0);
        long nanoTime = System.nanoTime();
        while (true) {
            c cVar = (c) m.get(this);
            if (cVar != null) {
                synchronized (cVar) {
                    c7 = cVar.b() > 0 ? cVar.c(0) : null;
                }
                b bVar = c7;
                if (bVar != null) {
                    d0(nanoTime, bVar);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
