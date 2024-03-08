package androidx.compose.ui.platform;

import a6.x;
import android.view.View;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.n;
import d6.c0;
import i5.d;
import k5.e;
import k5.i;
import p.g0;
import q5.p;
import r5.s;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 implements l {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1125a;

        static {
            int[] iArr = new int[g.a.values().length];
            try {
                iArr[g.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[g.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[g.a.ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[g.a.ON_DESTROY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[g.a.ON_PAUSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[g.a.ON_RESUME.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[g.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f1125a = iArr;
        }
    }

    @e(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", f = "WindowRecomposer.android.kt", l = {394}, m = "invokeSuspend")
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b extends i implements p<x, d<? super f5.g>, Object> {

        /* renamed from: j  reason: collision with root package name */
        public int f1126j;

        /* renamed from: k  reason: collision with root package name */
        public /* synthetic */ Object f1127k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ s<v> f1128l;
        public final /* synthetic */ n m;

        /* renamed from: n  reason: collision with root package name */
        public final /* synthetic */ WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 f1129n;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ View f1130o;

        @e(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1", f = "WindowRecomposer.android.kt", l = {389}, m = "invokeSuspend")
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static final class a extends i implements p<x, d<? super f5.g>, Object> {

            /* renamed from: j  reason: collision with root package name */
            public int f1131j;

            /* renamed from: k  reason: collision with root package name */
            public final /* synthetic */ c0<Float> f1132k;

            /* renamed from: l  reason: collision with root package name */
            public final /* synthetic */ v f1133l;

            /* renamed from: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$b$a$a  reason: collision with other inner class name */
            /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
            public static final class C0010a implements d6.d<Float> {

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ v f1134f;

                public C0010a(v vVar) {
                    this.f1134f = vVar;
                }

                @Override // d6.d
                public final Object m(Float f7, d dVar) {
                    this.f1134f.f1240f.j(f7.floatValue());
                    return f5.g.f4141a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c0<Float> c0Var, v vVar, d<? super a> dVar) {
                super(2, dVar);
                this.f1132k = c0Var;
                this.f1133l = vVar;
            }

            @Override // q5.p
            public final Object i(x xVar, d<? super f5.g> dVar) {
                ((a) p(xVar, dVar)).s(f5.g.f4141a);
                return j5.a.f4591f;
            }

            @Override // k5.a
            public final d<f5.g> p(Object obj, d<?> dVar) {
                return new a(this.f1132k, this.f1133l, dVar);
            }

            @Override // k5.a
            public final Object s(Object obj) {
                j5.a aVar = j5.a.f4591f;
                int i7 = this.f1131j;
                if (i7 == 0) {
                    f5.e.b(obj);
                    c0<Float> c0Var = this.f1132k;
                    C0010a aVar2 = new C0010a(this.f1133l);
                    this.f1131j = 1;
                    if (c0Var.a(aVar2, this) == aVar) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(s<v> sVar, g0 g0Var, n nVar, WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2, View view, d<? super b> dVar) {
            super(2, dVar);
            this.f1128l = sVar;
            this.m = nVar;
            this.f1129n = windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2;
            this.f1130o = view;
        }

        @Override // q5.p
        public final Object i(x xVar, d<? super f5.g> dVar) {
            return ((b) p(xVar, dVar)).s(f5.g.f4141a);
        }

        @Override // k5.a
        public final d<f5.g> p(Object obj, d<?> dVar) {
            b bVar = new b(this.f1128l, null, this.m, this.f1129n, this.f1130o, dVar);
            bVar.f1127k = obj;
            return bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v2, types: [a6.u0] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // k5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object s(java.lang.Object r7) {
            /*
                r6 = this;
                j5.a r0 = j5.a.f4591f
                int r0 = r6.f1126j
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L_0x002e
                if (r0 != r2) goto L_0x0026
                java.lang.Object r0 = r6.f1127k
                a6.u0 r0 = (a6.u0) r0
                f5.e.b(r7)     // Catch: all -> 0x0024
                if (r0 == 0) goto L_0x0016
                r0.d(r1)
            L_0x0016:
                androidx.lifecycle.n r7 = r6.m
                androidx.lifecycle.o r7 = r7.k()
                androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r6 = r6.f1129n
                r7.c(r6)
                f5.g r6 = f5.g.f4141a
                return r6
            L_0x0024:
                r7 = move-exception
                goto L_0x0075
            L_0x0026:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L_0x002e:
                f5.e.b(r7)
                java.lang.Object r7 = r6.f1127k
                a6.x r7 = (a6.x) r7
                r5.s<androidx.compose.ui.platform.v> r0 = r6.f1128l     // Catch: all -> 0x0073
                T r0 = r0.f5927f     // Catch: all -> 0x0073
                androidx.compose.ui.platform.v r0 = (androidx.compose.ui.platform.v) r0     // Catch: all -> 0x0073
                if (r0 == 0) goto L_0x006c
                android.view.View r3 = r6.f1130o     // Catch: all -> 0x0073
                android.content.Context r3 = r3.getContext()     // Catch: all -> 0x0073
                android.content.Context r3 = r3.getApplicationContext()     // Catch: all -> 0x0073
                java.lang.String r4 = "context.applicationContext"
                r5.h.e(r3, r4)     // Catch: all -> 0x0073
                d6.c0 r3 = androidx.compose.ui.platform.i0.a(r3)     // Catch: all -> 0x0073
                java.lang.Object r4 = r3.getValue()     // Catch: all -> 0x0073
                java.lang.Number r4 = (java.lang.Number) r4     // Catch: all -> 0x0073
                float r4 = r4.floatValue()     // Catch: all -> 0x0073
                p.y r5 = r0.f1240f     // Catch: all -> 0x0073
                r5.j(r4)     // Catch: all -> 0x0073
                androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$b$a r4 = new androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$b$a     // Catch: all -> 0x0073
                r4.<init>(r3, r0, r1)     // Catch: all -> 0x0073
                r0 = 3
                r3 = 0
                a6.h1 r7 = a0.e.u(r7, r1, r3, r4, r0)     // Catch: all -> 0x0073
                r0 = r7
                goto L_0x006d
            L_0x006c:
                r0 = r1
            L_0x006d:
                r6.f1127k = r0     // Catch: all -> 0x0024
                r6.f1126j = r2     // Catch: all -> 0x0024
                r7 = 0
                throw r7     // Catch: all -> 0x0024
            L_0x0073:
                r7 = move-exception
                r0 = r1
            L_0x0075:
                if (r0 == 0) goto L_0x007a
                r0.d(r1)
            L_0x007a:
                androidx.lifecycle.n r0 = r6.m
                androidx.lifecycle.o r0 = r0.k()
                androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r6 = r6.f1129n
                r0.c(r6)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2.b.s(java.lang.Object):java.lang.Object");
        }
    }

    @Override // androidx.lifecycle.l
    public final void c(n nVar, g.a aVar) {
        int i7 = a.f1125a[aVar.ordinal()];
        if (i7 == 1) {
            a0.e.u(null, null, 4, new b(null, null, nVar, this, null, null), 1);
        } else if (i7 == 2) {
            throw null;
        } else if (i7 == 3) {
            throw null;
        } else if (i7 == 4) {
            throw null;
        }
    }
}
