package d6;

import f5.b;
import f5.g;
import i5.d;
import k5.c;
import k5.e;
import k5.i;
import q5.p;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a0 implements y {

    @e(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", l = {155}, m = "invokeSuspend")
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends i implements p<d<? super x>, d<? super g>, Object> {

        /* renamed from: j */
        public int f3653j;

        /* renamed from: k */
        public /* synthetic */ Object f3654k;

        /* renamed from: l */
        public final /* synthetic */ c0<Integer> f3655l;

        /* renamed from: d6.a0$a$a */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static final class C0046a<T> implements d {

            /* renamed from: f */
            public final /* synthetic */ r5.p f3656f;

            /* renamed from: g */
            public final /* synthetic */ d<x> f3657g;

            @e(c = "kotlinx.coroutines.flow.StartedLazily$command$1$1", f = "SharingStarted.kt", l = {158}, m = "emit")
            /* renamed from: d6.a0$a$a$a */
            /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
            public static final class C0047a extends c {

                /* renamed from: i */
                public /* synthetic */ Object f3658i;

                /* renamed from: j */
                public final /* synthetic */ C0046a<T> f3659j;

                /* renamed from: k */
                public int f3660k;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0047a(C0046a<? super T> aVar, d<? super C0047a> dVar) {
                    super(dVar);
                    this.f3659j = aVar;
                }

                @Override // k5.a
                public final Object s(Object obj) {
                    this.f3658i = obj;
                    this.f3660k |= Integer.MIN_VALUE;
                    return this.f3659j.a(0, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C0046a(r5.p pVar, d<? super x> dVar) {
                this.f3656f = pVar;
                this.f3657g = dVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(int r5, i5.d<? super f5.g> r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof d6.a0.a.C0046a.C0047a
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    d6.a0$a$a$a r0 = (d6.a0.a.C0046a.C0047a) r0
                    int r1 = r0.f3660k
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f3660k = r1
                    goto L_0x0018
                L_0x0013:
                    d6.a0$a$a$a r0 = new d6.a0$a$a$a
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.f3658i
                    j5.a r1 = j5.a.f4591f
                    int r2 = r0.f3660k
                    r3 = 1
                    if (r2 == 0) goto L_0x002f
                    if (r2 != r3) goto L_0x0027
                    f5.e.b(r6)
                    goto L_0x0049
                L_0x0027:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L_0x002f:
                    f5.e.b(r6)
                    if (r5 <= 0) goto L_0x004c
                    r5.p r5 = r4.f3656f
                    boolean r6 = r5.f5924f
                    if (r6 != 0) goto L_0x004c
                    r5.f5924f = r3
                    d6.d<d6.x> r4 = r4.f3657g
                    d6.x r5 = d6.x.START
                    r0.f3660k = r3
                    java.lang.Object r4 = r4.m(r5, r0)
                    if (r4 != r1) goto L_0x0049
                    return r1
                L_0x0049:
                    f5.g r4 = f5.g.f4141a
                    return r4
                L_0x004c:
                    f5.g r4 = f5.g.f4141a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: d6.a0.a.C0046a.a(int, i5.d):java.lang.Object");
            }

            @Override // d6.d
            public final /* bridge */ /* synthetic */ Object m(Object obj, d dVar) {
                return a(((Number) obj).intValue(), dVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c0<Integer> c0Var, d<? super a> dVar) {
            super(2, dVar);
            this.f3655l = c0Var;
        }

        @Override // q5.p
        public final Object i(d<? super x> dVar, d<? super g> dVar2) {
            ((a) p(dVar, dVar2)).s(g.f4141a);
            return j5.a.f4591f;
        }

        @Override // k5.a
        public final d<g> p(Object obj, d<?> dVar) {
            a aVar = new a(this.f3655l, dVar);
            aVar.f3654k = obj;
            return aVar;
        }

        @Override // k5.a
        public final Object s(Object obj) {
            j5.a aVar = j5.a.f4591f;
            int i7 = this.f3653j;
            if (i7 == 0) {
                f5.e.b(obj);
                r5.p pVar = new r5.p();
                c0<Integer> c0Var = this.f3655l;
                C0046a aVar2 = new C0046a(pVar, (d) this.f3654k);
                this.f3653j = 1;
                if (c0Var.a(aVar2, this) == aVar) {
                    return aVar;
                }
            } else if (i7 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                f5.e.b(obj);
            }
            throw new b();
        }
    }

    @Override // d6.y
    public final c<x> a(c0<Integer> c0Var) {
        return new s(new a(c0Var, null));
    }

    public final String toString() {
        return "SharingStarted.Lazily";
    }
}
