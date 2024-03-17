package cn.jiguang.k;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.ReportCallBack;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a implements ReportCallBack {
    private String a;
    private final Context b;
    private final String c;
    private final String d;

    public a(String str, Context context, String str2, String str3) {
        this.a = str;
        this.b = context;
        this.c = str2;
        this.d = str3;
    }

    @Override // cn.jiguang.api.ReportCallBack
    public void onFinish(int i) {
        if (TextUtils.isEmpty(this.a)) {
            this.a = "";
        }
        Context context = this.b;
        cn.jiguang.n.b.h(context, this.c + this.a);
        if (cn.jiguang.n.b.j(this.b, this.c) == 0) {
            cn.jiguang.n.b.r(this.b, this.a);
        }
        cn.jiguang.n.b.h(this.b, this.d);
    }
}
