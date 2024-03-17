package cn.jpush.android.b;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b implements Serializable {
    private static final long serialVersionUID = 2310616383854860780L;
    public String a;
    public long b;
    public String c;
    public boolean d;
    public long e;
    public double f = 200.0d;
    public double g = 200.0d;
    public String h;
    public int i;
    public String j;
    public String k;
    public int l;
    public int m;
    public int n;
    public long o;
    public String p;
    public int q;
    public String r;
    public int s;
    public cn.jpush.android.d.d t;

    public static b a(Context context, JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                Logger.w("Geofence", "geofence json is null");
                return null;
            }
            b bVar = new b();
            Logger.d("Geofence", "geofence message:" + jSONObject.toString());
            bVar.k = jSONObject.optString("op");
            bVar.a = jSONObject.optString("geofenceid");
            bVar.j = jSONObject.optString("name");
            bVar.b = jSONObject.optLong("radius");
            bVar.c = jSONObject.optString("status");
            bVar.d = jSONObject.optBoolean("repeat");
            bVar.l = jSONObject.optInt("repeat_week_num");
            bVar.m = jSONObject.optInt("repeat_day_num");
            bVar.n = jSONObject.optInt("repeat_time");
            bVar.e = jSONObject.optLong("expiration");
            bVar.i = jSONObject.optInt("type", 1);
            bVar.f = jSONObject.optDouble("lon", 200.0d);
            bVar.g = jSONObject.optDouble("lat", 200.0d);
            bVar.o = jSONObject.optLong("lastTime");
            bVar.p = jSONObject.optString("lastTimeWeek");
            bVar.q = jSONObject.optInt("weekNum");
            bVar.r = jSONObject.optString("lastTimeDay");
            bVar.s = jSONObject.optInt("dayNum");
            bVar.h = jSONObject.optString("lastGeoStatus");
            String optString = jSONObject.optString("entity");
            if (!TextUtils.isEmpty(optString)) {
                bVar.t = cn.jpush.android.d.d.b(optString, context.getPackageName(), JCoreHelper.getAppKey(context), 0L);
            }
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static b a(JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                Logger.w("Geofence", "geofence json is null");
                return null;
            }
            b bVar = new b();
            Logger.d("Geofence", "geofence message:" + jSONObject.toString());
            bVar.k = jSONObject.optString("op");
            bVar.a = jSONObject.optString("geofenceid");
            bVar.j = jSONObject.optString("name");
            bVar.b = jSONObject.optLong("radius");
            bVar.c = jSONObject.optString("status");
            bVar.d = jSONObject.optBoolean("repeat");
            bVar.l = jSONObject.optInt("repeat_week_num");
            bVar.m = jSONObject.optInt("repeat_day_num");
            bVar.n = jSONObject.optInt("repeat_time");
            bVar.e = jSONObject.optLong("expiration");
            bVar.i = jSONObject.optInt("type", 1);
            JSONObject optJSONObject = jSONObject.optJSONObject("center");
            if (optJSONObject != null) {
                bVar.f = optJSONObject.optDouble("lon", 200.0d);
                bVar.g = optJSONObject.optDouble("lat", 200.0d);
            }
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("op", this.k);
            jSONObject.put("geofenceid", this.a);
            jSONObject.put("name", this.j);
            jSONObject.put("radius", this.b);
            jSONObject.put("status", this.c);
            jSONObject.put("repeat", this.d);
            jSONObject.put("repeat_week_num", this.l);
            jSONObject.put("repeat_day_num", this.m);
            jSONObject.put("repeat_time", this.n);
            jSONObject.put("expiration", this.e);
            jSONObject.put("type", this.i);
            jSONObject.put("lon", this.f);
            jSONObject.put("lat", this.g);
            jSONObject.put("lastTime", this.o);
            jSONObject.put("lastTimeWeek", this.p);
            jSONObject.put("weekNum", this.q);
            jSONObject.put("lastTimeDay", this.r);
            jSONObject.put("dayNum", this.s);
            jSONObject.put("lastGeoStatus", this.h);
            cn.jpush.android.d.d dVar = this.t;
            if (dVar != null) {
                jSONObject.put("entity", dVar.h);
            }
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void a(b bVar) {
        this.h = bVar.h;
        this.o = bVar.o;
        this.p = bVar.p;
        this.r = bVar.r;
        this.q = bVar.q;
        this.s = bVar.s;
    }

    public void b(JSONObject jSONObject) {
        try {
            if (jSONObject.has("name")) {
                this.j = jSONObject.optString("name");
            }
            long optLong = jSONObject.optLong("radius", -1L);
            if (optLong > 0) {
                this.b = optLong;
            }
            if (jSONObject.has("status")) {
                this.c = jSONObject.optString("status");
            }
            if (jSONObject.has("repeat")) {
                boolean optBoolean = jSONObject.optBoolean("repeat");
                this.d = optBoolean;
                if (optBoolean) {
                    if (jSONObject.has("repeat_week_num")) {
                        this.l = jSONObject.optInt("repeat_week_num");
                    }
                    if (jSONObject.has("repeat_day_num")) {
                        this.m = jSONObject.optInt("repeat_day_num");
                    }
                    if (jSONObject.has("repeat_time")) {
                        this.n = jSONObject.optInt("repeat_time");
                    }
                }
            }
            if (jSONObject.has("expiration")) {
                this.e = jSONObject.optLong("expiration");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("center");
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("lon", 200.0d);
                double optDouble2 = optJSONObject.optDouble("lat", 200.0d);
                if (optDouble >= -180.0d && optDouble <= 180.0d && optDouble2 >= -90.0d && optDouble2 <= 90.0d) {
                    this.f = optDouble;
                    this.g = optDouble2;
                    return;
                }
                Logger.w("Geofence", "update center failed because value invalid, [" + optDouble2 + "," + optDouble + "]");
            }
        } catch (Throwable unused) {
        }
    }
}
