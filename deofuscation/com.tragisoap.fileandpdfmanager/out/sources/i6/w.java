package i6;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class w {

    /* renamed from: d  reason: collision with root package name */
    public static final a f4537d = new a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f4538a;

    /* renamed from: b  reason: collision with root package name */
    public long f4539b;

    /* renamed from: c  reason: collision with root package name */
    public long f4540c;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends w {
        @Override // i6.w
        public final w d(long j7) {
            return this;
        }

        @Override // i6.w
        public final void f() {
        }

        @Override // i6.w
        public final w g(long j7, TimeUnit timeUnit) {
            return this;
        }
    }

    public w a() {
        this.f4538a = false;
        return this;
    }

    public w b() {
        this.f4540c = 0;
        return this;
    }

    public long c() {
        if (this.f4538a) {
            return this.f4539b;
        }
        throw new IllegalStateException("No deadline");
    }

    public w d(long j7) {
        this.f4538a = true;
        this.f4539b = j7;
        return this;
    }

    public boolean e() {
        return this.f4538a;
    }

    public void f() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f4538a && this.f4539b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public w g(long j7, TimeUnit timeUnit) {
        if (j7 < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j7);
        } else if (timeUnit != null) {
            this.f4540c = timeUnit.toNanos(j7);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }
}
