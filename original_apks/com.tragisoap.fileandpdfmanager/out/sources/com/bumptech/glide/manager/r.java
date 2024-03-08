package com.bumptech.glide.manager;

import h3.g;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import k3.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class r implements g {

    /* renamed from: f  reason: collision with root package name */
    public final Set<g<?>> f2736f = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.bumptech.glide.manager.g
    public final void a() {
        Iterator it = l.e(this.f2736f).iterator();
        while (it.hasNext()) {
            ((g) it.next()).a();
        }
    }

    @Override // com.bumptech.glide.manager.g
    public final void d() {
        Iterator it = l.e(this.f2736f).iterator();
        while (it.hasNext()) {
            ((g) it.next()).d();
        }
    }

    @Override // com.bumptech.glide.manager.g
    public final void k() {
        Iterator it = l.e(this.f2736f).iterator();
        while (it.hasNext()) {
            ((g) it.next()).k();
        }
    }
}
