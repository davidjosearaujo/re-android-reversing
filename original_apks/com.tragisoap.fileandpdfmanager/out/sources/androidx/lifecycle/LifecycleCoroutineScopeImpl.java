package androidx.lifecycle;

import a6.u0;
import androidx.lifecycle.g;
import i5.f;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class LifecycleCoroutineScopeImpl extends h implements l {

    /* renamed from: f  reason: collision with root package name */
    public final g f1821f;

    /* renamed from: g  reason: collision with root package name */
    public final f f1822g;

    public LifecycleCoroutineScopeImpl(g gVar, f fVar) {
        u0 u0Var;
        h.f(fVar, "coroutineContext");
        this.f1821f = gVar;
        this.f1822g = fVar;
        if (gVar.b() == g.b.DESTROYED && (u0Var = (u0) fVar.e(u0.b.f341f)) != null) {
            u0Var.d(null);
        }
    }

    @Override // androidx.lifecycle.l
    public final void c(n nVar, g.a aVar) {
        if (this.f1821f.b().compareTo(g.b.DESTROYED) <= 0) {
            this.f1821f.c(this);
            u0 u0Var = (u0) this.f1822g.e(u0.b.f341f);
            if (u0Var != null) {
                u0Var.d(null);
            }
        }
    }

    @Override // a6.x
    public final f l() {
        return this.f1822g;
    }
}
