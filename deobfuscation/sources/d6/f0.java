package d6;

@k5.e(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {419, 423}, m = "onSubscription")
/* loaded from: classes.dex */
public final class f0 extends k5.c {

    /* renamed from: i */
    public g0 f3692i;

    /* renamed from: j */
    public e6.o f3693j;

    /* renamed from: k */
    public /* synthetic */ Object f3694k;

    /* renamed from: l */
    public final /* synthetic */ g0<Object> f3695l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(g0<Object> g0Var, i5.d<? super f0> dVar) {
        super(dVar);
        this.f3695l = g0Var;
    }

    @Override // k5.a
    public final Object s(Object obj) {
        this.f3694k = obj;
        this.m |= Integer.MIN_VALUE;
        return this.f3695l.a(this);
    }
}
