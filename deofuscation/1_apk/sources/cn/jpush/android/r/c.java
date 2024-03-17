package cn.jpush.android.r;

import android.app.Activity;
import android.content.Context;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.lang.ref.WeakReference;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    private static int a;
    private static WeakReference<Activity> b;
    private static Activity c;
    private static boolean d;
    private static long e;

    public static Activity a(Context context) {
        return JPushConstants.SDK_VERSION_CODE < 369 ? cn.jpush.android.o.a.a(context) : b(context);
    }

    public static void a() {
        if (a == 0) {
            Logger.d("InAppActivityLifeCallback", "need sync activity task count");
            a++;
        }
    }

    public static long b() {
        return JPushConstants.SDK_VERSION_CODE < 369 ? cn.jpush.android.o.a.a() : e;
    }

    private static Activity b(Context context) {
        if (c != null) {
            Logger.dd("InAppActivityLifeCallback", "use LifeCycle activity");
            return c;
        }
        Activity activity = null;
        try {
            if (b != null) {
                Logger.d("InAppActivityLifeCallback", "mActivity is null, try to user weakActivity: " + b);
                Activity activity2 = b.get();
                if (activity2 != null) {
                    try {
                        Logger.dd("InAppActivityLifeCallback", "use weak activity");
                    } catch (Throwable unused) {
                        activity = activity2;
                    }
                }
                activity = activity2;
            }
            if (activity == null) {
                activity = cn.jpush.android.ac.a.p(context);
                if (activity != null) {
                    Logger.dd("InAppActivityLifeCallback", "use current stack activity");
                    b = new WeakReference<>(activity);
                    if (!d) {
                        Logger.d("InAppActivityLifeCallback", "init activity lifecycle for getting current stack activity");
                        d = true;
                        JPushConstants.init(context);
                    }
                } else {
                    Logger.d("InAppActivityLifeCallback", "current stack activity is null");
                }
            }
        } catch (Throwable unused2) {
        }
        return activity;
    }

    public void a(Activity activity) {
        c = activity;
    }

    public void b(Activity activity) {
        if (activity != null) {
            try {
                Logger.d("InAppActivityLifeCallback", "[onActivityStarted], activity: " + activity.getClass().getCanonicalName() + ", activityTaskCount: " + a);
                a(activity);
                if (JPushConstants.getAppContext(activity) != null) {
                    if (a == 0) {
                        Logger.d("InAppActivityLifeCallback", "is foreground, change foreground state");
                        e = System.currentTimeMillis();
                        cn.jpush.android.o.b.a(activity.getApplicationContext(), cn.jpush.android.ac.a.a(activity) ? 2 : 1);
                    }
                    a++;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void c(Activity activity) {
        a(activity);
        if (activity != null) {
            cn.jpush.android.p.a.a().b(activity.getApplicationContext(), activity.getClass().getCanonicalName());
        }
    }

    public void d(Activity activity) {
        try {
            if (c == null || activity == null) {
                return;
            }
            Logger.d("InAppActivityLifeCallback", "[onActivityPaused], mActivityName: " + c.getClass().getCanonicalName() + ", activityName: " + activity.getClass().getCanonicalName());
            if (c.getClass().getCanonicalName() != null && c.getClass().getCanonicalName().equals(activity.getClass().getCanonicalName())) {
                c = null;
            }
            b = new WeakReference<>(activity);
            cn.jpush.android.p.a.a().a(activity.getApplicationContext(), activity.getClass().getCanonicalName());
        } catch (Throwable th) {
            Logger.w("InAppActivityLifeCallback", " onActivityDestroyed error: " + th.getMessage());
        }
    }

    public void e(Activity activity) {
        if (activity != null) {
            try {
                Logger.d("InAppActivityLifeCallback", "[onActivityStopped], activity: " + activity.getClass().getCanonicalName() + ", activityTaskCount: " + a);
                Context appContext = JPushConstants.getAppContext(activity);
                if (appContext != null) {
                    int i = a;
                    if (i > 0) {
                        a = i - 1;
                    }
                    if (a == 0) {
                        Logger.d("InAppActivityLifeCallback", "is not Foreground, change to foreground state");
                        cn.jpush.android.o.b.a(appContext, 0);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void f(Activity activity) {
        Logger.d("InAppActivityLifeCallback", "[onActivityDestroyed]");
        if (activity != null) {
            try {
                cn.jpush.android.p.a.a().c(activity.getApplicationContext(), activity.getClass().getCanonicalName());
            } catch (Throwable unused) {
            }
        }
    }
}
