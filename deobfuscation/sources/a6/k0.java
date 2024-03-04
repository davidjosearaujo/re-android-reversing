package a6;

/* loaded from: classes.dex */
public final class k0 implements q0 {

    /* renamed from: f */
    public final boolean f303f;

    public k0(boolean z6) {
        this.f303f = z6;
    }

    @Override // a6.q0
    public final boolean b() {
        return this.f303f;
    }

    @Override // a6.q0
    public final c1 g() {
        return null;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("Empty{");
        d7.append(this.f303f ? "Active" : "New");
        d7.append('}');
        return d7.toString();
    }
}
