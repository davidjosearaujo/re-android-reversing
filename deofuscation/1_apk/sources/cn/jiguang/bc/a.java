package cn.jiguang.bc;

import android.content.Context;
import android.os.Build;
import cn.jiguang.ax.e;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.hunantv.media.player.MgtvMediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static volatile a t;
    private static final Object u = new Object();
    private static String v;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    private transient AtomicBoolean s = new AtomicBoolean(false);

    private a(Context context) {
        b(context);
    }

    public static a a(Context context) {
        if (t == null) {
            synchronized (u) {
                if (t == null) {
                    t = new a(context);
                }
            }
        }
        return t;
    }

    private String a(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }

    private void b(Context context) {
        if (this.s.get() || context == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a(Build.VERSION.RELEASE));
        sb.append(",");
        int i = Build.VERSION.SDK_INT;
        sb.append(i);
        this.b = sb.toString();
        if (cn.jiguang.i.a.a().d(CommonConstant.RETCODE.SIGN_IN_AUTH_SERVER_FAILED)) {
            this.c = a(Build.MODEL);
        }
        if (cn.jiguang.i.a.a().d(2001)) {
            this.d = cn.jiguang.f.a.b(context, "gsm.version.baseband", "baseband");
        }
        if (cn.jiguang.i.a.a().d(CommonConstant.RETCODE.INVALID_AT_ERROR)) {
            this.l = a(Build.MANUFACTURER);
        }
        if (cn.jiguang.i.a.a().d(2002)) {
            this.n = a(Build.BRAND);
        }
        if (cn.jiguang.i.a.a().d(2012)) {
            this.h = cn.jiguang.f.a.f(context);
        }
        if (cn.jiguang.i.a.a().d(MgtvMediaPlayer.MainNotifyHandler.MSG_HTTPDNS_REPORT_PV)) {
            this.i = cn.jiguang.f.a.i(context);
        }
        this.j = " ";
        this.e = a(Build.DEVICE);
        this.k = a(Build.PRODUCT);
        this.m = a(Build.FINGERPRINT);
        this.a = c(context);
        this.f = cn.jiguang.d.a.g(context);
        this.g = cn.jiguang.f.a.e(context) ? 1 : 0;
        this.o = cn.jiguang.f.a.f(context, "");
        Object a = e.a(context, "get_imei", null);
        if (a instanceof String) {
            this.p = (String) a;
        }
        this.q = i + "";
        this.r = context.getApplicationInfo().targetSdkVersion + "";
        this.s.set(true);
    }

    private static String c(Context context) {
        if (v == null) {
            try {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                if (str.length() > 30) {
                    str = str.substring(0, 30);
                }
                v = str;
            } catch (Throwable unused) {
                cn.jiguang.ar.c.d("DeviceInfo", "NO versionName defined in manifest.");
            }
        }
        String str2 = v;
        return str2 == null ? "" : str2;
    }
}
