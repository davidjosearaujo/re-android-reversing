package cn.jiguang.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.hunantv.media.player.subtitle.MediaFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c extends cn.jiguang.n.a {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile c c;
    private Context a;
    private JSONObject b;

    public static c a() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    @Override // cn.jiguang.n.a
    public String a(Context context) {
        this.a = context;
        return "JDeviceBattery";
    }

    @Override // cn.jiguang.n.a
    public void b(Context context, String str) {
        if (cn.jiguang.i.a.a().e(1200)) {
            return;
        }
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), context.getPackageName() + cn.jiguang.a.a.a, null);
            if (registerReceiver == null) {
                return;
            }
            int intExtra = registerReceiver.getIntExtra(MediaFormat.KEY_LEVEL, -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            int intExtra3 = registerReceiver.getIntExtra("status", -1);
            if (intExtra3 == 1) {
                intExtra3 = 0;
            } else if (intExtra3 == 2) {
                intExtra3 = 2;
            } else if (intExtra3 == 3 || intExtra3 == 4) {
                intExtra3 = 1;
            } else if (intExtra3 == 5) {
                intExtra3 = 3;
            }
            int intExtra4 = registerReceiver.getIntExtra("voltage", -1);
            int intExtra5 = registerReceiver.getIntExtra("temperature", -1);
            if (this.b == null) {
                this.b = new JSONObject();
            }
            this.b.put(MediaFormat.KEY_LEVEL, intExtra);
            this.b.put("scale", intExtra2);
            this.b.put("status", intExtra3);
            this.b.put("voltage", intExtra4);
            this.b.put("temperature", intExtra5);
            cn.jiguang.ak.a.a("JDeviceBattery", "collect success:" + this.b);
            super.b(context, str);
        } catch (JSONException e) {
            cn.jiguang.ak.a.d("JDeviceBattery", "packageJson exception: " + e.getMessage());
        }
    }

    @Override // cn.jiguang.n.a
    public void d(Context context, String str) {
        if (cn.jiguang.i.a.a().e(1200)) {
            return;
        }
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            cn.jiguang.ak.a.d("JDeviceBattery", "there are no data to report");
            return;
        }
        cn.jiguang.n.d.a(context, jSONObject, "battery");
        cn.jiguang.n.d.a(context, (Object) this.b);
        super.d(context, str);
        this.b = null;
    }
}
