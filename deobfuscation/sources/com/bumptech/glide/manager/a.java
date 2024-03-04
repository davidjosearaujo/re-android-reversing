package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class a implements f {

    /* renamed from: f */
    public final Set<g> f2693f = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: g */
    public boolean f2694g;

    /* renamed from: h */
    public boolean f2695h;

    @Override // com.bumptech.glide.manager.f
    public final void a(g gVar) {
        this.f2693f.add(gVar);
        if (this.f2695h) {
            gVar.k();
        } else if (this.f2694g) {
            gVar.a();
        } else {
            gVar.d();
        }
    }

    public final void b() {
        this.f2695h = true;
        Iterator it = k3.l.e(this.f2693f).iterator();
        while (it.hasNext()) {
            ((g) it.next()).k();
        }
    }

    public final void c() {
        this.f2694g = true;
        Iterator it = k3.l.e(this.f2693f).iterator();
        while (it.hasNext()) {
            ((g) it.next()).a();
        }
    }

    @Override // com.bumptech.glide.manager.f
    public final void d(g gVar) {
        this.f2693f.remove(gVar);
    }

    public final void e() {
        this.f2694g = false;
        Iterator it = k3.l.e(this.f2693f).iterator();
        while (it.hasNext()) {
            ((g) it.next()).d();
        }
    }
}
