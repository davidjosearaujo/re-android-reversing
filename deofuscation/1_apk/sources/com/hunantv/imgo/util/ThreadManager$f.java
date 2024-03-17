package com.hunantv.imgo.util;

import android.widget.Toast;
import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ThreadManager$f {
    private static ThreadManager$f b = new ThreadManager$f();
    private ExecutorService a;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable, "mgtv_statis #" + this.a.getAndIncrement());
            thread.setPriority(1);
            return thread;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b implements RejectedExecutionHandler {
        public b() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (ThreadManager.sThreadDebugMode) {
                Toast.makeText(j.l.a.a.a(), "statis threadpool full!!!", 0).show();
            }
        }
    }

    public /* synthetic */ ThreadManager$f(ThreadManager$a threadManager$a) {
        this();
    }

    private ThreadManager$f() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 7, ThreadManager.access$1400(), TimeUnit.SECONDS, new LinkedBlockingQueue(ThreadManager.sThreadDebugMode ? 32 : 128), new a());
        threadPoolExecutor.setRejectedExecutionHandler(new b());
        this.a = threadPoolExecutor;
    }
}
