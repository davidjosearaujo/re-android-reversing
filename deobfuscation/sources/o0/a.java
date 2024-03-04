package o0;

import f5.a;

/* loaded from: classes.dex */
public final class a<T extends f5.a<? extends Boolean>> {

    /* renamed from: a */
    public final String f5226a;

    /* renamed from: b */
    public final T f5227b;

    public a(String str, T t5) {
        this.f5226a = str;
        this.f5227b = t5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return r5.h.a(this.f5226a, aVar.f5226a) && r5.h.a(this.f5227b, aVar.f5227b);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f5226a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        T t5 = this.f5227b;
        return hashCode + (t5 != null ? t5.hashCode() : 0);
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
