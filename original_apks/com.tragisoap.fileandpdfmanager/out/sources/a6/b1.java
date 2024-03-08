package a6;

import f6.m;
import g6.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class b1 extends u {
    public abstract b1 W();

    @Override // a6.u
    public String toString() {
        String str;
        b1 b1Var;
        c cVar = h0.f297a;
        b1 b1Var2 = m.f4172a;
        if (this == b1Var2) {
            str = "Dispatchers.Main";
        } else {
            try {
                b1Var = b1Var2.W();
            } catch (UnsupportedOperationException unused) {
                b1Var = null;
            }
            str = this == b1Var ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        return getClass().getSimpleName() + '@' + a0.c(this);
    }
}
