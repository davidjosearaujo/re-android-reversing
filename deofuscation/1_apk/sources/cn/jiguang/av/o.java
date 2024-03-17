package cn.jiguang.av;

import android.content.Context;
import android.os.SystemClock;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class o implements Callable<l> {
    private final k a;
    private final p b;
    private final f c;
    private Set<String> d;
    private g e;

    public o(k kVar, g gVar, Set<String> set) {
        this.a = kVar;
        this.b = null;
        this.c = null;
        this.e = gVar;
        this.d = set;
    }

    public o(k kVar, p pVar, f fVar) {
        this.a = kVar;
        this.b = pVar;
        this.c = fVar;
    }

    private static void a(Context context, l lVar) {
        if (lVar == null || lVar.a()) {
            return;
        }
        String a = g.a(lVar.a);
        String a2 = g.a(lVar.b);
        String c = cn.jiguang.f.h.c(context);
        cn.jiguang.ar.c.c("SisTask", "updateSisInfo ips=" + a + " sslIps=" + a2 + " net=" + c);
        cn.jiguang.g.a[] aVarArr = new cn.jiguang.g.a[8];
        aVarArr[0] = cn.jiguang.g.a.J().a((cn.jiguang.g.a<String>) a);
        aVarArr[1] = cn.jiguang.g.a.K().a((cn.jiguang.g.a<String>) a2);
        aVarArr[2] = cn.jiguang.g.a.d(false).a((cn.jiguang.g.a<String>) g.a(lVar.c));
        aVarArr[3] = cn.jiguang.g.a.d(true).a((cn.jiguang.g.a<String>) g.a(lVar.d));
        aVarArr[4] = cn.jiguang.g.a.O().a((cn.jiguang.g.a<String>) g.a(lVar.e));
        cn.jiguang.g.a<String> R = cn.jiguang.g.a.R();
        JSONObject jSONObject = lVar.f;
        aVarArr[5] = R.a((cn.jiguang.g.a<String>) (jSONObject != null ? jSONObject.toString() : null));
        aVarArr[6] = cn.jiguang.g.a.L().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(lVar.h));
        aVarArr[7] = cn.jiguang.g.a.M().a((cn.jiguang.g.a<Long>) Long.valueOf(SystemClock.elapsedRealtime()));
        cn.jiguang.g.b.a(context, aVarArr);
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.F().a((cn.jiguang.g.a<String>) c));
    }

    private Object[] a(DatagramSocket datagramSocket, InetAddress inetAddress, int i) {
        Object[] objArr = new Object[2];
        objArr[1] = 0;
        try {
            byte[] a = this.a.a(this.d);
            DatagramPacket datagramPacket = new DatagramPacket(a, a.length, inetAddress, i);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                byte[] a2 = c.a(datagramSocket, datagramPacket);
                objArr[1] = Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis);
                try {
                    l lVar = new l(new String(c.a(a2)));
                    if (lVar.a()) {
                        objArr[0] = 6;
                        return objArr;
                    }
                    a(this.a.a, lVar);
                    lVar.g = new g(inetAddress, i);
                    objArr[0] = lVar;
                    return objArr;
                } catch (cn.jiguang.ax.f e) {
                    objArr[0] = Integer.valueOf(e.a());
                    return objArr;
                }
            } catch (Exception unused) {
                objArr[0] = 3;
                objArr[1] = Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis);
                return objArr;
            }
        } catch (cn.jiguang.ax.f e2) {
            objArr[0] = Integer.valueOf(e2.a());
            return objArr;
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public l call() {
        try {
            if (this.c != null) {
                return a(this.c.a(this.a.b()));
            }
            return a(this.e);
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("SisTask", "run e:" + th);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x00f8, code lost:
        if (r5 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cn.jiguang.av.l a(cn.jiguang.av.g r20) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.av.o.a(cn.jiguang.av.g):cn.jiguang.av.l");
    }
}
