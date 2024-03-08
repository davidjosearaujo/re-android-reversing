package r5;

import a6.z;
import x5.a;
import x5.d;
import x5.e;
import x5.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class j extends l implements d {
    public j(String str, String str2) {
        super(str, str2);
    }

    @Override // r5.b
    public final a a() {
        t.f5928a.getClass();
        return this;
    }

    @Override // x5.e
    public final e.a j() {
        if (!this.f5923l) {
            a c7 = c();
            if (c7 != this) {
                return ((d) ((f) c7)).j();
            }
            throw new z();
        }
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
    }

    @Override // q5.l
    public final Object k(Object obj) {
        return ((k) this).j().call();
    }
}
