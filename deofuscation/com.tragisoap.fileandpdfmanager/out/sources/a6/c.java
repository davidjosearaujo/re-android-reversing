package a6;

import i5.f;
import java.util.concurrent.locks.LockSupport;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c<T> extends a<T> {

    /* renamed from: i  reason: collision with root package name */
    public final Thread f285i;

    /* renamed from: j  reason: collision with root package name */
    public final l0 f286j;

    public c(f fVar, Thread thread, l0 l0Var) {
        super(fVar, true);
        this.f285i = thread;
        this.f286j = l0Var;
    }

    @Override // a6.z0
    public final void w(Object obj) {
        if (!h.a(Thread.currentThread(), this.f285i)) {
            LockSupport.unpark(this.f285i);
        }
    }
}
