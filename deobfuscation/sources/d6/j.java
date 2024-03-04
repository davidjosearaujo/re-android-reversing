package d6;

import linc.com.amplituda.ErrorCode;

/* loaded from: classes.dex */
public final class j<T> implements d {

    /* renamed from: f */
    public final /* synthetic */ r5.p f3700f;

    /* renamed from: g */
    public final /* synthetic */ d f3701g;

    /* renamed from: h */
    public final /* synthetic */ q5.p f3702h;

    @k5.e(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", f = "Limit.kt", l = {ErrorCode.DECODING_PROC_CODE, ErrorCode.INVALID_PARAMETER_FLAG_PROC_CODE, ErrorCode.SAMPLE_OUT_OF_BOUNDS_PROC_CODE}, m = "emit")
    /* loaded from: classes.dex */
    public static final class a extends k5.c {

        /* renamed from: i */
        public j f3703i;

        /* renamed from: j */
        public Object f3704j;

        /* renamed from: k */
        public /* synthetic */ Object f3705k;
        public int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i5.d dVar) {
            super(dVar);
            j.this = r1;
        }

        public final Object s(Object obj) {
            this.f3705k = obj;
            this.m |= Integer.MIN_VALUE;
            return j.this.m(null, this);
        }
    }

    public j(r5.p pVar, d dVar, q5.p pVar2) {
        this.f3700f = pVar;
        this.f3701g = dVar;
        this.f3702h = pVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(java.lang.Object r7, i5.d r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof d6.j.a
            if (r0 == 0) goto L13
            r0 = r8
            d6.j$a r0 = (d6.j.a) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            d6.j$a r0 = new d6.j$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f3705k
            j5.a r1 = Kotlin_1.a.f4591f
            int r2 = r0.m
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            f5.e.b(r8)
            goto L83
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r7 = r0.f3704j
            d6.j r6 = r0.f3703i
            f5.e.b(r8)
            goto L67
        L3d:
            f5.e.b(r8)
            goto L55
        L41:
            f5.e.b(r8)
            r5.p r8 = r6.f3700f
            boolean r8 = r8.f5924f
            if (r8 == 0) goto L58
            d6.d r6 = r6.f3701g
            r0.m = r5
            java.lang.Object r6 = r6.m(r7, r0)
            if (r6 != r1) goto L55
            return r1
        L55:
            f5.g r6 = f5.g.f4141a
            return r6
        L58:
            q5.p r8 = r6.f3702h
            r0.f3703i = r6
            r0.f3704j = r7
            r0.m = r4
            java.lang.Object r8 = r8.i(r7, r0)
            if (r8 != r1) goto L67
            return r1
        L67:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L86
            r5.p r8 = r6.f3700f
            r8.f5924f = r5
            d6.d r6 = r6.f3701g
            r8 = 0
            r0.f3703i = r8
            r0.f3704j = r8
            r0.m = r3
            java.lang.Object r6 = r6.m(r7, r0)
            if (r6 != r1) goto L83
            return r1
        L83:
            f5.g r6 = f5.g.f4141a
            return r6
        L86:
            f5.g r6 = f5.g.f4141a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.j.m(java.lang.Object, i5.d):java.lang.Object");
    }
}
