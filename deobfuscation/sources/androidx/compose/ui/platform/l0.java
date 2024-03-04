package androidx.compose.ui.platform;

/* loaded from: classes.dex */
public final class l0 extends r5.i implements q5.p<p.b, Integer, f5.g> {

    /* renamed from: g */
    public final /* synthetic */ WrappedComposition f1191g;

    /* renamed from: h */
    public final /* synthetic */ q5.p<p.b, Integer, f5.g> f1192h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public l0(WrappedComposition wrappedComposition, q5.p<? super p.b, ? super Integer, f5.g> pVar) {
        super(2);
        this.f1191g = wrappedComposition;
        this.f1192h = pVar;
    }

    @Override // q5.p
    public final f5.g i(p.b bVar, Integer num) {
        p.b bVar2 = bVar;
        if ((num.intValue() & 11) == 2 && bVar2.k()) {
            bVar2.c();
            return f5.g.f4141a;
        }
        this.f1191g.getClass();
        throw null;
    }
}
