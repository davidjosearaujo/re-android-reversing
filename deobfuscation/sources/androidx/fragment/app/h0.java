package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

/* loaded from: classes.dex */
public final class h0 extends Transition.EpicenterCallback {

    /* renamed from: a */
    public final /* synthetic */ Rect f1652a;

    public h0(Rect rect) {
        this.f1652a = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public final Rect onGetEpicenter(Transition transition) {
        return this.f1652a;
    }
}
