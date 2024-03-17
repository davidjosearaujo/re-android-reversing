package com.hunantv.oversea.me.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.alibaba.fastjson.asm.Label;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.hunantv.media.drm.IDrmSession;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.v;
import j.l.c.e0.a.a.a;
import j.l.c.k.m.b;
import j.l.c.k.m.d;
import j.l.c.k.m.f;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class JumpPermissionSettingUtil {
    private static final String a = "Huawei";
    private static final String b = "Meizu";
    private static final String c = "Xiaomi";
    private static final String d = "Sony";
    private static final String e = "OPPO";
    private static final String f = "LG";
    private static final String g = "vivo";
    private static final String h = "samsung";
    private static final String i = "Letv";
    private static final String j = "ZTE";
    private static final String k = "YuLong";
    private static final String l = "LENOVO";
    private static final /* synthetic */ c.b m = null;
    private static final /* synthetic */ c.b n = null;
    private static final /* synthetic */ c.b o = null;
    private static final /* synthetic */ c.b p = null;
    private static final /* synthetic */ c.b q = null;

    static {
        l();
    }

    @WithTryCatchRuntime
    public static void ApplicationInfo(Activity activity) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d(new Object[]{activity, e.w(o, (Object) null, (Object) null, activity)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    @WithTryCatchRuntime
    public static void SystemConfig(Activity activity) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.k.m.e(new Object[]{activity, e.w(p, (Object) null, (Object) null, activity)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    @WithTryCatchRuntime
    public static void _360(Activity activity) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.k.m.c(new Object[]{activity, e.w(n, (Object) null, (Object) null, activity)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    public static final /* synthetic */ void a(Activity activity, c cVar) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", n(), null));
        a.h(intent);
        activity.startActivity(intent);
    }

    public static void b(Activity activity) {
        try {
            Intent intent = new Intent();
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtra(CommonConstant.ReqAccessTokenParam.PACKAGE_NAME, n());
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            a.h(intent);
            activity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            ApplicationInfo(activity);
        }
    }

    public static void c(Activity activity) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtra(CommonConstant.ReqAccessTokenParam.PACKAGE_NAME, n());
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity"));
            a.h(intent);
            activity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            ApplicationInfo(activity);
        }
    }

    public static void d(Activity activity) {
        try {
            Intent intent = new Intent();
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtra(CommonConstant.ReqAccessTokenParam.PACKAGE_NAME, n());
            intent.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.PermissionAndApps"));
            a.h(intent);
            activity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            ApplicationInfo(activity);
        }
    }

    public static void e(Activity activity) {
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra(CommonConstant.ReqAccessTokenParam.PACKAGE_NAME, n());
            a.h(intent);
            activity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            ApplicationInfo(activity);
        }
    }

    public static void f(Activity activity) {
        try {
            Intent intent = new Intent();
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtra(CommonConstant.ReqAccessTokenParam.PACKAGE_NAME, n());
            intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
            a.h(intent);
            activity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            ApplicationInfo(activity);
        }
    }

    public static void g(Activity activity) {
        try {
            Intent intent = new Intent();
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtra(CommonConstant.ReqAccessTokenParam.PACKAGE_NAME, n());
            intent.setComponent(new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity"));
            a.h(intent);
            activity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            ApplicationInfo(activity);
        }
    }

    @WithTryCatchRuntime
    private static String getMiuiVersion() {
        return (String) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f(new Object[]{e.v(q, (Object) null, (Object) null)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    @WithTryCatchRuntime
    public static void goToSetting(Activity activity) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new b(new Object[]{activity, e.w(m, (Object) null, (Object) null, activity)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    public static final /* synthetic */ void h(Activity activity, c cVar) {
        Intent intent = new Intent("android.settings.SETTINGS");
        a.h(intent);
        activity.startActivity(intent);
    }

    public static void i(Activity activity) {
        Intent intent;
        try {
            String str = Build.MODEL;
            if ((str.contains("Y85") && !str.contains("Y85A")) || str.contains("vivo Y53L")) {
                intent = new Intent();
                intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.PurviewTabActivity");
                intent.putExtra("packagename", n());
                intent.putExtra("tabId", "1");
            } else {
                intent = new Intent();
                intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
                intent.setAction("secure.intent.action.softPermissionDetail");
                intent.putExtra("packagename", n());
            }
            a.h(intent);
            activity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            ApplicationInfo(activity);
        }
    }

    public static void j(Activity activity) {
        try {
            Intent intent = new Intent();
            String miuiVersion = getMiuiVersion();
            if (!"V6".equals(miuiVersion) && !"V7".equals(miuiVersion)) {
                if (!"V8".equals(miuiVersion) && !"V9".equals(miuiVersion)) {
                    ApplicationInfo(activity);
                }
                intent.setAction("miui.intent.action.APP_PERM_EDITOR");
                intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                intent.putExtra("extra_pkgname", n());
            }
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", n());
        } catch (Exception e2) {
            e2.printStackTrace();
            ApplicationInfo(activity);
        }
    }

    public static final /* synthetic */ void k(Activity activity, c cVar) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtra(CommonConstant.ReqAccessTokenParam.PACKAGE_NAME, n());
        intent.setComponent(new ComponentName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity"));
        a.h(intent);
        activity.startActivity(intent);
    }

    private static /* synthetic */ void l() {
        e eVar = new e("JumpPermissionSettingUtil.java", JumpPermissionSettingUtil.class);
        m = eVar.H("method-execution", eVar.E("9", "goToSetting", "com.hunantv.oversea.me.util.JumpPermissionSettingUtil", "android.app.Activity", "activity", "", "void"), 51);
        n = eVar.H("method-execution", eVar.E("9", "_360", "com.hunantv.oversea.me.util.JumpPermissionSettingUtil", "android.app.Activity", "activity", "", "void"), (int) IDrmSession.ERROR_SESSION_PROVISION_ERROR);
        o = eVar.H("method-execution", eVar.E("9", "ApplicationInfo", "com.hunantv.oversea.me.util.JumpPermissionSettingUtil", "android.app.Activity", "activity", "", "void"), 227);
        p = eVar.H("method-execution", eVar.E("9", "SystemConfig", "com.hunantv.oversea.me.util.JumpPermissionSettingUtil", "android.app.Activity", "activity", "", "void"), 239);
        q = eVar.H("method-execution", eVar.E("a", "getMiuiVersion", "com.hunantv.oversea.me.util.JumpPermissionSettingUtil", "", "", "", "java.lang.String"), 245);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x004f: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:23:0x004f */
    public static final /* synthetic */ String m(c cVar) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                try {
                    bufferedReader3.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return readLine;
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader3 = bufferedReader2;
            bufferedReader3.close();
            throw th;
        }
    }

    private static String n() {
        return j.l.a.a.a().getPackageName();
    }

    public static final /* synthetic */ void o(Activity activity, c cVar) {
        String str = Build.MANUFACTURER;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2122609145:
                if (str.equals(a)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1675632421:
                if (str.equals(c)) {
                    c2 = 1;
                    break;
                }
                break;
            case 2427:
                if (str.equals(f)) {
                    c2 = 2;
                    break;
                }
                break;
            case 2364891:
                if (str.equals(i)) {
                    c2 = 3;
                    break;
                }
                break;
            case 2432928:
                if (str.equals(e)) {
                    c2 = 4;
                    break;
                }
                break;
            case 2582855:
                if (str.equals(d)) {
                    c2 = 5;
                    break;
                }
                break;
            case 3620012:
                if (str.equals(g)) {
                    c2 = 6;
                    break;
                }
                break;
            case 74224812:
                if (str.equals(b)) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                b(activity);
                return;
            case 1:
                j(activity);
                return;
            case 2:
                c(activity);
                return;
            case 3:
                d(activity);
                return;
            case 4:
                f(activity);
                return;
            case 5:
                g(activity);
                return;
            case 6:
                i(activity);
                return;
            case 7:
                e(activity);
                return;
            default:
                ApplicationInfo(activity);
                v.g("goToSetting", "目前暂不支持此系统");
                return;
        }
    }
}
