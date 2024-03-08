package f5;

import java.io.Serializable;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d<T> implements Serializable {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements Serializable {

        /* renamed from: f */
        public final Throwable f4137f;

        public a(Throwable th) {
            h.f(th, "exception");
            this.f4137f = th;
        }

        @Override // java.lang.Object
        public final boolean equals(Object obj) {
            return (obj instanceof a) && h.a(this.f4137f, ((a) obj).f4137f);
        }

        @Override // java.lang.Object
        public final int hashCode() {
            return this.f4137f.hashCode();
        }

        @Override // java.lang.Object
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
