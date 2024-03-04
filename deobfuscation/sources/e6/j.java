package e6;

import a6.u0;
import a6.x;
import a6.y;
import linc.com.amplituda.ErrorCode;

/* loaded from: classes.dex */
public final class j<T, R> extends h {

    /* renamed from: j */
    public final q5.q f3887j;

    @k5.e(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", l = {ErrorCode.INVALID_AUDIO_BYTE_ARRAY_IO_CODE}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class a extends k5.i implements q5.p {

        /* renamed from: j */
        public int f3888j;

        /* renamed from: k */
        public /* synthetic */ Object f3889k;
        public final /* synthetic */ d6.d m;

        /* renamed from: e6.j$a$a */
        /* loaded from: classes.dex */
        public static final class C0051a<T> implements d6.d {

            /* renamed from: f */
            public final /* synthetic */ r5.s f3891f;

            /* renamed from: g */
            public final /* synthetic */ x f3892g;

            /* renamed from: h */
            public final /* synthetic */ j f3893h;

            /* renamed from: i */
            public final /* synthetic */ d6.d f3894i;

            @k5.e(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", l = {ErrorCode.PACKET_SUBMITTING_PROC_CODE}, m = "invokeSuspend")
            /* renamed from: e6.j$a$a$a */
            /* loaded from: classes.dex */
            public static final class C0052a extends k5.i implements q5.p {

                /* renamed from: j */
                public int f3895j;

                /* renamed from: k */
                public final /* synthetic */ j f3896k;

                /* renamed from: l */
                public final /* synthetic */ d6.d f3897l;
                public final /* synthetic */ Object m;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0052a(j jVar, d6.d dVar, Object obj, i5.d dVar2) {
                    super(2, dVar2);
                    this.f3896k = jVar;
                    this.f3897l = dVar;
                    this.m = obj;
                }

                public final Object i(Object obj, Object obj2) {
                    return ((C0052a) p((x) obj, (i5.d) obj2)).s(f5.g.f4141a);
                }

                public final i5.d p(Object obj, i5.d dVar) {
                    return new C0052a(this.f3896k, this.f3897l, this.m, dVar);
                }

                public final Object s(Object obj) {
                    Kotlin_1.a aVar = Kotlin_1.a.f4591f;
                    int i7 = this.f3895j;
                    if (i7 == 0) {
                        f5.e.b(obj);
                        q5.q qVar = this.f3896k.f3887j;
                        d6.d dVar = this.f3897l;
                        Object obj2 = this.m;
                        this.f3895j = 1;
                        if (qVar.f(dVar, obj2, this) == aVar) {
                            return aVar;
                        }
                    } else if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        f5.e.b(obj);
                    }
                    return f5.g.f4141a;
                }
            }

            @k5.e(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1", f = "Merge.kt", l = {ErrorCode.CODEC_NOT_FOUND_PROC_CODE}, m = "emit")
            /* renamed from: e6.j$a$a$b */
            /* loaded from: classes.dex */
            public static final class b extends k5.c {

                /* renamed from: i */
                public C0051a f3898i;

                /* renamed from: j */
                public Object f3899j;

                /* renamed from: k */
                public u0 f3900k;

                /* renamed from: l */
                public /* synthetic */ Object f3901l;

                /* renamed from: n */
                public int f3902n;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(i5.d dVar) {
                    super(dVar);
                    C0051a.this = r1;
                }

                public final Object s(Object obj) {
                    this.f3901l = obj;
                    this.f3902n |= Integer.MIN_VALUE;
                    return C0051a.this.m(null, this);
                }
            }

            public C0051a(r5.s sVar, x xVar, j jVar, d6.d dVar) {
                this.f3891f = sVar;
                this.f3892g = xVar;
                this.f3893h = jVar;
                this.f3894i = dVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:31:0x0021  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0033  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object m(java.lang.Object r7, i5.d r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof e6.j.a.C0051a.b
                    if (r0 == 0) goto L13
                    r0 = r8
                    e6.j$a$a$b r0 = (e6.j.a.C0051a.b) r0
                    int r1 = r0.f3902n
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f3902n = r1
                    goto L18
                L13:
                    e6.j$a$a$b r0 = new e6.j$a$a$b
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.f3901l
                    j5.a r1 = Kotlin_1.a.f4591f
                    int r2 = r0.f3902n
                    r3 = 1
                    if (r2 == 0) goto L33
                    if (r2 != r3) goto L2b
                    java.lang.Object r7 = r0.f3899j
                    e6.j$a$a r6 = r0.f3898i
                    f5.e.b(r8)
                    goto L55
                L2b:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L33:
                    f5.e.b(r8)
                    r5.s r8 = r6.f3891f
                    T r8 = r8.f5927f
                    a6.u0 r8 = (a6.u0) r8
                    if (r8 == 0) goto L55
                    androidx.lifecycle.j r2 = new androidx.lifecycle.j
                    r2.<init>()
                    r8.d(r2)
                    r0.f3898i = r6
                    r0.f3899j = r7
                    r0.f3900k = r8
                    r0.f3902n = r3
                    java.lang.Object r8 = r8.D(r0)
                    if (r8 != r1) goto L55
                    return r1
                L55:
                    r5.s r8 = r6.f3891f
                    a6.x r0 = r6.f3892g
                    r1 = 4
                    e6.j$a$a$a r2 = new e6.j$a$a$a
                    e6.j r4 = r6.f3893h
                    d6.d r6 = r6.f3894i
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
        public a(d6.d dVar, i5.d dVar2) {
            super(2, dVar2);
            j.this = r1;
            this.m = dVar;
        }

        public final Object i(Object obj, Object obj2) {
            return ((a) p((x) obj, (i5.d) obj2)).s(f5.g.f4141a);
        }

        public final i5.d p(Object obj, i5.d dVar) {
            a aVar = new a(this.m, dVar);
            aVar.f3889k = obj;
            return aVar;
        }

        public final Object s(Object obj) {
            Kotlin_1.a aVar = Kotlin_1.a.f4591f;
            int i7 = this.f3888j;
            if (i7 == 0) {
                f5.e.b(obj);
                r5.s sVar = new r5.s();
                j jVar = j.this;
                d6.c cVar = jVar.f3886i;
                C0051a c0051a = new C0051a(sVar, (x) this.f3889k, jVar, this.m);
                this.f3888j = 1;
                if (cVar.a(c0051a, this) == aVar) {
                    return aVar;
                }
            } else if (i7 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                f5.e.b(obj);
            }
            return f5.g.f4141a;
        }
    }

    public j(q5.q qVar, d6.c cVar, i5.f fVar, int i7, c6.a aVar) {
        super(i7, fVar, aVar, cVar);
        this.f3887j = qVar;
    }

    public final f e(i5.f fVar, int i7, c6.a aVar) {
        return new j(this.f3887j, this.f3886i, fVar, i7, aVar);
    }

    public final Object g(d6.d dVar, i5.d dVar2) {
        Object b2 = y.b(new a(dVar, null), dVar2);
        return b2 == Kotlin_1.a.f4591f ? b2 : f5.g.f4141a;
    }
}
