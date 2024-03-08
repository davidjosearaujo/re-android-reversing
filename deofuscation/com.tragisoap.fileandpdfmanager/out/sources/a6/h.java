package a6;

import a0.b;
import a0.e;
import a6.u0;
import f5.g;
import f6.s;
import i2.c;
import i5.f;
import j5.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k5.d;
import q5.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h<T> extends g0<T> implements g<T>, d, p1 {

    /* renamed from: k */
    public static final AtomicIntegerFieldUpdater f293k = AtomicIntegerFieldUpdater.newUpdater(h.class, "_decisionAndIndex");

    /* renamed from: l */
    public static final AtomicReferenceFieldUpdater f294l = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_state");
    public static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;

    /* renamed from: i */
    public final i5.d<T> f295i;

    /* renamed from: j */
    public final f f296j;
    private volatile int _decisionAndIndex = 536870911;
    private volatile Object _state = b.f282f;

    public h(int i7, i5.d dVar) {
        super(i7);
        this.f295i = dVar;
        this.f296j = dVar.a();
    }

    public static Object C(e1 e1Var, Object obj, int i7, l lVar) {
        if (obj instanceof o) {
            return obj;
        }
        boolean z6 = true;
        if (!(i7 == 1 || i7 == 2)) {
            z6 = false;
        }
        if (!z6) {
            return obj;
        }
        if (lVar == null && !(e1Var instanceof e)) {
            return obj;
        }
        return new n(obj, e1Var instanceof e ? (e) e1Var : null, lVar, (CancellationException) null, 16);
    }

    public static void z(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0029, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A() {
        /*
            r8 = this;
            i5.d<T> r0 = r8.f295i
            boolean r1 = r0 instanceof f6.f
            r2 = 0
            if (r1 == 0) goto L_0x000a
            f6.f r0 = (f6.f) r0
            goto L_0x000b
        L_0x000a:
            r0 = r2
        L_0x000b:
            if (r0 == 0) goto L_0x0076
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f6.f.m
        L_0x000f:
            java.lang.Object r3 = r1.get(r0)
            q.d r4 = a0.b.B
            r5 = 0
            r6 = 1
            if (r3 != r4) goto L_0x002c
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = f6.f.m
        L_0x001b:
            boolean r3 = r7.compareAndSet(r0, r4, r8)
            if (r3 == 0) goto L_0x0023
            r5 = r6
            goto L_0x0029
        L_0x0023:
            java.lang.Object r3 = r7.get(r0)
            if (r3 == r4) goto L_0x001b
        L_0x0029:
            if (r5 == 0) goto L_0x000f
            goto L_0x0045
        L_0x002c:
            boolean r1 = r3 instanceof java.lang.Throwable
            if (r1 == 0) goto L_0x005b
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f6.f.m
        L_0x0032:
            boolean r4 = r1.compareAndSet(r0, r3, r2)
            if (r4 == 0) goto L_0x003a
            r5 = r6
            goto L_0x0040
        L_0x003a:
            java.lang.Object r4 = r1.get(r0)
            if (r4 == r3) goto L_0x0032
        L_0x0040:
            if (r5 == 0) goto L_0x004f
            r2 = r3
            java.lang.Throwable r2 = (java.lang.Throwable) r2
        L_0x0045:
            if (r2 != 0) goto L_0x0048
            goto L_0x0076
        L_0x0048:
            r8.q()
            r8.p(r2)
            return
        L_0x004f:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Failed requirement."
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L_0x005b:
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
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.h.A():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0023, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(java.lang.Object r8, int r9, q5.l<? super java.lang.Throwable, f5.g> r10) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = a6.h.f294l
        L_0x0002:
            java.lang.Object r1 = r0.get(r7)
            boolean r2 = r1 instanceof a6.e1
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0032
            r2 = r1
            a6.e1 r2 = (a6.e1) r2
            java.lang.Object r2 = C(r2, r8, r9, r10)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = a6.h.f294l
        L_0x0015:
            boolean r6 = r5.compareAndSet(r7, r1, r2)
            if (r6 == 0) goto L_0x001d
            r3 = r4
            goto L_0x0023
        L_0x001d:
            java.lang.Object r6 = r5.get(r7)
            if (r6 == r1) goto L_0x0015
        L_0x0023:
            if (r3 == 0) goto L_0x0002
            boolean r8 = r7.y()
            if (r8 != 0) goto L_0x002e
            r7.q()
        L_0x002e:
            r7.s(r9)
            return
        L_0x0032:
            boolean r9 = r1 instanceof a6.i
            if (r9 == 0) goto L_0x004b
            a6.i r1 = (a6.i) r1
            r1.getClass()
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r9 = a6.i.f299c
            boolean r9 = r9.compareAndSet(r1, r3, r4)
            if (r9 == 0) goto L_0x004b
            if (r10 == 0) goto L_0x004a
            java.lang.Throwable r8 = r1.f324a
            r7.m(r10, r8)
        L_0x004a:
            return
        L_0x004b:
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

    @Override // i5.d
    public final f a() {
        return this.f296j;
    }

    @Override // a6.p1
    public final void b(s<?> sVar, int i7) {
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

    @Override // a6.g
    public final q.d c(Object obj, l lVar) {
        boolean z6;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f294l;
        do {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof e1) {
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
            } else {
                boolean z7 = obj2 instanceof n;
                return null;
            }
        } while (!z6);
        if (!y()) {
            q();
        }
        return e.f37f;
    }

    @Override // a6.g0
    public final void d(Object obj, CancellationException cancellationException) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f294l;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof e1) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof o)) {
                boolean z6 = true;
                if (obj2 instanceof n) {
                    n nVar = (n) obj2;
                    if (!(nVar.e != null)) {
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
                            l<Throwable, g> lVar = nVar.f320c;
                            if (lVar != null) {
                                m(lVar, cancellationException);
                                return;
                            }
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f294l;
                    n nVar2 = new n(obj2, (e) null, (l) null, cancellationException, 14);
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
            } else {
                return;
            }
        }
    }

    @Override // a6.g0
    public final i5.d<T> e() {
        return this.f295i;
    }

    @Override // a6.g0
    public final Throwable f(Object obj) {
        Throwable f7 = super.f(obj);
        if (f7 != null) {
            return f7;
        }
        return null;
    }

    @Override // k5.d
    public final d g() {
        i5.d<T> dVar = this.f295i;
        if (dVar instanceof d) {
            return (d) dVar;
        }
        return null;
    }

    @Override // a6.g
    public final void h() {
        s(this.f291h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a6.g0
    public final <T> T i(Object obj) {
        return obj instanceof n ? (T) ((n) obj).f318a : obj;
    }

    @Override // a6.g0
    public final Object k() {
        return f294l.get(this);
    }

    public final void l(e eVar, Throwable th) {
        try {
            eVar.c(th);
        } catch (Throwable th2) {
            f fVar = this.f296j;
            w.a(fVar, new c("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void m(l<? super Throwable, g> lVar, Throwable th) {
        try {
            lVar.k(th);
        } catch (Throwable th2) {
            f fVar = this.f296j;
            w.a(fVar, new c("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void n(s<?> sVar, Throwable th) {
        int i7 = f293k.get(this) & 536870911;
        if (i7 != 536870911) {
            try {
                sVar.g(i7, this.f296j);
            } catch (Throwable th2) {
                f fVar = this.f296j;
                w.a(fVar, new c("Exception in invokeOnCancellation handler for " + this, th2));
            }
        } else {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
    }

    @Override // i5.d
    public final void o(Object obj) {
        Throwable a7 = f5.d.a(obj);
        if (a7 != null) {
            obj = new o(a7, false);
        }
        B(obj, this.f291h, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x002e, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(java.lang.Throwable r8) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = a6.h.f294l
        L_0x0002:
            java.lang.Object r1 = r0.get(r7)
            boolean r2 = r1 instanceof a6.e1
            r3 = 0
            if (r2 != 0) goto L_0x000c
            return r3
        L_0x000c:
            a6.i r2 = new a6.i
            boolean r4 = r1 instanceof a6.e
            r5 = 1
            if (r4 != 0) goto L_0x001a
            boolean r4 = r1 instanceof f6.s
            if (r4 == 0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r4 = r3
            goto L_0x001b
        L_0x001a:
            r4 = r5
        L_0x001b:
            r2.<init>(r7, r8, r4)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = a6.h.f294l
        L_0x0020:
            boolean r6 = r4.compareAndSet(r7, r1, r2)
            if (r6 == 0) goto L_0x0028
            r3 = r5
            goto L_0x002e
        L_0x0028:
            java.lang.Object r6 = r4.get(r7)
            if (r6 == r1) goto L_0x0020
        L_0x002e:
            if (r3 == 0) goto L_0x0002
            r0 = r1
            a6.e1 r0 = (a6.e1) r0
            boolean r2 = r0 instanceof a6.e
            if (r2 == 0) goto L_0x003d
            a6.e r1 = (a6.e) r1
            r7.l(r1, r8)
            goto L_0x0046
        L_0x003d:
            boolean r0 = r0 instanceof f6.s
            if (r0 == 0) goto L_0x0046
            f6.s r1 = (f6.s) r1
            r7.n(r1, r8)
        L_0x0046:
            boolean r8 = r7.y()
            if (r8 != 0) goto L_0x004f
            r7.q()
        L_0x004f:
            int r8 = r7.f291h
            r7.s(r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.h.p(java.lang.Throwable):boolean");
    }

    public final void q() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
        i0 i0Var = (i0) atomicReferenceFieldUpdater.get(this);
        if (i0Var != null) {
            i0Var.a();
            atomicReferenceFieldUpdater.set(this, d1.f289f);
        }
    }

    @Override // a6.g
    public final void r(u uVar, g gVar) {
        i5.d<T> dVar = this.f295i;
        f6.f fVar = dVar instanceof f6.f ? (f6.f) dVar : null;
        B(gVar, (fVar != null ? fVar.f4148i : null) == uVar ? 4 : this.f291h, null);
    }

    public final void s(int i7) {
        boolean z6;
        boolean z7;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f293k;
        while (true) {
            int i8 = atomicIntegerFieldUpdater.get(this);
            int i9 = i8 >> 29;
            z6 = false;
            if (i9 == 0) {
                if (f293k.compareAndSet(this, i8, (536870911 & i8) + 1073741824)) {
                    z7 = true;
                    break;
                }
            } else if (i9 == 1) {
                z7 = false;
            } else {
                throw new IllegalStateException("Already resumed".toString());
            }
        }
        if (!z7) {
            i5.d<T> dVar = this.f295i;
            boolean z8 = i7 == 4;
            if (!z8 && (dVar instanceof f6.f)) {
                boolean z9 = i7 == 1 || i7 == 2;
                int i10 = this.f291h;
                if (i10 == 1 || i10 == 2) {
                    z6 = true;
                }
                if (z9 == z6) {
                    u uVar = ((f6.f) dVar).f4148i;
                    f a7 = dVar.a();
                    if (uVar.V()) {
                        uVar.U(a7, this);
                        return;
                    }
                    l0 a8 = k1.a();
                    if (a8.Z()) {
                        a8.X(this);
                        return;
                    }
                    a8.Y(true);
                    try {
                        b.z(this, this.f295i, true);
                        do {
                        } while (a8.b0());
                    } finally {
                        try {
                            return;
                        } finally {
                        }
                    }
                    return;
                }
            }
            b.z(this, dVar, z8);
        }
    }

    public final Object t() {
        boolean z6;
        boolean z7;
        u0 u0Var;
        boolean y6 = y();
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f293k;
        while (true) {
            int i7 = atomicIntegerFieldUpdater.get(this);
            int i8 = i7 >> 29;
            z6 = false;
            if (i8 == 0) {
                if (f293k.compareAndSet(this, i7, (536870911 & i7) + 536870912)) {
                    z7 = true;
                    break;
                }
            } else if (i8 == 2) {
                z7 = false;
            } else {
                throw new IllegalStateException("Already suspended".toString());
            }
        }
        if (z7) {
            if (((i0) m.get(this)) == null) {
                v();
            }
            if (y6) {
                A();
            }
            return a.f4591f;
        }
        if (y6) {
            A();
        }
        Object obj = f294l.get(this);
        if (!(obj instanceof o)) {
            int i9 = this.f291h;
            if (i9 == 1 || i9 == 2) {
                z6 = true;
            }
            if (!z6 || (u0Var = (u0) this.f296j.e(u0.b.f341f)) == null || u0Var.b()) {
                return i(obj);
            }
            CancellationException G = u0Var.G();
            d(obj, G);
            throw G;
        }
        throw ((o) obj).f324a;
    }

    @Override // java.lang.Object
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

    public final void w(l<? super Throwable, g> lVar) {
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
                Throwable th = null;
                if (!(obj2 instanceof e ? true : obj2 instanceof s)) {
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
                            if (oVar != null) {
                                th = oVar.f324a;
                            }
                            if (obj instanceof e) {
                                l((e) obj, th);
                                return;
                            }
                            r5.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                            n((s) obj, th);
                            return;
                        } else {
                            return;
                        }
                    } else if (obj2 instanceof n) {
                        n nVar = (n) obj2;
                        if (nVar.f319b != null) {
                            z(obj, obj2);
                            throw null;
                        } else if (!(obj instanceof s)) {
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
                        } else {
                            return;
                        }
                    } else if (!(obj instanceof s)) {
                        r5.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        n nVar2 = new n(obj2, (e) obj, (l) null, (CancellationException) null, 28);
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
                    } else {
                        return;
                    }
                } else {
                    z(obj, obj2);
                    throw null;
                }
            }
        }
    }

    public final boolean y() {
        if (this.f291h == 2) {
            i5.d<T> dVar = this.f295i;
            r5.h.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (f6.f.m.get((f6.f) dVar) != null) {
                return true;
            }
        }
        return false;
    }
}
