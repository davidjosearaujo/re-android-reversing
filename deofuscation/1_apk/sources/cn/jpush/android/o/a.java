package cn.jpush.android.o;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.lang.ref.WeakReference;

@TargetApi(14)
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    private static int a;
    private static WeakReference<Activity> b;
    private static Activity c;
    private static boolean d;
    private static long e;

    public static long a() {
        return e;
    }

    public static Activity a(Context context) {
        if (c != null) {
            Logger.dd("DyActivityLifeCallback", "use dLifeCycle activity");
            return c;
        }
        Activity activity = null;
        try {
            if (b != null) {
                Logger.d("DyActivityLifeCallback", "mActivity is null, try to use weakActivity: " + b);
                Activity activity2 = b.get();
                if (activity2 != null) {
                    try {
                        Logger.dd("DyActivityLifeCallback", "use weak activity");
                    } catch (Throwable unused) {
                        activity = activity2;
                    }
                }
                activity = activity2;
            }
            if (activity == null) {
                activity = cn.jpush.android.ac.a.p(context);
                if (activity != null) {
                    Logger.dd("DyActivityLifeCallback", "use current stack activity");
                    b = new WeakReference<>(activity);
                    if (!d) {
                        Logger.d("DyActivityLifeCallback", "init activity lifecycle for getting current stack activity");
                        d = true;
                        b.a(context);
                    }
                } else {
                    Logger.d("DyActivityLifeCallback", "current stack activity is null");
                }
            }
        } catch (Throwable unused2) {
        }
        return activity;
    }

    public static void b() {
        if (a == 0) {
            Logger.d("DyActivityLifeCallback", "need sync activity task count");
            a++;
        }
    }

    public void a(Activity activity) {
        c = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity != null) {
            try {
                cn.jpush.android.p.a.a().c(activity.getApplicationContext(), activity.getClass().getCanonicalName());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        try {
            if (c == null || activity == null) {
                return;
            }
            Logger.d("DyActivityLifeCallback", "[onActivityPaused], mActivityName: " + c.getClass().getCanonicalName() + ", activityName: " + activity.getClass().getCanonicalName());
            if (c.getClass().getCanonicalName() != null && c.getClass().getCanonicalName().equals(activity.getClass().getCanonicalName())) {
                c = null;
            }
            b = new WeakReference<>(activity);
            cn.jpush.android.p.a.a().a(activity.getApplicationContext(), activity.getClass().getCanonicalName());
        } catch (Throwable th) {
            Logger.w("DyActivityLifeCallback", " onActivityDestroyed error: " + th.getMessage());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        a(activity);
        if (activity != null) {
            cn.jpush.android.p.a.a().b(activity.getApplicationContext(), activity.getClass().getCanonicalName());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        try {
            a(activity);
            if (a == 0) {
                Logger.d("DyActivityLifeCallback", "is Foreground");
                e = System.currentTimeMillis();
                b.a(activity.getApplicationContext(), cn.jpush.android.ac.a.a(activity) ? 2 : 1);
            }
            a++;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        try {
            int i = a;
            if (i > 0) {
                a = i - 1;
            }
            if (a == 0) {
                Logger.d("DyActivityLifeCallback", "is not Foreground");
                b.a(JPushConstants.getAppContext(activity), 0);
            }
        } catch (Throwable unused) {
        }
    }
}
