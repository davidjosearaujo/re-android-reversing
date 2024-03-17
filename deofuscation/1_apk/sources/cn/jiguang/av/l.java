package cn.jiguang.av;

import android.text.TextUtils;
import java.util.LinkedHashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class l {
    public LinkedHashSet<g> a;
    public LinkedHashSet<g> b;
    public LinkedHashSet<g> c;
    public LinkedHashSet<g> d;
    public LinkedHashSet<g> e;
    public JSONObject f;
    public transient g g;
    public boolean h;

    public l(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.a = a(jSONObject, "ips");
            this.b = a(jSONObject, "ssl_ips");
            this.c = a(jSONObject, "http_report");
            this.d = a(jSONObject, "https_report");
            this.e = a(jSONObject, "sis_ips");
            this.h = jSONObject.optBoolean("data_report");
            this.f = jSONObject.optJSONObject("tcp_report");
            cn.jiguang.ar.c.c("sis", "get sis=" + jSONObject.toString(2));
        } catch (Throwable unused) {
        }
    }

    private LinkedHashSet<g> a(JSONObject jSONObject, String str) {
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    g a = g.a(optJSONArray.optString(i, null));
                    if (a != null && a.a()) {
                        linkedHashSet.add(a);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return linkedHashSet;
    }

    public boolean a() {
        LinkedHashSet<g> linkedHashSet;
        LinkedHashSet<g> linkedHashSet2 = this.a;
        return (linkedHashSet2 == null || linkedHashSet2.isEmpty()) && ((linkedHashSet = this.b) == null || linkedHashSet.isEmpty());
    }
}
