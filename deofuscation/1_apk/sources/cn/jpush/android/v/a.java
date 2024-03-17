package cn.jpush.android.v;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static volatile a a;
    private static final Object e = new Object();
    private Handler b;
    private Context c;
    private String d;

    private a(Context context) {
        this.b = null;
        this.c = null;
        this.d = "";
        Logger.d("JPushLocalNotificationCenter", "Constructor : JPushLocalNotificationCenter");
        this.b = new Handler(Looper.getMainLooper());
        this.c = context;
        this.d = context.getPackageName();
    }

    public static a a(Context context) {
        Logger.v("JPushLocalNotificationCenter", "getInstance");
        if (a == null) {
            synchronized (e) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    private synchronized void a(final long j, long j2, int i) {
        Logger.d("JPushLocalNotificationCenter", "LocalNotification scheduleReadiedLN");
        if (this.b != null) {
            Runnable runnable = new Runnable() { // from class: cn.jpush.android.v.a.2
                {
                    a.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    long a2;
                    int i2;
                    int i3;
                    int i4;
                    String d;
                    long f;
                    long e2;
                    try {
                        b a3 = b.a(a.this.c);
                        c a4 = a3.a(j, 0);
                        if (a4 != null) {
                            if (a4.c() == 1) {
                                Logger.d("JPushLocalNotificationCenter", "remove ");
                                a2 = a4.a();
                                i2 = 0;
                                i3 = 1;
                                i4 = 0;
                                d = a4.d();
                                f = a4.f();
                                e2 = a4.e();
                            } else if (a4.b() > 1) {
                                Logger.d("JPushLocalNotificationCenter", "repeat add");
                                a3.b(a4.a(), a4.b() - 1, 0, 0, a4.d(), a4.f(), a4.e());
                                return;
                            } else if (a4.b() != 1) {
                                Logger.d("JPushLocalNotificationCenter", "already triggered");
                                return;
                            } else {
                                Logger.d("JPushLocalNotificationCenter", "send broadcast");
                                if (a4.f() > System.currentTimeMillis()) {
                                    Logger.d("JPushLocalNotificationCenter", "repeat add");
                                    return;
                                }
                                a aVar = a.this;
                                aVar.a(aVar.c, a4.d());
                                a2 = a4.a();
                                i2 = 0;
                                i3 = 0;
                                i4 = 0;
                                d = a4.d();
                                f = a4.f();
                                e2 = a4.e();
                            }
                            a3.b(a2, i2, i3, i4, d, f, e2);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        Logger.e("JPushLocalNotificationCenter", "exception:" + e3.getMessage());
                    }
                }
            };
            if (j2 <= 0) {
                Logger.d("JPushLocalNotificationCenter", "post right now ");
                this.b.post(runnable);
            } else {
                Logger.d("JPushLocalNotificationCenter", "post delayed : " + j2);
                this.b.postDelayed(runnable, j2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0050 A[Catch: all -> 0x0093, TRY_ENTER, TryCatch #1 {, blocks: (B:50:0x0001, B:62:0x0050, B:63:0x0053, B:76:0x0083, B:77:0x0086, B:78:0x0089, B:74:0x007d, B:79:0x008a), top: B:89:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void e(android.content.Context r15) {
        /*
            r14 = this;
            monitor-enter(r14)
            java.lang.String r0 = "JPushLocalNotificationCenter"
            java.lang.String r1 = "triggerLNKillProcess"
            cn.jpush.android.helper.Logger.d(r0, r1)     // Catch: java.lang.Throwable -> L93
            cn.jpush.android.v.b r0 = cn.jpush.android.v.b.a(r15)     // Catch: java.lang.Throwable -> L93
            r1 = 0
            boolean r2 = r0.a(r1)     // Catch: java.lang.Throwable -> L93
            if (r2 == 0) goto L8a
            r2 = 0
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            r5 = 1
            android.database.Cursor r13 = r0.a(r5, r3)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            boolean r2 = r13.moveToFirst()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            if (r2 == 0) goto L4e
        L24:
            cn.jpush.android.v.c r2 = cn.jpush.android.v.b.a(r13)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            if (r2 == 0) goto L48
            java.lang.String r3 = r2.d()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            r14.a(r15, r3)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            long r3 = r2.a()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = r2.d()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            long r9 = r2.f()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            long r11 = r2.e()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            r2 = r0
            r2.b(r3, r5, r6, r7, r8, r9, r11)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
        L48:
            boolean r2 = r13.moveToNext()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            if (r2 != 0) goto L24
        L4e:
            if (r13 == 0) goto L53
            r13.close()     // Catch: java.lang.Throwable -> L93
        L53:
            r0.b(r1)     // Catch: java.lang.Throwable -> L93
            goto L91
        L57:
            r15 = move-exception
            r2 = r13
            goto L81
        L5a:
            r15 = move-exception
            r2 = r13
            goto L60
        L5d:
            r15 = move-exception
            goto L81
        L5f:
            r15 = move-exception
        L60:
            java.lang.String r3 = "JPushLocalNotificationCenter"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5d
            r4.<init>()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r5 = "triggerLNKillProcess: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r15 = r15.getMessage()     // Catch: java.lang.Throwable -> L5d
            r4.append(r15)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r15 = r4.toString()     // Catch: java.lang.Throwable -> L5d
            cn.jpush.android.helper.Logger.ww(r3, r15)     // Catch: java.lang.Throwable -> L5d
            if (r2 == 0) goto L53
            r2.close()     // Catch: java.lang.Throwable -> L93
            goto L53
        L81:
            if (r2 == 0) goto L86
            r2.close()     // Catch: java.lang.Throwable -> L93
        L86:
            r0.b(r1)     // Catch: java.lang.Throwable -> L93
            throw r15     // Catch: java.lang.Throwable -> L93
        L8a:
            java.lang.String r15 = "JPushLocalNotificationCenter"
            java.lang.String r0 = "init LocalNotification cast expt: db open failed"
            cn.jpush.android.helper.Logger.e(r15, r0)     // Catch: java.lang.Throwable -> L93
        L91:
            monitor-exit(r14)
            return
        L93:
            r15 = move-exception
            monitor-exit(r14)
            goto L97
        L96:
            throw r15
        L97:
            goto L96
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.v.a.e(android.content.Context):void");
    }

    public void a(Context context, String str) {
        Logger.d("JPushLocalNotificationCenter", "start LocalNotification broadCastToPushService");
        Bundle bundle = new Bundle();
        bundle.putString("local_notify_msg", str);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "show_local_notify", bundle);
        Logger.d("JPushLocalNotificationCenter", "end LocalNotification broadCastToPushService");
    }

    public synchronized boolean a(Context context, long j) {
        c a2;
        Logger.dd("JPushLocalNotificationCenter", "remove LocalNotification ");
        long j2 = (int) j;
        try {
            b a3 = b.a(context);
            if (a3.a(j2, 0) != null) {
                Logger.d("JPushLocalNotificationCenter", "remove local count : " + a2.b());
                a3.a(j2);
                JPushInterface.clearNotificationById(this.c, (int) j2);
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            Logger.e("JPushLocalNotificationCenter", "exception:" + e2.getMessage());
            return false;
        }
    }

    public synchronized boolean a(Context context, JPushLocalNotification jPushLocalNotification) {
        Logger.dd("JPushLocalNotificationCenter", "add LocalNotification");
        long currentTimeMillis = System.currentTimeMillis();
        long broadcastTime = jPushLocalNotification.getBroadcastTime() - currentTimeMillis;
        if (cn.jpush.android.cache.a.d(context)) {
            Logger.d("JPushLocalNotificationCenter", "push has stopped");
        }
        long notificationId = jPushLocalNotification.getNotificationId();
        try {
            b a2 = b.a(context);
            if (a2.a(notificationId, 0) != null) {
                a2.b(notificationId, 1, 0, 0, jPushLocalNotification.toJSON(), jPushLocalNotification.getBroadcastTime(), currentTimeMillis);
            } else {
                a2.a(notificationId, 1, 0, 0, jPushLocalNotification.toJSON(), jPushLocalNotification.getBroadcastTime(), currentTimeMillis);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Logger.e("JPushLocalNotificationCenter", "exception:" + e2.getMessage());
        }
        if (broadcastTime < 300000) {
            a(jPushLocalNotification.getNotificationId(), broadcastTime, 0);
            return true;
        }
        return true;
    }

    public synchronized void b(Context context) {
        Logger.dd("JPushLocalNotificationCenter", "clear all local notification ");
        int[] a2 = b.a(context).a();
        if (a2 != null && a2.length > 0) {
            Logger.d("JPushLocalNotificationCenter", " success");
            for (int i : a2) {
                JPushInterface.clearNotificationById(this.c, i);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0042 A[Catch: all -> 0x007a, TRY_ENTER, TryCatch #2 {, blocks: (B:42:0x0001, B:53:0x0042, B:54:0x0045, B:61:0x0064, B:66:0x0071, B:45:0x0014, B:47:0x0025, B:49:0x002b, B:50:0x003a, B:59:0x004c), top: B:76:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void c(android.content.Context r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = "JPushLocalNotificationCenter"
            java.lang.String r1 = "init LocalNotification"
            cn.jpush.android.helper.Logger.d(r0, r1)     // Catch: java.lang.Throwable -> L7a
            cn.jpush.android.v.b r12 = cn.jpush.android.v.b.a(r12)     // Catch: java.lang.Throwable -> L7a
            r0 = 0
            boolean r1 = r12.a(r0)     // Catch: java.lang.Throwable -> L7a
            if (r1 == 0) goto L71
            r1 = 0
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r4 = 300000(0x493e0, double:1.482197E-318)
            android.database.Cursor r1 = r12.a(r2, r4)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            boolean r4 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r4 == 0) goto L40
        L25:
            cn.jpush.android.v.c r4 = cn.jpush.android.v.b.a(r1)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r4 == 0) goto L3a
            long r6 = r4.a()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            long r4 = r4.f()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            long r8 = r4 - r2
            r10 = 0
            r5 = r11
            r5.a(r6, r8, r10)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
        L3a:
            boolean r4 = r1.moveToNext()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r4 != 0) goto L25
        L40:
            if (r1 == 0) goto L45
            r1.close()     // Catch: java.lang.Throwable -> L7a
        L45:
            r12.b(r0)     // Catch: java.lang.Throwable -> L7a
            goto L78
        L49:
            r2 = move-exception
            goto L68
        L4b:
            r2 = move-exception
            java.lang.String r3 = "JPushLocalNotificationCenter"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49
            r4.<init>()     // Catch: java.lang.Throwable -> L49
            java.lang.String r5 = "init LocalNotification cast expt:"
            r4.append(r5)     // Catch: java.lang.Throwable -> L49
            r4.append(r2)     // Catch: java.lang.Throwable -> L49
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L49
            cn.jpush.android.helper.Logger.e(r3, r2)     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L45
            r1.close()     // Catch: java.lang.Throwable -> L7a
            goto L45
        L68:
            if (r1 == 0) goto L6d
            r1.close()     // Catch: java.lang.Throwable -> L7a
        L6d:
            r12.b(r0)     // Catch: java.lang.Throwable -> L7a
            throw r2     // Catch: java.lang.Throwable -> L7a
        L71:
            java.lang.String r12 = "JPushLocalNotificationCenter"
            java.lang.String r0 = "init LocalNotification cast expt: db open failed"
            cn.jpush.android.helper.Logger.e(r12, r0)     // Catch: java.lang.Throwable -> L7a
        L78:
            monitor-exit(r11)
            return
        L7a:
            r12 = move-exception
            monitor-exit(r11)
            goto L7e
        L7d:
            throw r12
        L7e:
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.v.a.c(android.content.Context):void");
    }

    public void d(final Context context) {
        Logger.d("JPushLocalNotificationCenter", "LocalNotification onHeartBeat");
        JCoreHelper.futureExecutor(context, "JPushLocalNotificationCenter", new cn.jpush.android.ac.e("JPushLocationNotificationCenter#onHeartBeat") { // from class: cn.jpush.android.v.a.1
            {
                a.this = this;
            }

            @Override // cn.jpush.android.ac.e
            public void a() {
                a.this.e(context);
                a.this.c(context);
                cn.jpush.android.k.a.c(context);
            }
        });
    }
}
