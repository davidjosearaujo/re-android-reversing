package r;

import java.util.Map;

/* loaded from: classes.dex */
public final class k<K, V> extends j<K, V, Map.Entry<? extends K, ? extends V>> {
    @Override // java.util.Iterator
    public final Object next() {
        int i7 = this.f5688h + 2;
        this.f5688h = i7;
        Object[] objArr = this.f5686f;
        return new a(objArr[i7 - 2], objArr[i7 - 1]);
    }
}
