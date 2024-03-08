package d6;

import f5.g;
import i5.d;
import k5.c;
import k5.e;
import q5.l;
import q5.p;
import r5.s;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b<T> implements c<T> {

    /* renamed from: f  reason: collision with root package name */
    public final c<T> f3661f;

    /* renamed from: g  reason: collision with root package name */
    public final l<T, Object> f3662g;

    /* renamed from: h  reason: collision with root package name */
    public final p<Object, Object, Boolean> f3663h;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a<T> implements d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b<T> f3664f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s<Object> f3665g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d<T> f3666h;

        @e(c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$2", f = "Distinct.kt", l = {77}, m = "emit")
        /* renamed from: d6.b$a$a  reason: collision with other inner class name */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static final class C0048a extends c {

            /* renamed from: i  reason: collision with root package name */
            public /* synthetic */ Object f3667i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ a<T> f3668j;

            /* renamed from: k  reason: collision with root package name */
            public int f3669k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0048a(a<? super T> aVar, d<? super C0048a> dVar) {
                super(dVar);
                this.f3668j = aVar;
            }

            @Override // k5.a
            public final Object s(Object obj) {
                this.f3667i = obj;
                this.f3669k |= Integer.MIN_VALUE;
                return this.f3668j.m(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(b<T> bVar, s<Object> sVar, d<? super T> dVar) {
            this.f3664f = bVar;
            this.f3665g = sVar;
            this.f3666h = dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
        @Override // d6.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object m(T r6, i5.d<? super f5.g> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof d6.b.a.C0048a
                if (r0 == 0) goto L_0x0013
                r0 = r7
                d6.b$a$a r0 = (d6.b.a.C0048a) r0
                int r1 = r0.f3669k
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f3669k = r1
                goto L_0x0018
            L_0x0013:
                d6.b$a$a r0 = new d6.b$a$a
                r0.<init>(r5, r7)
            L_0x0018:
                java.lang.Object r7 = r0.f3667i
                j5.a r1 = j5.a.f4591f
                int r2 = r0.f3669k
                r3 = 1
                if (r2 == 0) goto L_0x002f
                if (r2 != r3) goto L_0x0027
                f5.e.b(r7)
                goto L_0x0065
            L_0x0027:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x002f:
                f5.e.b(r7)
                d6.b<T> r7 = r5.f3664f
                q5.l<T, java.lang.Object> r7 = r7.f3662g
                java.lang.Object r7 = r7.k(r6)
                r5.s<java.lang.Object> r2 = r5.f3665g
                T r2 = r2.f5927f
                q.d r4 = a0.e.Y
                if (r2 == r4) goto L_0x0056
                d6.b<T> r4 = r5.f3664f
                q5.p<java.lang.Object, java.lang.Object, java.lang.Boolean> r4 = r4.f3663h
                java.lang.Object r2 = r4.i(r2, r7)
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 != 0) goto L_0x0053
                goto L_0x0056
            L_0x0053:
                f5.g r5 = f5.g.f4141a
                return r5
            L_0x0056:
                r5.s<java.lang.Object> r2 = r5.f3665g
                r2.f5927f = r7
                d6.d<T> r5 = r5.f3666h
                r0.f3669k = r3
                java.lang.Object r5 = r5.m(r6, r0)
                if (r5 != r1) goto L_0x0065
                return r1
            L_0x0065:
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

    @Override // d6.c
    public final Object a(d<? super T> dVar, d<? super g> dVar2) {
        s sVar = new s();
        sVar.f5927f = (T) a0.e.Y;
        Object a7 = this.f3661f.a(new a(this, sVar, dVar), dVar2);
        return a7 == j5.a.f4591f ? a7 : g.f4141a;
    }
}
