package androidx.compose.ui.platform;

/* loaded from: classes.dex */
public final class q extends r5.i implements q5.a<f5.g> {

    /* renamed from: g */
    public final /* synthetic */ boolean f1233g;

    /* renamed from: h */
    public final /* synthetic */ androidx.savedstate.a f1234h;

    /* renamed from: i */
    public final /* synthetic */ String f1235i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(boolean z6, androidx.savedstate.a aVar, String str) {
        super(0);
        this.f1233g = z6;
        this.f1234h = aVar;
        this.f1235i = str;
    }

    @Override // q5.a
    public final f5.g d() {
        if (this.f1233g) {
            androidx.savedstate.a aVar = this.f1234h;
            String str = this.f1235i;
            aVar.getClass();
            r5.h.f(str, "key");
            aVar.f2292a.b(str);
        }
        return f5.g.f4141a;
    }
}
