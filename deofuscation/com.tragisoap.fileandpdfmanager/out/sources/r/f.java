package r;

import java.util.Iterator;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f<K, V> extends g5.f<K> {

    /* renamed from: f  reason: collision with root package name */
    public final b<K, V> f5680f;

    public f(b<K, V> bVar) {
        h.f(bVar, "map");
        this.f5680f = bVar;
    }

    @Override // g5.a
    public final int a() {
        b<K, V> bVar = this.f5680f;
        bVar.getClass();
        return bVar.f5675g;
    }

    @Override // g5.a, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f5680f.containsKey(obj);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<K> iterator() {
        return new g(this.f5680f.f5674f, 0);
    }
}
