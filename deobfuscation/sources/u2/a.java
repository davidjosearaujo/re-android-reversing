package u2;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.activity.h;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class a implements ExecutorService {

    /* renamed from: g */
    public static final long f6092g = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: h */
    public static volatile int f6093h;

    /* renamed from: f */
    public final ExecutorService f6094f;

    /* renamed from: u2.a$a */
    /* loaded from: classes.dex */
    public static final class ThreadFactoryC0110a implements ThreadFactory {

        /* renamed from: u2.a$a$a */
        /* loaded from: classes.dex */
        public class C0111a extends Thread {
            public C0111a(Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                Process.setThreadPriority(9);
                super.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new C0111a(runnable);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements ThreadFactory {

        /* renamed from: a */
        public final ThreadFactory f6095a;

        /* renamed from: b */
        public final String f6096b;

        /* renamed from: c */
        public final c f6097c;

        /* renamed from: d */
        public final boolean f6098d;
        public final AtomicInteger e;

        /* renamed from: u2.a$b$a */
        /* loaded from: classes.dex */
        public class RunnableC0112a implements Runnable {

            /* renamed from: f */
            public final /* synthetic */ Runnable f6099f;

            public RunnableC0112a(Runnable runnable) {
                b.this = r1;
                this.f6099f = runnable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.f6098d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    this.f6099f.run();
                } catch (Throwable th) {
                    b.this.f6097c.a(th);
                }
            }
        }

        public b(ThreadFactoryC0110a threadFactoryC0110a, String str, boolean z6) {
            c.C0113a c0113a = c.f6101a;
            this.e = new AtomicInteger();
            this.f6095a = threadFactoryC0110a;
            this.f6096b = str;
            this.f6097c = c0113a;
            this.f6098d = z6;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread newThread = this.f6095a.newThread(new RunnableC0112a(runnable));
            StringBuilder d7 = h.d("glide-");
            d7.append(this.f6096b);
            d7.append("-thread-");
            d7.append(this.e.getAndIncrement());
            newThread.setName(d7.toString());
            return newThread;
        }
    }

    /* loaded from: classes.dex */
    public interface c {

        /* renamed from: a */
        public static final C0113a f6101a = new C0113a();

        /* renamed from: u2.a$c$a */
        /* loaded from: classes.dex */
        public class C0113a implements c {
            @Override // u2.a.c
            public final void a(Throwable th) {
                if (Log.isLoggable("GlideExecutor", 6)) {
                    Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                }
            }
        }

        void a(Throwable th);
    }

    public a(ThreadPoolExecutor threadPoolExecutor) {
        this.f6094f = threadPoolExecutor;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j5, TimeUnit timeUnit) {
        return this.f6094f.awaitTermination(j5, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f6094f.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.f6094f.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j5, TimeUnit timeUnit) {
        return this.f6094f.invokeAll(collection, j5, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.f6094f.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j5, TimeUnit timeUnit) {
        return (T) this.f6094f.invokeAny(collection, j5, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.f6094f.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.f6094f.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.f6094f.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.f6094f.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable runnable) {
        return this.f6094f.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable runnable, T t5) {
        return this.f6094f.submit(runnable, t5);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> callable) {
        return this.f6094f.submit(callable);
    }

    public final String toString() {
        return this.f6094f.toString();
    }
}
