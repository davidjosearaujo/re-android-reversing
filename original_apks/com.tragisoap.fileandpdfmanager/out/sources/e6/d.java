package e6;

import a6.h0;
import a6.s;
import a6.x;
import c6.b;
import c6.h;
import c6.n;
import f5.g;
import g6.c;
import i5.e;
import i5.f;
import j5.a;
import k5.e;
import k5.i;
import q5.p;
@e(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {123}, m = "invokeSuspend")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d extends i implements p<x, i5.d<? super g>, Object> {

    /* renamed from: j  reason: collision with root package name */
    public int f3874j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f3875k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ d6.d<Object> f3876l;
    public final /* synthetic */ f<Object> m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(i5.d dVar, d6.d dVar2, f fVar) {
        super(2, dVar);
        this.f3876l = dVar2;
        this.m = fVar;
    }

    @Override // q5.p
    public final Object i(x xVar, i5.d<? super g> dVar) {
        return ((d) p(xVar, dVar)).s(g.f4141a);
    }

    @Override // k5.a
    public final i5.d<g> p(Object obj, i5.d<?> dVar) {
        d dVar2 = new d(dVar, this.f3876l, this.m);
        dVar2.f3875k = obj;
        return dVar2;
    }

    @Override // k5.a
    public final Object s(Object obj) {
        Object obj2 = a.f4591f;
        int i7 = this.f3874j;
        if (i7 == 0) {
            f5.e.b(obj);
            x xVar = (x) this.f3875k;
            d6.d<Object> dVar = this.f3876l;
            f<Object> fVar = this.m;
            f fVar2 = fVar.f3880f;
            int i8 = fVar.f3881g;
            if (i8 == -3) {
                i8 = -2;
            }
            c6.a aVar = fVar.f3882h;
            p eVar = new e(fVar, null);
            b a7 = h.a(i8, aVar, 4);
            f a8 = s.a(xVar.l(), fVar2, true);
            c cVar = h0.f297a;
            if (a8 != cVar && a8.e(e.a.f4486f) == null) {
                a8 = a8.s(cVar);
            }
            n nVar = new n(a8, a7);
            nVar.l0(3, nVar, eVar);
            this.f3874j = 1;
            Object l6 = a0.b.l(dVar, nVar, true, this);
            if (l6 != obj2) {
                l6 = g.f4141a;
            }
            if (l6 == obj2) {
                return obj2;
            }
        } else if (i7 == 1) {
            f5.e.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return g.f4141a;
    }
}
