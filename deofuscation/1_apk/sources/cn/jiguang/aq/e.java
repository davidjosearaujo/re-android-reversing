package cn.jiguang.aq;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.android.IDataShare;
import cn.jiguang.ax.h;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import cn.jpush.android.service.DataShare;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.PushReceiver;
import com.alibaba.android.arouter.utils.Consts;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e {
    private static e a;
    private static Map<String, String> b = new HashMap();

    private e() {
    }

    private Bundle a(String str, String str2, Bundle bundle, String str3) {
        String str4 = str + Consts.DOT + str2;
        try {
            IDataShare dataShare = DataShare.getInstance(str3);
            if (dataShare == null) {
                cn.jiguang.ar.c.c("JMessenger", str3 + "'s aidl not found, " + str4);
                return null;
            }
            cn.jiguang.ar.c.c("JMessenger", "sendByAidl, " + str4);
            if ("INTERNAL_API".equals(str)) {
                return dataShare.execute(str, str2, bundle);
            }
            dataShare.onAction(str, str2, bundle);
            return new Bundle();
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("JMessenger", "sendByAidl, " + str4 + ", e=" + th);
            return null;
        }
    }

    public static e a() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    private static String a(Context context, String str) {
        StringBuilder sb;
        String str2 = b.get(str);
        if (TextUtils.isEmpty(str2)) {
            String str3 = context.getPackageName() + JConstants.DATA_PROVIDER_SUFFIX;
            ProviderInfo a2 = cn.jiguang.f.a.a(context, context.getPackageName(), str3);
            if (str.equals(a2 != null ? a2.processName : null)) {
                sb = new StringBuilder();
            } else {
                str3 = context.getPackageName() + ".DownloadProvider";
                ProviderInfo a3 = cn.jiguang.f.a.a(context, context.getPackageName(), str3);
                if (!str.equals(a3 != null ? a3.processName : null)) {
                    return "";
                }
                sb = new StringBuilder();
            }
            sb.append("content://");
            sb.append(str3);
            sb.append("/");
            String sb2 = sb.toString();
            b.put(str, sb2);
            return sb2;
        }
        return str2;
    }

    private boolean a(Context context, Class cls, String str, Bundle bundle) {
        Intent intent;
        if (cls == null) {
            return false;
        }
        String str2 = cls.getName() + Consts.DOT + str;
        try {
            intent = new Intent();
            intent.setClass(context, cls);
            intent.setAction(str);
            intent.setPackage(context.getPackageName());
            if (bundle != null) {
                intent.putExtras(bundle);
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("JMessenger", "sendByComponent, " + str2 + " e=" + th);
        }
        if (BroadcastReceiver.class.isAssignableFrom(cls)) {
            context.sendBroadcast(intent);
            cn.jiguang.ar.c.c("JMessenger", "sendByReceiver, " + str2);
            return true;
        }
        if (Service.class.isAssignableFrom(cls)) {
            if (context.startService(intent) != null) {
                cn.jiguang.ar.c.c("JMessenger", "sendByService, " + str2);
                return true;
            }
            cn.jiguang.ar.c.g("JMessenger", "startService, " + str2 + ", can't find component");
        }
        return false;
    }

    private Bundle b(Context context, String str, String str2, Bundle bundle, String str3) {
        String str4 = str + Consts.DOT + str2;
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                String a2 = a(context, str3);
                if (TextUtils.isEmpty(a2)) {
                    cn.jiguang.ar.c.c("JMessenger", "uri is null, check provider config");
                    return null;
                }
                Uri parse = Uri.parse(a2);
                cn.jiguang.ar.c.c("JMessenger", "sendByProvider, uri=" + a2 + ", " + str4);
                return context.getContentResolver().call(parse, str, str2, bundle);
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("JMessenger", "provider call:" + th);
            return null;
        }
    }

    public Bundle a(Context context, String str, String str2, Bundle bundle, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        String a2 = cn.jiguang.f.a.a(context);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        if (a2.equals(str3)) {
            return b(context, str, str2, bundle);
        }
        Bundle a3 = a(str, str2, bundle, str3);
        if (a3 != null) {
            return a3;
        }
        Bundle b2 = b(context, str, str2, bundle, str3);
        if (b2 != null) {
            return b2;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f A[Catch: all -> 0x0066, TRY_LEAVE, TryCatch #0 {all -> 0x0066, blocks: (B:17:0x0057, B:20:0x005f), top: B:27:0x0057 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.content.Context r11, java.lang.String r12, java.lang.String r13, android.os.Bundle r14) {
        /*
            r10 = this;
            java.lang.String r7 = " meet e:"
            java.lang.String r8 = "JMessenger"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            java.lang.String r1 = "."
            r0.append(r1)
            r0.append(r13)
            java.lang.String r9 = r0.toString()
            r1 = 0
            java.lang.Class r2 = java.lang.Class.forName(r12)     // Catch: java.lang.Throwable -> L39
            java.lang.Class<android.app.Service> r0 = android.app.Service.class
            boolean r0 = r0.isAssignableFrom(r2)     // Catch: java.lang.Throwable -> L37
            if (r0 == 0) goto L2a
            java.lang.String r1 = cn.jiguang.f.a.a(r11, r12)     // Catch: java.lang.Throwable -> L37
            goto L50
        L2a:
            java.lang.Class<android.content.BroadcastReceiver> r0 = android.content.BroadcastReceiver.class
            boolean r0 = r0.isAssignableFrom(r2)     // Catch: java.lang.Throwable -> L37
            if (r0 == 0) goto L50
            java.lang.String r1 = cn.jiguang.f.a.b(r11, r12)     // Catch: java.lang.Throwable -> L37
            goto L50
        L37:
            r0 = move-exception
            goto L3b
        L39:
            r0 = move-exception
            r2 = r1
        L3b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r9)
            r4.append(r7)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            cn.jiguang.ar.c.c(r8, r0)
        L50:
            r6 = r1
            r0 = r2
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            android.os.Bundle r1 = r1.a(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L66
            r2 = 1
            if (r1 == 0) goto L5f
            return r2
        L5f:
            boolean r0 = r10.a(r11, r0, r13, r14)     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L82
            return r2
        L66:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "send, "
            r2.append(r3)
            r2.append(r9)
            r2.append(r7)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            cn.jiguang.ar.c.g(r8, r0)
        L82:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "send all failed, "
            r0.append(r2)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            cn.jiguang.ar.c.i(r8, r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.aq.e.a(android.content.Context, java.lang.String, java.lang.String, android.os.Bundle):boolean");
    }

    public Bundle b(Context context, String str, String str2, Bundle bundle) {
        try {
            cn.jiguang.ar.c.c("JMessenger", "directHandle, " + str + Consts.DOT + str2);
            if ("INTERNAL_API".equals(str)) {
                if (str2.equals("isTcpLoggedIn")) {
                    boolean d = h.a().d();
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("state", d);
                    return bundle2;
                }
                cn.jiguang.ar.c.i("JMessenger", "directHandle, not support " + str + Consts.DOT + str2);
                return null;
            }
            Class<?> cls = Class.forName(str);
            if (!BroadcastReceiver.class.isAssignableFrom(cls) && !Service.class.isAssignableFrom(cls)) {
                cn.jiguang.ar.c.i("JMessenger", "directHandle, not support " + str + Consts.DOT + str2);
                return null;
            } else if (JCommonService.class.isAssignableFrom(cls)) {
                cn.jiguang.ar.c.c("JMessenger", "JCommonService handle succeed," + str + Consts.DOT + str2);
                JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 2, true, str2, bundle, new Object[0]);
                return new Bundle();
            } else {
                Intent intent = new Intent(str2);
                intent.setClass(context, cls);
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                intent.setPackage(context.getPackageName());
                intent.addCategory(context.getPackageName());
                if (PushReceiver.class.isAssignableFrom(cls)) {
                    cn.jiguang.ar.c.c("JMessenger", "PushReceiver handle succeed," + str + Consts.DOT + str2);
                    ActionManager.getInstance().handleMessage(context, bundle != null ? bundle.getString("sdktype") : null, intent);
                } else if (BroadcastReceiver.class.isAssignableFrom(cls)) {
                    cn.jiguang.ar.c.c("JMessenger", "Receiver onReceive," + str + Consts.DOT + str2);
                    ((BroadcastReceiver) cls.newInstance()).onReceive(context, intent);
                } else {
                    cn.jiguang.ar.c.c("JMessenger", "Service onStartCommand," + str + Consts.DOT + str2);
                    ((Service) cls.newInstance()).onStartCommand(intent, 0, 0);
                }
                return new Bundle();
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.i("JMessenger", "directHandle e:" + th);
            return null;
        }
    }
}
