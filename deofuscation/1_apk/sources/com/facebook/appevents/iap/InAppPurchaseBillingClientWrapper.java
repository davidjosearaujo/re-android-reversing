package com.facebook.appevents.iap;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class InAppPurchaseBillingClientWrapper {
    private static final String CLASSNAME_BILLING_CLIENT = "com.android.billingclient.api.BillingClient";
    private static final String CLASSNAME_BILLING_CLIENT_BUILDER = "com.android.billingclient.api.BillingClient$Builder";
    private static final String CLASSNAME_BILLING_CLIENT_STATE_LISTENER = "com.android.billingclient.api.BillingClientStateListener";
    private static final String CLASSNAME_PURCHASE = "com.android.billingclient.api.Purchase";
    private static final String CLASSNAME_PURCHASES_RESULT = "com.android.billingclient.api.Purchase$PurchasesResult";
    private static final String CLASSNAME_PURCHASE_HISTORY_RECORD = "com.android.billingclient.api.PurchaseHistoryRecord";
    private static final String CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER = "com.android.billingclient.api.PurchaseHistoryResponseListener";
    private static final String CLASSNAME_PURCHASE_UPDATED_LISTENER = "com.android.billingclient.api.PurchasesUpdatedListener";
    private static final String CLASSNAME_SKU_DETAILS = "com.android.billingclient.api.SkuDetails";
    private static final String CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER = "com.android.billingclient.api.SkuDetailsResponseListener";
    private static final String IN_APP = "inapp";
    private static final String METHOD_BUILD = "build";
    private static final String METHOD_ENABLE_PENDING_PURCHASES = "enablePendingPurchases";
    private static final String METHOD_GET_ORIGINAL_JSON = "getOriginalJson";
    private static final String METHOD_GET_PURCHASE_LIST = "getPurchasesList";
    private static final String METHOD_NEW_BUILDER = "newBuilder";
    private static final String METHOD_ON_BILLING_SERVICE_DISCONNECTED = "onBillingServiceDisconnected";
    private static final String METHOD_ON_BILLING_SETUP_FINISHED = "onBillingSetupFinished";
    private static final String METHOD_ON_PURCHASE_HISTORY_RESPONSE = "onPurchaseHistoryResponse";
    private static final String METHOD_ON_SKU_DETAILS_RESPONSE = "onSkuDetailsResponse";
    private static final String METHOD_QUERY_PURCHASES = "queryPurchases";
    private static final String METHOD_QUERY_PURCHASE_HISTORY_ASYNC = "queryPurchaseHistoryAsync";
    private static final String METHOD_QUERY_SKU_DETAILS_ASYNC = "querySkuDetailsAsync";
    private static final String METHOD_SET_LISTENER = "setListener";
    private static final String METHOD_START_CONNECTION = "startConnection";
    private static final String PACKAGE_NAME = "packageName";
    private static final String PRODUCT_ID = "productId";
    private final Class<?> PurchaseHistoryRecordClazz;
    private final Object billingClient;
    private final Class<?> billingClientClazz;
    private final Context context;
    private final Method getOriginalJsonMethod;
    private final Method getOriginalJsonPurchaseHistoryMethod;
    private final Method getOriginalJsonSkuMethod;
    private final Method getPurchaseListMethod;
    private final Set<String> historyPurchaseSet = new CopyOnWriteArraySet();
    private final InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper;
    private final Class<?> purchaseClazz;
    private final Class<?> purchaseHistoryResponseListenerClazz;
    private final Class<?> purchaseResultClazz;
    private final Method queryPurchaseHistoryAsyncMethod;
    private final Method queryPurchasesMethod;
    private final Method querySkuDetailsAsyncMethod;
    private final Class<?> skuDetailsClazz;
    private final Class<?> skuDetailsResponseListenerClazz;
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    @Nullable
    private static InAppPurchaseBillingClientWrapper mInstance = null;
    public static final AtomicBoolean isServiceConnected = new AtomicBoolean(false);
    public static final Map<String, JSONObject> purchaseDetailsMap = new ConcurrentHashMap();
    public static final Map<String, JSONObject> skuDetailsMap = new ConcurrentHashMap();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class BillingClientStateListenerWrapper implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().equals(InAppPurchaseBillingClientWrapper.METHOD_ON_BILLING_SETUP_FINISHED)) {
                InAppPurchaseBillingClientWrapper.isServiceConnected.set(true);
                return null;
            } else if (method.getName().endsWith(InAppPurchaseBillingClientWrapper.METHOD_ON_BILLING_SERVICE_DISCONNECTED)) {
                InAppPurchaseBillingClientWrapper.isServiceConnected.set(false);
                return null;
            } else {
                return null;
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class PurchaseHistoryResponseListenerWrapper implements InvocationHandler {
        public Runnable runnable;

        public PurchaseHistoryResponseListenerWrapper(Runnable runnable) {
            InAppPurchaseBillingClientWrapper.this = r1;
            this.runnable = runnable;
        }

        private void getPurchaseHistoryRecord(List<?> list) {
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                try {
                    Object invokeMethod = InAppPurchaseUtils.invokeMethod(InAppPurchaseBillingClientWrapper.access$200(InAppPurchaseBillingClientWrapper.this), InAppPurchaseBillingClientWrapper.access$300(InAppPurchaseBillingClientWrapper.this), it.next(), new Object[0]);
                    if (invokeMethod instanceof String) {
                        JSONObject jSONObject = new JSONObject((String) invokeMethod);
                        jSONObject.put("packageName", InAppPurchaseBillingClientWrapper.access$400(InAppPurchaseBillingClientWrapper.this).getPackageName());
                        if (jSONObject.has(InAppPurchaseBillingClientWrapper.PRODUCT_ID)) {
                            String string = jSONObject.getString(InAppPurchaseBillingClientWrapper.PRODUCT_ID);
                            InAppPurchaseBillingClientWrapper.access$000(InAppPurchaseBillingClientWrapper.this).add(string);
                            InAppPurchaseBillingClientWrapper.purchaseDetailsMap.put(string, jSONObject);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            this.runnable.run();
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().equals(InAppPurchaseBillingClientWrapper.METHOD_ON_PURCHASE_HISTORY_RESPONSE)) {
                Object obj2 = objArr[1];
                if (obj2 instanceof List) {
                    getPurchaseHistoryRecord((List) obj2);
                    return null;
                }
                return null;
            }
            return null;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class PurchasesUpdatedListenerWrapper implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(Object obj, Method method, Object[] objArr) {
            return null;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class SkuDetailsResponseListenerWrapper implements InvocationHandler {
        public Runnable runnable;

        public SkuDetailsResponseListenerWrapper(Runnable runnable) {
            InAppPurchaseBillingClientWrapper.this = r1;
            this.runnable = runnable;
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().equals(InAppPurchaseBillingClientWrapper.METHOD_ON_SKU_DETAILS_RESPONSE)) {
                Object obj2 = objArr[1];
                if (obj2 instanceof List) {
                    parseSkuDetails((List) obj2);
                    return null;
                }
                return null;
            }
            return null;
        }

        public void parseSkuDetails(List<?> list) {
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                try {
                    Object invokeMethod = InAppPurchaseUtils.invokeMethod(InAppPurchaseBillingClientWrapper.access$500(InAppPurchaseBillingClientWrapper.this), InAppPurchaseBillingClientWrapper.access$600(InAppPurchaseBillingClientWrapper.this), it.next(), new Object[0]);
                    if (invokeMethod instanceof String) {
                        JSONObject jSONObject = new JSONObject((String) invokeMethod);
                        if (jSONObject.has(InAppPurchaseBillingClientWrapper.PRODUCT_ID)) {
                            InAppPurchaseBillingClientWrapper.skuDetailsMap.put(jSONObject.getString(InAppPurchaseBillingClientWrapper.PRODUCT_ID), jSONObject);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            this.runnable.run();
        }
    }

    private InAppPurchaseBillingClientWrapper(Context context, Object obj, Class<?> cls, Class<?> cls2, Class<?> cls3, Class<?> cls4, Class<?> cls5, Class<?> cls6, Class<?> cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper) {
        this.context = context;
        this.billingClient = obj;
        this.billingClientClazz = cls;
        this.purchaseResultClazz = cls2;
        this.purchaseClazz = cls3;
        this.skuDetailsClazz = cls4;
        this.PurchaseHistoryRecordClazz = cls5;
        this.skuDetailsResponseListenerClazz = cls6;
        this.purchaseHistoryResponseListenerClazz = cls7;
        this.queryPurchasesMethod = method;
        this.getPurchaseListMethod = method2;
        this.getOriginalJsonMethod = method3;
        this.getOriginalJsonSkuMethod = method4;
        this.getOriginalJsonPurchaseHistoryMethod = method5;
        this.querySkuDetailsAsyncMethod = method6;
        this.queryPurchaseHistoryAsyncMethod = method7;
        this.inAppPurchaseSkuDetailsWrapper = inAppPurchaseSkuDetailsWrapper;
    }

    public static /* synthetic */ Set access$000(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.historyPurchaseSet;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static /* synthetic */ void access$100(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, String str, List list, Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapper.querySkuDetailsAsync(str, list, runnable);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
        }
    }

    public static /* synthetic */ Class access$200(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.PurchaseHistoryRecordClazz;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static /* synthetic */ Method access$300(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.getOriginalJsonPurchaseHistoryMethod;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static /* synthetic */ Context access$400(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.context;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static /* synthetic */ Class access$500(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.skuDetailsClazz;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static /* synthetic */ Method access$600(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.getOriginalJsonSkuMethod;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    public static Object createBillingClient(Context context, Class<?> cls) {
        Object invokeMethod;
        Object invokeMethod2;
        Object invokeMethod3;
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            Class<?> cls2 = InAppPurchaseUtils.getClass(CLASSNAME_BILLING_CLIENT_BUILDER);
            Class<?> cls3 = InAppPurchaseUtils.getClass(CLASSNAME_PURCHASE_UPDATED_LISTENER);
            if (cls2 != null && cls3 != null) {
                Method method = InAppPurchaseUtils.getMethod(cls, METHOD_NEW_BUILDER, Context.class);
                Method method2 = InAppPurchaseUtils.getMethod(cls2, METHOD_ENABLE_PENDING_PURCHASES, new Class[0]);
                Method method3 = InAppPurchaseUtils.getMethod(cls2, METHOD_SET_LISTENER, cls3);
                Method method4 = InAppPurchaseUtils.getMethod(cls2, METHOD_BUILD, new Class[0]);
                if (method == null || method2 == null || method3 == null || method4 == null || (invokeMethod = InAppPurchaseUtils.invokeMethod(cls, method, null, context)) == null || (invokeMethod2 = InAppPurchaseUtils.invokeMethod(cls2, method3, invokeMethod, Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, new PurchasesUpdatedListenerWrapper()))) == null || (invokeMethod3 = InAppPurchaseUtils.invokeMethod(cls2, method2, invokeMethod2, new Object[0])) == null) {
                    return null;
                }
                return InAppPurchaseUtils.invokeMethod(cls2, method4, invokeMethod3, new Object[0]);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
            return null;
        }
    }

    private static void createInstance(Context context) {
        Object createBillingClient;
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return;
        }
        try {
            InAppPurchaseSkuDetailsWrapper orCreateInstance = InAppPurchaseSkuDetailsWrapper.getOrCreateInstance();
            if (orCreateInstance == null) {
                return;
            }
            Class<?> cls = InAppPurchaseUtils.getClass(CLASSNAME_BILLING_CLIENT);
            Class<?> cls2 = InAppPurchaseUtils.getClass(CLASSNAME_PURCHASE);
            Class<?> cls3 = InAppPurchaseUtils.getClass(CLASSNAME_PURCHASES_RESULT);
            Class<?> cls4 = InAppPurchaseUtils.getClass(CLASSNAME_SKU_DETAILS);
            Class<?> cls5 = InAppPurchaseUtils.getClass(CLASSNAME_PURCHASE_HISTORY_RECORD);
            Class<?> cls6 = InAppPurchaseUtils.getClass(CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER);
            Class<?> cls7 = InAppPurchaseUtils.getClass(CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER);
            if (cls != null && cls3 != null && cls2 != null && cls4 != null && cls6 != null && cls5 != null && cls7 != null) {
                Method method = InAppPurchaseUtils.getMethod(cls, METHOD_QUERY_PURCHASES, String.class);
                Method method2 = InAppPurchaseUtils.getMethod(cls3, METHOD_GET_PURCHASE_LIST, new Class[0]);
                Method method3 = InAppPurchaseUtils.getMethod(cls2, METHOD_GET_ORIGINAL_JSON, new Class[0]);
                Method method4 = InAppPurchaseUtils.getMethod(cls4, METHOD_GET_ORIGINAL_JSON, new Class[0]);
                Method method5 = InAppPurchaseUtils.getMethod(cls5, METHOD_GET_ORIGINAL_JSON, new Class[0]);
                Method method6 = InAppPurchaseUtils.getMethod(cls, METHOD_QUERY_SKU_DETAILS_ASYNC, orCreateInstance.getSkuDetailsParamsClazz(), cls6);
                Method method7 = InAppPurchaseUtils.getMethod(cls, METHOD_QUERY_PURCHASE_HISTORY_ASYNC, String.class, cls7);
                if (method == null || method2 == null || method3 == null || method4 == null || method5 == null || method6 == null || method7 == null || (createBillingClient = createBillingClient(context, cls)) == null) {
                    return;
                }
                InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper = new InAppPurchaseBillingClientWrapper(context, createBillingClient, cls, cls3, cls2, cls4, cls5, cls6, cls7, method, method2, method3, method4, method5, method6, method7, orCreateInstance);
                mInstance = inAppPurchaseBillingClientWrapper;
                inAppPurchaseBillingClientWrapper.startConnection();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapper.class);
        }
    }

    @Nullable
    public static synchronized InAppPurchaseBillingClientWrapper getOrCreateInstance(Context context) {
        synchronized (InAppPurchaseBillingClientWrapper.class) {
            if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
                return null;
            }
            AtomicBoolean atomicBoolean = initialized;
            if (atomicBoolean.get()) {
                return mInstance;
            }
            createInstance(context);
            atomicBoolean.set(true);
            return mInstance;
        }
    }

    private void queryPurchaseHistoryAsync(String str, Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.queryPurchaseHistoryAsyncMethod, this.billingClient, str, Proxy.newProxyInstance(this.purchaseHistoryResponseListenerClazz.getClassLoader(), new Class[]{this.purchaseHistoryResponseListenerClazz}, new PurchaseHistoryResponseListenerWrapper(runnable)));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void querySkuDetailsAsync(String str, List<String> list, Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Object newProxyInstance = Proxy.newProxyInstance(this.skuDetailsResponseListenerClazz.getClassLoader(), new Class[]{this.skuDetailsResponseListenerClazz}, new SkuDetailsResponseListenerWrapper(runnable));
            InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.querySkuDetailsAsyncMethod, this.billingClient, this.inAppPurchaseSkuDetailsWrapper.getSkuDetailsParams(str, list), newProxyInstance);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void startConnection() {
        Method method;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Class<?> cls = InAppPurchaseUtils.getClass(CLASSNAME_BILLING_CLIENT_STATE_LISTENER);
            if (cls == null || (method = InAppPurchaseUtils.getMethod(this.billingClientClazz, METHOD_START_CONNECTION, cls)) == null) {
                return;
            }
            InAppPurchaseUtils.invokeMethod(this.billingClientClazz, method, this.billingClient, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new BillingClientStateListenerWrapper()));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void queryPurchase(String str, Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Object invokeMethod = InAppPurchaseUtils.invokeMethod(this.purchaseResultClazz, this.getPurchaseListMethod, InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.queryPurchasesMethod, this.billingClient, IN_APP), new Object[0]);
            if (invokeMethod instanceof List) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : (List) invokeMethod) {
                        Object invokeMethod2 = InAppPurchaseUtils.invokeMethod(this.purchaseClazz, this.getOriginalJsonMethod, obj, new Object[0]);
                        if (invokeMethod2 instanceof String) {
                            JSONObject jSONObject = new JSONObject((String) invokeMethod2);
                            if (jSONObject.has(PRODUCT_ID)) {
                                String string = jSONObject.getString(PRODUCT_ID);
                                arrayList.add(string);
                                purchaseDetailsMap.put(string, jSONObject);
                            }
                        }
                    }
                    querySkuDetailsAsync(str, arrayList, runnable);
                } catch (JSONException unused) {
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void queryPurchaseHistory(String str, final Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            queryPurchaseHistoryAsync(str, new Runnable() { // from class: com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.1
                {
                    InAppPurchaseBillingClientWrapper.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        InAppPurchaseBillingClientWrapper.access$100(InAppPurchaseBillingClientWrapper.this, InAppPurchaseBillingClientWrapper.IN_APP, new ArrayList(InAppPurchaseBillingClientWrapper.access$000(InAppPurchaseBillingClientWrapper.this)), runnable);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
