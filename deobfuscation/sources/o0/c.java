package o0;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    public final int f5228a;

    public final boolean equals(Object obj) {
        return (obj instanceof c) && this.f5228a == ((c) obj).f5228a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f5228a);
    }

    public final String toString() {
        int i7 = this.f5228a;
        if (i7 == 0) {
            return "Button";
        }
        if (i7 == 1) {
            return "Checkbox";
        }
        if (i7 == 2) {
            return "Switch";
        }
        if (i7 == 3) {
            return "RadioButton";
        }
        if (i7 == 4) {
            return "Tab";
        }
        if (i7 == 5) {
            return "Image";
        }
        return i7 == 6 ? "DropdownList" : "Unknown";
    }
}
