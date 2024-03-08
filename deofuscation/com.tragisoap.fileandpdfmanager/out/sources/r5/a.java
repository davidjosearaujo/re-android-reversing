package r5;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a<T> implements Iterator<T>, s5.a {

    /* renamed from: f  reason: collision with root package name */
    public final T[] f5908f;

    /* renamed from: g  reason: collision with root package name */
    public int f5909g;

    public a(T[] tArr) {
        this.f5908f = tArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5909g < this.f5908f.length;
    }

    @Override // java.util.Iterator
    public final T next() {
        try {
            T[] tArr = this.f5908f;
            int i7 = this.f5909g;
            this.f5909g = i7 + 1;
            return tArr[i7];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f5909g--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
