package a6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class o {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f323b = AtomicIntegerFieldUpdater.newUpdater(o.class, "_handled");
    private volatile int _handled;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f324a;

    public o(Throwable th, boolean z6) {
        this.f324a = th;
        this._handled = z6 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f324a + ']';
    }
}
