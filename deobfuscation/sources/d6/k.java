package d6;

@k5.e(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", l = {217, 217}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class k extends k5.i implements q5.q {

    /* renamed from: j */
    public int f3707j;

    /* renamed from: k */
    public /* synthetic */ d f3708k;

    /* renamed from: l */
    public /* synthetic */ Object f3709l;
    public final /* synthetic */ q5.p m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(q5.p pVar, i5.d dVar) {
        super(3, dVar);
        this.m = pVar;
    }

    public final Object f(Object obj, Object obj2, Object obj3) {
        k kVar = new k(this.m, (i5.d) obj3);
        kVar.f3708k = (d) obj;
        kVar.f3709l = obj2;
        return kVar.s(f5.g.f4141a);
    }

    public final Object s(Object obj) {
        d dVar;
        Kotlin_1.a aVar = Kotlin_1.a.f4591f;
        int i7 = this.f3707j;
        if (i7 == 0) {
            f5.e.b(obj);
            dVar = this.f3708k;
            Object obj2 = this.f3709l;
            q5.p pVar = this.m;
            this.f3708k = dVar;
            this.f3707j = 1;
            obj = pVar.i(obj2, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i7 != 1) {
            if (i7 == 2) {
                f5.e.b(obj);
                return f5.g.f4141a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            dVar = this.f3708k;
            f5.e.b(obj);
        }
        this.f3708k = null;
        this.f3707j = 2;
        if (dVar.m(obj, this) == aVar) {
            return aVar;
        }
        return f5.g.f4141a;
    }
}
