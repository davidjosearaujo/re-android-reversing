package cn.jiguang.be;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a implements RejectedExecutionHandler {
    private int a;
    private String b;
    private ThreadPoolExecutor c;
    private LinkedBlockingQueue<Runnable> d;

    public a(String str, int i) {
        this.b = str;
        if (i <= 0) {
            this.a = 3;
        }
        this.a = i;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        cn.jiguang.ar.c.c("JRejectedExecutionHandler", "poolName: " + this.b + ", Exceeded ThreadPoolExecutor pool size");
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.d = new LinkedBlockingQueue<>();
                    int i = this.a;
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    LinkedBlockingQueue<Runnable> linkedBlockingQueue = this.d;
                    ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(i, i, 3L, timeUnit, linkedBlockingQueue, new c(this.b + "_rjt"));
                    this.c = threadPoolExecutor2;
                    threadPoolExecutor2.allowCoreThreadTimeOut(true);
                }
            }
        }
        this.c.execute(runnable);
    }
}
