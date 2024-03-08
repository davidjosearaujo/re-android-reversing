package a6;

import a0.e;
import a6.u0;
import e6.j;
import f5.g;
import f6.i;
import f6.o;
import i5.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import q.d;
import q5.l;
import q5.p;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class z0 implements u0, m, f1 {

    /* renamed from: f */
    public static final AtomicReferenceFieldUpdater f346f = AtomicReferenceFieldUpdater.newUpdater(z0.class, Object.class, "_state");

    /* renamed from: g */
    public static final AtomicReferenceFieldUpdater f347g = AtomicReferenceFieldUpdater.newUpdater(z0.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends y0 {

        /* renamed from: j */
        public final z0 f348j;

        /* renamed from: k */
        public final b f349k;

        /* renamed from: l */
        public final l f350l;
        public final Object m;

        public a(z0 z0Var, b bVar, l lVar, Object obj) {
            this.f348j = z0Var;
            this.f349k = bVar;
            this.f350l = lVar;
            this.m = obj;
        }

        @Override // q5.l
        public final /* bridge */ /* synthetic */ g k(Throwable th) {
            q(th);
            return g.f4141a;
        }

        @Override // a6.q
        public final void q(Throwable th) {
            z0 z0Var = this.f348j;
            b bVar = this.f349k;
            l lVar = this.f350l;
            Object obj = this.m;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = z0.f346f;
            z0Var.getClass();
            l Z = z0.Z(lVar);
            if (Z == null || !z0Var.h0(bVar, Z, obj)) {
                z0Var.w(z0Var.J(bVar, obj));
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b implements q0 {

        /* renamed from: g */
        public static final AtomicIntegerFieldUpdater f351g = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isCompleting");

        /* renamed from: h */
        public static final AtomicReferenceFieldUpdater f352h = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_rootCause");

        /* renamed from: i */
        public static final AtomicReferenceFieldUpdater f353i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_exceptionsHolder");
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting = 0;
        private volatile Object _rootCause;

        /* renamed from: f */
        public final c1 f354f;

        public b(c1 c1Var, Throwable th) {
            this.f354f = c1Var;
            this._rootCause = th;
        }

        public final void a(Throwable th) {
            Throwable c7 = c();
            if (c7 == null) {
                f352h.set(this, th);
            } else if (th != c7) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f353i;
                Object obj = atomicReferenceFieldUpdater.get(this);
                if (obj == null) {
                    atomicReferenceFieldUpdater.set(this, th);
                } else if (obj instanceof Throwable) {
                    if (th != obj) {
                        ArrayList arrayList = new ArrayList(4);
                        arrayList.add(obj);
                        arrayList.add(th);
                        atomicReferenceFieldUpdater.set(this, arrayList);
                    }
                } else if (obj instanceof ArrayList) {
                    ((ArrayList) obj).add(th);
                } else {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
            }
        }

        @Override // a6.q0
        public final boolean b() {
            return c() == null;
        }

        public final Throwable c() {
            return (Throwable) f352h.get(this);
        }

        public final boolean d() {
            return c() != null;
        }

        public final boolean e() {
            return f351g.get(this) != 0;
        }

        public final ArrayList f(Throwable th) {
            ArrayList arrayList;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f353i;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                arrayList = new ArrayList(4);
            } else if (obj instanceof Throwable) {
                ArrayList arrayList2 = new ArrayList(4);
                arrayList2.add(obj);
                arrayList = arrayList2;
            } else if (obj instanceof ArrayList) {
                arrayList = (ArrayList) obj;
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
            Throwable c7 = c();
            if (c7 != null) {
                arrayList.add(0, c7);
            }
            if (th != null && !h.a(th, c7)) {
                arrayList.add(th);
            }
            atomicReferenceFieldUpdater.set(this, e.f46k);
            return arrayList;
        }

        @Override // a6.q0
        public final c1 g() {
            return this.f354f;
        }

        public final String toString() {
            StringBuilder d7 = androidx.activity.h.d("Finishing[cancelling=");
            d7.append(d());
            d7.append(", completing=");
            d7.append(e());
            d7.append(", rootCause=");
            d7.append(c());
            d7.append(", exceptions=");
            d7.append(f353i.get(this));
            d7.append(", list=");
            d7.append(this.f354f);
            d7.append(']');
            return d7.toString();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c extends i.a {

        /* renamed from: d */
        public final /* synthetic */ z0 f355d;
        public final /* synthetic */ Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i iVar, z0 z0Var, Object obj) {
            super(iVar);
            this.f355d = z0Var;
            this.e = obj;
        }

        @Override // f6.a
        public final d c(Object obj) {
            i iVar = (i) obj;
            if (this.f355d.Q() == this.e) {
                return null;
            }
            return e.f33b0;
        }
    }

    public z0(boolean z6) {
        this._state = z6 ? e.m : e.f47l;
    }

    public static l Z(i iVar) {
        while (iVar.p()) {
            iVar = iVar.o();
        }
        while (true) {
            iVar = iVar.n();
            if (!iVar.p()) {
                if (iVar instanceof l) {
                    return (l) iVar;
                }
                if (iVar instanceof c1) {
                    return null;
                }
            }
        }
    }

    public static String f0(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.d()) {
                return "Cancelling";
            }
            if (bVar.e()) {
                return "Completing";
            }
        } else if (!(obj instanceof q0)) {
            return obj instanceof o ? "Cancelled" : "Completed";
        } else {
            if (!((q0) obj).b()) {
                return "New";
            }
        }
        return "Active";
    }

    public final boolean A(Throwable th) {
        if (W()) {
            return true;
        }
        boolean z6 = th instanceof CancellationException;
        k kVar = (k) f347g.get(this);
        return (kVar == null || kVar == d1.f289f) ? z6 : kVar.c(th) || z6;
    }

    public String B() {
        return "Job was cancelled";
    }

    @Override // a6.u0
    public final Object D(j.a.C0051a.b bVar) {
        boolean z6;
        while (true) {
            Object Q = Q();
            if (Q instanceof q0) {
                if (e0(Q) >= 0) {
                    z6 = true;
                    break;
                }
            } else {
                z6 = false;
                break;
            }
        }
        if (!z6) {
            f fVar = bVar.f4819g;
            h.c(fVar);
            q2.a.r(fVar);
            return g.f4141a;
        }
        h hVar = new h(1, q2.a.A(bVar));
        hVar.u();
        hVar.w(new j0(0, V(new g1(hVar))));
        Object t5 = hVar.t();
        j5.a aVar = j5.a.f4591f;
        if (t5 != aVar) {
            t5 = g.f4141a;
        }
        return t5 == aVar ? t5 : g.f4141a;
    }

    @Override // a6.f1
    public final CancellationException E() {
        Throwable th;
        Object Q = Q();
        CancellationException cancellationException = null;
        if (Q instanceof b) {
            th = ((b) Q).c();
        } else if (Q instanceof o) {
            th = ((o) Q).f324a;
        } else if (!(Q instanceof q0)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + Q).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        }
        if (cancellationException != null) {
            return cancellationException;
        }
        StringBuilder d7 = androidx.activity.h.d("Parent job is ");
        d7.append(f0(Q));
        return new v0(d7.toString(), th, this);
    }

    public boolean F(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return x(th) && M();
    }

    @Override // a6.u0
    public final CancellationException G() {
        Object Q = Q();
        CancellationException cancellationException = null;
        if (Q instanceof b) {
            Throwable c7 = ((b) Q).c();
            if (c7 != null) {
                String str = getClass().getSimpleName() + " is cancelling";
                if (c7 instanceof CancellationException) {
                    cancellationException = (CancellationException) c7;
                }
                if (cancellationException != null) {
                    return cancellationException;
                }
                if (str == null) {
                    str = B();
                }
                return new v0(str, c7, this);
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (Q instanceof q0) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (Q instanceof o) {
            Throwable th = ((o) Q).f324a;
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            return cancellationException == null ? new v0(B(), th, this) : cancellationException;
        } else {
            return new v0(getClass().getSimpleName() + " has completed normally", null, this);
        }
    }

    public final void H(q0 q0Var, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f347g;
        k kVar = (k) atomicReferenceFieldUpdater.get(this);
        if (kVar != null) {
            kVar.a();
            atomicReferenceFieldUpdater.set(this, d1.f289f);
        }
        i2.c cVar = null;
        o oVar = obj instanceof o ? (o) obj : null;
        Throwable th = oVar != null ? oVar.f324a : null;
        if (q0Var instanceof y0) {
            try {
                ((y0) q0Var).q(th);
            } catch (Throwable th2) {
                T(new i2.c("Exception in completion handler " + q0Var + " for " + this, th2));
            }
        } else {
            c1 g2 = q0Var.g();
            if (g2 != null) {
                Object m = g2.m();
                h.d(m, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                for (i iVar = (i) m; !h.a(iVar, g2); iVar = iVar.n()) {
                    if (iVar instanceof y0) {
                        y0 y0Var = (y0) iVar;
                        try {
                            y0Var.q(th);
                        } catch (Throwable th3) {
                            if (cVar != null) {
                                q2.a.c(cVar, th3);
                            } else {
                                cVar = new i2.c("Exception in completion handler " + y0Var + " for " + this, th3);
                                g gVar = g.f4141a;
                            }
                        }
                    }
                }
                if (cVar != null) {
                    T(cVar);
                }
            }
        }
    }

    public final Throwable I(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new v0(B(), null, this) : th;
        }
        h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((f1) obj).E();
    }

    public final Object J(b bVar, Object obj) {
        Throwable L;
        Throwable th = null;
        o oVar = obj instanceof o ? (o) obj : null;
        if (oVar != null) {
            th = oVar.f324a;
        }
        synchronized (bVar) {
            bVar.d();
            ArrayList<Throwable> f7 = bVar.f(th);
            L = L(bVar, f7);
            if (L != null && f7.size() > 1) {
                Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(f7.size()));
                for (Throwable th2 : f7) {
                    if (th2 != L && th2 != L && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                        q2.a.c(L, th2);
                    }
                }
            }
        }
        if (!(L == null || L == th)) {
            obj = new o(L, false);
        }
        if (L != null) {
            if (A(L) || S(L)) {
                h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                o.f323b.compareAndSet((o) obj, 0, 1);
            }
        }
        b0(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f346f;
        Object r0Var = obj instanceof q0 ? new r0((q0) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, bVar, r0Var) && atomicReferenceFieldUpdater.get(this) == bVar) {
        }
        H(bVar, obj);
        return obj;
    }

    public final Throwable L(b bVar, ArrayList arrayList) {
        Object obj;
        boolean z6;
        Object obj2 = null;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (!(((Throwable) obj) instanceof CancellationException)) {
                    break;
                }
            }
            Throwable th = (Throwable) obj;
            if (th != null) {
                return th;
            }
            Throwable th2 = (Throwable) arrayList.get(0);
            if (th2 instanceof l1) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    Throwable th3 = (Throwable) next;
                    if (th3 == th2 || !(th3 instanceof l1)) {
                        z6 = false;
                        continue;
                    } else {
                        z6 = true;
                        continue;
                    }
                    if (z6) {
                        obj2 = next;
                        break;
                    }
                }
                Throwable th4 = (Throwable) obj2;
                if (th4 != null) {
                    return th4;
                }
            }
            return th2;
        } else if (bVar.d()) {
            return new v0(B(), null, this);
        } else {
            return null;
        }
    }

    public boolean M() {
        return true;
    }

    public boolean O() {
        return false;
    }

    public final c1 P(q0 q0Var) {
        c1 g2 = q0Var.g();
        if (g2 != null) {
            return g2;
        }
        if (q0Var instanceof k0) {
            return new c1();
        }
        if (q0Var instanceof y0) {
            d0((y0) q0Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + q0Var).toString());
    }

    public final Object Q() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f346f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof o)) {
                return obj;
            }
            ((o) obj).a(this);
        }
    }

    @Override // a6.u0
    public final i0 R(boolean z6, boolean z7, l<? super Throwable, g> lVar) {
        y0 y0Var;
        boolean z8;
        Throwable th;
        Throwable th2 = null;
        if (z6) {
            y0Var = lVar instanceof w0 ? (w0) lVar : null;
            if (y0Var == null) {
                y0Var = new s0(lVar);
            }
        } else {
            y0Var = lVar instanceof y0 ? (y0) lVar : null;
            if (y0Var == null) {
                y0Var = new t0(lVar);
            }
        }
        y0Var.f345i = this;
        while (true) {
            Object Q = Q();
            if (Q instanceof k0) {
                k0 k0Var = (k0) Q;
                if (k0Var.f303f) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f346f;
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(this, Q, y0Var)) {
                            if (atomicReferenceFieldUpdater.get(this) != Q) {
                                z8 = false;
                                break;
                            }
                        } else {
                            z8 = true;
                            break;
                        }
                    }
                    if (z8) {
                        return y0Var;
                    }
                } else {
                    c1 c1Var = new c1();
                    Object p0Var = k0Var.f303f ? c1Var : new p0(c1Var);
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f346f;
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, k0Var, p0Var) && atomicReferenceFieldUpdater2.get(this) == k0Var) {
                    }
                }
            } else if (Q instanceof q0) {
                c1 g2 = ((q0) Q).g();
                if (g2 == null) {
                    h.d(Q, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    d0((y0) Q);
                } else {
                    i0 i0Var = d1.f289f;
                    if (!z6 || !(Q instanceof b)) {
                        th = null;
                    } else {
                        synchronized (Q) {
                            th = ((b) Q).c();
                            if (th == null || ((lVar instanceof l) && !((b) Q).e())) {
                                if (v(Q, g2, y0Var)) {
                                    if (th == null) {
                                        return y0Var;
                                    }
                                    i0Var = y0Var;
                                }
                            }
                            g gVar = g.f4141a;
                        }
                    }
                    if (th != null) {
                        if (z7) {
                            lVar.k(th);
                        }
                        return i0Var;
                    } else if (v(Q, g2, y0Var)) {
                        return y0Var;
                    }
                }
            } else {
                if (z7) {
                    o oVar = Q instanceof o ? (o) Q : null;
                    if (oVar != null) {
                        th2 = oVar.f324a;
                    }
                    lVar.k(th2);
                }
                return d1.f289f;
            }
        }
    }

    public boolean S(Throwable th) {
        return false;
    }

    public void T(i2.c cVar) {
        throw cVar;
    }

    public final void U(u0 u0Var) {
        if (u0Var == null) {
            f347g.set(this, d1.f289f);
            return;
        }
        u0Var.start();
        k n6 = u0Var.n(this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f347g;
        atomicReferenceFieldUpdater.set(this, n6);
        if (!(Q() instanceof q0)) {
            n6.a();
            atomicReferenceFieldUpdater.set(this, d1.f289f);
        }
    }

    public final i0 V(l<? super Throwable, g> lVar) {
        return R(false, true, lVar);
    }

    public boolean W() {
        return this instanceof c;
    }

    public final Object X(Object obj) {
        Object g02;
        do {
            g02 = g0(Q(), obj);
            if (g02 == e.f39g) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                Throwable th = null;
                o oVar = obj instanceof o ? (o) obj : null;
                if (oVar != null) {
                    th = oVar.f324a;
                }
                throw new IllegalStateException(str, th);
            }
        } while (g02 == e.f43i);
        return g02;
    }

    public String Y() {
        return getClass().getSimpleName();
    }

    public final void a0(c1 c1Var, Throwable th) {
        Object m = c1Var.m();
        h.d(m, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        i2.c cVar = null;
        for (i iVar = (i) m; !h.a(iVar, c1Var); iVar = iVar.n()) {
            if (iVar instanceof w0) {
                y0 y0Var = (y0) iVar;
                try {
                    y0Var.q(th);
                } catch (Throwable th2) {
                    if (cVar != null) {
                        q2.a.c(cVar, th2);
                    } else {
                        cVar = new i2.c("Exception in completion handler " + y0Var + " for " + this, th2);
                        g gVar = g.f4141a;
                    }
                }
            }
        }
        if (cVar != null) {
            T(cVar);
        }
        A(th);
    }

    @Override // a6.u0
    public boolean b() {
        Object Q = Q();
        return (Q instanceof q0) && ((q0) Q).b();
    }

    public void b0(Object obj) {
    }

    public void c0() {
    }

    @Override // a6.u0
    public void d(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new v0(B(), null, this);
        }
        y(cancellationException);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002b, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d0(a6.y0 r6) {
        /*
            r5 = this;
            a6.c1 r0 = new a6.c1
            r0.<init>()
            r6.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f6.i.f4160g
            r1.lazySet(r0, r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f6.i.f4159f
            r1.lazySet(r0, r6)
        L_0x0012:
            java.lang.Object r1 = r6.m()
            r2 = 0
            if (r1 == r6) goto L_0x001a
            goto L_0x0030
        L_0x001a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f6.i.f4159f
        L_0x001c:
            boolean r3 = r1.compareAndSet(r6, r6, r0)
            r4 = 1
            if (r3 == 0) goto L_0x0025
            r2 = r4
            goto L_0x002b
        L_0x0025:
            java.lang.Object r3 = r1.get(r6)
            if (r3 == r6) goto L_0x001c
        L_0x002b:
            if (r2 == 0) goto L_0x0012
            r0.l(r6)
        L_0x0030:
            f6.i r1 = r6.n()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = a6.z0.f346f
        L_0x0036:
            boolean r0 = r2.compareAndSet(r5, r6, r1)
            if (r0 == 0) goto L_0x003d
            goto L_0x0043
        L_0x003d:
            java.lang.Object r0 = r2.get(r5)
            if (r0 == r6) goto L_0x0036
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.z0.d0(a6.y0):void");
    }

    @Override // i5.f.b, i5.f
    public final <E extends f.b> E e(f.c<E> cVar) {
        return (E) f.b.a.a(this, cVar);
    }

    public final int e0(Object obj) {
        boolean z6 = false;
        if (obj instanceof k0) {
            if (((k0) obj).f303f) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f346f;
            k0 k0Var = e.m;
            while (true) {
                if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, k0Var)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                } else {
                    z6 = true;
                    break;
                }
            }
            if (!z6) {
                return -1;
            }
            c0();
            return 1;
        } else if (!(obj instanceof p0)) {
            return 0;
        } else {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f346f;
            c1 c1Var = ((p0) obj).f328f;
            while (true) {
                if (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, c1Var)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                } else {
                    z6 = true;
                    break;
                }
            }
            if (!z6) {
                return -1;
            }
            c0();
            return 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Throwable, T] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Unknown variable types count: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g0(java.lang.Object r9, java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.z0.g0(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // i5.f.b
    public final f.c<?> getKey() {
        return u0.b.f341f;
    }

    @Override // a6.u0
    public final u0 getParent() {
        k kVar = (k) f347g.get(this);
        if (kVar != null) {
            return kVar.getParent();
        }
        return null;
    }

    public final boolean h0(b bVar, l lVar, Object obj) {
        while (u0.a.a(lVar.f305j, false, new a(this, bVar, lVar, obj), 1) == d1.f289f) {
            lVar = Z(lVar);
            if (lVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // a6.m
    public final void i(z0 z0Var) {
        x(z0Var);
    }

    @Override // i5.f
    public final f k(f.c<?> cVar) {
        return f.b.a.b(this, cVar);
    }

    @Override // a6.u0
    public final k n(z0 z0Var) {
        i0 a7 = u0.a.a(this, true, new l(z0Var), 2);
        h.d(a7, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (k) a7;
    }

    @Override // i5.f
    public final <R> R q(R r6, p<? super R, ? super f.b, ? extends R> pVar) {
        return (R) pVar.i(r6, this);
    }

    @Override // i5.f
    public final f s(f fVar) {
        h.f(fVar, "context");
        return f.a.a(this, fVar);
    }

    @Override // a6.u0
    public final boolean start() {
        int e02;
        do {
            e02 = e0(Q());
            if (e02 == 0) {
                return false;
            }
        } while (e02 != 1);
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Y() + '{' + f0(Q()) + '}');
        sb.append('@');
        sb.append(a0.c(this));
        return sb.toString();
    }

    public final boolean v(Object obj, c1 c1Var, y0 y0Var) {
        boolean z6;
        boolean z7;
        c cVar = new c(y0Var, this, obj);
        do {
            i o6 = c1Var.o();
            i.f4160g.lazySet(y0Var, o6);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i.f4159f;
            atomicReferenceFieldUpdater.lazySet(y0Var, c1Var);
            cVar.f4163c = c1Var;
            while (true) {
                if (!atomicReferenceFieldUpdater.compareAndSet(o6, c1Var, cVar)) {
                    if (atomicReferenceFieldUpdater.get(o6) != c1Var) {
                        z6 = false;
                        break;
                    }
                } else {
                    z6 = true;
                    break;
                }
            }
            z7 = !z6 ? false : cVar.a(o6) == null ? true : true;
            if (z7) {
                return true;
            }
        } while (!z7);
        return false;
    }

    public void w(Object obj) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ca, code lost:
        r10 = a0.e.f39g;
     */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ca A[EDGE_INSN: B:88:0x00ca->B:63:0x00ca ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x003f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.z0.x(java.lang.Object):boolean");
    }

    public void y(CancellationException cancellationException) {
        x(cancellationException);
    }
}
