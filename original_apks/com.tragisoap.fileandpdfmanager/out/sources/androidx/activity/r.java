package androidx.activity;

import f5.g;
import g5.h;
import java.util.ListIterator;
import q5.a;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class r extends i implements a<g> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f434g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(OnBackPressedDispatcher onBackPressedDispatcher) {
        super(0);
        this.f434g = onBackPressedDispatcher;
    }

    @Override // q5.a
    public final g d() {
        n nVar;
        OnBackPressedDispatcher onBackPressedDispatcher = this.f434g;
        if (onBackPressedDispatcher.f386d == null) {
            h<n> hVar = onBackPressedDispatcher.f385c;
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
        return g.f4141a;
    }
}
