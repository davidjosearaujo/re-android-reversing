package f5;

import java.io.Serializable;
import r5.h;

/* loaded from: classes.dex */
public final class c<A, B> implements Serializable {

    /* renamed from: f */
    public final A f4135f;

    /* renamed from: g */
    public final B f4136g;

    public c(A a7, B b2) {
        this.f4135f = a7;
        this.f4136g = b2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return h.a(this.f4135f, cVar.f4135f) && h.a(this.f4136g, cVar.f4136g);
        }
        return false;
    }

    public final int hashCode() {
        A a7 = this.f4135f;
        int hashCode = (a7 == null ? 0 : a7.hashCode()) * 31;
        B b2 = this.f4136g;
        return hashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public final String toString() {
        return '(' + this.f4135f + ", " + this.f4136g + ')';
    }
}
