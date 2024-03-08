package androidx.activity;

import f5.g;
import q5.a;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class q extends i implements a<g> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f433g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(OnBackPressedDispatcher onBackPressedDispatcher) {
        super(0);
        this.f433g = onBackPressedDispatcher;
    }

    @Override // q5.a
    public final g d() {
        this.f433g.b();
        return g.f4141a;
    }
}
