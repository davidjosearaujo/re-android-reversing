package cn.jiguang.av;

import android.content.Context;
import cn.jiguang.internal.JConstants;
import com.alipay.sdk.app.PayTask;
import com.hunantv.media.player.MgtvMediaPlayer;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.concurrent.Callable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class i implements Callable<l> {
    private LinkedHashSet<g> a = new LinkedHashSet<>();
    private k b;

    public i(k kVar) {
        this.b = kVar;
    }

    private LinkedHashSet<g> a(Context context) {
        LinkedHashSet<g> b = g.b((String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.O()));
        return (b == null || b.isEmpty()) ? g.a(cn.jiguang.au.a.b()) : b;
    }

    private void a(p pVar, f fVar) {
        LinkedHashSet<g> a = g.a(cn.jiguang.au.a.a());
        a.removeAll(this.a);
        LinkedList<g> a2 = cn.jiguang.f.i.a(a);
        cn.jiguang.ar.c.c("Sis", "main sis: sis host=" + a2);
        for (g gVar : a2) {
            if (a(gVar, pVar, fVar)) {
                return;
            }
        }
        g a3 = g.a((String) cn.jiguang.g.b.a(this.b.a, cn.jiguang.g.a.b(true)));
        cn.jiguang.ar.c.c("Sis", "main sis: last good sis v4 address=" + a3);
        if (a(a3, pVar, fVar)) {
            return;
        }
        g a4 = g.a((String) cn.jiguang.g.b.a(this.b.a, cn.jiguang.g.a.b(false)));
        cn.jiguang.ar.c.c("Sis", "main sis: last good sis v6 address=" + a4);
        a(a4, pVar, fVar);
    }

    private boolean a(g gVar, p pVar, f fVar) {
        if (pVar.a()) {
            return true;
        }
        if (gVar != null && gVar.a() && !this.a.contains(gVar)) {
            cn.jiguang.ay.b a = cn.jiguang.ay.b.a();
            k kVar = this.b;
            InetAddress[] b = a.b(kVar.a, gVar.a, PayTask.j, kVar.a());
            if (b != null && b.length != 0) {
                Iterator it = cn.jiguang.f.i.a(Arrays.asList(b)).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    InetAddress inetAddress = (InetAddress) it.next();
                    if (!pVar.a()) {
                        g gVar2 = new g(inetAddress, gVar.b);
                        if (!this.a.contains(gVar2) && fVar.a(gVar2)) {
                            this.a.add(gVar2);
                            pVar.a((Callable<?>) new o(this.b, pVar, fVar));
                            break;
                        }
                    } else {
                        return true;
                    }
                }
                this.a.add(gVar);
            }
        }
        return false;
    }

    private void b(p pVar, f fVar) {
        LinkedHashSet<g> a = a(this.b.a);
        a.removeAll(this.a);
        LinkedList<g> a2 = cn.jiguang.f.i.a(a);
        cn.jiguang.ar.c.c("Sis", "main sis: default sis" + a2);
        for (g gVar : a2) {
            if (a(gVar, pVar, fVar)) {
                return;
            }
        }
        LinkedHashSet<g> a3 = cn.jiguang.aw.l.a().a(cn.jiguang.au.a.c(), 10000L);
        a2.clear();
        if (a3 != null) {
            a3.removeAll(this.a);
            a2 = cn.jiguang.f.i.a(a3);
        }
        cn.jiguang.ar.c.c("Sis", "main sis: sis srv" + a2);
        Iterator it = a2.iterator();
        while (it.hasNext() && !a((g) it.next(), pVar, fVar)) {
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public l call() {
        f fVar = new f();
        p pVar = new p(5, MgtvMediaPlayer.MainNotifyHandler.MSG_HTTPDNS_REPORT_PV, null, "ss");
        a(pVar, fVar);
        cn.jiguang.ar.c.c("Sis", "main sis: after host and last good, wait Result");
        Object a = pVar.a(JConstants.MIN);
        if (a instanceof l) {
            return (l) a;
        }
        b(pVar, fVar);
        cn.jiguang.ar.c.c("Sis", "main sis: after default and srv, wait Result");
        Object a2 = pVar.a(JConstants.MIN);
        pVar.a(false);
        if (a2 instanceof l) {
            return (l) a2;
        }
        return null;
    }
}
