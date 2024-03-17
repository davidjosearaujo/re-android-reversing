package cn.jpush.android.b;

import android.content.Context;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.n.e;
import cn.jpush.android.n.f;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    private static d a;
    private static final Object b = new Object();
    private c c;
    private f d;

    private d(Context context) {
        b(context);
    }

    public static d a(Context context) {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    private void b(Context context) {
        if (context == null) {
            Logger.dd("GeofenceManager", "context is null,init failed");
            return;
        }
        e.a().a(context);
        this.c = new a(context);
        this.d = new f(context);
    }

    public void a() {
        this.c.b();
    }

    public void a(int i) {
        e.a().a(i);
    }

    public void a(long j) {
        this.c.a(j);
    }

    public void a(long j, int i, cn.jpush.android.n.d dVar) {
        this.d.a(j, i, dVar);
    }

    public void a(b bVar) {
        Logger.dd("GeofenceManager", "recv geofence...");
        e.a().b(bVar);
    }

    public void a(cn.jpush.android.n.b bVar) {
        this.d.a(bVar);
    }

    public void a(String str) {
        e.a().a(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0061, code lost:
        if (r3 == 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
        if (r3 == 2) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0065, code lost:
        cn.jpush.android.helper.Logger.w("GeofenceManager", "operation " + r1 + " not supported");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
        cn.jpush.android.n.e.a().a(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0087, code lost:
        cn.jpush.android.n.e.a().a(r2, r9, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(org.json.JSONObject r9) {
        /*
            r8 = this;
            java.lang.String r0 = "GeofenceManager"
            java.lang.String r1 = "content"
            org.json.JSONObject r9 = r9.getJSONObject(r1)     // Catch: java.lang.Throwable -> La1
            if (r9 == 0) goto Lb6
            int r1 = r9.length()     // Catch: java.lang.Throwable -> La1
            if (r1 <= 0) goto Lb6
            java.lang.String r1 = "op"
            java.lang.String r1 = r9.optString(r1)     // Catch: java.lang.Throwable -> La1
            java.lang.String r2 = "geofenceid"
            java.lang.String r2 = r9.optString(r2)     // Catch: java.lang.Throwable -> La1
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> La1
            if (r3 != 0) goto L9b
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> La1
            if (r3 == 0) goto L2a
            goto L9b
        L2a:
            r3 = -1
            int r4 = r1.hashCode()     // Catch: java.lang.Throwable -> La1
            r5 = 96417(0x178a1, float:1.35109E-40)
            r6 = 2
            r7 = 1
            if (r4 == r5) goto L56
            r5 = 99339(0x1840b, float:1.39204E-40)
            if (r4 == r5) goto L4c
            r5 = 116009(0x1c529, float:1.62563E-40)
            if (r4 == r5) goto L41
            goto L5f
        L41:
            java.lang.String r4 = "upd"
            boolean r4 = r1.equals(r4)     // Catch: java.lang.Throwable -> La1
            if (r4 == 0) goto L5f
            r3 = 1
            goto L5f
        L4c:
            java.lang.String r4 = "del"
            boolean r4 = r1.equals(r4)     // Catch: java.lang.Throwable -> La1
            if (r4 == 0) goto L5f
            r3 = 2
            goto L5f
        L56:
            java.lang.String r4 = "add"
            boolean r4 = r1.equals(r4)     // Catch: java.lang.Throwable -> La1
            if (r4 == 0) goto L5f
            r3 = 0
        L5f:
            if (r3 == 0) goto L8f
            if (r3 == r7) goto L87
            if (r3 == r6) goto L7f
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La1
            r9.<init>()     // Catch: java.lang.Throwable -> La1
            java.lang.String r2 = "operation "
            r9.append(r2)     // Catch: java.lang.Throwable -> La1
            r9.append(r1)     // Catch: java.lang.Throwable -> La1
            java.lang.String r1 = " not supported"
            r9.append(r1)     // Catch: java.lang.Throwable -> La1
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> La1
            cn.jpush.android.helper.Logger.w(r0, r9)     // Catch: java.lang.Throwable -> La1
            goto Lb6
        L7f:
            cn.jpush.android.n.e r9 = cn.jpush.android.n.e.a()     // Catch: java.lang.Throwable -> La1
            r9.a(r2)     // Catch: java.lang.Throwable -> La1
            goto Lb6
        L87:
            cn.jpush.android.n.e r1 = cn.jpush.android.n.e.a()     // Catch: java.lang.Throwable -> La1
            r1.a(r2, r9, r7)     // Catch: java.lang.Throwable -> La1
            goto Lb6
        L8f:
            cn.jpush.android.b.b r9 = cn.jpush.android.b.b.a(r9)     // Catch: java.lang.Throwable -> La1
            cn.jpush.android.n.e r1 = cn.jpush.android.n.e.a()     // Catch: java.lang.Throwable -> La1
            r1.b(r9)     // Catch: java.lang.Throwable -> La1
            goto Lb6
        L9b:
            java.lang.String r9 = "json error: required key not found"
            cn.jpush.android.helper.Logger.w(r0, r9)     // Catch: java.lang.Throwable -> La1
            return
        La1:
            r9 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "json error:"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            cn.jpush.android.helper.Logger.w(r0, r9)
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.b.d.a(org.json.JSONObject):void");
    }

    public void b() {
        this.c.a();
    }

    public void c() {
        this.d.a();
    }

    public void d() {
        this.d.b();
    }
}
