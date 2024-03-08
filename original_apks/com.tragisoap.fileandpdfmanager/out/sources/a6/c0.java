package a6;

import f6.m;
import f6.u;
import g6.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c0 {

    /* renamed from: a */
    public static final d0 f287a;

    static {
        String str;
        d0 d0Var;
        int i7 = u.f4181a;
        try {
            str = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str != null ? Boolean.parseBoolean(str) : false) {
            c cVar = h0.f297a;
            b1 b1Var = m.f4172a;
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
