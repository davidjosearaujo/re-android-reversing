package com.bumptech.glide.manager;

import com.bumptech.glide.manager.o;

/* loaded from: classes.dex */
public final class p implements Runnable {

    /* renamed from: f */
    public final /* synthetic */ boolean f2731f;

    /* renamed from: g */
    public final /* synthetic */ o.c.a f2732g;

    public p(o.c.a aVar, boolean z6) {
        this.f2732g = aVar;
        this.f2731f = z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o.c.a aVar = this.f2732g;
        boolean z6 = this.f2731f;
        aVar.getClass();
        k3.l.a();
        o.c cVar = o.c.this;
        boolean z7 = cVar.f2726a;
        cVar.f2726a = z6;
        if (z7 != z6) {
            cVar.f2727b.a(z6);
        }
    }
}
