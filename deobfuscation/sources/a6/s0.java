package a6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class s0 extends w0 {

    /* renamed from: k */
    public static final AtomicIntegerFieldUpdater f334k = AtomicIntegerFieldUpdater.newUpdater(s0.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: j */
    public final q5.l<Throwable, f5.g> f335j;

    /* JADX WARN: Multi-variable type inference failed */
    public s0(q5.l<? super Throwable, f5.g> lVar) {
        this.f335j = lVar;
    }

    @Override // q5.l
    public final /* bridge */ /* synthetic */ f5.g k(Throwable th) {
        q(th);
        return f5.g.f4141a;
    }

    @Override // a6.q
    public final void q(Throwable th) {
        if (f334k.compareAndSet(this, 0, 1)) {
            this.f335j.k(th);
        }
    }
}
