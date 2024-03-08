package g5;

import java.util.Iterator;
import java.util.Set;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class f<E> extends a<E> implements Set<E> {
    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        h.f(set, "other");
        if (size() != set.size()) {
            return false;
        }
        return containsAll(set);
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public final int hashCode() {
        Iterator<E> it = iterator();
        int i7 = 0;
        while (it.hasNext()) {
            E next = it.next();
            i7 += next != null ? next.hashCode() : 0;
        }
        return i7;
    }
}
