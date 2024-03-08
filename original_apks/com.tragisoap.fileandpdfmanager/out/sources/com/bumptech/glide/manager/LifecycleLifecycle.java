package com.bumptech.glide.manager;

import androidx.lifecycle.g;
import androidx.lifecycle.m;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.lifecycle.t;
import java.util.HashSet;
import java.util.Iterator;
import k3.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class LifecycleLifecycle implements f, m {

    /* renamed from: f  reason: collision with root package name */
    public final HashSet f2691f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    public final g f2692g;

    public LifecycleLifecycle(o oVar) {
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
    public void onDestroy(n nVar) {
        Iterator it = l.e(this.f2691f).iterator();
        while (it.hasNext()) {
            ((g) it.next()).k();
        }
        nVar.k().c(this);
    }

    @t(g.a.ON_START)
    public void onStart(n nVar) {
        Iterator it = l.e(this.f2691f).iterator();
        while (it.hasNext()) {
            ((g) it.next()).a();
        }
    }

    @t(g.a.ON_STOP)
    public void onStop(n nVar) {
        Iterator it = l.e(this.f2691f).iterator();
        while (it.hasNext()) {
            ((g) it.next()).d();
        }
    }
}
