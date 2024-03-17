package cn.jiguang.am;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.n.b;
import cn.jiguang.n.d;
import com.facebook.internal.ServerProtocol;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a extends cn.jiguang.n.a {
    private Context a;
    private Bundle b;
    private String c = "";
    private int d = 0;
    private int e = 0;
    private int f = 0;

    private JSONObject a(String str, int i, int i2) {
        int i3;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(i);
            jSONArray.put(i2);
            if (!"core".equals(str)) {
                if ("push".equals(str)) {
                    jSONArray.put(d.h());
                    i3 = this.f;
                }
                jSONObject2.put(str, jSONArray);
                jSONObject.put("type", HianalyticsBaseData.SDK_TYPE);
                jSONObject.put("itime", d.h(this.a));
                jSONObject.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, jSONObject2);
                return jSONObject;
            }
            jSONArray.put(d.d());
            i3 = this.f;
            jSONArray.put(i3);
            jSONObject2.put(str, jSONArray);
            jSONObject.put("type", HianalyticsBaseData.SDK_TYPE);
            jSONObject.put("itime", d.h(this.a));
            jSONObject.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, jSONObject2);
            return jSONObject;
        } catch (JSONException e) {
            cn.jiguang.ak.a.d("JType", "package json exception: " + e.getMessage());
            return null;
        }
    }

    private static boolean a(Context context, String str, int i, int i2, int i3) {
        if (TextUtils.isEmpty(str) || i < 0 || i2 < 0) {
            return false;
        }
        int q = b.q(context, str);
        cn.jiguang.ak.a.a("JType", "[isTypeReportEnable],lastversion:" + q + ",curversion:" + i3 + ",type:" + str);
        if (q != i3) {
            return true;
        }
        String p = b.p(context, str);
        return !p.equals(i + "," + i2);
    }

    @Override // cn.jiguang.n.a
    public String a(Context context) {
        this.a = context;
        return "JType";
    }

    @Override // cn.jiguang.n.a
    public void a(String str, Bundle bundle) {
        this.b = bundle;
    }

    @Override // cn.jiguang.n.a
    public void b(Context context, String str) {
    }

    @Override // cn.jiguang.n.a
    public void d(Context context, String str) {
        JSONObject a = a(this.c, this.d, this.e);
        if (a == null) {
            cn.jiguang.ak.a.d("JType", "there are no data to report");
        } else {
            d.a(context, (Object) a);
        }
    }

    @Override // cn.jiguang.n.a
    public boolean d() {
        Bundle bundle = this.b;
        if (bundle == null) {
            return false;
        }
        this.c = bundle.getString("name");
        this.d = this.b.getInt("custom", 0);
        this.e = this.b.getInt("dynamic", 0);
        this.f = this.b.getInt("sdk_v", 0);
        cn.jiguang.ak.a.a("JType", "parseBundle type:" + this.c + ",custom:" + this.d + ",dynamic:" + this.e + ",sdkVersion:" + this.f);
        boolean a = a(this.a, this.c, this.d, this.e, this.f);
        if (a) {
            b.a(this.a, this.c, this.f);
            b.a(this.a, this.c, this.d + "," + this.e);
        } else {
            cn.jiguang.ak.a.a("JType", "type [" + this.c + "] data not change");
        }
        return a;
    }
}
