package f0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f4072a;

    public /* synthetic */ a(int i7) {
        this.f4072a = i7;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && this.f4072a == ((a) obj).f4072a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f4072a);
    }

    public final String toString() {
        int i7 = this.f4072a;
        boolean z6 = false;
        if (i7 == 1) {
            return "Touch";
        }
        if (i7 == 2) {
            z6 = true;
        }
        return z6 ? "Keyboard" : "Error";
    }
}
