package com.facebook.appevents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest$Callback;
import com.facebook.GraphRequest$Companion;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import n.l2.v.s0;
import org.json.JSONArray;
import org.json.JSONException;
import r.e.a.d;
import r.e.a.e;

/* compiled from: AppEventQueue.kt */
@b0(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J*\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190!2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001fH\u0007J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0007J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0007J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00150(H\u0007J0\u0010)\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010-\u001a\u00020\u0013H\u0007J\u001a\u0010.\u001a\u0004\u0018\u00010\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/facebook/appevents/AppEventQueue;", "", "()V", "FLUSH_PERIOD_IN_SECONDS", "", "NO_CONNECTIVITY_ERROR_CODE", "NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER", "TAG", "", "appEventCollection", "Lcom/facebook/appevents/AppEventCollection;", "flushRunnable", "Ljava/lang/Runnable;", "scheduledFuture", "Ljava/util/concurrent/ScheduledFuture;", "singleThreadExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "add", "", "accessTokenAppId", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "appEvent", "Lcom/facebook/appevents/AppEvent;", "buildRequestForSession", "Lcom/facebook/GraphRequest;", "appEvents", "Lcom/facebook/appevents/SessionEventsState;", "limitEventUsage", "", "flushState", "Lcom/facebook/appevents/FlushStatistics;", "buildRequests", "", "flushResults", "flush", "reason", "Lcom/facebook/appevents/FlushReason;", "flushAndWait", "getKeySet", "", "handleResponse", "request", "response", "Lcom/facebook/GraphResponse;", "persistToDisk", "sendEventsToServer", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class AppEventQueue {
    private static final int FLUSH_PERIOD_IN_SECONDS = 15;
    @d
    public static final AppEventQueue INSTANCE = new AppEventQueue();
    private static final int NO_CONNECTIVITY_ERROR_CODE = -1;
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER;
    private static final String TAG;
    private static volatile AppEventCollection appEventCollection;
    private static final Runnable flushRunnable;
    private static ScheduledFuture<?> scheduledFuture;
    private static final ScheduledExecutorService singleThreadExecutor;

    static {
        String name = AppEventQueue.class.getName();
        f0.o(name, "AppEventQueue::class.java.name");
        TAG = name;
        NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
        appEventCollection = new AppEventCollection();
        singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
        flushRunnable = new Runnable() { // from class: com.facebook.appevents.AppEventQueue$flushRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    AppEventQueue.access$setScheduledFuture$p(AppEventQueue.INSTANCE, null);
                    if (AppEventsLogger.Companion.getFlushBehavior() != AppEventsLogger$FlushBehavior.EXPLICIT_ONLY) {
                        AppEventQueue.flushAndWait(FlushReason.TIMER);
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        };
    }

    private AppEventQueue() {
    }

    public static final /* synthetic */ AppEventCollection access$getAppEventCollection$p(AppEventQueue appEventQueue) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            return appEventCollection;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }

    public static final /* synthetic */ Runnable access$getFlushRunnable$p(AppEventQueue appEventQueue) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            return flushRunnable;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }

    public static final /* synthetic */ int access$getNUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER$p(AppEventQueue appEventQueue) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return 0;
        }
        try {
            return NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return 0;
        }
    }

    public static final /* synthetic */ ScheduledFuture access$getScheduledFuture$p(AppEventQueue appEventQueue) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            return scheduledFuture;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }

    public static final /* synthetic */ ScheduledExecutorService access$getSingleThreadExecutor$p(AppEventQueue appEventQueue) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            return singleThreadExecutor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$setAppEventCollection$p(AppEventQueue appEventQueue, AppEventCollection appEventCollection2) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            appEventCollection = appEventCollection2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    public static final /* synthetic */ void access$setScheduledFuture$p(AppEventQueue appEventQueue, ScheduledFuture scheduledFuture2) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            scheduledFuture = scheduledFuture2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @k
    public static final void add(@d final AccessTokenAppIdPair accessTokenAppIdPair, @d final AppEvent appEvent) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            f0.p(accessTokenAppIdPair, "accessTokenAppId");
            f0.p(appEvent, "appEvent");
            singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.AppEventQueue$add$1
                @Override // java.lang.Runnable
                public final void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        AppEventQueue appEventQueue = AppEventQueue.INSTANCE;
                        AppEventQueue.access$getAppEventCollection$p(appEventQueue).addEvent(AccessTokenAppIdPair.this, appEvent);
                        if (AppEventsLogger.Companion.getFlushBehavior() != AppEventsLogger$FlushBehavior.EXPLICIT_ONLY && AppEventQueue.access$getAppEventCollection$p(appEventQueue).getEventCount() > AppEventQueue.access$getNUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER$p(appEventQueue)) {
                            AppEventQueue.flushAndWait(FlushReason.EVENT_THRESHOLD);
                        } else if (AppEventQueue.access$getScheduledFuture$p(appEventQueue) == null) {
                            AppEventQueue.access$setScheduledFuture$p(appEventQueue, AppEventQueue.access$getSingleThreadExecutor$p(appEventQueue).schedule(AppEventQueue.access$getFlushRunnable$p(appEventQueue), 15, TimeUnit.SECONDS));
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @k
    @e
    public static final GraphRequest buildRequestForSession(@d final AccessTokenAppIdPair accessTokenAppIdPair, @d final SessionEventsState sessionEventsState, boolean z, @d final FlushStatistics flushStatistics) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            f0.p(accessTokenAppIdPair, "accessTokenAppId");
            f0.p(sessionEventsState, "appEvents");
            f0.p(flushStatistics, "flushState");
            String applicationId = accessTokenAppIdPair.getApplicationId();
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
            GraphRequest$Companion graphRequest$Companion = GraphRequest.Companion;
            s0 s0Var = s0.a;
            String format = String.format("%s/activities", Arrays.copyOf(new Object[]{applicationId}, 1));
            f0.o(format, "java.lang.String.format(format, *args)");
            final GraphRequest newPostRequest = graphRequest$Companion.newPostRequest(null, format, null, null);
            newPostRequest.setForceApplicationRequest(true);
            Bundle parameters = newPostRequest.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            parameters.putString("access_token", accessTokenAppIdPair.getAccessTokenString());
            String pushNotificationsRegistrationId = InternalAppEventsLogger.Companion.getPushNotificationsRegistrationId();
            if (pushNotificationsRegistrationId != null) {
                parameters.putString(RemoteMessageConst.DEVICE_TOKEN, pushNotificationsRegistrationId);
            }
            String installReferrer = AppEventsLoggerImpl.Companion.getInstallReferrer();
            if (installReferrer != null) {
                parameters.putString("install_referrer", installReferrer);
            }
            newPostRequest.setParameters(parameters);
            boolean supportsImplicitLogging = queryAppSettings != null ? queryAppSettings.supportsImplicitLogging() : false;
            Context applicationContext = FacebookSdk.getApplicationContext();
            f0.o(applicationContext, "FacebookSdk.getApplicationContext()");
            int populateRequest = sessionEventsState.populateRequest(newPostRequest, applicationContext, supportsImplicitLogging, z);
            if (populateRequest == 0) {
                return null;
            }
            flushStatistics.setNumEvents(flushStatistics.getNumEvents() + populateRequest);
            newPostRequest.setCallback(new GraphRequest$Callback() { // from class: com.facebook.appevents.AppEventQueue$buildRequestForSession$1
                @Override // com.facebook.GraphRequest$Callback
                public final void onCompleted(@d GraphResponse graphResponse) {
                    f0.p(graphResponse, "response");
                    AppEventQueue.handleResponse(AccessTokenAppIdPair.this, newPostRequest, graphResponse, sessionEventsState, flushStatistics);
                }
            });
            return newPostRequest;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }

    @d
    @k
    public static final List<GraphRequest> buildRequests(@d AppEventCollection appEventCollection2, @d FlushStatistics flushStatistics) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            f0.p(appEventCollection2, "appEventCollection");
            f0.p(flushStatistics, "flushResults");
            boolean limitEventAndDataUsage = FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext());
            ArrayList arrayList = new ArrayList();
            for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection2.keySet()) {
                SessionEventsState sessionEventsState = appEventCollection2.get(accessTokenAppIdPair);
                if (sessionEventsState != null) {
                    GraphRequest buildRequestForSession = buildRequestForSession(accessTokenAppIdPair, sessionEventsState, limitEventAndDataUsage, flushStatistics);
                    if (buildRequestForSession != null) {
                        arrayList.add(buildRequestForSession);
                    }
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }

    @k
    public static final void flush(@d final FlushReason flushReason) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            f0.p(flushReason, "reason");
            singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.AppEventQueue$flush$1
                @Override // java.lang.Runnable
                public final void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        AppEventQueue.flushAndWait(FlushReason.this);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @k
    public static final void flushAndWait(@d FlushReason flushReason) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            f0.p(flushReason, "reason");
            appEventCollection.addPersistedEvents(AppEventStore.readAndClearStore());
            try {
                FlushStatistics sendEventsToServer = sendEventsToServer(flushReason, appEventCollection);
                if (sendEventsToServer != null) {
                    Intent intent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
                    intent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", sendEventsToServer.getNumEvents());
                    intent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", sendEventsToServer.getResult());
                    LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()).sendBroadcast(intent);
                }
            } catch (Exception e) {
                Log.w(TAG, "Caught unexpected exception while flushing app events: ", e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @d
    @k
    public static final Set<AccessTokenAppIdPair> getKeySet() {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            return appEventCollection.keySet();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }

    @k
    public static final void handleResponse(@d final AccessTokenAppIdPair accessTokenAppIdPair, @d GraphRequest graphRequest, @d GraphResponse graphResponse, @d final SessionEventsState sessionEventsState, @d FlushStatistics flushStatistics) {
        String str;
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            f0.p(accessTokenAppIdPair, "accessTokenAppId");
            f0.p(graphRequest, "request");
            f0.p(graphResponse, "response");
            f0.p(sessionEventsState, "appEvents");
            f0.p(flushStatistics, "flushState");
            FacebookRequestError error = graphResponse.getError();
            String str2 = "Success";
            FlushResult flushResult = FlushResult.SUCCESS;
            boolean z = true;
            if (error != null) {
                if (error.getErrorCode() == -1) {
                    str2 = "Failed: No Connectivity";
                    flushResult = FlushResult.NO_CONNECTIVITY;
                } else {
                    s0 s0Var = s0.a;
                    str2 = String.format("Failed:\n  Response: %s\n  Error %s", Arrays.copyOf(new Object[]{graphResponse.toString(), error.toString()}, 2));
                    f0.o(str2, "java.lang.String.format(format, *args)");
                    flushResult = FlushResult.SERVER_ERROR;
                }
            }
            if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
                try {
                    str = new JSONArray((String) graphRequest.getTag()).toString(2);
                    f0.o(str, "jsonArray.toString(2)");
                } catch (JSONException unused) {
                    str = "<Can't encode events for debug logging>";
                }
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", String.valueOf(graphRequest.getGraphObject()), str2, str);
            }
            if (error == null) {
                z = false;
            }
            sessionEventsState.clearInFlightAndStats(z);
            FlushResult flushResult2 = FlushResult.NO_CONNECTIVITY;
            if (flushResult == flushResult2) {
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.AppEventQueue$handleResponse$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            AppEventStore.persistEvents(AccessTokenAppIdPair.this, sessionEventsState);
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    }
                });
            }
            if (flushResult == FlushResult.SUCCESS || flushStatistics.getResult() == flushResult2) {
                return;
            }
            flushStatistics.setResult(flushResult);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @k
    public static final void persistToDisk() {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.AppEventQueue$persistToDisk$1
                @Override // java.lang.Runnable
                public final void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        AppEventQueue appEventQueue = AppEventQueue.INSTANCE;
                        AppEventStore.persistEvents(AppEventQueue.access$getAppEventCollection$p(appEventQueue));
                        AppEventQueue.access$setAppEventCollection$p(appEventQueue, new AppEventCollection());
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @VisibleForTesting(otherwise = 2)
    @k
    @e
    public static final FlushStatistics sendEventsToServer(@d FlushReason flushReason, @d AppEventCollection appEventCollection2) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            f0.p(flushReason, "reason");
            f0.p(appEventCollection2, "appEventCollection");
            FlushStatistics flushStatistics = new FlushStatistics();
            List<GraphRequest> buildRequests = buildRequests(appEventCollection2, flushStatistics);
            if (!buildRequests.isEmpty()) {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", Integer.valueOf(flushStatistics.getNumEvents()), flushReason.toString());
                for (GraphRequest graphRequest : buildRequests) {
                    graphRequest.executeAndWait();
                }
                return flushStatistics;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }
}
