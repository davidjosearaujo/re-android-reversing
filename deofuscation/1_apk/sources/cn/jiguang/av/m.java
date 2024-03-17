package cn.jiguang.av;

import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class m {
    public String a;
    public int b;
    public g c;
    public long d;
    public long e;
    public long f;
    public int g;
    public double h;
    public double i;
    public long j;
    public int k;

    public static m a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                m mVar = new m();
                mVar.a = jSONObject.optString(com.alipay.sdk.sys.a.o);
                mVar.b = jSONObject.getInt("type");
                mVar.c = g.a(jSONObject.getString("addr"));
                mVar.e = jSONObject.getLong("rtime");
                mVar.f = jSONObject.getLong("interval");
                mVar.g = jSONObject.getInt(com.alipay.sdk.app.statistic.b.k);
                mVar.k = jSONObject.getInt(JThirdPlatFormInterface.KEY_CODE);
                mVar.d = jSONObject.optLong(CommonConstant.KEY_UID);
                mVar.h = jSONObject.optDouble("lat");
                mVar.i = jSONObject.optDouble("lng");
                mVar.j = jSONObject.optLong("ltime");
                return mVar;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static LinkedList<m> a(String str) {
        LinkedList<m> linkedList = new LinkedList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(a(jSONArray.getJSONObject(i)));
                }
            } catch (JSONException unused) {
            }
        }
        return linkedList;
    }

    private static boolean a(double d, double d2) {
        return d > -90.0d && d < 90.0d && d2 > -180.0d && d2 < 180.0d;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.a)) {
                jSONObject.put(com.alipay.sdk.sys.a.o, this.a);
            }
            jSONObject.put("type", this.b);
            jSONObject.put("addr", this.c.toString());
            jSONObject.put("rtime", this.e);
            jSONObject.put("interval", this.f);
            jSONObject.put(com.alipay.sdk.app.statistic.b.k, this.g);
            jSONObject.put(JThirdPlatFormInterface.KEY_CODE, this.k);
            long j = this.d;
            if (j != 0) {
                jSONObject.put(CommonConstant.KEY_UID, j);
            }
            if (a(this.h, this.i)) {
                jSONObject.put("lat", this.h);
                jSONObject.put("lng", this.i);
                jSONObject.put("ltime", this.j);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
