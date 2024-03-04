package y5;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class m<T, R> implements d<R> {

    /* renamed from: a */
    public final d<T> f6847a;

    /* renamed from: b */
    public final q5.l<T, R> f6848b;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<R>, s5.a {

        /* renamed from: f */
        public final Iterator<T> f6849f;

        /* renamed from: g */
        public final /* synthetic */ m<T, R> f6850g;

        public a(m<T, R> mVar) {
            this.f6850g = mVar;
            this.f6849f = mVar.f6847a.iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f6849f.hasNext();
        }

        @Override // java.util.Iterator
        public final R next() {
            return this.f6850g.f6848b.k(this.f6849f.next());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(d<? extends T> dVar, q5.l<? super T, ? extends R> lVar) {
        this.f6847a = dVar;
        this.f6848b = lVar;
    }

    @Override // y5.d
    public final Iterator<R> iterator() {
        return new a(this);
    }
}
