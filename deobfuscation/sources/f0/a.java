package f0;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public final int f4072a;

    public final boolean equals(Object obj) {
        return (obj instanceof a) && this.f4072a == ((a) obj).f4072a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f4072a);
    }

    public final String toString() {
        int i7 = this.f4072a;
        if (i7 == 1) {
            return "Touch";
        }
        return i7 == 2 ? "Keyboard" : "Error";
    }
}
