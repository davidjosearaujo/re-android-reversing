package e6;

import d6.d;
import j5.a;
import k5.e;
import k5.i;
import q5.p;
@e(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", l = {152}, m = "invokeSuspend")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g extends i implements p<d<Object>, i5.d<? super f5.g>, Object> {

    /* renamed from: j  reason: collision with root package name */
    public int f3883j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f3884k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ h<Object, Object> f3885l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h<Object, Object> hVar, i5.d<? super g> dVar) {
        super(2, dVar);
        this.f3885l = hVar;
    }

    @Override // q5.p
    public final Object i(d<Object> dVar, i5.d<? super f5.g> dVar2) {
        return ((g) p(dVar, dVar2)).s(f5.g.f4141a);
    }

    @Override // k5.a
    public final i5.d<f5.g> p(Object obj, i5.d<?> dVar) {
        g gVar = new g(this.f3885l, dVar);
        gVar.f3884k = obj;
        return gVar;
    }

    @Override // k5.a
    public final Object s(Object obj) {
        a aVar = a.f4591f;
        int i7 = this.f3883j;
        if (i7 == 0) {
            f5.e.b(obj);
            h<Object, Object> hVar = this.f3885l;
            this.f3883j = 1;
            if (hVar.g((d) this.f3884k, this) == aVar) {
                return aVar;
            }
        } else if (i7 == 1) {
            f5.e.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return f5.g.f4141a;
    }
}
