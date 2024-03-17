package cn.jiguang.an;

import android.annotation.SuppressLint;
import android.content.Context;
import cn.jiguang.ap.e;
import org.json.JSONArray;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d extends cn.jiguang.n.a {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile d b;
    private Context a;
    private cn.jiguang.ao.a c;

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

    @Override // cn.jiguang.n.a
    public String a(Context context) {
        this.a = context;
        e.a = true;
        return "JWakeReport";
    }

    @Override // cn.jiguang.n.a
    public boolean a(Context context, String str) {
        return true;
    }

    @Override // cn.jiguang.n.a
    public void b(Context context, String str) {
        this.c = cn.jiguang.ap.b.b(context);
        super.b(context, str);
    }

    @Override // cn.jiguang.n.a
    public boolean c(Context context, String str) {
        return cn.jiguang.n.b.d(context, str);
    }

    @Override // cn.jiguang.n.a
    public void d(Context context, String str) {
        if (this.c.t) {
            JSONArray b2 = cn.jiguang.ap.c.b(context);
            if (b2 == null || b2.length() == 0) {
                cn.jiguang.ak.a.a("JWakeReport", "no report wakeData");
            } else {
                cn.jiguang.ak.a.a("JWakeReport", "report wakeData:" + b2);
                cn.jiguang.n.d.a(context, b2);
                cn.jiguang.ap.c.c(context);
            }
        } else {
            cn.jiguang.ak.a.d("JWakeReport", "server set do not report wake data.");
        }
        if (this.c.u) {
            JSONArray a = e.a(context);
            if (a == null || a.length() == 0) {
                cn.jiguang.ak.a.a("JWakeReport", "no report wakedData");
            } else {
                cn.jiguang.ak.a.a("JWakeReport", "report wakedData:" + a);
                cn.jiguang.n.d.a(context, a);
                e.d(context);
            }
        } else {
            cn.jiguang.ak.a.d("JWakeReport", "server set do not report waked data.");
        }
        super.d(context, str);
    }
}
