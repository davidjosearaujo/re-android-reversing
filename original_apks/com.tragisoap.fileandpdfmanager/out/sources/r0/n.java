package r0;

import androidx.fragment.app.s0;
import q2.a;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class n implements Comparable<n> {

    /* renamed from: g  reason: collision with root package name */
    public static final n f5701g;

    /* renamed from: f  reason: collision with root package name */
    public final int f5702f;

    static {
        n nVar = new n(100);
        n nVar2 = new n(200);
        n nVar3 = new n(300);
        n nVar4 = new n(400);
        n nVar5 = new n(500);
        n nVar6 = new n(600);
        n nVar7 = new n(700);
        n nVar8 = new n(800);
        n nVar9 = new n(900);
        f5701g = nVar4;
        a.H(nVar, nVar2, nVar3, nVar4, nVar5, nVar6, nVar7, nVar8, nVar9);
    }

    public n(int i7) {
        this.f5702f = i7;
        boolean z6 = false;
        if (1 <= i7 && i7 < 1001) {
            z6 = true;
        }
        if (!z6) {
            throw new IllegalArgumentException(s0.g("Font weight can be in range [1, 1000]. Current value: ", i7).toString());
        }
    }

    /* renamed from: a */
    public final int compareTo(n nVar) {
        h.f(nVar, "other");
        return h.h(this.f5702f, nVar.f5702f);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof n) && this.f5702f == ((n) obj).f5702f;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.f5702f;
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("FontWeight(weight=");
        d7.append(this.f5702f);
        d7.append(')');
        return d7.toString();
    }
}
