package d6;

import i5.d;
import k5.c;
import k5.e;
import linc.com.amplituda.ErrorCode;
import r5.p;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j<T> implements d {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ p f3700f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ d<T> f3701g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ q5.p<T, d<? super Boolean>, Object> f3702h;

    @e(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", f = "Limit.kt", l = {ErrorCode.DECODING_PROC_CODE, ErrorCode.INVALID_PARAMETER_FLAG_PROC_CODE, ErrorCode.SAMPLE_OUT_OF_BOUNDS_PROC_CODE}, m = "emit")
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends c {

        /* renamed from: i  reason: collision with root package name */
        public j f3703i;

        /* renamed from: j  reason: collision with root package name */
        public Object f3704j;

        /* renamed from: k  reason: collision with root package name */
        public /* synthetic */ Object f3705k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ j<T> f3706l;
        public int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(j<? super T> jVar, d<? super a> dVar) {
            super(dVar);
            this.f3706l = jVar;
        }

        @Override // k5.a
        public final Object s(Object obj) {
            this.f3705k = obj;
            this.m |= Integer.MIN_VALUE;
            return this.f3706l.m(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(p pVar, d<? super T> dVar, q5.p<? super T, ? super d<? super Boolean>, ? extends Object> pVar2) {
        this.f3700f = pVar;
        this.f3701g = dVar;
        this.f3702h = pVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    @Override // d6.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(T r7, i5.d<? super f5.g> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof d6.j.a
            if (r0 == 0) goto L_0x0013
            r0 = r8
            d6.j$a r0 = (d6.j.a) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.m = r1
            goto L_0x0018
        L_0x0013:
            d6.j$a r0 = new d6.j$a
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f3705k
            j5.a r1 = j5.a.f4591f
            int r2 = r0.m
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r5) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            f5.e.b(r8)
            goto L_0x0083
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r7 = r0.f3704j
            d6.j r6 = r0.f3703i
            f5.e.b(r8)
            goto L_0x0067
        L_0x003d:
            f5.e.b(r8)
            goto L_0x0055
        L_0x0041:
            f5.e.b(r8)
            r5.p r8 = r6.f3700f
            boolean r8 = r8.f5924f
            if (r8 == 0) goto L_0x0058
            d6.d<T> r6 = r6.f3701g
            r0.m = r5
            java.lang.Object r6 = r6.m(r7, r0)
            if (r6 != r1) goto L_0x0055
            return r1
        L_0x0055:
            f5.g r6 = f5.g.f4141a
            return r6
        L_0x0058:
            q5.p<T, i5.d<? super java.lang.Boolean>, java.lang.Object> r8 = r6.f3702h
            r0.f3703i = r6
            r0.f3704j = r7
            r0.m = r4
            java.lang.Object r8 = r8.i(r7, r0)
            if (r8 != r1) goto L_0x0067
            return r1
        L_0x0067:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x0086
            r5.p r8 = r6.f3700f
            r8.f5924f = r5
            d6.d<T> r6 = r6.f3701g
            r8 = 0
            r0.f3703i = r8
            r0.f3704j = r8
            r0.m = r3
            java.lang.Object r6 = r6.m(r7, r0)
            if (r6 != r1) goto L_0x0083
            return r1
        L_0x0083:
            f5.g r6 = f5.g.f4141a
            return r6
        L_0x0086:
            f5.g r6 = f5.g.f4141a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.j.m(java.lang.Object, i5.d):java.lang.Object");
    }
}
