package com.bumptech.glide.manager;

import android.content.Context;
import com.bumptech.glide.manager.b;
import com.bumptech.glide.manager.o;
import com.bumptech.glide.n;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d implements b {

    /* renamed from: f  reason: collision with root package name */
    public final Context f2696f;

    /* renamed from: g  reason: collision with root package name */
    public final b.a f2697g;

    public d(Context context, n.b bVar) {
        this.f2696f = context.getApplicationContext();
        this.f2697g = bVar;
    }

    @Override // com.bumptech.glide.manager.g
    public final void a() {
        o a7 = o.a(this.f2696f);
        b.a aVar = this.f2697g;
        synchronized (a7) {
            a7.f2722b.add(aVar);
            a7.b();
        }
    }

    @Override // com.bumptech.glide.manager.g
    public final void d() {
        o a7 = o.a(this.f2696f);
        b.a aVar = this.f2697g;
        synchronized (a7) {
            a7.f2722b.remove(aVar);
            if (a7.f2723c && a7.f2722b.isEmpty()) {
                o.c cVar = a7.f2721a;
                cVar.f2728c.get().unregisterNetworkCallback(cVar.f2729d);
                a7.f2723c = false;
            }
        }
    }

    @Override // com.bumptech.glide.manager.g
    public final void k() {
    }
}
