package r;

import g5.a;
import java.util.Iterator;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h<K, V> extends a<V> {

    /* renamed from: f  reason: collision with root package name */
    public final b<K, V> f5681f;

    public h(b<K, V> bVar) {
        r5.h.f(bVar, "map");
        this.f5681f = bVar;
    }

    @Override // g5.a
    public final int a() {
        b<K, V> bVar = this.f5681f;
        bVar.getClass();
        return bVar.f5675g;
    }

    @Override // g5.a, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f5681f.containsValue(obj);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        return new g(this.f5681f.f5674f, 1);
    }
}
