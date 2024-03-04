package d6;

@k5.e(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", l = {214, 218, 219, 225}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class o extends k5.i implements q5.p {

    /* renamed from: j */
    public int f3721j;

    /* renamed from: k */
    public final /* synthetic */ y f3722k;

    /* renamed from: l */
    public final /* synthetic */ c f3723l;
    public final /* synthetic */ p m;

    /* renamed from: n */
    public final /* synthetic */ Object f3724n;

    @k5.e(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class a extends k5.i implements q5.p {

        /* renamed from: j */
        public /* synthetic */ int f3725j;

        public a(i5.d dVar) {
            super(2, dVar);
        }

        public final Object i(Object obj, Object obj2) {
            return ((a) p(Integer.valueOf(((Number) obj).intValue()), (i5.d) obj2)).s(f5.g.f4141a);
        }

        public final i5.d p(Object obj, i5.d dVar) {
            a aVar = new a(dVar);
            aVar.f3725j = ((Number) obj).intValue();
            return aVar;
        }

        public final Object s(Object obj) {
            Kotlin_1.a aVar = Kotlin_1.a.f4591f;
            f5.e.b(obj);
            return Boolean.valueOf(this.f3725j > 0);
        }
    }

    @k5.e(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", l = {227}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class b extends k5.i implements q5.p {

        /* renamed from: j */
        public int f3726j;

        /* renamed from: k */
        public /* synthetic */ Object f3727k;

        /* renamed from: l */
        public final /* synthetic */ c f3728l;
        public final /* synthetic */ p m;

        /* renamed from: n */
        public final /* synthetic */ Object f3729n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, p pVar, Object obj, i5.d dVar) {
            super(2, dVar);
            this.f3728l = cVar;
            this.m = pVar;
            this.f3729n = obj;
        }

        public final Object i(Object obj, Object obj2) {
            return ((b) p((x) obj, (i5.d) obj2)).s(f5.g.f4141a);
        }

        public final i5.d p(Object obj, i5.d dVar) {
            b bVar = new b(this.f3728l, this.m, this.f3729n, dVar);
            bVar.f3727k = obj;
            return bVar;
        }

        public final Object s(Object obj) {
            Kotlin_1.a aVar = Kotlin_1.a.f4591f;
            int i7 = this.f3726j;
            if (i7 == 0) {
                f5.e.b(obj);
                int ordinal = ((x) this.f3727k).ordinal();
                if (ordinal == 0) {
                    c cVar = this.f3728l;
                    p pVar = this.m;
                    this.f3726j = 1;
                    if (cVar.a(pVar, this) == aVar) {
                        return aVar;
                    }
                } else if (ordinal == 2) {
                    Object obj2 = this.f3729n;
                    q.d dVar = a0.b.f18r;
                    p pVar2 = this.m;
                    if (obj2 == dVar) {
                        pVar2.b();
                    } else {
                        pVar2.l(obj2);
                    }
                }
            } else if (i7 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                f5.e.b(obj);
            }
            return f5.g.f4141a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(y yVar, c cVar, p pVar, Object obj, i5.d dVar) {
        super(2, dVar);
        this.f3722k = yVar;
        this.f3723l = cVar;
        this.m = pVar;
        this.f3724n = obj;
    }

    public final Object i(Object obj, Object obj2) {
        return ((o) p((a6.x) obj, (i5.d) obj2)).s(f5.g.f4141a);
    }

    public final i5.d p(Object obj, i5.d dVar) {
        return new o(this.f3722k, this.f3723l, this.m, this.f3724n, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x005f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s(java.lang.Object r13) {
        /*
            r12 = this;
            j5.a r0 = Kotlin_1.a.f4591f
            int r1 = r12.f3721j
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L24
            if (r1 == r5) goto L1f
            if (r1 == r4) goto L1b
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L13
            goto L1f
        L13:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L1b:
            f5.e.b(r13)
            goto L53
        L1f:
            f5.e.b(r13)
            goto La7
        L24:
            f5.e.b(r13)
            d6.y r13 = r12.f3722k
            d6.z r1 = d6.y.a.f3756a
            if (r13 != r1) goto L3a
            d6.c r13 = r12.f3723l
            d6.p r1 = r12.m
            r12.f3721j = r5
            java.lang.Object r12 = r13.a(r1, r12)
            if (r12 != r0) goto La7
            return r0
        L3a:
            d6.a0 r1 = d6.y.a.f3757b
            r5 = 0
            if (r13 != r1) goto L60
            d6.p r13 = r12.m
            e6.t r13 = r13.n()
            d6.o$a r1 = new d6.o$a
            r1.<init>(r5)
            r12.f3721j = r4
            java.lang.Object r13 = q2.a.t(r13, r1, r12)
            if (r13 != r0) goto L53
            return r0
        L53:
            d6.c r13 = r12.f3723l
            d6.p r1 = r12.m
            r12.f3721j = r3
            java.lang.Object r12 = r13.a(r1, r12)
            if (r12 != r0) goto La7
            return r0
        L60:
            d6.p r1 = r12.m
            e6.t r1 = r1.n()
            d6.c r13 = r13.a(r1)
            d6.c r8 = q2.a.q(r13)
            d6.o$b r13 = new d6.o$b
            d6.c r1 = r12.f3723l
            d6.p r3 = r12.m
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
            if (r12 != r0) goto L9d
            goto L9f
        L9d:
            f5.g r12 = f5.g.f4141a
        L9f:
            if (r12 != r0) goto La2
            goto La4
        La2:
            f5.g r12 = f5.g.f4141a
        La4:
            if (r12 != r0) goto La7
            return r0
        La7:
            f5.g r12 = f5.g.f4141a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.o.s(java.lang.Object):java.lang.Object");
    }
}
