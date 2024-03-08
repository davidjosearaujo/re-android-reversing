package e6;

import a0.b;
import d6.d;
import f5.g;
import f6.v;
import i5.f;
import k5.e;
import k5.i;
import q5.p;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class u<T> implements d<T> {

    /* renamed from: f  reason: collision with root package name */
    public final f f3918f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f3919g;

    /* renamed from: h  reason: collision with root package name */
    public final a f3920h;

    @e(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", l = {212}, m = "invokeSuspend")
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends i implements p<T, i5.d<? super g>, Object> {

        /* renamed from: j  reason: collision with root package name */
        public int f3921j;

        /* renamed from: k  reason: collision with root package name */
        public /* synthetic */ Object f3922k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ d<T> f3923l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(d<? super T> dVar, i5.d<? super a> dVar2) {
            super(2, dVar2);
            this.f3923l = dVar;
        }

        @Override // q5.p
        public final Object i(Object obj, i5.d<? super g> dVar) {
            return ((a) p(obj, dVar)).s(g.f4141a);
        }

        @Override // k5.a
        public final i5.d<g> p(Object obj, i5.d<?> dVar) {
            a aVar = new a(this.f3923l, dVar);
            aVar.f3922k = obj;
            return aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // k5.a
        public final Object s(Object obj) {
            j5.a aVar = j5.a.f4591f;
            int i7 = this.f3921j;
            if (i7 == 0) {
                f5.e.b(obj);
                Object obj2 = this.f3922k;
                this.f3921j = 1;
                if (this.f3923l.m(obj2, this) == aVar) {
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

    public u(d<? super T> dVar, f fVar) {
        this.f3918f = fVar;
        this.f3919g = v.b(fVar);
        this.f3920h = new a(dVar, null);
    }

    @Override // d6.d
    public final Object m(T t5, i5.d<? super g> dVar) {
        Object E = b.E(this.f3918f, t5, this.f3919g, this.f3920h, dVar);
        return E == j5.a.f4591f ? E : g.f4141a;
    }
}
