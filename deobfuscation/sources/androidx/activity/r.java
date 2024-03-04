package androidx.activity;

import java.util.ListIterator;

/* loaded from: classes.dex */
public final class r extends r5.i implements q5.a<f5.g> {

    /* renamed from: g */
    public final /* synthetic */ OnBackPressedDispatcher f434g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(OnBackPressedDispatcher onBackPressedDispatcher) {
        super(0);
        this.f434g = onBackPressedDispatcher;
    }

    @Override // q5.a
    public final f5.g d() {
        n nVar;
        OnBackPressedDispatcher onBackPressedDispatcher = this.f434g;
        if (onBackPressedDispatcher.f386d == null) {
            g5.h<n> hVar = onBackPressedDispatcher.f385c;
            ListIterator<n> listIterator = hVar.listIterator(hVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    nVar = null;
                    break;
                }
                nVar = listIterator.previous();
                if (nVar.f428a) {
                    break;
                }
            }
        }
        onBackPressedDispatcher.f386d = null;
        return f5.g.f4141a;
    }
}
