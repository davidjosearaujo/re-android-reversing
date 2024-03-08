package a6;

import a0.b;
import f6.r;
import i5.d;
import i5.f;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import q2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f0<T> extends r<T> {

    /* renamed from: j  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f290j = AtomicIntegerFieldUpdater.newUpdater(f0.class, "_decision");
    private volatile int _decision;

    public f0(d dVar, f fVar) {
        super(dVar, fVar);
    }

    @Override // f6.r, a6.a
    public final void i0(Object obj) {
        boolean z6;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f290j;
        while (true) {
            int i7 = atomicIntegerFieldUpdater.get(this);
            z6 = false;
            if (i7 == 0) {
                if (f290j.compareAndSet(this, 0, 2)) {
                    z6 = true;
                    break;
                }
            } else if (i7 != 1) {
                throw new IllegalStateException("Already resumed".toString());
            }
        }
        if (!z6) {
            b.A(a.A(this.f4177i), b.u(obj), null);
        }
    }

    @Override // f6.r, a6.z0
    public final void w(Object obj) {
        i0(obj);
    }
}
