package d6;

/* loaded from: classes.dex */
public final class a0 implements y {

    @k5.e(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", l = {155}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class a extends k5.i implements q5.p {

        /* renamed from: j */
        public int f3653j;

        /* renamed from: k */
        public /* synthetic */ Object f3654k;

        /* renamed from: l */
        public final /* synthetic */ c0 f3655l;

        /* renamed from: d6.a0$a$a */
        /* loaded from: classes.dex */
        public static final class C0046a<T> implements d {

            /* renamed from: f */
            public final /* synthetic */ r5.p f3656f;

            /* renamed from: g */
            public final /* synthetic */ d f3657g;

            @k5.e(c = "kotlinx.coroutines.flow.StartedLazily$command$1$1", f = "SharingStarted.kt", l = {158}, m = "emit")
            /* renamed from: d6.a0$a$a$a */
            /* loaded from: classes.dex */
            public static final class C0047a extends k5.c {

                /* renamed from: i */
                public /* synthetic */ Object f3658i;

                /* renamed from: k */
                public int f3660k;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0047a(i5.d dVar) {
                    super(dVar);
                    C0046a.this = r1;
                }

                public final Object s(Object obj) {
                    this.f3658i = obj;
                    this.f3660k |= Integer.MIN_VALUE;
                    return C0046a.this.a(0, this);
                }
            }

            public C0046a(r5.p pVar, d dVar) {
                this.f3656f = pVar;
                this.f3657g = dVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:35:0x0021  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x002f  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object a(int r5, i5.d r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof d6.a0.a.C0046a.C0047a
                    if (r0 == 0) goto L13
                    r0 = r6
                    d6.a0$a$a$a r0 = (d6.a0.a.C0046a.C0047a) r0
                    int r1 = r0.f3660k
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f3660k = r1
                    goto L18
                L13:
                    d6.a0$a$a$a r0 = new d6.a0$a$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f3658i
                    j5.a r1 = Kotlin_1.a.f4591f
                    int r2 = r0.f3660k
                    r3 = 1
                    if (r2 == 0) goto L2f
                    if (r2 != r3) goto L27
                    f5.e.b(r6)
                    goto L49
                L27:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L2f:
                    f5.e.b(r6)
                    if (r5 <= 0) goto L4c
                    r5.p r5 = r4.f3656f
                    boolean r6 = r5.f5924f
                    if (r6 != 0) goto L4c
                    r5.f5924f = r3
                    d6.d r4 = r4.f3657g
                    d6.x r5 = d6.x.START
                    r0.f3660k = r3
                    java.lang.Object r4 = r4.m(r5, r0)
                    if (r4 != r1) goto L49
                    return r1
                L49:
                    f5.g r4 = f5.g.f4141a
                    return r4
                L4c:
                    f5.g r4 = f5.g.f4141a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: d6.a0.a.C0046a.a(int, i5.d):java.lang.Object");
            }

            public final /* bridge */ /* synthetic */ Object m(Object obj, i5.d dVar) {
                return a(((Number) obj).intValue(), dVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c0 c0Var, i5.d dVar) {
            super(2, dVar);
            this.f3655l = c0Var;
        }

        public final Object i(Object obj, Object obj2) {
            ((a) p((d) obj, (i5.d) obj2)).s(f5.g.f4141a);
            return Kotlin_1.a.f4591f;
        }

        public final i5.d p(Object obj, i5.d dVar) {
            a aVar = new a(this.f3655l, dVar);
            aVar.f3654k = obj;
            return aVar;
        }

        public final Object s(Object obj) {
            Kotlin_1.a aVar = Kotlin_1.a.f4591f;
            int i7 = this.f3653j;
            if (i7 == 0) {
                f5.e.b(obj);
                r5.p pVar = new r5.p();
                c0 c0Var = this.f3655l;
                C0046a c0046a = new C0046a(pVar, (d) this.f3654k);
                this.f3653j = 1;
                if (c0Var.a(c0046a, this) == aVar) {
                    return aVar;
                }
            } else if (i7 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                f5.e.b(obj);
            }
            throw new f5.b();
        }
    }

    public final c a(c0 c0Var) {
        return new s(new a(c0Var, null));
    }

    public final String toString() {
        return "SharingStarted.Lazily";
    }
}
