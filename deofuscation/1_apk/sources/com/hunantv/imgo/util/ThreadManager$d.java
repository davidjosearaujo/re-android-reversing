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
public class ThreadManager$d {
    private static ThreadManager$d b = new ThreadManager$d();
    private ExecutorService a;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable, "mgtv_network #" + this.a.getAndIncrement());
            thread.setPriority(8);
            return thread;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b implements RejectedExecutionHandler {
        public b() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Toast.makeText(j.l.a.a.a(), "network threadpool full!!!", 0).show();
        }
    }

    private ThreadManager$d() {
        int access$1300 = ThreadManager.access$1300() + 2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(access$1300, (access$1300 * 2) + 1, ThreadManager.access$1400(), TimeUnit.SECONDS, new LinkedBlockingQueue(ThreadManager.sThreadDebugMode ? access$1300 * 2 : 64), new a());
        if (ThreadManager.sThreadDebugMode) {
            threadPoolExecutor.setRejectedExecutionHandler(new b());
        } else {
            threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        }
        this.a = threadPoolExecutor;
    }
}
