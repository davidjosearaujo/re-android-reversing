package o0;

import f5.a;
import q5.p;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class n extends i implements p<a<a<? extends Boolean>>, a<a<? extends Boolean>>, a<a<? extends Boolean>>> {

    /* renamed from: g  reason: collision with root package name */
    public static final n f5266g = new n();

    public n() {
        super(2);
    }

    @Override // q5.p
    public final a<a<? extends Boolean>> i(a<a<? extends Boolean>> aVar, a<a<? extends Boolean>> aVar2) {
        String str;
        a<? extends Boolean> aVar3;
        a<a<? extends Boolean>> aVar4 = aVar;
        a<a<? extends Boolean>> aVar5 = aVar2;
        h.f(aVar5, "childValue");
        if (aVar4 == null || (str = aVar4.f5226a) == null) {
            str = aVar5.f5226a;
        }
        if (aVar4 == null || (aVar3 = aVar4.f5227b) == null) {
            aVar3 = aVar5.f5227b;
        }
        return new a<>(str, aVar3);
    }
}
