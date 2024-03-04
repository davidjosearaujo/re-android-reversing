package a6;

/* loaded from: classes.dex */
public abstract class b1 extends u {
    public abstract b1 W();

    @Override // a6.u
    public String toString() {
        b1 b1Var;
        String str;
        g6.c cVar = h0.f297a;
        b1 b1Var2 = f6.m.f4172a;
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
        if (str == null) {
            return getClass().getSimpleName() + '@' + a0.c(this);
        }
        return str;
    }
}
