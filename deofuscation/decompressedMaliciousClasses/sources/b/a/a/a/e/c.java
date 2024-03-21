package b.a.a.a.e;

import b.a.a.a.e.j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.j;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class c<A extends j<? extends j, a.c>> extends a {

    /* renamed from: a  reason: collision with root package name */
    private A f138a;

    public c(int i, A a2) {
        super(i);
        this.f138a = a2;
    }

    @Override // b.a.a.a.e.a
    public final void b(p pVar, boolean z) {
        pVar.b(this.f138a, z);
    }

    @Override // b.a.a.a.e.a
    public final void c(v<?> vVar) {
        this.f138a.m(vVar.q());
    }

    @Override // b.a.a.a.e.a
    public final void e(Status status) {
        this.f138a.o(status);
    }
}
