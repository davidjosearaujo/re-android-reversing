package cn.jiguang.ax;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class g {
    private static volatile g a;
    private static final Object b = new Object();
    private Context c;
    private cn.jiguang.bb.a d = new cn.jiguang.bb.a() { // from class: cn.jiguang.ax.g.1
        {
            g.this = this;
        }

        @Override // cn.jiguang.bb.a
        public void a(Message message) {
            cn.jiguang.ar.c.c("PeriodWorker", "time is up, next period=" + (h.a().g() * 1000));
            g gVar = g.this;
            gVar.c(gVar.c);
        }
    };
    private long e;

    private g() {
    }

    public static g a() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new g();
                }
            }
        }
        return a;
    }

    private void b(Context context) {
        this.e = SystemClock.elapsedRealtime();
        if (((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.A())).booleanValue()) {
            a.a(context);
        } else {
            a.b(context);
        }
    }

    public void c(Context context) {
        cn.jiguang.ar.c.c("PeriodWorker", "periodTask...");
        b(context);
        cn.jiguang.a.a.a(context, false, 0L);
        b.a().a(context, 19, 0, "periodTask");
        e.a(context, "periodtask", null);
        cn.jiguang.b.a.a(context);
        cn.jiguang.aq.b.a(context);
    }

    public void a(Context context) {
        this.c = context;
        cn.jiguang.bb.b.a().a(JosStatusCodes.RTN_CODE_COMMON_ERROR, h.a().f() * 1000, this.d);
    }

    public void a(Context context, boolean z) {
        cn.jiguang.ar.c.e("PeriodWorker", "PeriodWorker resume");
        if (this.e > 0 && SystemClock.elapsedRealtime() > this.e + ((h.a().f() + 5) * 1000)) {
            cn.jiguang.ar.c.e("PeriodWorker", "schedule time is expired, execute now");
            a(context);
            c(context);
        } else if (!z) {
            cn.jiguang.ar.c.c("PeriodWorker", "need not change period task");
        } else {
            a(context);
            b(context);
        }
    }

    public void b() {
        this.e = SystemClock.elapsedRealtime();
        a.a(this.c);
        cn.jiguang.bb.b.a().a(JosStatusCodes.RTN_CODE_COMMON_ERROR, h.a().f() * 1000, this.d);
    }
}
