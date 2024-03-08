package o0;

import f5.a;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a<T extends f5.a<? extends Boolean>> {

    /* renamed from: a  reason: collision with root package name */
    public final String f5226a;

    /* renamed from: b  reason: collision with root package name */
    public final T f5227b;

    public a(String str, T t5) {
        this.f5226a = str;
        this.f5227b = t5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return h.a(this.f5226a, aVar.f5226a) && h.a(this.f5227b, aVar.f5227b);
    }

    public final int hashCode() {
        String str = this.f5226a;
        int i7 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        T t5 = this.f5227b;
        if (t5 != null) {
            i7 = t5.hashCode();
        }
        return hashCode + i7;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("AccessibilityAction(label=");
        d7.append(this.f5226a);
        d7.append(", action=");
        d7.append(this.f5227b);
        d7.append(')');
        return d7.toString();
    }
}
