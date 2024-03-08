package e6;

import a6.u0;
import a6.x;
import a6.y;
import d6.d;
import f5.g;
import i5.f;
import k5.c;
import k5.e;
import k5.i;
import linc.com.amplituda.ErrorCode;
import q5.p;
import q5.q;
import r5.s;
/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:77)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:55)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:49)
    */
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j<T, R> extends h<T, R> {

    /* renamed from: j */
    public final q<d<? super R>, T, i5.d<? super g>, Object> f3887j;

    @e(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", l = {ErrorCode.INVALID_AUDIO_BYTE_ARRAY_IO_CODE}, m = "invokeSuspend")
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends i implements p<x, i5.d<? super g>, Object> {

        /* renamed from: j */
        public int f3888j;

        /* renamed from: k */
        public /* synthetic */ Object f3889k;

        /* renamed from: l */
        public final /* synthetic */ j<T, R> f3890l;
        public final /* synthetic */ d<R> m;

        /* renamed from: e6.j$a$a */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static final class C0051a<T> implements d {

            /* renamed from: f */
            public final /* synthetic */ s<u0> f3891f;

            /* renamed from: g */
            public final /* synthetic */ x f3892g;

            /* renamed from: h */
            public final /* synthetic */ j<T, R> f3893h;

            /* renamed from: i */
            public final /* synthetic */ d<R> f3894i;

            @e(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", l = {ErrorCode.PACKET_SUBMITTING_PROC_CODE}, m = "invokeSuspend")
            /* renamed from: e6.j$a$a$a */
            /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
            public static final class C0052a extends i implements p<x, i5.d<? super g>, Object> {

                /* renamed from: j */
                public int f3895j;

                /* renamed from: k */
                public final /* synthetic */ j<T, R> f3896k;

                /* renamed from: l */
                public final /* synthetic */ d<R> f3897l;
                public final /* synthetic */ T m;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0052a(j<T, R> jVar, d<? super R> dVar, T t5, i5.d<? super C0052a> dVar2) {
                    super(2, dVar2);
                    this.f3896k = jVar;
                    this.f3897l = dVar;
                    this.m = t5;
                }

                @Override // q5.p
                public final Object i(x xVar, i5.d<? super g> dVar) {
                    return ((C0052a) p(xVar, dVar)).s(g.f4141a);
                }

                @Override // k5.a
                public final i5.d<g> p(Object obj, i5.d<?> dVar) {
                    return new C0052a(this.f3896k, this.f3897l, this.m, dVar);
                }

                @Override // k5.a
                public final Object s(Object obj) {
                    j5.a aVar = j5.a.f4591f;
                    int i7 = this.f3895j;
                    if (i7 == 0) {
                        f5.e.b(obj);
                        d<R> dVar = this.f3897l;
                        T t5 = this.m;
                        this.f3895j = 1;
                        if (this.f3896k.f3887j.f(dVar, t5, this) == aVar) {
                            return aVar;
                        }
                    } else if (i7 == 1) {
                        f5.e.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return g.f4141a;
                }
            }

            @e(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1", f = "Merge.kt", l = {ErrorCode.CODEC_NOT_FOUND_PROC_CODE}, m = "emit")
            /* renamed from: e6.j$a$a$b */
            /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
            public static final class b extends c {

                /* renamed from: i */
                public C0051a f3898i;

                /* renamed from: j */
                public Object f3899j;

                /* renamed from: k */
                public u0 f3900k;

                /* renamed from: l */
                public /* synthetic */ Object f3901l;
                public final /* synthetic */ C0051a<T> m;

                /* renamed from: n */
                public int f3902n;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public b(C0051a<? super T> aVar, i5.d<? super b> dVar) {
                    super(dVar);
                    this.m = aVar;
                }

                @Override // k5.a
                public final Object s(Object obj) {
                    this.f3901l = obj;
                    this.f3902n |= Integer.MIN_VALUE;
                    return this.m.m(null, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C0051a(s<u0> sVar, x xVar, j<T, R> jVar, d<? super R> dVar) {
                this.f3891f = sVar;
                this.f3892g = xVar;
                this.f3893h = jVar;
                this.f3894i = dVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
            @Override // d6.d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object m(T r7, i5.d<? super f5.g> r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof e6.j.a.C0051a.b
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    e6.j$a$a$b r0 = (e6.j.a.C0051a.b) r0
                    int r1 = r0.f3902n
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f3902n = r1
                    goto L_0x0018
                L_0x0013:
                    e6.j$a$a$b r0 = new e6.j$a$a$b
                    r0.<init>(r6, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.f3901l
                    j5.a r1 = j5.a.f4591f
                    int r2 = r0.f3902n
                    r3 = 1
                    if (r2 == 0) goto L_0x0033
                    if (r2 != r3) goto L_0x002b
                    java.lang.Object r7 = r0.f3899j
                    e6.j$a$a r6 = r0.f3898i
                    f5.e.b(r8)
                    goto L_0x0055
                L_0x002b:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0033:
                    f5.e.b(r8)
                    r5.s<a6.u0> r8 = r6.f3891f
                    T r8 = r8.f5927f
                    a6.u0 r8 = (a6.u0) r8
                    if (r8 == 0) goto L_0x0055
                    androidx.lifecycle.j r2 = new androidx.lifecycle.j
                    r2.<init>()
                    r8.d(r2)
                    r0.f3898i = r6
                    r0.f3899j = r7
                    r0.f3900k = r8
                    r0.f3902n = r3
                    java.lang.Object r8 = r8.D(r0)
                    if (r8 != r1) goto L_0x0055
                    return r1
                L_0x0055:
                    r5.s<a6.u0> r8 = r6.f3891f
                    a6.x r0 = r6.f3892g
                    r1 = 4
                    e6.j$a$a$a r2 = new e6.j$a$a$a
                    e6.j<T, R> r4 = r6.f3893h
                    d6.d<R> r6 = r6.f3894i
                    r5 = 0
                    r2.<init>(r4, r6, r7, r5)
                    a6.h1 r6 = a0.e.u(r0, r5, r1, r2, r3)
                    r8.f5927f = r6
                    f5.g r6 = f5.g.f4141a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: e6.j.a.C0051a.m(java.lang.Object, i5.d):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(j<T, R> jVar, d<? super R> dVar, i5.d<? super a> dVar2) {
            super(2, dVar2);
            this.f3890l = jVar;
            this.m = dVar;
        }

        @Override // q5.p
        public final Object i(x xVar, i5.d<? super g> dVar) {
            return ((a) p(xVar, dVar)).s(g.f4141a);
        }

        @Override // k5.a
        public final i5.d<g> p(Object obj, i5.d<?> dVar) {
            a aVar = new a(this.f3890l, this.m, dVar);
            aVar.f3889k = obj;
            return aVar;
        }

        @Override // k5.a
        public final Object s(Object obj) {
            j5.a aVar = j5.a.f4591f;
            int i7 = this.f3888j;
            if (i7 == 0) {
                f5.e.b(obj);
                s sVar = new s();
                j<T, R> jVar = this.f3890l;
                d6.c<S> cVar = jVar.f3886i;
                C0051a aVar2 = new C0051a(sVar, (x) this.f3889k, jVar, this.m);
                this.f3888j = 1;
                if (cVar.a(aVar2, this) == aVar) {
                    return aVar;
                }
            } else if (i7 == 1) {
                f5.e.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return g.f4141a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(q<? super d<? super R>, ? super T, ? super i5.d<? super g>, ? extends Object> qVar, d6.c<? extends T> cVar, f fVar, int i7, c6.a aVar) {
        super(i7, fVar, aVar, cVar);
        this.f3887j = qVar;
    }

    @Override // e6.f
    public final f<R> e(f fVar, int i7, c6.a aVar) {
        return new j(this.f3887j, this.f3886i, fVar, i7, aVar);
    }

    @Override // e6.h
    public final Object g(d<? super R> dVar, i5.d<? super g> dVar2) {
        Object b2 = y.b(new a(this, dVar, null), dVar2);
        return b2 == j5.a.f4591f ? b2 : g.f4141a;
    }
}
