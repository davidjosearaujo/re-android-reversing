package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a */
    public final Set<g3.d> f2717a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    public final HashSet f2718b = new HashSet();

    /* renamed from: c */
    public boolean f2719c;

    public final boolean a(g3.d dVar) {
        boolean z6 = true;
        if (dVar == null) {
            return true;
        }
        boolean remove = this.f2717a.remove(dVar);
        if (!this.f2718b.remove(dVar) && !remove) {
            z6 = false;
        }
        if (z6) {
            dVar.clear();
        }
        return z6;
    }

    public final void b() {
        Iterator it = k3.l.e(this.f2717a).iterator();
        while (it.hasNext()) {
            g3.d dVar = (g3.d) it.next();
            if (!dVar.i() && !dVar.c()) {
                dVar.clear();
                if (this.f2719c) {
                    this.f2718b.add(dVar);
                } else {
                    dVar.f();
                }
            }
        }
    }

    public final String toString() {
        return super.toString() + "{numRequests=" + this.f2717a.size() + ", isPaused=" + this.f2719c + "}";
    }
}
