package cn.jiguang.ad;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private static Context a;
    private static boolean b;
    private static b c;
    private static a d;
    private static Object e = new Object();
    private static HandlerThread f;
    private static Handler g;
    private static String h;
    private static String i;
    private static String j;
    private static String k;

    private b() {
    }

    public static b a(Context context) {
        if (c == null) {
            c = new b();
            a = context;
            f();
            d = new a(a);
            a();
        }
        return c;
    }

    public static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void a() {
        b = "1".equals(a("persist.sys.identifierid.supported", "0"));
    }

    private void b(int i2, String str) {
        Message obtainMessage = g.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString(HiAnalyticsConstant.HaKey.BI_KEY_APPID, str);
        }
        obtainMessage.setData(bundle);
        g.sendMessage(obtainMessage);
    }

    private static void f() {
        HandlerThread handlerThread = new HandlerThread("jg_vvdb_thread");
        f = handlerThread;
        handlerThread.start();
        g = new Handler(f.getLooper()) { // from class: cn.jiguang.ad.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    cn.jiguang.ak.a.a("VivoIdManager", "message type valid");
                    return;
                }
                try {
                    String unused = b.h = b.d.a(message.getData().getInt("type"), message.getData().getString(HiAnalyticsConstant.HaKey.BI_KEY_APPID));
                } catch (Throwable th) {
                    String unused2 = b.h = "";
                    cn.jiguang.ak.a.d("VivoIdManager", "vv getIds, exception" + th.getMessage());
                }
                synchronized (b.e) {
                    b.e.notify();
                }
            }
        };
    }

    public String a(String str) {
        if (b()) {
            String str2 = j;
            if (str2 != null) {
                return str2;
            }
            a(1, str);
            return j;
        }
        return null;
    }

    public void a(int i2, String str) {
        String str2;
        String str3;
        synchronized (e) {
            b(i2, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                e.wait(AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS);
            } catch (InterruptedException e2) {
                cn.jiguang.ak.a.d("VivoIdManager", "lock wait error: " + e2.getMessage());
            }
            if (SystemClock.uptimeMillis() - uptimeMillis < AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS) {
                if (i2 == 0) {
                    i = h;
                } else if (i2 == 1) {
                    String str4 = h;
                    if (str4 == null) {
                        str2 = "VivoIdManager";
                        str3 = "get vaid failed";
                    } else {
                        j = str4;
                    }
                } else if (i2 == 2) {
                    String str5 = h;
                    if (str5 == null) {
                        str2 = "VivoIdManager";
                        str3 = "get aaid failed";
                    } else {
                        k = str5;
                    }
                }
                h = null;
            } else {
                str2 = "VivoIdManager";
                str3 = "query timeout";
            }
            cn.jiguang.ak.a.a(str2, str3);
        }
    }

    public String b(String str) {
        if (b()) {
            String str2 = k;
            if (str2 != null) {
                return str2;
            }
            a(2, str);
            return k;
        }
        return null;
    }

    public boolean b() {
        return b;
    }

    public String c() {
        if (b()) {
            String str = i;
            if (str != null) {
                return str;
            }
            a(0, (String) null);
            return i;
        }
        return null;
    }
}
