package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.Log;
import com.bumptech.glide.manager.b;
import com.bumptech.glide.manager.r;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class n implements ComponentCallbacks2, com.bumptech.glide.manager.g {

    /* renamed from: p */
    public static final g3.g f2737p;

    /* renamed from: f */
    public final com.bumptech.glide.b f2738f;

    /* renamed from: g */
    public final Context f2739g;

    /* renamed from: h */
    public final com.bumptech.glide.manager.f f2740h;

    /* renamed from: i */
    public final com.bumptech.glide.manager.n f2741i;

    /* renamed from: j */
    public final com.bumptech.glide.manager.m f2742j;

    /* renamed from: k */
    public final r f2743k;

    /* renamed from: l */
    public final a f2744l;
    public final com.bumptech.glide.manager.b m;

    /* renamed from: n */
    public final CopyOnWriteArrayList<g3.f<Object>> f2745n;

    /* renamed from: o */
    public g3.g f2746o;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            n.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            n nVar = n.this;
            nVar.f2740h.a(nVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a {

        /* renamed from: a */
        public final com.bumptech.glide.manager.n f2748a;

        public b(com.bumptech.glide.manager.n nVar) {
            n.this = r1;
            this.f2748a = nVar;
        }

        @Override // com.bumptech.glide.manager.b.a
        public final void a(boolean z6) {
            if (z6) {
                synchronized (n.this) {
                    this.f2748a.b();
                }
            }
        }
    }

    static {
        g3.g c7 = new g3.g().c(Bitmap.class);
        c7.f4210y = true;
        f2737p = c7;
        new g3.g().c(c3.c.class).f4210y = true;
        g3.g gVar = (g3.g) ((g3.g) new g3.g().d(r2.l.f5794b).i()).m();
    }

    public n(com.bumptech.glide.b bVar, com.bumptech.glide.manager.f fVar, com.bumptech.glide.manager.m mVar, Context context) {
        g3.g gVar;
        com.bumptech.glide.manager.n nVar = new com.bumptech.glide.manager.n();
        com.bumptech.glide.manager.c cVar = bVar.f2628k;
        this.f2743k = new r();
        a aVar = new a();
        this.f2744l = aVar;
        this.f2738f = bVar;
        this.f2740h = fVar;
        this.f2742j = mVar;
        this.f2741i = nVar;
        this.f2739g = context;
        Context applicationContext = context.getApplicationContext();
        b bVar2 = new b(nVar);
        ((com.bumptech.glide.manager.e) cVar).getClass();
        boolean z6 = g1.a.a(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z6 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        com.bumptech.glide.manager.b dVar = z6 ? new com.bumptech.glide.manager.d(applicationContext, bVar2) : new com.bumptech.glide.manager.j();
        this.m = dVar;
        char[] cArr = k3.l.f4712a;
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            k3.l.f().post(aVar);
        } else {
            fVar.a(this);
        }
        fVar.a(dVar);
        this.f2745n = new CopyOnWriteArrayList<>(bVar.f2625h.e);
        g gVar2 = bVar.f2625h;
        synchronized (gVar2) {
            if (gVar2.f2639j == null) {
                ((c) gVar2.f2634d).getClass();
                g3.g gVar3 = new g3.g();
                gVar3.f4210y = true;
                gVar2.f2639j = gVar3;
            }
            gVar = gVar2.f2639j;
        }
        synchronized (this) {
            g3.g clone = gVar.clone();
            if (clone.f4210y && !clone.A) {
                throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
            }
            clone.A = true;
            clone.f4210y = true;
            this.f2746o = clone;
        }
        synchronized (bVar.f2629l) {
            if (bVar.f2629l.contains(this)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            bVar.f2629l.add(this);
        }
    }

    @Override // com.bumptech.glide.manager.g
    public final synchronized void a() {
        p();
        this.f2743k.a();
    }

    @Override // com.bumptech.glide.manager.g
    public final synchronized void d() {
        o();
        this.f2743k.d();
    }

    @Override // com.bumptech.glide.manager.g
    public final synchronized void k() {
        this.f2743k.k();
        Iterator it = k3.l.e(this.f2743k.f2736f).iterator();
        while (it.hasNext()) {
            l((h3.g) it.next());
        }
        this.f2743k.f2736f.clear();
        com.bumptech.glide.manager.n nVar = this.f2741i;
        Iterator it2 = k3.l.e(nVar.f2717a).iterator();
        while (it2.hasNext()) {
            nVar.a((g3.d) it2.next());
        }
        nVar.f2718b.clear();
        this.f2740h.d(this);
        this.f2740h.d(this.m);
        k3.l.f().removeCallbacks(this.f2744l);
        this.f2738f.c(this);
    }

    public final void l(h3.g<?> gVar) {
        boolean z6;
        if (gVar == null) {
            return;
        }
        boolean q6 = q(gVar);
        g3.d h7 = gVar.h();
        if (q6) {
            return;
        }
        com.bumptech.glide.b bVar = this.f2738f;
        synchronized (bVar.f2629l) {
            Iterator it = bVar.f2629l.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z6 = false;
                    break;
                } else if (((n) it.next()).q(gVar)) {
                    z6 = true;
                    break;
                }
            }
        }
        if (z6 || h7 == null) {
            return;
        }
        gVar.b(null);
        h7.clear();
    }

    public final m<Drawable> m(Integer num) {
        PackageInfo packageInfo;
        m mVar = new m(this.f2738f, this, Drawable.class, this.f2739g);
        m w6 = mVar.w(num);
        Context context = mVar.F;
        ConcurrentHashMap concurrentHashMap = j3.b.f4577a;
        String packageName = context.getPackageName();
        p2.f fVar = (p2.f) j3.b.f4577a.get(packageName);
        if (fVar == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                StringBuilder d7 = androidx.activity.h.d("Cannot resolve info for");
                d7.append(context.getPackageName());
                Log.e("AppVersionSignature", d7.toString(), e);
                packageInfo = null;
            }
            j3.d dVar = new j3.d(packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString());
            fVar = (p2.f) j3.b.f4577a.putIfAbsent(packageName, dVar);
            if (fVar == null) {
                fVar = dVar;
            }
        }
        return w6.r(new g3.g().l(new j3.a(context.getResources().getConfiguration().uiMode & 48, fVar)));
    }

    public final m<Drawable> n(String str) {
        return new m(this.f2738f, this, Drawable.class, this.f2739g).w(str);
    }

    public final synchronized void o() {
        com.bumptech.glide.manager.n nVar = this.f2741i;
        nVar.f2719c = true;
        Iterator it = k3.l.e(nVar.f2717a).iterator();
        while (it.hasNext()) {
            g3.d dVar = (g3.d) it.next();
            if (dVar.isRunning()) {
                dVar.pause();
                nVar.f2718b.add(dVar);
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i7) {
    }

    public final synchronized void p() {
        com.bumptech.glide.manager.n nVar = this.f2741i;
        nVar.f2719c = false;
        Iterator it = k3.l.e(nVar.f2717a).iterator();
        while (it.hasNext()) {
            g3.d dVar = (g3.d) it.next();
            if (!dVar.i() && !dVar.isRunning()) {
                dVar.f();
            }
        }
        nVar.f2718b.clear();
    }

    public final synchronized boolean q(h3.g<?> gVar) {
        g3.d h7 = gVar.h();
        if (h7 == null) {
            return true;
        }
        if (this.f2741i.a(h7)) {
            this.f2743k.f2736f.remove(gVar);
            gVar.b(null);
            return true;
        }
        return false;
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.f2741i + ", treeNode=" + this.f2742j + "}";
    }
}
