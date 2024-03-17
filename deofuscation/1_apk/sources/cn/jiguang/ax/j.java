package cn.jiguang.ax;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import cn.jiguang.api.JCoreManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class j {
    private static volatile j a = null;
    private static final Object b = new Object();
    private static long e = 1;
    private cn.jiguang.bb.a d = new cn.jiguang.bb.a() { // from class: cn.jiguang.ax.j.1
        @Override // cn.jiguang.bb.a
        public void a(Message message) {
            long j = message.what - 100000;
            Bundle bundle = new Bundle();
            bundle.putLong("rid", j);
            h.a().a(JCoreManager.getAppContext(null), "tcp_a6", bundle);
        }
    };
    private Map<Long, d> c = new HashMap();

    private j() {
    }

    public static j a() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new j();
                }
            }
        }
        return a;
    }

    private byte[] a(Context context, d dVar) {
        return cn.jiguang.az.b.a(context, dVar.d, dVar.e, dVar.f, dVar.g, 0L);
    }

    public static long b() {
        long j = e + 1;
        e = j;
        if (j >= 2147483647L) {
            e = 1L;
        }
        return e;
    }

    public d a(long j) {
        return this.c.get(Long.valueOf(j));
    }

    public void a(Context context) {
        if (this.c.isEmpty()) {
            cn.jiguang.ar.c.c("TcpRequestManager", "no cache request");
            return;
        }
        for (Map.Entry<Long, d> entry : this.c.entrySet()) {
            if (entry.getValue().j) {
                long nanoTime = System.nanoTime() - entry.getValue().h;
                if (entry.getValue().i - nanoTime >= 10000) {
                    entry.getValue().a();
                    cn.jiguang.ar.c.c("TcpRequestManager", "send again:" + entry.getValue());
                    h.a().c().d().a(a(context, entry.getValue()));
                } else {
                    cn.jiguang.ar.c.c("TcpRequestManager", "shoud not send again by 10000ms,hasRequestTime:" + nanoTime + ",timeout:" + entry.getValue().i);
                }
            }
        }
    }

    public void a(Context context, long j) {
        d remove = this.c.remove(Long.valueOf(j));
        if (remove != null) {
            if (remove.j) {
                cn.jiguang.bb.b.a().b((int) (j + 100000));
            }
            cn.jiguang.ar.c.c("TcpRequestManager", "handle reponse :" + remove);
        }
    }

    public void a(Context context, long j, int i, int i2, byte[] bArr, String str) {
        long c = cn.jiguang.av.c.c(context);
        if (this.c.containsKey(Long.valueOf(c))) {
            cn.jiguang.ar.c.h("TcpRequestManager", "Generator same rid,not do this msg");
            return;
        }
        d dVar = new d(j, str, i, i2, c, 0L, bArr);
        if (h.a().d()) {
            h.a().c().d().a(a(context, dVar));
        }
        this.c.put(Long.valueOf(c), dVar);
    }

    public void a(Context context, long j, int i, int i2, byte[] bArr, String str, long j2) {
        long j3;
        if (i == 10) {
            j3 = j;
        } else {
            long c = cn.jiguang.av.c.c(context);
            cn.jiguang.ar.c.c("TcpRequestManager", "Generator new rid:" + c);
            if (this.c.containsKey(Long.valueOf(c))) {
                cn.jiguang.ar.c.h("TcpRequestManager", "Generator same rid,not do this msg");
                return;
            }
            j3 = c;
        }
        long j4 = j2 <= 0 ? 10000L : j2;
        long j5 = j4;
        d dVar = new d(j, str, i, i2, j3, j4, bArr);
        if (h.a().d()) {
            h.a().c().d().a(a(context, dVar));
        }
        dVar.h = System.nanoTime();
        this.c.put(Long.valueOf(j3), dVar);
        cn.jiguang.bb.b.a().b((int) (j3 + 100000), j5, this.d);
    }

    public void b(Context context, long j) {
        d remove = this.c.remove(Long.valueOf(j));
        if (remove == null) {
            cn.jiguang.ar.c.g("TcpRequestManager", "not found requst by rid:" + j);
            return;
        }
        cn.jiguang.ar.c.c("TcpRequestManager", "request time out:" + remove);
        b.a().a(context, remove.c, remove.b, remove.d);
    }
}
