package r0;

import a6.a0;

/* loaded from: classes.dex */
public final class v extends r5.i implements q5.l<x, f5.g> {

    /* renamed from: g */
    public final /* synthetic */ w f5711g;

    /* renamed from: h */
    public final /* synthetic */ u f5712h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(w wVar, u uVar) {
        super(1);
        this.f5711g = wVar;
        this.f5712h = uVar;
    }

    @Override // q5.l
    public final f5.g k(x xVar) {
        x xVar2 = xVar;
        r5.h.f(xVar2, "finalResult");
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
        return f5.g.f4141a;
    }
}
