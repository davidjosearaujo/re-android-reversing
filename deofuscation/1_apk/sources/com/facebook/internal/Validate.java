package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import n.l2.v.s0;
import r.e.a.d;
import r.e.a.e;

/* compiled from: Validate.kt */
@b0(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J$\u0010\u000f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00102\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00100\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\b\u0010\u0011\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0017\u001a\u00020\u0004H\u0007J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u001a\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0013H\u0007J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0013H\u0007J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0004H\u0007J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J$\u0010\"\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00102\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00100\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J$\u0010$\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00102\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00100\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u001a\u0010%\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u001a\u0010&\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J7\u0010'\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u00042\u0016\u0010(\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010)\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\u000bH\u0007J\b\u0010,\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/facebook/internal/Validate;", "", "()V", "CONTENT_PROVIDER_BASE", "", "CONTENT_PROVIDER_NOT_FOUND_REASON", "CUSTOM_TAB_REDIRECT_URI_PREFIX", "FACEBOOK_ACTIVITY_NOT_FOUND_REASON", "NO_INTERNET_PERMISSION_REASON", "TAG", "containsNoNullOrEmpty", "", "container", "", "name", "containsNoNulls", "T", "hasAppID", "hasBluetoothPermission", "", "context", "Landroid/content/Context;", "hasChangeWifiStatePermission", "hasClientToken", "hasContentProvider", "hasCustomTabRedirectActivity", "redirectURI", "hasFacebookActivity", "shouldThrow", "hasInternetPermissions", "hasLocationPermission", "hasPermission", "permission", "hasWiFiPermission", "notEmpty", "arg", "notEmptyAndContainsNoNulls", "notNull", "notNullOrEmpty", "oneOf", "values", "", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)V", "runningOnUiThread", "sdkInitialized", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class Validate {
    private static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";
    private static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";
    @d
    public static final String CUSTOM_TAB_REDIRECT_URI_PREFIX = "fbconnect://cct.";
    private static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
    @d
    public static final Validate INSTANCE = new Validate();
    private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
    private static final String TAG;

    static {
        String name = Validate.class.getName();
        f0.o(name, "Validate::class.java.name");
        TAG = name;
    }

    private Validate() {
    }

    @k
    public static final void containsNoNullOrEmpty(@d Collection<String> collection, @d String str) {
        boolean z;
        f0.p(collection, "container");
        f0.p(str, "name");
        notNull(collection, str);
        for (String str2 : collection) {
            if (str2 != null) {
                if (str2.length() > 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    throw new IllegalArgumentException(("Container '" + str + "' cannot contain empty values").toString());
                }
            } else {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
        }
    }

    @k
    public static final <T> void containsNoNulls(@d Collection<? extends T> collection, @d String str) {
        f0.p(collection, "container");
        f0.p(str, "name");
        notNull(collection, str);
        for (T t : collection) {
            if (t == null) {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
        }
    }

    @d
    @k
    public static final String hasAppID() {
        String applicationId = FacebookSdk.getApplicationId();
        if (applicationId != null) {
            return applicationId;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.".toString());
    }

    @k
    public static final boolean hasBluetoothPermission(@d Context context) {
        f0.p(context, "context");
        return hasPermission(context, "android.permission.BLUETOOTH") && hasPermission(context, "android.permission.BLUETOOTH_ADMIN");
    }

    @k
    public static final boolean hasChangeWifiStatePermission(@d Context context) {
        f0.p(context, "context");
        return hasPermission(context, "android.permission.CHANGE_WIFI_STATE");
    }

    @d
    @k
    public static final String hasClientToken() {
        String clientToken = FacebookSdk.getClientToken();
        if (clientToken != null) {
            return clientToken;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token.".toString());
    }

    @k
    public static final void hasContentProvider(@d Context context) {
        f0.p(context, "context");
        notNull(context, "context");
        String hasAppID = hasAppID();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            String str = CONTENT_PROVIDER_BASE + hasAppID;
            if (packageManager.resolveContentProvider(str, 0) != null) {
                return;
            }
            s0 s0Var = s0.a;
            String format = String.format(CONTENT_PROVIDER_NOT_FOUND_REASON, Arrays.copyOf(new Object[]{str}, 1));
            f0.o(format, "java.lang.String.format(format, *args)");
            throw new IllegalStateException(format.toString());
        }
    }

    @k
    public static final boolean hasCustomTabRedirectActivity(@d Context context, @e String str) {
        List<ResolveInfo> list;
        f0.p(context, "context");
        notNull(context, "context");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str));
            list = packageManager.queryIntentActivities(intent, 64);
        } else {
            list = null;
        }
        if (list != null) {
            boolean z = false;
            for (ResolveInfo resolveInfo : list) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (!f0.g(activityInfo.name, "com.facebook.CustomTabActivity") || !f0.g(activityInfo.packageName, context.getPackageName())) {
                    return false;
                }
                z = true;
            }
            return z;
        }
        return false;
    }

    @k
    public static final void hasFacebookActivity(@d Context context) {
        f0.p(context, "context");
        hasFacebookActivity(context, true);
    }

    @k
    public static final void hasInternetPermissions(@d Context context) {
        f0.p(context, "context");
        hasInternetPermissions(context, true);
    }

    @k
    public static final boolean hasLocationPermission(@d Context context) {
        f0.p(context, "context");
        return hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION") || hasPermission(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    @k
    public static final boolean hasPermission(@d Context context, @d String str) {
        f0.p(context, "context");
        f0.p(str, "permission");
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    @k
    public static final boolean hasWiFiPermission(@d Context context) {
        f0.p(context, "context");
        return hasPermission(context, "android.permission.ACCESS_WIFI_STATE");
    }

    @k
    public static final <T> void notEmpty(@d Collection<? extends T> collection, @d String str) {
        f0.p(collection, "container");
        f0.p(str, "name");
        if (!collection.isEmpty()) {
            return;
        }
        throw new IllegalArgumentException(("Container '" + str + "' cannot be empty").toString());
    }

    @k
    public static final <T> void notEmptyAndContainsNoNulls(@d Collection<? extends T> collection, @d String str) {
        f0.p(collection, "container");
        f0.p(str, "name");
        containsNoNulls(collection, str);
        notEmpty(collection, str);
    }

    @k
    public static final void notNull(@e Object obj, @d String str) {
        f0.p(str, "name");
        if (obj != null) {
            return;
        }
        throw new NullPointerException("Argument '" + str + "' cannot be null");
    }

    @k
    public static final void notNullOrEmpty(@e String str, @d String str2) {
        f0.p(str2, "name");
        if (!Utility.isNullOrEmpty(str)) {
            return;
        }
        throw new IllegalArgumentException(("Argument '" + str2 + "' cannot be null or empty").toString());
    }

    @k
    public static final void oneOf(@e Object obj, @d String str, @d Object... objArr) {
        f0.p(str, "name");
        f0.p(objArr, "values");
        for (Object obj2 : objArr) {
            if (f0.g(obj2, obj)) {
                return;
            }
        }
        throw new IllegalArgumentException("Argument '" + str + "' was not one of the allowed values");
    }

    @k
    public static final void runningOnUiThread() {
        if (!f0.g(Looper.getMainLooper(), Looper.myLooper())) {
            throw new FacebookException("This method should be called from the UI thread");
        }
    }

    @k
    public static final void sdkInitialized() {
        if (!FacebookSdk.isInitialized()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0034 A[ORIG_RETURN, RETURN] */
    @android.annotation.SuppressLint({"WrongConstant"})
    @n.l2.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void hasFacebookActivity(@r.e.a.d android.content.Context r4, boolean r5) {
        /*
            java.lang.String r0 = "context"
            n.l2.v.f0.p(r4, r0)
            notNull(r4, r0)
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            r1 = 1
            if (r0 == 0) goto L1b
            android.content.ComponentName r2 = new android.content.ComponentName
            java.lang.String r3 = "com.facebook.FacebookActivity"
            r2.<init>(r4, r3)
            android.content.pm.ActivityInfo r4 = r0.getActivityInfo(r2, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L1b
            goto L1c
        L1b:
            r4 = 0
        L1c:
            if (r4 != 0) goto L34
            r4 = r5 ^ 1
            java.lang.String r5 = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info."
            if (r4 == 0) goto L2a
            java.lang.String r4 = com.facebook.internal.Validate.TAG
            android.util.Log.w(r4, r5)
            goto L34
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Validate.hasFacebookActivity(android.content.Context, boolean):void");
    }

    @k
    public static final void hasInternetPermissions(@d Context context, boolean z) {
        f0.p(context, "context");
        notNull(context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            if (!z) {
                Log.w(TAG, NO_INTERNET_PERMISSION_REASON);
                return;
            }
            throw new IllegalStateException(NO_INTERNET_PERMISSION_REASON.toString());
        }
    }

    @k
    public static final void notEmpty(@d String str, @d String str2) {
        f0.p(str, "arg");
        f0.p(str2, "name");
        if (str.length() > 0) {
            return;
        }
        throw new IllegalArgumentException(("Argument '" + str2 + "' cannot be empty").toString());
    }
}
