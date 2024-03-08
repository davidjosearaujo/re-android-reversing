package a6;

import androidx.activity.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k0 implements q0 {

    /* renamed from: f  reason: collision with root package name */
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
        StringBuilder d7 = h.d("Empty{");
        d7.append(this.f303f ? "Active" : "New");
        d7.append('}');
        return d7.toString();
    }
}
