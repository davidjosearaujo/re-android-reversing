package androidx.fragment.app;

import androidx.fragment.app.q0;

/* loaded from: classes.dex */
public final class o0 implements Runnable {

    /* renamed from: f */
    public final /* synthetic */ q0.a f1734f;

    /* renamed from: g */
    public final /* synthetic */ q0 f1735g;

    public o0(q0 q0Var, q0.a aVar) {
        this.f1735g = q0Var;
        this.f1734f = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1735g.f1744b.contains(this.f1734f)) {
            q0.a aVar = this.f1734f;
            s0.a(aVar.f1748a, aVar.f1750c.J);
        }
    }
}
