package androidx.lifecycle;

import a6.u0;
import androidx.lifecycle.g;

/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends h implements l {

    /* renamed from: f */
    public final g f1821f;

    /* renamed from: g */
    public final i5.f f1822g;

    public LifecycleCoroutineScopeImpl(g gVar, i5.f fVar) {
        u0 u0Var;
        r5.h.f(fVar, "coroutineContext");
        this.f1821f = gVar;
        this.f1822g = fVar;
        if (gVar.b() != g.b.DESTROYED || (u0Var = (u0) fVar.e(u0.b.f341f)) == null) {
            return;
        }
        u0Var.d(null);
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
    public final i5.f l() {
        return this.f1822g;
    }
}
