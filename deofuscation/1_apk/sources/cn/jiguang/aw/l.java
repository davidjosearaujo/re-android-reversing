package cn.jiguang.aw;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.android.arouter.utils.Consts;
import com.alipay.sdk.app.PayTask;
import com.facebook.soloader.MinElf;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class l {
    private static volatile l a;
    private static final Object b = new Object();
    private long c = 86400000;
    private long d = 1800000;
    private final Map<String, Pair<LinkedHashSet<cn.jiguang.av.g>, Long>> e = new HashMap();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a implements Callable<LinkedHashSet<cn.jiguang.av.g>> {
        private String a;
        private l b;

        public a(String str, l lVar) {
            this.a = str;
            this.b = lVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public LinkedHashSet<cn.jiguang.av.g> call() {
            LinkedHashSet<cn.jiguang.av.g> a = l.a(this.a);
            if (a != null && a.size() > 0) {
                this.b.a(this.a, new Pair(a, Long.valueOf(System.currentTimeMillis())));
            }
            return a;
        }
    }

    private l() {
    }

    private Pair<LinkedHashSet<cn.jiguang.av.g>, Boolean> a(String str, long j, long j2) {
        Object obj;
        Pair<LinkedHashSet<cn.jiguang.av.g>, Long> pair = this.e.get(str);
        boolean z = pair == null || (obj = pair.first) == null || ((LinkedHashSet) obj).size() == 0;
        long longValue = ((Long) (z ? cn.jiguang.g.b.a((Context) null, cn.jiguang.g.a.e(str)) : pair.second)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > longValue + j) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z) {
            String str2 = (String) cn.jiguang.g.b.a((Context) null, cn.jiguang.g.a.d(str));
            if (!TextUtils.isEmpty(str2)) {
                for (String str3 : str2.split(",")) {
                    cn.jiguang.av.g a2 = cn.jiguang.av.g.a(str3);
                    if (a2 != null && a2.a()) {
                        linkedHashSet.add(a2);
                    }
                }
                this.e.put(str, new Pair<>(linkedHashSet, Long.valueOf(System.currentTimeMillis())));
            }
        } else {
            linkedHashSet = (LinkedHashSet) pair.first;
        }
        if (linkedHashSet.isEmpty()) {
            return null;
        }
        return new Pair<>(linkedHashSet, Boolean.valueOf(currentTimeMillis > longValue + j2));
    }

    public static l a() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new l();
                }
            }
        }
        return a;
    }

    public static LinkedHashSet<cn.jiguang.av.g> a(String str) {
        String[] a2;
        e eVar;
        i a3;
        h[] b2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] b3 = b(str);
            cn.jiguang.ar.c.c("SRVLoader", "srv host:" + str);
            LinkedHashSet<cn.jiguang.av.g> linkedHashSet = new LinkedHashSet<>();
            try {
                a2 = k.b().a();
            } catch (Throwable th) {
                cn.jiguang.ar.c.h("SRVLoader", "Get default ports error with Exception:" + th);
            }
            if (a2 != null && a2.length != 0) {
                LinkedHashSet<InetAddress> linkedHashSet2 = new LinkedHashSet();
                cn.jiguang.ay.b a4 = cn.jiguang.ay.b.a();
                for (String str2 : a2) {
                    InetAddress a5 = a4.a((Context) null, str2, PayTask.j, false);
                    if (a5 != null) {
                        linkedHashSet2.add(a5);
                    }
                }
                for (InetAddress inetAddress : linkedHashSet2) {
                    try {
                        eVar = new e(o.a(null, new InetSocketAddress(inetAddress, 53), b3, System.currentTimeMillis() + 1000));
                        a3 = eVar.a();
                    } catch (IOException e) {
                        cn.jiguang.ar.c.g("SRVLoader", "tcp send to " + inetAddress.getHostAddress() + " err:" + e);
                    }
                    if (a3 == null) {
                        break;
                    }
                    for (h hVar : eVar.b(1)) {
                        if (hVar.d() == a3.g() && hVar.c() == a3.e() && hVar.b().equals(a3.d())) {
                            Iterator a6 = hVar.a();
                            while (a6.hasNext()) {
                                m mVar = (m) a6.next();
                                if (mVar.j() > 0) {
                                    String gVar = mVar.k().toString();
                                    if (!TextUtils.isEmpty(gVar)) {
                                        if (gVar.endsWith(Consts.DOT)) {
                                            gVar = gVar.substring(0, gVar.length() - 1);
                                        }
                                        cn.jiguang.av.g gVar2 = new cn.jiguang.av.g(gVar, mVar.j());
                                        if (gVar2.a()) {
                                            linkedHashSet.add(gVar2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return linkedHashSet;
            }
            return linkedHashSet;
        } catch (IOException e2) {
            cn.jiguang.ar.c.g("SRVLoader", "can't srv, create query:" + e2);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str, Pair<LinkedHashSet<cn.jiguang.av.g>, Long> pair) {
        Object obj = pair.first;
        if (obj == null || ((LinkedHashSet) obj).size() <= 0 || pair.second == null) {
            return;
        }
        this.e.put(str, pair);
        StringBuilder sb = new StringBuilder();
        Iterator it = ((LinkedHashSet) pair.first).iterator();
        while (it.hasNext()) {
            sb.append(((cn.jiguang.av.g) it.next()).toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        cn.jiguang.g.b.a((Context) null, cn.jiguang.g.a.d(str).a((cn.jiguang.g.a<String>) sb.toString()), cn.jiguang.g.a.e(str).a((cn.jiguang.g.a<Long>) pair.second));
    }

    private static byte[] b(String str) {
        return e.a(i.a(g.a(g.a(str), g.a), 33, 1)).c(MinElf.PN_XNUM);
    }

    public LinkedHashSet<cn.jiguang.av.g> a(String str, long j) {
        LinkedHashSet<cn.jiguang.av.g> linkedHashSet;
        StringBuilder sb;
        LinkedHashSet<cn.jiguang.av.g> linkedHashSet2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Pair<LinkedHashSet<cn.jiguang.av.g>, Boolean> a2 = a(str, this.c, this.d);
        if (a2 != null) {
            Object obj = a2.first;
            linkedHashSet = (obj == null || ((LinkedHashSet) obj).size() <= 0) ? null : (LinkedHashSet) a2.first;
            if (!((Boolean) a2.second).booleanValue()) {
                return linkedHashSet;
            }
        } else {
            linkedHashSet = null;
        }
        FutureTask futureTask = new FutureTask(new a(str, this));
        cn.jiguang.at.b.d(futureTask, new int[0]);
        if (j == 0) {
            sb = new StringBuilder();
        } else {
            try {
                linkedHashSet2 = (LinkedHashSet) futureTask.get(j, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                cn.jiguang.ar.c.g("SRVLoader", "run futureTask e:" + th);
            }
            if (linkedHashSet2 != null && linkedHashSet2.size() > 0) {
                cn.jiguang.ar.c.c("SRVLoader", "use resolved result=" + linkedHashSet2);
                return linkedHashSet2;
            }
            sb = new StringBuilder();
        }
        sb.append("use cache=");
        sb.append(linkedHashSet);
        cn.jiguang.ar.c.c("SRVLoader", sb.toString());
        return linkedHashSet;
    }
}
