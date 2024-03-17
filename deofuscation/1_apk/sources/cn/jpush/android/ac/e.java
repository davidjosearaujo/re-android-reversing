package cn.jpush.android.ac;

import cn.jpush.android.helper.Logger;
import java.lang.Thread;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class e implements Runnable {
    private Thread.UncaughtExceptionHandler a;
    public String f;

    public e() {
        this.a = new Thread.UncaughtExceptionHandler() { // from class: cn.jpush.android.ac.e.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(e.this.f);
                sb.append(", thread id:");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                Logger.e("JPushRunnable", sb.toString());
            }
        };
    }

    public e(String str) {
        this.f = str;
        this.a = new Thread.UncaughtExceptionHandler() { // from class: cn.jpush.android.ac.e.2
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(e.this.f);
                sb.append(", thread id: ");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                Logger.e("JPushRunnable", sb.toString());
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
