package com.hunantv.oversea.channel.dynamic.render.live;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Label;
import com.facebook.internal.NativeProtocol;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.a;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PushAlertHelper {
    public static final String a = "sp_open_system_notification";
    public static final String b = "sp_sys_notify_module_id";
    private static final String c = "Xiaomi";
    private static final String d = "Huawei";
    private static final String e = "OPPO";
    private static final String f = "vivo";
    private static final /* synthetic */ c.b g = null;

    static {
        a();
    }

    private static /* synthetic */ void a() {
        e eVar = new e("PushAlertHelper.java", PushAlertHelper.class);
        g = eVar.H("method-execution", eVar.E("9", "goSystemNotificationSettingPage", "com.hunantv.oversea.channel.dynamic.render.live.PushAlertHelper", "android.content.Context", "context", "", "void"), 47);
    }

    public static final /* synthetic */ void b(Context context, c cVar) {
        boolean z;
        if (context == null) {
            return;
        }
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                Intent intent = new Intent();
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", a.a().getPackageName());
                intent.putExtra("android.provider.extra.CHANNEL_ID", a.a().getApplicationInfo().uid);
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                z = d(context, intent);
            } else if (i >= 21) {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent2.putExtra("app_package", a.a().getPackageName());
                intent2.putExtra("app_uid", a.a().getApplicationInfo().uid);
                intent2.putExtra("android.provider.extra.APP_PACKAGE", a.a().getPackageName());
                intent2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                z = d(context, intent2);
            } else if (i == 19) {
                Intent intent3 = new Intent();
                intent3.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent3.addCategory("android.intent.category.DEFAULT");
                intent3.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                intent3.setData(Uri.parse("package:" + a.a().getPackageName()));
                z = d(context, intent3);
            } else {
                Intent intent4 = new Intent();
                intent4.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                z = d(context, intent4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            z = false;
        }
        if (z || !c()) {
            return;
        }
        Intent intent5 = new Intent();
        intent5.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent5.setData(Uri.fromParts("package", context.getPackageName(), null));
        d(context, intent5);
    }

    private static boolean c() {
        String str = Build.MANUFACTURER;
        return TextUtils.equals(str, d) || TextUtils.equals(str, e) || TextUtils.equals(str, f) || TextUtils.equals(str, c);
    }

    public static boolean d(@NonNull Context context, Intent intent) {
        try {
            j.l.c.e0.a.a.a.h(intent);
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @WithTryCatchRuntime
    public static void goSystemNotificationSettingPage(Context context) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.w.c(new Object[]{context, e.w(g, (Object) null, (Object) null, context)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }
}
