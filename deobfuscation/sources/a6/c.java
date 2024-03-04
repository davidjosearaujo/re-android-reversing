package a6;

import java.util.concurrent.locks.LockSupport;

/* loaded from: classes.dex */
public final class c<T> extends a<T> {

    /* renamed from: i */
    public final Thread f285i;

    /* renamed from: j */
    public final l0 f286j;

    public c(i5.f fVar, Thread thread, l0 l0Var) {
        super(fVar, true);
        this.f285i = thread;
        this.f286j = l0Var;
    }

    @Override // a6.z0
    public final void w(Object obj) {
        if (r5.h.a(Thread.currentThread(), this.f285i)) {
            return;
        }
        LockSupport.unpark(this.f285i);
    }
}
