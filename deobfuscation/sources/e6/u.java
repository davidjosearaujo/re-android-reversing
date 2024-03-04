package e6;

import f6.v;

/* loaded from: classes.dex */
public final class u<T> implements d6.d {

    /* renamed from: f */
    public final i5.f f3918f;

    /* renamed from: g */
    public final Object f3919g;

    /* renamed from: h */
    public final a f3920h;

    @k5.e(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", l = {212}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class a extends k5.i implements q5.p {

        /* renamed from: j */
        public int f3921j;

        /* renamed from: k */
        public /* synthetic */ Object f3922k;

        /* renamed from: l */
        public final /* synthetic */ d6.d f3923l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d6.d dVar, i5.d dVar2) {
            super(2, dVar2);
            this.f3923l = dVar;
        }

        public final Object i(Object obj, Object obj2) {
            return ((a) p(obj, (i5.d) obj2)).s(f5.g.f4141a);
        }

        public final i5.d p(Object obj, i5.d dVar) {
            a aVar = new a(this.f3923l, dVar);
            aVar.f3922k = obj;
            return aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object s(Object obj) {
            Kotlin_1.a aVar = Kotlin_1.a.f4591f;
            int i7 = this.f3921j;
            if (i7 == 0) {
                f5.e.b(obj);
                Object obj2 = this.f3922k;
                d6.d dVar = this.f3923l;
                this.f3921j = 1;
                if (dVar.m(obj2, this) == aVar) {
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

    public u(d6.d dVar, i5.f fVar) {
        this.f3918f = fVar;
        this.f3919g = v.b(fVar);
        this.f3920h = new a(dVar, null);
    }

    public final Object m(Object obj, i5.d dVar) {
        Object E = a0.b.E(this.f3918f, obj, this.f3919g, this.f3920h, dVar);
        return E == Kotlin_1.a.f4591f ? E : f5.g.f4141a;
    }
}
