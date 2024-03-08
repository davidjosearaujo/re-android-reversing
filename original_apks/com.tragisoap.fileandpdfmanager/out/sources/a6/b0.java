package a6;

import a6.m0;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b0 extends m0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: o  reason: collision with root package name */
    public static final b0 f283o;

    /* renamed from: p  reason: collision with root package name */
    public static final long f284p;

    static {
        Long l6;
        b0 b0Var = new b0();
        f283o = b0Var;
        b0Var.Y(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l6 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l6 = 1000L;
        }
        f284p = timeUnit.toNanos(l6.longValue());
    }

    @Override // a6.n0
    public final Thread c0() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }

    @Override // a6.n0
    public final void d0(long j7, m0.b bVar) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // a6.m0
    public final void f0(Runnable runnable) {
        if (!(debugStatus == 4)) {
            super.f0(runnable);
            return;
        }
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final synchronized void j0() {
        int i7 = debugStatus;
        if (i7 == 2 || i7 == 3) {
            debugStatus = 3;
            m0.f310l.set(this, null);
            m0.m.set(this, null);
            notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z6;
        k1.f304a.set(this);
        try {
            synchronized (this) {
                int i7 = debugStatus;
                if (i7 == 2 || i7 == 3) {
                    z6 = false;
                } else {
                    debugStatus = 1;
                    notifyAll();
                    z6 = true;
                }
            }
            if (!z6) {
                _thread = null;
                j0();
                if (!h0()) {
                    c0();
                    return;
                }
                return;
            }
            long j7 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long a02 = a0();
                if (a02 == Long.MAX_VALUE) {
                    long nanoTime = System.nanoTime();
                    if (j7 == Long.MAX_VALUE) {
                        j7 = f284p + nanoTime;
                    }
                    long j8 = j7 - nanoTime;
                    if (j8 <= 0) {
                        _thread = null;
                        j0();
                        if (!h0()) {
                            c0();
                            return;
                        }
                        return;
                    } else if (a02 > j8) {
                        a02 = j8;
                    }
                } else {
                    j7 = Long.MAX_VALUE;
                }
                if (a02 > 0) {
                    int i8 = debugStatus;
                    if (i8 == 2 || i8 == 3) {
                        _thread = null;
                        j0();
                        if (!h0()) {
                            c0();
                            return;
                        }
                        return;
                    }
                    LockSupport.parkNanos(this, a02);
                }
            }
        } catch (Throwable th) {
            _thread = null;
            j0();
            if (!h0()) {
                c0();
            }
            throw th;
        }
    }

    @Override // a6.m0, a6.l0
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
