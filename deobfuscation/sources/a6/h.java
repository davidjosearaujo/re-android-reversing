package a6;

import a6.u0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class h<T> extends g0 implements g, k5.d, p1 {

    /* renamed from: k */
    public static final AtomicIntegerFieldUpdater f293k = AtomicIntegerFieldUpdater.newUpdater(h.class, "_decisionAndIndex");

    /* renamed from: l */
    public static final AtomicReferenceFieldUpdater f294l = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_state");
    public static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* renamed from: i */
    public final i5.d f295i;

    /* renamed from: j */
    public final i5.f f296j;

    public h(int i7, i5.d dVar) {
        super(i7);
        this.f295i = dVar;
        this.f296j = dVar.a();
        this._decisionAndIndex = 536870911;
        this._state = b.f282f;
    }

    public static Object C(e1 e1Var, Object obj, int i7, q5.l lVar) {
        if (obj instanceof o) {
            return obj;
        }
        boolean z6 = true;
        if (i7 != 1 && i7 != 2) {
            z6 = false;
        }
        if (z6) {
            if (lVar != null || (e1Var instanceof e)) {
                return new n(obj, e1Var instanceof e ? (e) e1Var : null, lVar, (CancellationException) null, 16);
            }
            return obj;
        }
        return obj;
    }

    public static void z(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0029, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A() {
        /*
            r8 = this;
            i5.d r0 = r8.f295i
            boolean r1 = r0 instanceof f6.f
            r2 = 0
            if (r1 == 0) goto La
            f6.f r0 = (f6.f) r0
            goto Lb
        La:
            r0 = r2
        Lb:
            if (r0 == 0) goto L76
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f6.f.m
        Lf:
            java.lang.Object r3 = r1.get(r0)
            q.d r4 = a0.b.B
            r5 = 0
            r6 = 1
            if (r3 != r4) goto L2c
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = f6.f.m
        L1b:
            boolean r3 = r7.compareAndSet(r0, r4, r8)
            if (r3 == 0) goto L23
            r5 = r6
            goto L29
        L23:
            java.lang.Object r3 = r7.get(r0)
            if (r3 == r4) goto L1b
        L29:
            if (r5 == 0) goto Lf
            goto L45
        L2c:
            boolean r1 = r3 instanceof java.lang.Throwable
            if (r1 == 0) goto L5b
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f6.f.m
        L32:
            boolean r4 = r1.compareAndSet(r0, r3, r2)
            if (r4 == 0) goto L3a
            r5 = r6
            goto L40
        L3a:
            java.lang.Object r4 = r1.get(r0)
            if (r4 == r3) goto L32
        L40:
            if (r5 == 0) goto L4f
            r2 = r3
            java.lang.Throwable r2 = (java.lang.Throwable) r2
        L45:
            if (r2 != 0) goto L48
            goto L76
        L48:
            r8.q()
            r8.p(r2)
            return
        L4f:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Failed requirement."
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L5b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Inconsistent state "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.h.A():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0023, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B(java.lang.Object r8, int r9, q5.l r10) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = a6.h.f294l
        L2:
            java.lang.Object r1 = r0.get(r7)
            boolean r2 = r1 instanceof a6.e1
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            r2 = r1
            a6.e1 r2 = (a6.e1) r2
            java.lang.Object r2 = C(r2, r8, r9, r10)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = a6.h.f294l
        L15:
            boolean r6 = r5.compareAndSet(r7, r1, r2)
            if (r6 == 0) goto L1d
            r3 = r4
            goto L23
        L1d:
            java.lang.Object r6 = r5.get(r7)
            if (r6 == r1) goto L15
        L23:
            if (r3 == 0) goto L2
            boolean r8 = r7.y()
            if (r8 != 0) goto L2e
            r7.q()
        L2e:
            r7.s(r9)
            return
        L32:
            boolean r9 = r1 instanceof a6.i
            if (r9 == 0) goto L4b
            a6.i r1 = (a6.i) r1
            r1.getClass()
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r9 = a6.i.f299c
            boolean r9 = r9.compareAndSet(r1, r3, r4)
            if (r9 == 0) goto L4b
            if (r10 == 0) goto L4a
            java.lang.Throwable r8 = r1.f324a
            r7.m(r10, r8)
        L4a:
            return
        L4b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Already resumed, but proposed with update "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.h.B(java.lang.Object, int, q5.l):void");
    }

    public final i5.f a() {
        return this.f296j;
    }

    public final void b(f6.s sVar, int i7) {
        int i8;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f293k;
        do {
            i8 = atomicIntegerFieldUpdater.get(this);
            if (!((i8 & 536870911) == 536870911)) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i8, ((i8 >> 29) << 29) + i7));
        x(sVar);
    }

    public final q.d c(Object obj, q5.l lVar) {
        boolean z6;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f294l;
        do {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof e1)) {
                boolean z7 = obj2 instanceof n;
                return null;
            }
            Object C = C((e1) obj2, obj, this.f291h, lVar);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f294l;
            while (true) {
                if (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, C)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                        z6 = false;
                        continue;
                        break;
                    }
                } else {
                    z6 = true;
                    continue;
                    break;
                }
            }
        } while (!z6);
        if (!y()) {
            q();
        }
        return a0.e.f37f;
    }

    public final void d(Object obj, CancellationException cancellationException) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f294l;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof e1) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof o) {
                return;
            }
            boolean z6 = true;
            if (obj2 instanceof n) {
                n nVar = (n) obj2;
                if (!(!(nVar.e != null))) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                n a7 = n.a(nVar, null, cancellationException, 15);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f294l;
                while (true) {
                    if (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, a7)) {
                        if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                            z6 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z6) {
                    e eVar = nVar.f319b;
                    if (eVar != null) {
                        l(eVar, cancellationException);
                    }
                    q5.l<Throwable, f5.g> lVar = nVar.f320c;
                    if (lVar != null) {
                        m(lVar, cancellationException);
                        return;
                    }
                    return;
                }
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f294l;
                n nVar2 = new n(obj2, (e) null, (q5.l) null, cancellationException, 14);
                while (true) {
                    if (!atomicReferenceFieldUpdater3.compareAndSet(this, obj2, nVar2)) {
                        if (atomicReferenceFieldUpdater3.get(this) != obj2) {
                            z6 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z6) {
                    return;
                }
            }
        }
    }

    public final i5.d e() {
        return this.f295i;
    }

    public final Throwable f(Object obj) {
        Throwable f7 = super.f(obj);
        if (f7 != null) {
            return f7;
        }
        return null;
    }

    public final k5.d g() {
        i5.d dVar = this.f295i;
        if (dVar instanceof k5.d) {
            return (k5.d) dVar;
        }
        return null;
    }

    public final void h() {
        s(this.f291h);
    }

    public final Object i(Object obj) {
        return obj instanceof n ? ((n) obj).f318a : obj;
    }

    public final Object k() {
        return f294l.get(this);
    }

    public final void l(e eVar, Throwable th) {
        try {
            eVar.c(th);
        } catch (Throwable th2) {
            i5.f fVar = this.f296j;
            w.a(fVar, new i2.c("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void m(q5.l lVar, Throwable th) {
        try {
            lVar.k(th);
        } catch (Throwable th2) {
            i5.f fVar = this.f296j;
            w.a(fVar, new i2.c("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void n(f6.s sVar, Throwable th) {
        int i7 = f293k.get(this) & 536870911;
        if (!(i7 != 536870911)) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
        try {
            sVar.g(i7, this.f296j);
        } catch (Throwable th2) {
            i5.f fVar = this.f296j;
            w.a(fVar, new i2.c("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void o(Object obj) {
        Throwable a7 = f5.d.a(obj);
        if (a7 != null) {
            obj = new o(a7, false);
        }
        B(obj, this.f291h, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x002e, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean p(java.lang.Throwable r8) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = a6.h.f294l
        L2:
            java.lang.Object r1 = r0.get(r7)
            boolean r2 = r1 instanceof a6.e1
            r3 = 0
            if (r2 != 0) goto Lc
            return r3
        Lc:
            a6.i r2 = new a6.i
            boolean r4 = r1 instanceof a6.e
            r5 = 1
            if (r4 != 0) goto L1a
            boolean r4 = r1 instanceof f6.s
            if (r4 == 0) goto L18
            goto L1a
        L18:
            r4 = r3
            goto L1b
        L1a:
            r4 = r5
        L1b:
            r2.<init>(r7, r8, r4)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = a6.h.f294l
        L20:
            boolean r6 = r4.compareAndSet(r7, r1, r2)
            if (r6 == 0) goto L28
            r3 = r5
            goto L2e
        L28:
            java.lang.Object r6 = r4.get(r7)
            if (r6 == r1) goto L20
        L2e:
            if (r3 == 0) goto L2
            r0 = r1
            a6.e1 r0 = (a6.e1) r0
            boolean r2 = r0 instanceof a6.e
            if (r2 == 0) goto L3d
            a6.e r1 = (a6.e) r1
            r7.l(r1, r8)
            goto L46
        L3d:
            boolean r0 = r0 instanceof f6.s
            if (r0 == 0) goto L46
            f6.s r1 = (f6.s) r1
            r7.n(r1, r8)
        L46:
            boolean r8 = r7.y()
            if (r8 != 0) goto L4f
            r7.q()
        L4f:
            int r8 = r7.f291h
            r7.s(r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.h.p(java.lang.Throwable):boolean");
    }

    public final void q() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
        i0 i0Var = (i0) atomicReferenceFieldUpdater.get(this);
        if (i0Var == null) {
            return;
        }
        i0Var.a();
        atomicReferenceFieldUpdater.set(this, d1.f289f);
    }

    public final void r(u uVar, f5.g gVar) {
        i5.d dVar = this.f295i;
        f6.f fVar = dVar instanceof f6.f ? (f6.f) dVar : null;
        B(gVar, (fVar != null ? fVar.f4148i : null) == uVar ? 4 : this.f291h, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0070, code lost:
        r8.Y(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0073, code lost:
        a0.b.z(r7, r7.f295i, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x007c, code lost:
        if (r8.b0() != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x007f, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x008c, code lost:
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x008d, code lost:
        a0.b.z(r7, r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0090, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x002c, code lost:
        if (r0 == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x002e, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x002f, code lost:
        r0 = r7.f295i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0032, code lost:
        if (r8 != 4) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0034, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0036, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0037, code lost:
        if (r1 != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x003b, code lost:
        if ((r0 instanceof f6.f) == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x003e, code lost:
        if (r8 == 1) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0040, code lost:
        if (r8 != 2) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0043, code lost:
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0045, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0046, code lost:
        r5 = r7.f291h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0048, code lost:
        if (r5 == 1) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x004a, code lost:
        if (r5 != 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x004c, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x004d, code lost:
        if (r8 != r4) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x004f, code lost:
        r8 = ((f6.f) r0).f4148i;
        r0 = r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x005c, code lost:
        if (r8.V() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x005e, code lost:
        r8.U(r0, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0062, code lost:
        r8 = a6.k1.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x006a, code lost:
        if (r8.Z() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x006c, code lost:
        r8.X(r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s(int r8) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = a6.h.f293k
        L2:
            int r1 = r0.get(r7)
            int r2 = r1 >> 29
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1c
            if (r2 != r3) goto L10
            r0 = r4
            goto L2c
        L10:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Already resumed"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L1c:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = a6.h.f293k
            r5 = 536870911(0x1fffffff, float:1.0842021E-19)
            r5 = r5 & r1
            r6 = 1073741824(0x40000000, float:2.0)
            int r5 = r5 + r6
            boolean r1 = r2.compareAndSet(r7, r1, r5)
            if (r1 == 0) goto L2
            r0 = r3
        L2c:
            if (r0 == 0) goto L2f
            return
        L2f:
            i5.d r0 = r7.f295i
            r1 = 4
            if (r8 != r1) goto L36
            r1 = r3
            goto L37
        L36:
            r1 = r4
        L37:
            if (r1 != 0) goto L8d
            boolean r2 = r0 instanceof f6.f
            if (r2 == 0) goto L8d
            r2 = 2
            if (r8 == r3) goto L45
            if (r8 != r2) goto L43
            goto L45
        L43:
            r8 = r4
            goto L46
        L45:
            r8 = r3
        L46:
            int r5 = r7.f291h
            if (r5 == r3) goto L4c
            if (r5 != r2) goto L4d
        L4c:
            r4 = r3
        L4d:
            if (r8 != r4) goto L8d
            r8 = r0
            f6.f r8 = (f6.f) r8
            a6.u r8 = r8.f4148i
            i5.f r0 = r0.a()
            boolean r1 = r8.V()
            if (r1 == 0) goto L62
            r8.U(r0, r7)
            goto L90
        L62:
            a6.l0 r8 = a6.k1.a()
            boolean r0 = r8.Z()
            if (r0 == 0) goto L70
            r8.X(r7)
            goto L90
        L70:
            r8.Y(r3)
            i5.d r0 = r7.f295i     // Catch: java.lang.Throwable -> L7f
            a0.b.z(r7, r0, r3)     // Catch: java.lang.Throwable -> L7f
        L78:
            boolean r0 = r8.b0()     // Catch: java.lang.Throwable -> L7f
            if (r0 != 0) goto L78
            goto L84
        L7f:
            r0 = move-exception
            r1 = 0
            r7.j(r0, r1)     // Catch: java.lang.Throwable -> L88
        L84:
            r8.W(r3)
            goto L90
        L88:
            r7 = move-exception
            r8.W(r3)
            throw r7
        L8d:
            a0.b.z(r7, r0, r1)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.h.s(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0031, code lost:
        if (r1 == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x003b, code lost:
        if (((a6.i0) a6.h.m.get(r9)) != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x003d, code lost:
        v();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0040, code lost:
        if (r0 == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0042, code lost:
        A();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0047, code lost:
        return Kotlin_1.a.f4591f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0048, code lost:
        if (r0 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x004a, code lost:
        A();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x004d, code lost:
        r0 = a6.h.f294l.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0055, code lost:
        if ((r0 instanceof a6.o) != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0057, code lost:
        r1 = r9.f291h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0059, code lost:
        if (r1 == 1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x005b, code lost:
        if (r1 != 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x005d, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x005e, code lost:
        if (r4 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0060, code lost:
        r1 = (a6.u0) r9.f296j.e(a6.u0.b.f341f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x006a, code lost:
        if (r1 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0070, code lost:
        if (r1.b() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0073, code lost:
        r1 = r1.G();
        d(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x007a, code lost:
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x007f, code lost:
        return i(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0084, code lost:
        throw ((a6.o) r0).f324a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t() {
        /*
            r9 = this;
            boolean r0 = r9.y()
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = a6.h.f293k
        L6:
            int r2 = r1.get(r9)
            int r3 = r2 >> 29
            r4 = 0
            r5 = 1
            r6 = 2
            if (r3 == 0) goto L21
            if (r3 != r6) goto L15
            r1 = r4
            goto L31
        L15:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "Already suspended"
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L21:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = a6.h.f293k
            r7 = 536870911(0x1fffffff, float:1.0842021E-19)
            r7 = r7 & r2
            r8 = 536870912(0x20000000, float:1.0842022E-19)
            int r7 = r7 + r8
            boolean r2 = r3.compareAndSet(r9, r2, r7)
            if (r2 == 0) goto L6
            r1 = r5
        L31:
            if (r1 == 0) goto L48
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = a6.h.m
            java.lang.Object r1 = r1.get(r9)
            a6.i0 r1 = (a6.i0) r1
            if (r1 != 0) goto L40
            r9.v()
        L40:
            if (r0 == 0) goto L45
            r9.A()
        L45:
            j5.a r9 = Kotlin_1.a.f4591f
            return r9
        L48:
            if (r0 == 0) goto L4d
            r9.A()
        L4d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = a6.h.f294l
            java.lang.Object r0 = r0.get(r9)
            boolean r1 = r0 instanceof a6.o
            if (r1 != 0) goto L80
            int r1 = r9.f291h
            if (r1 == r5) goto L5d
            if (r1 != r6) goto L5e
        L5d:
            r4 = r5
        L5e:
            if (r4 == 0) goto L7b
            i5.f r1 = r9.f296j
            a6.u0$b r2 = a6.u0.b.f341f
            i5.f$b r1 = r1.e(r2)
            a6.u0 r1 = (a6.u0) r1
            if (r1 == 0) goto L7b
            boolean r2 = r1.b()
            if (r2 == 0) goto L73
            goto L7b
        L73:
            java.util.concurrent.CancellationException r1 = r1.G()
            r9.d(r0, r1)
            throw r1
        L7b:
            java.lang.Object r9 = r9.i(r0)
            return r9
        L80:
            a6.o r0 = (a6.o) r0
            java.lang.Throwable r9 = r0.f324a
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.h.t():java.lang.Object");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CancellableContinuation");
        sb.append('(');
        sb.append(a0.e(this.f295i));
        sb.append("){");
        Object obj = f294l.get(this);
        sb.append(obj instanceof e1 ? "Active" : obj instanceof i ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(a0.c(this));
        return sb.toString();
    }

    public final void u() {
        i0 v6 = v();
        if (v6 != null && (!(f294l.get(this) instanceof e1))) {
            v6.a();
            m.set(this, d1.f289f);
        }
    }

    public final i0 v() {
        u0 u0Var = (u0) this.f296j.e(u0.b.f341f);
        if (u0Var == null) {
            return null;
        }
        i0 a7 = u0.a.a(u0Var, true, new j(this), 2);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, null, a7) && atomicReferenceFieldUpdater.get(this) == null) {
        }
        return a7;
    }

    public final void w(q5.l lVar) {
        x(lVar instanceof e ? (e) lVar : new j0(1, lVar));
    }

    public final void x(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f294l;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            boolean z6 = true;
            if (obj2 instanceof b) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f294l;
                while (true) {
                    if (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, obj)) {
                        if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                            z6 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z6) {
                    return;
                }
            } else {
                if (obj2 instanceof e ? true : obj2 instanceof f6.s) {
                    z(obj, obj2);
                    throw null;
                }
                boolean z7 = obj2 instanceof o;
                if (z7) {
                    o oVar = (o) obj2;
                    oVar.getClass();
                    if (!o.f323b.compareAndSet(oVar, 0, 1)) {
                        z(obj, obj2);
                        throw null;
                    } else if (obj2 instanceof i) {
                        if (!z7) {
                            oVar = null;
                        }
                        Throwable th = oVar != null ? oVar.f324a : null;
                        if (obj instanceof e) {
                            l((e) obj, th);
                            return;
                        }
                        r5.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        n((f6.s) obj, th);
                        return;
                    } else {
                        return;
                    }
                } else if (obj2 instanceof n) {
                    n nVar = (n) obj2;
                    if (nVar.f319b != null) {
                        z(obj, obj2);
                        throw null;
                    } else if (obj instanceof f6.s) {
                        return;
                    } else {
                        r5.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        e eVar = (e) obj;
                        Throwable th2 = nVar.e;
                        if (th2 != null) {
                            l(eVar, th2);
                            return;
                        }
                        n a7 = n.a(nVar, eVar, null, 29);
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f294l;
                        while (true) {
                            if (!atomicReferenceFieldUpdater3.compareAndSet(this, obj2, a7)) {
                                if (atomicReferenceFieldUpdater3.get(this) != obj2) {
                                    z6 = false;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (z6) {
                            return;
                        }
                    }
                } else if (obj instanceof f6.s) {
                    return;
                } else {
                    r5.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    n nVar2 = new n(obj2, (e) obj, (q5.l) null, (CancellationException) null, 28);
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4 = f294l;
                    while (true) {
                        if (!atomicReferenceFieldUpdater4.compareAndSet(this, obj2, nVar2)) {
                            if (atomicReferenceFieldUpdater4.get(this) != obj2) {
                                z6 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z6) {
                        return;
                    }
                }
            }
        }
    }

    public final boolean y() {
        if (this.f291h == 2) {
            i5.d dVar = this.f295i;
            r5.h.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (f6.f.m.get((f6.f) dVar) != null) {
                return true;
            }
        }
        return false;
    }
}
