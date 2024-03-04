package r5;

import a6.z;
import x5.e;

/* loaded from: classes.dex */
public abstract class j extends l implements x5.d {
    public j(String str, String str2) {
        super(str, str2);
    }

    @Override // r5.b
    public final x5.a a() {
        t.f5928a.getClass();
        return this;
    }

    @Override // x5.e
    public final e.a j() {
        if (this.f5923l) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
        }
        x5.a c7 = c();
        if (c7 != this) {
            return ((x5.d) ((x5.f) c7)).j();
        }
        throw new z();
    }

    @Override // q5.l
    public final Object k(Object obj) {
        return ((k) this).j().call();
    }
}
