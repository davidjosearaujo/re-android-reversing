package f6;

import a0.e;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import q.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class a<T> extends o {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4142a = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_consensus");
    private volatile Object _consensus = e.f32a0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f6.o
    public final Object a(Object obj) {
        boolean z6;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4142a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        d dVar = e.f32a0;
        if (obj2 == dVar) {
            d c7 = c(obj);
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 == dVar) {
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, dVar, c7)) {
                        if (atomicReferenceFieldUpdater.get(this) != dVar) {
                            z6 = false;
                            break;
                        }
                    } else {
                        z6 = true;
                        break;
                    }
                }
                obj2 = z6 ? c7 : f4142a.get(this);
            }
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(T t5, Object obj);

    public abstract d c(Object obj);
}
