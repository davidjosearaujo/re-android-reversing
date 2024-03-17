package cn.jiguang.av;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class p {
    private final int a;
    private final ThreadPoolExecutor b;
    private final Handler c;
    private final cn.jiguang.av.a<Object> e;
    private Object g;
    private final AtomicBoolean d = new AtomicBoolean(true);
    private volatile long f = 0;
    private CountDownLatch h = new CountDownLatch(1);

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends Handler {
        private final ExecutorService a;

        public a(ExecutorService executorService) {
            super(p.c());
            this.a = executorService;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (this.a.isShutdown()) {
                    cn.jiguang.ar.c.g("Step", "executor is shutdown");
                } else {
                    this.a.submit((Callable) message.obj);
                }
            } catch (Throwable th) {
                cn.jiguang.ar.c.i("Step", "handleMessage e:" + th);
            }
        }
    }

    public p(int i, int i2, cn.jiguang.av.a<Object> aVar, String str) {
        this.a = i2;
        this.e = aVar;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new cn.jiguang.be.c(str)) { // from class: cn.jiguang.av.p.1
            {
                p.this = this;
            }

            /* JADX WARN: Code restructure failed: missing block: B:31:0x001d, code lost:
                if (cn.jiguang.av.p.this.c.hasMessages(233) == false) goto L9;
             */
            /* JADX WARN: Removed duplicated region for block: B:42:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
            @Override // java.util.concurrent.ThreadPoolExecutor
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void afterExecute(java.lang.Runnable r2, java.lang.Throwable r3) {
                /*
                    r1 = this;
                    r2 = 1
                    int r3 = r1.getActiveCount()     // Catch: java.lang.Throwable -> L22
                    if (r3 > r2) goto L20
                    java.util.concurrent.BlockingQueue r3 = r1.getQueue()     // Catch: java.lang.Throwable -> L22
                    boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L22
                    if (r3 == 0) goto L20
                    cn.jiguang.av.p r3 = cn.jiguang.av.p.this     // Catch: java.lang.Throwable -> L22
                    android.os.Handler r3 = cn.jiguang.av.p.a(r3)     // Catch: java.lang.Throwable -> L22
                    r0 = 233(0xe9, float:3.27E-43)
                    boolean r3 = r3.hasMessages(r0)     // Catch: java.lang.Throwable -> L22
                    if (r3 != 0) goto L20
                    goto L22
                L20:
                    r3 = 0
                    goto L23
                L22:
                    r3 = 1
                L23:
                    if (r3 == 0) goto L37
                    cn.jiguang.av.p r3 = cn.jiguang.av.p.this     // Catch: java.lang.Throwable -> L37
                    java.util.concurrent.atomic.AtomicBoolean r3 = cn.jiguang.av.p.b(r3)     // Catch: java.lang.Throwable -> L37
                    r3.set(r2)     // Catch: java.lang.Throwable -> L37
                    cn.jiguang.av.p r2 = cn.jiguang.av.p.this     // Catch: java.lang.Throwable -> L37
                    java.util.concurrent.CountDownLatch r2 = cn.jiguang.av.p.c(r2)     // Catch: java.lang.Throwable -> L37
                    r2.countDown()     // Catch: java.lang.Throwable -> L37
                L37:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.av.p.AnonymousClass1.afterExecute(java.lang.Runnable, java.lang.Throwable):void");
            }
        };
        this.b = threadPoolExecutor;
        this.c = new a(threadPoolExecutor);
    }

    private synchronized long b(long j) {
        long j2 = this.f + j;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (j2 < uptimeMillis) {
            this.f = uptimeMillis;
            return -1L;
        }
        this.f = j2;
        return j2;
    }

    public static /* synthetic */ Looper c() {
        return d();
    }

    private static Looper d() {
        HandlerThread handlerThread = new HandlerThread("jg_step_thread") { // from class: cn.jiguang.av.p.2
            @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                }
            }
        };
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        return looper == null ? Looper.getMainLooper() : looper;
    }

    public synchronized Object a(long j) {
        if (a()) {
            return this.g;
        } else if (this.d.get()) {
            return null;
        } else {
            try {
                if (j != -1) {
                    this.h.await(j, TimeUnit.MILLISECONDS);
                } else {
                    this.h.await();
                }
            } catch (InterruptedException unused) {
            }
            if (this.h.getCount() == 0) {
                this.h = new CountDownLatch(1);
            }
            return this.g;
        }
    }

    public void a(Object obj) {
        if (a() || obj == null) {
            return;
        }
        this.g = obj;
        this.h.countDown();
        cn.jiguang.av.a<Object> aVar = this.e;
        if (aVar != null) {
            aVar.a(obj);
        }
        a(true);
        cn.jiguang.ar.c.c("Step", "done!");
    }

    public void a(Callable<?> callable) {
        try {
            long b = b(this.a);
            if (b < 0) {
                this.b.submit(callable);
            } else {
                Message obtain = Message.obtain();
                obtain.what = 233;
                obtain.obj = callable;
                this.c.sendMessageAtTime(obtain, b);
            }
            this.d.set(false);
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z) {
        this.c.removeMessages(233);
        if (!this.b.isShutdown()) {
            if (z) {
                this.b.shutdownNow();
            } else {
                this.b.shutdown();
            }
        }
        try {
            this.c.getLooper().quit();
        } catch (Throwable unused) {
        }
        cn.jiguang.ar.c.c("Step", "StepParallelScheduler stop !");
    }

    public boolean a() {
        return this.g != null;
    }

    public void b() {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.b;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.getQueue().clear();
                this.c.removeMessages(233);
            }
        } catch (Throwable th) {
            Log.w("Step", "clean executor e:" + th);
        }
    }
}
