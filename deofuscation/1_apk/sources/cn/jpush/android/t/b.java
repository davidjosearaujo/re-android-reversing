package cn.jpush.android.t;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.ac.h;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private static final String a = cn.jpush.android.ac.d.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 83, 79, 119, 110, Byte.MAX_VALUE, 118, 29, 74, 108, 102, Byte.MAX_VALUE, 126, 94, 14, 115, 120, 99, 98, 88, 14, 122, 102, 57, 103, 1, 15, 115, 107, 121, Byte.MAX_VALUE, 86, 73, 126, 39, 112, 118, 92});
    private static String b = "";
    private static List<String> c = new LinkedList();
    private static List<String> d = new LinkedList();
    private static AtomicBoolean e = new AtomicBoolean(false);

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends cn.jpush.android.ac.e {
        public Context a;

        public a(Context context) {
            this.a = context;
        }

        private synchronized void a(Context context) {
            if (context == null) {
                Logger.w("InAppBlackLstConfigHelper", "unexcept error context is null");
            } else if (!b(context)) {
                Logger.d("InAppBlackLstConfigHelper", "need not black config request");
            } else {
                String d = d(this.a);
                if (TextUtils.isEmpty(d)) {
                    return;
                }
                a(context, d);
            }
        }

        private void a(Context context, String str) {
            try {
                String b = h.b(str);
                JSONObject jSONObject = new JSONObject(b);
                long optLong = jSONObject.optLong("next_time", 21600L);
                b.b(jSONObject.optString("black_list", ""), jSONObject.optString("white_list", ""));
                Sp.set(context, Key.BlackPagesInternalTime().set(Long.valueOf(optLong)));
                Sp.set(context, Key.BlackPagesLastReqTime().set(Long.valueOf(System.currentTimeMillis())));
                b.a(context, str);
                cn.jpush.android.o.b.a(context, str);
                b.e.set(true);
                Logger.d("InAppBlackLstConfigHelper", "recv config decData, " + b);
            } catch (JSONException e) {
                Logger.w("InAppBlackLstConfigHelper", "update config data parse json failed, e: " + e.getMessage());
            }
        }

        private boolean b(Context context) {
            String str;
            if (JCoreHelper.checkSdkBanned(context).booleanValue()) {
                str = "sdk is banned not request config";
            } else {
                if (System.currentTimeMillis() - ((Long) Sp.get(context, Key.BlackPagesLastReqTime())).longValue() >= ((Long) Sp.get(context, Key.BlackPagesInternalTime())).longValue() * 1000) {
                    return true;
                }
                str = "not config request internal time";
            }
            Logger.d("InAppBlackLstConfigHelper", str);
            return false;
        }

        private JSONObject c(Context context) {
            try {
                String appKey = JCoreHelper.getAppKey(context);
                if (TextUtils.isEmpty(appKey)) {
                    Logger.w("InAppBlackLstConfigHelper", "request black page list config failed because can't get appKey");
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.alipay.sdk.sys.a.o, appKey);
                jSONObject.put(CommonConstant.KEY_UID, JCoreHelper.getUid(context));
                jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, "a");
                return jSONObject;
            } catch (Throwable th) {
                Logger.w("InAppBlackLstConfigHelper", "package app list probe req data failed, " + th.getMessage());
                return null;
            }
        }

        private String d(Context context) {
            JSONObject c = c(context);
            if (c == null) {
                Logger.w("InAppBlackLstConfigHelper", "package request data failed.");
                return null;
            }
            String str = b.a;
            String a = h.a(c.toString());
            Logger.d("InAppBlackLstConfigHelper", "url:" + str + ", param json:" + c.toString() + ", encryptStr: " + a);
            String a2 = cn.jpush.android.w.a.a(context, str, a, 1);
            if (TextUtils.isEmpty(a2)) {
                Logger.d("InAppBlackLstConfigHelper", "request black pages config failed");
                return null;
            }
            return a2;
        }

        @Override // cn.jpush.android.ac.e
        public void a() {
            a(this.a);
        }
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized ("pcf.cat") {
            cn.jpush.android.ac.c.a(new File(context.getFilesDir(), "pcf.cat"), str);
        }
    }

    public static void b(String str, String str2) {
        c.clear();
        if (!TextUtils.isEmpty(str)) {
            c.addAll(Arrays.asList(str.split("&")));
        }
        d.clear();
        if (!TextUtils.isEmpty(str2)) {
            d.addAll(Arrays.asList(str2.split("&")));
        }
        Logger.d("InAppBlackLstConfigHelper", "blacklist: " + str + ", whitelist: " + str2);
    }

    public static boolean b(Context context) {
        e(context);
        return e.get();
    }

    public static List<String> c(Context context) {
        if (d.isEmpty()) {
            e(context);
            return d;
        }
        return d;
    }

    public static List<String> d(Context context) {
        if (c.isEmpty()) {
            e(context);
            return c;
        }
        return c;
    }

    private static void e(Context context) {
        if (e.get()) {
            return;
        }
        synchronized ("pcf.cat") {
            File file = new File(context.getFilesDir(), "pcf.cat");
            if (file.exists()) {
                String str = (String) cn.jpush.android.ac.c.a(file);
                if (!TextUtils.isEmpty(str)) {
                    String b2 = h.b(str);
                    Logger.d("InAppBlackLstConfigHelper", "get black list config from cache file: " + b2);
                    JSONObject jSONObject = new JSONObject(b2);
                    b(jSONObject.optString("black_list", ""), jSONObject.optString("white_list", ""));
                    e.set(true);
                }
            }
        }
    }

    public void a(Context context) {
        JCoreHelper.futureExecutor(context, new a(context));
    }
}
