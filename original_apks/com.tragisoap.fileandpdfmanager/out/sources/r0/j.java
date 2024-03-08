package r0;

import a6.a0;
import q2.a;
import r0.g;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j implements g.a {

    /* renamed from: a */
    public final r f5694a;

    /* renamed from: b */
    public final w f5695b;

    /* renamed from: c */
    public final m f5696c;

    /* renamed from: d */
    public final q f5697d;
    public final h e = new h(this);

    public j(a aVar, a aVar2) {
        w wVar = k.f5698a;
        m mVar = new m(k.f5699b);
        q qVar = new q();
        h.f(wVar, "typefaceRequestCache");
        this.f5694a = aVar;
        this.f5695b = wVar;
        this.f5696c = mVar;
        this.f5697d = qVar;
    }

    public final x a(u uVar) {
        x a7;
        w wVar = this.f5695b;
        i iVar = new i(this, uVar);
        wVar.getClass();
        a0 a0Var = wVar.f5713a;
        try {
            synchronized (a0Var) {
                a7 = wVar.f5714b.a(uVar);
                if (a7 != null) {
                    if (a7.f()) {
                        return a7;
                    }
                    wVar.f5714b.c(uVar);
                }
            }
            a7 = (x) iVar.k(new v(wVar, uVar));
            a0Var = wVar.f5713a;
            synchronized (a0Var) {
                if (wVar.f5714b.a(uVar) == null && a7.f()) {
                    wVar.f5714b.b(uVar, a7);
                }
                f5.g gVar = f5.g.f4141a;
                return a7;
            }
        } catch (Exception e) {
            throw new IllegalStateException("Could not load font", e);
        }
    }
}
