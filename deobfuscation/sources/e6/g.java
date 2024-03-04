package e6;

@k5.e(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", l = {152}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class g extends k5.i implements q5.p {

    /* renamed from: j */
    public int f3883j;

    /* renamed from: k */
    public /* synthetic */ Object f3884k;

    /* renamed from: l */
    public final /* synthetic */ h f3885l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, i5.d dVar) {
        super(2, dVar);
        this.f3885l = hVar;
    }

    public final Object i(Object obj, Object obj2) {
        return ((g) p((d6.d) obj, (i5.d) obj2)).s(f5.g.f4141a);
    }

    public final i5.d p(Object obj, i5.d dVar) {
        g gVar = new g(this.f3885l, dVar);
        gVar.f3884k = obj;
        return gVar;
    }

    public final Object s(Object obj) {
        Kotlin_1.a aVar = Kotlin_1.a.f4591f;
        int i7 = this.f3883j;
        if (i7 == 0) {
            f5.e.b(obj);
            h hVar = this.f3885l;
            this.f3883j = 1;
            if (hVar.g((d6.d) this.f3884k, this) == aVar) {
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
