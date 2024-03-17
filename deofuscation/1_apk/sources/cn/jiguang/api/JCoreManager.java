package cn.jiguang.api;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.aq.f;
import cn.jiguang.ar.c;
import cn.jiguang.d.a;
import cn.jiguang.g.b;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class JCoreManager {
    private static final String TAG = "JCoreManager";
    private static final AtomicBoolean isInited = new AtomicBoolean();

    public static void addDispatchAction(String str, String str2) {
        a.a(str, str2);
    }

    public static void changeLiveStatus(boolean z) {
    }

    public static Context getAppContext(Context context) {
        return JConstants.getAppContext(context);
    }

    @Deprecated
    public static boolean getConnectionState(Context context) {
        Object onEvent = JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 67, false, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return false;
    }

    public static boolean getDebugMode() {
        return JConstants.DEBUG_MODE;
    }

    public static void init(Context context) {
        Context appContext = JConstants.getAppContext(context);
        if (appContext == null) {
            return;
        }
        JConstants.isCallInit.set(true);
        AtomicBoolean atomicBoolean = isInited;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        try {
            if (f.a(appContext)) {
                atomicBoolean.set(false);
                JConstants.isCallInit.set(false);
                return;
            }
            a.a(appContext);
            JCoreInternalHelper.getInstance().onEvent(appContext, JConstants.SDK_TYPE, 10, true, "tcp_a1", null, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public static void initCrashHandler(Context context) {
        onEvent(context, JConstants.SDK_TYPE, 70, true, null, null, new Object[0]);
    }

    public static boolean isInternal() {
        return JConstants.INTERNAL_USE;
    }

    public static boolean isTestEnv() {
        return JConstants.isTestEnv();
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0046 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object onEvent(android.content.Context r8, java.lang.String r9, int r10, java.lang.String r11, android.os.Bundle r12, java.lang.Object... r13) {
        /*
            r0 = 13
            if (r10 == r0) goto L46
            r0 = 49
            if (r10 == r0) goto L46
            r0 = 58
            if (r10 == r0) goto L46
            r0 = 60
            if (r10 == r0) goto L46
            r0 = 82
            if (r10 == r0) goto L46
            r0 = 25
            if (r10 == r0) goto L46
            r0 = 26
            if (r10 == r0) goto L46
            r0 = 42
            if (r10 == r0) goto L46
            r0 = 43
            if (r10 == r0) goto L46
            r0 = 52
            if (r10 == r0) goto L46
            r0 = 53
            if (r10 == r0) goto L46
            r0 = 63
            if (r10 == r0) goto L46
            r0 = 64
            if (r10 == r0) goto L46
            switch(r10) {
                case 4: goto L46;
                case 5: goto L46;
                case 6: goto L46;
                case 7: goto L46;
                case 8: goto L46;
                default: goto L37;
            }
        L37:
            switch(r10) {
                case 18: goto L46;
                case 19: goto L46;
                case 20: goto L46;
                case 21: goto L46;
                default: goto L3a;
            }
        L3a:
            switch(r10) {
                case 32: goto L46;
                case 33: goto L46;
                case 34: goto L46;
                default: goto L3d;
            }
        L3d:
            switch(r10) {
                case 45: goto L46;
                case 46: goto L46;
                case 47: goto L46;
                default: goto L40;
            }
        L40:
            switch(r10) {
                case 67: goto L46;
                case 68: goto L46;
                case 69: goto L46;
                default: goto L43;
            }
        L43:
            r0 = 1
            r4 = 1
            goto L48
        L46:
            r0 = 0
            r4 = 0
        L48:
            r1 = r8
            r2 = r9
            r3 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            java.lang.Object r8 = onEvent(r1, r2, r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.JCoreManager.onEvent(android.content.Context, java.lang.String, int, java.lang.String, android.os.Bundle, java.lang.Object[]):java.lang.Object");
    }

    public static Object onEvent(Context context, String str, int i, boolean z, String str2, Bundle bundle, Object... objArr) {
        if (i != 18 && i != 13) {
            init(context);
        }
        return JCoreInternalHelper.getInstance().onEvent(context, str, i, z, str2, bundle, objArr);
    }

    public static void register(Context context, String str) {
        try {
            if (f.a(context)) {
                JConstants.isCallInit.set(false);
                return;
            }
            JConstants.isCallInit.set(true);
            a.a(context);
            String b = cn.jiguang.aq.a.b(context);
            if (!TextUtils.isEmpty(b) && !b.equals(str)) {
                c.h(TAG, "[register] not same appkey with manifest,please check it");
                Bundle bundle = new Bundle();
                bundle.putString(com.alipay.sdk.sys.a.o, str);
                JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 10, true, "a5", bundle, new Object[0]);
            }
            JConstants.APP_KEY = str;
            Bundle bundle2 = new Bundle();
            bundle2.putString(com.alipay.sdk.sys.a.o, str);
            JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 10, true, "a5", bundle2, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void reportWakedData(Context context, Bundle bundle, int i) {
        if (context == null) {
            c.h(TAG, "[reportWakedData] context was null");
        } else if (bundle == null) {
            c.h(TAG, "[reportWakedData] bundle was null");
        } else {
            int i2 = bundle.getInt("type", -1);
            if (i2 != -1) {
                i = i2;
            }
            if (i != 8 && i != 16) {
                c.h(TAG, "[reportWakedData] wrong type:" + i);
                return;
            }
            bundle.putInt("type", i);
            c.c(TAG, "action - reportWakedData" + bundle.toString());
            onEvent(context, null, 74, null, bundle, new Object[0]);
        }
    }

    public static void requestPermission(Context context) {
        String str;
        if (context == null) {
            str = "[requestPermission] context was null";
        } else if (context instanceof Activity) {
            int i = Build.VERSION.SDK_INT;
            if (i < 23) {
                str = "[requestPermission] android.os.Build.VERSION.SDK_INT<23";
            } else if (context.getApplicationInfo().targetSdkVersion >= 23) {
                if (i < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
                    return;
                }
                try {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                    linkedList.add("android.permission.READ_EXTERNAL_STORAGE");
                    linkedList.add("android.permission.ACCESS_FINE_LOCATION");
                    linkedList.add("android.permission.READ_PHONE_STATE");
                    if (JConstants.isAndroidQ(context, false, "will request background location permission")) {
                        linkedList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                    }
                    List<String> a = cn.jiguang.f.a.a(context, linkedList);
                    if (a != null && !a.isEmpty()) {
                        c.a(TAG, "lackPermissions:" + a);
                        Class.forName("android.app.Activity").getDeclaredMethod("requestPermissions", String[].class, Integer.TYPE).invoke(context, a.toArray(new String[a.size()]), 1);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    c.h(TAG, "#unexcepted - requestPermission e:" + e);
                    return;
                }
            } else {
                str = "[requestPermission] app targetSdkVersion<23";
            }
        } else {
            str = "[requestPermission] context must instanceof Activity";
        }
        c.h(TAG, str);
    }

    public static void setAnalysisAction(JAnalyticsAction jAnalyticsAction) {
        JConstants.jAnalyticsAction = jAnalyticsAction;
    }

    public static void setDebugMode(boolean z) {
        JConstants.DEBUG_MODE = z;
    }

    public static void setLBSEnable(Context context, boolean z) {
        c.c(TAG, "action - setLBSEnable-control:" + z);
        if (!z) {
            try {
                b.a(context, cn.jiguang.g.a.z().a((cn.jiguang.g.a<Boolean>) Boolean.FALSE));
            } catch (Throwable unused) {
            }
        }
        onEvent(context, null, 27, null, null, Boolean.valueOf(z));
    }

    public static void setSDKConfigs(Context context, Bundle bundle) {
        JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 55, true, null, bundle, new Object[0]);
    }

    public static void stopCrashHandler(Context context) {
        onEvent(context, JConstants.SDK_TYPE, 71, true, null, null, new Object[0]);
    }

    public static void unRegister(Context context) {
        JConstants.isCallInit.set(true);
        a.a(context);
        JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 10, true, "tcp_a23", null, new Object[0]);
    }
}
