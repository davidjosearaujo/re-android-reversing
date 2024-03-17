package cn.jiguang.al;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.n.b;
import cn.jiguang.n.d;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    public static void a(Context context, int i) {
        boolean z;
        boolean z2;
        if (cn.jiguang.i.a.a().a(1800)) {
            String f = b.f(context);
            boolean a = new a().a(context);
            boolean z3 = true;
            if (!TextUtils.isEmpty(f)) {
                if (TextUtils.equals("ON", f)) {
                    z = false;
                    z2 = true;
                } else {
                    z = !TextUtils.equals("OFF", f);
                    z2 = false;
                }
                if (z) {
                    cn.jiguang.ak.a.a("JNotificationState", "notification state do not changed");
                    z3 = z;
                } else if (z2 == a) {
                    z3 = false;
                }
            }
            cn.jiguang.ak.a.a("JNotificationState", "lastCacheNotificationState:" + f + ",currentNotificationSate:" + a + ",isNeedReport:" + z3 + ",triggerScene:" + i);
            if (!z3) {
                cn.jiguang.ak.a.a("JNotificationState", "do not need report notification state");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("notification_state", a);
                if (cn.jiguang.i.a.a().a(1802)) {
                    jSONObject.put("device_id", d.g(context));
                }
                jSONObject.put("trigger_scene", i);
                d.a(context, jSONObject, "android_notification_state");
                d.a(context, (Object) jSONObject);
                b.u(context, a ? "ON" : "OFF");
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JNotificationState", "report notification state failed, error:" + th.getMessage());
            }
        }
    }

    private boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 24 ? b(context) : c(context);
    }

    @TargetApi(24)
    private boolean b(Context context) {
        try {
            return ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).areNotificationsEnabled();
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JNotificationState", "invoke areNotificationsEnabled method failed, error:" + th.getMessage());
            return true;
        }
    }

    private boolean c(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JNotificationState", "getNotificationStateCommon failed, other error:" + th.getMessage());
            return true;
        }
    }
}
