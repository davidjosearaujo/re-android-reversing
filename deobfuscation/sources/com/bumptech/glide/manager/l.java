package com.bumptech.glide.manager;

import a6.a0;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.x;
import androidx.fragment.app.y;
import com.bumptech.glide.manager.i;
import com.bumptech.glide.manager.k;
import com.bumptech.glide.manager.q;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class l implements Handler.Callback {

    /* renamed from: i */
    public static final a f2709i = new a();

    /* renamed from: a */
    public volatile com.bumptech.glide.n f2710a;

    /* renamed from: b */
    public final HashMap f2711b = new HashMap();

    /* renamed from: c */
    public final HashMap f2712c = new HashMap();

    /* renamed from: d */
    public final Handler f2713d;
    public final b e;

    /* renamed from: f */
    public final com.bumptech.glide.h f2714f;

    /* renamed from: g */
    public final g6.i f2715g;

    /* renamed from: h */
    public final i f2716h;

    /* loaded from: classes.dex */
    public class a implements b {
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    public l(b bVar, com.bumptech.glide.h hVar) {
        new o.b();
        new o.b();
        new Bundle();
        bVar = bVar == null ? f2709i : bVar;
        this.e = bVar;
        this.f2714f = hVar;
        this.f2713d = new Handler(Looper.getMainLooper(), this);
        this.f2716h = new i(bVar);
        File file = y2.q.e;
        this.f2715g = new g6.i(5);
    }

    public static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public final com.bumptech.glide.n b(Context context) {
        if (context != null) {
            char[] cArr = k3.l.f4712a;
            boolean z6 = true;
            if ((Looper.myLooper() == Looper.getMainLooper()) && !(context instanceof Application)) {
                if (context instanceof androidx.fragment.app.q) {
                    return c((androidx.fragment.app.q) context);
                }
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (!(Looper.myLooper() == Looper.getMainLooper())) {
                        return b(activity.getApplicationContext());
                    }
                    if (activity instanceof androidx.fragment.app.q) {
                        return c((androidx.fragment.app.q) activity);
                    }
                    if (activity.isDestroyed()) {
                        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                    }
                    this.f2715g.getClass();
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    Activity a7 = a(activity);
                    if (a7 != null && a7.isFinishing()) {
                        z6 = false;
                    }
                    k d7 = d(fragmentManager);
                    com.bumptech.glide.n nVar = d7.f2705i;
                    if (nVar == null) {
                        com.bumptech.glide.b b2 = com.bumptech.glide.b.b(activity);
                        b bVar = this.e;
                        com.bumptech.glide.manager.a aVar = d7.f2702f;
                        k.a aVar2 = d7.f2703g;
                        ((a) bVar).getClass();
                        com.bumptech.glide.n nVar2 = new com.bumptech.glide.n(b2, aVar, aVar2, activity);
                        if (z6) {
                            nVar2.a();
                        }
                        d7.f2705i = nVar2;
                        return nVar2;
                    }
                    return nVar;
                } else if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return b(contextWrapper.getBaseContext());
                    }
                }
            }
            if (this.f2710a == null) {
                synchronized (this) {
                    if (this.f2710a == null) {
                        com.bumptech.glide.b b7 = com.bumptech.glide.b.b(context.getApplicationContext());
                        b bVar2 = this.e;
                        a0 a0Var = new a0();
                        a0 a0Var2 = new a0();
                        Context applicationContext = context.getApplicationContext();
                        ((a) bVar2).getClass();
                        this.f2710a = new com.bumptech.glide.n(b7, a0Var, a0Var2, applicationContext);
                    }
                }
            }
            return this.f2710a;
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public final com.bumptech.glide.n c(androidx.fragment.app.q qVar) {
        char[] cArr = k3.l.f4712a;
        boolean z6 = false;
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            return b(qVar.getApplicationContext());
        }
        if (qVar.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
        this.f2715g.getClass();
        y yVar = qVar.f1739x.f1762a.f1767i;
        Activity a7 = a(qVar);
        if (a7 == null || !a7.isFinishing()) {
            z6 = true;
        }
        if (!this.f2714f.f2640a.containsKey(com.bumptech.glide.f.class)) {
            q e = e(yVar);
            com.bumptech.glide.n nVar = e.f2733a0;
            if (nVar == null) {
                com.bumptech.glide.b b2 = com.bumptech.glide.b.b(qVar);
                b bVar = this.e;
                com.bumptech.glide.manager.a aVar = e.W;
                q.a aVar2 = e.X;
                ((a) bVar).getClass();
                com.bumptech.glide.n nVar2 = new com.bumptech.glide.n(b2, aVar, aVar2, qVar);
                if (z6) {
                    nVar2.a();
                }
                e.f2733a0 = nVar2;
                return nVar2;
            }
            return nVar;
        }
        Context applicationContext = qVar.getApplicationContext();
        com.bumptech.glide.b b7 = com.bumptech.glide.b.b(applicationContext);
        i iVar = this.f2716h;
        androidx.lifecycle.o oVar = qVar.f358i;
        y yVar2 = qVar.f1739x.f1762a.f1767i;
        iVar.getClass();
        k3.l.a();
        k3.l.a();
        com.bumptech.glide.n nVar3 = (com.bumptech.glide.n) iVar.f2700a.get(oVar);
        if (nVar3 == null) {
            LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(oVar);
            b bVar2 = iVar.f2701b;
            i.a aVar3 = new i.a(iVar, yVar2);
            ((a) bVar2).getClass();
            com.bumptech.glide.n nVar4 = new com.bumptech.glide.n(b7, lifecycleLifecycle, aVar3, applicationContext);
            iVar.f2700a.put(oVar, nVar4);
            lifecycleLifecycle.a(new h(iVar, oVar));
            if (z6) {
                nVar4.a();
            }
            return nVar4;
        }
        return nVar3;
    }

    public final k d(FragmentManager fragmentManager) {
        k kVar = (k) this.f2711b.get(fragmentManager);
        if (kVar == null) {
            k kVar2 = (k) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
            if (kVar2 == null) {
                kVar2 = new k();
                kVar2.f2707k = null;
                this.f2711b.put(fragmentManager, kVar2);
                fragmentManager.beginTransaction().add(kVar2, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.f2713d.obtainMessage(1, fragmentManager).sendToTarget();
            }
            return kVar2;
        }
        return kVar;
    }

    public final q e(x xVar) {
        q qVar = (q) this.f2712c.get(xVar);
        if (qVar == null) {
            q qVar2 = (q) xVar.F("com.bumptech.glide.manager");
            if (qVar2 == null) {
                qVar2 = new q();
                qVar2.f2734b0 = null;
                this.f2712c.put(xVar, qVar2);
                androidx.fragment.app.a aVar = new androidx.fragment.app.a(xVar);
                aVar.e(0, qVar2, "com.bumptech.glide.manager", 1);
                aVar.d(true);
                this.f2713d.obtainMessage(2, xVar).sendToTarget();
            }
            return qVar2;
        }
        return qVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:304:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x013c  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r17) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.manager.l.handleMessage(android.os.Message):boolean");
    }
}
