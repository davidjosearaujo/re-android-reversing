package cn.jpush.android.t;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.ac.i;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.h;
import cn.jpush.android.local.JPushConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.fastjson.JSONStreamContext;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.hunantv.media.player.subtitle.MediaFormat;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    private static int a = 120;
    private static volatile c b = null;
    private static String l = "";
    private static long m = 0;
    private static long n = 43200;
    private long h;
    private boolean c = true;
    private int d = 0;
    private int e = 0;
    private boolean f = false;
    private boolean g = false;
    private boolean i = true;
    private String j = "";
    private long k = 0;
    private f o = new f() { // from class: cn.jpush.android.t.c.1
        {
            c.this = this;
        }

        @Override // cn.jpush.android.t.f
        public void a(Message message) {
            if (message == null || message.what != 1004) {
                return;
            }
            Context context = JPushConstants.mApplicationContext;
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", true);
            c.this.a(context, "tcp_send_rtc", bundle);
        }
    };

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends cn.jpush.android.ac.e {
        private Context b;
        private String c;
        private Bundle d;

        public a(Context context, String str, Bundle bundle) {
            c.this = r1;
            this.b = context;
            this.c = str;
            this.d = bundle;
            this.f = "HbPeriodManager#Action";
        }

        @Override // cn.jpush.android.ac.e
        public void a() {
            c cVar;
            Context context;
            Bundle bundle;
            try {
                Logger.d("InAppHbPeriodManager", "action: " + this.c);
                if (this.c.equals("tcp_rtc")) {
                    d.a().a(this.b, false);
                    cVar = c.this;
                    context = this.b;
                    bundle = this.d;
                } else if (this.c.equals("tcp_send_rtc")) {
                    c.this.c(this.b, this.d);
                    return;
                } else if (!"special_rtc".equals(this.c)) {
                    return;
                } else {
                    cVar = c.this;
                    context = this.b;
                    bundle = this.d;
                }
                cVar.a(context, bundle);
            } catch (Throwable th) {
                Logger.ww("InAppHbPeriodManager", "tcp action failed:" + th.getMessage());
            }
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

    private boolean a(boolean z) {
        if (z) {
            return System.currentTimeMillis() - this.h < 10000;
        }
        int i = this.d;
        long currentTimeMillis = System.currentTimeMillis() - this.h;
        return i > 0 ? currentTimeMillis < ((long) (this.d + (-4))) * 1000 : currentTimeMillis < 18000;
    }

    public void c(Context context, Bundle bundle) {
        try {
            if (!g()) {
                Logger.d("InAppHbPeriodManager", "HB Period is disabled by user");
                return;
            }
            if (a(bundle != null ? bundle.getBoolean("force", false) : false)) {
                Logger.d("InAppHbPeriodManager", "No need to in app rtc, Because it have succeed recently");
                return;
            }
            Logger.dd("InAppHbPeriodManager", "Send heart beat");
            if (this.f) {
                e(context);
            } else {
                Logger.d("InAppHbPeriodManager", "socket is closed or push isn't login");
            }
        } catch (Throwable th) {
            Logger.w("InAppHbPeriodManager", "[rtcKeepAlive] failed, " + th.getMessage());
        }
    }

    public static synchronized String f(Context context) {
        synchronized (c.class) {
            if (System.currentTimeMillis() - m < n * 1000) {
                return l;
            }
            String i = i(context);
            n = !TextUtils.isEmpty(i) ? 43200L : 360L;
            if (!TextUtils.isEmpty(i)) {
                JSONObject jSONObject = new JSONObject(i);
                String optString = jSONObject.optString("imei1", " ");
                String optString2 = jSONObject.optString("imei2", " ");
                String optString3 = jSONObject.optString("joad", " ");
                String optString4 = jSONObject.optString("android_id", " ");
                String optString5 = jSONObject.optString("manufacturer", " ");
                String optString6 = jSONObject.optString(DeviceRequestsHelper.DEVICE_INFO_MODEL, " ");
                String a2 = h.a();
                String optString7 = jSONObject.optString("os_version", " ");
                String optString8 = jSONObject.optString(MediaFormat.KEY_LANGUAGE, " ");
                DisplayMetrics a3 = i.a(context);
                i = optString + Consts.SEPARATOR + optString2 + Consts.SEPARATOR + optString3 + Consts.SEPARATOR + optString4 + Consts.SEPARATOR + optString5 + Consts.SEPARATOR + optString6 + Consts.SEPARATOR + a2 + Consts.SEPARATOR + optString7 + Consts.SEPARATOR + optString8 + Consts.SEPARATOR + a3.widthPixels + Consts.SEPARATOR + a3.heightPixels;
            }
            l = i;
            m = System.currentTimeMillis();
            return i;
        }
    }

    private String g(Context context) {
        if (JCoreHelper.getJCoreSDKVersionInt() < 266) {
            return "-4";
        }
        if (System.currentTimeMillis() - this.k < 600000) {
            return this.j;
        }
        String h = h(context);
        this.j = h;
        this.k = System.currentTimeMillis();
        return h;
    }

    private boolean g() {
        return JPushConstants.SDK_VERSION_CODE >= 410 ? JPushConstants.IS_HB_PERIOD_ENABLE : this.i;
    }

    private static String h(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 85, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    private static String i(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 86, null, null, new Object[0]);
        return onEvent instanceof JSONObject ? ((JSONObject) onEvent).toString() : "";
    }

    public synchronized void a(Context context) {
        if (this.g) {
            return;
        }
        this.e = 0;
        Logger.d("InAppHbPeriodManager", "start push period worker...");
        g.a().b();
        d.a().a(context, true);
        this.g = true;
    }

    public void a(Context context, Bundle bundle) {
        long j;
        if (cn.jpush.android.cache.a.d(context)) {
            Logger.dd("InAppHbPeriodManager", "[rtc] tcp has close by active");
            return;
        }
        boolean z = true;
        if (bundle != null) {
            z = bundle.getBoolean("force", true);
            j = bundle.getLong("delay_time", 0L);
        } else {
            j = 0;
        }
        if (j <= 0) {
            c(context, bundle);
        } else {
            g.a().b(JSONStreamContext.StartArray, j, this.o);
        }
        Logger.i("InAppHbPeriodManager", "send rtc force=" + z + " delay=" + j);
    }

    public void a(Context context, String str, Bundle bundle) {
        Logger.d("InAppHbPeriodManager", "[doAction] action: " + str + ", userInAppHb: " + this.c);
        a(context);
        JCoreHelper.normalExecutor(context, "InAppHbPeriodManager", new a(context, str, bundle));
    }

    public void a(Context context, String str, boolean z, long j) {
        try {
            Logger.d("InAppHbPeriodManager", "[sendRtcToTcp], action: " + str + ", force: " + z + ", delayTime: " + j);
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", z);
            bundle.putLong("delay_time", j * 1000);
            a(context, str, bundle);
        } catch (Throwable th) {
            Logger.ww("InAppHbPeriodManager", "sendRtcToTcp error:" + th.getMessage());
        }
    }

    public void a(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            if (jSONObject2 != null) {
                int optInt = jSONObject2.optInt("inapp_next_time");
                Logger.d("InAppHbPeriodManager", "need request in app soon, next_time: " + optInt);
                a(context, "special_rtc", true, (long) Math.max(optInt, 0));
            }
        } catch (Throwable th) {
            Logger.w("InAppHbPeriodManager", "[handleCtrlNextInAppCmd] error:" + th.getMessage());
        }
    }

    public void a(Context context, boolean z) {
        boolean z2 = JPushConstants.IS_HB_PERIOD_ENABLE;
        if (z2 && !z) {
            d.a().a(context);
        } else if (!z2 && z) {
            a(context);
            f();
            d.a().a(context, true);
        }
        this.i = z;
        JPushConstants.IS_HB_PERIOD_ENABLE = z;
        cn.jpush.android.helper.c.a("NO MSGID", 1327, context);
        Logger.d("InAppHbPeriodManager", "user set HB Period status, enable: " + z);
    }

    public void b(Context context) {
        this.f = true;
        Logger.d("InAppHbPeriodManager", "onLoginedIn ...");
    }

    public void b(Context context, Bundle bundle) {
        if (!this.f || bundle == null) {
            return;
        }
        cn.jpush.android.r.h.a(bundle.getString("activity_name"), bundle.getInt("state"), bundle.getBoolean("type"));
    }

    public void b(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            Logger.d("InAppHbPeriodManager", "handleCtrlHeartBeatCmd cmd content: " + jSONObject2);
            if (jSONObject2 != null) {
                boolean optBoolean = jSONObject2.optBoolean("use_inapp");
                this.c = optBoolean;
                if (!optBoolean) {
                    d.a().a(context);
                    return;
                }
                int optInt = jSONObject2.optInt("inapp_interval");
                int optInt2 = jSONObject2.optInt("inapp_max_interval", a);
                int i = a;
                if (optInt2 <= i) {
                    a = i;
                }
                a = optInt2;
                if (optInt <= 0) {
                    Logger.w("InAppHbPeriodManager", "hb_interval is less than 0, will use 15s");
                    this.d = 15;
                } else if (optInt >= optInt2 / 2) {
                    Logger.w("InAppHbPeriodManager", "hb_interval is more than " + a + ", will use " + a + "s");
                    this.d = a;
                    this.d = 0;
                } else {
                    Logger.w("InAppHbPeriodManager", "set ssp heartbeat interval:" + optInt);
                    this.d = optInt;
                }
                a(context);
                d.a().a(context, true);
            }
        } catch (Throwable th) {
            Logger.w("InAppHbPeriodManager", "[InAppHbPeriodManager] handleCtrlHeartBeatCmd error:" + th);
        }
    }

    public boolean b() {
        return this.c;
    }

    public void c() {
        int i;
        int i2 = this.e;
        int i3 = this.d;
        if (i3 > 0) {
            if (i2 == 0) {
                i = i3 * 2;
            } else {
                int i4 = i2 * 2;
                int i5 = a;
                if (i4 < i5) {
                    i = i2 * 2;
                } else {
                    this.e = i5;
                }
            }
            this.e = i;
        }
        Logger.d("InAppHbPeriodManager", "updateHeartBeatInterval  -- current HeartBeatInterval = " + this.e + ", old hbInterval: " + i2);
    }

    public void c(Context context) {
        Logger.d("InAppHbPeriodManager", "[onTcpDisconnected] hb cancel");
        if (b()) {
            d.a().a(context);
        }
        this.f = false;
        this.g = false;
        this.d = 0;
    }

    public int d() {
        Logger.d("InAppHbPeriodManager", "getHeartBeatInterval  -- current HeartBeatInterval = " + this.e);
        int i = this.d;
        if (i > 0) {
            int i2 = this.e;
            return i2 == 0 ? i : i2;
        }
        return a;
    }

    public void d(Context context) {
        if (b() && g()) {
            if (d() >= a / 2 && this.d > 0) {
                Logger.d("InAppHbPeriodManager", "change foreground hb large " + (a / 2) + ", reset current hb");
                f();
            }
            Logger.d("InAppHbPeriodManager", "change to foreground, force send rtc now(pull in app)");
            a(context, "special_rtc", true, 0L);
        }
    }

    public int e() {
        Logger.d("InAppHbPeriodManager", "getNextHbIntervalForLog  -- current HeartBeatInterval = " + this.e);
        int i = this.d;
        if (i > 0) {
            int i2 = this.e;
            if (i2 == 0) {
                int i3 = i * 2;
                int i4 = a;
                return i3 < i4 / 2 ? i * 2 : i4;
            }
            int i5 = i2 * 2;
            int i6 = a;
            return i5 < i6 / 2 ? i2 * 2 : i6;
        }
        return a;
    }

    public void e(Context context) {
        try {
            if (cn.jpush.android.r.h.d(context)) {
                Logger.d("InAppHbPeriodManager", "current page in black list, not send hb");
                long uid = JCoreHelper.getUid(context);
                cn.jpush.android.helper.c.a(uid + "", 1325, context);
                return;
            }
            int i = cn.jpush.android.o.b.a;
            if (i != 2) {
                i = cn.jpush.android.ac.a.k(context) ? 1 : 0;
                Logger.d("InAppHbPeriodManager", "send heartbeat local userType= " + cn.jpush.android.o.b.a + ", use process importance to judge type: " + i);
            }
            int i2 = i;
            int i3 = cn.jpush.android.o.b.c ? 1 : 0;
            byte g = cn.jpush.android.r.a.g(context);
            byte b2 = cn.jpush.android.helper.i.b(context);
            int a2 = cn.jpush.android.helper.i.a(context);
            String g2 = g(context);
            String f = f(context);
            Logger.d("InAppHbPeriodManager", "send status report - userType:" + i2 + ", supportInstall:" + i3 + ", sspLayoutVersion=" + a2 + " , suppprtINAPP:" + ((int) g) + ", supportSSP: " + ((int) b2) + ", pkgIndex: " + g2 + ", devInfo: " + f);
            JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 35, 4, 1L, 0L, cn.jpush.android.z.c.a(i2, i3, 1, a2, g, b2, g2, f));
            this.h = System.currentTimeMillis();
        } catch (Throwable th) {
            Logger.w("InAppHbPeriodManager", "send hb failed, error: " + th.getMessage());
        }
    }

    public void f() {
        this.e = 0;
        d.a().b();
    }
}
