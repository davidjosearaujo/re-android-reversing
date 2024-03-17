package cn.jpush.android.r;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.r.n;
import cn.jpush.android.s.c;
import com.alibaba.fastjson.JSONStreamContext;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class g implements Handler.Callback, c.a {
    private static Map<String, l> a;
    private q b = new q();
    private Handler c;
    private cn.jpush.android.s.c d;
    private HashMap<Integer, f> e;
    private n f;
    private long g;

    public g() {
        a = new HashMap();
        this.e = new LinkedHashMap();
        this.c = new Handler(Looper.getMainLooper(), this);
    }

    private void a() {
        if (this.f != null) {
            Logger.d("InAppDisplayHelper", "cancel js load timer");
            this.f.a();
        }
    }

    private static void a(Context context, int i, cn.jpush.android.u.e eVar) {
        if (context == null) {
            Logger.d("InAppDisplayHelper", "set layout config failed with context is null.");
            return;
        }
        try {
            DisplayMetrics a2 = cn.jpush.android.ac.i.a(context);
            cn.jpush.android.u.g gVar = new cn.jpush.android.u.g();
            String a3 = cn.jpush.android.u.g.a(i, 1);
            l lVar = null;
            if (a3 != null && a != null) {
                l c = i != 1 ? i != 2 ? i != 3 ? null : gVar.c(context, a2, eVar) : gVar.e(context, a2, eVar) : gVar.a(context, a2, eVar);
                if (c != null) {
                    a.put(a3, c);
                }
            }
            String a4 = cn.jpush.android.u.g.a(i, 2);
            if (a4 == null || a == null) {
                return;
            }
            if (i == 1) {
                lVar = gVar.b(context, a2, eVar);
            } else if (i == 2) {
                lVar = gVar.f(context, a2, eVar);
            } else if (i == 3) {
                lVar = gVar.d(context, a2, eVar);
            }
            if (lVar != null) {
                a.put(a4, lVar);
            }
        } catch (Throwable th) {
            Logger.w("InAppDisplayHelper", "[setInAppLayoutConfig] failed, error: " + th.getMessage());
        }
    }

    public void a(final Context context, final cn.jpush.android.u.e eVar) {
        a();
        this.g = System.currentTimeMillis();
        n nVar = new n();
        this.f = nVar;
        nVar.a(new n.a() { // from class: cn.jpush.android.r.g.3
            {
                g.this = this;
            }

            @Override // cn.jpush.android.r.n.a
            public void a() {
                Logger.ww("InAppDisplayHelper", "js load callback timeout, time: " + (System.currentTimeMillis() - g.this.g));
                g.this.a(context, 1006, eVar, true, new Object[0]);
            }
        }, 10000L, 1000L);
    }

    public void a(Context context, cn.jpush.android.u.e eVar, boolean z) {
        int i;
        try {
            if (!eVar.p() && !cn.jpush.android.ac.a.k(context)) {
                Logger.dd("InAppDisplayHelper", "delay time up, is in background");
                a(context, !z ? 1009 : com.alipay.sdk.app.d.a, eVar, true, new Object[0]);
            } else if (a(context, 1012, eVar, false, new Object[0])) {
                a(context, 1015, eVar, true, new Object[0]);
                Logger.dd("InAppDisplayHelper", "message is intercepted, not to show");
            } else {
                Logger.d("InAppDisplayHelper", "ready to display message");
                if (h.d(context)) {
                    Logger.d("InAppDisplayHelper", "inapp message not display in black page");
                    a(context, 1028, eVar, true, new Object[0]);
                    return;
                }
                if (cn.jpush.android.ac.a.c(context)) {
                    eVar.k();
                }
                Activity a2 = c.a(context);
                int a3 = a2 != null ? this.b.a(a2, this.d, false) : 100;
                JSONObject jSONObject = new JSONObject();
                if (a3 != 0) {
                    a(context, 1015, eVar, true, new Object[0]);
                    Logger.ww("InAppDisplayHelper", "show in app message failed. displayCode: " + a3);
                    i = 1013;
                } else {
                    if (eVar.t()) {
                        String canonicalName = a2.getClass().getCanonicalName();
                        jSONObject.put("activity_name", canonicalName);
                        Logger.d("InAppDisplayHelper", "show in app message success, report activity page name: " + canonicalName);
                    }
                    i = 1014;
                }
                a(context, i, eVar, false, Integer.valueOf(a3), Boolean.FALSE, jSONObject);
                cn.jpush.android.p.a.a(context, "cn.jpush.android.intent.IN_APP_MSG_ARRIVED_INTERVAL", eVar.u(), false);
            }
        } catch (Throwable th) {
            Logger.ww("InAppDisplayHelper", "in app message show failed" + th.getMessage());
            a(context, 1008, eVar, true, new Object[0]);
        }
    }

    public boolean a(Context context, int i, cn.jpush.android.u.e eVar, boolean z, Object... objArr) {
        boolean z2 = true;
        if (eVar != null) {
            int i2 = eVar.u().bn;
            Logger.d("InAppDisplayHelper", "dispatch display action, eventType: " + i + ", inAppType: " + i2 + ", dismiss: " + z);
            f fVar = this.e.get(Integer.valueOf(i2));
            if (fVar != null && i != 1015) {
                z2 = fVar.a(context, i, eVar, objArr).booleanValue();
            }
            if (z && e(context) && fVar != null) {
                fVar.a(context, 1015, eVar, new Object[0]);
            }
        }
        return z2;
    }

    private long b(Context context, cn.jpush.android.u.e eVar) {
        long max = Math.max(System.currentTimeMillis() - c.b(), 0L);
        long max2 = Math.max(eVar.q(), 0);
        Logger.d("InAppDisplayHelper", "stayForeTime: " + max + ", delayDisTime: " + max2);
        if (max2 <= 0 || max >= max2) {
            Logger.d("InAppDisplayHelper", "notify in-app message display directory, stay foreground time: " + max + ", server delay time: " + max2);
            return 0L;
        }
        long j = max2 - max;
        Logger.d("InAppDisplayHelper", "notify in-app message should delay to show, delay time: " + j + ", server delay time: " + max2);
        a(context, 1007, eVar, false, new Object[0]);
        return j;
    }

    private static cn.jpush.android.u.e b(Context context, cn.jpush.android.d.d dVar) {
        if (dVar != null) {
            try {
                Logger.d("InAppDisplayHelper", "start buildAppMessage, message type: " + dVar.aA);
                int i = dVar.aA;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return c(context, dVar);
                    }
                    cn.jpush.android.u.e eVar = new cn.jpush.android.u.e(dVar);
                    a(context, eVar.o(), eVar);
                    return eVar;
                }
                return d(context, dVar);
            } catch (Throwable th) {
                Logger.w("InAppDisplayHelper", "in-app message buildAppMessage failed, " + th.getMessage());
                return null;
            }
        }
        return null;
    }

    private boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    private boolean b(Context context) {
        q qVar = this.b;
        return qVar != null && qVar.a(this.d);
    }

    public static l c(Context context, int i) {
        l lVar = null;
        if (context == null) {
            Logger.d("InAppDisplayHelper", "[getLayoutConfig] context is null");
            return null;
        }
        try {
            if (a != null) {
                int d = d(context);
                if (d < 0) {
                    Logger.d("InAppDisplayHelper", "[getLayoutConfig] get screen orientation failed, curOrientation: " + d);
                    return null;
                }
                l lVar2 = a.get(cn.jpush.android.u.g.a(i, d));
                if (lVar2 == null) {
                    try {
                        Logger.d("InAppDisplayHelper", "get in-app layout config failed, orientation config not exist");
                        return null;
                    } catch (Throwable th) {
                        lVar = lVar2;
                        th = th;
                        Logger.w("InAppDisplayHelper", "[getLayoutConfig] failed. err: " + th.getMessage());
                        return lVar;
                    }
                }
                return lVar2;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static cn.jpush.android.u.e c(Context context, cn.jpush.android.d.d dVar) {
        try {
            cn.jpush.android.u.c a2 = cn.jpush.android.u.c.d().a(dVar.aC).a(dVar.be).b(dVar.aV).a(dVar).a();
            a(context, a2.o(), a2);
            return a2;
        } catch (Throwable th) {
            Logger.w("InAppDisplayHelper", "build banner style message failed, err: " + th.getMessage());
            return null;
        }
    }

    public boolean c(Context context) {
        q qVar = this.b;
        return qVar != null && qVar.b(this.d);
    }

    private static int d(Context context) {
        if (context == null) {
            return -1;
        }
        return context.getResources().getConfiguration().orientation;
    }

    private static cn.jpush.android.u.e d(Context context, cn.jpush.android.d.d dVar) {
        try {
            cn.jpush.android.u.b a2 = cn.jpush.android.u.b.j().a(dVar.aV).b(dVar.aW).c(dVar.aX).a(dVar.aD).d(dVar.bk).e(dVar.bl).c(dVar.aC).b(dVar.aE).a(dVar).a();
            a(context, a2.o(), a2);
            return a2;
        } catch (Throwable th) {
            Logger.w("InAppDisplayHelper", "build banner style message failed, err: " + th.getMessage());
            return null;
        }
    }

    public boolean e(final Context context) {
        try {
            a();
            if (b()) {
                f(context);
                return true;
            }
            Logger.d("InAppDisplayHelper", "dismiss in app change to main thread, curThread: " + Thread.currentThread().getName());
            Handler handler = this.c;
            if (handler != null) {
                handler.post(new cn.jpush.android.ac.e("dismissInApp") { // from class: cn.jpush.android.r.g.4
                    {
                        g.this = this;
                    }

                    @Override // cn.jpush.android.ac.e
                    public void a() {
                        g.this.f(context);
                    }
                });
                return true;
            }
            return true;
        } catch (Throwable th) {
            Logger.w("InAppDisplayHelper", "dismiss in app message failed, " + th.getMessage());
            return false;
        }
    }

    public void f(Context context) {
        q qVar = this.b;
        if (qVar != null) {
            try {
                qVar.a(context, this.d);
                this.d.a((c.a) null);
                this.d = null;
            } catch (Throwable unused) {
            }
            Logger.d("InAppDisplayHelper", "[destroy] windowManager destroy completed. thread: " + Thread.currentThread().getName());
        }
    }

    public void a(int i, f fVar) {
        this.e.put(Integer.valueOf(i), fVar);
    }

    public void a(Context context) {
        if (context == null || this.b == null || this.d == null || !b(context)) {
            return;
        }
        if (!this.b.a()) {
            a(context, 1024, this.d.c(), false, new Object[0]);
            return;
        }
        cn.jpush.android.u.e c = this.d.c();
        c.u = 4;
        a(context, 1015, c, true, new Object[0]);
    }

    public void a(Context context, int i) {
        try {
            if (!c(context)) {
                Logger.d("InAppDisplayHelper", "in app not inflate ready");
                return;
            }
            Handler handler = this.c;
            if (handler == null || !handler.hasMessages(1000)) {
                if (b(context)) {
                    a(context, i == 1 ? 1026 : 1029, this.d.c(), true, new Object[0]);
                    return;
                }
                return;
            }
            Logger.d("InAppDisplayHelper", "in app is in display delaying, drop it");
            this.c.removeMessages(1000);
            a(context, i == 1 ? 1027 : 1029, this.d.c(), true, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    @Override // cn.jpush.android.s.c.a
    public void a(Context context, View view, Object obj) {
        a(context, 1015, obj instanceof cn.jpush.android.u.e ? (cn.jpush.android.u.e) obj : null, true, new Object[0]);
    }

    public void a(final Context context, final cn.jpush.android.u.e eVar, int i) {
        a();
        if (context == null || eVar == null) {
            Logger.w("InAppDisplayHelper", "unexpected param is null, context is " + context + ", message is " + eVar);
            a(JPushConstants.mApplicationContext, 1018, eVar, true, new Object[0]);
        } else if (i != 0) {
            a(context, JSONStreamContext.ArrayValue, eVar, true, Integer.valueOf(i));
        } else {
            Logger.dd("InAppDisplayHelper", "tpl load success will display");
            a(context, JSONStreamContext.StartArray, eVar, false, new Object[0]);
            long b = b(context, eVar);
            if (b <= 0) {
                this.c.post(new cn.jpush.android.ac.e() { // from class: cn.jpush.android.r.g.2
                    {
                        g.this = this;
                    }

                    @Override // cn.jpush.android.ac.e
                    public void a() {
                        g.this.a(context, eVar, false);
                    }
                });
                return;
            }
            if (this.c.hasMessages(1000)) {
                Logger.d("InAppDisplayHelper", "remove delaying message");
                this.c.removeMessages(1000);
            }
            Message message = new Message();
            message.what = 1000;
            message.arg1 = eVar.u().bn;
            message.arg2 = (int) b;
            Bundle bundle = new Bundle();
            bundle.putString("msg_data", eVar.v());
            message.setData(bundle);
            this.c.sendMessageDelayed(message, b);
        }
    }

    public void a(Context context, String str) {
        q qVar;
        if (b(context) && (qVar = this.b) != null && qVar.b(str)) {
            a(context, 1025, this.d.c(), false, new Object[0]);
        }
    }

    public void a(Context context, String str, boolean z, boolean z2) {
        cn.jpush.android.s.c cVar;
        if (!z2) {
            if (c(context) && (cVar = this.d) != null && cVar.c().n().equals(str)) {
                Logger.dd("InAppDisplayHelper", "cancel notify message, msgId: " + str);
                Handler handler = this.c;
                if (handler != null && handler.hasMessages(1000)) {
                    Logger.d("InAppDisplayHelper", "remove delaying message");
                    this.c.removeMessages(1000);
                }
                a(context, 1016, this.d.c(), true, new Object[0]);
                return;
            }
            return;
        }
        q qVar = this.b;
        if (qVar == null || !qVar.a() || !b(context)) {
            if (z) {
                a(context, 1022, this.d.c(), false, new Object[0]);
                return;
            }
            return;
        }
        cn.jpush.android.s.c cVar2 = this.d;
        if (cVar2 == null || !cVar2.c().n().equals(str)) {
            return;
        }
        Logger.dd("InAppDisplayHelper", "cancel alert notify message, msgId: " + str);
        a(context, 1016, this.d.c(), true, new Object[0]);
    }

    public void a(cn.jpush.android.u.e eVar, int i, String str) {
        Context context = JPushConstants.mApplicationContext;
        if (eVar == null) {
            Logger.ww("InAppDisplayHelper", "onclick message is null");
            a(context, 1020, null, true, new Object[0]);
            return;
        }
        int i2 = i != 0 ? 1019 : 1021;
        if (i != 0) {
            cn.jpush.android.p.a.a(context, "cn.jpush.android.intent.IN_APP_MSG_CLICK_INTERVAL", eVar.u(), false);
        }
        a(context, i2, eVar, i != 1, Integer.valueOf(i), str);
    }

    public boolean a(final Context context, cn.jpush.android.d.d dVar) {
        if (context == null || dVar == null) {
            Logger.w("InAppDisplayHelper", "unexpected error, context is null");
            a(JPushConstants.mApplicationContext, 1000, dVar != null ? new cn.jpush.android.u.e(dVar) : null, false, new Object[0]);
            return false;
        }
        Logger.d("InAppDisplayHelper", "inflate message: type: " + dVar.aA + ", showPos: " + dVar.aC + ", messageType: " + dVar.bn);
        final cn.jpush.android.u.e b = b(context, dVar);
        if (b != null) {
            this.c.post(new cn.jpush.android.ac.e("inflateInAppMessage") { // from class: cn.jpush.android.r.g.1
                {
                    g.this = this;
                }

                /* JADX WARN: Removed duplicated region for block: B:35:0x007f  */
                /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
                /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
                /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
                @Override // cn.jpush.android.ac.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void a() {
                    /*
                        r10 = this;
                        cn.jpush.android.r.g r0 = cn.jpush.android.r.g.this
                        android.content.Context r1 = r3
                        boolean r0 = cn.jpush.android.r.g.a(r0, r1)
                        java.lang.String r1 = "InAppDisplayHelper"
                        r2 = 0
                        if (r0 == 0) goto L38
                        cn.jpush.android.r.g r0 = cn.jpush.android.r.g.this
                        cn.jpush.android.s.c r0 = cn.jpush.android.r.g.a(r0)
                        cn.jpush.android.u.e r0 = r0.c()
                        java.lang.String r0 = r0.n()
                        java.lang.String r3 = "has message display now, should override"
                        cn.jpush.android.helper.Logger.w(r1, r3)
                        cn.jpush.android.r.g r4 = cn.jpush.android.r.g.this
                        android.content.Context r5 = r3
                        r6 = 1017(0x3f9, float:1.425E-42)
                        cn.jpush.android.u.e r7 = r4
                        r8 = 0
                        r3 = 1
                        java.lang.Object[] r9 = new java.lang.Object[r3]
                        r9[r2] = r0
                        cn.jpush.android.r.g.a(r4, r5, r6, r7, r8, r9)
                        cn.jpush.android.r.g r0 = cn.jpush.android.r.g.this
                        android.content.Context r3 = r3
                        cn.jpush.android.r.g.b(r0, r3)
                    L38:
                        android.content.Context r0 = r3
                        cn.jpush.android.u.e r3 = r4
                        int r3 = r3.o()
                        cn.jpush.android.r.l r0 = cn.jpush.android.r.g.b(r0, r3)
                        if (r0 == 0) goto L7c
                        cn.jpush.android.r.g r3 = cn.jpush.android.r.g.this
                        cn.jpush.android.u.e r4 = r4
                        cn.jpush.android.s.c r0 = cn.jpush.android.s.d.a(r0, r4)
                        cn.jpush.android.r.g.a(r3, r0)
                        cn.jpush.android.r.g r0 = cn.jpush.android.r.g.this
                        cn.jpush.android.s.c r0 = cn.jpush.android.r.g.a(r0)
                        if (r0 == 0) goto L7c
                        cn.jpush.android.r.g r0 = cn.jpush.android.r.g.this
                        cn.jpush.android.s.c r0 = cn.jpush.android.r.g.a(r0)
                        android.content.Context r3 = r3
                        boolean r0 = r0.d(r3)
                        if (r0 == 0) goto L7d
                        cn.jpush.android.r.g r3 = cn.jpush.android.r.g.this
                        android.content.Context r4 = r3
                        cn.jpush.android.u.e r5 = r4
                        cn.jpush.android.r.g.a(r3, r4, r5)
                        cn.jpush.android.r.g r3 = cn.jpush.android.r.g.this
                        cn.jpush.android.s.c r3 = cn.jpush.android.r.g.a(r3)
                        cn.jpush.android.r.g r4 = cn.jpush.android.r.g.this
                        r3.a(r4)
                        goto L7d
                    L7c:
                        r0 = 0
                    L7d:
                        if (r0 == 0) goto L84
                        r3 = 1003(0x3eb, float:1.406E-42)
                        r6 = 1003(0x3eb, float:1.406E-42)
                        goto L88
                    L84:
                        r3 = 1002(0x3ea, float:1.404E-42)
                        r6 = 1002(0x3ea, float:1.404E-42)
                    L88:
                        if (r0 == 0) goto L8e
                        java.lang.String r0 = "wb inflate success"
                        goto L91
                    L8e:
                        java.lang.String r0 = "wb inflate failed"
                    L91:
                        cn.jpush.android.helper.Logger.dd(r1, r0)
                        cn.jpush.android.r.g r4 = cn.jpush.android.r.g.this
                        android.content.Context r5 = r3
                        cn.jpush.android.u.e r7 = r4
                        r8 = 0
                        java.lang.Object[] r9 = new java.lang.Object[r2]
                        cn.jpush.android.r.g.a(r4, r5, r6, r7, r8, r9)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.r.g.AnonymousClass1.a():void");
                }
            });
            return true;
        }
        Logger.w("InAppDisplayHelper", "in-app message build message failed");
        a(context, 1001, new cn.jpush.android.u.e(dVar), false, new Object[0]);
        return false;
    }

    public void b(Context context, String str) {
        q qVar;
        if (b(context) && (qVar = this.b) != null && qVar.b(str)) {
            a(context, 1023, this.d.c(), false, new Object[0]);
        }
    }

    public void c(Context context, String str) {
        q qVar;
        if (context == null || (qVar = this.b) == null || this.d == null || !qVar.a(str) || !b(context)) {
            return;
        }
        Logger.d("InAppDisplayHelper", "[onActivityDestroyed], to dismiss in app, activityName: " + str);
        cn.jpush.android.u.e c = this.d.c();
        c.u = 3;
        a(context, 1015, c, true, new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x004b  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleMessage(android.os.Message r10) {
        /*
            r9 = this;
            java.lang.String r0 = "InAppDisplayHelper"
            int r1 = r10.what
            r2 = 0
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r1 != r3) goto L5f
            int r1 = r10.arg1
            android.content.Context r4 = cn.jpush.android.local.JPushConstants.mApplicationContext
            r1 = 1
            android.os.Bundle r10 = r10.getData()     // Catch: java.lang.Throwable -> L2f
            if (r10 == 0) goto L2d
            if (r4 == 0) goto L2d
            java.lang.String r3 = "msg_data"
            java.lang.String r10 = r10.getString(r3)     // Catch: java.lang.Throwable -> L2f
            cn.jpush.android.u.e r10 = cn.jpush.android.u.e.a(r10)     // Catch: java.lang.Throwable -> L2f
            if (r10 == 0) goto L2d
            java.lang.String r3 = "message delay up, start to display"
            cn.jpush.android.helper.Logger.d(r0, r3)     // Catch: java.lang.Throwable -> L2b
            r9.a(r4, r10, r1)     // Catch: java.lang.Throwable -> L2b
            goto L49
        L2b:
            r10 = move-exception
            goto L31
        L2d:
            r1 = 0
            goto L49
        L2f:
            r10 = move-exception
            r1 = 0
        L31:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "handle message failed, "
            r3.append(r5)
            java.lang.String r10 = r10.getMessage()
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            cn.jpush.android.helper.Logger.w(r0, r10)
        L49:
            if (r1 != 0) goto L5f
            cn.jpush.android.s.c r10 = r9.d
            if (r10 == 0) goto L54
            cn.jpush.android.u.e r10 = r10.c()
            goto L55
        L54:
            r10 = 0
        L55:
            r6 = r10
            r5 = 1018(0x3fa, float:1.427E-42)
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r2]
            r3 = r9
            r3.a(r4, r5, r6, r7, r8)
        L5f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.r.g.handleMessage(android.os.Message):boolean");
    }
}
