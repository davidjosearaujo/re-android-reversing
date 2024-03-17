package cn.jiguang.h;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.n.d;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static long a;

    public static void a(Context context, int i) {
        cn.jiguang.ak.a.a("JAnalytics", "sendStartAPP:" + i);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a < AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS) {
            cn.jiguang.ak.a.a("JAnalytics", "sendStartAPP return:" + i);
            return;
        }
        a = currentTimeMillis;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i);
        } catch (Throwable unused) {
        }
        a(context, 2021, "Start the APP", jSONObject);
    }

    public static void a(Context context, int i, String str, JSONObject jSONObject) {
        b(context, i, str, jSONObject);
    }

    public static void b(Context context, int i, String str, JSONObject jSONObject) {
        if (context == null) {
            cn.jiguang.ak.a.f("JAnalytics", "reportPushAnylysis NULL context");
        } else if (!d.c()) {
            cn.jiguang.b.a.a(context, i, str);
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt(JThirdPlatFormInterface.KEY_CODE, i);
            bundle.putString("msg", str);
            JCoreManager.onEvent(context, null, 87, null, bundle, jSONObject);
        }
    }
}
