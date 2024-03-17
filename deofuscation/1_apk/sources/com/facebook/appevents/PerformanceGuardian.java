package com.facebook.appevents;

import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import r.e.a.d;
import r.e.a.e;

/* compiled from: PerformanceGuardian.kt */
@b0(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0003J\u001a\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002J,\u0010\u001b\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J:\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00062\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/facebook/appevents/PerformanceGuardian;", "", "()V", "ACTIVITY_PROCESS_TIME_THRESHOLD", "", "BANNED_ACTIVITY_STORE", "", "CACHE_APP_VERSION", "MAX_EXCEED_LIMIT_COUNT", "activityProcessTimeMapCodeless", "", "activityProcessTimeMapSe", "bannedCodelessActivitySet", "", "bannedSuggestedEventActivitySet", "initialized", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "initializeIfNotYet", "", "isBannedActivity", "activityName", "useCase", "Lcom/facebook/appevents/PerformanceGuardian$UseCase;", "isCacheValid", "previousVersion", "limitProcessTime", "startTime", "", SDKConstants.PARAM_END_TIME, "updateActivityMap", "activityExceedLimitCountMap", "bannedActivitySet", "UseCase", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class PerformanceGuardian {
    private static final int ACTIVITY_PROCESS_TIME_THRESHOLD = 40;
    private static final String BANNED_ACTIVITY_STORE = "com.facebook.internal.BANNED_ACTIVITY";
    private static final String CACHE_APP_VERSION = "app_version";
    private static final int MAX_EXCEED_LIMIT_COUNT = 3;
    private static boolean initialized;
    private static SharedPreferences sharedPreferences;
    @d
    public static final PerformanceGuardian INSTANCE = new PerformanceGuardian();
    private static final Set<String> bannedSuggestedEventActivitySet = new HashSet();
    private static final Set<String> bannedCodelessActivitySet = new HashSet();
    private static final Map<String, Integer> activityProcessTimeMapCodeless = new HashMap();
    private static final Map<String, Integer> activityProcessTimeMapSe = new HashMap();

    /* compiled from: PerformanceGuardian.kt */
    @b0(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/PerformanceGuardian$UseCase;", "", "(Ljava/lang/String;I)V", "CODELESS", "SUGGESTED_EVENT", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum UseCase {
        CODELESS,
        SUGGESTED_EVENT
    }

    @b0(k = 3, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[UseCase.values().length];
            $EnumSwitchMapping$0 = iArr;
            UseCase useCase = UseCase.CODELESS;
            iArr[useCase.ordinal()] = 1;
            UseCase useCase2 = UseCase.SUGGESTED_EVENT;
            iArr[useCase2.ordinal()] = 2;
            int[] iArr2 = new int[UseCase.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[useCase.ordinal()] = 1;
            iArr2[useCase2.ordinal()] = 2;
        }
    }

    private PerformanceGuardian() {
    }

    @k
    private static final synchronized void initializeIfNotYet() {
        synchronized (PerformanceGuardian.class) {
            if (CrashShieldHandler.isObjectCrashing(PerformanceGuardian.class)) {
                return;
            }
            if (initialized) {
                return;
            }
            SharedPreferences sharedPreferences2 = FacebookSdk.getApplicationContext().getSharedPreferences(BANNED_ACTIVITY_STORE, 0);
            f0.o(sharedPreferences2, "FacebookSdk.getApplicati…RE, Context.MODE_PRIVATE)");
            sharedPreferences = sharedPreferences2;
            if (sharedPreferences2 == null) {
                f0.S("sharedPreferences");
            }
            if (!INSTANCE.isCacheValid(sharedPreferences2.getString(CACHE_APP_VERSION, ""))) {
                SharedPreferences sharedPreferences3 = sharedPreferences;
                if (sharedPreferences3 == null) {
                    f0.S("sharedPreferences");
                }
                sharedPreferences3.edit().clear().apply();
            } else {
                Set<String> set = bannedCodelessActivitySet;
                SharedPreferences sharedPreferences4 = sharedPreferences;
                if (sharedPreferences4 == null) {
                    f0.S("sharedPreferences");
                }
                Set<String> stringSet = sharedPreferences4.getStringSet(UseCase.CODELESS.toString(), new LinkedHashSet());
                if (stringSet == null) {
                    stringSet = new LinkedHashSet<>();
                }
                set.addAll(stringSet);
                Set<String> set2 = bannedSuggestedEventActivitySet;
                SharedPreferences sharedPreferences5 = sharedPreferences;
                if (sharedPreferences5 == null) {
                    f0.S("sharedPreferences");
                }
                Set<String> stringSet2 = sharedPreferences5.getStringSet(UseCase.SUGGESTED_EVENT.toString(), new LinkedHashSet());
                if (stringSet2 == null) {
                    stringSet2 = new LinkedHashSet<>();
                }
                set2.addAll(stringSet2);
            }
            initialized = true;
        }
    }

    @k
    public static final boolean isBannedActivity(@d String str, @e UseCase useCase) {
        if (CrashShieldHandler.isObjectCrashing(PerformanceGuardian.class)) {
            return false;
        }
        try {
            f0.p(str, "activityName");
            initializeIfNotYet();
            if (useCase != null) {
                int i = WhenMappings.$EnumSwitchMapping$0[useCase.ordinal()];
                if (i == 1) {
                    return bannedCodelessActivitySet.contains(str);
                }
                if (i == 2) {
                    return bannedSuggestedEventActivitySet.contains(str);
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PerformanceGuardian.class);
            return false;
        }
    }

    private final boolean isCacheValid(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            String appVersion = Utility.getAppVersion();
            if (appVersion == null || str == null) {
                return false;
            }
            if (str.length() == 0) {
                return false;
            }
            return f0.g(str, appVersion);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    @k
    public static final void limitProcessTime(@e String str, @e UseCase useCase, long j, long j2) {
        if (CrashShieldHandler.isObjectCrashing(PerformanceGuardian.class)) {
            return;
        }
        try {
            initializeIfNotYet();
            long j3 = j2 - j;
            if (str != null && j3 >= 40 && useCase != null) {
                int i = WhenMappings.$EnumSwitchMapping$1[useCase.ordinal()];
                if (i == 1) {
                    INSTANCE.updateActivityMap(useCase, str, activityProcessTimeMapCodeless, bannedCodelessActivitySet);
                } else if (i != 2) {
                } else {
                    INSTANCE.updateActivityMap(useCase, str, activityProcessTimeMapSe, bannedSuggestedEventActivitySet);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PerformanceGuardian.class);
        }
    }

    private final void updateActivityMap(UseCase useCase, String str, Map<String, Integer> map, Set<String> set) {
        Integer num;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            int i = 0;
            if (map.containsKey(str) && (num = map.get(str)) != null) {
                i = num.intValue();
            }
            int i2 = i + 1;
            map.put(str, Integer.valueOf(i2));
            if (i2 >= 3) {
                set.add(str);
                SharedPreferences sharedPreferences2 = sharedPreferences;
                if (sharedPreferences2 == null) {
                    f0.S("sharedPreferences");
                }
                sharedPreferences2.edit().putStringSet(useCase.toString(), set).putString(CACHE_APP_VERSION, Utility.getAppVersion()).apply();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
