package cn.jiguang.b;

import android.content.Context;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.internal.JConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e extends cn.jiguang.be.b implements ReportCallBack {
    public e() {
        this.h = "ReportCrashLogDirect";
    }

    private JSONObject a(Context context) {
        JSONArray c = d.c(context);
        if (c == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashlogs", c);
            jSONObject.put("network_type", cn.jiguang.f.a.l(context));
            cn.jiguang.d.a.a(context, jSONObject, "crash_log");
            Object a = cn.jiguang.c.b.a(context);
            JSONObject jSONObject2 = a instanceof JSONObject ? (JSONObject) a : null;
            if (jSONObject2 != null && jSONObject2.length() > 0) {
                jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, jSONObject2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // cn.jiguang.be.b
    public void a() {
        try {
            Context appContext = JConstants.getAppContext(null);
            if (appContext == null) {
                cn.jiguang.ar.c.g("ReportCrashLogDirect", "ReportDirect context is null");
                return;
            }
            JSONObject a = a(appContext);
            if (a != null) {
                cn.jiguang.as.f.a(appContext, a, this);
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.i("ReportCrashLogDirect", "run report crash e:" + th);
        }
    }

    @Override // cn.jiguang.api.ReportCallBack
    public void onFinish(int i) {
        cn.jiguang.ar.c.g("ReportCrashLogDirect", "ReportDirect finish : " + i);
        if (i == 0) {
            d.d(JConstants.getAppContext(null));
        }
    }
}
