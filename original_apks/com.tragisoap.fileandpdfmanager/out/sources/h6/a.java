package h6;

import a6.e;
import a6.g;
import a6.p1;
import f6.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import q.d;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a<R> extends e implements b, p1 {

    /* renamed from: f  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4402f = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "state");
    private volatile Object state;

    /* renamed from: h6.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final class C0066a {
    }

    @Override // h6.b
    public final boolean a(Object obj, Object obj2) {
        return g(obj) == 0;
    }

    @Override // a6.p1
    public final void b(s<?> sVar, int i7) {
    }

    @Override // a6.f
    public final void c(Throwable th) {
        boolean z6;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4402f;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != a0.e.f36e0) {
                d dVar = a0.e.f38f0;
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, dVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            z6 = false;
                            continue;
                            break;
                        }
                    } else {
                        z6 = true;
                        continue;
                        break;
                    }
                }
            } else {
                return;
            }
        } while (!z6);
    }

    public final int g(Object obj) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4402f;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof g)) {
                if (h.a(obj2, a0.e.f36e0) ? true : obj2 instanceof C0066a) {
                    return 3;
                }
                if (h.a(obj2, a0.e.f38f0)) {
                    return 2;
                }
                boolean z6 = false;
                if (h.a(obj2, a0.e.f35d0)) {
                    List G = q2.a.G(obj);
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, G)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                break;
                            }
                        } else {
                            z6 = true;
                            break;
                        }
                    }
                    if (z6) {
                        return 1;
                    }
                } else if (obj2 instanceof List) {
                    Collection collection = (Collection) obj2;
                    h.f(collection, "<this>");
                    ArrayList arrayList = new ArrayList(collection.size() + 1);
                    arrayList.addAll(collection);
                    arrayList.add(obj);
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, arrayList)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                break;
                            }
                        } else {
                            z6 = true;
                            break;
                        }
                    }
                    if (z6) {
                        return 1;
                    }
                } else {
                    throw new IllegalStateException(("Unexpected state: " + obj2).toString());
                }
            }
        }
    }

    @Override // q5.l
    public final /* bridge */ /* synthetic */ f5.g k(Throwable th) {
        c(th);
        return f5.g.f4141a;
    }
}
