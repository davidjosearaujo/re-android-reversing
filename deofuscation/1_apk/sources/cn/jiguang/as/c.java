package cn.jiguang.as;

import android.text.TextUtils;
import java.io.File;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    public long a;
    public JSONObject b;
    private File c;
    private JSONObject d;
    private boolean e;
    private boolean f;

    private c(File file, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        this.c = file;
        this.d = jSONObject;
        this.b = jSONObject2;
        this.a = file.length();
        this.f = z;
        this.e = z;
    }

    public static c a(File file, Set<String> set) {
        JSONObject a = a(file);
        if (a != null) {
            return new c(file, a, cn.jiguang.f.d.a(a, set), false);
        }
        cn.jiguang.f.c.a(file);
        return null;
    }

    public static c a(File file, JSONObject jSONObject) {
        JSONObject a = a(file);
        if (a != null) {
            return new c(file, a, jSONObject, true);
        }
        cn.jiguang.f.c.a(file);
        return null;
    }

    public static JSONObject a(File file) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        try {
            String d = cn.jiguang.f.c.d(file);
            if (TextUtils.isEmpty(d) || (optJSONArray = (jSONObject = new JSONObject(d)).optJSONArray("content")) == null) {
                return null;
            }
            if (optJSONArray.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean a(c cVar, File file) {
        boolean z = true;
        if (cVar != null) {
            try {
                if (this.a + cVar.a <= 40960) {
                    JSONArray jSONArray = this.d.getJSONArray("content");
                    JSONArray jSONArray2 = cVar.d.getJSONArray("content");
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        jSONArray.put(jSONArray2.getJSONObject(i));
                    }
                    this.a += cVar.a;
                    this.e = true;
                    cn.jiguang.f.c.a(cVar.c);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, this.c.getName());
        if (this.f) {
            cn.jiguang.f.d.a(this.d, this.b);
        }
        if (this.c.equals(file2)) {
            z = false;
        }
        if (this.e || z) {
            cn.jiguang.f.c.b(file2, this.d.toString());
        }
        if (z) {
            cn.jiguang.f.c.a(this.c);
        }
        return false;
    }
}
