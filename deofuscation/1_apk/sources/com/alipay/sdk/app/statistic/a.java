package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.packet.impl.d;
import com.alipay.sdk.packet.impl.e;
import com.alipay.sdk.util.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {

    /* renamed from: com.alipay.sdk.app.statistic.a$a */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class C0024a {
        public static final String a = "RecordPref";
        public static final String b = "alipay_cashier_statistic_record";

        public static synchronized String a(Context context, String str, String str2) {
            synchronized (C0024a.class) {
                com.alipay.sdk.util.c.b(a, "stat append " + str2 + " , " + str);
                if (context != null && !TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = UUID.randomUUID().toString();
                    }
                    C0025a a2 = a(context);
                    if (a2.a.size() > 20) {
                        a2.a.clear();
                    }
                    a2.a.put(str2, str);
                    a(context, a2);
                    return str2;
                }
                return null;
            }
        }

        public static synchronized String b(Context context) {
            synchronized (C0024a.class) {
                com.alipay.sdk.util.c.b(a, "stat peek");
                if (context == null) {
                    return null;
                }
                C0025a a2 = a(context);
                if (a2.a.isEmpty()) {
                    return null;
                }
                return a2.a.entrySet().iterator().next().getValue();
            }
        }

        /* renamed from: com.alipay.sdk.app.statistic.a$a$a */
        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static final class C0025a {
            public final LinkedHashMap<String, String> a = new LinkedHashMap<>();

            public C0025a() {
            }

            public String a() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, String> entry : this.a.entrySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(entry.getKey()).put(entry.getValue());
                        jSONArray.put(jSONArray2);
                    }
                    return jSONArray.toString();
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                    return new JSONArray().toString();
                }
            }

            public C0025a(String str) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        this.a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                }
            }
        }

        public static synchronized int a(Context context, String str) {
            synchronized (C0024a.class) {
                com.alipay.sdk.util.c.b(a, "stat remove " + str);
                if (context != null && !TextUtils.isEmpty(str)) {
                    C0025a a2 = a(context);
                    if (a2.a.isEmpty()) {
                        return 0;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, String> entry : a2.a.entrySet()) {
                        if (str.equals(entry.getValue())) {
                            arrayList.add(entry.getKey());
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.a.remove((String) it.next());
                    }
                    a(context, a2);
                    return arrayList.size();
                }
                return 0;
            }
        }

        public static synchronized C0025a a(Context context) {
            synchronized (C0024a.class) {
                try {
                    String a2 = h.a(null, context, b, null);
                    if (TextUtils.isEmpty(a2)) {
                        return new C0025a();
                    }
                    return new C0025a(a2);
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                    return new C0025a();
                }
            }
        }

        public static synchronized void a(Context context, C0025a c0025a) {
            synchronized (C0024a.class) {
                if (c0025a == null) {
                    try {
                        c0025a = new C0025a();
                    } catch (Throwable th) {
                        com.alipay.sdk.util.c.a(th);
                    }
                }
                h.b(null, context, b, c0025a.a());
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class b {

        /* renamed from: com.alipay.sdk.app.statistic.a$b$a */
        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class RunnableC0026a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ Context b;

            public RunnableC0026a(String str, Context context) {
                this.a = str;
                this.b = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.a) || b.b(this.b, this.a)) {
                    for (int i = 0; i < 4; i++) {
                        String b = C0024a.b(this.b);
                        if (TextUtils.isEmpty(b) || !b.b(this.b, b)) {
                            return;
                        }
                    }
                }
            }
        }

        public static synchronized boolean b(Context context, String str) {
            synchronized (b.class) {
                com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "stat sub " + str);
                if ((com.alipay.sdk.data.a.v().d() ? new d() : new e()).a((com.alipay.sdk.sys.a) null, context, str) != null) {
                    C0024a.a(context, str);
                    return true;
                }
                return false;
            }
        }

        public static synchronized void a(Context context, com.alipay.sdk.app.statistic.b bVar, String str, String str2) {
            synchronized (b.class) {
                if (context == null || bVar == null || str == null) {
                    return;
                }
                a(context, bVar.a(str), str2);
            }
        }

        public static synchronized void a(Context context) {
            synchronized (b.class) {
                a(context, null, null);
            }
        }

        public static synchronized void a(Context context, String str, String str2) {
            synchronized (b.class) {
                if (context == null) {
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    C0024a.a(context, str, str2);
                }
                new Thread(new RunnableC0026a(str, context)).start();
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class c {
        public static final String a = "alipay_cashier_statistic_v";

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:39:0x0025
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
            */
        public static synchronized long a(android.content.Context r6) {
            /*
                java.lang.Class<com.alipay.sdk.app.statistic.a$c> r0 = com.alipay.sdk.app.statistic.a.c.class
                monitor-enter(r0)
                r1 = 0
                java.lang.String r2 = "alipay_cashier_statistic_v"
                java.lang.String r2 = com.alipay.sdk.util.h.a(r1, r6, r2, r1)     // Catch: java.lang.Throwable -> L15
                boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L15
                if (r3 != 0) goto L15
                long r2 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> L15
                goto L17
            L15:
                r2 = 0
            L17:
                r4 = 1
                long r2 = r2 + r4
                java.lang.String r4 = "alipay_cashier_statistic_v"
                java.lang.String r5 = java.lang.Long.toString(r2)     // Catch: java.lang.Throwable -> L23
                com.alipay.sdk.util.h.b(r1, r6, r4, r5)     // Catch: java.lang.Throwable -> L23
            L23:
                monitor-exit(r0)
                return r2
            L25:
                r6 = move-exception
                monitor-exit(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.statistic.a.c.a(android.content.Context):long");
        }
    }

    public static synchronized void a(Context context, com.alipay.sdk.sys.a aVar, String str, String str2) {
        synchronized (a.class) {
            if (context == null || aVar == null) {
                return;
            }
            try {
                C0024a.a(context, aVar.i.a(str), str2);
            } catch (Throwable th) {
                com.alipay.sdk.util.c.a(th);
            }
        }
    }

    public static synchronized void b(Context context, com.alipay.sdk.sys.a aVar, String str, String str2) {
        synchronized (a.class) {
            if (context == null || aVar == null) {
                return;
            }
            b.a(context, aVar.i, str, str2);
        }
    }

    public static void b(com.alipay.sdk.sys.a aVar, String str, String str2, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.i.b(str, str2, str3);
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            b.a(context);
        }
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, Throwable th) {
        if (aVar == null || th == null || th.getClass() == null) {
            return;
        }
        aVar.i.a(str, th.getClass().getSimpleName(), th);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2, Throwable th, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.i.a(str, str2, th, str3);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2, Throwable th) {
        if (aVar == null) {
            return;
        }
        aVar.i.a(str, str2, th);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.i.a(str, str2, str3);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2) {
        if (aVar == null) {
            return;
        }
        aVar.i.a(str, str2);
    }
}
