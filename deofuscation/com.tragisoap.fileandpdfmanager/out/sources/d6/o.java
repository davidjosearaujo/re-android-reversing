package d6;

import a6.x;
import f5.g;
import i5.d;
import k5.e;
import k5.i;
import q5.p;
@e(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", l = {214, 218, 219, 225}, m = "invokeSuspend")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o extends i implements p<x, d<? super g>, Object> {

    /* renamed from: j  reason: collision with root package name */
    public int f3721j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ y f3722k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ c<Object> f3723l;
    public final /* synthetic */ p<Object> m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Object f3724n;

    @e(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", l = {}, m = "invokeSuspend")
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends i implements p<Integer, d<? super Boolean>, Object> {

        /* renamed from: j  reason: collision with root package name */
        public /* synthetic */ int f3725j;

        public a(d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // q5.p
        public final Object i(Integer num, d<? super Boolean> dVar) {
            return ((a) p(Integer.valueOf(num.intValue()), dVar)).s(g.f4141a);
        }

        @Override // k5.a
        public final d<g> p(Object obj, d<?> dVar) {
            a aVar = new a(dVar);
            aVar.f3725j = ((Number) obj).intValue();
            return aVar;
        }

        @Override // k5.a
        public final Object s(Object obj) {
            j5.a aVar = j5.a.f4591f;
            f5.e.b(obj);
            return Boolean.valueOf(this.f3725j > 0);
        }
    }

    @e(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", l = {227}, m = "invokeSuspend")
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b extends i implements p<x, d<? super g>, Object> {

        /* renamed from: j  reason: collision with root package name */
        public int f3726j;

        /* renamed from: k  reason: collision with root package name */
        public /* synthetic */ Object f3727k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ c<Object> f3728l;
        public final /* synthetic */ p<Object> m;

        /* renamed from: n  reason: collision with root package name */
        public final /* synthetic */ Object f3729n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c<Object> cVar, p<Object> pVar, Object obj, d<? super b> dVar) {
            super(2, dVar);
            this.f3728l = cVar;
            this.m = pVar;
            this.f3729n = obj;
        }

        @Override // q5.p
        public final Object i(x xVar, d<? super g> dVar) {
            return ((b) p(xVar, dVar)).s(g.f4141a);
        }

        @Override // k5.a
        public final d<g> p(Object obj, d<?> dVar) {
            b bVar = new b(this.f3728l, this.m, this.f3729n, dVar);
            bVar.f3727k = obj;
            return bVar;
        }

        @Override // k5.a
        public final Object s(Object obj) {
            j5.a aVar = j5.a.f4591f;
            int i7 = this.f3726j;
            if (i7 == 0) {
                f5.e.b(obj);
                int ordinal = ((x) this.f3727k).ordinal();
                if (ordinal == 0) {
                    c<Object> cVar = this.f3728l;
                    p<Object> pVar = this.m;
                    this.f3726j = 1;
                    if (cVar.a(pVar, this) == aVar) {
                        return aVar;
                    }
                } else if (ordinal == 2) {
                    Object obj2 = this.f3729n;
                    q.d dVar = a0.b.f18r;
                    p<Object> pVar2 = this.m;
                    if (obj2 == dVar) {
                        pVar2.b();
                    } else {
                        pVar2.l(obj2);
                    }
                }
            } else if (i7 == 1) {
                f5.e.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return g.f4141a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(y yVar, c<Object> cVar, p<Object> pVar, Object obj, d<? super o> dVar) {
        super(2, dVar);
        this.f3722k = yVar;
        this.f3723l = cVar;
        this.m = pVar;
        this.f3724n = obj;
    }

    @Override // q5.p
    public final Object i(x xVar, d<? super g> dVar) {
        return ((o) p(xVar, dVar)).s(g.f4141a);
    }

    @Override // k5.a
    public final d<g> p(Object obj, d<?> dVar) {
        return new o(this.f3722k, this.f3723l, this.m, this.f3724n, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f A[RETURN] */
    @Override // k5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r13) {
        /*
            r12 = this;
            j5.a r0 = j5.a.f4591f
            int r1 = r12.f3721j
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0024
            if (r1 == r5) goto L_0x001f
            if (r1 == r4) goto L_0x001b
            if (r1 == r3) goto L_0x001f
            if (r1 != r2) goto L_0x0013
            goto L_0x001f
        L_0x0013:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x001b:
            f5.e.b(r13)
            goto L_0x0053
        L_0x001f:
            f5.e.b(r13)
            goto L_0x00a7
        L_0x0024:
            f5.e.b(r13)
            d6.y r13 = r12.f3722k
            d6.z r1 = d6.y.a.f3756a
            if (r13 != r1) goto L_0x003a
            d6.c<java.lang.Object> r13 = r12.f3723l
            d6.p<java.lang.Object> r1 = r12.m
            r12.f3721j = r5
            java.lang.Object r12 = r13.a(r1, r12)
            if (r12 != r0) goto L_0x00a7
            return r0
        L_0x003a:
            d6.a0 r1 = d6.y.a.f3757b
            r5 = 0
            if (r13 != r1) goto L_0x0060
            d6.p<java.lang.Object> r13 = r12.m
            e6.t r13 = r13.n()
            d6.o$a r1 = new d6.o$a
            r1.<init>(r5)
            r12.f3721j = r4
            java.lang.Object r13 = q2.a.t(r13, r1, r12)
            if (r13 != r0) goto L_0x0053
            return r0
        L_0x0053:
            d6.c<java.lang.Object> r13 = r12.f3723l
            d6.p<java.lang.Object> r1 = r12.m
            r12.f3721j = r3
            java.lang.Object r12 = r13.a(r1, r12)
            if (r12 != r0) goto L_0x00a7
            return r0
        L_0x0060:
            d6.p<java.lang.Object> r1 = r12.m
            e6.t r1 = r1.n()
            d6.c r13 = r13.a(r1)
            d6.c r8 = q2.a.q(r13)
            d6.o$b r13 = new d6.o$b
            d6.c<java.lang.Object> r1 = r12.f3723l
            d6.p<java.lang.Object> r3 = r12.m
            java.lang.Object r4 = r12.f3724n
            r13.<init>(r1, r3, r4, r5)
            r12.f3721j = r2
            int r1 = d6.l.f3710a
            d6.k r7 = new d6.k
            r7.<init>(r13, r5)
            e6.j r13 = new e6.j
            i5.g r1 = i5.g.f4488f
            c6.a r2 = c6.a.SUSPEND
            r10 = -2
            r6 = r13
            r9 = r1
            r11 = r2
            r6.<init>(r7, r8, r9, r10, r11)
            r3 = 0
            d6.c r13 = r13.c(r1, r3, r2)
            e6.n r1 = e6.n.f3906f
            java.lang.Object r12 = r13.a(r1, r12)
            if (r12 != r0) goto L_0x009d
            goto L_0x009f
        L_0x009d:
            f5.g r12 = f5.g.f4141a
        L_0x009f:
            if (r12 != r0) goto L_0x00a2
            goto L_0x00a4
        L_0x00a2:
            f5.g r12 = f5.g.f4141a
        L_0x00a4:
            if (r12 != r0) goto L_0x00a7
            return r0
        L_0x00a7:
            f5.g r12 = f5.g.f4141a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.o.s(java.lang.Object):java.lang.Object");
    }
}
