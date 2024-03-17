package cn.jiguang.aq;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class f {
    private static final String a = cn.jiguang.r.a.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 83, 79, 119, 110, Byte.MAX_VALUE, 118, 30, 74, 105, 125, 101, 121, 30, 67, 119, 39, 96, 32, 31, 83, 109, 105, 98, 100, 67});
    private static AtomicBoolean b = new AtomicBoolean(false);
    private static long c = 0;
    private static Boolean d = null;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends cn.jiguang.be.b {
        private Context a;

        public a(Context context) {
            this.a = context;
            this.h = "JBannedConfig";
        }

        /* JADX WARN: Removed duplicated region for block: B:67:0x0090 A[Catch: all -> 0x014a, TryCatch #0 {all -> 0x014a, blocks: (B:51:0x0004, B:54:0x0010, B:56:0x0016, B:61:0x0031, B:63:0x0037, B:65:0x004f, B:67:0x0090, B:69:0x0096, B:75:0x00d4, B:76:0x00e8, B:77:0x00f0, B:79:0x00f6, B:81:0x0105, B:82:0x010e, B:85:0x012c), top: B:91:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0096 A[Catch: all -> 0x014a, TRY_LEAVE, TryCatch #0 {all -> 0x014a, blocks: (B:51:0x0004, B:54:0x0010, B:56:0x0016, B:61:0x0031, B:63:0x0037, B:65:0x004f, B:67:0x0090, B:69:0x0096, B:75:0x00d4, B:76:0x00e8, B:77:0x00f0, B:79:0x00f6, B:81:0x0105, B:82:0x010e, B:85:0x012c), top: B:91:0x0004 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int a(android.content.Context r15) {
            /*
                Method dump skipped, instructions count: 331
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.aq.f.a.a(android.content.Context):int");
        }

        @Override // cn.jiguang.be.b
        public void a() {
            cn.jiguang.ar.c.c("JBannedConfig", "start request sdk banned config");
            int a = a(this.a);
            if (a != 0) {
                cn.jiguang.ar.c.g("JBannedConfig", "request banned config failed, code: " + a);
            }
        }
    }

    private static void a(Context context, String str) {
        try {
            cn.jiguang.ar.c.c("JSDKBannedHelper", "save sdk banned status: " + str);
            context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putString("sdk_banned_status", str).apply();
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("JSDKBannedHelper", "[saveBannedConfigJson] parse json error, " + th.getMessage());
        }
    }

    private static void a(Context context, boolean z, long j) {
        c = j;
        if (b.get() != z) {
            cn.jiguang.ar.c.c("JSDKBannedHelper", "sdk banned status changed, update status, sdkBanned: " + z);
            if (!z) {
                b = new AtomicBoolean(z);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("sdk_banned", z);
            JCoreManager.onEvent(context, "", 81, null, bundle, new Object[0]);
        }
        if (z) {
            cn.jiguang.ar.c.i("JSDKBannedHelper", "sdk is banned...");
        }
        b = new AtomicBoolean(z);
        cn.jiguang.ar.c.e("JSDKBannedHelper", "sdk banned status, banned: " + z + ", nextTime: " + c);
    }

    public static boolean a() {
        Context appContext;
        if (d != null || (appContext = JConstants.getAppContext(null)) == null) {
            return b.get();
        }
        cn.jiguang.ar.c.c("JSDKBannedHelper", "[isSDKBanned] first request banned config");
        return a(appContext);
    }

    public static synchronized boolean a(Context context) {
        synchronized (f.class) {
            if (d != null) {
                return b.get();
            }
            d = Boolean.TRUE;
            b(context);
            if (System.currentTimeMillis() > c) {
                cn.jiguang.be.d.a("FUTURE_TASK", new a(context), 0, false);
            } else {
                if (b.get()) {
                    cn.jiguang.ar.c.i("JSDKBannedHelper", "sdk is banned...");
                }
                cn.jiguang.ar.c.c("JSDKBannedHelper", "request sdk banned config not time up, not request");
            }
            return b.get();
        }
    }

    public static void b(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("values");
            if (optJSONObject != null) {
                boolean equals = "banned".equals(optJSONObject.optString("status"));
                long optLong = optJSONObject.optLong("nexttime", 43200L);
                cn.jiguang.ar.c.c("JSDKBannedHelper", "from server sdk banned status: " + equals + ", next request time: " + optLong);
                if (optLong <= 0) {
                    optLong = 0;
                }
                if (optLong >= 86400) {
                    optLong = 86400;
                }
                long currentTimeMillis = System.currentTimeMillis() + (optLong * 1000);
                a(context, equals + "," + currentTimeMillis);
                a(context, equals, currentTimeMillis);
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("JSDKBannedHelper", "parse sdk banned config failed, " + th.getMessage());
        }
    }

    private static boolean b(Context context) {
        try {
            String string = context.getSharedPreferences("cn.jiguang.prefs", 0).getString("sdk_banned_status", "");
            cn.jiguang.ar.c.e("JSDKBannedHelper", "local sdk banned config: " + string);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(",");
                boolean parseBoolean = Boolean.parseBoolean(split[0]);
                long parseLong = Long.parseLong(split[1]);
                cn.jiguang.ar.c.c("JSDKBannedHelper", "local banned config, isBanned: " + parseBoolean + ", nextReqTime: " + parseLong);
                c = parseLong;
                b = new AtomicBoolean(parseBoolean);
                return true;
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("JSDKBannedHelper", "read config json from cache failed !! error:" + th);
        }
        return false;
    }
}
