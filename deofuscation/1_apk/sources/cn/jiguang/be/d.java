package cn.jiguang.be;

import cn.jiguang.aq.f;
import com.hunantv.mpdt.data.EventClickData;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    private static final HashMap<String, ExecutorService> a = new HashMap<>();
    private static final HashMap<String, String> b;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        b = hashMap;
        hashMap.put("SDK_INIT", "ic");
        hashMap.put("SDK_SERVICE_INIT", "mn");
        hashMap.put("TCP_CONN_TASK", "tc");
        hashMap.put("UPLOAD_REPORT", "rp");
        hashMap.put("ONCE_TASK", EventClickData.a.Q);
        hashMap.put("SCHEDULE_TASK", "sc");
        hashMap.put("MAJOR_TASK", "mj");
        hashMap.put("NORMAL_TASK", "nr");
        hashMap.put("FUTURE_TASK", "fr");
        hashMap.put("DELAY_TASK", "dl");
    }

    public static void a(String str) {
        try {
            a(c(str));
        } catch (Throwable th) {
            cn.jiguang.ar.c.i("SDKWorker_XExecutor", "shutdown executor " + str + "error: " + th);
        }
    }

    public static void a(String str, Runnable runnable) {
        a(str, runnable, 0, true);
    }

    public static void a(String str, Runnable runnable, int i) {
        a(str, runnable, i, true);
    }

    public static void a(String str, Runnable runnable, int i, boolean z) {
        if (z) {
            try {
                if (f.a()) {
                    return;
                }
            } catch (Throwable th) {
                cn.jiguang.ar.c.i("SDKWorker_XExecutor", "execute failed, try again e:" + th);
                return;
            }
        }
        ExecutorService c = c(str);
        if (c != null) {
            if (i <= 0 || !(c instanceof ScheduledExecutorService)) {
                c.execute(runnable);
            } else {
                ((ScheduledExecutorService) c).schedule(runnable, i, TimeUnit.MILLISECONDS);
            }
        }
    }

    private static void a(ExecutorService executorService) {
        if (executorService == null) {
            return;
        }
        try {
            executorService.shutdown();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (executorService.awaitTermination(100L, timeUnit)) {
                return;
            }
            executorService.shutdownNow();
            if (executorService.awaitTermination(100L, timeUnit)) {
                return;
            }
            cn.jiguang.ar.c.a("SDKWorker_XExecutor", "executor did not terminate");
        } catch (InterruptedException unused) {
            executorService.shutdownNow();
            cn.jiguang.ar.c.a("SDKWorker_XExecutor", "current thread is interrupted by self");
            Thread.currentThread().interrupt();
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("SDKWorker_XExecutor", "shutDown e:" + th);
        }
    }

    public static boolean b(String str) {
        try {
            ExecutorService c = c(str);
            if (c == null || c.isShutdown()) {
                return false;
            }
            return !c.isTerminated();
        } catch (Throwable th) {
            cn.jiguang.ar.c.i("SDKWorker_XExecutor", "check executor " + str + " isAlive error: " + th);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0034, code lost:
        if (r5 != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.concurrent.ExecutorService c(java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.be.d.c(java.lang.String):java.util.concurrent.ExecutorService");
    }
}
