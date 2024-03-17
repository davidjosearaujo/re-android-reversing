package cn.jiguang.be;

import java.lang.Thread;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class b implements Runnable {
    private Thread.UncaughtExceptionHandler a;
    public String h;

    public b() {
        this.a = new Thread.UncaughtExceptionHandler() { // from class: cn.jiguang.be.b.1
            {
                b.this = this;
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(b.this.h);
                sb.append(", thread id:");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                cn.jiguang.ar.c.i("JCoreRunnable", sb.toString());
            }
        };
    }

    public b(String str) {
        this.h = str;
        this.a = new Thread.UncaughtExceptionHandler() { // from class: cn.jiguang.be.b.2
            {
                b.this = this;
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(b.this.h);
                sb.append(", thread id: ");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                cn.jiguang.ar.c.i("JCoreRunnable", sb.toString());
            }
        };
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.a);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }
}
