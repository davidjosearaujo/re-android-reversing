package l;

import java.util.HashMap;
import l.b;

/* loaded from: classes.dex */
public final class a<K, V> extends b<K, V> {

    /* renamed from: j */
    public final HashMap<K, b.c<K, V>> f4828j = new HashMap<>();

    @Override // l.b
    public final b.c<K, V> a(K k6) {
        return this.f4828j.get(k6);
    }

    @Override // l.b
    public final V b(K k6) {
        V v6 = (V) super.b(k6);
        this.f4828j.remove(k6);
        return v6;
    }

    public final V c(K k6, V v6) {
        b.c<K, V> a7 = a(k6);
        if (a7 != null) {
            return a7.f4834g;
        }
        HashMap<K, b.c<K, V>> hashMap = this.f4828j;
        b.c<K, V> cVar = new b.c<>(k6, v6);
        this.f4832i++;
        b.c<K, V> cVar2 = this.f4830g;
        if (cVar2 == null) {
            this.f4829f = cVar;
        } else {
            cVar2.f4835h = cVar;
            cVar.f4836i = cVar2;
        }
        this.f4830g = cVar;
        hashMap.put(k6, cVar);
        return null;
    }
}
