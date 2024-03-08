package o0;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import l0.z;
import r5.h;
import s5.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f implements r, Iterable<Map.Entry<? extends q<?>, ? extends Object>>, a {

    /* renamed from: f */
    public final LinkedHashMap f5231f = new LinkedHashMap();

    /* renamed from: g */
    public boolean f5232g;

    /* renamed from: h */
    public boolean f5233h;

    @Override // o0.r
    public final <T> void a(q<T> qVar, T t5) {
        h.f(qVar, "key");
        if (!(t5 instanceof a) || !b(qVar)) {
            this.f5231f.put(qVar, t5);
            return;
        }
        Object obj = this.f5231f.get(qVar);
        h.d(obj, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
        a aVar = (a) obj;
        LinkedHashMap linkedHashMap = this.f5231f;
        a aVar2 = (a) t5;
        String str = aVar2.f5226a;
        if (str == null) {
            str = aVar.f5226a;
        }
        f5.a aVar3 = aVar2.f5227b;
        if (aVar3 == null) {
            aVar3 = aVar.f5227b;
        }
        linkedHashMap.put(qVar, new a(str, aVar3));
    }

    public final <T> boolean b(q<T> qVar) {
        h.f(qVar, "key");
        return this.f5231f.containsKey(qVar);
    }

    public final <T> T c(q<T> qVar) {
        h.f(qVar, "key");
        T t5 = (T) this.f5231f.get(qVar);
        if (t5 != null) {
            return t5;
        }
        throw new IllegalStateException("Key not present: " + qVar + " - consider getOrElse or getOrNull");
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return h.a(this.f5231f, fVar.f5231f) && this.f5232g == fVar.f5232g && this.f5233h == fVar.f5233h;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        int hashCode = Boolean.hashCode(this.f5232g);
        return Boolean.hashCode(this.f5233h) + ((hashCode + (this.f5231f.hashCode() * 31)) * 31);
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<? extends q<?>, ? extends Object>> iterator() {
        return this.f5231f.entrySet().iterator();
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String str = "";
        if (this.f5232g) {
            sb.append(str);
            sb.append("mergeDescendants=true");
            str = ", ";
        }
        if (this.f5233h) {
            sb.append(str);
            sb.append("isClearingSemantics=true");
            str = ", ";
        }
        for (Map.Entry entry : this.f5231f.entrySet()) {
            Object value = entry.getValue();
            sb.append(str);
            sb.append(((q) entry.getKey()).f5269a);
            sb.append(" : ");
            sb.append(value);
            str = ", ";
        }
        return z.p(this) + "{ " + ((Object) sb) + " }";
    }
}
