package com.facebook.appevents.iap;

import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;
import com.alipay.sdk.util.g;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class InAppPurchaseLoggerManager {
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final String LAST_QUERY_PURCHASE_HISTORY_TIME = "LAST_QUERY_PURCHASE_HISTORY_TIME";
    private static final String PRODUCT_DETAILS_STORE = "com.facebook.internal.iap.PRODUCT_DETAILS";
    private static final String PURCHASE_DETAILS_SET = "PURCHASE_DETAILS_SET";
    private static final int PURCHASE_IN_CACHE_INTERVAL = 86400;
    private static final String PURCHASE_TIME = "purchaseTime";
    private static SharedPreferences sharedPreferences;
    private static final Set<String> cachedPurchaseSet = new CopyOnWriteArraySet();
    private static final Map<String, Long> cachedPurchaseMap = new ConcurrentHashMap();

    public static Map<String, JSONObject> cacheDeDupPurchase(Map<String, JSONObject> map) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            for (Map.Entry entry : new HashMap(map).entrySet()) {
                try {
                    JSONObject jSONObject = (JSONObject) entry.getValue();
                    if (jSONObject.has("purchaseToken")) {
                        String string = jSONObject.getString("purchaseToken");
                        if (cachedPurchaseMap.containsKey(string)) {
                            map.remove(entry.getKey());
                        } else {
                            Set<String> set = cachedPurchaseSet;
                            set.add(string + ';' + currentTimeMillis);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            sharedPreferences.edit().putStringSet(PURCHASE_DETAILS_SET, cachedPurchaseSet).apply();
            return new HashMap(map);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseLoggerManager.class);
            return null;
        }
    }

    private static void clearOutdatedProductInfoInCache() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j = sharedPreferences.getLong(LAST_CLEARED_TIME, 0L);
            if (j == 0) {
                sharedPreferences.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
            } else if (currentTimeMillis - j > 604800) {
                for (Map.Entry entry : new HashMap(cachedPurchaseMap).entrySet()) {
                    String str = (String) entry.getKey();
                    Long l = (Long) entry.getValue();
                    if (currentTimeMillis - l.longValue() > 86400) {
                        Set<String> set = cachedPurchaseSet;
                        set.remove(str + g.b + l);
                        cachedPurchaseMap.remove(str);
                    }
                }
                sharedPreferences.edit().putStringSet(PURCHASE_DETAILS_SET, cachedPurchaseSet).putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseLoggerManager.class);
        }
    }

    public static Map<String, String> constructLoggingReadyMap(Map<String, JSONObject> map, Map<String, JSONObject> map2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, JSONObject> entry : map.entrySet()) {
                JSONObject jSONObject = map2.get(entry.getKey());
                JSONObject value = entry.getValue();
                if (value != null && value.has(PURCHASE_TIME)) {
                    try {
                        if (currentTimeMillis - (value.getLong(PURCHASE_TIME) / 1000) <= 86400 && jSONObject != null) {
                            hashMap.put(value.toString(), jSONObject.toString());
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return hashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseLoggerManager.class);
            return null;
        }
    }

    public static boolean eligibleQueryPurchaseHistory() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return false;
        }
        try {
            readPurchaseCache();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j = sharedPreferences.getLong(LAST_QUERY_PURCHASE_HISTORY_TIME, 0L);
            if (j == 0 || currentTimeMillis - j >= 86400) {
                sharedPreferences.edit().putLong(LAST_QUERY_PURCHASE_HISTORY_TIME, currentTimeMillis).apply();
                return true;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseLoggerManager.class);
            return false;
        }
    }

    public static void filterPurchaseLogging(Map<String, JSONObject> map, Map<String, JSONObject> map2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return;
        }
        try {
            readPurchaseCache();
            logPurchases(new HashMap(constructLoggingReadyMap(cacheDeDupPurchase(map), map2)));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseLoggerManager.class);
        }
    }

    public static void logPurchases(Map<String, String> map) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null) {
                    AutomaticAnalyticsLogger.logPurchase(key, value, false);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseLoggerManager.class);
        }
    }

    private static void readPurchaseCache() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences2 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
            SharedPreferences sharedPreferences3 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
            if (sharedPreferences2.contains(LAST_CLEARED_TIME)) {
                sharedPreferences2.edit().clear().apply();
                sharedPreferences3.edit().clear().apply();
            }
            SharedPreferences sharedPreferences4 = FacebookSdk.getApplicationContext().getSharedPreferences(PRODUCT_DETAILS_STORE, 0);
            sharedPreferences = sharedPreferences4;
            Set<String> set = cachedPurchaseSet;
            set.addAll(sharedPreferences4.getStringSet(PURCHASE_DETAILS_SET, new HashSet()));
            for (String str : set) {
                String[] split = str.split(g.b, 2);
                cachedPurchaseMap.put(split[0], Long.valueOf(Long.parseLong(split[1])));
            }
            clearOutdatedProductInfoInCache();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseLoggerManager.class);
        }
    }
}
