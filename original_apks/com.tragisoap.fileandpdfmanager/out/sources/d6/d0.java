package d6;

import a6.u0;
import e6.b;
import e6.i;
import e6.l;
import f5.g;
import i5.d;
import i5.f;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k5.c;
import k5.e;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d0<T> extends b<e0> implements q<T>, c, l<T> {

    /* renamed from: k */
    public static final AtomicReferenceFieldUpdater f3676k = AtomicReferenceFieldUpdater.newUpdater(d0.class, Object.class, "_state");
    private volatile Object _state;

    /* renamed from: j */
    public int f3677j;

    @e(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {384, 396, 401}, m = "collect")
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends c {

        /* renamed from: i */
        public d0 f3678i;

        /* renamed from: j */
        public d f3679j;

        /* renamed from: k */
        public e0 f3680k;

        /* renamed from: l */
        public u0 f3681l;
        public Object m;

        /* renamed from: n */
        public /* synthetic */ Object f3682n;

        /* renamed from: o */
        public final /* synthetic */ d0<T> f3683o;

        /* renamed from: p */
        public int f3684p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d0<T> d0Var, d<? super a> dVar) {
            super(dVar);
            this.f3683o = d0Var;
        }

        @Override // k5.a
        public final Object s(Object obj) {
            this.f3682n = obj;
            this.f3684p |= Integer.MIN_VALUE;
            return this.f3683o.a(null, this);
        }
    }

    public d0(Object obj) {
        this._state = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b6, code lost:
        r5 = r5;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ba, code lost:
        if (r5.h.a(r0, r11) != false) goto L_0x00db;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8 A[Catch: all -> 0x012e, TryCatch #3 {all -> 0x012e, blocks: (B:33:0x0091, B:34:0x00a0, B:36:0x00a8, B:39:0x00af, B:40:0x00b3, B:42:0x00b6, B:44:0x00bc, B:48:0x00c3, B:53:0x00db, B:58:0x00f3, B:59:0x010b, B:62:0x0113, B:65:0x011b, B:66:0x0120, B:69:0x0129), top: B:83:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f3 A[Catch: all -> 0x012e, TryCatch #3 {all -> 0x012e, blocks: (B:33:0x0091, B:34:0x00a0, B:36:0x00a8, B:39:0x00af, B:40:0x00b3, B:42:0x00b6, B:44:0x00bc, B:48:0x00c3, B:53:0x00db, B:58:0x00f3, B:59:0x010b, B:62:0x0113, B:65:0x011b, B:66:0x0120, B:69:0x0129), top: B:83:0x0091 }] */
    /* JADX WARN: Type inference failed for: r5v15, types: [d6.e0] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v7, types: [d6.e0] */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // d6.t, d6.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(d6.d<? super T> r18, i5.d<?> r19) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.d0.a(d6.d, i5.d):java.lang.Object");
    }

    @Override // d6.p
    public final void b() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // e6.l
    public final c<T> c(f fVar, int i7, c6.a aVar) {
        return (((i7 >= 0 && i7 < 2) || i7 == -2) && aVar == c6.a.DROP_OLDEST) ? this : ((i7 == 0 || i7 == -3) && aVar == c6.a.SUSPEND) ? this : new i(i7, fVar, aVar, this);
    }

    @Override // e6.b
    public final e0 e() {
        return new e0();
    }

    @Override // e6.b
    public final e6.c[] f() {
        return new e0[2];
    }

    @Override // d6.c0
    public final T getValue() {
        q.d dVar = a0.e.Y;
        T t5 = (T) f3676k.get(this);
        if (t5 == dVar) {
            return null;
        }
        return t5;
    }

    public final boolean h(Object obj, Object obj2) {
        int i7;
        q.d dVar;
        boolean z6;
        boolean z7;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3676k;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj == null || h.a(obj3, obj))) {
                return false;
            }
            if (h.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i8 = this.f3677j;
            if ((i8 & 1) == 0) {
                int i9 = i8 + 1;
                this.f3677j = i9;
                Object obj4 = this.f3870f;
                g gVar = g.f4141a;
                while (true) {
                    e0[] e0VarArr = (e0[]) obj4;
                    if (e0VarArr != null) {
                        for (e0 e0Var : e0VarArr) {
                            if (e0Var != null) {
                                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = e0.f3686a;
                                while (true) {
                                    Object obj5 = atomicReferenceFieldUpdater2.get(e0Var);
                                    if (obj5 != null && obj5 != (dVar = a0.b.f19t)) {
                                        q.d dVar2 = a0.b.s;
                                        if (obj5 != dVar2) {
                                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = e0.f3686a;
                                            while (true) {
                                                if (!atomicReferenceFieldUpdater3.compareAndSet(e0Var, obj5, dVar2)) {
                                                    if (atomicReferenceFieldUpdater3.get(e0Var) != obj5) {
                                                        z7 = false;
                                                        break;
                                                    }
                                                } else {
                                                    z7 = true;
                                                    break;
                                                }
                                            }
                                            if (z7) {
                                                ((a6.h) obj5).o(g.f4141a);
                                                break;
                                            }
                                        } else {
                                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4 = e0.f3686a;
                                            while (true) {
                                                if (!atomicReferenceFieldUpdater4.compareAndSet(e0Var, obj5, dVar)) {
                                                    if (atomicReferenceFieldUpdater4.get(e0Var) != obj5) {
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
                                        }
                                    }
                                }
                            }
                        }
                    }
                    synchronized (this) {
                        i7 = this.f3677j;
                        if (i7 == i9) {
                            this.f3677j = i9 + 1;
                            return true;
                        }
                        obj4 = this.f3870f;
                        g gVar2 = g.f4141a;
                    }
                    i9 = i7;
                }
            } else {
                this.f3677j = i8 + 2;
                return true;
            }
        }
    }

    @Override // d6.p
    public final boolean l(T t5) {
        setValue(t5);
        return true;
    }

    @Override // d6.d
    public final Object m(T t5, d<? super g> dVar) {
        setValue(t5);
        return g.f4141a;
    }

    @Override // d6.q
    public final void setValue(T t5) {
        if (t5 == null) {
            t5 = (T) a0.e.Y;
        }
        h(null, t5);
    }
}
