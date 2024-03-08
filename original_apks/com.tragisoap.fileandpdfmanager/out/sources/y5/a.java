package y5;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<d<T>> f6827a;

    public a(g gVar) {
        this.f6827a = new AtomicReference<>(gVar);
    }

    @Override // y5.d
    public final Iterator<T> iterator() {
        d<T> andSet = this.f6827a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
