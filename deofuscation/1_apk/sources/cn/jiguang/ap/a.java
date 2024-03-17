package cn.jiguang.ap;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import cn.jiguang.n.c;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.service.DActivity;
import cn.jpush.android.service.DaemonService;
import cn.jpush.android.service.DownloadProvider;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static Boolean a;
    private static Boolean b;
    private static final String c = "Xiaomi".toLowerCase();

    public static cn.jiguang.ao.c a(Context context, PackageManager packageManager, String str, String str2) {
        StringBuilder sb;
        String message;
        if (packageManager != null && !TextUtils.isEmpty(str)) {
            try {
                int checkPermission = packageManager.checkPermission(str + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX, str);
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    String b2 = cn.jiguang.n.d.b(context);
                    Intent intent = new Intent();
                    intent.setClassName(str, "cn.jpush.android.service.PushService");
                    boolean z = false;
                    List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                    if (queryIntentServices != null && queryIntentServices.size() != 0) {
                        z = true;
                    }
                    if (checkPermission == 0 && z && !TextUtils.isEmpty(b2) && b2.length() == 24) {
                        cn.jiguang.ao.c cVar = new cn.jiguang.ao.c(str, str2, applicationInfo.targetSdkVersion);
                        ComponentInfo a2 = cn.jiguang.n.d.a(context, str, (Class<?>) DownloadProvider.class);
                        if (a2 instanceof ProviderInfo) {
                            ProviderInfo providerInfo = (ProviderInfo) a2;
                            if (providerInfo.exported && providerInfo.enabled && providerInfo.authority != null) {
                                if (TextUtils.equals(str + ".DownloadProvider", providerInfo.authority)) {
                                    cVar.d = providerInfo.authority;
                                }
                            }
                        }
                        return cVar;
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                sb = new StringBuilder();
                sb.append("checkWhetherToStart exception:");
                message = e.toString();
                sb.append(message);
                cn.jiguang.ak.a.d("JWakeComponentHelper", sb.toString());
                return null;
            } catch (Throwable th) {
                sb = new StringBuilder();
                sb.append("checkWhetherToStart throwable:");
                message = th.getMessage();
                sb.append(message);
                cn.jiguang.ak.a.d("JWakeComponentHelper", sb.toString());
                return null;
            }
        }
        return null;
    }

    public static void a(Context context, boolean z) {
        a(context, z, "cn.jpush.android.intent.DaemonService", DaemonService.class);
        b(context, z, DownloadProvider.class);
        if (b(context)) {
            a(context, z, DActivity.class);
            try {
                a(context, z, Class.forName("cn.jpush.android.service.BActivity", false, context.getClassLoader()));
            } catch (Throwable unused) {
                cn.jiguang.ak.a.a("JWakeComponentHelper", "can't find BActivity");
            }
        }
    }

    private static void a(Context context, boolean z, Class cls) {
        try {
            if (context == null) {
                cn.jiguang.ak.a.e("JWakeComponentHelper", "context is null, give up setComponentEnabled");
                return;
            }
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            if (packageManager == null) {
                cn.jiguang.ak.a.e("JWakeComponentHelper", "PackageManager is null, give up setComponentEnabled");
                return;
            }
            int i = z ? 1 : 2;
            ComponentName componentName = new ComponentName(context, cls);
            if (packageManager.getComponentEnabledSetting(componentName) == i) {
                cn.jiguang.ak.a.a("JWakeComponentHelper", componentName.getClassName() + " enabled is :" + z + ", no need repeat set.");
                return;
            }
            cn.jiguang.ak.a.a("JWakeComponentHelper", componentName + " setActivityEnabledSetting newState: " + i);
            packageManager.setComponentEnabledSetting(componentName, i, 1);
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWakeComponentHelper", "setActivityEnabled throwable:" + th.getMessage());
        }
    }

    private static void a(Context context, boolean z, String str, Class cls) {
        ServiceInfo serviceInfo;
        try {
            if (context == null) {
                cn.jiguang.ak.a.e("JWakeComponentHelper", "context is null, give up setComponentEnabled");
                return;
            }
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            if (packageManager == null) {
                cn.jiguang.ak.a.e("JWakeComponentHelper", "PackageManager is null, give up setComponentEnabled");
                return;
            }
            String packageName = context.getPackageName();
            int i = z ? 1 : 2;
            Intent intent = new Intent();
            intent.setPackage(packageName);
            intent.setAction(str);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 512);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                cn.jiguang.ak.a.d("JWakeComponentHelper", "cant't find DaemonService");
                return;
            }
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                    String str2 = serviceInfo.name;
                    if (TextUtils.isEmpty(str2)) {
                        continue;
                    } else {
                        try {
                            Class<?> cls2 = Class.forName(str2);
                            if (cls2 != null) {
                                if (cls.isAssignableFrom(cls2)) {
                                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                                    cn.jiguang.ak.a.a("JWakeComponentHelper", componentName + " setComponentEnabledSetting newState: " + i);
                                    if (packageManager.getComponentEnabledSetting(componentName) == i) {
                                        cn.jiguang.ak.a.a("JWakeComponentHelper", "DaemonService  enabled is :" + z + ", no need repeat set.");
                                        return;
                                    }
                                    packageManager.setComponentEnabledSetting(componentName, i, 1);
                                } else {
                                    cn.jiguang.ak.a.e("JWakeComponentHelper", "give up setting, as " + str2 + " is not extend from: " + cls.getName());
                                }
                            }
                        } catch (ClassNotFoundException unused) {
                            cn.jiguang.ak.a.d("JWakeComponentHelper", "cant't find service class:" + str2);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWakeComponentHelper", "setServiceEnabled throwable:" + th.getMessage());
        }
    }

    public static boolean a(Context context) {
        Boolean bool = b;
        if (bool != null) {
            return bool.booleanValue();
        }
        b = c(context) ? Boolean.TRUE : Boolean.FALSE;
        return b.booleanValue();
    }

    private static boolean a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            return !packageManager.queryIntentActivities(intent, 0).isEmpty();
        } catch (Throwable th) {
            cn.jiguang.ak.a.e("JWakeComponentHelper", "hasActivityIntentFilter error:" + th.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, String str, Intent intent, boolean z) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            intent.setPackage(str);
            if (!z) {
                intent.setAction("cn.jpush.android.intent.DActivity");
                intent.addCategory(str);
            }
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            if (resolveActivity == null) {
                cn.jiguang.ak.a.d("JWakeComponentHelper", "getDActivity resolveInfo was null from:" + intent);
                return false;
            }
            cn.jiguang.ak.a.a("JWakeComponentHelper", "target actvity name:" + resolveActivity.activityInfo.name + ", theme:" + resolveActivity.activityInfo.theme + ",exported:" + resolveActivity.activityInfo.exported);
            ActivityInfo activityInfo = resolveActivity.activityInfo;
            if (activityInfo.exported && activityInfo.enabled) {
                if (!z && !"jpush.custom".equals(activityInfo.taskAffinity)) {
                    cn.jiguang.ak.a.d("JWakeComponentHelper", "activity taskAffinity must be jpush.custom");
                    return false;
                } else if (resolveActivity.activityInfo.theme != 16973840) {
                    cn.jiguang.ak.a.d("JWakeComponentHelper", resolveActivity.activityInfo.name + "activity theme must config as @android:style/Theme.Translucent.NoTitleBar");
                    return false;
                } else {
                    cn.jiguang.ak.a.a("JWakeComponentHelper", "dIntent:" + intent);
                    return true;
                }
            }
            cn.jiguang.ak.a.d("JWakeComponentHelper", "activity muse be exported and enabled");
            return false;
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWakeComponentHelper", "get deeplink activity error#" + th);
            return false;
        }
    }

    private static void b(Context context, boolean z, Class cls) {
        try {
            if (context == null) {
                cn.jiguang.ak.a.e("JWakeComponentHelper", "context is null, give up setComponentEnabled");
                return;
            }
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            if (packageManager == null) {
                cn.jiguang.ak.a.e("JWakeComponentHelper", "PackageManager is null, give up setComponentEnabled");
                return;
            }
            int i = z ? 1 : 2;
            ComponentName componentName = new ComponentName(context, cls);
            if (packageManager.getComponentEnabledSetting(componentName) == i) {
                cn.jiguang.ak.a.a("JWakeComponentHelper", componentName.getClassName() + " enabled is :" + z + ", no need repeat set.");
                return;
            }
            cn.jiguang.ak.a.a("JWakeComponentHelper", componentName + " setDownloadProviderEnabledSetting newState: " + i);
            packageManager.setComponentEnabledSetting(componentName, i, 1);
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWakeComponentHelper", "setContentProviderEnabled throwable:" + th.getMessage());
        }
    }

    public static boolean b(Context context) {
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        a = a(context, "cn.jpush.android.intent.DActivity") ? Boolean.TRUE : Boolean.FALSE;
        return a.booleanValue();
    }

    private static boolean c(Context context) {
        try {
            String str = c.a.b;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return TextUtils.equals(c, str.toLowerCase());
        } catch (Throwable th) {
            cn.jiguang.ak.a.e("JWakeComponentHelper", "get MANUFACTURER failed - error:" + th);
            return false;
        }
    }
}
