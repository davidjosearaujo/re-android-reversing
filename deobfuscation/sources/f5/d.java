package f5;

import java.io.Serializable;
import r5.h;

/* loaded from: classes.dex */
public final class d<T> implements Serializable {

    /* loaded from: classes.dex */
    public static final class a implements Serializable {

        /* renamed from: f */
        public final Throwable f4137f;

        public a(Throwable th) {
            h.f(th, "exception");
            this.f4137f = th;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof a) && h.a(this.f4137f, ((a) obj).f4137f);
        }

        public final int hashCode() {
            return this.f4137f.hashCode();
        }

        public final String toString() {
            StringBuilder d7 = androidx.activity.h.d("Failure(");
            d7.append(this.f4137f);
            d7.append(')');
            return d7.toString();
        }
    }

    public static final Throwable a(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).f4137f;
        }
        return null;
    }
}
