package b.a.a.a.e;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class c0<L> {

    /* renamed from: a  reason: collision with root package name */
    private final L f139a;

    /* renamed from: b  reason: collision with root package name */
    private final String f140b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f139a == c0Var.f139a && this.f140b.equals(c0Var.f140b);
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f139a) * 31) + this.f140b.hashCode();
    }
}
