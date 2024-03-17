package cn.jiguang.x;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import cn.jiguang.n.d;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.reflect.Method;

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

    public static void a() {
        Context context = null;
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
            method.setAccessible(true);
            context = (Context) method.invoke(null, new Object[0]);
        } catch (Exception e2) {
            cn.jiguang.ak.a.d("MeizuIdManager", "ActivityThread:currentApplication --> " + e2.toString());
        }
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            String g2 = d.g("rIjLIWp9yd1+l2BByOWYjPjGCBlvF2tDounrABnhodw=");
            if (packageManager != null && packageManager.resolveContentProvider(g2, 0) != null) {
                try {
                    Cursor query = context.getContentResolver().query(Uri.parse(d.g("SyfFpc71r1BITMlIo0m1Vt2cR3sdiPGnMd0WMSsF4yU8+J95KN/jHVtZShu2ONYO")), null, null, new String[]{"supported"}, null);
                    if (query != null) {
                        query.moveToFirst();
                        int columnIndex = query.getColumnIndex(SDKConstants.PARAM_VALUE);
                        if (columnIndex >= 0) {
                            b = "0".equals(query.getString(columnIndex));
                        } else {
                            b = false;
                        }
                        query.close();
                    }
                } catch (Throwable unused) {
                    cn.jiguang.ak.a.a("MeizuIdManager", "mz not support");
                }
                cn.jiguang.ak.a.a("MeizuIdManager", "check meizu supported:" + b);
            }
        }
        b = false;
        cn.jiguang.ak.a.a("MeizuIdManager", "check meizu supported:" + b);
    }

    private void b(int i2) {
        String str;
        Message obtainMessage = g.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        if (i2 == 0) {
            str = "ggTIEepvzybHoO4C7/s5eQ==";
        } else if (i2 != 1) {
            if (i2 == 2) {
                str = "bRmfYSLDPlLJ9XQro1+/dQ==";
            }
            obtainMessage.setData(bundle);
            g.sendMessage(obtainMessage);
        } else {
            str = "QlAKJNz4iTmDadRoCSAs4A==";
        }
        bundle.putString("type", d.g(str));
        obtainMessage.setData(bundle);
        g.sendMessage(obtainMessage);
    }

    private static void f() {
        HandlerThread handlerThread = new HandlerThread("jg_mzdb_thread");
        f = handlerThread;
        handlerThread.start();
        g = new Handler(f.getLooper()) { // from class: cn.jiguang.x.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    cn.jiguang.ak.a.a("MeizuIdManager", "message type valid");
                    return;
                }
                try {
                    String unused = b.h = b.d.a(message.getData().getString("type"));
                } catch (Throwable th) {
                    String unused2 = b.h = "";
                    cn.jiguang.ak.a.a("MeizuIdManager", "getID exception, " + th.getMessage());
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
            a(1);
            return j;
        }
        return null;
    }

    public void a(int i2) {
        String str;
        String str2;
        synchronized (e) {
            b(i2);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                e.wait(AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS);
            } catch (InterruptedException e2) {
                cn.jiguang.ak.a.d("MeizuIdManager", "lock wait err: " + e2.getMessage());
            }
            if (SystemClock.uptimeMillis() - uptimeMillis >= AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS) {
                str = "MeizuIdManager";
                str2 = "query timeout";
            } else if (i2 == 0) {
                i = h;
                h = null;
                str = "MeizuIdManager";
                str2 = "query aaid: " + i;
            } else if (i2 == 1) {
                String str3 = h;
                if (str3 == null) {
                    str = "MeizuIdManager";
                    str2 = "get ids-va failed";
                } else {
                    j = str3;
                    h = null;
                    str = "MeizuIdManager";
                    str2 = "query aaid: " + j;
                }
            } else if (i2 == 2) {
                String str4 = h;
                if (str4 == null) {
                    str = "MeizuIdManager";
                    str2 = "get ids-aa failed";
                } else {
                    k = str4;
                    h = null;
                    str = "MeizuIdManager";
                    str2 = "query aaid: " + k;
                }
            }
            cn.jiguang.ak.a.a(str, str2);
        }
    }

    public String b(String str) {
        if (b()) {
            String str2 = k;
            if (str2 != null) {
                return str2;
            }
            a(2);
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
            a(0);
            return i;
        }
        return null;
    }
}
