package y5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import q5.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d<T> f6828a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f6829b = false;

    /* renamed from: c  reason: collision with root package name */
    public final l<T, Boolean> f6830c;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements Iterator<T>, s5.a {

        /* renamed from: f  reason: collision with root package name */
        public final Iterator<T> f6831f;

        /* renamed from: g  reason: collision with root package name */
        public int f6832g = -1;

        /* renamed from: h  reason: collision with root package name */
        public T f6833h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b<T> f6834i;

        public a(b<T> bVar) {
            this.f6834i = bVar;
            this.f6831f = bVar.f6828a.iterator();
        }

        public final void a() {
            int i7;
            while (true) {
                if (!this.f6831f.hasNext()) {
                    i7 = 0;
                    break;
                }
                T next = this.f6831f.next();
                if (this.f6834i.f6830c.k(next).booleanValue() == this.f6834i.f6829b) {
                    this.f6833h = next;
                    i7 = 1;
                    break;
                }
            }
            this.f6832g = i7;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f6832g == -1) {
                a();
            }
            return this.f6832g == 1;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.f6832g == -1) {
                a();
            }
            if (this.f6832g != 0) {
                T t5 = this.f6833h;
                this.f6833h = null;
                this.f6832g = -1;
                return t5;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(m mVar) {
        k kVar = k.f6846g;
        this.f6828a = mVar;
        this.f6830c = kVar;
    }

    @Override // y5.d
    public final Iterator<T> iterator() {
        return new a(this);
    }
}
