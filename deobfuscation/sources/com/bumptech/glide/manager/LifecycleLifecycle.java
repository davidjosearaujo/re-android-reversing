package com.bumptech.glide.manager;

import androidx.lifecycle.g;
import androidx.lifecycle.t;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class LifecycleLifecycle implements f, androidx.lifecycle.m {

    /* renamed from: f */
    public final HashSet f2691f = new HashSet();

    /* renamed from: g */
    public final androidx.lifecycle.g f2692g;

    public LifecycleLifecycle(androidx.lifecycle.o oVar) {
        this.f2692g = oVar;
        oVar.a(this);
    }

    @Override // com.bumptech.glide.manager.f
    public final void a(g gVar) {
        this.f2691f.add(gVar);
        if (this.f2692g.b() == g.b.DESTROYED) {
            gVar.k();
            return;
        }
        if (this.f2692g.b().compareTo(g.b.STARTED) >= 0) {
            gVar.a();
        } else {
            gVar.d();
        }
    }

    @Override // com.bumptech.glide.manager.f
    public final void d(g gVar) {
        this.f2691f.remove(gVar);
    }

    @t(g.a.ON_DESTROY)
    public void onDestroy(androidx.lifecycle.n nVar) {
        Iterator it = k3.l.e(this.f2691f).iterator();
        while (it.hasNext()) {
            ((g) it.next()).k();
        }
        nVar.k().c(this);
    }

    @t(g.a.ON_START)
    public void onStart(androidx.lifecycle.n nVar) {
        Iterator it = k3.l.e(this.f2691f).iterator();
        while (it.hasNext()) {
            ((g) it.next()).a();
        }
    }

    @t(g.a.ON_STOP)
    public void onStop(androidx.lifecycle.n nVar) {
        Iterator it = k3.l.e(this.f2691f).iterator();
        while (it.hasNext()) {
            ((g) it.next()).d();
        }
    }
}
