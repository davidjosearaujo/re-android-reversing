package e6;

import a6.h0;
import a6.x;
import i5.e;

@k5.e(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {123}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class d extends k5.i implements q5.p {

    /* renamed from: j */
    public int f3874j;

    /* renamed from: k */
    public /* synthetic */ Object f3875k;

    /* renamed from: l */
    public final /* synthetic */ d6.d f3876l;
    public final /* synthetic */ f m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(i5.d dVar, d6.d dVar2, f fVar) {
        super(2, dVar);
        this.f3876l = dVar2;
        this.m = fVar;
    }

    public final Object i(Object obj, Object obj2) {
        return ((d) p((x) obj, (i5.d) obj2)).s(f5.g.f4141a);
    }

    public final i5.d p(Object obj, i5.d dVar) {
        d dVar2 = new d(dVar, this.f3876l, this.m);
        dVar2.f3875k = obj;
        return dVar2;
    }

    public final Object s(Object obj) {
        Object obj2 = Kotlin_1.a.f4591f;
        int i7 = this.f3874j;
        if (i7 == 0) {
            f5.e.b(obj);
            x xVar = (x) this.f3875k;
            d6.d dVar = this.f3876l;
            f fVar = this.m;
            i5.f fVar2 = fVar.f3880f;
            int i8 = fVar.f3881g;
            if (i8 == -3) {
                i8 = -2;
            }
            c6.a aVar = fVar.f3882h;
            q5.p eVar = new e(fVar, null);
            c6.b a7 = c6.h.a(i8, aVar, 4);
            i5.f a8 = a6.s.a(xVar.l(), fVar2, true);
            g6.c cVar = h0.f297a;
            if (a8 != cVar && a8.e(e.a.f4486f) == null) {
                a8 = a8.s(cVar);
            }
            c6.n nVar = new c6.n(a8, a7);
            nVar.l0(3, nVar, eVar);
            this.f3874j = 1;
            Object l6 = a0.b.l(dVar, nVar, true, this);
            if (l6 != obj2) {
                l6 = f5.g.f4141a;
            }
            if (l6 == obj2) {
                return obj2;
            }
        } else if (i7 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            f5.e.b(obj);
        }
        return f5.g.f4141a;
    }
}
