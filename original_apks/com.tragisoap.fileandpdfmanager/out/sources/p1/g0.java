package p1;

import android.view.View;
import android.view.ViewGroup;
import f5.g;
import i5.d;
import j5.a;
import k5.e;
import k5.h;
import q5.p;
import y5.f;
@e(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {414, 416}, m = "invokeSuspend")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g0 extends h implements p<f<? super View>, d<? super g>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f5488h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5489i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ View f5490j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(View view, d<? super g0> dVar) {
        super(dVar);
        this.f5490j = view;
    }

    @Override // q5.p
    public final Object i(f<? super View> fVar, d<? super g> dVar) {
        return ((g0) p(fVar, dVar)).s(g.f4141a);
    }

    @Override // k5.a
    public final d<g> p(Object obj, d<?> dVar) {
        g0 g0Var = new g0(this.f5490j, dVar);
        g0Var.f5489i = obj;
        return g0Var;
    }

    @Override // k5.a
    public final Object s(Object obj) {
        a aVar = a.f4591f;
        int i7 = this.f5488h;
        if (i7 != 0) {
            if (i7 == 1) {
                f fVar = (f) this.f5489i;
                f5.e.b(obj);
                View view = this.f5490j;
                if (view instanceof ViewGroup) {
                    f0 f0Var = new f0((ViewGroup) view, null);
                    this.f5489i = null;
                    this.f5488h = 2;
                    fVar.getClass();
                    y5.e eVar = new y5.e();
                    eVar.f6843i = q2.a.p(eVar, eVar, f0Var);
                    Object d7 = fVar.d(eVar, this);
                    if (d7 != aVar) {
                        d7 = g.f4141a;
                    }
                    if (d7 == aVar) {
                        return aVar;
                    }
                }
            } else if (i7 == 2) {
                f5.e.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return g.f4141a;
        }
        f5.e.b(obj);
        f fVar2 = (f) this.f5489i;
        View view2 = this.f5490j;
        this.f5489i = fVar2;
        this.f5488h = 1;
        fVar2.b(view2, this);
        return aVar;
    }
}
