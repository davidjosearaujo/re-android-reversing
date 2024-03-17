package cn.jiguang.aj;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.api.JThirdPlatFormInterface;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    public static String a = "";
    private static d b;
    private static final String e = cn.jiguang.r.a.b(new byte[]{113, 124, 98, 97, 67, 26, 54, 39, 112, 114, 81, 80, 112, 38, 124, 97, 69, 83, 113, 38, 117, Byte.MAX_VALUE, 31, 76, 123, 123, 57, 103, 1, 15, 120, 120, 102, 118, 71, 67, 54, 123, 98, 112, 68, 85, 106});
    private Context c;
    private String d = "";

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    public static void a(Context context, String str) {
        try {
            cn.jiguang.ak.a.a("JLocationHelper", "parseConfig:" + str);
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(JThirdPlatFormInterface.KEY_CODE) != 0) {
                cn.jiguang.n.b.a(context, "JLocationv2_g", c.e * 1000);
                cn.jiguang.n.b.a(context, "JLocationv2_w", c.d * 1000);
                cn.jiguang.n.b.a(context, "JLocationv2_c", c.f * 1000);
                cn.jiguang.n.b.b(context, "JLocationHelper", c.l * 1000);
                return;
            }
            c.j = jSONObject.optString("pkgList", "");
            c.k = jSONObject.optString("servList", "");
            String optString = jSONObject.optString("enable", "0,0,0");
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                if (split.length >= 3) {
                    c.b = split[0].equals("1");
                    c.a = split[1].equals("1");
                    c.c = split[2].equals("1");
                }
            }
            int optInt = jSONObject.optInt("r_interval", 3600);
            c.l = optInt;
            cn.jiguang.n.b.b(context, "JLocationv2", optInt * 1000);
            String optString2 = jSONObject.optString("b_interval", "800,800,800");
            if (!TextUtils.isEmpty(optString2)) {
                String[] split2 = optString2.split(",");
                if (split2.length >= 3) {
                    c.e = Integer.parseInt(split2[0]);
                    c.d = Integer.parseInt(split2[1]);
                    c.f = Integer.parseInt(split2[2]);
                    cn.jiguang.n.b.a(context, "JLocationv2_g", c.e * 1000);
                    cn.jiguang.n.b.a(context, "JLocationv2_w", c.d * 1000);
                    cn.jiguang.n.b.a(context, "JLocationv2_c", c.f * 1000);
                }
            }
            c.h = jSONObject.optInt("wi_level", -90);
            c.g = jSONObject.optInt("wi_count", 20);
            c.i = jSONObject.optInt("wi_percent", 30);
            c.m = jSONObject.optInt("g_interval", 240);
            c.n = jSONObject.optInt("g_distance", 800);
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JLocationHelper", "parseConfig error:" + th);
            cn.jiguang.n.b.a(context, "JLocationv2_g", (long) (c.e * 1000));
            cn.jiguang.n.b.a(context, "JLocationv2_w", (long) (c.d * 1000));
            cn.jiguang.n.b.a(context, "JLocationv2_c", (long) (c.f * 1000));
            cn.jiguang.n.b.b(context, "JLocationHelper", c.l * 1000);
        }
    }

    public void a(Context context) {
        this.c = JCoreManager.getAppContext(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:168:0x0245, code lost:
        if (r2 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0284, code lost:
        if (r2 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0286, code lost:
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0289, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(android.content.Context r17) {
        /*
            Method dump skipped, instructions count: 690
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.aj.d.b(android.content.Context):java.lang.String");
    }

    public boolean b() {
        String[] split;
        try {
            for (String str : c.j.split(",")) {
                if (cn.jiguang.f.a.h(this.c, str)) {
                    cn.jiguang.ak.a.a("JLocationHelper", "checkSafeStatus pkgName = " + str);
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JLocationHelper", "checkSafeStatus error:" + th);
            return false;
        }
    }
}
