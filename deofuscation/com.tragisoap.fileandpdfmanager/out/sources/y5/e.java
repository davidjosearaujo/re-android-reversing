package y5;

import f5.g;
import i5.d;
import i5.f;
import java.util.Iterator;
import java.util.NoSuchElementException;
import r5.h;
import s5.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e<T> extends f<T> implements Iterator<T>, d<g>, a {

    /* renamed from: f */
    public int f6840f;

    /* renamed from: g */
    public T f6841g;

    /* renamed from: h */
    public Iterator<? extends T> f6842h;

    /* renamed from: i */
    public d<? super g> f6843i;

    @Override // i5.d
    public final f a() {
        return i5.g.f4488f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // y5.f
    public final void b(Object obj, d dVar) {
        this.f6841g = obj;
        this.f6840f = 3;
        this.f6843i = dVar;
        j5.a aVar = j5.a.f4591f;
        h.f(dVar, "frame");
    }

    @Override // y5.f
    public final Object d(Iterator<? extends T> it, d<? super g> dVar) {
        if (!it.hasNext()) {
            return g.f4141a;
        }
        this.f6842h = it;
        this.f6840f = 2;
        this.f6843i = dVar;
        j5.a aVar = j5.a.f4591f;
        h.f(dVar, "frame");
        return aVar;
    }

    public final RuntimeException e() {
        int i7 = this.f6840f;
        if (i7 == 4) {
            return new NoSuchElementException();
        }
        if (i7 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        StringBuilder d7 = androidx.activity.h.d("Unexpected state of the iterator: ");
        d7.append(this.f6840f);
        return new IllegalStateException(d7.toString());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i7 = this.f6840f;
            if (i7 != 0) {
                if (i7 == 1) {
                    Iterator<? extends T> it = this.f6842h;
                    h.c(it);
                    if (it.hasNext()) {
                        this.f6840f = 2;
                        return true;
                    }
                    this.f6842h = null;
                } else if (i7 == 2 || i7 == 3) {
                    return true;
                } else {
                    if (i7 == 4) {
                        return false;
                    }
                    throw e();
                }
            }
            this.f6840f = 5;
            d<? super g> dVar = this.f6843i;
            h.c(dVar);
            this.f6843i = null;
            dVar.o(g.f4141a);
        }
    }

    @Override // java.util.Iterator
    public final T next() {
        int i7 = this.f6840f;
        if (i7 == 0 || i7 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        } else if (i7 == 2) {
            this.f6840f = 1;
            Iterator<? extends T> it = this.f6842h;
            h.c(it);
            return (T) it.next();
        } else if (i7 == 3) {
            this.f6840f = 0;
            T t5 = this.f6841g;
            this.f6841g = null;
            return t5;
        } else {
            throw e();
        }
    }

    @Override // i5.d
    public final void o(Object obj) {
        f5.e.b(obj);
        this.f6840f = 4;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
