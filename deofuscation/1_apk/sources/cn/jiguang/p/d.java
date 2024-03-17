package cn.jiguang.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d extends cn.jiguang.n.a {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile d c;
    private Context a;
    private JSONObject b;

    public static d a() {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d();
                }
            }
        }
        return c;
    }

    private boolean a(JSONObject jSONObject) {
        String h = cn.jiguang.n.b.h(this.a);
        if (TextUtils.isEmpty(h)) {
            cn.jiguang.ak.a.a("JDeviceIds", "ids cache is empty");
        } else {
            try {
                return !h.equals(cn.jiguang.n.d.c(jSONObject.toString()));
            } catch (Exception e) {
                cn.jiguang.ak.a.d("JDeviceIds", "[checkIdsChanged] toMD5 error: " + e.getMessage());
            }
        }
        return true;
    }

    private void e() {
        try {
            Object obj = this.b.get("data");
            if (obj != null) {
                String c2 = cn.jiguang.n.d.c(cn.jiguang.n.d.g(obj.toString()));
                cn.jiguang.n.b.w(this.a, c2);
                cn.jiguang.ak.a.a("JDeviceIds", "device ids refresh cache success, md5-ids: " + c2);
            }
        } catch (Exception e) {
            cn.jiguang.ak.a.d("JDeviceIds", "ids encrypted failed, err: " + e.getMessage());
        }
    }

    @Override // cn.jiguang.n.a
    public String a(Context context) {
        this.a = context;
        return "JDeviceIds";
    }

    @Override // cn.jiguang.n.a
    public void b(Context context, String str) {
        String str2;
        if (cn.jiguang.i.a.a().e(1900)) {
            return;
        }
        try {
            JSONObject a = cn.jiguang.t.a.a(context);
            if (a == null) {
                cn.jiguang.ak.a.d("JDeviceIds", "ids collect failed");
            } else if (!a(a)) {
                cn.jiguang.ak.a.a("JDeviceIds", "ids not changed, need not report");
            } else {
                try {
                    str2 = cn.jiguang.n.d.f(a.toString());
                } catch (Exception e) {
                    cn.jiguang.ak.a.d("JDeviceIds", "ids encrypted failed, err: " + e.getMessage());
                    str2 = "";
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                if (this.b == null) {
                    this.b = new JSONObject();
                }
                this.b.put("data", str2);
                cn.jiguang.ak.a.a("JDeviceIds", "collect success:" + this.b + ", origin ids: " + a.toString());
                super.b(context, str);
            }
        } catch (JSONException e2) {
            cn.jiguang.ak.a.d("JDeviceIds", "packageJson exception: " + e2.getMessage());
        }
    }

    @Override // cn.jiguang.n.a
    public void d(Context context, String str) {
        if (cn.jiguang.i.a.a().e(1900)) {
            return;
        }
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            cn.jiguang.ak.a.d("JDeviceIds", "there are no data to report");
            return;
        }
        cn.jiguang.n.d.a(context, jSONObject, "sdk_joa");
        cn.jiguang.n.d.a(context, (Object) this.b);
        super.d(context, str);
        e();
        cn.jiguang.ak.a.a("JDeviceIds", str + "report success, reportData: " + this.b);
        this.b = null;
    }
}
