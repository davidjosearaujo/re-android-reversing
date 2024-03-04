package a6;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a */
    public static final d0 f287a;

    static {
        String str;
        d0 d0Var;
        int i7 = f6.u.f4181a;
        try {
            str = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str != null ? Boolean.parseBoolean(str) : false) {
            g6.c cVar = h0.f297a;
            b1 b1Var = f6.m.f4172a;
            b1Var.W();
            if (b1Var instanceof d0) {
                d0Var = (d0) b1Var;
                f287a = d0Var;
            }
        }
        d0Var = b0.f283o;
        f287a = d0Var;
    }
}
