package androidx.lifecycle;

import a6.u0;
import a6.x;
import androidx.lifecycle.g;
import f5.g;
import i5.d;
import j5.a;
import k5.e;
import q5.p;
@e(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i extends k5.i implements p<x, d<? super g>, Object> {

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f1870j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LifecycleCoroutineScopeImpl f1871k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, d<? super i> dVar) {
        super(2, dVar);
        this.f1871k = lifecycleCoroutineScopeImpl;
    }

    @Override // q5.p
    public final Object i(x xVar, d<? super g> dVar) {
        return ((i) p(xVar, dVar)).s(g.f4141a);
    }

    @Override // k5.a
    public final d<g> p(Object obj, d<?> dVar) {
        i iVar = new i(this.f1871k, dVar);
        iVar.f1870j = obj;
        return iVar;
    }

    @Override // k5.a
    public final Object s(Object obj) {
        a aVar = a.f4591f;
        f5.e.b(obj);
        x xVar = (x) this.f1870j;
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
