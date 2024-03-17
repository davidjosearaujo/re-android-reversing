package cn.jpush.android.k;

import android.content.Context;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.c;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    public static void a(Context context) {
        Logger.d("JAnalytics", "sendClickNotificationMessage");
        a(context, 2025, "Click the notification bar message");
    }

    public static void a(Context context, int i, String str) {
        a(context, i, str, null);
    }

    public static void a(Context context, int i, String str, JSONObject jSONObject) {
        try {
            c.a(context, i, str, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context) {
        a(context, CommonConstant.RETCODE.INDEPENDENT_AUTH_NOT_ALLOW, "Clear the notification bar message");
    }

    public static void c(Context context) {
        int i;
        String str;
        Logger.d("JAnalytics", "sendNotificationPermissions");
        int d = cn.jpush.android.x.c.d(context);
        if (d == ((Integer) Sp.get(context, Key.IsNotificationEnabledLastTime())).intValue()) {
            Logger.d("JAnalytics", "sendNotificationPermissions enabled == integer : " + d);
            return;
        }
        Key<Integer> IsNotificationEnabledLastTime = Key.IsNotificationEnabledLastTime();
        IsNotificationEnabledLastTime.set(Integer.valueOf(d));
        Sp.set(context, IsNotificationEnabledLastTime);
        if (1 == d) {
            i = 2027;
            str = "Enable notification permissions";
        } else {
            i = 2028;
            str = "Turn off notification permissions";
        }
        a(context, i, str);
    }

    public static void d(Context context) {
        a(context, 2029, "App Browsing Page");
    }
}
