package a6;

import f5.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l extends w0 implements k {

    /* renamed from: j  reason: collision with root package name */
    public final m f305j;

    public l(z0 z0Var) {
        this.f305j = z0Var;
    }

    @Override // a6.k
    public final boolean c(Throwable th) {
        return r().F(th);
    }

    @Override // a6.k
    public final u0 getParent() {
        return r();
    }

    @Override // q5.l
    public final /* bridge */ /* synthetic */ g k(Throwable th) {
        q(th);
        return g.f4141a;
    }

    @Override // a6.q
    public final void q(Throwable th) {
        this.f305j.i(r());
    }
}
