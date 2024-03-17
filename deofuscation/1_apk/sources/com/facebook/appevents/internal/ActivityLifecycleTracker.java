package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import n.u1;
import r.e.a.d;
import r.e.a.e;

/* compiled from: ActivityLifecycleTracker.kt */
@b0(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\n\u0010 \u001a\u0004\u0018\u00010\rH\u0007J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\b\u0010#\u001a\u00020$H\u0007J\b\u0010%\u001a\u00020$H\u0007J\u0012\u0010&\u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\rH\u0002J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\rH\u0002J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\rH\u0007J\u001a\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/facebook/appevents/internal/ActivityLifecycleTracker;", "", "()V", "INCORRECT_IMPL_WARNING", "", "INTERRUPTION_THRESHOLD_MILLISECONDS", "", "TAG", "activityReferences", "", "appId", "currActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "currentActivityAppearTime", "currentFuture", "Ljava/util/concurrent/ScheduledFuture;", "currentFutureLock", "currentSession", "Lcom/facebook/appevents/internal/SessionInfo;", "foregroundActivityCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "sessionTimeoutInSeconds", "getSessionTimeoutInSeconds", "()I", "singleThreadExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "tracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancelCurrentTask", "", "getCurrentActivity", "getCurrentSessionGuid", "Ljava/util/UUID;", "isInBackground", "", "isTracking", "onActivityCreated", "activity", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "startTracking", "application", "Landroid/app/Application;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class ActivityLifecycleTracker {
    private static final String INCORRECT_IMPL_WARNING = "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method";
    @d
    public static final ActivityLifecycleTracker INSTANCE = new ActivityLifecycleTracker();
    private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000;
    private static final String TAG;
    private static int activityReferences;
    private static String appId;
    private static WeakReference<Activity> currActivity;
    private static long currentActivityAppearTime;
    private static volatile ScheduledFuture<?> currentFuture;
    private static final Object currentFutureLock;
    private static volatile SessionInfo currentSession;
    private static final AtomicInteger foregroundActivityCount;
    private static final ScheduledExecutorService singleThreadExecutor;
    private static final AtomicBoolean tracking;

    static {
        String canonicalName = ActivityLifecycleTracker.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.internal.ActivityLifecycleTracker";
        }
        TAG = canonicalName;
        singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
        currentFutureLock = new Object();
        foregroundActivityCount = new AtomicInteger(0);
        tracking = new AtomicBoolean(false);
    }

    private ActivityLifecycleTracker() {
    }

    private final void cancelCurrentTask() {
        ScheduledFuture<?> scheduledFuture;
        synchronized (currentFutureLock) {
            if (currentFuture != null && (scheduledFuture = currentFuture) != null) {
                scheduledFuture.cancel(false);
            }
            currentFuture = null;
            u1 u1Var = u1.a;
        }
    }

    @k
    @e
    public static final Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = currActivity;
        if (weakReference == null || weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @k
    @e
    public static final UUID getCurrentSessionGuid() {
        SessionInfo sessionInfo;
        if (currentSession == null || (sessionInfo = currentSession) == null) {
            return null;
        }
        return sessionInfo.getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSessionTimeoutInSeconds() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery != null) {
            return appSettingsWithoutQuery.getSessionTimeoutInSeconds();
        }
        return Constants.getDefaultAppEventsSessionTimeoutInSeconds();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @k
    public static final boolean isInBackground() {
        return activityReferences == 0;
    }

    @k
    public static final boolean isTracking() {
        return tracking.get();
    }

    @k
    public static final void onActivityCreated(@e Activity activity) {
        singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.internal.ActivityLifecycleTracker$onActivityCreated$1
            @Override // java.lang.Runnable
            public final void run() {
                SessionInfo sessionInfo;
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                    sessionInfo = ActivityLifecycleTracker.currentSession;
                    if (sessionInfo == null) {
                        ActivityLifecycleTracker.currentSession = SessionInfo.Companion.getStoredSessionInfo();
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onActivityDestroyed(Activity activity) {
        CodelessManager.onActivityDestroyed(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onActivityPaused(Activity activity) {
        AtomicInteger atomicInteger = foregroundActivityCount;
        if (atomicInteger.decrementAndGet() < 0) {
            atomicInteger.set(0);
            Log.w(TAG, INCORRECT_IMPL_WARNING);
        }
        cancelCurrentTask();
        long currentTimeMillis = System.currentTimeMillis();
        String activityName = Utility.getActivityName(activity);
        CodelessManager.onActivityPaused(activity);
        singleThreadExecutor.execute(new ActivityLifecycleTracker$onActivityPaused$handleActivityPaused$1(currentTimeMillis, activityName));
    }

    @k
    public static final void onActivityResumed(@d Activity activity) {
        f0.p(activity, "activity");
        currActivity = new WeakReference<>(activity);
        foregroundActivityCount.incrementAndGet();
        INSTANCE.cancelCurrentTask();
        final long currentTimeMillis = System.currentTimeMillis();
        currentActivityAppearTime = currentTimeMillis;
        final String activityName = Utility.getActivityName(activity);
        CodelessManager.onActivityResumed(activity);
        MetadataIndexer.onActivityResumed(activity);
        SuggestedEventsManager.trackActivity(activity);
        InAppPurchaseManager.startTracking();
        final Context applicationContext = activity.getApplicationContext();
        singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.internal.ActivityLifecycleTracker$onActivityResumed$handleActivityResume$1
            /* JADX WARN: Code restructure failed: missing block: B:19:0x0089, code lost:
                r1 = com.facebook.appevents.internal.ActivityLifecycleTracker.currentSession;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() {
                /*
                    r12 = this;
                    boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
                    if (r0 == 0) goto L7
                    return
                L7:
                    com.facebook.appevents.internal.ActivityLifecycleTracker r0 = com.facebook.appevents.internal.ActivityLifecycleTracker.INSTANCE     // Catch: java.lang.Throwable -> Lab
                    com.facebook.appevents.internal.SessionInfo r1 = com.facebook.appevents.internal.ActivityLifecycleTracker.access$getCurrentSession$p(r0)     // Catch: java.lang.Throwable -> Lab
                    r2 = 0
                    if (r1 == 0) goto L15
                    java.lang.Long r1 = r1.getSessionLastEventTime()     // Catch: java.lang.Throwable -> Lab
                    goto L16
                L15:
                    r1 = r2
                L16:
                    com.facebook.appevents.internal.SessionInfo r3 = com.facebook.appevents.internal.ActivityLifecycleTracker.access$getCurrentSession$p(r0)     // Catch: java.lang.Throwable -> Lab
                    java.lang.String r4 = "appContext"
                    if (r3 != 0) goto L40
                    com.facebook.appevents.internal.SessionInfo r1 = new com.facebook.appevents.internal.SessionInfo     // Catch: java.lang.Throwable -> Lab
                    long r5 = r1     // Catch: java.lang.Throwable -> Lab
                    java.lang.Long r6 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> Lab
                    r7 = 0
                    r8 = 0
                    r9 = 4
                    r10 = 0
                    r5 = r1
                    r5.<init>(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lab
                    com.facebook.appevents.internal.ActivityLifecycleTracker.access$setCurrentSession$p(r0, r1)     // Catch: java.lang.Throwable -> Lab
                    java.lang.String r1 = r3     // Catch: java.lang.Throwable -> Lab
                    java.lang.String r3 = com.facebook.appevents.internal.ActivityLifecycleTracker.access$getAppId$p(r0)     // Catch: java.lang.Throwable -> Lab
                    android.content.Context r5 = r4     // Catch: java.lang.Throwable -> Lab
                    n.l2.v.f0.o(r5, r4)     // Catch: java.lang.Throwable -> Lab
                    com.facebook.appevents.internal.SessionLogger.logActivateApp(r1, r2, r3, r5)     // Catch: java.lang.Throwable -> Lab
                    goto L92
                L40:
                    if (r1 == 0) goto L92
                    long r5 = r1     // Catch: java.lang.Throwable -> Lab
                    long r7 = r1.longValue()     // Catch: java.lang.Throwable -> Lab
                    long r5 = r5 - r7
                    int r1 = com.facebook.appevents.internal.ActivityLifecycleTracker.access$getSessionTimeoutInSeconds$p(r0)     // Catch: java.lang.Throwable -> Lab
                    int r1 = r1 * 1000
                    long r7 = (long) r1     // Catch: java.lang.Throwable -> Lab
                    int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                    if (r1 <= 0) goto L83
                    java.lang.String r1 = r3     // Catch: java.lang.Throwable -> Lab
                    com.facebook.appevents.internal.SessionInfo r3 = com.facebook.appevents.internal.ActivityLifecycleTracker.access$getCurrentSession$p(r0)     // Catch: java.lang.Throwable -> Lab
                    java.lang.String r5 = com.facebook.appevents.internal.ActivityLifecycleTracker.access$getAppId$p(r0)     // Catch: java.lang.Throwable -> Lab
                    com.facebook.appevents.internal.SessionLogger.logDeactivateApp(r1, r3, r5)     // Catch: java.lang.Throwable -> Lab
                    java.lang.String r1 = r3     // Catch: java.lang.Throwable -> Lab
                    java.lang.String r3 = com.facebook.appevents.internal.ActivityLifecycleTracker.access$getAppId$p(r0)     // Catch: java.lang.Throwable -> Lab
                    android.content.Context r5 = r4     // Catch: java.lang.Throwable -> Lab
                    n.l2.v.f0.o(r5, r4)     // Catch: java.lang.Throwable -> Lab
                    com.facebook.appevents.internal.SessionLogger.logActivateApp(r1, r2, r3, r5)     // Catch: java.lang.Throwable -> Lab
                    com.facebook.appevents.internal.SessionInfo r1 = new com.facebook.appevents.internal.SessionInfo     // Catch: java.lang.Throwable -> Lab
                    long r2 = r1     // Catch: java.lang.Throwable -> Lab
                    java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> Lab
                    r8 = 0
                    r9 = 0
                    r10 = 4
                    r11 = 0
                    r6 = r1
                    r6.<init>(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Lab
                    com.facebook.appevents.internal.ActivityLifecycleTracker.access$setCurrentSession$p(r0, r1)     // Catch: java.lang.Throwable -> Lab
                    goto L92
                L83:
                    r1 = 1000(0x3e8, double:4.94E-321)
                    int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                    if (r3 <= 0) goto L92
                    com.facebook.appevents.internal.SessionInfo r1 = com.facebook.appevents.internal.ActivityLifecycleTracker.access$getCurrentSession$p(r0)     // Catch: java.lang.Throwable -> Lab
                    if (r1 == 0) goto L92
                    r1.incrementInterruptionCount()     // Catch: java.lang.Throwable -> Lab
                L92:
                    com.facebook.appevents.internal.SessionInfo r1 = com.facebook.appevents.internal.ActivityLifecycleTracker.access$getCurrentSession$p(r0)     // Catch: java.lang.Throwable -> Lab
                    if (r1 == 0) goto La1
                    long r2 = r1     // Catch: java.lang.Throwable -> Lab
                    java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> Lab
                    r1.setSessionLastEventTime(r2)     // Catch: java.lang.Throwable -> Lab
                La1:
                    com.facebook.appevents.internal.SessionInfo r0 = com.facebook.appevents.internal.ActivityLifecycleTracker.access$getCurrentSession$p(r0)     // Catch: java.lang.Throwable -> Lab
                    if (r0 == 0) goto Laa
                    r0.writeSessionToDisk()     // Catch: java.lang.Throwable -> Lab
                Laa:
                    return
                Lab:
                    r0 = move-exception
                    com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r12)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.ActivityLifecycleTracker$onActivityResumed$handleActivityResume$1.run():void");
            }
        });
    }

    @k
    public static final void startTracking(@d Application application, @e String str) {
        f0.p(application, "application");
        if (tracking.compareAndSet(false, true)) {
            FeatureManager.checkFeature(FeatureManager.Feature.CodelessEvents, new FeatureManager.Callback() { // from class: com.facebook.appevents.internal.ActivityLifecycleTracker$startTracking$1
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    if (z) {
                        CodelessManager.enable();
                    } else {
                        CodelessManager.disable();
                    }
                }
            });
            appId = str;
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.facebook.appevents.internal.ActivityLifecycleTracker$startTracking$2
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(@d Activity activity, @e Bundle bundle) {
                    String str2;
                    f0.p(activity, "activity");
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                    str2 = ActivityLifecycleTracker.TAG;
                    companion.log(loggingBehavior, str2, "onActivityCreated");
                    AppEventUtility.assertIsMainThread();
                    ActivityLifecycleTracker.onActivityCreated(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(@d Activity activity) {
                    String str2;
                    f0.p(activity, "activity");
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                    str2 = ActivityLifecycleTracker.TAG;
                    companion.log(loggingBehavior, str2, "onActivityDestroyed");
                    activityLifecycleTracker.onActivityDestroyed(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(@d Activity activity) {
                    String str2;
                    f0.p(activity, "activity");
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                    str2 = ActivityLifecycleTracker.TAG;
                    companion.log(loggingBehavior, str2, "onActivityPaused");
                    AppEventUtility.assertIsMainThread();
                    activityLifecycleTracker.onActivityPaused(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(@d Activity activity) {
                    String str2;
                    f0.p(activity, "activity");
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                    str2 = ActivityLifecycleTracker.TAG;
                    companion.log(loggingBehavior, str2, "onActivityResumed");
                    AppEventUtility.assertIsMainThread();
                    ActivityLifecycleTracker.onActivityResumed(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(@d Activity activity, @d Bundle bundle) {
                    String str2;
                    f0.p(activity, "activity");
                    f0.p(bundle, "outState");
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                    str2 = ActivityLifecycleTracker.TAG;
                    companion.log(loggingBehavior, str2, "onActivitySaveInstanceState");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(@d Activity activity) {
                    int i;
                    String str2;
                    f0.p(activity, "activity");
                    ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                    i = ActivityLifecycleTracker.activityReferences;
                    ActivityLifecycleTracker.activityReferences = i + 1;
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    str2 = ActivityLifecycleTracker.TAG;
                    companion.log(loggingBehavior, str2, "onActivityStarted");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(@d Activity activity) {
                    String str2;
                    int i;
                    f0.p(activity, "activity");
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                    str2 = ActivityLifecycleTracker.TAG;
                    companion.log(loggingBehavior, str2, "onActivityStopped");
                    AppEventsLogger.Companion.onContextStop();
                    i = ActivityLifecycleTracker.activityReferences;
                    ActivityLifecycleTracker.activityReferences = i - 1;
                }
            });
        }
    }
}
