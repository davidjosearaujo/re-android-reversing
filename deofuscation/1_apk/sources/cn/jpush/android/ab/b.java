package cn.jpush.android.ab;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.x.e;
import com.alibaba.fastjson.asm.Label;
import java.util.LinkedList;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    public static int a;

    public static d a(Context context, String str, String str2) {
        return d.a(context, str, str2);
    }

    private static void a(Context context, d dVar) {
        Intent b = 2 == dVar.Z ? cn.jpush.android.x.c.b(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar) : cn.jpush.android.x.c.a(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar);
        if (b != null) {
            b.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            Context applicationContext = context.getApplicationContext();
            j.l.c.e0.a.a.a.h(b);
            applicationContext.startActivity(b);
        }
    }

    private static void a(Context context, d dVar, String str, int i) {
        Logger.v("PluginPlatformsNotificationHelper", "Action - onNotificationMessageArrived");
        cn.jpush.android.x.c.a(context, "cn.jpush.android.intent.NOTIFICATION_ARRIVED", dVar, (Intent) null);
        cn.jpush.android.helper.c.a(dVar.c, str, dVar.ae, 1018, context);
    }

    public static void a(Context context, String str, String str2, int i, byte b, int i2) {
        String str3;
        if (context == null) {
            str3 = "context was null";
        } else if (TextUtils.isEmpty(str)) {
            str3 = "content was null";
        } else {
            Logger.v("PluginPlatformsNotificationHelper", "message content:" + str);
            d a2 = a(context, str, str2);
            Logger.v("PluginPlatformsNotificationHelper", "entity:" + a2);
            if (a2 == null) {
                str3 = "entity was null";
            } else if (!TextUtils.isEmpty(a2.c)) {
                a2.ae = b;
                a2.d = i;
                if (i2 == 0) {
                    c(context, a2, str2, i);
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(a2.c);
                    e.a(context, linkedList);
                    return;
                } else if (i2 == 1) {
                    a(context, a2, str2, i);
                    return;
                } else if (i2 != 2) {
                    return;
                } else {
                    b(context, a2, str2, i);
                    return;
                }
            } else {
                str3 = "message id was empty";
            }
        }
        Logger.ww("PluginPlatformsNotificationHelper", str3);
    }

    private static void b(Context context, d dVar, String str, int i) {
        Logger.v("PluginPlatformsNotificationHelper", "Action - onNotificationMessageUnShow in foreground");
        dVar.d = i;
        cn.jpush.android.x.c.a(context, "cn.jpush.android.intent.NOTIFICATION_UN_SHOW", dVar, (Intent) null);
        cn.jpush.android.helper.c.a(dVar.c, str, dVar.ae, 1060, context);
    }

    private static void c(Context context, d dVar, String str, int i) {
        Logger.v("PluginPlatformsNotificationHelper", "Action - onNotificationMessageClick");
        if (dVar.U) {
            a(context, dVar);
            return;
        }
        cn.jpush.android.x.c.a(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar, (Intent) null);
        cn.jpush.android.helper.c.a(dVar.c, str, dVar.ae, 1000, context);
    }
}
