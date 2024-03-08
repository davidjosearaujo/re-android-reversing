package i6;

import java.util.concurrent.TimeUnit;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j extends w {
    public w e;

    public j(w wVar) {
        if (wVar != null) {
            this.e = wVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
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
    public final w d(long j7) {
        return this.e.d(j7);
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
    public final w g(long j7, TimeUnit timeUnit) {
        return this.e.g(j7, timeUnit);
    }
}
