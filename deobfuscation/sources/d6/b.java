package d6;

/* loaded from: classes.dex */
public final class b<T> implements c {

    /* renamed from: f */
    public final c f3661f;

    /* renamed from: g */
    public final q5.l f3662g;

    /* renamed from: h */
    public final q5.p f3663h;

    /* loaded from: classes.dex */
    public static final class a<T> implements d {

        /* renamed from: g */
        public final /* synthetic */ r5.s f3665g;

        /* renamed from: h */
        public final /* synthetic */ d f3666h;

        @k5.e(c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$2", f = "Distinct.kt", l = {77}, m = "emit")
        /* renamed from: d6.b$a$a */
        /* loaded from: classes.dex */
        public static final class C0048a extends k5.c {

            /* renamed from: i */
            public /* synthetic */ Object f3667i;

            /* renamed from: k */
            public int f3669k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0048a(i5.d dVar) {
                super(dVar);
                a.this = r1;
            }

            public final Object s(Object obj) {
                this.f3667i = obj;
                this.f3669k |= Integer.MIN_VALUE;
                return a.this.m(null, this);
            }
        }

        public a(r5.s sVar, d dVar) {
            b.this = r1;
            this.f3665g = sVar;
            this.f3666h = dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0021  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x002f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object m(java.lang.Object r6, i5.d r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof d6.b.a.C0048a
                if (r0 == 0) goto L13
                r0 = r7
                d6.b$a$a r0 = (d6.b.a.C0048a) r0
                int r1 = r0.f3669k
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f3669k = r1
                goto L18
            L13:
                d6.b$a$a r0 = new d6.b$a$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f3667i
                j5.a r1 = Kotlin_1.a.f4591f
                int r2 = r0.f3669k
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                f5.e.b(r7)
                goto L65
            L27:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2f:
                f5.e.b(r7)
                d6.b r7 = d6.b.this
                q5.l r7 = r7.f3662g
                java.lang.Object r7 = r7.k(r6)
                r5.s r2 = r5.f3665g
                T r2 = r2.f5927f
                q.d r4 = a0.e.Y
                if (r2 == r4) goto L56
                d6.b r4 = d6.b.this
                q5.p r4 = r4.f3663h
                java.lang.Object r2 = r4.i(r2, r7)
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 != 0) goto L53
                goto L56
            L53:
                f5.g r5 = f5.g.f4141a
                return r5
            L56:
                r5.s r2 = r5.f3665g
                r2.f5927f = r7
                d6.d r5 = r5.f3666h
                r0.f3669k = r3
                java.lang.Object r5 = r5.m(r6, r0)
                if (r5 != r1) goto L65
                return r1
            L65:
                f5.g r5 = f5.g.f4141a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: d6.b.a.m(java.lang.Object, i5.d):java.lang.Object");
        }
    }

    public b(c cVar) {
        h hVar = h.f3697g;
        g gVar = g.f3696g;
        this.f3661f = cVar;
        this.f3662g = hVar;
        this.f3663h = gVar;
    }

    public final Object a(d dVar, i5.d dVar2) {
        r5.s sVar = new r5.s();
        sVar.f5927f = (T) a0.e.Y;
        Object a7 = this.f3661f.a(new a(sVar, dVar), dVar2);
        return a7 == Kotlin_1.a.f4591f ? a7 : f5.g.f4141a;
    }
}
