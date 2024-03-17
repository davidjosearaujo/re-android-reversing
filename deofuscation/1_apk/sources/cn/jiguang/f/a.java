package cn.jiguang.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.service.PushReceiver;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static String a = null;
    private static String b = "";
    private static int c = 0;
    private static String d = "";
    private static String e = "";
    private static String f = "";
    private static String g = "";

    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        ComponentInfo[] componentInfoArr;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            cn.jiguang.ar.c.g("AndroidUtil", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            int i = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, i);
            componentInfoArr = i != 1 ? i != 2 ? i != 4 ? i != 8 ? null : packageInfo.providers : packageInfo.services : packageInfo.receivers : packageInfo.activities;
        } catch (Throwable th) {
            cn.jiguang.ar.c.h("AndroidUtil", "hasComponent error:" + th);
        }
        if (componentInfoArr == null) {
            return null;
        }
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (cls.isAssignableFrom(Class.forName(componentInfo.name, false, cls.getClassLoader()))) {
                return componentInfo;
            }
        }
        return null;
    }

    public static ProviderInfo a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo(str, 8).providers;
                if (providerInfoArr != null && providerInfoArr.length != 0) {
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        if (str2.equals(providerInfo.authority)) {
                            return providerInfo;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0039, code lost:
        cn.jiguang.f.a.a = r1.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r3) {
        /*
            java.lang.String r0 = cn.jiguang.f.a.a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lb
            java.lang.String r3 = cn.jiguang.f.a.a
            return r3
        Lb:
            android.content.Context r3 = cn.jiguang.internal.JConstants.getAppContext(r3)     // Catch: java.lang.Throwable -> L3e
            r0 = 0
            if (r3 == 0) goto L1b
            java.lang.String r0 = "activity"
            java.lang.Object r3 = r3.getSystemService(r0)     // Catch: java.lang.Throwable -> L3e
            r0 = r3
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch: java.lang.Throwable -> L3e
        L1b:
            if (r0 == 0) goto L59
            int r3 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L3e
            java.util.List r0 = r0.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L3e
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L3e
        L29:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L59
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L3e
            android.app.ActivityManager$RunningAppProcessInfo r1 = (android.app.ActivityManager.RunningAppProcessInfo) r1     // Catch: java.lang.Throwable -> L3e
            int r2 = r1.pid     // Catch: java.lang.Throwable -> L3e
            if (r2 != r3) goto L29
            java.lang.String r3 = r1.processName     // Catch: java.lang.Throwable -> L3e
            cn.jiguang.f.a.a = r3     // Catch: java.lang.Throwable -> L3e
            goto L59
        L3e:
            r3 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "#unexcepted - getCurProcessName failed:"
            r0.append(r1)
            java.lang.String r3 = r3.getMessage()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            java.lang.String r0 = "AndroidUtil"
            cn.jiguang.ar.c.h(r0, r3)
        L59:
            java.lang.String r3 = cn.jiguang.f.a.a
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.f.a.a(android.content.Context):java.lang.String");
    }

    public static String a(Context context, String str) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static List<String> a(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null) {
                    String str2 = serviceInfo.name;
                    if (!TextUtils.isEmpty(str2)) {
                        boolean z = true;
                        if (!TextUtils.isEmpty(str) && packageManager.checkPermission(str, resolveInfo.activityInfo.packageName) != 0) {
                            z = false;
                        }
                        if (z) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static List<String> a(Context context, List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!c(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static void a(Context context, Intent intent) {
        try {
            context.sendBroadcast(intent);
        } catch (Throwable unused) {
            b(context, intent);
        }
    }

    public static void a(Context context, String str, int i) {
        int i2;
        Notification notification;
        if (!g(context)) {
            cn.jiguang.ar.c.c("AndroidUtil", "not debuggable");
        } else if (!a(context, PushReceiver.class)) {
            d(context, str);
        } else {
            cn.jiguang.ar.c.c("AndroidUtil", "action:showPermanentNotification");
            Intent intent = new Intent(context, PushReceiver.class);
            intent.setAction("noti_open_proxy");
            intent.addCategory(context.getPackageName());
            intent.putExtra("debug_notification", true);
            intent.putExtra("toastText", str);
            intent.putExtra("type", i);
            PendingIntent b2 = j.l.c.e0.a.a.d.b(context, 0, intent, 134217728);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            try {
                i2 = context.getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 0).icon;
            } catch (Throwable th) {
                cn.jiguang.ar.c.d("AndroidUtil", "failed to get application info and icon.", th);
                i2 = 17301586;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 11) {
                Notification.Builder when = new Notification.Builder(context.getApplicationContext()).setContentTitle("Jiguang提示：包名和AppKey不匹配").setContentText("请到 Portal 上获取您的包名和AppKey并更新AndroidManifest相应字段").setContentIntent(b2).setSmallIcon(i2).setTicker(str).setWhen(currentTimeMillis);
                if (i3 >= 26) {
                    if (notificationManager.getNotificationChannel("JPush_Notification") == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel("JPush_Notification", "JPush_Notification", 3));
                    }
                    when.setChannelId("JPush_Notification");
                }
                notification = when.getNotification();
                notification.flags = 34;
            } else {
                Notification notification2 = new Notification(i2, str, currentTimeMillis);
                notification2.flags = 34;
                try {
                    f.a(notification2, "setLatestEventInfo", new Object[]{context, "Jiguang提示：包名和AppKey不匹配", "请到 Portal 上获取您的包名和AppKey并更新AndroidManifest相应字段", b2}, new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class});
                } catch (Exception unused) {
                }
                notification = notification2;
            }
            c = 10000;
            notificationManager.notify(10000, notification);
        }
    }

    public static boolean a() {
        boolean z;
        try {
            j.l.c.e0.a.a.b.c();
            z = Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("AndroidUtil", "isSdcardExist exception: " + th);
            z = false;
        }
        if (!z) {
            cn.jiguang.ar.c.c("AndroidUtil", "SDCard is not mounted");
        }
        return z;
    }

    public static boolean a(Context context, Class<?> cls) {
        boolean z;
        boolean z2 = false;
        try {
            z = !context.getPackageManager().queryBroadcastReceivers(new Intent(context, cls), 0).isEmpty();
        } catch (Throwable unused) {
        }
        if (z) {
            return z;
        }
        try {
            if (a(context, context.getPackageName(), cls) != null) {
                z2 = true;
            }
        } catch (Throwable unused2) {
            z2 = z;
        }
        return z2;
    }

    public static ProviderInfo b(Context context, String str, Class<? extends ContentProvider> cls) {
        try {
            return context.getPackageManager().getProviderInfo(new ComponentName(str, cls.getName()), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b() {
        /*
            j.l.c.e0.a.a.b.a()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lc java.lang.Exception -> L10
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lc java.lang.Exception -> L10
            java.lang.String r0 = r0.getPath()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lc java.lang.Exception -> L10
            goto L11
        Lc:
            r0 = move-exception
            r0.printStackTrace()
        L10:
            r0 = 0
        L11:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L28
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "/data/"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L28:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.f.a.b():java.lang.String");
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(b)) {
            String packageName = context.getPackageName();
            b = packageName;
            return packageName;
        }
        return b;
    }

    public static String b(Context context, String str) {
        try {
            return context.getPackageManager().getReceiverInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(Context context, String str, String str2) {
        try {
            return (String) f.a(context.getClassLoader().loadClass("android.os.SystemProperties"), "get", new Object[]{str, str2}, new Class[]{String.class, String.class});
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (Exception unused) {
            return "";
        }
    }

    private static List<String> b(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    String str2 = activityInfo.name;
                    if (!TextUtils.isEmpty(str2)) {
                        boolean z = true;
                        if (!TextUtils.isEmpty(str) && packageManager.checkPermission(str, resolveInfo.activityInfo.packageName) != 0) {
                            z = false;
                        }
                        if (z) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static void b(Context context, Intent intent) {
        try {
            List<String> b2 = b(context, intent, (String) null);
            if (b2 == null || b2.isEmpty()) {
                cn.jiguang.ar.c.h("AndroidUtil", "sendBroadcast failed again: receiver not found, action:" + intent.getAction());
                return;
            }
            for (String str : b2) {
                try {
                    Intent intent2 = (Intent) intent.clone();
                    intent2.setComponent(new ComponentName(context.getPackageName(), str));
                    context.sendBroadcast(intent2);
                } catch (Exception e2) {
                    cn.jiguang.ar.c.h("AndroidUtil", "sendBroadcast failed again:" + e2.getMessage() + ", action:" + intent.getAction());
                }
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.h("AndroidUtil", "tryAgainSendBrocast failed:" + th.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(android.content.Context r6) {
        /*
            java.lang.String r0 = "AndroidUtil"
            r1 = -1
            if (r6 != 0) goto L6
            return r1
        L6:
            android.content.IntentFilter r2 = new android.content.IntentFilter
            java.lang.String r3 = "android.intent.action.BATTERY_CHANGED"
            r2.<init>(r3)
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            r4.<init>()     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            java.lang.String r5 = r6.getPackageName()     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            r4.append(r5)     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            java.lang.String r5 = cn.jiguang.a.a.a     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            r4.append(r5)     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            android.content.Intent r3 = r6.registerReceiver(r3, r2, r4, r3)     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            goto L44
        L28:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "getChargedStatus unkown exception:"
            r2.append(r4)
            java.lang.String r6 = r6.getMessage()
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            goto L41
        L3f:
            java.lang.String r6 = "getChargedStatus SecurityException"
        L41:
            cn.jiguang.ar.c.g(r0, r6)
        L44:
            if (r3 != 0) goto L47
            return r1
        L47:
            java.lang.String r6 = "status"
            int r6 = r3.getIntExtra(r6, r1)
            r0 = 2
            if (r6 == r0) goto L57
            r0 = 5
            if (r6 != r0) goto L55
            goto L57
        L55:
            r6 = 0
            goto L58
        L57:
            r6 = 1
        L58:
            if (r6 != 0) goto L5b
            return r1
        L5b:
            java.lang.String r6 = "plugged"
            int r6 = r3.getIntExtra(r6, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.f.a.c(android.content.Context):int");
    }

    public static String c() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (Exception e2) {
            cn.jiguang.ar.c.g("AndroidUtil", "getPhoneIp:");
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean c(Context context, String str) {
        try {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 23) {
                if (context.getApplicationInfo().targetSdkVersion < 23) {
                    String permissionToOp = AppOpsManager.permissionToOp(str);
                    if (permissionToOp != null) {
                        z = ((AppOpsManager) context.getSystemService("appops")).noteProxyOpNoThrow(permissionToOp, context.getPackageName()) == 0;
                    }
                    return z;
                } else if (context.checkSelfPermission(str) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("AndroidUtil", "checkPermission error:" + th.getMessage());
            return false;
        }
    }

    public static void d(final Context context, final String str) {
        new Handler(Looper.getMainLooper()).post(new cn.jiguang.be.b("AndroidUtils#ShowToast") { // from class: cn.jiguang.f.a.1
            @Override // cn.jiguang.be.b
            public void a() {
                try {
                    Toast.makeText(context, str, 0).show();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (!c(context, "android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static synchronized String e(Context context, String str) {
        synchronized (a.class) {
            if (g.h("")) {
                str = "";
            }
        }
        return str;
    }

    public static boolean e(Context context) {
        String str = context.getApplicationInfo().sourceDir;
        if (g.a(str)) {
            cn.jiguang.ar.c.i("AndroidUtil", "Unexpected: cannot get pk installed path");
            return false;
        }
        cn.jiguang.ar.c.c("AndroidUtil", "Current pk installed path: " + str);
        if (str.startsWith("/system/app/")) {
            return true;
        }
        if (str.startsWith("/data/app/")) {
            return false;
        }
        cn.jiguang.ar.c.e("AndroidUtil", "NOTE: the pk does not installed in system/data. ");
        return false;
    }

    public static String f(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return "0*0";
        }
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        return i + "*" + i2;
    }

    @SuppressLint({"MissingPermission"})
    public static synchronized String f(Context context, String str) {
        synchronized (a.class) {
            if (!TextUtils.isEmpty("")) {
                str = "";
            }
        }
        return str;
    }

    public static String g(Context context, String str) {
        return "";
    }

    public static boolean g(Context context) {
        boolean z = false;
        try {
            boolean z2 = (context.getApplicationInfo().flags & 2) != 0;
            cn.jiguang.ar.c.c("AndroidUtil", "isDebug:" + z2);
            if (JConstants.INTERNAL_USE && JConstants.DEBUG_MODE) {
                return z2;
            }
            X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
            String[] strArr = {"CN=Android Debug", "O=Android", "C=US"};
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            boolean z3 = false;
            for (Signature signature : signatureArr) {
                try {
                    X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
                    z3 = x509Certificate.getSubjectX500Principal().equals(x500Principal);
                    cn.jiguang.ar.c.c("AndroidUtil", "debuggable :" + z3);
                    if (z3) {
                        break;
                    }
                    String str = null;
                    try {
                        str = x509Certificate.getSubjectX500Principal().getName();
                    } catch (Exception unused) {
                    }
                    cn.jiguang.ar.c.c("AndroidUtil", "certName:" + str);
                    if (str != null && str.contains(strArr[0]) && str.contains(strArr[1]) && str.contains(strArr[2])) {
                        return true;
                    }
                } catch (Throwable unused2) {
                    z = z3;
                    return z;
                }
            }
            return z3;
        } catch (Throwable unused3) {
        }
    }

    public static void h(Context context) {
        try {
            if (c != 0) {
                ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).cancel(c);
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("AndroidUtil", "[canclePermanentNotification] failed:" + th.getMessage());
        }
    }

    public static boolean h(Context context, String str) {
        if (g.a(str)) {
            return false;
        }
        return context.getPackageManager().getPackageInfo(str, 0) != null;
    }

    public static String i(Context context) {
        return "";
    }

    public static boolean i(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("empty params");
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                for (String str2 : packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                    if (str.equals(str2)) {
                        cn.jiguang.ar.c.c("AndroidUtil", "find permission: " + str);
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.h("AndroidUtil", "hasPermissionDefined error:" + th.getMessage());
        }
        return false;
    }

    public static String j(Context context) {
        try {
            String g2 = g(context, "");
            if (g2 != null && !g2.equals("")) {
                cn.jiguang.ar.c.e("AndroidUtil", "MAC addr info---- " + g2);
                return g.d(g2.toLowerCase() + Build.MODEL);
            }
            return null;
        } catch (Exception e2) {
            cn.jiguang.ar.c.c("AndroidUtil", "", e2);
            return null;
        }
    }

    public static boolean k(Context context) {
        String b2 = b(context, "ro.product.brand", "");
        cn.jiguang.ar.c.c("AndroidUtil", "brand = " + b2);
        String b3 = b(context, "ro.miui.ui.version.name", "");
        if (TextUtils.isEmpty(b2) || !"Xiaomi".equals(b2) || TextUtils.isEmpty(b3)) {
            return true;
        }
        String b4 = b(context, "ro.build.version.incremental", "");
        if (TextUtils.isEmpty(b4) || !b4.startsWith("V7.1")) {
            return true;
        }
        cn.jiguang.ar.c.g("AndroidUtil", "7.1 will not get wifi list");
        return false;
    }

    public static String l(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            String typeName = activeNetworkInfo.getTypeName();
            String subtypeName = activeNetworkInfo.getSubtypeName();
            if (typeName == null) {
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            if (g.a(subtypeName)) {
                return typeName;
            }
            return typeName + "," + subtypeName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    public static String m(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null || !c(context, "android.permission.ACCESS_WIFI_STATE")) {
                return "";
            }
            String bssid = wifiManager.getConnectionInfo().getBSSID();
            if (bssid != null) {
                try {
                    if (bssid.startsWith("02:00:00:")) {
                        return "";
                    }
                } catch (Throwable unused) {
                }
                return bssid;
            }
            return "";
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String n(Context context) {
        Object invoke;
        String str = null;
        int i = -1;
        if (context != null) {
            try {
                Object systemService = context.getApplicationContext().getSystemService("country_detector");
                if (systemService != null) {
                    Method declaredMethod = systemService.getClass().getDeclaredMethod("detectCountry", new Class[0]);
                    if (declaredMethod != null && (invoke = declaredMethod.invoke(systemService, new Object[0])) != null) {
                        String str2 = (String) invoke.getClass().getDeclaredMethod("getCountryIso", new Class[0]).invoke(invoke, new Object[0]);
                        try {
                            i = ((Integer) invoke.getClass().getDeclaredMethod("getSource", new Class[0]).invoke(invoke, new Object[0])).intValue();
                            str = str2;
                        } catch (Throwable th) {
                            th = th;
                            str = str2;
                            cn.jiguang.ar.c.i("AndroidUtil", "getCountryCode failed, error :" + th);
                            cn.jiguang.ar.c.c("AndroidUtil", "get CountCode = " + str + " source = " + i);
                            if (i != 0) {
                            }
                        }
                    }
                } else {
                    cn.jiguang.ar.c.c("AndroidUtil", "country_detector is null");
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        cn.jiguang.ar.c.c("AndroidUtil", "get CountCode = " + str + " source = " + i);
        return (i != 0 || i == 1) ? str : "";
    }

    public static Activity o(Context context) {
        if (context != null) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get(invoke);
                if (map == null) {
                    cn.jiguang.ar.c.g("AndroidUtil", "get current activities for currentActivityThread, activities is null");
                    return null;
                }
                for (Object obj : map.values()) {
                    Class<?> cls2 = obj.getClass();
                    Field declaredField2 = cls2.getDeclaredField("paused");
                    declaredField2.setAccessible(true);
                    if (!declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField("activity");
                        declaredField3.setAccessible(true);
                        Activity activity = (Activity) declaredField3.get(obj);
                        if (activity == null) {
                            cn.jiguang.ar.c.g("AndroidUtil", "[getCurrentActivity] activity is null");
                            return null;
                        } else if (activity.getPackageName().equals(context.getPackageName())) {
                            cn.jiguang.ar.c.c("AndroidUtil", "getCurrentActivity: " + activity.getLocalClassName());
                            return activity;
                        } else {
                            cn.jiguang.ar.c.g("AndroidUtil", "current activity packageName: " + activity.getPackageName() + ", appPackageName: " + context.getPackageName());
                            return null;
                        }
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.ar.c.g("AndroidUtil", "[getCurrentActivity] error: " + th.getMessage());
            }
        }
        return null;
    }
}
