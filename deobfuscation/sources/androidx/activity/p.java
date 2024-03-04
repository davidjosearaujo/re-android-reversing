package androidx.activity;

import java.util.ListIterator;

/* loaded from: classes.dex */
public final class p extends r5.i implements q5.l<b, f5.g> {

    /* renamed from: g */
    public final /* synthetic */ OnBackPressedDispatcher f432g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(OnBackPressedDispatcher onBackPressedDispatcher) {
        super(1);
        this.f432g = onBackPressedDispatcher;
    }

    @Override // q5.l
    public final f5.g k(b bVar) {
        n nVar;
        r5.h.f(bVar, "backEvent");
        OnBackPressedDispatcher onBackPressedDispatcher = this.f432g;
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
        return f5.g.f4141a;
    }
}
