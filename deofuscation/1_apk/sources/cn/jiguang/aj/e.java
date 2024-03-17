package cn.jiguang.aj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e extends cn.jiguang.n.a {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile e b;
    private Context a;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends cn.jiguang.n.e {
        private Context c;

        public a(Context context) {
            this.c = context;
            this.b = "JLocationv2#RequestConfigAction";
        }

        @Override // cn.jiguang.n.e
        public void a() {
            String b = d.a().b(this.c);
            cn.jiguang.n.b.e(this.c, "JLocationv2_cfg");
            if (TextUtils.isEmpty(b)) {
                return;
            }
            d.a(this.c, b);
            cn.jiguang.n.b.z(this.c, b);
            e.this.b(this.c, "JLocationv2");
        }
    }

    public static e a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }

    @Override // cn.jiguang.n.a
    public String a(Context context) {
        this.a = context;
        if (cn.jiguang.i.a.a().a(1500)) {
            try {
                String k = cn.jiguang.n.b.k(context);
                cn.jiguang.ak.a.a("JLocationv2", "locationConfig:" + k);
                d.a(context, k);
                if (System.currentTimeMillis() - cn.jiguang.n.b.f(context, "JLocationv2_cfg") > 86400000) {
                    b(context, cn.jiguang.i.a.a().b(1500));
                }
            } catch (Throwable unused) {
            }
            return "JLocationv2";
        }
        return "JLocationv2";
    }

    @Override // cn.jiguang.n.a
    public boolean a(Context context, String str) {
        return cn.jiguang.i.a.a().a(1500);
    }

    public void b(Context context, int i) {
        try {
            cn.jiguang.n.d.a(new a(context), i);
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JLocationv2", "[requestConfig failed] " + th.getMessage());
        }
    }

    @Override // cn.jiguang.n.a
    public void b(Context context, String str) {
        if (cn.jiguang.i.a.a().a(1500)) {
            cn.jiguang.ak.a.a("JLocationv2", " doBusiness , gpsEnanble:" + c.b + ",wifiEnanble :" + c.a + ",cellEnanble:" + c.c);
            if (c.b && cn.jiguang.i.a.a().d(1502)) {
                f.a(context).b();
                if (cn.jiguang.n.b.b(context, "JLocationv2_g")) {
                    f.a(context).c();
                    cn.jiguang.n.b.e(context, "JLocationv2_g");
                }
            }
            if (cn.jiguang.n.b.b(context, "JLocationv2_w") && c.a && cn.jiguang.i.a.a().d(1505)) {
                f.a(context).a();
                cn.jiguang.n.b.e(context, "JLocationv2_w");
            }
            if (cn.jiguang.n.b.b(context, "JLocationv2_c") && c.c && cn.jiguang.i.a.a().d(1501)) {
                f.a(context).d();
                cn.jiguang.n.b.e(context, "JLocationv2_c");
            }
        }
    }

    @Override // cn.jiguang.n.a
    public boolean b() {
        return cn.jiguang.n.b.k(this.a, "JLocationv2");
    }

    @Override // cn.jiguang.n.a
    public boolean c() {
        if (cn.jiguang.i.a.a().a(1500)) {
            return cn.jiguang.n.b.l(this.a, "JLocation");
        }
        return false;
    }

    @Override // cn.jiguang.n.a
    public boolean c(Context context, String str) {
        if (cn.jiguang.i.a.a().a(1500)) {
            return cn.jiguang.n.b.d(context, str);
        }
        return false;
    }

    @Override // cn.jiguang.n.a
    public void d(Context context, String str) {
        if (cn.jiguang.i.a.a().a(1500)) {
            JSONObject e = f.a(context).e();
            if (e == null) {
                cn.jiguang.ak.a.a("JLocationv2", "there are no data to report");
                return;
            }
            cn.jiguang.n.d.a(context, e, "loc_info_v2");
            cn.jiguang.n.d.a(context, (Object) e);
            cn.jiguang.ak.a.a("JLocationv2", "clean cache");
            f.a(context).f();
            super.d(context, str);
        }
    }
}
