package cn.jiguang.ax;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import cn.jpush.android.service.AlarmReceiver;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    public static void a(Context context) {
        try {
            ((AlarmManager) context.getSystemService("alarm")).cancel(j.l.c.e0.a.a.d.b(context, 0, new Intent(context, AlarmReceiver.class), 0));
        } catch (Throwable unused) {
            cn.jiguang.ar.c.g("AlarmHelper", "Cancel heartbeat alarm failed.");
        }
    }

    public static void b(Context context) {
        h.a().e();
        long h = h.a().h() * 1000;
        long currentTimeMillis = System.currentTimeMillis() + h;
        cn.jiguang.ar.c.e("AlarmHelper", "Reset heartbeat alarm, wait " + h + "ms.");
        try {
            PendingIntent b = j.l.c.e0.a.a.d.b(context, 0, new Intent(context, AlarmReceiver.class), 0);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setWindow(0, currentTimeMillis, 0L, b);
            } else {
                alarmManager.setInexactRepeating(0, currentTimeMillis, h, b);
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.h("AlarmHelper", "can't trigger alarm cause by exception:" + th);
        }
    }
}
