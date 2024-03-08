package o0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f5228a;

    public /* synthetic */ c(int i7) {
        this.f5228a = i7;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && this.f5228a == ((c) obj).f5228a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f5228a);
    }

    public final String toString() {
        int i7 = this.f5228a;
        boolean z6 = false;
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
        if (i7 == 6) {
            z6 = true;
        }
        return z6 ? "DropdownList" : "Unknown";
    }
}
