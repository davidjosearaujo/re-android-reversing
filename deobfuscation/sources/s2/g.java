package s2;

import java.util.ArrayList;
import java.util.HashMap;
import s2.l;

/* loaded from: classes.dex */
public final class g<K extends l, V> {

    /* renamed from: a */
    public final a<K, V> f5934a = new a<>();

    /* renamed from: b */
    public final HashMap f5935b = new HashMap();

    /* loaded from: classes.dex */
    public static class a<K, V> {

        /* renamed from: a */
        public final K f5936a;

        /* renamed from: b */
        public ArrayList f5937b;

        /* renamed from: c */
        public a<K, V> f5938c;

        /* renamed from: d */
        public a<K, V> f5939d;

        public a() {
            this(null);
        }

        public a(K k6) {
            this.f5939d = this;
            this.f5938c = this;
            this.f5936a = k6;
        }
    }

    public final V a(K k6) {
        a aVar;
        a aVar2 = (a) this.f5935b.get(k6);
        if (aVar2 == null) {
            a aVar3 = new a(k6);
            this.f5935b.put(k6, aVar3);
            aVar = aVar3;
        } else {
            k6.a();
            aVar = aVar2;
        }
        a<K, V> aVar4 = aVar.f5939d;
        aVar4.f5938c = aVar.f5938c;
        aVar.f5938c.f5939d = aVar4;
        a<K, V> aVar5 = this.f5934a;
        aVar.f5939d = aVar5;
        a<K, V> aVar6 = aVar5.f5938c;
        aVar.f5938c = aVar6;
        aVar6.f5939d = aVar;
        aVar.f5939d.f5938c = aVar;
        ArrayList arrayList = aVar.f5937b;
        int size = arrayList != null ? arrayList.size() : 0;
        if (size > 0) {
            return (V) aVar.f5937b.remove(size - 1);
        }
        return null;
    }

    public final void b(K k6, V v6) {
        a aVar = (a) this.f5935b.get(k6);
        if (aVar == null) {
            aVar = new a(k6);
            a<K, V> aVar2 = aVar.f5939d;
            aVar2.f5938c = aVar.f5938c;
            aVar.f5938c.f5939d = aVar2;
            a<K, V> aVar3 = this.f5934a;
            aVar.f5939d = aVar3.f5939d;
            aVar.f5938c = aVar3;
            aVar3.f5939d = aVar;
            aVar.f5939d.f5938c = aVar;
            this.f5935b.put(k6, aVar);
        } else {
            k6.a();
        }
        if (aVar.f5937b == null) {
            aVar.f5937b = new ArrayList();
        }
        aVar.f5937b.add(v6);
    }

    public final V c() {
        a aVar = this.f5934a;
        while (true) {
            aVar = aVar.f5939d;
            V v6 = null;
            if (aVar.equals(this.f5934a)) {
                return null;
            }
            ArrayList arrayList = aVar.f5937b;
            int size = arrayList != null ? arrayList.size() : 0;
            if (size > 0) {
                v6 = (V) aVar.f5937b.remove(size - 1);
            }
            if (v6 != null) {
                return v6;
            }
            a<K, V> aVar2 = aVar.f5939d;
            aVar2.f5938c = aVar.f5938c;
            aVar.f5938c.f5939d = aVar2;
            this.f5935b.remove(aVar.f5936a);
            ((l) aVar.f5936a).a();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z6 = false;
        for (a aVar = this.f5934a.f5938c; !aVar.equals(this.f5934a); aVar = aVar.f5938c) {
            z6 = true;
            sb.append('{');
            sb.append(aVar.f5936a);
            sb.append(':');
            ArrayList arrayList = aVar.f5937b;
            sb.append(arrayList != null ? arrayList.size() : 0);
            sb.append("}, ");
        }
        if (z6) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
