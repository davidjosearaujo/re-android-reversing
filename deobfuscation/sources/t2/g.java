package t2;

import r2.m;
import r2.v;
import t2.h;

/* loaded from: classes.dex */
public final class g extends k3.i<p2.f, v<?>> implements h {

    /* renamed from: d */
    public h.a f6050d;

    public g(long j5) {
        super(j5);
    }

    @Override // k3.i
    public final int b(v<?> vVar) {
        v<?> vVar2 = vVar;
        if (vVar2 == null) {
            return 1;
        }
        return vVar2.b();
    }

    @Override // k3.i
    public final void c(p2.f fVar, v<?> vVar) {
        v<?> vVar2 = vVar;
        h.a aVar = this.f6050d;
        if (aVar == null || vVar2 == null) {
            return;
        }
        ((m) aVar).e.a(vVar2, true);
    }
}
