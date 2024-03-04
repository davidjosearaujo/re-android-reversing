package androidx.lifecycle;

import androidx.lifecycle.g;

/* loaded from: classes.dex */
public final class SavedStateHandleController implements l {

    /* renamed from: f */
    public boolean f1839f;

    public final void a(g gVar, androidx.savedstate.a aVar) {
        r5.h.f(aVar, "registry");
        r5.h.f(gVar, "lifecycle");
        if (!(!this.f1839f)) {
            throw new IllegalStateException("Already attached to lifecycleOwner".toString());
        }
        this.f1839f = true;
        gVar.a(this);
        throw null;
    }

    @Override // androidx.lifecycle.l
    public final void c(n nVar, g.a aVar) {
        if (aVar == g.a.ON_DESTROY) {
            this.f1839f = false;
            nVar.k().c(this);
        }
    }
}
