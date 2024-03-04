package androidx.lifecycle;

import a6.u0;
import androidx.lifecycle.g;

@k5.e(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class i extends k5.i implements q5.p {

    /* renamed from: j */
    public /* synthetic */ Object f1870j;

    /* renamed from: k */
    public final /* synthetic */ LifecycleCoroutineScopeImpl f1871k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, i5.d dVar) {
        super(2, dVar);
        this.f1871k = lifecycleCoroutineScopeImpl;
    }

    public final Object i(Object obj, Object obj2) {
        return ((i) p((a6.x) obj, (i5.d) obj2)).s(f5.g.f4141a);
    }

    public final i5.d p(Object obj, i5.d dVar) {
        i iVar = new i(this.f1871k, dVar);
        iVar.f1870j = obj;
        return iVar;
    }

    public final Object s(Object obj) {
        Kotlin_1.a aVar = Kotlin_1.a.f4591f;
        f5.e.b(obj);
        a6.x xVar = (a6.x) this.f1870j;
        if (this.f1871k.f1821f.b().compareTo(g.b.INITIALIZED) >= 0) {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = this.f1871k;
            lifecycleCoroutineScopeImpl.f1821f.a(lifecycleCoroutineScopeImpl);
        } else {
            u0 u0Var = (u0) xVar.l().e(u0.b.f341f);
            if (u0Var != null) {
                u0Var.d(null);
            }
        }
        return f5.g.f4141a;
    }
}
