package cn.jiguang.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.android.IDataShare;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.aq.d;
import cn.jiguang.aq.f;
import cn.jiguang.ar.c;
import cn.jiguang.ax.e;
import cn.jiguang.be.b;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import cn.jpush.android.service.DataShare;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.PushReceiver;
import com.facebook.GraphResponse;
import com.hunantv.media.player.MgtvMediaPlayer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    public static String a = ".permission.JPUSH_MESSAGE";
    public static String b = "2.8.2";
    public static int c = 282;
    public static String d = "";
    public static Boolean e;
    public static Boolean f;
    private static ServiceConnection g = new ServiceConnection() { // from class: cn.jiguang.a.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c.c("JCoreGobal", "action - onServiceConnected, ComponentName:" + componentName);
            c.e("JCoreGobal", "Remote Service bind success.");
            try {
                DataShare.init(IDataShare.Stub.asInterface(iBinder), d.a(JConstants.getAppContext(null)));
                Context context = JConstants.mApplicationContext;
                if (context != null) {
                    JCoreManager.init(context);
                }
            } catch (Throwable th) {
                c.i("JCoreGobal", "onServiceConnected e:" + th);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.c("JCoreGobal", "action - onServiceDisconnected, ComponentName:" + componentName);
        }
    };

    /* renamed from: cn.jiguang.a.a$a  reason: collision with other inner class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class C0001a extends b {
        public Context a;
        public boolean b;
        public String c;
        public Bundle d;

        public C0001a(Context context, boolean z, String str, Bundle bundle) {
            this.a = context;
            this.b = z;
            this.c = str;
            this.d = bundle;
            this.h = "JCoreGlobal";
        }

        @Override // cn.jiguang.be.b
        public void a() {
            String str;
            try {
                if (!this.b) {
                    if (a.a(this.a)) {
                        d.a().a(this.a, this.c, this.d);
                        return;
                    }
                    return;
                }
                if (this.c.equals("a5")) {
                    cn.jiguang.ax.b.a().a(this.a, 2001, 1, "");
                    cn.jiguang.g.b.a(this.a, cn.jiguang.g.a.n().a((cn.jiguang.g.a<Boolean>) Boolean.TRUE));
                    String string = this.d.getString(com.alipay.sdk.sys.a.o);
                    if (TextUtils.isEmpty(string)) {
                        cn.jiguang.ax.b.a().a(this.a, 0, 10003, "appkey is empty");
                        return;
                    }
                    String b = cn.jiguang.aq.a.b(this.a);
                    if (!TextUtils.isEmpty(b) && !b.equals(string)) {
                        cn.jiguang.ax.b.a().a(this.a, 0, 10002, "appkey not same with meta appkey");
                        return;
                    }
                    cn.jiguang.f.a.h(this.a);
                    JConstants.APP_KEY = string;
                    if (cn.jiguang.ax.c.a(this.a)) {
                        str = "tcp_a24";
                    } else {
                        String b2 = cn.jiguang.d.a.b(this.a);
                        if (!TextUtils.isEmpty(b2)) {
                            cn.jiguang.ax.b.a().a(this.a, 2001, 0, b2);
                        }
                        str = "tcp_a1";
                    }
                    this.c = str;
                } else if (this.c.equals("tcp_a23")) {
                    cn.jiguang.ax.b.a().a(this.a, MgtvMediaPlayer.MainNotifyHandler.MSG_HTTPDNS_REPORT_PV, 0, GraphResponse.SUCCESS_KEY);
                } else if (this.c.equals("a6")) {
                    f.a(this.a);
                }
                if (a.b(this.a)) {
                    d.a().b(this.a, this.c, this.d);
                }
            } catch (Throwable th) {
                c.i("JCoreGobal", "do action error:" + th.getMessage());
            }
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        try {
            if (TextUtils.isEmpty(d.b(context)) || !context.getPackageName().equals(cn.jiguang.f.a.a(context))) {
                b(context, str, bundle);
            } else {
                cn.jiguang.be.d.a("SDK_INIT", new C0001a(context, false, str, bundle));
            }
        } catch (Throwable th) {
            c.g("JCoreGobal", "sendToServiceAction failed, " + th.getMessage());
        }
    }

    public static void a(Context context, boolean z, long j) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", z);
            bundle.putLong("delay_time", j);
            a(context, "tcp_a2", bundle);
        } catch (Throwable th) {
            c.h("JCoreGobal", "sendHeartBeat error:" + th);
        }
    }

    public static boolean a() {
        return false;
    }

    public static synchronized boolean a(Context context) {
        synchronized (a.class) {
            Boolean bool = e;
            if (bool != null) {
                return bool.booleanValue();
            } else if (context == null) {
                c.j("JCoreGobal", "init failed,context is null");
                return false;
            } else {
                c.f("JCoreGobal", "action:init jcore,version:" + b + ",build id:89,l:" + JConstants.SDK_VERSION_INT);
                c.c("JCoreGobal", "build type:google_play");
                JConstants.mApplicationContext = context.getApplicationContext();
                Context applicationContext = context.getApplicationContext();
                cn.jiguang.aq.c.a();
                String b2 = d.b(applicationContext);
                if ((cn.jiguang.aq.c.a().c() || cn.jiguang.aq.c.a().b()) && TextUtils.isEmpty(b2)) {
                    e = Boolean.FALSE;
                    c.j("JCoreGobal", "AndroidManifest.xml missing required service:" + JCommonService.class.getCanonicalName() + ",please custom one service and extends JCommonService");
                    return false;
                }
                cn.jiguang.b.d.a().b();
                c(applicationContext);
                e(applicationContext);
                Boolean bool2 = Boolean.TRUE;
                e = bool2;
                return bool2.booleanValue();
            }
        }
    }

    public static void b(Context context, String str, Bundle bundle) {
        cn.jiguang.be.d.a("SDK_SERVICE_INIT", new C0001a(context, true, str, bundle));
    }

    public static synchronized boolean b(Context context) {
        synchronized (a.class) {
            Boolean bool = f;
            if (bool != null) {
                return bool.booleanValue();
            } else if (context == null) {
                c.j("JCoreGobal", "init failed,context is null");
                return false;
            } else {
                c.c("JCoreGobal", "serviceInit...");
                JConstants.mApplicationContext = context.getApplicationContext();
                Context applicationContext = context.getApplicationContext();
                if (cn.jiguang.aq.a.e(applicationContext)) {
                    if (!cn.jiguang.aq.a.f(applicationContext)) {
                        f = Boolean.FALSE;
                        return false;
                    }
                    if (a()) {
                        JCoreInternalHelper.getInstance().onEvent(applicationContext, JConstants.SDK_TYPE, 65, true, "", null, 1);
                    }
                    cn.jiguang.aq.c.a();
                    try {
                        JConstants.isCallInit.set(true);
                    } catch (Throwable unused) {
                    }
                    d(applicationContext);
                    f = Boolean.TRUE;
                    cn.jiguang.b.d.a().e(applicationContext);
                    e.a(applicationContext, "service_create", null);
                    if (Build.VERSION.SDK_INT >= 28) {
                        cn.jiguang.ay.a.a().a(applicationContext);
                    }
                    return f.booleanValue();
                }
                return false;
            }
        }
    }

    private static void c(Context context) {
        String b2 = d.b(context);
        if (TextUtils.isEmpty(b2)) {
            c.e("JCoreGobal", "not found commonServiceClass（JCommonService）");
            return;
        }
        try {
            context.startService(new Intent(context.getApplicationContext(), Class.forName(b2)));
            c.c("JCoreGobal", "start common service");
        } catch (Throwable unused) {
        }
    }

    private static void d(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            PushReceiver pushReceiver = new PushReceiver();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            if (Build.VERSION.SDK_INT < 28) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            context.registerReceiver(pushReceiver, intentFilter, context.getPackageName() + a, null);
            cn.jiguang.f.a.a(context, PushReceiver.class);
        } catch (Throwable th) {
            c.i("JCoreGobal", "registerPushReceiver fail:" + th);
        }
    }

    private static void e(Context context) {
        String str;
        String b2 = d.b(context);
        if (TextUtils.isEmpty(b2)) {
            c.e("JCoreGobal", "not found commonServiceClass（JCommonService）");
        } else if (DataShare.isBinding()) {
            c.c("JCoreGobal", "is binding service");
        } else {
            try {
                Intent intent = new Intent();
                intent.setClass(context, Class.forName(b2));
                if (context.bindService(intent, g, 1)) {
                    c.a("JCoreGobal", "Remote Service on binding...");
                    DataShare.setBinding();
                } else {
                    c.a("JCoreGobal", "Remote Service bind failed");
                }
            } catch (SecurityException unused) {
                str = "Remote Service bind failed caused by SecurityException!";
                c.h("JCoreGobal", str);
            } catch (Throwable th) {
                str = "Remote Service bind failed :" + th;
                c.h("JCoreGobal", str);
            }
        }
    }
}
