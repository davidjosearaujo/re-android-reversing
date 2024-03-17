package cn.jiguang.ay;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.f.g;
import cn.jiguang.f.h;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    private static int a;
    private static c b;
    private final Map<String, Integer> c = new HashMap();

    private c() {
    }

    private int a(boolean z) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            boolean z2 = false;
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (!g.a(nextElement.getName(), "dummy")) {
                    boolean a2 = g.a(nextElement.getName(), "wlan");
                    if (!z || a2) {
                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (!nextElement2.isLoopbackAddress() && a(nextElement2)) {
                                if (a2) {
                                    return 3;
                                }
                                z2 = true;
                            }
                        }
                        continue;
                    }
                }
            }
            return z2 ? 0 : 1;
        } catch (Exception unused) {
            cn.jiguang.ar.c.g("IpvxHelper", "checkIpvxSupport:");
            return 0;
        }
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public static void a(int i) {
        if (i > 3 || i < 0) {
            return;
        }
        a = i;
    }

    private static boolean a(InetAddress inetAddress) {
        try {
            if (inetAddress instanceof Inet6Address) {
                if (!inetAddress.getHostAddress().substring(0, 4).equalsIgnoreCase("fe80")) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public int a(Context context) {
        int i;
        int i2 = 0;
        try {
            String c = h.c(context);
            String str = "";
            boolean equals = "wifi".equals(c);
            if (equals && cn.jiguang.d.a.l(context)) {
                str = cn.jiguang.f.a.m(context);
            }
            boolean z = !TextUtils.isEmpty(str);
            if (!equals || z) {
                Integer num = this.c.get(c + str);
                if (num != null && num.intValue() != 0) {
                    cn.jiguang.ar.c.c("IpvxHelper", "net=" + c + " " + str + " get cache support=" + num);
                    return num.intValue();
                }
            }
            if (z) {
                i = ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.g(str))).intValue();
                try {
                    cn.jiguang.ar.c.c("IpvxHelper", "net=" + c + " " + str + " get wifi history support=" + i);
                } catch (Throwable th) {
                    th = th;
                    i2 = i;
                    cn.jiguang.ar.c.g("IpvxHelper", "getPreferVx e:" + th);
                    return i2;
                }
            } else {
                i = 0;
            }
            if (i == 0) {
                i = a(equals);
                cn.jiguang.ar.c.c("IpvxHelper", "net=" + c + " " + str + " get networkinterface support=" + i);
                if (z) {
                    cn.jiguang.g.b.a(context, cn.jiguang.g.a.g(str).a((cn.jiguang.g.a<Integer>) Integer.valueOf(i)));
                }
            }
            i2 = i;
            if (!equals || z) {
                this.c.put(c + str, Integer.valueOf(i2));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return i2;
    }

    public void a(Context context, int i) {
        String c = h.c(context);
        boolean equals = "wifi".equals(c);
        String m = (equals && cn.jiguang.d.a.l(context)) ? cn.jiguang.f.a.m(context) : "";
        boolean z = !TextUtils.isEmpty(m);
        if (!equals || z) {
            this.c.put(c + m, Integer.valueOf(i));
        }
        if (z) {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.g(m).a((cn.jiguang.g.a<Integer>) Integer.valueOf(i)));
        }
    }

    public int b(int i) {
        int i2 = a;
        if (i2 == 2 || i2 == 1) {
            return i2;
        }
        if (i != 1) {
            if (i != 2) {
                return i2;
            }
            return 2;
        }
        return 1;
    }
}
