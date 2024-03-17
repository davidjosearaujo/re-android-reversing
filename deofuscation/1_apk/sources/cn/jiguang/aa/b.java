package cn.jiguang.aa;

import android.content.Context;
import android.net.Uri;
import cn.jiguang.n.d;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private Context a;
    private Uri b;

    public b(Context context) {
        this.a = context;
        String g = d.g("k97muQEI3n3mlJTZdD9q3lC6tvCVkeY7wPOrf0wd0l4zQtrGyn5uq0enBKOySISr");
        cn.jiguang.ak.a.a("NubiaOpenIDHelper", "url: " + g);
        this.b = Uri.parse(g);
    }

    public String a() {
        try {
            Context context = this.a;
            return a.a(context, context.getPackageName(), this.b);
        } catch (Exception e) {
            cn.jiguang.ak.a.d("NubiaOpenIDHelper", "get Ids-aa error: " + e.getMessage());
            return "";
        }
    }

    public String b() {
        try {
            return a.a(this.a, this.b);
        } catch (Exception e) {
            cn.jiguang.ak.a.d("NubiaOpenIDHelper", "get Ids-oa error: " + e.getMessage());
            return "";
        }
    }

    public String c() {
        try {
            Context context = this.a;
            return a.b(context, context.getPackageName(), this.b);
        } catch (Exception e) {
            cn.jiguang.ak.a.d("NubiaOpenIDHelper", "get Ids-va error: " + e.getMessage());
            return "";
        }
    }
}
