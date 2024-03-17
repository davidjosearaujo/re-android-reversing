package com.hunantv.oversea.me.schema;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import cn.jpush.android.local.JPushConstants;
import com.alibaba.fastjson.asm.Label;
import com.facebook.internal.NativeProtocol;
import com.google.auto.service.AutoService;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.hunantv.oversea.scheme.core.SchemeJumper;
import com.hunantv.oversea.scheme.core.config.ComponentConfigEntity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.e0.a.a.a;
import j.l.d.d;
import r.a.b.c;
import r.a.c.c.e;

@AutoService({SchemeJumper.class})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MeSchemeJumper implements SchemeJumper {
    private static final String ACTION_APP_MANAGER_SETTINGS = "appManagerSettingsSystem";
    private static final String ACTION_BROWSER = "browserSystem";
    private static final String ACTION_LANGUAGE_SWITCH = "languageswitch";
    private static final String ACTION_MARKET = "market";
    private static final String ACTION_MGUSERCENTER = "mguserCenter";
    private static final String ACTION_PRIVACYSETTING = "privacysetting";
    private static final String ACTION_SETTINGS = "settingsSystem";
    private static final String ACTION_SMESSAGE = "smessage";
    private static final String ACTION_SSCAN = "sscan";
    private static final String ACTION_SSETINGS = "ssetings";
    private static final String ACTION_WIFI_SETTINGS = "wifiSettingsSystem";
    private static final String PARA_TAB_INDEX = "tabIndex";
    private static final String TAG;
    private static final /* synthetic */ c.b ajc$tjp_0 = null;
    private ComponentConfigEntity mComponentConfigEntity;
    private String[] mHosts;

    static {
        ajc$preClinit();
        TAG = MeSchemeJumper.class.getSimpleName();
    }

    private static /* synthetic */ void ajc$preClinit() {
        e eVar = new e("MeSchemeJumper.java", MeSchemeJumper.class);
        ajc$tjp_0 = eVar.H("method-execution", eVar.E("9", "gotoMarket", "com.hunantv.oversea.me.schema.MeSchemeJumper", "android.content.Context:java.lang.String", "context:pkg", "", "void"), 150);
    }

    private String getComponentPath(String str) {
        ComponentConfigEntity componentConfigEntity = this.mComponentConfigEntity;
        if (componentConfigEntity != null) {
            return componentConfigEntity.getComponentPath(str);
        }
        return null;
    }

    public static boolean goToSamsungMarket(Context context, String str) {
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("http://www.samsungapps.com/appquery/appDetail.as?appId=" + str));
        intent.setPackage("com.sec.android.app.samsungapps");
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        try {
            a.h(intent);
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            Log.w(ACTION_MARKET, "goToSamsungMarket: " + Log.getStackTraceString(e));
            return false;
        }
    }

    private static void gotoBrowser(Context context, String str) {
        String str2 = TAG;
        Log.d(str2, "jump: " + str);
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null) {
            parse = Uri.parse(JPushConstants.HTTP_PRE + str);
        }
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, parse);
        a.h(intent);
        context.startActivity(intent);
    }

    @WithTryCatchRuntime
    public static void gotoMarket(Context context, @Nullable String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.k.j.a(new Object[]{context, str, e.x(ajc$tjp_0, (Object) null, (Object) null, context, str)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    public static final /* synthetic */ void gotoMarket_aroundBody0(Context context, String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            str = "com.hunantv.imgo.activity.inter";
        }
        if (launchAppDetail(context, str)) {
            return;
        }
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("https://glb.api.mgtv.com/download.html"));
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        a.h(intent);
        context.startActivity(intent);
    }

    public static boolean isGooglePlayInstalled(Context context) {
        PackageManager packageManager = context.getPackageManager();
        boolean z = false;
        try {
            String str = (String) packageManager.getPackageInfo("com.android.vending", 1).applicationInfo.loadLabel(packageManager);
            if (str != null) {
                if (!str.equals("Market")) {
                    z = true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        Log.d(ACTION_MARKET, "isGooglePlayInstalled: " + z);
        return z;
    }

    private static boolean launchAppDetail(Context context, String str) {
        if (!TextUtils.isEmpty(str) && isGooglePlayInstalled(context)) {
            if ("samsung".equals(Build.BRAND)) {
                return goToSamsungMarket(context, str);
            }
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("market://details?id=" + str));
            intent.setPackage("com.android.vending");
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            if (intent.resolveActivity(context.getPackageManager()) == null) {
                return false;
            }
            a.h(intent);
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    public String[] hosts() {
        if (this.mHosts == null) {
            if (this.mComponentConfigEntity == null) {
                this.mComponentConfigEntity = j.l.c.z.c.h.a.c(j.l.a.a.a(), "schema/MGUserCenterRouterConfig.yaml", true);
            }
            ComponentConfigEntity componentConfigEntity = this.mComponentConfigEntity;
            if (componentConfigEntity != null) {
                this.mHosts = componentConfigEntity.getPaths();
            }
        }
        return this.mHosts;
    }

    public boolean jump(Context context, Uri uri, Bundle bundle, j.l.c.z.c.c cVar) {
        if (uri == null || TextUtils.isEmpty(uri.getHost())) {
            return false;
        }
        String host = uri.getHost();
        String componentPath = getComponentPath(uri.getHost());
        host.hashCode();
        char c = 65535;
        switch (host.hashCode()) {
            case -2074007897:
                if (host.equals(ACTION_WIFI_SETTINGS)) {
                    c = 0;
                    break;
                }
                break;
            case -1887357902:
                if (host.equals(ACTION_SETTINGS)) {
                    c = 1;
                    break;
                }
                break;
            case -1842508937:
                if (host.equals(ACTION_BROWSER)) {
                    c = 2;
                    break;
                }
                break;
            case -1081306052:
                if (host.equals(ACTION_MARKET)) {
                    c = 3;
                    break;
                }
                break;
            case -485349324:
                if (host.equals(ACTION_SMESSAGE)) {
                    c = 4;
                    break;
                }
                break;
            case 109729136:
                if (host.equals(ACTION_SSCAN)) {
                    c = 5;
                    break;
                }
                break;
            case 545343584:
                if (host.equals(ACTION_SSETINGS)) {
                    c = 6;
                    break;
                }
                break;
            case 678979724:
                if (host.equals(ACTION_LANGUAGE_SWITCH)) {
                    c = 7;
                    break;
                }
                break;
            case 1187013064:
                if (host.equals(ACTION_PRIVACYSETTING)) {
                    c = '\b';
                    break;
                }
                break;
            case 1902818586:
                if (host.equals(ACTION_MGUSERCENTER)) {
                    c = '\t';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Intent intent = new Intent("android.settings.WIFI_SETTINGS");
                a.h(intent);
                context.startActivity(intent);
                break;
            case 1:
                Intent intent2 = new Intent("android.settings.SETTINGS");
                a.h(intent2);
                context.startActivity(intent2);
                break;
            case 2:
                String queryParameter = uri.getQueryParameter("url");
                if (!TextUtils.isEmpty(queryParameter)) {
                    gotoBrowser(context, queryParameter);
                    break;
                } else {
                    return false;
                }
            case 3:
                gotoMarket(context, uri.getQueryParameter("pkg"));
                break;
            case 4:
            case 6:
            case 7:
            case '\b':
                if (!TextUtils.isEmpty(componentPath)) {
                    new d.c().a(componentPath).h(bundle).g().g(context);
                    break;
                } else {
                    return false;
                }
            case 5:
                if (!TextUtils.isEmpty(componentPath)) {
                    new d.c().a(componentPath).h(bundle).p(PARA_TAB_INDEX, uri.getQueryParameter(PARA_TAB_INDEX)).g().g(context);
                    break;
                } else {
                    return false;
                }
            case '\t':
                if (uri.getBooleanQueryParameter("isFromOutside", false)) {
                    j.l.c.z.c.d.d(context, "omgotv://home?tabID=mine&jumpposition=3", bundle);
                    break;
                } else {
                    j.l.c.z.c.d.j(context, "omgotv://home?tabID=mine&jumpposition=3", bundle);
                    break;
                }
            default:
                return false;
        }
        return true;
    }
}
