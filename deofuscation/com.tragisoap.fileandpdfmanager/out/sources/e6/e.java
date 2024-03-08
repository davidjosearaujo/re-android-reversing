package e6;

import c6.o;
import f5.g;
import i5.d;
import j5.a;
import k5.i;
import q5.p;
@k5.e(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {60}, m = "invokeSuspend")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e extends i implements p<o<Object>, d<? super g>, Object> {

    /* renamed from: j  reason: collision with root package name */
    public int f3877j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f3878k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ f<Object> f3879l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f<Object> fVar, d<? super e> dVar) {
        super(2, dVar);
        this.f3879l = fVar;
    }

    @Override // q5.p
    public final Object i(o<Object> oVar, d<? super g> dVar) {
        return ((e) p(oVar, dVar)).s(g.f4141a);
    }

    @Override // k5.a
    public final d<g> p(Object obj, d<?> dVar) {
        e eVar = new e(this.f3879l, dVar);
        eVar.f3878k = obj;
        return eVar;
    }

    @Override // k5.a
    public final Object s(Object obj) {
        a aVar = a.f4591f;
        int i7 = this.f3877j;
        if (i7 == 0) {
            f5.e.b(obj);
            f<Object> fVar = this.f3879l;
            this.f3877j = 1;
            if (fVar.d((o) this.f3878k, this) == aVar) {
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
