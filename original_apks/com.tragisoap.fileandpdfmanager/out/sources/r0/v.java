package r0;

import a6.a0;
import f5.g;
import q5.l;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class v extends i implements l<x, g> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ w f5711g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ u f5712h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(w wVar, u uVar) {
        super(1);
        this.f5711g = wVar;
        this.f5712h = uVar;
    }

    @Override // q5.l
    public final g k(x xVar) {
        x xVar2 = xVar;
        h.f(xVar2, "finalResult");
        w wVar = this.f5711g;
        a0 a0Var = wVar.f5713a;
        u uVar = this.f5712h;
        synchronized (a0Var) {
            if (xVar2.f()) {
                wVar.f5714b.b(uVar, xVar2);
            } else {
                wVar.f5714b.c(uVar);
            }
        }
        return g.f4141a;
    }
}
