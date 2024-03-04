package d6;

import a6.u0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class d0<T> extends e6.b implements q, c, e6.l {

    /* renamed from: k */
    public static final AtomicReferenceFieldUpdater f3676k = AtomicReferenceFieldUpdater.newUpdater(d0.class, Object.class, "_state");
    private volatile Object _state;

    /* renamed from: j */
    public int f3677j;

    @k5.e(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {384, 396, 401}, m = "collect")
    /* loaded from: classes.dex */
    public static final class a extends k5.c {

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

        /* renamed from: p */
        public int f3684p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i5.d dVar) {
            super(dVar);
            d0.this = r1;
        }

        public final Object s(Object obj) {
            this.f3682n = obj;
            this.f3684p |= Integer.MIN_VALUE;
            return d0.this.a(null, this);
        }
    }

    public d0(Object obj) {
        this._state = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x00b6, code lost:
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00ba, code lost:
        if (r5.h.a(r0, r11) != false) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00a8 A[Catch: all -> 0x012e, TryCatch #3 {all -> 0x012e, blocks: (B:126:0x00a0, B:128:0x00a8, B:131:0x00af, B:132:0x00b3, B:134:0x00b6, B:145:0x00db, B:150:0x00f3, B:151:0x010b, B:157:0x011b, B:158:0x0120, B:161:0x0129, B:154:0x0113, B:136:0x00bc, B:140:0x00c3, B:125:0x0091), top: B:176:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00f3 A[Catch: all -> 0x012e, TryCatch #3 {all -> 0x012e, blocks: (B:126:0x00a0, B:128:0x00a8, B:131:0x00af, B:132:0x00b3, B:134:0x00b6, B:145:0x00db, B:150:0x00f3, B:151:0x010b, B:157:0x011b, B:158:0x0120, B:161:0x0129, B:154:0x0113, B:136:0x00bc, B:140:0x00c3, B:125:0x0091), top: B:176:0x0091 }] */
    /* JADX WARN: Type inference failed for: r5v12, types: [d6.e0] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v15, types: [d6.e0] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:149:0x00f1 -> B:126:0x00a0). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:162:0x012b -> B:126:0x00a0). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(d6.d r18, i5.d r19) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.d0.a(d6.d, i5.d):java.lang.Object");
    }

    public final void b() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    public final c c(i5.f fVar, int i7, c6.a aVar) {
        return (((i7 >= 0 && i7 < 2) || i7 == -2) && aVar == c6.a.DROP_OLDEST) ? this : ((i7 == 0 || i7 == -3) && aVar == c6.a.SUSPEND) ? this : new e6.i(i7, fVar, aVar, this);
    }

    public final e6.c e() {
        return new e0();
    }

    public final e6.c[] f() {
        return new e0[2];
    }

    public final Object getValue() {
        q.d dVar = a0.e.Y;
        Object obj = f3676k.get(this);
        if (obj == dVar) {
            return null;
        }
        return obj;
    }

    public final boolean h(Object obj, Object obj2) {
        int i7;
        Object obj3;
        q.d dVar;
        boolean z6;
        boolean z7;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3676k;
            Object obj4 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !r5.h.a(obj4, obj)) {
                return false;
            }
            if (r5.h.a(obj4, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i8 = this.f3677j;
            if ((i8 & 1) != 0) {
                this.f3677j = i8 + 2;
                return true;
            }
            int i9 = i8 + 1;
            this.f3677j = i9;
            Object obj5 = this.f3870f;
            f5.g gVar = f5.g.f4141a;
            while (true) {
                e0[] e0VarArr = (e0[]) obj5;
                if (e0VarArr != null) {
                    for (e0 e0Var : e0VarArr) {
                        if (e0Var != null) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = e0.f3686a;
                            while (true) {
                                Object obj6 = atomicReferenceFieldUpdater2.get(e0Var);
                                if (obj6 != null && obj6 != (dVar = a0.b.f19t)) {
                                    q.d dVar2 = a0.b.s;
                                    if (obj6 != dVar2) {
                                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = e0.f3686a;
                                        while (true) {
                                            if (atomicReferenceFieldUpdater3.compareAndSet(e0Var, obj6, dVar2)) {
                                                z7 = true;
                                                break;
                                            } else if (atomicReferenceFieldUpdater3.get(e0Var) != obj6) {
                                                z7 = false;
                                                break;
                                            }
                                        }
                                        if (z7) {
                                            ((a6.h) obj6).o(f5.g.f4141a);
                                            break;
                                        }
                                    } else {
                                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4 = e0.f3686a;
                                        while (true) {
                                            if (atomicReferenceFieldUpdater4.compareAndSet(e0Var, obj6, dVar)) {
                                                z6 = true;
                                                break;
                                            } else if (atomicReferenceFieldUpdater4.get(e0Var) != obj6) {
                                                z6 = false;
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
                    obj3 = this.f3870f;
                    f5.g gVar2 = f5.g.f4141a;
                }
                obj5 = obj3;
                i9 = i7;
            }
        }
    }

    public final boolean l(Object obj) {
        setValue(obj);
        return true;
    }

    public final Object m(Object obj, i5.d dVar) {
        setValue(obj);
        return f5.g.f4141a;
    }

    public final void setValue(Object obj) {
        if (obj == null) {
            obj = a0.e.Y;
        }
        h(null, obj);
    }
}
