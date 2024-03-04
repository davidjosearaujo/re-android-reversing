package androidx.fragment.app;

import androidx.lifecycle.g;

/* loaded from: classes.dex */
public final class m0 implements androidx.lifecycle.e, h2.c, androidx.lifecycle.f0 {

    /* renamed from: f */
    public final androidx.lifecycle.e0 f1697f;

    /* renamed from: g */
    public androidx.lifecycle.o f1698g = null;

    /* renamed from: h */
    public h2.b f1699h = null;

    public m0(androidx.lifecycle.e0 e0Var) {
        this.f1697f = e0Var;
    }

    @Override // h2.c
    public final androidx.savedstate.a b() {
        e();
        return this.f1699h.f4376b;
    }

    public final void d(g.a aVar) {
        this.f1698g.f(aVar);
    }

    public final void e() {
        if (this.f1698g == null) {
            this.f1698g = new androidx.lifecycle.o(this);
            this.f1699h = new h2.b(this);
        }
    }

    @Override // androidx.lifecycle.f0
    public final androidx.lifecycle.e0 i() {
        e();
        return this.f1697f;
    }

    @Override // androidx.lifecycle.n
    public final androidx.lifecycle.o k() {
        e();
        return this.f1698g;
    }
}
