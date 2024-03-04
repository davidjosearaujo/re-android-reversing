package r0;

/* loaded from: classes.dex */
public final class a implements s {

    /* renamed from: a */
    public final int f5690a;

    public a(int i7) {
        this.f5690a = i7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f5690a == ((a) obj).f5690a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f5690a);
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("AndroidFontResolveInterceptor(fontWeightAdjustment=");
        d7.append(this.f5690a);
        d7.append(')');
        return d7.toString();
    }
}
