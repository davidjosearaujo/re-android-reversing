package cn.jiguang.ad;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    private String a = "";
    private Context b;

    public c(Context context) {
        this.b = context;
    }

    public String a() {
        String b = b.a(this.b).b(this.a);
        return TextUtils.isEmpty(b) ? "" : b;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        String c = b.a(this.b).c();
        return c == null ? "" : c;
    }

    public String c() {
        String a = b.a(this.b).a(this.a);
        return a == null ? "" : a;
    }
}
