package f5;

import java.io.Serializable;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c<A, B> implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    public final A f4135f;

    /* renamed from: g  reason: collision with root package name */
    public final B f4136g;

    public c(A a7, B b2) {
        this.f4135f = a7;
        this.f4136g = b2;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return h.a(this.f4135f, cVar.f4135f) && h.a(this.f4136g, cVar.f4136g);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        A a7 = this.f4135f;
        int i7 = 0;
        int hashCode = (a7 == null ? 0 : a7.hashCode()) * 31;
        B b2 = this.f4136g;
        if (b2 != null) {
            i7 = b2.hashCode();
        }
        return hashCode + i7;
    }

    @Override // java.lang.Object
    public final String toString() {
        return '(' + this.f4135f + ", " + this.f4136g + ')';
    }
}
