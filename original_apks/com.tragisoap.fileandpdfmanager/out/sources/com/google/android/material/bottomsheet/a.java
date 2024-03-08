package com.google.android.material.bottomsheet;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.b;
import p1.p;
import p1.p0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements p {

    /* renamed from: a */
    public final /* synthetic */ b f2886a;

    public a(b bVar) {
        this.f2886a = bVar;
    }

    @Override // p1.p
    public final p0 a(View view, p0 p0Var) {
        b bVar = this.f2886a;
        b.C0031b bVar2 = bVar.f2893r;
        if (bVar2 != null) {
            bVar.f2887k.f2843b0.remove(bVar2);
        }
        b bVar3 = this.f2886a;
        bVar3.f2893r = new b.C0031b(bVar3.f2889n, p0Var);
        b bVar4 = this.f2886a;
        bVar4.f2893r.e(bVar4.getWindow());
        b bVar5 = this.f2886a;
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = bVar5.f2887k;
        b.C0031b bVar6 = bVar5.f2893r;
        if (!bottomSheetBehavior.f2843b0.contains(bVar6)) {
            bottomSheetBehavior.f2843b0.add(bVar6);
        }
        return p0Var;
    }
}
