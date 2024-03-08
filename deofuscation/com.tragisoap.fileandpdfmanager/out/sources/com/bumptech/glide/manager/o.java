package com.bumptech.glide.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.util.Log;
import com.bumptech.glide.manager.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import k3.f;
import k3.g;
import k3.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o {

    /* renamed from: d */
    public static volatile o f2720d;

    /* renamed from: a */
    public final c f2721a;

    /* renamed from: b */
    public final HashSet f2722b = new HashSet();

    /* renamed from: c */
    public boolean f2723c;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements g<ConnectivityManager> {

        /* renamed from: a */
        public final /* synthetic */ Context f2724a;

        public a(Context context) {
            this.f2724a = context;
        }

        @Override // k3.g
        public final ConnectivityManager get() {
            return (ConnectivityManager) this.f2724a.getSystemService("connectivity");
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements b.a {
        public b() {
            o.this = r1;
        }

        @Override // com.bumptech.glide.manager.b.a
        public final void a(boolean z6) {
            ArrayList arrayList;
            l.a();
            synchronized (o.this) {
                arrayList = new ArrayList(o.this.f2722b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((b.a) it.next()).a(z6);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c {

        /* renamed from: a */
        public boolean f2726a;

        /* renamed from: b */
        public final b.a f2727b;

        /* renamed from: c */
        public final g<ConnectivityManager> f2728c;

        /* renamed from: d */
        public final a f2729d = new a();

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a extends ConnectivityManager.NetworkCallback {
            public a() {
                c.this = r1;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                l.f().post(new p(this, true));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                l.f().post(new p(this, false));
            }
        }

        public c(f fVar, b bVar) {
            this.f2728c = fVar;
            this.f2727b = bVar;
        }
    }

    public o(Context context) {
        this.f2721a = new c(new f(new a(context)), new b());
    }

    public static o a(Context context) {
        if (f2720d == null) {
            synchronized (o.class) {
                if (f2720d == null) {
                    f2720d = new o(context.getApplicationContext());
                }
            }
        }
        return f2720d;
    }

    public final void b() {
        if (!this.f2723c && !this.f2722b.isEmpty()) {
            c cVar = this.f2721a;
            boolean z6 = true;
            cVar.f2726a = cVar.f2728c.get().getActiveNetwork() != null;
            try {
                cVar.f2728c.get().registerDefaultNetworkCallback(cVar.f2729d);
            } catch (RuntimeException e) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register callback", e);
                }
                z6 = false;
            }
            this.f2723c = z6;
        }
    }
}
