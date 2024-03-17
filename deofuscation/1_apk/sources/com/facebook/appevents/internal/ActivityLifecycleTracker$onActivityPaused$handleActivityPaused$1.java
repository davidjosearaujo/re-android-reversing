package com.facebook.appevents.internal;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import n.b0;
import n.u1;

/* compiled from: ActivityLifecycleTracker.kt */
@b0(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class ActivityLifecycleTracker$onActivityPaused$handleActivityPaused$1 implements Runnable {
    public final /* synthetic */ String $activityName;
    public final /* synthetic */ long $currentTime;

    public ActivityLifecycleTracker$onActivityPaused$handleActivityPaused$1(long j, String str) {
        this.$currentTime = j;
        this.$activityName = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SessionInfo sessionInfo;
        SessionInfo sessionInfo2;
        AtomicInteger atomicInteger;
        long j;
        SessionInfo sessionInfo3;
        Object obj;
        ScheduledExecutorService scheduledExecutorService;
        int sessionTimeoutInSeconds;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
            sessionInfo = ActivityLifecycleTracker.currentSession;
            if (sessionInfo == null) {
                ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(this.$currentTime), null, null, 4, null);
            }
            sessionInfo2 = ActivityLifecycleTracker.currentSession;
            if (sessionInfo2 != null) {
                sessionInfo2.setSessionLastEventTime(Long.valueOf(this.$currentTime));
            }
            atomicInteger = ActivityLifecycleTracker.foregroundActivityCount;
            if (atomicInteger.get() <= 0) {
                Runnable runnable = new Runnable() { // from class: com.facebook.appevents.internal.ActivityLifecycleTracker$onActivityPaused$handleActivityPaused$1$task$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SessionInfo sessionInfo4;
                        AtomicInteger atomicInteger2;
                        Object obj2;
                        SessionInfo sessionInfo5;
                        String str;
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            ActivityLifecycleTracker activityLifecycleTracker2 = ActivityLifecycleTracker.INSTANCE;
                            sessionInfo4 = ActivityLifecycleTracker.currentSession;
                            if (sessionInfo4 == null) {
                                ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(ActivityLifecycleTracker$onActivityPaused$handleActivityPaused$1.this.$currentTime), null, null, 4, null);
                            }
                            atomicInteger2 = ActivityLifecycleTracker.foregroundActivityCount;
                            if (atomicInteger2.get() <= 0) {
                                String str2 = ActivityLifecycleTracker$onActivityPaused$handleActivityPaused$1.this.$activityName;
                                sessionInfo5 = ActivityLifecycleTracker.currentSession;
                                str = ActivityLifecycleTracker.appId;
                                SessionLogger.logDeactivateApp(str2, sessionInfo5, str);
                                SessionInfo.Companion.clearSavedSessionFromDisk();
                                ActivityLifecycleTracker.currentSession = null;
                            }
                            obj2 = ActivityLifecycleTracker.currentFutureLock;
                            synchronized (obj2) {
                                ActivityLifecycleTracker.currentFuture = null;
                                u1 u1Var = u1.a;
                            }
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    }
                };
                obj = ActivityLifecycleTracker.currentFutureLock;
                synchronized (obj) {
                    scheduledExecutorService = ActivityLifecycleTracker.singleThreadExecutor;
                    sessionTimeoutInSeconds = activityLifecycleTracker.getSessionTimeoutInSeconds();
                    ActivityLifecycleTracker.currentFuture = scheduledExecutorService.schedule(runnable, sessionTimeoutInSeconds, TimeUnit.SECONDS);
                    u1 u1Var = u1.a;
                }
            }
            j = ActivityLifecycleTracker.currentActivityAppearTime;
            AutomaticAnalyticsLogger.logActivityTimeSpentEvent(this.$activityName, j > 0 ? (this.$currentTime - j) / 1000 : 0L);
            sessionInfo3 = ActivityLifecycleTracker.currentSession;
            if (sessionInfo3 != null) {
                sessionInfo3.writeSessionToDisk();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
