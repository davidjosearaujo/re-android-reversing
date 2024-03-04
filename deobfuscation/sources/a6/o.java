package a6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public class o {

    /* renamed from: b */
    public static final AtomicIntegerFieldUpdater f323b = AtomicIntegerFieldUpdater.newUpdater(o.class, "_handled");
    private volatile int _handled;

    /* renamed from: a */
    public final Throwable f324a;

    public o(Throwable th, boolean z6) {
        this.f324a = th;
        this._handled = z6 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f324a + ']';
    }
}
