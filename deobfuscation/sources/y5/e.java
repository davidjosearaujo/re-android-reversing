package y5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class e<T> extends f implements Iterator, i5.d, s5.a {

    /* renamed from: f */
    public int f6840f;

    /* renamed from: g */
    public Object f6841g;

    /* renamed from: h */
    public Iterator f6842h;

    /* renamed from: i */
    public i5.d f6843i;

    public final i5.f a() {
        return i5.g.f4488f;
    }

    public final void b(Object obj, i5.d dVar) {
        this.f6841g = obj;
        this.f6840f = 3;
        this.f6843i = dVar;
        Kotlin_1.a aVar = Kotlin_1.a.f4591f;
        r5.h.f(dVar, "frame");
    }

    public final Object d(Iterator it, i5.d dVar) {
        if (it.hasNext()) {
            this.f6842h = it;
            this.f6840f = 2;
            this.f6843i = dVar;
            Kotlin_1.a aVar = Kotlin_1.a.f4591f;
            r5.h.f(dVar, "frame");
            return aVar;
        }
        return f5.g.f4141a;
    }

    public final RuntimeException e() {
        int i7 = this.f6840f;
        if (i7 != 4) {
            if (i7 != 5) {
                StringBuilder d7 = androidx.activity.h.d("Unexpected state of the iterator: ");
                d7.append(this.f6840f);
                return new IllegalStateException(d7.toString());
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    public final boolean hasNext() {
        while (true) {
            int i7 = this.f6840f;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 == 2 || i7 == 3) {
                        return true;
                    }
                    if (i7 == 4) {
                        return false;
                    }
                    throw e();
                }
                Iterator it = this.f6842h;
                r5.h.c(it);
                if (it.hasNext()) {
                    this.f6840f = 2;
                    return true;
                }
                this.f6842h = null;
            }
            this.f6840f = 5;
            i5.d dVar = this.f6843i;
            r5.h.c(dVar);
            this.f6843i = null;
            dVar.o(f5.g.f4141a);
        }
    }

    public final Object next() {
        int i7 = this.f6840f;
        if (i7 == 0 || i7 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        } else if (i7 == 2) {
            this.f6840f = 1;
            Iterator it = this.f6842h;
            r5.h.c(it);
            return it.next();
        } else if (i7 == 3) {
            this.f6840f = 0;
            Object obj = this.f6841g;
            this.f6841g = null;
            return obj;
        } else {
            throw e();
        }
    }

    public final void o(Object obj) {
        f5.e.b(obj);
        this.f6840f = 4;
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
