package androidx.activity;

import f5.g;
import java.util.ListIterator;
import q5.l;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o extends i implements l<b, g> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f431g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(OnBackPressedDispatcher onBackPressedDispatcher) {
        super(1);
        this.f431g = onBackPressedDispatcher;
    }

    @Override // q5.l
    public final g k(b bVar) {
        n nVar;
        h.f(bVar, "backEvent");
        OnBackPressedDispatcher onBackPressedDispatcher = this.f431g;
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
        onBackPressedDispatcher.f386d = nVar;
        return g.f4141a;
    }
}
