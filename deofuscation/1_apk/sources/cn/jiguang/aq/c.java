package cn.jiguang.aq;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    private static boolean a;
    private static boolean b;
    private static boolean c;
    private static boolean d;
    private static boolean e;
    private static boolean f;
    private static boolean g;
    private static boolean h;
    private static boolean i;
    private static volatile c j;
    private static final Object k = new Object();
    private static AtomicInteger l = new AtomicInteger(0);

    private c() {
        a = d();
        b = e();
        c = f();
        d = g();
        e = h();
        f = j();
        g = i();
        h = k();
        i = l();
    }

    public static c a() {
        if (j == null) {
            j = new c();
        }
        return j;
    }

    private static boolean d() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 1) != 0) {
            cn.jiguang.ar.c.c("JClientsHelper", "p jpush init");
            return a;
        }
        i2 = l.addAndGet(1);
        try {
            Class.forName("cn.jpush.android.api.JPushInterface");
            z = true;
        } catch (ClassNotFoundException e3) {
            e = e3;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJpushSDK:" + e.getMessage());
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJpushSDK:" + z + ", mPluginInitState: " + i2);
            return z;
        }
        cn.jiguang.ar.c.a("JClientsHelper", "isPluginJpushSDK:" + z + ", mPluginInitState: " + i2);
        return z;
    }

    private static boolean e() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 2) != 0) {
            cn.jiguang.ar.c.c("JClientsHelper", "p jmessage init");
            return b;
        }
        int i3 = l.addAndGet(2);
        try {
            Class.forName("cn.jpush.im.android.api.JMessageClient");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJMessageSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJMessageSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.ar.c.a("JClientsHelper", "isPluginJMessageSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    private static boolean f() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 4) != 0) {
            cn.jiguang.ar.c.c("JClientsHelper", "p janalytics init");
            return c;
        }
        int i3 = l.addAndGet(4);
        try {
            Class.forName("cn.jiguang.analytics.android.api.JAnalyticsInterface");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJanalyticsSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJanalyticsSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.ar.c.a("JClientsHelper", "isPluginJanalyticsSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    private static boolean g() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 8) != 0) {
            cn.jiguang.ar.c.c("JClientsHelper", "p jshare init");
            return d;
        }
        int i3 = l.addAndGet(8);
        try {
            Class.forName("cn.jiguang.share.android.api.JShareInterface");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJshareSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJshareSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.ar.c.a("JClientsHelper", "isPluginJshareSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    private static boolean h() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 16) != 0) {
            cn.jiguang.ar.c.c("JClientsHelper", "p jssp init");
            return e;
        }
        int i3 = l.addAndGet(16);
        try {
            Class.forName("cn.jiguang.adsdk.api.JSSPInterface");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJSspSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJSspSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.ar.c.a("JClientsHelper", "isPluginJSspSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    private static boolean i() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 32) != 0) {
            cn.jiguang.ar.c.c("JClientsHelper", "p jcommon init");
            return g;
        }
        int i3 = l.addAndGet(32);
        try {
            Class.forName("cn.jiguang.i.b");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJCommonSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJCommonSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.ar.c.a("JClientsHelper", "isPluginJCommonSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    private static boolean j() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 64) != 0) {
            cn.jiguang.ar.c.c("JClientsHelper", "p jverification init");
            return f;
        }
        int i3 = l.addAndGet(64);
        try {
            Class.forName("cn.jiguang.verifysdk.api.JVerificationInterface");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJVerificationSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJVerificationSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.ar.c.a("JClientsHelper", "isPluginJVerificationSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    private static boolean k() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 128) != 0) {
            cn.jiguang.ar.c.c("JClientsHelper", "p jmlink init");
            return h;
        }
        int i3 = l.addAndGet(128);
        try {
            Class.forName("cn.jiguang.jmlinksdk.core.JMlinkInterfaceImpl");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJMLinkSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJMLinkSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.ar.c.a("JClientsHelper", "isPluginJMLinkSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    private static boolean l() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 256) != 0) {
            cn.jiguang.ar.c.c("JClientsHelper", "p junion init");
            return i;
        }
        int i3 = l.addAndGet(256);
        try {
            Class.forName("cn.jiguang.junion.JUnionInterface");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJUnionSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.ar.c.a("JClientsHelper", "isPluginJUnionSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.ar.c.a("JClientsHelper", "isPluginJUnionSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    public boolean a(Context context) {
        return b || a;
    }

    public boolean b() {
        return b;
    }

    public boolean c() {
        return a;
    }
}
