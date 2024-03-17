package cn.jpush.android.ab;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.g;
import cn.jpush.android.local.JPushConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static volatile a b;
    private Map<Byte, C0012a> a = new HashMap();

    /* renamed from: cn.jpush.android.ab.a$a  reason: collision with other inner class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class C0012a {
        public byte a;
        public String b;
        public long c;
        public byte[] d;
        public int e = 0;

        public C0012a(byte b, String str, long j, byte[] bArr) {
            this.a = b;
            this.b = str;
            this.c = j;
            this.d = bArr;
        }

        public String toString() {
            return "PluginPlatformRegIDBean{pluginPlatformType=" + ((int) this.a) + ", regid='" + this.b + "', rid=" + this.c + ", retryCount=" + this.e + '}';
        }
    }

    private a() {
    }

    private C0012a a(long j) {
        for (Map.Entry<Byte, C0012a> entry : this.a.entrySet()) {
            if (entry.getValue().c == j) {
                return entry.getValue();
            }
        }
        Logger.d("PluginPlatformRidUpdate", "can not find uploadBean by rid");
        return null;
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    private synchronized void a(Context context, C0012a c0012a) {
        JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 27, 1, c0012a.c, 10000L, c0012a.d);
    }

    private void b(Context context, byte b2, String str) {
        long a = g.a();
        Logger.v("PluginPlatformRidUpdate", "sendUpdateRidInfo regid:" + str + ",rid:" + a + ",whichPlatform:" + ((int) b2));
        C0012a c0012a = new C0012a(b2, str, a, cn.jpush.android.z.c.a(str, b2));
        this.a.put(Byte.valueOf(b2), c0012a);
        a(context, c0012a);
    }

    public synchronized void a(Context context, byte b2, String str) {
        if (b2 == 0) {
            Logger.w("PluginPlatformRidUpdate", "unknown plugin platform type");
        } else if (!JPushConstants.isTcpConnected()) {
            Logger.d("PluginPlatformRidUpdate", "tcp disconnected");
        } else if (this.a.containsKey(Byte.valueOf(b2)) && TextUtils.equals(this.a.get(Byte.valueOf(b2)).b, str)) {
            Logger.d("PluginPlatformRidUpdate", "same regid request, drop it");
        } else {
            b(context, b2, str);
        }
    }

    public void a(Context context, long j) {
        C0012a a = a(j);
        Logger.ii("PluginPlatformRidUpdate", "onUpdateRidSuccess rid:" + j + " ,pluginPlatformRegIDBean:" + a);
        if (a != null) {
            Sp.set(context, Key.ThirdPush_RegID(a.a).set(a.b));
            Sp.set(context, Key.ThirdPush_RegUpload(a.a).set(Boolean.TRUE));
            this.a.remove(Byte.valueOf(a.a));
            c.a().a(context, (int) a.a, a.b);
        }
    }

    public void a(Context context, long j, int i) {
        C0012a a = a(j);
        Logger.ii("PluginPlatformRidUpdate", "onUpdateRidFailed rid:" + j + ",errorCode:" + i + " ,pluginPlatformRegIDBean:" + a);
        if (a != null) {
            int i2 = a.e;
            if (i2 < 3) {
                a.e = i2 + 1;
                a(context, a);
                return;
            }
            Logger.d("PluginPlatformRidUpdate", "updateRegId failed");
            this.a.remove(Byte.valueOf(a.a));
        }
    }

    public void b(Context context, long j) {
        C0012a a = a(j);
        Logger.ii("PluginPlatformRidUpdate", "onUpdateRidTimeout rid:" + j + " ,pluginPlatformRegIDBean:" + a);
        if (a != null) {
            int i = a.e;
            if (i < 3) {
                a.e = i + 1;
                a(context, a);
                return;
            }
            Logger.d("PluginPlatformRidUpdate", "updateRegId failed by timeout");
            this.a.remove(Byte.valueOf(a.a));
        }
    }
}
