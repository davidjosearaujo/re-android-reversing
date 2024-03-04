package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class r implements g {

    /* renamed from: f */
    public final Set<h3.g<?>> f2736f = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.bumptech.glide.manager.g
    public final void a() {
        Iterator it = k3.l.e(this.f2736f).iterator();
        while (it.hasNext()) {
            ((h3.g) it.next()).a();
        }
    }

    @Override // com.bumptech.glide.manager.g
    public final void d() {
        Iterator it = k3.l.e(this.f2736f).iterator();
        while (it.hasNext()) {
            ((h3.g) it.next()).d();
        }
    }

    @Override // com.bumptech.glide.manager.g
    public final void k() {
        Iterator it = k3.l.e(this.f2736f).iterator();
        while (it.hasNext()) {
            ((h3.g) it.next()).k();
        }
    }
}
