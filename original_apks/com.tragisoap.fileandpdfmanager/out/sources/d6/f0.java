package d6;

import e6.o;
import i5.d;
import k5.c;
import k5.e;
@e(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {419, 423}, m = "onSubscription")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f0 extends c {

    /* renamed from: i  reason: collision with root package name */
    public g0 f3692i;

    /* renamed from: j  reason: collision with root package name */
    public o f3693j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f3694k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ g0<Object> f3695l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(g0<Object> g0Var, d<? super f0> dVar) {
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
