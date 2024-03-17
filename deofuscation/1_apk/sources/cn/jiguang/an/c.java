package cn.jiguang.an;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0016, code lost:
        if (r1 == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0018, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0030, code lost:
        if (r8 != r1) goto L4;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r9) {
        /*
            java.lang.String r0 = cn.jiguang.n.b.c(r9)
            boolean r1 = cn.jiguang.n.b.b(r9)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r3 = "OFF"
            java.lang.String r4 = "ON"
            r5 = 0
            java.lang.String r6 = "JWakeLocalState"
            r7 = 1
            if (r2 == 0) goto L1a
            if (r1 != 0) goto L39
        L18:
            r5 = 1
            goto L39
        L1a:
            boolean r2 = android.text.TextUtils.equals(r4, r0)
            if (r2 == 0) goto L23
            r2 = 0
        L21:
            r8 = 1
            goto L2e
        L23:
            boolean r2 = android.text.TextUtils.equals(r3, r0)
            if (r2 == 0) goto L2c
            r2 = 0
            r8 = 0
            goto L2e
        L2c:
            r2 = 1
            goto L21
        L2e:
            if (r2 != 0) goto L33
            if (r8 == r1) goto L39
            goto L18
        L33:
            java.lang.String r5 = "local wake state do not changed"
            cn.jiguang.ak.a.a(r6, r5)
            r5 = r2
        L39:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = "lastCacheWakeState:"
            r2.append(r8)
            r2.append(r0)
            java.lang.String r0 = ",userWakeupEnable:"
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = ",isNeedReport:"
            r2.append(r0)
            r2.append(r5)
            java.lang.String r0 = r2.toString()
            cn.jiguang.ak.a.a(r6, r0)
            if (r5 == 0) goto L97
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L7d
            r0.<init>()     // Catch: java.lang.Throwable -> L7d
            java.lang.String r2 = "status"
            if (r1 == 0) goto L6a
            goto L6b
        L6a:
            r7 = 2
        L6b:
            r0.put(r2, r7)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r2 = "aals"
            cn.jiguang.n.d.a(r9, r0, r2)     // Catch: java.lang.Throwable -> L7d
            cn.jiguang.n.d.a(r9, r0)     // Catch: java.lang.Throwable -> L7d
            if (r1 == 0) goto L79
            r3 = r4
        L79:
            cn.jiguang.n.b.o(r9, r3)     // Catch: java.lang.Throwable -> L7d
            goto L9c
        L7d:
            r9 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "report local wake state failed, error:"
            r0.append(r1)
            java.lang.String r9 = r9.getMessage()
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            cn.jiguang.ak.a.d(r6, r9)
            goto L9c
        L97:
            java.lang.String r9 = "do not need report local wake state"
            cn.jiguang.ak.a.a(r6, r9)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.an.c.a(android.content.Context):void");
    }
}
