package cn.jiguang.analytics.page;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JAnalyticsAction;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.ar.c;
import cn.jiguang.as.f;
import cn.jiguang.be.b;
import cn.jiguang.be.d;
import cn.jiguang.d.a;
import cn.jiguang.internal.JConstants;
import org.json.JSONObject;

@TargetApi(14)
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ActivityLifecycle implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "ActivityLifecycle";
    public static final long WAKE_VIOLATION_COUNT = 5;
    public static final long WAKE_VIOLATION_DURATION = 50;
    public static int activityTaskCount;
    public static long lastWakeTime;

    private boolean isTranslucentNotitleTheme(Activity activity) {
        try {
            TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{16842838, 16842841, 16842836, 16842840, 16843435});
            boolean z = obtainStyledAttributes.getBoolean(0, false);
            Drawable drawable = obtainStyledAttributes.getDrawable(1);
            int color = obtainStyledAttributes.getColor(2, -1);
            boolean z2 = obtainStyledAttributes.getBoolean(3, false);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(4);
            c.c(TAG, "notitle:" + z + ", overlay:" + drawable + ", color:" + color + ", translucent:" + z2 + "background:" + drawable2);
            obtainStyledAttributes.recycle();
            if (z && z2 && drawable == null && drawable2 == null) {
                if (color == activity.getResources().getColor(17170445)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            c.g(TAG, "check TranslucentNotitleTheme failed :" + th);
        }
        return false;
    }

    private boolean isWakeActivity(Activity activity) {
        if (activity != null) {
            try {
                if (activity.getIntent() == null || TextUtils.isEmpty(activity.getIntent().getAction())) {
                    return false;
                }
                return "cn.jpush.android.intent.DActivity".equals(activity.getIntent().getAction());
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    private void reportWakeViolation(final Context context) {
        d.a("FUTURE_TASK", new b() { // from class: cn.jiguang.analytics.page.ActivityLifecycle.1
            @Override // cn.jiguang.be.b
            public void a() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    a.a(context, jSONObject, "wake_violation");
                    f.a(context, jSONObject);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        c.c(TAG, "onActivityCreated:" + activity.getClass().getCanonicalName());
        try {
            JAnalyticsAction jAnalyticsAction = JConstants.jAnalyticsAction;
            if (jAnalyticsAction != null) {
                jAnalyticsAction.dispatchStatus(activity, "onCreate");
            }
            if (isWakeActivity(activity)) {
                lastWakeTime = System.currentTimeMillis();
                return;
            }
            long j = lastWakeTime;
            if (j > 0 && j - System.currentTimeMillis() < 50) {
                c.c(TAG, "wake activity violation");
                int intValue = ((Integer) cn.jiguang.g.b.a(activity.getApplicationContext(), cn.jiguang.g.a.T())).intValue() + 1;
                if (intValue >= 5) {
                    reportWakeViolation(activity.getApplicationContext());
                    intValue = 0;
                }
                cn.jiguang.g.b.a(activity.getApplicationContext(), cn.jiguang.g.a.T().a((cn.jiguang.g.a<Integer>) Integer.valueOf(intValue)));
            }
            lastWakeTime = 0L;
        } catch (Throwable unused) {
            c.c(TAG, "onActivityCreated failed");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        try {
            c.e(TAG, "onActivityPaused:" + activity.getClass().getCanonicalName());
            JAnalyticsAction jAnalyticsAction = JConstants.jAnalyticsAction;
            if (jAnalyticsAction != null) {
                jAnalyticsAction.dispatchPause(activity);
            }
            if (JConstants.isInstrumentationHookFailed) {
                return;
            }
            PushSA.getInstance().onPause(activity);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            c.e(TAG, "onActivityResumed:" + activity.getClass().getCanonicalName());
            JAnalyticsAction jAnalyticsAction = JConstants.jAnalyticsAction;
            if (jAnalyticsAction != null) {
                jAnalyticsAction.dispatchResume(activity);
            }
            if (JConstants.isInstrumentationHookFailed) {
                return;
            }
            PushSA.getInstance().onResume(activity);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (activity != null) {
            c.c(TAG, "onActivityStarted:" + activity.getClass().getCanonicalName());
        }
        try {
            if (activityTaskCount == 0) {
                c.c(TAG, "isForeground");
                if (activity != null) {
                    JCoreManager.onEvent(activity.getApplicationContext(), JConstants.SDK_TYPE, 66, null, null, Integer.valueOf(isTranslucentNotitleTheme(activity) ? 2 : 1));
                }
                JAnalyticsAction jAnalyticsAction = JConstants.jAnalyticsAction;
                if (jAnalyticsAction != null) {
                    jAnalyticsAction.dispatchStatus(activity, "onStart");
                }
            }
            activityTaskCount++;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        try {
            c.c(TAG, "onActivityStopped:" + activity.getClass().getCanonicalName());
            int i = activityTaskCount;
            if (i > 0) {
                activityTaskCount = i - 1;
            }
            if (activityTaskCount == 0) {
                c.c(TAG, "is not Foreground");
                JCoreManager.onEvent(JConstants.getAppContext(activity), JConstants.SDK_TYPE, 66, null, null, 0);
            }
        } catch (Throwable unused) {
        }
    }
}
