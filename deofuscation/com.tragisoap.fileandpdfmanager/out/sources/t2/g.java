package t2;

import k3.i;
import p2.f;
import r2.m;
import r2.v;
import t2.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g extends i<f, v<?>> implements h {

    /* renamed from: d  reason: collision with root package name */
    public h.a f6050d;

    public g(long j7) {
        super(j7);
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
    public final void c(f fVar, v<?> vVar) {
        v<?> vVar2 = vVar;
        h.a aVar = this.f6050d;
        if (aVar != null && vVar2 != null) {
            ((m) aVar).e.a(vVar2, true);
        }
    }
}
