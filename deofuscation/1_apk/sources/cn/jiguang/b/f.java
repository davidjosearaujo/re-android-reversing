package cn.jiguang.b;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class f {
    private static boolean a;
    private static Handler b;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends Handler {
        private Context a;

        public a(Context context) {
            super(Looper.getMainLooper());
            this.a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                if (1 == message.what) {
                    f.c(this.a);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void a(Context context) {
        boolean equals;
        synchronized (f.class) {
            try {
                equals = context.getPackageName().equals(cn.jiguang.f.a.a(context));
                cn.jiguang.ar.c.c("ScreenRegister", "registerReceiver isCurProcess:" + equals);
            } catch (Throwable unused) {
            }
            if (equals) {
                if (a) {
                    return;
                }
                a = true;
                b = new a(context);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                context.getApplicationContext().registerReceiver(new BroadcastReceiver() { // from class: cn.jiguang.b.f.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        if (intent == null) {
                            return;
                        }
                        try {
                            String action = intent.getAction();
                            cn.jiguang.ar.c.c("ScreenRegister", "onReceive Action:" + action);
                            if (f.b != null) {
                                f.b.removeMessages(1);
                                f.b.sendEmptyMessageDelayed(1, AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS);
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }, intentFilter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        boolean isScreenOn = ((PowerManager) context.getSystemService("power")).isScreenOn();
        cn.jiguang.ar.c.c("ScreenRegister", "onReceive isScreenOn:" + isScreenOn);
        boolean inKeyguardRestrictedInputMode = ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        cn.jiguang.ar.c.c("ScreenRegister", "onReceive flag:" + inKeyguardRestrictedInputMode);
        boolean z = isScreenOn && !inKeyguardRestrictedInputMode;
        StringBuilder sb = new StringBuilder();
        sb.append("onReceive status:");
        sb.append(z ? "开" : "锁");
        cn.jiguang.ar.c.c("ScreenRegister", sb.toString());
        JSONObject jSONObject = new JSONObject();
        JSONObject a2 = cn.jiguang.d.a.a(context, jSONObject, "sc_status");
        jSONObject.put("status", z);
        cn.jiguang.ar.c.c("ScreenRegister", "onReceive jsonObject:" + a2);
        cn.jiguang.d.a.a(context, a2);
    }
}
