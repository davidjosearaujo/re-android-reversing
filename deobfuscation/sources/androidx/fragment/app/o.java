package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.savedstate.a;

/* loaded from: classes.dex */
public final class o implements a.b {

    /* renamed from: a */
    public final /* synthetic */ q f1733a;

    public o(q qVar) {
        this.f1733a = qVar;
    }

    @Override // androidx.savedstate.a.b
    public final Bundle a() {
        Bundle bundle = new Bundle();
        do {
        } while (q.q(this.f1733a.f1739x.f1762a.f1767i));
        this.f1733a.f1740y.f(g.a.ON_STOP);
        z V = this.f1733a.f1739x.f1762a.f1767i.V();
        if (V != null) {
            bundle.putParcelable("android:support:fragments", V);
        }
        return bundle;
    }
}
