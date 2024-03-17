package cn.jiguang.an;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.n.e;
import cn.jiguang.r.f;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a extends e {
    private Context a;
    private cn.jiguang.ao.a c;
    private String d;

    /* renamed from: cn.jiguang.an.a$a  reason: collision with other inner class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class C0004a extends e {
        private Context a;

        public C0004a(Context context) {
            this.a = context;
            this.b = "JWake#RequestConfigAction";
        }

        @Override // cn.jiguang.n.e
        public void a() {
            a.d(this.a);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class b implements ServiceConnection {
        private Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                cn.jiguang.ak.a.a("JWake", "unbind wake ServiceConnection");
                this.a.getApplicationContext().unbindService(this);
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JWake", "onServiceConnected throwable" + th.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public a(Context context, String str) {
        this.a = context;
        this.d = str;
        this.b = "JWake";
    }

    public static Object a(Context context, Object obj) {
        if (obj instanceof List) {
            return cn.jiguang.ap.c.a(cn.jiguang.ap.b.b(context), (List) obj);
        }
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x015f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<cn.jiguang.ao.b> a(android.content.Context r23, java.util.List<cn.jiguang.ao.c> r24) {
        /*
            Method dump skipped, instructions count: 837
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.an.a.a(android.content.Context, java.util.List):java.util.List");
    }

    public static void a(Context context) {
        try {
            cn.jiguang.n.d.a(new C0004a(context));
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWake", "[requestConfig failed] " + th.getMessage());
        }
    }

    private static void a(Context context, cn.jiguang.ao.a aVar) {
        boolean z = true;
        boolean z2 = aVar.b && aVar.d;
        if (!aVar.e) {
            z2 = (z2 && cn.jiguang.n.b.b(context)) ? false : false;
        }
        cn.jiguang.ap.a.a(context, z2);
    }

    public static void a(Context context, String str) {
        try {
            cn.jiguang.n.d.a(new a(context, str));
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWake", "[doAction failed] " + str + " :" + th.getMessage());
        }
    }

    private static boolean a(Context context, Bundle bundle, Intent intent) {
        String str;
        try {
            if (intent == null) {
                cn.jiguang.ak.a.d("JWake", "Fail to start activity ,activityIntent is null !!");
                return false;
            }
            intent.addFlags(276824064);
            intent.putExtras(bundle);
            j.l.c.e0.a.a.a.h(intent);
            context.startActivity(intent);
            if (intent.getComponent() != null) {
                String className = intent.getComponent().getClassName();
                if (!"cn.jpush.android.service.DActivity".equals(className) && !"cn.jpush.android.service.BActivity".equals(className)) {
                    str = "JWake_activity";
                    cn.jiguang.n.b.e(context, str);
                    return true;
                }
                str = "JWake_dactivity";
                cn.jiguang.n.b.e(context, str);
                return true;
            }
            return true;
        } catch (Throwable th) {
            cn.jiguang.ak.a.a("JWake", "Fail to start activity caused by:" + th);
            return false;
        }
    }

    private boolean a(Intent intent, String str, boolean z) {
        return cn.jiguang.ap.a.a(this.a, str, intent, z);
    }

    private boolean a(String str) {
        StringBuilder sb;
        String str2;
        List<String> list = this.c.p;
        if (list != null && list.contains(str)) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = " is in black list";
        } else if (TextUtils.isEmpty(this.c.n)) {
            return false;
        } else {
            if (this.c.n.equals("exclude")) {
                if (!this.c.o.contains(str)) {
                    return false;
                }
                sb = new StringBuilder();
                sb.append(str);
                str2 = " is in excloude list";
            } else if (!this.c.n.equals("include") || this.c.o.contains(str)) {
                return false;
            } else {
                sb = new StringBuilder();
                sb.append(str);
                str2 = " is not in include list";
            }
        }
        sb.append(str2);
        cn.jiguang.ak.a.a("JWake", sb.toString());
        return true;
    }

    private boolean a(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (String str : list) {
                        if (cn.jiguang.f.a.h(this.a, str)) {
                            cn.jiguang.ak.a.a("JWake", "checkSafeStatus blackPkgName = " + str);
                            return false;
                        }
                    }
                    return true;
                }
                return true;
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JWake", "checkSafeStatus error:" + th);
                return true;
            }
        }
        return true;
    }

    public static Object b(Context context) {
        boolean z = cn.jiguang.ap.b.b(context).e || cn.jiguang.n.b.b(context);
        cn.jiguang.ak.a.a("JWake", "isActionUserEnable :" + z);
        return Boolean.valueOf(z);
    }

    private boolean b() {
        boolean z = this.c.e || cn.jiguang.n.b.b(this.a);
        cn.jiguang.ak.a.a("JWake", "isActionUserEnable :" + z);
        return z;
    }

    private void c() {
        long j = this.c.l;
        long f = cn.jiguang.n.b.f(this.a, "JWakeConfigHelper");
        long currentTimeMillis = System.currentTimeMillis();
        cn.jiguang.ak.a.a("JWake", "[refeshWakeConfig] currentTimeMillis:" + currentTimeMillis + ",lastBusinessTime:" + f + ",wakeConfigInterval:" + j);
        if (currentTimeMillis - f < j) {
            cn.jiguang.ak.a.a("JWake", "need not get wake config");
            return;
        }
        cn.jiguang.ao.a d = d(this.a);
        if (d != null) {
            this.c = d;
        }
        c.a(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static cn.jiguang.ao.a d(Context context) {
        try {
            JSONObject a = cn.jiguang.ap.b.a(context);
            if (a != null) {
                cn.jiguang.ap.b.a(context, f.b(a.toString()));
                return cn.jiguang.ap.b.a(context, a);
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWake", "[requestConfigNow] failed:" + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0195 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<cn.jiguang.ao.c> d() {
        /*
            Method dump skipped, instructions count: 681
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.an.a.d():java.util.List");
    }

    @Override // cn.jiguang.n.e
    public void a() {
        try {
            cn.jiguang.ak.a.a("JWake", "wake with:" + this.d);
            if (!cn.jiguang.n.d.e(this.a)) {
                cn.jiguang.ak.a.d("JWake", "can't wake because not registered yet");
                return;
            }
            this.c = cn.jiguang.ap.b.b(this.a);
            c();
            cn.jiguang.ak.a.a("JWake", "use config:" + this.c);
            a(this.a, this.c);
            if (!b()) {
                cn.jiguang.ak.a.a("JWake", "wake is disabled by user");
                return;
            }
            cn.jiguang.ao.a aVar = this.c;
            if (aVar.a && aVar.c) {
                if (!a(aVar.w)) {
                    cn.jiguang.ak.a.a("JWake", "wake is disabled by unsafe package");
                    return;
                }
                cn.jiguang.ao.a aVar2 = this.c;
                if (aVar2.v == 7) {
                    cn.jiguang.ak.a.a("JWake", "all wakeup type is unsupported of app, not wakeup any package");
                    return;
                } else if (aVar2.i && this.d.equals("start")) {
                    cn.jiguang.ap.c.a(this.a, this.c, a(this.a, d()));
                    return;
                } else if (!this.c.h) {
                    cn.jiguang.ak.a.a("JWake", "time disabled");
                    return;
                } else {
                    long f = cn.jiguang.n.b.f(this.a, "JWake");
                    long j = this.c.g;
                    long currentTimeMillis = System.currentTimeMillis();
                    cn.jiguang.ak.a.a("JWake", "[wakeUp]currentTimeMillis:" + currentTimeMillis + ",lastBusinessTime:" + f + ",wakeInterval:" + j);
                    if (currentTimeMillis - f < j) {
                        cn.jiguang.ak.a.a("JWake", "need not wake up");
                        return;
                    }
                    cn.jiguang.ap.c.a(this.a, this.c, a(this.a, d()));
                    return;
                }
            }
            cn.jiguang.ak.a.a("JWake", "wake is disabled by server");
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWake", "wake failed:" + th.getMessage());
        }
    }
}
