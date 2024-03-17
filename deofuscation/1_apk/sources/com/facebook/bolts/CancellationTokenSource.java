package com.facebook.bolts;

import cn.jpush.android.api.JThirdPlatFormInterface;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import n.b0;
import n.l2.v.f0;
import n.l2.v.s0;
import n.u1;
import r.e.a.d;
import r.e.a.e;

/* compiled from: CancellationTokenSource.kt */
@b0(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\u0016\u0010\u001e\u001a\u00020\u00162\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001fH\u0002J\u0017\u0010 \u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0000¢\u0006\u0002\b#J\r\u0010$\u001a\u00020\u0016H\u0000¢\u0006\u0002\b%J\b\u0010&\u001a\u00020\u0016H\u0002J\b\u0010'\u001a\u00020(H\u0016J\u0015\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u000eH\u0000¢\u0006\u0002\b+R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006,"}, d2 = {"Lcom/facebook/bolts/CancellationTokenSource;", "Ljava/io/Closeable;", "()V", "cancellationRequested", "", "closed", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "isCancellationRequested", "()Z", "lock", "", "registrations", "", "Lcom/facebook/bolts/CancellationTokenRegistration;", "scheduledCancellation", "Ljava/util/concurrent/ScheduledFuture;", JThirdPlatFormInterface.KEY_TOKEN, "Lcom/facebook/bolts/CancellationToken;", "getToken", "()Lcom/facebook/bolts/CancellationToken;", "cancel", "", "cancelAfter", "delay", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "cancelScheduledCancellation", "close", "notifyListeners", "", "register", "action", "Ljava/lang/Runnable;", "register$facebook_core_release", "throwIfCancellationRequested", "throwIfCancellationRequested$facebook_core_release", "throwIfClosed", "toString", "", "unregister", "registration", "unregister$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class CancellationTokenSource implements Closeable {
    private boolean cancellationRequested;
    private boolean closed;
    private ScheduledFuture<?> scheduledCancellation;
    private final Object lock = new Object();
    private final List<CancellationTokenRegistration> registrations = new ArrayList();
    private final ScheduledExecutorService executor = BoltsExecutors.Companion.scheduled$facebook_core_release();

    private final void cancelScheduledCancellation() {
        ScheduledFuture<?> scheduledFuture = this.scheduledCancellation;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.scheduledCancellation = null;
        }
    }

    private final void notifyListeners(List<CancellationTokenRegistration> list) {
        for (CancellationTokenRegistration cancellationTokenRegistration : list) {
            cancellationTokenRegistration.runAction$facebook_core_release();
        }
    }

    private final void throwIfClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("Object already closed".toString());
        }
    }

    public final void cancel() {
        synchronized (this.lock) {
            throwIfClosed();
            if (this.cancellationRequested) {
                return;
            }
            cancelScheduledCancellation();
            this.cancellationRequested = true;
            ArrayList arrayList = new ArrayList(this.registrations);
            u1 u1Var = u1.a;
            notifyListeners(arrayList);
        }
    }

    public final void cancelAfter(long j) {
        cancelAfter(j, TimeUnit.MILLISECONDS);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            cancelScheduledCancellation();
            for (CancellationTokenRegistration cancellationTokenRegistration : this.registrations) {
                cancellationTokenRegistration.close();
            }
            this.registrations.clear();
            this.closed = true;
            u1 u1Var = u1.a;
        }
    }

    @d
    public final CancellationToken getToken() {
        CancellationToken cancellationToken;
        synchronized (this.lock) {
            throwIfClosed();
            cancellationToken = new CancellationToken(this);
        }
        return cancellationToken;
    }

    public final boolean isCancellationRequested() {
        boolean z;
        synchronized (this.lock) {
            throwIfClosed();
            z = this.cancellationRequested;
        }
        return z;
    }

    @d
    public final CancellationTokenRegistration register$facebook_core_release(@e Runnable runnable) {
        CancellationTokenRegistration cancellationTokenRegistration;
        synchronized (this.lock) {
            throwIfClosed();
            cancellationTokenRegistration = new CancellationTokenRegistration(this, runnable);
            if (this.cancellationRequested) {
                cancellationTokenRegistration.runAction$facebook_core_release();
                u1 u1Var = u1.a;
            } else {
                this.registrations.add(cancellationTokenRegistration);
            }
        }
        return cancellationTokenRegistration;
    }

    public final void throwIfCancellationRequested$facebook_core_release() throws CancellationException {
        synchronized (this.lock) {
            throwIfClosed();
            if (!this.cancellationRequested) {
                u1 u1Var = u1.a;
            } else {
                throw new CancellationException();
            }
        }
    }

    @d
    public String toString() {
        s0 s0Var = s0.a;
        String format = String.format(Locale.US, "%s@%s[cancellationRequested=%s]", Arrays.copyOf(new Object[]{CancellationTokenSource.class.getName(), Integer.toHexString(hashCode()), Boolean.toString(isCancellationRequested())}, 3));
        f0.o(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public final void unregister$facebook_core_release(@d CancellationTokenRegistration cancellationTokenRegistration) {
        f0.p(cancellationTokenRegistration, "registration");
        synchronized (this.lock) {
            throwIfClosed();
            this.registrations.remove(cancellationTokenRegistration);
        }
    }

    private final void cancelAfter(final long j, final TimeUnit timeUnit) {
        if (!(j >= ((long) (-1)))) {
            throw new IllegalArgumentException("Delay must be >= -1".toString());
        }
        if (j == 0) {
            cancel();
            return;
        }
        synchronized (this.lock) {
            if (this.cancellationRequested) {
                return;
            }
            cancelScheduledCancellation();
            if (j != -1) {
                this.scheduledCancellation = this.executor.schedule(new Runnable() { // from class: com.facebook.bolts.CancellationTokenSource$cancelAfter$$inlined$synchronized$lambda$1
                    {
                        CancellationTokenSource.this = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Object obj;
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            obj = CancellationTokenSource.this.lock;
                            synchronized (obj) {
                                CancellationTokenSource.this.scheduledCancellation = null;
                                u1 u1Var = u1.a;
                            }
                            CancellationTokenSource.this.cancel();
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    }
                }, j, timeUnit);
            }
            u1 u1Var = u1.a;
        }
    }
}
