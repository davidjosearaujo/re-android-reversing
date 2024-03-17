package cn.jiguang.n;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class a {

    /* renamed from: cn.jiguang.n.a$a */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class C0011a extends e {
        private Context c;
        private String d;
        private Bundle e;

        public C0011a(Context context, String str, Bundle bundle) {
            a.this = r1;
            this.c = context;
            this.d = str;
            this.e = bundle;
            this.b = str + "#BundleAction";
        }

        @Override // cn.jiguang.n.e
        public void a() {
            try {
                a.this.a(this.c, this.d, this.e);
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JCommon", "BundleAction failed:" + th.getMessage());
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b extends e {
        private Context c;
        private String d;

        public b(Context context, String str) {
            a.this = r1;
            this.c = context;
            this.d = str;
            this.b = str + "#CommonAction";
        }

        @Override // cn.jiguang.n.e
        public void a() {
            try {
                cn.jiguang.i.a.a().a(this.d);
                a.this.e(this.c, this.d);
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JCommon", "dealAction failed:" + th.getMessage());
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class c extends e {
        private Context c;
        private String d;
        private JSONObject e;

        public c(Context context, String str, JSONObject jSONObject) {
            a.this = r1;
            this.c = context;
            this.d = str;
            this.e = jSONObject;
            this.b = str + "#JsonAction";
        }

        @Override // cn.jiguang.n.e
        public void a() {
            try {
                a.this.a(this.c, this.d, this.e);
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JCommon", "JsonAction-deal failed:" + th.getMessage());
            }
        }
    }

    public void a(Context context, String str, Bundle bundle) {
        a(str, bundle);
        boolean d = d();
        cn.jiguang.ak.a.a("JCommon", str + " isActionBundleEnable:" + d);
        if (d) {
            b(context, str);
            d(context, str);
        }
    }

    public void a(Context context, String str, JSONObject jSONObject) {
        a(str, jSONObject);
        if (jSONObject.optInt("cmd") != 45) {
            boolean b2 = b();
            cn.jiguang.ak.a.a("JCommon", str + " isActionCommandEnable:" + b2);
            if (b2) {
                b(context, str);
                d(context, str);
            }
        }
    }

    public void e(Context context, String str) {
        boolean a = a(context, str);
        cn.jiguang.ak.a.a("JCommon", str + " isBusinessEnable:" + a);
        if (a) {
            b(context, str);
        }
        boolean c2 = c(context, str);
        cn.jiguang.ak.a.a("JCommon", str + " isReportEnable:" + c2);
        if (c2) {
            d(context, str);
        }
    }

    private boolean f(Context context, String str) {
        boolean c2 = c();
        boolean b2 = b();
        boolean c3 = c(context);
        boolean z = c2 && b2 && c3;
        cn.jiguang.ak.a.a("JCommon", str + " isActionEnable:" + z + ",actionUserEnable:" + c2 + ",actionCommandEnable:" + b2 + ",actionUidEnable:" + c3);
        return z;
    }

    public abstract String a(Context context);

    public void a(Context context, int i) {
        String a = a(context);
        cn.jiguang.ak.a.a("JCommon", "executeActionSingle: [" + a + "] from heartBeat, will delay " + i + "ms execute");
        boolean f = f(context, a);
        boolean a2 = a(context, a);
        cn.jiguang.ak.a.a("JCommon", a + " isActionEnable:" + f + ", isBusinessEnable:" + a2);
        if (f && a2) {
            d.a(new b(context, a), i);
        }
    }

    public void a(Context context, Bundle bundle) {
        String a = a(context);
        cn.jiguang.ak.a.a("JCommon", "executeBundleAction: [" + a + "] from bundle");
        boolean c2 = c();
        cn.jiguang.ak.a.a("JCommon", a + " isActionUserEnable:" + c2);
        if (c2) {
            d.a(new C0011a(context, a, bundle));
        }
    }

    public void a(Context context, JSONObject jSONObject) {
        String a = a(context);
        cn.jiguang.ak.a.a("JCommon", "executeCommandActionSingle: [" + a + "] from cmd");
        boolean c2 = c();
        cn.jiguang.ak.a.a("JCommon", a + " isActionUserEnable:" + c2);
        if (c2) {
            d.a(new c(context, a, jSONObject));
        }
    }

    public void a(String str, Bundle bundle) {
        if (bundle != null) {
            cn.jiguang.ak.a.a("JCommon", str + " parseJson:" + bundle.toString());
        }
    }

    public void a(String str, JSONObject jSONObject) {
    }

    public boolean a(Context context, String str) {
        return cn.jiguang.n.b.a(context, str);
    }

    public void b(Context context) {
        try {
            String a = a(context);
            cn.jiguang.ak.a.a("JCommon", "executeAction: [" + a + "] from heartBeat");
            boolean f = f(context, a);
            boolean a2 = a(context, a);
            cn.jiguang.ak.a.a("JCommon", a + " - isActionEnable:" + f + ", isBusinessEnable:" + a2);
            if (f && a2) {
                d.a(new b(context, a));
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.a("JCommon", "executeAction failed, error:" + th);
        }
    }

    public void b(Context context, String str) {
        cn.jiguang.n.b.e(context, str);
    }

    public boolean b() {
        return true;
    }

    public boolean c() {
        return true;
    }

    public boolean c(Context context) {
        return d.c(context) > 0;
    }

    public boolean c(Context context, String str) {
        return cn.jiguang.n.b.c(context, str);
    }

    public Object d(Context context) {
        return null;
    }

    public void d(Context context, String str) {
        cn.jiguang.n.b.h(context, str);
    }

    public boolean d() {
        return true;
    }
}
