package w5;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c extends a {

    /* renamed from: i  reason: collision with root package name */
    public static final c f6418i = new c(1, 0);

    public c(int i7, int i8) {
        super(i7, i8, 1);
    }

    @Override // w5.a, java.lang.Object
    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (!(this.f6411f == cVar.f6411f && this.f6412g == cVar.f6412g)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // w5.a, java.lang.Object
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return this.f6412g + (this.f6411f * 31);
    }

    @Override // w5.a
    public final boolean isEmpty() {
        return this.f6411f > this.f6412g;
    }

    @Override // w5.a, java.lang.Object
    public final String toString() {
        return this.f6411f + ".." + this.f6412g;
    }
}
