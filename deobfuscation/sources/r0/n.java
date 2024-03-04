package r0;

import androidx.fragment.app.s0;

/* loaded from: classes.dex */
public final class n implements Comparable<n> {

    /* renamed from: g */
    public static final n f5701g;

    /* renamed from: f */
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
        q2.a.H(nVar, nVar2, nVar3, nVar4, nVar5, nVar6, nVar7, nVar8, nVar9);
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

    @Override // java.lang.Comparable
    /* renamed from: a */
    public final int compareTo(n nVar) {
        r5.h.f(nVar, "other");
        return r5.h.h(this.f5702f, nVar.f5702f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof n) && this.f5702f == ((n) obj).f5702f;
    }

    public final int hashCode() {
        return this.f5702f;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("FontWeight(weight=");
        d7.append(this.f5702f);
        d7.append(')');
        return d7.toString();
    }
}
