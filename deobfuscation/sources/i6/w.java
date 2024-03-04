package i6;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class w {

    /* renamed from: d */
    public static final a f4537d = new a();

    /* renamed from: a */
    public boolean f4538a;

    /* renamed from: b */
    public long f4539b;

    /* renamed from: c */
    public long f4540c;

    /* loaded from: classes.dex */
    public static class a extends w {
        @Override // i6.w
        public final w d(long j5) {
            return this;
        }

        @Override // i6.w
        public final void f() {
        }

        @Override // i6.w
        public final w g(long j5, TimeUnit timeUnit) {
            return this;
        }
    }

    public w a() {
        this.f4538a = false;
        return this;
    }

    public w b() {
        this.f4540c = 0L;
        return this;
    }

    public long c() {
        if (this.f4538a) {
            return this.f4539b;
        }
        throw new IllegalStateException("No deadline");
    }

    public w d(long j5) {
        this.f4538a = true;
        this.f4539b = j5;
        return this;
    }

    public boolean e() {
        return this.f4538a;
    }

    public void f() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.f4538a && this.f4539b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public w g(long j5, TimeUnit timeUnit) {
        if (j5 >= 0) {
            if (timeUnit != null) {
                this.f4540c = timeUnit.toNanos(j5);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j5);
    }
}
