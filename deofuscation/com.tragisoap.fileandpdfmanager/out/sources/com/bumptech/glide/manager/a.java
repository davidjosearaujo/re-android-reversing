package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import k3.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements f {

    /* renamed from: f  reason: collision with root package name */
    public final Set<g> f2693f = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: g  reason: collision with root package name */
    public boolean f2694g;

    /* renamed from: h  reason: collision with root package name */
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
        Iterator it = l.e(this.f2693f).iterator();
        while (it.hasNext()) {
            ((g) it.next()).k();
        }
    }

    public final void c() {
        this.f2694g = true;
        Iterator it = l.e(this.f2693f).iterator();
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
        Iterator it = l.e(this.f2693f).iterator();
        while (it.hasNext()) {
            ((g) it.next()).d();
        }
    }
}
