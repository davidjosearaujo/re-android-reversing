package d6;

import f5.g;
import i5.d;
import j5.a;
import k5.e;
import k5.i;
import q5.p;
import q5.q;
@e(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", l = {217, 217}, m = "invokeSuspend")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k extends i implements q<d<Object>, Object, d<? super g>, Object> {

    /* renamed from: j  reason: collision with root package name */
    public int f3707j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ d f3708k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f3709l;
    public final /* synthetic */ p<Object, d<Object>, Object> m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public k(p<Object, ? super d<Object>, ? extends Object> pVar, d<? super k> dVar) {
        super(3, dVar);
        this.m = pVar;
    }

    @Override // q5.q
    public final Object f(d<Object> dVar, Object obj, d<? super g> dVar2) {
        k kVar = new k(this.m, dVar2);
        kVar.f3708k = dVar;
        kVar.f3709l = obj;
        return kVar.s(g.f4141a);
    }

    @Override // k5.a
    public final Object s(Object obj) {
        d dVar;
        a aVar = a.f4591f;
        int i7 = this.f3707j;
        if (i7 == 0) {
            f5.e.b(obj);
            dVar = this.f3708k;
            Object obj2 = this.f3709l;
            p<Object, d<Object>, Object> pVar = this.m;
            this.f3708k = dVar;
            this.f3707j = 1;
            obj = pVar.i(obj2, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i7 == 1) {
            dVar = this.f3708k;
            f5.e.b(obj);
        } else if (i7 == 2) {
            f5.e.b(obj);
            return g.f4141a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f3708k = null;
        this.f3707j = 2;
        if (dVar.m(obj, this) == aVar) {
            return aVar;
        }
        return g.f4141a;
    }
}
