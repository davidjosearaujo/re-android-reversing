package com.bumptech.glide.manager;

import g3.d;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import k3.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final Set<d> f2717a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    public final HashSet f2718b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public boolean f2719c;

    public final boolean a(d dVar) {
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
        Iterator it = l.e(this.f2717a).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!dVar.i() && !dVar.c()) {
                dVar.clear();
                if (!this.f2719c) {
                    dVar.f();
                } else {
                    this.f2718b.add(dVar);
                }
            }
        }
    }

    public final String toString() {
        return super.toString() + "{numRequests=" + this.f2717a.size() + ", isPaused=" + this.f2719c + "}";
    }
}
