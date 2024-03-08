package r0;

import q5.l;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h extends i implements l<u, Object> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ j f5691g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(j jVar) {
        super(1);
        this.f5691g = jVar;
    }

    @Override // q5.l
    public final Object k(u uVar) {
        u uVar2 = uVar;
        r5.h.f(uVar2, "it");
        j jVar = this.f5691g;
        n nVar = uVar2.f5708b;
        int i7 = uVar2.f5709c;
        int i8 = uVar2.f5710d;
        Object obj = uVar2.e;
        r5.h.f(nVar, "fontWeight");
        return jVar.a(new u(null, nVar, i7, i8, obj)).getValue();
    }
}
