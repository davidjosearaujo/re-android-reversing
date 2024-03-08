package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.f0;
import c.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class p implements b {

    /* renamed from: a  reason: collision with root package name */
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
            if (uVar2 instanceof f0) {
                uVar2.f1767i.U(parcelable);
                return;
            }
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
    }
}
