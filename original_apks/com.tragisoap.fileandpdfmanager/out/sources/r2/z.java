package r2;

import com.bumptech.glide.load.data.d;
import p2.f;
import r2.h;
import v2.n;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class z implements d.a<Object> {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ n.a f5895f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ a0 f5896g;

    public z(a0 a0Var, n.a aVar) {
        this.f5896g = a0Var;
        this.f5895f = aVar;
    }

    @Override // com.bumptech.glide.load.data.d.a
    public final void c(Exception exc) {
        a0 a0Var = this.f5896g;
        n.a<?> aVar = this.f5895f;
        n.a<?> aVar2 = a0Var.f5723k;
        if (aVar2 != null && aVar2 == aVar) {
            a0 a0Var2 = this.f5896g;
            n.a aVar3 = this.f5895f;
            h.a aVar4 = a0Var2.f5719g;
            f fVar = a0Var2.f5724l;
            d<Data> dVar = aVar3.f6225c;
            aVar4.b(fVar, exc, dVar, dVar.e());
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public final void d(Object obj) {
        a0 a0Var = this.f5896g;
        n.a<?> aVar = this.f5895f;
        n.a<?> aVar2 = a0Var.f5723k;
        if (aVar2 != null && aVar2 == aVar) {
            a0 a0Var2 = this.f5896g;
            n.a aVar3 = this.f5895f;
            l lVar = a0Var2.f5718f.f5759p;
            if (obj == null || !lVar.c(aVar3.f6225c.e())) {
                h.a aVar4 = a0Var2.f5719g;
                f fVar = aVar3.f6223a;
                d<Data> dVar = aVar3.f6225c;
                aVar4.c(fVar, obj, dVar, dVar.e(), a0Var2.f5724l);
                return;
            }
            a0Var2.f5722j = obj;
            a0Var2.f5719g.a();
        }
    }
}
