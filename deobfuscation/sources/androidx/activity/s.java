package androidx.activity;

/* loaded from: classes.dex */
public final class s extends r5.i implements q5.a<f5.g> {

    /* renamed from: g */
    public final /* synthetic */ OnBackPressedDispatcher f460g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(OnBackPressedDispatcher onBackPressedDispatcher) {
        super(0);
        this.f460g = onBackPressedDispatcher;
    }

    @Override // q5.a
    public final f5.g d() {
        this.f460g.b();
        return f5.g.f4141a;
    }
}