package cn.jpush.android.t;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    private static volatile d a;
    private static AtomicInteger b = new AtomicInteger(0);
    private long c = 0;
    private f d = new f() { // from class: cn.jpush.android.t.d.1
        @Override // cn.jpush.android.t.f
        public void a(Message message) {
            Logger.d("InAppPeriodWorker", "time is up, next period=" + c.a().e());
            d.this.d(JPushConstants.mApplicationContext);
        }
    };

    private d() {
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    private void b(Context context) {
        g.a().a(JosStatusCodes.RTN_CODE_COMMON_ERROR, c.a().d() * 1000, this.d);
    }

    private void c(Context context) {
        this.c = SystemClock.elapsedRealtime();
        if (cn.jpush.android.cache.a.d(context)) {
            return;
        }
        c.a().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        Logger.d("InAppPeriodWorker", "periodTask...");
        c(context);
        c.a().a(context, "tcp_rtc", false, 0L);
    }

    public void a(Context context) {
        if (g.a().a(JosStatusCodes.RTN_CODE_COMMON_ERROR)) {
            g.a().b(JosStatusCodes.RTN_CODE_COMMON_ERROR);
        }
    }

    public void a(Context context, boolean z) {
        Logger.i("InAppPeriodWorker", "PeriodWorker resume, reset: " + z);
        if (this.c > 0 && SystemClock.elapsedRealtime() > this.c + ((c.a().d() + 5) * 1000)) {
            Logger.i("InAppPeriodWorker", "schedule time is expired, execute now");
            b(context);
            d(context);
        } else if (!z) {
            Logger.d("InAppPeriodWorker", "need not change period task");
        } else {
            Logger.i("InAppPeriodWorker", "force reset init send task and update interval...");
            b(context);
            c(context);
        }
    }

    public void b() {
        this.c = SystemClock.elapsedRealtime();
        g.a().a(JosStatusCodes.RTN_CODE_COMMON_ERROR, c.a().d() * 1000, this.d);
    }
}
