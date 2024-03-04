package p1;

import android.view.View;
import android.view.ViewGroup;

@k5.e(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {414, 416}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class g0 extends k5.h implements q5.p {

    /* renamed from: h */
    public int f5488h;

    /* renamed from: i */
    public /* synthetic */ Object f5489i;

    /* renamed from: j */
    public final /* synthetic */ View f5490j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(View view, i5.d dVar) {
        super(dVar);
        this.f5490j = view;
    }

    public final Object i(Object obj, Object obj2) {
        return ((g0) p((y5.f) obj, (i5.d) obj2)).s(f5.g.f4141a);
    }

    public final i5.d p(Object obj, i5.d dVar) {
        g0 g0Var = new g0(this.f5490j, dVar);
        g0Var.f5489i = obj;
        return g0Var;
    }

    public final Object s(Object obj) {
        Kotlin_1.a aVar = Kotlin_1.a.f4591f;
        int i7 = this.f5488h;
        if (i7 == 0) {
            f5.e.b(obj);
            y5.f fVar = (y5.f) this.f5489i;
            View view = this.f5490j;
            this.f5489i = fVar;
            this.f5488h = 1;
            fVar.b(view, this);
            return aVar;
        }
        if (i7 == 1) {
            y5.f fVar2 = (y5.f) this.f5489i;
            f5.e.b(obj);
            View view2 = this.f5490j;
            if (view2 instanceof ViewGroup) {
                f0 f0Var = new f0((ViewGroup) view2, null);
                this.f5489i = null;
                this.f5488h = 2;
                fVar2.getClass();
                y5.e eVar = new y5.e();
                eVar.f6843i = q2.a.p(eVar, eVar, f0Var);
                Object d7 = fVar2.d(eVar, this);
                if (d7 != aVar) {
                    d7 = f5.g.f4141a;
                }
                if (d7 == aVar) {
                    return aVar;
                }
            }
        } else if (i7 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            f5.e.b(obj);
        }
        return f5.g.f4141a;
    }
}
