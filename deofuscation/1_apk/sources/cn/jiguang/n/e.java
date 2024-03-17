package cn.jiguang.n;

import java.lang.Thread;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class e implements Runnable {
    private Thread.UncaughtExceptionHandler a = new Thread.UncaughtExceptionHandler() { // from class: cn.jiguang.n.e.1
        {
            e.this = this;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("name: ");
            sb.append(e.this.b);
            sb.append("thread id: ");
            sb.append(thread != null ? thread.getName() : "");
            sb.append("-");
            sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
            sb.append("\n e:");
            sb.append(th);
            cn.jiguang.ak.a.f("JCommonRunnable", sb.toString());
        }
    };
    public String b;

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.a);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }
}
