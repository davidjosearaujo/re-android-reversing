package cn.jiguang.an;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jiguang.n.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends e {
        private Context a;
        private JSONObject c;

        public a(Context context, JSONObject jSONObject) {
            this.a = context;
            this.c = jSONObject;
            this.b = "JWakeCmd#WakeAction";
        }

        @Override // cn.jiguang.n.e
        public void a() {
            try {
                long f = cn.jiguang.n.b.f(this.a, "JWakeCmdcmd");
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = this.c;
                if (jSONObject == null && currentTimeMillis - f < JConstants.HOUR) {
                    cn.jiguang.ak.a.d("JWakeCmd", "is not cmd wake time");
                }
                b.c(this.a, jSONObject);
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JWakeCmd", "WakeAction failed:" + th.getMessage());
            }
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            cn.jiguang.ak.a.a("JWakeCmd", jSONObject == null ? "executeWakeAction: [JWakeCmd] from heartBeat" : "executeWakeAction: [JWakeCmd] from cmd");
            boolean booleanValue = ((Boolean) cn.jiguang.an.a.b(context)).booleanValue();
            cn.jiguang.ak.a.a("JWakeCmd", "JWakeCmd isActionUserEnable:" + booleanValue);
            if (booleanValue) {
                cn.jiguang.n.d.a(new a(context, jSONObject));
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.e("JWakeCmd", "[executeWakeAction] failed:" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, JSONObject jSONObject) {
        List<cn.jiguang.ao.c> a2;
        ApplicationInfo applicationInfo;
        try {
            cn.jiguang.n.b.e(context, "JWakeCmdcmd");
            String c = cn.jiguang.r.c.c(context, "bwct.catch.v2");
            cn.jiguang.ak.a.a("JWakeCmd", "read cmd wakeTarget:" + c);
            if (jSONObject != null) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                int optInt = jSONObject2.optInt("type", 1);
                String optString = jSONObject2.optString("pkgName", "");
                String optString2 = jSONObject2.optString("serviceName", "");
                a2 = null;
                if (optInt == 1 && (applicationInfo = context.getPackageManager().getApplicationInfo(optString, 128)) != null) {
                    a2 = new ArrayList<>();
                    cn.jiguang.ao.c cVar = new cn.jiguang.ao.c();
                    cVar.a = optString;
                    cVar.b = optString2;
                    cVar.c = applicationInfo.targetSdkVersion;
                    cVar.i = 1;
                    cVar.g = 4;
                    a2.add(cVar);
                }
                String a3 = cn.jiguang.ap.c.a(cn.jiguang.ap.d.a(c, optString, optString2, optInt));
                cn.jiguang.ak.a.a("JWakeCmd", "write cmd wakeTarget:" + a3);
                cn.jiguang.r.c.a(context, "bwct.catch.v2", a3);
            } else if (c == null || TextUtils.isEmpty(c)) {
                cn.jiguang.ak.a.d("JWakeCmd", "there are no cache cmd wakeTarget");
                return;
            } else {
                a2 = cn.jiguang.ap.c.a(context, cn.jiguang.ap.c.a(c));
            }
            if (a2 != null) {
                cn.jiguang.an.a.a(context, a2);
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWakeCmd", "parse throwable:" + th.getMessage());
        }
    }
}
