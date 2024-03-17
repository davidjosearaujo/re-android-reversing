package cn.jiguang.av;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
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
public class j {
    private k b;
    private h c;
    private o f;
    private LinkedHashSet<g> a = new LinkedHashSet<>();
    private p d = new p(5, MgtvMediaPlayer.MainNotifyHandler.MSG_HTTPDNS_REPORT_PV, null, "ssn");
    private f e = new f();

    public j(k kVar) {
        this.b = kVar;
    }

    private void a(LinkedHashSet<g> linkedHashSet) {
        linkedHashSet.removeAll(this.a);
        if (linkedHashSet.isEmpty()) {
            return;
        }
        LinkedHashSet<g> a = e.a(this.b.a, linkedHashSet, 0L);
        cn.jiguang.ar.c.c("SisConn", "connect: last good sis info" + a);
        Iterator<g> it = a.iterator();
        while (it.hasNext() && !a(it.next())) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.LinkedHashSet<cn.jiguang.av.g> r13, long r14) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.av.j.a(java.util.LinkedHashSet, long):void");
    }

    private boolean a() {
        return (a(this.b.a, cn.jiguang.f.h.c(this.b.a)) || cn.jiguang.f.i.a(((Long) cn.jiguang.g.b.a(this.b.a, cn.jiguang.g.a.M())).longValue(), 180000L)) ? false : true;
    }

    private static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String str2 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.F());
        cn.jiguang.ar.c.c("SisConn", "newType=" + str + " last=" + str2);
        return !str.equalsIgnoreCase(str2);
    }

    private boolean a(g gVar) {
        cn.jiguang.ax.f fVar;
        if (!this.c.a) {
            if (this.d.a()) {
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
                        if (!this.c.a) {
                            if (!this.d.a()) {
                                g gVar2 = new g(inetAddress, gVar.b);
                                if (!this.a.contains(gVar2) && this.e.a(gVar2)) {
                                    this.a.add(gVar2);
                                    p pVar = this.d;
                                    pVar.a((Callable<?>) new b(this.b, pVar, this.e, this.c));
                                    break;
                                }
                            } else {
                                return true;
                            }
                        } else {
                            fVar = new cn.jiguang.ax.f(-991, null);
                            break;
                        }
                    }
                    this.a.add(gVar);
                }
            }
            return false;
        }
        fVar = new cn.jiguang.ax.f(-991, null);
        this.d.a(fVar);
        return true;
    }

    private void b() {
        g a = g.a((String) cn.jiguang.g.b.a(this.b.a, cn.jiguang.g.a.c(true)));
        cn.jiguang.ar.c.c("SisConn", "connect: use last good v4 address=" + a);
        if (a(a)) {
            return;
        }
        g a2 = g.a((String) cn.jiguang.g.b.a(this.b.a, cn.jiguang.g.a.c(false)));
        cn.jiguang.ar.c.c("SisConn", "connect: use last good v6 address=" + a2);
        if (a(a2)) {
            return;
        }
        LinkedHashSet<g> c = c();
        if (c != null) {
            c.removeAll(this.a);
        }
        LinkedList a3 = cn.jiguang.f.i.a(c);
        cn.jiguang.ar.c.c("SisConn", "connect: use defaultConn=" + a3);
        Iterator it = a3.iterator();
        while (it.hasNext()) {
            if (a((g) it.next())) {
                return;
            }
        }
        LinkedHashSet<g> a4 = cn.jiguang.aw.l.a().a(cn.jiguang.au.a.b(this.b.a), 10000L);
        a3.clear();
        if (a4 != null) {
            a4.removeAll(this.a);
            a3 = cn.jiguang.f.i.a(a4);
        }
        cn.jiguang.ar.c.c("SisConn", "connect: use srv address" + a3);
        Iterator it2 = a3.iterator();
        while (it2.hasNext() && !a((g) it2.next())) {
        }
    }

    private LinkedHashSet<g> c() {
        String a;
        LinkedList a2;
        try {
            a = cn.jiguang.au.a.a(this.b.a);
            cn.jiguang.ar.c.c("SisConn", "load Default Conn, from host=" + a);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        cn.jiguang.ay.b a3 = cn.jiguang.ay.b.a();
        k kVar = this.b;
        InetAddress[] b = a3.b(kVar.a, a, PayTask.j, kVar.a());
        if (b != null && b.length != 0 && (a2 = cn.jiguang.f.i.a(Arrays.asList(b))) != null && !a2.isEmpty()) {
            String hostAddress = ((InetAddress) a2.get(0)).getHostAddress();
            LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
            linkedHashSet.add(new g(hostAddress, 7000));
            linkedHashSet.add(new g(hostAddress, 7002));
            linkedHashSet.add(new g(hostAddress, 7003));
            linkedHashSet.add(new g(hostAddress, 7004));
            linkedHashSet.add(new g(hostAddress, 7005));
            linkedHashSet.add(new g(hostAddress, 7006));
            linkedHashSet.add(new g(hostAddress, 7007));
            linkedHashSet.add(new g(hostAddress, 7008));
            linkedHashSet.add(new g(hostAddress, 7009));
            return linkedHashSet;
        }
        return null;
    }

    public cn.jiguang.ba.a a(h hVar) {
        this.c = hVar;
        cn.jiguang.ar.c.c("SisConn", "start sisAndConnect...");
        this.e = new f();
        long uptimeMillis = SystemClock.uptimeMillis() + 12000;
        LinkedHashSet<g> b = g.b((String) cn.jiguang.g.b.a(this.b.a, cn.jiguang.g.a.J()));
        boolean z = (b == null || b.isEmpty()) ? false : true;
        boolean a = a();
        if (z && a) {
            a(b);
        }
        l a2 = this.b.a(12000L);
        LinkedHashSet<g> linkedHashSet = a2 != null ? a2.a : null;
        if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
            this.b.a(a2.g);
            a(linkedHashSet, uptimeMillis);
        } else if (z && !a) {
            a(b);
        }
        b();
        cn.jiguang.ar.c.c("SisConn", "wait final result...");
        Object a3 = this.d.a(JConstants.MIN);
        this.d.a(false);
        if (a3 instanceof cn.jiguang.ba.a) {
            cn.jiguang.ar.c.c("SisConn", "connect succeed");
            return (cn.jiguang.ba.a) a3;
        } else if (a3 instanceof Exception) {
            cn.jiguang.ar.c.c("SisConn", "all sis and connect failed, e:" + a3);
            throw ((Exception) a3);
        } else {
            cn.jiguang.ar.c.g("SisConn", "all sis and connect failed:" + a3);
            throw new cn.jiguang.ax.f(1, null);
        }
    }
}
