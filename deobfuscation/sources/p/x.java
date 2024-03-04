package p;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a */
    public final String f5455a;

    public x(String str) {
        this.f5455a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof x) && r5.h.a(this.f5455a, ((x) obj).f5455a);
    }

    public final int hashCode() {
        return this.f5455a.hashCode();
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("OpaqueKey(key=");
        d7.append(this.f5455a);
        d7.append(')');
        return d7.toString();
    }
}
