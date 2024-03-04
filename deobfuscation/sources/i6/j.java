package i6;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class j extends w {
    public w e;

    public j(w wVar) {
        if (wVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.e = wVar;
    }

    @Override // i6.w
    public final w a() {
        return this.e.a();
    }

    @Override // i6.w
    public final w b() {
        return this.e.b();
    }

    @Override // i6.w
    public final long c() {
        return this.e.c();
    }

    @Override // i6.w
    public final w d(long j5) {
        return this.e.d(j5);
    }

    @Override // i6.w
    public final boolean e() {
        return this.e.e();
    }

    @Override // i6.w
    public final void f() {
        this.e.f();
    }

    @Override // i6.w
    public final w g(long j5, TimeUnit timeUnit) {
        return this.e.g(j5, timeUnit);
    }
}
