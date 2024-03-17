package cn.jiguang.av;

import android.os.SystemClock;
import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.concurrent.Callable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b implements Callable<cn.jiguang.ba.a> {
    private final k a;
    private final p b;
    private final f c;
    private final h d;

    public b(k kVar, p pVar, f fVar, h hVar) {
        this.b = pVar;
        this.a = kVar;
        this.c = fVar;
        this.d = hVar;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public cn.jiguang.ba.a call() {
        try {
            if (this.c != null) {
                return a(this.c.a(this.a.b()));
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("ConnTask", "run e:" + th);
            return null;
        }
    }

    public cn.jiguang.ba.a a(g gVar) {
        if (this.b.a()) {
            return null;
        }
        h hVar = this.d;
        if (hVar == null || hVar.a) {
            this.b.a(new cn.jiguang.ax.f(-991, null));
            return null;
        } else if (gVar == null) {
            return null;
        } else {
            if (!TextUtils.isEmpty(cn.jiguang.au.a.c)) {
                String str = cn.jiguang.au.a.c;
                gVar.a = str;
                gVar.c = InetAddress.getByName(str);
            }
            int i = cn.jiguang.au.a.d;
            if (i > 0) {
                gVar.b = i;
            }
            cn.jiguang.ar.c.d("ConnTask", "Open connection with ip=" + gVar.c + ", port:" + gVar.b);
            long uptimeMillis = SystemClock.uptimeMillis();
            cn.jiguang.ba.b bVar = new cn.jiguang.ba.b(8128, 20);
            int a = bVar.a(gVar.a, gVar.b);
            if (this.b.a()) {
                cn.jiguang.f.i.a(bVar);
                return null;
            } else if (this.d.a) {
                this.b.a(new cn.jiguang.ax.f(-991, null));
                cn.jiguang.f.i.a(bVar);
                return null;
            } else if (a == 0) {
                cn.jiguang.g.b.a(this.a.a, cn.jiguang.g.a.c((gVar.c instanceof Inet4Address) || cn.jiguang.f.g.f(gVar.a)).a((cn.jiguang.g.a<String>) gVar.toString()));
                cn.jiguang.ar.c.f("ConnTask", "Succeed to open connection - ip:" + gVar.c + ", port:" + gVar.b);
                this.b.a(bVar);
                e.a(this.a.a, gVar, 1, 0L);
                return bVar;
            } else {
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                this.a.a(2, gVar.a, gVar.b, cn.jiguang.d.b.b(this.a.a), uptimeMillis2, a);
                cn.jiguang.ar.c.e("ConnTask", "Failed(" + a + ") to open connection - ip:" + gVar.c + ", port:" + gVar.b + ", cost:" + uptimeMillis2);
                e.a(this.a.a, gVar, -1, uptimeMillis2);
                cn.jiguang.f.i.a(bVar);
                return null;
            }
        }
    }
}
