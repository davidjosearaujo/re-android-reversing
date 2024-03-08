package a6;

import f5.g;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import q5.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class s0 extends w0 {

    /* renamed from: k  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f334k = AtomicIntegerFieldUpdater.newUpdater(s0.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: j  reason: collision with root package name */
    public final l<Throwable, g> f335j;

    /* JADX WARN: Multi-variable type inference failed */
    public s0(l<? super Throwable, g> lVar) {
        this.f335j = lVar;
    }

    @Override // q5.l
    public final /* bridge */ /* synthetic */ g k(Throwable th) {
        q(th);
        return g.f4141a;
    }

    @Override // a6.q
    public final void q(Throwable th) {
        if (f334k.compareAndSet(this, 0, 1)) {
            this.f335j.k(th);
        }
    }
}
