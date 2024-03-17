package cn.jiguang.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.n.d;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b extends cn.jiguang.n.a {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile b c;
    private Context a;
    private JSONObject b;
    private String d;
    private boolean e;

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    private void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<cn.jiguang.l.a> list) {
        try {
            if (this.b == null) {
                this.b = new JSONObject();
            }
            if (cn.jiguang.i.a.a().d(1608)) {
                this.b.put("ssid", str);
            }
            if (cn.jiguang.i.a.a().d(1601)) {
                this.b.put("bssid", str2);
            }
            if (cn.jiguang.i.a.a().d(1605)) {
                this.b.put("local_ip", str3);
            }
            if (cn.jiguang.i.a.a().d(1606)) {
                this.b.put("local_mac", str4);
            }
            if (cn.jiguang.i.a.a().d(1607)) {
                this.b.put("netmask", str5);
            }
            if (cn.jiguang.i.a.a().d(1604)) {
                this.b.put("gateway", str8);
            }
            if (cn.jiguang.i.a.a().d(1602)) {
                this.b.put("dhcp", str9);
            }
            if (cn.jiguang.i.a.a().d(1603)) {
                JSONArray jSONArray = new JSONArray();
                if (!TextUtils.isEmpty(str6)) {
                    jSONArray.put(str6);
                }
                if (!TextUtils.isEmpty(str7)) {
                    jSONArray.put(str7);
                }
                this.b.put("dns", jSONArray);
            }
            JSONArray jSONArray2 = new JSONArray();
            for (cn.jiguang.l.a aVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ip", aVar.a);
                jSONObject.put("mac", aVar.d);
                jSONArray2.put(jSONObject);
            }
            this.b.put("data", jSONArray2);
        } catch (JSONException e) {
            cn.jiguang.ak.a.d("JArp", "packageJson exception: " + e.getMessage());
        }
    }

    @Override // cn.jiguang.n.a
    public String a(Context context) {
        this.a = context;
        return "JArp";
    }

    @Override // cn.jiguang.n.a
    public void a(String str, JSONObject jSONObject) {
        if (cn.jiguang.i.a.a().a(1600)) {
            this.e = true;
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            boolean z = !optJSONObject.optBoolean("disable");
            cn.jiguang.n.b.a(this.a, "JArp", z);
            if (z) {
                long optLong = optJSONObject.optLong("frequency", 0L) * 1000;
                if (optLong == 0) {
                    cn.jiguang.n.b.b(this.a, true);
                    return;
                }
                cn.jiguang.n.b.b(this.a, false);
                cn.jiguang.n.b.b(this.a, "JArp", optLong);
            }
        }
    }

    @Override // cn.jiguang.n.a
    public boolean a(Context context, String str) {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0105, code lost:
        if (android.text.TextUtils.equals(r6, "0.0.0.0") != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0130, code lost:
        if (android.text.TextUtils.equals(r9, "0.0.0.0") != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0172, code lost:
        if (android.text.TextUtils.equals(r14, "0.0.0.0") != false) goto L85;
     */
    @Override // cn.jiguang.n.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.content.Context r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.k.b.b(android.content.Context, java.lang.String):void");
    }

    @Override // cn.jiguang.n.a
    public boolean b() {
        return cn.jiguang.n.b.k(this.a, "JArp");
    }

    @Override // cn.jiguang.n.a
    public boolean c(Context context, String str) {
        if (cn.jiguang.i.a.a().a(1600)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.d)) {
                this.d = "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("JArp");
            sb.append(this.d);
            return currentTimeMillis - cn.jiguang.n.b.i(context, sb.toString()) > cn.jiguang.n.b.j(context, "JArp");
        }
        return false;
    }

    @Override // cn.jiguang.n.a
    public void d(Context context, String str) {
        if (cn.jiguang.i.a.a().a(1600)) {
            JSONObject jSONObject = this.b;
            if (jSONObject == null) {
                cn.jiguang.ak.a.a("JArp", "there are no data to report");
                return;
            }
            d.a(context, jSONObject, "mac_list");
            d.a(context, this.b, new a(this.d, context, "JArp", str));
            this.b = null;
        }
    }
}
