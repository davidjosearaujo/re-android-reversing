package com.huawei.hms.push;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: SelfShowType.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class j {
    public static final String[] a = {"url", "app", "cosa", "rp"};
    public Context b;
    public k c;

    public j(Context context, k kVar) {
        this.b = context;
        this.c = kVar;
    }

    public static boolean a(String str) {
        for (String str2 : a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x007a, code lost:
        if (r3 != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ba, code lost:
        if (com.huawei.hms.push.q.a(r6.b, r6.c.d(), r2).booleanValue() != false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5 A[Catch: Exception -> 0x00e4, TryCatch #1 {Exception -> 0x00e4, blocks: (B:44:0x0007, B:46:0x000e, B:48:0x001c, B:67:0x00c1, B:69:0x00c5, B:71:0x00d0, B:73:0x00db, B:72:0x00d6, B:60:0x0097, B:62:0x009f, B:57:0x007e, B:59:0x0085, B:51:0x0044, B:53:0x0059), top: B:80:0x0007, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b() {
        /*
            r6 = this;
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r1 = "run into launchCosaApp"
            com.huawei.hms.support.log.HMSLog.i(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Le4
            r1.<init>()     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = "enter launchExistApp cosa, appPackageName ="
            r1.append(r2)     // Catch: java.lang.Exception -> Le4
            com.huawei.hms.push.k r2 = r6.c     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = r2.d()     // Catch: java.lang.Exception -> Le4
            r1.append(r2)     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = ",and msg.intentUri is "
            r1.append(r2)     // Catch: java.lang.Exception -> Le4
            com.huawei.hms.push.k r2 = r6.c     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = r2.n()     // Catch: java.lang.Exception -> Le4
            r1.append(r2)     // Catch: java.lang.Exception -> Le4
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> Le4
            com.huawei.hms.support.log.HMSLog.i(r0, r1)     // Catch: java.lang.Exception -> Le4
            android.content.Context r1 = r6.b     // Catch: java.lang.Exception -> Le4
            com.huawei.hms.push.k r2 = r6.c     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = r2.d()     // Catch: java.lang.Exception -> Le4
            android.content.Intent r1 = com.huawei.hms.push.q.b(r1, r2)     // Catch: java.lang.Exception -> Le4
            com.huawei.hms.push.k r2 = r6.c     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = r2.n()     // Catch: java.lang.Exception -> Le4
            r3 = 0
            if (r2 == 0) goto L97
            com.huawei.hms.push.k r2 = r6.c     // Catch: java.lang.Exception -> L7d
            java.lang.String r2 = r2.n()     // Catch: java.lang.Exception -> L7d
            android.content.Intent r2 = android.content.Intent.parseUri(r2, r3)     // Catch: java.lang.Exception -> L7d
            r4 = 0
            r2.setSelector(r4)     // Catch: java.lang.Exception -> L7d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L7d
            r4.<init>()     // Catch: java.lang.Exception -> L7d
            java.lang.String r5 = "Intent.parseUri(msg.intentUri, 0), action:"
            r4.append(r5)     // Catch: java.lang.Exception -> L7d
            java.lang.String r5 = r2.getAction()     // Catch: java.lang.Exception -> L7d
            r4.append(r5)     // Catch: java.lang.Exception -> L7d
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L7d
            com.huawei.hms.support.log.HMSLog.i(r0, r4)     // Catch: java.lang.Exception -> L7d
            android.content.Context r4 = r6.b     // Catch: java.lang.Exception -> L7d
            com.huawei.hms.push.k r5 = r6.c     // Catch: java.lang.Exception -> L7d
            java.lang.String r5 = r5.d()     // Catch: java.lang.Exception -> L7d
            java.lang.Boolean r4 = com.huawei.hms.push.q.a(r4, r5, r2)     // Catch: java.lang.Exception -> L7d
            boolean r3 = r4.booleanValue()     // Catch: java.lang.Exception -> L7d
            if (r3 == 0) goto Lbd
            goto Lbc
        L7d:
            r2 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Le4
            r4.<init>()     // Catch: java.lang.Exception -> Le4
            java.lang.String r5 = "intentUri error."
            r4.append(r5)     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Le4
            r4.append(r2)     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Exception -> Le4
            com.huawei.hms.support.log.HMSLog.w(r0, r2)     // Catch: java.lang.Exception -> Le4
            goto Lbd
        L97:
            com.huawei.hms.push.k r2 = r6.c     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = r2.a()     // Catch: java.lang.Exception -> Le4
            if (r2 == 0) goto Lbd
            android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Exception -> Le4
            com.huawei.hms.push.k r4 = r6.c     // Catch: java.lang.Exception -> Le4
            java.lang.String r4 = r4.a()     // Catch: java.lang.Exception -> Le4
            r2.<init>(r4)     // Catch: java.lang.Exception -> Le4
            android.content.Context r4 = r6.b     // Catch: java.lang.Exception -> Le4
            com.huawei.hms.push.k r5 = r6.c     // Catch: java.lang.Exception -> Le4
            java.lang.String r5 = r5.d()     // Catch: java.lang.Exception -> Le4
            java.lang.Boolean r4 = com.huawei.hms.push.q.a(r4, r5, r2)     // Catch: java.lang.Exception -> Le4
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Exception -> Le4
            if (r4 == 0) goto Lbd
        Lbc:
            r1 = r2
        Lbd:
            if (r1 != 0) goto Lc5
            java.lang.String r1 = "launchCosaApp,intent == null"
            com.huawei.hms.support.log.HMSLog.i(r0, r1)     // Catch: java.lang.Exception -> Le4
            return
        Lc5:
            com.huawei.hms.push.k r2 = r6.c     // Catch: java.lang.Exception -> Le4
            java.lang.String r2 = r2.d()     // Catch: java.lang.Exception -> Le4
            r1.setPackage(r2)     // Catch: java.lang.Exception -> Le4
            if (r3 == 0) goto Ld6
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r2)     // Catch: java.lang.Exception -> Le4
            goto Ldb
        Ld6:
            r2 = 805437440(0x30020000, float:4.7293724E-10)
            r1.setFlags(r2)     // Catch: java.lang.Exception -> Le4
        Ldb:
            android.content.Context r2 = r6.b     // Catch: java.lang.Exception -> Le4
            j.l.c.e0.a.a.a.h(r1)     // Catch: java.lang.Exception -> Le4
            r2.startActivity(r1)     // Catch: java.lang.Exception -> Le4
            goto Lfd
        Le4:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "launch Cosa App exception."
            r2.append(r3)
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.huawei.hms.support.log.HMSLog.e(r0, r1)
        Lfd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.j.b():void");
    }

    public void c() {
        k kVar;
        HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.b != null && (kVar = this.c) != null) {
            if ("app".equals(kVar.i())) {
                a();
                return;
            } else if ("cosa".equals(this.c.i())) {
                b();
                return;
            } else if ("rp".equals(this.c.i())) {
                HMSLog.w("PushSelfShowLog", this.c.i() + " not support rich message.");
                return;
            } else if ("url".equals(this.c.i())) {
                HMSLog.w("PushSelfShowLog", this.c.i() + " not support URL.");
                return;
            } else {
                HMSLog.d("PushSelfShowLog", this.c.i() + " is not exist in hShowType");
                return;
            }
        }
        HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
    }

    public final void a() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("enter launchApp, appPackageName =");
            sb.append(this.c.d());
            HMSLog.i("PushSelfShowLog", sb.toString());
            if (q.c(this.b, this.c.d())) {
                b();
            }
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", "launchApp error:" + e.toString());
        }
    }
}
