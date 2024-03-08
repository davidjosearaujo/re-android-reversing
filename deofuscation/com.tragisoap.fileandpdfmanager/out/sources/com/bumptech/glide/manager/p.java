package com.bumptech.glide.manager;

import com.bumptech.glide.manager.o;
import k3.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class p implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f2731f;

    /* renamed from: g  reason: collision with root package name */
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
        l.a();
        o.c cVar = o.c.this;
        boolean z7 = cVar.f2726a;
        cVar.f2726a = z6;
        if (z7 != z6) {
            cVar.f2727b.a(z6);
        }
    }
}
