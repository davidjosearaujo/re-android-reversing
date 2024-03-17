package cn.jiguang.av;

import cn.jpush.android.api.JThirdPlatFormInterface;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class n {
    public int a;
    public String b;
    public String c;
    public long d;
    public String e;
    public double f;
    public double g;
    public long h;
    private int i = 0;
    private int j = 0;

    public n(int i, String str, String str2, long j, String str3, double d, double d2, long j2) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = j;
        this.e = str3;
        this.f = d;
        this.g = d2;
        this.h = j2;
    }

    private static boolean a(double d, double d2) {
        return d > -90.0d && d < 90.0d && d2 > -180.0d && d2 < 180.0d;
    }

    public JSONObject a(Set<String> set) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.a);
            jSONObject.put(com.alipay.sdk.sys.a.o, this.b);
            jSONObject.put("sdkver", this.c);
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, 0);
            long j = this.d;
            if (j != 0) {
                jSONObject.put(CommonConstant.KEY_UID, j);
            }
            String str = this.e;
            if (str != null) {
                jSONObject.put("opera", str);
            }
            if (a(this.f, this.g)) {
                jSONObject.put("lat", this.f);
                jSONObject.put("lng", this.g);
                jSONObject.put(CrashHianalyticsData.TIME, this.h);
            }
            if (set != null && !set.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String str2 : set) {
                    jSONArray.put(str2);
                }
                jSONObject.put("fail_ips", jSONArray);
            }
            int i = this.i;
            if (i != 0) {
                jSONObject.put("ips_flag", i);
            }
            int i2 = this.j;
            if (i2 != 0) {
                jSONObject.put("report_flag", i2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
