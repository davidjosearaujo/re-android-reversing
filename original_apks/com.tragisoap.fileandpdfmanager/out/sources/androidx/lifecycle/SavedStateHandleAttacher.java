package androidx.lifecycle;

import androidx.lifecycle.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class SavedStateHandleAttacher implements l {

    /* renamed from: f  reason: collision with root package name */
    public final a0 f1838f;

    public SavedStateHandleAttacher(a0 a0Var) {
        this.f1838f = a0Var;
    }

    @Override // androidx.lifecycle.l
    public final void c(n nVar, g.a aVar) {
        if (aVar == g.a.ON_CREATE) {
            nVar.k().c(this);
            this.f1838f.b();
            return;
        }
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + aVar).toString());
    }
}
