package r3;

import android.os.Bundle;
import android.view.View;

/* loaded from: classes.dex */
public final class e extends p1.a {

    /* renamed from: d */
    public final /* synthetic */ com.google.android.material.bottomsheet.b f5903d;

    public e(com.google.android.material.bottomsheet.b bVar) {
        this.f5903d = bVar;
    }

    @Override // p1.a
    public final void d(View view, q1.f fVar) {
        boolean z6;
        this.f5466a.onInitializeAccessibilityNodeInfo(view, fVar.f5624a);
        if (this.f5903d.f2890o) {
            fVar.a(1048576);
            z6 = true;
        } else {
            z6 = false;
        }
        fVar.l(z6);
    }

    @Override // p1.a
    public final boolean g(View view, int i7, Bundle bundle) {
        if (i7 == 1048576) {
            com.google.android.material.bottomsheet.b bVar = this.f5903d;
            if (bVar.f2890o) {
                bVar.cancel();
                return true;
            }
        }
        return super.g(view, i7, bundle);
    }
}
