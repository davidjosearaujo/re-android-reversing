package cn.jiguang.av;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    public final g a;
    public int b;
    public long c;
    public long d;
    public int e;

    public d(g gVar) {
        this.a = gVar;
    }

    public static d a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d(new g(jSONObject.getString("ip"), jSONObject.getInt("port")));
            dVar.b = jSONObject.optInt("status");
            dVar.c = jSONObject.optLong("fetch_time");
            dVar.d = jSONObject.optLong("cost");
            dVar.e = jSONObject.optInt("prefer");
            return dVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ip", this.a.a);
            jSONObject.put("port", this.a.b);
            jSONObject.put("status", this.b);
            jSONObject.put("fetch_time", this.c);
            jSONObject.put("cost", this.d);
            jSONObject.put("prefer", this.e);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.b == dVar.b && this.c == dVar.c && this.d == dVar.d && this.e == dVar.e) {
                g gVar = this.a;
                g gVar2 = dVar.a;
                return gVar != null ? gVar.equals(gVar2) : gVar2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        g gVar = this.a;
        int hashCode = gVar != null ? gVar.hashCode() : 0;
        long j = this.c;
        long j2 = this.d;
        return (((((((hashCode * 31) + this.b) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.e;
    }

    public String toString() {
        return "IpInfo{ipPort=" + this.a + ", status=" + this.b + ", fetchTime=" + this.c + ", cost=" + this.d + ", prefer=" + this.e + '}';
    }
}
