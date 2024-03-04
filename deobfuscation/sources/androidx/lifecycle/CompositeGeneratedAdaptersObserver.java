package androidx.lifecycle;

import androidx.lifecycle.g;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class CompositeGeneratedAdaptersObserver implements l {

    /* renamed from: f */
    public final d[] f1815f;

    public CompositeGeneratedAdaptersObserver(d[] dVarArr) {
        this.f1815f = dVarArr;
    }

    @Override // androidx.lifecycle.l
    public final void c(n nVar, g.a aVar) {
        new HashMap();
        for (d dVar : this.f1815f) {
            dVar.a();
        }
        for (d dVar2 : this.f1815f) {
            dVar2.a();
        }
    }
}
