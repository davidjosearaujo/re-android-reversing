package androidx.fragment.app;

import androidx.lifecycle.e;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;
import androidx.lifecycle.g;
import androidx.lifecycle.o;
import androidx.savedstate.a;
import h2.b;
import h2.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class m0 implements e, c, f0 {

    /* renamed from: f  reason: collision with root package name */
    public final e0 f1697f;

    /* renamed from: g  reason: collision with root package name */
    public o f1698g = null;

    /* renamed from: h  reason: collision with root package name */
    public b f1699h = null;

    public m0(e0 e0Var) {
        this.f1697f = e0Var;
    }

    @Override // h2.c
    public final a b() {
        e();
        return this.f1699h.f4376b;
    }

    public final void d(g.a aVar) {
        this.f1698g.f(aVar);
    }

    public final void e() {
        if (this.f1698g == null) {
            this.f1698g = new o(this);
            this.f1699h = new b(this);
        }
    }

    @Override // androidx.lifecycle.f0
    public final e0 i() {
        e();
        return this.f1697f;
    }

    @Override // androidx.lifecycle.n
    public final o k() {
        e();
        return this.f1698g;
    }
}
