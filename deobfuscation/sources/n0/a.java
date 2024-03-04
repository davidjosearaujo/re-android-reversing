package n0;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import r5.h;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public final HashMap<Object, WeakReference<C0081a>> f5107a = new HashMap<>();

    /* renamed from: n0.a$a */
    /* loaded from: classes.dex */
    public static final class C0081a {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C0081a) {
                ((C0081a) obj).getClass();
                return h.a(null, null);
            }
            return false;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "ImageVectorEntry(imageVector=null, configFlags=0)";
        }
    }
}
