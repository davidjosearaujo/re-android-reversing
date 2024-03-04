package androidx.compose.ui.platform;

import a6.h1;
import a6.u0;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.g;

/* loaded from: classes.dex */
public final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 implements androidx.lifecycle.l {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
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

    @k5.e(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", f = "WindowRecomposer.android.kt", l = {394}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class b extends k5.i implements q5.p {

        /* renamed from: j */
        public int f1126j;

        /* renamed from: k */
        public /* synthetic */ Object f1127k;

        /* renamed from: l */
        public final /* synthetic */ r5.s f1128l;
        public final /* synthetic */ androidx.lifecycle.n m;

        /* renamed from: n */
        public final /* synthetic */ WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 f1129n;

        /* renamed from: o */
        public final /* synthetic */ View f1130o;

        @k5.e(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1", f = "WindowRecomposer.android.kt", l = {389}, m = "invokeSuspend")
        /* loaded from: classes.dex */
        public static final class a extends k5.i implements q5.p {

            /* renamed from: j */
            public int f1131j;

            /* renamed from: k */
            public final /* synthetic */ d6.c0 f1132k;

            /* renamed from: l */
            public final /* synthetic */ v f1133l;

            /* renamed from: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$b$a$a */
            /* loaded from: classes.dex */
            public static final class C0010a implements d6.d {

                /* renamed from: f */
                public final /* synthetic */ v f1134f;

                public C0010a(v vVar) {
                    this.f1134f = vVar;
                }

                public final Object m(Object obj, i5.d dVar) {
                    this.f1134f.f1240f.j(((Number) obj).floatValue());
                    return f5.g.f4141a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d6.c0 c0Var, v vVar, i5.d dVar) {
                super(2, dVar);
                this.f1132k = c0Var;
                this.f1133l = vVar;
            }

            public final Object i(Object obj, Object obj2) {
                ((a) p((a6.x) obj, (i5.d) obj2)).s(f5.g.f4141a);
                return Kotlin_1.a.f4591f;
            }

            public final i5.d p(Object obj, i5.d dVar) {
                return new a(this.f1132k, this.f1133l, dVar);
            }

            public final Object s(Object obj) {
                Kotlin_1.a aVar = Kotlin_1.a.f4591f;
                int i7 = this.f1131j;
                if (i7 == 0) {
                    f5.e.b(obj);
                    d6.c0 c0Var = this.f1132k;
                    C0010a c0010a = new C0010a(this.f1133l);
                    this.f1131j = 1;
                    if (c0Var.a(c0010a, this) == aVar) {
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
        public b(r5.s sVar, p.g0 g0Var, androidx.lifecycle.n nVar, WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2, View view, i5.d dVar) {
            super(2, dVar);
            this.f1128l = sVar;
            this.m = nVar;
            this.f1129n = windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2;
            this.f1130o = view;
        }

        public final Object i(Object obj, Object obj2) {
            return ((b) p((a6.x) obj, (i5.d) obj2)).s(f5.g.f4141a);
        }

        public final i5.d p(Object obj, i5.d dVar) {
            b bVar = new b(this.f1128l, null, this.m, this.f1129n, this.f1130o, dVar);
            bVar.f1127k = obj;
            return bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v2, types: [a6.u0] */
        /* JADX WARN: Type inference failed for: r0v5 */
        public final Object s(Object obj) {
            h1 h1Var;
            Kotlin_1.a aVar = Kotlin_1.a.f4591f;
            ?? r02 = this.f1126j;
            try {
                if (r02 != 0) {
                    if (r02 == 1) {
                        u0 u0Var = (u0) this.f1127k;
                        f5.e.b(obj);
                        if (u0Var != null) {
                            u0Var.d(null);
                        }
                        this.m.k().c(this.f1129n);
                        return f5.g.f4141a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f5.e.b(obj);
                a6.x xVar = (a6.x) this.f1127k;
                try {
                    v vVar = (v) this.f1128l.f5927f;
                    if (vVar != null) {
                        Context applicationContext = this.f1130o.getContext().getApplicationContext();
                        r5.h.e(applicationContext, "context.applicationContext");
                        d6.c0 a7 = i0.a(applicationContext);
                        vVar.f1240f.j(((Number) a7.getValue()).floatValue());
                        h1Var = a0.e.u(xVar, null, 0, new a(a7, vVar, null), 3);
                    } else {
                        h1Var = null;
                    }
                    this.f1127k = h1Var;
                    this.f1126j = 1;
                    throw null;
                } catch (Throwable th) {
                    th = th;
                    r02 = 0;
                    if (r02 != 0) {
                        r02.d(null);
                    }
                    this.m.k().c(this.f1129n);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void c(androidx.lifecycle.n nVar, g.a aVar) {
        int i7 = a.f1125a[aVar.ordinal()];
        if (i7 == 1) {
            a0.e.u(null, null, 4, new b(null, null, nVar, this, null, null), 1);
        } else if (i7 == 2) {
            throw null;
        } else {
            if (i7 == 3) {
                throw null;
            }
            if (i7 == 4) {
                throw null;
            }
        }
    }
}
