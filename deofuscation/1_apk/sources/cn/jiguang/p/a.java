package cn.jiguang.p;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.ReportCallBack;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a implements ReportCallBack {
    private Context a;
    private String b;
    private String c;

    public a(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    @Override // cn.jiguang.api.ReportCallBack
    public void onFinish(int i) {
        cn.jiguang.ak.a.a("DeviceReport", "report finish code:" + i);
        if (i != 0) {
            return;
        }
        cn.jiguang.n.b.h(this.a, this.c);
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        cn.jiguang.n.b.v(this.a, this.b);
    }
}
