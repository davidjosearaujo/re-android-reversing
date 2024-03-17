package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.data.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.f;
import com.alipay.sdk.util.j;
import com.alipay.sdk.util.l;
import java.util.List;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AuthTask {
    public static final Object c = f.class;
    public Activity a;
    public com.alipay.sdk.widget.a b;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements f.e {
        public a() {
        }

        @Override // com.alipay.sdk.util.f.e
        public void a() {
            AuthTask.this.a();
        }

        @Override // com.alipay.sdk.util.f.e
        public void b() {
        }
    }

    public AuthTask(Activity activity) {
        this.a = activity;
        com.alipay.sdk.sys.b.d().a(this.a);
        this.b = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.k);
    }

    private f.e b() {
        return new a();
    }

    private void c() {
        com.alipay.sdk.widget.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    public synchronized String auth(String str, boolean z) {
        return innerAuth(new com.alipay.sdk.sys.a(this.a, str, com.alipay.sdk.app.statistic.b.n), str, z);
    }

    public synchronized Map<String, String> authV2(String str, boolean z) {
        com.alipay.sdk.sys.a aVar;
        aVar = new com.alipay.sdk.sys.a(this.a, str, "authV2");
        return j.a(aVar, innerAuth(aVar, str, z));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00c0, code lost:
        if (com.alipay.sdk.data.a.v().q() != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00c2, code lost:
        com.alipay.sdk.data.a.v().a(r6, r5.a, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00cb, code lost:
        a();
        com.alipay.sdk.app.statistic.a.b(r5.a, r6, r7, r6.d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x006b, code lost:
        if (com.alipay.sdk.data.a.v().q() == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String innerAuth(com.alipay.sdk.sys.a r6, java.lang.String r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.innerAuth(com.alipay.sdk.sys.a, java.lang.String, boolean):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.alipay.sdk.widget.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(android.app.Activity r4, java.lang.String r5, com.alipay.sdk.sys.a r6) {
        /*
            r3 = this;
            r3.c()
            r0 = 0
            com.alipay.sdk.packet.impl.a r1 = new com.alipay.sdk.packet.impl.a     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r1.<init>()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.packet.b r4 = r1.a(r6, r4, r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            org.json.JSONObject r4 = r4.c()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.lang.String r5 = "form"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.lang.String r5 = "onload"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.util.List r4 = com.alipay.sdk.protocol.b.a(r4)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r3.a()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r5 = 0
        L25:
            int r1 = r4.size()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            if (r5 >= r1) goto L4a
            java.lang.Object r1 = r4.get(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.protocol.b r1 = (com.alipay.sdk.protocol.b) r1     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.protocol.a r1 = r1.a()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.protocol.a r2 = com.alipay.sdk.protocol.a.WapPay     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            if (r1 != r2) goto L47
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.protocol.b r4 = (com.alipay.sdk.protocol.b) r4     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.lang.String r4 = r3.a(r6, r4)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r3.a()
            return r4
        L47:
            int r5 = r5 + 1
            goto L25
        L4a:
            r3.a()
            goto L6b
        L4e:
            r4 = move-exception
            java.lang.String r5 = "biz"
            java.lang.String r1 = "H5AuthDataAnalysisError"
            com.alipay.sdk.app.statistic.a.a(r6, r5, r1, r4)     // Catch: java.lang.Throwable -> L86
            goto L68
        L57:
            r4 = move-exception
            com.alipay.sdk.app.c r5 = com.alipay.sdk.app.c.NETWORK_ERROR     // Catch: java.lang.Throwable -> L86
            int r5 = r5.b()     // Catch: java.lang.Throwable -> L86
            com.alipay.sdk.app.c r5 = com.alipay.sdk.app.c.b(r5)     // Catch: java.lang.Throwable -> L86
            java.lang.String r0 = "net"
            com.alipay.sdk.app.statistic.a.a(r6, r0, r4)     // Catch: java.lang.Throwable -> L86
            r0 = r5
        L68:
            r3.a()
        L6b:
            if (r0 != 0) goto L77
            com.alipay.sdk.app.c r4 = com.alipay.sdk.app.c.FAILED
            int r4 = r4.b()
            com.alipay.sdk.app.c r0 = com.alipay.sdk.app.c.b(r4)
        L77:
            int r4 = r0.b()
            java.lang.String r5 = r0.a()
            java.lang.String r6 = ""
            java.lang.String r4 = com.alipay.sdk.app.b.a(r4, r5, r6)
            return r4
        L86:
            r4 = move-exception
            r3.a()
            goto L8c
        L8b:
            throw r4
        L8c:
            goto L8b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.b(android.app.Activity, java.lang.String, com.alipay.sdk.sys.a):java.lang.String");
    }

    private String a(Activity activity, String str, com.alipay.sdk.sys.a aVar) {
        String a2 = aVar.a(str);
        List<a.b> k = com.alipay.sdk.data.a.v().k();
        if (!com.alipay.sdk.data.a.v().g || k == null) {
            k = com.alipay.sdk.app.a.d;
        }
        if (l.b(aVar, this.a, k)) {
            String a3 = new f(activity, aVar, b()).a(a2);
            if (!TextUtils.equals(a3, f.j) && !TextUtils.equals(a3, f.k)) {
                return TextUtils.isEmpty(a3) ? b.a() : a3;
            }
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.m0);
            return b(activity, a2, aVar);
        }
        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.n0);
        return b(activity, a2, aVar);
    }

    private String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.protocol.b bVar) {
        String[] c2 = bVar.c();
        Bundle bundle = new Bundle();
        bundle.putString("url", c2[0]);
        Intent intent = new Intent(this.a, H5AuthActivity.class);
        intent.putExtras(bundle);
        a.C0030a.a(aVar, intent);
        Activity activity = this.a;
        j.l.c.e0.a.a.a.h(intent);
        activity.startActivity(intent);
        Object obj = c;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException unused) {
                return b.a();
            }
        }
        String d = b.d();
        return TextUtils.isEmpty(d) ? b.a() : d;
    }
}
