package e6;

@k5.e(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {60}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class e extends k5.i implements q5.p {

    /* renamed from: j */
    public int f3877j;

    /* renamed from: k */
    public /* synthetic */ Object f3878k;

    /* renamed from: l */
    public final /* synthetic */ f f3879l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, i5.d dVar) {
        super(2, dVar);
        this.f3879l = fVar;
    }

    public final Object i(Object obj, Object obj2) {
        return ((e) p((c6.o) obj, (i5.d) obj2)).s(f5.g.f4141a);
    }

    public final i5.d p(Object obj, i5.d dVar) {
        e eVar = new e(this.f3879l, dVar);
        eVar.f3878k = obj;
        return eVar;
    }

    public final Object s(Object obj) {
        Kotlin_1.a aVar = Kotlin_1.a.f4591f;
        int i7 = this.f3877j;
        if (i7 == 0) {
            f5.e.b(obj);
            f fVar = this.f3879l;
            this.f3877j = 1;
            if (fVar.d((c6.o) this.f3878k, this) == aVar) {
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
