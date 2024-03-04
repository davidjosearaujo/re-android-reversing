package y5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class c<T> implements d<T> {

    /* renamed from: a */
    public final q5.a<T> f6835a;

    /* renamed from: b */
    public final q5.l<T, T> f6836b;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<T>, s5.a {

        /* renamed from: f */
        public T f6837f;

        /* renamed from: g */
        public int f6838g = -2;

        /* renamed from: h */
        public final /* synthetic */ c<T> f6839h;

        public a(c<T> cVar) {
            this.f6839h = cVar;
        }

        public final void a() {
            T k6;
            if (this.f6838g == -2) {
                k6 = this.f6839h.f6835a.d();
            } else {
                q5.l<T, T> lVar = this.f6839h.f6836b;
                T t5 = this.f6837f;
                r5.h.c(t5);
                k6 = lVar.k(t5);
            }
            this.f6837f = k6;
            this.f6838g = k6 == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f6838g < 0) {
                a();
            }
            return this.f6838g == 1;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.f6838g < 0) {
                a();
            }
            if (this.f6838g != 0) {
                T t5 = this.f6837f;
                r5.h.d(t5, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.f6838g = -1;
                return t5;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public c(h hVar, q5.l lVar) {
        this.f6835a = hVar;
        this.f6836b = lVar;
    }

    @Override // y5.d
    public final Iterator<T> iterator() {
        return new a(this);
    }
}
