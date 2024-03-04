package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class p implements c.b {

    /* renamed from: a */
    public final /* synthetic */ q f1736a;

    public p(q qVar) {
        this.f1736a = qVar;
    }

    @Override // c.b
    public final void a() {
        u<?> uVar = this.f1736a.f1739x.f1762a;
        uVar.f1767i.c(uVar, uVar, null);
        Bundle a7 = this.f1736a.f359j.f4376b.a("android:support:fragments");
        if (a7 != null) {
            Parcelable parcelable = a7.getParcelable("android:support:fragments");
            u<?> uVar2 = this.f1736a.f1739x.f1762a;
            if (!(uVar2 instanceof androidx.lifecycle.f0)) {
                throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
            }
            uVar2.f1767i.U(parcelable);
        }
    }
}
