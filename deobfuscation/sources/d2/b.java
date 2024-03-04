package d2;

import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import r5.h;

/* loaded from: classes.dex */
public final class b implements d0.a {

    /* renamed from: a */
    public final d<?>[] f3557a;

    public b(d<?>... dVarArr) {
        h.f(dVarArr, "initializers");
        this.f3557a = dVarArr;
    }

    @Override // androidx.lifecycle.d0.a
    public final c0 a(Class cls, c cVar) {
        d<?>[] dVarArr;
        c0 c0Var = null;
        for (d<?> dVar : this.f3557a) {
            if (h.a(dVar.f3558a, cls)) {
                Object k6 = dVar.f3559b.k(cVar);
                c0Var = k6 instanceof c0 ? (c0) k6 : null;
            }
        }
        if (c0Var != null) {
            return c0Var;
        }
        StringBuilder d7 = androidx.activity.h.d("No initializer set for given class ");
        d7.append(cls.getName());
        throw new IllegalArgumentException(d7.toString());
    }
}
