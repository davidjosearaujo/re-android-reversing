package cn.jpush.android.u;

import cn.jpush.android.helper.Logger;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class f {
    public String a;
    public String b;
    public long c;

    public static f a(String str, String str2, long j) {
        f fVar = new f();
        fVar.a = str;
        fVar.b = str2;
        fVar.c = j;
        return fVar;
    }

    public static f a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                f fVar = new f();
                fVar.a = jSONObject.getString("tpl_id");
                fVar.b = jSONObject.getString("tpl_file_name");
                fVar.c = jSONObject.getLong("tpl_recent_use_time");
                return fVar;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tpl_id", this.a);
            jSONObject.put("tpl_file_name", this.b);
            jSONObject.put("tpl_recent_use_time", this.c);
            return jSONObject;
        } catch (Throwable th) {
            Logger.w("InAppTemplate", "in-app template to json failed. " + th.getMessage());
            return null;
        }
    }
}
