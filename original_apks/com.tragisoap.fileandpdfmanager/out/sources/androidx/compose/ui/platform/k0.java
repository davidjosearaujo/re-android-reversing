package androidx.compose.ui.platform;

import f5.g;
import p.b;
import q5.p;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k0 extends i implements p<b, Integer, g> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WrappedComposition f1187g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ p<b, Integer, g> f1188h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public k0(WrappedComposition wrappedComposition, p<? super b, ? super Integer, g> pVar) {
        super(2);
        this.f1187g = wrappedComposition;
        this.f1188h = pVar;
    }

    @Override // q5.p
    public final g i(b bVar, Integer num) {
        b bVar2 = bVar;
        if ((num.intValue() & 11) != 2 || !bVar2.k()) {
            this.f1187g.getClass();
            h.a(null, this.f1188h, bVar2, 8);
        } else {
            bVar2.c();
        }
        return g.f4141a;
    }
}