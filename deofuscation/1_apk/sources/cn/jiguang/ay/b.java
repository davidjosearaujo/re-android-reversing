package cn.jiguang.ay;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.f.g;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private static volatile b a;
    private static final Object b = new Object();
    private long c = 36000000;
    private long d = 900000;
    private final Map<String, Pair<InetAddress[], Long>> e = new HashMap();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a implements Callable<InetAddress[]> {
        private Context a;
        private String b;
        private b c;

        public a(Context context, String str, b bVar) {
            this.a = context;
            this.b = str;
            this.c = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:74:0x0050  */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.net.InetAddress[] call() {
            /*
                r14 = this;
                java.lang.String r0 = "DNSLoader"
                r1 = 0
                java.lang.String r2 = r14.b     // Catch: java.net.UnknownHostException -> La
                java.net.InetAddress[] r2 = java.net.InetAddress.getAllByName(r2)     // Catch: java.net.UnknownHostException -> La
                goto L20
            La:
                r2 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "dns resolve failed:"
                r3.append(r4)
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                cn.jiguang.ar.c.g(r0, r2)
                r2 = r1
            L20:
                if (r2 == 0) goto Le1
                int r3 = r2.length
                if (r3 <= 0) goto Le1
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                int r5 = r2.length
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
            L34:
                r10 = 1
                if (r7 >= r5) goto L67
                r11 = r2[r7]
                r12 = 3
                if (r8 >= r12) goto L44
                boolean r13 = r11 instanceof java.net.Inet4Address
                if (r13 == 0) goto L44
                int r8 = r8 + 1
            L42:
                r13 = 1
                goto L4e
            L44:
                if (r9 >= r12) goto L4d
                boolean r13 = r11 instanceof java.net.Inet6Address
                if (r13 == 0) goto L4d
                int r9 = r9 + 1
                goto L42
            L4d:
                r13 = 0
            L4e:
                if (r13 == 0) goto L5f
                r3.add(r11)
                java.lang.String r11 = r11.getHostAddress()
                r4.append(r11)
                java.lang.String r11 = ","
                r4.append(r11)
            L5f:
                if (r8 != r12) goto L64
                if (r9 != r12) goto L64
                goto L67
            L64:
                int r7 = r7 + 1
                goto L34
            L67:
                boolean r2 = r3.isEmpty()
                if (r2 != 0) goto Le2
                java.net.InetAddress[] r1 = new java.net.InetAddress[r6]
                java.lang.Object[] r1 = r3.toArray(r1)
                java.net.InetAddress[] r1 = (java.net.InetAddress[]) r1
                long r2 = java.lang.System.currentTimeMillis()
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r7 = "update dns cache url="
                r5.append(r7)
                java.lang.String r7 = r14.b
                r5.append(r7)
                java.lang.String r7 = " resolved="
                r5.append(r7)
                java.lang.String r7 = java.util.Arrays.toString(r1)
                r5.append(r7)
                java.lang.String r5 = r5.toString()
                cn.jiguang.ar.c.c(r0, r5)
                cn.jiguang.ay.b r0 = r14.c
                java.util.Map r0 = cn.jiguang.ay.b.a(r0)
                java.lang.String r5 = r14.b
                android.util.Pair r7 = new android.util.Pair
                java.lang.Long r8 = java.lang.Long.valueOf(r2)
                r7.<init>(r1, r8)
                r0.put(r5, r7)
                int r0 = r4.length()     // Catch: java.lang.Throwable -> Le2
                int r0 = r0 - r10
                r4.deleteCharAt(r0)     // Catch: java.lang.Throwable -> Le2
                android.content.Context r0 = r14.a     // Catch: java.lang.Throwable -> Le2
                r5 = 2
                cn.jiguang.g.a[] r5 = new cn.jiguang.g.a[r5]     // Catch: java.lang.Throwable -> Le2
                java.lang.String r7 = r14.b     // Catch: java.lang.Throwable -> Le2
                cn.jiguang.g.a r7 = cn.jiguang.g.a.b(r7)     // Catch: java.lang.Throwable -> Le2
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Le2
                cn.jiguang.g.a r4 = r7.a(r4)     // Catch: java.lang.Throwable -> Le2
                r5[r6] = r4     // Catch: java.lang.Throwable -> Le2
                java.lang.String r4 = r14.b     // Catch: java.lang.Throwable -> Le2
                cn.jiguang.g.a r4 = cn.jiguang.g.a.c(r4)     // Catch: java.lang.Throwable -> Le2
                java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> Le2
                cn.jiguang.g.a r2 = r4.a(r2)     // Catch: java.lang.Throwable -> Le2
                r5[r10] = r2     // Catch: java.lang.Throwable -> Le2
                cn.jiguang.g.b.a(r0, r5)     // Catch: java.lang.Throwable -> Le2
                goto Le2
            Le1:
                r1 = r2
            Le2:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ay.b.a.call():java.net.InetAddress[]");
        }
    }

    private b() {
    }

    private Pair<InetAddress[], Boolean> a(Context context, String str, long j, long j2) {
        InetAddress[] inetAddressArr;
        Pair<InetAddress[], Long> pair = this.e.get(str);
        boolean z = pair == null || pair.first == null;
        long longValue = ((Long) (z ? cn.jiguang.g.b.a(context, cn.jiguang.g.a.c(str)) : pair.second)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > longValue + j) {
            return null;
        }
        if (z) {
            inetAddressArr = a(context, str);
            if (inetAddressArr != null) {
                this.e.put(str, new Pair<>(inetAddressArr, Long.valueOf(longValue)));
            }
        } else {
            inetAddressArr = (InetAddress[]) pair.first;
        }
        if (inetAddressArr != null) {
            return new Pair<>(inetAddressArr, Boolean.valueOf(currentTimeMillis > longValue + j2));
        }
        return null;
    }

    public static b a() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    private InetAddress a(String str) {
        if (g.f(str) || g.g(str)) {
            try {
                return InetAddress.getByName(str);
            } catch (UnknownHostException e) {
                cn.jiguang.ar.c.g("DNSLoader", "dns resolve failed:" + e);
            }
        }
        return null;
    }

    private InetAddress[] a(Context context, String str) {
        String str2 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.b(str));
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String[] split = str2.split(",");
        LinkedList linkedList = new LinkedList();
        for (String str3 : split) {
            InetAddress a2 = a(str3);
            if (a2 != null) {
                linkedList.add(a2);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        return (InetAddress[]) linkedList.toArray(new InetAddress[0]);
    }

    public InetAddress a(Context context, String str, long j, boolean z) {
        InetAddress[] b2 = b(context, str, j, z);
        if (b2 == null || b2.length <= 0) {
            return null;
        }
        return b2[0];
    }

    public InetAddress[] b(Context context, String str, long j, boolean z) {
        InetAddress[] inetAddressArr;
        StringBuilder sb;
        String arrays;
        InetAddress[] inetAddressArr2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        InetAddress a2 = a(str);
        if (a2 != null) {
            return new InetAddress[]{a2};
        }
        Pair<InetAddress[], Boolean> a3 = a(context, str, this.c, this.d);
        if (a3 != null) {
            Object obj = a3.first;
            inetAddressArr = obj != null ? (InetAddress[]) obj : null;
            if (!((Boolean) a3.second).booleanValue()) {
                if (z) {
                    cn.jiguang.at.b.d(new FutureTask(new a(context, str, this)), new int[0]);
                }
                sb = new StringBuilder();
                sb.append("use cache=");
                arrays = Arrays.toString(inetAddressArr);
                sb.append(arrays);
                cn.jiguang.ar.c.c("DNSLoader", sb.toString());
                return inetAddressArr;
            }
        } else {
            inetAddressArr = null;
        }
        FutureTask futureTask = new FutureTask(new a(context, str, this));
        cn.jiguang.at.b.d(futureTask, new int[0]);
        if (j == 0) {
            sb = new StringBuilder();
        } else {
            try {
                cn.jiguang.ar.c.c("DNSLoader", "waiting dns for " + str);
                inetAddressArr2 = (InetAddress[]) futureTask.get(j, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                cn.jiguang.ar.c.g("DNSLoader", "run futureTask e:" + th);
            }
            if (inetAddressArr2 != null) {
                cn.jiguang.ar.c.c("DNSLoader", "use resolved result=" + Arrays.toString(inetAddressArr2));
                return inetAddressArr2;
            }
            sb = new StringBuilder();
        }
        sb.append("use cache=");
        arrays = Arrays.toString(inetAddressArr);
        sb.append(arrays);
        cn.jiguang.ar.c.c("DNSLoader", sb.toString());
        return inetAddressArr;
    }
}
