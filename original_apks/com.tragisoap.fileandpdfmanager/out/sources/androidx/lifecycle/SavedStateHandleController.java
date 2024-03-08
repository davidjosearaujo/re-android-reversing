package androidx.lifecycle;

import androidx.lifecycle.g;
import androidx.savedstate.a;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class SavedStateHandleController implements l {

    /* renamed from: f  reason: collision with root package name */
    public boolean f1839f;

    public final void a(g gVar, a aVar) {
        h.f(aVar, "registry");
        h.f(gVar, "lifecycle");
        if (!this.f1839f) {
            this.f1839f = true;
            gVar.a(this);
            throw null;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner".toString());
    }

    @Override // androidx.lifecycle.l
    public final void c(n nVar, g.a aVar) {
        if (aVar == g.a.ON_DESTROY) {
            this.f1839f = false;
            nVar.k().c(this);
        }
    }
}
