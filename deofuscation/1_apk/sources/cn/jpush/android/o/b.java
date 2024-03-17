package cn.jpush.android.o;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ActivityLifeCallBack;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.t.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    public static int a = 0;
    public static boolean b = false;
    public static boolean c = true;
    private static boolean d;

    public static void a(Context context) {
        e(context);
    }

    public static void a(Context context, int i) {
        Logger.d("DyPushConstants", "changeForegroundStat, userType: " + i);
        a = i;
        b = i > 0;
        Bundle bundle = new Bundle();
        bundle.putInt("user_type", i);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "change_foreground_dy", bundle);
        cn.jpush.android.p.a.a().b(context, i);
    }

    public static void a(Context context, Bundle bundle) {
    }

    public static void a(Context context, String str) {
        d dVar = new d();
        dVar.br = str;
        cn.jpush.android.p.a.a(context, "cn.jpush.android.intent.SYNC_BLACK_LIST", dVar, true);
    }

    public static void a(Context context, String str, long j) {
        Logger.d("DyPushConstants", "saveInAppInfo, content: " + str + ", displayTime: " + j);
        Bundle bundle = new Bundle();
        bundle.putString("type", "config_info");
        bundle.putString("content", str);
        bundle.putLong("display_time", j);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "save_config", bundle);
    }

    public static void a(Context context, boolean z) {
        Logger.d("DyPushConstants", "changeInstallStatus, support: " + z);
        c = z;
        Bundle bundle = new Bundle();
        bundle.putBoolean("install_status", z);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "install_status", bundle);
    }

    public static void b(Context context) {
        try {
            if (cn.jpush.android.ac.a.k(context)) {
                Logger.d("DyPushConstants", "force send rtc in foreground for logined, and sync activity task count if need.");
                c.a().d(context);
            }
        } catch (Throwable th) {
            Logger.w("DyPushConstants", "[forceRtcForLogined] force send rtc error, " + th.getMessage());
        }
    }

    public static void c(Context context) {
        if (JPushConstants.SDK_VERSION_CODE < 369) {
            a.b();
            return;
        }
        cn.jpush.android.r.c.a();
        try {
            ActivityLifeCallBack.syncActivityTaskCount();
        } catch (Throwable unused) {
            Logger.w("DyPushConstants", "no syncActivityTaskCount method in ActivityLifeCallBack, sdk_code: " + JPushConstants.SDK_VERSION_CODE);
        }
    }

    public static void d(Context context) {
        Logger.d("DyPushConstants", "saveInAppState...");
        Bundle bundle = new Bundle();
        bundle.putString("type", "config_state");
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "save_config", bundle);
    }

    private static void e(Context context) {
        String str;
        if (JPushConstants.SDK_VERSION_CODE >= 369) {
            Logger.d("DyPushConstants", "JPush local version: " + JPushConstants.SDK_VERSION_CODE + ", large than: 369 min in app version, need not register another lifecycle");
            return;
        }
        Logger.d("DyPushConstants", "initPageLifecycle init, local jpush version: " + JPushConstants.SDK_VERSION_CODE);
        if (d) {
            return;
        }
        try {
            d = true;
            if (Build.VERSION.SDK_INT < 14 || !(context instanceof Application)) {
                return;
            }
            String d2 = cn.jpush.android.ac.a.d(context);
            String packageName = context.getPackageName();
            if (d2 == null || packageName == null || !context.getPackageName().equals(d2)) {
                str = "need not initPageLifecycle in other process :" + d2;
            } else {
                ((Application) context).registerActivityLifecycleCallbacks(new a());
                str = "initPageLifecycle in main process,packageName:" + packageName + ",currentProcessName:" + d2;
            }
            Logger.d("DyPushConstants", str);
        } catch (Throwable th) {
            Logger.ww("DyPushConstants", "registerActivityLifecycleCallbacks failed:" + th.getMessage());
        }
    }
}
