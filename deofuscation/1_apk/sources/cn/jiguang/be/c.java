package cn.jiguang.be;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c implements ThreadFactory {
    private final ThreadGroup a;
    private final AtomicInteger b = new AtomicInteger(1);
    private final String c;

    public c(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        String lowerCase = TextUtils.isEmpty(str) ? "default" : str.toLowerCase();
        this.c = "jg_" + lowerCase + "_pool_thread";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread;
        Throwable th;
        try {
            thread = new Thread(this.a, runnable, this.c + this.b.getAndIncrement(), 0L);
        } catch (Throwable th2) {
            thread = null;
            th = th2;
        }
        try {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
                return thread;
            }
            return thread;
        } catch (Throwable th3) {
            th = th3;
            cn.jiguang.ar.c.i("JThreadFactory", "JThreadFactory new Thread error, " + th.getMessage());
            try {
                Thread thread2 = new Thread(this.a, runnable, this.c + this.b.getAndIncrement(), 0L);
                try {
                    if (thread2.isDaemon()) {
                        thread2.setDaemon(false);
                    }
                    if (thread2.getPriority() != 5) {
                        thread2.setPriority(5);
                    }
                    return thread2;
                } catch (Throwable th4) {
                    th = th4;
                    thread = thread2;
                    cn.jiguang.ar.c.i("JThreadFactory", "JThreadFactory new Thread again error, " + th.getMessage());
                    return thread;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }
}
